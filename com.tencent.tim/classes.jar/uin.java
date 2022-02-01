import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView.a;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

public class uin
  implements EmotionKeywordHorizonListView.a
{
  public uin(BaseChatPie paramBaseChatPie) {}
  
  public void Ao(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.this$0.uiHandler.removeMessages(67);
      anot.a(this.this$0.app, "CliOper", "", "", "ep_mall", "slide", 0, 0, "", "", "", this.this$0.a.getText().toString());
      return;
    }
    this.this$0.uiHandler.sendEmptyMessageDelayed(67, 6000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uin
 * JD-Core Version:    0.7.0.1
 */