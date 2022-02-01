package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FavoriteCKVData
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
  
  public static final class FavoriteItem
    extends MessageMicro<FavoriteItem>
  {
    public static final int Kandian = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 802 }, new String[] { "uint32_favorite_source", "msg_kandian_favorite_item" }, new Object[] { Integer.valueOf(0), null }, FavoriteItem.class);
    public FavoriteCKVData.KandianFavoriteItem msg_kandian_favorite_item = new FavoriteCKVData.KandianFavoriteItem();
    public final PBUInt32Field uint32_favorite_source = PBField.initUInt32(0);
  }
  
  public static final class FavoriteSummary
    extends MessageMicro<FavoriteSummary>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18 }, new String[] { "msg_link_summary" }, new Object[] { null }, FavoriteSummary.class);
    public FavoriteCKVData.LinkSummary msg_link_summary = new FavoriteCKVData.LinkSummary();
  }
  
  public static final class KandianFavoriteBizData
    extends MessageMicro<KandianFavoriteBizData>
  {
    public static final int Article = 1;
    public static final int PictureCollection = 3;
    public static final int Video = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_account_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_account_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72 }, new String[] { "bytes_rowkey", "uint32_type", "uint32_video_duration", "uint32_pic_num", "uint64_account_id", "bytes_account_name", "uint32_video_type", "uint64_feeds_id", "uint32_feeds_type" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, KandianFavoriteBizData.class);
    }
  }
  
  public static final class KandianFavoriteItem
    extends MessageMicro<KandianFavoriteItem>
  {
    public static final int Link = 2;
    public static final int Valid = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public FavoriteCKVData.Author msg_author = new FavoriteCKVData.Author();
    public FavoriteCKVData.KandianFavoriteBizData msg_favorite_ext_info = new FavoriteCKVData.KandianFavoriteBizData();
    public FavoriteCKVData.FavoriteSummary msg_favorite_summary = new FavoriteCKVData.FavoriteSummary();
    public final PBRepeatField<ByteStringMicro> rpt_bytes_cid = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_data_sync_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_favorite_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_modify_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 64, 72, 82 }, new String[] { "msg_favorite_ext_info", "rpt_bytes_cid", "uint32_type", "uint32_status", "msg_author", "uint64_create_time", "uint64_favorite_time", "uint64_modify_time", "uint64_data_sync_time", "msg_favorite_summary" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null }, KandianFavoriteItem.class);
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
    public final PBRepeatMessageField<FavoriteCKVData.PicInfo> rpt_msg_pic_info = PBField.initRepeatMessage(FavoriteCKVData.PicInfo.class);
    
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
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_note = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uri = PBField.initBytes(ByteStringMicro.EMPTY);
    public FavoriteCKVData.Author msg_owner = new FavoriteCKVData.Author();
    public final PBUInt32Field uint32_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72, 82, 90 }, new String[] { "bytes_uri", "bytes_md5", "bytes_sha1", "bytes_name", "bytes_note", "uint32_width", "uint32_height", "uint32_size", "uint32_type", "msg_owner", "bytes_pic_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro6 }, PicInfo.class);
    }
  }
  
  public static final class UserFavoriteList
    extends MessageMicro<UserFavoriteList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 802 }, new String[] { "uint64_uin", "uint64_modify_ts", "rpt_msg_favorite_items" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null }, UserFavoriteList.class);
    public final PBRepeatMessageField<FavoriteCKVData.FavoriteItem> rpt_msg_favorite_items = PBField.initRepeatMessage(FavoriteCKVData.FavoriteItem.class);
    public final PBUInt64Field uint64_modify_ts = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.FavoriteCKVData
 * JD-Core Version:    0.7.0.1
 */