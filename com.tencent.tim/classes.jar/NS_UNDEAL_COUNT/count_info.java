package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class count_info
  extends JceStruct
{
  static single_count cache_stCount = new single_count();
  static ArrayList<feed_host_info> cache_vecUinList = new ArrayList();
  public long cTime;
  public int iShowLevel;
  public int iSubCountID;
  public single_count stCount;
  public String strIconUrl = "";
  public String strReportValue = "";
  public String strShowMsg = "";
  public String trace_info = "";
  public ArrayList<feed_host_info> vecUinList;
  
  static
  {
    feed_host_info localfeed_host_info = new feed_host_info();
    cache_vecUinList.add(localfeed_host_info);
  }
  
  public count_info() {}
  
  public count_info(single_count paramsingle_count, ArrayList<feed_host_info> paramArrayList, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    this.stCount = paramsingle_count;
    this.vecUinList = paramArrayList;
    this.trace_info = paramString1;
    this.iSubCountID = paramInt1;
    this.strIconUrl = paramString2;
    this.strShowMsg = paramString3;
    this.strReportValue = paramString4;
    this.cTime = paramLong;
    this.iShowLevel = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stCount = ((single_count)paramJceInputStream.read(cache_stCount, 0, false));
    this.vecUinList = ((ArrayList)paramJceInputStream.read(cache_vecUinList, 1, false));
    this.trace_info = paramJceInputStream.readString(2, false);
    this.iSubCountID = paramJceInputStream.read(this.iSubCountID, 3, false);
    this.strIconUrl = paramJceInputStream.readString(4, false);
    this.strShowMsg = paramJceInputStream.readString(5, false);
    this.strReportValue = paramJceInputStream.readString(6, false);
    this.cTime = paramJceInputStream.read(this.cTime, 7, false);
    this.iShowLevel = paramJceInputStream.read(this.iShowLevel, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stCount != null) {
      paramJceOutputStream.write(this.stCount, 0);
    }
    if (this.vecUinList != null) {
      paramJceOutputStream.write(this.vecUinList, 1);
    }
    if (this.trace_info != null) {
      paramJceOutputStream.write(this.trace_info, 2);
    }
    paramJceOutputStream.write(this.iSubCountID, 3);
    if (this.strIconUrl != null) {
      paramJceOutputStream.write(this.strIconUrl, 4);
    }
    if (this.strShowMsg != null) {
      paramJceOutputStream.write(this.strShowMsg, 5);
    }
    if (this.strReportValue != null) {
      paramJceOutputStream.write(this.strReportValue, 6);
    }
    paramJceOutputStream.write(this.cTime, 7);
    paramJceOutputStream.write(this.iShowLevel, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.count_info
 * JD-Core Version:    0.7.0.1
 */