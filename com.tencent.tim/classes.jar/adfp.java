import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;

public class adfp
  implements Handler.Callback
{
  public adfi a;
  private adfj jdField_a_of_type_Adfj;
  public adfk a;
  public adgk a;
  public adgm a;
  public adgn a;
  private adgo jdField_a_of_type_Adgo = new adfu(this);
  public adfh b;
  public adgj b;
  public ARCommonConfigInfo b;
  public ArEffectConfig b;
  volatile boolean bME = false;
  boolean bMF = false;
  public ArConfigInfo c;
  private int cEV = -1;
  public boolean isDownloading;
  public ServiceConnection j = new adfq(this);
  private Context mContext;
  private Handler mHandler;
  private HandlerThread mThread = new HandlerThread("RemoteArConfigManager");
  
  public adfp()
  {
    this.jdField_a_of_type_Adgn = new adfr(this);
    this.jdField_a_of_type_Adgk = new adfs(this);
    this.jdField_a_of_type_Adgm = new adft(this);
    this.mThread.start();
    this.mHandler = new Handler(this.mThread.getLooper(), this);
  }
  
  public void KR(int paramInt)
  {
    if (this.jdField_b_of_type_Adgj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadFaceResources type " + paramInt);
      }
    }
    try
    {
      this.jdField_b_of_type_Adgj.KL(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadFaceResources|RemoteException e= " + localRemoteException);
    }
  }
  
  public void KS(int paramInt)
  {
    if (this.jdField_b_of_type_Adgj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadMiniResource type " + paramInt);
      }
    }
    try
    {
      this.jdField_b_of_type_Adgj.KM(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadMiniResource|RemoteException e= " + localRemoteException);
    }
  }
  
  public void a(Context paramContext, adfh paramadfh, adfk paramadfk)
  {
    a(paramContext, false, paramadfh, null, null, paramadfk);
  }
  
  public void a(Context paramContext, boolean paramBoolean, adfh paramadfh, adfi paramadfi, adfj paramadfj, adfk paramadfk)
    throws RuntimeException
  {
    if (paramContext == null) {
      return;
    }
    this.mContext = paramContext;
    this.bMF = paramBoolean;
    paramContext = new Intent(this.mContext, ArConfigService.class);
    this.mContext.bindService(paramContext, this.j, 1);
    this.bME = true;
    if (paramadfh != null) {
      this.jdField_b_of_type_Adfh = paramadfh;
    }
    if (paramadfi != null) {
      this.jdField_a_of_type_Adfi = paramadfi;
    }
    this.jdField_a_of_type_Adfj = paramadfj;
    this.jdField_a_of_type_Adfk = paramadfk;
  }
  
  public boolean adU()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (this.jdField_b_of_type_Adgj != null) {}
    try
    {
      bool1 = this.jdField_b_of_type_Adgj.adU();
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "isFaceResConfigReady " + bool1);
        bool2 = bool1;
      }
      return bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        boolean bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "isFaceResConfigReady|RemoteException e= " + localRemoteException);
          bool1 = bool3;
        }
      }
    }
  }
  
  public boolean adV()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (this.jdField_b_of_type_Adgj != null) {}
    try
    {
      bool1 = this.jdField_b_of_type_Adgj.adV();
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "isMiniResConfigReady " + bool1);
        bool2 = bool1;
      }
      return bool2;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        boolean bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "isMiniResConfigReady|RemoteException e= " + localRemoteException);
          bool1 = bool3;
        }
      }
    }
  }
  
  public boolean adW()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Adgj != null) {}
    try
    {
      bool1 = this.jdField_b_of_type_Adgj.adW();
      return bool1;
    }
    catch (Exception localException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("ArConfig_RemoteArConfigManager", 2, "isArSoReady fail!", localException);
    }
    return false;
  }
  
  public ARCommonConfigInfo b()
  {
    Object localObject1;
    if (this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = null;
        localObject1 = null;
      } while (this.jdField_b_of_type_Adgj == null);
      try
      {
        localObject1 = this.jdField_b_of_type_Adgj.b();
        localObject2 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("ArConfig_RemoteArConfigManager", 1, "getARCommonConfigInfo fail!", localException);
        }
      }
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("ArConfig_RemoteArConfigManager", 2, String.format("getARCommonConfigInfo arCommonConfigInfo=%s", new Object[] { localObject2 }));
    return localObject2;
  }
  
  public ArConfigInfo b()
  {
    Object localObject2;
    if (this.c != null) {
      localObject2 = this.c;
    }
    for (;;)
    {
      return localObject2;
      localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_b_of_type_Adgj != null) {}
      try
      {
        localObject1 = this.jdField_b_of_type_Adgj.a();
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArConfig_RemoteArConfigManager", 2, "getArConfig|info=" + localObject1);
        return localObject1;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("ArConfig_RemoteArConfigManager", 2, "getArConfig|RemoteException e= " + localRemoteException);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public ArEffectConfig b()
  {
    Object localObject2;
    if (this.jdField_b_of_type_ComTencentMobileqqArAidlArEffectConfig != null) {
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqArAidlArEffectConfig;
    }
    for (;;)
    {
      return localObject2;
      Object localObject3 = null;
      localObject2 = null;
      if (this.jdField_b_of_type_Adgj == null) {
        continue;
      }
      try
      {
        localObject1 = this.jdField_b_of_type_Adgj.a();
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArConfig_RemoteArConfigManager", 2, "getEffectConfig|info=" + localObject1);
        return localObject1;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Object localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("ArConfig_RemoteArConfigManager", 2, "getEffectConfig|RemoteException e= " + localRemoteException);
            localObject1 = localObject3;
          }
        }
      }
    }
  }
  
  public void cQW()
  {
    if (this.jdField_b_of_type_Adgj != null) {}
    try
    {
      this.jdField_b_of_type_Adgj.cQW();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadArSo fail!", localException);
    }
  }
  
  public void cRn()
  {
    if (this.mThread != null)
    {
      this.mThread.quit();
      this.mThread = null;
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    if (this.isDownloading)
    {
      cancelDownload();
      this.isDownloading = false;
    }
    if ((!this.bME) || (this.mContext != null)) {}
    try
    {
      this.mContext.unbindService(this.j);
      this.bME = false;
      this.mContext = null;
      this.jdField_b_of_type_Adfh = null;
      this.jdField_a_of_type_Adfi = null;
      this.jdField_a_of_type_Adfj = null;
      this.jdField_a_of_type_Adfk = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void cancelDownload()
  {
    if (this.jdField_b_of_type_Adgj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload");
      }
    }
    try
    {
      this.jdField_b_of_type_Adgj.cancelDownload();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload|RemoteException e= " + localRemoteException);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            for (;;)
                            {
                              return false;
                              if (this.jdField_b_of_type_Adfh != null)
                              {
                                this.jdField_b_of_type_Adfh.zE();
                                return false;
                                if (this.jdField_b_of_type_Adfh != null)
                                {
                                  paramMessage = paramMessage.obj;
                                  if ((paramMessage instanceof ArConfigInfo))
                                  {
                                    this.jdField_b_of_type_Adfh.a((ArConfigInfo)paramMessage);
                                    return false;
                                    if (this.jdField_b_of_type_Adfh != null)
                                    {
                                      paramMessage = paramMessage.obj;
                                      if ((paramMessage instanceof ArEffectConfig))
                                      {
                                        this.jdField_b_of_type_Adfh.a((ArEffectConfig)paramMessage);
                                        return false;
                                        if (this.jdField_b_of_type_Adfh != null) {
                                          try
                                          {
                                            if ((paramMessage.obj instanceof ARCommonConfigInfo))
                                            {
                                              this.jdField_b_of_type_Adfh.a((ARCommonConfigInfo)paramMessage.obj);
                                              return false;
                                            }
                                          }
                                          catch (Exception paramMessage)
                                          {
                                            QLog.e("ArConfig_RemoteArConfigManager", 1, "handleMessage AR_COMMON_CONFIG_UPDATE fail.", paramMessage);
                                            return false;
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          } while (this.jdField_b_of_type_Adfh == null);
                          this.jdField_b_of_type_Adfh.onDownloadSuccess();
                          this.isDownloading = false;
                          return false;
                        } while (this.jdField_b_of_type_Adfh == null);
                        i = paramMessage.arg1;
                        k = paramMessage.arg2;
                        this.jdField_b_of_type_Adfh.m(i, k);
                        return false;
                      } while ((this.jdField_b_of_type_Adfh == null) || (!(paramMessage.obj instanceof Integer)));
                      this.jdField_b_of_type_Adfh.ez(((Integer)paramMessage.obj).intValue());
                      this.isDownloading = false;
                      return false;
                    } while (this.jdField_a_of_type_Adfi == null);
                    i = paramMessage.arg1;
                    this.jdField_a_of_type_Adfi.eA(i);
                    return false;
                  } while (this.jdField_a_of_type_Adfi == null);
                  i = paramMessage.arg1;
                  k = paramMessage.arg2;
                  this.jdField_a_of_type_Adfi.ak(i, k);
                  return false;
                } while (this.jdField_a_of_type_Adfi == null);
                i = paramMessage.arg1;
                k = paramMessage.arg2;
                this.jdField_a_of_type_Adfi.al(i, k);
                return false;
              } while (this.jdField_a_of_type_Adfj == null);
              this.jdField_a_of_type_Adfj.cPS();
              return false;
            } while (this.jdField_a_of_type_Adfj == null);
            this.jdField_a_of_type_Adfj.cPT();
            return false;
          } while (this.jdField_a_of_type_Adfj == null);
          this.jdField_a_of_type_Adfj.Ky(paramMessage.arg1);
          return false;
        } while (this.jdField_a_of_type_Adfk == null);
        i = paramMessage.arg1;
        this.jdField_a_of_type_Adfk.KQ(i);
        return false;
      } while (this.jdField_a_of_type_Adfk == null);
      i = paramMessage.arg1;
      k = paramMessage.arg2;
      this.jdField_a_of_type_Adfk.hk(i, k);
      return false;
    } while (this.jdField_a_of_type_Adfk == null);
    int i = paramMessage.arg1;
    int k = paramMessage.arg2;
    this.jdField_a_of_type_Adfk.hl(i, k);
    return false;
  }
  
  public void yd(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onToolScannerActivityStateChanged state:" + paramInt + "  mConfigManager:" + this.jdField_b_of_type_Adgj);
    }
    if (this.jdField_b_of_type_Adgj != null) {
      try
      {
        this.jdField_b_of_type_Adgj.yd(paramInt);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
    }
    this.cEV = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfp
 * JD-Core Version:    0.7.0.1
 */