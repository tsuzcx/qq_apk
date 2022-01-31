package KQQ;

import java.io.Serializable;

public final class ESetGroupReqType
  implements Serializable
{
  public static final int _eCreateGroupReq = 10;
  public static final int _eDeleteGroupReq = 9;
  public static final int _eFireGroupReq = 3;
  public static final int _eInviteGroupReq = 8;
  public static final int _eJoinGroupReq = 1;
  public static final int _eMemberAgreeJoinGroupReq = 6;
  public static final int _eMemberInviteGroupReq = 11;
  public static final int _eMemberRefuseJoinGroupReq = 7;
  public static final int _eMngerAgreeJoinGroupReq = 4;
  public static final int _eMngerRefuseJoinGroupReq = 5;
  public static final int _eResignGroupReq = 2;
  public static final int _eSearchGroupReq = 0;
  private static ESetGroupReqType[] a;
  public static final ESetGroupReqType eCreateGroupReq;
  public static final ESetGroupReqType eDeleteGroupReq;
  public static final ESetGroupReqType eFireGroupReq;
  public static final ESetGroupReqType eInviteGroupReq;
  public static final ESetGroupReqType eJoinGroupReq;
  public static final ESetGroupReqType eMemberAgreeJoinGroupReq;
  public static final ESetGroupReqType eMemberInviteGroupReq;
  public static final ESetGroupReqType eMemberRefuseJoinGroupReq;
  public static final ESetGroupReqType eMngerAgreeJoinGroupReq;
  public static final ESetGroupReqType eMngerRefuseJoinGroupReq;
  public static final ESetGroupReqType eResignGroupReq;
  public static final ESetGroupReqType eSearchGroupReq;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!ESetGroupReqType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new ESetGroupReqType[12];
      eSearchGroupReq = new ESetGroupReqType(0, 0, "eSearchGroupReq");
      eJoinGroupReq = new ESetGroupReqType(1, 1, "eJoinGroupReq");
      eResignGroupReq = new ESetGroupReqType(2, 2, "eResignGroupReq");
      eFireGroupReq = new ESetGroupReqType(3, 3, "eFireGroupReq");
      eMngerAgreeJoinGroupReq = new ESetGroupReqType(4, 4, "eMngerAgreeJoinGroupReq");
      eMngerRefuseJoinGroupReq = new ESetGroupReqType(5, 5, "eMngerRefuseJoinGroupReq");
      eMemberAgreeJoinGroupReq = new ESetGroupReqType(6, 6, "eMemberAgreeJoinGroupReq");
      eMemberRefuseJoinGroupReq = new ESetGroupReqType(7, 7, "eMemberRefuseJoinGroupReq");
      eInviteGroupReq = new ESetGroupReqType(8, 8, "eInviteGroupReq");
      eDeleteGroupReq = new ESetGroupReqType(9, 9, "eDeleteGroupReq");
      eCreateGroupReq = new ESetGroupReqType(10, 10, "eCreateGroupReq");
      eMemberInviteGroupReq = new ESetGroupReqType(11, 11, "eMemberInviteGroupReq");
      return;
    }
  }
  
  private ESetGroupReqType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static ESetGroupReqType convert(int paramInt)
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
  
  public static ESetGroupReqType convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.ESetGroupReqType
 * JD-Core Version:    0.7.0.1
 */