import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.cs.smartptt.Smartptt.PttUpReq;
import tencent.im.cs.smartptt.Smartptt.ReqBody;

public class aonz
{
  public static Smartptt.ReqBody a(aonz.a parama)
  {
    int j = 0;
    Smartptt.ReqBody localReqBody = new Smartptt.ReqBody();
    localReqBody.uint32_sub_cmd.set(3);
    Smartptt.PttUpReq localPttUpReq = new Smartptt.PttUpReq();
    localPttUpReq.uint32_bits_per_sample.set(16);
    localPttUpReq.uint32_voice_file_type.set(1);
    localPttUpReq.uint32_voice_encode_type.set(parama.dQu);
    localPttUpReq.uint32_samples_per_sec.set(16000);
    localPttUpReq.str_voice_id.set(parama.cmh);
    PBUInt32Field localPBUInt32Field = localPttUpReq.uint32_is_first;
    if (parama.cNu) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localPBUInt32Field = localPttUpReq.uint32_is_end;
      i = j;
      if (parama.cNv) {
        i = 1;
      }
      localPBUInt32Field.set(i);
      localPttUpReq.uint32_offset.set(parama.offset);
      localPttUpReq.str_Filemd5.set(parama.md5);
      localPttUpReq.uint32_chat_type.set(parama.chatType);
      localPttUpReq.uint32_service_id.set(1);
      localPttUpReq.uint32_voice_num.set(parama.dQv);
      localPttUpReq.uint32_voice_offset.set(parama.dQw);
      localReqBody.msg_ptt_up_req.set(localPttUpReq);
      return localReqBody;
    }
  }
  
  public static class a
  {
    public boolean cNu;
    public boolean cNv;
    public int chatType;
    public String cmh;
    public int dQu;
    public int dQv;
    public int dQw;
    public String filePath;
    public String md5;
    public int offset;
    
    public String toString()
    {
      return "PttSliceInfoBean{encodeType=" + this.dQu + ", isfirst=" + this.cNu + ", isLast=" + this.cNv + ", voiceId='" + this.cmh + '\'' + ", offset=" + this.offset + ", vegPos='" + this.dQw + '\'' + ", md5='" + this.md5 + '\'' + ", chatType='" + this.chatType + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonz
 * JD-Core Version:    0.7.0.1
 */