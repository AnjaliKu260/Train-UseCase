package TrainDemo;
import java.io.*;
import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;


public class TicketApplication {



	public static void main(String[] args) throws IOException, NullPointerException{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("======Welcome To Ticket Reservation=========");

		TrainDAO traindao=new TrainDAO();

		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter the train Number");
		Train train =traindao.findTrain(sc.nextInt());

		System.out.println("Enter TravelDate");
		String date=sc.next();



		LocalDate travelDate=LocalDate.parse(date,df);

		Ticket ticket=new Ticket(travelDate,train);
		ticket.setCounter(100);
		int count=ticket.getCounter();



		//  user input of Number of Passengers 
		System.out.println("Enter Number of Passengers");
		int numberOfPassengers=sc.nextInt();




		sc.nextLine();
		// user input for Passengers Details 
		for(int i=1;i<=numberOfPassengers;i++)
		{
			System.out.println("Enter Passenger Name");
			String name=sc.next();
			sc.nextLine();

			System.out.println("Enter Age");
			int age=sc.nextInt();
			sc.nextLine();

			System.out.println("Enter Gender(M/F)");
			String gender=sc.next();
			char g=gender.charAt(0);

			//adding the Passenger
			ticket.addPassenger(name, age, g);
			count++;



		}


		System.out.print("Ticket Booked with PNR:"+ticket.generatePNR());

		ticket.writeTicket();

		System.out.println();
		System.out.println("Ticket should be written to the file with filename :"+ ticket.generatePNR());     




	}

}