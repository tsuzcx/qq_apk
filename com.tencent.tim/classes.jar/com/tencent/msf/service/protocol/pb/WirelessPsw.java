package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WirelessPsw
{
  public static final class CWirelessPswReq
    extends MessageMicro
  {
    public static final int CMD_FIELD_NUMBER = 5;
    public static final int IP_FIELD_NUMBER = 2;
    public static final int KSID_FIELD_NUMBER = 4;
    public static final int TIME_FIELD_NUMBER = 3;
    public static final int UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field ip = PBField.initUInt32(0);
    public final PBBytesField ksid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field time = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uin", "ip", "time", "ksid", "cmd" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, CWirelessPswReq.class);
    }
  }
  
  public static final class CWirelessPswRsp
    extends MessageMicro
  {
    public static final int RET_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, CWirelessPswRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.WirelessPsw
 * JD-Core Version:    0.7.0.1
 */