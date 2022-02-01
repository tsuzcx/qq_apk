import android.text.TextUtils;
import com.tencent.open.wadl.WadlJsBridge;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class ascd
{
  private asce a = new asce();
  private WadlJsBridge b = new WadlJsBridge(null, null, this.a);
  
  public void XG(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", paramString);
      localJSONArray.put(localJSONObject);
      this.b.a().getQueryDownloadAction(localJSONArray.toString(), null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("WadlMainBridge", 1, paramString, new Object[0]);
    }
  }
  
  public void a(asce.a parama)
  {
    this.a.b(parama);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, ArrayList<WadlResult> paramArrayList)
  {
    boolean bool2;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      bool2 = true;
    }
    boolean bool1;
    do
    {
      return bool2;
      paramArrayList = paramArrayList.iterator();
      bool1 = true;
      bool2 = bool1;
    } while (!paramArrayList.hasNext());
    WadlResult localWadlResult = (WadlResult)paramArrayList.next();
    WadlParams localWadlParams = localWadlResult.a;
    if ((paramString1.equals(localWadlParams.appId)) && (paramString2.equals(localWadlParams.apkUrl)) && (paramInt == localWadlParams.versionCode) && (!TextUtils.isEmpty(localWadlResult.aJb)) && (ahbj.isFileExists(localWadlResult.aJb))) {
      bool1 = false;
    }
    for (;;)
    {
      break;
    }
  }
  
  public void d(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (paramInt == 2) {}
    try
    {
      String str = paramJSONObject.optString("appId");
      if (!TextUtils.isEmpty(str)) {
        awok.a().cC(7, str);
      }
      paramJSONObject.put("actionCode", paramInt);
      this.b.a().a(paramJSONObject.toString(), false, 7, null);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("WadlMainBridge", 1, paramJSONObject, new Object[0]);
    }
  }
  
  public void destroy()
  {
    this.b.doOnDestroy();
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ascd
 * JD-Core Version:    0.7.0.1
 */