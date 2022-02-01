package tencent.im.oidb.cmd0x9da;

import appoint.define.appoint_define.UserFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x9da
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int BYTES_COOKIE_FIELD_NUMBER = 3;
    public static final int UINT32_FEED_NUM_FIELD_NUMBER = 2;
    public static final int UINT64_TOPIC_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_feed_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_topic_id", "uint32_feed_num", "bytes_cookie" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int BYTES_COOKIE_FIELD_NUMBER = 3;
    public static final int RPT_MSG_FEEDS_FIELD_NUMBER = 2;
    public static final int STR_ERROR_TIPS_FIELD_NUMBER = 1;
    public static final int UINT32_COMPLETED_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<appoint_define.UserFeed> rpt_msg_feeds = PBField.initRepeatMessage(appoint_define.UserFeed.class);
    public final PBStringField str_error_tips = PBField.initString("");
    public final PBUInt32Field uint32_completed = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "str_error_tips", "rpt_msg_feeds", "bytes_cookie", "uint32_completed" }, new Object[] { "", null, localByteStringMicro, Integer.valueOf(0) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9da.cmd0x9da
 * JD-Core Version:    0.7.0.1
 */