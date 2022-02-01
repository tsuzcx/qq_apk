package tencent.im.oidb.cmd0xd68;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xd68
{
  public static final class ForwardDataWireReqBody
    extends MessageMicro<ForwardDataWireReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_parent_folder = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField cid = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_svcid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 66, 72 }, new String[] { "uint32_src_svcid", "bytes_src_parent_folder", "bytes_src_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "cid", "uint32_client_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Long.valueOf(0L), "", "", Integer.valueOf(0) }, ForwardDataWireReqBody.class);
    }
  }
  
  public static final class ForwardDataWireRspBody
    extends MessageMicro<ForwardDataWireRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "int32_ret_code", "str_ret_msg", "bytes_uuid", "uint64_total_space" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, Long.valueOf(0L) }, ForwardDataWireRspBody.class);
    }
  }
  
  public static final class ForwardGroupReqBody
    extends MessageMicro<ForwardGroupReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_dst_folder_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_parent_folder = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField cid = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_path = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 66, 74, 82, 90 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_src_bus_id", "bytes_src_parent_folder", "bytes_src_uuid", "bytes_dst_folder_id", "uint64_file_size", "str_local_path", "str_file_name", "bytes_md5", "cid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), "", "", localByteStringMicro4, "" }, ForwardGroupReqBody.class);
    }
  }
  
  public static final class ForwardGroupRspBody
    extends MessageMicro<ForwardGroupRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_save_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "bytes_save_file_path", "uint32_bus_id" }, new Object[] { Integer.valueOf(0), "", "", localByteStringMicro, Integer.valueOf(0) }, ForwardGroupRspBody.class);
    }
  }
  
  public static final class ForwardOfflineFileReqBody
    extends MessageMicro<ForwardOfflineFileReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_parent_folder = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField cid = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_svcid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 66, 72 }, new String[] { "uint32_src_svcid", "bytes_src_parent_folder", "bytes_src_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "cid", "uint32_client_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Long.valueOf(0L), "", "", Integer.valueOf(0) }, ForwardOfflineFileReqBody.class);
    }
  }
  
  public static final class ForwardOfflineFileRspBody
    extends MessageMicro<ForwardOfflineFileRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "int32_ret_code", "str_ret_msg", "bytes_uuid", "uint64_total_space" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, Long.valueOf(0L) }, ForwardOfflineFileRspBody.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "forward_group_req", "forward_offline_req", "forward_data_wire_req" }, new Object[] { null, null, null }, ReqBody.class);
    public oidb_cmd0xd68.ForwardDataWireReqBody forward_data_wire_req = new oidb_cmd0xd68.ForwardDataWireReqBody();
    public oidb_cmd0xd68.ForwardGroupReqBody forward_group_req = new oidb_cmd0xd68.ForwardGroupReqBody();
    public oidb_cmd0xd68.ForwardOfflineFileReqBody forward_offline_req = new oidb_cmd0xd68.ForwardOfflineFileReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "int32_ret_code", "str_internal_err_msg", "forward_group_rsp", "forward_offline_rsp", "forward_data_wire_rsp" }, new Object[] { Integer.valueOf(0), "", null, null, null }, RspBody.class);
    public oidb_cmd0xd68.ForwardDataWireRspBody forward_data_wire_rsp = new oidb_cmd0xd68.ForwardDataWireRspBody();
    public oidb_cmd0xd68.ForwardGroupRspBody forward_group_rsp = new oidb_cmd0xd68.ForwardGroupRspBody();
    public oidb_cmd0xd68.ForwardOfflineFileRspBody forward_offline_rsp = new oidb_cmd0xd68.ForwardOfflineFileRspBody();
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_internal_err_msg = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd68.oidb_cmd0xd68
 * JD-Core Version:    0.7.0.1
 */