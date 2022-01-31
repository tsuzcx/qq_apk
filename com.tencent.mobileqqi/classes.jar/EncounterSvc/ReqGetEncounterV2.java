package EncounterSvc;

import NeighborComm.NewListType;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqGetEncounterV2
  extends JceStruct
{
  static int cache_eNewListType;
  static byte[] cache_nearbyGroupReq;
  static byte[] cache_nearbyPublicAcctReq;
  static UserData cache_stUserData;
  static ReqUserInfo cache_stUserInfo;
  static byte[] cache_strA2;
  static ArrayList cache_vTagsID;
  public byte bTraversing = 0;
  public int eNewListType = NewListType.NewListType_Nomal.value();
  public byte encrypt_proto = 0;
  public int iListSize = -1;
  public int iMaxSearchNum = -1;
  public int iRadius = 2000;
  public int iSimpleSort = 0;
  public byte[] nearbyGroupReq = null;
  public byte[] nearbyPublicAcctReq = null;
  public int random_trav_dis_level = 0;
  public UserData stUserData = null;
  public ReqUserInfo stUserInfo = null;
  public byte[] strA2 = null;
  public ArrayList vTagsID = null;
  
  public ReqGetEncounterV2() {}
  
  public ReqGetEncounterV2(ReqUserInfo paramReqUserInfo, UserData paramUserData, int paramInt1, int paramInt2, ArrayList paramArrayList, byte[] paramArrayOfByte1, byte paramByte1, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt6, byte paramByte2)
  {
    this.stUserInfo = paramReqUserInfo;
    this.stUserData = paramUserData;
    this.eNewListType = paramInt1;
    this.iListSize = paramInt2;
    this.vTagsID = paramArrayList;
    this.strA2 = paramArrayOfByte1;
    this.bTraversing = paramByte1;
    this.iRadius = paramInt3;
    this.iMaxSearchNum = paramInt4;
    this.iSimpleSort = paramInt5;
    this.nearbyGroupReq = paramArrayOfByte2;
    this.nearbyPublicAcctReq = paramArrayOfByte3;
    this.random_trav_dis_level = paramInt6;
    this.encrypt_proto = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 0, true));
    if (cache_stUserData == null) {
      cache_stUserData = new UserData();
    }
    this.stUserData = ((UserData)paramJceInputStream.read(cache_stUserData, 1, true));
    this.eNewListType = paramJceInputStream.read(this.eNewListType, 2, false);
    this.iListSize = paramJceInputStream.read(this.iListSize, 3, false);
    if (cache_vTagsID == null)
    {
      cache_vTagsID = new ArrayList();
      cache_vTagsID.add(Long.valueOf(0L));
    }
    this.vTagsID = ((ArrayList)paramJceInputStream.read(cache_vTagsID, 4, false));
    if (cache_strA2 == null)
    {
      cache_strA2 = (byte[])new byte[1];
      ((byte[])cache_strA2)[0] = 0;
    }
    this.strA2 = ((byte[])paramJceInputStream.read(cache_strA2, 5, false));
    this.bTraversing = paramJceInputStream.read(this.bTraversing, 6, false);
    this.iRadius = paramJceInputStream.read(this.iRadius, 7, false);
    this.iMaxSearchNum = paramJceInputStream.read(this.iMaxSearchNum, 8, false);
    this.iSimpleSort = paramJceInputStream.read(this.iSimpleSort, 9, false);
    if (cache_nearbyGroupReq == null)
    {
      cache_nearbyGroupReq = (byte[])new byte[1];
      ((byte[])cache_nearbyGroupReq)[0] = 0;
    }
    this.nearbyGroupReq = ((byte[])paramJceInputStream.read(cache_nearbyGroupReq, 10, false));
    if (cache_nearbyPublicAcctReq == null)
    {
      cache_nearbyPublicAcctReq = (byte[])new byte[1];
      ((byte[])cache_nearbyPublicAcctReq)[0] = 0;
    }
    this.nearbyPublicAcctReq = ((byte[])paramJceInputStream.read(cache_nearbyPublicAcctReq, 11, false));
    this.random_trav_dis_level = paramJceInputStream.read(this.random_trav_dis_level, 12, false);
    this.encrypt_proto = paramJceInputStream.read(this.encrypt_proto, 13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUserInfo, 0);
    paramJceOutputStream.write(this.stUserData, 1);
    paramJceOutputStream.write(this.eNewListType, 2);
    paramJceOutputStream.write(this.iListSize, 3);
    if (this.vTagsID != null) {
      paramJceOutputStream.write(this.vTagsID, 4);
    }
    if (this.strA2 != null) {
      paramJceOutputStream.write(this.strA2, 5);
    }
    paramJceOutputStream.write(this.bTraversing, 6);
    paramJceOutputStream.write(this.iRadius, 7);
    paramJceOutputStream.write(this.iMaxSearchNum, 8);
    paramJceOutputStream.write(this.iSimpleSort, 9);
    if (this.nearbyGroupReq != null) {
      paramJceOutputStream.write(this.nearbyGroupReq, 10);
    }
    if (this.nearbyPublicAcctReq != null) {
      paramJceOutputStream.write(this.nearbyPublicAcctReq, 11);
    }
    paramJceOutputStream.write(this.random_trav_dis_level, 12);
    paramJceOutputStream.write(this.encrypt_proto, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     EncounterSvc.ReqGetEncounterV2
 * JD-Core Version:    0.7.0.1
 */