package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.Modelos.Reservas;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do Quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data do check-in (dd/mm/aaaa): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do check-out (dd/mm/aaaa): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data do check-out e anterior a data de check-in");
		} else {
			Reservas reserva = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		
			System.out.println();
			System.out.println("Entre com os dados da atualizacao da reserva:");
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: Os novos dados da reserve tem que ser dados futuros");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: Data do check-out e anterior a data de check-in");
			} else {
				reserva.atualizacaoDatas(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
		
		}
		sc.close();
		
	}
	
}
