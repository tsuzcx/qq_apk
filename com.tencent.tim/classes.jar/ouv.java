import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.fragments.QCircleHybirdFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.GpsInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class ouv
  extends WebViewPlugin
{
  private boolean c(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1))
    {
      QLog.e("QCircleJsPlugin", 2, "args is null");
      bool = false;
    }
    return bool;
  }
  
  private void cc(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent();
      localIntent.putExtras(ovd.a(localIntent.getExtras(), paramString1));
      ((Activity)localObject).setResult(-1, localIntent);
    } while (TextUtils.isEmpty(paramString2));
    localObject = localIntent.getStringExtra("key_parse_data_error_msg");
    paramString1 = "{\"ret\":0, \"msg\":\"sucess\"}";
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString1 = "{\"ret\":-1, \"msg\":\"" + (String)localObject + "\"}";
    }
    callJs(paramString2, new String[] { paramString1 });
  }
  
  private void f(String paramString, String[] paramArrayOfString)
    throws JSONException
  {
    if (("getLabel".equals(paramString)) && (c(paramArrayOfString))) {
      qg(new JSONObject(paramArrayOfString[0]).optString("callback"));
    }
    do
    {
      return;
      if (("setLabel".equals(paramString)) && (c(paramArrayOfString)))
      {
        paramString = new JSONObject(paramArrayOfString[0]);
        cc(paramArrayOfString[0], paramString.optString("callback"));
        return;
      }
      if (("getGpsInfo".equals(paramString)) && (c(paramArrayOfString)))
      {
        qf(new JSONObject(paramArrayOfString[0]).optString("callback"));
        return;
      }
      if (("reloadhomepage".equals(paramString)) && (c(paramArrayOfString)))
      {
        qh(paramArrayOfString[0]);
        return;
      }
      if (("reportReadMessage".equals(paramString)) && (c(paramArrayOfString)))
      {
        ql(paramArrayOfString[0]);
        return;
      }
      if (("isQCircleActive".equals(paramString)) && (c(paramArrayOfString)))
      {
        qe(new JSONObject(paramArrayOfString[0]).optString("callback"));
        return;
      }
      if (("updateUserFollowState".equals(paramString)) && (c(paramArrayOfString)))
      {
        qi(paramArrayOfString[0]);
        return;
      }
      if (("updateTagFollowState".equals(paramString)) && (c(paramArrayOfString)))
      {
        qj(paramArrayOfString[0]);
        return;
      }
    } while ((!"authrefreshpage".equals(paramString)) || (!c(paramArrayOfString)));
    qk(paramArrayOfString[0]);
  }
  
  @Deprecated
  private void qe(String paramString) {}
  
  private void qf(String paramString)
  {
    Object localObject1 = this.mRuntime.getActivity();
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
  
  private void qg(String paramString)
  {
    Object localObject = this.mRuntime.getActivity();
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
    callJs(paramString, new String[] { ovd.c((Bundle)localObject) });
  }
  
  private void qh(String paramString)
    throws JSONException
  {
    paramString = new ouv.a(paramString).getString("uin");
    if ((this.mRuntime != null) && ((this.mRuntime.b() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.b()).qy(paramString);
    }
  }
  
  private void qi(String paramString)
    throws JSONException
  {
    paramString = new ouv.a(paramString);
    String str = paramString.getString("uin");
    int i = paramString.getInt("type");
    if ((this.mRuntime != null) && ((this.mRuntime.b() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.b()).bc(str, i);
    }
  }
  
  private void qj(String paramString)
    throws JSONException
  {
    paramString = new ouv.a(paramString);
    String str = paramString.getString("tagId");
    int i = paramString.getInt("type");
    if ((this.mRuntime != null) && ((this.mRuntime.b() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.b()).bd(str, i);
    }
  }
  
  private void qk(String paramString)
    throws JSONException
  {
    paramString = new ouv.a(paramString);
    int i = paramString.optInt("tagtype");
    int j = paramString.optInt("status");
    paramString = paramString.optString("tagname");
    if ((this.mRuntime != null) && ((this.mRuntime.b() instanceof QCircleHybirdFragment))) {
      ((QCircleHybirdFragment)this.mRuntime.b()).o(i, j, paramString);
    }
  }
  
  private void ql(String paramString)
    throws JSONException
  {
    int i = new ouv.a(paramString).getInt("createTime");
    if ((this.mRuntime != null) && ((this.mRuntime.b() instanceof QCircleHybirdFragment)))
    {
      QLog.d("QCircleJsPlugin", 1, "reportReadMessage createTime" + i);
      ((QCircleHybirdFragment)this.mRuntime.b()).vm(i);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("qcircle".equals(paramString2))
    {
      QLog.i("QCircleJsPlugin", 2, "handleJsRequest:" + paramString1);
      try
      {
        f(paramString3, paramVarArgs);
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
  
  public class a
    extends JSONObject
  {
    public a(String paramString)
      throws JSONException
    {
      super();
    }
    
    public int getInt(String paramString)
      throws JSONException
    {
      if (!has(paramString)) {
        return 0;
      }
      return super.getInt(paramString);
    }
    
    public String getString(String paramString)
      throws JSONException
    {
      if (!has(paramString)) {
        return "";
      }
      return super.getString(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ouv
 * JD-Core Version:    0.7.0.1
 */