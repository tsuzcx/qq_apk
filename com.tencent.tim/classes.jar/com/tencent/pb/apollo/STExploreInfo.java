package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STExploreInfo
{
  public static final class STEntryIdInfo
    extends MessageMicro<STEntryIdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "entry_id", "num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, STEntryIdInfo.class);
    public final PBInt32Field entry_id = PBField.initInt32(0);
    public final PBInt32Field num = PBField.initInt32(0);
  }
  
  public static final class STEntryIdMsg
    extends MessageMicro<STEntryIdMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "entry_id", "msg_info", "next_req_ts" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, STEntryIdMsg.class);
    public final PBInt32Field entry_id = PBField.initInt32(0);
    public final PBRepeatMessageField<STExploreInfo.STMsgInfo> msg_info = PBField.initRepeatMessage(STExploreInfo.STMsgInfo.class);
    public final PBUInt32Field next_req_ts = PBField.initUInt32(0);
  }
  
  public static final class STGetMsgReq
    extends MessageMicro<STGetMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "app_type", "eid_list" }, new Object[] { Integer.valueOf(0), null }, STGetMsgReq.class);
    public final PBInt32Field app_type = PBField.initInt32(0);
    public final PBRepeatMessageField<STExploreInfo.STEntryIdInfo> eid_list = PBField.initRepeatMessage(STExploreInfo.STEntryIdInfo.class);
  }
  
  public static final class STGetMsgRsp
    extends MessageMicro<STGetMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "eid_list" }, new Object[] { null }, STGetMsgRsp.class);
    public final PBRepeatMessageField<STExploreInfo.STEntryIdMsg> eid_list = PBField.initRepeatMessage(STExploreInfo.STEntryIdMsg.class);
  }
  
  public static final class STMsgInfo
    extends MessageMicro<STMsgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field action_id = PBField.initInt32(0);
    public final PBInt32Field bubble_id = PBField.initInt32(0);
    public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field is_red = PBField.initInt32(0);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField scheme = PBField.initString("");
    public final PBInt64Field seq = PBField.initInt64(0L);
    public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 64 }, new String[] { "seq", "wording", "jump_url", "scheme", "is_red", "icon_url", "action_id", "bubble_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, "", Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, STMsgInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.apollo.STExploreInfo
 * JD-Core Version:    0.7.0.1
 */