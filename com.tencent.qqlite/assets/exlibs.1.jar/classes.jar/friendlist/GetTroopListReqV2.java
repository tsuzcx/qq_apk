package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetTroopListReqV2
  extends JceStruct
{
  static byte[] cache_vecCookies;
  static ArrayList cache_vecGroupInfo;
  public byte bGetMSFMsgFlag = 0;
  public byte bGroupFlagExt = 0;
  public int shVersion = 0;
  public long uin = 0L;
  public byte[] vecCookies = null;
  public ArrayList vecGroupInfo = null;
  
  public GetTroopListReqV2() {}
  
  public GetTroopListReqV2(long paramLong, byte paramByte1, byte[] paramArrayOfByte, ArrayList paramArrayList, byte paramByte2, int paramInt)
  {
    this.uin = paramLong;
    this.bGetMSFMsgFlag = paramByte1;
    this.vecCookies = paramArrayOfByte;
    this.vecGroupInfo = paramArrayList;
    this.bGroupFlagExt = paramByte2;
    this.shVersion = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.bGetMSFMsgFlag = paramJceInputStream.read(this.bGetMSFMsgFlag, 1, false);
    if (cache_vecCookies == null)
    {
      cache_vecCookies = (byte[])new byte[1];
      ((byte[])cache_vecCookies)[0] = 0;
    }
    this.vecCookies = ((byte[])paramJceInputStream.read(cache_vecCookies, 2, false));
    if (cache_vecGroupInfo == null)
    {
      cache_vecGroupInfo = new ArrayList();
      stTroopNum localstTroopNum = new stTroopNum();
      cache_vecGroupInfo.add(localstTroopNum);
    }
    this.vecGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vecGroupInfo, 3, false));
    this.bGroupFlagExt = paramJceInputStream.read(this.bGroupFlagExt, 4, false);
    this.shVersion = paramJceInputStream.read(this.shVersion, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.bGetMSFMsgFlag, 1);
    if (this.vecCookies != null) {
      paramJceOutputStream.write(this.vecCookies, 2);
    }
    if (this.vecGroupInfo != null) {
      paramJceOutputStream.write(this.vecGroupInfo, 3);
    }
    paramJceOutputStream.write(this.bGroupFlagExt, 4);
    paramJceOutputStream.write(this.shVersion, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.GetTroopListReqV2
 * JD-Core Version:    0.7.0.1
 */