package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class category_face_confirm_info
  extends JceStruct
{
  static int cache_op = 0;
  public String label = "";
  public int op = 0;
  public long uin;
  
  public category_face_confirm_info() {}
  
  public category_face_confirm_info(int paramInt, String paramString, long paramLong)
  {
    this.op = paramInt;
    this.label = paramString;
    this.uin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.op = paramJceInputStream.read(this.op, 0, false);
    this.label = paramJceInputStream.readString(1, false);
    this.uin = paramJceInputStream.read(this.uin, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.op, 0);
    if (this.label != null) {
      paramJceOutputStream.write(this.label, 1);
    }
    paramJceOutputStream.write(this.uin, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.category_face_confirm_info
 * JD-Core Version:    0.7.0.1
 */