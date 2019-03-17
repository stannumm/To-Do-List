import React, { Component } from 'react';
import {PostData} from '../../services/postData';
import {Redirect} from 'react-router-dom';

class CreateItem extends Component {

constructor(props){
  super(props);
  this.state={
    name:'',
    deadline:'',
    createDate:'',
    redirect:false
  }

  this.create = this.create.bind(this);
  this.onChange = this.onChange.bind(this);
}

create()
{
  var userid = JSON.parse(sessionStorage.getItem("userData")).id;
  var listid = JSON.parse(sessionStorage.getItem("selectedList"));
    PostData('users/'+userid+'/list/'+listid+'/item',this.state).then((result) =>{
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
      return(<Redirect to={'/todo'}/>)
    }

    return (
      <div className="row small-up-2 medium-up-3 large-up-4">
      <div className="column">
        <p>Create Item</p>
        <label>Name</label>
        <input type="text" name="name" placeholder="name" onChange={this.onChange}/>
        <label>Deadline</label>
        <input type="date" name="deadline" placeholder="deadline" onChange={this.onChange}/>
        <label>CreateDate</label>
        <input type="date" name="createDate" placeholder="createDate" onChange={this.onChange}/>
        <input type="submit" className="button success" value="Create" onClick={this.create}/>
      </div>
    </div>
    );
  }
}

export default CreateItem;