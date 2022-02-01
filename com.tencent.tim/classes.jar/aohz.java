import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import java.util.ArrayList;

class aohz
  implements awms
{
  aohz(aohy paramaohy) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    QLog.d("TogetherControlManager", 2, new Object[] { "ongetAdvs result:", Boolean.valueOf(paramBoolean), " rsp:", paramGetAdsRsp.toString() });
    if (paramBoolean)
    {
      paramGetAdsRsp = aohy.b.a(paramBoolean, paramGetAdsRsp);
      if (paramGetAdsRsp != null)
      {
        this.a.Bi.add(paramGetAdsRsp);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable.getDrawable(paramGetAdsRsp.pic, localURLDrawableOptions).startDownload();
      }
    }
    else
    {
      return;
    }
    QLog.d("TogetherControlManager", 2, "ongetAdvs banner is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aohz
 * JD-Core Version:    0.7.0.1
 */