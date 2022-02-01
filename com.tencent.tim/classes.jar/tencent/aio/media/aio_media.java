package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media
{
  public static final class AIOPush
    extends MessageMicro<AIOPush>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64 }, new String[] { "enum_aio_type", "uint64_id", "msg_push_type", "seq", "uint32_joined_num", "enum_c2c_join_state", "msg_personal_setting", "enum_play_mode" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), null, Integer.valueOf(1) }, AIOPush.class);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBEnumField enum_c2c_join_state = PBField.initEnum(1);
    public final PBEnumField enum_play_mode = PBField.initEnum(1);
    public aio_media.PersonalSetting msg_personal_setting = new aio_media.PersonalSetting();
    public final PBEnumField msg_push_type = PBField.initEnum(1);
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    public final PBUInt32Field uint32_joined_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  }
  
  public static final class DynamicInfo
    extends MessageMicro<DynamicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24 }, new String[] { "uint32_user_num", "rpt_uint64_uins" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, DynamicInfo.class);
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_user_num = PBField.initUInt32(0);
  }
  
  public static final class PersonalSetting
    extends MessageMicro<PersonalSetting>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_theme_id" }, new Object[] { Integer.valueOf(0) }, PersonalSetting.class);
    public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
  }
  
  public static final class ReqCollect
    extends MessageMicro<ReqCollect>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_song_id" }, new Object[] { "" }, ReqCollect.class);
    public final PBStringField str_song_id = PBField.initString("");
  }
  
  public static final class ReqGetDynamicInfo
    extends MessageMicro<ReqGetDynamicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqGetDynamicInfo.class);
  }
  
  public static final class ReqGetUserAuth
    extends MessageMicro<ReqGetUserAuth>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_id" }, new Object[] { Long.valueOf(0L) }, ReqGetUserAuth.class);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqLatestPlayingState
    extends MessageMicro<ReqLatestPlayingState>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "enum_aio_type", "uint64_id", "uint32_version" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(0) }, ReqLatestPlayingState.class);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqMediaOperation
    extends MessageMicro<ReqMediaOperation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "enum_aio_type", "uint64_id", "enum_operation", "enum_play_mode", "enum_cut_type" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) }, ReqMediaOperation.class);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBEnumField enum_cut_type = PBField.initEnum(1);
    public final PBEnumField enum_operation = PBField.initEnum(1);
    public final PBEnumField enum_play_mode = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqReportDownloadFail
    extends MessageMicro<ReqReportDownloadFail>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_song_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_song_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_singer = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBStringField str_song_id = PBField.initString("");
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "enum_aio_type", "uint64_id", "str_song_id", "bytes_song_name", "rpt_bytes_singer", "bytes_song_url" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ReqReportDownloadFail.class);
    }
  }
  
  public static final class ReqRoomOperation
    extends MessageMicro<ReqRoomOperation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "enum_aio_type", "uint64_id", "enum_room_operation", "enum_media_type" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(1) }, ReqRoomOperation.class);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBEnumField enum_media_type = PBField.initEnum(1);
    public final PBEnumField enum_room_operation = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqShareTrans
    extends MessageMicro<ReqShareTrans>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_cut_song = PBField.initBool(false);
    public final PBBytesField bytes_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_song_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_song_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_singer = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBStringField str_song_id = PBField.initString("");
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_share_appid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sharer_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 66, 72, 80, 90 }, new String[] { "enum_aio_type", "uint64_id", "uint32_share_appid", "bytes_song_name", "rpt_bytes_singer", "bytes_song_url", "bool_cut_song", "str_song_id", "uint32_duration", "uint64_sharer_uin", "bytes_cover" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Boolean.valueOf(false), "", Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro4 }, ReqShareTrans.class);
    }
  }
  
  public static final class ReqShareTransCheck
    extends MessageMicro<ReqShareTransCheck>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_song_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_song_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_singer = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_share_appid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "enum_aio_type", "uint64_id", "uint32_share_appid", "bytes_song_name", "rpt_bytes_singer", "bytes_song_url" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ReqShareTransCheck.class);
    }
  }
  
  public static final class ReqSongExtendedInfo
    extends MessageMicro<ReqSongExtendedInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "enum_aio_type", "uint64_id", "rpt_msg_song_list" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), null }, ReqSongExtendedInfo.class);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBRepeatMessageField<aio_media.SongExtendedReqParam> rpt_msg_song_list = PBField.initRepeatMessage(aio_media.SongExtendedReqParam.class);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqSongPlayShowInfo
    extends MessageMicro<ReqSongPlayShowInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_id" }, new Object[] { Long.valueOf(0L) }, ReqSongPlayShowInfo.class);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  }
  
  public static final class ResultInfo
    extends MessageMicro<ResultInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint32_svr_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_svr_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_result", "bytes_errmsg", "uint32_svr_time", "uint64_svr_time" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L) }, ResultInfo.class);
    }
  }
  
  public static final class RspCollect
    extends MessageMicro<RspCollect>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_result" }, new Object[] { null }, RspCollect.class);
    public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
  }
  
  public static final class RspGetDynamicInfo
    extends MessageMicro<RspGetDynamicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82, 90, 98, 106 }, new String[] { "msg_result", "msg_music_info", "msg_video_info", "msg_ksing_info", "msg_play_info" }, new Object[] { null, null, null, null, null }, RspGetDynamicInfo.class);
    public aio_media.DynamicInfo msg_ksing_info = new aio_media.DynamicInfo();
    public aio_media.DynamicInfo msg_music_info = new aio_media.DynamicInfo();
    public aio_media.DynamicInfo msg_play_info = new aio_media.DynamicInfo();
    public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
    public aio_media.DynamicInfo msg_video_info = new aio_media.DynamicInfo();
  }
  
  public static final class RspGetUserAuth
    extends MessageMicro<RspGetUserAuth>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_result", "bool_allow_member_start" }, new Object[] { null, Boolean.valueOf(true) }, RspGetUserAuth.class);
    public final PBBoolField bool_allow_member_start = PBField.initBool(true);
    public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
  }
  
  public static final class RspLatestPlayingState
    extends MessageMicro<RspLatestPlayingState>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64, 74, 80, 160, 168, 176, 184, 402, 410 }, new String[] { "msg_result", "enum_aio_state", "enum_media_type", "msg_music", "uint64_create_uin", "enum_user_state", "uint32_joined_num", "enum_c2c_join_state", "msg_personal_setting", "uint64_aio_identification", "enum_joined_aio_type", "uint64_joined_id", "bool_joined_is_creater", "enum_joined_media_type", "msg_room_info", "msg_ksing_info" }, new Object[] { null, Integer.valueOf(1), Integer.valueOf(1), null, Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), null, Long.valueOf(0L), Integer.valueOf(1), Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(1), null, null }, RspLatestPlayingState.class);
    public final PBBoolField bool_joined_is_creater = PBField.initBool(false);
    public final PBEnumField enum_aio_state = PBField.initEnum(1);
    public final PBEnumField enum_c2c_join_state = PBField.initEnum(1);
    public final PBEnumField enum_joined_aio_type = PBField.initEnum(1);
    public final PBEnumField enum_joined_media_type = PBField.initEnum(1);
    public final PBEnumField enum_media_type = PBField.initEnum(1);
    public final PBEnumField enum_user_state = PBField.initEnum(1);
    public aio_media.TypeKSing msg_ksing_info = new aio_media.TypeKSing();
    public aio_media.TypeMusic msg_music = new aio_media.TypeMusic();
    public aio_media.PersonalSetting msg_personal_setting = new aio_media.PersonalSetting();
    public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
    public aio_media.TypeVideo msg_room_info = new aio_media.TypeVideo();
    public final PBUInt32Field uint32_joined_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_aio_identification = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_joined_id = PBField.initUInt64(0L);
  }
  
  public static final class RspMediaOperation
    extends MessageMicro<RspMediaOperation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_result" }, new Object[] { null }, RspMediaOperation.class);
    public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
  }
  
  public static final class RspReportDownloadFail
    extends MessageMicro<RspReportDownloadFail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_result" }, new Object[] { null }, RspReportDownloadFail.class);
    public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
  }
  
  public static final class RspRoomOperation
    extends MessageMicro<RspRoomOperation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_result" }, new Object[] { null }, RspRoomOperation.class);
    public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
  }
  
  public static final class RspShareTrans
    extends MessageMicro<RspShareTrans>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_result" }, new Object[] { null }, RspShareTrans.class);
    public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
  }
  
  public static final class RspShareTransCheck
    extends MessageMicro<RspShareTransCheck>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 56, 64, 72, 80 }, new String[] { "msg_result", "enum_aio_state", "enum_media_type", "bool_show_icon", "str_song_id", "uint32_duration", "uint64_create_uin", "bool_song_existed", "bool_allow_member_start", "bool_allow_member_add" }, new Object[] { null, Integer.valueOf(1), Integer.valueOf(1), Boolean.valueOf(false), "", Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false) }, RspShareTransCheck.class);
    public final PBBoolField bool_allow_member_add = PBField.initBool(false);
    public final PBBoolField bool_allow_member_start = PBField.initBool(true);
    public final PBBoolField bool_show_icon = PBField.initBool(false);
    public final PBBoolField bool_song_existed = PBField.initBool(false);
    public final PBEnumField enum_aio_state = PBField.initEnum(1);
    public final PBEnumField enum_media_type = PBField.initEnum(1);
    public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
    public final PBStringField str_song_id = PBField.initString("");
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspSongExtendedInfo
    extends MessageMicro<RspSongExtendedInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_result", "rpt_msg_song_list" }, new Object[] { null, null }, RspSongExtendedInfo.class);
    public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
    public final PBRepeatMessageField<aio_media.Song> rpt_msg_song_list = PBField.initRepeatMessage(aio_media.Song.class);
  }
  
  public static final class RspSongPlayShowInfo
    extends MessageMicro<RspSongPlayShowInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "msg_result", "uint32_join_num", "rpt_uint64_join_uins" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, RspSongPlayShowInfo.class);
    public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
    public final PBRepeatField<Long> rpt_uint64_join_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_join_num = PBField.initUInt32(0);
  }
  
  public static final class Song
    extends MessageMicro<Song>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_lyric = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_song_source = PBField.initEnum(1);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_download_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_singer = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBStringField str_song_id = PBField.initString("");
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt64Field uint64_sharer_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72, 80 }, new String[] { "str_song_id", "bytes_name", "bytes_sub_title", "rpt_bytes_singer", "rpt_bytes_download_url", "bytes_lyric", "bytes_cover", "uint32_duration", "enum_song_source", "uint64_sharer_uin" }, new Object[] { "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(0L) }, Song.class);
    }
  }
  
  public static final class SongExtendedReqParam
    extends MessageMicro<SongExtendedReqParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_song_id", "bool_need_url", "bool_need_lyric" }, new Object[] { "", Boolean.valueOf(false), Boolean.valueOf(false) }, SongExtendedReqParam.class);
    public final PBBoolField bool_need_lyric = PBField.initBool(false);
    public final PBBoolField bool_need_url = PBField.initBool(false);
    public final PBStringField str_song_id = PBField.initString("");
  }
  
  public static final class TypeKSing
    extends MessageMicro<TypeKSing>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_song = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_singer = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58 }, new String[] { "uint32_type", "uint64_id", "bytes_jump", "bytes_cover", "bytes_name", "uint64_singer", "bytes_song" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4 }, TypeKSing.class);
    }
  }
  
  public static final class TypeMusic
    extends MessageMicro<TypeMusic>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48 }, new String[] { "rpt_msg_song_list", "uint32_progress_seek", "int32_progress_seek", "enum_play_mode", "bool_allow_member_start", "bool_allow_member_add" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Boolean.valueOf(true), Boolean.valueOf(false) }, TypeMusic.class);
    public final PBBoolField bool_allow_member_add = PBField.initBool(false);
    public final PBBoolField bool_allow_member_start = PBField.initBool(true);
    public final PBEnumField enum_play_mode = PBField.initEnum(1);
    public final PBInt32Field int32_progress_seek = PBField.initInt32(0);
    public final PBRepeatMessageField<aio_media.Song> rpt_msg_song_list = PBField.initRepeatMessage(aio_media.Song.class);
    public final PBUInt32Field uint32_progress_seek = PBField.initUInt32(0);
  }
  
  public static final class TypeVideo
    extends MessageMicro<TypeVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_jump_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_video_jump_type = PBField.initEnum(1);
    public final PBEnumField enum_video_type = PBField.initEnum(1);
    public final PBBytesField match_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_polling = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 56, 64, 74, 82 }, new String[] { "uint32_type", "uint64_id", "bytes_jump", "bytes_cover", "uint32_polling", "bytes_name", "enum_video_type", "enum_video_jump_type", "bytes_video_jump_value", "match_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(1), Integer.valueOf(1), localByteStringMicro4, localByteStringMicro5 }, TypeVideo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.aio.media.aio_media
 * JD-Core Version:    0.7.0.1
 */