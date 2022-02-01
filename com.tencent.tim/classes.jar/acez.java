import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.recent.DrawerFrame.a;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.7.1;
import com.tencent.mobileqq.app.FrameHelperActivity.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class acez
  implements DrawerFrame.a
{
  public acez(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void AD(int paramInt)
  {
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerStartMoving:: side = " + paramInt + " getActivity = " + this.this$0.getActivity() + " mDrawerBg= " + this.this$0.dU);
    }
    if (this.this$0.getActivity() == null) {
      return;
    }
    if (this.this$0.dU != null) {
      FrameHelperActivity.a(this.this$0, false);
    }
    DrawerFrame.a[] arrayOfa = this.this$0.a;
    int j = arrayOfa.length;
    while (i < j)
    {
      DrawerFrame.a locala = arrayOfa[i];
      if (locala != null) {
        locala.AD(paramInt);
      }
      i += 1;
    }
    this.this$0.EP(true);
  }
  
  public void aC(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerStartToggle:: side = " + paramInt + " open:" + paramBoolean + " getActivity = " + this.this$0.getActivity());
    }
    DrawerFrame.a[] arrayOfa = this.this$0.a;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      DrawerFrame.a locala = arrayOfa[i];
      if (locala != null) {
        locala.aC(paramInt, paramBoolean);
      }
      i += 1;
    }
    if (paramBoolean) {
      ThreadManager.post(new FrameHelperActivity.7.1(this), 5, null, true);
    }
    this.this$0.EP(paramBoolean);
  }
  
  public void eZ(int paramInt1, int paramInt2)
  {
    FrameHelperActivity.a(this.this$0, true);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerOpened:: side = " + paramInt1 + " getActivity = " + this.this$0.getActivity());
    }
    if (this.this$0.getActivity() == null) {
      return;
    }
    FrameHelperActivity.b(this.this$0, true);
    this.this$0.g(paramInt2, true, FrameHelperActivity.c(this.this$0));
    Object localObject1 = this.this$0.getActivity().app;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from DrawerOpened");
    }
    this.this$0.mUiHandler.sendEmptyMessage(14);
    if ((!this.this$0.getActivity().isFinishing()) && (FrameHelperActivity.a(this.this$0) != null))
    {
      FrameHelperActivity.a(this.this$0).onResume();
      if (aura.aJz())
      {
        localObject1 = FrameHelperActivity.a(this.this$0).a(aura.aRP);
        if (localObject1 != null)
        {
          if (paramInt2 != 1) {
            break label252;
          }
          ((auvn)localObject1).resume();
        }
      }
    }
    for (;;)
    {
      localObject1 = this.this$0.a;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.eZ(paramInt1, paramInt2);
        }
        i += 1;
      }
      label252:
      ((auvn)localObject1).start();
    }
    FrameHelperActivity.a(this.this$0);
    this.this$0.EP(true);
    lcc.a().onDrawerOpened();
    this.this$0.bRF();
  }
  
  public void fa(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerClosed:: side = " + paramInt1 + " getActivity = " + this.this$0.getActivity());
    }
    if (this.this$0.getActivity() == null) {
      return;
    }
    FrameHelperActivity.b(this.this$0, false);
    this.this$0.g(paramInt2, false, FrameHelperActivity.c(this.this$0));
    if ((!this.this$0.getActivity().isFinishing()) && (FrameHelperActivity.a(this.this$0) != null))
    {
      FrameHelperActivity.a(this.this$0).onPause();
      if (aura.aJz())
      {
        localObject1 = FrameHelperActivity.a(this.this$0).a(aura.aRP);
        if (localObject1 != null) {
          ((auvn)localObject1).stop();
        }
      }
    }
    if (this.this$0.dU != null) {
      ((ImageView)this.this$0.dU.findViewById(2131381291)).setImageResource(0);
    }
    Object localObject1 = this.this$0.a;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.fa(paramInt1, paramInt2);
      }
      i += 1;
    }
    this.this$0.EP(false);
    localObject1 = (QQAppInterface)kxm.getAppRuntime();
    if (localObject1 != null) {
      ((KandianMergeManager)((QQAppInterface)localObject1).getManager(162)).aIQ();
    }
    if (this.this$0.mUiHandler.hasMessages(17)) {
      this.this$0.mUiHandler.removeMessages(17);
    }
    this.this$0.mUiHandler.sendEmptyMessageDelayed(17, 100L);
  }
  
  @TargetApi(11)
  public void m(int paramInt, float paramFloat)
  {
    int i = 0;
    if ((QLog.isDevelopLevel()) && (FrameHelperActivity.a(this.this$0)))
    {
      FrameHelperActivity.a(this.this$0, false);
      QLog.i("Q.recent", 4, "onDrawerMoving:: side = " + paramInt + " getActivity = " + this.this$0.getActivity());
    }
    if (this.this$0.getActivity() == null) {
      return;
    }
    if ((!this.this$0.getActivity().isFinishing()) && (FrameHelperActivity.a(this.this$0) != null) && (aura.aJz()))
    {
      localObject1 = FrameHelperActivity.a(this.this$0).a(aura.aRP);
      if (localObject1 != null) {
        ((auvn)localObject1).pause();
      }
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    Object localObject1 = this.this$0.a;
    int j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.m(paramInt, paramFloat);
      }
      i += 1;
    }
    this.this$0.EP(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acez
 * JD-Core Version:    0.7.0.1
 */