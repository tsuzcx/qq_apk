import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class alas
{
  public final String mContent;
  public final ArrayList<alas.a> mData;
  
  public alas(String paramString)
  {
    this.mContent = paramString;
    this.mData = new ArrayList(1);
  }
  
  public static boolean a(alas.a parama)
  {
    return (parama != null) && (!TextUtils.isEmpty(parama.title)) && (!TextUtils.isEmpty(parama.content));
  }
  
  public void e(aqoa paramaqoa)
  {
    if (paramaqoa == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mData.iterator();
      while (localIterator.hasNext())
      {
        alas.a locala = (alas.a)localIterator.next();
        if (a(locala)) {
          paramaqoa.Z(2131365509, locala.title, 0);
        }
      }
    }
  }
  
  public void gU(String paramString1, String paramString2)
  {
    this.mData.add(new alas.a(paramString1, paramString2, null));
  }
  
  public String mJ(String paramString)
  {
    Iterator localIterator = this.mData.iterator();
    while (localIterator.hasNext())
    {
      alas.a locala = (alas.a)localIterator.next();
      if ((a(locala)) && (paramString != null) && (paramString.equals(locala.title))) {
        return locala.content;
      }
    }
    return null;
  }
  
  public static class a
  {
    public final String content;
    public final String title;
    
    private a(String paramString1, String paramString2)
    {
      this.title = paramString1;
      this.content = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alas
 * JD-Core Version:    0.7.0.1
 */