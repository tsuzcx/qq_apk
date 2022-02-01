package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FolderInfo
  extends JceStruct
{
  static ArrayList<SuffixInfo> ez = new ArrayList();
  public String absolutepath = "";
  public long clearTime = 0L;
  public long deleteSize = 0L;
  public int folderType = 0;
  public boolean isView = false;
  public String packageName = "";
  public int pathType = 0;
  public ArrayList<SuffixInfo> suffixinfos = null;
  
  static
  {
    SuffixInfo localSuffixInfo = new SuffixInfo();
    ez.add(localSuffixInfo);
  }
  
  public JceStruct newInit()
  {
    return new FolderInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.absolutepath = paramJceInputStream.readString(0, true);
    this.suffixinfos = ((ArrayList)paramJceInputStream.read(ez, 1, true));
    this.folderType = paramJceInputStream.read(this.folderType, 2, false);
    this.clearTime = paramJceInputStream.read(this.clearTime, 3, false);
    this.packageName = paramJceInputStream.readString(4, false);
    this.isView = paramJceInputStream.read(this.isView, 5, false);
    this.deleteSize = paramJceInputStream.read(this.deleteSize, 6, false);
    this.pathType = paramJceInputStream.read(this.pathType, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.absolutepath, 0);
    paramJceOutputStream.write(this.suffixinfos, 1);
    if (this.folderType != 0) {
      paramJceOutputStream.write(this.folderType, 2);
    }
    if (this.clearTime != 0L) {
      paramJceOutputStream.write(this.clearTime, 3);
    }
    if (this.packageName != null) {
      paramJceOutputStream.write(this.packageName, 4);
    }
    if (this.isView) {
      paramJceOutputStream.write(this.isView, 5);
    }
    if (this.deleteSize != 0L) {
      paramJceOutputStream.write(this.deleteSize, 6);
    }
    if (this.pathType != 0) {
      paramJceOutputStream.write(this.pathType, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.FolderInfo
 * JD-Core Version:    0.7.0.1
 */