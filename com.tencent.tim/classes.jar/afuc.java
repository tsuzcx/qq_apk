import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afuc
{
  public List<afuc.a> Ay;
  public int cUt;
  public boolean caM;
  public boolean caN;
  
  private int cacheCount()
  {
    if (this.Ay != null)
    {
      Iterator localIterator = this.Ay.iterator();
      for (int i = 0;; i = ((afuc.a)localIterator.next()).mList.size() + i)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
      }
    }
    int j = 0;
    return j;
  }
  
  private void dcc()
  {
    if (this.Ay != null)
    {
      long l = System.currentTimeMillis();
      int i = this.Ay.size() - 1;
      while (i >= 0)
      {
        if (Math.abs(l - ((afuc.a)this.Ay.get(i)).mUpdateTime) > 60000L) {
          this.Ay.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  public afuc.a a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.Ay != null)
    {
      localObject1 = localObject2;
      if (this.Ay.size() > 0) {
        localObject1 = (afuc.a)this.Ay.get(0);
      }
    }
    return localObject1;
  }
  
  public afuc.a a(String paramString)
  {
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (this.Ay != null))
    {
      i = 0;
      if (i < this.Ay.size()) {
        if (paramString.equals(((afuc.a)this.Ay.get(i)).mSearchKey))
        {
          paramString = (afuc.a)this.Ay.get(i);
          this.Ay.remove(i);
        }
      }
    }
    for (;;)
    {
      if (paramString != null) {
        this.Ay.add(0, paramString);
      }
      return paramString;
      i += 1;
      break;
      paramString = null;
    }
  }
  
  public void a(afuc.a parama, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.caM = paramBoolean1;
    this.caN = paramBoolean2;
    this.cUt = paramInt;
    dcc();
    if (this.Ay == null) {
      this.Ay = new ArrayList();
    }
    if (this.Ay.contains(parama)) {
      this.Ay.remove(parama);
    }
    if ((parama == null) || (parama.mList.size() == 0)) {}
    for (;;)
    {
      return;
      this.Ay.add(0, parama);
      while ((cacheCount() > 500) && (this.Ay.size() > 1)) {
        this.Ay.remove(this.Ay.size() - 1);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("mProfileComplete").append("=").append(this.caM);
    localStringBuilder.append(" ").append("mProfileComplete").append("=").append(this.caM);
    localStringBuilder.append(" ").append("mShowCard").append("=").append(this.caN);
    localStringBuilder.append(" ").append("mMaxLikeCount").append("=").append(this.cUt);
    localStringBuilder.append(" ").append("mTags").append("=").append(" [");
    if (this.Ay != null)
    {
      int i = 0;
      while (i < this.Ay.size())
      {
        afuc.a locala = (afuc.a)this.Ay.get(i);
        localStringBuilder.append("\n");
        localStringBuilder.append("index_").append(i).append("=").append(locala.toString());
        i += 1;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public int cUu;
    public boolean caO;
    public byte[] dF;
    public int mCurPos;
    public List<afua> mList = new ArrayList();
    public int mOffset;
    public String mSearchKey;
    public long mUpdateTime;
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          bool1 = bool2;
          if (paramObject.mSearchKey != null)
          {
            bool1 = bool2;
            if (this.mSearchKey.equals(paramObject.mSearchKey)) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mUpdateTime").append("=").append(this.mUpdateTime);
      localStringBuilder.append(" ").append("mUpdateTime").append("=").append(this.mUpdateTime);
      localStringBuilder.append(" ").append("mSearchKey").append("=").append(this.mSearchKey);
      localStringBuilder.append(" ").append("mLoadOver").append("=").append(this.caO);
      localStringBuilder.append(" ").append("mCurPos").append("=").append(this.mCurPos);
      localStringBuilder.append(" ").append("mOffset").append("=").append(this.mOffset);
      localStringBuilder.append(" ").append("size").append("=").append(this.mList.size());
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afuc
 * JD-Core Version:    0.7.0.1
 */