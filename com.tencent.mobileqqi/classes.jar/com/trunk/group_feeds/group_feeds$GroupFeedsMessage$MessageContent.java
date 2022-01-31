package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_feeds$GroupFeedsMessage$MessageContent
  extends MessageMicro
{
  public static final int ACCEPTURL_FIELD_NUMBER = 10;
  public static final int BYTES_BRIEF_FIELD_NUMBER = 39;
  public static final int BYTES_URL_FOR_PICVIEWER_FIELD_NUMBER = 36;
  public static final int CLIPPIC = 7;
  public static final int CLIP_FILEID_FIELD_NUMBER = 22;
  public static final int CLIP_FROMUIN_FIELD_NUMBER = 20;
  public static final int CLIP_GROUPUIN_FIELD_NUMBER = 21;
  public static final int CLIP_MD5_FIELD_NUMBER = 23;
  public static final int CLIP_URL_FIELD_NUMBER = 24;
  public static final int CONTROL = 14;
  public static final int C_GALLIANCE_QT_EVENT = 11;
  public static final int C_GALLIANCE_QT_NOCTICE = 12;
  public static final int C_VOTE = 9;
  public static final int FACE = 2;
  public static final int FACE_IDX_FIELD_NUMBER = 25;
  public static final int FILE = 5;
  public static final int GBK_FACE = 8;
  public static final int LINK = 1;
  public static final int MUSIC = 4;
  public static final int MUSICID_FIELD_NUMBER = 8;
  public static final int MUSICNAME_FIELD_NUMBER = 9;
  public static final int OBJ_IN_XML = 13;
  public static final int PIC = 3;
  public static final int PIC_ID_FIELD_NUMBER = 5;
  public static final int PIC_MD5_FIELD_NUMBER = 15;
  public static final int PIC_PATH_FIELD_NUMBER = 4;
  public static final int PIC_SIZE_FIELD_NUMBER = 3;
  public static final int PIC_URL_FIELD_NUMBER = 6;
  public static final int QT_LIVE_END_TIME_FIELD_NUMBER = 33;
  public static final int QT_LIVE_START_TIME_FIELD_NUMBER = 32;
  public static final int QT_ROOM_FIELD_NUMBER = 34;
  public static final int REFUSEURL_FIELD_NUMBER = 11;
  public static final int REF_QT_EVENT_FEED_ID_FIELD_NUMBER = 35;
  public static final int SHAREATTR_FIELD_NUMBER = 31;
  public static final int SHAREFILE_FIELD_NUMBER = 12;
  public static final int SHAREMD5_FIELD_NUMBER = 30;
  public static final int SHAREORI_FIELD_NUMBER = 14;
  public static final int SHARESHA_FIELD_NUMBER = 28;
  public static final int SHARESIZE_FIELD_NUMBER = 27;
  public static final int SHARETRISHA_FIELD_NUMBER = 29;
  public static final int SHAREURL_FIELD_NUMBER = 13;
  public static final int TEXT = 0;
  public static final int TITLE = 10;
  public static final int TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_PICVIEWER_HEIGHT_FIELD_NUMBER = 38;
  public static final int UINT32_PICVIEWER_WIDTH_FIELD_NUMBER = 37;
  public static final int USERID_FIELD_NUMBER = 7;
  public static final int VALUE_FIELD_NUMBER = 2;
  public static final int VIDEO = 6;
  public static final int VIDEOFILE_FIELD_NUMBER = 16;
  public static final int VIDEOID_FIELD_NUMBER = 18;
  public static final int VIDEOINTRO_FIELD_NUMBER = 19;
  public static final int VIDEOSOURCE_FIELD_NUMBER = 26;
  public static final int VIDEOURL_FIELD_NUMBER = 17;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField accepturl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_brief = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url_for_picviewer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field clip_fileid = PBField.initFixed32(0);
  public final PBFixed32Field clip_fromuin = PBField.initFixed32(0);
  public final PBFixed32Field clip_groupuin = PBField.initFixed32(0);
  public final PBBytesField clip_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField clip_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field face_idx = PBField.initInt32(0);
  public final PBFixed32Field musicid = PBField.initFixed32(0);
  public final PBBytesField musicname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_size = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field qt_live_end_time = PBField.initFixed32(0);
  public final PBFixed32Field qt_live_start_time = PBField.initFixed32(0);
  public final PBBytesField qt_room = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField ref_qt_event_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField refuseurl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field shareattr = PBField.initUInt32(0);
  public final PBBytesField sharefile = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField sharemd5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField shareori = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField sharesha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field sharesize = PBField.initUInt64(0L);
  public final PBBytesField sharetrisha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField shareurl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField type = PBField.initEnum(0);
  public final PBUInt32Field uint32_picviewer_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_picviewer_width = PBField.initUInt32(0);
  public final PBBytesField userid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField videofile = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField videoid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField videointro = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField videosource = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField videourl = PBField.initBytes(ByteStringMicro.EMPTY);
  
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
    ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro16 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro17 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro18 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro19 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro20 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro21 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro22 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro23 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro24 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro25 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro26 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro27 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 69, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 165, 173, 181, 186, 194, 200, 210, 216, 226, 234, 242, 248, 261, 269, 274, 282, 290, 296, 304, 314 }, new String[] { "type", "value", "pic_size", "pic_path", "pic_id", "pic_url", "userid", "musicid", "musicname", "accepturl", "refuseurl", "sharefile", "shareurl", "shareori", "pic_md5", "videofile", "videourl", "videoid", "videointro", "clip_fromuin", "clip_groupuin", "clip_fileid", "clip_md5", "clip_url", "face_idx", "videosource", "sharesize", "sharesha", "sharetrisha", "sharemd5", "shareattr", "qt_live_start_time", "qt_live_end_time", "qt_room", "ref_qt_event_feed_id", "bytes_url_for_picviewer", "uint32_picviewer_width", "uint32_picviewer_height", "bytes_brief" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro18, localByteStringMicro19, Integer.valueOf(0), localByteStringMicro20, Long.valueOf(0L), localByteStringMicro21, localByteStringMicro22, localByteStringMicro23, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro24, localByteStringMicro25, localByteStringMicro26, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro27 }, MessageContent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage.MessageContent
 * JD-Core Version:    0.7.0.1
 */