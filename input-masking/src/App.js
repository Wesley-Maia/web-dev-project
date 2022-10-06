import { useState } from 'react';
import InputMask from 'react-input-mask';

function PhoneInput(props) {
  return (
    <InputMask 
      mask='(99) 99999-9999' 
      value={props.value} 
      onChange={props.onChange}>
    </InputMask>
  );
}

function CNPJInput(props) {
  return (
    <InputMask 
      mask='99.999.999/0001-99' 
      value={props.value} 
      onChange={props.onChange}
      placeholder='Enter cnpj'>
    </InputMask>
  );
}

function App() {

  const [phone, setPhone] = useState('');
  const handleInput = ({ target: { value } }) => setPhone(value);

  const [cnpj, setCnpj] = useState('');
  const handleCnpj = ({ target: { value } }) => setCnpj(value);

  return (
    <div>
      <PhoneInput 
        value={phone} 
        onChange={handleInput}>
      </PhoneInput>
      <div style={{paddingTop: '12px'}}>Telefone: {phone}</div>

      <CNPJInput 
        value={cnpj} 
        onChange={handleCnpj}>
      </CNPJInput>
      <div style={{paddingTop: '12px'}}>CNPJ: {cnpj}</div>
    </div>
    
  );
}
export default App;