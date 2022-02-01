import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class zpm
  implements bbri
{
  zpm(zpf paramzpf, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("TroopMemberApiService", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.LogDownLoad("TroopMemberApiService", amtj.a(2131714618) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(amtj.a(2131714588));
        bbqi.a(1, paramInt2);
        this.jdField_a_of_type_Zpf.a.b = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.LogDownLoad("TroopMemberApiService", amtj.a(2131714579), null);
        ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList, new zpn(this));
        return;
      }
      VideoEnvironment.LogDownLoad("TroopMemberApiService", amtj.a(2131714580) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(amtj.a(2131714617));
      bbqi.a(1, paramInt1);
      return;
    }
    VideoEnvironment.LogDownLoad("TroopMemberApiService", amtj.a(2131714668) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(amtj.a(2131714625));
    bbqi.a(1, paramInt2);
    this.jdField_a_of_type_Zpf.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpm
 * JD-Core Version:    0.7.0.1
 */