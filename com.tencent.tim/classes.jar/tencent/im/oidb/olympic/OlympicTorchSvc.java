package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OlympicTorchSvc
{
  public static final class ReqDeliverTorch
    extends MessageMicro<ReqDeliverTorch>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
    public final PBUInt32Field uint32_user_share = PBField.initUInt32(0);
    public final PBUInt64Field uint64_torch_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 82 }, new String[] { "uint64_torch_id", "msg_lbs_info", "uint32_user_share", "bytes_sig" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro }, ReqDeliverTorch.class);
    }
  }
  
  public static final class ReqExitDeliverTorch
    extends MessageMicro<ReqExitDeliverTorch>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqExitDeliverTorch.class);
  }
  
  public static final class ReqGetBusinessTorch
    extends MessageMicro<ReqGetBusinessTorch>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_torch_id", "msg_lbs_info", "rpt_city_pic_id_list" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L) }, ReqGetBusinessTorch.class);
    public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
    public final PBRepeatField<Long> rpt_city_pic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_torch_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqGetTorchAward
    extends MessageMicro<ReqGetTorchAward>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_city_pic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_business = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 82 }, new String[] { "bytes_pack_id", "uint32_business", "rpt_city_pic_id_list", "bytes_sig" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2 }, ReqGetTorchAward.class);
    }
  }
  
  public static final class RspDeliverTorch
    extends MessageMicro<RspDeliverTorch>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public OlympicTorchSvc.RspHead msg_rsp_head = new OlympicTorchSvc.RspHead();
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_min_update_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 82 }, new String[] { "msg_rsp_head", "uint32_min_update_time", "uint32_expire_time", "bytes_sig" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RspDeliverTorch.class);
    }
  }
  
  public static final class RspExitDeliverTorch
    extends MessageMicro<RspExitDeliverTorch>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_rsp_head" }, new Object[] { null }, RspExitDeliverTorch.class);
    public OlympicTorchSvc.RspHead msg_rsp_head = new OlympicTorchSvc.RspHead();
  }
  
  public static final class RspGetBusinessTorch
    extends MessageMicro<RspGetBusinessTorch>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_rsp_head", "msg_torch_info", "msg_scene_wording" }, new Object[] { null, null, null }, RspGetBusinessTorch.class);
    public OlympicTorchSvc.RspHead msg_rsp_head = new OlympicTorchSvc.RspHead();
    public OlympicTorchSvc.SceneWording msg_scene_wording = new OlympicTorchSvc.SceneWording();
    public torch_transfer.TorchbearerInfo msg_torch_info = new torch_transfer.TorchbearerInfo();
  }
  
  public static final class RspGetTorchAward
    extends MessageMicro<RspGetTorchAward>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public OlympicTorchSvc.RspHead msg_rsp_head = new OlympicTorchSvc.RspHead();
    public torch_transfer.TorchbearerInfo msg_torchbearer_info = new torch_transfer.TorchbearerInfo();
    public final PBUInt32Field uint32_delay_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 82 }, new String[] { "msg_rsp_head", "msg_torchbearer_info", "uint32_delay_time", "bytes_sig" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspGetTorchAward.class);
    }
  }
  
  public static final class RspHead
    extends MessageMicro<RspHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "str_error_msg" }, new Object[] { Integer.valueOf(0), "" }, RspHead.class);
    public final PBStringField str_error_msg = PBField.initString("");
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
  
  public static final class SceneWording
    extends MessageMicro<SceneWording>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "str_line1", "str_line2", "str_link_word", "str_link_url" }, new Object[] { "", "", "", "" }, SceneWording.class);
    public final PBStringField str_line1 = PBField.initString("");
    public final PBStringField str_line2 = PBField.initString("");
    public final PBStringField str_link_url = PBField.initString("");
    public final PBStringField str_link_word = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.olympic.OlympicTorchSvc
 * JD-Core Version:    0.7.0.1
 */