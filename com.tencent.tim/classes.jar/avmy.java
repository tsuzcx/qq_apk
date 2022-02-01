import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import cooperation.qqreader.QRBridgeUtil;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class avmy
  extends QIPCModule
{
  private static avmy a;
  
  public avmy(String paramString)
  {
    super(paramString);
  }
  
  public static avmy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avmy("ReaderIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    avoc.d("ReaderIPCModule", "action = " + paramString);
    if (paramBundle == null)
    {
      avoc.d("ReaderIPCModule", "Err params = null, action = " + paramString);
      return null;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      avoc.d("ReaderIPCModule", "onRemoteInvoke cannot get QQAppInterface");
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("getRedTouchInfo".equals(paramString))
    {
      paramString = (altq)((QQAppInterface)localObject).getManager(36);
      localObject = paramBundle.getStringArrayList("pathList");
      if ((paramString != null) && (localObject != null))
      {
        paramBundle = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          BusinessInfoCheckUpdate.AppInfo localAppInfo = paramString.getAppInfoByPath((String)((Iterator)localObject).next());
          if (localAppInfo != null) {
            paramBundle.add(altt.a(localAppInfo));
          }
        }
        paramString = new Bundle();
        paramString.putParcelableArrayList("redTouchInfoList", paramBundle);
        return EIPCResult.createResult(0, paramString);
      }
    }
    else if ("getSingleRedTouchInfo".equals(paramString))
    {
      paramString = (altq)((QQAppInterface)localObject).getManager(36);
      if (paramString != null)
      {
        paramString = paramString.getAppInfoByPath(paramBundle.getString("path"));
        if (paramString != null)
        {
          paramString = altt.a(paramString);
          paramBundle = new Bundle();
          paramBundle.putParcelable("redTouchInfo", paramString);
          if ((paramString != null) && (paramString.If() == 1)) {
            avoc.d("ReaderIPCModule", "path=" + paramString.getPath());
          }
          return EIPCResult.createResult(0, paramBundle);
        }
      }
    }
    else
    {
      if (!"reportRedTouchClick".equals(paramString)) {
        break label396;
      }
      paramString = (altq)((QQAppInterface)localObject).getManager(36);
      if (paramString != null)
      {
        paramBundle = paramBundle.getString("path");
        paramString.OS(paramBundle);
      }
    }
    label396:
    do
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("service_type", 2);
        ((JSONObject)localObject).put("act_id", 1002);
        paramString.h(paramString.getAppInfoByPath(paramBundle), ((JSONObject)localObject).toString());
        return null;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      if ("download_reader_plugin".equals(paramString))
      {
        avlz.a().gn(((QQAppInterface)localObject).getApp());
        return EIPCResult.createResult(0, new Bundle());
      }
      if ("get_skey".equals(paramString))
      {
        paramString = new Bundle();
        paramString.putString("get_skey_value", QRBridgeUtil.getSKey((QQAppInterface)localObject));
        return EIPCResult.createResult(0, paramString);
      }
    } while (!"action_get_account".equals(paramString));
    paramString = new Bundle();
    paramString.putString("key_get_account", ((QQAppInterface)localObject).getAccount());
    return EIPCResult.createResult(0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmy
 * JD-Core Version:    0.7.0.1
 */