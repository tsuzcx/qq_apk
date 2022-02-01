package tencent.im.oidb.cmd0xaf3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xae9.group_online_docs.DocInfo;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;

public final class Oidb_0xaf3
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public online_docs.DocId doc_id = new online_docs.DocId();
    public final PBBytesField doc_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBBytesField pskey = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 122 }, new String[] { "group_code", "doc_title", "doc_id", "pskey" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, null, localByteStringMicro2 }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "doc_info" }, new Object[] { null }, RspBody.class);
    public group_online_docs.DocInfo doc_info = new group_online_docs.DocInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaf3.Oidb_0xaf3
 * JD-Core Version:    0.7.0.1
 */