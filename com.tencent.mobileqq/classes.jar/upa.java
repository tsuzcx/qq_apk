import UserGrowth.stReportItem;
import UserGrowth.stWeishiReportReq;
import UserGrowth.stWeishiReportRsp;
import java.util.ArrayList;

public class upa
  extends ukl<stWeishiReportRsp>
{
  public upa(ArrayList<stReportItem> paramArrayList)
  {
    super("WeishiReport");
    this.a = new stWeishiReportReq(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upa
 * JD-Core Version:    0.7.0.1
 */