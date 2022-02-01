package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class GetCameraConfigRsp
  extends JceStruct
{
  static Map<String, CameraConfig> cache_ConfigMap = new HashMap();
  public int Code;
  public Map<String, CameraConfig> ConfigMap;
  
  static
  {
    CameraConfig localCameraConfig = new CameraConfig();
    cache_ConfigMap.put("", localCameraConfig);
  }
  
  public GetCameraConfigRsp() {}
  
  public GetCameraConfigRsp(int paramInt, Map<String, CameraConfig> paramMap)
  {
    this.Code = paramInt;
    this.ConfigMap = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Code = paramJceInputStream.read(this.Code, 0, false);
    this.ConfigMap = ((Map)paramJceInputStream.read(cache_ConfigMap, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Code, 0);
    if (this.ConfigMap != null) {
      paramJceOutputStream.write(this.ConfigMap, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp
 * JD-Core Version:    0.7.0.1
 */