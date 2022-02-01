package tencent.im.cs.MQKanDianSvc0x001;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MQKanDianSvc0x001
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int CUT_ALL = 1;
    public static final int CUT_FOR_SEARCH = 2;
    public static final int CUT_PRECISE = 0;
    public static final int CUT_WORD = 0;
    public static final int CUT_WORD_AND_GET_ARTICLES = 2;
    public static final int GET_ARTICLES = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "enum_cut_mode", "enum_request_mode", "rpt_str_sentences", "bool_use_hmm", "uint32_request_article_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Boolean.valueOf(false), Integer.valueOf(0) }, ReqBody.class);
    public final PBBoolField bool_use_hmm = PBField.initBool(false);
    public final PBEnumField enum_cut_mode = PBField.initEnum(0);
    public final PBEnumField enum_request_mode = PBField.initEnum(0);
    public final PBRepeatField<String> rpt_str_sentences = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_request_article_num = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_error_num", "rpt_msg_words", "rpt_msg_articles" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
    public final PBInt32Field int32_error_num = PBField.initInt32(0);
    public final PBRepeatMessageField<ArticleInfo> rpt_msg_articles = PBField.initRepeatMessage(ArticleInfo.class);
    public final PBRepeatMessageField<WordsOfCut> rpt_msg_words = PBField.initRepeatMessage(WordsOfCut.class);
    
    public static final class ArticleInfo
      extends MessageMicro<ArticleInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_subject", "str_abstract", "str_content_url" }, new Object[] { "", "", "" }, ArticleInfo.class);
      public final PBStringField str_abstract = PBField.initString("");
      public final PBStringField str_content_url = PBField.initString("");
      public final PBStringField str_subject = PBField.initString("");
    }
    
    public static final class WordsOfCut
      extends MessageMicro<WordsOfCut>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_str_words" }, new Object[] { "" }, WordsOfCut.class);
      public final PBRepeatField<String> rpt_str_words = PBField.initRepeat(PBStringField.__repeatHelper__);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.MQKanDianSvc0x001.MQKanDianSvc0x001
 * JD-Core Version:    0.7.0.1
 */