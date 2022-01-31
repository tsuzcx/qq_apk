import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class uvd
  extends unk<uve>
{
  static final String jdField_a_of_type_JavaLangString = ume.a("StorySvc.get_tab_node_vid_list");
  utx jdField_a_of_type_Utx;
  String b = "";
  String c = "";
  
  public uvd(utx paramutx, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Utx = paramutx;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public static uve a(utx paramutx, byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeVideoList localRspMsgTabNodeVideoList = new qqstory_service.RspMsgTabNodeVideoList();
    if (paramArrayOfByte != null) {}
    try
    {
      localRspMsgTabNodeVideoList.mergeFrom(paramArrayOfByte);
      return new uve(paramutx, localRspMsgTabNodeVideoList, paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramutx)
    {
      wsv.d("Q.qqstory:ReqMsgTabNodeVideoList", "" + paramutx);
    }
    return null;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public uve a(byte[] paramArrayOfByte)
  {
    return a(this.jdField_a_of_type_Utx, paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqMsgTabNodeVideoList localReqMsgTabNodeVideoList = new qqstory_service.ReqMsgTabNodeVideoList();
    localReqMsgTabNodeVideoList.unionID.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Utx.jdField_a_of_type_JavaLangString));
    localReqMsgTabNodeVideoList.req_time_stamp.set(this.jdField_a_of_type_Utx.c);
    localReqMsgTabNodeVideoList.node_type.set(this.jdField_a_of_type_Utx.jdField_a_of_type_Int);
    localReqMsgTabNodeVideoList.recommend_id.set(this.jdField_a_of_type_Utx.e);
    localReqMsgTabNodeVideoList.source.set(this.jdField_a_of_type_Utx.f);
    if (this.jdField_a_of_type_Utx.jdField_a_of_type_Int == 12)
    {
      if ((TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c))) {
        localReqMsgTabNodeVideoList.start_vid.set(this.c);
      }
      if (!TextUtils.isEmpty(this.b)) {
        localReqMsgTabNodeVideoList.cookie.set(this.b);
      }
      localReqMsgTabNodeVideoList.page_size.set(20);
    }
    Long localLong = xnd.a();
    if (localLong != null) {
      localReqMsgTabNodeVideoList.adcode.set(localLong.longValue());
    }
    localReqMsgTabNodeVideoList.device.set(ByteStringMicro.copyFromUtf8(Build.DEVICE));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Utx.k)) {
      localReqMsgTabNodeVideoList.passthrough.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Utx.k));
    }
    return localReqMsgTabNodeVideoList.toByteArray();
  }
  
  public String toString()
  {
    return "MsgTabNodeVidListRequest{nodeInfo.unionId=" + this.jdField_a_of_type_Utx.jdField_a_of_type_JavaLangString + ", mCookie='" + this.b + '\'' + ", mStartVid='" + this.c + '\'' + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvd
 * JD-Core Version:    0.7.0.1
 */