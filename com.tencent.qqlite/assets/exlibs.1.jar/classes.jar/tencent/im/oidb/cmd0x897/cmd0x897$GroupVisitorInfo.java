package tencent.im.oidb.cmd0x897;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x897$GroupVisitorInfo
  extends MessageMicro
{
  public static final int MSG_GROUP_NEXT_VISITOR_FIELD_NUMBER = 1;
  public static final int RPT_MSG_VISITOR_INFO_FIELD_NUMBER = 3;
  public static final int UINT32_FLAG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_group_next_visitor", "uint32_flag", "rpt_msg_visitor_info" }, new Object[] { null, Integer.valueOf(0), null }, GroupVisitorInfo.class);
  public cmd0x897.GroupNextVisitor msg_group_next_visitor = new cmd0x897.GroupNextVisitor();
  public final PBRepeatMessageField rpt_msg_visitor_info = PBField.initRepeatMessage(cmd0x897.VisitorInfo.class);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x897.cmd0x897.GroupVisitorInfo
 * JD-Core Version:    0.7.0.1
 */