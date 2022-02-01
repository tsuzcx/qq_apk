package localpb.uniteGrayTip;

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

public final class UniteGrayTip
{
  public static final class BusinessData
    extends MessageMicro<BusinessData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66, 74, 82 }, new String[] { "haveRead", "subType", "masterUin", "extUin", "taskId", "editState", "editTime", "editMsgData", "caidanAnimUrl", "caidanAnimUrlMd5" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Long.valueOf(0L), "", "", "" }, BusinessData.class);
    public final PBStringField caidanAnimUrl = PBField.initString("");
    public final PBStringField caidanAnimUrlMd5 = PBField.initString("");
    public final PBStringField editMsgData = PBField.initString("");
    public final PBUInt32Field editState = PBField.initUInt32(0);
    public final PBUInt64Field editTime = PBField.initUInt64(0L);
    public final PBStringField extUin = PBField.initString("");
    public final PBUInt32Field haveRead = PBField.initUInt32(0);
    public final PBStringField masterUin = PBField.initString("");
    public final PBUInt32Field subType = PBField.initUInt32(0);
    public final PBStringField taskId = PBField.initString("");
  }
  
  public static final class HightlightParam
    extends MessageMicro<HightlightParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66, 74 }, new String[] { "start", "end", "uin", "needUpdateNick", "actionType", "icon", "textColor", "mMsgActionData", "mMsg_A_ActionData" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", "" }, HightlightParam.class);
    public final PBUInt32Field actionType = PBField.initUInt32(0);
    public final PBUInt32Field end = PBField.initUInt32(0);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField mMsgActionData = PBField.initString("");
    public final PBStringField mMsg_A_ActionData = PBField.initString("");
    public final PBUInt32Field needUpdateNick = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field textColor = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class UniteGrayTipMsg
    extends MessageMicro<UniteGrayTipMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public UniteGrayTip.BusinessData business_data = new UniteGrayTip.BusinessData();
    public final PBBytesField business_related = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field graytip_id = PBField.initUInt32(0);
    public final PBStringField graytip_key = PBField.initString("");
    public final PBUInt32Field graytip_level = PBField.initUInt32(0);
    public final PBRepeatField<Integer> graytip_mutex_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<UniteGrayTip.HightlightParam> hightlight_item = PBField.initRepeatMessage(UniteGrayTip.HightlightParam.class);
    public final PBUInt32Field isLocalTroopMsg = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 74 }, new String[] { "graytip_id", "graytip_level", "graytip_mutex_id", "graytip_key", "content", "business_related", "hightlight_item", "isLocalTroopMsg", "business_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", localByteStringMicro, null, Integer.valueOf(0), null }, UniteGrayTipMsg.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     localpb.uniteGrayTip.UniteGrayTip
 * JD-Core Version:    0.7.0.1
 */