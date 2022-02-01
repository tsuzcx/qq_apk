package NS_QQ_STORY_CONFIG;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CONFIG
{
  public static final class StGetStoryConfigReq
    extends MessageMicro<StGetStoryConfigReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGetStoryConfigReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetStoryConfigRsp
    extends MessageMicro<StGetStoryConfigRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "intConf" }, new Object[] { null, null }, StGetStoryConfigRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CONFIG.StIntConf> intConf = PBField.initRepeatMessage(CONFIG.StIntConf.class);
  }
  
  public static final class StIntConf
    extends MessageMicro<StIntConf>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "key", "value" }, new Object[] { "", Long.valueOf(0L) }, StIntConf.class);
    public final PBStringField key = PBField.initString("");
    public final PBInt64Field value = PBField.initInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QQ_STORY_CONFIG.CONFIG
 * JD-Core Version:    0.7.0.1
 */