import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class wyu
  implements axeo
{
  wyu(wyt paramwyt) {}
  
  public void G_()
  {
    this.a.jdField_a_of_type_Wym.a.b = false;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label152;
      }
      VideoEnvironment.a("TroopMemberApiService", ajyc.a(2131715553) + paramInt + "]", null);
      ShortVideoResourceManager.a(ajyc.a(2131715607));
      axds.a(2, paramInt);
      this.a.jdField_a_of_type_AndroidOsBundle.putInt("result", 0);
    }
    for (;;)
    {
      VideoEnvironment.a("TroopMemberApiService", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      this.a.jdField_a_of_type_Wym.a.a(93, this.a.jdField_a_of_type_AndroidOsBundle);
      this.a.jdField_a_of_type_Wym.a.b = false;
      return;
      label152:
      this.a.jdField_a_of_type_AndroidOsBundle.putInt("result", -2);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyu
 * JD-Core Version:    0.7.0.1
 */