import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class yry
  implements azeh
{
  yry(yrr paramyrr, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("TroopMemberApiService", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("TroopMemberApiService", alud.a(2131715996) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(alud.a(2131715966));
        azdh.a(1, paramInt2);
        this.jdField_a_of_type_Yrr.a.b = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("TroopMemberApiService", alud.a(2131715957), null);
        ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList, new yrz(this));
        return;
      }
      VideoEnvironment.a("TroopMemberApiService", alud.a(2131715958) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(alud.a(2131715995));
      azdh.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("TroopMemberApiService", alud.a(2131716046) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(alud.a(2131716003));
    azdh.a(1, paramInt2);
    this.jdField_a_of_type_Yrr.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yry
 * JD-Core Version:    0.7.0.1
 */