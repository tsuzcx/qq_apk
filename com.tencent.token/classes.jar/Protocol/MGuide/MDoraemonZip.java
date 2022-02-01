package Protocol.MGuide;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MDoraemonZip
  extends JceStruct
{
  static ArrayList<MDoraemonRes> a = new ArrayList();
  public ArrayList<MDoraemonRes> mDoraemonResList = null;
  public String mDoraemonZipUrl = "";
  
  static
  {
    MDoraemonRes localMDoraemonRes = new MDoraemonRes();
    a.add(localMDoraemonRes);
  }
  
  public JceStruct newInit()
  {
    return new MDoraemonZip();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mDoraemonZipUrl = paramJceInputStream.readString(0, false);
    this.mDoraemonResList = ((ArrayList)paramJceInputStream.read(a, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mDoraemonZipUrl != null) {
      paramJceOutputStream.write(this.mDoraemonZipUrl, 0);
    }
    if (this.mDoraemonResList != null) {
      paramJceOutputStream.write(this.mDoraemonResList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MGuide.MDoraemonZip
 * JD-Core Version:    0.7.0.1
 */