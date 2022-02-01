import UserGrowth.stReportItem;
import UserGrowth.stWeishiReportReq;
import UserGrowth.stWeishiReportRsp;
import java.util.ArrayList;

public class oob
  extends okw<stWeishiReportRsp>
{
  public oob(ArrayList<stReportItem> paramArrayList)
  {
    super("WeishiReport");
    this.req = new stWeishiReportReq(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oob
 * JD-Core Version:    0.7.0.1
 */