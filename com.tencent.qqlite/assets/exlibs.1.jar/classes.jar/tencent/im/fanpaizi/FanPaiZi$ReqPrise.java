package tencent.im.fanpaizi;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FanPaiZi$ReqPrise
  extends MessageMicro
{
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int UINT64_PEER_TINYID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_head", "uint64_peer_tinyid" }, new Object[] { null, Long.valueOf(0L) }, ReqPrise.class);
  public FanPaiZi.BusiReqHead msg_head = new FanPaiZi.BusiReqHead();
  public final PBUInt64Field uint64_peer_tinyid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.fanpaizi.FanPaiZi.ReqPrise
 * JD-Core Version:    0.7.0.1
 */