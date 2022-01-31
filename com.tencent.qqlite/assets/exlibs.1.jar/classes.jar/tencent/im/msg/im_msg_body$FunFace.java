package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg_body$FunFace
  extends MessageMicro
{
  public static final int MSG_BOMB_FIELD_NUMBER = 2;
  public static final int MSG_TURNTABLE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_turntable", "msg_bomb" }, new Object[] { null, null }, FunFace.class);
  public im_msg_body.FunFace.Bomb msg_bomb = new im_msg_body.FunFace.Bomb();
  public im_msg_body.FunFace.Turntable msg_turntable = new im_msg_body.FunFace.Turntable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.FunFace
 * JD-Core Version:    0.7.0.1
 */