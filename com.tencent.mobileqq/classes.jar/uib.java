import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.List;

public class uib
  implements BusinessObserver
{
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, List<MaterialData> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, (String)paramObject);
      return;
    }
    a(paramBoolean, (List)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uib
 * JD-Core Version:    0.7.0.1
 */