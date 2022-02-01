package MWIFI;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SCGet3rdCloudCheck
  extends JceStruct
{
  static ArrayList<Integer> cache_safeTypeList = new ArrayList();
  public int delayHour = 24;
  public String h5 = "";
  public ArrayList<Integer> safeTypeList;
  public String tips = "";
  public int tipsType = 0;
  
  static
  {
    cache_safeTypeList.add(Integer.valueOf(0));
  }
  
  public JceStruct newInit()
  {
    return new SCGet3rdCloudCheck();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tipsType = paramJceInputStream.read(this.tipsType, 0, true);
    this.tips = paramJceInputStream.readString(1, false);
    this.delayHour = paramJceInputStream.read(this.delayHour, 2, true);
    this.safeTypeList = ((ArrayList)paramJceInputStream.read(cache_safeTypeList, 3, false));
    this.h5 = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tipsType, 0);
    if (this.tips != null) {
      paramJceOutputStream.write(this.tips, 1);
    }
    paramJceOutputStream.write(this.delayHour, 2);
    if (this.safeTypeList != null) {
      paramJceOutputStream.write(this.safeTypeList, 3);
    }
    if (this.h5 != null) {
      paramJceOutputStream.write(this.h5, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MWIFI.SCGet3rdCloudCheck
 * JD-Core Version:    0.7.0.1
 */