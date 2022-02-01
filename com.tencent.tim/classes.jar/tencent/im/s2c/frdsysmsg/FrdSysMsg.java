package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FrdSysMsg
{
  public static final class AddFrdSNInfo
    extends MessageMicro<AddFrdSNInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_not_see_dynamic", "uint32_set_sn" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AddFrdSNInfo.class);
    public final PBUInt32Field uint32_not_see_dynamic = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_sn = PBField.initUInt32(0);
  }
  
  public static final class AddFriendVerifyInfo
    extends MessageMicro<AddFriendVerifyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_type", "str_url", "str_verify_info" }, new Object[] { Integer.valueOf(0), "", "" }, AddFriendVerifyInfo.class);
    public final PBStringField str_url = PBField.initString("");
    public final PBStringField str_verify_info = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class DiscussInfo
    extends MessageMicro<DiscussInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_discuss_uin", "str_discuss_name", "str_discuss_nick" }, new Object[] { Long.valueOf(0L), "", "" }, DiscussInfo.class);
    public final PBStringField str_discuss_name = PBField.initString("");
    public final PBStringField str_discuss_nick = PBField.initString("");
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
  }
  
  public static final class EimInfo
    extends MessageMicro<EimInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_eim_fuin", "str_eim_id", "str_eim_telno", "uint64_group_id" }, new Object[] { Long.valueOf(0L), "", "", Long.valueOf(0L) }, EimInfo.class);
    public final PBStringField str_eim_id = PBField.initString("");
    public final PBStringField str_eim_telno = PBField.initString("");
    public final PBUInt64Field uint64_eim_fuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  }
  
  public static final class FriendHelloInfo
    extends MessageMicro<FriendHelloInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_source_name" }, new Object[] { "" }, FriendHelloInfo.class);
    public final PBStringField str_source_name = PBField.initString("");
  }
  
  public static final class FriendMiscInfo
    extends MessageMicro<FriendMiscInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_fromuin_nick" }, new Object[] { "" }, FriendMiscInfo.class);
    public final PBStringField str_fromuin_nick = PBField.initString("");
  }
  
  public static final class FriendSysMsg
    extends MessageMicro<FriendSysMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106, 800 }, new String[] { "msg_group_ext", "msg_intite_info", "msg_school_info", "uint32_doubt_flag" }, new Object[] { null, null, null, Integer.valueOf(0) }, FriendSysMsg.class);
    public FrdSysMsg.GroupInfoExt msg_group_ext = new FrdSysMsg.GroupInfoExt();
    public FrdSysMsg.InviteInfo msg_intite_info = new FrdSysMsg.InviteInfo();
    public FrdSysMsg.SchoolInfo msg_school_info = new FrdSysMsg.SchoolInfo();
    public final PBUInt32Field uint32_doubt_flag = PBField.initUInt32(0);
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_group_uin", "str_group_name", "str_group_nick" }, new Object[] { Long.valueOf(0L), "", "" }, GroupInfo.class);
    public final PBStringField str_group_name = PBField.initString("");
    public final PBStringField str_group_nick = PBField.initString("");
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  }
  
  public static final class GroupInfoExt
    extends MessageMicro<GroupInfoExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_notify_type", "uint64_group_code", "uint32_from_groupadmlist" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GroupInfoExt.class);
    public final PBUInt32Field uint32_from_groupadmlist = PBField.initUInt32(0);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class InviteInfo
    extends MessageMicro<InviteInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_recommend_uin" }, new Object[] { Long.valueOf(0L) }, InviteInfo.class);
    public final PBUInt64Field uint64_recommend_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgEncodeFlag
    extends MessageMicro<MsgEncodeFlag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_is_utf8" }, new Object[] { Integer.valueOf(0) }, MsgEncodeFlag.class);
    public final PBUInt32Field uint32_is_utf8 = PBField.initUInt32(0);
  }
  
  public static final class SchoolInfo
    extends MessageMicro<SchoolInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_school_id", "str_school_name" }, new Object[] { "", "" }, SchoolInfo.class);
    public final PBStringField str_school_id = PBField.initString("");
    public final PBStringField str_school_name = PBField.initString("");
  }
  
  public static final class TongXunLuNickInfo
    extends MessageMicro<TongXunLuNickInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_fromuin", "uint64_touin", "str_tongxunlu_nickname" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, TongXunLuNickInfo.class);
    public final PBStringField str_tongxunlu_nickname = PBField.initString("");
    public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.frdsysmsg.FrdSysMsg
 * JD-Core Version:    0.7.0.1
 */