package NS_STORE_APP_SEARCH;

import NS_COMM.COMM.StCommonExt;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StoreAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppSearch
{
  public static final class StGetHotSearchAppsReq
    extends MessageMicro<StGetHotSearchAppsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGetHotSearchAppsReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetHotSearchAppsRsp
    extends MessageMicro<StGetHotSearchAppsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 34 }, new String[] { "extInfo", "title", "appList" }, new Object[] { null, "", null }, StGetHotSearchAppsRsp.class);
    public final PBRepeatMessageField<STORE_APP_CLIENT.StoreAppInfo> appList = PBField.initRepeatMessage(STORE_APP_CLIENT.StoreAppInfo.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField title = PBField.initString("");
  }
  
  public static final class StSearchAppReq
    extends MessageMicro<StSearchAppReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "query" }, new Object[] { null, "" }, StSearchAppReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField query = PBField.initString("");
  }
  
  public static final class StSearchAppRsp
    extends MessageMicro<StSearchAppRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "appList", "isFinished", "highlightWords" }, new Object[] { null, null, Integer.valueOf(0), "" }, StSearchAppRsp.class);
    public final PBRepeatMessageField<STORE_APP_CLIENT.StoreAppInfo> appList = PBField.initRepeatMessage(STORE_APP_CLIENT.StoreAppInfo.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatField<String> highlightWords = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field isFinished = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_STORE_APP_SEARCH.MiniAppSearch
 * JD-Core Version:    0.7.0.1
 */