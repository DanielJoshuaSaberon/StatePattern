# StatePattern
# State Pattern

## Problem Statement
A bank needs to manage different states of customer accounts, including active, suspended, and closed. Each state has specific rules and restrictions regarding allowed operations, and accounts have associated attributes like account number and balance.

### Account States:
- **Active accounts:** Allow deposits and withdrawals.
- **Suspended accounts:** Disallow deposits and withdrawal transactions but allow viewing account information.
- **Closed accounts:** Disallow all transactions and viewing of account information.

Currently, the system relies on conditional statements within the `Account` class to check the account state and determine valid actions. This approach becomes cumbersome and error-prone as the number of states and their associated logic grows.

## Solution: State Pattern
Implement the State pattern to improve code maintainability and flexibility.

### Steps to Implement:
1. **Define Account States:**
   - Create separate classes representing different account states: `ActiveState`, `SuspendedState`, and `ClosedState`.

2. **Implement State Interface:**
   - Define an interface `AccountState` with methods for common actions like `deposit()`, `withdraw()`, `activate()`, `suspend()`, and `close()`.

3. **Implement State Behaviors:**
   - Each concrete state class implements the `AccountState` interface, providing specific behavior for its respective state.
   - For example, the `ActiveState` class allows deposits and withdrawals, while the `ClosedState` class disallows any transactions.

4. **Update Account Class:**
   - Include attributes for `accountNumber` and `balance`.
   - Remove state-specific logic from the `Account` class.
   - Introduce a reference to the current `AccountState` object.
   - Delegate actions like `deposit()`, `withdraw()`, `activate()`, `suspend()`, and `close()` to the current state object through its corresponding methods.

## Business Logic Rules
- **If the account is active:**
  - You can either suspend or close it.
- **If the account is suspended:**
  - You can either activate or close it.
  - No deposits or withdrawals are allowed.
- **If the account is closed:**
  - You can neither suspend nor activate it.
  - No deposits or withdrawals are allowed.

## Composition of Account
### Attributes:
- `accountNumber: String`
- `balance: Double`
- `accountState: AccountState`

### Methods:
- Setter and getter methods
- `deposit(Double depositAmount): void`
- `withdraw(Double withdrawAmount): void`
- `suspend(): void`
- `activate(): void`
- `close(): void`
- `toString(): String` — Displays account number and balance

**Note:** No `if-else` or `switch` statements should be used.

## Testing the Implementation
Create a test class `AccountTest` to verify the behavior of the `Account` class.

### Example Code:
```java
public class AccountTest {
    public static void main(String[] args) {
        Account myAccount = new Account("1234", 10000.0); // Set account to active state

        myAccount.activate(); // Displays: "Account is already activated!"

        // Suspend the account
        myAccount.suspend(); // Displays: "Account is suspended!"

        // Activate the account
        myAccount.activate(); // Displays: "Account is activated!"

        // Deposit to the account
        myAccount.deposit(1000.0); // Updates balance and displays account number and current balance

        // Withdraw from the account
        myAccount.withdraw(100.0); // Updates balance and displays account number and current balance

        // Close the account
        myAccount.close(); // Displays: "Account is closed!"

        // Activate the account
        myAccount.activate(); // Displays: "You cannot activate a closed account!"

        // Suspend the account
        myAccount.suspend(); // Displays: "You cannot suspend a closed account!"

        // Withdraw from the account
        myAccount.withdraw(500.0); // Displays: "You cannot withdraw on a closed account!" with current balance

        // Deposit to the account
        myAccount.deposit(1000.0); // Displays: "You cannot deposit on a closed account!" with current balance
    }
}
```
