package cooperation.qzone.contentbox;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class UserListItemView
  extends FrameLayout
{
  private ImageView Gf;
  private Context mContext;
  private Handler mUiHandler;
  private RelativeLayout nL;
  
  public UserListItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    init(paramContext, paramInt);
  }
  
  private void init(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mUiHandler = new Handler(Looper.getMainLooper());
    if (paramInt == 0) {
      LayoutInflater.from(paramContext).inflate(2131562604, this);
    }
    for (;;)
    {
      this.Gf = ((ImageView)findViewById(2131363195));
      this.nL = ((RelativeLayout)findViewById(2131363192));
      return;
      LayoutInflater.from(paramContext).inflate(2131562605, this);
    }
  }
  
  public void setUin(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new UserListItemView.1(this, paramString));
  }
  
  public void vb(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.nL.setVisibility(0);
      return;
    }
    this.nL.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.UserListItemView
 * JD-Core Version:    0.7.0.1
 */