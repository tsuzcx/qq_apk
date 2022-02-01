import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment.b;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelHeaderModule.1;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelHeaderModule.3;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.JSONUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ProteusJsHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class lbk
{
  private ConcurrentHashMap<Integer, List<ReadInJoyDynamicChannelBaseFragment.b>> bb = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, List<lbm>> bc = new ConcurrentHashMap();
  private ExecutorService mExecutorService = MonitorTimeExecutor.e();
  private Handler mMainThreadHandler;
  
  public lbk(Handler paramHandler)
  {
    this.mMainThreadHandler = paramHandler;
  }
  
  private boolean Bt()
  {
    return (this.mExecutorService != null) && (!this.mExecutorService.isShutdown());
  }
  
  public static lbk a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    if (localQQAppInterface != null) {
      return ((lcd)localQQAppInterface.getManager(163)).b().b();
    }
    return null;
  }
  
  private JSONObject a(JSONObject paramJSONObject, int paramInt, ReadInJoyDynamicChannelBaseFragment.b paramb)
  {
    long l = System.currentTimeMillis();
    QLog.d("DynamicChannelHeaderModule", 1, "preProcessReqData, begin.");
    Object localObject2 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.bl(paramInt));
    Object localObject1 = paramJSONObject;
    if (localObject2 != null)
    {
      localObject2 = ((npi)localObject2).a();
      localObject1 = paramJSONObject;
      if (localObject2 != null)
      {
        localObject1 = ((lan)localObject2).eF("dp_environment_id");
        localObject2 = paramb.aeb;
        paramb = new StringBuffer();
        localObject2 = (String)ProteusJsHelper.evaluateJs((String)localObject1, (String)localObject2, paramJSONObject.toString(), paramb);
        QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "preProcessReqData res = ", localObject2, ", exception = ", paramb });
        localObject1 = paramJSONObject;
      }
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = new JSONObject((String)localObject2);
      }
      QLog.d("DynamicChannelHeaderModule", 1, new Object[] { "preProcessReqData time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
      return localObject1;
    }
    catch (JSONException paramb)
    {
      for (;;)
      {
        QLog.d("DynamicChannelHeaderModule", 2, "preProcessReqData e = ", paramb);
        localObject1 = paramJSONObject;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, ReadInJoyDynamicChannelBaseFragment.b paramb)
  {
    JSONObject localJSONObject = a(c(paramInt1), paramInt1, paramb);
    Bundle localBundle = JSONUtils.b(localJSONObject);
    HashMap localHashMap = new HashMap();
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", BaseApplicationImpl.getApplication());
    localBundle = new Bundle();
    localBundle.putInt("insert_index", paramInt2);
    new aprc(JSONUtils.b(localJSONObject, paramb.aea), "POST", new lbl(this, paramInt1, paramb), 1000, localBundle).J(localHashMap);
  }
  
  private void a(int paramInt, lbm paramlbm)
  {
    if (paramlbm == null) {
      return;
    }
    Object localObject = (List)this.bc.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.bc.put(Integer.valueOf(paramInt), localObject);
    }
    for (;;)
    {
      if (((List)localObject).size() > 0)
      {
        paramInt = 0;
        while (paramInt < ((List)localObject).size())
        {
          lbm locallbm = (lbm)((List)localObject).get(paramInt);
          if (locallbm.aMT > paramlbm.aMT)
          {
            ((List)localObject).add(paramInt, paramlbm);
            QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "putHeaderDataModel, i = ", Integer.valueOf(paramInt), "dataModel = ", locallbm });
            return;
          }
          paramInt += 1;
        }
      }
      ((List)localObject).add(paramlbm);
      return;
    }
  }
  
  private void a(int paramInt, JSONObject paramJSONObject, Bundle paramBundle, ReadInJoyDynamicChannelBaseFragment.b paramb)
  {
    if (paramJSONObject == null)
    {
      QLog.d("DynamicChannelHeaderModule", 2, "handleRequest result is null");
      b(paramInt, false, null, 0);
    }
    int i;
    do
    {
      return;
      QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "result = ", paramJSONObject, ", requestParams = ", paramBundle });
      long l = System.currentTimeMillis();
      QLog.d("DynamicChannelHeaderModule", 1, "handleRequest, begin processRecData");
      paramJSONObject = b(paramJSONObject, paramInt, paramb);
      QLog.d("DynamicChannelHeaderModule", 1, new Object[] { "handleRequest, processedResult time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
      QLog.d("DynamicChannelHeaderModule", 1, new Object[] { "handleRequest, processedResult = ", paramJSONObject });
      if (paramJSONObject == null)
      {
        QLog.d("DynamicChannelHeaderModule", 2, "handleRequest processedResult is null");
        b(paramInt, false, null, 0);
        return;
      }
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject == null)
      {
        QLog.d("DynamicChannelHeaderModule", 2, "handleRequest data is null.");
        b(paramInt, false, null, 0);
        return;
      }
      Object localObject = paramJSONObject.optJSONObject("commonInfo");
      paramJSONObject = paramJSONObject.optJSONArray("dataList");
      paramb = new ArrayList();
      if ((localObject == null) || (paramJSONObject == null)) {
        break;
      }
      localObject = ((JSONObject)localObject).optString("cookieString");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        awit.H("readinjoy_dynamic_channel_header_cookie_" + paramInt, localObject);
      }
      if (paramJSONObject.length() == 0)
      {
        QLog.d("DynamicChannelHeaderModule", 2, "handleRequest dataList is null.");
        b(paramInt, false, null, 0);
        return;
      }
      i = 0;
      if (paramBundle != null) {
        i = paramBundle.getInt("insert_index");
      }
      int j = 0;
      while (j < paramJSONObject.length())
      {
        paramBundle = paramJSONObject.optJSONObject(j);
        if (paramBundle != null)
        {
          localObject = paramBundle.optString("style_ID", "");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            lbm locallbm = new lbm();
            locallbm.styleID = ((String)localObject);
            locallbm.proteusData = paramBundle.toString();
            locallbm.aMT = i;
            paramb.add(locallbm);
            QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "handleRequest [", Integer.valueOf(j), "] = ", locallbm });
          }
        }
        j += 1;
      }
    } while (paramb.size() <= 0);
    p(paramInt, paramb);
    b(paramInt, true, q(paramInt), i);
    return;
    QLog.d("DynamicChannelHeaderModule", 2, "handleRequest commonInfo or dataList is null.");
    b(paramInt, false, null, 0);
  }
  
  private JSONObject b(JSONObject paramJSONObject, int paramInt, ReadInJoyDynamicChannelBaseFragment.b paramb)
  {
    Object localObject2 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.bl(paramInt));
    Object localObject1 = paramJSONObject;
    if (localObject2 != null)
    {
      localObject2 = ((npi)localObject2).a();
      localObject1 = paramJSONObject;
      if (localObject2 != null)
      {
        localObject1 = ((lan)localObject2).eF("dp_environment_id");
        localObject2 = paramb.aec;
        paramb = new StringBuffer();
        localObject2 = (String)ProteusJsHelper.evaluateJs((String)localObject1, (String)localObject2, paramJSONObject.toString(), paramb);
        QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "preProcessRecData res = ", localObject2, ", exception = ", paramb });
        localObject1 = paramJSONObject;
      }
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = new JSONObject((String)localObject2);
      }
      return localObject1;
    }
    catch (JSONException paramb)
    {
      QLog.d("DynamicChannelHeaderModule", 2, "preProcessRecData e = ", paramb);
    }
    return paramJSONObject;
  }
  
  private void b(int paramInt1, boolean paramBoolean, List<lbm> paramList, int paramInt2)
  {
    this.mMainThreadHandler.post(new DynamicChannelHeaderModule.3(this, paramInt1, paramBoolean, paramList, paramInt2));
  }
  
  private JSONObject c(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        str = kxm.iT();
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        localJSONObject.put("imei", str);
        localJSONObject.put("platform", "Android");
        localJSONObject.put("qqVersionID", "3.4.4");
        localObject = (QQAppInterface)kxm.getAppRuntime();
        str = ((QQAppInterface)localObject).getAccount();
        localObject = ((TicketManager)((QQAppInterface)localObject).getManager(2)).getSkey(str);
        localJSONObject.put("uin", str);
        if (localObject != null) {
          continue;
        }
        str = "";
        localJSONObject.put("token", str);
        localJSONObject.put("cookieString", awit.f("readinjoy_dynamic_channel_header_cookie_" + paramInt, ""));
      }
      catch (JSONException localJSONException)
      {
        String str;
        Object localObject;
        QLog.d("DynamicChannelHeaderModule", 2, "makeRequestParams, e = ", localJSONException);
        continue;
      }
      QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "makeRequestParams params = ", localJSONObject });
      return localJSONObject;
      str = "";
      continue;
      str = msg.ej((String)localObject);
    }
  }
  
  private void p(int paramInt, List<lbm> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramInt, (lbm)paramList.next());
      }
    }
  }
  
  public void aEL()
  {
    this.bc.clear();
    this.bb.clear();
    if (this.mExecutorService != null) {
      this.mExecutorService.shutdownNow();
    }
  }
  
  public List<lbm> q(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.bc.get(Integer.valueOf(paramInt));
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
  
  public void q(int paramInt, List<ReadInJoyDynamicChannelBaseFragment.b> paramList)
  {
    if ((paramInt == -1) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.bb.put(Integer.valueOf(paramInt), paramList);
  }
  
  public void qg(int paramInt)
  {
    List localList = (List)this.bb.get(Integer.valueOf(paramInt));
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        ReadInJoyDynamicChannelBaseFragment.b localb = (ReadInJoyDynamicChannelBaseFragment.b)localList.get(i);
        if ((!TextUtils.isEmpty(localb.styleID)) && (!TextUtils.isEmpty(localb.proteusData)))
        {
          lbm locallbm = new lbm();
          locallbm.styleID = localb.styleID;
          locallbm.proteusData = localb.proteusData;
          locallbm.aMT = i;
          localArrayList.add(locallbm);
        }
        i += 1;
      }
      this.bc.put(Integer.valueOf(paramInt), localArrayList);
    }
  }
  
  public void qh(int paramInt)
  {
    List localList = (List)this.bb.get(Integer.valueOf(paramInt));
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        ReadInJoyDynamicChannelBaseFragment.b localb = (ReadInJoyDynamicChannelBaseFragment.b)localList.get(i);
        if ((!TextUtils.isEmpty(localb.aea)) && (Bt())) {
          this.mExecutorService.execute(new DynamicChannelHeaderModule.1(this, paramInt, i, localb));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lbk
 * JD-Core Version:    0.7.0.1
 */