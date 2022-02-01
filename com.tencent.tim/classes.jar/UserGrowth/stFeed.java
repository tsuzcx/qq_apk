package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stFeed
  extends JceStruct
{
  static stSimpleMetaFeed cache_feed = new stSimpleMetaFeed();
  static ArrayList<stSimpleMetaPerson> cache_person_meta = new ArrayList();
  public stSimpleMetaFeed feed;
  public int feed_type;
  public ArrayList<stSimpleMetaPerson> person_meta;
  
  static
  {
    stSimpleMetaPerson localstSimpleMetaPerson = new stSimpleMetaPerson();
    cache_person_meta.add(localstSimpleMetaPerson);
  }
  
  public stFeed() {}
  
  public stFeed(stSimpleMetaFeed paramstSimpleMetaFeed, ArrayList<stSimpleMetaPerson> paramArrayList, int paramInt)
  {
    this.feed = paramstSimpleMetaFeed;
    this.person_meta = paramArrayList;
    this.feed_type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed = ((stSimpleMetaFeed)paramJceInputStream.read(cache_feed, 0, false));
    this.person_meta = ((ArrayList)paramJceInputStream.read(cache_person_meta, 1, false));
    this.feed_type = paramJceInputStream.read(this.feed_type, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.feed != null) {
      paramJceOutputStream.write(this.feed, 0);
    }
    if (this.person_meta != null) {
      paramJceOutputStream.write(this.person_meta, 1);
    }
    paramJceOutputStream.write(this.feed_type, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stFeed
 * JD-Core Version:    0.7.0.1
 */