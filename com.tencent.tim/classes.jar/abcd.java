import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.a;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.util.HashMap;
import java.util.List;

class abcd
  implements QvipSpecialSoundManager.a
{
  abcd(abcb paramabcb, String paramString) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject = "key_special_sound_list" + this.a.mRuntime.a().getCurrentAccountUin();
      localObject = (List)QvipSpecialSoundManager.ib.get(localObject);
      abcb.a(this.a, this.bfl, (List)localObject);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      try
      {
        abcb.a(this.a, this.bfl, null);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    abcb.a(this.a, this.bfl, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcd
 * JD-Core Version:    0.7.0.1
 */