import React, { useState } from 'react';
import './App.css';

import Modal from './Components/Modal';

function App() {
  const [isModalVisible, setIsModalVisible] = useState(false);

  const handleClick = () => {
    setIsModalVisible(true);
  }

  return (
    <div className="App">
      <button onClick={handleClick}>Open</button>
      {isModalVisible ? (
        <Modal onClose={() => setIsModalVisible(false)}>
          <h2>Modal</h2>
        </Modal>
      ) : null}
    </div>
  );
}

export default App;
