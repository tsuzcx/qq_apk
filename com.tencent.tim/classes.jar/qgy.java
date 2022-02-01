import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract interface qgy
{
  public abstract qgy.a a(@Nullable qgy.c paramc, int paramInt);
  
  @UiThread
  public abstract void a(@Nullable qgy.c paramc, int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(qgy.e parame);
  
  @UiThread
  public abstract qgy.f b();
  
  public abstract void b(qgy.e parame);
  
  @UiThread
  public abstract void c(@Nullable qgy.c paramc, String paramString);
  
  public abstract void create();
  
  public abstract void destroy();
  
  public static class a
  {
    public boolean aDp;
    public boolean aDq;
    public boolean aDr;
    public ErrorMessage g;
    public ErrorMessage h;
    public List<qgy.d> nP = new ArrayList();
    
    public String toString()
    {
      return "Data{upErrorMessage=" + this.g + ", isUpEnd=" + this.aDp + ", mGroupInfoList=" + this.nP + ", isDownEnd=" + this.aDq + ", isFastData=" + this.aDr + ", downErrorMessage=" + this.h + '}';
    }
  }
  
  public static class b
    extends qgy.d
  {
    public ErrorMessage i;
    
    public b(qgy.c paramc, @Nullable ErrorMessage paramErrorMessage)
    {
      super();
      if (paramErrorMessage == null) {}
      for (this.i = new ErrorMessage(97000001, "loading");; this.i = paramErrorMessage)
      {
        this.nv = new ArrayList();
        return;
      }
    }
    
    public boolean JA()
    {
      return this.i.errorCode == 97000001;
    }
    
    public boolean Jy()
    {
      return this.i.errorCode == 97000000;
    }
    
    public boolean Jz()
    {
      return (!Jy()) && (!JA());
    }
    
    public String toString()
    {
      return "fg{g=" + this.d + ", em=" + this.i + '}';
    }
  }
  
  public static class c
  {
    public String debugInfo;
    public String groupId;
    
    public c(@NonNull String paramString)
    {
      this.groupId = paramString;
      rom.sF(paramString);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (c)paramObject;
        if (this.groupId != null) {
          return this.groupId.equals(paramObject.groupId);
        }
      } while (paramObject.groupId == null);
      return false;
    }
    
    public int hashCode()
    {
      if (this.groupId != null) {
        return this.groupId.hashCode();
      }
      return 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.debugInfo == null) {}
      for (String str = "";; str = this.debugInfo) {
        return str + this.groupId;
      }
    }
  }
  
  public static class d
    implements Cloneable
  {
    @Nullable
    public String axq;
    public int bmp = 0;
    public qgy.c d;
    public Map<String, String> fR = new HashMap();
    private boolean mIsEnd = true;
    public List<String> nv;
    
    public d(qgy.c paramc)
    {
      this.d = paramc;
      rom.checkNotNull(paramc);
      if ((paramc instanceof qhc.a))
      {
        paramc = ((qhc.a)paramc).g;
        if ((paramc != null) && (paramc.nodeType == 12)) {
          this.mIsEnd = false;
        }
      }
    }
    
    public boolean JA()
    {
      return false;
    }
    
    public boolean JB()
    {
      return this.nv != null;
    }
    
    public boolean Jz()
    {
      return false;
    }
    
    public d a()
    {
      d locald = new d(this.d);
      locald.fR.putAll(this.fR);
      if (this.nv != null) {
        locald.nv = new ArrayList(this.nv);
      }
      locald.axq = this.axq;
      return locald;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        paramObject = (d)paramObject;
        if (this.d != null) {
          return this.d.equals(paramObject.d);
        }
      } while (paramObject.d == null);
      return false;
    }
    
    public int hashCode()
    {
      if (this.d != null) {
        return this.d.hashCode();
      }
      return 0;
    }
    
    public boolean isEnd()
    {
      return this.mIsEnd;
    }
    
    public void rI(String paramString)
    {
      Iterator localIterator = this.nv.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.fR.put(str, paramString);
      }
    }
    
    public String toString()
    {
      if ("gi{g=" + this.d + ", fv=" + this.axq + ", vlist=" + this.nv != null) {
        return String.valueOf(this.nv.size());
      }
      return "}";
    }
  }
  
  public static abstract interface e
  {
    @UiThread
    public abstract void a(qgy.c paramc, String paramString, boolean paramBoolean);
    
    @UiThread
    public abstract void bok();
  }
  
  public static class f
  {
    @Nullable
    public qgy.d a;
    public qgy.c d;
    @Nullable
    public String feedId;
    @Nullable
    public String vid;
    
    public f(@Nullable qgy.c paramc, @Nullable String paramString1, @Nullable String paramString2)
    {
      this.d = paramc;
      this.vid = paramString1;
      this.feedId = paramString2;
    }
    
    public f(f paramf)
    {
      this.d = paramf.d;
      this.vid = paramf.vid;
      this.feedId = paramf.feedId;
      this.a = paramf.a;
    }
    
    public String toString()
    {
      return "StartInfo{mGroupId=" + this.d + ", vid='" + this.vid + '\'' + ", feedId='" + this.feedId + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgy
 * JD-Core Version:    0.7.0.1
 */