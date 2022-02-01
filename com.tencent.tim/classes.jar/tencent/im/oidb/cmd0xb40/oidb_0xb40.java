package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb40
{
  public static final class Author
    extends MessageMicro<Author>
  {
    public static final int Email = 4;
    public static final int Group = 2;
    public static final int Phone = 5;
    public static final int TempTeam = 3;
    public static final int Uin = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_str_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_num_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint32_type", "uint64_num_id", "bytes_str_id", "uint64_group_id", "bytes_group_name" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, Author.class);
    }
  }
  
  public static final class CheckFavoriteReqBody
    extends MessageMicro<CheckFavoriteReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_rowkey = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_bytes_rowkey" }, new Object[] { localByteStringMicro }, CheckFavoriteReqBody.class);
    }
  }
  
  public static final class CheckFavoriteRspBody
    extends MessageMicro<CheckFavoriteRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_rsp_items" }, new Object[] { null }, CheckFavoriteRspBody.class);
    public final PBRepeatMessageField<oidb_0xb40.CheckFavoriteRspItem> rpt_msg_rsp_items = PBField.initRepeatMessage(oidb_0xb40.CheckFavoriteRspItem.class);
  }
  
  public static final class CheckFavoriteRspItem
    extends MessageMicro<CheckFavoriteRspItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> bytes_cid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_rowkey", "uint32_result", "bytes_cid_list" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, CheckFavoriteRspItem.class);
    }
  }
  
  public static final class FavoriteExtInfo
    extends MessageMicro<FavoriteExtInfo>
  {
    public static final int Article = 1;
    public static final int PictureCollection = 3;
    public static final int Video = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_type", "uint32_video_duration" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FavoriteExtInfo.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
  }
  
  public static final class FavoriteItem
    extends MessageMicro<FavoriteItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xb40.Author msg_author = new oidb_0xb40.Author();
    public oidb_0xb40.FavoriteExtInfo msg_favorite_ext_info = new oidb_0xb40.FavoriteExtInfo();
    public oidb_0xb40.FavoriteSummary msg_favorite_summary = new oidb_0xb40.FavoriteSummary();
    public final PBRepeatField<ByteStringMicro> rpt_bytes_cid = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt64Field uint64_favorite_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50 }, new String[] { "bytes_rowkey", "rpt_bytes_cid", "msg_author", "uint64_favorite_time", "msg_favorite_summary", "msg_favorite_ext_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Long.valueOf(0L), null, null }, FavoriteItem.class);
    }
  }
  
  public static final class FavoriteSummary
    extends MessageMicro<FavoriteSummary>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18 }, new String[] { "msg_link_summary" }, new Object[] { null }, FavoriteSummary.class);
    public oidb_0xb40.LinkSummary msg_link_summary = new oidb_0xb40.LinkSummary();
  }
  
  public static final class GetFavoriteListReqBody
    extends MessageMicro<GetFavoriteListReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_sync_cookie", "uint32_page_size" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, GetFavoriteListReqBody.class);
    }
  }
  
  public static final class GetFavoriteListRspBody
    extends MessageMicro<GetFavoriteListRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0xb40.FavoriteItem> rpt_msg_favorite_items = PBField.initRepeatMessage(oidb_0xb40.FavoriteItem.class);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "bytes_next_cookie", "uint32_is_end", "uint32_total", "rpt_msg_favorite_items" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, GetFavoriteListRspBody.class);
    }
  }
  
  public static final class LinkSummary
    extends MessageMicro<LinkSummary>
  {
    public static final int Audio = 2;
    public static final int Video = 1;
    public static final int Web = 0;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_brief = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_publisher = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_resource_uri = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_type = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uri = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0xb40.PicInfo> rpt_msg_pic_info = PBField.initRepeatMessage(oidb_0xb40.PicInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "bytes_uri", "bytes_title", "bytes_publisher", "bytes_brief", "rpt_msg_pic_info", "bytes_type", "bytes_resource_uri" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, localByteStringMicro5, localByteStringMicro6 }, LinkSummary.class);
    }
  }
  
  public static final class PicInfo
    extends MessageMicro<PicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uri = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_uri" }, new Object[] { localByteStringMicro }, PicInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_check_favorite_req", "msg_get_favorite_list_req" }, new Object[] { null, null }, ReqBody.class);
    public oidb_0xb40.CheckFavoriteReqBody msg_check_favorite_req = new oidb_0xb40.CheckFavoriteReqBody();
    public oidb_0xb40.GetFavoriteListReqBody msg_get_favorite_list_req = new oidb_0xb40.GetFavoriteListReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_check_favorite_rsp", "msg_get_favorite_list_rsp" }, new Object[] { null, null }, RspBody.class);
    public oidb_0xb40.CheckFavoriteRspBody msg_check_favorite_rsp = new oidb_0xb40.CheckFavoriteRspBody();
    public oidb_0xb40.GetFavoriteListRspBody msg_get_favorite_list_rsp = new oidb_0xb40.GetFavoriteListRspBody();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb40.oidb_0xb40
 * JD-Core Version:    0.7.0.1
 */