import com.tencent.biz.qcircleshadow.lib.delegate.IDaTongReportDelegate;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;

public class vgh
  implements IDaTongReportDelegate
{
  public void setPageId(Object paramObject, String paramString)
  {
    VideoReport.setPageId(paramObject, paramString);
  }
  
  public void setPageParams(Object paramObject, Map<String, Object> paramMap)
  {
    VideoReport.setPageParams(paramObject, new PageParams(paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgh
 * JD-Core Version:    0.7.0.1
 */