import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.AIOTransferFileSearchActivity;
import com.tencent.mobileqq.search.activity.AddFilesSearchActivity;
import com.tencent.mobileqq.search.activity.CloudFileGroupSearchActivity;
import com.tencent.mobileqq.search.activity.CloudRecentFileSearchActivity;
import com.tencent.mobileqq.search.activity.OnlineFilesSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;

public class aaja
  implements DialogInterface.OnDismissListener, View.OnClickListener, Animation.AnimationListener
{
  private TextView Co;
  private long LW;
  private View ae;
  private BaseActivity c;
  byte[] cA;
  private int chg = 4;
  private int chh = 1;
  private long dk = 0L;
  private long iu = 0L;
  private View mRootView;
  private View nj;
  private View zy;
  
  public aaja(ListView paramListView, View paramView1, View paramView2, BaseActivity paramBaseActivity, View paramView3, int paramInt)
  {
    Object localObject = null;
    this.chh = paramInt;
    if (paramView3 != null) {
      localObject = paramView3;
    }
    if (localObject == null) {}
    for (paramView3 = paramBaseActivity.getLayoutInflater().inflate(2131563209, paramListView, false);; paramView3 = (View)localObject)
    {
      paramView3.findViewById(2131363801).setVisibility(8);
      localObject = new LinearLayout(paramBaseActivity);
      ((LinearLayout)localObject).setOrientation(1);
      ((LinearLayout)localObject).addView(paramView3);
      paramListView.addHeaderView((View)localObject);
      IphoneTitleBarActivity.setLayerType(paramView3);
      this.c = paramBaseActivity;
      this.zy = paramBaseActivity.findViewById(2131365363);
      this.mRootView = paramView1;
      this.nj = paramView2;
      paramListView = (EditText)paramView3.findViewById(2131366542);
      paramListView.setFocusableInTouchMode(false);
      paramListView.setCursorVisible(false);
      paramListView.setOnClickListener(this);
      this.Co = ((TextView)paramView3.findViewById(2131380917));
      this.ae = paramView3;
      return;
    }
  }
  
  public aaja(ListView paramListView, View paramView1, View paramView2, BaseActivity paramBaseActivity, View paramView3, int paramInt, byte[] paramArrayOfByte)
  {
    this(paramListView, paramView1, paramView2, paramBaseActivity, paramView3, paramInt);
    this.cA = paramArrayOfByte;
  }
  
  private void gX()
  {
    this.LW = System.currentTimeMillis();
    if ((this.chh == 27) || (this.chh == 49))
    {
      if (this.chh == 49) {
        this.chh = 27;
      }
      CloudFileGroupSearchActivity.p(this.c, null, this.chh);
      return;
    }
    if (this.chh == 31)
    {
      AIOTransferFileSearchActivity.a(this.c, null, null, this.chh);
      return;
    }
    if (this.chh == 34)
    {
      AddFilesSearchActivity.a(this.c, null, null, this.chh, this.cA);
      return;
    }
    if (this.chh == 35)
    {
      OnlineFilesSearchActivity.a(this.c, null, null, this.chh);
      return;
    }
    if (this.chh == 43)
    {
      AddFilesSearchActivity.a(this.c, null, null, this.chh, this.cA);
      return;
    }
    if (this.chh == 50)
    {
      CloudRecentFileSearchActivity.a(this.c, null, null, this.chh);
      return;
    }
    UniteSearchActivity.p(this.c, null, this.chh);
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onClick() time stamp = " + (l - this.iu));
    }
    if (l - this.iu > 1500L)
    {
      this.iu = l;
      gX();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestory()
  {
    obg.a().bdc();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onPause() {}
  
  public void setShow(boolean paramBoolean)
  {
    if (this.ae == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while (this.ae.getVisibility() == 0);
      this.ae.setVisibility(0);
      return;
    } while (this.ae.getVisibility() == 8);
    this.ae.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaja
 * JD-Core Version:    0.7.0.1
 */