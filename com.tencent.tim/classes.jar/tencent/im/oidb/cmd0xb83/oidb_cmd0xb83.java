package tencent.im.oidb.cmd0xb83;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb83
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "uint32_reserved", "msg_req_search_tag_info", "msg_req_recommend_tag_info" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
    public oidb_cmd0xb83.ReqRecommendTagInfo msg_req_recommend_tag_info = new oidb_cmd0xb83.ReqRecommendTagInfo();
    public oidb_cmd0xb83.ReqSearchTagInfo msg_req_search_tag_info = new oidb_cmd0xb83.ReqSearchTagInfo();
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
  }
  
  public static final class ReqRecommendTagInfo
    extends MessageMicro<ReqRecommendTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_recommend_info", "uint64_topic_id" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L) }, ReqRecommendTagInfo.class);
    public final PBUInt32Field uint32_recommend_info = PBField.initUInt32(1);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqSearchTagInfo
    extends MessageMicro<ReqSearchTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_search_info_list" }, new Object[] { null }, ReqSearchTagInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xb83.SearchInfo> rpt_msg_search_info_list = PBField.initRepeatMessage(oidb_cmd0xb83.SearchInfo.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "uint32_reserved", "msg_rsp_search_tag_info", "msg_rsp_recommend_tag_info" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
    public oidb_cmd0xb83.RspRecommendTagInfo msg_rsp_recommend_tag_info = new oidb_cmd0xb83.RspRecommendTagInfo();
    public oidb_cmd0xb83.RspSearchTagInfo msg_rsp_search_tag_info = new oidb_cmd0xb83.RspSearchTagInfo();
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
  }
  
  public static final class RspRecommendTagInfo
    extends MessageMicro<RspRecommendTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_tag_info_list" }, new Object[] { null }, RspRecommendTagInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xb83.TagInfo> rpt_msg_tag_info_list = PBField.initRepeatMessage(oidb_cmd0xb83.TagInfo.class);
  }
  
  public static final class RspSearchTagInfo
    extends MessageMicro<RspSearchTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_tag_info_list" }, new Object[] { null }, RspSearchTagInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xb83.TagInfo> rpt_msg_tag_info_list = PBField.initRepeatMessage(oidb_cmd0xb83.TagInfo.class);
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
  
  public static final class TagInfo
    extends MessageMicro<TagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBDoubleField double_tag_score = PBField.initDouble(0.0D);
    public final PBUInt64Field uint64_channel = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_tag_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 25, 32 }, new String[] { "uint64_tag_id", "bytes_tag_name", "double_tag_score", "uint64_channel" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Double.valueOf(0.0D), Long.valueOf(0L) }, TagInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb83.oidb_cmd0xb83
 * JD-Core Version:    0.7.0.1
 */