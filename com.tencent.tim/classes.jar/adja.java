import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adja
{
  protected static aolm.a b = new adjc();
  private ArrayList<adja.b> bS;
  private Object bm = new Object();
  private aolm c;
  public AppInterface mApp;
  
  public adja(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    this.c = this.mApp.getNetEngine(0);
    this.bS = new ArrayList();
  }
  
  public boolean a(adja.b paramb, adja.a arg2)
  {
    if ((paramb == null) || (??? == null)) {
      return false;
    }
    ??? = new adjb(this, paramb, ???);
    aoll localaoll = new aoll();
    localaoll.f = ???;
    localaoll.bZ = paramb.url;
    localaoll.mHttpMethod = 0;
    localaoll.atY = paramb.fileName;
    localaoll.dPo = 1;
    localaoll.a = b;
    this.c.a(localaoll);
    paramb.e = localaoll;
    synchronized (this.bm)
    {
      this.bS.add(paramb);
      QLog.i("AREngine_ARResourceDownload", 1, "submitDownloadTask. url = " + paramb.url);
      return true;
    }
  }
  
  public void cSb()
  {
    Object localObject1 = this.bm;
    int i = 0;
    try
    {
      while (i < this.bS.size())
      {
        QLog.i("AREngine_ARResourceDownload", 1, "cancelDownloadTask. url = " + ((adja.b)this.bS.get(i)).url);
        this.c.b(((adja.b)this.bS.get(i)).e);
        i += 1;
      }
      this.bS.clear();
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    cSb();
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, adja.b paramb);
    
    public abstract void aj(long paramLong1, long paramLong2);
  }
  
  public static class b
  {
    public boolean bNI;
    public aoll e;
    public String fileName = "";
    public long fileSize;
    public String md5 = "";
    public int type;
    public String url = "";
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("DownloadInfo{");
      localStringBuffer.append("type=").append(this.type);
      localStringBuffer.append(", url='").append(this.url).append('\'');
      localStringBuffer.append(", md5='").append(this.md5).append('\'');
      localStringBuffer.append(", fileName='").append(this.fileName).append('\'');
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adja
 * JD-Core Version:    0.7.0.1
 */