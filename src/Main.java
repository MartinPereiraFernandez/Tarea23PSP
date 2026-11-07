import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);{
            try{
                InetAddress local = InetAddress.getLocalHost();
                System.out.println("Equipo: "+local.getHostName());
                System.out.println("IP: "+local.getHostAddress());
            } catch (Exception e){
                System.out.println("Error con la direccion: "+e.getMessage());
            }
            System.out.print("Dominio: ");
            String dominio = sc.nextLine().trim();
            if(!dominio.equalsIgnoreCase("salir")){
                try{
                    InetAddress[] ips = InetAddress.getAllByName(dominio);
                    for (InetAddress ip:ips){
                        if( ip instanceof Inet4Address){
                            System.out.println("IPv4: "+ip.getHostAddress());
                        } else if (ip instanceof Inet6Address){
                            System.out.println("IPv6: "+ip.getHostAddress());
                        }
                    }

                } catch (UnknownHostException e) {
                    System.out.println("El dominio "+dominio+" no existe...");
                }
                System.out.print("Dominio: ");
                dominio = sc.nextLine().trim();
            }
        }
    }
}
