package cooperation.hce;

import aczc.b;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

final class HceDataProxy$1
  extends aczc.b
{
  HceDataProxy$1(String paramString, HceDataProxy.GetLocationListener paramGetLocationListener)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.val$li.onLocationFinish(paramInt, paramSosoLbsInfo.a.city, paramSosoLbsInfo.a.cityCode);
      return;
    }
    this.val$li.onLocationFinish(-1, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.hce.HceDataProxy.1
 * JD-Core Version:    0.7.0.1
 */