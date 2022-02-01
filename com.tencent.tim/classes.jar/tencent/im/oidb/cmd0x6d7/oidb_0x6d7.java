package tencent.im.oidb.cmd0x6d7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.cs.group_file_common.group_file_common.FolderInfo;

public final class oidb_0x6d7
{
  public static final class CreateFolderReqBody
    extends MessageMicro<CreateFolderReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_group_code", "uint32_app_id", "str_parent_folder_id", "str_folder_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "" }, CreateFolderReqBody.class);
    public final PBStringField str_folder_name = PBField.initString("");
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class CreateFolderRspBody
    extends MessageMicro<CreateFolderRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "folder_info" }, new Object[] { Integer.valueOf(0), "", "", null }, CreateFolderRspBody.class);
    public group_file_common.FolderInfo folder_info = new group_file_common.FolderInfo();
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class DeleteFolderReqBody
    extends MessageMicro<DeleteFolderReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_group_code", "uint32_app_id", "str_folder_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, DeleteFolderReqBody.class);
    public final PBStringField str_folder_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class DeleteFolderRspBody
    extends MessageMicro<DeleteFolderRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording" }, new Object[] { Integer.valueOf(0), "", "" }, DeleteFolderRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class MoveFolderReqBody
    extends MessageMicro<MoveFolderReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint64_group_code", "uint32_app_id", "str_folder_id", "str_parent_folder_id", "str_dest_folder_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", "" }, MoveFolderReqBody.class);
    public final PBStringField str_dest_folder_id = PBField.initString("");
    public final PBStringField str_folder_id = PBField.initString("");
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class MoveFolderRspBody
    extends MessageMicro<MoveFolderRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "folder_info" }, new Object[] { Integer.valueOf(0), "", "", null }, MoveFolderRspBody.class);
    public group_file_common.FolderInfo folder_info = new group_file_common.FolderInfo();
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class RenameFolderReqBody
    extends MessageMicro<RenameFolderReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_group_code", "uint32_app_id", "str_folder_id", "str_new_folder_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "" }, RenameFolderReqBody.class);
    public final PBStringField str_folder_id = PBField.initString("");
    public final PBStringField str_new_folder_name = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class RenameFolderRspBody
    extends MessageMicro<RenameFolderRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "folder_info" }, new Object[] { Integer.valueOf(0), "", "", null }, RenameFolderRspBody.class);
    public group_file_common.FolderInfo folder_info = new group_file_common.FolderInfo();
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "create_folder_req", "delete_folder_req", "rename_folder_req", "move_folder_req" }, new Object[] { null, null, null, null }, ReqBody.class);
    public oidb_0x6d7.CreateFolderReqBody create_folder_req = new oidb_0x6d7.CreateFolderReqBody();
    public oidb_0x6d7.DeleteFolderReqBody delete_folder_req = new oidb_0x6d7.DeleteFolderReqBody();
    public oidb_0x6d7.MoveFolderReqBody move_folder_req = new oidb_0x6d7.MoveFolderReqBody();
    public oidb_0x6d7.RenameFolderReqBody rename_folder_req = new oidb_0x6d7.RenameFolderReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "create_folder_rsp", "delete_folder_rsp", "rename_folder_rsp", "move_folder_rsp" }, new Object[] { null, null, null, null }, RspBody.class);
    public oidb_0x6d7.CreateFolderRspBody create_folder_rsp = new oidb_0x6d7.CreateFolderRspBody();
    public oidb_0x6d7.DeleteFolderRspBody delete_folder_rsp = new oidb_0x6d7.DeleteFolderRspBody();
    public oidb_0x6d7.MoveFolderRspBody move_folder_rsp = new oidb_0x6d7.MoveFolderRspBody();
    public oidb_0x6d7.RenameFolderRspBody rename_folder_rsp = new oidb_0x6d7.RenameFolderRspBody();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d7.oidb_0x6d7
 * JD-Core Version:    0.7.0.1
 */