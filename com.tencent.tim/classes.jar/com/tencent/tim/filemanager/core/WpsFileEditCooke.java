package com.tencent.tim.filemanager.core;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WpsFileEditCooke
{
  public static final class EditCookeData
    extends MessageMicro<EditCookeData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field bus_type = PBField.initInt32(0);
    public final PBBytesField bytes_cloud_dirkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cloud_fileid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field edit_start_time = PBField.initUInt64(0L);
    public final PBUInt64Field entity_sessionid = PBField.initUInt64(0L);
    public final PBUInt64Field last_modify_time = PBField.initUInt64(0L);
    public final PBUInt64Field sessionid = PBField.initUInt64(0L);
    public final PBStringField str_cloud_showname = PBField.initString("");
    public final PBStringField str_disc_fileid = PBField.initString("");
    public final PBStringField str_filepath = PBField.initString("");
    public final PBStringField str_group_fileid = PBField.initString("");
    public final PBStringField str_uuid = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 66, 74, 82, 88, 96 }, new String[] { "sessionid", "edit_start_time", "str_filepath", "bus_type", "str_uuid", "str_disc_fileid", "str_group_fileid", "bytes_cloud_fileid", "bytes_cloud_dirkey", "str_cloud_showname", "last_modify_time", "entity_sessionid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), "", "", "", localByteStringMicro1, localByteStringMicro2, "", Long.valueOf(0L), Long.valueOf(0L) }, EditCookeData.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.WpsFileEditCooke
 * JD-Core Version:    0.7.0.1
 */