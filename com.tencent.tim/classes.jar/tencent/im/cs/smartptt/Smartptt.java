package tencent.im.cs.smartptt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Smartptt
{
  public static final class PttTransRsp
    extends MessageMicro<PttTransRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "uint32_ret_code", "str_voice_id", "uint32_is_final", "str_text", "uint32_offset" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0) }, PttTransRsp.class);
    public final PBStringField str_text = PBField.initString("");
    public final PBStringField str_voice_id = PBField.initString("");
    public final PBUInt32Field uint32_is_final = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
  }
  
  public static final class PttUpReq
    extends MessageMicro<PttUpReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 32, 40, 50, 56, 64, 72, 80, 90, 96, 104, 112 }, new String[] { "uint32_bits_per_sample", "uint32_voice_file_type", "uint32_voice_encode_type", "uint32_samples_per_sec", "str_voice_id", "uint32_offset", "uint32_is_first", "uint32_is_end", "uint32_service_id", "str_Filemd5", "uint32_chat_type", "uint32_voice_num", "uint32_voice_offset" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PttUpReq.class);
    public final PBStringField str_Filemd5 = PBField.initString("");
    public final PBStringField str_voice_id = PBField.initString("");
    public final PBUInt32Field uint32_bits_per_sample = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_first = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
    public final PBUInt32Field uint32_samples_per_sec = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_encode_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_offset = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_sub_cmd", "msg_ptt_up_req", "msg_tts_req" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
    public Smartptt.PttUpReq msg_ptt_up_req = new Smartptt.PttUpReq();
    public Smartptt.TTSReq msg_tts_req = new Smartptt.TTSReq();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_sub_cmd", "msg_semantic_reco_rsp", "msg_ptttrans_rsp", "msg_tts_rsp", "str_trace_id" }, new Object[] { Integer.valueOf(0), null, null, null, "" }, RspBody.class);
    public Smartptt.PttTransRsp msg_ptttrans_rsp = new Smartptt.PttTransRsp();
    public Smartptt.SemanticRecoRsp msg_semantic_reco_rsp = new Smartptt.SemanticRecoRsp();
    public Smartptt.TTSRsp msg_tts_rsp = new Smartptt.TTSRsp();
    public final PBStringField str_trace_id = PBField.initString("");
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class SemanticRecoRsp
    extends MessageMicro<SemanticRecoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 56, 66, 74, 82 }, new String[] { "uint32_ret_code", "str_voice_id", "uint32_ans_node_id", "str_ans_node_name", "uint32_is_final", "uint32_title_id", "str_title", "slot_info", "str_answer" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", null, "" }, SemanticRecoRsp.class);
    public final PBRepeatMessageField<Smartptt.Slot> slot_info = PBField.initRepeatMessage(Smartptt.Slot.class);
    public final PBStringField str_ans_node_name = PBField.initString("");
    public final PBStringField str_answer = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_voice_id = PBField.initString("");
    public final PBUInt32Field uint32_ans_node_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_final = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_title_id = PBField.initUInt32(0);
  }
  
  public static final class Slot
    extends MessageMicro<Slot>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_slot_name", "str_slot_value", "str_confirm_status" }, new Object[] { "", "", "" }, Slot.class);
    public final PBStringField str_confirm_status = PBField.initString("");
    public final PBStringField str_slot_name = PBField.initString("");
    public final PBStringField str_slot_value = PBField.initString("");
  }
  
  public static final class TTSReq
    extends MessageMicro<TTSReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], TTSReq.class);
  }
  
  public static final class TTSRsp
    extends MessageMicro<TTSRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], TTSRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.smartptt.Smartptt
 * JD-Core Version:    0.7.0.1
 */