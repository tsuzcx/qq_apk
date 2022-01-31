package AccostSvc;

import java.io.Serializable;

public final class MsgType
  implements Serializable
{
  public static final MsgType Msg_DownGrpMsg;
  public static final MsgType Msg_ExChangeInfo;
  public static final MsgType Msg_FriNotify;
  public static final MsgType Msg_GrpMngNoTify;
  public static final MsgType Msg_Normal;
  public static final MsgType Msg_PttFileKey;
  public static final MsgType Msg_Read;
  public static final MsgType Msg_Received;
  public static final MsgType Msg_Rich;
  public static final MsgType Msg_Stream;
  public static final int _Msg_DownGrpMsg = 102;
  public static final int _Msg_ExChangeInfo = 7;
  public static final int _Msg_FriNotify = 4;
  public static final int _Msg_GrpMngNoTify = 6;
  public static final int _Msg_Normal = 1;
  public static final int _Msg_PttFileKey = 101;
  public static final int _Msg_Read = 2;
  public static final int _Msg_Received = 3;
  public static final int _Msg_Rich = 5;
  public static final int _Msg_Stream = 8;
  private static MsgType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!MsgType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new MsgType[10];
      Msg_Normal = new MsgType(0, 1, "Msg_Normal");
      Msg_Read = new MsgType(1, 2, "Msg_Read");
      Msg_Received = new MsgType(2, 3, "Msg_Received");
      Msg_FriNotify = new MsgType(3, 4, "Msg_FriNotify");
      Msg_Rich = new MsgType(4, 5, "Msg_Rich");
      Msg_GrpMngNoTify = new MsgType(5, 6, "Msg_GrpMngNoTify");
      Msg_ExChangeInfo = new MsgType(6, 7, "Msg_ExChangeInfo");
      Msg_Stream = new MsgType(7, 8, "Msg_Stream");
      Msg_PttFileKey = new MsgType(8, 101, "Msg_PttFileKey");
      Msg_DownGrpMsg = new MsgType(9, 102, "Msg_DownGrpMsg");
      return;
    }
  }
  
  private MsgType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static MsgType convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static MsgType convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     AccostSvc.MsgType
 * JD-Core Version:    0.7.0.1
 */