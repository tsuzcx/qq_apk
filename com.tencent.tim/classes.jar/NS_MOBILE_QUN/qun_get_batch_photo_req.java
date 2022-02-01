package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_get_batch_photo_req
  extends JceStruct
{
  public String albumid = "";
  public String attach_info = "";
  public String batchid = "";
  public int count;
  public String qunid = "";
  
  public qun_get_batch_photo_req() {}
  
  public qun_get_batch_photo_req(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.qunid = paramString1;
    this.albumid = paramString2;
    this.batchid = paramString3;
    this.count = paramInt;
    this.attach_info = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.batchid = paramJceInputStream.readString(2, true);
    this.count = paramJceInputStream.read(this.count, 3, false);
    this.attach_info = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.batchid, 2);
    paramJceOutputStream.write(this.count, 3);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_batch_photo_req
 * JD-Core Version:    0.7.0.1
 */