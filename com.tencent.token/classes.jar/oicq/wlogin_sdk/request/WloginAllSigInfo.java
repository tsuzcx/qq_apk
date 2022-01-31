package oicq.wlogin_sdk.request;

import java.io.Serializable;
import java.util.TreeMap;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class WloginAllSigInfo
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  public TreeMap<Long, WloginSigInfo> _tk_map = new TreeMap();
  public long _uin = 0L;
  public WloginSimpleInfo _useInfo = new WloginSimpleInfo();
  
  public WloginAllSigInfo get_clone()
  {
    try
    {
      WloginAllSigInfo localWloginAllSigInfo = (WloginAllSigInfo)clone();
      return localWloginAllSigInfo;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int put_da2(long paramLong, byte[] paramArrayOfByte)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong));
    if (localWloginSigInfo != null) {
      this._tk_map.put(Long.valueOf(paramLong), localWloginSigInfo.setDA2(paramArrayOfByte));
    }
    return 0;
  }
  
  public int put_randseed(long paramLong, byte[] paramArrayOfByte)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong));
    if (localWloginSigInfo != null) {
      this._tk_map.put(Long.valueOf(paramLong), localWloginSigInfo.setRandSeed(paramArrayOfByte));
    }
    return 0;
  }
  
  public int put_siginfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[][] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong1));
    if (localWloginSigInfo != null) {
      this._tk_map.put(Long.valueOf(paramLong1), localWloginSigInfo.Set(paramLong2, paramLong3, paramLong4, paramLong5, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte, paramArrayOfLong, paramInt));
    }
    for (;;)
    {
      return 0;
      this._tk_map.put(Long.valueOf(paramLong1), new WloginSigInfo(paramLong2, paramLong3, paramLong4, paramLong5, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte, paramArrayOfLong, paramInt));
    }
  }
  
  public int put_siginfo(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this._tk_map.put(Long.valueOf(paramLong1), new WloginSigInfo(paramLong2, paramLong3, paramArrayOfByte1, paramArrayOfByte2));
    return 0;
  }
  
  public int put_siginfo(long paramLong1, byte[][] paramArrayOfByte, long paramLong2)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong1));
    if (localWloginSigInfo != null) {
      this._tk_map.put(Long.valueOf(paramLong1), localWloginSigInfo.Set(paramArrayOfByte, paramLong2));
    }
    return 0;
  }
  
  public int put_simpleinfo(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[][] paramArrayOfByte)
  {
    if (this._useInfo == null) {
      this._useInfo = new WloginSimpleInfo(paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte);
    }
    for (;;)
    {
      return 0;
      this._useInfo.set_info(paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WloginAllSigInfo
 * JD-Core Version:    0.7.0.1
 */