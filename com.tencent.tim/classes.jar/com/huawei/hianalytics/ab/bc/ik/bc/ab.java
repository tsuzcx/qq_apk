package com.huawei.hianalytics.ab.bc.ik.bc;

import com.huawei.hianalytics.ab.bc.fg.cd;
import java.util.List;
import java.util.Map;

public class ab
  implements com.huawei.hianalytics.ab.bc.ik.cd.ab
{
  private byte[] ab;
  private String bc;
  private String cd;
  private String de;
  private String ef;
  private List<com.huawei.hianalytics.ab.bc.cd.bc.de> fg;
  
  public ab(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, String paramString4, List<com.huawei.hianalytics.ab.bc.cd.bc.de> paramList)
  {
    this.ab = ((byte[])paramArrayOfByte.clone());
    this.bc = paramString1;
    this.cd = paramString2;
    this.ef = paramString3;
    this.de = paramString4;
    this.fg = paramList;
  }
  
  private cd ab(Map<String, String> paramMap)
  {
    return com.huawei.hianalytics.ab.bc.fg.bc.ab(this.bc, this.ab, paramMap);
  }
  
  private Map<String, String> ab()
  {
    return com.huawei.hianalytics.ab.de.ab.cd(this.cd, this.ef, this.de);
  }
  
  private void bc()
  {
    de localde = new de(this.fg, this.cd, this.de, this.ef);
    com.huawei.hianalytics.ab.bc.ik.cd.bc.ab().ab(localde);
  }
  
  public void run()
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("DataSendTask", "send data running");
    int i = ab(ab()).ab();
    if (i != 200)
    {
      bc();
      return;
    }
    com.huawei.hianalytics.ab.bc.ef.ab.ab("DataSendTask", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.de, new Object[] { this.ef, this.cd, Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ik.bc.ab
 * JD-Core Version:    0.7.0.1
 */