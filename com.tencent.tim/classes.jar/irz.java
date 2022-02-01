import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.redpacket.config.AVRedPacketConfigManager.1;
import com.tencent.av.redpacket.config.AVRedPacketConfigManager.2;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class irz
  implements aduq.b, Handler.Callback, Manager
{
  public String Qp;
  public volatile boolean UD;
  public volatile boolean UE;
  public volatile boolean UF;
  public aduq a;
  public AVRedPacketConfig a;
  public QQAppInterface a;
  public itw a;
  public itw b;
  private MqqHandler e;
  public Object lock = new Object();
  private HandlerThread m;
  private Handler mHandler;
  public String resPath;
  
  public irz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Aduq = ((aduq)paramQQAppInterface.getManager(191));
    this.jdField_a_of_type_Aduq.a(this);
  }
  
  public AVRedPacketConfig a()
  {
    return a(true);
  }
  
  public AVRedPacketConfig a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null) && (paramBoolean))
    {
      loadConfigFromFile();
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig:" + this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig);
      }
    }
    return this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig;
  }
  
  MqqHandler a()
  {
    try
    {
      if (this.m == null)
      {
        this.m = ThreadManager.newFreeHandlerThread("QAV_RedPacketResDownload", 0);
        this.m.start();
        QLog.w("AVRedPacketConfigManger", 1, "getDownloadHandle, 创建mDownloadHandleThread");
      }
      if (this.e == null)
      {
        this.e = new MqqHandler(this.m.getLooper());
        QLog.w("AVRedPacketConfigManger", 1, "getDownloadHandle, 创建mDownloadHandle");
      }
      MqqHandler localMqqHandler = this.e;
      return localMqqHandler;
    }
    finally {}
  }
  
  public void a(AVRedPacketConfig paramAVRedPacketConfig, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "onGetConfig ,isNewConfig = " + paramBoolean + ",config = " + paramAVRedPacketConfig);
    }
    synchronized (this.lock)
    {
      this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig = paramAVRedPacketConfig;
      itw localitw = this.jdField_a_of_type_Itw;
      if (localitw != null) {}
      try
      {
        this.jdField_a_of_type_Itw.a(true, paramAVRedPacketConfig);
        this.UD = false;
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig != null)) {
          this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.saveToFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketConfigManger", 2, "onGetConfig finish, isGettingConfig =" + this.UD);
        }
        return;
      }
      catch (RemoteException paramAVRedPacketConfig)
      {
        for (;;)
        {
          paramAVRedPacketConfig.printStackTrace();
        }
      }
    }
  }
  
  public void a(itw paramitw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "downloadRes");
    }
    if (this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null)
    {
      QLog.d("AVRedPacketConfigManger", 1, "downloadRes, redPacketConfig is null");
      return;
    }
    Object localObject = (aopo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
    ((aopo)localObject).a(this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL);
    ((aopo)localObject).a(this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl);
    localObject = a();
    if (localObject != null)
    {
      ((MqqHandler)localObject).post(new AVRedPacketConfigManager.1(this, paramitw));
      return;
    }
    QLog.w("AVRedPacketConfigManger", 1, "downloadRes, downloadHandle is null");
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "onDownloadFinish,url =   " + paramString1 + ",md5 = " + paramString2 + ",errCode = " + paramInt + ",path = " + paramString3 + ",userData = " + paramObject);
    }
    String str = null;
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label182;
      }
      paramObject = this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL;
      irm.bM(i, paramInt);
      if (!paramString3.endsWith("/")) {
        break label204;
      }
    }
    label182:
    label204:
    for (str = paramString3;; str = paramString3 + File.separator)
    {
      if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(paramObject)))
      {
        paramString3 = a();
        if (paramString3 == null) {
          break label230;
        }
        paramString3.post(new AVRedPacketConfigManager.2(this, paramInt, str, paramString2, i, paramString1));
      }
      return;
      paramObject = str;
      if (i != 2) {
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl;
      break;
    }
    label230:
    QLog.w("AVRedPacketConfigManger", 1, "onDownloadFinish, downloadHandle is null");
  }
  
  public void aqj()
  {
    a(a(), false);
    irm.iK(false);
  }
  
  public void b(itw paramitw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig,start");
    }
    synchronized (this.lock)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig,isGettingConfig =   " + this.UD);
      }
      this.jdField_a_of_type_Itw = paramitw;
      if (!this.UD)
      {
        paramitw = this.jdField_a_of_type_Itw;
        if (paramitw == null) {}
      }
      try
      {
        this.jdField_a_of_type_Itw.a(true, this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig);
        return;
      }
      catch (RemoteException paramitw)
      {
        for (;;)
        {
          paramitw.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("AVRedPacketConfigManger", 2, "getAVRedPacketConfig,error    ", paramitw);
          }
        }
      }
    }
  }
  
  public void f(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "onDownloadUpdate,url =   " + paramString1 + ",md5 = " + paramString2 + ",percent = " + paramInt);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      jgx.awm();
    }
    return true;
  }
  
  public void jy(String paramString)
  {
    try
    {
      if (this.e != null)
      {
        this.e.removeCallbacksAndMessages(null);
        this.e = null;
        QLog.w("AVRedPacketConfigManger", 1, "clearDownloadHandle[" + paramString + "], 释放mDownloadHandle");
      }
      if (this.m != null)
      {
        this.m.quit();
        this.m = null;
        QLog.w("AVRedPacketConfigManger", 1, "clearDownloadHandle[" + paramString + "], 释放mDownloadHandleThread");
      }
      return;
    }
    finally {}
  }
  
  public void jz(String paramString)
  {
    paramString = AVRedPacketConfig.parse(paramString);
    if (paramString == null) {
      AVRedPacketConfig.deleteLocalConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    for (;;)
    {
      irm.iK(true);
      return;
      a(paramString, true);
    }
  }
  
  public int lA()
  {
    AVRedPacketConfig localAVRedPacketConfig = a();
    if (localAVRedPacketConfig == null) {}
    for (int i = 0;; i = localAVRedPacketConfig.version)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketConfigManger", 2, "getConfigVersion:" + i);
      }
      return i;
    }
  }
  
  public void loadConfigFromFile()
  {
    synchronized (this.lock)
    {
      if (this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null)
      {
        this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig = AVRedPacketConfig.readFromFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketConfigManger", 2, "loadConfigFromFile,redPacketConfig =   " + this.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig);
        }
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Aduq.b(this);
    jy("onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irz
 * JD-Core Version:    0.7.0.1
 */