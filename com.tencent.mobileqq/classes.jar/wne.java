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

public class wne
  extends wfm<wnf>
{
  static final String jdField_a_of_type_JavaLangString = weg.a("StorySvc.get_tab_node_vid_list");
  wly jdField_a_of_type_Wly;
  String b = "";
  String c = "";
  
  public wne(wly paramwly, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Wly = paramwly;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public static wnf a(wly paramwly, byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeVideoList localRspMsgTabNodeVideoList = new qqstory_service.RspMsgTabNodeVideoList();
    if (paramArrayOfByte != null) {}
    try
    {
      localRspMsgTabNodeVideoList.mergeFrom(paramArrayOfByte);
      return new wnf(paramwly, localRspMsgTabNodeVideoList, paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramwly)
    {
      ykq.d("Q.qqstory:ReqMsgTabNodeVideoList", "" + paramwly);
    }
    return null;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public wnf a(byte[] paramArrayOfByte)
  {
    return a(this.jdField_a_of_type_Wly, paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqMsgTabNodeVideoList localReqMsgTabNodeVideoList = new qqstory_service.ReqMsgTabNodeVideoList();
    localReqMsgTabNodeVideoList.unionID.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Wly.jdField_a_of_type_JavaLangString));
    localReqMsgTabNodeVideoList.req_time_stamp.set(this.jdField_a_of_type_Wly.c);
    localReqMsgTabNodeVideoList.node_type.set(this.jdField_a_of_type_Wly.jdField_a_of_type_Int);
    localReqMsgTabNodeVideoList.recommend_id.set(this.jdField_a_of_type_Wly.e);
    localReqMsgTabNodeVideoList.source.set(this.jdField_a_of_type_Wly.f);
    if (this.jdField_a_of_type_Wly.jdField_a_of_type_Int == 12)
    {
      if ((TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c))) {
        localReqMsgTabNodeVideoList.start_vid.set(this.c);
      }
      if (!TextUtils.isEmpty(this.b)) {
        localReqMsgTabNodeVideoList.cookie.set(this.b);
      }
      localReqMsgTabNodeVideoList.page_size.set(20);
    }
    Long localLong = zeh.a();
    if (localLong != null) {
      localReqMsgTabNodeVideoList.adcode.set(localLong.longValue());
    }
    localReqMsgTabNodeVideoList.device.set(ByteStringMicro.copyFromUtf8(Build.DEVICE));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Wly.k)) {
      localReqMsgTabNodeVideoList.passthrough.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Wly.k));
    }
    return localReqMsgTabNodeVideoList.toByteArray();
  }
  
  public String toString()
  {
    return "MsgTabNodeVidListRequest{nodeInfo.unionId=" + this.jdField_a_of_type_Wly.jdField_a_of_type_JavaLangString + ", mCookie='" + this.b + '\'' + ", mStartVid='" + this.c + '\'' + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wne
 * JD-Core Version:    0.7.0.1
 */