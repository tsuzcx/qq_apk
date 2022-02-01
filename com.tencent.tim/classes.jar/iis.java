import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class iis
{
  boolean PO = false;
  public boolean PP;
  private QQLruCache<String, String> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache;
  itz.a jdField_a_of_type_Itz$a = new iis.a();
  public iua a;
  int amF = -1;
  private MQLruCache<String, Object> faceIconCache;
  VideoAppInterface mApp;
  ServiceConnection mServiceConnection = new iis.b();
  
  public iis(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_Iua = null;
    this.mApp = paramVideoAppInterface;
  }
  
  public Bitmap G()
  {
    return aqhu.f(true);
  }
  
  public void T(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      this.jdField_a_of_type_Iua.T(paramInt, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "startPumpMessage", paramString);
    }
  }
  
  public void U(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      this.jdField_a_of_type_Iua.U(paramInt, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "setBindInfo", paramString);
    }
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = a(paramInt, paramString1, paramString2, paramBoolean1);
    Object localObject = getBitmapFromCache(str);
    if (localObject == null) {
      if (this.jdField_a_of_type_Iua == null) {}
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = this.jdField_a_of_type_Iua.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
        localObject = localBitmap;
        if (localObject == null) {}
      }
      catch (RemoteException localRemoteException1)
      {
        if (paramBoolean2) {
          localObject = G();
        }
        i = 2;
        continue;
      }
      catch (NullPointerException localNullPointerException1) {}
      try
      {
        e(str, (Bitmap)localObject);
        i = 0;
      }
      catch (NullPointerException localNullPointerException2)
      {
        break label173;
      }
      catch (RemoteException localRemoteException2)
      {
        continue;
        continue;
      }
      if (AudioHelper.aCz()) {
        QLog.w("QQServiceProxy", 1, "getFaceBitmap, uinType[" + paramInt + "], uin[" + paramString1 + "], extraUin[" + paramString2 + "], isNeedReturnDefaultValue[" + paramBoolean2 + "], ret[" + i + "]");
      }
      return localObject;
      int i = 1;
      continue;
      label173:
      if (paramBoolean2) {
        localObject = G();
      }
      i = 3;
      continue;
      i = 4;
      if (!paramBoolean2) {
        break;
      }
      localObject = G();
      continue;
      i = -3;
    }
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (this.jdField_a_of_type_Iua != null) {
      try
      {
        paramBundle = this.jdField_a_of_type_Iua.a(paramInt1, paramInt2, paramInt3, null, paramBundle, paramResultReceiver);
        return paramBundle;
      }
      catch (RemoteException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceProxy", 2, "requestEvent, mainCmd[" + paramInt1 + "], subType[" + paramInt2 + "], seq[" + paramInt3 + "]");
        }
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.w("QQServiceProxy", 1, "requestEvent, fail, mainCmd[" + paramInt1 + "], subType[" + paramInt2 + "], seq[" + paramInt3 + "]");
      }
    }
  }
  
  public String a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = new StringBuilder().append("").append(paramInt).append("_").append(paramString1).append("_").append(paramString2).append("_");
    if (paramBoolean) {}
    for (paramString1 = "0";; paramString1 = "1") {
      return paramString1;
    }
  }
  
  public boolean a(itw paramitw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "getAVRedPacketConfig start mQQServiceForAV = " + this.jdField_a_of_type_Iua);
    }
    if (this.jdField_a_of_type_Iua != null) {
      try
      {
        this.jdField_a_of_type_Iua.b(paramitw);
        return true;
      }
      catch (RemoteException paramitw)
      {
        paramitw.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceProxy", 2, "getAVRedPacketConfig error", paramitw);
        }
      }
    }
    return false;
  }
  
  public long[] a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_Iua.a(paramString);
      return localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getDiscussMemberList", paramString);
    }
    return null;
  }
  
  public void aO(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) && (!TextUtils.isEmpty(paramString2))) {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString1, paramString2);
    }
  }
  
  public int aj(String paramString)
  {
    if (this.jdField_a_of_type_Iua != null) {
      try
      {
        int i = this.jdField_a_of_type_Iua.aj(paramString);
        return i;
      }
      catch (RemoteException paramString)
      {
        QLog.e("QQServiceProxy", 2, "convertUinTypeEx e = ", paramString);
      }
    }
    for (;;)
    {
      return -1;
      QLog.e("QQServiceProxy", 2, "convertUinTypeEx mQQServiceForAV == null");
    }
  }
  
  public boolean ak(long paramLong)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool = this.jdField_a_of_type_Iua.ay(paramLong);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QQServiceProxy", 2, "getTroopAdmins-->troopUin=" + paramLong, localRemoteException);
    }
    return false;
  }
  
  public void amD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "bindQQService");
    }
    if ((this.jdField_a_of_type_Iua == null) && (!this.PO))
    {
      this.PO = true;
      Intent localIntent = new Intent(this.mApp.getApp(), QQServiceForAV.class);
      this.mApp.getApp().bindService(localIntent, this.mServiceConnection, 1);
    }
  }
  
  public void amE()
  {
    igd.aK("QQServiceProxy", "unbindQQService");
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      this.jdField_a_of_type_Iua.aqJ();
      this.jdField_a_of_type_Iua.a(this.jdField_a_of_type_Itz$a);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        try
        {
          this.mApp.getApp().unbindService(this.mServiceConnection);
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("QQServiceProxy", 2, "unbindService3 ", localException2);
        }
        localRemoteException = localRemoteException;
        QLog.e("QQServiceProxy", 2, "unbindQQService1 ", localRemoteException);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.e("QQServiceProxy", 2, "unbindQQService2 ", localException1);
      }
    }
  }
  
  public void amF()
  {
    if (this.jdField_a_of_type_Iua != null) {
      try
      {
        this.jdField_a_of_type_Iua.amF();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQServiceProxy", 2, "avStartAddFriendService", localRemoteException);
        return;
      }
    }
    this.PP = true;
  }
  
  public void bL(long paramLong)
  {
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      this.jdField_a_of_type_Iua.bL(paramLong);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "syncChatingTime", localRemoteException);
    }
  }
  
  public boolean cp(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      this.jdField_a_of_type_Iua.ju(paramString);
      bool1 = true;
    }
    catch (RemoteException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getNearbyProfileData", paramString);
    }
    return bool1;
    return false;
  }
  
  public boolean cq(String paramString)
  {
    if (this.jdField_a_of_type_Iua != null) {
      try
      {
        boolean bool = this.jdField_a_of_type_Iua.w(paramString, this.mApp.getCurrentAccountUin());
        return bool;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return true;
  }
  
  public String d(int paramInt, String paramString1, String paramString2)
  {
    return "" + paramInt + "_" + paramString1 + "_" + paramString2;
  }
  
  public String dg(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) {
      return (String)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    }
    return "";
  }
  
  public String dh(String paramString)
  {
    Object localObject2 = dg(paramString);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = null;
      localObject1 = null;
      if (this.jdField_a_of_type_Iua == null) {}
    }
    try
    {
      localObject1 = this.jdField_a_of_type_Iua.dd(paramString);
      localObject2 = localObject1;
      aO(paramString, (String)localObject1);
      localObject2 = localObject1;
      QLog.w("QQServiceProxy", 1, "getPhoneUserNameByPhoneNum, number[" + paramString + "], name[" + (String)localObject1 + "]");
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.w("QQServiceProxy", 2, "getPhoneUserNameByPhoneNum", paramString);
    }
    return localObject1;
    return localObject2;
  }
  
  public String di(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_Iua.di(paramString);
      return localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getPhoneNumByUin", paramString);
    }
    return null;
  }
  
  public int e(int paramInt, String paramString)
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      i = this.jdField_a_of_type_Iua.e(paramInt, paramString);
      return i;
    }
    catch (RemoteException paramString)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getDiscussMemberNum", paramString);
    }
    return 0;
  }
  
  public void e(long paramLong1, String paramString, long paramLong2)
  {
    if (this.jdField_a_of_type_Iua != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        this.jdField_a_of_type_Iua.e(paramLong1, paramString, paramLong2);
        return;
      }
      catch (RemoteException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQServiceProxy", 2, "addSharpMsgRecordList e = ", paramString);
        return;
      }
    }
    QLog.e("QQServiceProxy", 2, "addSharpMsgRecordList mQQServiceForAV==null");
  }
  
  public void e(String paramString, Bitmap paramBitmap)
  {
    if ((this.faceIconCache != null) && (paramBitmap != null)) {
      this.faceIconCache.put(paramString, paramBitmap);
    }
  }
  
  public boolean e(String paramString, int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool = this.jdField_a_of_type_Iua.e(paramString, paramInt);
      return bool;
    }
    catch (RemoteException paramString)
    {
      QLog.e("QQServiceProxy", 2, "requestDecodeStrangeFace-->false", paramString);
    }
    return false;
  }
  
  public boolean g(int paramInt, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Iua.l(paramInt, paramLong);
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "curGAInviteIsRight", localRemoteException);
    }
    return true;
  }
  
  public Bitmap getBitmapFromCache(String paramString)
  {
    if (this.faceIconCache != null) {
      return (Bitmap)this.faceIconCache.get(paramString);
    }
    return null;
  }
  
  public String getDisplayName(int paramInt, String paramString1, String paramString2)
  {
    String str2 = d(paramInt, paramString1, paramString2);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      String str1 = this.jdField_a_of_type_Iua.getDisplayName(paramInt, paramString1, paramString2);
      localObject2 = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject2 = str1;
        aO(str2, str1);
      }
      localObject1 = str1;
      localObject2 = str1;
      if (AudioHelper.aCz())
      {
        localObject2 = str1;
        QLog.w("QQServiceProxy", 1, "getDisplayName, uinType[" + paramInt + "], uin[" + paramString1 + "], extraUin[" + paramString2 + "], name[" + str1 + "]");
        localObject1 = str1;
      }
    }
    catch (RemoteException paramString2)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("QQServiceProxy", 2, "getDisplayName", paramString2);
          localObject1 = localObject2;
        }
      }
    }
    paramString2 = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = dg(str2);
      paramString2 = (String)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return paramString1;
      }
    }
    return paramString2;
  }
  
  public String getSKey()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Iua != null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceProxy", 2, "We will get current user skey");
      }
    }
    while (!QLog.isColorLevel())
    {
      try
      {
        String str = this.jdField_a_of_type_Iua.getSKey();
        localObject = str;
      }
      catch (RemoteException localRemoteException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("QQServiceProxy", 2, "getSKey fail", localRemoteException);
        return null;
      }
      return localObject;
    }
    QLog.d("QQServiceProxy", 2, "getSKey-->mQQServiceForAV is null");
    return null;
  }
  
  public void h(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      this.jdField_a_of_type_Iua.h(paramInt, paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "setPeerInfo", paramString1);
    }
  }
  
  public void hW(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      this.jdField_a_of_type_Iua.hW(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQServiceProxy", 1, "keepVideoProcessAlive fail.", localThrowable);
    }
  }
  
  public void init()
  {
    this.faceIconCache = BaseApplicationImpl.sImageCache;
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(10001, 50, 10);
  }
  
  public boolean isFriend(String paramString)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool = this.jdField_a_of_type_Iua.isFriend(paramString);
      return bool;
    }
    catch (RemoteException paramString)
    {
      QLog.e("QQServiceProxy", 2, "isFriend", paramString);
    }
    return false;
  }
  
  public void iw(String paramString)
  {
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      QLog.w("QQServiceProxy", 1, "stopPumpMessage[" + paramString + "]");
      this.jdField_a_of_type_Iua.aqJ();
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "stopPumpMessage", paramString);
    }
  }
  
  public void ix(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Iua != null) {
        this.jdField_a_of_type_Iua.ix(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "[red dot] redTouchManagerClick", paramString);
    }
  }
  
  public void iy(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Iua != null) {
        this.jdField_a_of_type_Iua.iy(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceProxy", 2, "[red dot] redTouchManagerExposure", paramString);
    }
  }
  
  public boolean sK()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("isQQServiceBind ");
      if (this.jdField_a_of_type_Iua == null) {
        break label52;
      }
    }
    label52:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQServiceProxy", 2, bool);
      if (this.jdField_a_of_type_Iua == null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean sL()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Iua.sL();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "isQQpaused", localRemoteException);
    }
    return false;
  }
  
  public boolean sM()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Iua.sM();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "isPhoneCalling", localRemoteException);
    }
    return false;
  }
  
  public boolean sN()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Iua.sN();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getNearbyProfileData", localRemoteException);
    }
    return false;
  }
  
  public boolean sO()
  {
    if ((this.amF == -1) && (this.jdField_a_of_type_Iua != null)) {}
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Iua.sO()) {
          continue;
        }
        i = 1;
        this.amF = i;
      }
      catch (Exception localException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QQServiceProxy", 2, "getTalkBack", localException);
        continue;
      }
      if (this.amF != 1) {
        break label69;
      }
      return true;
      i = 0;
    }
    label69:
    return false;
  }
  
  public boolean sP()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Iua.sP();
      if (QLog.isColorLevel()) {
        QLog.e("EffectEnable", 2, "getEffectsSoLoadIsOk  result " + this.jdField_a_of_type_Iua + "   " + bool1);
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("EffectEnable", 1, "getEffectsSoLoadIsOk", localRemoteException);
        bool1 = bool2;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        igd.aL("EffectEnable", localNullPointerException.getMessage());
        bool1 = bool2;
      }
    }
  }
  
  public boolean sQ()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Iua.sQ();
      if (QLog.isColorLevel()) {
        QLog.e("getEffectLibPagSoLoadIsOk", 2, "getEffectLibPagSoLoadIsOk  result " + this.jdField_a_of_type_Iua + "   " + bool1);
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("getEffectLibPagSoLoadIsOk", 1, "getEffectLibPagSoLoadIsOk", localRemoteException);
        bool1 = bool2;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        igd.aL("EffectEnable", localNullPointerException.getMessage());
        bool1 = bool2;
      }
    }
  }
  
  public boolean sR()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Iua.cf(1);
      if (QLog.isColorLevel()) {
        QLog.e("getRealNameAuthed", 2, "getEffectLibPagSoLoadIsOk  result " + this.jdField_a_of_type_Iua + "   " + bool1);
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("getRealNameAuthed", 1, "getRealNameAuthed error", localRemoteException);
        bool1 = bool2;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        igd.aL("getRealNameAuthed", localNullPointerException.getMessage());
        bool1 = bool2;
      }
    }
  }
  
  public boolean sS()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Iua.cf(2);
      if (QLog.isColorLevel()) {
        QLog.e("startRealNameAuth", 2, "startRealNameAuth  result " + this.jdField_a_of_type_Iua + "   " + bool1);
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("startRealNameAuth", 1, "startRealNameAuth error", localRemoteException);
        bool1 = bool2;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        igd.aL("startRealNameAuth", localNullPointerException.getMessage());
        bool1 = bool2;
      }
    }
  }
  
  public boolean sy()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_Iua.sy();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "isQQSVIP remote call exception", localRemoteException);
    }
    return false;
  }
  
  public void uninit()
  {
    if (this.faceIconCache != null) {
      this.faceIconCache.evictAll();
    }
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    }
  }
  
  public long v(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_Iua != null) {}
    try
    {
      l1 = this.jdField_a_of_type_Iua.v(paramString);
      return l1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceProxy", 2, "getDiscussMemberNum", paramString);
    }
    return 0L;
  }
  
  class a
    extends itz.a
  {
    a() {}
    
    public Bundle a(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceProxy", 2, "getDataFromVideoProcess cmd = " + paramInt1 + ",subCmd = " + paramInt2 + ",request = " + paramBundle + ",callbackCookie = " + paramString);
      }
      switch (paramInt1)
      {
      default: 
        return null;
      }
      paramString = new Bundle();
      paramString.putString("camera_used_desc", ilp.NH);
      return paramString;
    }
    
    public void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
      throws RemoteException
    {}
    
    public void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo)
      throws RemoteException
    {
      if ((paramArrayOfRecvGVideoLevelInfo != null) && (paramArrayOfRecvGVideoLevelInfo.length > 0)) {
        iis.this.mApp.l(new Object[] { Integer.valueOf(501), paramArrayOfRecvGVideoLevelInfo });
      }
    }
    
    public void b(RecvMsg paramRecvMsg)
      throws RemoteException
    {
      if (paramRecvMsg != null) {
        iis.this.mApp.l(new Object[] { Integer.valueOf(12), paramRecvMsg });
      }
    }
    
    public void c(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      if (TextUtils.equals(paramString, "avChatRoom"))
      {
        ilu localilu = iis.this.mApp.a();
        if (localilu != null) {
          localilu.e(paramInt, paramArrayOfByte);
        }
      }
      if (QLog.isDevelopLevel())
      {
        paramString = new StringBuilder().append("onReceivePushMsg , key[").append(paramString).append("], msgType[").append(paramInt).append("], bytes[");
        if (paramArrayOfByte != null) {
          break label96;
        }
      }
      label96:
      for (paramInt = 0;; paramInt = paramArrayOfByte.length)
      {
        QLog.i("ChatRoomMng", 4, paramInt + "]");
        return;
      }
    }
    
    public void d(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
      throws RemoteException
    {
      iis.this.mApp.l(new Object[] { Integer.valueOf(47), Boolean.valueOf(paramBoolean), paramString1, paramString2, paramString3 });
    }
  }
  
  class b
    implements ServiceConnection
  {
    b() {}
    
    /* Error */
    public void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
    {
      // Byte code:
      //   0: ldc 27
      //   2: iconst_1
      //   3: new 29	java/lang/StringBuilder
      //   6: dup
      //   7: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   10: ldc 32
      //   12: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   15: aload_1
      //   16: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   19: ldc 41
      //   21: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   24: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   27: invokestatic 51	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
      //   30: aload_0
      //   31: getfield 15	iis$b:a	Liis;
      //   34: iconst_0
      //   35: putfield 55	iis:PO	Z
      //   38: aload_0
      //   39: getfield 15	iis$b:a	Liis;
      //   42: aload_2
      //   43: invokestatic 60	iua$a:a	(Landroid/os/IBinder;)Liua;
      //   46: putfield 63	iis:jdField_a_of_type_Iua	Liua;
      //   49: aload_0
      //   50: getfield 15	iis$b:a	Liis;
      //   53: getfield 63	iis:jdField_a_of_type_Iua	Liua;
      //   56: aload_0
      //   57: getfield 15	iis$b:a	Liis;
      //   60: getfield 66	iis:jdField_a_of_type_Itz$a	Litz$a;
      //   63: ldc 68
      //   65: invokeinterface 73 3 0
      //   70: aload_0
      //   71: getfield 15	iis$b:a	Liis;
      //   74: getfield 76	iis:PP	Z
      //   77: ifeq +10 -> 87
      //   80: aload_0
      //   81: getfield 15	iis$b:a	Liis;
      //   84: invokevirtual 79	iis:amF	()V
      //   87: aload_0
      //   88: getfield 15	iis$b:a	Liis;
      //   91: getfield 83	iis:mApp	Lcom/tencent/av/app/VideoAppInterface;
      //   94: iconst_1
      //   95: anewarray 4	java/lang/Object
      //   98: dup
      //   99: iconst_0
      //   100: bipush 10
      //   102: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   105: aastore
      //   106: invokevirtual 95	com/tencent/av/app/VideoAppInterface:l	([Ljava/lang/Object;)V
      //   109: aload_0
      //   110: getfield 15	iis$b:a	Liis;
      //   113: getfield 63	iis:jdField_a_of_type_Iua	Liua;
      //   116: invokeinterface 99 1 0
      //   121: new 101	iit
      //   124: dup
      //   125: aload_0
      //   126: invokespecial 104	iit:<init>	(Liis$b;)V
      //   129: iconst_0
      //   130: invokeinterface 110 3 0
      //   135: aload_0
      //   136: getfield 15	iis$b:a	Liis;
      //   139: getfield 83	iis:mApp	Lcom/tencent/av/app/VideoAppInterface;
      //   142: ifnull +29 -> 171
      //   145: aload_0
      //   146: getfield 15	iis$b:a	Liis;
      //   149: getfield 83	iis:mApp	Lcom/tencent/av/app/VideoAppInterface;
      //   152: getfield 114	com/tencent/av/app/VideoAppInterface:d	Lcom/tencent/av/VideoController;
      //   155: ifnull +16 -> 171
      //   158: aload_0
      //   159: getfield 15	iis$b:a	Liis;
      //   162: getfield 83	iis:mApp	Lcom/tencent/av/app/VideoAppInterface;
      //   165: invokevirtual 117	com/tencent/av/app/VideoAppInterface:b	()Lcom/tencent/av/VideoController;
      //   168: invokevirtual 122	com/tencent/av/VideoController:amg	()V
      //   171: return
      //   172: astore_1
      //   173: ldc 27
      //   175: new 29	java/lang/StringBuilder
      //   178: dup
      //   179: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   182: ldc 124
      //   184: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   187: aload_1
      //   188: invokevirtual 127	android/os/RemoteException:getMessage	()Ljava/lang/String;
      //   191: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   194: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   197: invokestatic 133	igd:aL	(Ljava/lang/String;Ljava/lang/String;)V
      //   200: goto -91 -> 109
      //   203: astore_1
      //   204: ldc 27
      //   206: new 29	java/lang/StringBuilder
      //   209: dup
      //   210: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   213: ldc 124
      //   215: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   218: aload_1
      //   219: invokevirtual 134	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   222: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   225: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   228: invokestatic 133	igd:aL	(Ljava/lang/String;Ljava/lang/String;)V
      //   231: goto -96 -> 135
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	234	0	this	b
      //   0	234	1	paramComponentName	ComponentName
      //   0	234	2	paramIBinder	android.os.IBinder
      // Exception table:
      //   from	to	target	type
      //   49	87	172	android/os/RemoteException
      //   87	109	172	android/os/RemoteException
      //   109	135	203	java/lang/Exception
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected");
      }
      try
      {
        if (iis.this.jdField_a_of_type_Iua != null) {
          iis.this.jdField_a_of_type_Iua.a(iis.this.jdField_a_of_type_Itz$a);
        }
        iis.this.mApp.l(new Object[] { Integer.valueOf(11) });
        iis.this.mApp.a().deleteObservers();
      }
      catch (RemoteException paramComponentName)
      {
        for (;;)
        {
          QLog.e("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected RemoteException", paramComponentName);
        }
      }
      iis.this.jdField_a_of_type_Iua = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iis
 * JD-Core Version:    0.7.0.1
 */