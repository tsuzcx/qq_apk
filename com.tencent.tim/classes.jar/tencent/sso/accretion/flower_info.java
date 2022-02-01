package tencent.sso.accretion;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class flower_info
{
  public static final class SFlowerInfo
    extends MessageMicro<SFlowerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "send_uin", "recv_uin", "flower_url", "num" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0) }, SFlowerInfo.class);
    public final PBStringField flower_url = PBField.initString("");
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt64Field recv_uin = PBField.initUInt64(0L);
    public final PBUInt64Field send_uin = PBField.initUInt64(0L);
  }
  
  public static final class SFlowerInfoReq
    extends MessageMicro<SFlowerInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50 }, new String[] { "uin", "queryuin", "version", "platform", "type", "key" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "5.4.0", Integer.valueOf(0), Integer.valueOf(0), "" }, SFlowerInfoReq.class);
    public final PBStringField key = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt64Field queryuin = PBField.initUInt64(0L);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBStringField version = PBField.initString("5.4.0");
  }
  
  public static final class SFlowerInfoRsp
    extends MessageMicro<SFlowerInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48 }, new String[] { "flowers", "num", "ret", "rpt_flower_url", "flower_msg_tips", "flower_flag" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, SFlowerInfoRsp.class);
    public final PBUInt32Field flower_flag = PBField.initUInt32(0);
    public final PBStringField flower_msg_tips = PBField.initString("");
    public final PBRepeatMessageField<flower_info.SFlowerInfo> flowers = PBField.initRepeatMessage(flower_info.SFlowerInfo.class);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBRepeatField<String> rpt_flower_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.sso.accretion.flower_info
 * JD-Core Version:    0.7.0.1
 */