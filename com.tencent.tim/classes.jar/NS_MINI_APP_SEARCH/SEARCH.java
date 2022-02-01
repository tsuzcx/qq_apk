package NS_MINI_APP_SEARCH;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SEARCH
{
  public static final class StAppSearchItem
    extends MessageMicro<StAppSearchItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "appid", "appname", "appIcon", "desc", "showMask" }, new Object[] { "", "", "", "", Integer.valueOf(0) }, StAppSearchItem.class);
    public final PBStringField appIcon = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField appname = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBInt32Field showMask = PBField.initInt32(0);
  }
  
  public static final class StLocalSearchDataReq
    extends MessageMicro<StLocalSearchDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StLocalSearchDataReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StLocalSearchDataRsp
    extends MessageMicro<StLocalSearchDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "status", "items" }, new Object[] { null, Integer.valueOf(0), null }, StLocalSearchDataRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<SEARCH.StAppSearchItem> items = PBField.initRepeatMessage(SEARCH.StAppSearchItem.class);
    public final PBInt32Field status = PBField.initInt32(0);
  }
  
  public static final class StSearchMiniAppReq
    extends MessageMicro<StSearchMiniAppReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "query", "pageSize" }, new Object[] { null, "", Integer.valueOf(0) }, StSearchMiniAppReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field pageSize = PBField.initInt32(0);
    public final PBStringField query = PBField.initString("");
  }
  
  public static final class StSearchMiniAppRsp
    extends MessageMicro<StSearchMiniAppRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "items", "hasmore", "highlightWords" }, new Object[] { null, null, Boolean.valueOf(false), "" }, StSearchMiniAppRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBBoolField hasmore = PBField.initBool(false);
    public final PBRepeatField<String> highlightWords = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<SEARCH.StAppSearchItem> items = PBField.initRepeatMessage(SEARCH.StAppSearchItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_APP_SEARCH.SEARCH
 * JD-Core Version:    0.7.0.1
 */