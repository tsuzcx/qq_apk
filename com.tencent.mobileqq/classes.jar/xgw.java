import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.videostory.network.observer.VSDispatchObserver.1;
import com.tencent.biz.videostory.network.observer.VSDispatchObserver.2;
import com.tencent.biz.videostory.network.observer.VSDispatchObserver.3;
import com.tencent.biz.videostory.network.observer.VSDispatchObserver.4;
import com.tencent.biz.videostory.network.observer.VSDispatchObserver.5;
import com.tencent.biz.videostory.network.observer.VSDispatchObserver.6;
import com.tencent.biz.videostory.network.observer.VSDispatchObserver.7;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;

public class xgw
  implements BusinessObserver
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private volatile ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, xgx>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private void a(int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localObject2 == null)
    {
      QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: cmdCallback has All Removed");
      return;
    }
    VSBaseRequest localVSBaseRequest = (VSBaseRequest)paramBundle.getSerializable("key_request_data");
    if (localVSBaseRequest == null)
    {
      QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: request is null");
      return;
    }
    if (((ConcurrentHashMap)localObject2).get(Integer.valueOf(localVSBaseRequest.getCurrentSeq())) == null)
    {
      QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: CmdName:" + localVSBaseRequest.getCmdName() + " | TraceId:" + localVSBaseRequest.getTraceId() + " | cmdCallback SeqId:" + localVSBaseRequest.getCurrentSeq() + " is Null or has Removed");
      return;
    }
    Object localObject1 = (FromServiceMsg)paramBundle.getParcelable("key_response_msg");
    long l1 = paramBundle.getLong("key_send_timestamp");
    paramBundle = (xgx)((ConcurrentHashMap)localObject2).remove(Integer.valueOf(localVSBaseRequest.getCurrentSeq()));
    if (paramBundle == null)
    {
      QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: CmdName:" + localVSBaseRequest.getCmdName() + " | TraceId:" + localVSBaseRequest.getTraceId() + " | cmdCallback SeqId:" + localVSBaseRequest.getCurrentSeq() + " onVSRspCallBack is Null or removed");
      return;
    }
    if (localObject1 != null)
    {
      localObject2 = new PROTOCAL.StQWebRsp();
      long l2;
      MessageMicro localMessageMicro;
      try
      {
        ((PROTOCAL.StQWebRsp)localObject2).mergeFrom(bblm.b(((FromServiceMsg)localObject1).getWupBuffer()));
        l2 = ((PROTOCAL.StQWebRsp)localObject2).retCode.get();
        localObject1 = ((PROTOCAL.StQWebRsp)localObject2).errMsg.get().toStringUtf8();
        localObject2 = ((PROTOCAL.StQWebRsp)localObject2).busiBuff.get().toByteArray();
        localMessageMicro = localVSBaseRequest.decode((byte[])localObject2);
        if (localMessageMicro == null)
        {
          a().post(new VSDispatchObserver.2(this, paramBundle, l2, (String)localObject1));
          return;
        }
      }
      catch (Exception localException)
      {
        a().post(new VSDispatchObserver.4(this, paramBundle, localException));
        return;
      }
      a().post(new VSDispatchObserver.3(this, paramBoolean, l2, localException, (byte[])localObject2, paramBundle, (String)localObject1, localMessageMicro, l1));
      return;
    }
    a().post(new VSDispatchObserver.5(this, paramBundle));
  }
  
  private void a(VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte)
  {
    if (bbjw.a(paramVSBaseRequest.getRequestKey()))
    {
      veg.d("VSNetworkHelper| Protocol Cache", "requestKey is empty");
      return;
    }
    ThreadManagerV2.executeOnFileThread(new VSDispatchObserver.6(this, paramVSBaseRequest, paramArrayOfByte));
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, MessageMicro paramMessageMicro)
  {
    a().post(new VSDispatchObserver.7(this, paramVSBaseRequest, paramMessageMicro));
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, xgx paramxgx)
  {
    int i = paramVSBaseRequest.getCmdName().hashCode();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i)) == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), new ConcurrentHashMap());
    }
    try
    {
      ((ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).put(Integer.valueOf(paramVSBaseRequest.getNewSeq()), paramxgx);
      return;
    }
    catch (Exception paramVSBaseRequest)
    {
      paramVSBaseRequest.printStackTrace();
      QLog.e("VSNetworkHelper", 1, "setCallBack exception occur!" + paramVSBaseRequest.toString());
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (paramString != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramString.hashCode()));
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManagerV2.excute(new VSDispatchObserver.1(this, paramInt, paramBundle, paramBoolean), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgw
 * JD-Core Version:    0.7.0.1
 */