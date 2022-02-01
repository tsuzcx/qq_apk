package tencent.im.oidb.cmd0xe5b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe5b
{
  public static final class LifeAchievementItem
    extends MessageMicro<LifeAchievementItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_has_praised = PBField.initBool(false);
    public final PBBytesField bytes_achievement_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_achievement_icon = PBField.initString("");
    public final PBStringField str_achievement_title = PBField.initString("");
    public final PBUInt32Field uint32_achievement_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "uint32_achievement_id", "str_achievement_title", "str_achievement_icon", "bool_has_praised", "uint32_praise_num", "bytes_achievement_content" }, new Object[] { Integer.valueOf(0), "", "", Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro }, LifeAchievementItem.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_uin", "rpt_achievement_id", "uint32_max_count", "bool_req_achievement_content" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, ReqBody.class);
    public final PBBoolField bool_req_achievement_content = PBField.initBool(false);
    public final PBRepeatField<Integer> rpt_achievement_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_achievement_totalcount", "rpt_life_ach_item", "str_achievement_openid" }, new Object[] { Integer.valueOf(0), null, "" }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xe5b.LifeAchievementItem> rpt_life_ach_item = PBField.initRepeatMessage(oidb_0xe5b.LifeAchievementItem.class);
    public final PBStringField str_achievement_openid = PBField.initString("");
    public final PBUInt32Field uint32_achievement_totalcount = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5b.oidb_0xe5b
 * JD-Core Version:    0.7.0.1
 */