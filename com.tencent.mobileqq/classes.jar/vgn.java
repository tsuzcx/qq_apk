import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqReportEvil;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspReportEvil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class vgn
  extends urt<vhy>
{
  public static final String a = uqn.a("StorySvc.video_report_evil");
  public long b;
  public String b;
  public final int c;
  public String c;
  
  public String a()
  {
    return a;
  }
  
  public vhy a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspReportEvil localRspReportEvil = new qqstory_service.RspReportEvil();
    try
    {
      localRspReportEvil.mergeFrom(paramArrayOfByte);
      return new vhy(localRspReportEvil);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqReportEvil localReqReportEvil = new qqstory_service.ReqReportEvil();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localReqReportEvil.vid.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    if (this.jdField_b_of_type_Long != 0L) {
      localReqReportEvil.tuin.set(this.jdField_b_of_type_Long);
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      localReqReportEvil.union_id.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    localReqReportEvil.type.set(this.jdField_c_of_type_Int);
    return localReqReportEvil.toByteArray();
  }
  
  public String toString()
  {
    return "ReportEvilRequest{impeachType=" + this.jdField_c_of_type_Int + ", vid='" + this.jdField_b_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vgn
 * JD-Core Version:    0.7.0.1
 */