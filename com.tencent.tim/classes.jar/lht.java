import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.DailyDynamicHeaderModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.DailyDynamicHeaderModule.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;

public class lht
  extends lir
{
  private JSONObject aq;
  private final Object mLock = new Object();
  
  public lht(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
    startLoadFromDisk();
  }
  
  static JSONObject a(boolean paramBoolean)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localJSONObject2.put("req_type", i);
      localJSONObject2.put("ad_code", aczc.getCityCode());
      localJSONObject2.put("city_name", aczc.getCity());
      localJSONObject1.put("dynamic_header_req_param", localJSONObject2);
      return localJSONObject1;
    }
  }
  
  private void aMs()
  {
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(kxm.getAccount()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(lhf.getNetType());
    try
    {
      Object localObject = new JSONArray();
      ((JSONArray)localObject).put(a(false));
      localObject = ((JSONArray)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("DynamicHeaderModule", 2, "[requestForUpdate] req: " + (String)localObject);
      }
      localReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("DynamicHeaderModule", 1, "[requestForUpdate] ", localException);
      }
    }
    sendPbReq(lup.makeOIDBPkg("OidbSvc.0xcba", 3258, 0, localReqBody.toByteArray()));
  }
  
  private void startLoadFromDisk()
  {
    String str = (String)awit.f("sp_key_daily_dynamic_header_data", "");
    QLog.i("DynamicHeaderModule", 1, "[startLoadFromDisk] json=" + str);
    if (!TextUtils.isEmpty(str)) {
      nl(str);
    }
  }
  
  public JSONObject D()
  {
    synchronized (this.mLock)
    {
      JSONObject localJSONObject = this.aq;
      return localJSONObject;
    }
  }
  
  public void aEL() {}
  
  public void aMt()
  {
    aMs();
  }
  
  public void nl(String paramString)
  {
    boolean bool = true;
    QLog.i("DynamicHeaderModule", 1, "[updateDynamicHeaderData] jsonString=" + paramString);
    synchronized (this.mLock)
    {
      try
      {
        this.aq = new JSONObject(paramString).optJSONObject("dynamic_header_data");
        paramString = this.aq;
        if (paramString == null) {
          break label79;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label79:
          QLog.e("DynamicHeaderModule", 1, "[updateDynamicHeaderData] ", paramString);
          this.aq = null;
          bool = false;
        }
      }
      ThreadManagerV2.getUIHandlerV2().post(new DailyDynamicHeaderModule.1(this, bool));
      return;
      bool = false;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    int i = kxf.a(paramToServiceMsg, paramFromServiceMsg, paramObject, localRspBody, false);
    QLog.i("DynamicHeaderModule", 1, "[onReceive] result=" + i);
    if (i == 0)
    {
      if ((localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null))
      {
        paramToServiceMsg = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
        if ((paramToServiceMsg.bytes_nearby_cookie.has()) && (paramToServiceMsg.bytes_nearby_cookie.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.bytes_nearby_cookie.get().toStringUtf8();
          awit.H("sp_key_daily_dynamic_header_data", paramToServiceMsg);
          nl(paramToServiceMsg);
        }
      }
      return;
    }
    awit.H("sp_key_daily_dynamic_header_data", "");
    ThreadManagerV2.getUIHandlerV2().post(new DailyDynamicHeaderModule.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lht
 * JD-Core Version:    0.7.0.1
 */