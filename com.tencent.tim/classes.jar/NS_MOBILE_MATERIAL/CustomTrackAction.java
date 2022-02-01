package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class CustomTrackAction
  extends JceStruct
{
  static Map<String, String> cache_ExtendInfo = new HashMap();
  public String Button = "";
  public Map<String, String> ExtendInfo;
  public String ID = "";
  public String Name = "";
  public int Type;
  public String Url = "";
  public int is_block;
  
  static
  {
    cache_ExtendInfo.put("", "");
  }
  
  public CustomTrackAction() {}
  
  public CustomTrackAction(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    this.ID = paramString1;
    this.Type = paramInt1;
    this.Name = paramString2;
    this.is_block = paramInt2;
    this.Url = paramString3;
    this.Button = paramString4;
    this.ExtendInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ID = paramJceInputStream.readString(0, false);
    this.Type = paramJceInputStream.read(this.Type, 1, false);
    this.Name = paramJceInputStream.readString(2, false);
    this.is_block = paramJceInputStream.read(this.is_block, 3, false);
    this.Url = paramJceInputStream.readString(4, false);
    this.Button = paramJceInputStream.readString(5, false);
    this.ExtendInfo = ((Map)paramJceInputStream.read(cache_ExtendInfo, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.ID != null) {
      paramJceOutputStream.write(this.ID, 0);
    }
    paramJceOutputStream.write(this.Type, 1);
    if (this.Name != null) {
      paramJceOutputStream.write(this.Name, 2);
    }
    paramJceOutputStream.write(this.is_block, 3);
    if (this.Url != null) {
      paramJceOutputStream.write(this.Url, 4);
    }
    if (this.Button != null) {
      paramJceOutputStream.write(this.Button, 5);
    }
    if (this.ExtendInfo != null) {
      paramJceOutputStream.write(this.ExtendInfo, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.CustomTrackAction
 * JD-Core Version:    0.7.0.1
 */