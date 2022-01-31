package tencent.im.kqq.searchgroup;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SearchGroup$SearchGroupRes
  extends MessageMicro
{
  public static final int DWNEXTRECTIME_FIELD_NUMBER = 4;
  public static final int DWRESULT_FIELD_NUMBER = 1;
  public static final int SERRINFO_FIELD_NUMBER = 3;
  public static final int STGROUPCLUSTERINFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "dwResult", "stGroupClusterInfo", "sErrInfo", "dwNextRecTime" }, new Object[] { Integer.valueOf(1), null, "", Integer.valueOf(0) }, SearchGroupRes.class);
  public final PBUInt32Field dwNextRecTime = PBField.initUInt32(0);
  public final PBUInt32Field dwResult = PBField.initUInt32(1);
  public final PBStringField sErrInfo = PBField.initString("");
  public SearchGroup.GroupClusterInfo stGroupClusterInfo = new SearchGroup.GroupClusterInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.kqq.searchgroup.SearchGroup.SearchGroupRes
 * JD-Core Version:    0.7.0.1
 */