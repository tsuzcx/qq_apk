package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ExtSnsFrdData;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ReqBody;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.MutualMarkData;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.ReqBody;
import tencent.intimate_relation.intimate_relation.IntimateInfo;

public final class Oidb_0x5e0
{
  public static final class ContentItem
    extends MessageMicro<ContentItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106 }, new String[] { "uint32_update_profile_id", "msg_nicknamefiled", "msg_genderfiled", "msg_friendremark", "msg_longnick", "msg_groupname", "msg_friend_teamlist", "msg_value_bit", "msg_general_buffer", "msg_profile_info", "msg_intimate_info", "msg_ext_sns_frd_data", "msg_mutual_mark_data" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null }, ContentItem.class);
    public Oidb_0xd50.ExtSnsFrdData msg_ext_sns_frd_data = new Oidb_0xd50.ExtSnsFrdData();
    public Oidb_0x5e0.FriendTeamList msg_friend_teamlist = new Oidb_0x5e0.FriendTeamList();
    public Oidb_0x5e0.FriendRemark msg_friendremark = new Oidb_0x5e0.FriendRemark();
    public Oidb_0x5e0.GenderFiled msg_genderfiled = new Oidb_0x5e0.GenderFiled();
    public Oidb_0x5e0.GeneralBuffer msg_general_buffer = new Oidb_0x5e0.GeneralBuffer();
    public Oidb_0x5e0.GroupName msg_groupname = new Oidb_0x5e0.GroupName();
    public intimate_relation.IntimateInfo msg_intimate_info = new intimate_relation.IntimateInfo();
    public Oidb_0x5e0.LongNick msg_longnick = new Oidb_0x5e0.LongNick();
    public Oidb_0xd6b.MutualMarkData msg_mutual_mark_data = new Oidb_0xd6b.MutualMarkData();
    public Oidb_0x5e0.NickNameFiled msg_nicknamefiled = new Oidb_0x5e0.NickNameFiled();
    public Oidb_0x5e0.ProfileInfo msg_profile_info = new Oidb_0x5e0.ProfileInfo();
    public Oidb_0x5e0.ValueBit msg_value_bit = new Oidb_0x5e0.ValueBit();
    public final PBUInt32Field uint32_update_profile_id = PBField.initUInt32(0);
  }
  
  public static final class FriendRemark
    extends MessageMicro<FriendRemark>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "bytes_value" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, FriendRemark.class);
    }
  }
  
  public static final class FriendTeamList
    extends MessageMicro<FriendTeamList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16 }, new String[] { "uint32_update_flag" }, new Object[] { Integer.valueOf(0) }, FriendTeamList.class);
    public final PBUInt32Field uint32_update_flag = PBField.initUInt32(0);
  }
  
  public static final class GenderFiled
    extends MessageMicro<GenderFiled>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint32_gender" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GenderFiled.class);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GeneralBuffer
    extends MessageMicro<GeneralBuffer>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_value", "uint64_uin" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, GeneralBuffer.class);
    }
  }
  
  public static final class GroupName
    extends MessageMicro<GroupName>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_group_uin", "bytes_value" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, GroupName.class);
    }
  }
  
  public static final class LongNick
    extends MessageMicro<LongNick>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "bytes_value" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, LongNick.class);
    }
  }
  
  public static final class NickNameFiled
    extends MessageMicro<NickNameFiled>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "bytes_value" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, NickNameFiled.class);
    }
  }
  
  public static final class ProfileInfo
    extends MessageMicro<ProfileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "rpt_msg_profile_info" }, new Object[] { Long.valueOf(0L), null }, ProfileInfo.class);
    public final PBRepeatMessageField<Oidb_0x5e0.ProfileTvInfo> rpt_msg_profile_info = PBField.initRepeatMessage(Oidb_0x5e0.ProfileTvInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ProfileListResult
    extends MessageMicro<ProfileListResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_result", "uint32_update_profile_id", "uint32_new_content_timestamp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ProfileListResult.class);
    public final PBUInt32Field uint32_new_content_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_profile_id = PBField.initUInt32(0);
  }
  
  public static final class ProfileTvInfo
    extends MessageMicro<ProfileTvInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_field_str_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_field_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_field_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_field_int_value = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_field_id", "uint32_field_type", "uint64_field_int_value", "bytes_field_str_value" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, ProfileTvInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_svrcontext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Oidb_0x5e0.UpdateProfileList> rpt_msg_update_profile_list = PBField.initRepeatMessage(Oidb_0x5e0.UpdateProfileList.class);
    public final PBRepeatField<Long> rpt_uint64_uinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_forced_update = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "rpt_msg_update_profile_list", "bytes_svrcontext", "rpt_uint64_uinlist", "uint32_forced_update" }, new Object[] { null, localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_svrcontext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Oidb_0x5e0.ProfileListResult> rpt_msg_ProfileListResult = PBField.initRepeatMessage(Oidb_0x5e0.ProfileListResult.class);
    public final PBRepeatMessageField<Oidb_0x5e0.ContentItem> rpt_msg_contentItem = PBField.initRepeatMessage(Oidb_0x5e0.ContentItem.class);
    public final PBUInt32Field uint32_over_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "rpt_msg_contentItem", "uint32_over_flag", "rpt_msg_ProfileListResult", "bytes_svrcontext" }, new Object[] { null, Integer.valueOf(0), null, localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class UpdateProfileList
    extends MessageMicro<UpdateProfileList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 80, 90, 98 }, new String[] { "uint32_update_profile_id", "uint32_get_content_timestamp", "uint32_friendlist_type", "uint32_need_content", "rpt_uint32_profile_field_list", "msg_0xd50_req", "msg_0xd6b_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, UpdateProfileList.class);
    public Oidb_0xd50.ReqBody msg_0xd50_req = new Oidb_0xd50.ReqBody();
    public Oidb_0xd6b.ReqBody msg_0xd6b_req = new Oidb_0xd6b.ReqBody();
    public final PBRepeatField<Integer> rpt_uint32_profile_field_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_friendlist_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_get_content_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_content = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_profile_id = PBField.initUInt32(0);
  }
  
  public static final class ValueBit
    extends MessageMicro<ValueBit>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_flag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_identity_flag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_service_flag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_uin", "bytes_identity_flag", "bytes_ext_flag", "bytes_service_flag" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ValueBit.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e0.Oidb_0x5e0
 * JD-Core Version:    0.7.0.1
 */