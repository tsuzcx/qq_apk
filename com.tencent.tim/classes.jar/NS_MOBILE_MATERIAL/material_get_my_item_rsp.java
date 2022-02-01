package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class material_get_my_item_rsp
  extends JceStruct
{
  static MaterialUserInfo cache_stUserItemInfo = new MaterialUserInfo();
  public int iCode;
  public MaterialUserInfo stUserItemInfo;
  public String strErrMsg = "";
  
  public material_get_my_item_rsp() {}
  
  public material_get_my_item_rsp(int paramInt, MaterialUserInfo paramMaterialUserInfo, String paramString)
  {
    this.iCode = paramInt;
    this.stUserItemInfo = paramMaterialUserInfo;
    this.strErrMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, true);
    this.stUserItemInfo = ((MaterialUserInfo)paramJceInputStream.read(cache_stUserItemInfo, 1, true));
    this.strErrMsg = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    paramJceOutputStream.write(this.stUserItemInfo, 1);
    if (this.strErrMsg != null) {
      paramJceOutputStream.write(this.strErrMsg, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_get_my_item_rsp
 * JD-Core Version:    0.7.0.1
 */