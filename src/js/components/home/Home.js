import React, { Component } from 'react';
import './Home.css';
import { GetData } from '../../services/getData';
import { Redirect } from 'react-router-dom';
import {DeleteData} from '../../services/deleteData';

class Home extends Component {


  constructor(props) {
    super(props);
    this.state = {
      data: [],
      redirect: false,
      redirectItem: false
    }
    this.get = this.get.bind(this);
    this.logout = this.logout.bind(this);
  }

  get() {
  }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
    console.log(this.state);
  }

  componentWillMount() {
    if (sessionStorage.getItem("userData")) {
      var id = JSON.parse(sessionStorage.getItem("userData")).id;
      console.log(JSON.parse(sessionStorage.getItem("userData")));
      GetData('users/' + id + "/lists", this.state).then((result) => {
        let responseJSON = result
        this.setState({ data: responseJSON });
        console.log(responseJSON);
      });
    }
    else {
      this.setState({ redirect: true });
    }
  }

  logout() {
    sessionStorage.setItem("userData", '');
    sessionStorage.clear();
    this.setState({ redirect: true });
  }

  gotolist(listid) {
    sessionStorage.setItem("selectedList", listid);
    this.setState({ redirectItem: true });
  }

  deleteList(listid){
    var userid = JSON.parse(sessionStorage.getItem("userData")).id+1;
    DeleteData('users/' + userid + "/list/"+listid).then((result) => {
      console.log(result);
      window.location.reload();
    });
  
  }

  render() {

    if (this.state.redirect) {
      return (<Redirect to={'/'} />)
    }
    if (this.state.redirectItem) {
      return (<Redirect to={'/todo'} />)
    }


    return (
      <div className="row small-up-2 medium-up-3 large-up-4">
        <p>Home Page</p>
        <div className="column">
          { //key needs to be set or gives error 
            this.state.data.map(item => (
              <div className="callout secondary" key={item.id}>
                <callout>
                  <button type='button' className="button" onClick={() => this.gotolist(item.id)}>Go to {item.name}</button>
                  <button type='button' className="alert button" onClick={() => this.deleteList(item.id)}>Delete</button>
                </callout>
              </div>

            ))}

        </div>

        <div className="column">
          <a href="/createlist">Create List</a>
        </div>

        <div className="column">
          <button type='button' className="success button" onClick={this.logout}>Logout</button>
        </div>
      </div>
    );
  }
}

export default Home;
