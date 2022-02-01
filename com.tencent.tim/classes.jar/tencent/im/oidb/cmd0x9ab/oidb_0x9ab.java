package tencent.im.oidb.cmd0x9ab;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x9ab
{
  public static final class GroupTabList
    extends MessageMicro<GroupTabList>
  {
    public static final int RPT_TAB_LIST_FIELD_NUMBER = 2;
    public static final int UINT32_CURR_TAB_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_curr_tab_id", "rpt_tab_list" }, new Object[] { Integer.valueOf(0), null }, GroupTabList.class);
    public final PBRepeatMessageField<oidb_0x9ab.TabItem> rpt_tab_list = PBField.initRepeatMessage(oidb_0x9ab.TabItem.class);
    public final PBUInt32Field uint32_curr_tab_id = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int UINT32_TAB_ID_FIELD_NUMBER = 2;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_group_code", "uint32_tab_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int ITEM_FIELD_NUMBER = 2;
    public static final int LIST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "list", "item" }, new Object[] { null, null }, RspBody.class);
    public oidb_0x9ab.TabItem item = new oidb_0x9ab.TabItem();
    public oidb_0x9ab.GroupTabList list = new oidb_0x9ab.GroupTabList();
  }
  
  public static final class TabItem
    extends MessageMicro<TabItem>
  {
    public static final int BYT_TAB_URL_FIELD_NUMBER = 3;
    public static final int BYT_TAB_WORDING_FIELD_NUMBER = 2;
    public static final int UINT32_STATUS_FLAG_FIELD_NUMBER = 4;
    public static final int UINT32_TAB_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField byt_tab_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField byt_tab_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_status_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_tab_id", "byt_tab_wording", "byt_tab_url", "uint32_status_flag" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, TabItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9ab.oidb_0x9ab
 * JD-Core Version:    0.7.0.1
 */