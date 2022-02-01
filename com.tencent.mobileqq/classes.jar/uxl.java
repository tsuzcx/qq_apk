import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.fragments.hybird.QCircleHybirdFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.GpsInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uxl
  extends WebViewPlugin
{
  private QCircleHybirdFragment a()
  {
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      return (QCircleHybirdFragment)this.mRuntime.a();
    }
    return null;
  }
  
  private void a(String paramString)
  {
    paramString = new uxm(this, paramString);
    int i;
    if (paramString.has("titleTextColor"))
    {
      i = uxx.a(paramString, "titleTextColor");
      paramString = a();
      if (paramString != null)
      {
        if (i != -1) {
          break label45;
        }
        paramString.resetTitleBarTextColor();
      }
    }
    return;
    label45:
    paramString.setTitleBarTextColor(i | 0xFF000000);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent();
      localIntent.putExtras(uxx.a(localIntent.getExtras(), paramString1));
      ((Activity)localObject).setResult(-1, localIntent);
    } while (TextUtils.isEmpty(paramString2));
    localObject = localIntent.getStringExtra("key_parse_data_error_msg");
    paramString1 = "{\"ret\":0, \"msg\":\"sucess\"}";
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString1 = "{\"ret\":-1, \"msg\":\"" + (String)localObject + "\"}";
    }
    callJs(paramString2, new String[] { paramString1 });
  }
  
  private void a(String paramString, String[] paramArrayOfString)
  {
    if (("getLabel".equals(paramString)) && (a(paramArrayOfString))) {
      e(new JSONObject(paramArrayOfString[0]).optString("callback"));
    }
    do
    {
      return;
      if (("setLabel".equals(paramString)) && (a(paramArrayOfString)))
      {
        paramString = new JSONObject(paramArrayOfString[0]);
        a(paramArrayOfString[0], paramString.optString("callback"));
        return;
      }
      if (("getGpsInfo".equals(paramString)) && (a(paramArrayOfString)))
      {
        d(new JSONObject(paramArrayOfString[0]).optString("callback"));
        return;
      }
      if (("reloadhomepage".equals(paramString)) && (a(paramArrayOfString)))
      {
        f(paramArrayOfString[0]);
        return;
      }
      if (("reportReadMessage".equals(paramString)) && (a(paramArrayOfString)))
      {
        l(paramArrayOfString[0]);
        return;
      }
      if (("isQCircleActive".equals(paramString)) && (a(paramArrayOfString)))
      {
        c(new JSONObject(paramArrayOfString[0]).optString("callback"));
        return;
      }
      if (("updateUserFollowState".equals(paramString)) && (a(paramArrayOfString)))
      {
        i(paramArrayOfString[0]);
        return;
      }
      if (("updateTagFollowState".equals(paramString)) && (a(paramArrayOfString)))
      {
        j(paramArrayOfString[0]);
        return;
      }
      if (("authrefreshpage".equals(paramString)) && (a(paramArrayOfString)))
      {
        k(paramArrayOfString[0]);
        return;
      }
      if (("refreshFeedList".equals(paramString)) && (a(paramArrayOfString)))
      {
        g(paramArrayOfString[0]);
        return;
      }
      if (("refreshHippyPage".equals(paramString)) && (a(paramArrayOfString)))
      {
        h(paramArrayOfString[0]);
        return;
      }
      if (("saveimage".equals(paramString)) && (a(paramArrayOfString)))
      {
        b(paramArrayOfString[0]);
        return;
      }
    } while ((!"setTitleBarStyle".equals(paramString)) || (!a(paramArrayOfString)));
    a(paramArrayOfString[0]);
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1))
    {
      QLog.e("QCircleJsPlugin", 2, "args is null");
      bool = false;
    }
    return bool;
  }
  
  private void b(String paramString)
  {
    Object localObject1 = new uxm(this, paramString);
    paramString = ((uxm)localObject1).getString("callback");
    localObject1 = ((uxm)localObject1).optJSONArray("images");
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < ((JSONArray)localObject1).length())
    {
      Object localObject2 = ((JSONArray)localObject1).getJSONObject(i).getString("image");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = awzl.a(localObject2.split(",")[1]);
        localObject2 = BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length);
        JSONObject localJSONObject = new JSONObject();
        if (localObject2 != null)
        {
          String str1 = System.currentTimeMillis() + ".jpeg";
          String str2 = bhgg.a(anhk.bg);
          File localFile = new File(str2);
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
          str1 = str2 + str1;
          if (bmiz.a((Bitmap)localObject2, str1, Bitmap.CompressFormat.JPEG, 100, true))
          {
            localJSONObject.put("path", str1);
            localJSONArray.put(localJSONObject);
            QLog.i("QCircleJsPlugin", 1, "handleBase64ToPics... file save success:" + str1);
          }
          else
          {
            QLog.e("QCircleJsPlugin", 1, "handleBase64ToPics... file save failed:" + str1);
          }
        }
      }
    }
    QLog.i("QCircleJsPlugin", 1, "handleBase64ToPics... list:" + localJSONArray.toString());
    callJs("window." + paramString + "({result:" + localJSONArray.toString() + "})");
  }
  
  @Deprecated
  private void c(String paramString) {}
  
  private void d(String paramString)
  {
    Object localObject1 = this.mRuntime.a();
    if ((localObject1 == null) || (((Activity)localObject1).isFinishing()) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        localObject1 = ((Activity)localObject1).getIntent();
      } while (localObject1 == null);
      localObject1 = ((Intent)localObject1).getExtras();
    } while (localObject1 == null);
    Object localObject2 = (LbsDataV2.GpsInfo)((Bundle)localObject1).getParcelable("key_gps_info");
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new LbsDataV2.GpsInfo();
      ((LbsDataV2.GpsInfo)localObject1).lat = 0;
      ((LbsDataV2.GpsInfo)localObject1).lon = 0;
      ((LbsDataV2.GpsInfo)localObject1).alt = 0;
      ((LbsDataV2.GpsInfo)localObject1).gpsType = 0;
    }
    localObject2 = new JSONObject();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("lat", ((LbsDataV2.GpsInfo)localObject1).lat);
      localJSONObject.put("lon", ((LbsDataV2.GpsInfo)localObject1).lon);
      localJSONObject.put("alt", ((LbsDataV2.GpsInfo)localObject1).alt);
      ((JSONObject)localObject2).put("gpsInfo", localJSONObject);
      label156:
      callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
      return;
    }
    catch (Exception localException)
    {
      break label156;
    }
  }
  
  private void e(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing()) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        localObject = ((Activity)localObject).getIntent();
      } while (localObject == null);
      localObject = ((Intent)localObject).getExtras();
    } while (localObject == null);
    callJs(paramString, new String[] { uxx.a((Bundle)localObject) });
  }
  
  private void f(String paramString)
  {
    paramString = new uxm(this, paramString).getString("uin");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).a(paramString);
    }
  }
  
  private void g(String paramString)
  {
    paramString = new uxm(this, paramString).getString("page");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).b(paramString);
    }
  }
  
  private void h(String paramString)
  {
    paramString = new uxm(this, paramString).getString("module");
    Intent localIntent = new Intent();
    localIntent.setAction("action_refresh_hippy_page");
    localIntent.putExtra("pageType", paramString);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  private void i(String paramString)
  {
    Object localObject = new uxm(this, paramString);
    paramString = ((uxm)localObject).getString("uin");
    int i = ((uxm)localObject).getInt("type");
    int j = ((uxm)localObject).optInt("isDoubly");
    localObject = ((uxm)localObject).optString("nick");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).a(paramString, i, j, (String)localObject);
    }
  }
  
  private void j(String paramString)
  {
    paramString = new uxm(this, paramString);
    String str = paramString.getString("tagId");
    int i = paramString.getInt("type");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).a(str, i);
    }
  }
  
  private void k(String paramString)
  {
    paramString = new uxm(this, paramString);
    int i = paramString.optInt("tagtype");
    int j = paramString.optInt("status");
    paramString = paramString.optString("tagname");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).a(i, j, paramString);
    }
  }
  
  private void l(String paramString)
  {
    int i = new uxm(this, paramString).getInt("createTime");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment)))
    {
      QLog.d("QCircleJsPlugin", 1, "reportReadMessage createTime" + i);
      ((QCircleHybirdFragment)this.mRuntime.a()).a(i);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("qcircle".equals(paramString2))
    {
      QLog.i("QCircleJsPlugin", 2, "handleJsRequest:" + paramString1);
      try
      {
        a(paramString3, paramVarArgs);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          QLog.d("QCircleJsPlugin", 2, paramJsBridgeListener, new Object[0]);
        }
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxl
 * JD-Core Version:    0.7.0.1
 */