package PasserbySvc;

import NeighborComm.Cell;
import NeighborComm.GPS;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqUserInfo
  extends JceStruct
{
  static int cache_ePosType;
  static GPS cache_stGps;
  static ArrayList<Cell> cache_vCells;
  static byte[] cache_vLBSKeyData;
  static ArrayList<Long> cache_vMacs;
  public int ePosType;
  public GPS stGps;
  public String strAuthName = "";
  public String strAuthPassword = "";
  public ArrayList<Cell> vCells;
  public byte[] vLBSKeyData;
  public ArrayList<Long> vMacs;
  
  public ReqUserInfo() {}
  
  public ReqUserInfo(String paramString1, String paramString2, int paramInt, GPS paramGPS, ArrayList<Long> paramArrayList, ArrayList<Cell> paramArrayList1, byte[] paramArrayOfByte)
  {
    this.strAuthName = paramString1;
    this.strAuthPassword = paramString2;
    this.ePosType = paramInt;
    this.stGps = paramGPS;
    this.vMacs = paramArrayList;
    this.vCells = paramArrayList1;
    this.vLBSKeyData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strAuthName = paramJceInputStream.readString(0, true);
    this.strAuthPassword = paramJceInputStream.readString(1, true);
    this.ePosType = paramJceInputStream.read(this.ePosType, 2, true);
    if (cache_stGps == null) {
      cache_stGps = new GPS();
    }
    this.stGps = ((GPS)paramJceInputStream.read(cache_stGps, 3, false));
    if (cache_vMacs == null)
    {
      cache_vMacs = new ArrayList();
      cache_vMacs.add(Long.valueOf(0L));
    }
    this.vMacs = ((ArrayList)paramJceInputStream.read(cache_vMacs, 4, false));
    if (cache_vCells == null)
    {
      cache_vCells = new ArrayList();
      Cell localCell = new Cell();
      cache_vCells.add(localCell);
    }
    this.vCells = ((ArrayList)paramJceInputStream.read(cache_vCells, 5, false));
    if (cache_vLBSKeyData == null)
    {
      cache_vLBSKeyData = (byte[])new byte[1];
      ((byte[])cache_vLBSKeyData)[0] = 0;
    }
    this.vLBSKeyData = ((byte[])paramJceInputStream.read(cache_vLBSKeyData, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strAuthName, 0);
    paramJceOutputStream.write(this.strAuthPassword, 1);
    paramJceOutputStream.write(this.ePosType, 2);
    if (this.stGps != null) {
      paramJceOutputStream.write(this.stGps, 3);
    }
    if (this.vMacs != null) {
      paramJceOutputStream.write(this.vMacs, 4);
    }
    if (this.vCells != null) {
      paramJceOutputStream.write(this.vCells, 5);
    }
    if (this.vLBSKeyData != null) {
      paramJceOutputStream.write(this.vLBSKeyData, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     PasserbySvc.ReqUserInfo
 * JD-Core Version:    0.7.0.1
 */