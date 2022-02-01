package tencent.im.oidb.cmd0xaef;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xae9.group_online_docs.DocInfo;

public final class Oidb_0xaef
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "search_doc_req" }, new Object[] { null }, ReqBody.class);
    public Oidb_0xaef.SearchDocReq search_doc_req = new Oidb_0xaef.SearchDocReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "search_doc_rsp" }, new Object[] { null }, RspBody.class);
    public Oidb_0xaef.SearchDocRsp search_doc_rsp = new Oidb_0xaef.SearchDocRsp();
  }
  
  public static final class SearchDocReq
    extends MessageMicro<SearchDocReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field file_type = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field search_type = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "group_code", "key_word", "start", "limit", "search_type", "file_type" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SearchDocReq.class);
    }
  }
  
  public static final class SearchDocRsp
    extends MessageMicro<SearchDocRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<Oidb_0xaef.SearchItem> doc_list = PBField.initRepeatMessage(Oidb_0xaef.SearchItem.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field match_count = PBField.initUInt32(0);
    public final PBUInt32Field next = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "next", "is_end", "key_word", "match_count", "doc_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), null }, SearchDocRsp.class);
    }
  }
  
  public static final class SearchItem
    extends MessageMicro<SearchItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public group_online_docs.DocInfo doc_info = new group_online_docs.DocInfo();
    public final PBRepeatField<ByteStringMicro> match_word = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "doc_info", "match_word" }, new Object[] { null, localByteStringMicro }, SearchItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaef.Oidb_0xaef
 * JD-Core Version:    0.7.0.1
 */