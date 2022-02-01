import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.pb.funcall.VipFunCallAndRing.TSourceInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class aqwu
  implements Manager
{
  public static String cys = "Vip_FunCall";
  public static int edp = -3;
  public static int edq = -6;
  public static int edr = -7;
  public static int mResType = -1;
  aquy jdField_b_of_type_Aquy = new aqwz(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private aqva jdField_b_of_type_Aqva;
  public aqvd c;
  QQAppInterface mApp;
  
  public aqwu(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_b_of_type_Aqva = ((aqva)paramQQAppInterface.getManager(47));
    paramQQAppInterface = new File(igg.gz());
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    Object localObject;
    if (!aFM())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "<<need to copy a default config file.");
      }
      localObject = null;
      paramQQAppInterface = null;
    }
    for (;;)
    {
      try
      {
        localInputStream = this.mApp.getApp().getAssets().open("funcall/vipfuncall_config.json");
        paramQQAppInterface = localInputStream;
        localObject = localInputStream;
        aqhq.a(igg.gz(), new StringBuffer("config.json"), localInputStream);
      }
      catch (IOException localIOException)
      {
        InputStream localInputStream;
        localObject = paramQQAppInterface;
        localIOException.printStackTrace();
        if (paramQQAppInterface == null) {
          continue;
        }
        try
        {
          paramQQAppInterface.close();
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localObject == null) {
          break label168;
        }
      }
      try
      {
        localInputStream.close();
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    try
    {
      ((InputStream)localObject).close();
      label168:
      throw paramQQAppInterface;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    }
    if (localAppRuntime == null)
    {
      QLog.e("VipFunCallManager", 1, "getResIdByUin null == app");
      return 0;
    }
    SharedPreferences localSharedPreferences = a(localAppRuntime, 1, null);
    if (localSharedPreferences == null)
    {
      QLog.e("VipFunCallManager", 1, "getResIdByUin null == sp");
      return 0;
    }
    paramAppRuntime = paramString1;
    int i;
    int j;
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramBoolean) {
        paramAppRuntime = localAppRuntime.getAccount();
      }
    }
    else
    {
      i = localSharedPreferences.getInt(paramAppRuntime + "callId" + paramInt, 0);
      if ((paramBoolean) || (TextUtils.isEmpty(paramString2))) {
        break label377;
      }
      paramAppRuntime = localSharedPreferences.getString("group", null);
      if (TextUtils.isEmpty(paramAppRuntime)) {
        break label372;
      }
      paramAppRuntime = paramAppRuntime.split(",");
      j = 0;
      label146:
      if (j >= paramAppRuntime.length) {
        break label372;
      }
      paramString1 = localSharedPreferences.getString("group_" + paramAppRuntime[j], null);
      if ((TextUtils.isEmpty(paramString1)) || (paramString1.indexOf("-" + paramString2 + "-") <= 0)) {
        break label331;
      }
      paramAppRuntime = paramString1.split(",");
      if (paramAppRuntime.length < 3) {
        break label372;
      }
      if (3 != paramInt) {
        break label324;
      }
      paramAppRuntime = paramAppRuntime[1];
      label245:
      if (TextUtils.isEmpty(paramAppRuntime)) {
        break label369;
      }
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt(paramAppRuntime);
        i = j;
        j = i;
        if (i == 0) {
          j = localSharedPreferences.getInt(localAppRuntime.getAccount() + "callId" + paramInt, 0);
        }
        return j;
      }
      catch (Exception paramAppRuntime)
      {
        label324:
        label331:
        QLog.e("VipFunCallManager", 1, "getResIdByUin err:" + paramAppRuntime.getMessage());
      }
      QLog.e("VipFunCallManager", 1, "getResIdByUin null == uin, isICall = false");
      paramAppRuntime = paramString1;
      break;
      paramAppRuntime = paramAppRuntime[0];
      break label245;
      j += 1;
      break label146;
      label369:
      continue;
      label372:
      paramAppRuntime = null;
      break label245;
      label377:
      j = i;
    }
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    int i = a(paramAppRuntime, 1, null).getInt("uin_fun_call_id_change_" + paramString1 + "_" + paramString2, 2);
    if (i != 0) {
      a(paramAppRuntime, paramString1, 0, paramString2, 0);
    }
    return i;
  }
  
  public static SharedPreferences a(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    }
    if (localAppRuntime == null)
    {
      QLog.e("VipFunCallManager", 1, "getFunCallUinSP app == null");
      return null;
    }
    if (1 == paramInt) {}
    for (paramAppRuntime = "fun_call_uinSp_" + localAppRuntime.getAccount();; paramAppRuntime = "fun_call_appSp")
    {
      Object localObject = paramAppRuntime;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = paramAppRuntime + "_" + paramString;
      }
      return localAppRuntime.getApplication().getSharedPreferences((String)localObject, 4);
    }
  }
  
  public static VipFullScreenVideoView a(Activity paramActivity, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramRelativeLayout == null)) {}
    View localView;
    RelativeLayout.LayoutParams localLayoutParams;
    do
    {
      return null;
      localView = paramActivity.getLayoutInflater().inflate(2131563326, null);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
    } while (paramActivity.isFinishing());
    paramRelativeLayout.addView(localView, 0, localLayoutParams);
    return (VipFullScreenVideoView)localView.findViewById(2131381588);
  }
  
  public static String a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = b(paramAppRuntime, paramInt1, paramInt2, null);
    }
    if (TextUtils.isEmpty(str))
    {
      QLog.e("VipFunCallManager", 1, "getResourcePathByUrl, url=null , id=" + paramInt1 + ", type=" + paramInt2);
      return null;
    }
    paramAppRuntime = str.substring(str.lastIndexOf("/") + 1);
    paramString = igg.gz() + paramInt1 + File.separator;
    return paramString + paramAppRuntime;
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, Bundle paramBundle, VipFunCallAndRing.TSourceInfo paramTSourceInfo, boolean paramBoolean)
  {
    int k = 0;
    int j = -1;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    Object localObject1 = null;
    String str1 = null;
    Object localObject2 = null;
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("callId");
      localObject1 = paramBundle.getString("name");
      k = paramBundle.getInt("ringId");
      j = paramBundle.getInt("feeType");
      str4 = paramBundle.getString("url_Video");
      str3 = paramBundle.getString("url_Fuzz");
      str2 = paramBundle.getString("url_Picture");
      paramTSourceInfo = paramBundle.getString("url_Ring");
      str1 = paramBundle.getString("url_call_thum");
      paramBundle = (Bundle)localObject1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "downloadFCSuit callid=" + paramInt + ", ringid=" + k + ", feeType" + j + ", mediaUrl=" + str4 + ", fuzzImageUrl" + str3 + ", imageUrl=" + str2 + ", ringUrl" + paramTSourceInfo);
      }
      if (i == 0) {}
      do
      {
        return;
        if (paramTSourceInfo == null) {
          break label542;
        }
        str4 = paramTSourceInfo.str_media_url.get();
        str3 = paramTSourceInfo.str_image_url.get();
        str2 = paramTSourceInfo.str_image_url.get();
        localObject1 = paramTSourceInfo.str_ring_url.get();
        paramBundle = paramTSourceInfo.str_fc_name.get();
        str1 = paramTSourceInfo.str_thumb_url.get();
        i = paramInt;
        paramTSourceInfo = (VipFunCallAndRing.TSourceInfo)localObject1;
        break;
        localObject1 = new File(igg.gz() + paramInt + File.separator);
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        localObject1 = a(paramAppRuntime, 0, String.valueOf(paramInt));
        if (localObject1 != null)
        {
          localObject1 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject1).putInt("callId", i);
          ((SharedPreferences.Editor)localObject1).putInt("ringId", k);
          if (j != 0) {
            ((SharedPreferences.Editor)localObject1).putInt("feeType", j);
          }
          if (!TextUtils.isEmpty(paramBundle)) {
            ((SharedPreferences.Editor)localObject1).putString("name", paramBundle);
          }
          ((SharedPreferences.Editor)localObject1).putString("_6", str4);
          ((SharedPreferences.Editor)localObject1).putString("_9", str3);
          ((SharedPreferences.Editor)localObject1).putString("_7", str2);
          ((SharedPreferences.Editor)localObject1).putString("_3", paramTSourceInfo);
          ((SharedPreferences.Editor)localObject1).putString("_8", str1);
          ((SharedPreferences.Editor)localObject1).commit();
        }
        paramAppRuntime = a(paramAppRuntime, 0, null);
      } while (paramAppRuntime == null);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putString("_3_" + k, paramTSourceInfo);
      paramAppRuntime.commit();
      return;
      label542:
      i = paramInt;
      paramBundle = localObject2;
      paramTSourceInfo = (VipFunCallAndRing.TSourceInfo)localObject1;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    a(paramAppRuntime, 1, null).edit().putInt("uin_fun_call_id_change_" + paramString1 + "_" + paramString2, paramInt1).commit();
    if (paramInt2 == 0) {}
    do
    {
      return;
      paramString2 = a(paramAppRuntime, paramInt2, 8, null);
      paramString1 = new File(paramString2);
    } while (aqhq.fileExists(paramString2));
    String str = b(paramAppRuntime, paramInt2, 8, null);
    paramString2 = new Bundle();
    paramString1 = new aquz(str, paramString1);
    ((aqva)paramAppRuntime.getManager(47)).a(1).a(paramString1, null, paramString2);
  }
  
  public static boolean a(Context paramContext, VideoView paramVideoView, String paramString, int paramInt1, aqxa paramaqxa, int paramInt2, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramVideoView == null) || (paramString == null)) {
      return false;
    }
    paramContext = new File(paramString);
    if ((paramContext.exists()) && (!paramVideoView.isPlaying()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "playing[" + paramInt2 + "]");
      }
      if (paramInt1 == 6)
      {
        paramVideoView.setOnTouchListener(new aqwv());
        paramVideoView.setVideoPath(paramContext.getAbsolutePath());
        paramVideoView.requestFocus();
        paramVideoView.setVisibility(0);
        paramVideoView.setOnPreparedListener(new aqww(paramaqxa));
        paramVideoView.setOnCompletionListener(new aqwx(paramVideoView));
        paramVideoView.setOnErrorListener(new aqwy(paramInt2, paramaqxa, paramVideoView, paramBoolean));
        return true;
      }
      if (paramInt1 == 7)
      {
        paramContext = aqcu.decodeFile(paramString);
        if (paramContext != null) {}
        for (paramContext = new BitmapDrawable(paramContext); paramContext != null; paramContext = null)
        {
          paramVideoView = (RelativeLayout)paramVideoView.getParent();
          if (paramVideoView == null) {
            break;
          }
          if (paramaqxa != null) {
            paramaqxa.arP();
          }
          paramVideoView.setBackgroundDrawable(paramContext);
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean aFM()
  {
    return new File(aqwt.cyr).exists();
  }
  
  public static boolean aFN()
  {
    int i = aqiw.getSystemNetwork(null);
    return (1 == i) || (4 == i);
  }
  
  public static String b(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = a(paramAppRuntime, 0, String.valueOf(paramInt1));
    paramAppRuntime = localObject;
    if (localSharedPreferences != null)
    {
      if (paramInt2 <= -1) {
        break label100;
      }
      paramAppRuntime = localSharedPreferences.getString("_" + paramInt2, null);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramAppRuntime)) {
        QLog.e("VipFunCallManager", 1, "getResourceUrl, url=null , id=" + paramInt1 + ", type=" + paramInt2);
      }
      return paramAppRuntime;
      label100:
      paramAppRuntime = localObject;
      if (!TextUtils.isEmpty(paramString)) {
        paramAppRuntime = localSharedPreferences.getString(paramString, null);
      }
    }
  }
  
  public static int e(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, 1, null);
    int i = paramAppRuntime.getInt("last_fun_call_play_id", 0);
    paramAppRuntime.edit().remove("last_fun_call_play_id").commit();
    return i;
  }
  
  public static boolean f(Context paramContext, String paramString, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    boolean bool = aqft.cC();
    Object localObject = paramContext;
    if (bool)
    {
      localObject = paramContext;
      if (paramContext != null) {}
    }
    for (;;)
    {
      try
      {
        localObject = BaseApplicationImpl.sApplication;
        if ((!bool) || (localObject == null)) {
          break label355;
        }
        i = ((Context)localObject).checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
        if (i == 0) {
          bool = true;
        }
      }
      catch (Exception paramContext)
      {
        long l2;
        QLog.e("VipFunCallManager", 1, "isExternalStorageReady have sdCARD:" + bool + ", from:" + paramString + ", lonth=" + (System.currentTimeMillis() - l1) + ", msg=" + paramContext.getMessage());
        return bool;
      }
      try
      {
        l2 = System.currentTimeMillis() - l1;
        if ((QLog.isColorLevel()) || (!bool) || (paramBoolean)) {
          QLog.d("VipFunCallManager", 1, "isExternalStorageReady have sdCARD:" + bool + ", from:" + paramString + ", showLog:" + paramBoolean + ", type=" + i + ", lonth=" + l2);
        }
        aqrm.b("externalStorageType", paramString, i + "_t", l2 + "", bool + "", l2 + "", bool + "_p", "", "", "");
        return bool;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      bool = false;
      continue;
      label355:
      int i = -10;
    }
  }
  
  public static int getResourceType()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "Build.MODEL=[" + Build.MODEL + "],android.os.Build.VERSION.SDK_INT=[" + Build.VERSION.SDK_INT + "]");
    }
    if (mResType < 0) {
      try
      {
        String[] arrayOfString = "R8007,SCH-I869,K-Touch E780,HUAWEI C8812E,AMOI N828,7,8,9,10,11,12,13,HUAWEI Y320-T00,gt-s7568i".split(",");
        int i = 0;
        while (i < arrayOfString.length)
        {
          if ((arrayOfString[i] != null) && ((arrayOfString[i].equalsIgnoreCase(Build.VERSION.SDK_INT + "")) || (arrayOfString[i].equalsIgnoreCase(Build.MODEL)))) {
            mResType = 7;
          }
          i += 1;
        }
        if (mResType >= 0) {
          break label194;
        }
      }
      catch (Exception localException)
      {
        QLog.e("VipFunCallManager", 1, "Build.MODEL=[" + Build.MODEL + "],android.os.Build.VERSION.SDK_INT=[" + Build.VERSION.SDK_INT + "]");
      }
    } else {
      mResType = 6;
    }
    label194:
    return mResType;
  }
  
  public static void i(AppRuntime paramAppRuntime, int paramInt)
  {
    a(paramAppRuntime, 1, null).edit().putInt("last_fun_call_play_id", paramInt).commit();
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt1, String paramString, int paramInt2, int paramInt3, List<Long> paramList, long paramLong)
  {
    Object localObject1 = paramAppRuntime;
    if (paramAppRuntime == null) {
      localObject1 = BaseApplicationImpl.sApplication.getRuntime();
    }
    if (localObject1 == null) {
      QLog.e("VipFunCallManager", 1, "setFunCallData null == app opType=" + paramInt1 + ", callId=" + paramInt2);
    }
    SharedPreferences localSharedPreferences;
    label233:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localSharedPreferences = a((AppRuntime)localObject1, 1, null);
            if (localSharedPreferences == null)
            {
              QLog.e("VipFunCallManager", 1, "setFunCallData null == sp");
              return;
            }
            if (2 != paramInt1) {
              break;
            }
            if (paramInt2 == 0)
            {
              QLog.e("VipFunCallManager", 1, "setGroup callId == 0, opType=SET_DATA_DELET_GROUP");
              return;
            }
            paramList = String.valueOf(paramInt2);
          } while (TextUtils.isEmpty(paramList));
          localObject1 = localSharedPreferences.getString("group", null);
        } while (TextUtils.isEmpty((CharSequence)localObject1));
        localObject2 = ((String)localObject1).split(",");
        paramAppRuntime = "";
        paramInt1 = 0;
        if (paramInt1 < localObject2.length)
        {
          paramString = paramAppRuntime;
          if (!paramList.equals(localObject2[paramInt1]))
          {
            paramString = new StringBuilder().append(paramAppRuntime);
            if (paramAppRuntime.length() <= 0) {
              break label233;
            }
          }
          for (paramAppRuntime = "," + localObject2[paramInt1];; paramAppRuntime = localObject2[paramInt1])
          {
            paramString = paramAppRuntime;
            paramInt1 += 1;
            paramAppRuntime = paramString;
            break;
          }
        }
      } while (((String)localObject1).equals(paramAppRuntime));
      localSharedPreferences.edit().putString("group", paramAppRuntime).commit();
      return;
      if (1 != paramInt1) {
        break;
      }
      if ((paramInt2 == 0) || (paramList == null) || (paramList.size() < 1))
      {
        QLog.e("VipFunCallManager", 1, "setGroup uins.size() < 1 opType=" + paramInt1 + ", callId=" + paramInt2);
        return;
      }
      paramString = String.valueOf(paramInt2);
    } while ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.size() < 1));
    String str1 = localSharedPreferences.getString("group", null);
    Object localObject2 = localSharedPreferences.edit();
    String[] arrayOfString;
    int i;
    int j;
    if (!TextUtils.isEmpty(str1))
    {
      arrayOfString = str1.split(",");
      i = -1;
      paramInt1 = 0;
      j = i;
      if (paramInt1 >= arrayOfString.length) {
        break label622;
      }
      if (paramString.equals(arrayOfString[paramInt1])) {
        j = paramInt1;
      }
      do
      {
        paramInt1 += 1;
        i = j;
        break;
        j = i;
      } while (TextUtils.isEmpty(arrayOfString[paramInt1]));
      localObject1 = localSharedPreferences.getString("group_" + arrayOfString[paramInt1], "");
      Iterator localIterator = paramList.iterator();
      paramAppRuntime = (AppRuntime)localObject1;
      label504:
      if (localIterator.hasNext())
      {
        String str2 = String.valueOf((Long)localIterator.next());
        if (TextUtils.isEmpty(str2)) {
          break label996;
        }
        paramAppRuntime = paramAppRuntime.replace(str2 + "-", "");
      }
    }
    label730:
    label996:
    for (;;)
    {
      break label504;
      j = i;
      if (((String)localObject1).equals(paramAppRuntime)) {
        break;
      }
      ((SharedPreferences.Editor)localObject2).putString("group_" + arrayOfString[paramInt1], paramAppRuntime);
      j = i;
      break;
      j = -1;
      label622:
      if (j < 0) {
        if (TextUtils.isEmpty(str1)) {
          break label730;
        }
      }
      for (paramAppRuntime = str1 + "," + paramString;; paramAppRuntime = paramString)
      {
        ((SharedPreferences.Editor)localObject2).putString("group", paramAppRuntime);
        paramString = paramList.iterator();
        for (paramAppRuntime = "-"; paramString.hasNext(); paramAppRuntime = paramAppRuntime + paramList + "-") {
          paramList = (Long)paramString.next();
        }
      }
      paramAppRuntime = paramInt2 + "," + paramInt3 + "," + paramAppRuntime + "," + paramLong;
      ((SharedPreferences.Editor)localObject2).putString("group_" + paramInt2, paramAppRuntime);
      ((SharedPreferences.Editor)localObject2).commit();
      return;
      if (paramInt1 == 0)
      {
        paramAppRuntime = localSharedPreferences.edit();
        paramAppRuntime.putInt(paramString + "callId" + 6, paramInt2);
        paramAppRuntime.putInt(paramString + "callId" + 9, paramInt2);
        paramAppRuntime.putInt(paramString + "callId" + 7, paramInt2);
        paramAppRuntime.putInt(paramString + "callId" + 3, paramInt3);
        paramAppRuntime.commit();
        return;
      }
      QLog.e("VipFunCallManager", 1, "setFunCallData opType == unknow " + paramInt1);
      return;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, aqvd paramaqvd)
  {
    this.c = paramaqvd;
    int i = getResourceType();
    c(paramInt1, 9, paramBoolean, paramInt3);
    c(paramInt1, i, paramBoolean, paramInt3);
    if (paramInt2 != 0)
    {
      aqpr localaqpr = (aqpr)this.mApp.getManager(45);
      localaqpr.c = paramaqvd;
      localaqpr.a(paramInt2, 3, paramBoolean, paramInt3, "comering");
    }
    if (i == 6) {
      c(paramInt1, 7, false, 0);
    }
    return true;
  }
  
  public void c(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    boolean bool;
    if (this.mApp != null)
    {
      bool = f(this.mApp.getApp(), "VipFunCallManager", false);
      if ((QLog.isColorLevel()) || (!bool)) {
        QLog.d("VipFunCallManager", 2, "startDownload, id=" + paramInt1 + ", resType=" + paramInt2 + ", isIPC=" + paramBoolean + ", srcType=" + paramInt3 + ", haveSDCard=" + bool);
      }
      if (paramInt1 != 0) {
        break label112;
      }
    }
    label112:
    String str1;
    String str2;
    Object localObject;
    label298:
    do
    {
      return;
      bool = false;
      break;
      str1 = b(this.mApp, paramInt1, paramInt2, null);
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("VipFunCallManager", 1, "startDownload error0 url=null, id=" + paramInt1 + ", resType=" + paramInt2 + ", isIPC=" + paramBoolean + ", srcType=" + paramInt3);
        return;
      }
      str2 = a(this.mApp, paramInt1, paramInt2, null);
      if (TextUtils.isEmpty(str2))
      {
        QLog.e("VipFunCallManager", 1, "startDownload error resPath=null, id=" + paramInt1 + ", resType=" + paramInt2 + ", isIPC=" + paramBoolean + ", srcType=" + paramInt3);
        return;
      }
      localObject = new File(str2);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break label519;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "startDownload exists(), id=" + paramInt1 + ", resType=" + paramInt2 + ", isIPC=" + paramBoolean + ", srcType=" + paramInt3 + ", fileExist=" + bool);
      }
    } while ((bool) && (!paramBoolean));
    Bundle localBundle = new Bundle();
    if ((7 != getResourceType()) && (7 == paramInt2)) {}
    for (int i = 0;; i = paramInt2)
    {
      localBundle.putInt("callId", paramInt1);
      localBundle.putString("path", str2);
      localBundle.putBoolean("isIPC", paramBoolean);
      localBundle.putInt("resourceType", paramInt2);
      localBundle.putInt("srcType", paramInt3);
      localBundle.putInt("dealType", i);
      if (bool)
      {
        localBundle.putBoolean("isExists", true);
        localObject = new aquz(str1, (File)localObject);
        ((aquz)localObject).setStatus(3);
        ((aquz)localObject).errCode = 0;
        ((aquz)localObject).dy(localBundle);
        this.jdField_b_of_type_Aquy.onDone((aquz)localObject);
        return;
        label519:
        bool = false;
        break label298;
      }
      if (i == 0)
      {
        label530:
        localObject = new aquz(str1, (File)localObject);
        ((aquz)localObject).bC = 1;
        ((aquz)localObject).atX = 5242880L;
        ((aquz)localObject).cxW = cys;
        if ((9 == paramInt2) || (7 == paramInt2)) {
          if (WebpSoLoader.getDecoderVersion() == null) {
            break label711;
          }
        }
      }
      label711:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((aquz)localObject).cWu = paramBoolean;
        if (7 != paramInt2) {
          ((aquz)localObject).cWl = true;
        }
        this.jdField_b_of_type_Aqva.a(1).a((aquz)localObject, this.jdField_b_of_type_Aquy, localBundle);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VipFunCallManager", 2, "startDownload, id=" + paramInt1 + ", resType=" + paramInt2 + ", url=" + str1);
        return;
        localObject = new File(str2 + ".tmp");
        break label530;
      }
    }
  }
  
  public void onDestroy()
  {
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwu
 * JD-Core Version:    0.7.0.1
 */