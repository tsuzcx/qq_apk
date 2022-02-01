import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper.2;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class akks
{
  protected static void C(Context paramContext, String paramString1, String paramString2)
  {
    ajoz localajoz = ajoz.a(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    if (localajoz != null)
    {
      if (ajoz.bt(paramContext))
      {
        bJ(paramContext, localajoz.btnUrl);
        return;
      }
      localajoz.d1 = bo(paramString1, paramString2);
      paramContext = new akkm(paramContext);
      paramContext.a(localajoz);
      paramContext.show();
      return;
    }
    QLog.d("NearbyPublishMenuHelper", 1, "cikeData == null");
  }
  
  protected static void D(Context paramContext, String paramString1, String paramString2)
  {
    arhz localarhz = new arhz(paramContext, paramContext.getResources().getDimensionPixelSize(2131299627));
    localarhz.setMessage(2131695695);
    ThreadManager.post(new NearbyPublishMenuHelper.2(localarhz, paramString2, paramContext, paramString1), 5, null, true);
  }
  
  public static void a(Context paramContext, akkq.a parama, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "handleMenuItemClick：id=" + parama.id);
    }
    switch (parama.id)
    {
    default: 
      bJ(paramContext, parama.jumpUrl);
      return;
    case 1: 
      eI(paramContext);
      return;
    case 2: 
      eJ(paramContext);
      return;
    case 3: 
      reportClick(paramString, "pub_txt_clk");
      C(paramContext, paramString, "pub_txt_clk");
      return;
    case 4: 
      reportClick(paramString, "pub_voice_clk");
      C(paramContext, paramString, "pub_voice_clk");
      return;
    }
    reportClick(paramString, "pub_video_clk");
    C(paramContext, paramString, "pub_video_clk");
  }
  
  public static void bJ(Context paramContext, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "doJump, url=" + paramString);
      }
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramString.startsWith("http"))
      {
        Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        ocp.f(localIntent, paramString);
        paramContext.startActivity(localIntent);
        return;
      }
      if (paramString.startsWith("mqqapi"))
      {
        paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramString)));
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("NearbyPublishMenuHelper", 1, "doJump exp=" + paramContext.toString());
      return;
    }
    if (paramString.startsWith("tlitenow")) {
      paramContext.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(paramString)));
    }
  }
  
  protected static String bo(String paramString1, String paramString2)
  {
    int i;
    if ("pub_voice_clk".equals(paramString2)) {
      i = 1;
    }
    for (;;)
    {
      int j = i;
      if (i != 0)
      {
        if (!"home".equals(paramString1)) {
          break label107;
        }
        j = i;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyPublishMenuHelper", 2, "getReportD1=" + j);
        }
        return j + "";
        if ("pub_txt_clk".equals(paramString2))
        {
          i = 2;
          break;
        }
        if (!"pub_video_clk".equals(paramString2)) {
          break label128;
        }
        i = 3;
        break;
        label107:
        if ("data_card".equals(paramString1)) {
          j = i + 3;
        } else {
          j = 0;
        }
      }
      label128:
      i = 0;
    }
  }
  
  public static void c(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "onActivityResult, reqCode=" + paramInt1 + ", retCode=" + paramInt2);
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1001) {
        break label133;
      }
      paramIntent = getDefaultSharedPreferences(paramContext);
      str = paramIntent.getString("camera_photo_path", "");
      QLog.d("NearbyPublishMenuHelper", 1, "camera result, path=" + str);
      paramIntent.edit().remove("camera_photo_path").commit();
      if (!TextUtils.isEmpty(str)) {
        break label123;
      }
    }
    label123:
    while (paramInt1 != 1000)
    {
      String str;
      return;
      D(paramContext, "https://nearby.qq.com/nearby-topic/release.html?_bid=3203&from=3&getImageType=2", str);
      return;
    }
    label133:
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");; paramIntent = null)
    {
      if ((paramIntent != null) && (paramIntent.size() != 0)) {
        break label184;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NearbyPublishMenuHelper", 2, "path is empty return");
      return;
    }
    label184:
    QLog.d("NearbyPublishMenuHelper", 1, "select photo result, path=" + (String)paramIntent.get(0));
    D(paramContext, "https://nearby.qq.com/nearby-topic/release.html?_bid=3203&from=3&getImageType=2", (String)paramIntent.get(0));
  }
  
  public static ArrayList<akkq.a> dm()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = (String)ajrb.c(((AppRuntime)localObject1).getAccount(), "key_nearby_publish_menu", "");
    if (!TextUtils.isEmpty((String)ajrb.c(((AppRuntime)localObject1).getAccount(), "cike_guide_content", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "parseMenuItems, menuCfg=" + (String)localObject2 + ", hasDialogCfg=" + bool);
      }
      for (;;)
      {
        try
        {
          localObject1 = new JSONArray((String)localObject2);
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            akkq.a locala2 = new akkq.a();
            locala2.id = ((JSONObject)localObject2).optInt("id");
            if ((!bool) && (locala2.id != 1) && (locala2.id != 2)) {
              break label351;
            }
            locala2.iconUrl = ((JSONObject)localObject2).optString("icon");
            locala2.title = ((JSONObject)localObject2).optString("title");
            locala2.subTitle = ((JSONObject)localObject2).optString("subTitle");
            locala2.jumpUrl = ((JSONObject)localObject2).optString("jumpUrl");
            localArrayList.add(locala2);
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyPublishMenuHelper", 2, "handleTakePhotoBack, exp=" + localException.toString());
          }
          if (localArrayList.size() == 0)
          {
            akkq.a locala1 = new akkq.a();
            locala1.id = 1;
            locala1.iconResId = 2130842173;
            locala1.title = acfp.m(2131708926);
            localArrayList.add(locala1);
            locala1 = new akkq.a();
            locala1.id = 2;
            locala1.iconResId = 2130842172;
            locala1.title = acfp.m(2131708927);
            localArrayList.add(locala1);
          }
          return localArrayList;
        }
        label351:
        i += 1;
      }
    }
  }
  
  protected static void eI(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPublishMenuHelper", 2, "selectPic");
    }
    Object localObject = null;
    if ((paramContext instanceof AppActivity)) {
      localObject = (AppActivity)paramContext;
    }
    if (localObject == null) {
      return;
    }
    localObject = new Intent(paramContext, NewPhotoListActivity.class);
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject).putExtra("PeakConstants.showGifTypeIcon", true);
    ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
    ((Intent)localObject).putExtra("imageSizeLimit", 8388608);
    ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    ((Intent)localObject).putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    ((Intent)localObject).putExtra("enter_from", 30);
    paramContext.startActivity((Intent)localObject);
  }
  
  protected static void eJ(Context paramContext)
  {
    if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext())) {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "Camera used return");
      }
    }
    label322:
    label327:
    for (;;)
    {
      return;
      Object localObject1 = new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "photo/"));
      if ((!((File)localObject1).exists()) && (!((File)localObject1).mkdirs()))
      {
        QQToast.a(paramContext, 2131719242, 0).show();
        if (QLog.isColorLevel()) {
          QLog.d("NearbyPublishMenuHelper", 2, "sdcard not exist return");
        }
      }
      else
      {
        String str = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "photo/" + System.currentTimeMillis() + ".jpg");
        Intent localIntent = new Intent();
        FileProvider7Helper.setSystemCapture(BaseApplicationImpl.getContext(), new File(str), localIntent);
        if ((paramContext instanceof AppActivity)) {}
        Object localObject2;
        for (localObject1 = (AppActivity)paramContext;; localObject2 = null)
        {
          if (localObject1 == null) {
            break label327;
          }
          if ((Build.VERSION.SDK_INT >= 23) && (((AppActivity)localObject1).checkSelfPermission("android.permission.CAMERA") != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("NearbyPublishMenuHelper", 2, "requestPermissions");
            }
            ((AppActivity)localObject1).requestPermissions(new akkt(paramContext, str, (AppActivity)localObject1, localIntent), 1, new String[] { "android.permission.CAMERA" });
          }
          for (int i = 1;; i = 0) {
            for (;;)
            {
              if (i != 0) {
                break label322;
              }
              try
              {
                getDefaultSharedPreferences(paramContext).edit().putString("camera_photo_path", str).commit();
                ((AppActivity)localObject1).startActivityForResult(localIntent, 1001);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("NearbyPublishMenuHelper", 2, "takePhoto");
                return;
              }
              catch (Exception localException)
              {
                QLog.e("NearbyPublishMenuHelper", 1, localException, new Object[0]);
                QQToast.a(paramContext, 2131691243, 0).show();
                return;
              }
            }
          }
          break;
        }
      }
    }
  }
  
  /* Error */
  public static void gP(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload 7
    //   11: astore 5
    //   13: aload 6
    //   15: astore 4
    //   17: new 113	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 507
    //   27: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_0
    //   31: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore_0
    //   38: aload 7
    //   40: astore 5
    //   42: aload 6
    //   44: astore 4
    //   46: aload_1
    //   47: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifeq +35 -> 85
    //   53: aload 7
    //   55: astore 5
    //   57: aload 6
    //   59: astore 4
    //   61: invokestatic 12	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   64: aload_0
    //   65: invokevirtual 510	com/tencent/common/app/BaseApplicationImpl:deleteFile	(Ljava/lang/String;)Z
    //   68: pop
    //   69: iconst_0
    //   70: ifeq +11 -> 81
    //   73: new 512	java/lang/NullPointerException
    //   76: dup
    //   77: invokespecial 513	java/lang/NullPointerException:<init>	()V
    //   80: athrow
    //   81: ldc 2
    //   83: monitorexit
    //   84: return
    //   85: aload 7
    //   87: astore 5
    //   89: aload 6
    //   91: astore 4
    //   93: invokestatic 458	java/lang/System:currentTimeMillis	()J
    //   96: lstore_2
    //   97: aload 7
    //   99: astore 5
    //   101: aload 6
    //   103: astore 4
    //   105: invokestatic 12	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   108: aload_0
    //   109: iconst_0
    //   110: invokevirtual 517	com/tencent/common/app/BaseApplicationImpl:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   113: astore_0
    //   114: aload_0
    //   115: astore 5
    //   117: aload_0
    //   118: astore 4
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 521	java/lang/String:getBytes	()[B
    //   125: invokevirtual 527	java/io/FileOutputStream:write	([B)V
    //   128: aload_0
    //   129: astore 5
    //   131: aload_0
    //   132: astore 4
    //   134: aload_0
    //   135: invokevirtual 530	java/io/FileOutputStream:flush	()V
    //   138: aload_0
    //   139: astore 5
    //   141: aload_0
    //   142: astore 4
    //   144: ldc 62
    //   146: iconst_1
    //   147: new 113	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 532
    //   157: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokestatic 458	java/lang/System:currentTimeMillis	()J
    //   163: lload_2
    //   164: lsub
    //   165: invokevirtual 461	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   168: ldc_w 534
    //   171: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_1
    //   175: invokevirtual 535	java/lang/String:length	()I
    //   178: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_0
    //   188: ifnull -107 -> 81
    //   191: aload_0
    //   192: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   195: goto -114 -> 81
    //   198: astore_0
    //   199: goto -118 -> 81
    //   202: astore_0
    //   203: aload 5
    //   205: astore 4
    //   207: ldc 62
    //   209: iconst_1
    //   210: new 113	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 540
    //   220: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: invokevirtual 212	java/lang/Exception:toString	()Ljava/lang/String;
    //   227: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 5
    //   238: ifnull -157 -> 81
    //   241: aload 5
    //   243: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   246: goto -165 -> 81
    //   249: astore_0
    //   250: goto -169 -> 81
    //   253: astore_0
    //   254: aload 4
    //   256: ifnull +8 -> 264
    //   259: aload 4
    //   261: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   264: aload_0
    //   265: athrow
    //   266: astore_0
    //   267: ldc 2
    //   269: monitorexit
    //   270: aload_0
    //   271: athrow
    //   272: astore_0
    //   273: goto -192 -> 81
    //   276: astore_1
    //   277: goto -13 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramString1	String
    //   0	280	1	paramString2	String
    //   96	68	2	l	long
    //   15	245	4	localObject1	Object
    //   11	231	5	localObject2	Object
    //   4	98	6	localObject3	Object
    //   7	91	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   191	195	198	java/lang/Exception
    //   17	38	202	java/lang/Exception
    //   46	53	202	java/lang/Exception
    //   61	69	202	java/lang/Exception
    //   93	97	202	java/lang/Exception
    //   105	114	202	java/lang/Exception
    //   120	128	202	java/lang/Exception
    //   134	138	202	java/lang/Exception
    //   144	187	202	java/lang/Exception
    //   241	246	249	java/lang/Exception
    //   17	38	253	finally
    //   46	53	253	finally
    //   61	69	253	finally
    //   93	97	253	finally
    //   105	114	253	finally
    //   120	128	253	finally
    //   134	138	253	finally
    //   144	187	253	finally
    //   207	236	253	finally
    //   73	81	266	finally
    //   191	195	266	finally
    //   241	246	266	finally
    //   259	264	266	finally
    //   264	266	266	finally
    //   73	81	272	java/lang/Exception
    //   259	264	276	java/lang/Exception
  }
  
  public static SharedPreferences getDefaultSharedPreferences(Context paramContext)
  {
    return paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 4);
  }
  
  /* Error */
  public static String mu(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aload 6
    //   11: astore 4
    //   13: aload 5
    //   15: astore_3
    //   16: invokestatic 458	java/lang/System:currentTimeMillis	()J
    //   19: lstore_1
    //   20: aload 6
    //   22: astore 4
    //   24: aload 5
    //   26: astore_3
    //   27: new 113	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 507
    //   37: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 7
    //   49: aload 6
    //   51: astore 4
    //   53: aload 5
    //   55: astore_3
    //   56: new 422	java/io/File
    //   59: dup
    //   60: invokestatic 12	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   63: invokevirtual 554	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   66: aload 7
    //   68: invokespecial 557	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore_0
    //   72: aload 6
    //   74: astore 4
    //   76: aload 5
    //   78: astore_3
    //   79: aload_0
    //   80: invokevirtual 560	java/io/File:isFile	()Z
    //   83: ifeq +19 -> 102
    //   86: aload 6
    //   88: astore 4
    //   90: aload 5
    //   92: astore_3
    //   93: aload_0
    //   94: invokevirtual 562	java/io/File:length	()J
    //   97: lconst_0
    //   98: lcmp
    //   99: ifne +61 -> 160
    //   102: aload 6
    //   104: astore 4
    //   106: aload 5
    //   108: astore_3
    //   109: ldc 62
    //   111: iconst_1
    //   112: new 113	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 564
    //   122: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: invokevirtual 567	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   129: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: ldc 232
    //   140: astore_3
    //   141: aload_3
    //   142: astore_0
    //   143: iconst_0
    //   144: ifeq +11 -> 155
    //   147: new 512	java/lang/NullPointerException
    //   150: dup
    //   151: invokespecial 513	java/lang/NullPointerException:<init>	()V
    //   154: athrow
    //   155: ldc 2
    //   157: monitorexit
    //   158: aload_0
    //   159: areturn
    //   160: aload 6
    //   162: astore 4
    //   164: aload 5
    //   166: astore_3
    //   167: invokestatic 12	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   170: aload 7
    //   172: invokevirtual 571	com/tencent/common/app/BaseApplicationImpl:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   175: astore 5
    //   177: aload 5
    //   179: astore 4
    //   181: aload 5
    //   183: astore_3
    //   184: aload_0
    //   185: invokevirtual 562	java/io/File:length	()J
    //   188: l2i
    //   189: newarray byte
    //   191: astore_0
    //   192: aload 5
    //   194: astore 4
    //   196: aload 5
    //   198: astore_3
    //   199: aload 5
    //   201: aload_0
    //   202: invokevirtual 577	java/io/FileInputStream:read	([B)I
    //   205: pop
    //   206: aload 5
    //   208: astore 4
    //   210: aload 5
    //   212: astore_3
    //   213: ldc 62
    //   215: iconst_1
    //   216: new 113	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 579
    //   226: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokestatic 458	java/lang/System:currentTimeMillis	()J
    //   232: lload_1
    //   233: lsub
    //   234: invokevirtual 461	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   237: ldc_w 534
    //   240: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_0
    //   244: arraylength
    //   245: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload 5
    //   256: astore 4
    //   258: aload 5
    //   260: astore_3
    //   261: new 168	java/lang/String
    //   264: dup
    //   265: aload_0
    //   266: invokespecial 581	java/lang/String:<init>	([B)V
    //   269: astore 6
    //   271: aload 6
    //   273: astore_0
    //   274: aload 5
    //   276: ifnull -121 -> 155
    //   279: aload 5
    //   281: invokevirtual 582	java/io/FileInputStream:close	()V
    //   284: aload 6
    //   286: astore_0
    //   287: goto -132 -> 155
    //   290: astore_0
    //   291: aload 6
    //   293: astore_0
    //   294: goto -139 -> 155
    //   297: astore_0
    //   298: aload 4
    //   300: astore_3
    //   301: ldc 62
    //   303: iconst_1
    //   304: new 113	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 584
    //   314: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: invokevirtual 212	java/lang/Exception:toString	()Ljava/lang/String;
    //   321: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: aload 4
    //   332: ifnull +8 -> 340
    //   335: aload 4
    //   337: invokevirtual 582	java/io/FileInputStream:close	()V
    //   340: ldc 232
    //   342: astore_0
    //   343: goto -188 -> 155
    //   346: astore_0
    //   347: aload_3
    //   348: ifnull +7 -> 355
    //   351: aload_3
    //   352: invokevirtual 582	java/io/FileInputStream:close	()V
    //   355: aload_0
    //   356: athrow
    //   357: astore_0
    //   358: ldc 2
    //   360: monitorexit
    //   361: aload_0
    //   362: athrow
    //   363: astore_0
    //   364: aload_3
    //   365: astore_0
    //   366: goto -211 -> 155
    //   369: astore_0
    //   370: goto -30 -> 340
    //   373: astore_3
    //   374: goto -19 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramString	String
    //   19	214	1	l	long
    //   15	350	3	localObject1	Object
    //   373	1	3	localException	Exception
    //   11	325	4	localObject2	Object
    //   4	276	5	localFileInputStream	java.io.FileInputStream
    //   7	285	6	str1	String
    //   47	124	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   279	284	290	java/lang/Exception
    //   16	20	297	java/lang/Exception
    //   27	49	297	java/lang/Exception
    //   56	72	297	java/lang/Exception
    //   79	86	297	java/lang/Exception
    //   93	102	297	java/lang/Exception
    //   109	138	297	java/lang/Exception
    //   167	177	297	java/lang/Exception
    //   184	192	297	java/lang/Exception
    //   199	206	297	java/lang/Exception
    //   213	254	297	java/lang/Exception
    //   261	271	297	java/lang/Exception
    //   16	20	346	finally
    //   27	49	346	finally
    //   56	72	346	finally
    //   79	86	346	finally
    //   93	102	346	finally
    //   109	138	346	finally
    //   167	177	346	finally
    //   184	192	346	finally
    //   199	206	346	finally
    //   213	254	346	finally
    //   261	271	346	finally
    //   301	330	346	finally
    //   147	155	357	finally
    //   279	284	357	finally
    //   335	340	357	finally
    //   351	355	357	finally
    //   355	357	357	finally
    //   147	155	363	java/lang/Exception
    //   335	340	369	java/lang/Exception
    //   351	355	373	java/lang/Exception
  }
  
  protected static void reportClick(String paramString1, String paramString2)
  {
    new anov(null).a("dc00899").b("grp_lbs").c(paramString1).d(paramString2).report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akks
 * JD-Core Version:    0.7.0.1
 */