import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class yrz
  implements azef
{
  yrz(yry paramyry) {}
  
  public void G_()
  {
    this.a.jdField_a_of_type_Yrr.a.b = false;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label152;
      }
      VideoEnvironment.a("TroopMemberApiService", alud.a(2131715948) + paramInt + "]", null);
      ShortVideoResourceManager.a(alud.a(2131716002));
      azdh.a(2, paramInt);
      this.a.jdField_a_of_type_AndroidOsBundle.putInt("result", 0);
    }
    for (;;)
    {
      VideoEnvironment.a("TroopMemberApiService", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      this.a.jdField_a_of_type_Yrr.a.a(93, this.a.jdField_a_of_type_AndroidOsBundle);
      this.a.jdField_a_of_type_Yrr.a.b = false;
      return;
      label152:
      this.a.jdField_a_of_type_AndroidOsBundle.putInt("result", -2);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yrz
 * JD-Core Version:    0.7.0.1
 */