import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.subscribe.beans.SerializableMap;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.share.QZoneShareActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import org.json.JSONException;
import org.json.JSONObject;

public class avqq
{
  public static String cNb = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "UploadFail", "上传失败");
  public static int exV;
  private static ConcurrentHashMap<String, OpenID> jZ = new ConcurrentHashMap();
  
  public static OpenID a(AppRuntime paramAppRuntime, String paramString, acci paramacci)
  {
    Object localObject = (OpenID)jZ.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "get openid key = " + paramString);
    }
    paramAppRuntime = (AccountManager)paramAppRuntime.getManager(0);
    localObject = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 8192L;
    localRequestCustomSig.ulSType = 1L;
    localRequestCustomSig.reserved = new byte[0];
    ((HashMap)localObject).put("RequestCustomSig", localRequestCustomSig);
    ((HashMap)localObject).put("OpenAppid", paramString);
    paramAppRuntime.changeToken((HashMap)localObject, new avqr(paramString, paramacci));
    return null;
  }
  
  public static final void a(Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "publishToQzone()");
    }
    if (paramBundle == null)
    {
      QLog.d("QZoneShare", 1, "publishToQzone() params error");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("qzone_uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
    try
    {
      paramBundle = avpw.d.a();
      paramBundle.cMP = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      avpw.a((Activity)paramContext, paramBundle, localIntent, paramInt, paramOnDismissListener);
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle = new Intent(paramContext, TranslucentActivity.class);
      paramBundle.addFlags(268435456);
      paramBundle.putExtras(localIntent);
      paramContext.startActivity(paramBundle);
    }
  }
  
  public static final void a(Context paramContext, String paramString1, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt, String paramString2, String paramString3)
  {
    paramString3 = new QZoneShareData();
    paramString3.mTitle = (paramString2 + acfp.m(2131713361));
    paramString3.mSummary = acfp.m(2131713357);
    paramString3.ER = new ArrayList();
    paramString3.ER.add("https://qzonestyle.gtimg.cn/aoi/sola/20161111222053_4wlQcl1Eta.png");
    paramString3.targetUrl = ("https://h5.qzone.qq.com/redpacket/share?_wv=1&_ws=1&uin=" + paramString1);
    paramString3.from = 0;
    paramString3.cMX = paramString1;
    a(paramContext, paramString1, paramString3, paramOnDismissListener, paramInt);
  }
  
  public static final void a(Context paramContext, String paramString, QZoneShareData paramQZoneShareData, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "shareToQzone()");
    }
    if ((paramContext == null) || (paramQZoneShareData == null))
    {
      QLog.e("QZoneShare", 1, "shareToQzone() params error");
      return;
    }
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
    try
    {
      paramOnDismissListener = new Intent(paramContext, QZoneShareActivity.class);
      paramOnDismissListener.putExtra("qzone_uin", paramString);
      paramOnDismissListener.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
      ((Activity)paramContext).startActivityForResult(paramOnDismissListener, paramInt);
      return;
    }
    catch (Exception paramOnDismissListener)
    {
      paramOnDismissListener = new Intent(paramContext, QZoneShareActivity.class);
      paramOnDismissListener.putExtra("qzone_uin", paramString);
      paramOnDismissListener.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
      paramOnDismissListener.addFlags(268435456);
      paramContext.startActivity(paramOnDismissListener);
    }
  }
  
  public static final void a(Context paramContext, String paramString, QZoneShareData paramQZoneShareData, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "shareToQzone()");
    }
    if ((paramContext == null) || (paramQZoneShareData == null))
    {
      QLog.e("QZoneShare", 1, "shareToQzone() params error");
      return;
    }
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
    try
    {
      Intent localIntent = new Intent(paramContext, QZoneShareActivity.class);
      localIntent.putExtra("qzone_uin", paramString);
      localIntent.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
      localIntent.putExtras(paramBundle);
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle = new Intent(paramContext, QZoneShareActivity.class);
      paramBundle.putExtra("qzone_uin", paramString);
      paramBundle.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
      paramBundle.addFlags(268435456);
      paramContext.startActivity(paramBundle);
    }
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, String paramString9)
  {
    Intent localIntent = new Intent(paramContext, QZoneShareActivity.class);
    localIntent.putExtra("isSharedFromMiniProgram", true);
    localIntent.putExtra("isSharedFromThirdParty", true);
    localIntent.putExtra("miniShareParamAppId", paramString1);
    localIntent.putExtra("miniShareParamTitle", paramString2);
    localIntent.putExtra("miniShareParamDescription", paramString3);
    localIntent.putExtra("miniShareParamShareScene", 3);
    localIntent.putExtra("miniShareParamTemplateType", 1);
    localIntent.putExtra("miniShareParamBusinessType", 0);
    localIntent.putExtra("miniShareParamPicUrl", paramString4);
    localIntent.putExtra("miniShareParamIconUrl", paramString5);
    localIntent.putExtra("miniShareParamJumpUrl", paramString6);
    localIntent.putExtra("miniShareParamVersionType", paramInt);
    localIntent.putExtra("miniShareAppRichId", paramString7);
    localIntent.putExtra("miniSharePkgName", paramString8);
    localIntent.putExtra("miniShareOpenId", paramString9);
    paramContext.startActivity(localIntent);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    a(paramAppInterface, paramContext, paramBundle, paramOnDismissListener, -1);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "publishToQzone()");
    }
    if ((paramBundle == null) || (paramAppInterface == null))
    {
      QLog.d("QZoneShare", 1, "publishToQzone() params error");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("qzone_uin", paramAppInterface.getAccount());
    localIntent.putExtra("key_share_is_third_party", true);
    ArrayList localArrayList = paramBundle.getStringArrayList("images");
    String str1;
    String str2;
    if ((localArrayList != null) && (localArrayList.size() > 9))
    {
      str1 = "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity";
      if (((paramContext instanceof Activity)) && (((Activity)paramContext).getIntent() != null))
      {
        localIntent.putExtra("qq_camera_scheme", ((Activity)paramContext).getIntent().getStringExtra("qq_camera_scheme"));
        localIntent.putExtra("qq_camera_top_title", ((Activity)paramContext).getIntent().getStringExtra("qq_camera_top_title"));
      }
      str2 = paramBundle.getString("hulian_appid");
      String str3 = paramBundle.getString("file_send_path");
      if ((!td(str2)) && (((localArrayList != null) && (localArrayList.size() > 0)) || (!TextUtils.isEmpty(str3))))
      {
        paramBundle.putString("summary", "");
        paramBundle.putString("defaultText", "");
      }
      if (!TextUtils.isEmpty(str2))
      {
        if (TextUtils.isEmpty(str3)) {
          break label347;
        }
        paramBundle.putInt("key_upload_entrance", 207);
        paramBundle.putString("refer", str2);
      }
    }
    for (;;)
    {
      localIntent.putExtras(paramBundle);
      QzonePluginProxyActivity.x(localIntent, str1);
      localIntent.putExtra("key_share_is_third_party", true);
      com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
      try
      {
        paramBundle = avpw.d.a();
        paramBundle.cMP = paramAppInterface.getCurrentAccountUin();
        avpw.a((Activity)paramContext, paramBundle, localIntent, paramInt, paramOnDismissListener);
        return;
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface = new Intent(paramContext, TranslucentActivity.class);
        paramAppInterface.addFlags(268435456);
        paramAppInterface.putExtras(localIntent);
        paramContext.startActivity(paramAppInterface);
        return;
      }
      str1 = "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity";
      break;
      label347:
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramBundle.putInt("key_upload_entrance", 45);
        paramBundle.putString("refer", str2);
      }
    }
  }
  
  @Deprecated
  public static final boolean a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return a(paramAppInterface, paramContext, paramBundle, paramOnDismissListener, -1);
  }
  
  @Deprecated
  public static final boolean a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    return a(paramAppInterface.getCurrentAccountUin(), paramContext, paramBundle, paramOnDismissListener, paramInt);
  }
  
  @Deprecated
  public static final boolean a(String paramString, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (paramBundle == null) {
      return false;
    }
    Object localObject1 = paramBundle.getString("title");
    Object localObject2 = paramBundle.getString("desc");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2)) && (!paramBundle.getBoolean("is_share_mini_app_msg")))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("qzone_uin", paramString);
      ((Intent)localObject1).putExtra("key_share_is_third_party", true);
      ((Intent)localObject1).putExtra("share_data", paramBundle);
      ((Intent)localObject1).addFlags(67108864);
      ((Intent)localObject1).addFlags(268435456);
      QzonePluginProxyActivity.x((Intent)localObject1, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
      try
      {
        paramBundle = avpw.d.a();
        paramBundle.cMP = paramString;
        avpw.a((Activity)paramContext, paramBundle, (Intent)localObject1, paramInt, paramOnDismissListener);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = new Intent(paramContext, TranslucentActivity.class);
          paramString.addFlags(268435456);
          paramString.putExtras((Intent)localObject1);
          paramContext.startActivity(paramString);
        }
      }
    }
    r(paramBundle);
    paramOnDismissListener = paramBundle.getString("open_id");
    localObject1 = paramBundle.getString("pkg_name");
    if (paramBundle.getBoolean("is_share_mini_app_msg"))
    {
      paramString = paramBundle.getString("title");
      localObject2 = paramBundle.getString("desc");
      String str1 = paramBundle.getString("share_mini_app_id");
      String str2 = paramBundle.getString("share_mini_app_path");
      a(paramContext, str1, paramString, (String)localObject2, paramBundle.getString("share_mini_image_url"), null, str2, paramBundle.getInt("share_mini_ver_type"), String.valueOf(paramBundle.getLong("req_share_id", -1L)), (String)localObject1, paramOnDismissListener);
      return true;
    }
    localObject2 = (OpenSdkShareModel)paramBundle.getParcelable("KEY_MINI_PROGRAM_SHARE_OBJ");
    if (localObject2 != null)
    {
      a(paramContext, ((OpenSdkShareModel)localObject2).miniAppAppid, ((OpenSdkShareModel)localObject2).title, ((OpenSdkShareModel)localObject2).desc, ((OpenSdkShareModel)localObject2).imageUrl, ((OpenSdkShareModel)localObject2).iconUrl, ((OpenSdkShareModel)localObject2).miniAppPath, 3, ((OpenSdkShareModel)localObject2).appRichId, (String)localObject1, paramOnDismissListener);
      return true;
    }
    paramOnDismissListener = new QZoneShareData();
    paramOnDismissListener.mTitle = paramBundle.getString("title");
    paramOnDismissListener.mSummary = paramBundle.getString("desc");
    paramOnDismissListener.ER = paramBundle.getStringArrayList("image_url");
    paramOnDismissListener.extString = paramBundle.getString("share_qq_ext_str");
    paramOnDismissListener.appid = paramBundle.getLong("req_share_id");
    paramOnDismissListener.openId = paramBundle.getString("open_id");
    paramOnDismissListener.appName = paramBundle.getString("app_name");
    paramOnDismissListener.targetUrl = paramBundle.getString("detail_url");
    paramOnDismissListener.iUrlInfoFrm = paramBundle.getInt("iUrlInfoFrm", -1);
    paramOnDismissListener.azQ = paramBundle.getLong("share_begin_time", 0L);
    localObject1 = (SerializableMap)paramBundle.getSerializable("share_qzone_info");
    if (localObject1 != null) {
      paramOnDismissListener.qc = ((SerializableMap)localObject1).getMap();
    }
    if (paramBundle.getBoolean("thirdPartShare")) {
      paramOnDismissListener.from = 1;
    }
    for (;;)
    {
      paramOnDismissListener.action = paramBundle.getString("share_action");
      paramOnDismissListener.cMY = paramBundle.getString("jfrom");
      paramOnDismissListener.pkgname = paramBundle.getString("pkg_name");
      paramOnDismissListener.cMX = paramBundle.getString("share_uin");
      paramOnDismissListener.cNa = paramBundle.getString("shareCurUrl");
      paramOnDismissListener.cMZ = paramBundle.getString("default_text");
      a(paramContext, paramString, paramOnDismissListener, paramBundle, paramInt);
      return true;
      if (paramBundle.getBoolean("from_web")) {
        paramOnDismissListener.from = 2;
      } else {
        paramOnDismissListener.from = 0;
      }
    }
  }
  
  public static final ArrayList<String> b(ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    exV = 0;
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        Object localObject2 = (String)paramArrayList.get(i);
        if (!ahbj.isFileExists((String)localObject2)) {
          break label447;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneShare", 4, "local url:" + (String)localObject2);
        }
        Object localObject1 = localObject2;
        if (ahbj.getFileSize((String)localObject2) > 2097152L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 4, "file length:" + ahbj.getFileSize((String)localObject2));
          }
          localObject2 = c((String)localObject2, i);
          if (localObject2 == null) {
            break;
          }
          localObject1 = ((File)localObject2).getAbsolutePath();
          localArrayList.add(localObject2);
        }
        localObject2 = new HashMap();
        ((Map)localObject2).put("Connection", "keep-alive");
        ((Map)localObject2).put("Referer", "https://www.qq.com");
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("type", paramString3);
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("share_image", localObject1);
        localObject1 = jqc.a(MsfSdkUtils.insertMtype("qzPicu", "https://cgi.connect.qq.com/qqconnectopen/upload_share_image"), "cgi.connect.qq.com", paramString1, paramString2, localHashMap1, localHashMap2, (Map)localObject2, true);
        if (localObject1 == null) {
          break label447;
        }
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject1).getInt("retcode") == 0)
          {
            localObject1 = ((JSONObject)localObject1).getJSONObject("result");
            if (localObject1 != null)
            {
              paramArrayList.set(i, ((JSONObject)localObject1).getString("url"));
              if (QLog.isColorLevel()) {
                QLog.d("QZoneShare", 4, "target url:" + ((JSONObject)localObject1).getString("url"));
              }
            }
          }
          else
          {
            exV = ((JSONObject)localObject1).getInt("retcode");
            QLog.d("QZoneShare", 1, "upload fail, code = " + exV);
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            break label447;
          }
        }
        QLog.d("QZoneShare", 4, localJSONException.getMessage());
        break label447;
      }
      fr(localArrayList);
      return paramArrayList;
      label447:
      i += 1;
    }
  }
  
  /* Error */
  public static File c(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: invokestatic 655	ahbj:getFileDirectoryOf	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore 5
    //   11: aload_0
    //   12: invokestatic 658	ahbj:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 6
    //   17: new 660	android/graphics/BitmapFactory$Options
    //   20: dup
    //   21: invokespecial 661	android/graphics/BitmapFactory$Options:<init>	()V
    //   24: astore_2
    //   25: aload_2
    //   26: iconst_1
    //   27: putfield 664	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   30: aload_0
    //   31: aload_2
    //   32: invokestatic 670	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   35: pop
    //   36: aload_2
    //   37: aload_2
    //   38: sipush 640
    //   41: sipush 640
    //   44: invokestatic 674	avqq:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   47: putfield 677	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   50: aload_2
    //   51: iconst_0
    //   52: putfield 664	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   55: aload_0
    //   56: aload_2
    //   57: invokestatic 670	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: astore_0
    //   61: aload_3
    //   62: astore_2
    //   63: aload_0
    //   64: ifnull +85 -> 149
    //   67: aload_3
    //   68: astore_2
    //   69: aload 5
    //   71: ifnull +78 -> 149
    //   74: aload_0
    //   75: astore_2
    //   76: new 578	java/io/File
    //   79: dup
    //   80: aload 5
    //   82: new 59	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   89: iload_1
    //   90: invokevirtual 641	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: aload 6
    //   95: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 679	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: astore_3
    //   105: aload_0
    //   106: astore_2
    //   107: new 681	java/io/FileOutputStream
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 684	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   115: astore 5
    //   117: aload_0
    //   118: astore_2
    //   119: aload_0
    //   120: getstatic 690	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   123: bipush 50
    //   125: aload 5
    //   127: invokevirtual 696	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   130: ifeq +10 -> 140
    //   133: aload_0
    //   134: astore_2
    //   135: aload 5
    //   137: invokevirtual 699	java/io/FileOutputStream:flush	()V
    //   140: aload_0
    //   141: astore_2
    //   142: aload 5
    //   144: invokevirtual 702	java/io/FileOutputStream:close	()V
    //   147: aload_3
    //   148: astore_2
    //   149: aload_2
    //   150: astore_3
    //   151: aload_0
    //   152: ifnull +21 -> 173
    //   155: aload_2
    //   156: astore_3
    //   157: aload_0
    //   158: invokevirtual 705	android/graphics/Bitmap:isRecycled	()Z
    //   161: ifne +12 -> 173
    //   164: aload_0
    //   165: invokevirtual 708	android/graphics/Bitmap:recycle	()V
    //   168: invokestatic 713	java/lang/System:gc	()V
    //   171: aload_2
    //   172: astore_3
    //   173: aload_3
    //   174: areturn
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_0
    //   178: aload_0
    //   179: astore_2
    //   180: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +15 -> 198
    //   186: aload_0
    //   187: astore_2
    //   188: ldc 57
    //   190: iconst_2
    //   191: ldc_w 715
    //   194: aload_3
    //   195: invokestatic 718	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   198: aload 4
    //   200: astore_3
    //   201: aload_0
    //   202: ifnull -29 -> 173
    //   205: aload 4
    //   207: astore_3
    //   208: aload_0
    //   209: invokevirtual 705	android/graphics/Bitmap:isRecycled	()Z
    //   212: ifne -39 -> 173
    //   215: aload_0
    //   216: invokevirtual 708	android/graphics/Bitmap:recycle	()V
    //   219: invokestatic 713	java/lang/System:gc	()V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_3
    //   225: aconst_null
    //   226: astore_0
    //   227: aload_0
    //   228: astore_2
    //   229: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +15 -> 247
    //   235: aload_0
    //   236: astore_2
    //   237: ldc 57
    //   239: iconst_2
    //   240: ldc_w 720
    //   243: aload_3
    //   244: invokestatic 718	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload 4
    //   249: astore_3
    //   250: aload_0
    //   251: ifnull -78 -> 173
    //   254: aload 4
    //   256: astore_3
    //   257: aload_0
    //   258: invokevirtual 705	android/graphics/Bitmap:isRecycled	()Z
    //   261: ifne -88 -> 173
    //   264: aload_0
    //   265: invokevirtual 708	android/graphics/Bitmap:recycle	()V
    //   268: invokestatic 713	java/lang/System:gc	()V
    //   271: aconst_null
    //   272: areturn
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_2
    //   276: aload_2
    //   277: ifnull +17 -> 294
    //   280: aload_2
    //   281: invokevirtual 705	android/graphics/Bitmap:isRecycled	()Z
    //   284: ifne +10 -> 294
    //   287: aload_2
    //   288: invokevirtual 708	android/graphics/Bitmap:recycle	()V
    //   291: invokestatic 713	java/lang/System:gc	()V
    //   294: aload_0
    //   295: athrow
    //   296: astore_0
    //   297: goto -21 -> 276
    //   300: astore_3
    //   301: goto -74 -> 227
    //   304: astore_3
    //   305: goto -127 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramString	String
    //   0	308	1	paramInt	int
    //   24	264	2	localObject1	Object
    //   4	170	3	localObject2	Object
    //   175	20	3	localException1	Exception
    //   200	8	3	localObject3	Object
    //   224	20	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   249	8	3	localObject4	Object
    //   300	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   304	1	3	localException2	Exception
    //   1	254	4	localObject5	Object
    //   9	134	5	localObject6	Object
    //   15	79	6	str	String
    // Exception table:
    //   from	to	target	type
    //   17	61	175	java/lang/Exception
    //   17	61	224	java/lang/OutOfMemoryError
    //   17	61	273	finally
    //   76	105	296	finally
    //   107	117	296	finally
    //   119	133	296	finally
    //   135	140	296	finally
    //   142	147	296	finally
    //   180	186	296	finally
    //   188	198	296	finally
    //   229	235	296	finally
    //   237	247	296	finally
    //   76	105	300	java/lang/OutOfMemoryError
    //   107	117	300	java/lang/OutOfMemoryError
    //   119	133	300	java/lang/OutOfMemoryError
    //   135	140	300	java/lang/OutOfMemoryError
    //   142	147	300	java/lang/OutOfMemoryError
    //   76	105	304	java/lang/Exception
    //   107	117	304	java/lang/Exception
    //   119	133	304	java/lang/Exception
    //   135	140	304	java/lang/Exception
    //   142	147	304	java/lang/Exception
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    int i = paramOptions.outWidth;
    if ((j > paramInt2) || (i > paramInt1))
    {
      paramInt2 = Math.round(j / paramInt2);
      paramInt1 = Math.round(i / paramInt1);
      if (paramInt2 < paramInt1) {
        paramInt1 = paramInt2;
      }
    }
    for (;;)
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = 2;
      }
      return paramInt2;
      continue;
      paramInt1 = 2;
    }
  }
  
  public static final long d(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return 0L;
      paramIntent = paramIntent.getBundleExtra("share_data");
    } while (paramIntent == null);
    return paramIntent.getLong("req_share_id", 0L);
  }
  
  public static void fr(ArrayList<File> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        ahbj.deleteFile((File)localIterator.next());
      }
      paramArrayList.clear();
    }
  }
  
  private static boolean isValidUrl(String paramString)
  {
    return (jqc.isValidUrl(paramString)) || ((paramString != null) && (paramString.startsWith("avatar://")));
  }
  
  public static final Bundle q(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getStringArrayList("image_url");
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        String str = (String)localArrayList.get(i);
        if ((!isValidUrl(str)) && (!ahbj.isFileExists(str))) {
          localArrayList.remove(i);
        }
        i -= 1;
      }
      while (localArrayList.size() > 9) {
        localArrayList.remove(9);
      }
      if (localArrayList.size() > 0)
      {
        if (isValidUrl((String)localArrayList.get(0)))
        {
          i = localArrayList.size() - 1;
          while (i >= 0)
          {
            if (!isValidUrl((String)localArrayList.get(i))) {
              localArrayList.remove(i);
            }
            i -= 1;
          }
        }
        i = localArrayList.size() - 1;
        while (i >= 0)
        {
          if (i != 0) {
            localArrayList.remove(i);
          }
          i -= 1;
        }
      }
      paramBundle.putStringArrayList("image_url", localArrayList);
    }
    return paramBundle;
  }
  
  public static final Bundle r(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("desc");
    ArrayList localArrayList = paramBundle.getStringArrayList("image_url");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (localArrayList != null) && (!localArrayList.isEmpty())) {
      paramBundle.remove("detail_url");
    }
    q(paramBundle);
    return paramBundle;
  }
  
  public static boolean td(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "sharewhitelist", "100733645,1101218289,100497308,1103394134,1106611629,1105705811,1104466820");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.equals(localObject[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(boolean paramBoolean, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avqq
 * JD-Core Version:    0.7.0.1
 */