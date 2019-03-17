import React, { Component } from 'react';
import {PostData} from '../../services/postData';
import {Redirect} from 'react-router-dom';

class CreateList extends Component {

constructor(props){
  super(props);
  this.state={
    name:'',
    redirect:false
  }

  this.createList = this.createList.bind(this);
  this.onChange = this.onChange.bind(this);
}

createList()
{
  var id = JSON.parse(sessionStorage.getItem("userData")).id;
    PostData('users/'+id+'/list',this.state).then((result) =>{
      let responseJSON = result
      if(responseJSON.status === "saved")
        {
          console.log("created");
          this.setState({redirect:true});
        }
      else
      {
        console.log("Error");
      }
    });
  
}
onChange(e){
  this.setState({[e.target.name]:e.target.value});
  console.log(this.state);
}


  render() {

    if(this.state.redirect){
      return(<Redirect to={'/home'}/>)
    }

    return (
      <div className="row small-up-2 medium-up-3 large-up-4">
      <div className="column">
        <p>Create List</p>
        <label>Name</label>
        <input type="text" name="name" placeholder="name" onChange={this.onChange}/>
        <input type="submit" className="button success" value="Create" onClick={this.createList}/>
      </div>
    </div>
    );
  }
}

export default CreateList;