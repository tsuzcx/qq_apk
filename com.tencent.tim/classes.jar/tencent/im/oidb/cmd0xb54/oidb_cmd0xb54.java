package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xb74.cmd0xb74.FusionBiuInfo;

public final class oidb_cmd0xb54
{
  public static final class ArticleBusiness
    extends MessageMicro<ArticleBusiness>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_business_cash_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xb54.SentimentEntityData msg_sentiment_entity_data = new oidb_cmd0xb54.SentimentEntityData();
    public oidb_cmd0xb54.UnionNlpInfo msg_union_nlp_info = new oidb_cmd0xb54.UnionNlpInfo();
    public final PBUInt32Field uint32_business_cash_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 82, 90 }, new String[] { "uint32_business_cash_flag", "bytes_business_cash_info", "msg_sentiment_entity_data", "msg_union_nlp_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null }, ArticleBusiness.class);
    }
  }
  
  public static final class Client
    extends MessageMicro<Client>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_version", "uint32_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, Client.class);
    }
  }
  
  public static final class RelatedSearchWord
    extends MessageMicro<RelatedSearchWord>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBFloatField float_score = PBField.initFloat(0.0F);
    public final PBStringField str_jmp_url = PBField.initString("");
    public final PBStringField str_modle_name = PBField.initString("");
    public final PBUInt32Field uint32_modle_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 29, 34, 40 }, new String[] { "bytes_word", "str_jmp_url", "float_score", "str_modle_name", "uint32_modle_id" }, new Object[] { localByteStringMicro, "", Float.valueOf(0.0F), "", Integer.valueOf(0) }, RelatedSearchWord.class);
    }
  }
  
  public static final class ReqArticle
    extends MessageMicro<ReqArticle>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_style_card_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_row_key", "rpt_bytes_style_card_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ReqArticle.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_client", "msg_req_article", "uint32_topic", "msg_option" }, new Object[] { null, null, Integer.valueOf(0), null }, ReqBody.class);
    public oidb_cmd0xb54.Client msg_client = new oidb_cmd0xb54.Client();
    public oidb_cmd0xb54.ReqOption msg_option = new oidb_cmd0xb54.ReqOption();
    public oidb_cmd0xb54.ReqArticle msg_req_article = new oidb_cmd0xb54.ReqArticle();
    public final PBUInt32Field uint32_topic = PBField.initUInt32(0);
  }
  
  public static final class ReqOption
    extends MessageMicro<ReqOption>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "uint32_biu_count", "uint32_like_count", "uint32_is_like", "uint32_style_card", "uint32_related_search_size", "uint32_article_business", "uint32_related_search", "uint32_need_fusion_biu_info", "uint32_need_proteus_json_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqOption.class);
    public final PBUInt32Field uint32_article_business = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_fusion_biu_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_proteus_json_data = PBField.initUInt32(0);
    public final PBUInt32Field uint32_related_search = PBField.initUInt32(0);
    public final PBUInt32Field uint32_related_search_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_style_card = PBField.initUInt32(0);
  }
  
  public static final class RspBiuCount
    extends MessageMicro<RspBiuCount>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_biu_count" }, new Object[] { Long.valueOf(0L) }, RspBiuCount.class);
    public final PBUInt64Field uint64_biu_count = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_proteus_json_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_search_word_sid = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xb54.ArticleBusiness msg_article_business = new oidb_cmd0xb54.ArticleBusiness();
    public cmd0xb74.FusionBiuInfo msg_fusion_biu_info = new cmd0xb74.FusionBiuInfo();
    public oidb_cmd0xb54.RspBiuCount msg_rsp_biu_count = new oidb_cmd0xb54.RspBiuCount();
    public oidb_cmd0xb54.RspTopic msg_rsp_topic = new oidb_cmd0xb54.RspTopic();
    public final PBRepeatMessageField<oidb_cmd0xb54.StyleCard> rpt_msg_style_card = PBField.initRepeatMessage(oidb_cmd0xb54.StyleCard.class);
    public final PBRepeatMessageField<oidb_cmd0xb54.RelatedSearchWord> rpt_related_search_word = PBField.initRepeatMessage(oidb_cmd0xb54.RelatedSearchWord.class);
    public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58, 66, 74, 82 }, new String[] { "msg_rsp_topic", "msg_rsp_biu_count", "uint32_like_count", "uint32_is_like", "rpt_msg_style_card", "rpt_related_search_word", "bytes_search_word_sid", "msg_article_business", "msg_fusion_biu_info", "bytes_proteus_json_data" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), null, null, localByteStringMicro1, null, null, localByteStringMicro2 }, RspBody.class);
    }
  }
  
  public static final class RspTopic
    extends MessageMicro<RspTopic>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_topic" }, new Object[] { null }, RspTopic.class);
    public final PBRepeatMessageField<oidb_cmd0xb54.Topic> rpt_msg_topic = PBField.initRepeatMessage(oidb_cmd0xb54.Topic.class);
  }
  
  public static final class SentimentEntityData
    extends MessageMicro<SentimentEntityData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_relation = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_data", "bytes_relation" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, SentimentEntityData.class);
    }
  }
  
  public static final class StyleCard
    extends MessageMicro<StyleCard>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sourceid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_style = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_sourceid", "bytes_style" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, StyleCard.class);
    }
  }
  
  public static final class StyleCardReqParam
    extends MessageMicro<StyleCardReqParam>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_type", "bytes_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, StyleCardReqParam.class);
    }
  }
  
  public static final class Topic
    extends MessageMicro<Topic>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_topic_id", "bytes_title", "bytes_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, Topic.class);
    }
  }
  
  public static final class UnionNlpInfo
    extends MessageMicro<UnionNlpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_union_chann = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_union_tag = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_union_tag", "bytes_union_chann" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, UnionNlpInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb54.oidb_cmd0xb54
 * JD-Core Version:    0.7.0.1
 */