package tencent.im.oidb.cmd0xaea;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;

public final class Oidb_0xaea
{
  public static final class DeleteDocReq
    extends MessageMicro<DeleteDocReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "group_code", "doc_id", "copy" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, DeleteDocReq.class);
    public final PBUInt32Field copy = PBField.initUInt32(0);
    public online_docs.DocId doc_id = new online_docs.DocId();
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public Oidb_0xaea.DeleteDocReq delete_doc_req = new Oidb_0xaea.DeleteDocReq();
    public final PBBytesField pskey = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 122 }, new String[] { "delete_doc_req", "pskey" }, new Object[] { null, localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaea.Oidb_0xaea
 * JD-Core Version:    0.7.0.1
 */