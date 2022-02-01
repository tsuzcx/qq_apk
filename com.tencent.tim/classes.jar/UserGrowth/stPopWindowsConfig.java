package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stPopWindowsConfig
  extends JceStruct
{
  static stAnnexation cache_annexation;
  static Map<String, String> cache_exp;
  static stPopWindowsButton cache_jp_button = new stPopWindowsButton();
  public stAnnexation annexation;
  public String bg_img_url = "";
  public Map<String, String> exp;
  public String h5url = "";
  public int index;
  public stPopWindowsButton jp_button;
  public String remark = "";
  public int scene;
  public String schema_url = "";
  public String text = "";
  public String title = "";
  public String trace_id = "";
  public int type;
  public int windowsid;
  
  static
  {
    cache_annexation = new stAnnexation();
    cache_exp = new HashMap();
    cache_exp.put("", "");
  }
  
  public stPopWindowsConfig() {}
  
  public stPopWindowsConfig(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, stPopWindowsButton paramstPopWindowsButton, stAnnexation paramstAnnexation, int paramInt4, String paramString5, String paramString6, Map<String, String> paramMap, String paramString7)
  {
    this.windowsid = paramInt1;
    this.index = paramInt2;
    this.type = paramInt3;
    this.title = paramString1;
    this.text = paramString2;
    this.remark = paramString3;
    this.bg_img_url = paramString4;
    this.jp_button = paramstPopWindowsButton;
    this.annexation = paramstAnnexation;
    this.scene = paramInt4;
    this.h5url = paramString5;
    this.schema_url = paramString6;
    this.exp = paramMap;
    this.trace_id = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.windowsid = paramJceInputStream.read(this.windowsid, 0, false);
    this.index = paramJceInputStream.read(this.index, 1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.title = paramJceInputStream.readString(3, false);
    this.text = paramJceInputStream.readString(4, false);
    this.remark = paramJceInputStream.readString(5, false);
    this.bg_img_url = paramJceInputStream.readString(6, false);
    this.jp_button = ((stPopWindowsButton)paramJceInputStream.read(cache_jp_button, 7, false));
    this.annexation = ((stAnnexation)paramJceInputStream.read(cache_annexation, 8, false));
    this.scene = paramJceInputStream.read(this.scene, 9, false);
    this.h5url = paramJceInputStream.readString(11, false);
    this.schema_url = paramJceInputStream.readString(12, false);
    this.exp = ((Map)paramJceInputStream.read(cache_exp, 13, false));
    this.trace_id = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.windowsid, 0);
    paramJceOutputStream.write(this.index, 1);
    paramJceOutputStream.write(this.type, 2);
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 3);
    }
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 4);
    }
    if (this.remark != null) {
      paramJceOutputStream.write(this.remark, 5);
    }
    if (this.bg_img_url != null) {
      paramJceOutputStream.write(this.bg_img_url, 6);
    }
    if (this.jp_button != null) {
      paramJceOutputStream.write(this.jp_button, 7);
    }
    if (this.annexation != null) {
      paramJceOutputStream.write(this.annexation, 8);
    }
    paramJceOutputStream.write(this.scene, 9);
    if (this.h5url != null) {
      paramJceOutputStream.write(this.h5url, 11);
    }
    if (this.schema_url != null) {
      paramJceOutputStream.write(this.schema_url, 12);
    }
    if (this.exp != null) {
      paramJceOutputStream.write(this.exp, 13);
    }
    if (this.trace_id != null) {
      paramJceOutputStream.write(this.trace_id, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stPopWindowsConfig
 * JD-Core Version:    0.7.0.1
 */