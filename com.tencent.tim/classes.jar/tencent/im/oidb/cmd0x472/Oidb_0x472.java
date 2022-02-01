package tencent.im.oidb.cmd0x472;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x472
{
  public static final class ArticleSummary
    extends MessageMicro<ArticleSummary>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_original_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_big_picture = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recommend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recommend_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 88, 96, 104, 112, 122 }, new String[] { "uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_original_url", "bytes_article_content_url", "uint64_time", "uint32_comment_count", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_recommend_time", "uint64_recommend_seq", "uint32_show_big_picture", "uint64_algorithm_id", "bytes_recommend_reason" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro8 }, ArticleSummary.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_uin", "reqChannelPara" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
    public Oidb_0x472.ReqChannelPara reqChannelPara = new Oidb_0x472.ReqChannelPara();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqChannelPara
    extends MessageMicro<ReqChannelPara>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_channel_id", "uint32_req_channel_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqChannelPara.class);
    public final PBUInt32Field uint32_req_channel_list = PBField.initUInt32(0);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_uin", "rspChannelArticle" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
    public Oidb_0x472.RspChannelArticle rspChannelArticle = new Oidb_0x472.RspChannelArticle();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspChannelArticle
    extends MessageMicro<RspChannelArticle>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_channel_id", "rpt_article_list" }, new Object[] { Long.valueOf(0L), null }, RspChannelArticle.class);
    public final PBRepeatMessageField<Oidb_0x472.ArticleSummary> rpt_article_list = PBField.initRepeatMessage(Oidb_0x472.ArticleSummary.class);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x472.Oidb_0x472
 * JD-Core Version:    0.7.0.1
 */