package tencent.im.oidb.cmd0xda2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xda2
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint32_req_type", "msg_get_vid_to_url_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public content_vidurl_svr.GetVid2UrlsReq msg_get_vid_to_url_req = new content_vidurl_svr.GetVid2UrlsReq();
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90 }, new String[] { "msg_get_vid_to_url_rsp" }, new Object[] { null }, RspBody.class);
    public content_vidurl_svr.GetVid2UrlsRsp msg_get_vid_to_url_rsp = new content_vidurl_svr.GetVid2UrlsRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xda2.oidb_cmd0xda2
 * JD-Core Version:    0.7.0.1
 */