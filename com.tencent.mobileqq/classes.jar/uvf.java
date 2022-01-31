import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeWatched;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeWatched;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class uvf
  extends unk<uvg>
{
  static final String a = ume.a("StorySvc.msgtab_node_watched");
  public long b;
  public String b;
  public int c;
  public int d;
  
  public String a()
  {
    return a;
  }
  
  public unf a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeWatched localRspMsgTabNodeWatched = new qqstory_service.RspMsgTabNodeWatched();
    try
    {
      localRspMsgTabNodeWatched.mergeFrom(paramArrayOfByte);
      return new uvg(localRspMsgTabNodeWatched);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      wsv.d("Q.qqstory.msgTab:ReqMsgTabNodeWatched", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqMsgTabNodeWatched localReqMsgTabNodeWatched = new qqstory_service.ReqMsgTabNodeWatched();
    localReqMsgTabNodeWatched.unionID.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    localReqMsgTabNodeWatched.node_type.set(this.c);
    localReqMsgTabNodeWatched.operation.set(this.d);
    localReqMsgTabNodeWatched.recommend_id.set(this.jdField_b_of_type_Long);
    return localReqMsgTabNodeWatched.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvf
 * JD-Core Version:    0.7.0.1
 */