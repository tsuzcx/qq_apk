package tencent.im.oidb.cmd0x439;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x439
{
  public static final class ArticleInfo
    extends MessageMicro<ArticleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_subject = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_sum_pic = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_article_id", "bytes_article_subject", "bytes_article_url", "bytes_article_sum_pic" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ArticleInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 80, 88, 96 }, new String[] { "uint32_want_count", "uint32_req_article_info", "uint32_req_subscribe_info", "uint32_last_req_time", "uint32_comefrom", "uint32_version", "uint32_network_type", "uint32_pic_size" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_comefrom = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_req_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_article_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_subscribe_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want_count = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_subscribe_detail_url_pre = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0x439.SubscribeInfo> rpt_msg_subscribe_info = PBField.initRepeatMessage(oidb_cmd0x439.SubscribeInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_subscribe_info", "bytes_subscribe_detail_url_pre" }, new Object[] { null, localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class SubscribeInfo
    extends MessageMicro<SubscribeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0x439.ArticleInfo> rpt_article_list = PBField.initRepeatMessage(oidb_cmd0x439.ArticleInfo.class);
    public final PBRepeatField<Long> rpt_uint64_likely_subscribe_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_friend_subscribed_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_has_more = PBField.initUInt32(0);
    public final PBUInt64Field uint64_subscribe_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 74, 82, 162 }, new String[] { "uint64_subscribe_id", "rpt_uint64_likely_subscribe_list", "uint32_has_more", "uint32_friend_subscribed_count", "bytes_reason", "bytes_subscribe_name", "rpt_article_list" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null }, SubscribeInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x439.oidb_cmd0x439
 * JD-Core Version:    0.7.0.1
 */