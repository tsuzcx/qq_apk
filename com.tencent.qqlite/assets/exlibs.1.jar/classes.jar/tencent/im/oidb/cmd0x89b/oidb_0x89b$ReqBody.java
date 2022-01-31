package tencent.im.oidb.cmd0x89b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x89b$ReqBody
  extends MessageMicro
{
  public static final int MSG_EXIT_GROUP_FIELD_NUMBER = 5;
  public static final int MSG_JOIN_GROUP_FIELD_NUMBER = 4;
  public static final int MSG_KICK_VISITOR_FIELD_NUMBER = 6;
  public static final int UINT32_HOT_GROUP_TYPE_FIELD_NUMBER = 7;
  public static final int UINT32_REQ_TYPE_FIELD_NUMBER = 3;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
  public static final int UINT64_GROUP_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56 }, new String[] { "uint64_group_uin", "uint64_group_code", "uint32_req_type", "msg_join_group", "msg_exit_group", "msg_kick_visitor", "uint32_hot_group_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, ReqBody.class);
  public oidb_0x89b.ExitPublicGroupReqBody msg_exit_group = new oidb_0x89b.ExitPublicGroupReqBody();
  public oidb_0x89b.JoinPublicGroupReqBody msg_join_group = new oidb_0x89b.JoinPublicGroupReqBody();
  public oidb_0x89b.KickPublicGroupVisitorReqBody msg_kick_visitor = new oidb_0x89b.KickPublicGroupVisitorReqBody();
  public final PBUInt32Field uint32_hot_group_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89b.oidb_0x89b.ReqBody
 * JD-Core Version:    0.7.0.1
 */