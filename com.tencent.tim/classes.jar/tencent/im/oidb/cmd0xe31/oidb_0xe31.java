package tencent.im.oidb.cmd0xe31;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.kandian.ugc.topic_info.TopicInfo;

public final class oidb_0xe31
{
  public static final class GetUserSettingsReq
    extends MessageMicro<GetUserSettingsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, GetUserSettingsReq.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetUserSettingsRsp
    extends MessageMicro<GetUserSettingsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "video_count", "column_count", "subscribe_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetUserSettingsRsp.class);
    public final PBUInt32Field column_count = PBField.initUInt32(0);
    public final PBUInt32Field subscribe_count = PBField.initUInt32(0);
    public final PBUInt32Field video_count = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "user_settings_req", "topic_info_get_req", "topic_list_req_req" }, new Object[] { null, null, null }, ReqBody.class);
    public oidb_0xe31.TopicInfoGetReq topic_info_get_req = new oidb_0xe31.TopicInfoGetReq();
    public oidb_0xe31.TopicListReq topic_list_req_req = new oidb_0xe31.TopicListReq();
    public oidb_0xe31.GetUserSettingsReq user_settings_req = new oidb_0xe31.GetUserSettingsReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "user_settings_rsp", "topic_info_get_rsp", "topic_list_req_rsp" }, new Object[] { null, null, null }, RspBody.class);
    public oidb_0xe31.TopicInfoGetRsp topic_info_get_rsp = new oidb_0xe31.TopicInfoGetRsp();
    public oidb_0xe31.TopicListRsp topic_list_req_rsp = new oidb_0xe31.TopicListRsp();
    public oidb_0xe31.GetUserSettingsRsp user_settings_rsp = new oidb_0xe31.GetUserSettingsRsp();
  }
  
  public static final class TopicInfoGetReq
    extends MessageMicro<TopicInfoGetReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "topic_ids", "is_need_topic_view" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, TopicInfoGetReq.class);
    public final PBBoolField is_need_topic_view = PBField.initBool(false);
    public final PBRepeatField<Integer> topic_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class TopicInfoGetRsp
    extends MessageMicro<TopicInfoGetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "infos" }, new Object[] { null }, TopicInfoGetRsp.class);
    public final PBRepeatMessageField<topic_info.TopicInfo> infos = PBField.initRepeatMessage(topic_info.TopicInfo.class);
  }
  
  public static final class TopicListReq
    extends MessageMicro<TopicListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field top_topic_id = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uid", "cookie", "num", "top_topic_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, TopicListReq.class);
    }
  }
  
  public static final class TopicListRsp
    extends MessageMicro<TopicListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field create_limit = PBField.initUInt32(0);
    public final PBBoolField is_end = PBField.initBool(false);
    public final PBRepeatMessageField<topic_info.TopicInfo> topics = PBField.initRepeatMessage(topic_info.TopicInfo.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "cookie", "is_end", "total", "topics", "create_limit" }, new Object[] { localByteStringMicro, Boolean.valueOf(false), Integer.valueOf(0), null, Integer.valueOf(0) }, TopicListRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe31.oidb_0xe31
 * JD-Core Version:    0.7.0.1
 */