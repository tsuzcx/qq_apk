package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class RequestSearchWord
{
  public static final class Rcmd
    extends MessageMicro<Rcmd>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField jmp_url = PBField.initString("");
    public final PBUInt32Field modle_id = PBField.initUInt32(0);
    public final PBStringField modle_name = PBField.initString("");
    public final PBFloatField score = PBField.initFloat(0.0F);
    public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 29, 34, 40 }, new String[] { "word", "jmp_url", "score", "modle_name", "modle_id" }, new Object[] { localByteStringMicro, "", Float.valueOf(0.0F), "", Integer.valueOf(0) }, Rcmd.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_rowkey", "uint32_oper_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_search_keywords" }, new Object[] { null }, RspBody.class);
    public RequestSearchWord.SearchKeywords msg_search_keywords = new RequestSearchWord.SearchKeywords();
  }
  
  public static final class SearchKeywords
    extends MessageMicro<SearchKeywords>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<RequestSearchWord.Rcmd> rcmds = PBField.initRepeatMessage(RequestSearchWord.Rcmd.class);
    public final PBStringField sessionid = PBField.initString("");
    public final PBBytesField sid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 34, 42 }, new String[] { "rcmds", "sid", "sessionid" }, new Object[] { null, localByteStringMicro, "" }, SearchKeywords.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pb.unite.search.RequestSearchWord
 * JD-Core Version:    0.7.0.1
 */