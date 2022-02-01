import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.now_proxy.pb_now_proxy.ForwardReq;
import com.tencent.now_proxy.pb_now_proxy.ForwardRsp;
import com.tencent.pb.now.ilive_get_record_info_svr.GetRoomStateReq;
import com.tencent.pb.now.ilive_get_record_info_svr.GetRoomStateRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class jsr
  extends accg
{
  public static String TAG = "NowRecordInfo";
  String Ul;
  jsr.a a;
  int aCW;
  boolean abx = false;
  long qB = 0L;
  
  public jsr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    this.abx = false;
    this.qB = 0L;
    int i = j;
    if (paramFromServiceMsg.isSuccess())
    {
      i = j;
      if (paramObject != null) {
        i = 1;
      }
    }
    if (i == 0)
    {
      this.aCW = paramFromServiceMsg.getBusinessFailCode();
      this.Ul = paramFromServiceMsg.getBusinessFailMsg();
      a(true, "", "", System.currentTimeMillis() - this.qB, "");
      return;
    }
    paramToServiceMsg = new pb_now_proxy.ForwardRsp();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg.busi_error_code.get() != 0) || (paramToServiceMsg.busi_buf.get() == null))
      {
        this.aCW = paramToServiceMsg.busi_error_code.get();
        a(true, "", "", System.currentTimeMillis() - this.qB, "");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(true, "", "", System.currentTimeMillis() - this.qB, "");
      return;
    }
    f(paramToServiceMsg.busi_error_code.get(), paramToServiceMsg.busi_buf.get().toByteArray());
  }
  
  private void c(byte[] paramArrayOfByte, String paramString)
  {
    if (this.app == null) {
      return;
    }
    paramString = new ToServiceMsg("mobileqq.service", paramString, "NowGetRecordInfoSvr.get_record_info");
    paramString.putWupBuffer(paramArrayOfByte);
    sendPbReq(paramString);
  }
  
  public void a(String paramString1, long paramLong, String paramString2, jsr.a parama)
  {
    this.a = null;
    this.a = parama;
    this.qB = System.currentTimeMillis();
    if (this.app == null)
    {
      QLog.e(TAG, 1, "getRecordInfo fail,app is null ");
      a(true, "", "", 0L, "");
      return;
    }
    this.abx = true;
    parama = new ilive_get_record_info_svr.GetRoomStateReq();
    parama.source.set(paramString1);
    parama.roomid.set((int)paramLong);
    paramString1 = new pb_now_proxy.ForwardReq();
    paramString1.cmd.set(26182);
    paramString1.subcmd.set(2);
    paramString1.uid.set(Long.valueOf(paramString2).longValue());
    paramString1.platform.set(1);
    paramString1.codec.set(0);
    paramString1.busi_buf.set(ByteStringMicro.copyFrom(((ilive_get_record_info_svr.GetRoomStateReq)parama.get()).toByteArray()));
    paramString1.original_id_type.set(1);
    paramString1.original_id.set(paramString2);
    c(paramString1.toByteArray(), paramString2);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (this.a != null) {
      this.a.b(paramBoolean, paramString2, paramString1, paramLong, paramString3);
    }
  }
  
  public void f(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    QLog.i(TAG, 0, "拉取录播信息成功");
    this.aCW = 0;
    this.Ul = "";
    try
    {
      Object localObject = new ilive_get_record_info_svr.GetRoomStateRsp();
      ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).mergeFrom(paramArrayOfByte);
      paramInt = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).is_on_live.get();
      paramArrayOfByte = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).vid.get();
      String str = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).recorded_share_url.get();
      localObject = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).another_live_mqq.get();
      if (paramInt != 0) {
        bool = true;
      }
      a(bool, paramArrayOfByte, str, System.currentTimeMillis() - this.qB, (String)localObject);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(TAG, 1, "NowRecordObserver InvalidProtocolBufferMicroException! ");
    }
  }
  
  public String hU()
  {
    return this.Ul;
  }
  
  public int mV()
  {
    return this.aCW;
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("NowGetRecordInfoSvr.get_record_info".equals(paramFromServiceMsg.getServiceCmd()))
    {
      QLog.i(TAG, 1, "onReceive called.");
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsr
 * JD-Core Version:    0.7.0.1
 */