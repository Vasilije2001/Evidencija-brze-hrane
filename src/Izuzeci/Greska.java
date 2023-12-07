package Izuzeci;

public class Greska extends Exception
{
   private String dodatnaPoruka;

	public Greska(String poruka) 
	{
	    super(poruka);
	    dodatnaPoruka = "";
	}

	public Greska(String poruka, String dodatnaPoruka) 
	{
	    super(poruka);
	    this.dodatnaPoruka = dodatnaPoruka;
	}

	public String getdodatnaPoruka() 
	{
	    return dodatnaPoruka;
	}
}
