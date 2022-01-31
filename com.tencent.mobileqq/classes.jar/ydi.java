import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class ydi
  implements MediaPlayer.OnCompletionListener
{
  public ydi(VipSpecialSoundWebViewPlugin paramVipSpecialSoundWebViewPlugin, String paramString1, String paramString2) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    int i = VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin).a(this.jdField_a_of_type_JavaLangString);
    VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->media:" + this.jdField_a_of_type_JavaLangString + " play completed, soundId:" + i);
    try
    {
      paramMediaPlayer = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", i);
      paramMediaPlayer.put("code", 0);
      paramMediaPlayer.put("data", localJSONObject);
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin.callJs(this.b, new String[] { paramMediaPlayer.toString() });
      return;
    }
    catch (JSONException paramMediaPlayer)
    {
      VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->json exception:" + paramMediaPlayer.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ydi
 * JD-Core Version:    0.7.0.1
 */