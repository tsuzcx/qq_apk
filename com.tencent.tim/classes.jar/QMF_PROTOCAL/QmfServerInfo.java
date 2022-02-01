package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QmfServerInfo
  extends JceStruct
{
  static QmfClientIpInfo cache_ipWebapp;
  public long changeTime;
  public QmfClientIpInfo ipWebapp;
  
  public QmfServerInfo() {}
  
  public QmfServerInfo(QmfClientIpInfo paramQmfClientIpInfo, long paramLong)
  {
    this.ipWebapp = paramQmfClientIpInfo;
    this.changeTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_ipWebapp == null) {
      cache_ipWebapp = new QmfClientIpInfo();
    }
    this.ipWebapp = ((QmfClientIpInfo)paramJceInputStream.read(cache_ipWebapp, 0, true));
    this.changeTime = paramJceInputStream.read(this.changeTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ipWebapp, 0);
    paramJceOutputStream.write(this.changeTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QMF_PROTOCAL.QmfServerInfo
 * JD-Core Version:    0.7.0.1
 */