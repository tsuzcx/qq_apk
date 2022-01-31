package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class offlinepush
{
  public static final class C2CMsgReadedNotify
    extends MessageMicro
  {
    public static final int LLASTREADTIME_FIELD_NUMBER = 2;
    public static final int LPEERUIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "lPeerUin", "lLastReadTime" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, C2CMsgReadedNotify.class);
    public final PBUInt64Field lLastReadTime = PBField.initUInt64(0L);
    public final PBUInt64Field lPeerUin = PBField.initUInt64(0L);
  }
  
  public static final class C2CTmpOffMsgHead
    extends MessageMicro
  {
    public static final int C2C_TYPE_FIELD_NUMBER = 1;
    public static final int DISCUSS_REMARK_FIELD_NUMBER = 12;
    public static final int DIS_NAME_FIELD_NUMBER = 13;
    public static final int FROM_PHONE_FIELD_NUMBER = 7;
    public static final int GROUP_CARD_FIELD_NUMBER = 10;
    public static final int GROUP_CODE_FIELD_NUMBER = 4;
    public static final int GROUP_NAME_FIELD_NUMBER = 11;
    public static final int GROUP_UIN_FIELD_NUMBER = 3;
    public static final int LOCK_DISPLAY_FIELD_NUMBER = 9;
    public static final int SERVICE_TYPE_FIELD_NUMBER = 2;
    public static final int SIG_FIELD_NUMBER = 5;
    public static final int SIG_TYPE_FIELD_NUMBER = 6;
    public static final int TO_PHONE_FIELD_NUMBER = 8;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBBytesField dis_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField discuss_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField from_phone = PBField.initString("");
    public final PBBytesField group_card = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_uin = PBField.initUInt64(0L);
    public final PBUInt32Field lock_display = PBField.initUInt32(0);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field sig_type = PBField.initUInt32(0);
    public final PBStringField to_phone = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 72, 82, 90, 98, 106 }, new String[] { "c2c_type", "service_type", "group_uin", "group_code", "sig", "sig_type", "from_phone", "to_phone", "lock_display", "group_card", "group_name", "discuss_remark", "dis_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), "", "", Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, C2CTmpOffMsgHead.class);
    }
  }
  
  public static final class DisMsgReadedNotify
    extends MessageMicro
  {
    public static final int LDISMSGSEQ_FIELD_NUMBER = 4;
    public static final int LDISUIN_FIELD_NUMBER = 1;
    public static final int LMEMBERSEQ_FIELD_NUMBER = 3;
    public static final int LOPTYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "lDisUin", "lOpType", "lMemberSeq", "lDisMsgSeq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, DisMsgReadedNotify.class);
    public final PBUInt64Field lDisMsgSeq = PBField.initUInt64(0L);
    public final PBUInt64Field lDisUin = PBField.initUInt64(0L);
    public final PBUInt64Field lMemberSeq = PBField.initUInt64(0L);
    public final PBUInt64Field lOpType = PBField.initUInt64(0L);
  }
  
  public static final class DiscussOffInfo
    extends MessageMicro
  {
    public static final int DISCUSS_INFO_SEQ_FIELD_NUMBER = 3;
    public static final int DISCUSS_REMARK_FIELD_NUMBER = 4;
    public static final int DISCUSS_TYPE_FIELD_NUMBER = 2;
    public static final int DISCUSS_UIN_FIELD_NUMBER = 1;
    public static final int DIS_NAME_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dis_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0L);
    public final PBBytesField discuss_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field discuss_type = PBField.initUInt32(0);
    public final PBUInt64Field discuss_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "discuss_uin", "discuss_type", "discuss_info_seq", "discuss_remark", "dis_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, DiscussOffInfo.class);
    }
  }
  
  public static final class GroupMsgReadedNotify
    extends MessageMicro
  {
    public static final int LGROUPCODE_FIELD_NUMBER = 1;
    public static final int LGROUPMSGSEQ_FIELD_NUMBER = 4;
    public static final int LMEMBERSEQ_FIELD_NUMBER = 3;
    public static final int LOPTYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "lGroupCode", "lOpType", "lMemberSeq", "lGroupMsgSeq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, GroupMsgReadedNotify.class);
    public final PBUInt64Field lGroupCode = PBField.initUInt64(0L);
    public final PBUInt64Field lGroupMsgSeq = PBField.initUInt64(0L);
    public final PBUInt64Field lMemberSeq = PBField.initUInt64(0L);
    public final PBUInt64Field lOpType = PBField.initUInt64(0L);
  }
  
  public static final class GroupOffInfo
    extends MessageMicro
  {
    public static final int GROUP_CARD_FIELD_NUMBER = 4;
    public static final int GROUP_CODE_FIELD_NUMBER = 1;
    public static final int GROUP_INFO_SEQ_FIELD_NUMBER = 3;
    public static final int GROUP_NAME_FIELD_NUMBER = 5;
    public static final int GROUP_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField group_card = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt64Field group_info_seq = PBField.initUInt64(0L);
    public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "group_code", "group_type", "group_info_seq", "group_card", "group_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, GroupOffInfo.class);
    }
  }
  
  public static final class PbPushOffMsg
    extends MessageMicro
  {
    public static final int C2C_TMP_MSG_HEAD_FIELD_NUMBER = 8;
    public static final int DISCUSS_INFO_FIELD_NUMBER = 7;
    public static final int DWVIEDOTYPE_FIELD_NUMBER = 11;
    public static final int FROM_NICK_FIELD_NUMBER = 4;
    public static final int FROM_UIN_FIELD_NUMBER = 1;
    public static final int GROUP_INFO_FIELD_NUMBER = 6;
    public static final int MSG_FLAG_FIELD_NUMBER = 10;
    public static final int MSG_STR_FIELD_NUMBER = 5;
    public static final int MSG_TYPE_FIELD_NUMBER = 3;
    public static final int SVR_IP_FIELD_NUMBER = 9;
    public static final int TO_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public offlinepush.C2CTmpOffMsgHead c2c_tmp_msg_head = new offlinepush.C2CTmpOffMsgHead();
    public offlinepush.DiscussOffInfo discuss_info = new offlinepush.DiscussOffInfo();
    public final PBUInt32Field dwViedoType = PBField.initUInt32(0);
    public final PBBytesField from_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field from_uin = PBField.initUInt64(0L);
    public offlinepush.GroupOffInfo group_info = new offlinepush.GroupOffInfo();
    public final PBUInt32Field msg_flag = PBField.initUInt32(0);
    public final PBBytesField msg_str = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt32Field svr_ip = PBField.initUInt32(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 72, 80, 88 }, new String[] { "from_uin", "to_uin", "msg_type", "from_nick", "msg_str", "group_info", "discuss_info", "c2c_tmp_msg_head", "svr_ip", "msg_flag", "dwViedoType" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PbPushOffMsg.class);
    }
  }
  
  public static final class PbPushOffReadedNotify
    extends MessageMicro
  {
    public static final int CNOTIFYTYPE_FIELD_NUMBER = 1;
    public static final int SVR_IP_FIELD_NUMBER = 5;
    public static final int VC2CREADEDNOTIFY_FIELD_NUMBER = 2;
    public static final int VDISREADEDNOTIFY_FIELD_NUMBER = 4;
    public static final int VGROUPREADEDNOTIFY_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "cNotifyType", "vC2CReadedNotify", "vGroupReadedNotify", "vDisReadedNotify", "svr_ip" }, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, PbPushOffReadedNotify.class);
    public final PBUInt32Field cNotifyType = PBField.initUInt32(0);
    public final PBUInt32Field svr_ip = PBField.initUInt32(0);
    public final PBRepeatMessageField vC2CReadedNotify = PBField.initRepeatMessage(offlinepush.C2CMsgReadedNotify.class);
    public final PBRepeatMessageField vDisReadedNotify = PBField.initRepeatMessage(offlinepush.DisMsgReadedNotify.class);
    public final PBRepeatMessageField vGroupReadedNotify = PBField.initRepeatMessage(offlinepush.GroupMsgReadedNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.offlinepush
 * JD-Core Version:    0.7.0.1
 */