package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x388$ReqBody
  extends MessageMicro
{
  public static final int RPT_MSG_GETIMG_URL_REQ_FIELD_NUMBER = 4;
  public static final int RPT_MSG_GETPTT_URL_REQ_FIELD_NUMBER = 6;
  public static final int RPT_MSG_TRYUP_IMG_REQ_FIELD_NUMBER = 3;
  public static final int RPT_MSG_TRYUP_PTT_REQ_FIELD_NUMBER = 5;
  public static final int UINT32_NET_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "uint32_net_type", "uint32_subcmd", "rpt_msg_tryup_img_req", "rpt_msg_getimg_url_req", "rpt_msg_tryup_ptt_req", "rpt_msg_getptt_url_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null }, ReqBody.class);
  public final PBRepeatMessageField rpt_msg_getimg_url_req = PBField.initRepeatMessage(cmd0x388.GetImgUrlReq.class);
  public final PBRepeatMessageField rpt_msg_getptt_url_req = PBField.initRepeatMessage(cmd0x388.GetPttUrlReq.class);
  public final PBRepeatMessageField rpt_msg_tryup_img_req = PBField.initRepeatMessage(cmd0x388.TryUpImgReq.class);
  public final PBRepeatMessageField rpt_msg_tryup_ptt_req = PBField.initRepeatMessage(cmd0x388.TryUpPttReq.class);
  public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.ReqBody
 * JD-Core Version:    0.7.0.1
 */