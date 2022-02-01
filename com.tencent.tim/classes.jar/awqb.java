import android.text.TextUtils;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class awqb
{
  private final awqb.a a;
  private aoll jdField_c_of_type_Aoll;
  private final awpy jdField_c_of_type_Awpy;
  private awqd.c jdField_c_of_type_Awqd$c;
  private final String cSb;
  private String cSc;
  private volatile boolean drf;
  private volatile boolean mCanceled;
  private long mDbId;
  private String mFileVersion;
  private volatile boolean mIgnoreNetLimit;
  private final String mJobOwnerUid;
  private volatile boolean mPriority;
  
  private awqb(String paramString1, String paramString2, awpy paramawpy, awqb.a parama)
  {
    this.mJobOwnerUid = paramString1;
    this.cSb = paramString2;
    this.jdField_c_of_type_Awpy = paramawpy;
    this.a = parama;
  }
  
  public static aoll a(Object paramObject, String paramString1, String paramString2, String paramString3, aolm.a parama, aolm.b paramb)
  {
    return a(paramObject, paramString1, paramString2, paramString3, parama, paramb, null);
  }
  
  public static aoll a(Object paramObject, String paramString1, String paramString2, String paramString3, aolm.a parama, aolm.b paramb, String paramString4)
  {
    aoll localaoll = new aoll();
    localaoll.f = paramb;
    localaoll.bZ = paramString1;
    localaoll.mHttpMethod = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localaoll.u = new HashMap();
      localaoll.u.put("Cookie", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localaoll.mTempPath = paramString4;
    }
    localaoll.atY = paramString2;
    localaoll.dPo = 1;
    localaoll.bw(paramObject);
    localaoll.a = parama;
    return localaoll;
  }
  
  public static awqb a(String paramString1, awpy paramawpy, String paramString2, awqb.a parama)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramawpy == null) || (parama == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
    }
    return new awqb(paramString1, IOUtils.getDirPathNoSeparator(paramString2), paramawpy, parama);
  }
  
  public String Hm()
  {
    return this.cSb;
  }
  
  public String Hn()
  {
    return this.cSc;
  }
  
  public void Xo(boolean paramBoolean)
  {
    this.drf = paramBoolean;
  }
  
  public awqb.a a()
  {
    return this.a;
  }
  
  public awqd.c a()
  {
    return this.jdField_c_of_type_Awqd$c;
  }
  
  public void a(awqd.c paramc)
  {
    this.jdField_c_of_type_Awqd$c = paramc;
  }
  
  public boolean aNq()
  {
    return this.drf;
  }
  
  public void abZ(String paramString)
  {
    this.cSc = paramString;
  }
  
  public aoll b()
  {
    return this.jdField_c_of_type_Aoll;
  }
  
  public awpy b()
  {
    return this.jdField_c_of_type_Awpy;
  }
  
  public awqb.a b()
  {
    return this.a.c();
  }
  
  public void b(aoll paramaoll)
  {
    this.jdField_c_of_type_Aoll = paramaoll;
  }
  
  public long dbId()
  {
    return this.mDbId;
  }
  
  public String fileVersion()
  {
    return this.mFileVersion;
  }
  
  public boolean isCanceled()
  {
    return this.mCanceled;
  }
  
  public boolean isIgnoreNetLimit()
  {
    return this.mIgnoreNetLimit;
  }
  
  public boolean isPriority()
  {
    return this.mPriority;
  }
  
  public void setCanceled(boolean paramBoolean)
  {
    this.mCanceled = paramBoolean;
  }
  
  public void setDbId(long paramLong)
  {
    this.mDbId = paramLong;
  }
  
  public void setFileVersion(String paramString)
  {
    this.mFileVersion = paramString;
  }
  
  public void setIgnoreNetLimit(boolean paramBoolean)
  {
    this.mIgnoreNetLimit = paramBoolean;
  }
  
  public void setPriority(boolean paramBoolean)
  {
    this.mPriority = paramBoolean;
  }
  
  public String uid()
  {
    return this.mJobOwnerUid;
  }
  
  public static final class a
    implements Cloneable
  {
    public awqb a;
    public long currSize;
    public int errorCode;
    public String errorMsg = "";
    public String fileId = "";
    public String filePath = "";
    public String fileVersion = "";
    public volatile int state = 0;
    public long totalSize;
    
    public a c()
    {
      try
      {
        a locala = (a)super.clone();
        return locala;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return null;
    }
    
    public boolean canRestart()
    {
      return (this.state == 0) || (this.state == 5) || (this.state == 3) || ((this.state == 1) && ((this.errorCode == 1810003) || (this.errorCode == 1810004)));
    }
    
    public boolean canRunning()
    {
      return (this.state == 1) && (this.errorCode != 1810003) && (this.errorCode != 1810004);
    }
    
    public boolean canSuspend()
    {
      return (this.state == 0) || (this.state == 1) || (this.state == 2);
    }
    
    public boolean waitingNet()
    {
      return (this.state == 1) && ((this.errorCode == 1810003) || (this.errorCode == 1810004));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqb
 * JD-Core Version:    0.7.0.1
 */