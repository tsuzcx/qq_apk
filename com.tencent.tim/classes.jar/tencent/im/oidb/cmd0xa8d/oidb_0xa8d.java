package tencent.im.oidb.cmd0xa8d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa8d
{
  public static final class Cmd0xa8dExitPublicGroupReqBody
    extends MessageMicro<Cmd0xa8dExitPublicGroupReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_visitor_uin" }, new Object[] { Long.valueOf(0L) }, Cmd0xa8dExitPublicGroupReqBody.class);
    public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
  }
  
  public static final class Cmd0xa8dJoinPublicGroupReqBody
    extends MessageMicro<Cmd0xa8dJoinPublicGroupReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_visitor_uin" }, new Object[] { Long.valueOf(0L) }, Cmd0xa8dJoinPublicGroupReqBody.class);
    public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
  }
  
  public static final class Cmd0xa8dJoinPublicGroupRspBody
    extends MessageMicro<Cmd0xa8dJoinPublicGroupRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_GroupName = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_GroupClass = PBField.initUInt32(0);
    public final PBUInt32Field uint32_GroupClassEx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_GroupFlagEx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_MaxMember = PBField.initUInt32(0);
    public final PBUInt32Field uint32_SpeakInterval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_SpecialClass = PBField.initUInt32(0);
    public final PBUInt32Field uint32_StartSpeakInterval = PBField.initUInt32(0);
    public final PBUInt64Field uint64_GroupCode = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 74 }, new String[] { "uint64_GroupCode", "uint32_SpeakInterval", "uint32_GroupFlagEx", "uint32_StartSpeakInterval", "uint32_GroupClassEx", "uint32_GroupClass", "uint32_MaxMember", "uint32_SpecialClass", "bytes_GroupName" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, Cmd0xa8dJoinPublicGroupRspBody.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint64_group_code", "uint32_req_type", "msg_join_group", "msg_exit_group", "uint32_req_client_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, Integer.valueOf(0) }, ReqBody.class);
    public oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody msg_exit_group = new oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody();
    public oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody msg_join_group = new oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody();
    public final PBUInt32Field uint32_req_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_group_code", "uint32_req_type", "msg_join_group" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspBody.class);
    public oidb_0xa8d.Cmd0xa8dJoinPublicGroupRspBody msg_join_group = new oidb_0xa8d.Cmd0xa8dJoinPublicGroupRspBody();
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa8d.oidb_0xa8d
 * JD-Core Version:    0.7.0.1
 */