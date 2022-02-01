package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x6d1
{
  public static final class DealInviteReqBody
    extends MessageMicro<DealInviteReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_group_code", "uint64_uin", "str_id", "uint32_deal_result" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0) }, DealInviteReqBody.class);
    public final PBStringField str_id = PBField.initString("");
    public final PBUInt32Field uint32_deal_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class DealInviteRspBody
    extends MessageMicro<DealInviteRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], DealInviteRspBody.class);
  }
  
  public static final class InviteReqBody
    extends MessageMicro<InviteReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uin_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_first_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint64_group_code", "rpt_uin_list", "uint32_first_flag", "bytes_uin_nick", "bytes_group_name" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, InviteReqBody.class);
    }
  }
  
  public static final class InviteRspBody
    extends MessageMicro<InviteRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_invited_uin_list", "rpt_uninvited_uin_list" }, new Object[] { null, null }, InviteRspBody.class);
    public final PBRepeatMessageField<cmd0x6d1.ItemInfo> rpt_invited_uin_list = PBField.initRepeatMessage(cmd0x6d1.ItemInfo.class);
    public final PBRepeatMessageField<cmd0x6d1.ItemInfo> rpt_uninvited_uin_list = PBField.initRepeatMessage(cmd0x6d1.ItemInfo.class);
  }
  
  public static final class ItemInfo
    extends MessageMicro<ItemInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "str_id" }, new Object[] { Long.valueOf(0L), "" }, ItemInfo.class);
    public final PBStringField str_id = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "invite_req_body", "uninvite_req_body", "deal_invite_req_body" }, new Object[] { null, null, null }, ReqBody.class);
    public cmd0x6d1.DealInviteReqBody deal_invite_req_body = new cmd0x6d1.DealInviteReqBody();
    public cmd0x6d1.InviteReqBody invite_req_body = new cmd0x6d1.InviteReqBody();
    public final PBUInt32Field uint32_app_type = PBField.initUInt32(0);
    public cmd0x6d1.UninviteReqBody uninvite_req_body = new cmd0x6d1.UninviteReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "invite_rsp_body", "uninvite_rsp_body", "deal_invite_rsp_body" }, new Object[] { null, null, null }, RspBody.class);
    public cmd0x6d1.DealInviteRspBody deal_invite_rsp_body = new cmd0x6d1.DealInviteRspBody();
    public cmd0x6d1.InviteRspBody invite_rsp_body = new cmd0x6d1.InviteRspBody();
    public cmd0x6d1.UniviteRspBody uninvite_rsp_body = new cmd0x6d1.UniviteRspBody();
  }
  
  public static final class UninviteReqBody
    extends MessageMicro<UninviteReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_group_code", "uint64_uin", "str_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, UninviteReqBody.class);
    public final PBStringField str_id = PBField.initString("");
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class UniviteRspBody
    extends MessageMicro<UniviteRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], UniviteRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.im.oidb.cmd0x6d1.cmd0x6d1
 * JD-Core Version:    0.7.0.1
 */