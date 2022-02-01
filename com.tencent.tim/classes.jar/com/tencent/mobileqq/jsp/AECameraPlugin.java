package com.tencent.mobileqq.jsp;

import aczy;
import ahbj;
import aiip;
import aiiq;
import akyj;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import aoll;
import aolm;
import aolm.b;
import aomi;
import aqgo;
import aqhu;
import aqiw;
import awtn;
import awtn.d.a;
import axcg;
import axcj;
import axis;
import ayja;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneFeedsPluginProxyActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class AECameraPlugin
  extends WebViewPlugin
{
  private DownloadRunnable a;
  private String bNP;
  private String bNQ;
  private double cH;
  private int ddt = -1;
  private int ddu;
  private int ddv;
  
  static
  {
    File localFile = new File(awtn.d.a.cTc);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (bn(BaseApplicationImpl.getContext()))
    {
      localFile = new File(awtn.getCameraPath());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
  }
  
  public AECameraPlugin()
  {
    this.mPluginNameSpace = "aecamera";
  }
  
  private void Lh(@NonNull String paramString)
  {
    if ((this.a != null) && (this.a.mVideoUrl.equals(paramString)) && (this.ddt == 1))
    {
      JSONObject localJSONObject = e(paramString, "downloading canceled");
      callJs(this.a.mCallbackId, new String[] { localJSONObject.toString() });
      ThreadManager.removeJobFromThreadPool(this.a, 128);
    }
    this.a = null;
    this.bNP = null;
    this.ddt = -1;
    paramString = new File(lz(paramString));
    if (paramString.exists()) {
      ahbj.deleteFile(paramString);
    }
  }
  
  private void Li(@NonNull String paramString)
  {
    String str1 = lz(paramString);
    String str2 = lA(paramString);
    if (!new File(str1).exists()) {
      QQToast.a(this.mRuntime.getActivity(), 2131720152, 0).show();
    }
    for (;;)
    {
      return;
      paramString = this.mRuntime.getActivity().getIntent();
      Object localObject1;
      if (paramString == null)
      {
        localObject1 = axcg.a;
        paramString = "";
        label67:
        if ((localObject1 != axcg.e) || (TextUtils.isEmpty(paramString))) {
          break label170;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("file_send_path", str1);
        ((Intent)localObject1).putExtra("file_send_duration", ShortVideoUtils.getDuration(str1));
      }
      try
      {
        ((Intent)localObject1).putExtra("widgetinfo", URLEncoder.encode(paramString, "UTF-8"));
        label121:
        this.mRuntime.getActivity().setResult(-1, (Intent)localObject1);
        this.mRuntime.getActivity().finish();
        return;
        localObject1 = axcg.a(paramString.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", axcg.a.getId()));
        paramString = paramString.getStringExtra("url");
        break label67;
        label170:
        paramString = j(str1, 1);
        try
        {
          if (apb())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("h5_key_flag", true);
            ((Intent)localObject1).putExtra("h5_key_video_path", str1);
            ((Intent)localObject1).putExtra("h5_key_thumb_path", str2);
            aqhu.b(paramString, 80, new File(str2));
            this.mRuntime.getActivity().setResult(-1, (Intent)localObject1);
            this.mRuntime.getActivity().finish();
            return;
          }
          if (paramString != null)
          {
            aqhu.b(paramString, 80, new File(str2));
            ayja.a(this.mRuntime.getActivity(), str1, str2, axcg.H(this.mRuntime.getActivity()), ia(21));
          }
          for (;;)
          {
            return;
            QQToast.a(this.mRuntime.getActivity(), 2131720152, 0).show();
          }
        }
        catch (IOException localIOException)
        {
          QQToast.a(this.mRuntime.getActivity(), 2131720152, 0).show();
          return;
        }
        finally
        {
          if (paramString != null) {
            paramString.recycle();
          }
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        break label121;
      }
    }
  }
  
  private void Lj(String paramString)
    throws IOException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IOException();
    }
    Object localObject = new File(paramString);
    if ((!((File)localObject).exists()) || (((File)localObject).length() < 3L)) {
      throw new IOException();
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    if ((i < 0) || (j < 0)) {
      throw new IOException();
    }
  }
  
  private JSONObject a(@Nullable String paramString, int paramInt1, int paramInt2)
    throws IOException, JSONException, OutOfMemoryError
  {
    Lj(paramString);
    paramString = i(paramString, paramInt1, paramInt2);
    StringBuilder localStringBuilder = b(paramString);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("succeeded", true);
    localJSONObject.put("picData", localStringBuilder);
    localJSONObject.put("picPath", paramString);
    return localJSONObject;
  }
  
  private static void a(AppInterface paramAppInterface, String paramString1, String paramString2, aolm.b paramb)
  {
    aoll localaoll = new aoll();
    localaoll.bZ = paramString1;
    localaoll.mHttpMethod = 0;
    localaoll.atY = paramString2;
    localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
    localaoll.mExcuteTimeLimit = 60000L;
    localaoll.f = new aiiq(paramb);
    try
    {
      paramAppInterface.getNetEngine(0).a(localaoll);
      localaoll.f.onUpdateProgeress(localaoll, 1L, 100L);
      return;
    }
    catch (Exception paramAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          paramAppInterface.printStackTrace();
        }
      }
    }
  }
  
  private void a(a parama, @NonNull String paramString)
  {
    this.ddu = parama.ddy;
    this.ddv = parama.ddz;
    this.bNQ = paramString;
    int i = axcg.C.getId();
    axcj.a(this.mRuntime.getActivity(), ia(1), i, parama);
  }
  
  private String an(String paramString, int paramInt)
  {
    paramString = new CompressInfo(paramString, paramInt);
    akyj.b(paramString);
    return paramString.destPath;
  }
  
  private boolean apb()
  {
    if ((this.mRuntime != null) && (this.mRuntime.getActivity() != null) && (this.mRuntime.getActivity().getIntent() != null)) {
      return axcg.oi(this.mRuntime.getActivity().getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", axcg.a.getId()));
    }
    return false;
  }
  
  private StringBuilder b(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = false;
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    paramString = localOptions.outMimeType;
    if (("image/png".equalsIgnoreCase(paramString)) || ("image/gif".equals(paramString)) || ("image/bmp".equals(paramString)))
    {
      paramString = new StringBuilder("data:image/png;base64,");
      localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    }
    for (;;)
    {
      localBitmap.recycle();
      paramString.append(aqgo.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
      return paramString;
      paramString = new StringBuilder("data:image/jpeg;base64,");
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
    }
  }
  
  private static boolean bn(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    return aczy.bd(paramContext);
  }
  
  private JSONObject c(@Nullable String paramString, int paramInt)
    throws IOException, JSONException, OutOfMemoryError
  {
    Lj(paramString);
    paramString = an(paramString, paramInt);
    StringBuilder localStringBuilder = b(paramString);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("succeeded", true);
    localJSONObject.put("picData", localStringBuilder);
    localJSONObject.put("picPath", paramString);
    return localJSONObject;
  }
  
  private JSONObject d(@NonNull String paramString1, @Nullable String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("succeeded", true);
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("message", paramString2);
      }
      localJSONObject.put("videoUrl", paramString1);
      return localJSONObject;
    }
    catch (JSONException paramString1) {}
    return localJSONObject;
  }
  
  private void dsC()
  {
    if (this.mRuntime == null) {
      return;
    }
    if ((axcg.H(this.mRuntime.getActivity())) || (axcg.I(this.mRuntime.getActivity()))) {}
    for (Intent localIntent = new Intent(this.mRuntime.getActivity(), QzoneFeedsPluginProxyActivity.class);; localIntent = new Intent(this.mRuntime.getActivity(), SplashActivity.class))
    {
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      this.mRuntime.getActivity().startActivity(localIntent);
      return;
    }
  }
  
  private JSONObject e(@NonNull String paramString1, @NonNull String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("succeeded", false);
      localJSONObject.put("message", paramString2);
      localJSONObject.put("videoUrl", paramString1);
      return localJSONObject;
    }
    catch (JSONException paramString1) {}
    return localJSONObject;
  }
  
  private void gr(@Nullable String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "key_web_selected_pic_path";
    }
    axis.a().ai(str, paramString1, 0);
  }
  
  private void gs(@NonNull String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "key_web_selected_pic_path";
    }
    ThreadManager.excute(new AECameraPlugin.2(this, axis.a().t(str, "", 0), paramString1), 64, null, true);
  }
  
  private void gt(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((!TextUtils.isEmpty(this.bNP)) && (this.bNP.equals(paramString1)) && ((this.ddt == 1) || (this.ddt == 2))) {
      return;
    }
    Lh(paramString1);
    this.bNP = paramString1;
    this.ddt = 1;
    String str = lz(paramString1);
    aiip localaiip = new aiip(this, paramString1, paramString2, str);
    this.a = new DownloadRunnable(null);
    this.a.mAppInterface = this.mRuntime.a();
    this.a.mVideoUrl = paramString1;
    this.a.mLocalVideoPath = str;
    this.a.d = localaiip;
    this.a.mCallbackId = paramString2;
    ThreadManager.excute(this.a, 128, null, true);
  }
  
  private String i(String paramString, int paramInt1, int paramInt2)
  {
    String str = awtn.d.a.cTc + File.separator + "ae_pic_" + System.currentTimeMillis() + ".jpeg";
    this.cH = 0.7D;
    aqhu.compressImageJpg(paramString, str, paramInt1, paramInt2, (int)(this.cH * 100.0D));
    return str;
  }
  
  private static int ia(int paramInt)
  {
    return 53504 + paramInt;
  }
  
  private static Bitmap j(@NonNull String paramString, int paramInt)
  {
    int i = 300;
    paramString = ThumbnailUtils.createVideoThumbnail(paramString, paramInt);
    if (paramString != null)
    {
      int j = paramString.getWidth();
      paramInt = paramString.getHeight();
      if (j > 300)
      {
        float f = 300.0F / j;
        paramInt = (int)(paramInt * f);
      }
      for (;;)
      {
        return ThumbnailUtils.extractThumbnail(paramString, i, paramInt, 2);
        i = j;
      }
    }
    return paramString;
  }
  
  private String lA(@NonNull String paramString)
  {
    return awtn.d.a.cTc + File.separator + paramString.hashCode() + "_thumb.jpg";
  }
  
  private String lz(@NonNull String paramString)
  {
    Object localObject = paramString.split("\\.");
    localObject = localObject[(localObject.length - 1)];
    if (bn(this.mRuntime.getActivity())) {
      return awtn.getCameraPath() + paramString.hashCode() + "." + (String)localObject;
    }
    return awtn.d.a.cTc + File.separator + paramString.hashCode() + "." + (String)localObject;
  }
  
  private void n(Intent paramIntent, int paramInt)
  {
    int i = 400;
    if (paramInt != -1)
    {
      paramIntent = r("not get valid image");
      callJs(this.bNQ, new String[] { paramIntent.toString() });
      return;
    }
    paramIntent = paramIntent.getStringExtra("take_photo_path");
    if (this.ddu == 0)
    {
      paramInt = 400;
      if (this.ddv != 0) {
        break label90;
      }
    }
    for (;;)
    {
      ThreadManager.excute(new AECameraPlugin.1(this, paramIntent, paramInt, i), 64, null, true);
      return;
      paramInt = this.ddu;
      break;
      label90:
      i = this.ddv;
    }
  }
  
  private JSONObject r(@NonNull String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("succeeded", false);
      localJSONObject.put("message", paramString);
      return localJSONObject;
    }
    catch (JSONException paramString) {}
    return localJSONObject;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"aecamera".equals(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if ("takePhoto".equals(paramString3)) {}
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = new a();
        paramString1.ddy = paramJsBridgeListener.getInt("outMaxWidth");
        paramString1.ddz = paramJsBridgeListener.getInt("outMaxHeight");
        paramString1.cI = paramJsBridgeListener.optDouble("compression");
        paramString1.ckp = paramJsBridgeListener.optBoolean("backDevicePosition");
        paramString1.bNR = paramJsBridgeListener.optString("guideImage");
        paramString1.ckq = paramJsBridgeListener.optBoolean("enableCountDown");
        paramString1.ckr = paramJsBridgeListener.optBoolean("sensitiveValidate");
        paramString1.cks = paramJsBridgeListener.optBoolean("disableFaceDetect");
        a(paramString1, paramJsBridgeListener.getString("callback"));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        continue;
      }
      if ("setLastSelectedPicture".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          gr(paramJsBridgeListener.optString("picPath"), paramJsBridgeListener.optString("id"));
        }
        catch (Exception paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
      else if ("getLastSelectedPicture".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("id");
          gs(paramJsBridgeListener.optString("callback"), paramString1);
        }
        catch (Exception paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
      else if ("downloadVideo".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          gt(paramJsBridgeListener.optString("videoUrl"), paramJsBridgeListener.optString("callback"));
        }
        catch (Exception paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
      else if ("cancelDownload".equals(paramString3))
      {
        try
        {
          Lh(new JSONObject(paramVarArgs[0]).optString("videoUrl"));
        }
        catch (Exception paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
      else if ("shareVideo".equals(paramString3))
      {
        try
        {
          Li(new JSONObject(paramVarArgs[0]).optString("videoUrl"));
        }
        catch (Exception paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 1) {
      n(paramIntent, paramInt);
    }
    for (;;)
    {
      super.onActivityResult(paramIntent, paramByte, paramInt);
      return;
      if ((paramByte == 21) && (paramInt == -1)) {
        dsC();
      }
    }
  }
  
  static class DownloadRunnable
    implements Runnable
  {
    aolm.b d;
    AppInterface mAppInterface;
    String mCallbackId;
    String mLocalVideoPath;
    String mVideoUrl;
    
    public void run()
    {
      AECameraPlugin.b(this.mAppInterface, this.mVideoUrl, this.mLocalVideoPath, this.d);
    }
  }
  
  public static class a
  {
    public String bNR;
    public double cI;
    public boolean ckp;
    public boolean ckq;
    public boolean ckr;
    public boolean cks;
    public int ddy;
    public int ddz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AECameraPlugin
 * JD-Core Version:    0.7.0.1
 */