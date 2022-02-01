package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipMusicBox
{
  public static final class GetProfileMusicBoxInfoReq
    extends MessageMicro<GetProfileMusicBoxInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin" }, new Object[] { Long.valueOf(0L) }, GetProfileMusicBoxInfoReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class GetProfileMusicBoxInfoRsp
    extends MessageMicro<GetProfileMusicBoxInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "music", "is_visible" }, new Object[] { null, Boolean.valueOf(false) }, GetProfileMusicBoxInfoRsp.class);
    public final PBBoolField is_visible = PBField.initBool(false);
    public VipMusicBox.ProfileMusicInfo music = new VipMusicBox.ProfileMusicInfo();
  }
  
  public static final class ProfileMusicInfo
    extends MessageMicro<ProfileMusicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "song_id", "song_name", "album_name", "singer_list", "pic", "duration" }, new Object[] { "", "", "", null, "", Integer.valueOf(0) }, ProfileMusicInfo.class);
    public final PBStringField album_name = PBField.initString("");
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBStringField pic = PBField.initString("");
    public final PBRepeatMessageField<VipMusicBox.ProfileSingerInfo> singer_list = PBField.initRepeatMessage(VipMusicBox.ProfileSingerInfo.class);
    public final PBStringField song_id = PBField.initString("");
    public final PBStringField song_name = PBField.initString("");
  }
  
  public static final class ProfileSingerInfo
    extends MessageMicro<ProfileSingerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "singer_name" }, new Object[] { "" }, ProfileSingerInfo.class);
    public final PBStringField singer_name = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.VipMusicBox
 * JD-Core Version:    0.7.0.1
 */