package tencent.im.oidb.cmd0x98d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.qun.group_effect.group_effect.EffectInfo;

public final class oidb_0x98d
{
  public static final class GetReq
    extends MessageMicro<GetReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "effect_id" }, new Object[] { Integer.valueOf(0) }, GetReq.class);
    public final PBUInt32Field effect_id = PBField.initUInt32(0);
  }
  
  public static final class GetRsp
    extends MessageMicro<GetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "effect_info", "svip_level", "group_level" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, GetRsp.class);
    public group_effect.EffectInfo effect_info = new group_effect.EffectInfo();
    public final PBUInt32Field group_level = PBField.initUInt32(0);
    public final PBUInt32Field svip_level = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "y_list_req", "z_list_req", "get_req" }, new Object[] { null, null, null }, ReqBody.class);
    public oidb_0x98d.GetReq get_req = new oidb_0x98d.GetReq();
    public oidb_0x98d.YListReq y_list_req = new oidb_0x98d.YListReq();
    public oidb_0x98d.ZListReq z_list_req = new oidb_0x98d.ZListReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "y_list_rsp", "z_list_rsp", "get_rsp" }, new Object[] { null, null, null }, RspBody.class);
    public oidb_0x98d.GetRsp get_rsp = new oidb_0x98d.GetRsp();
    public oidb_0x98d.YListRsp y_list_rsp = new oidb_0x98d.YListRsp();
    public oidb_0x98d.ZListRsp z_list_rsp = new oidb_0x98d.ZListRsp();
  }
  
  public static final class YListReq
    extends MessageMicro<YListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_code", "start", "limit" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, YListReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class YListRsp
    extends MessageMicro<YListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "rpt_effect_info", "user_setting", "svip_level", "group_level" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, YListRsp.class);
    public final PBUInt32Field group_level = PBField.initUInt32(0);
    public final PBRepeatMessageField<group_effect.EffectInfo> rpt_effect_info = PBField.initRepeatMessage(group_effect.EffectInfo.class);
    public final PBUInt32Field svip_level = PBField.initUInt32(0);
    public group_effect.EffectInfo user_setting = new group_effect.EffectInfo();
  }
  
  public static final class ZListReq
    extends MessageMicro<ZListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "group_code" }, new Object[] { Long.valueOf(0L) }, ZListReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
  }
  
  public static final class ZListRsp
    extends MessageMicro<ZListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ZListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98d.oidb_0x98d
 * JD-Core Version:    0.7.0.1
 */