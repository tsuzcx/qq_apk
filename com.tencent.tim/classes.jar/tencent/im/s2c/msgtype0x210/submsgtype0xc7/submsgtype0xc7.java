package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc7
{
  public static final class ForwardBody
    extends MessageMicro<ForwardBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24002, 32002 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_hot_friend_notify", "msg_relational_chain_change" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, ForwardBody.class);
    public submsgtype0xc7.HotFriendNotify msg_hot_friend_notify = new submsgtype0xc7.HotFriendNotify();
    public submsgtype0xc7.RelationalChainChange msg_relational_chain_change = new submsgtype0xc7.RelationalChainChange();
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  }
  
  public static final class FriendShipFlagNotify
    extends MessageMicro<FriendShipFlagNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "uint64_dst_uin", "uint32_level_1", "uint32_level_2", "uint32_continuity_days", "uint32_chat_flag", "uint64_last_chat_time", "uint64_notify_time", "uint32_seq" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, FriendShipFlagNotify.class);
    public final PBUInt32Field uint32_chat_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_continuity_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level_1 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level_2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_chat_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_notify_time = PBField.initUInt64(0L);
  }
  
  public static final class HotFriendNotify
    extends MessageMicro<HotFriendNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_boat_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_key_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wildcard_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field loverKeyBusinessType = PBField.initUInt32(0);
    public final PBBytesField loverKeyLinkWording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField loverKeyMainWording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field loverKeySubBusinessType = PBField.initUInt32(0);
    public submsgtype0xc7.FriendShipFlagNotify msg_friendship_flag_notify = new submsgtype0xc7.FriendShipFlagNotify();
    public final PBUInt32Field uint32_boat_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_boat_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_boat_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_hot_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_hot_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_close_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_close_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_key_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_key_hot_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_key_hot_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_key_trans_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_boat_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lover_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_hot_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_hot_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzone_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzone_hot_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzone_hot_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_recheck_entry = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_chat_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_key_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_praise_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_qzone_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_notify_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 408, 418, 800, 1600, 1608, 1616, 1624, 1634, 1640, 1648, 1656, 1666, 1674, 2400, 2408, 2416, 2424, 2434, 3200, 3210 }, new String[] { "uint64_dst_uin", "uint32_praise_hot_level", "uint32_chat_hot_level", "uint32_praise_hot_days", "uint32_chat_hot_days", "uint32_close_level", "uint32_close_days", "uint32_praise_flag", "uint32_chat_flag", "uint32_close_flag", "uint64_notify_time", "uint64_last_praise_time", "uint64_last_chat_time", "uint32_qzone_hot_level", "uint32_qzone_hot_days", "uint32_qzone_flag", "uint64_last_qzone_time", "uint32_show_recheck_entry", "bytes_wildcard_wording", "uint32_lover_flag", "uint32_key_hot_level", "uint32_key_hot_days", "uint32_key_flag", "uint64_last_key_time", "bytes_key_wording", "uint32_key_trans_flag", "loverKeyBusinessType", "loverKeySubBusinessType", "loverKeyMainWording", "loverKeyLinkWording", "uint32_boat_level", "uint32_boat_days", "uint32_boat_flag", "uint32_last_boat_time", "bytes_boat_wording", "uint32_notify_type", "msg_friendship_flag_notify" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), null }, HotFriendNotify.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_mod_infos" }, new Object[] { null }, MsgBody.class);
    public final PBRepeatMessageField<submsgtype0xc7.ForwardBody> rpt_msg_mod_infos = PBField.initRepeatMessage(submsgtype0xc7.ForwardBody.class);
  }
  
  public static final class RelationalChainChange
    extends MessageMicro<RelationalChainChange>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 162, 800 }, new String[] { "uint64_appid", "uint64_src_uin", "uint64_dst_uin", "uint32_change_type", "msg_relational_chain_info_old", "msg_relational_chain_info_new", "msg_to_degrade_info", "rpt_relational_chain_infos", "rpt_uint32_feature_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), null, null, null, null, Integer.valueOf(0) }, RelationalChainChange.class);
    public submsgtype0xc7.RelationalChainInfo msg_relational_chain_info_new = new submsgtype0xc7.RelationalChainInfo();
    public submsgtype0xc7.RelationalChainInfo msg_relational_chain_info_old = new submsgtype0xc7.RelationalChainInfo();
    public submsgtype0xc7.ToDegradeInfo msg_to_degrade_info = new submsgtype0xc7.ToDegradeInfo();
    public final PBRepeatMessageField<submsgtype0xc7.RelationalChainInfos> rpt_relational_chain_infos = PBField.initRepeatMessage(submsgtype0xc7.RelationalChainInfos.class);
    public final PBRepeatField<Integer> rpt_uint32_feature_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBEnumField uint32_change_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  }
  
  public static final class RelationalChainInfo
    extends MessageMicro<RelationalChainInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_intimate_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_music_switch = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mutualmark_alienation = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField uint64_type = PBField.initEnum(1);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 8018, 728010, 808010 }, new String[] { "uint64_type", "bytes_attr", "bytes_intimate_info", "bytes_music_switch", "bytes_mutualmark_alienation" }, new Object[] { Integer.valueOf(1), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RelationalChainInfo.class);
    }
  }
  
  public static final class RelationalChainInfos
    extends MessageMicro<RelationalChainInfos>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_relational_chain_info_old", "msg_relational_chain_info_new" }, new Object[] { null, null }, RelationalChainInfos.class);
    public submsgtype0xc7.RelationalChainInfo msg_relational_chain_info_new = new submsgtype0xc7.RelationalChainInfo();
    public submsgtype0xc7.RelationalChainInfo msg_relational_chain_info_old = new submsgtype0xc7.RelationalChainInfo();
  }
  
  public static final class ToDegradeInfo
    extends MessageMicro<ToDegradeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field notify_time = PBField.initUInt64(0L);
    public final PBRepeatMessageField<submsgtype0xc7.ToDegradeItem> rpt_to_degrade_item = PBField.initRepeatMessage(submsgtype0xc7.ToDegradeItem.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_to_degrade_item", "bytes_nick", "notify_time" }, new Object[] { null, localByteStringMicro, Long.valueOf(0L) }, ToDegradeInfo.class);
    }
  }
  
  public static final class ToDegradeItem
    extends MessageMicro<ToDegradeItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 88, 96 }, new String[] { "type", "old_level", "new_level", "continuity_days", "uint64_last_action_time" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ToDegradeItem.class);
    public final PBUInt32Field continuity_days = PBField.initUInt32(0);
    public final PBUInt32Field new_level = PBField.initUInt32(0);
    public final PBUInt32Field old_level = PBField.initUInt32(0);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt64Field uint64_last_action_time = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7
 * JD-Core Version:    0.7.0.1
 */