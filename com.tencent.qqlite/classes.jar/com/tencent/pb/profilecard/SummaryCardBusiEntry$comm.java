package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SummaryCardBusiEntry$comm
  extends MessageMicro
{
  public static final int BUILD_FIELD_NUMBER = 14;
  public static final int CLIENT_IP_FIELD_NUMBER = 8;
  public static final int DISPLAY_FIELD_NUMBER = 9;
  public static final int ERR_MSG_FIELD_NUMBER = 11;
  public static final int FROMUIN_FIELD_NUMBER = 3;
  public static final int PLATFORM_FIELD_NUMBER = 12;
  public static final int QQVER_FIELD_NUMBER = 13;
  public static final int RESULT_FIELD_NUMBER = 10;
  public static final int SEQ_FIELD_NUMBER = 2;
  public static final int SERVICE_FIELD_NUMBER = 5;
  public static final int SESSION_KEY_FIELD_NUMBER = 7;
  public static final int SESSION_TYPE_FIELD_NUMBER = 6;
  public static final int TOUIN_FIELD_NUMBER = 4;
  public static final int VER_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field build = PBField.initInt32(0);
  public final PBUInt32Field client_ip = PBField.initUInt32(0);
  public SummaryCardBusiEntry.ui display = new SummaryCardBusiEntry.ui();
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt64Field fromuin = PBField.initUInt64(0L);
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBStringField qqver = PBField.initString("");
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt32Field service = PBField.initUInt32(0);
  public final PBBytesField session_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field session_type = PBField.initUInt32(0);
  public final PBUInt64Field touin = PBField.initUInt64(0L);
  public final PBUInt32Field ver = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 74, 80, 90, 96, 106, 112 }, new String[] { "ver", "seq", "fromuin", "touin", "service", "session_type", "session_key", "client_ip", "display", "result", "err_msg", "platform", "qqver", "build" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), null, Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0) }, comm.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardBusiEntry.comm
 * JD-Core Version:    0.7.0.1
 */