package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class StatReportRequest
  extends JceStruct
{
  static ArrayList<StatItem> cache_data = new ArrayList();
  public ArrayList<StatItem> data = null;
  
  static
  {
    StatItem localStatItem = new StatItem();
    cache_data.add(localStatItem);
  }
  
  public StatReportRequest() {}
  
  public StatReportRequest(ArrayList<StatItem> paramArrayList)
  {
    this.data = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.data = ((ArrayList)paramJceInputStream.read(cache_data, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.data, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.StatReportRequest
 * JD-Core Version:    0.7.0.1
 */