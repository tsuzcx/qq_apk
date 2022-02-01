package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_troop_hot
{
  public static final class ExtInfo
    extends MessageMicro<ExtInfo>
  {
    public static final int EXT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ext" }, new Object[] { "" }, ExtInfo.class);
    public final PBStringField ext = PBField.initString("");
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    public static final int LATITUDE_FIELD_NUMBER = 2;
    public static final int LONGTITUDE_FIELD_NUMBER = 1;
    public static final int RANGE_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "longtitude", "latitude", "range" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, GPS.class);
    public final PBUInt64Field latitude = PBField.initUInt64(0L);
    public final PBUInt64Field longtitude = PBField.initUInt64(0L);
    public final PBUInt64Field range = PBField.initUInt64(0L);
  }
  
  public static final class HotQunMsg
    extends MessageMicro<HotQunMsg>
  {
    public static final int CMD_FIELD_NUMBER = 3;
    public static final int EXT_FIELD_NUMBER = 5;
    public static final int MAGIC_FIELD_NUMBER = 1;
    public static final int MSG_REQ_BODY_FIELD_NUMBER = 10;
    public static final int MSG_RSP_BODY_FIELD_NUMBER = 11;
    public static final int SEQ_FIELD_NUMBER = 4;
    public static final int UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 82, 90 }, new String[] { "magic", "uin", "cmd", "seq", "ext", "msg_req_body", "msg_rsp_body" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, null }, HotQunMsg.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public nearby_troop_hot.ExtInfo ext = new nearby_troop_hot.ExtInfo();
    public final PBUInt32Field magic = PBField.initUInt32(0);
    public nearby_troop_hot.HotQunReq msg_req_body = new nearby_troop_hot.HotQunReq();
    public nearby_troop_hot.HotQunRsp msg_rsp_body = new nearby_troop_hot.HotQunRsp();
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class HotQunReq
    extends MessageMicro<HotQunReq>
  {
    public static final int GPS_FIELD_NUMBER = 4;
    public static final int PAGE_NUM_FIELD_NUMBER = 1;
    public static final int PAGE_SIZE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 34 }, new String[] { "page_num", "page_size", "gps" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, HotQunReq.class);
    public nearby_troop_hot.GPS gps = new nearby_troop_hot.GPS();
    public final PBUInt32Field page_num = PBField.initUInt32(0);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
  }
  
  public static final class HotQunRsp
    extends MessageMicro<HotQunRsp>
  {
    public static final int QUN_INFO_FIELD_NUMBER = 2;
    public static final int QUN_ITEM_FIELD_NUMBER = 10;
    public static final int RET_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 82 }, new String[] { "ret_info", "qun_info", "qun_item" }, new Object[] { null, null, null }, HotQunRsp.class);
    public nearby_troop_hot.QunInfo qun_info = new nearby_troop_hot.QunInfo();
    public final PBRepeatMessageField<nearby_troop_hot.QunItem> qun_item = PBField.initRepeatMessage(nearby_troop_hot.QunItem.class);
    public nearby_troop_hot.RetInfo ret_info = new nearby_troop_hot.RetInfo();
  }
  
  public static final class QunInfo
    extends MessageMicro<QunInfo>
  {
    public static final int CNT_FIELD_NUMBER = 3;
    public static final int DESC_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "title", "desc", "cnt", "url" }, new Object[] { "", "", Integer.valueOf(0), "" }, QunInfo.class);
    public final PBUInt32Field cnt = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class QunItem
    extends MessageMicro<QunItem>
  {
    public static final int DESC_FIELD_NUMBER = 3;
    public static final int GPS_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uin", "title", "desc", "gps" }, new Object[] { Long.valueOf(0L), "", "", null }, QunItem.class);
    public final PBStringField desc = PBField.initString("");
    public nearby_troop_hot.GPS gps = new nearby_troop_hot.GPS();
    public final PBStringField title = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    public static final int ERR_INFO_FIELD_NUMBER = 2;
    public static final int RET_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField err_info = PBField.initString("");
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_hot.nearby_troop_hot
 * JD-Core Version:    0.7.0.1
 */