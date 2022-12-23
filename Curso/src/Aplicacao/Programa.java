package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Modelos.Entidades.Reservas;
import Modelos.Excecoes.DomainException;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do Quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservas reserva = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		
			System.out.println();
			System.out.println("Entre com os dados da atualizacao da reserva:");
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizacaoDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.println("Formato de data invalida");
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}


		sc.close();
		
	}
	
}
