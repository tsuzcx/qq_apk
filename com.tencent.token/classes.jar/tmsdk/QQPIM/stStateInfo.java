package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stStateInfo
  extends JceStruct
{
  static STTrafficTemplate_Optional fo;
  public STTrafficTemplate_Optional curTemplate = null;
  public String info = "";
  public int ntype = 0;
  
  public stStateInfo() {}
  
  public stStateInfo(String paramString, int paramInt, STTrafficTemplate_Optional paramSTTrafficTemplate_Optional)
  {
    this.info = paramString;
    this.ntype = paramInt;
    this.curTemplate = paramSTTrafficTemplate_Optional;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.info = paramJceInputStream.readString(0, false);
    this.ntype = paramJceInputStream.read(this.ntype, 1, false);
    if (fo == null) {
      fo = new STTrafficTemplate_Optional();
    }
    this.curTemplate = ((STTrafficTemplate_Optional)paramJceInputStream.read(fo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.ntype, 1);
    localObject = this.curTemplate;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.stStateInfo
 * JD-Core Version:    0.7.0.1
 */