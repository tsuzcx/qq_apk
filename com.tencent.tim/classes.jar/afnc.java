import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.5.1;
import mqq.os.MqqHandler;

public class afnc
  extends aceg
{
  afnc(afna paramafna) {}
  
  protected void ag(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.this$0.dak();
    }
    if ((paramObject != null) && ((paramObject instanceof Integer))) {
      ThreadManager.getUIHandler().post(new EmoticonPanelFavHelper.5.1(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnc
 * JD-Core Version:    0.7.0.1
 */