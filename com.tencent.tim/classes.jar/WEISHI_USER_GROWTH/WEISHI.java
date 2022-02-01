package WEISHI_USER_GROWTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WEISHI
{
  public static final class stGetPersonalPageReq
    extends MessageMicro<stGetPersonalPageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "person_id", "type", "attach_info" }, new Object[] { "", Integer.valueOf(0), "" }, stGetPersonalPageReq.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBStringField person_id = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
  }
  
  public static final class stGetPersonalPageRsp
    extends MessageMicro<stGetPersonalPageRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 66, 82, 90 }, new String[] { "feed_num", "feeds", "attach_info", "personid" }, new Object[] { Integer.valueOf(0), null, "", "" }, stGetPersonalPageRsp.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBInt32Field feed_num = PBField.initInt32(0);
    public final PBRepeatMessageField<WEISHI.stMetaFeed> feeds = PBField.initRepeatMessage(WEISHI.stMetaFeed.class);
    public final PBStringField personid = PBField.initString("");
  }
  
  public static final class stMetaFeed
    extends MessageMicro<stMetaFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 58, 210, 218 }, new String[] { "id", "wording", "type", "poster_id", "images", "video_url", "material_thumburl" }, new Object[] { "", "", Integer.valueOf(0), "", null, "", "" }, stMetaFeed.class);
    public final PBStringField id = PBField.initString("");
    public final PBRepeatMessageField<WEISHI.stMetaUgcImage> images = PBField.initRepeatMessage(WEISHI.stMetaUgcImage.class);
    public final PBStringField material_thumburl = PBField.initString("");
    public final PBStringField poster_id = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField video_url = PBField.initString("");
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class stMetaUgcImage
    extends MessageMicro<stMetaUgcImage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56 }, new String[] { "url", "width", "height", "type", "sprite_width", "sprite_height", "sprite_span" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, stMetaUgcImage.class);
    public final PBInt32Field height = PBField.initInt32(0);
    public final PBInt32Field sprite_height = PBField.initInt32(0);
    public final PBInt32Field sprite_span = PBField.initInt32(0);
    public final PBInt32Field sprite_width = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field width = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     WEISHI_USER_GROWTH.WEISHI
 * JD-Core Version:    0.7.0.1
 */