import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import cooperation.qzone.webviewplugin.QzonePhotoWallPlugin.2;
import cooperation.qzone.webviewplugin.QzonePhotoWallPlugin.3;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class awfx
  extends awfr
{
  public static Set<String> dy = new HashSet();
  private byte bI = 115;
  JSONObject cn = null;
  private boolean dqh;
  private boolean dqi = false;
  int eAA = 0;
  int eAz = 3;
  public int mFrom = 4;
  public int mSource = 0;
  int pickerType = 0;
  
  private void I(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramArrayList.size())
        {
          Object localObject = (String)paramArrayList.get(i);
          long l1 = System.currentTimeMillis();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            String str2 = d((String)localObject, this.f.mRuntime.getActivity().getApplicationContext());
            dy.add(str2);
            localObject = awfn.a(str2);
            if (localObject != null)
            {
              QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize with =" + ((awfn.a)localObject).width + " height=" + ((awfn.a)localObject).height + " compressType=" + this.eAA);
              if (this.eAA != 3)
              {
                double d = a(this.f.mRuntime.getActivity(), this.eAA, (awfn.a)localObject);
                if (d > 0.0D)
                {
                  ((awfn.a)localObject).width = ((int)(((awfn.a)localObject).width / d));
                  ((awfn.a)localObject).height = ((int)(((awfn.a)localObject).height / d));
                }
              }
              QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize change width =" + ((awfn.a)localObject).width + " height=" + ((awfn.a)localObject).height + " compressType=" + this.eAA);
              String str1 = awfn.k(str2, ((awfn.a)localObject).width, ((awfn.a)localObject).height);
              boolean bool = TextUtils.isEmpty(str1);
              if (!bool) {
                try
                {
                  JSONObject localJSONObject = new JSONObject();
                  localJSONObject.put("currentIndex", i);
                  String str3;
                  if ((Qb() == 2) || (!paramBoolean))
                  {
                    QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize before path =" + str2);
                    str3 = Base64.encodeToString(str2.getBytes(), 2);
                    localJSONObject.put("identifier", str3);
                    QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize toH5 identifier =" + str3);
                  }
                  int j = 0;
                  if (!this.dqi)
                  {
                    str3 = "" + "data:image/jpg;base64," + str1;
                    j = str1.length();
                    localJSONObject.put("imageSize", j);
                    localJSONObject.put("data", str3);
                  }
                  this.f.callJs("window.QZImagePickerJSInterface.onReceive(" + localJSONObject.toString() + ")");
                  long l2 = System.currentTimeMillis();
                  QLog.i("QzonePhotoWallPlugin", 2, "@coverOptimize  path=" + str2 + " timediff=" + (l2 - l1) + " length=" + j + " compressType =" + this.eAA + " with =" + ((awfn.a)localObject).width + " height=" + ((awfn.a)localObject).height);
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  QLog.e("QzonePhotoWallPlugin", 2, "imageBase64 size=" + str1.length() + ",compressType=" + this.eAA + ",width=" + ((awfn.a)localObject).width + ",height=" + ((awfn.a)localObject).height + "," + localOutOfMemoryError);
                  arxa.a().showToast(acfp.m(2131713254), 1);
                }
              }
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramArrayList)
      {
        QLog.e("QzonePhotoWallPlugin", 1, "toBase64: " + paramArrayList);
      }
      i += 1;
    }
  }
  
  private int Qb()
  {
    if (this.eAz > 1) {
      return 1;
    }
    return 2;
  }
  
  public static double a(Context paramContext, int paramInt, awfn.a parama)
  {
    if (parama != null)
    {
      int i = parama.width;
      int j = parama.height;
      int k;
      if (i < j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        paramContext = avpw.a(paramContext, k, j, paramInt, false);
        double d3;
        if ((paramContext == null) || ((k <= paramContext.width) && (j <= paramContext.height)))
        {
          d3 = 0.0D;
          return d3;
        }
        double d1;
        if (k > j) {
          d1 = k / paramContext.width;
        }
        for (double d2 = j / paramContext.height;; d2 = k / paramContext.height)
        {
          d3 = d1;
          if (d1 > d2) {
            break;
          }
          return d2;
          d1 = j / paramContext.width;
        }
        k = i;
      }
    }
    return 0.0D;
  }
  
  private static void a(Activity paramActivity, WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = AbsBaseWebViewActivity.a(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i);
    paramActivity.startActivity(paramIntent);
  }
  
  private void abh(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.pickerType = paramString.getInt("pickerType");
      this.eAz = paramString.getInt("maxPickCount");
      this.eAA = i(paramString);
      this.cn = paramString.optJSONObject("userInfo");
      this.dqh = paramString.optBoolean("clipByH5");
      this.dqi = paramString.optBoolean("noNeedImageData", false);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void abi(String paramString)
  {
    if ("MobileAlbum".equals(paramString)) {
      if (awdb.a(this.f.mRuntime.getActivity(), new awfy(this), 1)) {}
    }
    while (!"QzoneAlbum".equals(paramString))
    {
      return;
      eDy();
      return;
    }
    paramString = new Bundle();
    paramString.putInt("key_personal_album_enter_model", Qb());
    paramString.putInt("_input_max", this.eAz);
    paramString.putBoolean("key_multiple_model_need_download_img", true);
    avpw.d locald = avpw.d.a();
    locald.cMP = this.f.mRuntime.a().getAccount();
    paramString.putString("keyAction", "actionSelectPicture");
    paramString.putBoolean("key_need_change_to_jpg", false);
    avpw.a(this.f.mRuntime.getActivity(), locald, paramString, this.bI);
  }
  
  public static String d(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return paramString;
      localObject = new File(paramString);
    } while ((!((File)localObject).exists()) || (!((File)localObject).canRead()) || (!SharpPUtil.isSharpPFile((File)localObject)));
    try
    {
      if (!aszy.cv(paramContext))
      {
        QLog.w("QzonePhotoWallPlugin", 1, "------ sharpp is not avaliable.");
        return paramString;
      }
    }
    catch (Throwable paramContext) {}
    for (;;)
    {
      QLog.e("QzonePhotoWallPlugin", 1, "decodeSharpP catch an exception: ", paramContext);
      return paramString;
      localObject = SharpPUtil.decodeSharpPByFilePath(((File)localObject).getAbsolutePath());
      if (localObject == null) {
        break;
      }
      String str = String.valueOf(System.currentTimeMillis()) + ".jpeg";
      paramContext = aqul.getSDKPrivatePath(acbn.oM + str);
      boolean bool = awcr.saveBitmapToFile((Bitmap)localObject, paramContext, Bitmap.CompressFormat.JPEG, 90, true);
      if (!bool) {
        break;
      }
      try
      {
        QLog.i("QzonePhotoWallPlugin", 1, "------ sharpp file save success:" + str);
        return paramContext;
      }
      catch (Throwable localThrowable)
      {
        paramString = paramContext;
        paramContext = localThrowable;
      }
    }
  }
  
  private void eDy()
  {
    Intent localIntent = new Intent(this.f.mRuntime.getActivity(), NewPhotoListActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", this.eAz);
    ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
    ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    if (this.eAz > 1) {}
    for (boolean bool = false;; bool = true)
    {
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", bool);
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", this.dqh);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      ((Bundle)localObject).putInt("uintype", 0);
      localIntent.putExtras((Bundle)localObject);
      avpw.ay(localIntent);
      localObject = this.f.mRuntime.getActivity();
      if (localObject == null) {
        break;
      }
      a((Activity)localObject, this.f, localIntent, this.bI);
      return;
    }
    QLog.e("QzonePhotoWallPlugin", 1, "launchCustom MobileAlbum activity is null");
  }
  
  private void fw(ArrayList<String> paramArrayList)
  {
    ThreadManager.post(new QzonePhotoWallPlugin.2(this, paramArrayList), 8, null, false);
  }
  
  private void fx(ArrayList<String> paramArrayList)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.cn == null) {
          this.cn = new JSONObject();
        }
        localJSONObject.put("userInfo", this.cn);
        if (paramArrayList != null) {
          continue;
        }
        i = 0;
        localJSONObject.put("totalPickCount", i);
        this.f.callJs("window.QZImagePickerJSInterface.doSelectPhoto(" + localJSONObject.toString() + ")");
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      if ((Qb() == 2) && (paramArrayList != null) && (paramArrayList.size() != 0)) {
        dy.add(paramArrayList.get(0));
      }
      ThreadManager.post(new QzonePhotoWallPlugin.3(this, paramArrayList), 8, null, false);
      return;
      i = paramArrayList.size();
    }
  }
  
  private int i(JSONObject paramJSONObject)
  {
    switch (paramJSONObject.optInt("compressType", 0))
    {
    default: 
      return 0;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.bI))
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      Intent localIntent = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if ((i == this.bI) && (j == -1))
      {
        if (Qb() != 1) {
          break label129;
        }
        paramString = localIntent.getStringArrayListExtra("key_cover_selected_img_path");
      }
      for (;;)
      {
        fx(paramString);
        return true;
        label129:
        paramString = new ArrayList();
        paramMap = localIntent.getStringExtra("key_cover_selected_img_path");
        if (!TextUtils.isEmpty(paramMap)) {
          paramString.add(paramMap);
        }
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!paramString2.equals("QZImagePicker")) || (this.f == null) || (this.f.mRuntime == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if (!paramString3.equals("choosePhoto")) {
          break;
        }
        bool1 = bool2;
      } while (paramVarArgs == null);
      bool1 = bool2;
    } while (paramVarArgs.length <= 0);
    abh(paramVarArgs[0]);
    this.eAA = 0;
    if (this.pickerType == 0)
    {
      abi("MobileAlbum");
      return true;
    }
    abi("QzoneAlbum");
    return true;
    if (paramString3.equals("getLocalImage")) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.eAA = i(paramJsBridgeListener);
        paramJsBridgeListener = paramJsBridgeListener.optString("identifier", "");
        if (TextUtils.isEmpty(paramJsBridgeListener))
        {
          QLog.w("QzonePhotoWallPlugin", 2, "@coverOptimize  identifier is null or size is 0 ");
          return false;
        }
        paramJsBridgeListener = new String(Base64.decode(paramJsBridgeListener, 2));
        paramString1 = new ArrayList();
        paramString1.add(paramJsBridgeListener);
        QLog.i("QzonePhotoWallPlugin", 1, "@coverOptimize  identifier =" + paramJsBridgeListener);
        if (!dy.contains(paramJsBridgeListener))
        {
          QLog.w("QzonePhotoWallPlugin", 2, "@coverOptimize  identifier is wrong identifier = " + paramJsBridgeListener);
          return false;
        }
        this.dqi = false;
        fw(paramString1);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if ((paramByte == this.bI) && (paramInt == -1))
    {
      ArrayList localArrayList2 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      ArrayList localArrayList1;
      if (localArrayList2 != null)
      {
        localArrayList1 = localArrayList2;
        if (!localArrayList2.isEmpty()) {}
      }
      else
      {
        localArrayList2 = new ArrayList(1);
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        localArrayList1 = localArrayList2;
        if (!TextUtils.isEmpty(paramIntent))
        {
          localArrayList2.add(paramIntent);
          localArrayList1 = localArrayList2;
        }
      }
      fx(localArrayList1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfx
 * JD-Core Version:    0.7.0.1
 */