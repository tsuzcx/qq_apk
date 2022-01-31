package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x383$ApplyGetFileInfoRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "fileInfo" }, new Object[] { null }, ApplyGetFileInfoRspBody.class);
  public cmd0x383.ApplyGetFileListRspBody.FileInfo fileInfo = new cmd0x383.ApplyGetFileListRspBody.FileInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileInfoRspBody
 * JD-Core Version:    0.7.0.1
 */