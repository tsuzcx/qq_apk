import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class pmm
  extends prz
{
  public long Ad;
  public pmm.b a = new pmm.b();
  public AtomicBoolean aC = new AtomicBoolean(false);
  public AtomicBoolean aD = new AtomicBoolean(false);
  protected INetEventHandler b = new pmm.a(null);
  public final Object bi = new Object();
  public final Object bj = new Object();
  
  private boolean It()
  {
    if (this.a.Iu()) {
      blV();
    }
    return this.a.isValidate();
  }
  
  private void blV()
  {
    if (this.aC.getAndSet(true))
    {
      ram.d("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    ram.b("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.a);
    pzq localpzq = new pzq();
    ppv.a().a(localpzq, new pmo(this));
  }
  
  public byte[] I()
  {
    if (It()) {
      return this.a.bA;
    }
    blV();
    ram.w("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.bi)
    {
      try
      {
        this.bi.wait(30000L);
        ram.w("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.a;
        if (((pmm.b)???).isValidate()) {
          return ((pmm.b)???).bA;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ram.w("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    ram.w("Q.qqstory.publish:VideoServerInfoManager", "return auth key with invalidate");
    return ((pmm.b)???).bA;
  }
  
  public void blU()
  {
    It();
  }
  
  public String mk()
  {
    byte[] arrayOfByte = I();
    if (arrayOfByte == null) {
      return null;
    }
    return aqhs.bytes2HexStr(arrayOfByte);
  }
  
  public String ml()
  {
    if (!this.a.Iu())
    {
      byte[] arrayOfByte = this.a.bA;
      if (arrayOfByte != null) {
        return aqhs.bytes2HexStr(arrayOfByte);
      }
    }
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AppNetConnInfo.unregisterNetEventHandler(this.b);
  }
  
  public void onInit()
  {
    super.onInit();
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().getApplication(), this.b);
    Bosses.get().postJob(new pmn(this, "Q.qqstory.publish:VideoServerInfoManager"));
  }
  
  class a
    implements INetEventHandler
  {
    private a() {}
    
    public void onNetChangeEvent(boolean paramBoolean)
    {
      ram.w("Q.qqstory.publish:VideoServerInfoManager", "network change");
      pmm.this.aD.set(true);
    }
  }
  
  public static class b
  {
    public String atM;
    public String atN;
    public String atO;
    public String atP;
    public String atQ;
    public byte[] bA = new byte[1];
    public long expireTime;
    
    public boolean Iu()
    {
      return this.expireTime <= NetConnInfoCenter.getServerTimeMillis() + 600000L;
    }
    
    public boolean isValidate()
    {
      if (this.expireTime > NetConnInfoCenter.getServerTimeMillis())
      {
        ram.d("Q.qqstory.publish:VideoServerInfoManager", "server inf validate %s", this);
        return true;
      }
      ram.w("Q.qqstory.publish:VideoServerInfoManager", "server inf invalidate %s", new Object[] { this });
      return false;
    }
    
    public void save()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("t", this.expireTime);
        localJSONObject.put("ak", aqhs.bytes2HexStr(this.bA));
        ((psr)psx.a(10)).n("SP_KEY_AUTHKEY_SERVER_INFO", localJSONObject.toString());
        ram.b("Q.qqstory.publish:VideoServerInfoManager", "save -> %s", localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    
    public String toString()
    {
      return "ServerInfo{, userIp='" + this.atM + '\'' + ", serverIp1='" + this.atN + '\'' + ", serverIp2='" + this.atO + '\'' + ", backupServerIp1='" + this.atP + '\'' + ", backupServerIp2='" + this.atQ + '\'' + ", expireTime=" + this.expireTime + "" + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmm
 * JD-Core Version:    0.7.0.1
 */