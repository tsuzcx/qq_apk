package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RichMsg$PttRec
  extends MessageMicro
{
  public static final int EXPANDSTT_FIELD_NUMBER = 14;
  public static final int GROUPFILEID_FIELD_NUMBER = 11;
  public static final int GROUP_FILE_KEY_FIELD_NUMBER = 15;
  public static final int ISREAD_FIELD_NUMBER = 4;
  public static final int ISREPORT_FIELD_NUMBER = 9;
  public static final int LOCALPATH_FIELD_NUMBER = 1;
  public static final int LONGPTTVIPFLAG_FIELD_NUMBER = 13;
  public static final int MD5_FIELD_NUMBER = 6;
  public static final int PTTFLAG_FIELD_NUMBER = 10;
  public static final int SERVERSTORAGESOURCE_FIELD_NUMBER = 7;
  public static final int SIZE_FIELD_NUMBER = 2;
  public static final int STTTEXT_FIELD_NUMBER = 12;
  public static final int TYPE_FIELD_NUMBER = 3;
  public static final int UUID_FIELD_NUMBER = 5;
  public static final int VERSION_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 64, 72, 80, 88, 98, 104, 112, 122 }, new String[] { "localPath", "size", "type", "isRead", "uuid", "md5", "serverStorageSource", "version", "isReport", "pttFlag", "groupFileID", "sttText", "longPttVipFlag", "expandStt", "group_file_key" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Boolean.valueOf(false), "" }, PttRec.class);
  public final PBBoolField expandStt = PBField.initBool(false);
  public final PBUInt64Field groupFileID = PBField.initUInt64(0L);
  public final PBStringField group_file_key = PBField.initString("");
  public final PBBoolField isRead = PBField.initBool(false);
  public final PBInt32Field isReport = PBField.initInt32(0);
  public final PBStringField localPath = PBField.initString("");
  public final PBInt32Field longPttVipFlag = PBField.initInt32(0);
  public final PBStringField md5 = PBField.initString("");
  public final PBInt32Field pttFlag = PBField.initInt32(0);
  public final PBStringField serverStorageSource = PBField.initString("");
  public final PBUInt64Field size = PBField.initUInt64(0L);
  public final PBStringField sttText = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField uuid = PBField.initString("");
  public final PBInt32Field version = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     localpb.richMsg.RichMsg.PttRec
 * JD-Core Version:    0.7.0.1
 */