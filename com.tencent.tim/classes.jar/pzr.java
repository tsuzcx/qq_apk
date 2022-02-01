import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqReportEvil;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspReportEvil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class pzr
  extends ppw<qay>
{
  public static final String CMD = ppf.fQ("StorySvc.video_report_evil");
  public final int blk;
  public long uin;
  public String unionId;
  public String vid;
  
  public qay a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspReportEvil localRspReportEvil = new qqstory_service.RspReportEvil();
    try
    {
      localRspReportEvil.mergeFrom(paramArrayOfByte);
      return new qay(localRspReportEvil);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqReportEvil localReqReportEvil = new qqstory_service.ReqReportEvil();
    if (!TextUtils.isEmpty(this.vid)) {
      localReqReportEvil.vid.set(ByteStringMicro.copyFromUtf8(this.vid));
    }
    if (this.uin != 0L) {
      localReqReportEvil.tuin.set(this.uin);
    }
    if (!TextUtils.isEmpty(this.unionId)) {
      localReqReportEvil.union_id.set(ByteStringMicro.copyFromUtf8(this.unionId));
    }
    localReqReportEvil.type.set(this.blk);
    return localReqReportEvil.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "ReportEvilRequest{impeachType=" + this.blk + ", vid='" + this.vid + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzr
 * JD-Core Version:    0.7.0.1
 */