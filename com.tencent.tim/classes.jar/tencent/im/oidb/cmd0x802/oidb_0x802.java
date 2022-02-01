package tencent.im.oidb.cmd0x802;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_0x802
{
  public static final class JoinRoomAuthBufReq
    extends MessageMicro<JoinRoomAuthBufReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_identifier = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_roomID = PBField.initInt32(0);
    public final PBInt64Field int64_peerUin = PBField.initInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "int32_roomID", "bytes_identifier", "int64_peerUin" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, JoinRoomAuthBufReq.class);
    }
  }
  
  public static final class JoinRoomAuthBufRsp
    extends MessageMicro<JoinRoomAuthBufRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_encrypt_buf" }, new Object[] { localByteStringMicro }, JoinRoomAuthBufRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_join_room_auth_buf_req" }, new Object[] { null }, ReqBody.class);
    public oidb_0x802.JoinRoomAuthBufReq msg_join_room_auth_buf_req = new oidb_0x802.JoinRoomAuthBufReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_join_room_auth_buf_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_0x802.JoinRoomAuthBufRsp msg_join_room_auth_buf_rsp = new oidb_0x802.JoinRoomAuthBufRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x802.oidb_0x802
 * JD-Core Version:    0.7.0.1
 */