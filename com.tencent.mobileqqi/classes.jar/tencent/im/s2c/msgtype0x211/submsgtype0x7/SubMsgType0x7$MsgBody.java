package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x7$MsgBody
  extends MessageMicro
{
  public static final int MSG_HEADER_FIELD_NUMBER = 2;
  public static final int MSG_SUBCMD_0X4_GENERIC_FIELD_NUMBER = 6;
  public static final int RPT_MSG_SUBCMD_0X1_FTN_NOTIFY_FIELD_NUMBER = 3;
  public static final int RPT_MSG_SUBCMD_0X2_NFC_NOTIFY_FIELD_NUMBER = 4;
  public static final int RPT_MSG_SUBCMD_0X3_FILECONTROL_FIELD_NUMBER = 5;
  public static final int RPT_MSG_SUBCMD_0X5_MOLO_NOTIFY_FIELD_NUMBER = 7;
  public static final int RPT_MSG_SUBCMD_0X6_RNFC_NOTIFY_FIELD_NUMBER = 8;
  public static final int RPT_MSG_SUBCMD_0X9_FTN_THUMB_NOTIFY_FIELD_NUMBER = 9;
  public static final int RPT_MSG_SUBCMD_0XA_NFC_THUMB_NOTIFY_FIELD_NUMBER = 10;
  public static final int RPT_MSG_SUBCMD_0XB_MPFILE_NOTIFY_FIELD_NUMBER = 11;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90 }, new String[] { "uint32_sub_cmd", "msg_header", "rpt_msg_subcmd_0x1_ftn_notify", "rpt_msg_subcmd_0x2_nfc_notify", "rpt_msg_subcmd_0x3_filecontrol", "msg_subcmd_0x4_generic", "rpt_msg_subcmd_0x5_molo_notify", "rpt_msg_subcmd_0x6_rnfc_notify", "rpt_msg_subcmd_0x9_ftn_thumb_notify", "rpt_msg_subcmd_0xa_nfc_thumb_notify", "rpt_msg_subcmd_0xb_mpfile_notify" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null }, MsgBody.class);
  public SubMsgType0x7.MsgBody.MsgHeader msg_header = new SubMsgType0x7.MsgBody.MsgHeader();
  public SubMsgType0x7.MsgBody.GenericSubCmd msg_subcmd_0x4_generic = new SubMsgType0x7.MsgBody.GenericSubCmd();
  public final PBRepeatMessageField rpt_msg_subcmd_0x1_ftn_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.FTNNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0x2_nfc_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.NFCNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0x3_filecontrol = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.FileControl.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0x5_molo_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.MoloNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0x6_rnfc_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.RNFCNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0x9_ftn_thumb_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.FTNNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0xa_nfc_thumb_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.NFCNotify.class);
  public final PBRepeatMessageField rpt_msg_subcmd_0xb_mpfile_notify = PBField.initRepeatMessage(SubMsgType0x7.MsgBody.MpFileNotify.class);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody
 * JD-Core Version:    0.7.0.1
 */