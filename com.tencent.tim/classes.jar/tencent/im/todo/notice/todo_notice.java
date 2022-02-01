package tencent.im.todo.notice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class todo_notice
{
  public static final class TodoNotice
    extends MessageMicro<TodoNotice>
  {
    public static final int NOTICE_DELETE = 3;
    public static final int NOTICE_NEW = 1;
    public static final int NOTICE_UPDATE = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_todo_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_notice_type = PBField.initEnum(1);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_notice_type", "bytes_todo_id" }, new Object[] { Integer.valueOf(1), localByteStringMicro }, TodoNotice.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.todo.notice.todo_notice
 * JD-Core Version:    0.7.0.1
 */