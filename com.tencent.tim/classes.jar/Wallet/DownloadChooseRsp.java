package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class DownloadChooseRsp
  extends JceStruct
{
  static ArrayList<ResInfo> cache_vecResInfo = new ArrayList();
  public ArrayList<ResInfo> vecResInfo;
  
  static
  {
    ResInfo localResInfo = new ResInfo();
    cache_vecResInfo.add(localResInfo);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecResInfo = ((ArrayList)paramJceInputStream.read(cache_vecResInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecResInfo != null) {
      paramJceOutputStream.write(this.vecResInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.DownloadChooseRsp
 * JD-Core Version:    0.7.0.1
 */