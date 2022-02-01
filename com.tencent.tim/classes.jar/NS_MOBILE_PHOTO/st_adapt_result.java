package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class st_adapt_result
  extends JceStruct
{
  public String albumid = "";
  public byte blocked;
  public byte deleted;
  public long owner;
  public String photoid = "";
  
  public st_adapt_result() {}
  
  public st_adapt_result(long paramLong, String paramString1, String paramString2, byte paramByte1, byte paramByte2)
  {
    this.owner = paramLong;
    this.albumid = paramString1;
    this.photoid = paramString2;
    this.blocked = paramByte1;
    this.deleted = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.owner = paramJceInputStream.read(this.owner, 0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.photoid = paramJceInputStream.readString(2, true);
    this.blocked = paramJceInputStream.read(this.blocked, 3, true);
    this.deleted = paramJceInputStream.read(this.deleted, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.owner, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.photoid, 2);
    paramJceOutputStream.write(this.blocked, 3);
    paramJceOutputStream.write(this.deleted, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.st_adapt_result
 * JD-Core Version:    0.7.0.1
 */