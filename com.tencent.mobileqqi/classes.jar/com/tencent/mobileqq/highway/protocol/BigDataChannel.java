package com.tencent.mobileqq.highway.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BigDataChannel
  extends JceStruct
{
  static byte[] cache_sBigdata_key_session;
  static byte[] cache_sBigdata_sig_session;
  static ArrayList<BigDataIpList> cache_vBigdata_iplists;
  public int iConnect_flag = 1;
  public byte[] sBigdata_key_session = null;
  public byte[] sBigdata_sig_session = null;
  public long uSig_Uin = 0L;
  public ArrayList<BigDataIpList> vBigdata_iplists = null;
  
  public BigDataChannel() {}
  
  public BigDataChannel(ArrayList<BigDataIpList> paramArrayList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, int paramInt)
  {
    this.vBigdata_iplists = paramArrayList;
    this.sBigdata_sig_session = paramArrayOfByte1;
    this.sBigdata_key_session = paramArrayOfByte2;
    this.uSig_Uin = paramLong;
    this.iConnect_flag = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vBigdata_iplists == null)
    {
      cache_vBigdata_iplists = new ArrayList();
      BigDataIpList localBigDataIpList = new BigDataIpList();
      cache_vBigdata_iplists.add(localBigDataIpList);
    }
    this.vBigdata_iplists = ((ArrayList)paramJceInputStream.read(cache_vBigdata_iplists, 0, true));
    if (cache_sBigdata_sig_session == null)
    {
      cache_sBigdata_sig_session = (byte[])new byte[1];
      ((byte[])cache_sBigdata_sig_session)[0] = 0;
    }
    this.sBigdata_sig_session = ((byte[])paramJceInputStream.read(cache_sBigdata_sig_session, 1, false));
    if (cache_sBigdata_key_session == null)
    {
      cache_sBigdata_key_session = (byte[])new byte[1];
      ((byte[])cache_sBigdata_key_session)[0] = 0;
    }
    this.sBigdata_key_session = ((byte[])paramJceInputStream.read(cache_sBigdata_key_session, 2, false));
    this.uSig_Uin = paramJceInputStream.read(this.uSig_Uin, 3, false);
    this.iConnect_flag = paramJceInputStream.read(this.iConnect_flag, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vBigdata_iplists, 0);
    if (this.sBigdata_sig_session != null) {
      paramJceOutputStream.write(this.sBigdata_sig_session, 1);
    }
    if (this.sBigdata_key_session != null) {
      paramJceOutputStream.write(this.sBigdata_key_session, 2);
    }
    paramJceOutputStream.write(this.uSig_Uin, 3);
    paramJceOutputStream.write(this.iConnect_flag, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.BigDataChannel
 * JD-Core Version:    0.7.0.1
 */