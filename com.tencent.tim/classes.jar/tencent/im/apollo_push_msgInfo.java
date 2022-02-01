package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class apollo_push_msgInfo
{
  public static final class STPushMsgElem
    extends MessageMicro<STPushMsgElem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114 }, new String[] { "type", "showPlace", "priority", "pm1", "pm2", "pm3", "pm4" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null }, STPushMsgElem.class);
    public STPushMsgElem0x1 pm1 = new STPushMsgElem0x1();
    public STPushMsgElem0x2 pm2 = new STPushMsgElem0x2();
    public final PBRepeatMessageField<STPushMsgElem0x3> pm3 = PBField.initRepeatMessage(STPushMsgElem0x3.class);
    public final PBRepeatMessageField<STPushMsgElem0x4> pm4 = PBField.initRepeatMessage(STPushMsgElem0x4.class);
    public final PBInt32Field priority = PBField.initInt32(0);
    public final PBUInt32Field showPlace = PBField.initUInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    
    public static final class STPushMsgElem0x1
      extends MessageMicro<STPushMsgElem0x1>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "actionId", "actionType", "sendUin", "rcvUin", "aioType", "sessionId", "wordType", "diyWords" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "" }, STPushMsgElem0x1.class);
      public final PBInt32Field actionId = PBField.initInt32(0);
      public final PBInt32Field actionType = PBField.initInt32(0);
      public final PBInt32Field aioType = PBField.initInt32(0);
      public final PBStringField diyWords = PBField.initString("");
      public final PBUInt64Field rcvUin = PBField.initUInt64(0L);
      public final PBUInt64Field sendUin = PBField.initUInt64(0L);
      public final PBUInt64Field sessionId = PBField.initUInt64(0L);
      public final PBInt32Field wordType = PBField.initInt32(0);
    }
    
    public static final class STPushMsgElem0x2
      extends MessageMicro<STPushMsgElem0x2>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "toUin", "actionId", "endTs", "wordType", "diyWords" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "" }, STPushMsgElem0x2.class);
      public final PBInt32Field actionId = PBField.initInt32(0);
      public final PBStringField diyWords = PBField.initString("");
      public final PBUInt64Field endTs = PBField.initUInt64(0L);
      public final PBUInt64Field toUin = PBField.initUInt64(0L);
      public final PBInt32Field wordType = PBField.initInt32(0);
    }
    
    public static final class STPushMsgElem0x3
      extends MessageMicro<STPushMsgElem0x3>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 74, 82, 88, 98 }, new String[] { "busType", "busId", "dotId", "priority", "begTs", "endTs", "wording", "url", "theme", "actId", "spRegion", "folderIconUrl" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "" }, STPushMsgElem0x3.class);
      public final PBStringField actId = PBField.initString("");
      public final PBUInt32Field begTs = PBField.initUInt32(0);
      public final PBUInt32Field busId = PBField.initUInt32(0);
      public final PBUInt32Field busType = PBField.initUInt32(0);
      public final PBUInt32Field dotId = PBField.initUInt32(0);
      public final PBUInt32Field endTs = PBField.initUInt32(0);
      public final PBStringField folderIconUrl = PBField.initString("");
      public final PBUInt32Field priority = PBField.initUInt32(0);
      public final PBUInt32Field spRegion = PBField.initUInt32(0);
      public final PBStringField theme = PBField.initString("");
      public final PBStringField url = PBField.initString("");
      public final PBStringField wording = PBField.initString("");
    }
    
    public static final class STPushMsgElem0x4
      extends MessageMicro<STPushMsgElem0x4>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "appid", "name", "srcVer", "newVer" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, STPushMsgElem0x4.class);
      public final PBUInt32Field appid = PBField.initUInt32(0);
      public final PBStringField name = PBField.initString("");
      public final PBUInt32Field newVer = PBField.initUInt32(0);
      public final PBUInt32Field srcVer = PBField.initUInt32(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.apollo_push_msgInfo
 * JD-Core Version:    0.7.0.1
 */