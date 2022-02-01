package com.tencent.pb.pendant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DiyAddonUser
{
  public static final class UserDiyInfo
    extends MessageMicro<UserDiyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uin", "curid", "frameid", "stickerinfo", "updatets" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L) }, UserDiyInfo.class);
    public final PBInt32Field curid = PBField.initInt32(0);
    public final PBUInt32Field frameid = PBField.initUInt32(0);
    public final PBRepeatMessageField<DiyAddonUser.UserStickerInfo> stickerinfo = PBField.initRepeatMessage(DiyAddonUser.UserStickerInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBUInt64Field updatets = PBField.initUInt64(0L);
  }
  
  public static final class UserStickerInfo
    extends MessageMicro<UserStickerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56 }, new String[] { "type", "stickerid", "angle", "text", "fontid", "fontcolor", "fonttype" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0) }, UserStickerInfo.class);
    public final PBUInt32Field angle = PBField.initUInt32(0);
    public final PBStringField fontcolor = PBField.initString("");
    public final PBUInt32Field fontid = PBField.initUInt32(0);
    public final PBUInt32Field fonttype = PBField.initUInt32(0);
    public final PBUInt32Field stickerid = PBField.initUInt32(0);
    public final PBStringField text = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.pendant.DiyAddonUser
 * JD-Core Version:    0.7.0.1
 */