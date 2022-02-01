import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class adis
{
  protected static aolm.a b = new adiw();
  private aopo a;
  private ArrayList<adis.b> bS;
  private Object bm = new Object();
  private aolm c;
  private HashMap<String, adis.a> jv;
  public QQAppInterface mApp;
  
  public adis(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.c = this.mApp.getNetEngine(0);
    this.bS = new ArrayList();
    this.jv = new HashMap();
    this.a = ((aopo)this.mApp.getManager(193));
  }
  
  public boolean a(adis.b paramb, adis.a parama)
  {
    if ((paramb == null) || (parama == null)) {
      return false;
    }
    Object localObject1 = new adit(this, paramb);
    ??? = new adiu(this);
    aoll localaoll = new aoll();
    localaoll.f = ((aolm.b)???);
    localaoll.bZ = paramb.url;
    localaoll.mHttpMethod = 0;
    localaoll.atY = paramb.fileName;
    localaoll.dPo = 1;
    localaoll.a = b;
    paramb.e = localaoll;
    for (;;)
    {
      synchronized (this.bm)
      {
        this.bS.add(paramb);
        switch (aqiw.getSystemNetwork(BaseApplication.getContext()))
        {
        default: 
          i = 1;
          localObject1 = new adiv(this, this.mApp, paramb.md5, (aopn.a)localObject1, localaoll, paramb, parama);
          this.a.a(10065, "prd", paramb.md5, 0, paramb.url, localaoll.atY, i, 0, false, (aopm)localObject1);
          this.jv.put(paramb.md5, parama);
          QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + paramb.url);
          return true;
        }
      }
      int i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, adis.b paramb);
    
    public abstract void aj(long paramLong1, long paramLong2);
    
    public abstract void cQU();
    
    public abstract void cQV();
  }
  
  public static class b
  {
    public boolean bNI;
    public aoll e;
    public String fileName = "";
    public long fileSize;
    public String md5 = "";
    public String name;
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
 * Qualified Name:     adis
 * JD-Core Version:    0.7.0.1
 */