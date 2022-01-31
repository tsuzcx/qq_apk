import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class ynj
  implements ayzy
{
  ynj(ync paramync, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("TroopMemberApiService", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("TroopMemberApiService", alpo.a(2131715984) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(alpo.a(2131715954));
        ayyy.a(1, paramInt2);
        this.jdField_a_of_type_Ync.a.b = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("TroopMemberApiService", alpo.a(2131715945), null);
        ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList, new ynk(this));
        return;
      }
      VideoEnvironment.a("TroopMemberApiService", alpo.a(2131715946) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(alpo.a(2131715983));
      ayyy.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("TroopMemberApiService", alpo.a(2131716034) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(alpo.a(2131715991));
    ayyy.a(1, paramInt2);
    this.jdField_a_of_type_Ync.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ynj
 * JD-Core Version:    0.7.0.1
 */