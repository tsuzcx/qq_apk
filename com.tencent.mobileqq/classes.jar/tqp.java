import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.fragments.QCircleHybirdFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.GpsInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class tqp
  extends WebViewPlugin
{
  @Deprecated
  private void a(String paramString) {}
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent();
      localIntent.putExtras(tra.a(localIntent.getExtras(), paramString1));
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
      c(new JSONObject(paramArrayOfString[0]).optString("callback"));
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
        b(new JSONObject(paramArrayOfString[0]).optString("callback"));
        return;
      }
      if (("reloadhomepage".equals(paramString)) && (a(paramArrayOfString)))
      {
        d(paramArrayOfString[0]);
        return;
      }
      if (("reportReadMessage".equals(paramString)) && (a(paramArrayOfString)))
      {
        h(paramArrayOfString[0]);
        return;
      }
      if (("isQCircleActive".equals(paramString)) && (a(paramArrayOfString)))
      {
        a(new JSONObject(paramArrayOfString[0]).optString("callback"));
        return;
      }
      if (("updateUserFollowState".equals(paramString)) && (a(paramArrayOfString)))
      {
        e(paramArrayOfString[0]);
        return;
      }
      if (("updateTagFollowState".equals(paramString)) && (a(paramArrayOfString)))
      {
        f(paramArrayOfString[0]);
        return;
      }
    } while ((!"authrefreshpage".equals(paramString)) || (!a(paramArrayOfString)));
    g(paramArrayOfString[0]);
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
      label151:
      callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
      return;
    }
    catch (Exception localException)
    {
      break label151;
    }
  }
  
  private void c(String paramString)
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
    callJs(paramString, new String[] { tra.a((Bundle)localObject) });
  }
  
  private void d(String paramString)
  {
    paramString = new tqq(this, paramString).getString("uin");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).a(paramString);
    }
  }
  
  private void e(String paramString)
  {
    paramString = new tqq(this, paramString);
    String str = paramString.getString("uin");
    int i = paramString.getInt("type");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).a(str, i);
    }
  }
  
  private void f(String paramString)
  {
    paramString = new tqq(this, paramString);
    String str = paramString.getString("tagId");
    int i = paramString.getInt("type");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).b(str, i);
    }
  }
  
  private void g(String paramString)
  {
    paramString = new tqq(this, paramString);
    int i = paramString.optInt("tagtype");
    int j = paramString.optInt("status");
    paramString = paramString.optString("tagname");
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.a()).a(i, j, paramString);
    }
  }
  
  private void h(String paramString)
  {
    int i = new tqq(this, paramString).getInt("createTime");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqp
 * JD-Core Version:    0.7.0.1
 */