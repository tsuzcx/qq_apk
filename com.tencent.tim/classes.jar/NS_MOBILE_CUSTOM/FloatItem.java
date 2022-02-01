package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class FloatItem
  extends JceStruct
{
  static int cache_iProperty;
  static int cache_iType = 0;
  static Map<String, String> cache_mapExtInfo;
  static ArrayList<FloatItemView> cache_vecView;
  public int iAngleSpeed;
  public int iCount;
  public int iDirection;
  public int iHasNewFlag;
  public int iMaxAngle;
  public int iMaxSize;
  public int iMinSize;
  public int iProperty;
  public int iRotationX;
  public int iRotationY;
  public int iSpeed;
  public int iType;
  public Map<String, String> mapExtInfo;
  public String strDescription = "";
  public String strDesignerInfo = "";
  public String strFloatName = "";
  public String strId = "";
  public String strThumbUrl = "";
  public String strTraceInfo = "";
  public ArrayList<FloatItemView> vecView;
  
  static
  {
    cache_iProperty = 0;
    cache_vecView = new ArrayList();
    FloatItemView localFloatItemView = new FloatItemView();
    cache_vecView.add(localFloatItemView);
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public FloatItem() {}
  
  public FloatItem(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, String paramString3, String paramString4, ArrayList<FloatItemView> paramArrayList, String paramString5, int paramInt12, String paramString6, Map<String, String> paramMap)
  {
    this.strId = paramString1;
    this.iType = paramInt1;
    this.iProperty = paramInt2;
    this.strFloatName = paramString2;
    this.iSpeed = paramInt3;
    this.iMaxAngle = paramInt4;
    this.iCount = paramInt5;
    this.iAngleSpeed = paramInt6;
    this.iRotationX = paramInt7;
    this.iRotationY = paramInt8;
    this.iMaxSize = paramInt9;
    this.iMinSize = paramInt10;
    this.iDirection = paramInt11;
    this.strDescription = paramString3;
    this.strThumbUrl = paramString4;
    this.vecView = paramArrayList;
    this.strTraceInfo = paramString5;
    this.iHasNewFlag = paramInt12;
    this.strDesignerInfo = paramString6;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strId = paramJceInputStream.readString(0, true);
    this.iType = paramJceInputStream.read(this.iType, 1, false);
    this.iProperty = paramJceInputStream.read(this.iProperty, 2, false);
    this.strFloatName = paramJceInputStream.readString(3, false);
    this.iSpeed = paramJceInputStream.read(this.iSpeed, 4, false);
    this.iMaxAngle = paramJceInputStream.read(this.iMaxAngle, 5, false);
    this.iCount = paramJceInputStream.read(this.iCount, 6, false);
    this.iAngleSpeed = paramJceInputStream.read(this.iAngleSpeed, 7, false);
    this.iRotationX = paramJceInputStream.read(this.iRotationX, 8, false);
    this.iRotationY = paramJceInputStream.read(this.iRotationY, 9, false);
    this.iMaxSize = paramJceInputStream.read(this.iMaxSize, 10, false);
    this.iMinSize = paramJceInputStream.read(this.iMinSize, 11, false);
    this.iDirection = paramJceInputStream.read(this.iDirection, 12, false);
    this.strDescription = paramJceInputStream.readString(13, false);
    this.strThumbUrl = paramJceInputStream.readString(14, false);
    this.vecView = ((ArrayList)paramJceInputStream.read(cache_vecView, 15, false));
    this.strTraceInfo = paramJceInputStream.readString(16, false);
    this.iHasNewFlag = paramJceInputStream.read(this.iHasNewFlag, 17, false);
    this.strDesignerInfo = paramJceInputStream.readString(18, false);
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 19, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strId, 0);
    paramJceOutputStream.write(this.iType, 1);
    paramJceOutputStream.write(this.iProperty, 2);
    if (this.strFloatName != null) {
      paramJceOutputStream.write(this.strFloatName, 3);
    }
    paramJceOutputStream.write(this.iSpeed, 4);
    paramJceOutputStream.write(this.iMaxAngle, 5);
    paramJceOutputStream.write(this.iCount, 6);
    paramJceOutputStream.write(this.iAngleSpeed, 7);
    paramJceOutputStream.write(this.iRotationX, 8);
    paramJceOutputStream.write(this.iRotationY, 9);
    paramJceOutputStream.write(this.iMaxSize, 10);
    paramJceOutputStream.write(this.iMinSize, 11);
    paramJceOutputStream.write(this.iDirection, 12);
    if (this.strDescription != null) {
      paramJceOutputStream.write(this.strDescription, 13);
    }
    if (this.strThumbUrl != null) {
      paramJceOutputStream.write(this.strThumbUrl, 14);
    }
    if (this.vecView != null) {
      paramJceOutputStream.write(this.vecView, 15);
    }
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 16);
    }
    paramJceOutputStream.write(this.iHasNewFlag, 17);
    if (this.strDesignerInfo != null) {
      paramJceOutputStream.write(this.strDesignerInfo, 18);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.FloatItem
 * JD-Core Version:    0.7.0.1
 */