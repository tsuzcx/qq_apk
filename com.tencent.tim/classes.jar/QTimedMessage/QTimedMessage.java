package QTimedMessage;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QTimedMessage
{
  public static final class C2CMessage
    extends MessageMicro<C2CMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public QTimedMessage.User msg_from_user = new QTimedMessage.User();
    public QTimedMessage.Client msg_recv_client = new QTimedMessage.Client();
    public RichText msg_rich_text = new RichText();
    public QTimedMessage.User msg_to_user = new QTimedMessage.User();
    public final PBUInt32Field uint32_send_rich_text_standalone = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_text_standalone = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56 }, new String[] { "msg_from_user", "msg_to_user", "msg_recv_client", "bytes_text", "msg_rich_text", "uint32_send_text_standalone", "uint32_send_rich_text_standalone" }, new Object[] { null, null, null, localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0) }, C2CMessage.class);
    }
    
    public static final class RichText
      extends MessageMicro<RichText>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_template_1 = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt32Field uint32_gift_id = PBField.initUInt32(0);
      public final PBUInt32Field uint32_service_id = PBField.initUInt32(0);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_template_1", "uint32_service_id", "uint32_gift_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RichText.class);
      }
    }
  }
  
  public static final class Client
    extends MessageMicro<Client>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_PC", "uint32_Mobile" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Client.class);
    public final PBUInt32Field uint32_Mobile = PBField.initUInt32(0);
    public final PBUInt32Field uint32_PC = PBField.initUInt32(0);
  }
  
  public static final class Content
    extends MessageMicro<Content>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public QTimedMessage.C2CMessage msg_c2c_message = new QTimedMessage.C2CMessage();
    public QTimedMessage.GroupMessage msg_group_message = new QTimedMessage.GroupMessage();
    public QTimedMessage.PCTip msg_pc_tip = new QTimedMessage.PCTip();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_userdef", "msg_pc_tip", "msg_group_message", "msg_c2c_message" }, new Object[] { localByteStringMicro, null, null, null }, Content.class);
    }
  }
  
  public static final class GroupMessage
    extends MessageMicro<GroupMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_from_user", "msg_to_user" }, new Object[] { null, null }, GroupMessage.class);
    public QTimedMessage.User msg_from_user = new QTimedMessage.User();
    public QTimedMessage.User msg_to_user = new QTimedMessage.User();
  }
  
  public static final class Host
    extends MessageMicro<Host>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cmlb_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_cmlb_id", "bytes_ip", "uint32_port" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, Host.class);
    }
  }
  
  public static final class Message
    extends MessageMicro<Message>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public QTimedMessage.User msg_author = new QTimedMessage.User();
    public QTimedMessage.Content msg_content = new QTimedMessage.Content();
    public QTimedMessage.Timer msg_timer = new QTimedMessage.Timer();
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66 }, new String[] { "uint64_appid", "bytes_msg_id", "msg_author", "uint32_main_type", "uint32_sub_type", "uint64_create_time", "msg_timer", "msg_content" }, new Object[] { Long.valueOf(0L), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null }, Message.class);
    }
  }
  
  public static final class PCTip
    extends MessageMicro<PCTip>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_redirect_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public QTimedMessage.User msg_from_user = new QTimedMessage.User();
    public QTimedMessage.User msg_to_user = new QTimedMessage.User();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_from_user", "msg_to_user", "bytes_title", "bytes_content", "bytes_redirect_url" }, new Object[] { null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, PCTip.class);
    }
  }
  
  public static final class Timer
    extends MessageMicro<Timer>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_time" }, new Object[] { Long.valueOf(0L) }, Timer.class);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  }
  
  public static final class UDPPacket
    extends MessageMicro<UDPPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public QTimedMessage.Host msg_to_host = new QTimedMessage.Host();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_to_host", "bytes_content" }, new Object[] { null, localByteStringMicro }, UDPPacket.class);
    }
  }
  
  public static final class User
    extends MessageMicro<User>
  {
    public static final int GROUP_CODE = 1;
    public static final int GTALK_CODE = 2;
    public static final int QQ_UIN = 3;
    public static final int SYSTEM_UIN = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "enum_uin_type", "uint64_uin" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L) }, User.class);
    public final PBEnumField enum_uin_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QTimedMessage.QTimedMessage
 * JD-Core Version:    0.7.0.1
 */