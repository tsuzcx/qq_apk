package Protocol.MGuide;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MBundle
  extends JceStruct
{
  public String mKey = "";
  public String mValue = "";
  public int mValueType = 0;
  
  public JceStruct newInit()
  {
    return new MBundle();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mKey = paramJceInputStream.readString(0, false);
    this.mValue = paramJceInputStream.readString(1, false);
    this.mValueType = paramJceInputStream.read(this.mValueType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mKey != null) {
      paramJceOutputStream.write(this.mKey, 0);
    }
    if (this.mValue != null) {
      paramJceOutputStream.write(this.mValue, 1);
    }
    if (this.mValueType != 0) {
      paramJceOutputStream.write(this.mValueType, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MGuide.MBundle
 * JD-Core Version:    0.7.0.1
 */