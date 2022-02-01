import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class slf
  implements angp.a
{
  public slf(TroopMemberApiService.a parama, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k("TroopMemberApiService", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.k("TroopMemberApiService", acfp.m(2131715959) + paramInt2 + "]", null);
        ShortVideoResourceManager.Qu(acfp.m(2131715929));
        anfv.jw(1, paramInt2);
        this.a.d.aLU = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.val$app, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.k("TroopMemberApiService", acfp.m(2131715920), null);
        ShortVideoResourceManager.a((QQAppInterface)this.val$app, localArrayList, new slg(this));
        return;
      }
      VideoEnvironment.k("TroopMemberApiService", acfp.m(2131715921) + paramInt1 + "]", null);
      ShortVideoResourceManager.Qu(acfp.m(2131715958));
      anfv.jw(1, paramInt1);
      return;
    }
    VideoEnvironment.k("TroopMemberApiService", acfp.m(2131716009) + paramInt2 + "]", null);
    ShortVideoResourceManager.Qu(acfp.m(2131715966));
    anfv.jw(1, paramInt2);
    this.a.d.aLU = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slf
 * JD-Core Version:    0.7.0.1
 */