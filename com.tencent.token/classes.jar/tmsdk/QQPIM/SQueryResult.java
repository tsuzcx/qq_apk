package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SQueryResult
  extends JceStruct
{
  static STagStats eK;
  static STagStats eL;
  static STagStats eM;
  public int confirmtype = 0;
  public STagStats firsttag = null;
  public String phonenum = "";
  public int queryrst = 0;
  public int reportnum = 0;
  public STagStats secondtag = null;
  public STagStats thirdtag = null;
  
  public SQueryResult() {}
  
  public SQueryResult(String paramString, int paramInt1, int paramInt2, STagStats paramSTagStats1, STagStats paramSTagStats2, STagStats paramSTagStats3, int paramInt3)
  {
    this.phonenum = paramString;
    this.queryrst = paramInt1;
    this.reportnum = paramInt2;
    this.firsttag = paramSTagStats1;
    this.secondtag = paramSTagStats2;
    this.thirdtag = paramSTagStats3;
    this.confirmtype = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.phonenum = paramJceInputStream.readString(0, true);
    this.queryrst = paramJceInputStream.read(this.queryrst, 1, true);
    this.reportnum = paramJceInputStream.read(this.reportnum, 2, false);
    if (eK == null) {
      eK = new STagStats();
    }
    this.firsttag = ((STagStats)paramJceInputStream.read(eK, 3, false));
    if (eL == null) {
      eL = new STagStats();
    }
    this.secondtag = ((STagStats)paramJceInputStream.read(eL, 4, false));
    if (eM == null) {
      eM = new STagStats();
    }
    this.thirdtag = ((STagStats)paramJceInputStream.read(eM, 5, false));
    this.confirmtype = paramJceInputStream.read(this.confirmtype, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.phonenum, 0);
    paramJceOutputStream.write(this.queryrst, 1);
    paramJceOutputStream.write(this.reportnum, 2);
    STagStats localSTagStats = this.firsttag;
    if (localSTagStats != null) {
      paramJceOutputStream.write(localSTagStats, 3);
    }
    localSTagStats = this.secondtag;
    if (localSTagStats != null) {
      paramJceOutputStream.write(localSTagStats, 4);
    }
    localSTagStats = this.thirdtag;
    if (localSTagStats != null) {
      paramJceOutputStream.write(localSTagStats, 5);
    }
    paramJceOutputStream.write(this.confirmtype, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SQueryResult
 * JD-Core Version:    0.7.0.1
 */