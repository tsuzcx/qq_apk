package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class STGameLogin
{
  public static final class STGameConfInfo
    extends MessageMicro<STGameConfInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 72, 80, 90, 98, 104, 112, 120, 128 }, new String[] { "game_id", "action_id", "appid", "ep_name", "g_start_ver", "g_end_ver", "game_name", "has_own_ark", "isfeatured", "is_show_onpanel", "list_cover_url", "logo_url", "need_open_key", "puin", "screen_mode", "view_mode" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, STGameConfInfo.class);
    public final PBUInt32Field action_id = PBField.initUInt32(0);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public final PBStringField ep_name = PBField.initString("");
    public final PBStringField g_end_ver = PBField.initString("");
    public final PBStringField g_start_ver = PBField.initString("");
    public final PBUInt32Field game_id = PBField.initUInt32(0);
    public final PBStringField game_name = PBField.initString("");
    public final PBInt32Field has_own_ark = PBField.initInt32(0);
    public final PBInt32Field is_show_onpanel = PBField.initInt32(0);
    public final PBInt32Field isfeatured = PBField.initInt32(0);
    public final PBStringField list_cover_url = PBField.initString("");
    public final PBStringField logo_url = PBField.initString("");
    public final PBInt32Field need_open_key = PBField.initInt32(0);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBInt32Field screen_mode = PBField.initInt32(0);
    public final PBInt32Field view_mode = PBField.initInt32(0);
  }
  
  public static final class STGameList
    extends MessageMicro<STGameList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "game_id", "tab" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, STGameList.class);
    public final PBUInt32Field game_id = PBField.initUInt32(0);
    public final PBInt32Field tab = PBField.initInt32(0);
  }
  
  public static final class STGameLoginReq
    extends MessageMicro<STGameLoginReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "local_ts", "from" }, new Object[] { Integer.valueOf(0), "" }, STGameLoginReq.class);
    public final PBStringField from = PBField.initString("");
    public final PBUInt32Field local_ts = PBField.initUInt32(0);
  }
  
  public static final class STGameLoginRsp
    extends MessageMicro<STGameLoginRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "game_list", "game_conf_info", "game_tag_info", "svr_ts" }, new Object[] { null, null, null, Integer.valueOf(0) }, STGameLoginRsp.class);
    public final PBRepeatMessageField<STGameLogin.STGameConfInfo> game_conf_info = PBField.initRepeatMessage(STGameLogin.STGameConfInfo.class);
    public final PBRepeatMessageField<STGameLogin.STGameList> game_list = PBField.initRepeatMessage(STGameLogin.STGameList.class);
    public final PBRepeatMessageField<STGameLogin.STGameTagInfo> game_tag_info = PBField.initRepeatMessage(STGameLogin.STGameTagInfo.class);
    public final PBUInt32Field svr_ts = PBField.initUInt32(0);
  }
  
  public static final class STGameTagInfo
    extends MessageMicro<STGameTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "game_id", "tag_type", "tag_url", "tag_beg_ts", "tag_end_ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, STGameTagInfo.class);
    public final PBUInt32Field game_id = PBField.initUInt32(0);
    public final PBUInt32Field tag_beg_ts = PBField.initUInt32(0);
    public final PBUInt32Field tag_end_ts = PBField.initUInt32(0);
    public final PBInt32Field tag_type = PBField.initInt32(0);
    public final PBStringField tag_url = PBField.initString("");
  }
  
  public static final class STGetGameConfReq
    extends MessageMicro<STGetGameConfReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "game_id_list", "from" }, new Object[] { Integer.valueOf(0), "" }, STGetGameConfReq.class);
    public final PBStringField from = PBField.initString("");
    public final PBRepeatField<Integer> game_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class STGetGameConfRsp
    extends MessageMicro<STGetGameConfRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "game_conf_info" }, new Object[] { null }, STGetGameConfRsp.class);
    public final PBRepeatMessageField<STGameLogin.STGameConfInfo> game_conf_info = PBField.initRepeatMessage(STGameLogin.STGameConfInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameLogin
 * JD-Core Version:    0.7.0.1
 */