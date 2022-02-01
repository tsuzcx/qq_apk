package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcReqBackGround
  extends JceStruct
{
  static byte[] cache_vCookie;
  static ArrayList<Long> cache_vDisSession;
  static ArrayList<Long> cache_vUnReadSession = new ArrayList();
  public long lBindUin;
  public long lBindUinUnRead;
  public long lC2CUnRead;
  public long lDisUnRead;
  public long lGrpUnRead;
  public long lMaxUnReadSessionNumber = 40L;
  public long lUin;
  public byte[] vCookie;
  public ArrayList<Long> vDisSession;
  public ArrayList<Long> vUnReadSession;
  
  static
  {
    cache_vUnReadSession.add(Long.valueOf(0L));
    cache_vDisSession = new ArrayList();
    cache_vDisSession.add(Long.valueOf(0L));
    cache_vCookie = (byte[])new byte[1];
    ((byte[])cache_vCookie)[0] = 0;
  }
  
  public SvcReqBackGround() {}
  
  public SvcReqBackGround(long paramLong1, ArrayList<Long> paramArrayList1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, ArrayList<Long> paramArrayList2, byte[] paramArrayOfByte, long paramLong6, long paramLong7)
  {
    this.lUin = paramLong1;
    this.vUnReadSession = paramArrayList1;
    this.lMaxUnReadSessionNumber = paramLong2;
    this.lC2CUnRead = paramLong3;
    this.lGrpUnRead = paramLong4;
    this.lDisUnRead = paramLong5;
    this.vDisSession = paramArrayList2;
    this.vCookie = paramArrayOfByte;
    this.lBindUinUnRead = paramLong6;
    this.lBindUin = paramLong7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.vUnReadSession = ((ArrayList)paramJceInputStream.read(cache_vUnReadSession, 1, false));
    this.lMaxUnReadSessionNumber = paramJceInputStream.read(this.lMaxUnReadSessionNumber, 2, false);
    this.lC2CUnRead = paramJceInputStream.read(this.lC2CUnRead, 3, false);
    this.lGrpUnRead = paramJceInputStream.read(this.lGrpUnRead, 4, false);
    this.lDisUnRead = paramJceInputStream.read(this.lDisUnRead, 5, false);
    this.vDisSession = ((ArrayList)paramJceInputStream.read(cache_vDisSession, 6, false));
    this.vCookie = ((byte[])paramJceInputStream.read(cache_vCookie, 7, false));
    this.lBindUinUnRead = paramJceInputStream.read(this.lBindUinUnRead, 8, false);
    this.lBindUin = paramJceInputStream.read(this.lBindUin, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    if (this.vUnReadSession != null) {
      paramJceOutputStream.write(this.vUnReadSession, 1);
    }
    paramJceOutputStream.write(this.lMaxUnReadSessionNumber, 2);
    paramJceOutputStream.write(this.lC2CUnRead, 3);
    paramJceOutputStream.write(this.lGrpUnRead, 4);
    paramJceOutputStream.write(this.lDisUnRead, 5);
    if (this.vDisSession != null) {
      paramJceOutputStream.write(this.vDisSession, 6);
    }
    if (this.vCookie != null) {
      paramJceOutputStream.write(this.vCookie, 7);
    }
    paramJceOutputStream.write(this.lBindUinUnRead, 8);
    paramJceOutputStream.write(this.lBindUin, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.SvcReqBackGround
 * JD-Core Version:    0.7.0.1
 */