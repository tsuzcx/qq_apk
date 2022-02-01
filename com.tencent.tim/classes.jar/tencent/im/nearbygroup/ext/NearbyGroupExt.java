package tencent.im.nearbygroup.ext;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group.group_label.GroupLabel.Label;
import tencent.im.troop_search_userinfo.userinfo.UserInfo;

public final class NearbyGroupExt
{
  public static final class GroupItem
    extends MessageMicro<GroupItem>
  {
    public static final int BYTES_GROUP_INTRO_FIELD_NUMBER = 3;
    public static final int BYTES_GROUP_NAME_FIELD_NUMBER = 2;
    public static final int RPT_LABEL_LIST_FIELD_NUMBER = 4;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_group_intro = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<GroupLabel.Label> rpt_label_list = PBField.initRepeatMessage(GroupLabel.Label.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_group_code", "bytes_group_name", "bytes_group_intro", "rpt_label_list" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null }, GroupItem.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int UINT32_TYPE_FIELD_NUMBER = 3;
    public static final int USER_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 24 }, new String[] { "user_info", "uint32_type" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public userinfo.UserInfo user_info = new userinfo.UserInfo();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int RPT_GROUP_LIST_FIELD_NUMBER = 2;
    public static final int STR_WORDING_FIELD_NUMBER = 3;
    public static final int UINT32_TOTAL_NUM_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_total_num", "rpt_group_list", "str_wording" }, new Object[] { Integer.valueOf(0), null, "" }, RspBody.class);
    public final PBRepeatMessageField<NearbyGroupExt.GroupItem> rpt_group_list = PBField.initRepeatMessage(NearbyGroupExt.GroupItem.class);
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field uint32_total_num = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.nearbygroup.ext.NearbyGroupExt
 * JD-Core Version:    0.7.0.1
 */