package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class count_info
  extends JceStruct
{
  static single_count cache_stCount;
  static ArrayList cache_vecUinList;
  public single_count stCount = null;
  public ArrayList vecUinList = null;
  
  public count_info() {}
  
  public count_info(single_count paramsingle_count, ArrayList paramArrayList)
  {
    this.stCount = paramsingle_count;
    this.vecUinList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stCount == null) {
      cache_stCount = new single_count();
    }
    this.stCount = ((single_count)paramJceInputStream.read(cache_stCount, 0, false));
    if (cache_vecUinList == null)
    {
      cache_vecUinList = new ArrayList();
      feed_host_info localfeed_host_info = new feed_host_info();
      cache_vecUinList.add(localfeed_host_info);
    }
    this.vecUinList = ((ArrayList)paramJceInputStream.read(cache_vecUinList, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stCount != null) {
      paramJceOutputStream.write(this.stCount, 0);
    }
    if (this.vecUinList != null) {
      paramJceOutputStream.write(this.vecUinList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.count_info
 * JD-Core Version:    0.7.0.1
 */