package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message
{
  public static final class ClearMessageResult
    extends MessageMicro<ClearMessageResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "remain_num", "image_uid", "last_time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ClearMessageResult.class);
    public final PBUInt64Field image_uid = PBField.initUInt64(0L);
    public final PBUInt32Field last_time = PBField.initUInt32(0);
    public final PBUInt32Field remain_num = PBField.initUInt32(0);
  }
  
  public static final class ErrorInfo
    extends MessageMicro<ErrorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBBytesField error_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "error_code", "error_desc" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ErrorInfo.class);
    }
  }
  
  public static final class ReqClearMessage
    extends MessageMicro<ReqClearMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "start_time", "source", "version_ctrl" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqClearMessage.class);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBUInt32Field version_ctrl = PBField.initUInt32(0);
  }
  
  public static final class ReqStoryMessageList
    extends MessageMicro<ReqStoryMessageList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "start_time", "num", "source", "version_ctrl" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqStoryMessageList.class);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBUInt32Field version_ctrl = PBField.initUInt32(0);
  }
  
  public static final class RspClearMessage
    extends MessageMicro<RspClearMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50 }, new String[] { "errinfo", "remain_num", "image_uid", "last_time", "msg_tab", "msg_dynamic" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, null }, RspClearMessage.class);
    public qqstory_710_message.ErrorInfo errinfo = new qqstory_710_message.ErrorInfo();
    public final PBUInt64Field image_uid = PBField.initUInt64(0L);
    public final PBUInt32Field last_time = PBField.initUInt32(0);
    public qqstory_710_message.ClearMessageResult msg_dynamic = new qqstory_710_message.ClearMessageResult();
    public qqstory_710_message.ClearMessageResult msg_tab = new qqstory_710_message.ClearMessageResult();
    public final PBUInt32Field remain_num = PBField.initUInt32(0);
  }
  
  public static final class RspStoryMessageList
    extends MessageMicro<RspStoryMessageList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "errinfo", "message_list", "message_num", "is_end", "has_read_msg" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspStoryMessageList.class);
    public qqstory_710_message.ErrorInfo errinfo = new qqstory_710_message.ErrorInfo();
    public final PBUInt32Field has_read_msg = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_710_message.StoryMessage> message_list = PBField.initRepeatMessage(qqstory_710_message.StoryMessage.class);
    public final PBUInt32Field message_num = PBField.initUInt32(0);
  }
  
  public static final class ShareGroupInfo
    extends MessageMicro<ShareGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBUInt32Field oper_type = PBField.initUInt32(0);
    public final PBUInt64Field oper_uin = PBField.initUInt64(0L);
    public final PBUInt32Field push_time = PBField.initUInt32(0);
    public final PBBytesField share_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField share_new_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field share_type = PBField.initUInt32(0);
    public final PBBytesField share_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58, 66, 72 }, new String[] { "oper_uin", "oper_type", "share_name", "share_new_name", "push_time", "is_bigv", "union_id", "share_union_id", "share_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, ShareGroupInfo.class);
    }
  }
  
  public static final class StoryAnswerInfo
    extends MessageMicro<StoryAnswerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField answer_question = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField answer_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field answer_time = PBField.initUInt32(0);
    public final PBUInt32Field answer_type = PBField.initUInt32(0);
    public final PBUInt64Field answer_uid = PBField.initUInt64(0L);
    public final PBUInt32Field at_video_ts = PBField.initUInt32(0);
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBUInt32Field is_my_answer = PBField.initUInt32(0);
    public final PBBytesField nick_postfix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_del = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58, 64, 72, 82, 88 }, new String[] { "answer_uid", "answer_time", "is_bigv", "union_id", "answer_type", "answer_question", "answer_text", "video_del", "is_my_answer", "nick_postfix", "at_video_ts" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, StoryAnswerInfo.class);
    }
  }
  
  public static final class StoryChallengeInfo
    extends MessageMicro<StoryChallengeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField challenge_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field challenge_time = PBField.initUInt32(0);
    public final PBUInt64Field challenge_uid = PBField.initUInt64(0L);
    public final PBUInt32Field comment_del = PBField.initUInt32(0);
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_del = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 74 }, new String[] { "challenge_uid", "challenge_time", "is_bigv", "union_id", "content", "comment_id", "comment_del", "video_del", "challenge_feed_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, StoryChallengeInfo.class);
    }
  }
  
  public static final class StoryCommentInfo
    extends MessageMicro<StoryCommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field comment_del = PBField.initUInt32(0);
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBUInt32Field comment_time = PBField.initUInt32(0);
    public final PBUInt64Field comment_uid = PBField.initUInt64(0L);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBUInt32Field reply_is_bigv = PBField.initUInt32(0);
    public final PBUInt64Field reply_uid = PBField.initUInt64(0L);
    public final PBBytesField reply_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField share_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field share_type = PBField.initUInt32(0);
    public final PBBytesField share_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 64, 72, 82, 88, 98, 106, 112 }, new String[] { "comment_id", "comment_uid", "comment_time", "content", "comment_del", "is_bigv", "union_id", "reply_uid", "reply_is_bigv", "reply_union_id", "type", "share_name", "share_union_id", "share_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0) }, StoryCommentInfo.class);
    }
  }
  
  public static final class StoryFriendAgreeInfo
    extends MessageMicro<StoryFriendAgreeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "friend_uin", "agree_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, StoryFriendAgreeInfo.class);
    public final PBUInt32Field agree_time = PBField.initUInt32(0);
    public final PBUInt64Field friend_uin = PBField.initUInt64(0L);
  }
  
  public static final class StoryGradeInfo
    extends MessageMicro<StoryGradeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field at_video_ts = PBField.initUInt32(0);
    public final PBUInt32Field grade_option = PBField.initUInt32(0);
    public final PBBytesField grade_question = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field grade_time = PBField.initUInt32(0);
    public final PBUInt32Field grade_type = PBField.initUInt32(0);
    public final PBUInt64Field grade_uid = PBField.initUInt64(0L);
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBUInt32Field is_my_grade = PBField.initUInt32(0);
    public final PBBytesField nick_postfix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_del = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56, 64, 72, 82, 88 }, new String[] { "grade_uid", "grade_time", "is_bigv", "union_id", "grade_type", "grade_question", "grade_option", "video_del", "is_my_grade", "nick_postfix", "at_video_ts" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0) }, StoryGradeInfo.class);
    }
  }
  
  public static final class StoryLikeInfo
    extends MessageMicro<StoryLikeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBUInt32Field like_time = PBField.initUInt32(0);
    public final PBUInt64Field like_uid = PBField.initUInt64(0L);
    public final PBBytesField share_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field share_type = PBField.initUInt32(0);
    public final PBBytesField share_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58, 64 }, new String[] { "like_uid", "like_time", "is_bigv", "union_id", "type", "share_name", "share_union_id", "share_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, StoryLikeInfo.class);
    }
  }
  
  public static final class StoryMedalInfo
    extends MessageMicro<StoryMedalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBUInt64Field official_uin = PBField.initUInt64(0L);
    public final PBUInt32Field push_time = PBField.initUInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50 }, new String[] { "official_uin", "is_bigv", "union_id", "push_time", "content", "cover_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, StoryMedalInfo.class);
    }
  }
  
  public static final class StoryMessage
    extends MessageMicro<StoryMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_710_message.StoryFriendAgreeInfo agree_info = new qqstory_710_message.StoryFriendAgreeInfo();
    public qqstory_710_message.StoryAnswerInfo answer_info = new qqstory_710_message.StoryAnswerInfo();
    public qqstory_710_message.StoryChallengeInfo chall_info = new qqstory_710_message.StoryChallengeInfo();
    public qqstory_710_message.StoryCommentInfo comment_info = new qqstory_710_message.StoryCommentInfo();
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_710_message.StoryGradeInfo grade_info = new qqstory_710_message.StoryGradeInfo();
    public qqstory_710_message.StoryLikeInfo like_info = new qqstory_710_message.StoryLikeInfo();
    public qqstory_710_message.StoryMedalInfo medal_info = new qqstory_710_message.StoryMedalInfo();
    public final PBUInt32Field message_id = PBField.initUInt32(0);
    public qqstory_710_message.StoryOfficialInfo official_info = new qqstory_710_message.StoryOfficialInfo();
    public qqstory_710_message.StoryPhotoTogetherInfo photo_info = new qqstory_710_message.StoryPhotoTogetherInfo();
    public qqstory_710_message.StoryPublishInfo publish_info = new qqstory_710_message.StoryPublishInfo();
    public qqstory_710_message.ShareGroupInfo share_info = new qqstory_710_message.ShareGroupInfo();
    public final PBUInt32Field src_type = PBField.initUInt32(0);
    public final PBUInt64Field src_uid = PBField.initUInt64(0L);
    public qqstory_710_message.StoryVideoInfo video_info = new qqstory_710_message.StoryVideoInfo();
    public qqstory_710_message.StoryVoteInfo vote_info = new qqstory_710_message.StoryVoteInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 74, 82, 90, 98, 106, 114, 122, 130, 138 }, new String[] { "like_info", "comment_info", "publish_info", "video_info", "feed_id", "message_id", "src_type", "src_uid", "official_info", "share_info", "medal_info", "vote_info", "grade_info", "answer_info", "agree_info", "chall_info", "photo_info" }, new Object[] { null, null, null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null, null, null, null, null, null, null, null }, StoryMessage.class);
    }
  }
  
  public static final class StoryMessagePollInfo
    extends MessageMicro<StoryMessagePollInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField choice_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField message_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field oper_type = PBField.initUInt32(0);
    public final PBUInt64Field oper_uin = PBField.initUInt64(0L);
    public final PBUInt32Field push_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "oper_uin", "oper_type", "message_text", "choice_text", "push_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, StoryMessagePollInfo.class);
    }
  }
  
  public static final class StoryOfficialInfo
    extends MessageMicro<StoryOfficialInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBUInt32Field jump_type = PBField.initUInt32(0);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field official_uin = PBField.initUInt64(0L);
    public final PBUInt32Field push_time = PBField.initUInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field url_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 64, 72 }, new String[] { "official_uin", "is_bigv", "union_id", "push_time", "content", "cover_url", "jump_url", "url_type", "jump_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0) }, StoryOfficialInfo.class);
    }
  }
  
  public static final class StoryPhotoTogetherInfo
    extends MessageMicro<StoryPhotoTogetherInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field at_video_ts = PBField.initUInt32(0);
    public final PBUInt32Field comment_del = PBField.initUInt32(0);
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBBytesField photo_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field photo_time = PBField.initUInt32(0);
    public final PBUInt64Field photo_uid = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_del = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 74, 80 }, new String[] { "photo_uid", "photo_time", "is_bigv", "union_id", "content", "comment_id", "comment_del", "video_del", "photo_feed_id", "at_video_ts" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0) }, StoryPhotoTogetherInfo.class);
    }
  }
  
  public static final class StoryPublishInfo
    extends MessageMicro<StoryPublishInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBUInt32Field publish_time = PBField.initUInt32(0);
    public final PBUInt64Field publish_uid = PBField.initUInt64(0L);
    public final PBBytesField share_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field share_type = PBField.initUInt32(0);
    public final PBBytesField share_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_del = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58, 64 }, new String[] { "publish_uid", "publish_time", "is_bigv", "union_id", "video_del", "share_name", "share_union_id", "share_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, StoryPublishInfo.class);
    }
  }
  
  public static final class StoryVideoInfo
    extends MessageMicro<StoryVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field author_uid = PBField.initUInt64(0L);
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_time = PBField.initUInt32(0);
    public final PBBytesField vote_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58 }, new String[] { "vid", "cover_url", "author_uid", "video_time", "is_bigv", "union_id", "vote_attr" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, StoryVideoInfo.class);
    }
  }
  
  public static final class StoryVoteInfo
    extends MessageMicro<StoryVoteInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field at_video_ts = PBField.initUInt32(0);
    public final PBUInt32Field is_bigv = PBField.initUInt32(0);
    public final PBUInt32Field is_my_vote = PBField.initUInt32(0);
    public final PBBytesField nick_postfix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_del = PBField.initUInt32(0);
    public final PBBytesField vote_answer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vote_question = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field vote_time = PBField.initUInt32(0);
    public final PBUInt32Field vote_type = PBField.initUInt32(0);
    public final PBUInt64Field vote_uid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58, 64, 72, 82, 88 }, new String[] { "vote_uid", "vote_time", "is_bigv", "union_id", "vote_type", "vote_question", "vote_answer", "video_del", "is_my_vote", "nick_postfix", "at_video_ts" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, StoryVoteInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message
 * JD-Core Version:    0.7.0.1
 */