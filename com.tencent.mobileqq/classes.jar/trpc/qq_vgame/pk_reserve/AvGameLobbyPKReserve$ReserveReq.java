package trpc.qq_vgame.pk_reserve;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameLobbyPKReserve$ReserveReq
  extends MessageMicro<ReserveReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "pk_id", "is_reserve" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, ReserveReq.class);
  public final PBBoolField is_reserve = PBField.initBool(false);
  public final PBUInt32Field pk_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.pk_reserve.AvGameLobbyPKReserve.ReserveReq
 * JD-Core Version:    0.7.0.1
 */