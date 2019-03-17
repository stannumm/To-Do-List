import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import MaterialTable from 'material-table'
import { GetData } from '../../services/getData';
import {DeleteData} from '../../services/deleteData';

class Todoitem extends Component {


  constructor(props) {
    super(props);
    this.state = {
      data: [],
      redirect: false,
      redirectItem: false
    }
  }

  componentWillMount() {
    if (sessionStorage.getItem("userData") && sessionStorage.getItem("selectedList")) {
      var userid = JSON.parse(sessionStorage.getItem("userData")).id;
      var listid = JSON.parse(sessionStorage.getItem("selectedList"));
      GetData('users/' + userid + "/list/" + listid + "/items", this.state).then((result) => {
        let responseJSON = result;
        this.setState({ data: responseJSON });

      });
    }
    else {
      this.setState({ redirect: true });
    }
  }


  deleteItem(itemid){
  var userid = JSON.parse(sessionStorage.getItem("userData")).id +1;
  var listid = JSON.parse(sessionStorage.getItem("selectedList"));
  DeleteData('users/' + userid + "/list/" + listid + "/item/"+itemid).then((result) => {
    console.log(result);
    window.location.reload();
  });

  }

  render() {
    return (
      <div className="row small-up-2 medium-up-3 large-up-4">
        <a href="/home">Go Home</a>

        <div className="column">
          <a href="/createitem">Create Item</a>
        </div>
        <MaterialTable
          columns={[
            { title: 'Name', field: 'name' },
            { title: 'Deadline', field: 'deadline' },
            { title: 'CreateDate', field: 'createDate' }
          ]}
          data={this.state.data}
          title="TodoItems"
          actions={[
            {
              icon: 'X',
              tooltip: 'Delete TodoItem',
              onClick: (event, rowData) => {
                this.deleteItem(rowData.id);
              },
            },
          ]}
          options={{
            paging: false,
            actionsColumnIndex: -1
            
          }}
       
        />
        </div>
    );
  }
}

export default Todoitem;
