public class ajex
{
  public short ao;
  public int cmd;
  public boolean cnR;
  public boolean cnS = true;
  public long fileSize;
  public String msg;
  public String path;
  public long sessionId;
  public String url;
  
  public String toString()
  {
    return "MsgBackupSessionTask[msg = " + this.msg + ", cmd = " + this.cmd + ", isFileTask = " + this.cnR + ", sessionId = " + this.sessionId + ", path = " + this.path + ", url = " + this.url + ", retryTimes = " + this.ao + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajex
 * JD-Core Version:    0.7.0.1
 */