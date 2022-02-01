package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ProfGroupInfoRes
  extends JceStruct
{
  static ArrayList<GroupMemberFlag> cache_vAdministrator;
  static ArrayList<String> cache_vsUrl;
  public byte cAlbumResult = -1;
  public byte cInviteSwitchOpen;
  public byte cResult;
  public long dwFlagExt;
  public long dwTimeStamp;
  public String sAuthGrpInfo = "";
  public String sFingerGroupMemo = "";
  public String sGroupLocation = "";
  public String sGroupMemo = "";
  public String sGroupName = "";
  public long uGroupCode;
  public long uGroupOwnerUin;
  public long uGroupUin;
  public ArrayList<GroupMemberFlag> vAdministrator;
  public ArrayList<String> vsUrl;
  public short wGroupFace;
  
  public ProfGroupInfoRes() {}
  
  public ProfGroupInfoRes(byte paramByte1, long paramLong1, long paramLong2, long paramLong3, String paramString1, short paramShort, String paramString2, String paramString3, ArrayList<GroupMemberFlag> paramArrayList, byte paramByte2, long paramLong4, ArrayList<String> paramArrayList1, String paramString4, byte paramByte3, long paramLong5, String paramString5)
  {
    this.cResult = paramByte1;
    this.uGroupUin = paramLong1;
    this.uGroupCode = paramLong2;
    this.uGroupOwnerUin = paramLong3;
    this.sGroupName = paramString1;
    this.wGroupFace = paramShort;
    this.sGroupMemo = paramString2;
    this.sFingerGroupMemo = paramString3;
    this.vAdministrator = paramArrayList;
    this.cAlbumResult = paramByte2;
    this.dwTimeStamp = paramLong4;
    this.vsUrl = paramArrayList1;
    this.sGroupLocation = paramString4;
    this.cInviteSwitchOpen = paramByte3;
    this.dwFlagExt = paramLong5;
    this.sAuthGrpInfo = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cResult = paramJceInputStream.read(this.cResult, 0, true);
    this.uGroupUin = paramJceInputStream.read(this.uGroupUin, 1, true);
    this.uGroupCode = paramJceInputStream.read(this.uGroupCode, 2, true);
    this.uGroupOwnerUin = paramJceInputStream.read(this.uGroupOwnerUin, 3, true);
    this.sGroupName = paramJceInputStream.readString(4, true);
    this.wGroupFace = paramJceInputStream.read(this.wGroupFace, 5, true);
    this.sGroupMemo = paramJceInputStream.readString(6, true);
    this.sFingerGroupMemo = paramJceInputStream.readString(7, true);
    if (cache_vAdministrator == null)
    {
      cache_vAdministrator = new ArrayList();
      GroupMemberFlag localGroupMemberFlag = new GroupMemberFlag();
      cache_vAdministrator.add(localGroupMemberFlag);
    }
    this.vAdministrator = ((ArrayList)paramJceInputStream.read(cache_vAdministrator, 8, false));
    this.cAlbumResult = paramJceInputStream.read(this.cAlbumResult, 9, false);
    this.dwTimeStamp = paramJceInputStream.read(this.dwTimeStamp, 10, false);
    if (cache_vsUrl == null)
    {
      cache_vsUrl = new ArrayList();
      cache_vsUrl.add("");
    }
    this.vsUrl = ((ArrayList)paramJceInputStream.read(cache_vsUrl, 11, false));
    this.sGroupLocation = paramJceInputStream.readString(12, false);
    this.cInviteSwitchOpen = paramJceInputStream.read(this.cInviteSwitchOpen, 13, false);
    this.dwFlagExt = paramJceInputStream.read(this.dwFlagExt, 14, false);
    this.sAuthGrpInfo = paramJceInputStream.readString(15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cResult, 0);
    paramJceOutputStream.write(this.uGroupUin, 1);
    paramJceOutputStream.write(this.uGroupCode, 2);
    paramJceOutputStream.write(this.uGroupOwnerUin, 3);
    paramJceOutputStream.write(this.sGroupName, 4);
    paramJceOutputStream.write(this.wGroupFace, 5);
    paramJceOutputStream.write(this.sGroupMemo, 6);
    paramJceOutputStream.write(this.sFingerGroupMemo, 7);
    if (this.vAdministrator != null) {
      paramJceOutputStream.write(this.vAdministrator, 8);
    }
    paramJceOutputStream.write(this.cAlbumResult, 9);
    paramJceOutputStream.write(this.dwTimeStamp, 10);
    if (this.vsUrl != null) {
      paramJceOutputStream.write(this.vsUrl, 11);
    }
    if (this.sGroupLocation != null) {
      paramJceOutputStream.write(this.sGroupLocation, 12);
    }
    paramJceOutputStream.write(this.cInviteSwitchOpen, 13);
    paramJceOutputStream.write(this.dwFlagExt, 14);
    if (this.sAuthGrpInfo != null) {
      paramJceOutputStream.write(this.sAuthGrpInfo, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     KQQ.ProfGroupInfoRes
 * JD-Core Version:    0.7.0.1
 */