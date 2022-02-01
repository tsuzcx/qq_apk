package com.tencent.android.tpush.data;

import java.io.Serializable;

public class UnregisterInfo
  implements Serializable
{
  public static final byte TYPE_UNINSTALL = 1;
  public static final byte TYPE_UNREGISTER = 0;
  private static final long serialVersionUID = -2293449011577410421L;
  public long accessId;
  public String accessKey;
  public String appCert;
  public byte isUninstall;
  public String option;
  public String packName;
  public long timestamp;
  public String token;
  
  public UnregisterInfo() {}
  
  public UnregisterInfo(int paramInt, String paramString1, String paramString2, byte paramByte, String paramString3)
  {
    this.accessId = paramInt;
    this.accessKey = paramString1;
    this.token = paramString2;
    this.isUninstall = paramByte;
    this.packName = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------------UnregisterInfo----------------\n").append("accessId=").append(this.accessId).append("\n").append("accesskey=").append(this.accessKey).append("\n").append("token=").append(this.token).append("\n").append("isUninstall=").append(this.isUninstall).append("\n").append("packName=").append(this.packName).append("\n").append("--------------UnregisterInfo End------------");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.data.UnregisterInfo
 * JD-Core Version:    0.7.0.1
 */