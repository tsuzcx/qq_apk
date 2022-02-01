package tencent.im.oidb.cmd0x938;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x938
{
  public static final class ClientConfig
    extends MessageMicro<ClientConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_card_url_g = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_card_url_h = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_list_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_show_card = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_list = PBField.initUInt32(0);
    public final PBUInt64Field uint64_next_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint32_show_list", "uint32_show_card", "uint64_next_time", "bytes_card_url_h", "bytes_card_url_g", "bytes_list_jump_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ClientConfig.class);
    }
  }
  
  public static final class ClientParam
    extends MessageMicro<ClientParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ClientParam.class);
  }
  
  public static final class CommParamReq
    extends MessageMicro<CommParamReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_version", "uint32_platform" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, CommParamReq.class);
    }
  }
  
  public static final class CommParamRsp
    extends MessageMicro<CommParamRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], CommParamRsp.class);
  }
  
  public static final class DataCardConfig
    extends MessageMicro<DataCardConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_card_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tail_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_card_wording_color = PBField.initUInt32(0);
    public final PBUInt32Field uint32_entry_ability = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tail_wording_color = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "bytes_card_wording", "bytes_tail_wording", "uint32_entry_ability", "uint32_card_wording_color", "uint32_tail_wording_color" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DataCardConfig.class);
    }
  }
  
  public static final class DataCardParam
    extends MessageMicro<DataCardParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint32_gender" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, DataCardParam.class);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class FloatButtonConfig
    extends MessageMicro<FloatButtonConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_button_image_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_button_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_button_back_color = PBField.initUInt32(0);
    public final PBUInt32Field uint32_button_word_color = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "bytes_button_wording", "bytes_button_image_url", "uint32_button_word_color", "uint32_button_back_color", "uint32_like_count" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FloatButtonConfig.class);
    }
  }
  
  public static final class FloatButtonParam
    extends MessageMicro<FloatButtonParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FloatButtonParam.class);
  }
  
  public static final class OperationConfig
    extends MessageMicro<OperationConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_button_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_button_wording" }, new Object[] { localByteStringMicro }, OperationConfig.class);
    }
  }
  
  public static final class OperationParam
    extends MessageMicro<OperationParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], OperationParam.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "msg_comm_param", "msg_client_param", "msg_datacard_param", "msg_operation_param", "msg_scorelist_param", "msg_floatbutton_param" }, new Object[] { null, null, null, null, null, null }, ReqBody.class);
    public cmd0x938.ClientParam msg_client_param = new cmd0x938.ClientParam();
    public cmd0x938.CommParamReq msg_comm_param = new cmd0x938.CommParamReq();
    public cmd0x938.DataCardParam msg_datacard_param = new cmd0x938.DataCardParam();
    public cmd0x938.FloatButtonParam msg_floatbutton_param = new cmd0x938.FloatButtonParam();
    public cmd0x938.OperationParam msg_operation_param = new cmd0x938.OperationParam();
    public cmd0x938.ScoreListParam msg_scorelist_param = new cmd0x938.ScoreListParam();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "msg_comm_param", "msg_client_config", "msg_datacard_config", "msg_operation_config", "msg_scorelist_config", "msg_floatbutton_config" }, new Object[] { null, null, null, null, null, null }, RspBody.class);
    public cmd0x938.ClientConfig msg_client_config = new cmd0x938.ClientConfig();
    public cmd0x938.CommParamRsp msg_comm_param = new cmd0x938.CommParamRsp();
    public cmd0x938.DataCardConfig msg_datacard_config = new cmd0x938.DataCardConfig();
    public cmd0x938.FloatButtonConfig msg_floatbutton_config = new cmd0x938.FloatButtonConfig();
    public cmd0x938.OperationConfig msg_operation_config = new cmd0x938.OperationConfig();
    public cmd0x938.ScoreListConfig msg_scorelist_config = new cmd0x938.ScoreListConfig();
  }
  
  public static final class ScoreListConfig
    extends MessageMicro<ScoreListConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_multi_mode" }, new Object[] { Integer.valueOf(0) }, ScoreListConfig.class);
    public final PBUInt32Field uint32_multi_mode = PBField.initUInt32(0);
  }
  
  public static final class ScoreListParam
    extends MessageMicro<ScoreListParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ScoreListParam.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x938.cmd0x938
 * JD-Core Version:    0.7.0.1
 */