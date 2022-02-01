package qqwifi.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ContentResponse
  extends JceStruct
{
  public String resource = "";
  public int ret;
  
  public ContentResponse() {}
  
  public ContentResponse(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.resource = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.resource = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.resource, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqwifi.MQQ.ContentResponse
 * JD-Core Version:    0.7.0.1
 */