package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class entrance_cfg
  extends JceStruct
{
  static st_report_info cache_stReportInfo = new st_report_info();
  public int iEntranceId;
  public int isAnchor;
  public int isDefualt;
  public String sEntranceAction = "";
  public String sEntranceIcon = "";
  public String sEntranceName = "";
  public String sQbossEntranceIcon = "";
  public String sQbossTraceInfo = "";
  public st_report_info stReportInfo;
  public int tabid;
  
  public entrance_cfg() {}
  
  public entrance_cfg(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4, String paramString5, int paramInt4, st_report_info paramst_report_info)
  {
    this.iEntranceId = paramInt1;
    this.sEntranceName = paramString1;
    this.sEntranceIcon = paramString2;
    this.sEntranceAction = paramString3;
    this.isDefualt = paramInt2;
    this.tabid = paramInt3;
    this.sQbossEntranceIcon = paramString4;
    this.sQbossTraceInfo = paramString5;
    this.isAnchor = paramInt4;
    this.stReportInfo = paramst_report_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iEntranceId = paramJceInputStream.read(this.iEntranceId, 0, false);
    this.sEntranceName = paramJceInputStream.readString(1, false);
    this.sEntranceIcon = paramJceInputStream.readString(2, false);
    this.sEntranceAction = paramJceInputStream.readString(3, false);
    this.isDefualt = paramJceInputStream.read(this.isDefualt, 4, false);
    this.tabid = paramJceInputStream.read(this.tabid, 5, false);
    this.sQbossEntranceIcon = paramJceInputStream.readString(6, false);
    this.sQbossTraceInfo = paramJceInputStream.readString(7, false);
    this.isAnchor = paramJceInputStream.read(this.isAnchor, 8, false);
    this.stReportInfo = ((st_report_info)paramJceInputStream.read(cache_stReportInfo, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iEntranceId, 0);
    if (this.sEntranceName != null) {
      paramJceOutputStream.write(this.sEntranceName, 1);
    }
    if (this.sEntranceIcon != null) {
      paramJceOutputStream.write(this.sEntranceIcon, 2);
    }
    if (this.sEntranceAction != null) {
      paramJceOutputStream.write(this.sEntranceAction, 3);
    }
    paramJceOutputStream.write(this.isDefualt, 4);
    paramJceOutputStream.write(this.tabid, 5);
    if (this.sQbossEntranceIcon != null) {
      paramJceOutputStream.write(this.sQbossEntranceIcon, 6);
    }
    if (this.sQbossTraceInfo != null) {
      paramJceOutputStream.write(this.sQbossTraceInfo, 7);
    }
    paramJceOutputStream.write(this.isAnchor, 8);
    if (this.stReportInfo != null) {
      paramJceOutputStream.write(this.stReportInfo, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.entrance_cfg
 * JD-Core Version:    0.7.0.1
 */