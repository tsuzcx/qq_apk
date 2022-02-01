import java.util.ArrayList;
import java.util.Iterator;

public class jiw
{
  boolean ZD = false;
  public int awS = -1;
  ArrayList<jiu> jb = new ArrayList();
  
  public void a(jiu paramjiu)
  {
    if (paramjiu == null) {
      return;
    }
    this.jb.add(paramjiu);
  }
  
  public ArrayList<jiu> aU()
  {
    return this.jb;
  }
  
  public ArrayList<jiu> aV()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jb.size())
    {
      if (((jiu)this.jb.get(i)).isVisiable()) {
        localArrayList.add(this.jb.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public jiu b(int paramInt)
  {
    Iterator localIterator = this.jb.iterator();
    while (localIterator.hasNext())
    {
      jiu localjiu = (jiu)localIterator.next();
      if (localjiu.getId() == paramInt) {
        return localjiu;
      }
    }
    return null;
  }
  
  public void b(jiu paramjiu)
  {
    if (paramjiu == null) {
      return;
    }
    this.jb.remove(paramjiu);
  }
  
  public void kV(boolean paramBoolean)
  {
    this.ZD = paramBoolean;
  }
  
  public int mD()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jb.size(); j = k)
    {
      k = j;
      if (((jiu)this.jb.get(i)).isVisiable()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void nE(int paramInt)
  {
    b(b(paramInt));
  }
  
  public boolean xz()
  {
    return this.ZD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jiw
 * JD-Core Version:    0.7.0.1
 */