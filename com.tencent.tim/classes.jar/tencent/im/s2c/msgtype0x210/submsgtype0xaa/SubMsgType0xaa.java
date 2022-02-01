package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xaa
{
  public static final class GameTeam_MsgBody
    extends MessageMicro<GameTeam_MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_GameTeamCmd", "msg_turnOverMessage", "msg_startGameMessage", "msg_updateTeamMessage" }, new Object[] { Integer.valueOf(0), null, null, null }, GameTeam_MsgBody.class);
    public SubMsgType0xaa.GameTeam_StartGameMessage msg_startGameMessage = new SubMsgType0xaa.GameTeam_StartGameMessage();
    public SubMsgType0xaa.GameTeam_TurnOverMessage msg_turnOverMessage = new SubMsgType0xaa.GameTeam_TurnOverMessage();
    public SubMsgType0xaa.GameTeam_UpdateTeamMessage msg_updateTeamMessage = new SubMsgType0xaa.GameTeam_UpdateTeamMessage();
    public final PBUInt32Field uint32_GameTeamCmd = PBField.initUInt32(0);
  }
  
  public static final class GameTeam_StartGameMessage
    extends MessageMicro<GameTeam_StartGameMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 66, 72, 80, 88 }, new String[] { "str_gamedata", "uint32_platformType", "str_title", "str_summary", "str_picUrl", "str_appid", "str_appStoreId", "str_packageName", "uint64_createMsgTime", "uint32_expire", "uint64_buildTeamTime" }, new Object[] { "", Integer.valueOf(0), "", "", "", "", "", "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, GameTeam_StartGameMessage.class);
    public final PBStringField str_appStoreId = PBField.initString("");
    public final PBStringField str_appid = PBField.initString("");
    public final PBStringField str_gamedata = PBField.initString("");
    public final PBStringField str_packageName = PBField.initString("");
    public final PBStringField str_picUrl = PBField.initString("");
    public final PBStringField str_summary = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBUInt32Field uint32_expire = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platformType = PBField.initUInt32(0);
    public final PBUInt64Field uint64_buildTeamTime = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_createMsgTime = PBField.initUInt64(0L);
  }
  
  public static final class GameTeam_TurnOverMessage
    extends MessageMicro<GameTeam_TurnOverMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48, 56, 64, 72, 80, 88, 98, 104, 114 }, new String[] { "str_teamId", "uint32_sessionType", "str_sourceUin", "str_actionUin", "actionType", "uint32_currentCount", "uint32_totalCount", "uint64_createMsgTime", "uint32_status", "uint32_expire", "uint64_buildTeamTime", "str_leaderUin", "uin32_leaderStatus", "InviteSourceList" }, new Object[] { "", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), null }, GameTeam_TurnOverMessage.class);
    public final PBRepeatMessageField<SubMsgType0xaa.InviteSource> InviteSourceList = PBField.initRepeatMessage(SubMsgType0xaa.InviteSource.class);
    public final PBUInt32Field actionType = PBField.initUInt32(0);
    public final PBStringField str_actionUin = PBField.initString("");
    public final PBStringField str_leaderUin = PBField.initString("");
    public final PBStringField str_sourceUin = PBField.initString("");
    public final PBStringField str_teamId = PBField.initString("");
    public final PBUInt32Field uin32_leaderStatus = PBField.initUInt32(0);
    public final PBUInt32Field uint32_currentCount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sessionType = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_totalCount = PBField.initUInt32(0);
    public final PBUInt64Field uint64_buildTeamTime = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_createMsgTime = PBField.initUInt64(0L);
  }
  
  public static final class GameTeam_UpdateTeamMessage
    extends MessageMicro<GameTeam_UpdateTeamMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64, 74, 80 }, new String[] { "str_teamId", "str_gameId", "uint32_status", "str_modeImg", "uint32_current_count", "uint64_createMsgTime", "uint32_expire", "uint64_buildTeamTime", "str_leaderUin", "uin32_leaderStatus" }, new Object[] { "", "", Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0) }, GameTeam_UpdateTeamMessage.class);
    public final PBStringField str_gameId = PBField.initString("");
    public final PBStringField str_leaderUin = PBField.initString("");
    public final PBStringField str_modeImg = PBField.initString("");
    public final PBStringField str_teamId = PBField.initString("");
    public final PBUInt32Field uin32_leaderStatus = PBField.initUInt32(0);
    public final PBUInt32Field uint32_current_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_buildTeamTime = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_createMsgTime = PBField.initUInt64(0L);
  }
  
  public static final class InviteSource
    extends MessageMicro<InviteSource>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "src" }, new Object[] { Integer.valueOf(0), "" }, InviteSource.class);
    public final PBStringField src = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "cmd", "msg_gameTeamMsg", "msg_onlineDocMsg" }, new Object[] { Integer.valueOf(0), null, null }, MsgBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public SubMsgType0xaa.GameTeam_MsgBody msg_gameTeamMsg = new SubMsgType0xaa.GameTeam_MsgBody();
    public SubMsgType0xaa.OnlineDoc_MsgBody msg_onlineDocMsg = new SubMsgType0xaa.OnlineDoc_MsgBody();
  }
  
  public static final class OnlineDoc_MsgBody
    extends MessageMicro<OnlineDoc_MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_OnlineDocCmd", "msg_pushChangeTitleMessage", "msg_pushNewPadMessage", "msg_pushPreviewToEdit" }, new Object[] { Integer.valueOf(0), null, null, null }, OnlineDoc_MsgBody.class);
    public SubMsgType0xaa.OnlineDoc_PushChangeTitleMessage msg_pushChangeTitleMessage = new SubMsgType0xaa.OnlineDoc_PushChangeTitleMessage();
    public SubMsgType0xaa.OnlineDoc_PushNewPadMessage msg_pushNewPadMessage = new SubMsgType0xaa.OnlineDoc_PushNewPadMessage();
    public SubMsgType0xaa.OnlineDoc_PushPreviewToEditMessage msg_pushPreviewToEdit = new SubMsgType0xaa.OnlineDoc_PushPreviewToEditMessage();
    public final PBUInt32Field uint32_OnlineDocCmd = PBField.initUInt32(0);
  }
  
  public static final class OnlineDoc_PushChangeTitleMessage
    extends MessageMicro<OnlineDoc_PushChangeTitleMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_last_editor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_edit_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_editor_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48 }, new String[] { "uint32_domainid", "bytes_localpadid", "bytes_title", "uint64_last_editor_uin", "bytes_last_editor_nick", "uint64_last_edit_time" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Long.valueOf(0L) }, OnlineDoc_PushChangeTitleMessage.class);
    }
  }
  
  public static final class OnlineDoc_PushNewPadMessage
    extends MessageMicro<OnlineDoc_PushNewPadMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_delete_flag = PBField.initBool(false);
    public final PBBoolField bool_pinned_flag = PBField.initBool(false);
    public final PBBytesField bytes_creator_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_hostuser_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_last_editor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_last_viewer_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pdid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_policy = PBField.initUInt32(0);
    public final PBUInt32Field uint32_right_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_creator_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_current_user_browse_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_hostuser_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_auth_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_delete_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_edit_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_editor_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_pinned_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_unpinned_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_view_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_viewer_uin = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50, 56, 66, 72, 80, 88, 98, 104, 112, 120, 128, 138, 144, 152, 160, 168, 178, 184, 192, 200, 210, 218 }, new String[] { "bytes_pad_url", "uint32_type", "bytes_title", "uint64_create_time", "uint64_creator_uin", "bytes_creator_nick", "uint64_last_editor_uin", "bytes_last_editor_nick", "uint64_last_edit_time", "bool_pinned_flag", "uint64_last_viewer_uin", "bytes_last_viewer_nick", "uint64_last_view_time", "uint64_last_pinned_time", "uint64_current_user_browse_time", "uint64_hostuser_uin", "bytes_hostuser_nick", "uint64_last_auth_time", "uint32_policy", "uint32_right_flag", "uint32_domainid", "bytes_localpadid", "uint64_last_unpinned_time", "bool_delete_flag", "uint64_last_delete_time", "bytes_thumb_url", "bytes_pdid" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), localByteStringMicro5, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), localByteStringMicro8, localByteStringMicro9 }, OnlineDoc_PushNewPadMessage.class);
    }
  }
  
  public static final class OnlineDoc_PushPreviewToEditMessage
    extends MessageMicro<OnlineDoc_PushPreviewToEditMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_aio_session = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_version", "bytes_title", "bytes_pad_url", "bytes_aio_session" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, OnlineDoc_PushPreviewToEditMessage.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa
 * JD-Core Version:    0.7.0.1
 */