package Protocol.MGuide;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class MDoraemonRes
  extends JceStruct
{
  static ArrayList<String> a = new ArrayList();
  public String mDoraemonText = "";
  public int mDoraemonType = 0;
  public ArrayList<String> mFileList = null;
  
  static
  {
    a.add("");
  }
  
  public JceStruct newInit()
  {
    return new MDoraemonRes();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mFileList = ((ArrayList)paramJceInputStream.read(a, 0, false));
    this.mDoraemonType = paramJceInputStream.read(this.mDoraemonType, 1, false);
    this.mDoraemonText = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.mFileList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    int i = this.mDoraemonType;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    localObject = this.mDoraemonText;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MGuide.MDoraemonRes
 * JD-Core Version:    0.7.0.1
 */