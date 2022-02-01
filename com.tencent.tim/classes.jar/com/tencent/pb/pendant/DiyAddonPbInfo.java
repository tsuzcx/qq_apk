package com.tencent.pb.pendant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DiyAddonPbInfo
{
  public static final class AddonGetDiyInfoReq
    extends MessageMicro<AddonGetDiyInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin" }, new Object[] { Long.valueOf(0L) }, AddonGetDiyInfoReq.class);
    public final PBRepeatField<Long> uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class AddonGetDiyInfoRsp
    extends MessageMicro<AddonGetDiyInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "userdiyinfo" }, new Object[] { null }, AddonGetDiyInfoRsp.class);
    public final PBRepeatMessageField<DiyAddonUser.UserDiyInfo> userdiyinfo = PBField.initRepeatMessage(DiyAddonUser.UserDiyInfo.class);
  }
  
  public static final class AddonReqComm
    extends MessageMicro<AddonReqComm>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platform", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, AddonReqComm.class);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
    public final PBInt64Field platform = PBField.initInt64(0L);
  }
  
  public static final class AddonRspComm
    extends MessageMicro<AddonRspComm>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AddonRspComm.class);
  }
  
  public static final class ReadAddonReq
    extends MessageMicro<ReadAddonReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "cmd", "packetseq", "comm", "reqcmd0x01" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, ReadAddonReq.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public DiyAddonPbInfo.AddonReqComm comm = new DiyAddonPbInfo.AddonReqComm();
    public final PBUInt64Field packetseq = PBField.initUInt64(0L);
    public DiyAddonPbInfo.AddonGetDiyInfoReq reqcmd0x01 = new DiyAddonPbInfo.AddonGetDiyInfoReq();
  }
  
  public static final class ReadAddonRsp
    extends MessageMicro<ReadAddonRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "ret", "errmsg", "cmd", "packetseq", "comm", "rspcmd0x01" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, null }, ReadAddonRsp.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public DiyAddonPbInfo.AddonRspComm comm = new DiyAddonPbInfo.AddonRspComm();
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field packetseq = PBField.initUInt64(0L);
    public final PBInt64Field ret = PBField.initInt64(0L);
    public DiyAddonPbInfo.AddonGetDiyInfoRsp rspcmd0x01 = new DiyAddonPbInfo.AddonGetDiyInfoRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.pendant.DiyAddonPbInfo
 * JD-Core Version:    0.7.0.1
 */