package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_feeds
{
  public static final class GroupFeedsMessage
    extends MessageMicro<GroupFeedsMessage>
  {
    public static final int MSG_TYPE_ACTIVITY = 23;
    public static final int MSG_TYPE_APP_NOTICES = 17;
    public static final int MSG_TYPE_CHATMSG = 9;
    public static final int MSG_TYPE_COMMENT = 1;
    public static final int MSG_TYPE_COURSE = 20;
    public static final int MSG_TYPE_FEEDS = 0;
    public static final int MSG_TYPE_GAMES = 21;
    public static final int MSG_TYPE_GROUP_ALBUM = 18;
    public static final int MSG_TYPE_MEMO = 5;
    public static final int MSG_TYPE_MSGPIC = 11;
    public static final int MSG_TYPE_MSGVIDEO = 10;
    public static final int MSG_TYPE_NEW_GUIDELINES = 19;
    public static final int MSG_TYPE_NEW_MEMO = 13;
    public static final int MSG_TYPE_NEW_OBJ_STREAM = 22;
    public static final int MSG_TYPE_PIC_VIEW = 15;
    public static final int MSG_TYPE_SHARE = 4;
    public static final int MSG_TYPE_VOTE = 12;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_album_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_app_open_param = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_batch_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_author_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_extra_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_feeds_author_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_feeds_type = PBField.initEnum(0);
    public final PBFixed32Field fixed32_win_height = PBField.initFixed32(0);
    public final PBFixed32Field fixed32_win_width = PBField.initFixed32(0);
    public final PBInt32Field int32_app_id = PBField.initInt32(0);
    public final PBInt32Field int32_photo_num = PBField.initInt32(0);
    public final PBInt32Field int32_vote_status = PBField.initInt32(0);
    public MemoCtrlInfo memo_ctrl_info = new MemoCtrlInfo();
    public ThemeBrief msg_theme_brief = new ThemeBrief();
    public Vote msg_vote_content = new Vote();
    public final PBUInt32Field opt_uint32_ctl_flag = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_concern_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<MessageContent> rpt_feeds_content = PBField.initRepeatMessage(MessageContent.class);
    public final PBRepeatField<Integer> rpt_my_vote_option_id_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_notify_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<VoteRecord> rpt_vote_record = PBField.initRepeatMessage(VoteRecord.class);
    public final PBRepeatMessageField<VoteStatistic> rpt_vote_statistic = PBField.initRepeatMessage(VoteStatistic.class);
    public final PBUInt32Field uint32_NC_feeds_terinal_ctrl = PBField.initUInt32(0);
    public final PBUInt32Field uint32_edu_organization_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_reported_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    
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
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 45, 53, 58, 66, 82, 98, 104, 114, 122, 128, 154, 162, 168, 178, 184, 192, 202, 210, 216, 226, 232, 242, 248, 256, 400, 410, 416, 426 }, new String[] { "enum_feeds_type", "rpt_feeds_content", "fixed32_win_width", "fixed32_win_height", "bytes_feeds_author_nickname", "bytes_comment_author_nickname", "bytes_group_nickname", "msg_vote_content", "rpt_my_vote_option_id_list", "rpt_vote_statistic", "rpt_vote_record", "int32_vote_status", "bytes_group_name", "bytes_app_name", "rpt_notify_uin_list", "bytes_app_open_param", "int32_app_id", "uint32_reported_id", "bytes_album_name", "bytes_batch_id", "int32_photo_num", "bytes_msg_resid", "uint32_edu_organization_id", "msg_theme_brief", "uint32_NC_feeds_terinal_ctrl", "rpt_concern_uin", "opt_uint32_ctl_flag", "bytes_extra_data", "uint32_expire_time", "memo_ctrl_info" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, Integer.valueOf(0), null, null, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9, Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro10, Integer.valueOf(0), null }, GroupFeedsMessage.class);
    }
    
    public static final class ContentList
      extends MessageMicro<ContentList>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_cont_elements" }, new Object[] { null }, ContentList.class);
      public final PBRepeatMessageField<group_feeds.GroupFeedsMessage.MessageContent> rpt_cont_elements = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.MessageContent.class);
    }
    
    public static final class MemoCtrlInfo
      extends MessageMicro<MemoCtrlInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_need_confirmation" }, new Object[] { Integer.valueOf(0) }, MemoCtrlInfo.class);
      public final PBUInt32Field uint32_need_confirmation = PBField.initUInt32(0);
    }
    
    public static final class MessageContent
      extends MessageMicro<MessageContent>
    {
      public static final int CONTENT_TYPE_CONTROL = 14;
      public static final int CONTENT_TYPE_C_VOTE = 9;
      public static final int CONTENT_TYPE_FACE = 2;
      public static final int CONTENT_TYPE_FILE = 5;
      public static final int CONTENT_TYPE_GBK_FACE = 8;
      public static final int CONTENT_TYPE_LINK = 1;
      public static final int CONTENT_TYPE_MUSIC = 4;
      public static final int CONTENT_TYPE_NC_TAG = 15;
      public static final int CONTENT_TYPE_OBJ_IN_XML = 13;
      public static final int CONTENT_TYPE_PIC = 3;
      public static final int CONTENT_TYPE_PTT = 16;
      public static final int CONTENT_TYPE_TEXT = 0;
      public static final int CONTENT_TYPE_TITLE = 10;
      public static final int CONTENT_TYPE_VIDEO = 6;
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_content_value = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_file_content_sha = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_file_ori = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_file_triple_sha = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_file_url = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_music_name = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_music_url_for_accept = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_music_url_for_refuse = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_music_user_rank = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_object_message_brief = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_pic_id = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_pic_path = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_pic_size = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_video_id = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_video_introduction = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_video_original_url = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_video_source = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_video_swf_url = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBEnumField enum_content_type = PBField.initEnum(0);
      public final PBInt32Field int32_face_idx = PBField.initInt32(0);
      public final PBUInt32Field uint32_file_attr = PBField.initUInt32(0);
      public final PBUInt32Field uint32_group_msg_seq = PBField.initUInt32(0);
      public final PBFixed32Field uint32_music_id = PBField.initFixed32(0);
      public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
      
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
        ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro16 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro17 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro18 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro19 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro20 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro21 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro22 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro23 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 69, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 200, 210, 216, 226, 234, 242, 248, 314, 320, 330 }, new String[] { "enum_content_type", "bytes_content_value", "bytes_pic_size", "bytes_pic_path", "bytes_pic_id", "bytes_pic_url", "bytes_music_user_rank", "uint32_music_id", "bytes_music_name", "bytes_music_url_for_accept", "bytes_music_url_for_refuse", "bytes_file_name", "bytes_file_url", "bytes_file_ori", "bytes_pic_md5", "bytes_video_swf_url", "bytes_video_original_url", "bytes_video_id", "bytes_video_introduction", "int32_face_idx", "bytes_video_source", "uint64_file_size", "bytes_file_content_sha", "bytes_file_triple_sha", "bytes_file_md5", "uint32_file_attr", "bytes_object_message_brief", "uint32_group_msg_seq", "bytes_file_uuid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, Integer.valueOf(0), localByteStringMicro18, Long.valueOf(0L), localByteStringMicro19, localByteStringMicro20, localByteStringMicro21, Integer.valueOf(0), localByteStringMicro22, Integer.valueOf(0), localByteStringMicro23 }, MessageContent.class);
      }
    }
    
    public static final class ThemeBrief
      extends MessageMicro<ThemeBrief>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_state", "rpt_uint64_msguin", "uint32_speaker_num", "uint64_open_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ThemeBrief.class);
      public final PBRepeatField<Long> rpt_uint64_msguin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
      public final PBUInt32Field uint32_speaker_num = PBField.initUInt32(0);
      public final PBUInt32Field uint32_state = PBField.initUInt32(0);
      public final PBUInt64Field uint64_open_uin = PBField.initUInt64(0L);
    }
    
    public static final class Vote
      extends MessageMicro<Vote>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 53 }, new String[] { "msg_title", "int32_max_vote_per_uin", "rpt_msg_options", "msg_vote_des", "msg_vote_res", "uint32_vote_deadline" }, new Object[] { null, Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, Vote.class);
      public final PBInt32Field int32_max_vote_per_uin = PBField.initInt32(0);
      public group_feeds.GroupFeedsMessage.ContentList msg_title = new group_feeds.GroupFeedsMessage.ContentList();
      public group_feeds.GroupFeedsMessage.ContentList msg_vote_des = new group_feeds.GroupFeedsMessage.ContentList();
      public group_feeds.GroupFeedsMessage.ContentList msg_vote_res = new group_feeds.GroupFeedsMessage.ContentList();
      public final PBRepeatMessageField<group_feeds.GroupFeedsMessage.ContentList> rpt_msg_options = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.ContentList.class);
      public final PBFixed32Field uint32_vote_deadline = PBField.initFixed32(0);
    }
    
    public static final class VoteRecord
      extends MessageMicro<VoteRecord>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 29 }, new String[] { "rpt_option_id", "fixed32_vote_uin", "fixed32_vote_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VoteRecord.class);
      public final PBFixed32Field fixed32_vote_time = PBField.initFixed32(0);
      public final PBFixed32Field fixed32_vote_uin = PBField.initFixed32(0);
      public final PBRepeatField<Integer> rpt_option_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    }
    
    public static final class VoteStatistic
      extends MessageMicro<VoteStatistic>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_option_id", "int32_vote_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, VoteStatistic.class);
      public final PBInt32Field int32_option_id = PBField.initInt32(0);
      public final PBInt32Field int32_vote_count = PBField.initInt32(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds
 * JD-Core Version:    0.7.0.1
 */