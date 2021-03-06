import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.1;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.2;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.3;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.4;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.5;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.6;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.7;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;

public class rxc
  implements BusinessObserver
{
  private final String aDh = "网络错误";
  private final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, rxc.a>> cr = new ConcurrentHashMap();
  private Handler mMainHandler;
  
  private void a(int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject2 = (ConcurrentHashMap)this.cr.get(Integer.valueOf(paramInt));
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
    paramBundle = (rxc.a)((ConcurrentHashMap)localObject2).remove(Integer.valueOf(localVSBaseRequest.getCurrentSeq()));
    if (paramBundle == null)
    {
      QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: CmdName:" + localVSBaseRequest.getCmdName() + " | TraceId:" + localVSBaseRequest.getTraceId() + " | cmdCallback SeqId:" + localVSBaseRequest.getCurrentSeq() + " onVSRspCallBack is Null or removed");
      return;
    }
    if (localObject1 != null)
    {
      long l2;
      MessageMicro localMessageMicro;
      try
      {
        localObject2 = localVSBaseRequest.parseResponseWrapper(aqnv.J(((FromServiceMsg)localObject1).getWupBuffer()));
        l2 = ((Long)localObject2[0]).longValue();
        localObject1 = (String)localObject2[1];
        localObject2 = ((ByteStringMicro)localObject2[2]).toByteArray();
        localMessageMicro = localVSBaseRequest.decode((byte[])localObject2);
        if (localMessageMicro == null)
        {
          p().post(new VSDispatchObserver.2(this, paramBundle, l2, (String)localObject1, localVSBaseRequest, l1));
          return;
        }
      }
      catch (Exception localException)
      {
        p().post(new VSDispatchObserver.4(this, paramBundle, localVSBaseRequest, l1, localException));
        return;
      }
      p().post(new VSDispatchObserver.3(this, paramBoolean, l2, localVSBaseRequest, (byte[])localObject2, paramBundle, localException, localMessageMicro, l1));
      return;
    }
    p().post(new VSDispatchObserver.5(this, paramBundle, localVSBaseRequest, l1));
  }
  
  private void a(VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte)
  {
    if (aqmr.isEmpty(paramVSBaseRequest.getRequestKey()))
    {
      ram.w("VSNetworkHelper| Protocol Cache", "requestKey is empty");
      return;
    }
    ThreadManagerV2.executeOnSubThread(new VSDispatchObserver.6(this, paramVSBaseRequest, paramArrayOfByte));
  }
  
  public void V(Context paramContext, int paramInt)
  {
    if (paramContext == null) {}
    while (this.cr.get(Integer.valueOf(paramContext.hashCode())) == null) {
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.cr.get(Integer.valueOf(paramContext.hashCode()));
    if ((localConcurrentHashMap != null) && (paramInt == -1))
    {
      localConcurrentHashMap.clear();
      QLog.i("VSNetworkHelper", 1, String.format("cancel Request Context Success contextHashcode:%d, seq:%d", new Object[] { Integer.valueOf(paramContext.hashCode()), Integer.valueOf(paramInt) }));
      return;
    }
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.remove(Integer.valueOf(paramInt)) != null))
    {
      QLog.i("VSNetworkHelper", 1, String.format("cancel Request Seq Success contextHashcode:%d, seq:%d", new Object[] { Integer.valueOf(paramContext.hashCode()), Integer.valueOf(paramInt) }));
      return;
    }
    QLog.w("VSNetworkHelper", 1, String.format("cancel Request failed not found request callback contextHashcode:%d, seq:%d", new Object[] { Integer.valueOf(paramContext.hashCode()), Integer.valueOf(paramInt) }));
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, MessageMicro paramMessageMicro)
  {
    p().post(new VSDispatchObserver.7(this, paramVSBaseRequest, paramMessageMicro));
  }
  
  public void b(VSBaseRequest paramVSBaseRequest, rxc.a parama)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.cr.get(Integer.valueOf(paramVSBaseRequest.getContextHashCode()));
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null)
    {
      localConcurrentHashMap1 = new ConcurrentHashMap();
      this.cr.put(Integer.valueOf(paramVSBaseRequest.getContextHashCode()), localConcurrentHashMap1);
    }
    try
    {
      localConcurrentHashMap1.put(Integer.valueOf(paramVSBaseRequest.getNewSeq()), parama);
      return;
    }
    catch (Exception paramVSBaseRequest)
    {
      paramVSBaseRequest.printStackTrace();
      QLog.e("VSNetworkHelper", 1, "setCallBack exception occur!" + paramVSBaseRequest.toString());
    }
  }
  
  public void cL(Context paramContext)
  {
    V(paramContext, -1);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManagerV2.excute(new VSDispatchObserver.1(this, paramInt, paramBundle, paramBoolean), 16, null, false);
  }
  
  public Handler p()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  public void release()
  {
    try
    {
      Iterator localIterator = this.cr.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.cr.get(Integer.valueOf(i));
        if (localConcurrentHashMap != null) {
          localConcurrentHashMap.clear();
        }
      }
    }
    finally {}
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(boolean paramBoolean, long paramLong, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxc
 * JD-Core Version:    0.7.0.1
 */