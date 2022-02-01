package tencent.im.oidb.cmd0x6c2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6c2
{
  public static final class GiftBagInfo
    extends MessageMicro<GiftBagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gift_bagid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gift_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gift_unit = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_amount = PBField.initInt32(0);
    public final PBInt32Field int32_count = PBField.initInt32(0);
    public final PBInt32Field int32_end = PBField.initInt32(0);
    public final PBInt32Field int32_remain_amount = PBField.initInt32(0);
    public final PBInt32Field int32_remain_count = PBField.initInt32(0);
    public final PBInt32Field int32_winner = PBField.initInt32(0);
    public final PBRepeatMessageField<oidb_0x6c2.Player> msg_paly = PBField.initRepeatMessage(oidb_0x6c2.Player.class);
    public final PBUInt64Field uint64_done_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_gift_owner = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72, 80, 88, 96, 104, 114, 122, 80002 }, new String[] { "bytes_gift_bagid", "int32_count", "int32_amount", "uint64_start_time", "uint64_end_time", "msg_paly", "int32_end", "int32_remain_count", "int32_remain_amount", "int32_winner", "uint64_gift_owner", "uint64_group_id", "uint64_done_time", "bytes_gift_name", "bytes_gift_unit", "bytes_ext" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, GiftBagInfo.class);
    }
  }
  
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_type", "bytes_sig", "uint32_appid" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, LoginSig.class);
    }
  }
  
  public static final class Player
    extends MessageMicro<Player>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_amount = PBField.initInt32(0);
    public final PBInt32Field int32_index = PBField.initInt32(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_uin", "uint64_time", "int32_amount", "int32_index", "bytes_tips" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, Player.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_gift_bagid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_page_index = PBField.initInt32(0);
    public final PBInt32Field int32_page_size = PBField.initInt32(0);
    public oidb_0x6c2.LoginSig msg_login_sig = new oidb_0x6c2.LoginSig();
    public final PBUInt32Field uint32_channel = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "uint64_group_id", "bytes_gift_bagid", "int32_page_index", "int32_page_size", "uint32_channel", "msg_login_sig" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_player = PBField.initInt32(0);
    public oidb_0x6c2.GiftBagInfo msg_gift_bag_info = new oidb_0x6c2.GiftBagInfo();
    public oidb_0x6c2.Player msg_winner = new oidb_0x6c2.Player();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint32_result", "bytes_errmsg", "msg_gift_bag_info", "int32_player", "msg_winner" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), null }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c2.oidb_0x6c2
 * JD-Core Version:    0.7.0.1
 */