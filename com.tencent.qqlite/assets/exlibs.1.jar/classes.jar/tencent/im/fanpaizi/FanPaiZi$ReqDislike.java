package tencent.im.fanpaizi;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FanPaiZi$ReqDislike
  extends MessageMicro
{
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int RPT_UINT64_PEER_TINYID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_head", "rpt_uint64_peer_tinyid" }, new Object[] { null, Long.valueOf(0L) }, ReqDislike.class);
  public FanPaiZi.BusiReqHead msg_head = new FanPaiZi.BusiReqHead();
  public final PBRepeatField rpt_uint64_peer_tinyid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.fanpaizi.FanPaiZi.ReqDislike
 * JD-Core Version:    0.7.0.1
 */