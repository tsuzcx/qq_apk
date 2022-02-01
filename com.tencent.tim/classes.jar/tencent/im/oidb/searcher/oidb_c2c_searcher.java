package tencent.im.oidb.searcher;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_c2c_searcher
{
  public static final class Iterator
    extends MessageMicro<Iterator>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "complete", "uin", "key" }, new Object[] { Boolean.valueOf(false), Long.valueOf(0L), null }, Iterator.class);
    public final PBBoolField complete = PBField.initBool(false);
    public oidb_c2c_searcher.MsgKey key = new oidb_c2c_searcher.MsgKey();
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgKey
    extends MessageMicro<MsgKey>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "time", "magic", "seq" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, MsgKey.class);
    public final PBUInt32Field magic = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt64Field time = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<oidb_c2c_searcher.Iterator> friends = PBField.initRepeatMessage(oidb_c2c_searcher.Iterator.class);
    public final PBUInt32Field max_cnt = PBField.initUInt32(0);
    public final PBBytesField query = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "query", "friends", "max_cnt", "type" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<oidb_c2c_searcher.Iterator> friends = PBField.initRepeatMessage(oidb_c2c_searcher.Iterator.class);
    public final PBRepeatField<ByteStringMicro> msgs = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBEnumField result = PBField.initEnum(0);
    public final PBRepeatField<ByteStringMicro> segs = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "result", "friends", "msgs", "segs" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2 }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.searcher.oidb_c2c_searcher
 * JD-Core Version:    0.7.0.1
 */