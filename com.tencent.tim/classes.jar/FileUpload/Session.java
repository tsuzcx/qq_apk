package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Session
  extends JceStruct
{
  public String process_ip = "";
  public int process_port = 0;
  public String proxy_ip = "";
  public int proxy_port = 0;
  
  public Session() {}
  
  public Session(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this.process_ip = paramString1;
    this.process_port = paramInt1;
    this.proxy_ip = paramString2;
    this.proxy_port = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.process_ip = paramJceInputStream.readString(0, true);
    this.process_port = paramJceInputStream.read(this.process_port, 1, false);
    this.proxy_ip = paramJceInputStream.readString(2, false);
    this.proxy_port = paramJceInputStream.read(this.proxy_port, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.process_ip, 0);
    paramJceOutputStream.write(this.process_port, 1);
    if (this.proxy_ip != null) {
      paramJceOutputStream.write(this.proxy_ip, 2);
    }
    paramJceOutputStream.write(this.proxy_port, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     FileUpload.Session
 * JD-Core Version:    0.7.0.1
 */