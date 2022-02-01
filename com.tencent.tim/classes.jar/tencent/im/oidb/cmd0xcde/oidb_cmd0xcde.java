package tencent.im.oidb.cmd0xcde;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xcde
{
  public static final class GetDecryptKeyReq
    extends MessageMicro<GetDecryptKeyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField file_meta = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "file_meta" }, new Object[] { localByteStringMicro }, GetDecryptKeyReq.class);
    }
  }
  
  public static final class GetDecryptKeyRsp
    extends MessageMicro<GetDecryptKeyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dncrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dncrypt_key" }, new Object[] { localByteStringMicro }, GetDecryptKeyRsp.class);
    }
  }
  
  public static final class GetEncrptkeyReq
    extends MessageMicro<GetEncrptkeyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetEncrptkeyReq.class);
  }
  
  public static final class GetEncryptKeyRsp
    extends MessageMicro<GetEncryptKeyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField file_meta = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "encrypt_key", "file_meta" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, GetEncryptKeyRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "get_encrypt_key_req", "get_decrypt_key_req" }, new Object[] { null, null }, ReqBody.class);
    public oidb_cmd0xcde.GetDecryptKeyReq get_decrypt_key_req = new oidb_cmd0xcde.GetDecryptKeyReq();
    public oidb_cmd0xcde.GetEncrptkeyReq get_encrypt_key_req = new oidb_cmd0xcde.GetEncrptkeyReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "get_encrypt_key_rsp", "get_decrypt_key_rsp" }, new Object[] { null, null }, RspBody.class);
    public oidb_cmd0xcde.GetDecryptKeyRsp get_decrypt_key_rsp = new oidb_cmd0xcde.GetDecryptKeyRsp();
    public oidb_cmd0xcde.GetEncryptKeyRsp get_encrypt_key_rsp = new oidb_cmd0xcde.GetEncryptKeyRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcde.oidb_cmd0xcde
 * JD-Core Version:    0.7.0.1
 */