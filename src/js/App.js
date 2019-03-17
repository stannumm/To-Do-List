import React, { Component } from 'react';
import Header from './components/header/Header';

import './styles/foundation.min.css';
import Routes from './routes';


class App extends Component {

  constructor(props){
    super(props);
    this.state ={
      items:[],
      isLoaded:false,
    }
  }

  render() {
    return (
      <div className="off-canvas-wrapper">
      <div className="off-canvas-wrapper-inner" data-off-canvas-wrapper>
        <div className="off-canvas-content" data-off-canvas-content>
          <Header/>
          <Routes/>
          <hr/>
        </div>
      </div>
    </div>
    );
  }
}

export default App;
