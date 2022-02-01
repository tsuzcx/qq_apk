package tencent.im.oidb.cmd0xad7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xad7
{
  public static final class Client
    extends MessageMicro<Client>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_version", "uint32_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, Client.class);
    }
  }
  
  public static final class ReqArticle
    extends MessageMicro<ReqArticle>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_prev_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_public_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 96 }, new String[] { "bytes_url", "uint64_public_uin", "bytes_article_id", "bytes_row_key", "uint32_prev_version" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, ReqArticle.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "msg_client", "msg_req_article", "uint32_friend", "uint32_qzhone", "uint32_wechat", "uint32_wechat_pyq", "uint32_wechat_dpyq", "uint32_weibo", "uint32_biu" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public oidb_cmd0xad7.Client msg_client = new oidb_cmd0xad7.Client();
    public oidb_cmd0xad7.ReqArticle msg_req_article = new oidb_cmd0xad7.ReqArticle();
    public final PBUInt32Field uint32_biu = PBField.initUInt32(0);
    public final PBUInt32Field uint32_friend = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzhone = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wechat = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wechat_dpyq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wechat_pyq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_weibo = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_rsp_share" }, new Object[] { null }, RspBody.class);
    public oidb_cmd0xad7.RspShare msg_rsp_share = new oidb_cmd0xad7.RspShare();
  }
  
  public static final class RspShare
    extends MessageMicro<RspShare>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_biu = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_friend = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qzhone = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wechat = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wechat_dpyq = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wechat_pyq = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_weibo = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 34, 42, 50, 58, 66, 74 }, new String[] { "bytes_friend", "bytes_qzhone", "bytes_wechat", "bytes_wechat_pyq", "bytes_wechat_dpyq", "bytes_weibo", "bytes_biu" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, RspShare.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad7.oidb_cmd0xad7
 * JD-Core Version:    0.7.0.1
 */