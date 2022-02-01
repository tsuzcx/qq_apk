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
    String str = this.mKey;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.mValue;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    int i = this.mValueType;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MGuide.MBundle
 * JD-Core Version:    0.7.0.1
 */