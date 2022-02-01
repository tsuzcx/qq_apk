package cooperation.qqreader.host.miniaio;

import android.content.ContextWrapper;
import avod;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;

public class MiniMsgUserWrapper
{
  private MiniMsgUser mMiniMsgUser;
  
  public MiniMsgUserWrapper(ContextWrapper paramContextWrapper, MiniMsgUserParamWrapper paramMiniMsgUserParamWrapper)
  {
    paramContextWrapper = avod.getActivity(paramContextWrapper);
    if (paramContextWrapper != null) {
      this.mMiniMsgUser = new MiniMsgUser(paramContextWrapper, paramMiniMsgUserParamWrapper.mParam);
    }
  }
  
  public void destroy()
  {
    if (this.mMiniMsgUser != null) {
      this.mMiniMsgUser.destroy();
    }
  }
  
  public void onBackground()
  {
    if (this.mMiniMsgUser != null) {
      this.mMiniMsgUser.onBackground();
    }
  }
  
  public void onForeground()
  {
    if (this.mMiniMsgUser != null) {
      this.mMiniMsgUser.onForeground();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.miniaio.MiniMsgUserWrapper
 * JD-Core Version:    0.7.0.1
 */