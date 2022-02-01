package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPhotoTag
  extends JceStruct
{
  static int cache_direction = 0;
  static int cache_type = 0;
  public String content = "";
  public int direction = 0;
  public String poiTagStreet = "";
  public String tag_id = "";
  public int type = 0;
  public long x_scale = 0L;
  public long y_scale = 0L;
  
  public stPhotoTag() {}
  
  public stPhotoTag(int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, String paramString3)
  {
    this.type = paramInt1;
    this.content = paramString1;
    this.tag_id = paramString2;
    this.x_scale = paramLong1;
    this.y_scale = paramLong2;
    this.direction = paramInt2;
    this.poiTagStreet = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.content = paramJceInputStream.readString(1, true);
    this.tag_id = paramJceInputStream.readString(2, true);
    this.x_scale = paramJceInputStream.read(this.x_scale, 3, false);
    this.y_scale = paramJceInputStream.read(this.y_scale, 4, false);
    this.direction = paramJceInputStream.read(this.direction, 5, false);
    this.poiTagStreet = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.content, 1);
    paramJceOutputStream.write(this.tag_id, 2);
    paramJceOutputStream.write(this.x_scale, 3);
    paramJceOutputStream.write(this.y_scale, 4);
    paramJceOutputStream.write(this.direction, 5);
    if (this.poiTagStreet != null) {
      paramJceOutputStream.write(this.poiTagStreet, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     FileUpload.stPhotoTag
 * JD-Core Version:    0.7.0.1
 */