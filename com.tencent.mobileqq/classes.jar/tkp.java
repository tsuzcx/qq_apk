import UserGrowth.stReportItem;
import UserGrowth.stWeishiReportReq;
import UserGrowth.stWeishiReportRsp;
import java.util.ArrayList;

public class tkp
  extends thb<stWeishiReportRsp>
{
  public tkp(ArrayList<stReportItem> paramArrayList)
  {
    super("WeishiReport");
    this.a = new stWeishiReportReq(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tkp
 * JD-Core Version:    0.7.0.1
 */