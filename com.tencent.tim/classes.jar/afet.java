import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.1;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.2;
import com.tencent.mobileqq.earlydownload.xmldata.ChirpSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class afet
  extends afeu
{
  private LinkedList<afet.a> T = new LinkedList();
  private boolean bXL;
  private QQAppInterface mApp;
  
  public afet(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.system.chirp", paramQQAppInterface);
    this.mApp = paramQQAppInterface;
  }
  
  public void HL(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "restartDownload " + paramBoolean);
    }
    if (!this.bXL) {
      this.bXL = paramBoolean;
    }
    if ((b() != null) && (b().loadState == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChirpSoHandler", 2, "is in downloading");
      }
      return;
    }
    super.HL(paramBoolean);
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "onDownload success " + paramString);
    }
    paramString = new ChirpSoHandler.1(this, paramString);
    if (Looper.getMainLooper() == Looper.myLooper()) {
      ThreadManager.getSubThreadHandler().post(paramString);
    }
    for (;;)
    {
      BaseApplicationImpl.sUiHandler.post(new ChirpSoHandler.2(this));
      return;
      paramString.run();
    }
  }
  
  public void a(afet.a parama)
  {
    synchronized (this.T)
    {
      if (!this.T.contains(parama)) {
        this.T.add(parama);
      }
      return;
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public boolean aiW()
  {
    if (this.bXL)
    {
      this.mApp.cKW();
      if (QLog.isColorLevel()) {
        QLog.d("ChirpSoHandler", 2, "isNetValid2Download by user " + AppSetting.enableTalkBack);
      }
      return AppSetting.enableTalkBack;
    }
    this.mApp.cKW();
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "isNetValid2Download by startup " + AppSetting.enableTalkBack);
    }
    return (AppSetting.enableTalkBack) && (super.aiW());
  }
  
  public void b(afet.a parama)
  {
    synchronized (this.T)
    {
      this.T.remove(parama);
      return;
    }
  }
  
  public Class<? extends XmlData> g()
  {
    return ChirpSoData.class;
  }
  
  public int getBusinessId()
  {
    return 10040;
  }
  
  public String un()
  {
    return "actEarlyChirpSo";
  }
  
  public String uo()
  {
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void bwK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afet
 * JD-Core Version:    0.7.0.1
 */