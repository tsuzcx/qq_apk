package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class online_docs
{
  public static final class DocId
    extends MessageMicro<DocId>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field domain_id = PBField.initUInt64(0L);
    public final PBBytesField pad_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "domain_id", "pad_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, DocId.class);
    }
  }
  
  public static final class DocInfo
    extends MessageMicro<DocInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56, 64, 72, 80, 90, 98, 106, 114, 122, 130 }, new String[] { "doc_meta", "creator_nick", "owner_nick", "last_modify_nick", "is_pinned", "doc_url", "doc_policy", "last_browse_ts", "last_pinned_ts", "browse_del_ts", "pin_doc_url", "unpin_doc_url", "delete_doc_url", "change_title_url", "export_url", "last_editor_head_url" }, new Object[] { null, "", "", "", Boolean.valueOf(false), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "" }, DocInfo.class);
    public final PBUInt32Field browse_del_ts = PBField.initUInt32(0);
    public final PBStringField change_title_url = PBField.initString("");
    public final PBStringField creator_nick = PBField.initString("");
    public final PBStringField delete_doc_url = PBField.initString("");
    public online_docs.DocMetaData doc_meta = new online_docs.DocMetaData();
    public final PBUInt32Field doc_policy = PBField.initUInt32(0);
    public final PBStringField doc_url = PBField.initString("");
    public final PBStringField export_url = PBField.initString("");
    public final PBBoolField is_pinned = PBField.initBool(false);
    public final PBUInt32Field last_browse_ts = PBField.initUInt32(0);
    public final PBStringField last_editor_head_url = PBField.initString("");
    public final PBStringField last_modify_nick = PBField.initString("");
    public final PBUInt32Field last_pinned_ts = PBField.initUInt32(0);
    public final PBStringField owner_nick = PBField.initString("");
    public final PBStringField pin_doc_url = PBField.initString("");
    public final PBStringField unpin_doc_url = PBField.initString("");
  }
  
  public static final class DocListItem
    extends MessageMicro<DocListItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "doc_id", "is_pinned", "pin_ts", "order_ts", "browse_del_ts" }, new Object[] { null, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DocListItem.class);
    public final PBUInt32Field browse_del_ts = PBField.initUInt32(0);
    public online_docs.DocId doc_id = new online_docs.DocId();
    public final PBBoolField is_pinned = PBField.initBool(false);
    public final PBUInt32Field order_ts = PBField.initUInt32(0);
    public final PBUInt32Field pin_ts = PBField.initUInt32(0);
  }
  
  public static final class DocMetaData
    extends MessageMicro<DocMetaData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field create_ts = PBField.initUInt32(0);
    public final PBUInt64Field creator_uid = PBField.initUInt64(0L);
    public final PBUInt64Field creator_uin = PBField.initUInt64(0L);
    public final PBStringField doc_icon = PBField.initString("");
    public online_docs.DocId doc_id = new online_docs.DocId();
    public final PBUInt32Field doc_status = PBField.initUInt32(0);
    public final PBStringField doc_thumbnail = PBField.initString("");
    public final PBUInt32Field doc_type = PBField.initUInt32(0);
    public final PBStringField doc_type_desc = PBField.initString("");
    public final PBUInt32Field last_modify_ts = PBField.initUInt32(0);
    public final PBUInt64Field last_modify_uid = PBField.initUInt64(0L);
    public final PBUInt64Field last_modify_uin = PBField.initUInt64(0L);
    public final PBUInt64Field owner_uid = PBField.initUInt64(0L);
    public final PBUInt64Field owner_uin = PBField.initUInt64(0L);
    public final PBStringField short_url = PBField.initString("");
    public final PBUInt32Field status_change_ts = PBField.initUInt32(0);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 114, 122, 130, 138 }, new String[] { "doc_id", "title", "creator_uin", "create_ts", "last_modify_uin", "last_modify_ts", "owner_uin", "doc_type", "creator_uid", "last_modify_uid", "owner_uid", "doc_status", "status_change_ts", "doc_icon", "doc_type_desc", "doc_thumbnail", "short_url" }, new Object[] { null, localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "" }, DocMetaData.class);
    }
  }
  
  public static final class FolderInfo
    extends MessageMicro<FolderInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48 }, new String[] { "folder_id", "title", "create_ts", "modify_ts", "parent_folder_id", "status" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, FolderInfo.class);
    public final PBUInt32Field create_ts = PBField.initUInt32(0);
    public final PBStringField folder_id = PBField.initString("");
    public final PBUInt32Field modify_ts = PBField.initUInt32(0);
    public final PBStringField parent_folder_id = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae9.online_docs
 * JD-Core Version:    0.7.0.1
 */