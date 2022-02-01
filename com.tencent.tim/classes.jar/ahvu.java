import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ahvu
{
  ahvu.a a;
  
  public ahvu(int paramInt)
  {
    this.a = new ahvu.a(paramInt);
  }
  
  public static String ep(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "graytip";
    case 2: 
      return "nor_text";
    case 3: 
      return "url";
    case 4: 
      return "qq";
    case 5: 
      return "img";
    case 6: 
      return "dialog";
    case 7: 
      return "title";
    case 8: 
      return "alter";
    case 9: 
      return "btn";
    }
    return "item";
  }
  
  public static String eq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "align";
    case 2: 
      return "text";
    case 3: 
      return "size";
    case 4: 
      return "jump";
    case 5: 
      return "color";
    case 6: 
      return "uin";
    case 7: 
      return "name";
    }
    return "src";
  }
  
  public ahvu.a a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return ahvu.a.a(this.a, 0);
  }
  
  public static class a
  {
    a b;
    HashMap<Integer, Object> lg;
    int noteType;
    ArrayList<a> xe;
    
    public a(int paramInt)
    {
      this.noteType = paramInt;
      this.lg = new HashMap();
      this.xe = new ArrayList();
    }
    
    private String er(int paramInt)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      int i = 0;
      while (i < paramInt)
      {
        localStringBuilder2.append("\t");
        i += 1;
      }
      localStringBuilder1.append(localStringBuilder2).append(ahvu.ep(this.noteType)).append(":[\n");
      localStringBuilder1.append(localStringBuilder2).append("\tfields").append(":[\n");
      Iterator localIterator = this.lg.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        String str = ahvu.eq(((Integer)localObject).intValue());
        localObject = this.lg.get(localObject);
        localStringBuilder1.append(localStringBuilder2).append("\t\t").append(str).append(":").append(localObject).append("\n");
      }
      localStringBuilder1.append(localStringBuilder2).append("\t]").append("\n");
      localIterator = this.xe.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder1.append(((a)localIterator.next()).er(paramInt + 1));
      }
      localStringBuilder1.append(localStringBuilder2).append("]").append("\n");
      return localStringBuilder1.toString();
    }
    
    public void C(int paramInt, Object paramObject)
    {
      this.lg.put(Integer.valueOf(paramInt), paramObject);
    }
    
    public int Fo()
    {
      return this.noteType;
    }
    
    public HashMap<Integer, Object> L()
    {
      return this.lg;
    }
    
    public a a(a parama)
    {
      this.b = parama;
      this.b.a(this);
      return this;
    }
    
    public void a(a parama)
    {
      this.xe.add(parama);
    }
    
    public boolean aoc()
    {
      return this.noteType == 2;
    }
    
    public a b()
    {
      return this.b;
    }
    
    public ArrayList<a> dh()
    {
      return this.xe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvu
 * JD-Core Version:    0.7.0.1
 */