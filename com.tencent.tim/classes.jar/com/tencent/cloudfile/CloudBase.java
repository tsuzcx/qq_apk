package com.tencent.cloudfile;

public abstract class CloudBase
{
  private String cachedDirString;
  private String cachedIdString;
  public byte[] cloudId;
  public long createTime;
  public long modifyTime;
  public byte[] pDirKey;
  public byte[] pLogicDirKey;
  public String showName;
  public long sortSeq;
  public long sortTime;
  public int storeType;
  public int type;
  
  public String getDirKeyString()
  {
    if (this.cachedDirString == null) {
      this.cachedDirString = new String(this.pLogicDirKey);
    }
    return this.cachedDirString;
  }
  
  public String getIdString()
  {
    if (this.cachedIdString == null) {
      this.cachedIdString = new String(this.cloudId);
    }
    return this.cachedIdString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.cloudfile.CloudBase
 * JD-Core Version:    0.7.0.1
 */