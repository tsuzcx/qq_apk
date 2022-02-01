import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class zpn
  implements bbrg
{
  zpn(zpm paramzpm) {}
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label152;
      }
      VideoEnvironment.LogDownLoad("TroopMemberApiService", amtj.a(2131714570) + paramInt + "]", null);
      ShortVideoResourceManager.a(amtj.a(2131714624));
      bbqi.a(2, paramInt);
      this.a.jdField_a_of_type_AndroidOsBundle.putInt("result", 0);
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("TroopMemberApiService", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      this.a.jdField_a_of_type_Zpf.a.a(93, this.a.jdField_a_of_type_AndroidOsBundle);
      this.a.jdField_a_of_type_Zpf.a.b = false;
      return;
      label152:
      this.a.jdField_a_of_type_AndroidOsBundle.putInt("result", -2);
    }
  }
  
  public void onNetWorkNone()
  {
    this.a.jdField_a_of_type_Zpf.a.b = false;
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpn
 * JD-Core Version:    0.7.0.1
 */