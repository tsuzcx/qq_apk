import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.av.redpacket.ui.RedPacketRollTextView;
import com.tencent.mobileqq.portal.StrokeTextView;

public class itf
  implements ViewSwitcher.ViewFactory
{
  public itf(RedPacketRollTextView paramRedPacketRollTextView, boolean paramBoolean) {}
  
  public View makeView()
  {
    localStrokeTextView = new StrokeTextView(RedPacketRollTextView.a(this.this$0));
    try
    {
      localStrokeTextView.setLayoutParams(new FrameLayout.LayoutParams(wja.dp2px(42.0F, this.this$0.getResources()), -1));
      localStrokeTextView.setTextSize(0, RedPacketRollTextView.a(this.this$0));
      localStrokeTextView.setIncludeFontPadding(false);
      if (this.val$isRool) {}
      for (String str = "0";; str = "")
      {
        localStrokeTextView.setText(str);
        localStrokeTextView.setStrokeEnable(true);
        localStrokeTextView.setStrokeColor(-1);
        localStrokeTextView.setStrokeSize(wja.dp2px(6.0F, this.this$0.getResources()));
        localStrokeTextView.setInnerTextColor(-2094274);
        localStrokeTextView.setTypeface(Typeface.defaultFromStyle(1));
        localStrokeTextView.setGravity(17);
        return localStrokeTextView;
      }
      return localStrokeTextView;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itf
 * JD-Core Version:    0.7.0.1
 */