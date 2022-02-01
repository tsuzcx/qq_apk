package tencent.im.oidb.cmd0xe5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe5c
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "type", "videoReqBody", "topicReqBody", "watch_word_req_body" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
    public cmd0xe5c.TopicReqBody topicReqBody = new cmd0xe5c.TopicReqBody();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public cmd0xe5c.VideoReqBody videoReqBody = new cmd0xe5c.VideoReqBody();
    public cmd0xe5c.WatchWordReqBody watch_word_req_body = new cmd0xe5c.WatchWordReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "type", "video_rsp_body", "topic_rsp_body", "watch_rsp_body" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
    public cmd0xe5c.TopicRspBody topic_rsp_body = new cmd0xe5c.TopicRspBody();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public cmd0xe5c.VideoRspBody video_rsp_body = new cmd0xe5c.VideoRspBody();
    public cmd0xe5c.WatchRspBody watch_rsp_body = new cmd0xe5c.WatchRspBody();
  }
  
  public static final class TopicInfo
    extends MessageMicro<TopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "icon", "title", "topic_id" }, new Object[] { "", "", "" }, TopicInfo.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField topic_id = PBField.initString("");
  }
  
  public static final class TopicReqBody
    extends MessageMicro<TopicReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "topic_id", "url" }, new Object[] { "", "" }, TopicReqBody.class);
    public final PBStringField topic_id = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class TopicRspBody
    extends MessageMicro<TopicRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "url", "watch_word", "is_open" }, new Object[] { "", "", Boolean.valueOf(false) }, TopicRspBody.class);
    public final PBBoolField is_open = PBField.initBool(false);
    public final PBStringField url = PBField.initString("");
    public final PBStringField watch_word = PBField.initString("");
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "username", "uin" }, new Object[] { "", Long.valueOf(0L) }, UserInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBStringField username = PBField.initString("");
  }
  
  public static final class VideoInfo
    extends MessageMicro<VideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "cover", "title", "type", "schema", "rowkey" }, new Object[] { "", "", Integer.valueOf(0), "", "" }, VideoInfo.class);
    public final PBStringField cover = PBField.initString("");
    public final PBStringField rowkey = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class VideoReqBody
    extends MessageMicro<VideoReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rowkey", "url", "topic_id" }, new Object[] { "", "", "" }, VideoReqBody.class);
    public final PBStringField rowkey = PBField.initString("");
    public final PBStringField topic_id = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class VideoRspBody
    extends MessageMicro<VideoRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "url", "watch_word", "is_open" }, new Object[] { "", "", Boolean.valueOf(false) }, VideoRspBody.class);
    public final PBBoolField is_open = PBField.initBool(false);
    public final PBStringField url = PBField.initString("");
    public final PBStringField watch_word = PBField.initString("");
  }
  
  public static final class WatchRspBody
    extends MessageMicro<WatchRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "type", "is_expired", "is_deleted", "from", "video", "topic" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), null, null, null }, WatchRspBody.class);
    public cmd0xe5c.UserInfo from = new cmd0xe5c.UserInfo();
    public final PBBoolField is_deleted = PBField.initBool(false);
    public final PBBoolField is_expired = PBField.initBool(false);
    public cmd0xe5c.TopicInfo topic = new cmd0xe5c.TopicInfo();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public cmd0xe5c.VideoInfo video = new cmd0xe5c.VideoInfo();
  }
  
  public static final class WatchWordReqBody
    extends MessageMicro<WatchWordReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "watch_word" }, new Object[] { "" }, WatchWordReqBody.class);
    public final PBStringField watch_word = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5c.cmd0xe5c
 * JD-Core Version:    0.7.0.1
 */