import com.tencent.ad.tangram.analysis.AdAnalysisAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class yry
  implements AdAnalysisAdapter
{
  public String getAppVersion()
  {
    return yxs.a();
  }
  
  public String getUIN()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
    } while (localObject == null);
    return ((AppRuntime)localObject).getAccount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yry
 * JD-Core Version:    0.7.0.1
 */