package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_common
{
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int GROUP_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "group_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1) }, GroupInfo.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBEnumField group_type = PBField.initEnum(1);
  }
  
  public static final class Signature
    extends MessageMicro<Signature>
  {
    public static final int KEY_TYPE_FIELD_NUMBER = 1;
    public static final int SESSION_APP_ID_FIELD_NUMBER = 2;
    public static final int SESSION_KEY_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field key_type = PBField.initUInt32(0);
    public final PBUInt32Field session_app_id = PBField.initUInt32(0);
    public final PBBytesField session_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "key_type", "session_app_id", "session_key" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, Signature.class);
    }
  }
  
  public static final class Token
    extends MessageMicro<Token>
  {
    public static final int BUF_FIELD_NUMBER = 1;
    public static final int C2C_TYPE_FIELD_NUMBER = 2;
    public static final int SERVICE_TYPE_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "buf", "c2c_type", "service_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, Token.class);
    }
  }
  
  public static final class User
    extends MessageMicro<User>
  {
    public static final int APP_ID_FIELD_NUMBER = 2;
    public static final int APP_TYPE_FIELD_NUMBER = 4;
    public static final int CLIENT_IP_FIELD_NUMBER = 5;
    public static final int EQUIP_KEY_FIELD_NUMBER = 10;
    public static final int INSTANCE_ID_FIELD_NUMBER = 3;
    public static final int LANGUAGE_FIELD_NUMBER = 9;
    public static final int PLATFORM_ID_FIELD_NUMBER = 8;
    public static final int STR_PHONE_NUMBER_FIELD_NUMBER = 7;
    public static final int UIN_FIELD_NUMBER = 1;
    public static final int VERSION_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field app_id = PBField.initUInt32(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBFixed32Field client_ip = PBField.initFixed32(0);
    public final PBBytesField equip_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field instance_id = PBField.initUInt32(0);
    public final PBUInt32Field language = PBField.initUInt32(0);
    public final PBUInt32Field platform_id = PBField.initUInt32(0);
    public final PBStringField str_phone_number = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBUInt32Field version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 45, 48, 58, 64, 72, 82 }, new String[] { "uin", "app_id", "instance_id", "app_type", "client_ip", "version", "str_phone_number", "platform_id", "language", "equip_key" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, User.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.msg.im_common
 * JD-Core Version:    0.7.0.1
 */