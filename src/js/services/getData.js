export function GetData(type) {
    let BaseURL = 'http://localhost:8080/';

    return new Promise((resolve, reject) =>{
    
         
        fetch(BaseURL+type, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                },
          })
          .then((response) => response.json())
          .then((res) => {
            resolve(res);
          })
          .catch((error) => {
            reject(error);
          });

  
      });
}