package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ArticleComment
{
  public static final class ArticleLikeRequest
    extends MessageMicro<ArticleLikeRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field like = PBField.initUInt32(0);
    public final PBUInt32Field pin = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "article_id", "uin", "like", "pin" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ArticleLikeRequest.class);
    }
  }
  
  public static final class ArticleLikeRespond
    extends MessageMicro<ArticleLikeRespond>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret" }, new Object[] { null }, ArticleLikeRespond.class);
    public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  }
  
  public static final class CheckArticleLikeRequest
    extends MessageMicro<CheckArticleLikeRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "article_id", "uins" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, CheckArticleLikeRequest.class);
    }
  }
  
  public static final class CheckArticleLikeRespond
    extends MessageMicro<CheckArticleLikeRespond>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret", "data" }, new Object[] { null, null }, CheckArticleLikeRespond.class);
    public final PBRepeatMessageField<ArticleComment.LikeRet> data = PBField.initRepeatMessage(ArticleComment.LikeRet.class);
    public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  }
  
  public static final class CreateArticleCommentRequest
    extends MessageMicro<CreateArticleCommentRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField comment = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field hide_name = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "article_id", "uin", "comment", "hide_name" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0) }, CreateArticleCommentRequest.class);
    }
  }
  
  public static final class CreateArticleCommentRespond
    extends MessageMicro<CreateArticleCommentRespond>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret", "comment_id" }, new Object[] { null, localByteStringMicro }, CreateArticleCommentRespond.class);
    }
  }
  
  public static final class GetArticleCommentCountRequest
    extends MessageMicro<GetArticleCommentCountRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "article_id" }, new Object[] { localByteStringMicro }, GetArticleCommentCountRequest.class);
    }
  }
  
  public static final class GetArticleCommentCountRespond
    extends MessageMicro<GetArticleCommentCountRespond>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "ret", "count" }, new Object[] { null, Integer.valueOf(0) }, GetArticleCommentCountRespond.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  }
  
  public static final class GetArticleLikeCountRequest
    extends MessageMicro<GetArticleLikeCountRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "article_id" }, new Object[] { localByteStringMicro }, GetArticleLikeCountRequest.class);
    }
  }
  
  public static final class GetArticleLikeCountRespond
    extends MessageMicro<GetArticleLikeCountRespond>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "ret", "count" }, new Object[] { null, Integer.valueOf(0) }, GetArticleLikeCountRespond.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  }
  
  public static final class GetPhotoCollectionInfoRequest
    extends MessageMicro<GetPhotoCollectionInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field click_source = PBField.initUInt32(0);
    public final PBUInt64Field cuin = PBField.initUInt64(0L);
    public final PBUInt32Field recommend_position = PBField.initUInt32(0);
    public final PBStringField recommend_source = PBField.initString("");
    public final PBStringField versionInfo = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "versionInfo", "cuin", "article_id", "recommend_source", "recommend_position", "click_source" }, new Object[] { "", Long.valueOf(0L), localByteStringMicro, "", Integer.valueOf(0), Integer.valueOf(0) }, GetPhotoCollectionInfoRequest.class);
    }
  }
  
  public static final class GetPhotoCollectionInfoResponse
    extends MessageMicro<GetPhotoCollectionInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField article_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField article_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField comment_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field enable_comment = PBField.initUInt32(0);
    public ArticleComment.PhotoFirstItemInfo firstItem = new ArticleComment.PhotoFirstItemInfo();
    public final PBRepeatMessageField<ArticleComment.PhotoItemInfo> item = PBField.initRepeatMessage(ArticleComment.PhotoItemInfo.class);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 56, 66, 74 }, new String[] { "ret", "item", "article_share_url", "puin", "article_img_url", "article_title", "enable_comment", "comment_url", "firstItem" }, new Object[] { null, null, localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, null }, GetPhotoCollectionInfoResponse.class);
    }
  }
  
  public static final class GetRecommendInfoRequest
    extends MessageMicro<GetRecommendInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field cuin = PBField.initUInt64(0L);
    public final PBStringField versionInfo = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "versionInfo", "cuin", "article_id" }, new Object[] { "", Long.valueOf(0L), localByteStringMicro }, GetRecommendInfoRequest.class);
    }
  }
  
  public static final class GetRecommendInfoResponse
    extends MessageMicro<GetRecommendInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret", "item" }, new Object[] { null, null }, GetRecommendInfoResponse.class);
    public final PBRepeatMessageField<ArticleComment.RecommendItemInfo> item = PBField.initRepeatMessage(ArticleComment.RecommendItemInfo.class);
    public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  }
  
  public static final class GetRecommendPubAccountRequest
    extends MessageMicro<GetRecommendPubAccountRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "version", "cuin", "count" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0) }, GetRecommendPubAccountRequest.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt64Field cuin = PBField.initUInt64(0L);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class GetRecommendPubAccountResponse
    extends MessageMicro<GetRecommendPubAccountResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<ArticleComment.Record> recom_list = PBField.initRepeatMessage(ArticleComment.Record.class);
    public final PBBytesField recom_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ret", "recom_list", "recom_title" }, new Object[] { null, null, localByteStringMicro }, GetRecommendPubAccountResponse.class);
    }
  }
  
  public static final class LikeRet
    extends MessageMicro<LikeRet>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "like" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, LikeRet.class);
    public final PBUInt32Field like = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class PhotoFirstItemInfo
    extends MessageMicro<PhotoFirstItemInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField photo_author_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField photo_time = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField publicaccount_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "url", "photo_time", "photo_author_name", "publicaccount_name" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, PhotoFirstItemInfo.class);
    }
  }
  
  public static final class PhotoItemInfo
    extends MessageMicro<PhotoItemInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBBytesField static_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "url", "content", "static_url", "width", "height" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, PhotoItemInfo.class);
    }
  }
  
  public static final class ReadPhotoItemInfo
    extends MessageMicro<ReadPhotoItemInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "index", "item_remain_time", "item_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReadPhotoItemInfo.class);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBUInt32Field item_remain_time = PBField.initUInt32(0);
    public final PBUInt32Field item_type = PBField.initUInt32(0);
  }
  
  public static final class RecommendInfo
    extends MessageMicro<RecommendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField echo_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rowkey", "echo_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, RecommendInfo.class);
    }
  }
  
  public static final class RecommendItemInfo
    extends MessageMicro<RecommendItemInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField recommend_source = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "url", "title", "recommend_source", "article_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RecommendItemInfo.class);
    }
  }
  
  public static final class Record
    extends MessageMicro<Record>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField brief = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField puin = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "puin", "name", "brief" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, Record.class);
    }
  }
  
  public static final class ReportGalleryInfoRequest
    extends MessageMicro<ReportGalleryInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field article_id = PBField.initUInt32(0);
    public final PBBytesField article_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field browse_time = PBField.initUInt32(0);
    public final PBUInt32Field client_ip = PBField.initUInt32(0);
    public final PBBytesField echo_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_qq = PBField.initUInt32(0);
    public final PBBytesField mv = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField network = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField os = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBUInt32Field recommend_index = PBField.initUInt32(0);
    public final PBRepeatMessageField<ArticleComment.RecommendInfo> recommend_info = PBField.initRepeatMessage(ArticleComment.RecommendInfo.class);
    public final PBBytesField rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field site_id = PBField.initUInt32(0);
    public final PBBytesField subv = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field ts = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58, 66, 74, 82, 88, 96, 104, 114, 120, 128, 138 }, new String[] { "uin", "puin", "article_id", "article_url", "is_qq", "os", "mv", "subv", "network", "rowkey", "ts", "site_id", "recommend_index", "echo_info", "client_ip", "browse_time", "recommend_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), null }, ReportGalleryInfoRequest.class);
    }
  }
  
  public static final class ReportGalleryInfoResponse
    extends MessageMicro<ReportGalleryInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret" }, new Object[] { null }, ReportGalleryInfoResponse.class);
    public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  }
  
  public static final class ReportNetConnectInfoRequest
    extends MessageMicro<ReportNetConnectInfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field DNSCost = PBField.initUInt32(0);
    public final PBUInt32Field connectCost = PBField.initUInt32(0);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBInt32Field netType = PBField.initInt32(0);
    public final PBUInt32Field receiveCost = PBField.initUInt32(0);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField versionInfo = PBField.initString("");
    public final PBStringField website_address = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64 }, new String[] { "versionInfo", "website_address", "errorcode", "url", "DNSCost", "connectCost", "receiveCost", "netType" }, new Object[] { "", "", Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReportNetConnectInfoRequest.class);
    }
  }
  
  public static final class ReportNetConnectInfoResponse
    extends MessageMicro<ReportNetConnectInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret" }, new Object[] { null }, ReportNetConnectInfoResponse.class);
    public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  }
  
  public static final class ReportReadPhotoCollectionRequest
    extends MessageMicro<ReportReadPhotoCollectionRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field cuin = PBField.initUInt64(0L);
    public final PBRepeatMessageField<ArticleComment.ReadPhotoItemInfo> item = PBField.initRepeatMessage(ArticleComment.ReadPhotoItemInfo.class);
    public final PBRepeatField<ByteStringMicro> recommend_article_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field report_timing_type = PBField.initUInt32(0);
    public final PBUInt32Field total_remain_time = PBField.initUInt32(0);
    public final PBStringField versionInfo = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50, 58 }, new String[] { "versionInfo", "cuin", "article_id", "report_timing_type", "total_remain_time", "item", "recommend_article_id" }, new Object[] { "", Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2 }, ReportReadPhotoCollectionRequest.class);
    }
  }
  
  public static final class ReportReadPhotoCollectionResponse
    extends MessageMicro<ReportReadPhotoCollectionResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret" }, new Object[] { null }, ReportReadPhotoCollectionResponse.class);
    public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField err_info = PBField.initString("");
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment
 * JD-Core Version:    0.7.0.1
 */