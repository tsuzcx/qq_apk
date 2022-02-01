package com.tencent.protofile.cmd0xe19;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.protofile.terminal_info.terminal_info.TerminalInfo;

public final class cmd0xe19
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50 }, new String[] { "source", "id", "rowkey", "task_idx", "skey", "terminal_info" }, new Object[] { Integer.valueOf(1), "", "", Integer.valueOf(0), "", null }, ReqBody.class);
    public final PBStringField id = PBField.initString("");
    public final PBStringField rowkey = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBEnumField source = PBField.initEnum(1);
    public final PBInt32Field task_idx = PBField.initInt32(0);
    public terminal_info.TerminalInfo terminal_info = new terminal_info.TerminalInfo();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 58, 66 }, new String[] { "money", "detail_wording", "has_task", "task", "button_wording", "ret", "outcome_wording", "toast" }, new Object[] { Long.valueOf(0L), "", Boolean.valueOf(false), null, "", Integer.valueOf(0), "", "" }, RspBody.class);
    public final PBStringField button_wording = PBField.initString("");
    public final PBStringField detail_wording = PBField.initString("");
    public final PBBoolField has_task = PBField.initBool(false);
    public final PBUInt64Field money = PBField.initUInt64(0L);
    public final PBStringField outcome_wording = PBField.initString("");
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public cmd0xe19.TaskRedPacket task = new cmd0xe19.TaskRedPacket();
    public final PBStringField toast = PBField.initString("");
  }
  
  public static final class TaskRedPacket
    extends MessageMicro<TaskRedPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "head", "nick", "wording" }, new Object[] { "", "", "" }, TaskRedPacket.class);
    public final PBStringField head = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField wording = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.cmd0xe19.cmd0xe19
 * JD-Core Version:    0.7.0.1
 */