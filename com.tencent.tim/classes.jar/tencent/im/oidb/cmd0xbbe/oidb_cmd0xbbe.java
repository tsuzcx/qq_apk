package tencent.im.oidb.cmd0xbbe;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbbe
{
  public static final class GetRecommendAccountReq
    extends MessageMicro<GetRecommendAccountReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetRecommendAccountReq.class);
  }
  
  public static final class GetRecommendAccountRsp
    extends MessageMicro<GetRecommendAccountRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_recommend_account_info" }, new Object[] { null }, GetRecommendAccountRsp.class);
    public final PBRepeatMessageField<oidb_cmd0xbbe.RecommendAccountInfo> rpt_msg_recommend_account_info = PBField.initRepeatMessage(oidb_cmd0xbbe.RecommendAccountInfo.class);
  }
  
  public static final class RecommendAccountInfo
    extends MessageMicro<RecommendAccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_head_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_followed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_star = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_vip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_issue_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 64, 72, 80, 88 }, new String[] { "uint64_uin", "uint32_account_type", "bytes_recommend_reason", "bytes_nick_name", "bytes_head_img_url", "uint32_is_vip", "uint32_is_star", "uint32_is_followed", "uint64_algorithm_id", "uint32_strategy_id", "uint64_issue_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, RecommendAccountInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_info_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xbbe.GetRecommendAccountReq msg_get_recommend_account_req = new oidb_cmd0xbbe.GetRecommendAccountReq();
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_get_recommend_account_req", "uint64_article_id", "bytes_info_cookie" }, new Object[] { null, Long.valueOf(0L), localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_article_id", "msg_get_recommend_account_rsp" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
    public oidb_cmd0xbbe.GetRecommendAccountRsp msg_get_recommend_account_rsp = new oidb_cmd0xbbe.GetRecommendAccountRsp();
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe
 * JD-Core Version:    0.7.0.1
 */