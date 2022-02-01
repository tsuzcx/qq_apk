package NS_MINI_PUBLIC;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Head
{
  public static final class AuthInfo
    extends MessageMicro<AuthInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBStringField str_appid = PBField.initString("");
    public final PBStringField str_uid = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_type", "str_uid", "bytes_sig", "str_appid", "extinfo" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, "", null }, AuthInfo.class);
    }
  }
  
  public static final class QAPPHead
    extends MessageMicro<QAPPHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48, 58, 66, 72, 82, 90, 96, 104, 114, 122, 130, 138 }, new String[] { "str_userip", "str_module", "str_cmdname", "uint64_seq", "str_qua", "uint64_loglevel", "str_logdepth", "auth_info", "retcode", "retmsg", "extinfo", "reqFrm", "logSeq", "colorLink", "deviceInfo", "trace", "all_trace" }, new Object[] { "", "", "", Long.valueOf(0L), "", Long.valueOf(0L), "", null, Long.valueOf(0L), "", null, Integer.valueOf(1), Long.valueOf(0L), null, "", null, null }, QAPPHead.class);
    public Head.StAllLinkTrace all_trace = new Head.StAllLinkTrace();
    public Head.AuthInfo auth_info = new Head.AuthInfo();
    public Head.StColorLink colorLink = new Head.StColorLink();
    public final PBStringField deviceInfo = PBField.initString("");
    public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBUInt64Field logSeq = PBField.initUInt64(0L);
    public final PBEnumField reqFrm = PBField.initEnum(1);
    public final PBInt64Field retcode = PBField.initInt64(0L);
    public final PBStringField retmsg = PBField.initString("");
    public final PBStringField str_cmdname = PBField.initString("");
    public final PBStringField str_logdepth = PBField.initString("");
    public final PBStringField str_module = PBField.initString("");
    public final PBStringField str_qua = PBField.initString("");
    public final PBStringField str_userip = PBField.initString("");
    public Head.StLinkTrace trace = new Head.StLinkTrace();
    public final PBUInt64Field uint64_loglevel = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  }
  
  public static final class StAllLinkTrace
    extends MessageMicro<StAllLinkTrace>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "traceId", "spanId", "parentSpanId", "sampled" }, new Object[] { "", "", "", Integer.valueOf(0) }, StAllLinkTrace.class);
    public final PBStringField parentSpanId = PBField.initString("");
    public final PBInt32Field sampled = PBField.initInt32(0);
    public final PBStringField spanId = PBField.initString("");
    public final PBStringField traceId = PBField.initString("");
  }
  
  public static final class StColorItem
    extends MessageMicro<StColorItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "moduleName", "l5Mod", "l5Cmd" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, StColorItem.class);
    public final PBInt32Field l5Cmd = PBField.initInt32(0);
    public final PBInt32Field l5Mod = PBField.initInt32(0);
    public final PBStringField moduleName = PBField.initString("");
  }
  
  public static final class StColorLink
    extends MessageMicro<StColorLink>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "links", "soft_level" }, new Object[] { null, Integer.valueOf(0) }, StColorLink.class);
    public final PBRepeatMessageField<Head.StColorItem> links = PBField.initRepeatMessage(Head.StColorItem.class);
    public final PBInt32Field soft_level = PBField.initInt32(0);
  }
  
  public static final class StLinkTrace
    extends MessageMicro<StLinkTrace>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "traceId", "spanId", "parentSpanId", "sampled" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, StLinkTrace.class);
    public final PBUInt64Field parentSpanId = PBField.initUInt64(0L);
    public final PBInt32Field sampled = PBField.initInt32(0);
    public final PBUInt64Field spanId = PBField.initUInt64(0L);
    public final PBUInt64Field traceId = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_PUBLIC.Head
 * JD-Core Version:    0.7.0.1
 */