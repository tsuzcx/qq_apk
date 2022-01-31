import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class wjr
  implements awfi
{
  wjr(wjk paramwjk, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("TroopMemberApiService", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("TroopMemberApiService", ajjy.a(2131649810) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(ajjy.a(2131649780));
        awek.a(1, paramInt2);
        this.jdField_a_of_type_Wjk.a.b = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("TroopMemberApiService", ajjy.a(2131649771), null);
        ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList, new wjs(this));
        return;
      }
      VideoEnvironment.a("TroopMemberApiService", ajjy.a(2131649772) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(ajjy.a(2131649809));
      awek.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("TroopMemberApiService", ajjy.a(2131649860) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(ajjy.a(2131649817));
    awek.a(1, paramInt2);
    this.jdField_a_of_type_Wjk.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wjr
 * JD-Core Version:    0.7.0.1
 */