package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class value
{
  public static final class Attach
    extends MessageMicro<Attach>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "name", "url", "size", "bus_id" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, Attach.class);
    public final PBUInt32Field bus_id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class CourseInfo
    extends MessageMicro<CourseInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "course_id", "course_name" }, new Object[] { Integer.valueOf(0), "" }, CourseInfo.class);
    public final PBUInt32Field course_id = PBField.initUInt32(0);
    public final PBStringField course_name = PBField.initString("");
  }
  
  public static final class CourseList
    extends MessageMicro<CourseList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "course_info" }, new Object[] { null }, CourseList.class);
    public final PBRepeatMessageField<value.CourseInfo> course_info = PBField.initRepeatMessage(value.CourseInfo.class);
  }
  
  public static final class ExamMsg
    extends MessageMicro<ExamMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field difficulty = PBField.initUInt32(0);
    public final PBStringField difficulty_desc = PBField.initString("");
    public final PBStringField grade = PBField.initString("");
    public final PBBytesField key_point = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField material_id = PBField.initString("");
    public final PBBytesField question_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField sp_hw_id = PBField.initString("");
    public final PBUInt32Field sp_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66 }, new String[] { "sp_id", "sp_hw_id", "material_id", "difficulty", "key_point", "question_list", "difficulty_desc", "grade" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, "", "" }, ExamMsg.class);
    }
  }
  
  public static final class GroupUserCourse
    extends MessageMicro<GroupUserCourse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "course_list", "last_course", "default_exclude" }, new Object[] { null, null, null }, GroupUserCourse.class);
    public value.CourseList course_list = new value.CourseList();
    public value.CourseList default_exclude = new value.CourseList();
    public value.CourseInfo last_course = new value.CourseInfo();
  }
  
  public static final class GroupUserIdentity
    extends MessageMicro<GroupUserIdentity>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "infos" }, new Object[] { null }, GroupUserIdentity.class);
    public final PBRepeatMessageField<value.UserIdentityInfo> infos = PBField.initRepeatMessage(value.UserIdentityInfo.class);
  }
  
  public static final class HomeworkInfo
    extends MessageMicro<HomeworkInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field course_id = PBField.initUInt32(0);
    public final PBStringField course_name = PBField.initString("");
    public final PBUInt64Field create_ts = PBField.initUInt64(0L);
    public final PBStringField date = PBField.initString("");
    public value.ExamMsg exam_msg = new value.ExamMsg();
    public final PBUInt32Field feedback = PBField.initUInt32(0);
    public final PBUInt32Field feedback_num = PBField.initUInt32(0);
    public final PBUInt64Field feedback_ts = PBField.initUInt64(0L);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt64Field hw_id = PBField.initUInt64(0L);
    public final PBUInt32Field hw_type = PBField.initUInt32(0);
    public final PBBoolField is_read = PBField.initBool(false);
    public value.MultiMedia multi_media = new value.MultiMedia();
    public final PBBoolField need_feedback = PBField.initBool(false);
    public final PBUInt64Field push_time = PBField.initUInt64(0L);
    public final PBRepeatField<Long> syncgids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field team_id = PBField.initUInt64(0L);
    public final PBStringField title = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 72, 80, 90, 96, 104, 114, 120, 128, 136, 144, 152, 160, 168 }, new String[] { "group_id", "uin", "course_id", "course_name", "title", "content", "date", "need_feedback", "push_time", "feedback_ts", "multi_media", "team_id", "hw_type", "exam_msg", "syncgids", "hw_id", "appid", "feedback_num", "is_read", "feedback", "create_ts" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", "", localByteStringMicro, "", Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(0L), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Long.valueOf(0L) }, HomeworkInfo.class);
    }
  }
  
  public static final class HomeworkLimit
    extends MessageMicro<HomeworkLimit>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "count", "ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, HomeworkLimit.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field ts = PBField.initUInt32(0);
  }
  
  public static final class HomeworkTmemDetail
    extends MessageMicro<HomeworkTmemDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt64Field created = PBField.initInt64(0L);
    public final PBBytesField feed_topic_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public value.HomeworkInfo info = new value.HomeworkInfo();
    public final PBInt32Field status = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "info", "status", "created", "feed_topic_id" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, HomeworkTmemDetail.class);
    }
  }
  
  public static final class HomeworkTmemList
    extends MessageMicro<HomeworkTmemList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "infos" }, new Object[] { null }, HomeworkTmemList.class);
    public final PBRepeatMessageField<value.HomeworkInfo> infos = PBField.initRepeatMessage(value.HomeworkInfo.class);
  }
  
  public static final class HwCommentInfo
    extends MessageMicro<HwCommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field createts = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public final PBUInt64Field modifyts = PBField.initUInt64(0L);
    public value.MultiMedia multi_media = new value.MultiMedia();
    public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "id", "text", "multi_media", "createts", "modifyts", "uin" }, new Object[] { "", localByteStringMicro, null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, HwCommentInfo.class);
    }
  }
  
  public static final class HwExamAnswer
    extends MessageMicro<HwExamAnswer>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "questionid", "answer", "result", "score" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, HwExamAnswer.class);
    public final PBStringField answer = PBField.initString("");
    public final PBStringField questionid = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field score = PBField.initUInt32(0);
  }
  
  public static final class HwExamination
    extends MessageMicro<HwExamination>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 90, 402 }, new String[] { "total_count", "correct_count", "error_count", "undone_count", "total_score", "elapsed_time", "avg_elapsed_time", "difficult", "answer_status", "answer_analyse", "difficult_desc", "answer" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", null }, HwExamination.class);
    public final PBRepeatMessageField<value.HwExamAnswer> answer = PBField.initRepeatMessage(value.HwExamAnswer.class);
    public final PBStringField answer_analyse = PBField.initString("");
    public final PBUInt32Field answer_status = PBField.initUInt32(0);
    public final PBUInt32Field avg_elapsed_time = PBField.initUInt32(0);
    public final PBUInt32Field correct_count = PBField.initUInt32(0);
    public final PBUInt32Field difficult = PBField.initUInt32(0);
    public final PBStringField difficult_desc = PBField.initString("");
    public final PBUInt32Field elapsed_time = PBField.initUInt32(0);
    public final PBUInt32Field error_count = PBField.initUInt32(0);
    public final PBUInt32Field total_count = PBField.initUInt32(0);
    public final PBUInt32Field total_score = PBField.initUInt32(0);
    public final PBUInt32Field undone_count = PBField.initUInt32(0);
  }
  
  public static final class HwFeedback
    extends MessageMicro<HwFeedback>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 82, 88, 96, 106, 162, 168 }, new String[] { "uin", "nick", "head", "status", "remind_ts", "review_ts", "feedback_ts", "content", "content_storage", "correct_rate", "openId", "relation", "user_status" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), "", null, Integer.valueOf(0) }, HwFeedback.class);
    public FbContent content = new FbContent();
    public final PBInt32Field content_storage = PBField.initInt32(0);
    public final PBUInt32Field correct_rate = PBField.initUInt32(0);
    public final PBUInt64Field feedback_ts = PBField.initUInt64(0L);
    public final PBStringField head = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField openId = PBField.initString("");
    public final PBRepeatMessageField<Relation> relation = PBField.initRepeatMessage(Relation.class);
    public final PBUInt64Field remind_ts = PBField.initUInt64(0L);
    public final PBUInt64Field review_ts = PBField.initUInt64(0L);
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBUInt32Field user_status = PBField.initUInt32(0);
    
    public static final class FbContent
      extends MessageMicro<FbContent>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "main", "comment", "examination" }, new Object[] { null, null, null }, FbContent.class);
      public final PBRepeatMessageField<value.HwCommentInfo> comment = PBField.initRepeatMessage(value.HwCommentInfo.class);
      public value.HwExamination examination = new value.HwExamination();
      public final PBRepeatMessageField<value.HwCommentInfo> main = PBField.initRepeatMessage(value.HwCommentInfo.class);
    }
    
    public static final class Relation
      extends MessageMicro<Relation>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uin", "status", "nick" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, Relation.class);
      public final PBStringField nick = PBField.initString("");
      public final PBInt32Field status = PBField.initInt32(0);
      public final PBUInt64Field uin = PBField.initUInt64(0L);
    }
  }
  
  public static final class HwFeedbackList
    extends MessageMicro<HwFeedbackList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 800 }, new String[] { "feedback", "total", "rate_noread", "rate_feedback", "is_hw_exist", "need_feedback", "hw_publisher", "gid", "team_id", "hw_type", "unreview_num", "reviewed_num", "feedback_num", "comment_num", "single_remind_limit", "onekey_remind_limit", "version" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, HwFeedbackList.class);
    public final PBUInt32Field comment_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<value.HwFeedback> feedback = PBField.initRepeatMessage(value.HwFeedback.class);
    public final PBUInt32Field feedback_num = PBField.initUInt32(0);
    public final PBUInt64Field gid = PBField.initUInt64(0L);
    public final PBUInt64Field hw_publisher = PBField.initUInt64(0L);
    public final PBUInt32Field hw_type = PBField.initUInt32(0);
    public final PBInt32Field is_hw_exist = PBField.initInt32(0);
    public final PBInt32Field need_feedback = PBField.initInt32(0);
    public final PBInt32Field onekey_remind_limit = PBField.initInt32(0);
    public final PBInt32Field rate_feedback = PBField.initInt32(0);
    public final PBInt32Field rate_noread = PBField.initInt32(0);
    public final PBUInt32Field reviewed_num = PBField.initUInt32(0);
    public final PBInt32Field single_remind_limit = PBField.initInt32(0);
    public final PBUInt64Field team_id = PBField.initUInt64(0L);
    public final PBInt32Field total = PBField.initInt32(0);
    public final PBUInt32Field unreview_num = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class HwTmemList
    extends MessageMicro<HwTmemList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "simple_infos", "actual_cnt", "store_cnt" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, HwTmemList.class);
    public final PBInt32Field actual_cnt = PBField.initInt32(0);
    public final PBRepeatMessageField<HwSimpleInfo> simple_infos = PBField.initRepeatMessage(HwSimpleInfo.class);
    public final PBInt32Field store_cnt = PBField.initInt32(0);
    
    public static final class HwSimpleInfo
      extends MessageMicro<HwSimpleInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "hw_id", "uin", "team_id", "hw_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, HwSimpleInfo.class);
      public final PBUInt64Field hw_id = PBField.initUInt64(0L);
      public final PBUInt32Field hw_type = PBField.initUInt32(0);
      public final PBUInt64Field team_id = PBField.initUInt64(0L);
      public final PBUInt64Field uin = PBField.initUInt64(0L);
    }
  }
  
  public static final class MultiMedia
    extends MessageMicro<MultiMedia>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "pic", "voice", "video", "attach" }, new Object[] { null, null, null, null }, MultiMedia.class);
    public final PBRepeatMessageField<value.Attach> attach = PBField.initRepeatMessage(value.Attach.class);
    public final PBRepeatMessageField<value.Picture> pic = PBField.initRepeatMessage(value.Picture.class);
    public final PBRepeatMessageField<value.Video> video = PBField.initRepeatMessage(value.Video.class);
    public final PBRepeatMessageField<value.Voice> voice = PBField.initRepeatMessage(value.Voice.class);
  }
  
  public static final class MyRead
    extends MessageMicro<MyRead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "hw_ids" }, new Object[] { Long.valueOf(0L) }, MyRead.class);
    public final PBRepeatField<Long> hw_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class Picture
    extends MessageMicro<Picture>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "url", "size" }, new Object[] { "", Integer.valueOf(0) }, Picture.class);
    public final PBRepeatField<Integer> size = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class UserIdentityInfo
    extends MessageMicro<UserIdentityInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66 }, new String[] { "group_id", "id", "course", "title", "name", "ts", "type", "tmp_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), null }, UserIdentityInfo.class);
    public final PBStringField course = PBField.initString("");
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public UserIdentityInfo tmp_info = new UserIdentityInfo();
    public final PBUInt32Field ts = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class Video
    extends MessageMicro<Video>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50 }, new String[] { "url", "title", "summary", "pic", "type", "real_url" }, new Object[] { "", "", "", "", Integer.valueOf(0), "" }, Video.class);
    public final PBStringField pic = PBField.initString("");
    public final PBStringField real_url = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class Voice
    extends MessageMicro<Voice>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "url", "time", "size", "url_mp3" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "" }, Voice.class);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBUInt32Field time = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBStringField url_mp3 = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value
 * JD-Core Version:    0.7.0.1
 */