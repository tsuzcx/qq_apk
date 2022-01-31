package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QPSingleUpdateProto$ReqBody
  extends MessageMicro
{
  public static final int MSG_REPORT_FIELD_NUMBER = 2;
  public static final int RPT_FILE_ITEM_LIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_file_item_list", "msg_report" }, new Object[] { null, null }, ReqBody.class);
  public QPSingleUpdateProto.UploadBody msg_report = new QPSingleUpdateProto.UploadBody();
  public final PBRepeatMessageField rpt_file_item_list = PBField.initRepeatMessage(QPSingleUpdateProto.FileItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdateProto.ReqBody
 * JD-Core Version:    0.7.0.1
 */