import React, { Component } from 'react';
import './signup.css';
import {PostData} from '../../services/postData';
import {Redirect} from 'react-router-dom';


class SignUp extends Component {

  
  constructor(props){
    super(props);
   
    this.state = {
     username: '',
     password: '',
     redirect: false
    };

    this.signup = this.signup.bind(this);
    this.onChange = this.onChange.bind(this);

  }
 
  
  signup()
  {
    if(this.state.username && this.state.password){
      PostData('signup',this.state).then((result) =>{
        let responseJSON = result
        if(responseJSON.status === "saved")
          {
            console.log("saved");
            this.setState({redirect:true});
          }
        else 
        {
          console.log("signup Error");
        }
      });
    }
   
  }
  onChange(e){
    this.setState({[e.target.name]:e.target.value});
    console.log(this.state);
  }
  


  render() {
    if(this.state.redirect){
      return(<Redirect to={'/'}/>)
    }
    return (
      <div className="row small-up-2 medium-up-3 large-up-4">
      <div className="column">
        <p>Signup Page</p>
        <label>Username</label>
        <input type="text" name="username" placeholder="username" onChange={this.onChange}/>
        <label>Password</label>
        <input type="password" name="password" placeholder="password" onChange={this.onChange}/>
        <input type="submit" className="button success" value="SignUp" onClick={this.signup}/>
      </div>
    </div>
    );
  }
}

export default SignUp;