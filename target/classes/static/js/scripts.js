function createShow(showData) {
    return fetch('/api/shows', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(showData)
    })
        .then(response => response.json());
}


function getAllShows() {
    fetch('/api/shows')
        .then(response => response.json())
        .then(shows => {
            const showsContainer = document.getElementById('showsContainer');
            shows.forEach(show => {
                const showDiv = document.createElement('div');
                showDiv.className = 'show';
                showDiv.innerHTML = `
                    <h3>${show.title}</h3>
                    <p>${show.description}</p>
                    <button onclick="openBookingForm('${show.id}')">Book Tickets</button>
                `;
                showsContainer.appendChild(showDiv);
            });
        })
        .catch(error => console.error('Error fetching shows:', error));
}

// Call this function when the page loads
document.addEventListener('DOMContentLoaded', getAllShows);

function registerCustomerHandler() {
    // Collecting form data
    const name = document.querySelector('input[type="text"]').value;
    const email = document.querySelector('input[type="email"]').value;
    const passwords = document.querySelectorAll('input[type="password"]');

    // Validation before sending data
    if (!validateForm(name, email, passwords)) {
        return; // Stop the function if validation fails
    }

    // Preparing data for registration
    const customerData = { name, email, password: passwords[0].value };
    registerCustomer(customerData);
}

function validateForm(name, email, passwords) {
    // Check if name and email are not empty
    if (!name || !email) {
        alert("Name and email are required!");
        return false;
    }

    // Check if passwords match
    if (passwords[0].value !== passwords[1].value) {
        alert("Passwords do not match!");
        return false;
    }

    // Check if Terms of Service is checked
    const tosCheckbox = document.getElementById('agree-term');
    if (!tosCheckbox.checked) {
        alert("You must agree to the Terms of Service!");
        return false;
    }

    return true; // All validations passed
}

function updateShow(showId, showData) {
    return fetch(`/api/shows/${showId}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(showData)
    })
        .then(response => response.json());
}

function deleteShow(showId) {
    return fetch(`/api/shows/${showId}`, {
        method: 'DELETE'
    })
        .then(response => response.status);
}


function createReservation(reservationData) {
    return fetch('/api/reservations', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(reservationData)
    })
        .then(response => response.json());
}


function getReservation(reservationId) {
    return fetch(`/api/reservations/${reservationId}`)
        .then(response => response.json());
}


function updateReservation(reservationId, reservationData) {
    return fetch(`/api/reservations/${reservationId}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(reservationData)
    })
        .then(response => response.json());
}


function deleteReservation(reservationId) {
    return fetch(`/api/reservations/${reservationId}`, {
        method: 'DELETE'
    })
        .then(response => response.status);
}


function issueTicket(ticketData) {
    return fetch('/api/tickets', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(ticketData)
    })
        .then(response => response.json());
}

function handleBooking(showId) {
    // Step 1: Gather reservation data
    // Assuming CustomerID and other necessary data are available
    const reservationData = {
        showId: showId,
        customerId: CustomerID, // Ensure this is defined or retrieved from the context
        // Add other necessary data like seat number, date, etc.
    };

    // Step 2: Create a reservation
    createReservation(reservationData)
        .then(reservationResponse => {
            // Check if reservation was successful
            if (reservationResponse.success) {
                // Step 3: Gather ticket data
                const ticketData = {
                    reservationId: reservationResponse.id,
                    // Other ticket related data
                };

                // Step 4: Issue a ticket
                return issueTicket(ticketData);
            } else {
                // Handle reservation error
                console.error('Reservation failed:', reservationResponse.message);
                alert('Reservation failed: ' + reservationResponse.message); // User-friendly error message
                throw new Error('Reservation failed');
            }
        })
        .then(ticketResponse => {
            // Handle successful ticket issue
            console.log('Ticket issued successfully:', ticketResponse);
            alert('Ticket issued successfully!'); // Notify user of success
        })
        .catch(error => {
            // Handle errors
            console.error('Error in booking process:', error);
            alert('Error in booking process: ' + error.message); // User-friendly error message
        });
}

// Example AJAX request function for creating a reservation
//function createReservation(data) {
//     return fetch('/api/reservation', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(data)
//     })
//         .then(response => response.json());
// }

// Example AJAX request function for issuing a ticket
function issueTicket(data) {
    return fetch('/api/ticket', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json());
}


function getTicketDetails(ticketId) {
    return fetch(`/api/tickets/${ticketId}`)
        .then(response => response.json());
}


function submitFeedback(feedbackData) {
    return fetch('/api/feedback', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(feedbackData)
    })
        .then(response => response.json());
}


function getAllFeedback() {
    return fetch('/api/feedback')
        .then(response => response.json());
}


function updateFeedback(feedbackId, feedbackData) {
    return fetch(`/api/feedback/${feedbackId}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(feedbackData)
    })
        .then(response => response.json());
}


function createSale(saleData) {
    return fetch('/api/sales', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(saleData)
    })
        .then(response => response.json());
}

function getSaleDetails(saleId) {
    return fetch(`/api/sales/${saleId}`)
        .then(response => response.json());
}


function processSalePayment(saleId, paymentData) {
    return fetch(`/api/sales/${saleId}/payment`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(paymentData)
    })
        .then(response => response.json());
}


function getAllSales() {
    return fetch('/api/sales')
        .then(response => response.json());
}


function registerCustomer(customerData) {
    return fetch('/api/customers', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(customerData)
    })
        .then(response => {
            // Check if the request was successful
            if (!response.ok) {
                // If not successful, throw an error with the status
                throw new Error('Registration failed with status: ' + response.status);
            }
            return response.json();
        })
        .then(data => {
            // Handle the successful response here
            alert("Registration successful!");
            console.log("Registration data:", data);
            // Optionally, redirect the user or update the UI
        })
        .catch(error => {
            // Handle any errors here
            alert(error.message);
            console.error("Error during registration:", error);
        });
}



function getCustomerDetails(customerId) {
    return fetch(`/api/customers/${customerId}`)
        .then(response => response.json());
}


function updateCustomer(customerId, customerData) {
    return fetch(`/api/customers/${customerId}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(customerData)
    })
        .then(response => response.json());
}


function createDiscount(discountData) {
    return fetch('/api/discounts', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(discountData)
    })
        .then(response => response.json());
}


function applyDiscountToSale(saleId, discountCode) {
    return fetch(`/api/discounts/apply/${saleId}`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({ discountCode: discountCode })
    })
        .then(response => response.json());
}


function addPerformance(performanceData) {
    return fetch('/api/performances', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(performanceData)
    })
        .then(response => response.json());
}


function getPerformanceDetails(performanceId) {
    return fetch(`/api/performances/${performanceId}`)
        .then(response => response.json());
}

function updatePerformance(performanceId, performanceData) {
    return fetch(`/api/performances/${performanceId}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(performanceData)
    })
        .then(response => response.json());
}


function deletePerformance(performanceId) {
    return fetch(`/api/performances/${performanceId}`, {
        method: 'DELETE'
    })
        .then(response => response.status);
}


function getPerformancesForShow(showId) {
    return fetch(`/api/performances/show/${showId}`)
        .then(response => response.json());
}


function getUserDetails(userId) {
    return fetch(`/api/users/${userId}`)
        .then(response => response.json());
}


function getShowDetails(showId) {
    return fetch(`/api/shows/${showId}`)
        .then(response => response.json());
}
