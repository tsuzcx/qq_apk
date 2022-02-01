package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm.Msg;

public final class subcmd0x51b
{
  public static final class DelSingleClusterMsgReq
    extends MessageMicro<DelSingleClusterMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cluster_id = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8("");
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_puin", "bytes_cluster_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, DelSingleClusterMsgReq.class);
    }
  }
  
  public static final class DelSingleClusterMsgRsp
    extends MessageMicro<DelSingleClusterMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    public final PBEnumField ret_code = PBField.initEnum(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8("");
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, DelSingleClusterMsgRsp.class);
    }
  }
  
  public static final class GetSingleClusterMsgReq
    extends MessageMicro<GetSingleClusterMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cluster_id = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    public final PBRepeatField<Long> rpt_fixed64_msgid_list = PBField.initRepeat(PBFixed64Field.__repeatHelper__);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8("");
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 25 }, new String[] { "uint64_puin", "bytes_cluster_id", "rpt_fixed64_msgid_list" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L) }, GetSingleClusterMsgReq.class);
    }
  }
  
  public static final class GetSingleClusterMsgRsp
    extends MessageMicro<GetSingleClusterMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBRepeatMessageField<msg_comm.Msg> rpt_msg_msg_list = PBField.initRepeatMessage(msg_comm.Msg.class);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8("");
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "ret_code", "bytes_error_msg", "uint64_puin", "rpt_msg_msg_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), null }, GetSingleClusterMsgRsp.class);
    }
  }
  
  public static final class GetSingleRoamMsgReq
    extends MessageMicro<GetSingleRoamMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17 }, new String[] { "uint64_puin", "fixed64_last_msg_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GetSingleRoamMsgReq.class);
    public final PBFixed64Field fixed64_last_msg_id = PBField.initFixed64(0L);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  }
  
  public static final class GetSingleRoamMsgRsp
    extends MessageMicro<GetSingleRoamMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBRepeatMessageField<msg_comm.Msg> rpt_msg_msg_list = PBField.initRepeatMessage(msg_comm.Msg.class);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8("");
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "ret_code", "bytes_error_msg", "uint64_puin", "rpt_msg_msg_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), null }, GetSingleRoamMsgRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_cmd", "msg_get_single_roam_msg_req", "msg_get_single_cluster_msg_req", "msg_del_single_cluster_msg_req" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
    public final PBInt32Field int32_cmd = PBField.initInt32(0);
    public subcmd0x51b.DelSingleClusterMsgReq msg_del_single_cluster_msg_req = new subcmd0x51b.DelSingleClusterMsgReq();
    public subcmd0x51b.GetSingleClusterMsgReq msg_get_single_cluster_msg_req = new subcmd0x51b.GetSingleClusterMsgReq();
    public subcmd0x51b.GetSingleRoamMsgReq msg_get_single_roam_msg_req = new subcmd0x51b.GetSingleRoamMsgReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_cmd", "msg_get_single_roam_msg_rep", "msg_get_single_cluster_msg_rep", "msg_del_single_cluster_msg_rep" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
    public final PBInt32Field int32_cmd = PBField.initInt32(0);
    public subcmd0x51b.DelSingleClusterMsgRsp msg_del_single_cluster_msg_rep = new subcmd0x51b.DelSingleClusterMsgRsp();
    public subcmd0x51b.GetSingleClusterMsgRsp msg_get_single_cluster_msg_rep = new subcmd0x51b.GetSingleClusterMsgRsp();
    public subcmd0x51b.GetSingleRoamMsgRsp msg_get_single_roam_msg_rep = new subcmd0x51b.GetSingleRoamMsgRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x51b
 * JD-Core Version:    0.7.0.1
 */