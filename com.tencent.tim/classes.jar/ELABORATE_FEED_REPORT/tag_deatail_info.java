package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class tag_deatail_info
  extends JceStruct
{
  static ArrayList<String> cache_vecReferenceTagList;
  static ArrayList<String> cache_vecTagList = new ArrayList();
  public long uFirstClassId;
  public long uSecondClassId;
  public ArrayList<String> vecReferenceTagList;
  public ArrayList<String> vecTagList;
  
  static
  {
    cache_vecTagList.add("");
    cache_vecReferenceTagList = new ArrayList();
    cache_vecReferenceTagList.add("");
  }
  
  public tag_deatail_info() {}
  
  public tag_deatail_info(ArrayList<String> paramArrayList1, long paramLong1, long paramLong2, ArrayList<String> paramArrayList2)
  {
    this.vecTagList = paramArrayList1;
    this.uFirstClassId = paramLong1;
    this.uSecondClassId = paramLong2;
    this.vecReferenceTagList = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecTagList = ((ArrayList)paramJceInputStream.read(cache_vecTagList, 0, false));
    this.uFirstClassId = paramJceInputStream.read(this.uFirstClassId, 1, false);
    this.uSecondClassId = paramJceInputStream.read(this.uSecondClassId, 2, false);
    this.vecReferenceTagList = ((ArrayList)paramJceInputStream.read(cache_vecReferenceTagList, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecTagList != null) {
      paramJceOutputStream.write(this.vecTagList, 0);
    }
    paramJceOutputStream.write(this.uFirstClassId, 1);
    paramJceOutputStream.write(this.uSecondClassId, 2);
    if (this.vecReferenceTagList != null) {
      paramJceOutputStream.write(this.vecReferenceTagList, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.tag_deatail_info
 * JD-Core Version:    0.7.0.1
 */