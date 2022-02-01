package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ComicIPSite
{
  public static final class Book
    extends MessageMicro<Book>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "cover", "desc", "id", "jumpUrl", "name", "recommDesc", "authorName" }, new Object[] { "", "", "", "", "", "", "" }, Book.class);
    public final PBStringField authorName = PBField.initString("");
    public final PBStringField cover = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField recommDesc = PBField.initString("");
  }
  
  public static final class Comic
    extends MessageMicro<Comic>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "comicType", "cover", "desc", "id", "jumpUrl", "name", "recommDesc", "typeName", "rich" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", "", "", null }, Comic.class);
    public final PBInt32Field comicType = PBField.initInt32(0);
    public final PBStringField cover = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField recommDesc = PBField.initString("");
    public final PBRepeatMessageField<ComicIPSite.ComicRich> rich = PBField.initRepeatMessage(ComicIPSite.ComicRich.class);
    public final PBStringField typeName = PBField.initString("");
  }
  
  public static final class ComicRich
    extends MessageMicro<ComicRich>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extCover", "extName", "extTitle", "extUrl" }, new Object[] { "", "", "", "" }, ComicRich.class);
    public final PBStringField extCover = PBField.initString("");
    public final PBStringField extName = PBField.initString("");
    public final PBStringField extTitle = PBField.initString("");
    public final PBStringField extUrl = PBField.initString("");
  }
  
  public static final class Game
    extends MessageMicro<Game>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "cover", "desc", "id", "jumpUrl", "name", "recommDesc", "rich" }, new Object[] { "", "", "", "", "", "", null }, Game.class);
    public final PBStringField cover = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField recommDesc = PBField.initString("");
    public final PBRepeatMessageField<ComicIPSite.GameRich> rich = PBField.initRepeatMessage(ComicIPSite.GameRich.class);
  }
  
  public static final class GameRich
    extends MessageMicro<GameRich>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "anchorFaceUrl", "anchorId", "anchorName", "coverUrl", "online", "title", "richJumpUrl" }, new Object[] { "", "", "", "", "", "", "" }, GameRich.class);
    public final PBStringField anchorFaceUrl = PBField.initString("");
    public final PBStringField anchorId = PBField.initString("");
    public final PBStringField anchorName = PBField.initString("");
    public final PBStringField coverUrl = PBField.initString("");
    public final PBStringField online = PBField.initString("");
    public final PBStringField richJumpUrl = PBField.initString("");
    public final PBStringField title = PBField.initString("");
  }
  
  public static final class Goods
    extends MessageMicro<Goods>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "cover", "goodsTags", "id", "name", "price", "saleTags", "svipPrice", "url", "moreUrl", "saleNum" }, new Object[] { "", "", "", "", "", "", "", "", "", "" }, Goods.class);
    public final PBStringField cover = PBField.initString("");
    public final PBStringField goodsTags = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBStringField moreUrl = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField price = PBField.initString("");
    public final PBStringField saleNum = PBField.initString("");
    public final PBStringField saleTags = PBField.initString("");
    public final PBStringField svipPrice = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class Gxzb
    extends MessageMicro<Gxzb>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50 }, new String[] { "appId", "appName", "cover", "feeType", "id", "name" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", "" }, Gxzb.class);
    public final PBInt32Field appId = PBField.initInt32(0);
    public final PBStringField appName = PBField.initString("");
    public final PBStringField cover = PBField.initString("");
    public final PBInt32Field feeType = PBField.initInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class ModuleInfo
    extends MessageMicro<ModuleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "appId", "itemId", "isRetSummary" }, new Object[] { Integer.valueOf(0), "", Boolean.valueOf(false) }, ModuleInfo.class);
    public final PBInt32Field appId = PBField.initInt32(0);
    public final PBBoolField isRetSummary = PBField.initBool(false);
    public final PBStringField itemId = PBField.initString("");
  }
  
  public static final class ModuleReq
    extends MessageMicro<ModuleReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "platform", "mqqver", "uin", "moduleInfo", "sub_cmd" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), null, Integer.valueOf(0) }, ModuleReq.class);
    public ComicIPSite.ModuleInfo moduleInfo = new ComicIPSite.ModuleInfo();
    public final PBStringField mqqver = PBField.initString("");
    public final PBInt64Field platform = PBField.initInt64(0L);
    public final PBInt32Field sub_cmd = PBField.initInt32(0);
    public final PBInt64Field uin = PBField.initInt64(0L);
  }
  
  public static final class ModuleRsp
    extends MessageMicro<ModuleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 66, 74, 82, 90, 98, 106, 114, 120, 128, 138, 146, 152, 160 }, new String[] { "ipId", "ipName", "ipDesc", "ipUrl", "itemSize", "strType", "extId", "extStr", "gxzbList", "gameList", "goodsList", "bookList", "videoList", "comicList", "result", "sub_cmd", "ipLogo", "ipContent", "requestInterval", "goodSize" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), "", null, null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0) }, ModuleRsp.class);
    public final PBRepeatMessageField<ComicIPSite.Book> bookList = PBField.initRepeatMessage(ComicIPSite.Book.class);
    public final PBRepeatMessageField<ComicIPSite.Comic> comicList = PBField.initRepeatMessage(ComicIPSite.Comic.class);
    public final PBInt32Field extId = PBField.initInt32(0);
    public final PBStringField extStr = PBField.initString("");
    public final PBRepeatMessageField<ComicIPSite.Game> gameList = PBField.initRepeatMessage(ComicIPSite.Game.class);
    public final PBInt32Field goodSize = PBField.initInt32(0);
    public final PBRepeatMessageField<ComicIPSite.Goods> goodsList = PBField.initRepeatMessage(ComicIPSite.Goods.class);
    public final PBRepeatMessageField<ComicIPSite.Gxzb> gxzbList = PBField.initRepeatMessage(ComicIPSite.Gxzb.class);
    public final PBStringField ipContent = PBField.initString("");
    public final PBStringField ipDesc = PBField.initString("");
    public final PBInt32Field ipId = PBField.initInt32(0);
    public final PBStringField ipLogo = PBField.initString("");
    public final PBStringField ipName = PBField.initString("");
    public final PBStringField ipUrl = PBField.initString("");
    public final PBInt32Field itemSize = PBField.initInt32(0);
    public final PBInt32Field requestInterval = PBField.initInt32(0);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBStringField strType = PBField.initString("");
    public final PBInt32Field sub_cmd = PBField.initInt32(0);
    public final PBRepeatMessageField<ComicIPSite.Video> videoList = PBField.initRepeatMessage(ComicIPSite.Video.class);
  }
  
  public static final class Video
    extends MessageMicro<Video>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72, 80, 90, 98, 106 }, new String[] { "id", "buttonDesc", "content", "cover", "desc", "name", "endTime", "isShow", "newStartTime", "newEndTime", "redirectUrl", "videoSource", "showDate" }, new Object[] { "", "", "", "", "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", "", "" }, Video.class);
    public final PBStringField buttonDesc = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField cover = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField endTime = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBInt32Field isShow = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBInt64Field newEndTime = PBField.initInt64(0L);
    public final PBInt64Field newStartTime = PBField.initInt64(0L);
    public final PBStringField redirectUrl = PBField.initString("");
    public final PBStringField showDate = PBField.initString("");
    public final PBStringField videoSource = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.ComicIPSite
 * JD-Core Version:    0.7.0.1
 */