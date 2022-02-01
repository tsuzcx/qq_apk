package tencent.im.oidb.cmd0x7df;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7df
{
  public static final class FriendScore
    extends MessageMicro<FriendScore>
  {
    public static final int BYTES_NICK_FIELD_NUMBER = 5;
    public static final int BYTES_RELATION_NAME_FIELD_NUMBER = 3;
    public static final int UINT32_FRIEND_SCORE_FIELD_NUMBER = 2;
    public static final int UINT32_RANK_FIELD_NUMBER = 4;
    public static final int UINT64_FRIEND_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_relation_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_friend_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rank = PBField.initUInt32(0);
    public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint64_friend_uin", "uint32_friend_score", "bytes_relation_name", "uint32_rank", "bytes_nick" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, FriendScore.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int RPT_UINT64_UINLIST_FIELD_NUMBER = 4;
    public static final int UINT32_NICK_FIELD_NUMBER = 6;
    public static final int UINT32_REQ_NUM_FIELD_NUMBER = 3;
    public static final int UINT32_SEQ_FIELD_NUMBER = 1;
    public static final int UINT32_SORT_FIELD_NUMBER = 5;
    public static final int UINT32_START_INDEX_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint32_seq", "uint32_start_index", "uint32_req_num", "rpt_uint64_uinlist", "uint32_sort", "uint32_nick" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_uinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_nick = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sort = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int RPT_MSG_FRIEND_SCORE_FIELD_NUMBER = 4;
    public static final int UINT32_LOW_SCORE_FIELD_NUMBER = 6;
    public static final int UINT32_NEXT_START_FIELD_NUMBER = 3;
    public static final int UINT32_OVER_FIELD_NUMBER = 2;
    public static final int UINT32_SEQ_FIELD_NUMBER = 1;
    public static final int UINT32_TOTAL_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint32_seq", "uint32_over", "uint32_next_start", "rpt_msg_friend_score", "uint32_total", "uint32_low_score" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x7df.FriendScore> rpt_msg_friend_score = PBField.initRepeatMessage(oidb_0x7df.FriendScore.class);
    public final PBUInt32Field uint32_low_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7df.oidb_0x7df
 * JD-Core Version:    0.7.0.1
 */