import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.2;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.3;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.4;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.5;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apmj
  extends WebViewPlugin
{
  public static String cpY = "pic_up";
  public static String cpZ = "pic";
  private static int dUW = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunShowPictureIntentLimit", 200);
  private BroadcastReceiver bD;
  protected String cpX;
  
  public apmj()
  {
    this.mPluginNameSpace = "troopNotice";
  }
  
  public static void O(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    a(paramActivity, 0, localArrayList, true, "", 1000);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<MediaPreviewInfo> paramArrayList, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, MediaPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putParcelableArrayList("mediaInfoList", paramArrayList);
    localBundle.putBoolean("is_not_show_index", paramBoolean);
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList, boolean paramBoolean, String paramString, int paramInt2)
  {
    a(paramActivity, paramInt1, paramArrayList, null, null, false, paramBoolean, paramString, paramInt2, null, null, "");
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList<String> paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, ArticleInfo paramArticleInfo, String paramString2)
  {
    a(paramActivity, paramInt1, paramArrayList1, paramArrayOfBoolean, paramArrayList2, paramBoolean1, paramBoolean2, paramString1, paramInt2, paramPublicAccountShowPictureReport, paramArticleInfo, null, null, paramString2, true);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList<String> paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, ArticleInfo paramArticleInfo, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4, String paramString2, boolean paramBoolean3)
  {
    ThreadManager.post(new TroopNoticeJsHandler.2(paramActivity, paramInt1, paramArrayList1, paramArrayList2, paramArrayOfBoolean, paramPublicAccountShowPictureReport, paramArrayList3, paramArrayList4, paramBoolean1, paramBoolean2, paramBoolean3, paramArticleInfo, paramString1, paramString2, paramInt2), 8, null, true);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList<String> paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, String paramString2, String paramString3, ArticleInfo paramArticleInfo, String paramString4)
  {
    Intent localIntent = new Intent(paramActivity, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putStringArrayList("seqNum", paramArrayList1);
    if (paramArrayList2 != null) {
      localBundle.putStringArrayList("descs", paramArrayList2);
    }
    if (paramArrayOfBoolean != null) {
      localBundle.putBooleanArray("likes", paramArrayOfBoolean);
    }
    if ((paramPublicAccountShowPictureReport != null) && (paramPublicAccountShowPictureReport.isReport)) {
      localBundle.putString("PublicAccountShowPictureReport", paramPublicAccountShowPictureReport.toString());
    }
    localBundle.putBoolean("needBottomBar", paramBoolean1);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", paramBoolean2);
    localBundle.putBoolean("is_show_content_url", true);
    localBundle.putString("article_url", paramString2);
    localBundle.putString("article_title", paramString3);
    if (paramArticleInfo != null)
    {
      localBundle.putInt("channel_id", (int)paramArticleInfo.mChannelID);
      localBundle.putLong("articleSeq", paramArticleInfo.mRecommendSeq);
      localBundle.putBoolean("is_grid_image_report", true);
      ndi.a(paramArticleInfo, "", paramInt1, localBundle);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localBundle.putString("src_id", paramString1);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localBundle.putString("str_data_extra", paramString4);
    }
    if ((kxm.s(paramArticleInfo)) && (!TextUtils.isEmpty(paramString2))) {
      localBundle.putString("btntext", paramActivity.getString(2131718433));
    }
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  /* Error */
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    // Byte code:
    //   0: aload_2
    //   1: sipush 640
    //   4: invokestatic 235	jqg:d	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   7: astore 9
    //   9: aload 9
    //   11: ifnonnull +15 -> 26
    //   14: aload 9
    //   16: ifnull +8 -> 24
    //   19: aload 9
    //   21: invokevirtual 240	android/graphics/Bitmap:recycle	()V
    //   24: aconst_null
    //   25: areturn
    //   26: aload 9
    //   28: astore_2
    //   29: new 242	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   36: getstatic 248	acbn:bmj	Ljava/lang/String;
    //   39: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 254
    //   44: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 261	aqul:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 10
    //   55: aload 9
    //   57: astore_2
    //   58: aload 9
    //   60: new 263	java/io/File
    //   63: dup
    //   64: aload 10
    //   66: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: invokestatic 272	aqhu:saveBitmapToFile	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   72: aload 9
    //   74: ifnull +8 -> 82
    //   77: aload 9
    //   79: invokevirtual 240	android/graphics/Bitmap:recycle	()V
    //   82: new 274	java/util/HashMap
    //   85: dup
    //   86: invokespecial 275	java/util/HashMap:<init>	()V
    //   89: astore_2
    //   90: aload_2
    //   91: ldc_w 277
    //   94: aload 5
    //   96: invokestatic 280	apmj:oJ	(Ljava/lang/String;)Ljava/lang/String;
    //   99: invokeinterface 286 3 0
    //   104: pop
    //   105: aload_3
    //   106: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifne +62 -> 171
    //   112: new 288	org/json/JSONObject
    //   115: dup
    //   116: aload_3
    //   117: invokespecial 289	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   120: astore_3
    //   121: aload_3
    //   122: invokevirtual 293	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   125: astore 9
    //   127: aload 9
    //   129: invokeinterface 299 1 0
    //   134: ifeq +37 -> 171
    //   137: aload 9
    //   139: invokeinterface 303 1 0
    //   144: checkcast 305	java/lang/String
    //   147: astore 11
    //   149: aload_2
    //   150: aload 11
    //   152: aload_3
    //   153: aload 11
    //   155: invokevirtual 309	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   158: invokevirtual 312	java/lang/Object:toString	()Ljava/lang/String;
    //   161: invokeinterface 286 3 0
    //   166: pop
    //   167: goto -40 -> 127
    //   170: astore_3
    //   171: new 274	java/util/HashMap
    //   174: dup
    //   175: invokespecial 275	java/util/HashMap:<init>	()V
    //   178: astore_3
    //   179: aload_3
    //   180: aload 6
    //   182: aload 10
    //   184: invokeinterface 286 3 0
    //   189: pop
    //   190: aload_0
    //   191: invokevirtual 315	java/lang/String:length	()I
    //   194: istore 8
    //   196: new 317	java/lang/StringBuffer
    //   199: dup
    //   200: ldc_w 319
    //   203: invokespecial 320	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   206: astore 6
    //   208: iconst_0
    //   209: istore 7
    //   211: iload 7
    //   213: bipush 10
    //   215: iload 8
    //   217: isub
    //   218: if_icmpge +80 -> 298
    //   221: aload 6
    //   223: ldc_w 322
    //   226: invokevirtual 325	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   229: pop
    //   230: iload 7
    //   232: iconst_1
    //   233: iadd
    //   234: istore 7
    //   236: goto -25 -> 211
    //   239: astore_0
    //   240: aconst_null
    //   241: astore 9
    //   243: aload 9
    //   245: astore_2
    //   246: aload_0
    //   247: invokevirtual 328	java/lang/OutOfMemoryError:printStackTrace	()V
    //   250: aload 9
    //   252: ifnull +8 -> 260
    //   255: aload 9
    //   257: invokevirtual 240	android/graphics/Bitmap:recycle	()V
    //   260: aconst_null
    //   261: areturn
    //   262: astore_0
    //   263: aconst_null
    //   264: astore 9
    //   266: aload 9
    //   268: astore_2
    //   269: aload_0
    //   270: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   273: aload 9
    //   275: ifnull +8 -> 283
    //   278: aload 9
    //   280: invokevirtual 240	android/graphics/Bitmap:recycle	()V
    //   283: aconst_null
    //   284: areturn
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_2
    //   288: aload_2
    //   289: ifnull +7 -> 296
    //   292: aload_2
    //   293: invokevirtual 240	android/graphics/Bitmap:recycle	()V
    //   296: aload_0
    //   297: athrow
    //   298: aload 6
    //   300: aload_0
    //   301: invokevirtual 325	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   304: pop
    //   305: new 274	java/util/HashMap
    //   308: dup
    //   309: invokespecial 275	java/util/HashMap:<init>	()V
    //   312: astore_0
    //   313: aload_0
    //   314: ldc_w 331
    //   317: new 333	java/net/URL
    //   320: dup
    //   321: aload_1
    //   322: invokespecial 334	java/net/URL:<init>	(Ljava/lang/String;)V
    //   325: invokevirtual 337	java/net/URL:getRef	()Ljava/lang/String;
    //   328: invokeinterface 286 3 0
    //   333: pop
    //   334: aload 4
    //   336: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   339: ifne +67 -> 406
    //   342: new 288	org/json/JSONObject
    //   345: dup
    //   346: aload 4
    //   348: invokespecial 289	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   351: astore 4
    //   353: aload 4
    //   355: invokevirtual 293	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   358: astore 9
    //   360: aload 9
    //   362: invokeinterface 299 1 0
    //   367: ifeq +39 -> 406
    //   370: aload 9
    //   372: invokeinterface 303 1 0
    //   377: checkcast 305	java/lang/String
    //   380: astore 10
    //   382: aload_0
    //   383: aload 10
    //   385: aload 4
    //   387: aload 10
    //   389: invokevirtual 309	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   392: invokevirtual 312	java/lang/Object:toString	()Ljava/lang/String;
    //   395: invokeinterface 286 3 0
    //   400: pop
    //   401: goto -41 -> 360
    //   404: astore 4
    //   406: aload_1
    //   407: aload 6
    //   409: invokevirtual 338	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   412: aload 5
    //   414: aload_2
    //   415: aload_3
    //   416: aload_0
    //   417: invokestatic 343	jqc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;
    //   420: areturn
    //   421: astore_0
    //   422: aload_0
    //   423: invokevirtual 344	java/net/MalformedURLException:printStackTrace	()V
    //   426: aconst_null
    //   427: areturn
    //   428: astore_0
    //   429: goto -141 -> 288
    //   432: astore_0
    //   433: goto -167 -> 266
    //   436: astore_0
    //   437: goto -194 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	paramString1	String
    //   0	440	1	paramString2	String
    //   0	440	2	paramString3	String
    //   0	440	3	paramString4	String
    //   0	440	4	paramString5	String
    //   0	440	5	paramString6	String
    //   0	440	6	paramString7	String
    //   209	26	7	i	int
    //   194	24	8	j	int
    //   7	364	9	localObject	Object
    //   53	335	10	str1	String
    //   147	7	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   112	127	170	org/json/JSONException
    //   127	167	170	org/json/JSONException
    //   0	9	239	java/lang/OutOfMemoryError
    //   0	9	262	java/io/IOException
    //   0	9	285	finally
    //   342	360	404	org/json/JSONException
    //   360	401	404	org/json/JSONException
    //   313	334	421	java/net/MalformedURLException
    //   29	55	428	finally
    //   58	72	428	finally
    //   246	250	428	finally
    //   269	273	428	finally
    //   29	55	432	java/io/IOException
    //   58	72	432	java/io/IOException
    //   29	55	436	java/lang/OutOfMemoryError
    //   58	72	436	java/lang/OutOfMemoryError
  }
  
  public static String oJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int j = 5381;
    int i = 0;
    int k = paramString.length();
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return Integer.toString(0x7FFFFFFF & j);
  }
  
  protected void Ti(String paramString)
  {
    ThreadManager.post(new TroopNoticeJsHandler.3(this, paramString), 5, null, true);
  }
  
  public void Tj(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = this.mRuntime.getWebView();
      if (paramString == null) {
        return;
      }
      AppInterface localAppInterface = this.mRuntime.a();
      if (localAppInterface != null)
      {
        Activity localActivity = this.mRuntime.getActivity();
        if (localActivity != null)
        {
          String str1 = ((JSONObject)localObject).optString("callback");
          String str2 = ((JSONObject)localObject).optString("cgiURL");
          String str3 = ((JSONObject)localObject).optString("imageID");
          String str4 = ((JSONObject)localObject).optString("headFields");
          localObject = ((JSONObject)localObject).optString("postParams");
          String str5 = assi.n(localAppInterface);
          localActivity.runOnUiThread(new TroopNoticeJsHandler.4(this, paramString, str1, b(localAppInterface.getCurrentAccountUin(), str2, str3, (String)localObject, str4, str5, cpY)));
          return;
        }
      }
    }
    catch (InterruptedException paramString) {}catch (Exception paramString) {}catch (OutOfMemoryError paramString) {}catch (JSONException paramString) {}
  }
  
  protected void Tk(String paramString)
  {
    ThreadManager.post(new TroopNoticeJsHandler.5(this, paramString), 5, null, false);
  }
  
  public void Tl(String paramString)
  {
    if ((this.mRuntime == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.cpX))) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.mRuntime.getWebView();
    } while (localCustomWebView == null);
    localCustomWebView.loadUrl("javascript: " + this.cpX + "(" + paramString + ")");
  }
  
  protected void Tm(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 4, "TroopNoticeJsHandler showMedia(): jsonData = " + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      localJSONArray = paramString.optJSONArray("imageIDs");
      j = paramString.optInt("index");
      bool = paramString.optBoolean("isNotShowIndex", true);
      if (localJSONArray == null) {
        return;
      }
      if (localJSONArray.length() == 0) {
        return;
      }
      if ((this.mRuntime.getWebView() == null) || (this.mRuntime.a() == null)) {
        return;
      }
      paramString = this.mRuntime.getActivity();
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof BasePluginActivity)) {
        break label210;
      }
      paramString = ((BasePluginActivity)paramString).getOutActivity();
    }
    catch (JSONException paramString)
    {
      JSONArray localJSONArray;
      int j;
      boolean bool;
      ArrayList localArrayList;
      int i;
      int k;
      while (QLog.isColorLevel())
      {
        QLog.d("zivonchen", 4, QLog.getStackTraceString(paramString));
        return;
      }
    }
    localArrayList = new ArrayList();
    i = 0;
    k = localJSONArray.length();
    while (i < k)
    {
      localArrayList.add(new MediaPreviewInfo(localJSONArray.optJSONObject(i)));
      i += 1;
    }
    a(paramString, j, localArrayList, bool, 101);
    return;
    label210:
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("troopNotice".equals(paramString2))
    {
      if ((!"showPicture".equals(paramString3)) || (paramVarArgs.length != 1)) {
        break label37;
      }
      pg(paramVarArgs[0]);
    }
    label37:
    do
    {
      return false;
      if (("sendPicture".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        Ti(paramVarArgs[0]);
        return false;
      }
      if (("sendBatchPicture".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        Tk(paramVarArgs[0]);
        return false;
      }
    } while ((!"showMedia".equals(paramString3)) || (paramVarArgs.length != 1));
    Tm(paramVarArgs[0]);
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    CustomWebView localCustomWebView;
    if (paramByte == 100)
    {
      localCustomWebView = this.mRuntime.getWebView();
      if (localCustomWebView != null) {
        break label21;
      }
    }
    label21:
    do
    {
      do
      {
        return;
      } while ((paramIntent == null) || (!paramIntent.hasExtra("DeletedList")));
      paramIntent = paramIntent.getStringArrayListExtra("DeletedList");
    } while ((paramIntent == null) || (paramIntent.size() <= 0));
    localCustomWebView.loadUrl("javascript: " + this.cpX + "([])");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Activity localActivity2;
    if ((this.bD != null) && (this.mRuntime != null))
    {
      localActivity2 = this.mRuntime.getActivity();
      if (localActivity2 != null) {}
    }
    else
    {
      return;
    }
    Activity localActivity1 = localActivity2;
    if ((localActivity2 instanceof BasePluginActivity)) {
      localActivity1 = ((BasePluginActivity)localActivity2).getOutActivity();
    }
    localActivity1.unregisterReceiver(this.bD);
  }
  
  protected void pg(String paramString)
  {
    try
    {
      Object localObject6 = new JSONObject(paramString);
      Object localObject8 = ((JSONObject)localObject6).optString("bigurl");
      Object localObject1;
      int i;
      int j;
      Object localObject2;
      Object localObject3;
      Object localObject9;
      if (!TextUtils.isEmpty((CharSequence)localObject8))
      {
        paramString = ((JSONObject)localObject6).optString("videoID");
        localObject1 = ((JSONObject)localObject6).optString("videoURL");
        ((JSONObject)localObject6).optString("originalVideoURL");
        i = ((JSONObject)localObject6).optInt("videoWidth");
        j = ((JSONObject)localObject6).optInt("videoHeight");
        ((JSONObject)localObject6).optBoolean("isLike");
        localObject2 = this.mRuntime.getActivity();
        if (localObject2 == null) {
          return;
        }
        localObject3 = avpw.d.a();
        localObject4 = new Bundle();
        localObject5 = new ArrayList();
        localObject7 = new PhotoInfo();
        ((PhotoInfo)localObject7).bigUrl = ((String)localObject8);
        ((PhotoInfo)localObject7).videoflag = 1;
        ((PhotoInfo)localObject7).a = new VideoInfo();
        ((PhotoInfo)localObject7).a.videoId = paramString;
        localObject9 = new PictureUrl();
        ((PictureUrl)localObject9).url = ((String)localObject8);
        ((PhotoInfo)localObject7).a.d = ((PictureUrl)localObject9);
        localObject8 = new VideoUrl();
        ((VideoUrl)localObject8).url = ((String)localObject1);
        ((PhotoInfo)localObject7).a.videoId = paramString;
        ((PhotoInfo)localObject7).a.actionUrl = ((String)localObject1);
        ((PhotoInfo)localObject7).a.a = ((VideoUrl)localObject8);
        ((PhotoInfo)localObject7).a.width = i;
        ((PhotoInfo)localObject7).a.height = j;
        ((PhotoInfo)localObject7).a.videoStatus = 5;
        ((ArrayList)localObject5).add(localObject7);
        ((Bundle)localObject4).putSerializable("picturelist", (Serializable)localObject5);
        ((Bundle)localObject4).putInt("curindex", 0);
        ((Bundle)localObject4).putInt("mode", 3);
        ((Bundle)localObject4).putBoolean("need_clear_cache", true);
        avpw.c((Activity)localObject2, (avpw.d)localObject3, (Bundle)localObject4, 6);
      }
      this.cpX = ((JSONObject)localObject6).optString("callback");
      Object localObject5 = ((JSONObject)localObject6).optJSONArray("imageIDs");
      localObject8 = ((JSONObject)localObject6).optJSONArray("likes");
      Object localObject7 = ((JSONObject)localObject6).optJSONArray("descs");
      Object localObject4 = ((JSONObject)localObject6).optJSONArray("sourceIDs");
      Object localObject10 = ((JSONObject)localObject6).optJSONArray("sourceSize");
      boolean bool1 = ((JSONObject)localObject6).optBoolean("needBottomBar");
      paramString = ((JSONObject)localObject6).optJSONObject("extra");
      if (paramString == null) {}
      boolean bool2;
      ArrayList localArrayList;
      int k;
      for (paramString = "";; paramString = paramString.toString())
      {
        j = ((JSONObject)localObject6).optInt("index");
        localObject9 = ((JSONObject)localObject6).optString("srcID");
        bool2 = ((JSONObject)localObject6).optBoolean("isReport");
        localObject1 = null;
        if (Boolean.valueOf(bool2).booleanValue())
        {
          localObject1 = new PublicAccountShowPictureReport();
          ((PublicAccountShowPictureReport)localObject1).parse((JSONObject)localObject6);
        }
        bool2 = ((JSONObject)localObject6).optBoolean("isNotShowIndex", true);
        if ((localObject5 == null) || (((JSONArray)localObject5).length() == 0) || (this.mRuntime.getWebView() == null) || (this.mRuntime.a() == null)) {
          break label1105;
        }
        localObject3 = this.mRuntime.getActivity();
        if (localObject3 == null) {
          break label1105;
        }
        localObject2 = localObject3;
        if ((localObject3 instanceof BasePluginActivity)) {
          localObject2 = ((BasePluginActivity)localObject3).getOutActivity();
        }
        localArrayList = new ArrayList();
        i = 0;
        k = ((JSONArray)localObject5).length();
        while (i < k)
        {
          localArrayList.add(((JSONArray)localObject5).get(i).toString());
          i += 1;
        }
      }
      if (localObject4 != null)
      {
        localObject3 = new ArrayList();
        i = 0;
        k = ((JSONArray)localObject4).length();
        while (i < k)
        {
          ((ArrayList)localObject3).add(((JSONArray)localObject4).get(i).toString());
          i += 1;
        }
      }
      for (;;)
      {
        localObject4 = null;
        if (localObject10 != null)
        {
          localObject5 = new ArrayList();
          i = 0;
          k = ((JSONArray)localObject10).length();
          for (;;)
          {
            localObject4 = localObject5;
            if (i >= k) {
              break;
            }
            ((ArrayList)localObject5).add(((JSONArray)localObject10).get(i).toString());
            i += 1;
          }
        }
        boolean bool3 = ((JSONObject)localObject6).optBoolean("showTitle", false);
        localObject5 = aqgo.encodeToString(((JSONObject)localObject6).optString("title", "").getBytes(), 0);
        localObject6 = ((JSONObject)localObject6).optString("articleUrl", "");
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, new Object[] { "KANDIAN Grid Image title: ", localObject5, ", articleUrl: ", localObject6, ", showTitle: ", Boolean.valueOf(bool3) });
        }
        if (bool1)
        {
          if (localObject8 != null)
          {
            localObject10 = new boolean[((JSONArray)localObject8).length()];
            i = 0;
            while (i < ((JSONArray)localObject8).length())
            {
              localObject10[i] = ((JSONArray)localObject8).getBoolean(i);
              i += 1;
            }
            localObject8 = new ArrayList();
            if ((localObject7 != null) && (((JSONArray)localObject7).length() != 0))
            {
              i = 0;
              k = ((JSONArray)localObject7).length();
              while (i < k)
              {
                ((ArrayList)localObject8).add(((JSONArray)localObject7).get(i).toString());
                i += 1;
              }
            }
            if (this.bD == null)
            {
              this.bD = new apmk(this);
              localObject7 = new IntentFilter("android.intent.action.WEBJSCALL");
              ((Activity)localObject2).registerReceiver(this.bD, (IntentFilter)localObject7);
            }
            if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
            {
              a((Activity)localObject2, j, localArrayList, (boolean[])localObject10, (ArrayList)localObject8, bool1, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, (String)localObject6, (String)localObject5, null, paramString);
              return;
            }
            a((Activity)localObject2, j, localArrayList, (boolean[])localObject10, (ArrayList)localObject8, bool1, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, null, (ArrayList)localObject3, (ArrayList)localObject4, paramString, true);
          }
        }
        else
        {
          if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
          {
            a((Activity)localObject2, j, localArrayList, null, null, false, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, (String)localObject6, (String)localObject5, null, paramString);
            return;
          }
          a((Activity)localObject2, j, localArrayList, null, null, false, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, null, paramString);
          return;
          localObject3 = null;
          continue;
        }
        label1105:
        return;
      }
      return;
    }
    catch (JSONException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmj
 * JD-Core Version:    0.7.0.1
 */