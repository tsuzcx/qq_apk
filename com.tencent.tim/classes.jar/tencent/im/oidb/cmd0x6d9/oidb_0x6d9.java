package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.cs.group_file_common.group_file_common.FeedsInfo;
import tencent.im.cs.group_file_common.group_file_common.FeedsResult;

public final class oidb_0x6d9
{
  public static final class CopyFromReqBody
    extends MessageMicro<CopyFromReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_dst_folder_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_parent_folder = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_path = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 64, 74, 82, 88, 98 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_src_bus_id", "bytes_src_parent_folder", "bytes_src_file_path", "uint32_dst_bus_id", "bytes_dst_folder_id", "uint64_file_size", "str_local_path", "str_file_name", "uint64_src_uin", "bytes_md5" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L), "", "", Long.valueOf(0L), localByteStringMicro4 }, CopyFromReqBody.class);
    }
  }
  
  public static final class CopyFromRspBody
    extends MessageMicro<CopyFromRspBody>
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "bytes_save_file_path", "uint32_bus_id" }, new Object[] { Integer.valueOf(0), "", "", localByteStringMicro, Integer.valueOf(0) }, CopyFromRspBody.class);
    }
  }
  
  public static final class CopyToReqBody
    extends MessageMicro<CopyToReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tim_cloud_extension_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tim_cloud_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tim_cloud_ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_new_file_name = PBField.initString("");
    public final PBStringField str_src_file_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tim_file_exist_option = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 322, 802, 810, 818, 824 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_src_bus_id", "str_src_file_id", "uint32_dst_bus_id", "uint64_dst_uin", "str_new_file_name", "bytes_tim_cloud_pdir_key", "bytes_tim_cloud_ppdir_key", "bytes_tim_cloud_extension_info", "uint32_tim_file_exist_option" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, CopyToReqBody.class);
    }
  }
  
  public static final class CopyToRspBody
    extends MessageMicro<CopyToRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 322 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "str_save_file_path", "uint32_bus_id", "str_file_name" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "" }, CopyToRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_save_file_path = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  }
  
  public static final class FeedsReqBody
    extends MessageMicro<FeedsReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_group_code", "uint32_app_id", "rpt_feeds_info_list", "multi_send_seq" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, FeedsReqBody.class);
    public final PBUInt32Field multi_send_seq = PBField.initUInt32(0);
    public final PBRepeatMessageField<group_file_common.FeedsInfo> rpt_feeds_info_list = PBField.initRepeatMessage(group_file_common.FeedsInfo.class);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class FeedsRspBody
    extends MessageMicro<FeedsRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "rpt_feeds_result_list", "uint32_svrbusy_wait_time" }, new Object[] { Integer.valueOf(0), "", "", null, Integer.valueOf(0) }, FeedsRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBRepeatMessageField<group_file_common.FeedsResult> rpt_feeds_result_list = PBField.initRepeatMessage(group_file_common.FeedsResult.class);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_svrbusy_wait_time = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 42 }, new String[] { "trans_file_req", "copy_from_req", "copy_to_req", "feeds_info_req" }, new Object[] { null, null, null, null }, ReqBody.class);
    public oidb_0x6d9.CopyFromReqBody copy_from_req = new oidb_0x6d9.CopyFromReqBody();
    public oidb_0x6d9.CopyToReqBody copy_to_req = new oidb_0x6d9.CopyToReqBody();
    public oidb_0x6d9.FeedsReqBody feeds_info_req = new oidb_0x6d9.FeedsReqBody();
    public oidb_0x6d9.TransFileReqBody trans_file_req = new oidb_0x6d9.TransFileReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 42 }, new String[] { "trans_file_rsp", "copy_from_rsp", "copy_to_rsp", "feeds_info_rsp" }, new Object[] { null, null, null, null }, RspBody.class);
    public oidb_0x6d9.CopyFromRspBody copy_from_rsp = new oidb_0x6d9.CopyFromRspBody();
    public oidb_0x6d9.CopyToRspBody copy_to_rsp = new oidb_0x6d9.CopyToRspBody();
    public oidb_0x6d9.FeedsRspBody feeds_info_rsp = new oidb_0x6d9.FeedsRspBody();
    public oidb_0x6d9.TransFileRspBody trans_file_rsp = new oidb_0x6d9.TransFileRspBody();
  }
  
  public static final class TransFileReqBody
    extends MessageMicro<TransFileReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, TransFileReqBody.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class TransFileRspBody
    extends MessageMicro<TransFileRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "uint32_save_bus_id", "str_save_file_path" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "" }, TransFileRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_save_file_path = PBField.initString("");
    public final PBUInt32Field uint32_save_bus_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d9.oidb_0x6d9
 * JD-Core Version:    0.7.0.1
 */