package tencent.im.oidb.cmd0xad6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xad6
{
  public static final class ArtcleCache
    extends MessageMicro<ArtcleCache>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_zip_html = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBFixed32Field fixed32_modify_time = PBField.initFixed32(0);
    public oidb_cmd0xad6.RspBody msg_rsp_body = new oidb_cmd0xad6.RspBody();
    public final PBUInt32Field uint32_compatible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_use_webview = PBField.initUInt32(0);
    public final PBUInt64Field uint64_expired_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_low_version = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_under = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 26, 32, 40, 50, 56, 80 }, new String[] { "fixed32_modify_time", "uint32_use_webview", "msg_rsp_body", "uint64_low_version", "uint64_under", "bytes_zip_html", "uint32_compatible", "uint64_expired_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, ArtcleCache.class);
    }
  }
  
  public static final class Article
    extends MessageMicro<Article>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_html = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xad6.ArticleCommonInfo msg_article_common = new oidb_cmd0xad6.ArticleCommonInfo();
    public final PBUInt32Field uint32_zip = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_article_common", "bytes_html", "uint32_zip" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0) }, Article.class);
    }
  }
  
  public static final class ArticleCommonInfo
    extends MessageMicro<ArticleCommonInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_account_author = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_account_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_account_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_account_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_date = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_original_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_proteus_json_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_share_words = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tags = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xad6.ArticleCover msg_cover = new oidb_cmd0xad6.ArticleCover();
    public final PBUInt32Field uint32_article_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_public_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 98, 104, 114, 120, 130, 138, 146, 154, 162 }, new String[] { "bytes_row_key", "bytes_title", "bytes_desc", "bytes_account_name", "bytes_account_icon", "bytes_account_author", "bytes_date", "msg_cover", "bytes_share_words", "uint32_article_flag", "bytes_account_desc", "uint64_public_uin", "bytes_original_url", "bytes_tags", "bytes_article_id", "bytes_proteus_json_data", "bytes_article_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, null, localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9, Long.valueOf(0L), localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14 }, ArticleCommonInfo.class);
    }
  }
  
  public static final class ArticleCover
    extends MessageMicro<ArticleCover>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_big_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nimage = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_smart_coverimg = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_cover_url", "bytes_big_url", "bytes_nimage", "bytes_smart_coverimg" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ArticleCover.class);
    }
  }
  
  public static final class ArticleExtInfo
    extends MessageMicro<ArticleExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comment_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_comment = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_read_count = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_read_count", "uint64_comment", "bytes_comment_url" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, ArticleExtInfo.class);
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
  
  public static final class ReqArticle
    extends MessageMicro<ReqArticle>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_zip = PBField.initUInt32(0);
    public final PBUInt64Field uint64_prev_version = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_public_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 88, 96 }, new String[] { "bytes_url", "uint64_public_uin", "bytes_article_id", "bytes_row_key", "uint32_zip", "uint64_prev_version" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Long.valueOf(0L) }, ReqArticle.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "msg_client", "msg_req_article", "uint32_article", "uint32_read_count", "uint32_comment", "uint32_comment_key_type" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public oidb_cmd0xad6.Client msg_client = new oidb_cmd0xad6.Client();
    public oidb_cmd0xad6.ReqArticle msg_req_article = new oidb_cmd0xad6.ReqArticle();
    public final PBUInt32Field uint32_article = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_key_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_count = PBField.initUInt32(0);
  }
  
  public static final class RspArticle
    extends MessageMicro<RspArticle>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_article", "uint64_version" }, new Object[] { null, Long.valueOf(0L) }, RspArticle.class);
    public oidb_cmd0xad6.Article msg_article = new oidb_cmd0xad6.Article();
    public final PBUInt64Field uint64_version = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "bool_use_webview", "msg_rsp_article", "msg_ext_info" }, new Object[] { Boolean.valueOf(false), null, null }, RspBody.class);
    public final PBBoolField bool_use_webview = PBField.initBool(false);
    public oidb_cmd0xad6.ArticleExtInfo msg_ext_info = new oidb_cmd0xad6.ArticleExtInfo();
    public oidb_cmd0xad6.RspArticle msg_rsp_article = new oidb_cmd0xad6.RspArticle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad6.oidb_cmd0xad6
 * JD-Core Version:    0.7.0.1
 */