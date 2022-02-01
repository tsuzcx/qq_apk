import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class pkw
{
  private pkw.a a = new pkw.a();
  
  public pkw(HashMap<String, List<pkd.a>> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (localObject == null)
      {
        ram.w("Q.qqstory.recommendAlbum.logic.AlbumTree", "value is null key=%s", new Object[] { str });
      }
      else
      {
        localObject = (List)localObject;
        this.a.n(str, ((List)localObject).size());
      }
    }
  }
  
  public pkw.a a()
  {
    return this.a;
  }
  
  public String mh()
  {
    StringBuilder localStringBuilder = new StringBuilder("AlbumTree=[\n");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(this.a);
    while (localLinkedList.size() > 0)
    {
      int j = localLinkedList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (pkw.a)localLinkedList.poll();
        if (localObject != null)
        {
          localStringBuilder.append(" [").append(((pkw.a)localObject).toString()).append("];");
          localObject = ((pkw.a)localObject).ma.iterator();
          while (((Iterator)localObject).hasNext()) {
            localLinkedList.offer((pkw.a)((Iterator)localObject).next());
          }
        }
        i += 1;
      }
      localStringBuilder.append("\n");
    }
    localStringBuilder.append("\n]");
    ram.w("Q.qqstory.recommendAlbum.logic.AlbumTree", "traverse " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public pkw.b a;
    private boolean aAj;
    public List<a> ma = new ArrayList();
    
    public a()
    {
      this.a = new pkw.b();
      this.a.mLevel = 0;
      pkw.b.a(this.a, 0);
      this.a.mStr = null;
    }
    
    public a(String paramString, int paramInt1, int paramInt2)
    {
      String str = paramString.substring(0, paramInt1);
      this.a = new pkw.b();
      this.a.mStr = str;
      this.a.mLevel = paramInt1;
      pkw.b.a(this.a, paramInt2);
      if (paramInt1 < paramString.length())
      {
        paramString = new a(paramString, paramInt1 + 1, paramInt2);
        this.ma.add(paramString);
      }
    }
    
    public List<a> bG()
    {
      ArrayList localArrayList = new ArrayList();
      if (this.ma.size() == 0) {
        localArrayList.add(this);
      }
      for (;;)
      {
        return localArrayList;
        Iterator localIterator = this.ma.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (!locala.aAj) {
            if (locala.ma.size() == 0) {
              localArrayList.add(locala);
            } else {
              localArrayList.addAll(locala.bG());
            }
          }
        }
      }
    }
    
    public void blo()
    {
      this.aAj = true;
      Iterator localIterator = this.ma.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).blo();
      }
    }
    
    public int getPicCount()
    {
      int j;
      if (this.ma.size() == 0) {
        j = pkw.b.a(this.a);
      }
      Iterator localIterator;
      int i;
      do
      {
        return j;
        localIterator = this.ma.iterator();
        i = 0;
        j = i;
      } while (!localIterator.hasNext());
      a locala = (a)localIterator.next();
      if (!locala.aAj) {
        i = locala.getPicCount() + i;
      }
      for (;;)
      {
        break;
      }
    }
    
    public boolean n(String paramString, int paramInt)
    {
      if ((this.a.mLevel != 0) && ((paramString.length() <= this.a.mLevel) || (!TextUtils.equals(this.a.mStr, String.valueOf(paramString.substring(0, this.a.mLevel)))))) {
        return false;
      }
      Iterator localIterator = this.ma.iterator();
      while (localIterator.hasNext()) {
        if (((a)localIterator.next()).n(paramString, paramInt))
        {
          paramString = this.a;
          pkw.b.a(paramString, pkw.b.a(paramString) + paramInt);
          return true;
        }
      }
      paramString = new a(paramString, this.a.mLevel + 1, paramInt);
      this.ma.add(paramString);
      paramString = this.a;
      pkw.b.a(paramString, pkw.b.a(paramString) + paramInt);
      return true;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mNodeBean: ").append(this.a).append(" ");
      localStringBuilder.append("child count:").append(this.ma.size());
      return localStringBuilder.toString();
    }
  }
  
  public static class b
  {
    private int bjh;
    public int mLevel;
    public String mStr;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mStr: ").append(this.mStr).append(" ");
      localStringBuilder.append("mLevel: ").append(this.mLevel).append(" ");
      localStringBuilder.append("mPicCount: ").append(this.bjh).append(" ");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkw
 * JD-Core Version:    0.7.0.1
 */