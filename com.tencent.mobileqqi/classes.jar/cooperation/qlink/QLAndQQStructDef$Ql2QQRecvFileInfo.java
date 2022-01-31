package cooperation.qlink;

import java.io.Serializable;

public class QLAndQQStructDef$Ql2QQRecvFileInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int connApTimeout;
  public int errCode;
  public boolean failed = false;
  public QLAndQQStructDef.FileInfo fileinfo = new QLAndQQStructDef.FileInfo();
  public String filename;
  public long filesize;
  public boolean forceConnAp;
  public byte isChnAvailable;
  public boolean isLastMsg;
  public int judgeResult;
  public int peerIp;
  public short peerPort;
  public String preSharedKey;
  public int source;
  public String ssid;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QLAndQQStructDef.Ql2QQRecvFileInfo
 * JD-Core Version:    0.7.0.1
 */