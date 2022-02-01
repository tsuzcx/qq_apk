package tencent.im.sso.offlinpkg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OfflinePkg
{
  public static final class BidPkg
    extends MessageMicro<BidPkg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_bid", "uint32_pkg_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BidPkg.class);
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_pkg_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field int32_network = PBField.initInt32(0);
    public final PBRepeatMessageField<OfflinePkg.BidPkg> st_bid_pkg = PBField.initRepeatMessage(OfflinePkg.BidPkg.class);
    public final PBBytesField str_from = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_osbrand = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_osmodel = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_osrelease = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_osver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_qver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 72, 82 }, new String[] { "uint32_cmd", "uint32_platform", "st_bid_pkg", "str_qver", "str_osver", "str_osrelease", "str_osbrand", "str_osmodel", "int32_network", "str_from" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6 }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBBytesField str_err_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_expire_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_offline_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_predown_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_predown_pkg_ex = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "int32_ret", "str_err_desc", "str_expire_pkg", "str_predown_pkg", "str_predown_pkg_ex", "str_offline_pkg" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.sso.offlinpkg.OfflinePkg
 * JD-Core Version:    0.7.0.1
 */