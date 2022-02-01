import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;

public class zno
  implements IMiniMsgUnreadCallback
{
  private TextView LJ;
  private View mContentView;
  
  public zno(View paramView, TextView paramTextView)
  {
    this.mContentView = paramView;
    this.LJ = paramTextView;
  }
  
  public void destroy()
  {
    this.mContentView = null;
    this.LJ = null;
  }
  
  public void hide()
  {
    this.mContentView.setVisibility(4);
  }
  
  public void hideUnread()
  {
    this.LJ.setVisibility(8);
  }
  
  public boolean show(int paramInt)
  {
    this.mContentView.setVisibility(0);
    updateUnreadCount(paramInt, false);
    return true;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle) {}
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    TextView localTextView = this.LJ;
    String str = String.valueOf(paramInt);
    if (paramInt > 99) {
      str = "99+";
    }
    localTextView.setText(str);
    if (!paramBoolean)
    {
      if (paramInt <= 0) {
        localTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    localTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zno
 * JD-Core Version:    0.7.0.1
 */