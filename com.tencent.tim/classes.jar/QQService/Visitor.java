package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Visitor
  extends JceStruct
{
  static FaceInfo cache_stFace;
  static byte[] cache_vecNick;
  public int iFaceID;
  public long lUIN;
  public FaceInfo stFace;
  public String strNick = "";
  public byte[] vecNick;
  
  public Visitor() {}
  
  public Visitor(long paramLong, FaceInfo paramFaceInfo, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.lUIN = paramLong;
    this.stFace = paramFaceInfo;
    this.iFaceID = paramInt;
    this.strNick = paramString;
    this.vecNick = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    if (cache_stFace == null) {
      cache_stFace = new FaceInfo();
    }
    this.stFace = ((FaceInfo)paramJceInputStream.read(cache_stFace, 1, true));
    this.iFaceID = paramJceInputStream.read(this.iFaceID, 2, false);
    this.strNick = paramJceInputStream.readString(3, false);
    if (cache_vecNick == null)
    {
      cache_vecNick = (byte[])new byte[1];
      ((byte[])cache_vecNick)[0] = 0;
    }
    this.vecNick = ((byte[])paramJceInputStream.read(cache_vecNick, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.stFace, 1);
    paramJceOutputStream.write(this.iFaceID, 2);
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 3);
    }
    if (this.vecNick != null) {
      paramJceOutputStream.write(this.vecNick, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.Visitor
 * JD-Core Version:    0.7.0.1
 */