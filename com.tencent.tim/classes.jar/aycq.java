import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.story.mode.StoryEffectTextMode.13.1;
import dov.com.qq.im.story.mode.StoryEffectTextMode.13.2;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aycq
  implements jox
{
  aycq(aycm paramaycm, boolean paramBoolean, prt.c paramc, String paramString) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StoryEffectTextMode", 2, "checkUpByBusinessId loaded code = " + paramInt);
    }
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    default: 
      ThreadManager.getUIHandler().post(new StoryEffectTextMode.13.2(this, paramInt));
    case 7: 
      return;
    case 0: 
      if (paramString != null)
      {
        ram.d("StoryEffectTextMode", "离线包协议拉取成功");
        try
        {
          paramString = new JSONObject(paramString).optJSONArray("data");
          if ((paramString != null) && (paramString.length() > 0))
          {
            ram.d("StoryEffectTextMode", "文字模板有更新");
            return;
          }
        }
        catch (JSONException paramString)
        {
          ram.e("StoryEffectTextMode", "parseExpire: " + QLog.getStackTraceString(paramString));
        }
      }
      break;
    }
    ThreadManager.getUIHandler().post(new StoryEffectTextMode.13.1(this));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycq
 * JD-Core Version:    0.7.0.1
 */