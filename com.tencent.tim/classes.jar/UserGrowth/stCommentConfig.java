package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stCommentConfig
  extends JceStruct
{
  public String guideText = "";
  
  public stCommentConfig() {}
  
  public stCommentConfig(String paramString)
  {
    this.guideText = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.guideText = paramJceInputStream.readString(0, false);
  }
  
  public String toString()
  {
    return "stCommentConfig{guideText='" + this.guideText + '\'' + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.guideText != null) {
      paramJceOutputStream.write(this.guideText, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stCommentConfig
 * JD-Core Version:    0.7.0.1
 */