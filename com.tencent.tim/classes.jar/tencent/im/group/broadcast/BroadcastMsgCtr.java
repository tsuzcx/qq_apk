package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BroadcastMsgCtr
{
  public static final class BroadcastMsgCtrInstInfo
    extends MessageMicro<BroadcastMsgCtrInstInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_appid", "uint32_inst_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BroadcastMsgCtrInstInfo.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inst_id = PBField.initUInt32(0);
  }
  
  public static final class BroadcastMsgCtrMsgReq
    extends MessageMicro<BroadcastMsgCtrMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ex2_tlv_trans2_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_red_packet = PBField.initEnum(0);
    public BroadcastMsgCtr.Ex2tlvGroupInfo group_info_tlv = new BroadcastMsgCtr.Ex2tlvGroupInfo();
    public BroadcastMsgCtr.BroadcastMsgCtrInstInfo msg_from_inst_info = new BroadcastMsgCtr.BroadcastMsgCtrInstInfo();
    public final PBRepeatMessageField<BroadcastMsgCtr.BroadcastMsgCtrInstInfo> msg_roaming_dst_insts = PBField.initRepeatMessage(BroadcastMsgCtr.BroadcastMsgCtrInstInfo.class);
    public final PBRepeatMessageField<BroadcastMsgCtr.BroadcastMsgCtrMsgUnit> rpt_msg_broadcast_msg_unit = PBField.initRepeatMessage(BroadcastMsgCtr.BroadcastMsgCtrMsgUnit.class);
    public final PBUInt32Field uint32_feeds_topic_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_ex = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_ex2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_ex3 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_ex4 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_id_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_total_pkg = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mem_level_name_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_message_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_sys_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_spec_focus_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_spec_hated_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
    public final PBBoolField whether_anonymous_message = PBField.initBool(false);
    public final PBBoolField whether_store_message = PBField.initBool(false);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64, 72, 80, 88, 96, 104, 112, 122, 138, 144, 152, 160, 168, 176, 184, 192, 202, 208, 216, 224 }, new String[] { "uint64_from_uin", "rpt_msg_broadcast_msg_unit", "bytes_msg", "uint32_msg_type", "uint32_msg_seq", "msg_from_inst_info", "uint64_group_code", "uint64_group_uin", "uint32_spec_focus_flag", "uint32_msg_time", "whether_store_message", "uint32_msg_sys_seq", "whether_anonymous_message", "uint32_id_info", "group_info_tlv", "msg_roaming_dst_insts", "uint32_spec_hated_flag", "enum_red_packet", "uint32_feeds_topic_flag", "uint32_flag_ex2", "uint32_mem_level_name_seq", "uint32_flag_ex", "uint32_message_type", "bytes_ex2_tlv_trans2_buf", "uint32_flag_ex3", "uint32_flag_ex4", "uint32_is_total_pkg" }, new Object[] { Long.valueOf(0L), null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, BroadcastMsgCtrMsgReq.class);
    }
  }
  
  public static final class BroadcastMsgCtrMsgRsp
    extends MessageMicro<BroadcastMsgCtrMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_group_uin", "uint64_from_uin", "uint32_msg_seq", "uint32_msg_type", "uint32_succ_count", "uint32_fail_count" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, BroadcastMsgCtrMsgRsp.class);
    public final PBUInt32Field uint32_fail_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_succ_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  }
  
  public static final class BroadcastMsgCtrMsgUnit
    extends MessageMicro<BroadcastMsgCtrMsgUnit>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bsavemsgdb = PBField.initBool(false);
    public final PBBytesField bytes_tlv = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_group_member_flag_ex2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_intelligent_terminal_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_ctr_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_mask = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_msg_mask = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_bits = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_msg_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88 }, new String[] { "uint64_uin", "bytes_tlv", "uint32_msg_ctr_cmd", "uint32_msg_mask", "uint32_intelligent_terminal_flag", "uint32_online_bits", "uint32_mobile_flag", "uint32_new_msg_mask", "bsavemsgdb", "uint32_group_member_flag_ex2", "uint32_read_msg_seq" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, BroadcastMsgCtrMsgUnit.class);
    }
  }
  
  public static final class BroadcastSystemMsgReq
    extends MessageMicro<BroadcastSystemMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public BroadcastMsgCtr.Ex2tlvGroupInfo group_info_tlv = new BroadcastMsgCtr.Ex2tlvGroupInfo();
    public BroadcastMsgCtr.BroadcastMsgCtrInstInfo msg_from_inst_info = new BroadcastMsgCtr.BroadcastMsgCtrInstInfo();
    public final PBRepeatMessageField<BroadcastMsgCtr.BroadcastMsgCtrInstInfo> msg_roaming_dst_insts = PBField.initRepeatMessage(BroadcastMsgCtr.BroadcastMsgCtrInstInfo.class);
    public final PBRepeatMessageField<BroadcastMsgCtr.BroadcastMsgCtrMsgUnit> rpt_msg_broadcast_msg_unit = PBField.initRepeatMessage(BroadcastMsgCtr.BroadcastMsgCtrMsgUnit.class);
    public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_sys_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64, 72, 88, 98, 138 }, new String[] { "uint64_from_uin", "rpt_msg_broadcast_msg_unit", "bytes_msg", "uint32_msg_type", "uint32_msg_seq", "msg_from_inst_info", "uint64_group_code", "uint64_group_uin", "uint32_msg_time", "uint32_msg_sys_seq", "group_info_tlv", "msg_roaming_dst_insts" }, new Object[] { Long.valueOf(0L), null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null }, BroadcastSystemMsgReq.class);
    }
  }
  
  public static final class ConfInfo
    extends MessageMicro<ConfInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_conf_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48 }, new String[] { "bytes_conf_name", "uint32_member_flag", "uint32_type", "bytes_sig", "uint32_appid", "uint32_conf_flag" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, ConfInfo.class);
    }
  }
  
  public static final class Ex2tlvGroupInfo
    extends MessageMicro<Ex2tlvGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tribe_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public BroadcastMsgCtr.ConfInfo conf_info = new BroadcastMsgCtr.ConfInfo();
    public BroadcastMsgCtr.ExtGroupKeyInfo ext_group_key_info = new BroadcastMsgCtr.ExtGroupKeyInfo();
    public final PBUInt32Field uint32_disable_fetch_remark = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 1018 }, new String[] { "bytes_group_name", "uint32_disable_fetch_remark", "bytes_tribe_info", "ext_group_key_info", "conf_info" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, null, null }, Ex2tlvGroupInfo.class);
    }
  }
  
  public static final class ExtGroupInfo
    extends MessageMicro<ExtGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ext_join_group_info" }, new Object[] { null }, ExtGroupInfo.class);
    public BroadcastMsgCtr.ExtJoinGroupInfo ext_join_group_info = new BroadcastMsgCtr.ExtJoinGroupInfo();
  }
  
  public static final class ExtGroupKeyInfo
    extends MessageMicro<ExtGroupKeyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_group_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cur_max_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_operate_by_parents = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cur_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_cur_max_seq", "uint64_cur_time", "uint32_operate_by_parents", "bytes_ext_group_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, ExtGroupKeyInfo.class);
    }
  }
  
  public static final class ExtJoinGroupInfo
    extends MessageMicro<ExtJoinGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "enmum_join_group_type", "uint64_share_uin" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L) }, ExtJoinGroupInfo.class);
    public final PBEnumField enmum_join_group_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_share_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.group.broadcast.BroadcastMsgCtr
 * JD-Core Version:    0.7.0.1
 */