package tencent.im.kqq.searchgroup;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SearchGroup$SearchGroupReq
  extends MessageMicro
{
  public static final int DWNEXTRECTIME_FIELD_NUMBER = 8;
  public static final int DWPAGENO_FIELD_NUMBER = 4;
  public static final int DWREQUINNUM_FIELD_NUMBER = 3;
  public static final int DWVERSION_FIELD_NUMBER = 2;
  public static final int EGROUPSORTTYPE_FIELD_NUMBER = 7;
  public static final int ESUBCMD_FIELD_NUMBER = 5;
  public static final int QWUIN_FIELD_NUMBER = 1;
  public static final int SREQCONTENT_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64 }, new String[] { "qwUin", "dwVersion", "dwReqUinNum", "dwPageNo", "eSubCmd", "sReqContent", "eGroupSortType", "dwNextRecTime" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf(0) }, SearchGroupReq.class);
  public final PBUInt32Field dwNextRecTime = PBField.initUInt32(0);
  public final PBUInt32Field dwPageNo = PBField.initUInt32(0);
  public final PBUInt32Field dwReqUinNum = PBField.initUInt32(0);
  public final PBUInt32Field dwVersion = PBField.initUInt32(0);
  public final PBEnumField eGroupSortType = PBField.initEnum(1);
  public final PBEnumField eSubCmd = PBField.initEnum(1);
  public final PBUInt64Field qwUin = PBField.initUInt64(0L);
  public final PBStringField sReqContent = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.kqq.searchgroup.SearchGroup.SearchGroupReq
 * JD-Core Version:    0.7.0.1
 */