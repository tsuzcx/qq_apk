import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.story.mode.StoryEffectTextMode.6.1;
import mqq.os.MqqHandler;

public class aycw
  implements jox
{
  aycw(aycm paramaycm) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (paramString == null) && (aycm.a(this.this$0, aycm.a(this.this$0).bka))) {
      ThreadManager.getUIHandler().post(new StoryEffectTextMode.6.1(this));
    }
    QLog.i("StoryEffectTextModeQ.qqstory.text_filter", 2, "HtmlOffline.checkUpByBusinessId QG_SO_BID, loaded:code =" + paramInt);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycw
 * JD-Core Version:    0.7.0.1
 */