package com.tencent.pb.ppcloginauth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PPCLoginAuth
{
  public static final class backgound_req
    extends MessageMicro<backgound_req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "id" }, new Object[] { "" }, backgound_req.class);
    public final PBRepeatField<String> id = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class backgound_rsp
    extends MessageMicro<backgound_rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, backgound_rsp.class);
    public final PBRepeatField<Integer> ret = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  }
  
  public static final class comering_req
    extends MessageMicro<comering_req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "id" }, new Object[] { "" }, comering_req.class);
    public final PBStringField id = PBField.initString("");
  }
  
  public static final class comering_rsp
    extends MessageMicro<comering_rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, comering_rsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
  
  public static final class plat_info
    extends MessageMicro<plat_info>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "implat", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, plat_info.class);
    public final PBInt64Field implat = PBField.initInt64(0L);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
  }
  
  public static final class req
    extends MessageMicro<req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "comm", "reqcmd_0x01", "reqcmd_0x02" }, new Object[] { null, null, null }, req.class);
    public PPCLoginAuth.plat_info comm = new PPCLoginAuth.plat_info();
    public PPCLoginAuth.comering_req reqcmd_0x01 = new PPCLoginAuth.comering_req();
    public PPCLoginAuth.backgound_req reqcmd_0x02 = new PPCLoginAuth.backgound_req();
  }
  
  public static final class rsp
    extends MessageMicro<rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "ret", "errmsg", "rspcmd_0x01", "rspcmd_0x02" }, new Object[] { Long.valueOf(0L), "", null, null }, rsp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBInt64Field ret = PBField.initInt64(0L);
    public PPCLoginAuth.comering_rsp rspcmd_0x01 = new PPCLoginAuth.comering_rsp();
    public PPCLoginAuth.backgound_rsp rspcmd_0x02 = new PPCLoginAuth.backgound_rsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.ppcloginauth.PPCLoginAuth
 * JD-Core Version:    0.7.0.1
 */