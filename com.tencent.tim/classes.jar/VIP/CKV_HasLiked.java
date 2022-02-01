package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CKV_HasLiked
  extends JceStruct
{
  public boolean hasLiked = true;
  
  public CKV_HasLiked() {}
  
  public CKV_HasLiked(boolean paramBoolean)
  {
    this.hasLiked = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasLiked = paramJceInputStream.read(this.hasLiked, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasLiked, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VIP.CKV_HasLiked
 * JD-Core Version:    0.7.0.1
 */