package com.tencent.mm.sdk.platformtools;

public class PhoneUtil$CellInfo
{
  public static final int MAX_CID = 65535;
  public static final int MAX_LAC = 65535;
  public String cellid;
  public String dbm;
  public String lac;
  public String mcc;
  public String mnc;
  public String networkId;
  public String stationId;
  public String systemId;
  public String type;
  
  public PhoneUtil$CellInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.mcc = paramString1;
    this.mnc = paramString2;
    this.lac = paramString3;
    this.type = paramString6;
    this.cellid = paramString4;
    this.stationId = paramString7;
    this.networkId = paramString8;
    this.systemId = paramString9;
    this.dbm = paramString5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneUtil.CellInfo
 * JD-Core Version:    0.7.0.1
 */