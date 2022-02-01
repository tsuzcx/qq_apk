package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class QzoneMessageBoxRsp
  extends JceStruct
{
  static ArrayList<BottomContentItem> cache_bottomVec;
  static ArrayList<NewMQMsg> cache_vecNews = new ArrayList();
  public ArrayList<BottomContentItem> bottomVec;
  public boolean hasMore = true;
  public String more_url = "";
  public long qzone_level;
  public long registered_days;
  public String sTraceInfo = "";
  public ArrayList<NewMQMsg> vecNews;
  public long visitor_count;
  
  static
  {
    Object localObject = new NewMQMsg();
    cache_vecNews.add(localObject);
    cache_bottomVec = new ArrayList();
    localObject = new BottomContentItem();
    cache_bottomVec.add(localObject);
  }
  
  public QzoneMessageBoxRsp() {}
  
  public QzoneMessageBoxRsp(ArrayList<NewMQMsg> paramArrayList, String paramString1, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, String paramString2, ArrayList<BottomContentItem> paramArrayList1)
  {
    this.vecNews = paramArrayList;
    this.sTraceInfo = paramString1;
    this.hasMore = paramBoolean;
    this.registered_days = paramLong1;
    this.qzone_level = paramLong2;
    this.visitor_count = paramLong3;
    this.more_url = paramString2;
    this.bottomVec = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecNews = ((ArrayList)paramJceInputStream.read(cache_vecNews, 0, false));
    this.sTraceInfo = paramJceInputStream.readString(1, false);
    this.hasMore = paramJceInputStream.read(this.hasMore, 2, false);
    this.registered_days = paramJceInputStream.read(this.registered_days, 3, false);
    this.qzone_level = paramJceInputStream.read(this.qzone_level, 4, false);
    this.visitor_count = paramJceInputStream.read(this.visitor_count, 5, false);
    this.more_url = paramJceInputStream.readString(6, false);
    this.bottomVec = ((ArrayList)paramJceInputStream.read(cache_bottomVec, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecNews != null) {
      paramJceOutputStream.write(this.vecNews, 0);
    }
    if (this.sTraceInfo != null) {
      paramJceOutputStream.write(this.sTraceInfo, 1);
    }
    paramJceOutputStream.write(this.hasMore, 2);
    paramJceOutputStream.write(this.registered_days, 3);
    paramJceOutputStream.write(this.qzone_level, 4);
    paramJceOutputStream.write(this.visitor_count, 5);
    if (this.more_url != null) {
      paramJceOutputStream.write(this.more_url, 6);
    }
    if (this.bottomVec != null) {
      paramJceOutputStream.write(this.bottomVec, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.QzoneMessageBoxRsp
 * JD-Core Version:    0.7.0.1
 */