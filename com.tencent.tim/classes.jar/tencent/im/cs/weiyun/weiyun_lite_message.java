package tencent.im.cs.weiyun;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class weiyun_lite_message
{
  public static final class BatchOpDirRename
    extends MessageMicro<BatchOpDirRename>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField dir_name = PBField.initString("");
    public final PBStringField pdir_key = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 58 }, new String[] { "dir_key", "dir_name", "pdir_key" }, new Object[] { localByteStringMicro, "", "" }, BatchOpDirRename.class);
    }
  }
  
  public static final class BatchOpFileRename
    extends MessageMicro<BatchOpFileRename>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 74 }, new String[] { "file_id", "filename", "pdir_key" }, new Object[] { "", "", "" }, BatchOpFileRename.class);
    public final PBStringField file_id = PBField.initString("");
    public final PBStringField filename = PBField.initString("");
    public final PBStringField pdir_key = PBField.initString("");
  }
  
  public static final class CrossBidProxyCopyFileToOtherBidMsgReq
    extends MessageMicro<CrossBidProxyCopyFileToOtherBidMsgReq>
  {
    public static final int GROUP_USER = 1;
    public static final int NORMAL_USER = 0;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field dst_bid = PBField.initUInt32(0);
    public final PBUInt64Field dst_uin = PBField.initUInt64(0L);
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField file_name = PBField.initString("");
    public final PBStringField file_sha = PBField.initString("");
    public final PBUInt64Field file_size = PBField.initUInt64(0L);
    public final PBUInt32Field src_bid = PBField.initUInt32(0);
    public final PBStringField src_file_id = PBField.initString("");
    public final PBUInt64Field src_group = PBField.initUInt64(0L);
    public final PBBytesField src_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field src_uin = PBField.initUInt64(0L);
    public final PBEnumField user_type = PBField.initEnum(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 160, 168, 176, 242, 250, 800, 810, 818, 826, 1600, 1608 }, new String[] { "user_type", "src_bid", "src_uin", "src_group", "src_pdir_key", "src_file_id", "file_size", "file_md5", "file_name", "file_sha", "dst_bid", "dst_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, "", Long.valueOf(0L), localByteStringMicro2, "", "", Integer.valueOf(0), Long.valueOf(0L) }, CrossBidProxyCopyFileToOtherBidMsgReq.class);
    }
  }
  
  public static final class CrossBidProxyCopyFileToOtherBidMsgRsp
    extends MessageMicro<CrossBidProxyCopyFileToOtherBidMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dst_path = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dst_path" }, new Object[] { localByteStringMicro }, CrossBidProxyCopyFileToOtherBidMsgRsp.class);
    }
  }
  
  public static final class DirFileDupItem
    extends MessageMicro<DirFileDupItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public static final int dup_dir = 2;
    public static final int dup_file = 1;
    public final PBInt32Field conflict_type = PBField.initInt32(0);
    public final PBBytesField dup_dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field file_attr = PBField.initUInt32(0);
    public final PBUInt64Field file_attr_mtime = PBField.initUInt64(0L);
    public final PBInt64Field file_ctime = PBField.initInt64(0L);
    public final PBInt64Field file_cursize = PBField.initInt64(0L);
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_mtime = PBField.initUInt64(0L);
    public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field file_size = PBField.initInt64(0L);
    public final PBUInt32Field file_version = PBField.initUInt32(0);
    public final PBStringField filename = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66, 72, 82, 96, 170, 176, 184 }, new String[] { "conflict_type", "pdir_key", "file_id", "file_ctime", "file_size", "file_cursize", "file_sha", "file_md5", "file_attr", "filename", "file_version", "dup_dir_key", "file_mtime", "file_attr_mtime" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro4, Long.valueOf(0L), Long.valueOf(0L) }, DirFileDupItem.class);
    }
  }
  
  public static final class DirItem
    extends MessageMicro<DirItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt64Field dir_ctime = PBField.initInt64(0L);
    public final PBStringField dir_icon = PBField.initString("");
    public final PBBytesField dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field dir_mtime = PBField.initInt64(0L);
    public final PBStringField dir_name = PBField.initString("");
    public final PBUInt32Field dir_status = PBField.initUInt32(0);
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 50, 56, 98 }, new String[] { "dir_key", "dir_name", "dir_ctime", "dir_mtime", "pdir_key", "dir_status", "dir_icon" }, new Object[] { localByteStringMicro1, "", Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), "" }, DirItem.class);
    }
  }
  
  public static final class DiskDirAttrModifyMsgReq
    extends MessageMicro<DiskDirAttrModifyMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField dst_dir_name = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField src_dir_name = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 50 }, new String[] { "ppdir_key", "pdir_key", "dir_key", "dst_dir_name", "src_dir_name" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, "", "" }, DiskDirAttrModifyMsgReq.class);
    }
  }
  
  public static final class DiskDirAttrModifyMsgRsp
    extends MessageMicro<DiskDirAttrModifyMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "pdir_mtime" }, new Object[] { Long.valueOf(0L) }, DiskDirAttrModifyMsgRsp.class);
    public final PBUInt64Field pdir_mtime = PBField.initUInt64(0L);
  }
  
  public static final class DiskDirCreateMsgReq
    extends MessageMicro<DiskDirCreateMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField dir_name = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ppdir_key", "pdir_key", "dir_name" }, new Object[] { localByteStringMicro1, localByteStringMicro2, "" }, DiskDirCreateMsgReq.class);
    }
  }
  
  public static final class DiskDirCreateMsgRsp
    extends MessageMicro<DiskDirCreateMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field dir_ctime = PBField.initUInt64(0L);
    public final PBBytesField dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field dir_mtime = PBField.initUInt64(0L);
    public final PBStringField dir_name = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "dir_key", "dir_name", "dir_ctime", "dir_mtime" }, new Object[] { localByteStringMicro, "", Long.valueOf(0L), Long.valueOf(0L) }, DiskDirCreateMsgRsp.class);
    }
  }
  
  public static final class DiskDirFileBatchDeleteExMsgReq
    extends MessageMicro<DiskDirFileBatchDeleteExMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "dir_list", "file_list" }, new Object[] { null, null }, DiskDirFileBatchDeleteExMsgReq.class);
    public final PBRepeatMessageField<weiyun_lite_message.DiskSimpleDirItem> dir_list = PBField.initRepeatMessage(weiyun_lite_message.DiskSimpleDirItem.class);
    public final PBRepeatMessageField<weiyun_lite_message.DiskSimpleFileItem> file_list = PBField.initRepeatMessage(weiyun_lite_message.DiskSimpleFileItem.class);
  }
  
  public static final class DiskDirFileBatchDeleteExMsgRsp
    extends MessageMicro<DiskDirFileBatchDeleteExMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 34 }, new String[] { "dir_list", "file_list" }, new Object[] { null, null }, DiskDirFileBatchDeleteExMsgRsp.class);
    public final PBRepeatMessageField<weiyun_lite_message.DiskSimpleDirItemResult> dir_list = PBField.initRepeatMessage(weiyun_lite_message.DiskSimpleDirItemResult.class);
    public final PBRepeatMessageField<weiyun_lite_message.DiskSimpleFileItemResult> file_list = PBField.initRepeatMessage(weiyun_lite_message.DiskSimpleFileItemResult.class);
  }
  
  public static final class DiskDirFileBatchMoveMsgReq
    extends MessageMicro<DiskDirFileBatchMoveMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<weiyun_lite_message.BatchOpDirRename> dir_list = PBField.initRepeatMessage(weiyun_lite_message.BatchOpDirRename.class);
    public final PBBytesField dst_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField dst_ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<weiyun_lite_message.BatchOpFileRename> file_list = PBField.initRepeatMessage(weiyun_lite_message.BatchOpFileRename.class);
    public final PBBytesField src_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField src_ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "src_ppdir_key", "src_pdir_key", "dir_list", "file_list", "dst_ppdir_key", "dst_pdir_key" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, null, localByteStringMicro3, localByteStringMicro4 }, DiskDirFileBatchMoveMsgReq.class);
    }
  }
  
  public static final class DiskDirFileBatchMoveMsgRsp
    extends MessageMicro<DiskDirFileBatchMoveMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 34 }, new String[] { "dir_list", "file_list" }, new Object[] { null, null }, DiskDirFileBatchMoveMsgRsp.class);
    public final PBRepeatMessageField<weiyun_lite_message.DiskSimpleDirItemResult> dir_list = PBField.initRepeatMessage(weiyun_lite_message.DiskSimpleDirItemResult.class);
    public final PBRepeatMessageField<weiyun_lite_message.DiskSimpleFileItemResult> file_list = PBField.initRepeatMessage(weiyun_lite_message.DiskSimpleFileItemResult.class);
  }
  
  public static final class DiskDirFileInfoListMsgReq
    extends MessageMicro<DiskDirFileInfoListMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField dir_name = PBField.initString("");
    public final PBBoolField get_abstract_url = PBField.initBool(false);
    public final PBInt32Field load_type = PBField.initInt32(0);
    public final PBStringField local_version = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 48 }, new String[] { "dir_key", "dir_name", "load_type", "local_version", "get_abstract_url" }, new Object[] { localByteStringMicro, "", Integer.valueOf(0), "", Boolean.valueOf(false) }, DiskDirFileInfoListMsgReq.class);
    }
  }
  
  public static final class DiskDirFileInfoListMsgRsp
    extends MessageMicro<DiskDirFileInfoListMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "finish_flag", "overflow_flag", "server_version", "FileItem_items", "DirItem_items" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), "", null, null }, DiskDirFileInfoListMsgRsp.class);
    public final PBRepeatMessageField<weiyun_lite_message.DirItem> DirItem_items = PBField.initRepeatMessage(weiyun_lite_message.DirItem.class);
    public final PBRepeatMessageField<weiyun_lite_message.FileItem> FileItem_items = PBField.initRepeatMessage(weiyun_lite_message.FileItem.class);
    public final PBBoolField finish_flag = PBField.initBool(false);
    public final PBBoolField overflow_flag = PBField.initBool(false);
    public final PBStringField server_version = PBField.initString("");
  }
  
  public static final class DiskFileBatchDownloadMsgReq
    extends MessageMicro<DiskFileBatchDownloadMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "file_list", "file_owner", "need_thumb", "download_type" }, new Object[] { null, Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0) }, DiskFileBatchDownloadMsgReq.class);
    public final PBUInt32Field download_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<weiyun_lite_message.DiskSimpleFileItem> file_list = PBField.initRepeatMessage(weiyun_lite_message.DiskSimpleFileItem.class);
    public final PBUInt64Field file_owner = PBField.initUInt64(0L);
    public final PBBoolField need_thumb = PBField.initBool(false);
  }
  
  public static final class DiskFileBatchDownloadMsgRsp
    extends MessageMicro<DiskFileBatchDownloadMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "file_list" }, new Object[] { null }, DiskFileBatchDownloadMsgRsp.class);
    public final PBRepeatMessageField<weiyun_lite_message.DiskFileDownloadRspItem> file_list = PBField.initRepeatMessage(weiyun_lite_message.DiskFileDownloadRspItem.class);
  }
  
  public static final class DiskFileCopyMsgReq
    extends MessageMicro<DiskFileCopyMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField additional_space = PBField.initBool(true);
    public final PBBoolField auto_create_user = PBField.initBool(false);
    public final PBStringField batch_id = PBField.initString("");
    public final PBUInt32Field control_check_type = PBField.initUInt32(1);
    public final PBStringField dst_filename = PBField.initString("");
    public final PBBytesField dst_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField dst_ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public weiyun_lite_message.FileExtInfo ext_info = new weiyun_lite_message.FileExtInfo();
    public final PBUInt32Field file_exist_option = PBField.initUInt32(0);
    public final PBStringField file_id = PBField.initString("");
    public final PBStringField src_filename = PBField.initString("");
    public final PBBytesField src_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field src_uin = PBField.initUInt64(0L);
    public final PBBoolField to_bypass = PBField.initBool(true);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 64, 72, 80, 88, 96, 104, 114, 170 }, new String[] { "src_pdir_key", "file_id", "dst_ppdir_key", "dst_pdir_key", "src_filename", "dst_filename", "additional_space", "src_uin", "file_exist_option", "auto_create_user", "to_bypass", "control_check_type", "ext_info", "batch_id" }, new Object[] { localByteStringMicro1, "", localByteStringMicro2, localByteStringMicro3, "", "", Boolean.valueOf(true), Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(true), Integer.valueOf(1), null, "" }, DiskFileCopyMsgReq.class);
    }
  }
  
  public static final class DiskFileCopyMsgRsp
    extends MessageMicro<DiskFileCopyMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field dst_pdir_mtime = PBField.initUInt64(0L);
    public weiyun_lite_message.DirFileDupItem dup_item = new weiyun_lite_message.DirFileDupItem();
    public final PBUInt64Field file_ctime = PBField.initUInt64(0L);
    public final PBStringField file_id = PBField.initString("");
    public weiyun_lite_message.FileItem file_item = new weiyun_lite_message.FileItem();
    public final PBStringField filename = PBField.initString("");
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBStringField src_file_id = PBField.initString("");
    public final PBBytesField src_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58, 64, 74, 170 }, new String[] { "src_pdir_key", "src_file_id", "file_id", "filename", "file_ctime", "dst_pdir_mtime", "dup_item", "retcode", "file_item", "retmsg" }, new Object[] { localByteStringMicro, "", "", "", Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), null, "" }, DiskFileCopyMsgRsp.class);
    }
  }
  
  public static final class DiskFileDownloadRspItem
    extends MessageMicro<DiskFileDownloadRspItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field channel_count = PBField.initUInt32(0);
    public final PBStringField cookie_name = PBField.initString("");
    public final PBStringField cookie_value = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
    public final PBBytesField encode_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_mtime = PBField.initUInt64(0L);
    public final PBStringField inside_download_ip = PBField.initString("");
    public final PBStringField outside_download_ip = PBField.initString("");
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBStringField server_name = PBField.initString("");
    public final PBUInt32Field server_port = PBField.initUInt32(0);
    public final PBStringField video_url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 90, 98, 106, 170, 200 }, new String[] { "retcode", "encode_url", "server_name", "server_port", "cookie_name", "cookie_value", "file_id", "file_md5", "video_url", "file_mtime", "inside_download_ip", "outside_download_ip", "download_url", "retmsg", "channel_count" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, "", Integer.valueOf(0), "", "", "", localByteStringMicro2, "", Long.valueOf(0L), "", "", "", "", Integer.valueOf(0) }, DiskFileDownloadRspItem.class);
    }
  }
  
  public static final class DiskFileRenameMsgReq
    extends MessageMicro<DiskFileRenameMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField file_id = PBField.initString("");
    public final PBStringField filename = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField src_filename = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 50 }, new String[] { "ppdir_key", "pdir_key", "file_id", "filename", "src_filename" }, new Object[] { localByteStringMicro1, localByteStringMicro2, "", "", "" }, DiskFileRenameMsgReq.class);
    }
  }
  
  public static final class DiskFileRenameMsgRsp
    extends MessageMicro<DiskFileRenameMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "pdir_mtime" }, new Object[] { Long.valueOf(0L) }, DiskFileRenameMsgRsp.class);
    public final PBUInt64Field pdir_mtime = PBField.initUInt64(0L);
  }
  
  public static final class DiskFileUploadMsgReq
    extends MessageMicro<DiskFileUploadMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField app_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField auto_create_user = PBField.initBool(false);
    public final PBStringField batch_id = PBField.initString("");
    public weiyun_lite_message.FileExtInfo ext_info = new weiyun_lite_message.FileExtInfo();
    public final PBUInt64Field file_attr = PBField.initUInt64(0L);
    public final PBUInt64Field file_attr_mtime = PBField.initUInt64(0L);
    public final PBUInt32Field file_exist_option = PBField.initUInt32(0);
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_size = PBField.initUInt64(0L);
    public final PBStringField filename = PBField.initString("");
    public final PBUInt32Field first_256k_crc = PBField.initUInt32(0);
    public final PBUInt32Field history_ctime = PBField.initUInt32(0);
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field upload_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72, 88, 96, 104, 112, 122, 170, 178 }, new String[] { "ppdir_key", "pdir_key", "filename", "file_sha", "file_md5", "file_size", "file_attr_mtime", "file_attr", "upload_type", "history_ctime", "file_exist_option", "first_256k_crc", "auto_create_user", "app_data", "ext_info", "batch_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, "", localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro5, null, "" }, DiskFileUploadMsgReq.class);
    }
  }
  
  public static final class DiskFileUploadMsgRsp
    extends MessageMicro<DiskFileUploadMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field channel_count = PBField.initUInt32(0);
    public final PBBytesField check_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_attr_mtime = PBField.initUInt64(0L);
    public final PBUInt64Field file_ctime = PBField.initUInt64(0L);
    public final PBBoolField file_exist = PBField.initBool(false);
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_mtime = PBField.initUInt64(0L);
    public final PBUInt32Field file_version = PBField.initUInt32(0);
    public final PBStringField filename = PBField.initString("");
    public final PBStringField inside_upload_ip = PBField.initString("10.130.69.41");
    public final PBUInt32Field lib_id = PBField.initUInt32(0);
    public final PBStringField outside_upload_ip = PBField.initString("");
    public final PBUInt64Field pdir_mtime = PBField.initUInt64(0L);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField server_name = PBField.initString("");
    public final PBUInt32Field server_port = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 64, 72, 82, 90, 98, 128, 176, 184, 192, 200 }, new String[] { "file_id", "filename", "file_ctime", "pdir_mtime", "server_name", "server_port", "check_key", "file_exist", "file_version", "file_key", "inside_upload_ip", "outside_upload_ip", "lib_id", "retcode", "file_mtime", "file_attr_mtime", "channel_count" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro1, Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro2, "10.130.69.41", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, DiskFileUploadMsgRsp.class);
    }
  }
  
  public static final class DiskSimpleDirItem
    extends MessageMicro<DiskSimpleDirItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField dir_name = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 34, 42 }, new String[] { "dir_key", "dir_name", "ppdir_key", "pdir_key" }, new Object[] { localByteStringMicro1, "", localByteStringMicro2, localByteStringMicro3 }, DiskSimpleDirItem.class);
    }
  }
  
  public static final class DiskSimpleDirItemResult
    extends MessageMicro<DiskSimpleDirItemResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 34, 42, 170 }, new String[] { "dir_key", "retcode", "ppdir_key", "pdir_key", "retmsg" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, "" }, DiskSimpleDirItemResult.class);
    }
  }
  
  public static final class DiskSimpleFileItem
    extends MessageMicro<DiskSimpleFileItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField file_id = PBField.initString("");
    public final PBStringField filename = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 58 }, new String[] { "file_id", "filename", "pdir_key", "ppdir_key" }, new Object[] { "", "", localByteStringMicro1, localByteStringMicro2 }, DiskSimpleFileItem.class);
    }
  }
  
  public static final class DiskSimpleFileItemResult
    extends MessageMicro<DiskSimpleFileItemResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 170 }, new String[] { "file_id", "retcode", "retmsg" }, new Object[] { "", Integer.valueOf(0), "" }, DiskSimpleFileItemResult.class);
    public final PBStringField file_id = PBField.initString("");
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
  }
  
  public static final class DiskUserInfoGetMsgReq
    extends MessageMicro<DiskUserInfoGetMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 128, 136, 152, 176 }, new String[] { "flash_image_width", "flash_image_height", "is_get_upload_flow_flag", "is_get_weiyun_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false) }, DiskUserInfoGetMsgReq.class);
    public final PBUInt32Field flash_image_height = PBField.initUInt32(0);
    public final PBUInt32Field flash_image_width = PBField.initUInt32(0);
    public final PBBoolField is_get_upload_flow_flag = PBField.initBool(false);
    public final PBBoolField is_get_weiyun_flag = PBField.initBool(false);
  }
  
  public static final class DiskUserInfoGetMsgRsp
    extends MessageMicro<DiskUserInfoGetMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField agreement_url = PBField.initString("");
    public final PBUInt64Field dir_total = PBField.initUInt64(0L);
    public final PBStringField faq_url = PBField.initString("");
    public final PBUInt64Field file_total = PBField.initUInt64(0L);
    public final PBStringField flash_click_url = PBField.initString("");
    public final PBBoolField flash_enable_click = PBField.initBool(false);
    public final PBInt64Field flash_end_time = PBField.initInt64(0L);
    public final PBStringField flash_image_url = PBField.initString("");
    public final PBInt64Field flash_show_duration = PBField.initInt64(2000L);
    public final PBInt64Field flash_start_time = PBField.initInt64(0L);
    public final PBStringField head_img_url = PBField.initString("");
    public final PBUInt64Field index_number = PBField.initUInt64(0L);
    public final PBBoolField is_pwd_open = PBField.initBool(false);
    public final PBBytesField main_dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field max_batch_dir_clear_number = PBField.initUInt32(0);
    public final PBUInt32Field max_batch_dir_delete_number = PBField.initUInt32(0);
    public final PBUInt32Field max_batch_dir_move_number = PBField.initUInt32(0);
    public final PBUInt32Field max_batch_dir_restore_number = PBField.initUInt32(0);
    public final PBUInt32Field max_batch_file_clear_number = PBField.initUInt32(0);
    public final PBUInt32Field max_batch_file_delete_number = PBField.initUInt32(0);
    public final PBUInt32Field max_batch_file_move_number = PBField.initUInt32(0);
    public final PBUInt32Field max_batch_file_restore_number = PBField.initUInt32(0);
    public final PBUInt32Field max_dir_layer_number = PBField.initUInt32(0);
    public final PBUInt32Field max_dir_name_length = PBField.initUInt32(0);
    public final PBUInt32Field max_filename_length = PBField.initUInt32(0);
    public final PBStringField nick_name = PBField.initString("");
    public final PBStringField offline_faq_url = PBField.initString("");
    public final PBUInt64Field plugin_switch_flag = PBField.initUInt64(0L);
    public final PBStringField pwd_forget_url = PBField.initString("");
    public weiyun_lite_message.QdiskFlowInfo qdisk_flow_info = new weiyun_lite_message.QdiskFlowInfo();
    public final PBStringField recommend_apps_url = PBField.initString("");
    public final PBBytesField root_dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field server_time = PBField.initInt64(0L);
    public final PBBytesField tim_0_dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField tim_1_dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field total_space = PBField.initUInt64(0L);
    public final PBInt64Field uin = PBField.initInt64(0L);
    public final PBUInt64Field used_space = PBField.initUInt64(0L);
    public final PBUInt64Field user_ctime = PBField.initUInt64(0L);
    public final PBUInt64Field user_mtime = PBField.initUInt64(0L);
    public weiyun_lite_message.WeiyunVipInfo weiyun_vip_info = new weiyun_lite_message.WeiyunVipInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 40, 56, 64, 80, 88, 96, 104, 112, 122, 130, 136, 144, 152, 170, 184, 194, 210, 218, 328, 336, 344, 352, 376, 384, 488, 496, 568, 728, 736, 746, 752, 762, 768, 962, 970, 978, 986, 994, 1842, 2002 }, new String[] { "max_dir_layer_number", "server_time", "max_filename_length", "max_dir_name_length", "plugin_switch_flag", "user_ctime", "user_mtime", "index_number", "used_space", "root_dir_key", "main_dir_key", "total_space", "dir_total", "file_total", "nick_name", "uin", "head_img_url", "tim_0_dir_key", "tim_1_dir_key", "max_batch_dir_delete_number", "max_batch_file_delete_number", "max_batch_dir_move_number", "max_batch_file_move_number", "max_batch_dir_restore_number", "max_batch_file_restore_number", "max_batch_dir_clear_number", "max_batch_file_clear_number", "is_pwd_open", "flash_start_time", "flash_end_time", "flash_image_url", "flash_enable_click", "flash_click_url", "flash_show_duration", "recommend_apps_url", "faq_url", "offline_faq_url", "agreement_url", "pwd_forget_url", "qdisk_flow_info", "weiyun_vip_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", Long.valueOf(0L), "", localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), "", Boolean.valueOf(false), "", Long.valueOf(2000L), "", "", "", "", "", null, null }, DiskUserInfoGetMsgRsp.class);
    }
  }
  
  public static final class ExtReqHead
    extends MessageMicro<ExtReqHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field business_appid = PBField.initUInt32(0);
    public final PBStringField channel_dev_id = PBField.initString("");
    public final PBUInt64Field channel_id = PBField.initUInt64(0L);
    public final PBStringField device_id = PBField.initString("");
    public final PBStringField device_mac = PBField.initString("");
    public final PBStringField localip = PBField.initString("");
    public final PBBytesField login_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field login_keytype = PBField.initInt32(0);
    public final PBStringField phone_number = PBField.initString("");
    public final PBUInt32Field service_ip = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 66, 88, 98 }, new String[] { "device_mac", "device_id", "phone_number", "localip", "business_appid", "service_ip", "channel_id", "channel_dev_id", "login_keytype", "login_key" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro }, ExtReqHead.class);
    }
  }
  
  public static final class FileExtInfo
    extends MessageMicro<FileExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField album = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBBoolField backup_flag = PBField.initBool(false);
    public final PBBoolField bool_ftn_to_qcloud_auto_req = PBField.initBool(false);
    public final PBBytesField bytes_tim_cloud_addtional_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField cookie_name = PBField.initString("");
    public final PBStringField cookie_value = PBField.initString("");
    public final PBStringField dev_mac = PBField.initString("");
    public final PBStringField dev_name = PBField.initString("");
    public final PBStringField dev_os = PBField.initString("");
    public final PBInt32Field dev_show_type = PBField.initInt32(0);
    public final PBStringField dev_type = PBField.initString("");
    public final PBInt32Field ext_status = PBField.initInt32(0);
    public final PBInt32Field from_source = PBField.initInt32(0);
    public final PBInt32Field group_id = PBField.initInt32(1);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBDoubleField latitude = PBField.initDouble(0.0D);
    public final PBInt64Field long_time = PBField.initInt64(0L);
    public final PBDoubleField longitude = PBField.initDouble(0.0D);
    public final PBBytesField org_file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field org_file_size = PBField.initUInt64(0L);
    public final PBUInt32Field orientation = PBField.initUInt32(0);
    public final PBBytesField origin_pic_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField singer = PBField.initString("");
    public final PBStringField take_dev_type = PBField.initString("");
    public final PBInt64Field take_time = PBField.initInt64(0L);
    public final PBStringField thumb_url = PBField.initString("");
    public final PBUInt32Field upload_appid = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 74, 88, 106, 114, 122, 160, 168, 177, 185, 192, 200, 216, 224, 232, 242, 248, 330, 338, 408, 418, 728, 8010, 8016 }, new String[] { "dev_mac", "dev_show_type", "dev_type", "dev_name", "dev_os", "app_name", "take_dev_type", "backup_flag", "thumb_url", "cookie_name", "cookie_value", "ext_status", "take_time", "longitude", "latitude", "group_id", "from_source", "width", "height", "org_file_size", "org_file_sha", "orientation", "singer", "album", "upload_appid", "origin_pic_sha", "long_time", "bytes_tim_cloud_addtional_info", "bool_ftn_to_qcloud_auto_req" }, new Object[] { "", Integer.valueOf(0), "", "", "", "", "", Boolean.valueOf(false), "", "", "", Integer.valueOf(0), Long.valueOf(0L), Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), "", "", Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Boolean.valueOf(false) }, FileExtInfo.class);
    }
  }
  
  public static final class FileItem
    extends MessageMicro<FileItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public static final int file_lib_id_CloudAlbum = 24;
    public static final int file_lib_id_Document = 1;
    public static final int file_lib_id_Music = 3;
    public static final int file_lib_id_Other = 5;
    public static final int file_lib_id_Photo = 2;
    public static final int file_lib_id_Video = 4;
    public final PBBytesField app_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField app_name = PBField.initString("");
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField batch_id = PBField.initString("");
    public final PBInt64Field diff_version = PBField.initInt64(0L);
    public weiyun_lite_message.FileExtInfo ext_info = new weiyun_lite_message.FileExtInfo();
    public final PBUInt64Field file_attr = PBField.initUInt64(0L);
    public final PBUInt64Field file_attr_mtime = PBField.initUInt64(0L);
    public final PBInt64Field file_ctime = PBField.initInt64(0L);
    public final PBInt64Field file_cursize = PBField.initInt64(0L);
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field file_mtime = PBField.initInt64(0L);
    public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field file_size = PBField.initInt64(0L);
    public final PBUInt32Field file_status = PBField.initUInt32(0);
    public final PBUInt32Field file_version = PBField.initUInt32(0);
    public final PBStringField filename = PBField.initString("");
    public final PBBoolField has_been_deleted = PBField.initBool(false);
    public final PBInt32Field lib_id = PBField.initInt32(0);
    public final PBInt32Field op_retcode = PBField.initInt32(0);
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField pdir_name = PBField.initString("");
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field star_flag = PBField.initInt32(0);
    public final PBInt64Field star_time = PBField.initInt64(0L);
    public final PBUInt32Field video_transcode_state = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 56, 64, 72, 80, 88, 96, 106, 112, 122, 130, 136, 144, 152, 160, 170, 176, 184, 242, 402, 808, 818 }, new String[] { "file_id", "filename", "file_size", "file_cursize", "file_sha", "file_md5", "file_ctime", "file_mtime", "file_attr", "file_version", "file_attr_mtime", "appid", "app_name", "file_status", "ppdir_key", "pdir_key", "star_flag", "diff_version", "star_time", "has_been_deleted", "ext_info", "lib_id", "video_transcode_state", "app_data", "pdir_name", "op_retcode", "batch_id" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, "", Integer.valueOf(0), "" }, FileItem.class);
    }
  }
  
  public static final class LibInfoListGetMsgReq
    extends MessageMicro<LibInfoListGetMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 242, 320, 400 }, new String[] { "lib_id", "load_type", "local_version", "count", "group_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, LibInfoListGetMsgReq.class);
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBInt32Field group_id = PBField.initInt32(0);
    public final PBInt32Field lib_id = PBField.initInt32(0);
    public final PBInt32Field load_type = PBField.initInt32(0);
    public final PBStringField local_version = PBField.initString("");
  }
  
  public static final class LibInfoListGetMsgRsp
    extends MessageMicro<LibInfoListGetMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 242, 322 }, new String[] { "finish_flag", "overflow_flag", "server_version", "FileItem_items" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), "", null }, LibInfoListGetMsgRsp.class);
    public final PBRepeatMessageField<weiyun_lite_message.FileItem> FileItem_items = PBField.initRepeatMessage(weiyun_lite_message.FileItem.class);
    public final PBInt32Field finish_flag = PBField.initInt32(0);
    public final PBBoolField overflow_flag = PBField.initBool(false);
    public final PBStringField server_version = PBField.initString("");
  }
  
  public static final class LibListNumGetMsgReq
    extends MessageMicro<LibListNumGetMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ext_name_flag" }, new Object[] { Integer.valueOf(0) }, LibListNumGetMsgReq.class);
    public final PBInt32Field ext_name_flag = PBField.initInt32(0);
  }
  
  public static final class LibListNumGetMsgRsp
    extends MessageMicro<LibListNumGetMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "LibViewItem_items" }, new Object[] { null }, LibListNumGetMsgRsp.class);
    public final PBRepeatMessageField<weiyun_lite_message.LibViewItem> LibViewItem_items = PBField.initRepeatMessage(weiyun_lite_message.LibViewItem.class);
  }
  
  public static final class LibViewItem
    extends MessageMicro<LibViewItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "lib_id", "lib_name", "total_count" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, LibViewItem.class);
    public final PBInt32Field lib_id = PBField.initInt32(0);
    public final PBStringField lib_name = PBField.initString("");
    public final PBInt32Field total_count = PBField.initInt32(0);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ReqMsg_body", "RspMsg_body" }, new Object[] { null, null }, MsgBody.class);
    public weiyun_lite_message.ReqMsgBody ReqMsg_body = new weiyun_lite_message.ReqMsgBody();
    public weiyun_lite_message.RspMsgBody RspMsg_body = new weiyun_lite_message.RspMsgBody();
  }
  
  public static final class MsgHead
    extends MessageMicro<MsgHead>
  {
    public static final int ReqMsg = 1;
    public static final int RspMsg = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBUInt32Field client_port = PBField.initUInt32(0);
    public final PBStringField clientip = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBStringField device_info = PBField.initString("");
    public final PBInt32Field emulator_flag = PBField.initInt32(0);
    public final PBInt32Field encrypt = PBField.initInt32(0);
    public final PBBytesField encryptkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field fix_version = PBField.initInt32(0);
    public final PBInt32Field keytype = PBField.initInt32(0);
    public final PBInt32Field major_version = PBField.initInt32(0);
    public final PBInt32Field minor_version = PBField.initInt32(0);
    public final PBInt32Field nettype = PBField.initInt32(0);
    public final PBStringField qua = PBField.initString("");
    public final PBStringField redirect_url = PBField.initString("");
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field src_client_id = PBField.initUInt32(0);
    public final PBInt32Field src_module_id = PBField.initInt32(0);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBInt64Field uin = PBField.initInt64(0L);
    public final PBInt32Field version = PBField.initInt32(0);
    public final PBInt32Field zip_flag = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72, 80, 90, 112, 120, 128, 136, 146, 152, 168, 328, 408, 416, 650, 808, 818, 826 }, new String[] { "uin", "seq", "type", "cmd", "appid", "version", "nettype", "clientip", "encrypt", "keytype", "encryptkey", "major_version", "minor_version", "emulator_flag", "zip_flag", "qua", "fix_version", "src_module_id", "bid", "client_port", "src_client_id", "device_info", "retcode", "retmsg", "redirect_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", "" }, MsgHead.class);
    }
  }
  
  public static final class OdAddUrlTaskMsgReq
    extends MessageMicro<OdAddUrlTaskMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82 }, new String[] { "url" }, new Object[] { "" }, OdAddUrlTaskMsgReq.class);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class OdAddUrlTaskMsgRsp
    extends MessageMicro<OdAddUrlTaskMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80 }, new String[] { "is_magnet_url" }, new Object[] { Boolean.valueOf(false) }, OdAddUrlTaskMsgRsp.class);
    public final PBBoolField is_magnet_url = PBField.initBool(false);
  }
  
  public static final class OdClearTaskListMsgReq
    extends MessageMicro<OdClearTaskListMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dummy = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dummy" }, new Object[] { localByteStringMicro }, OdClearTaskListMsgReq.class);
    }
  }
  
  public static final class OdClearTaskListMsgRsp
    extends MessageMicro<OdClearTaskListMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dummy = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dummy" }, new Object[] { localByteStringMicro }, OdClearTaskListMsgRsp.class);
    }
  }
  
  public static final class OdContinueTaskMsgReq
    extends MessageMicro<OdContinueTaskMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80 }, new String[] { "task_id" }, new Object[] { Long.valueOf(0L) }, OdContinueTaskMsgReq.class);
    public final PBRepeatField<Long> task_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class OdContinueTaskMsgRsp
    extends MessageMicro<OdContinueTaskMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dummy = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dummy" }, new Object[] { localByteStringMicro }, OdContinueTaskMsgRsp.class);
    }
  }
  
  public static final class OdDelTaskItemMsgReq
    extends MessageMicro<OdDelTaskItemMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80 }, new String[] { "task_id" }, new Object[] { Long.valueOf(0L) }, OdDelTaskItemMsgReq.class);
    public final PBRepeatField<Long> task_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class OdDelTaskItemMsgRsp
    extends MessageMicro<OdDelTaskItemMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80 }, new String[] { "task_id" }, new Object[] { Long.valueOf(0L) }, OdDelTaskItemMsgRsp.class);
    public final PBRepeatField<Long> task_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class OdGetTaskListMsgReq
    extends MessageMicro<OdGetTaskListMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dummy = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dummy" }, new Object[] { localByteStringMicro }, OdGetTaskListMsgReq.class);
    }
  }
  
  public static final class OdGetTaskListMsgRsp
    extends MessageMicro<OdGetTaskListMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82 }, new String[] { "task_list" }, new Object[] { null }, OdGetTaskListMsgRsp.class);
    public final PBRepeatMessageField<weiyun_lite_message.TaskInfo> task_list = PBField.initRepeatMessage(weiyun_lite_message.TaskInfo.class);
  }
  
  public static final class PwdQueryMsgReq
    extends MessageMicro<PwdQueryMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dummy = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dummy" }, new Object[] { localByteStringMicro }, PwdQueryMsgReq.class);
    }
  }
  
  public static final class PwdQueryMsgRsp
    extends MessageMicro<PwdQueryMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "pwd_open" }, new Object[] { Boolean.valueOf(false) }, PwdQueryMsgRsp.class);
    public final PBBoolField pwd_open = PBField.initBool(false);
  }
  
  public static final class PwdVerifyMsgReq
    extends MessageMicro<PwdVerifyMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cs_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pwd_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "pwd_md5", "cs_sig" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, PwdVerifyMsgReq.class);
    }
  }
  
  public static final class PwdVerifyMsgRsp
    extends MessageMicro<PwdVerifyMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cs_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "cs_sig" }, new Object[] { localByteStringMicro }, PwdVerifyMsgRsp.class);
    }
  }
  
  public static final class QdiskFlowInfo
    extends MessageMicro<QdiskFlowInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "flow_every_day_max_upload_size", "flow_has_upload_size" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, QdiskFlowInfo.class);
    public final PBInt64Field flow_every_day_max_upload_size = PBField.initInt64(0L);
    public final PBInt64Field flow_has_upload_size = PBField.initInt64(0L);
  }
  
  public static final class ReqMsgBody
    extends MessageMicro<ReqMsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 17610, 17778, 18410, 19218, 20074, 20826, 20842, 20914, 20922, 20946, 88010, 88042, 96802, 208810, 208906, 225690, 225762, 225770, 225778, 225842, 1965602 }, new String[] { "ext_req_head", "DiskUserInfoGetMsgReq_body", "DiskDirFileInfoListMsgReq_body", "DiskFileUploadMsgReq_body", "DiskFileBatchDownloadMsgReq_body", "DiskDirFileBatchDeleteExMsgReq_body", "DiskFileCopyMsgReq_body", "DiskFileRenameMsgReq_body", "DiskDirCreateMsgReq_body", "DiskDirAttrModifyMsgReq_body", "DiskDirFileBatchMoveMsgReq_body", "PwdQueryMsgReq_body", "PwdVerifyMsgReq_body", "WeiyunShareAddV2MsgReq_body", "LibListNumGetMsgReq_body", "LibInfoListGetMsgReq_body", "OdAddUrlTaskMsgReq_body", "OdGetTaskListMsgReq_body", "OdDelTaskItemMsgReq_body", "OdClearTaskListMsgReq_body", "OdContinueTaskMsgReq_body", "CrossBidProxyCopyFileToOtherBidMsgReq_body" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqMsgBody.class);
    public weiyun_lite_message.CrossBidProxyCopyFileToOtherBidMsgReq CrossBidProxyCopyFileToOtherBidMsgReq_body = new weiyun_lite_message.CrossBidProxyCopyFileToOtherBidMsgReq();
    public weiyun_lite_message.DiskDirAttrModifyMsgReq DiskDirAttrModifyMsgReq_body = new weiyun_lite_message.DiskDirAttrModifyMsgReq();
    public weiyun_lite_message.DiskDirCreateMsgReq DiskDirCreateMsgReq_body = new weiyun_lite_message.DiskDirCreateMsgReq();
    public weiyun_lite_message.DiskDirFileBatchDeleteExMsgReq DiskDirFileBatchDeleteExMsgReq_body = new weiyun_lite_message.DiskDirFileBatchDeleteExMsgReq();
    public weiyun_lite_message.DiskDirFileBatchMoveMsgReq DiskDirFileBatchMoveMsgReq_body = new weiyun_lite_message.DiskDirFileBatchMoveMsgReq();
    public weiyun_lite_message.DiskDirFileInfoListMsgReq DiskDirFileInfoListMsgReq_body = new weiyun_lite_message.DiskDirFileInfoListMsgReq();
    public weiyun_lite_message.DiskFileBatchDownloadMsgReq DiskFileBatchDownloadMsgReq_body = new weiyun_lite_message.DiskFileBatchDownloadMsgReq();
    public weiyun_lite_message.DiskFileCopyMsgReq DiskFileCopyMsgReq_body = new weiyun_lite_message.DiskFileCopyMsgReq();
    public weiyun_lite_message.DiskFileRenameMsgReq DiskFileRenameMsgReq_body = new weiyun_lite_message.DiskFileRenameMsgReq();
    public weiyun_lite_message.DiskFileUploadMsgReq DiskFileUploadMsgReq_body = new weiyun_lite_message.DiskFileUploadMsgReq();
    public weiyun_lite_message.DiskUserInfoGetMsgReq DiskUserInfoGetMsgReq_body = new weiyun_lite_message.DiskUserInfoGetMsgReq();
    public weiyun_lite_message.LibInfoListGetMsgReq LibInfoListGetMsgReq_body = new weiyun_lite_message.LibInfoListGetMsgReq();
    public weiyun_lite_message.LibListNumGetMsgReq LibListNumGetMsgReq_body = new weiyun_lite_message.LibListNumGetMsgReq();
    public weiyun_lite_message.OdAddUrlTaskMsgReq OdAddUrlTaskMsgReq_body = new weiyun_lite_message.OdAddUrlTaskMsgReq();
    public weiyun_lite_message.OdClearTaskListMsgReq OdClearTaskListMsgReq_body = new weiyun_lite_message.OdClearTaskListMsgReq();
    public weiyun_lite_message.OdContinueTaskMsgReq OdContinueTaskMsgReq_body = new weiyun_lite_message.OdContinueTaskMsgReq();
    public weiyun_lite_message.OdDelTaskItemMsgReq OdDelTaskItemMsgReq_body = new weiyun_lite_message.OdDelTaskItemMsgReq();
    public weiyun_lite_message.OdGetTaskListMsgReq OdGetTaskListMsgReq_body = new weiyun_lite_message.OdGetTaskListMsgReq();
    public weiyun_lite_message.PwdQueryMsgReq PwdQueryMsgReq_body = new weiyun_lite_message.PwdQueryMsgReq();
    public weiyun_lite_message.PwdVerifyMsgReq PwdVerifyMsgReq_body = new weiyun_lite_message.PwdVerifyMsgReq();
    public weiyun_lite_message.WeiyunShareAddV2MsgReq WeiyunShareAddV2MsgReq_body = new weiyun_lite_message.WeiyunShareAddV2MsgReq();
    public weiyun_lite_message.ExtReqHead ext_req_head = new weiyun_lite_message.ExtReqHead();
  }
  
  public static final class RspMsgBody
    extends MessageMicro<RspMsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 17610, 17778, 18410, 19218, 20074, 20826, 20842, 20914, 20922, 20946, 88010, 88042, 96802, 208810, 208906, 225690, 225762, 225770, 225778, 225842, 1965602 }, new String[] { "DiskUserInfoGetMsgRsp_body", "DiskDirFileInfoListMsgRsp_body", "DiskFileUploadMsgRsp_body", "DiskFileBatchDownloadMsgRsp_body", "DiskDirFileBatchDeleteExMsgRsp_body", "DiskFileCopyMsgRsp_body", "DiskFileRenameMsgRsp_body", "DiskDirCreateMsgRsp_body", "DiskDirAttrModifyMsgRsp_body", "DiskDirFileBatchMoveMsgRsp_body", "PwdQueryMsgRsp_body", "PwdVerifyMsgRsp_body", "WeiyunShareAddV2MsgRsp_body", "LibListNumGetMsgRsp_body", "LibInfoListGetMsgRsp_body", "OdAddUrlTaskMsgRsp_body", "OdGetTaskListMsgRsp_body", "OdDelTaskItemMsgRsp_body", "OdClearTaskListMsgRsp_body", "OdContinueTaskMsgRsp_body", "CrossBidProxyCopyFileToOtherBidMsgRsp_body" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RspMsgBody.class);
    public weiyun_lite_message.CrossBidProxyCopyFileToOtherBidMsgRsp CrossBidProxyCopyFileToOtherBidMsgRsp_body = new weiyun_lite_message.CrossBidProxyCopyFileToOtherBidMsgRsp();
    public weiyun_lite_message.DiskDirAttrModifyMsgRsp DiskDirAttrModifyMsgRsp_body = new weiyun_lite_message.DiskDirAttrModifyMsgRsp();
    public weiyun_lite_message.DiskDirCreateMsgRsp DiskDirCreateMsgRsp_body = new weiyun_lite_message.DiskDirCreateMsgRsp();
    public weiyun_lite_message.DiskDirFileBatchDeleteExMsgRsp DiskDirFileBatchDeleteExMsgRsp_body = new weiyun_lite_message.DiskDirFileBatchDeleteExMsgRsp();
    public weiyun_lite_message.DiskDirFileBatchMoveMsgRsp DiskDirFileBatchMoveMsgRsp_body = new weiyun_lite_message.DiskDirFileBatchMoveMsgRsp();
    public weiyun_lite_message.DiskDirFileInfoListMsgRsp DiskDirFileInfoListMsgRsp_body = new weiyun_lite_message.DiskDirFileInfoListMsgRsp();
    public weiyun_lite_message.DiskFileBatchDownloadMsgRsp DiskFileBatchDownloadMsgRsp_body = new weiyun_lite_message.DiskFileBatchDownloadMsgRsp();
    public weiyun_lite_message.DiskFileCopyMsgRsp DiskFileCopyMsgRsp_body = new weiyun_lite_message.DiskFileCopyMsgRsp();
    public weiyun_lite_message.DiskFileRenameMsgRsp DiskFileRenameMsgRsp_body = new weiyun_lite_message.DiskFileRenameMsgRsp();
    public weiyun_lite_message.DiskFileUploadMsgRsp DiskFileUploadMsgRsp_body = new weiyun_lite_message.DiskFileUploadMsgRsp();
    public weiyun_lite_message.DiskUserInfoGetMsgRsp DiskUserInfoGetMsgRsp_body = new weiyun_lite_message.DiskUserInfoGetMsgRsp();
    public weiyun_lite_message.LibInfoListGetMsgRsp LibInfoListGetMsgRsp_body = new weiyun_lite_message.LibInfoListGetMsgRsp();
    public weiyun_lite_message.LibListNumGetMsgRsp LibListNumGetMsgRsp_body = new weiyun_lite_message.LibListNumGetMsgRsp();
    public weiyun_lite_message.OdAddUrlTaskMsgRsp OdAddUrlTaskMsgRsp_body = new weiyun_lite_message.OdAddUrlTaskMsgRsp();
    public weiyun_lite_message.OdClearTaskListMsgRsp OdClearTaskListMsgRsp_body = new weiyun_lite_message.OdClearTaskListMsgRsp();
    public weiyun_lite_message.OdContinueTaskMsgRsp OdContinueTaskMsgRsp_body = new weiyun_lite_message.OdContinueTaskMsgRsp();
    public weiyun_lite_message.OdDelTaskItemMsgRsp OdDelTaskItemMsgRsp_body = new weiyun_lite_message.OdDelTaskItemMsgRsp();
    public weiyun_lite_message.OdGetTaskListMsgRsp OdGetTaskListMsgRsp_body = new weiyun_lite_message.OdGetTaskListMsgRsp();
    public weiyun_lite_message.PwdQueryMsgRsp PwdQueryMsgRsp_body = new weiyun_lite_message.PwdQueryMsgRsp();
    public weiyun_lite_message.PwdVerifyMsgRsp PwdVerifyMsgRsp_body = new weiyun_lite_message.PwdVerifyMsgRsp();
    public weiyun_lite_message.WeiyunShareAddV2MsgRsp WeiyunShareAddV2MsgRsp_body = new weiyun_lite_message.WeiyunShareAddV2MsgRsp();
  }
  
  public static final class ShareFileItem
    extends MessageMicro<ShareFileItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "pdir_key", "file_id" }, new Object[] { localByteStringMicro, "" }, ShareFileItem.class);
    }
  }
  
  public static final class TaskInfo
    extends MessageMicro<TaskInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBUInt64Field current_size = PBField.initUInt64(0L);
    public final PBStringField dir_path = PBField.initString("");
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBUInt64Field task_id = PBField.initUInt64(0L);
    public final PBStringField task_name = PBField.initString("");
    public final PBUInt64Field task_size = PBField.initUInt64(0L);
    public final PBInt32Field task_status = PBField.initInt32(0);
    public final PBStringField task_status_desc = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 248, 320, 328, 400, 482, 562, 642, 722, 802 }, new String[] { "task_id", "task_name", "task_size", "current_size", "task_status", "create_time", "retcode", "retmsg", "task_status_desc", "dir_path", "pdir_key", "file_id" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", "", localByteStringMicro, "" }, TaskInfo.class);
    }
  }
  
  public static final class TimCloudAddtionalInfo
    extends MessageMicro<TimCloudAddtionalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_biz_type", "uint32_src_type", "msg_tim_cloud_file_ext_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, TimCloudAddtionalInfo.class);
    public weiyun_lite_message.TimCloudFileExtInfo msg_tim_cloud_file_ext_info = new weiyun_lite_message.TimCloudFileExtInfo();
    public final PBUInt32Field uint32_biz_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_type = PBField.initUInt32(0);
  }
  
  public static final class TimCloudFileExtInfo
    extends MessageMicro<TimCloudFileExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField file_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_online_local_id = PBField.initString("");
    public final PBStringField str_online_thum_url = PBField.initString("");
    public final PBStringField str_online_url = PBField.initString("");
    public final PBStringField str_show_name = PBField.initString("");
    public final PBUInt32Field uint32_online_create_src_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_domain_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_list_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_trans_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_modify_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_preview_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_share_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_online_modify_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_online_share_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_peer_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_preview_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_trans_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 72, 80, 90, 98, 104, 114, 122, 128, 136, 144, 152, 160 }, new String[] { "str_show_name", "uint64_peer_uin", "uint64_create_uin", "uint64_trans_time", "uint32_trans_type", "uint64_preview_time", "uint64_create_time", "uint64_online_modify_time", "uint64_last_modify_uin", "uint32_online_list_type", "file_10m_md5", "str_online_local_id", "uint32_online_domain_id", "str_online_url", "str_online_thum_url", "uint64_online_share_time", "uint64_last_share_uin", "uint64_last_preview_uin", "uint32_online_file_type", "uint32_online_create_src_type" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, "", Integer.valueOf(0), "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, TimCloudFileExtInfo.class);
    }
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField main_dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField root_dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField tim_0_dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField tim_1_dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field total_flow_perday = PBField.initInt64(0L);
    public final PBUInt64Field total_space = PBField.initUInt64(0L);
    public final PBInt64Field used_flow_today = PBField.initInt64(0L);
    public final PBUInt64Field used_space = PBField.initUInt64(0L);
    public final PBBoolField weiyun_vip = PBField.initBool(false);
    public final PBUInt64Field weiyun_vip_begin_time = PBField.initUInt64(0L);
    public final PBUInt64Field weiyun_vip_end_time = PBField.initUInt64(0L);
    public final PBInt32Field weiyun_vip_level = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 58, 66, 80, 88, 96, 104 }, new String[] { "main_dir_key", "used_space", "total_space", "used_flow_today", "total_flow_perday", "root_dir_key", "tim_0_dir_key", "tim_1_dir_key", "weiyun_vip", "weiyun_vip_level", "weiyun_vip_begin_time", "weiyun_vip_end_time" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Boolean.valueOf(false), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, UserInfo.class);
    }
  }
  
  public static final class WeiyunShareAddV2MsgReq
    extends MessageMicro<WeiyunShareAddV2MsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 962 }, new String[] { "share_name", "file_list" }, new Object[] { "", null }, WeiyunShareAddV2MsgReq.class);
    public final PBRepeatMessageField<weiyun_lite_message.ShareFileItem> file_list = PBField.initRepeatMessage(weiyun_lite_message.ShareFileItem.class);
    public final PBStringField share_name = PBField.initString("");
  }
  
  public static final class WeiyunShareAddV2MsgRsp
    extends MessageMicro<WeiyunShareAddV2MsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 162, 242 }, new String[] { "raw_url", "short_url", "share_name" }, new Object[] { "", "", "" }, WeiyunShareAddV2MsgRsp.class);
    public final PBStringField raw_url = PBField.initString("");
    public final PBStringField share_name = PBField.initString("");
    public final PBStringField short_url = PBField.initString("");
  }
  
  public static final class WeiyunVipInfo
    extends MessageMicro<WeiyunVipInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 82 }, new String[] { "weiyun_vip", "old_weiyun_vip", "weiyun_begin_time", "weiyun_end_time", "weiyun_vip_img_url", "weiyun_vip_level_info" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), "", null }, WeiyunVipInfo.class);
    public final PBBoolField old_weiyun_vip = PBField.initBool(false);
    public final PBUInt64Field weiyun_begin_time = PBField.initUInt64(0L);
    public final PBUInt64Field weiyun_end_time = PBField.initUInt64(0L);
    public final PBBoolField weiyun_vip = PBField.initBool(false);
    public final PBStringField weiyun_vip_img_url = PBField.initString("");
    public weiyun_lite_message.WeiyunVipLevelInfo weiyun_vip_level_info = new weiyun_lite_message.WeiyunVipLevelInfo();
  }
  
  public static final class WeiyunVipLevelInfo
    extends MessageMicro<WeiyunVipLevelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 168, 240 }, new String[] { "level", "current_score", "history_max_score", "grow_speed" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, WeiyunVipLevelInfo.class);
    public final PBInt32Field current_score = PBField.initInt32(0);
    public final PBInt32Field grow_speed = PBField.initInt32(0);
    public final PBInt32Field history_max_score = PBField.initInt32(0);
    public final PBInt32Field level = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.weiyun.weiyun_lite_message
 * JD-Core Version:    0.7.0.1
 */