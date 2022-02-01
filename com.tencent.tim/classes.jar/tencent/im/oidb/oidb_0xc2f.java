package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc2f
{
  public static final class GetFollowUserRecommendListReq
    extends MessageMicro<GetFollowUserRecommendListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_followed_uin" }, new Object[] { Long.valueOf(0L) }, GetFollowUserRecommendListReq.class);
    public final PBUInt64Field uint64_followed_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetFollowUserRecommendListRsp
    extends MessageMicro<GetFollowUserRecommendListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0xc2f.RecommendAccountInfo> rpt_msg_recommend_list = PBField.initRepeatMessage(oidb_0xc2f.RecommendAccountInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_recommend_list", "bytes_jump_url" }, new Object[] { null, localByteStringMicro }, GetFollowUserRecommendListRsp.class);
    }
  }
  
  public static final class RecommendAccountInfo
    extends MessageMicro<RecommendAccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_head_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_star = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_vip = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58 }, new String[] { "uint64_uin", "uint32_account_type", "bytes_nick_name", "bytes_head_img_url", "uint32_is_vip", "uint32_is_star", "bytes_recommend_reason" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, RecommendAccountInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_follow_user_recommend_list_req" }, new Object[] { null }, ReqBody.class);
    public oidb_0xc2f.GetFollowUserRecommendListReq msg_get_follow_user_recommend_list_req = new oidb_0xc2f.GetFollowUserRecommendListReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_follow_user_recommend_list_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_0xc2f.GetFollowUserRecommendListRsp msg_get_follow_user_recommend_list_rsp = new oidb_0xc2f.GetFollowUserRecommendListRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc2f
 * JD-Core Version:    0.7.0.1
 */