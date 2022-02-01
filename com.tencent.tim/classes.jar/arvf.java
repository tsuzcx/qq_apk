import java.util.ArrayList;

public class arvf
{
  protected static arvf a;
  protected ArrayList<arxp> Dx;
  
  public static arvf a()
  {
    try
    {
      if (a == null)
      {
        a = new arvf();
        a.Dx = new ArrayList();
      }
      arvf localarvf = a;
      return localarvf;
    }
    finally {}
  }
  
  public void a(arxp paramarxp)
  {
    int j = a.Dx.size();
    int i = 0;
    while (i < j)
    {
      if ((arxp)a.Dx.get(i) == paramarxp) {
        return;
      }
      i += 1;
    }
    a.Dx.add(paramarxp);
  }
  
  public void b(arxp paramarxp)
  {
    int j = a.Dx.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((arxp)a.Dx.get(i) == paramarxp) {
          a.Dx.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public ArrayList<arxp> eg()
  {
    return a.Dx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvf
 * JD-Core Version:    0.7.0.1
 */