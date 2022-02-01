import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.1;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.xmlpull.v1.XmlPullParserException;

public class yuu
  implements Manager
{
  public long KK;
  public yut a;
  public yuv a;
  public Bundle aj;
  public Bundle ak;
  public boolean bpb;
  public boolean bpc;
  public boolean bpd;
  public boolean bpe;
  Runnable eN = new PhoneUnityManager.1(this);
  Runnable eO = new PhoneUnityManager.2(this);
  public QQAppInterface mApp;
  
  public yuu(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private void cme()
  {
    Object localObject = a();
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "tryShowBannerInner ve" + this.jdField_a_of_type_Yuv);
    }
    if (((yuv)localObject).KN > 0L)
    {
      ((yuv)localObject).KN -= 1L;
      a((yuv)localObject);
    }
    label68:
    yut localyut;
    label340:
    label342:
    do
    {
      break label68;
      for (;;)
      {
        return;
        if ((localObject != null) && (((yuv)localObject).version != -1))
        {
          localyut = a();
          if (QLog.isColorLevel()) {
            QLog.d("MobileUnityManager", 2, "tryShowBannerInner bd " + localyut);
          }
          if ((localyut == null) || (localyut.cbq <= 0) || (localyut.cbo <= 0) || (!localyut.boZ) || (((yuv)localObject).KM <= 0L)) {
            break;
          }
          int j = 0;
          long l1 = ((yuv)localObject).KL;
          long l2 = (localyut.cbp + 1) * 24 * 60 * 60 * 1000;
          long l3 = System.currentTimeMillis();
          int i;
          if (l3 - l1 > l2)
          {
            ((yuv)localObject).KL = l3;
            ((yuv)localObject).KM -= 1L;
            ((yuv)localObject).cbr = (localyut.cbo - 1);
            a((yuv)localObject);
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label340;
            }
            if (!((ajdo)this.mApp.getManager(11)).Uv()) {
              break label342;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("MobileUnityManager", 2, "tryShowBannerInner already binded");
            return;
            i = j;
            if (l3 - l1 < 86400000L)
            {
              i = j;
              if (((yuv)localObject).cbr > 0)
              {
                ((yuv)localObject).KM -= 1L;
                ((yuv)localObject).cbr -= 1;
                a((yuv)localObject);
                i = 1;
              }
            }
          }
        }
      }
      localObject = this.mApp.getHandler(Conversation.class);
    } while (localObject == null);
    Message localMessage = Message.obtain();
    localMessage.what = 1040;
    localMessage.obj = localyut;
    ((MqqHandler)localObject).sendMessage(localMessage);
  }
  
  public static String hP(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 7)) {
      return "";
    }
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, i - 8));
    localStringBuilder.append("******");
    localStringBuilder.append(paramString.substring(i - 2));
    return localStringBuilder.toString();
  }
  
  public boolean UA()
  {
    return this.bpd;
  }
  
  public yut a()
  {
    if (this.jdField_a_of_type_Yut != null) {
      return this.jdField_a_of_type_Yut;
    }
    Object localObject = pV();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_Yut = null;
      return null;
    }
    BaseApplicationImpl.getContext();
    localObject = new File((String)localObject);
    try
    {
      if (((File)localObject).exists()) {
        this.jdField_a_of_type_Yut = yut.a(aqhq.readFileContent((File)localObject));
      }
      localObject = this.jdField_a_of_type_Yut;
      return localObject;
    }
    catch (Exception localException)
    {
      return this.jdField_a_of_type_Yut;
    }
    catch (IOException localIOException)
    {
      break label70;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      label70:
      break label70;
    }
  }
  
  public yuv a()
  {
    if (this.jdField_a_of_type_Yuv != null) {
      return this.jdField_a_of_type_Yuv;
    }
    yuv localyuv = yuv.a(getPreference().getString("mobileunityversion", ""));
    this.jdField_a_of_type_Yuv = localyuv;
    return localyuv;
  }
  
  public void a(int paramInt, String paramString, yut paramyut)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "saveBannerConfig");
    }
    if (this.mApp == null) {}
    do
    {
      String str;
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(this.mApp.getCurrentAccountUin()));
        if (QLog.isColorLevel()) {
          QLog.d("MobileUnityManager", 2, "saveBannerConfig " + paramString);
        }
        str = pV();
        try
        {
          if (TextUtils.isEmpty(paramString))
          {
            aqhq.deleteFile(str);
            a(null);
            this.jdField_a_of_type_Yut = null;
            return;
          }
        }
        catch (Throwable paramString)
        {
          aqhq.delete(str, true);
          QLog.e("MobileUnityManager", 1, "", paramString);
          return;
        }
      } while (paramyut == null);
      aqhq.createFile(str);
      aqhq.writeFile(str, paramString);
      this.jdField_a_of_type_Yut = paramyut;
      if (QLog.isColorLevel()) {
        QLog.d("MobileUnityManager", 2, "saveBannerConfig date = " + this.jdField_a_of_type_Yut);
      }
      anot.a(this.mApp, "CliOper", "", "", "0X8005B71 ", "0X8005B71 ", 0, 0, "", "", "", "");
      paramString = a();
    } while (paramString == null);
    paramString.KL = 0L;
    paramString.version = paramInt;
    paramString.KM = paramyut.totalNum;
    paramString.cbr = paramyut.cbo;
    paramString.KN = paramyut.cbq;
    a(paramString);
    cmd();
  }
  
  public void a(yuv paramyuv)
  {
    if (paramyuv == null)
    {
      this.jdField_a_of_type_Yuv = null;
      getPreference().edit().remove("mobileunityversion").commit();
      return;
    }
    this.jdField_a_of_type_Yuv = paramyuv;
    getPreference().edit().putString("mobileunityversion", paramyuv.toJson()).commit();
  }
  
  public void bC(Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject4 = null;
    this.bpe = true;
    this.ak = paramBundle;
    Object localObject3;
    int i;
    boolean bool;
    if (paramBundle == null)
    {
      this.bpc = false;
      this.bpd = false;
      this.aj = null;
      localObject3 = null;
      localObject1 = (PhoneContactManagerImp)this.mApp.getManager(11);
      i = ((PhoneContactManagerImp)localObject1).xy();
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (i <= 5))
      {
        bool = true;
        label73:
        if (bool) {
          ((PhoneContactManagerImp)localObject1).i(true, false, 13);
        }
        if (QLog.isColorLevel()) {
          QLog.i("MobileUnityManager", 2, String.format("onGetBindInfo [%s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), localObject3, localObject4, paramBundle }));
        }
      }
    }
    else
    {
      if (paramBundle.getInt("src") != 0) {
        break label413;
      }
      this.aj = paramBundle;
    }
    label413:
    for (Object localObject1 = this.aj.getString("phone");; localObject1 = null)
    {
      if (paramBundle.getInt("need_unify") == 1)
      {
        bool = true;
        this.bpc = bool;
        Bundle[] arrayOfBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
        localObject3 = localObject1;
        if (arrayOfBundle == null) {
          break;
        }
        i = 0;
        label208:
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (i >= arrayOfBundle.length) {
          break;
        }
        localObject4 = arrayOfBundle[i];
        localObject3 = localObject2;
      }
      switch (localObject4.getInt("phone_type"))
      {
      default: 
      case 1: 
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 2: 
        for (localObject3 = localObject2;; localObject3 = localObject4.getString("phone"))
        {
          i += 1;
          localObject2 = localObject3;
          break label208;
          bool = false;
          break;
        }
      }
      if (localObject4.getInt("status") == 2) {}
      for (bool = true;; bool = false)
      {
        this.bpd = bool;
        localObject3 = localObject2;
        break;
      }
      if ((TextUtils.isEmpty((CharSequence)localObject3)) && (i > 5))
      {
        bool = true;
        break label73;
      }
      if ((TextUtils.isEmpty(localObject4)) && (i >= 8))
      {
        bool = true;
        break label73;
      }
      if ((!TextUtils.isEmpty(localObject4)) && (i == 7))
      {
        bool = true;
        break label73;
      }
      bool = false;
      break label73;
    }
  }
  
  public void cmc()
  {
    ThreadManager.post(this.eO, 5, null, false);
  }
  
  public void cmd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "tryShowBanner");
    }
    ThreadManager.getSubThreadHandler().postDelayed(this.eN, 5000L);
  }
  
  public void cmf()
  {
    long l2 = getPreference().getLong("mobileunity_reqtime", 0L);
    long l1 = System.currentTimeMillis();
    l2 = l1 - l2;
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, new Object[] { "getPhoneUnityInfoUnderCtrl ", Long.valueOf(l2) });
    }
    if ((l2 > 3600000L) || (l2 < 0L))
    {
      f(0, 31, null, null);
      getPreference().edit().putLong("mobileunity_reqtime", l1).commit();
    }
  }
  
  public void f(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    acll localacll = (acll)this.mApp.getBusinessHandler(34);
    if (localacll != null) {
      localacll.f(paramInt1, paramInt2, paramString1, paramString2);
    }
  }
  
  public SharedPreferences getPreference()
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("PhoneUnityManager_" + this.mApp.getCurrentAccountUin(), 0);
  }
  
  public void onDestroy() {}
  
  public String pV()
  {
    Object localObject = BaseApplicationImpl.getContext();
    String str = this.mApp.getCurrentAccountUin();
    localObject = ((Context)localObject).getFilesDir().getAbsolutePath() + File.separator + str + ".mobileunity";
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "getBannerConfigFilePath path = " + (String)localObject);
    }
    return localObject;
  }
  
  public int xB()
  {
    return a().version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yuu
 * JD-Core Version:    0.7.0.1
 */