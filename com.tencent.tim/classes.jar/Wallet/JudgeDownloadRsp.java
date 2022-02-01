package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class JudgeDownloadRsp
  extends JceStruct
{
  public static final int STATUS_NOT_DOWNLOAD = 2;
  public static final int STATUS_NOW_DOWNLOAD = 1;
  public static final int STATUS_NULL = -1;
  public static final int STATUS_WAIT_TO_REQ = 0;
  static ArrayList<ResInfo> cache_vecDownloadRes = new ArrayList();
  public int iDownloadStatus;
  public int iFailedRetryMax = 3;
  public int iSegTime;
  public ArrayList<ResInfo> vecDownloadRes;
  
  static
  {
    ResInfo localResInfo = new ResInfo();
    cache_vecDownloadRes.add(localResInfo);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iDownloadStatus = paramJceInputStream.read(this.iDownloadStatus, 0, false);
    this.vecDownloadRes = ((ArrayList)paramJceInputStream.read(cache_vecDownloadRes, 1, false));
    this.iSegTime = paramJceInputStream.read(this.iSegTime, 2, false);
    this.iFailedRetryMax = paramJceInputStream.read(this.iFailedRetryMax, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iDownloadStatus, 0);
    if (this.vecDownloadRes != null) {
      paramJceOutputStream.write(this.vecDownloadRes, 1);
    }
    paramJceOutputStream.write(this.iSegTime, 2);
    paramJceOutputStream.write(this.iFailedRetryMax, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.JudgeDownloadRsp
 * JD-Core Version:    0.7.0.1
 */