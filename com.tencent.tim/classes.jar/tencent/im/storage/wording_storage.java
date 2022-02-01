package tencent.im.storage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_msg_body.RichText;

public final class wording_storage
{
  public static final class KeyInfo
    extends MessageMicro<KeyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "type", "key" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, KeyInfo.class);
    public final PBUInt64Field key = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class WordingCfg
    extends MessageMicro<WordingCfg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "auto_reply_flag", "select_id", "wording_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, WordingCfg.class);
    public final PBUInt32Field auto_reply_flag = PBField.initUInt32(0);
    public final PBUInt32Field select_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<im_msg_body.RichText> wording_list = PBField.initRepeatMessage(im_msg_body.RichText.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.storage.wording_storage
 * JD-Core Version:    0.7.0.1
 */