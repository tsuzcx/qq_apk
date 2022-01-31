package tencent.im.kqq.searchgroup;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SearchGroup$GroupClusterInfo
  extends MessageMicro
{
  public static final int DWGROUPNUM_FIELD_NUMBER = 2;
  public static final int DWISEND_FIELD_NUMBER = 1;
  public static final int DWTOTALSEARCHNUM_FIELD_NUMBER = 4;
  public static final int VGROUPINFO_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "dwIsEnd", "dwGroupNum", "vGroupInfo", "dwTotalSearchNum" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(0) }, GroupClusterInfo.class);
  public final PBUInt32Field dwGroupNum = PBField.initUInt32(0);
  public final PBUInt32Field dwIsEnd = PBField.initUInt32(1);
  public final PBUInt32Field dwTotalSearchNum = PBField.initUInt32(0);
  public final PBRepeatMessageField vGroupInfo = PBField.initRepeatMessage(SearchGroup.GroupInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.kqq.searchgroup.SearchGroup.GroupClusterInfo
 * JD-Core Version:    0.7.0.1
 */