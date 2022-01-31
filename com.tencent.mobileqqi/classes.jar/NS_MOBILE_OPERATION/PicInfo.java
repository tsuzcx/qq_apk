package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class PicInfo
  extends JceStruct
{
  static Map cache_mapWaterMarkParams;
  public String albumid = "";
  public int hdheight = 0;
  public String hdid = "";
  public int hdwidth = 0;
  public boolean ishd = true;
  public Map mapWaterMarkParams = null;
  public int picheight = 0;
  public String pictureid = "";
  public int pictype = 0;
  public int picwidth = 0;
  public String sloc = "";
  public String strWaterMarkID = "";
  public String strWaterMarkMemo = "";
  
  public PicInfo() {}
  
  public PicInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString4, int paramInt4, int paramInt5, String paramString5, String paramString6, Map paramMap)
  {
    this.albumid = paramString1;
    this.pictureid = paramString2;
    this.sloc = paramString3;
    this.pictype = paramInt1;
    this.picheight = paramInt2;
    this.picwidth = paramInt3;
    this.ishd = paramBoolean;
    this.hdid = paramString4;
    this.hdheight = paramInt4;
    this.hdwidth = paramInt5;
    this.strWaterMarkID = paramString5;
    this.strWaterMarkMemo = paramString6;
    this.mapWaterMarkParams = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, false);
    this.pictureid = paramJceInputStream.readString(1, false);
    this.sloc = paramJceInputStream.readString(2, false);
    this.pictype = paramJceInputStream.read(this.pictype, 3, false);
    this.picheight = paramJceInputStream.read(this.picheight, 4, false);
    this.picwidth = paramJceInputStream.read(this.picwidth, 5, false);
    this.ishd = paramJceInputStream.read(this.ishd, 6, false);
    this.hdid = paramJceInputStream.readString(7, false);
    this.hdheight = paramJceInputStream.read(this.hdheight, 8, false);
    this.hdwidth = paramJceInputStream.read(this.hdwidth, 9, false);
    this.strWaterMarkID = paramJceInputStream.readString(10, false);
    this.strWaterMarkMemo = paramJceInputStream.readString(11, false);
    if (cache_mapWaterMarkParams == null)
    {
      cache_mapWaterMarkParams = new HashMap();
      cache_mapWaterMarkParams.put("", "");
    }
    this.mapWaterMarkParams = ((Map)paramJceInputStream.read(cache_mapWaterMarkParams, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 0);
    }
    if (this.pictureid != null) {
      paramJceOutputStream.write(this.pictureid, 1);
    }
    if (this.sloc != null) {
      paramJceOutputStream.write(this.sloc, 2);
    }
    paramJceOutputStream.write(this.pictype, 3);
    paramJceOutputStream.write(this.picheight, 4);
    paramJceOutputStream.write(this.picwidth, 5);
    paramJceOutputStream.write(this.ishd, 6);
    if (this.hdid != null) {
      paramJceOutputStream.write(this.hdid, 7);
    }
    paramJceOutputStream.write(this.hdheight, 8);
    paramJceOutputStream.write(this.hdwidth, 9);
    if (this.strWaterMarkID != null) {
      paramJceOutputStream.write(this.strWaterMarkID, 10);
    }
    if (this.strWaterMarkMemo != null) {
      paramJceOutputStream.write(this.strWaterMarkMemo, 11);
    }
    if (this.mapWaterMarkParams != null) {
      paramJceOutputStream.write(this.mapWaterMarkParams, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.PicInfo
 * JD-Core Version:    0.7.0.1
 */