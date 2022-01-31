import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class wyq
  implements axes
{
  wyq(wyj paramwyj, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("TroopMemberApiService", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("TroopMemberApiService", ajya.a(2131715612) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(ajya.a(2131715582));
        axdu.a(1, paramInt2);
        this.jdField_a_of_type_Wyj.a.b = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("TroopMemberApiService", ajya.a(2131715573), null);
        ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList, new wyr(this));
        return;
      }
      VideoEnvironment.a("TroopMemberApiService", ajya.a(2131715574) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(ajya.a(2131715611));
      axdu.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("TroopMemberApiService", ajya.a(2131715662) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(ajya.a(2131715619));
    axdu.a(1, paramInt2);
    this.jdField_a_of_type_Wyj.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyq
 * JD-Core Version:    0.7.0.1
 */