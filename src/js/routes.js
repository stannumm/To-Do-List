import React from 'react';
import {BrowserRouter,  Route,  Switch} from 'react-router-dom';

import Login from '././components/login/login';
import Signup from '././components/signup/signup';
import Home from '././components/home/Home';
import CreateItem from '././components/createitem/createitem'
import CreateList from '././components/createlist/createlist'
import Todoitem from '././components/todoitem/todoitem'


const Routes = () => (
  <BrowserRouter >
      <Switch>
          <Route exact path="/" component={Login}/>
          <Route path="/signup" component={Signup}/>
          <Route path="/home" component={Home}/>
          <Route path="/createitem" component={CreateItem}/>
          <Route path="/createlist" component={CreateList}/>
          <Route path="/todo" component ={Todoitem}/>

      </Switch>
  </BrowserRouter>
);

export default Routes;