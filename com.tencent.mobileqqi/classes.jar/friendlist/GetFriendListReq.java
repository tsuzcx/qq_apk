package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetFriendListReq
  extends JceStruct
{
  static int cache_reqtype;
  static ArrayList cache_uinList;
  public short getfriendCount = 0;
  public byte getgroupCount = 0;
  public byte groupid = 0;
  public byte groupstartIndex = 0;
  public byte ifGetGroupInfo = 0;
  public byte ifGetMSFGroup = 0;
  public byte ifReflush = 0;
  public byte ifShowTermType = 0;
  public int reqtype = 0;
  public short startIndex = 0;
  public long uin = 0L;
  public ArrayList uinList = null;
  public long version = 0L;
  
  public GetFriendListReq() {}
  
  public GetFriendListReq(int paramInt, byte paramByte1, long paramLong1, short paramShort1, short paramShort2, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, long paramLong2, ArrayList paramArrayList)
  {
    this.reqtype = paramInt;
    this.ifReflush = paramByte1;
    this.uin = paramLong1;
    this.startIndex = paramShort1;
    this.getfriendCount = paramShort2;
    this.groupid = paramByte2;
    this.ifGetGroupInfo = paramByte3;
    this.groupstartIndex = paramByte4;
    this.getgroupCount = paramByte5;
    this.ifGetMSFGroup = paramByte6;
    this.ifShowTermType = paramByte7;
    this.version = paramLong2;
    this.uinList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqtype = paramJceInputStream.read(this.reqtype, 0, true);
    this.ifReflush = paramJceInputStream.read(this.ifReflush, 1, true);
    this.uin = paramJceInputStream.read(this.uin, 2, true);
    this.startIndex = paramJceInputStream.read(this.startIndex, 3, true);
    this.getfriendCount = paramJceInputStream.read(this.getfriendCount, 4, true);
    this.groupid = paramJceInputStream.read(this.groupid, 5, false);
    this.ifGetGroupInfo = paramJceInputStream.read(this.ifGetGroupInfo, 6, true);
    this.groupstartIndex = paramJceInputStream.read(this.groupstartIndex, 7, false);
    this.getgroupCount = paramJceInputStream.read(this.getgroupCount, 8, false);
    this.ifGetMSFGroup = paramJceInputStream.read(this.ifGetMSFGroup, 9, false);
    this.ifShowTermType = paramJceInputStream.read(this.ifShowTermType, 10, false);
    this.version = paramJceInputStream.read(this.version, 11, false);
    if (cache_uinList == null)
    {
      cache_uinList = new ArrayList();
      cache_uinList.add(Long.valueOf(0L));
    }
    this.uinList = ((ArrayList)paramJceInputStream.read(cache_uinList, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqtype, 0);
    paramJceOutputStream.write(this.ifReflush, 1);
    paramJceOutputStream.write(this.uin, 2);
    paramJceOutputStream.write(this.startIndex, 3);
    paramJceOutputStream.write(this.getfriendCount, 4);
    paramJceOutputStream.write(this.groupid, 5);
    paramJceOutputStream.write(this.ifGetGroupInfo, 6);
    paramJceOutputStream.write(this.groupstartIndex, 7);
    paramJceOutputStream.write(this.getgroupCount, 8);
    paramJceOutputStream.write(this.ifGetMSFGroup, 9);
    paramJceOutputStream.write(this.ifShowTermType, 10);
    paramJceOutputStream.write(this.version, 11);
    if (this.uinList != null) {
      paramJceOutputStream.write(this.uinList, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.GetFriendListReq
 * JD-Core Version:    0.7.0.1
 */