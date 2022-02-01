package NS_MINI_USERAUTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniUserAuth
{
  public static final class StApiNameItem
    extends MessageMicro<StApiNameItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "eventName", "apiName" }, new Object[] { "", "" }, StApiNameItem.class);
    public final PBStringField apiName = PBField.initString("");
    public final PBStringField eventName = PBField.initString("");
  }
  
  public static final class StApiScopeConfig
    extends MessageMicro<StApiScopeConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "scopeList", "apiToScope" }, new Object[] { null, null }, StApiScopeConfig.class);
    public final PBRepeatMessageField<MiniUserAuth.StApiScopeEntry> apiToScope = PBField.initRepeatMessage(MiniUserAuth.StApiScopeEntry.class);
    public final PBRepeatMessageField<MiniUserAuth.StUserAuthScope> scopeList = PBField.initRepeatMessage(MiniUserAuth.StUserAuthScope.class);
  }
  
  public static final class StApiScopeEntry
    extends MessageMicro<StApiScopeEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "api", "scope" }, new Object[] { null, "" }, StApiScopeEntry.class);
    public MiniUserAuth.StApiNameItem api = new MiniUserAuth.StApiNameItem();
    public final PBStringField scope = PBField.initString("");
  }
  
  public static final class StUserAuthScope
    extends MessageMicro<StUserAuthScope>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "scope", "authType", "desc", "settingPageTitle" }, new Object[] { "", Integer.valueOf(0), "", "" }, StUserAuthScope.class);
    public final PBInt32Field authType = PBField.initInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField scope = PBField.initString("");
    public final PBStringField settingPageTitle = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_USERAUTH.MiniUserAuth
 * JD-Core Version:    0.7.0.1
 */