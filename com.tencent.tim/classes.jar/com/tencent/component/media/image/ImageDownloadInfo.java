package com.tencent.component.media.image;

public class ImageDownloadInfo
{
  public String clientIp;
  public String contentType;
  public String downloadDetailInfo;
  public int failCode;
  public int nocacheCode;
  public int retCode;
  public String serverIp;
  
  private ImageDownloadInfo(Builder paramBuilder)
  {
    this.failCode = paramBuilder.fail_code;
    this.retCode = paramBuilder.ret_code;
    this.contentType = paramBuilder.content_type;
    this.serverIp = paramBuilder.server_ip;
    this.clientIp = paramBuilder.client_ip;
    this.nocacheCode = paramBuilder.nocache_code;
    this.downloadDetailInfo = paramBuilder.download_detail_info;
  }
  
  public static class Builder
  {
    private String client_ip;
    private String content_type;
    public String download_detail_info;
    private int fail_code;
    public int nocache_code;
    private int ret_code;
    private String server_ip;
    
    public Builder(int paramInt1, int paramInt2)
    {
      this.fail_code = paramInt1;
      this.ret_code = paramInt2;
    }
    
    public ImageDownloadInfo build()
    {
      return new ImageDownloadInfo(this, null);
    }
    
    public Builder clientIp(String paramString)
    {
      this.client_ip = paramString;
      return this;
    }
    
    public Builder contentType(String paramString)
    {
      this.content_type = paramString;
      return this;
    }
    
    public Builder downloadDetailInfo(String paramString)
    {
      this.download_detail_info = paramString;
      return this;
    }
    
    public Builder nocacheCode(int paramInt)
    {
      this.nocache_code = paramInt;
      return this;
    }
    
    public Builder serverIp(String paramString)
    {
      this.server_ip = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageDownloadInfo
 * JD-Core Version:    0.7.0.1
 */