package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWMDBCombinReq
  extends JceStruct
{
  static stVersions cache_versions;
  public String flashId = "";
  public int richFlagMask = 1;
  public stVersions versions = null;
  
  public stWMDBCombinReq() {}
  
  public stWMDBCombinReq(stVersions paramstVersions, int paramInt, String paramString)
  {
    this.versions = paramstVersions;
    this.richFlagMask = paramInt;
    this.flashId = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_versions == null) {
      cache_versions = new stVersions();
    }
    this.versions = ((stVersions)paramJceInputStream.read(cache_versions, 0, true));
    this.richFlagMask = paramJceInputStream.read(this.richFlagMask, 1, true);
    this.flashId = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.versions, 0);
    paramJceOutputStream.write(this.richFlagMask, 1);
    paramJceOutputStream.write(this.flashId, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     WMDBClientInterface.stWMDBCombinReq
 * JD-Core Version:    0.7.0.1
 */