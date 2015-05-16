public class TestLoan {
	public static void main(String[] args) {
		try {
			new Loan(2.5, 1, 1000);
			Loan l = new Loan(-1, 3, 3);			

		}catch (Exception ex) {
			System.out.println(ex);
		}		

		System.out.println("End of Program");
	}
}

class Loan {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;

	/** Default constructor */
	public Loan() {
		this(2.5, 1, 1000);
	}

	/** Construct a loan with specified annual interest rate,
		number of years and loan amount 
	*/
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {

		/** Determine annualInterestRate is smaller than 0 or equal 0 */
		if (annualInterestRate <= 0)
			throw new IllegalArgumentException("Annual interest rate must be positive.");

		/** Determine numberOfYears is smaller than 0 or equal 0 */
		if (numberOfYears <= 0)
			throw new IllegalArgumentException("Number of years must be positive.");

		/** Determine loanAmount is smaller than 0 or equal 0 */
		if (loanAmount <= 0)
			throw new IllegalArgumentException("Loan amount must be positive.");

		setAnnualInterestRate(annualInterestRate);
		setNumberOfYears(numberOfYears);
		setLoanAmount(loanAmount);
		loanDate = new java.util.Date();
	}

	/** Return annualInterestRate */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/** Set a new annualInterestRate */
	public void setAnnualInterestRate(double annualInterestRate) {

		/** Throw IllegalArgumentException */
		if (annualInterestRate <= 0) {
			throw new IllegalArgumentException("Annual interest rate must be positive.");
		}

		this.annualInterestRate = annualInterestRate;
	}

	/** Return numberOfYears */
	public int getNumberOfYears() {
		return numberOfYears;
	}

	/** Set a new numberOfYears */
	public void setNumberOfYears(int numberOfYears) {

		/** Throw IllegalArgumentException */
		if (numberOfYears <= 0) {
			throw new IllegalArgumentException("Number of years must be positive.");
		}

		this.numberOfYears = numberOfYears;
	}

	/** Return loanAmount */
	public double getLoanAmount() {
		return loanAmount;
	}

	/** Set a newloanAmount */
	public void setLoanAmount(double loanAmount) {

		/** Throw IllegalArgumentException */
		if (loanAmount <= 0) {
			throw new IllegalArgumentException("Loan amount must be positive.");
		}

		this.loanAmount = loanAmount;
	}

	/** Find monthly payment */
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
		return monthlyPayment;    
	}

	/** Find total payment */
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;    
	}

	/** Return loan date */
	public java.util.Date getLoanDate() {
		return loanDate;
	}
}
