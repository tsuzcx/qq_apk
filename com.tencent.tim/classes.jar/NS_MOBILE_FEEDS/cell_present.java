package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_present
  extends JceStruct
{
  static ArrayList<s_presentman> cache_presentmans = new ArrayList();
  public long num;
  public ArrayList<s_presentman> presentmans;
  
  static
  {
    s_presentman locals_presentman = new s_presentman();
    cache_presentmans.add(locals_presentman);
  }
  
  public cell_present() {}
  
  public cell_present(long paramLong, ArrayList<s_presentman> paramArrayList)
  {
    this.num = paramLong;
    this.presentmans = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.presentmans = ((ArrayList)paramJceInputStream.read(cache_presentmans, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    if (this.presentmans != null) {
      paramJceOutputStream.write(this.presentmans, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_present
 * JD-Core Version:    0.7.0.1
 */