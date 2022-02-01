import com.tencent.open.downloadnew.DownloadInfo;

public class arvk
{
  public String appId;
  public long awC;
  public int errCode;
  public String errMsg = "";
  public long jy;
  public String packageName;
  public int progress;
  public int state;
  
  public arvk a(DownloadInfo paramDownloadInfo)
  {
    this.appId = paramDownloadInfo.appId;
    this.packageName = paramDownloadInfo.packageName;
    this.state = kM(paramDownloadInfo.getState());
    this.progress = paramDownloadInfo.progress;
    this.awC = paramDownloadInfo.awN;
    this.jy = 0L;
    return this;
  }
  
  public int kM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 20: 
      return 4;
    case 3: 
      return 2;
    case 10: 
      return 5;
    case 2: 
      return 1;
    case 4: 
      return 3;
    case -2: 
      return 6;
    case 6: 
      return 7;
    }
    return 9;
  }
  
  public int kN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 700;
    case -24: 
      return -24;
    case 3: 
    case 731: 
    case 732: 
      return 102;
    case 1: 
      return 202;
    case 2: 
      return 201;
    case 4: 
      return 100;
    case 5: 
      return 101;
    case 600: 
    case 601: 
    case 602: 
    case 603: 
    case 604: 
    case 605: 
    case 606: 
      return 203;
    case 607: 
    case 700: 
    case 701: 
    case 702: 
      return 300;
    case -50: 
    case -40: 
    case -30: 
    case -20: 
    case -1: 
    case 703: 
    case 704: 
    case 705: 
    case 706: 
    case 707: 
      return 500;
    case 708: 
      return 400;
    case 709: 
      return 401;
    }
    return 600;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvk
 * JD-Core Version:    0.7.0.1
 */