// Use in 'index.html'
// <script src="./main.js"></script>

(async ( ) => {
    // Request to EatGo-API SpringBoot Application
    const url = 'http://localhost:8080/restaurants';
    const response = await fetch( url );
    const restaurantList = await response.json( );

    // Print JSON (Response Body)
    const elementApp = document.getElementById('app');
    elementApp.innerHTML = `
        ${restaurantList.map(restaurant =>
            `
                <p>
                    ${restaurant.restaurantId}
                    ${restaurant.restaurantName}
                    ${restaurant.restaurantAddress}
                </p>
            `
        ).join( '' )}
    `;
})( );
