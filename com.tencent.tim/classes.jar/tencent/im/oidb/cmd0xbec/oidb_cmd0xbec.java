package tencent.im.oidb.cmd0xbec;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbec
{
  public static final class Cookies
    extends MessageMicro<Cookies>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_page_index", "int64_timestamp" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, Cookies.class);
    public final PBInt64Field int64_timestamp = PBField.initInt64(0L);
    public final PBUInt32Field uint32_page_index = PBField.initUInt32(0);
  }
  
  public static final class GetHotWendaReq
    extends MessageMicro<GetHotWendaReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_cookies", "uint32_page_size" }, new Object[] { null, Integer.valueOf(0) }, GetHotWendaReq.class);
    public oidb_cmd0xbec.Cookies msg_cookies = new oidb_cmd0xbec.Cookies();
    public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
  }
  
  public static final class HotItem
    extends MessageMicro<HotItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_title" }, new Object[] { localByteStringMicro }, HotItem.class);
    }
  }
  
  public static final class HotWendaRsp
    extends MessageMicro<HotWendaRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_hot", "uint64_next_pull_time" }, new Object[] { null, Long.valueOf(0L) }, HotWendaRsp.class);
    public final PBRepeatMessageField<oidb_cmd0xbec.HotItem> rpt_hot = PBField.initRepeatMessage(oidb_cmd0xbec.HotItem.class);
    public final PBUInt64Field uint64_next_pull_time = PBField.initUInt64(0L);
  }
  
  public static final class QuestionInfo
    extends MessageMicro<QuestionInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_answer_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fans_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "bytes_rowkey", "bytes_title", "uint32_fans_num", "uint32_answer_num", "bytes_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, QuestionInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "search_req", "get_hot_wenda_req" }, new Object[] { null, null }, ReqBody.class);
    public oidb_cmd0xbec.GetHotWendaReq get_hot_wenda_req = new oidb_cmd0xbec.GetHotWendaReq();
    public oidb_cmd0xbec.SearchByKeyWordsReq search_req = new oidb_cmd0xbec.SearchByKeyWordsReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "search_result_rsp", "rpt_hot_rsp" }, new Object[] { null, null }, RspBody.class);
    public oidb_cmd0xbec.HotWendaRsp rpt_hot_rsp = new oidb_cmd0xbec.HotWendaRsp();
    public oidb_cmd0xbec.SearchResultRsp search_result_rsp = new oidb_cmd0xbec.SearchResultRsp();
  }
  
  public static final class SearchByKeyWordsReq
    extends MessageMicro<SearchByKeyWordsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_keywords = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xbec.Cookies msg_cookies = new oidb_cmd0xbec.Cookies();
    public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_keywords", "msg_cookies", "uint32_page_size" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0) }, SearchByKeyWordsReq.class);
    }
  }
  
  public static final class SearchResultRsp
    extends MessageMicro<SearchResultRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_is_end = PBField.initBool(false);
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0xbec.QuestionInfo> rpt_question_info = PBField.initRepeatMessage(oidb_cmd0xbec.QuestionInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_question_info", "bytes_cookies", "bool_is_end" }, new Object[] { null, localByteStringMicro, Boolean.valueOf(false) }, SearchResultRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbec.oidb_cmd0xbec
 * JD-Core Version:    0.7.0.1
 */