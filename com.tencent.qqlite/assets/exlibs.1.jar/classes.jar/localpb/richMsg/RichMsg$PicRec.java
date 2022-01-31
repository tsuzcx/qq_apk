package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RichMsg$PicRec
  extends MessageMicro
{
  public static final int BIGMSGURL_FIELD_NUMBER = 9;
  public static final int FILESIZEFLAG_FIELD_NUMBER = 11;
  public static final int FOWARDINFO_FIELD_NUMBER = 13;
  public static final int GROUPFILEID_FIELD_NUMBER = 17;
  public static final int ISREAD_FIELD_NUMBER = 4;
  public static final int ISREPORT_FIELD_NUMBER = 16;
  public static final int LOCALPATH_FIELD_NUMBER = 1;
  public static final int LOCALUUID_FIELD_NUMBER = 18;
  public static final int MD5_FIELD_NUMBER = 6;
  public static final int PREDOWNNETWORK_FIELD_NUMBER = 20;
  public static final int PREDOWNSTATE_FIELD_NUMBER = 19;
  public static final int PREVIEWED_FIELD_NUMBER = 21;
  public static final int RAWMSGURL_FIELD_NUMBER = 10;
  public static final int SERVERSTORAGESOURCE_FIELD_NUMBER = 7;
  public static final int SIZE_FIELD_NUMBER = 2;
  public static final int THUMBMSGURL_FIELD_NUMBER = 8;
  public static final int TYPE_FIELD_NUMBER = 3;
  public static final int UINT32_HEIGHT_FIELD_NUMBER = 25;
  public static final int UINT32_IMAGE_TYPE_FIELD_NUMBER = 26;
  public static final int UINT32_THUMB_HEIGHT_FIELD_NUMBER = 23;
  public static final int UINT32_THUMB_WIDTH_FIELD_NUMBER = 22;
  public static final int UINT32_WIDTH_FIELD_NUMBER = 24;
  public static final int UIOPERATORFLAG_FIELD_NUMBER = 12;
  public static final int UUID_FIELD_NUMBER = 5;
  public static final int VERSION_FIELD_NUMBER = 15;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66, 74, 82, 88, 96, 106, 120, 128, 136, 146, 152, 160, 168, 176, 184, 192, 200, 208 }, new String[] { "localPath", "size", "type", "isRead", "uuid", "md5", "serverStorageSource", "thumbMsgUrl", "bigMsgUrl", "rawMsgUrl", "fileSizeFlag", "uiOperatorFlag", "fowardInfo", "version", "isReport", "groupFileID", "localUUID", "preDownState", "preDownNetwork", "previewed", "uint32_thumb_width", "uint32_thumb_height", "uint32_width", "uint32_height", "uint32_image_type" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PicRec.class);
  public final PBStringField bigMsgUrl = PBField.initString("");
  public final PBInt32Field fileSizeFlag = PBField.initInt32(0);
  public RichMsg.ForwardExtra fowardInfo = new RichMsg.ForwardExtra();
  public final PBUInt64Field groupFileID = PBField.initUInt64(0L);
  public final PBBoolField isRead = PBField.initBool(false);
  public final PBInt32Field isReport = PBField.initInt32(0);
  public final PBStringField localPath = PBField.initString("");
  public final PBStringField localUUID = PBField.initString("");
  public final PBStringField md5 = PBField.initString("");
  public final PBInt32Field preDownNetwork = PBField.initInt32(0);
  public final PBInt32Field preDownState = PBField.initInt32(0);
  public final PBInt32Field previewed = PBField.initInt32(0);
  public final PBStringField rawMsgUrl = PBField.initString("");
  public final PBStringField serverStorageSource = PBField.initString("");
  public final PBUInt64Field size = PBField.initUInt64(0L);
  public final PBStringField thumbMsgUrl = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBInt32Field uiOperatorFlag = PBField.initInt32(0);
  public final PBUInt32Field uint32_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_image_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_width = PBField.initUInt32(0);
  public final PBStringField uuid = PBField.initString("");
  public final PBInt32Field version = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     localpb.richMsg.RichMsg.PicRec
 * JD-Core Version:    0.7.0.1
 */