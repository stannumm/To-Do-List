import React, { Component } from 'react';
import './Header.css';


class Header extends Component {
  render() {
    return (
        <div className="callout primary" id="Header">
        <div className="row column">
          <h4>To-Do List</h4>
        </div>
      </div>
    );
  }
}

export default Header;