package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReqGroupVideo
{
  public static final class MemberInfo
    extends MessageMicro<MemberInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_member_uin", "uint32_invite_timestamp" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, MemberInfo.class);
    public final PBUInt32Field uint32_invite_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqCreateShareUrl
    extends MessageMicro<ReqCreateShareUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field role = PBField.initUInt32(0);
    public final PBBytesField share_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_need_verify = PBField.initUInt32(0);
    public final PBUInt32Field uint32_room_create_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64 }, new String[] { "uint64_uin", "uint64_group_code", "uint64_room_id", "uint32_room_create_time", "group_name", "share_name", "role", "uint32_is_need_verify" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, ReqCreateShareUrl.class);
    }
  }
  
  public static final class ReqGetInvitedMemberList
    extends MessageMicro<ReqGetInvitedMemberList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_group", "uint64_room_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqGetInvitedMemberList.class);
    public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqGroupVideoTerminate
    extends MessageMicro<ReqGroupVideoTerminate>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_operator", "uint64_group", "uint64_room_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ReqGroupVideoTerminate.class);
    public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_operator = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqShareBackflowVerify
    extends MessageMicro<ReqShareBackflowVerify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_crypt_room_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "bytes_crypt_room_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ReqShareBackflowVerify.class);
    }
  }
  
  public static final class RspCreateShareUrl
    extends MessageMicro<RspCreateShareUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public common.ErrorInfo result = new common.ErrorInfo();
    public final PBBytesField share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField share_url_with_no_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "result", "share_url", "share_url_with_no_sig" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2 }, RspCreateShareUrl.class);
    }
  }
  
  public static final class RspGetInvitedMemberList
    extends MessageMicro<RspGetInvitedMemberList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "result", "uint64_group", "uint64_room_id", "rpt_member_list" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), null }, RspGetInvitedMemberList.class);
    public common.ErrorInfo result = new common.ErrorInfo();
    public final PBRepeatMessageField<ReqGroupVideo.MemberInfo> rpt_member_list = PBField.initRepeatMessage(ReqGroupVideo.MemberInfo.class);
    public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
  }
  
  public static final class RspGroupVideoTerminate
    extends MessageMicro<RspGroupVideoTerminate>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspGroupVideoTerminate.class);
    public common.ErrorInfo result = new common.ErrorInfo();
  }
  
  public static final class RspShareBackflowVerify
    extends MessageMicro<RspShareBackflowVerify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_verify_status = PBField.initEnum(0);
    public common.ErrorInfo result = new common.ErrorInfo();
    public final PBUInt32Field uint32_room_create_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50 }, new String[] { "result", "uint64_group_code", "uint64_room_id", "uint32_room_create_time", "enum_verify_status", "bytes_wording" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RspShareBackflowVerify.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo
 * JD-Core Version:    0.7.0.1
 */