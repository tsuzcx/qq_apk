package tencent.im.oidb.cmd0x9d0;

import appoint.define.appoint_define.FeedInfo;
import appoint.define.appoint_define.PublisherInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x9d0
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_feed_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_req_uid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_req_uid", "uint32_feed_num", "bytes_cookie", "uint64_req_uin" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.PublisherInfo msg_user_info = new appoint_define.PublisherInfo();
    public final PBRepeatMessageField<appoint_define.FeedInfo> rpt_msg_feeds = PBField.initRepeatMessage(appoint_define.FeedInfo.class);
    public final PBStringField str_error_tips = PBField.initString("");
    public final PBUInt32Field uint32_completed = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "str_error_tips", "msg_user_info", "rpt_msg_feeds", "bytes_cookie", "uint32_completed" }, new Object[] { "", null, null, localByteStringMicro, Integer.valueOf(0) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9d0.oidb_0x9d0
 * JD-Core Version:    0.7.0.1
 */