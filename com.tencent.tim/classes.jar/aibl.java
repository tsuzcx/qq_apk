import android.os.Handler;
import android.os.Looper;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.inputstatus.InputStatusHelper.2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime.Status;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.InputNotifyRsp;

public class aibl
  implements wvs
{
  private static final String TAG = aibl.class.getSimpleName();
  private aibo a;
  private aibn b;
  private String bMB = "";
  private BaseChatPie c;
  private boolean cjL = true;
  private boolean cjM;
  private boolean cjN;
  private boolean cjO;
  private int dcV;
  private Runnable gG = new InputStatusHelper.2(this);
  public long interval = 5000L;
  private Handler mHandler;
  public long timeStamp;
  private TextWatcher w = new aibm(this);
  
  public aibl(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
  }
  
  private void PL(int paramInt)
  {
    if ((aoM()) && (aoN()) && (aoJ())) {}
    try
    {
      this.dcV = paramInt;
      long l = Long.parseLong(this.c.sessionInfo.aTl);
      aibk localaibk = (aibk)this.c.app.getBusinessHandler(150);
      if (localaibk != null) {
        localaibk.ai(paramInt, l);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, localException, new Object[0]);
    }
  }
  
  private aibo a()
  {
    if (this.a == null)
    {
      Manager localManager = this.c.app.getManager(316);
      if ((localManager instanceof aibo)) {
        this.a = ((aibo)localManager);
      }
    }
    return this.a;
  }
  
  private boolean ahh()
  {
    try
    {
      aibj.a locala = (aibj.a)aeif.a().o(445);
      if (locala != null)
      {
        boolean bool = locala.cjJ;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, localException, new Object[0]);
    }
    return false;
  }
  
  private boolean aoJ()
  {
    if ((this.c != null) && ((this.c instanceof ybb))) {
      return aoK();
    }
    return ahh();
  }
  
  private boolean aoK()
  {
    try
    {
      aibj.a locala = (aibj.a)aeif.a().o(445);
      if (locala != null)
      {
        boolean bool = locala.cjK;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, localException, new Object[0]);
    }
    return true;
  }
  
  private boolean aoL()
  {
    AppRuntime.Status localStatus = this.c.app.getOnlineStatus();
    return (localStatus != AppRuntime.Status.away) && (localStatus != AppRuntime.Status.busy) && (localStatus != AppRuntime.Status.dnd) && (localStatus != AppRuntime.Status.invisiable);
  }
  
  private boolean aoM()
  {
    if ((this.c != null) && ((this.c instanceof ybb))) {
      return true;
    }
    return aoL();
  }
  
  private boolean aoN()
  {
    if ((this.c != null) && ((this.c instanceof ybb))) {
      return true;
    }
    return this.cjL;
  }
  
  private void drP()
  {
    if ((this.c != null) && (aoN()) && (aoJ())) {}
    try
    {
      long l = Long.parseLong(this.c.sessionInfo.aTl);
      aibk localaibk = (aibk)this.c.app.getBusinessHandler(150);
      if (localaibk != null) {
        localaibk.ai(2, l);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, localException, new Object[0]);
    }
  }
  
  private Handler getHandler()
  {
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper());
    }
    return this.mHandler;
  }
  
  public int[] C()
  {
    return new int[] { 7, 13 };
  }
  
  public void Ck(int paramInt)
  {
    this.cjM = false;
    this.dcV = 0;
    drS();
    switch (paramInt)
    {
    default: 
    case 7: 
      do
      {
        do
        {
          return;
        } while ((this.c == null) || (!aoJ()));
        if (this.b == null) {
          this.b = new aibl.a(this, null);
        }
        this.c.app.addObserver(this.b);
        this.cjL = this.c.app.aS(true);
      } while (!aoN());
      if (a() != null) {
        a().y(this.c);
      }
      this.c.a.addTextChangedListener(this.w);
      return;
    }
    if (a() != null) {
      a().onDestroy();
    }
    if (this.c != null)
    {
      if (this.c.a != null) {
        this.c.a.removeTextChangedListener(this.w);
      }
      this.c.app.removeObserver(this.b);
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacks(this.gG);
      this.mHandler = null;
    }
    drP();
  }
  
  public void aD(boolean paramBoolean, String paramString)
  {
    BaseChatPie localBaseChatPie = this.c;
    this.cjM = paramBoolean;
    if (paramBoolean) {}
    for (;;)
    {
      localBaseChatPie.R(paramBoolean, paramString);
      return;
      paramString = this.bMB;
    }
  }
  
  public void aqG()
  {
    if (!this.cjO)
    {
      this.cjO = true;
      if ((aoN()) && (aoJ())) {
        getHandler().postDelayed(this.gG, 1000L);
      }
    }
  }
  
  public void drQ()
  {
    this.cjM = false;
    this.c.R(this.cjM, this.bMB);
    if (a() != null) {
      a().drT();
    }
  }
  
  public void drR()
  {
    getHandler().removeCallbacks(this.gG);
    if ((aoN()) && (aoJ())) {}
    try
    {
      long l = Long.parseLong(this.c.sessionInfo.aTl);
      aibk localaibk = (aibk)this.c.app.getBusinessHandler(150);
      if (localaibk != null) {
        localaibk.ai(2, l);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, localException, new Object[0]);
    }
  }
  
  public void drS()
  {
    this.cjO = false;
    this.cjN = false;
  }
  
  public void vc(String paramString)
  {
    this.bMB = paramString;
    if (!this.cjM) {
      this.c.R(this.cjM, this.bMB);
    }
  }
  
  static final class a
    extends aibn
  {
    private WeakReference<aibl> hg;
    
    private a(aibl paramaibl)
    {
      this.hg = new WeakReference(paramaibl);
    }
    
    protected void aS(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (this.hg.get() != null))
      {
        if ((!aibl.a((aibl)this.hg.get())) && (paramBoolean2))
        {
          if (aibl.a((aibl)this.hg.get()) != null) {
            aibl.a((aibl)this.hg.get()).y(aibl.a((aibl)this.hg.get()));
          }
          aibl.a((aibl)this.hg.get()).a.addTextChangedListener(aibl.a((aibl)this.hg.get()));
        }
        aibl.a((aibl)this.hg.get(), paramBoolean2);
      }
    }
    
    protected void bp(boolean paramBoolean, Object paramObject)
    {
      if (((paramObject instanceof cmd0xcd4.InputNotifyRsp)) && (paramBoolean))
      {
        paramObject = (cmd0xcd4.InputNotifyRsp)paramObject;
        int i = paramObject.sint32_result.get();
        int j = paramObject.uint32_interval.get();
        paramObject = paramObject.bytes_err_msg.get().toStringUtf8();
        if (i != 0) {
          break label84;
        }
        if ((j > 0) && (this.hg.get() != null)) {
          ((aibl)this.hg.get()).interval = (j * 1000);
        }
      }
      return;
      label84:
      QLog.d(aibl.TAG, 1, "send input status fail : " + paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibl
 * JD-Core Version:    0.7.0.1
 */