import android.os.Bundle;
import com.tencent.biz.huiyin.HuiyinRedDotProto.RedDotGetRsp;
import com.tencent.biz.huiyin.ILiveProto.iLiveResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.observer.BusinessObserver;

class aies
  implements BusinessObserver
{
  aies(aien paramaien, aien.b paramb) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      paramBundle = new ILiveProto.iLiveResponse();
    }
    try
    {
      paramBundle.mergeFrom((byte[])localObject);
      localObject = new HuiyinRedDotProto.RedDotGetRsp();
      ((HuiyinRedDotProto.RedDotGetRsp)localObject).mergeFrom(paramBundle.ex.get().toByteArray());
      this.this$0.redDotNum = ((int)((HuiyinRedDotProto.RedDotGetRsp)localObject).totalNum.get());
      this.a.N(this.this$0.redDotNum);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aies
 * JD-Core Version:    0.7.0.1
 */