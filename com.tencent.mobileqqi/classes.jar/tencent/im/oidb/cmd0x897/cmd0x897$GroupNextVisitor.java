package tencent.im.oidb.cmd0x897;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x897$GroupNextVisitor
  extends MessageMicro
{
  public static final int MSG_GROUP_UIN_CODE_FIELD_NUMBER = 1;
  public static final int MSG_REQ_FIELD_FIELD_NUMBER = 3;
  public static final int UINT32_MAX_COUNT_FIELD_NUMBER = 4;
  public static final int UINT64_NEXT_VISITOR_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "msg_group_uin_code", "uint64_next_visitor", "msg_req_field", "uint32_max_count" }, new Object[] { null, Long.valueOf(0L), null, Integer.valueOf(0) }, GroupNextVisitor.class);
  public cmd0x897.GroupUinCode msg_group_uin_code = new cmd0x897.GroupUinCode();
  public cmd0x897.VisitorInfo msg_req_field = new cmd0x897.VisitorInfo();
  public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_next_visitor = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x897.cmd0x897.GroupNextVisitor
 * JD-Core Version:    0.7.0.1
 */