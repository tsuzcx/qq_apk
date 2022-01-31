package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RegisterHttpShortConnectionResp
  extends JceStruct
{
  static ArrayList cache_vBusiPacks;
  static byte[] cache_vCookies;
  static byte[] cache_vSig;
  public byte bReloadSvrlist = 0;
  public long uInterval = 0L;
  public ArrayList vBusiPacks = null;
  public byte[] vCookies = null;
  public byte[] vSig = null;
  
  public RegisterHttpShortConnectionResp() {}
  
  public RegisterHttpShortConnectionResp(byte[] paramArrayOfByte1, ArrayList paramArrayList, long paramLong, byte[] paramArrayOfByte2, byte paramByte)
  {
    this.vCookies = paramArrayOfByte1;
    this.vBusiPacks = paramArrayList;
    this.uInterval = paramLong;
    this.vSig = paramArrayOfByte2;
    this.bReloadSvrlist = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vCookies == null)
    {
      cache_vCookies = (byte[])new byte[1];
      ((byte[])cache_vCookies)[0] = 0;
    }
    this.vCookies = ((byte[])paramJceInputStream.read(cache_vCookies, 0, true));
    if (cache_vBusiPacks == null)
    {
      cache_vBusiPacks = new ArrayList();
      RegisterHttpShortConnectionBusiPack localRegisterHttpShortConnectionBusiPack = new RegisterHttpShortConnectionBusiPack();
      cache_vBusiPacks.add(localRegisterHttpShortConnectionBusiPack);
    }
    this.vBusiPacks = ((ArrayList)paramJceInputStream.read(cache_vBusiPacks, 1, true));
    this.uInterval = paramJceInputStream.read(this.uInterval, 2, false);
    if (cache_vSig == null)
    {
      cache_vSig = (byte[])new byte[1];
      ((byte[])cache_vSig)[0] = 0;
    }
    this.vSig = ((byte[])paramJceInputStream.read(cache_vSig, 3, false));
    this.bReloadSvrlist = paramJceInputStream.read(this.bReloadSvrlist, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vCookies, 0);
    paramJceOutputStream.write(this.vBusiPacks, 1);
    paramJceOutputStream.write(this.uInterval, 2);
    if (this.vSig != null) {
      paramJceOutputStream.write(this.vSig, 3);
    }
    paramJceOutputStream.write(this.bReloadSvrlist, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     RegisterProxySvcPack.RegisterHttpShortConnectionResp
 * JD-Core Version:    0.7.0.1
 */