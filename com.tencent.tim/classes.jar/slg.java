import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.biz.troop.TroopMemberApiService.a;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class slg
  implements ShortVideoResourceManager.c
{
  slg(slf paramslf) {}
  
  public void aFW()
  {
    this.a.a.d.aLU = false;
  }
  
  public void f(String paramString, long paramLong1, long paramLong2) {}
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label152;
      }
      VideoEnvironment.k("TroopMemberApiService", acfp.m(2131715911) + paramInt + "]", null);
      ShortVideoResourceManager.Qu(acfp.m(2131715965));
      anfv.jw(2, paramInt);
      this.a.val$data.putInt("result", 0);
    }
    for (;;)
    {
      VideoEnvironment.k("TroopMemberApiService", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      this.a.a.d.j(93, this.a.val$data);
      this.a.a.d.aLU = false;
      return;
      label152:
      this.a.val$data.putInt("result", -2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slg
 * JD-Core Version:    0.7.0.1
 */