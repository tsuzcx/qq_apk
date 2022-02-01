package com.tencent.mobileqq.troop.activity;

import acbn;
import acfp;
import afmf;
import ahbj;
import akyr;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable.Factory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import aora;
import aovq;
import aovr;
import aovs;
import aovt;
import aovu;
import aovv;
import aprv;
import apsv;
import aqfy;
import aqha;
import aqho;
import aqiz;
import aqju;
import aryr;
import aryv;
import awit;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import jqc;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rop;
import tat;

public class TroopBarPublishUtils
{
  public static Editable.Factory a;
  private static b a;
  public static boolean cOY;
  public static String cnl;
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new aovt();
  }
  
  public static void Rn(boolean paramBoolean)
  {
    awit.H("sp_key_is_open_tribe_pic_watermark", Boolean.valueOf(paramBoolean));
  }
  
  public static final Bitmap a(Context paramContext, Bitmap paramBitmap)
  {
    if ((paramBitmap.getWidth() < 640) || (paramBitmap.getHeight() < 300)) {
      return null;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inScaled = false;
    paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130844052, (BitmapFactory.Options)localObject);
    int i;
    int j;
    int k;
    if (TextUtils.isEmpty(cnl))
    {
      cnl = acfp.m(2131715608);
      if (cnl.length() > 12) {
        cnl = cnl.substring(0, 11) + "...";
      }
      int m = paramBitmap.getWidth();
      i = (int)(36.0D / 750 * m);
      j = (int)(32.0D / 750 * m);
      k = (int)(8.0D / 750 * m);
      m = (int)(24.0D / 750 * m);
      localObject = new Paint();
      ((Paint)localObject).setDither(true);
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setColor(-1);
      ((Paint)localObject).setFakeBoldText(true);
      ((Paint)localObject).setTextSize(m);
      if (!paramBitmap.isMutable()) {
        break label385;
      }
    }
    for (;;)
    {
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.save();
      localCanvas.drawBitmap(paramContext, new Rect(0, 0, paramContext.getWidth(), paramContext.getHeight()), new Rect(i, localCanvas.getHeight() - i - j, i + j, localCanvas.getHeight() - i), (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localCanvas.translate(i + j + k, localCanvas.getHeight() - i - (i - j));
      localCanvas.drawText(cnl, 0.0F, 0.0F, (Paint)localObject);
      localCanvas.restore();
      return paramBitmap;
      if (cnl.endsWith(acfp.m(2131715603))) {
        break;
      }
      cnl += acfp.m(2131715600);
      break;
      label385:
      paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    }
  }
  
  public static Uri a(BaseActivity paramBaseActivity, a parama)
  {
    if (paramBaseActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
    {
      paramBaseActivity.requestPermissions(new aovq(paramBaseActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      return null;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (paramBaseActivity.checkSelfPermission("android.permission.CAMERA") != 0))
    {
      paramBaseActivity.requestPermissions(new aovr(parama, paramBaseActivity), 1, new String[] { "android.permission.CAMERA" });
      return null;
    }
    return aprv.a(paramBaseActivity, acbn.oM, 1001);
  }
  
  public static ViewGroup a(BaseActivity paramBaseActivity, ViewGroup paramViewGroup, EditText paramEditText, afmf paramafmf)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    tat.b(paramBaseActivity, paramEditText);
    paramEditText = (EmoticonMainPanel)View.inflate(paramBaseActivity, 2131559281, null);
    paramEditText.setCallBack(paramafmf);
    paramEditText.bYY = true;
    paramEditText.a(paramBaseActivity.app, 1008, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null);
    paramEditText.daq();
    paramViewGroup.addView(paramEditText, new RelativeLayout.LayoutParams(-1, (int)aqho.convertDpToPixel(paramBaseActivity, 250.0F)));
    paramEditText.setVisibility(8);
    return paramEditText;
  }
  
  @TargetApi(11)
  public static SystemAndEmojiEmoticonPanel a(Context paramContext, ViewGroup paramViewGroup, EditText paramEditText, afmf paramafmf)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    tat.b(paramContext, paramEditText);
    paramEditText = new SystemAndEmojiEmoticonPanel(paramContext, paramafmf);
    paramEditText.setBackgroundResource(2130838096);
    paramafmf = new RelativeLayout.LayoutParams(-1, (int)aqho.convertDpToPixel(paramContext, 196.0F));
    int i = (int)aqho.convertDpToPixel(paramContext, 20.0F);
    paramEditText.setPadding(0, i, 0, i);
    paramViewGroup.addView(paramEditText, paramafmf);
    paramEditText.setVisibility(8);
    return paramEditText;
  }
  
  public static String a(String paramString, ArrayList<String> paramArrayList, AudioInfo paramAudioInfo)
  {
    return a(paramString, paramArrayList, paramAudioInfo, null);
  }
  
  public static String a(String paramString, ArrayList<String> paramArrayList, AudioInfo paramAudioInfo, aora paramaora)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      localJSONObject.put("content", str);
      int i;
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramString = new ArrayList(paramArrayList);
        paramArrayList = new JSONArray();
        int j = 0;
        i = 0;
        while (j < paramString.size())
        {
          str = (String)paramString.get(j);
          TroopBarPublishActivity.Pic_list localPic_list = (TroopBarPublishActivity.Pic_list)aprv.w.get(str);
          if (localPic_list == null) {
            break label283;
          }
          paramArrayList.put(localPic_list.getJsonObject());
          if (!akyr.lP(str)) {
            break label283;
          }
          i += 1;
          j += 1;
        }
      }
      try
      {
        localJSONObject.put("pic_list", paramArrayList);
        localJSONObject.put("gif_num", i);
        label158:
        if (paramAudioInfo != null) {
          paramString = new JSONArray();
        }
        try
        {
          paramString.put(new JSONObject(paramAudioInfo.getJsonText()));
          localJSONObject.put("audio_list", paramString);
          if (paramaora != null) {
            paramString = new JSONArray();
          }
        }
        catch (JSONException paramString)
        {
          try
          {
            do
            {
              paramString.put(paramaora.toJson());
              localJSONObject.put("ugc_video_list", paramString);
              return localJSONObject.toString();
              paramString = paramString;
            } while (!QLog.isColorLevel());
            QLog.e("TroopBarPublishUtils", 2, paramString.getMessage());
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("TroopBarPublishUtils", 2, paramString.getMessage());
              }
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        break label158;
      }
    }
    catch (JSONException paramString)
    {
      label283:
      for (;;) {}
    }
  }
  
  public static void a(int paramInt, Activity paramActivity, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
    case 4: 
      cl(paramActivity);
      String str = paramBundle.getString("bid", "0");
      if ("interestcircle".endsWith(paramBundle.getString("from")))
      {
        paramActivity = "pub_page_new";
        if (paramInt != 3) {
          break label146;
        }
        paramBundle = "Clk_install";
        if (paramInt != 3) {
          break label158;
        }
        if (!"0".endsWith(str)) {
          break label153;
        }
        paramInt = 2;
      }
      for (;;)
      {
        anot.a(null, "dc00899", "Grp_tribe", "", paramActivity, paramBundle, paramInt, 0, str, "", "", "");
        return;
        if ("0".endsWith(str)) {}
        for (paramActivity = "pub_page_new";; paramActivity = "reply_page_new") {
          break;
        }
        paramBundle = "Clk_update";
        break label77;
        paramInt = 1;
        continue;
        paramInt = 0;
      }
    case 1: 
      label77:
      n(paramActivity, paramBundle);
      label146:
      label153:
      label158:
      return;
    }
    o(paramActivity, paramBundle);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str = aqiz.O(paramActivity, "com.tencent.tribe");
    jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$b = new b(paramActivity, paramInt1, paramInt2, paramBundle);
    if (!"0".equals(str))
    {
      if (("interestcircle".endsWith(paramBundle.getString("from"))) && (compareVersion(str, "1.5") < 0))
      {
        b(paramActivity, 4, paramInt2, paramBundle);
        return;
      }
      b(paramActivity, paramInt1, paramInt2, paramBundle);
      return;
    }
    b(paramActivity, 3, paramInt2, paramBundle);
  }
  
  public static void a(BaseActivity paramBaseActivity, ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramBaseActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
    {
      paramBaseActivity.requestPermissions(new aovs(paramBaseActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null) {
      localArrayList.addAll(paramArrayList);
    }
    paramArrayList = new Intent();
    paramArrayList.setClass(paramBaseActivity, NewPhotoListActivity.class);
    paramArrayList.putExtra("enter_from", 24);
    paramArrayList.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramArrayList.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramBaseActivity.getClass().getName());
    paramArrayList.putExtra("from_tribe_class_name", paramBaseActivity.getClass().getSimpleName());
    paramArrayList.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramArrayList.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramArrayList.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    paramArrayList.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    paramArrayList.getExtras().remove("forward_type");
    paramArrayList.putExtra("album_enter_directly", true);
    paramArrayList.putExtra("ALBUM_ID", aqfy.sLastAlbumId);
    paramArrayList.putExtra("ALBUM_NAME", aqfy.sLastAlbumName);
    paramArrayList.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    paramArrayList.putExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", true);
    paramBaseActivity.startActivityForResult(paramArrayList, 1001);
    aqfy.anim(paramBaseActivity, false, true);
  }
  
  public static boolean aAE()
  {
    return ((Boolean)awit.f("sp_key_is_open_tribe_pic_watermark", Boolean.valueOf(true))).booleanValue();
  }
  
  protected static void b(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if ((paramInt1 != 3) && (paramInt1 != 4) && (jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$b.l().booleanValue()))
    {
      a(paramInt1, paramActivity, paramBundle);
      return;
    }
    String str2;
    String str1;
    label97:
    String str4;
    Object localObject;
    String str3;
    switch (paramInt2)
    {
    default: 
      str2 = acfp.m(2131715588);
      switch (paramInt1)
      {
      default: 
        str1 = "";
        if ((paramInt1 == 3) || (paramInt1 == 4))
        {
          str4 = paramBundle.getString("bid", "0");
          if (!"interestcircle".endsWith(paramBundle.getString("from"))) {
            break label340;
          }
          localObject = "pub_page_new";
          if (paramInt1 != 3) {
            break label367;
          }
          str3 = "exp_install";
          label150:
          if (paramInt1 != 4) {
            break label375;
          }
          paramInt2 = 0;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      anot.a(null, "dc00899", "Grp_tribe", "", (String)localObject, str3, paramInt2, 0, str4, "", "", "");
      localObject = aqha.a(paramActivity, 230);
      ((aqju)localObject).setTitle(paramActivity.getString(2131698461, new Object[] { str1, str2 }));
      paramActivity = new aovu(paramBundle, paramInt1, paramInt1, paramActivity);
      ((aqju)localObject).setNegativeButton(acfp.m(2131715577), paramActivity);
      ((aqju)localObject).setPositiveButton(acfp.m(2131715598) + str1, paramActivity);
      ((aqju)localObject).show();
      return;
      str2 = acfp.m(2131715571);
      break;
      str2 = acfp.m(2131715574);
      break;
      str1 = acfp.m(2131715601);
      break label97;
      str1 = acfp.m(2131715584);
      break label97;
      str1 = acfp.m(2131715580);
      break label97;
      label340:
      if ("0".endsWith(str4)) {}
      for (localObject = "pub_page_new";; localObject = "reply_page_new") {
        break;
      }
      label367:
      str3 = "exp_update";
      break label150;
      label375:
      if ("0".endsWith(str4)) {
        paramInt2 = 2;
      } else {
        paramInt2 = 1;
      }
    }
  }
  
  public static void ck(Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tencenttribe://open_app/?from=profile"));
      localIntent.addFlags(268435456);
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      QQToast.a(paramActivity, acfp.m(2131715597), 0).show(50);
    }
  }
  
  protected static void cl(Activity paramActivity)
  {
    if (apsv.aH(paramActivity) != 2)
    {
      aqju localaqju = aqha.a(paramActivity, 230);
      localaqju.setTitle(acfp.m(2131715596));
      paramActivity = new aovv(paramActivity);
      localaqju.setNegativeButton(acfp.m(2131715606), paramActivity);
      localaqju.setPositiveButton(acfp.m(2131715602), paramActivity);
      localaqju.show();
      return;
    }
    cm(paramActivity);
  }
  
  public static void cm(Activity paramActivity)
  {
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("REFERER", " https://buluo.qq.com/");
      ((Bundle)localObject1).putString("HOST", " buluo.qq.com");
      Object localObject2 = new JSONObject(jqc.a(paramActivity, "https://buluo.qq.com/cgi-bin/sbar/other/downloadappurl", "POST", null, (Bundle)localObject1));
      localObject1 = paramActivity.getString(2131698460);
      localObject2 = ((JSONObject)localObject2).getJSONObject("result").getJSONObject("android").getString("app_url");
      String str1 = paramActivity.getString(2131698462);
      String str2 = paramActivity.getString(2131698459);
      Bundle localBundle = new Bundle();
      localBundle.putString(aryv.PARAM_SNG_APPID, (String)localObject1);
      localBundle.putString(aryv.PARAM_URL, (String)localObject2);
      localBundle.putInt(aryv.PARAM_ACTIONCODE, 2);
      localBundle.putString(aryv.PARAM_APPNAME, str2);
      localBundle.putString(aryv.PARAM_TASK_PACKNAME, str1);
      localBundle.putBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG, false);
      localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, false);
      localBundle.putString(aryv.PARAM_NOTIFYKEY, "_" + (String)localObject1);
      aryr.d(paramActivity, localBundle, "biz_src_feeds_buluo", null, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "====tribe app download====" + localException.toString());
      }
      QQToast.a(paramActivity, acfp.m(2131715593), 0).show(50);
    }
  }
  
  public static int compareVersion(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return 0;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return 1;
    }
    if ((TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    int i = 0;
    for (;;)
    {
      int j;
      int k;
      try
      {
        if ((i < arrayOfString1.length) && (i < arrayOfString2.length))
        {
          j = Integer.parseInt(arrayOfString1[i]);
          k = Integer.parseInt(arrayOfString2[i]);
          if (j < k) {
            return -1;
          }
        }
        else
        {
          if (arrayOfString1.length > i) {
            return 1;
          }
          j = arrayOfString2.length;
          if (j <= i) {
            break;
          }
          return -1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return paramString1.compareTo(paramString2);
      }
      if (j > k) {
        return 1;
      }
      i += 1;
    }
  }
  
  public static void g(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://buluo.qq.com/mobile/video_theme.html?_wv=1031&video_theme_id=" + paramInt2);
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  protected static void n(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      String str1 = paramBundle.getString("bid", "");
      String str2 = paramBundle.getString("uin");
      paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(String.format("tencenttribe://gbar_home/?bid=%s&from=%s&post=true&uin=%s&title=%s&msg=%s&clicktype=%s", new Object[] { str1, paramBundle.getString("from", "qqbuluo"), str2, URLEncoder.encode(paramBundle.getString("title"), "UTF-8"), URLEncoder.encode(paramBundle.getString("content"), "UTF-8"), paramBundle.getString("clicktype") })));
      paramBundle.addFlags(268435456);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "=====invoke proto====" + paramBundle.toString());
      }
      paramActivity.startActivity(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QQToast.a(paramActivity, acfp.m(2131715592), 0).show(50);
    }
  }
  
  protected static void o(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(String.format("tencenttribe://post_detail/?pid=%s&bid=%s&bar_type=0&from=qqbuluo&post=true&uin=%s&floor=%s&msg=%s&clicktype=%s", new Object[] { paramBundle.getString("pid"), paramBundle.getString("bid", ""), paramBundle.getString("uin"), paramBundle.getString("floor"), URLEncoder.encode(paramBundle.getString("content"), "UTF-8"), paramBundle.getString("clicktype") })));
      paramBundle.addFlags(268435456);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "=====invoke proto====" + paramBundle.toString());
      }
      paramActivity.startActivity(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QQToast.a(paramActivity, acfp.m(2131715589), 0).show(50);
    }
  }
  
  public static class AudioUploadTask
    implements Runnable
  {
    protected WeakReference<BaseActivity> mActivity;
    protected String mAudioPath;
    protected Handler mHandler;
    protected int mState;
    protected String mUrl;
    
    public AudioUploadTask(BaseActivity paramBaseActivity, Handler paramHandler, String paramString1, String paramString2)
    {
      this.mUrl = paramString1;
      this.mActivity = new WeakReference(paramBaseActivity);
      this.mHandler = paramHandler;
      this.mAudioPath = paramString2;
      this.mState = -1;
    }
    
    public int La()
    {
      return this.mState;
    }
    
    public void run()
    {
      this.mState = 1;
      if (this.mActivity == null) {}
      for (Object localObject1 = null; localObject1 == null; localObject1 = (BaseActivity)this.mActivity.get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBarPublishUtils", 2, "AudioUploadTask activity is null!");
        }
        this.mState = 0;
        return;
      }
      if (!ahbj.isFileExists(this.mAudioPath))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBarPublishUtils", 2, "Audio is null! mAudioPath=" + this.mAudioPath);
        }
        this.mState = 0;
        return;
      }
      Object localObject2 = ((BaseActivity)localObject1).getAppRuntime();
      localObject1 = ((AppRuntime)localObject2).getAccount();
      localObject2 = ((TicketManager)((AppRuntime)localObject2).getManager(2)).getSkey((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.mState = 0;
        return;
      }
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("type", "1");
      localHashMap1.put("name", this.mAudioPath);
      localHashMap1.put("fileName", this.mAudioPath);
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("file", this.mAudioPath);
      HashMap localHashMap3 = new HashMap();
      localHashMap3.put("Connection", "keep-alive");
      localHashMap3.put("Referer", "https://www.qq.com");
      localObject1 = jqc.a(this.mUrl, (String)localObject1, (String)localObject2, localHashMap1, localHashMap2, localHashMap3);
      if (localObject1 != null) {}
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject1).optInt("retcode", -1) == 0)
          {
            localObject1 = ((JSONObject)localObject1).optJSONObject("result");
            if ((localObject1 != null) && (((JSONObject)localObject1).optInt("retcode") == 0))
            {
              localObject1 = ((JSONObject)localObject1).optString("url");
              localObject2 = this.mHandler.obtainMessage(1009);
              ((Message)localObject2).obj = localObject1;
              ((Message)localObject2).arg1 = 1;
              this.mHandler.sendMessage((Message)localObject2);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopBarPublishUtils", 2, localJSONException.getMessage());
          continue;
        }
        this.mState = 0;
        return;
        Message localMessage = this.mHandler.obtainMessage(1004);
        this.mHandler.sendMessage(localMessage);
        if (QLog.isColorLevel()) {
          QLog.d("TroopBarPublishUtils", 2, "uploadImage failed: path = " + this.mAudioPath);
        }
      }
    }
  }
  
  public static class PicUploadThread
    implements Runnable
  {
    protected final ArrayList<String> BF;
    protected WeakReference<BaseActivity> mActivity;
    protected Handler mHandler;
    private long mStartTime;
    protected boolean mStop;
    protected String mUrl;
    protected String type;
    
    public PicUploadThread(BaseActivity paramBaseActivity, Handler paramHandler, ArrayList<String> paramArrayList, String paramString)
    {
      this.BF = new ArrayList(paramArrayList);
      this.mHandler = paramHandler;
      this.mActivity = new WeakReference(paramBaseActivity);
      this.mUrl = paramString;
      this.type = "2";
    }
    
    private void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
    {
      if (this.mHandler == null) {
        return;
      }
      Message localMessage = this.mHandler.obtainMessage(paramInt1);
      if (paramObject != null) {
        localMessage.obj = paramObject;
      }
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      this.mHandler.sendMessage(localMessage);
    }
    
    public void run()
    {
      this.mStartTime = SystemClock.elapsedRealtime();
      if (this.mActivity == null) {}
      for (BaseActivity localBaseActivity = null; this.BF.size() == 0; localBaseActivity = (BaseActivity)this.mActivity.get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBarPublishUtils", 2, "PicUploadThread path list is null!");
        }
        a(1001, null, -2, 0);
        return;
      }
      if ((localBaseActivity == null) || (localBaseActivity.app == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBarPublishUtils", 2, "PicUploadThread activity is null!");
        }
        a(1001, this.BF.get(0), -1, 0);
        return;
      }
      String str1 = localBaseActivity.app.getCurrentAccountUin();
      String str2 = ((TicketManager)localBaseActivity.app.getManager(2)).getSkey(str1);
      if (TextUtils.isEmpty(str2))
      {
        a(1001, this.BF.get(0), 1000, 0);
        return;
      }
      Iterator localIterator = this.BF.iterator();
      String str3;
      int i;
      Object localObject1;
      label291:
      Object localObject2;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          str3 = (String)localIterator.next();
          if ((!akyr.lP(str3)) && (TroopBarPublishUtils.aAE()) && (TroopBarPublishUtils.cOY)) {}
          for (i = 1;; i = 0)
          {
            localObject1 = (TroopBarPublishActivity.Pic_list)aprv.w.get(str3);
            if (localObject1 != null)
            {
              if (((TroopBarPublishActivity.Pic_list)localObject1).canReuse) {
                break;
              }
              aprv.w.remove(str3);
            }
            if ((!localBaseActivity.isFinishing()) && (!this.mStop)) {
              break label291;
            }
            a(1001, str3, 1003, 0);
            return;
          }
          localObject1 = MediaApiPlugin.an(str3, 0);
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            a(1001, str3, 1001, 0);
            if (QLog.isColorLevel()) {
              QLog.d("TroopBarPublishUtils", 2, "scalePublishImage failed: path = " + str3);
            }
          }
          else
          {
            if (i == 0) {
              break label673;
            }
            localObject2 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject2).inScaled = false;
            localObject2 = TroopBarPublishUtils.a(localBaseActivity, BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2));
            if (localObject2 != null)
            {
              localObject1 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf(".")) + "_tribe_water_" + ((String)localObject1).substring(((String)localObject1).lastIndexOf("."));
              rop.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, (String)localObject1);
            }
          }
        }
      }
      label673:
      for (;;)
      {
        label445:
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("type", this.type);
        if (QLog.isColorLevel()) {
          QLog.d("TroopBarPublishUtils", 2, "PicUploadThread type: " + this.type + " ,mUrl: " + this.mUrl);
        }
        localObject2 = aprv.a(this.mUrl, localBaseActivity, (String)localObject1, str1, str2, (Map)localObject2);
        if (i != 0) {
          new File((String)localObject1).delete();
        }
        if (localObject2 != null)
        {
          localObject1 = new TroopBarPublishActivity.Pic_list((JSONObject)localObject2);
          if (i == 0) {}
          for (boolean bool = true;; bool = false)
          {
            ((TroopBarPublishActivity.Pic_list)localObject1).canReuse = bool;
            aprv.w.put(str3, localObject1);
            break;
            i = 0;
            break label445;
          }
        }
        a(1001, str3, 1002, 0);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopBarPublishUtils", 2, "singleUploadImage failed: path = " + str3);
        break;
        a(1003, this.BF.get(0), 0, (int)(SystemClock.elapsedRealtime() - this.mStartTime));
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void i(Uri paramUri);
  }
  
  public static class b
  {
    private SharedPreferences Z;
    SharedPreferences.Editor editor;
    private String uin;
    
    public b(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
    {
      this.uin = paramBundle.getString("uin");
      if (this.uin != null) {}
      for (paramBundle = this.uin;; paramBundle = "0")
      {
        this.uin = paramBundle;
        this.Z = paramActivity.getSharedPreferences("tribeInvokeFrom", 0);
        return;
      }
    }
    
    public void dXl()
    {
      this.editor = this.Z.edit();
      this.editor.putBoolean(this.uin, true);
      this.editor.commit();
    }
    
    public Boolean l()
    {
      return Boolean.valueOf(this.Z.getBoolean(this.uin, false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils
 * JD-Core Version:    0.7.0.1
 */