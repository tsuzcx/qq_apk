package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UniteSearch
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field client_has_people_and_qun = PBField.initUInt32(0);
    public DynamicSearch.ExtensionRequestInfo extension_request_info = new DynamicSearch.ExtensionRequestInfo();
    public final PBUInt32Field from_action = PBField.initUInt32(0);
    public final PBUInt32Field from_tabbar_index = PBField.initUInt32(0);
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field locate_result_count = PBField.initUInt32(0);
    public DynamicSearch.RootSearcherRequest req_entity = new DynamicSearch.RootSearcherRequest();
    public DynamicSearch.RootSearcherRequest req_topic = new DynamicSearch.RootSearcherRequest();
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64, 72, 802 }, new String[] { "key_word", "version", "req_entity", "req_topic", "from_action", "client_has_people_and_qun", "from_tabbar_index", "source", "locate_result_count", "extension_request_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie_topic = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField error_msg = PBField.initString("");
    public final PBUInt32Field is_end_topic = PBField.initUInt32(0);
    public final PBRepeatMessageField<DynamicSearch.ResultItemGroup> item_groups = PBField.initRepeatMessage(DynamicSearch.ResultItemGroup.class);
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBBytesField search_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<UniteSearch.TabItemGroup> tab_groups = PBField.initRepeatMessage(UniteSearch.TabItemGroup.class);
    public final PBUInt32Field trigger_netword_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 64 }, new String[] { "result_code", "error_msg", "item_groups", "tab_groups", "is_end_topic", "cookie_topic", "search_ver", "trigger_netword_num" }, new Object[] { Integer.valueOf(0), "", null, null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, RspBody.class);
    }
  }
  
  public static final class TabItemGroup
    extends MessageMicro<TabItemGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<Long> rpt_group_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBytesField tab_name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 24 }, new String[] { "tab_name", "rpt_group_mask" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, TabItemGroup.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pb.unite.search.UniteSearch
 * JD-Core Version:    0.7.0.1
 */