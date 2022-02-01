import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class anoc
{
  List<Object> GD = new ArrayList();
  anoc.a a = new anoc.a(this.dKr, '&');
  int dKr = 0;
  
  public anoc()
  {
    this.dKr += 1;
  }
  
  public void QR(String paramString)
  {
    Object localObject = this.a;
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      anoc.a locala = ((anoc.a)localObject).a(c);
      if (locala == null)
      {
        locala = new anoc.a(this.dKr, c);
        this.dKr += 1;
        ((anoc.a)localObject).a(locala);
      }
      for (localObject = locala;; localObject = locala)
      {
        i += 1;
        break;
        locala.dSC();
      }
    }
  }
  
  public static class a
  {
    public int ash;
    public int dKs;
    public char g;
    public List<a> ma = new ArrayList();
    
    public a(int paramInt, char paramChar)
    {
      this.dKs = paramInt;
      this.g = paramChar;
      this.ash = 1;
    }
    
    public a a(char paramChar)
    {
      Iterator localIterator = this.ma.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.g == paramChar) {
          return locala;
        }
      }
      return null;
    }
    
    public void a(a parama)
    {
      this.ma.add(parama);
    }
    
    public void dSC()
    {
      this.ash += 1;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id: ").append(this.dKs).append(" ");
      localStringBuilder.append("char: ").append(this.g).append(" ");
      localStringBuilder.append("cnt: ").append(this.ash);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anoc
 * JD-Core Version:    0.7.0.1
 */