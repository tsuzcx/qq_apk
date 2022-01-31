package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqSummaryCard
  extends JceStruct
{
  static int cache_eAddFriendSource;
  static int cache_eComeFrom;
  static byte[] cache_vReqLastGameInfo;
  static byte[] cache_vReqStarInfo;
  static byte[] cache_vReqTemplateInfo;
  static byte[] cache_vSecureSig;
  static byte[] cache_vSeed;
  static ArrayList cache_vvReqServices;
  public byte bIsFriend = 0;
  public int eAddFriendSource = 0;
  public int eComeFrom = 65535;
  public long lGetControl = 0L;
  public long lGroupCode = 0L;
  public long lGroupUin = 0L;
  public long lTinyId = 0L;
  public long lUIN = 0L;
  public String strSearchName = "";
  public long uQzoneFeedTimestamp = 0L;
  public byte[] vReqLastGameInfo = null;
  public byte[] vReqStarInfo = null;
  public byte[] vReqTemplateInfo = null;
  public byte[] vSecureSig = null;
  public byte[] vSeed = null;
  public ArrayList vvReqServices = null;
  
  public ReqSummaryCard() {}
  
  public ReqSummaryCard(long paramLong1, int paramInt1, long paramLong2, byte paramByte, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, String paramString, long paramLong5, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, ArrayList paramArrayList, long paramLong6)
  {
    this.lUIN = paramLong1;
    this.eComeFrom = paramInt1;
    this.uQzoneFeedTimestamp = paramLong2;
    this.bIsFriend = paramByte;
    this.lGroupCode = paramLong3;
    this.lGroupUin = paramLong4;
    this.vSeed = paramArrayOfByte1;
    this.strSearchName = paramString;
    this.lGetControl = paramLong5;
    this.eAddFriendSource = paramInt2;
    this.vSecureSig = paramArrayOfByte2;
    this.vReqLastGameInfo = paramArrayOfByte3;
    this.vReqTemplateInfo = paramArrayOfByte4;
    this.vReqStarInfo = paramArrayOfByte5;
    this.vvReqServices = paramArrayList;
    this.lTinyId = paramLong6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.eComeFrom = paramJceInputStream.read(this.eComeFrom, 1, true);
    this.uQzoneFeedTimestamp = paramJceInputStream.read(this.uQzoneFeedTimestamp, 2, false);
    this.bIsFriend = paramJceInputStream.read(this.bIsFriend, 3, false);
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 4, false);
    this.lGroupUin = paramJceInputStream.read(this.lGroupUin, 5, false);
    if (cache_vSeed == null)
    {
      cache_vSeed = (byte[])new byte[1];
      ((byte[])cache_vSeed)[0] = 0;
    }
    this.vSeed = ((byte[])paramJceInputStream.read(cache_vSeed, 6, false));
    this.strSearchName = paramJceInputStream.readString(7, false);
    this.lGetControl = paramJceInputStream.read(this.lGetControl, 8, false);
    this.eAddFriendSource = paramJceInputStream.read(this.eAddFriendSource, 9, false);
    if (cache_vSecureSig == null)
    {
      cache_vSecureSig = (byte[])new byte[1];
      ((byte[])cache_vSecureSig)[0] = 0;
    }
    this.vSecureSig = ((byte[])paramJceInputStream.read(cache_vSecureSig, 10, false));
    if (cache_vReqLastGameInfo == null)
    {
      cache_vReqLastGameInfo = (byte[])new byte[1];
      ((byte[])cache_vReqLastGameInfo)[0] = 0;
    }
    this.vReqLastGameInfo = ((byte[])paramJceInputStream.read(cache_vReqLastGameInfo, 11, false));
    if (cache_vReqTemplateInfo == null)
    {
      cache_vReqTemplateInfo = (byte[])new byte[1];
      ((byte[])cache_vReqTemplateInfo)[0] = 0;
    }
    this.vReqTemplateInfo = ((byte[])paramJceInputStream.read(cache_vReqTemplateInfo, 12, false));
    if (cache_vReqStarInfo == null)
    {
      cache_vReqStarInfo = (byte[])new byte[1];
      ((byte[])cache_vReqStarInfo)[0] = 0;
    }
    this.vReqStarInfo = ((byte[])paramJceInputStream.read(cache_vReqStarInfo, 13, false));
    if (cache_vvReqServices == null)
    {
      cache_vvReqServices = new ArrayList();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_vvReqServices.add(arrayOfByte);
    }
    this.vvReqServices = ((ArrayList)paramJceInputStream.read(cache_vvReqServices, 14, false));
    this.lTinyId = paramJceInputStream.read(this.lTinyId, 15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.eComeFrom, 1);
    paramJceOutputStream.write(this.uQzoneFeedTimestamp, 2);
    paramJceOutputStream.write(this.bIsFriend, 3);
    paramJceOutputStream.write(this.lGroupCode, 4);
    paramJceOutputStream.write(this.lGroupUin, 5);
    if (this.vSeed != null) {
      paramJceOutputStream.write(this.vSeed, 6);
    }
    if (this.strSearchName != null) {
      paramJceOutputStream.write(this.strSearchName, 7);
    }
    paramJceOutputStream.write(this.lGetControl, 8);
    paramJceOutputStream.write(this.eAddFriendSource, 9);
    if (this.vSecureSig != null) {
      paramJceOutputStream.write(this.vSecureSig, 10);
    }
    if (this.vReqLastGameInfo != null) {
      paramJceOutputStream.write(this.vReqLastGameInfo, 11);
    }
    if (this.vReqTemplateInfo != null) {
      paramJceOutputStream.write(this.vReqTemplateInfo, 12);
    }
    if (this.vReqStarInfo != null) {
      paramJceOutputStream.write(this.vReqStarInfo, 13);
    }
    if (this.vvReqServices != null) {
      paramJceOutputStream.write(this.vvReqServices, 14);
    }
    paramJceOutputStream.write(this.lTinyId, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SummaryCard.ReqSummaryCard
 * JD-Core Version:    0.7.0.1
 */