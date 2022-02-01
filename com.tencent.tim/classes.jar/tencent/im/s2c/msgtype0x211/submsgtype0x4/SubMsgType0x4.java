package tencent.im.s2c.msgtype0x211.submsgtype0x4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.msg.resv21.hummer_resv_21.XtfSenderInfo;

public final class SubMsgType0x4
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50 }, new String[] { "msg_not_online_file", "uint32_msg_time", "uint32_OnlineFileForPolyToOffline", "file_image_info", "msg_xtf_sender_info", "resv_attr" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null, null, null }, MsgBody.class);
    public hummer_resv_21.FileImgInfo file_image_info = new hummer_resv_21.FileImgInfo();
    public im_msg_body.NotOnlineFile msg_not_online_file = new im_msg_body.NotOnlineFile();
    public hummer_resv_21.XtfSenderInfo msg_xtf_sender_info = new hummer_resv_21.XtfSenderInfo();
    public hummer_resv_21.ResvAttr resv_attr = new hummer_resv_21.ResvAttr();
    public final PBUInt32Field uint32_OnlineFileForPolyToOffline = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4
 * JD-Core Version:    0.7.0.1
 */