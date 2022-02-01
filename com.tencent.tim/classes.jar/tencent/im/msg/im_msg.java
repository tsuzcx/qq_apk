package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg
{
  public static final class C2C
    extends MessageMicro<C2C>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "sender", "receiver", "c2c_relation" }, new Object[] { null, null, null }, C2C.class);
    public im_msg.C2CRelation c2c_relation = new im_msg.C2CRelation();
    public im_common.User receiver = new im_common.User();
    public im_common.User sender = new im_common.User();
  }
  
  public static final class C2CRelation
    extends MessageMicro<C2CRelation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "c2c_type", "group_info", "token" }, new Object[] { Integer.valueOf(0), null, null }, C2CRelation.class);
    public final PBEnumField c2c_type = PBField.initEnum(0);
    public im_common.GroupInfo group_info = new im_common.GroupInfo();
    public im_common.Token token = new im_common.Token();
  }
  
  public static final class ContentHead
    extends MessageMicro<ContentHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "pkg_num", "pkg_index", "seq", "date_time", "msg_type", "div_seq", "msgdb_uin", "msgdb_seq", "word_msg_seq", "msg_rand" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ContentHead.class);
    public final PBUInt32Field date_time = PBField.initUInt32(0);
    public final PBUInt32Field div_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_rand = PBField.initUInt32(0);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt32Field msgdb_seq = PBField.initUInt32(0);
    public final PBUInt64Field msgdb_uin = PBField.initUInt64(0L);
    public final PBUInt32Field pkg_index = PBField.initUInt32(0);
    public final PBUInt32Field pkg_num = PBField.initUInt32(1);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field word_msg_seq = PBField.initUInt32(0);
  }
  
  public static final class Group
    extends MessageMicro<Group>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "sender", "receiver", "group_info" }, new Object[] { null, null, null }, Group.class);
    public im_common.GroupInfo group_info = new im_common.GroupInfo();
    public im_common.User receiver = new im_common.User();
    public im_common.User sender = new im_common.User();
  }
  
  public static final class Msg
    extends MessageMicro<Msg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "body" }, new Object[] { null, null }, Msg.class);
    public im_msg_body.MsgBody body = new im_msg_body.MsgBody();
    public im_msg.MsgHead head = new im_msg.MsgHead();
  }
  
  public static final class MsgHead
    extends MessageMicro<MsgHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public im_msg.ContentHead content_head = new im_msg.ContentHead();
    public final PBBytesField gbk_tmp_msg_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public im_msg.RoutingHead routing_head = new im_msg.RoutingHead();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "routing_head", "content_head", "gbk_tmp_msg_body" }, new Object[] { null, null, localByteStringMicro }, MsgHead.class);
    }
  }
  
  public static final class MsgSendReq
    extends MessageMicro<MsgSendReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bu_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field conn_msg_flag = PBField.initUInt32(0);
    public im_msg.Msg msg = new im_msg.Msg();
    public final PBUInt32Field msg_tail_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "msg", "bu_msg", "msg_tail_id", "conn_msg_flag", "bytes_cookie" }, new Object[] { null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, MsgSendReq.class);
    }
  }
  
  public static final class MsgSendResp
    extends MessageMicro<MsgSendResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MsgSendResp.class);
  }
  
  public static final class RoutingHead
    extends MessageMicro<RoutingHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "c2c", "group" }, new Object[] { null, null }, RoutingHead.class);
    public im_msg.C2C c2c = new im_msg.C2C();
    public im_msg.Group group = new im_msg.Group();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg
 * JD-Core Version:    0.7.0.1
 */