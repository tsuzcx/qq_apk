package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqGetPluginSettings
  extends JceStruct
{
  static ArrayList<Long> cache_PluginList;
  public ArrayList<Long> PluginList;
  
  public ReqGetPluginSettings() {}
  
  public ReqGetPluginSettings(ArrayList<Long> paramArrayList)
  {
    this.PluginList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_PluginList == null)
    {
      cache_PluginList = new ArrayList();
      cache_PluginList.add(Long.valueOf(0L));
    }
    this.PluginList = ((ArrayList)paramJceInputStream.read(cache_PluginList, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.PluginList, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     KQQ.ReqGetPluginSettings
 * JD-Core Version:    0.7.0.1
 */