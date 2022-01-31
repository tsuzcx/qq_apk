package AccostSvc;

import java.io.Serializable;

public final class MsgItemType
  implements Serializable
{
  public static final MsgItemType MsgItem_Clt_ActionType;
  public static final MsgItemType MsgItem_Cookie;
  public static final MsgItemType MsgItem_EventReport;
  public static final MsgItemType MsgItem_Event_ShareTrace;
  public static final MsgItemType MsgItem_FileKey_File;
  public static final MsgItemType MsgItem_FileKey_Graff;
  public static final MsgItemType MsgItem_FileKey_Pic;
  public static final MsgItemType MsgItem_FileKey_Ptt;
  public static final MsgItemType MsgItem_FileKey_video;
  public static final MsgItemType MsgItem_MContact_Accepted;
  public static final MsgItemType MsgItem_MContact_Rejected;
  public static final MsgItemType MsgItem_MContact_Req;
  public static final MsgItemType MsgItem_NewVote;
  public static final MsgItemType MsgItem_Normal;
  public static final MsgItemType MsgItem_PengYou_Info;
  public static final MsgItemType MsgItem_PositionInfoForLBS;
  public static final MsgItemType MsgItem_QQRobert_info;
  public static final MsgItemType MsgItem_Share_Location;
  public static final MsgItemType MsgItem_StreamEnd_Graff;
  public static final MsgItemType MsgItem_StreamEnd_Ptt;
  public static final MsgItemType MsgItem_StreamFrag_Graff;
  public static final MsgItemType MsgItem_StreamFrag_Ptt;
  public static final int _MsgItem_Clt_ActionType = 11;
  public static final int _MsgItem_Cookie = 17;
  public static final int _MsgItem_EventReport = 18;
  public static final int _MsgItem_Event_ShareTrace = 201;
  public static final int _MsgItem_FileKey_File = 13;
  public static final int _MsgItem_FileKey_Graff = 7;
  public static final int _MsgItem_FileKey_Pic = 3;
  public static final int _MsgItem_FileKey_Ptt = 4;
  public static final int _MsgItem_FileKey_video = 15;
  public static final int _MsgItem_MContact_Accepted = 20;
  public static final int _MsgItem_MContact_Rejected = 21;
  public static final int _MsgItem_MContact_Req = 19;
  public static final int _MsgItem_NewVote = 200;
  public static final int _MsgItem_Normal = 1;
  public static final int _MsgItem_PengYou_Info = 10;
  public static final int _MsgItem_PositionInfoForLBS = 16;
  public static final int _MsgItem_QQRobert_info = 12;
  public static final int _MsgItem_Share_Location = 14;
  public static final int _MsgItem_StreamEnd_Graff = 6;
  public static final int _MsgItem_StreamEnd_Ptt = 9;
  public static final int _MsgItem_StreamFrag_Graff = 5;
  public static final int _MsgItem_StreamFrag_Ptt = 8;
  private static MsgItemType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!MsgItemType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new MsgItemType[22];
      MsgItem_Normal = new MsgItemType(0, 1, "MsgItem_Normal");
      MsgItem_FileKey_Pic = new MsgItemType(1, 3, "MsgItem_FileKey_Pic");
      MsgItem_FileKey_Ptt = new MsgItemType(2, 4, "MsgItem_FileKey_Ptt");
      MsgItem_StreamFrag_Graff = new MsgItemType(3, 5, "MsgItem_StreamFrag_Graff");
      MsgItem_StreamEnd_Graff = new MsgItemType(4, 6, "MsgItem_StreamEnd_Graff");
      MsgItem_FileKey_Graff = new MsgItemType(5, 7, "MsgItem_FileKey_Graff");
      MsgItem_StreamFrag_Ptt = new MsgItemType(6, 8, "MsgItem_StreamFrag_Ptt");
      MsgItem_StreamEnd_Ptt = new MsgItemType(7, 9, "MsgItem_StreamEnd_Ptt");
      MsgItem_PengYou_Info = new MsgItemType(8, 10, "MsgItem_PengYou_Info");
      MsgItem_Clt_ActionType = new MsgItemType(9, 11, "MsgItem_Clt_ActionType");
      MsgItem_QQRobert_info = new MsgItemType(10, 12, "MsgItem_QQRobert_info");
      MsgItem_FileKey_File = new MsgItemType(11, 13, "MsgItem_FileKey_File");
      MsgItem_Share_Location = new MsgItemType(12, 14, "MsgItem_Share_Location");
      MsgItem_FileKey_video = new MsgItemType(13, 15, "MsgItem_FileKey_video");
      MsgItem_PositionInfoForLBS = new MsgItemType(14, 16, "MsgItem_PositionInfoForLBS");
      MsgItem_Cookie = new MsgItemType(15, 17, "MsgItem_Cookie");
      MsgItem_EventReport = new MsgItemType(16, 18, "MsgItem_EventReport");
      MsgItem_MContact_Req = new MsgItemType(17, 19, "MsgItem_MContact_Req");
      MsgItem_MContact_Accepted = new MsgItemType(18, 20, "MsgItem_MContact_Accepted");
      MsgItem_MContact_Rejected = new MsgItemType(19, 21, "MsgItem_MContact_Rejected");
      MsgItem_NewVote = new MsgItemType(20, 200, "MsgItem_NewVote");
      MsgItem_Event_ShareTrace = new MsgItemType(21, 201, "MsgItem_Event_ShareTrace");
      return;
    }
  }
  
  private MsgItemType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static MsgItemType convert(int paramInt)
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
  
  public static MsgItemType convert(String paramString)
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
 * Qualified Name:     AccostSvc.MsgItemType
 * JD-Core Version:    0.7.0.1
 */