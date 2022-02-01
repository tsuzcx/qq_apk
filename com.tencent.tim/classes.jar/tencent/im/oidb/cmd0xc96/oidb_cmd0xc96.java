package tencent.im.oidb.cmd0xc96;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc96
{
  public static final class FollowExt
    extends MessageMicro<FollowExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "source_from" }, new Object[] { Integer.valueOf(0) }, FollowExt.class);
    public final PBUInt32Field source_from = PBField.initUInt32(0);
  }
  
  public static final class FollowInfo
    extends MessageMicro<FollowInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "openid", "is_followed", "follow_time" }, new Object[] { "", Boolean.valueOf(false), Integer.valueOf(0) }, FollowInfo.class);
    public final PBUInt32Field follow_time = PBField.initUInt32(0);
    public final PBBoolField is_followed = PBField.initBool(false);
    public final PBStringField openid = PBField.initString("");
  }
  
  public static final class FollowReq
    extends MessageMicro<FollowReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ext" }, new Object[] { null }, FollowReq.class);
    public oidb_cmd0xc96.FollowExt ext = new oidb_cmd0xc96.FollowExt();
  }
  
  public static final class FollowRsp
    extends MessageMicro<FollowRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FollowRsp.class);
  }
  
  public static final class GetFollowInfoReq
    extends MessageMicro<GetFollowInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetFollowInfoReq.class);
  }
  
  public static final class GetFollowInfoRsp
    extends MessageMicro<GetFollowInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "follow_info" }, new Object[] { null }, GetFollowInfoRsp.class);
    public oidb_cmd0xc96.FollowInfo follow_info = new oidb_cmd0xc96.FollowInfo();
  }
  
  public static final class MGetFollowInfoReq
    extends MessageMicro<MGetFollowInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "openids" }, new Object[] { "" }, MGetFollowInfoReq.class);
    public final PBRepeatField<String> openids = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class MGetFollowInfoRsp
    extends MessageMicro<MGetFollowInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "follow_info" }, new Object[] { null }, MGetFollowInfoRsp.class);
    public final PBRepeatMessageField<oidb_cmd0xc96.FollowInfo> follow_info = PBField.initRepeatMessage(oidb_cmd0xc96.FollowInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 90, 98, 106, 114 }, new String[] { "appid", "app_type", "puin", "cmd_type", "follow_req", "unfollow_req", "get_follow_info_req", "mget_follow_info_req" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, null, null, null }, ReqBody.class);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public final PBUInt32Field cmd_type = PBField.initUInt32(0);
    public oidb_cmd0xc96.FollowReq follow_req = new oidb_cmd0xc96.FollowReq();
    public oidb_cmd0xc96.GetFollowInfoReq get_follow_info_req = new oidb_cmd0xc96.GetFollowInfoReq();
    public oidb_cmd0xc96.MGetFollowInfoReq mget_follow_info_req = new oidb_cmd0xc96.MGetFollowInfoReq();
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public oidb_cmd0xc96.UnfollowReq unfollow_req = new oidb_cmd0xc96.UnfollowReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 90, 98, 106, 114 }, new String[] { "wording", "next_req_duration", "appid", "app_type", "follow_rsp", "unfollow_rsp", "get_follow_info_rsp", "mget_follow_info_rsp" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, null, null, null }, RspBody.class);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public oidb_cmd0xc96.FollowRsp follow_rsp = new oidb_cmd0xc96.FollowRsp();
    public oidb_cmd0xc96.GetFollowInfoRsp get_follow_info_rsp = new oidb_cmd0xc96.GetFollowInfoRsp();
    public oidb_cmd0xc96.MGetFollowInfoRsp mget_follow_info_rsp = new oidb_cmd0xc96.MGetFollowInfoRsp();
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
    public oidb_cmd0xc96.UnfollowRsp unfollow_rsp = new oidb_cmd0xc96.UnfollowRsp();
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class UnFollowExt
    extends MessageMicro<UnFollowExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "source_from" }, new Object[] { Integer.valueOf(0) }, UnFollowExt.class);
    public final PBUInt32Field source_from = PBField.initUInt32(0);
  }
  
  public static final class UnfollowReq
    extends MessageMicro<UnfollowReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ext" }, new Object[] { null }, UnfollowReq.class);
    public oidb_cmd0xc96.UnFollowExt ext = new oidb_cmd0xc96.UnFollowExt();
  }
  
  public static final class UnfollowRsp
    extends MessageMicro<UnfollowRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], UnfollowRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc96.oidb_cmd0xc96
 * JD-Core Version:    0.7.0.1
 */