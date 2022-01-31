package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$QQWalletAioBody
  extends MessageMicro
{
  public static final int RECEIVER_FIELD_NUMBER = 3;
  public static final int SENDER_FIELD_NUMBER = 2;
  public static final int SINT32_CHANNELID_FIELD_NUMBER = 4;
  public static final int SINT32_TEMPLATEID_FIELD_NUMBER = 5;
  public static final int UINT32_RESEND_FIELD_NUMBER = 6;
  public static final int UINT64_SENDUIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48 }, new String[] { "uint64_senduin", "sender", "receiver", "sint32_channelid", "sint32_templateid", "uint32_resend" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, QQWalletAioBody.class);
  public im_msg_body.QQWalletAioElem receiver = new im_msg_body.QQWalletAioElem();
  public im_msg_body.QQWalletAioElem sender = new im_msg_body.QQWalletAioElem();
  public final PBSInt32Field sint32_channelid = PBField.initSInt32(0);
  public final PBSInt32Field sint32_templateid = PBField.initSInt32(0);
  public final PBUInt32Field uint32_resend = PBField.initUInt32(0);
  public final PBUInt64Field uint64_senduin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.QQWalletAioBody
 * JD-Core Version:    0.7.0.1
 */