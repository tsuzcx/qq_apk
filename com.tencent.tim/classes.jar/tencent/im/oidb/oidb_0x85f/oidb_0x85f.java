package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.userdata.userdata.FaceScore;

public final class oidb_0x85f
{
  public static final class CommParamReq
    extends MessageMicro<CommParamReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
    public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
    public final PBUInt32Field uint32_use_uin = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_portal", "bytes_version", "uint32_platform", "uint32_use_uin" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, CommParamReq.class);
    }
  }
  
  public static final class CommParamRsp
    extends MessageMicro<CommParamRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], CommParamRsp.class);
  }
  
  public static final class GrayOpenReq
    extends MessageMicro<GrayOpenReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GrayOpenReq.class);
  }
  
  public static final class GrayOpenRsp
    extends MessageMicro<GrayOpenRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_info_card_entry_guest_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_info_card_entry_host_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nearby_entry_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nearby_entry_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_nearby_entry_color = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_card = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_list = PBField.initUInt32(0);
    public final PBUInt64Field uint64_next_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66 }, new String[] { "uint32_show_card", "uint32_show_list", "uint64_next_time", "uint32_nearby_entry_color", "bytes_nearby_entry_wording", "bytes_info_card_entry_host_url", "bytes_info_card_entry_guest_url", "bytes_nearby_entry_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, GrayOpenRsp.class);
    }
  }
  
  public static final class MatchCheckReq
    extends MessageMicro<MatchCheckReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_match_user_id" }, new Object[] { Long.valueOf(0L) }, MatchCheckReq.class);
    public final PBRepeatField<Long> uint64_match_user_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class MatchCheckRsp
    extends MessageMicro<MatchCheckRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_match_item" }, new Object[] { null }, MatchCheckRsp.class);
    public final PBRepeatMessageField<oidb_0x85f.MatchItem> msg_match_item = PBField.initRepeatMessage(oidb_0x85f.MatchItem.class);
  }
  
  public static final class MatchItem
    extends MessageMicro<MatchItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_match_user_id", "uint32_match" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, MatchItem.class);
    public final PBUInt32Field uint32_match = PBField.initUInt32(0);
    public final PBUInt64Field uint64_match_user_id = PBField.initUInt64(0L);
  }
  
  public static final class ReadFaceScoreBatchReq
    extends MessageMicro<ReadFaceScoreBatchReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_req_list" }, new Object[] { null }, ReadFaceScoreBatchReq.class);
    public final PBRepeatMessageField<oidb_0x85f.ReadFaceScoreReq> msg_req_list = PBField.initRepeatMessage(oidb_0x85f.ReadFaceScoreReq.class);
  }
  
  public static final class ReadFaceScoreBatchRsp
    extends MessageMicro<ReadFaceScoreBatchRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_rsp_list" }, new Object[] { null }, ReadFaceScoreBatchRsp.class);
    public final PBRepeatMessageField<oidb_0x85f.ReadFaceScoreRsp> msg_rsp_list = PBField.initRepeatMessage(oidb_0x85f.ReadFaceScoreRsp.class);
  }
  
  public static final class ReadFaceScoreReq
    extends MessageMicro<ReadFaceScoreReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_user_id", "uint32_day", "uint32_range_min", "uint32_range_max" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReadFaceScoreReq.class);
    public final PBUInt32Field uint32_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_range_max = PBField.initUInt32(0);
    public final PBUInt32Field uint32_range_min = PBField.initUInt32(0);
    public final PBUInt64Field uint64_user_id = PBField.initUInt64(0L);
  }
  
  public static final class ReadFaceScoreRsp
    extends MessageMicro<ReadFaceScoreRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_user_id", "uint32_score_of_mine", "msg_score", "uint32_show_user", "uint32_score_to_me" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReadFaceScoreRsp.class);
    public final PBRepeatMessageField<userdata.FaceScore> msg_score = PBField.initRepeatMessage(userdata.FaceScore.class);
    public final PBUInt32Field uint32_score_of_mine = PBField.initUInt32(0);
    public final PBUInt32Field uint32_score_to_me = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_user = PBField.initUInt32(0);
    public final PBUInt64Field uint64_user_id = PBField.initUInt64(0L);
  }
  
  public static final class ReadScoreListReq
    extends MessageMicro<ReadScoreListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint32_index_begin", "uint32_index_end", "uint32_dimension", "uint32_index_order", "uint32_day", "uint64_user_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReadScoreListReq.class);
    public final PBUInt32Field uint32_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dimension = PBField.initUInt32(0);
    public final PBUInt32Field uint32_index_begin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_index_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_index_order = PBField.initUInt32(0);
    public final PBUInt64Field uint64_user_id = PBField.initUInt64(0L);
  }
  
  public static final class ReadScoreListRsp
    extends MessageMicro<ReadScoreListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_rsp_list", "uint32_index_end" }, new Object[] { null, Integer.valueOf(0) }, ReadScoreListRsp.class);
    public final PBRepeatMessageField<oidb_0x85f.ReadFaceScoreRsp> msg_rsp_list = PBField.initRepeatMessage(oidb_0x85f.ReadFaceScoreRsp.class);
    public final PBUInt32Field uint32_index_end = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 794 }, new String[] { "msg_comm_param", "msg_read_score", "msg_read_list", "msg_match_check", "msg_gray_open" }, new Object[] { null, null, null, null, null }, ReqBody.class);
    public oidb_0x85f.CommParamReq msg_comm_param = new oidb_0x85f.CommParamReq();
    public oidb_0x85f.GrayOpenReq msg_gray_open = new oidb_0x85f.GrayOpenReq();
    public oidb_0x85f.MatchCheckReq msg_match_check = new oidb_0x85f.MatchCheckReq();
    public oidb_0x85f.ReadScoreListReq msg_read_list = new oidb_0x85f.ReadScoreListReq();
    public oidb_0x85f.ReadFaceScoreBatchReq msg_read_score = new oidb_0x85f.ReadFaceScoreBatchReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 794 }, new String[] { "msg_comm_param", "msg_read_score", "msg_read_list", "msg_match_check", "msg_gray_open" }, new Object[] { null, null, null, null, null }, RspBody.class);
    public oidb_0x85f.CommParamRsp msg_comm_param = new oidb_0x85f.CommParamRsp();
    public oidb_0x85f.GrayOpenRsp msg_gray_open = new oidb_0x85f.GrayOpenRsp();
    public oidb_0x85f.MatchCheckRsp msg_match_check = new oidb_0x85f.MatchCheckRsp();
    public oidb_0x85f.ReadScoreListRsp msg_read_list = new oidb_0x85f.ReadScoreListRsp();
    public oidb_0x85f.ReadFaceScoreBatchRsp msg_read_score = new oidb_0x85f.ReadFaceScoreBatchRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f
 * JD-Core Version:    0.7.0.1
 */