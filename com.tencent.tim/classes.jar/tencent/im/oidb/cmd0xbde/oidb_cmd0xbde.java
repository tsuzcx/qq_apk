package tencent.im.oidb.cmd0xbde;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbde
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90 }, new String[] { "uint32_reserved", "uint32_query_mode", "msg_req_search_tag_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
    public oidb_cmd0xbde.ReqSearchTopicInfo msg_req_search_tag_info = new oidb_cmd0xbde.ReqSearchTopicInfo();
    public final PBUInt32Field uint32_query_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
  }
  
  public static final class ReqSearchTopicInfo
    extends MessageMicro<ReqSearchTopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_search_info_list" }, new Object[] { null }, ReqSearchTopicInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xbde.SearchInfo> rpt_msg_search_info_list = PBField.initRepeatMessage(oidb_cmd0xbde.SearchInfo.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint32_reserved", "msg_rsp_search_tag_info" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public oidb_cmd0xbde.RspSearchTopicResult msg_rsp_search_tag_info = new oidb_cmd0xbde.RspSearchTopicResult();
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
  }
  
  public static final class RspSearchTopicResult
    extends MessageMicro<RspSearchTopicResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_tag_info_list", "rpt_msg_search_info_list" }, new Object[] { null, null }, RspSearchTopicResult.class);
    public final PBRepeatMessageField<oidb_cmd0xbde.SearchInfo> rpt_msg_search_info_list = PBField.initRepeatMessage(oidb_cmd0xbde.SearchInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xbde.TopicInfo> rpt_msg_tag_info_list = PBField.initRepeatMessage(oidb_cmd0xbde.TopicInfo.class);
  }
  
  public static final class SearchInfo
    extends MessageMicro<SearchInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_key" }, new Object[] { localByteStringMicro }, SearchInfo.class);
    }
  }
  
  public static final class TopicInfo
    extends MessageMicro<TopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_topic_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_topic_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_topic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint64_topic_id", "bytes_topic_name", "bytes_topic_url", "bytes_topic_cover_url", "bytes_topic_summary" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, TopicInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbde.oidb_cmd0xbde
 * JD-Core Version:    0.7.0.1
 */