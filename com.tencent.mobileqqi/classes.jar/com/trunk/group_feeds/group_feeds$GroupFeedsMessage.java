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

public final class group_feeds$GroupFeedsMessage
  extends MessageMicro
{
  public static final int ADMIN = 2;
  public static final int ADMIN_EXIT = 6;
  public static final int APP_ID_FIELD_NUMBER = 23;
  public static final int APP_NOTICES = 17;
  public static final int APP_OPEN_PARAM_FIELD_NUMBER = 22;
  public static final int ATUIN_FIELD_NUMBER = 3;
  public static final int BYTES_ALBUM_NAME_FIELD_NUMBER = 25;
  public static final int BYTES_APP_NAME_FIELD_NUMBER = 20;
  public static final int BYTES_BATCH_ID_FIELD_NUMBER = 26;
  public static final int BYTES_GALLIANCE_NAME_FIELD_NUMBER = 17;
  public static final int BYTES_GROUP_NAME_FIELD_NUMBER = 19;
  public static final int BYTES_MSG_RESID_FIELD_NUMBER = 28;
  public static final int CHATMSG = 9;
  public static final int COMMENT = 1;
  public static final int COMMENT_UINNICK_FIELD_NUMBER = 8;
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int COURSE = 20;
  public static final int FEEDS = 0;
  public static final int FEEDS_UINNICK_FIELD_NUMBER = 7;
  public static final int GALLIANCE_NOTICE = 14;
  public static final int GALLIANCE_QT_EVENT = 16;
  public static final int GAMES = 21;
  public static final int GROUP_ALBUM = 18;
  public static final int GROUP_NICK_FIELD_NUMBER = 10;
  public static final int INT32_IDENTIFY_FLAG_FIELD_NUMBER = 18;
  public static final int MEMBER = 3;
  public static final int MEMBER_KICKOUT = 7;
  public static final int MEMO = 5;
  public static final int MSGPIC = 11;
  public static final int MSGVIDEO = 10;
  public static final int NEW_GUIDELINES = 19;
  public static final int NEW_MEMO = 13;
  public static final int NEW_OBJ_STREAM = 22;
  public static final int NOTIFY_UIN_FIELD_NUMBER = 21;
  public static final int OWNVOT_FIELD_NUMBER = 13;
  public static final int PHOTO_NUM_FIELD_NUMBER = 27;
  public static final int PIC_VIEW = 15;
  public static final int REPORTED_ID_FIELD_NUMBER = 24;
  public static final int RESERVE2 = 23;
  public static final int RESERVE3 = 24;
  public static final int RESERVE4 = 25;
  public static final int RESERVE5 = 26;
  public static final int RESERVE6 = 27;
  public static final int RESERVE7 = 28;
  public static final int RESERVE8 = 29;
  public static final int RESERVE9 = 30;
  public static final int SECCMT = 8;
  public static final int SECCMTID_FIELD_NUMBER = 4;
  public static final int SECCOMMENT_UINNICK_FIELD_NUMBER = 9;
  public static final int SECOND_COMMENTS_FIELD_NUMBER = 11;
  public static final int SHARE = 4;
  public static final int TYPE_FIELD_NUMBER = 1;
  public static final int VOTE = 12;
  public static final int VOTE_FIELD_NUMBER = 12;
  public static final int VOTE_STATE_FIELD_NUMBER = 16;
  public static final int V_RECORD_FIELD_NUMBER = 15;
  public static final int V_STATISTIC_FIELD_NUMBER = 14;
  public static final int WIN_HEIGHT_FIELD_NUMBER = 6;
  public static final int WIN_WIDTH_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field app_id = PBField.initInt32(0);
  public final PBBytesField app_open_param = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField atuin = PBField.initRepeat(PBFixed32Field.__repeatHelper__);
  public final PBBytesField bytes_album_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_batch_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gAlliance_Name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField comment_uinnick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField content = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.MessageContent.class);
  public final PBBytesField feeds_uinnick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField group_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_identify_flag = PBField.initInt32(0);
  public final PBRepeatField notify_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField ownVot = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBInt32Field photo_num = PBField.initInt32(0);
  public final PBRepeatField reported_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBInt32Field seccmtid = PBField.initInt32(0);
  public final PBBytesField seccomment_uinnick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField second_comments = PBField.initRepeatMessage(GroupFeedsMessage.class);
  public final PBEnumField type = PBField.initEnum(0);
  public final PBRepeatMessageField v_record = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.VoteRecord.class);
  public final PBRepeatMessageField v_statistic = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.VoteStatistic.class);
  public group_feeds.GroupFeedsMessage.Vote vote = new group_feeds.GroupFeedsMessage.Vote();
  public final PBInt32Field vote_state = PBField.initInt32(0);
  public final PBFixed32Field win_height = PBField.initFixed32(0);
  public final PBFixed32Field win_width = PBField.initFixed32(0);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 29, 32, 45, 53, 58, 66, 74, 82, 90, 98, 104, 114, 122, 128, 138, 144, 154, 162, 168, 178, 184, 192, 202, 210, 216, 226 }, new String[] { "type", "content", "atuin", "seccmtid", "win_width", "win_height", "feeds_uinnick", "comment_uinnick", "seccomment_uinnick", "group_nick", "second_comments", "vote", "ownVot", "v_statistic", "v_record", "vote_state", "bytes_gAlliance_Name", "int32_identify_flag", "bytes_group_name", "bytes_app_name", "notify_uin", "app_open_param", "app_id", "reported_id", "bytes_album_name", "bytes_batch_id", "photo_num", "bytes_msg_resid" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Long.valueOf(0L), localByteStringMicro8, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), localByteStringMicro11 }, GroupFeedsMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage
 * JD-Core Version:    0.7.0.1
 */