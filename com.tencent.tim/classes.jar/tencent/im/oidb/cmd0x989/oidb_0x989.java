package tencent.im.oidb.cmd0x989;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.qun.group_effect.group_effect.EffectInfo;

public final class oidb_0x989
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_code", "svip_level", "group_level" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt64Field group_level = PBField.initUInt64(0L);
    public final PBUInt64Field svip_level = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "wording", "effect_info" }, new Object[] { "", null }, RspBody.class);
    public group_effect.EffectInfo effect_info = new group_effect.EffectInfo();
    public final PBStringField wording = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x989.oidb_0x989
 * JD-Core Version:    0.7.0.1
 */