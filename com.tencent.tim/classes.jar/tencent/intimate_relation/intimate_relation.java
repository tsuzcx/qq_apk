package tencent.intimate_relation;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class intimate_relation
{
  public static final class IntimateBuddy
    extends MessageMicro<IntimateBuddy>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field buddy_uin = PBField.initUInt64(0L);
    public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field chat_days = PBField.initUInt32(0);
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 802 }, new String[] { "buddy_uin", "time", "source", "level", "chat_days", "buffer" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, IntimateBuddy.class);
    }
  }
  
  public static final class IntimateInfo
    extends MessageMicro<IntimateInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64 }, new String[] { "lover", "ladybro", "buddy", "nick_name", "face_url", "is_del", "frd_uin", "modify_time" }, new Object[] { null, null, null, "", "", Boolean.valueOf(false), Long.valueOf(0L), Integer.valueOf(0) }, IntimateInfo.class);
    public intimate_relation.IntimateBuddy buddy = new intimate_relation.IntimateBuddy();
    public final PBStringField face_url = PBField.initString("");
    public final PBUInt64Field frd_uin = PBField.initUInt64(0L);
    public final PBBoolField is_del = PBField.initBool(false);
    public intimate_relation.IntimateLadybro ladybro = new intimate_relation.IntimateLadybro();
    public intimate_relation.IntimateLover lover = new intimate_relation.IntimateLover();
    public final PBUInt32Field modify_time = PBField.initUInt32(0);
    public final PBStringField nick_name = PBField.initString("");
  }
  
  public static final class IntimateLadybro
    extends MessageMicro<IntimateLadybro>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field chat_days = PBField.initUInt32(0);
    public final PBUInt64Field ladybro_uin = PBField.initUInt64(0L);
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 802 }, new String[] { "ladybro_uin", "time", "source", "level", "chat_days", "buffer" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, IntimateLadybro.class);
    }
  }
  
  public static final class IntimateLover
    extends MessageMicro<IntimateLover>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field chat_days = PBField.initUInt32(0);
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBUInt64Field lover_uin = PBField.initUInt64(0L);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 802 }, new String[] { "lover_uin", "time", "source", "level", "chat_days", "buffer" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, IntimateLover.class);
    }
  }
  
  public static final class MiddleBindInfo
    extends MessageMicro<MiddleBindInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "bind_type", "bind_time", "bind_nums", "latest_ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MiddleBindInfo.class);
    public final PBUInt32Field bind_nums = PBField.initUInt32(0);
    public final PBUInt32Field bind_time = PBField.initUInt32(0);
    public final PBUInt32Field bind_type = PBField.initUInt32(0);
    public final PBUInt32Field latest_ts = PBField.initUInt32(0);
  }
  
  public static final class SnsRelationInfo
    extends MessageMicro<SnsRelationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "intimate_list" }, new Object[] { null }, SnsRelationInfo.class);
    public final PBRepeatMessageField<intimate_relation.IntimateInfo> intimate_list = PBField.initRepeatMessage(intimate_relation.IntimateInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.intimate_relation.intimate_relation
 * JD-Core Version:    0.7.0.1
 */