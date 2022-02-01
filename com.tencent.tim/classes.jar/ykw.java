import android.support.annotation.Nullable;
import com.tencent.mobileqq.datarecv.pb.ZhituReportMsg.ReqBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class ykw
{
  @Nullable
  public String aYA;
  @Nullable
  public String aYB;
  public String aYx;
  public String aYy;
  public String aYz;
  public int action;
  public String auy;
  public boolean isReported;
  public String pass;
  
  public ZhituReportMsg.ReqBody a()
  {
    if (this.pass == null) {
      this.pass = "";
    }
    if (this.auy == null) {
      this.auy = "";
    }
    if (this.aYx == null) {
      this.aYx = "";
    }
    if (this.aYy == null) {
      this.aYy = "";
    }
    if (this.aYz == null) {
      this.aYz = "";
    }
    if (this.aYA == null) {
      this.aYA = "";
    }
    if (this.aYB == null) {
      this.aYB = "";
    }
    ZhituReportMsg.ReqBody localReqBody = new ZhituReportMsg.ReqBody();
    localReqBody.bytes_pass.set(ByteStringMicro.copyFromUtf8(this.pass));
    localReqBody.bytes_pic_id.set(ByteStringMicro.copyFromUtf8(this.aYx));
    localReqBody.bytes_style.set(ByteStringMicro.copyFromUtf8(this.auy));
    localReqBody.uint32_action.set(this.action);
    localReqBody.bytes_aio_type.set(ByteStringMicro.copyFromUtf8(this.aYy));
    localReqBody.bytes_mobile_type.set(ByteStringMicro.copyFromUtf8("android"));
    localReqBody.bytes_current_text.set(ByteStringMicro.copyFromUtf8(this.aYz));
    return localReqBody;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ZhituReportData{pass='").append(this.pass).append('\'').append(", imgId='").append(this.aYx).append('\'').append(", styles='").append(this.auy).append('\'').append(", action=").append(this.action).append(", aioType='").append(this.aYy).append('\'').append(", queryText='");
    if (this.aYz != null)
    {
      str = atad.toMD5(this.aYz);
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", lastMessage='");
      if (this.aYA == null) {
        break label207;
      }
      str = atad.toMD5(this.aYA);
      label139:
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", lastTwoMessage='");
      if (this.aYB == null) {
        break label213;
      }
    }
    label207:
    label213:
    for (String str = atad.toMD5(this.aYB);; str = "null")
    {
      return str + '\'' + ", isReported=" + this.isReported + '}';
      str = "null";
      break;
      str = "null";
      break label139;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykw
 * JD-Core Version:    0.7.0.1
 */