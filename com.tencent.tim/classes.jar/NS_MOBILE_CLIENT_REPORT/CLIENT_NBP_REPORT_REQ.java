package NS_MOBILE_CLIENT_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class CLIENT_NBP_REPORT_REQ
  extends JceStruct
{
  static Map<String, String> cache_extra_info;
  static ArrayList<String> cache_report_info = new ArrayList();
  public Map<String, String> extra_info;
  public ArrayList<String> report_info;
  public String strABTestId = "";
  
  static
  {
    cache_report_info.add("");
    cache_extra_info = new HashMap();
    cache_extra_info.put("", "");
  }
  
  public CLIENT_NBP_REPORT_REQ() {}
  
  public CLIENT_NBP_REPORT_REQ(String paramString, ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    this.strABTestId = paramString;
    this.report_info = paramArrayList;
    this.extra_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strABTestId = paramJceInputStream.readString(0, false);
    this.report_info = ((ArrayList)paramJceInputStream.read(cache_report_info, 1, false));
    this.extra_info = ((Map)paramJceInputStream.read(cache_extra_info, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strABTestId != null) {
      paramJceOutputStream.write(this.strABTestId, 0);
    }
    if (this.report_info != null) {
      paramJceOutputStream.write(this.report_info, 1);
    }
    if (this.extra_info != null) {
      paramJceOutputStream.write(this.extra_info, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_CLIENT_REPORT.CLIENT_NBP_REPORT_REQ
 * JD-Core Version:    0.7.0.1
 */