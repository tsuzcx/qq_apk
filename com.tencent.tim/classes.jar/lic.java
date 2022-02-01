import android.os.Handler;
import android.text.SpannableString;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.oidb_0xbfe.RspBody;

public class lic
  extends lir
{
  private lic.a a;
  private boolean akt = true;
  private boolean aku;
  private CharSequence r;
  
  public lic(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private void ai(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    paramToServiceMsg = new oidb_0xbfe.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.d("FreeNetFlowInfoModule", 2, new Object[] { "handle0xBe6FreeNetFlowInfo result = ", Integer.valueOf(i) });
    if (i == 0) {
      if (paramToServiceMsg.has())
      {
        if (this.a == null) {
          this.a = new lic.a();
        }
        if (paramToServiceMsg.uint32_receive_status.has()) {
          this.a.mStatus = paramToServiceMsg.uint32_receive_status.get();
        }
        if (paramToServiceMsg.bytes_jump_url.has()) {
          this.a.mJumpUrl = paramToServiceMsg.bytes_jump_url.get().toStringUtf8();
        }
        if (paramToServiceMsg.uint32_flag.has())
        {
          paramFromServiceMsg = this.a;
          if (paramToServiceMsg.uint32_flag.get() != 1) {
            break label223;
          }
          paramFromServiceMsg.isActive = bool;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FreeNetFlowInfoModule", 2, "free netflow, status: " + this.a.mStatus + ", jumpUrl: " + this.a.mJumpUrl + ", isActive: " + this.a.isActive);
        }
      }
    }
    label223:
    do
    {
      return;
      bool = false;
      break;
      this.akt = true;
    } while (!QLog.isColorLevel());
    QLog.d("FreeNetFlowInfoModule", 2, "get free netflow error, result code: " + paramFromServiceMsg.getResultCode());
  }
  
  public static CharSequence d()
  {
    int i = "".indexOf("领取1G流量");
    SpannableString localSpannableString = new SpannableString("");
    localSpannableString.setSpan(new lid(), i, i + 6, 33);
    return localSpannableString;
  }
  
  public static void no(String paramString)
  {
    int i;
    switch (aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext()))
    {
    default: 
      i = 2;
    }
    for (;;)
    {
      kbp.a(null, "", paramString, paramString, 0, 0, "" + i, kxm.getAccount(), "0", null, false);
      return;
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public boolean Cn()
  {
    return (!this.aku) && (this.a != null) && (this.a.Cp());
  }
  
  public boolean Co()
  {
    return this.akt;
  }
  
  public void aEL()
  {
    nB(false);
  }
  
  public CharSequence c()
  {
    if (this.r == null) {
      this.r = d();
    }
    return this.r;
  }
  
  public String jt()
  {
    Object localObject = null;
    if (this.a != null)
    {
      String str = this.a.mJumpUrl;
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.d("FreeNetFlowInfoModule", 2, "get url from freeNetFlow: " + str);
        localObject = str;
      }
    }
    return localObject;
  }
  
  public void nB(boolean paramBoolean)
  {
    this.aku = paramBoolean;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.akt = bool;
      if (QLog.isColorLevel()) {
        QLog.d("FreeNetFlowInfoModule", 2, "setShowingFreeNetFlow: " + paramBoolean);
      }
      if ((this.akt) && (this.a != null)) {
        this.a.clear();
      }
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbfe")) {
      ai(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public static class a
  {
    public boolean isActive;
    public String mJumpUrl;
    public int mStatus;
    
    public boolean Cp()
    {
      return (this.isActive) && (this.mStatus == 2);
    }
    
    public void clear()
    {
      this.mStatus = 0;
      this.mJumpUrl = null;
      this.isActive = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lic
 * JD-Core Version:    0.7.0.1
 */