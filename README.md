# E-Wallet Automation Test (Selenium Java)

## Tech Stack
- Java 17
- Selenium WebDriver
- TestNG
- Maven
- Parallel execution on Chrome & Firefox

## CI Integration
Currently, the project supports local execution only.
CI integration (GitHub Actions) can be easily added in future versions.

## Test Scenarios
1. **Login flow**
   - Valid login
   - Invalid username/password
   - Locked user scenario
   - Screenshot on failure
2. **Add to cart & checkout flow**
   - Add items
   - Complete checkout successfully

## How to Run  
mvn clean test
