package NearbyPubAcct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RspGetNearbyPubAcctInfo
  extends JceStruct
{
  static int cache_eReplyCode;
  static byte[] cache_vContext;
  static ArrayList cache_vGroupInfo;
  public int eReplyCode = 0;
  public int iCompletedFlag = 0;
  public int iFlagStamp = 0;
  public int iRadius = 0;
  public int iRedFlag = 0;
  public byte[] vContext = null;
  public ArrayList vGroupInfo = null;
  
  public RspGetNearbyPubAcctInfo() {}
  
  public RspGetNearbyPubAcctInfo(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, ArrayList paramArrayList, int paramInt4, int paramInt5)
  {
    this.eReplyCode = paramInt1;
    this.vContext = paramArrayOfByte;
    this.iCompletedFlag = paramInt2;
    this.iRadius = paramInt3;
    this.vGroupInfo = paramArrayList;
    this.iRedFlag = paramInt4;
    this.iFlagStamp = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.eReplyCode = paramJceInputStream.read(this.eReplyCode, 0, true);
    if (cache_vContext == null)
    {
      cache_vContext = (byte[])new byte[1];
      ((byte[])cache_vContext)[0] = 0;
    }
    this.vContext = ((byte[])paramJceInputStream.read(cache_vContext, 1, true));
    this.iCompletedFlag = paramJceInputStream.read(this.iCompletedFlag, 2, true);
    this.iRadius = paramJceInputStream.read(this.iRadius, 3, false);
    if (cache_vGroupInfo == null)
    {
      cache_vGroupInfo = new ArrayList();
      PubAcctInfo localPubAcctInfo = new PubAcctInfo();
      cache_vGroupInfo.add(localPubAcctInfo);
    }
    this.vGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vGroupInfo, 4, false));
    this.iRedFlag = paramJceInputStream.read(this.iRedFlag, 5, false);
    this.iFlagStamp = paramJceInputStream.read(this.iFlagStamp, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.eReplyCode, 0);
    paramJceOutputStream.write(this.vContext, 1);
    paramJceOutputStream.write(this.iCompletedFlag, 2);
    paramJceOutputStream.write(this.iRadius, 3);
    if (this.vGroupInfo != null) {
      paramJceOutputStream.write(this.vGroupInfo, 4);
    }
    paramJceOutputStream.write(this.iRedFlag, 5);
    paramJceOutputStream.write(this.iFlagStamp, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NearbyPubAcct.RspGetNearbyPubAcctInfo
 * JD-Core Version:    0.7.0.1
 */