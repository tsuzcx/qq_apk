package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop
{
  public static final class SQQSHPAccoutRelation
    extends MessageMicro<SQQSHPAccoutRelation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "puin", "binduin", "distance", "customerservice" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(-1), Integer.valueOf(0) }, SQQSHPAccoutRelation.class);
    public final PBUInt64Field binduin = PBField.initUInt64(0L);
    public final PBInt32Field customerservice = PBField.initInt32(0);
    public final PBInt32Field distance = PBField.initInt32(-1);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
  }
  
  public static final class SQQSHPClientReq
    extends MessageMicro<SQQSHPClientReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 33, 41, 48, 56, 64 }, new String[] { "eventid", "puinlist", "cuinlist", "longitude", "latitude", "msglistlen", "rcpuin", "ad_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(-1), Long.valueOf(0L), Long.valueOf(0L) }, SQQSHPClientReq.class);
    public final PBUInt64Field ad_id = PBField.initUInt64(0L);
    public final PBRepeatField<Long> cuinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field eventid = PBField.initUInt32(0);
    public final PBDoubleField latitude = PBField.initDouble(0.0D);
    public final PBDoubleField longitude = PBField.initDouble(0.0D);
    public final PBInt32Field msglistlen = PBField.initInt32(-1);
    public final PBRepeatField<Long> puinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field rcpuin = PBField.initUInt64(0L);
  }
  
  public static final class SQQSHPClientRsp
    extends MessageMicro<SQQSHPClientRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "recmdlist", "bindlist", "retcode", "newusrrecmd", "rcpuin" }, new Object[] { null, null, Integer.valueOf(0), null, Long.valueOf(0L) }, SQQSHPClientRsp.class);
    public final PBRepeatMessageField<qqshop.SQQSHPAccoutRelation> bindlist = PBField.initRepeatMessage(qqshop.SQQSHPAccoutRelation.class);
    public qqshop.SQQSHPNewUserRecmd newusrrecmd = new qqshop.SQQSHPNewUserRecmd();
    public final PBUInt64Field rcpuin = PBField.initUInt64(0L);
    public final PBRepeatMessageField<qqshop.SQQSHPRecmdAccount> recmdlist = PBField.initRepeatMessage(qqshop.SQQSHPRecmdAccount.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
  }
  
  public static final class SQQSHPNewUserRecmd
    extends MessageMicro<SQQSHPNewUserRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "recmdflag", "recmdurl" }, new Object[] { Integer.valueOf(0), "" }, SQQSHPNewUserRecmd.class);
    public final PBInt32Field recmdflag = PBField.initInt32(0);
    public final PBStringField recmdurl = PBField.initString("");
  }
  
  public static final class SQQSHPRecmdAccount
    extends MessageMicro<SQQSHPRecmdAccount>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "puin", "nick", "headurl", "desc" }, new Object[] { Long.valueOf(0L), "", "", "" }, SQQSHPRecmdAccount.class);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField headurl = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBUInt64Field puin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop
 * JD-Core Version:    0.7.0.1
 */