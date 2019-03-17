import React, { Component } from 'react';
import './login.css';
import {PostData} from '../../services/postData';
import {Redirect} from 'react-router-dom';

class Login extends Component {

constructor(props){
  super(props);
  this.state={
    username:'',
    password:'',
    redirect:false
  }

  this.login = this.login.bind(this);
  this.onChange = this.onChange.bind(this);
}

login()
{
  if(this.state.username && this.state.password){
    PostData('users',this.state).then((result) =>{
      let responseJSON = result
      if(responseJSON)
        {
          console.log("logged");
         sessionStorage.setItem("userData",JSON.stringify(responseJSON));
          this.setState({redirect:true});
        }
      else
      {
        console.log("Login Error");
      }
    });
  }
 
}
onChange(e){
  this.setState({[e.target.name]:e.target.value});
  console.log(this.state);
}



  render() {

    if(sessionStorage.getItem("userData")){
      return(<Redirect to={'/home'}/>)
    }

    return (
      <div className="row small-up-2 medium-up-3 large-up-4">
      <div className="column">
        <p>Login Page</p>
        <label>Username</label>
        <input type="text" name="username" placeholder="username" onChange={this.onChange}/>
        <label>Password</label>
        <input type="password" name="password" placeholder="password" onChange={this.onChange}/>
        <input type="submit" className="button success" value="Login" onClick={this.login}/>
        <a href="/signup">Registration</a>
      </div>
    </div>
    );
  }
}

export default Login;