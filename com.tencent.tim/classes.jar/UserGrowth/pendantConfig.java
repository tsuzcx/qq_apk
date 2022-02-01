package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class pendantConfig
  extends JceStruct
{
  static Map<String, String> cache_ext;
  static pendantStageConfig cache_medium_stage;
  static pendantStageConfig cache_strong_stage;
  static pendantStageConfig cache_weak_stage = new pendantStageConfig();
  public int cid;
  public boolean enable;
  public Map<String, String> ext;
  public pendantStageConfig medium_stage;
  public pendantStageConfig strong_stage;
  public String trace_id = "";
  public pendantStageConfig weak_stage;
  
  static
  {
    cache_medium_stage = new pendantStageConfig();
    cache_strong_stage = new pendantStageConfig();
    cache_ext = new HashMap();
    cache_ext.put("", "");
  }
  
  public pendantConfig() {}
  
  public pendantConfig(boolean paramBoolean, pendantStageConfig parampendantStageConfig1, pendantStageConfig parampendantStageConfig2, pendantStageConfig parampendantStageConfig3, int paramInt, Map<String, String> paramMap, String paramString)
  {
    this.enable = paramBoolean;
    this.weak_stage = parampendantStageConfig1;
    this.medium_stage = parampendantStageConfig2;
    this.strong_stage = parampendantStageConfig3;
    this.cid = paramInt;
    this.ext = paramMap;
    this.trace_id = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.enable = paramJceInputStream.read(this.enable, 0, false);
    this.weak_stage = ((pendantStageConfig)paramJceInputStream.read(cache_weak_stage, 1, false));
    this.medium_stage = ((pendantStageConfig)paramJceInputStream.read(cache_medium_stage, 2, false));
    this.strong_stage = ((pendantStageConfig)paramJceInputStream.read(cache_strong_stage, 3, false));
    this.cid = paramJceInputStream.read(this.cid, 4, false);
    this.ext = ((Map)paramJceInputStream.read(cache_ext, 5, false));
    this.trace_id = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.enable, 0);
    if (this.weak_stage != null) {
      paramJceOutputStream.write(this.weak_stage, 1);
    }
    if (this.medium_stage != null) {
      paramJceOutputStream.write(this.medium_stage, 2);
    }
    if (this.strong_stage != null) {
      paramJceOutputStream.write(this.strong_stage, 3);
    }
    paramJceOutputStream.write(this.cid, 4);
    if (this.ext != null) {
      paramJceOutputStream.write(this.ext, 5);
    }
    if (this.trace_id != null) {
      paramJceOutputStream.write(this.trace_id, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.pendantConfig
 * JD-Core Version:    0.7.0.1
 */