package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class AllowJoinShareAlbum
  extends JceStruct
{
  static byte[] cache_data = (byte[])new byte[1];
  public byte[] data;
  public int source = 0;
  
  static
  {
    ((byte[])cache_data)[0] = 0;
  }
  
  public AllowJoinShareAlbum() {}
  
  public AllowJoinShareAlbum(int paramInt, byte[] paramArrayOfByte)
  {
    this.source = paramInt;
    this.data = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.source = paramJceInputStream.read(this.source, 0, false);
    this.data = ((byte[])paramJceInputStream.read(cache_data, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.source, 0);
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.AllowJoinShareAlbum
 * JD-Core Version:    0.7.0.1
 */