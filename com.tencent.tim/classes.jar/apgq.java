import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.homework.arithmetic.pb.MathHWNetWorkPB.ErrorInfo;
import com.tencent.mobileqq.troop.homework.arithmetic.pb.MathHWNetWorkPB.ReqCheckHomework;
import com.tencent.mobileqq.troop.homework.arithmetic.pb.MathHWNetWorkPB.YoutuPicInfo;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class apgq
  extends JobSegment<String, apgq.c>
{
  private apgq.a a;
  private String coQ;
  
  public apgq(apgq.a parama)
  {
    this.a = parama;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    ram.w("QQ.Troop.homework.SendArithHomeResultSegment", "runSegment " + paramString);
    this.coQ = paramString;
    ppv.a().a(new apgq.b(this.a, this.coQ), new apgr(this));
  }
  
  public static class a
  {
    public long arz;
    public String coR;
    public String coS;
    public long groupId;
    public long uin;
  }
  
  public static class b
    extends ppw
  {
    apgq.a a;
    String coQ;
    
    public b(apgq.a parama, String paramString)
    {
      this.a = parama;
      this.coQ = paramString;
    }
    
    public ppu a(byte[] paramArrayOfByte)
    {
      MathHWNetWorkPB.ErrorInfo localErrorInfo = new MathHWNetWorkPB.ErrorInfo();
      try
      {
        localErrorInfo.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new ppu(localErrorInfo.error_code.get(), localErrorInfo.error_desc.get().toStringUtf8());
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.w("QQ.Troop.homework.SendArithHomeResultSegment", "decodeResponse", paramArrayOfByte);
      }
      return new ppu(-99, "decodeResponse error:" + paramArrayOfByte);
    }
    
    protected byte[] encode()
      throws QQStoryCmdHandler.IllegalUinException
    {
      MathHWNetWorkPB.ReqCheckHomework localReqCheckHomework = new MathHWNetWorkPB.ReqCheckHomework();
      MathHWNetWorkPB.YoutuPicInfo localYoutuPicInfo = new MathHWNetWorkPB.YoutuPicInfo();
      localYoutuPicInfo.old_url.set(this.a.coR);
      localYoutuPicInfo.new_url.set(this.coQ);
      localYoutuPicInfo.new_data.set(ByteStringMicro.copyFromUtf8(this.a.coS));
      localReqCheckHomework.group_id.set(this.a.groupId);
      localReqCheckHomework.hw_id.set(this.a.arz);
      localReqCheckHomework.uin.set(this.a.uin);
      localReqCheckHomework.pics.add(localYoutuPicInfo);
      return localReqCheckHomework.toByteArray();
    }
    
    public String mg()
    {
      return "HwSvc.check_homework";
    }
  }
  
  public static class c
  {
    public String coS;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgq
 * JD-Core Version:    0.7.0.1
 */