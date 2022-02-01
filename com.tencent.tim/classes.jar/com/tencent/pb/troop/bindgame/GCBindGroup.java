package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GCBindGroup
{
  public static final class GCBindGroupSsoServerReq
    extends MessageMicro<GCBindGroupSsoServerReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "cmd", "bind_req", "dynamic_req", "member_req" }, new Object[] { "", null, null, null }, GCBindGroupSsoServerReq.class);
    public GCBindGroup.QQGroupBind bind_req = new GCBindGroup.QQGroupBind();
    public final PBStringField cmd = PBField.initString("");
    public GCBindGroup.QQGroupCardDynamic dynamic_req = new GCBindGroup.QQGroupCardDynamic();
    public GCBindGroup.QQGroupCardMember member_req = new GCBindGroup.QQGroupCardMember();
  }
  
  public static final class GCBindGroupSsoServerRsp
    extends MessageMicro<GCBindGroupSsoServerRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "ret", "msg", "bind_info", "card_info", "memeber_info" }, new Object[] { Integer.valueOf(0), "", null, null, null }, GCBindGroupSsoServerRsp.class);
    public GCBindGroup.QQBindInfo bind_info = new GCBindGroup.QQBindInfo();
    public GCBindGroup.QQCardDynamicInfo card_info = new GCBindGroup.QQCardDynamicInfo();
    public GCBindGroup.QQCardMemberInfo memeber_info = new GCBindGroup.QQCardMemberInfo();
    public final PBStringField msg = PBField.initString("");
    public final PBInt32Field ret = PBField.initInt32(0);
  }
  
  public static final class QQBindInfo
    extends MessageMicro<QQBindInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "appid", "group_code", "app_name" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, QQBindInfo.class);
    public final PBStringField app_name = PBField.initString("");
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
  }
  
  public static final class QQCardDynamicInfo
    extends MessageMicro<QQCardDynamicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "dynamic_info", "dynamic_cnt", "newest_time" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L) }, QQCardDynamicInfo.class);
    public final PBInt32Field dynamic_cnt = PBField.initInt32(0);
    public final PBStringField dynamic_info = PBField.initString("");
    public final PBUInt64Field newest_time = PBField.initUInt64(0L);
  }
  
  public static final class QQCardMemberInfo
    extends MessageMicro<QQCardMemberInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "game_name", "level_name", "level_icon", "game_font_color", "game_background_color", "game_url", "desc_info" }, new Object[] { "", "", "", "", "", "", "" }, QQCardMemberInfo.class);
    public final PBRepeatField<String> desc_info = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField game_background_color = PBField.initString("");
    public final PBStringField game_font_color = PBField.initString("");
    public final PBStringField game_name = PBField.initString("");
    public final PBStringField game_url = PBField.initString("");
    public final PBStringField level_icon = PBField.initString("");
    public final PBStringField level_name = PBField.initString("");
  }
  
  public static final class QQCardRankInfo
    extends MessageMicro<QQCardRankInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "summary", "rank" }, new Object[] { "", Integer.valueOf(0) }, QQCardRankInfo.class);
    public final PBInt32Field rank = PBField.initInt32(0);
    public final PBStringField summary = PBField.initString("");
  }
  
  public static final class QQGroupBind
    extends MessageMicro<QQGroupBind>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "group_code", "appid", "group_name", "group_pic" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "" }, QQGroupBind.class);
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBStringField group_name = PBField.initString("");
    public final PBStringField group_pic = PBField.initString("");
  }
  
  public static final class QQGroupCardDynamic
    extends MessageMicro<QQGroupCardDynamic>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_code", "last_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, QQGroupCardDynamic.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt64Field last_time = PBField.initUInt64(0L);
  }
  
  public static final class QQGroupCardMember
    extends MessageMicro<QQGroupCardMember>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_code", "uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, QQGroupCardMember.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.troop.bindgame.GCBindGroup
 * JD-Core Version:    0.7.0.1
 */