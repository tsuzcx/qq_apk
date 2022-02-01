public class aonh
{
  public boolean cNn;
  public boolean isIpv6;
  public String mIp;
  public int port = 80;
  
  public void bbs() {}
  
  public String ox(String paramString)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    if (paramString != null)
    {
      if (!this.cNn) {
        break label109;
      }
      if (!paramString.startsWith("http://")) {
        break label72;
      }
      localObject1 = "http://" + this.mIp;
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + "/";
      return localObject1;
      label72:
      localObject1 = localObject2;
      if (paramString.startsWith("https://")) {
        localObject1 = "https://" + this.mIp;
      }
    }
    label109:
    if (paramString.startsWith("http://")) {
      if ((this.isIpv6) && (!this.mIp.startsWith("["))) {
        localObject1 = "http://[" + this.mIp + "]";
      }
    }
    while (this.port != 80)
    {
      return (String)localObject1 + ":" + this.port + "/";
      localObject1 = "http://" + this.mIp;
      continue;
      localObject1 = localObject3;
      if (paramString.startsWith("https://")) {
        if ((this.isIpv6) && (!this.mIp.startsWith("["))) {
          localObject1 = "https://[" + this.mIp + "]";
        } else {
          localObject1 = "https://" + this.mIp;
        }
      }
    }
    return (String)localObject1 + "/";
  }
  
  public String toString()
  {
    return this.mIp + ":" + this.port;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonh
 * JD-Core Version:    0.7.0.1
 */