import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.QQSettingMeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DrawerCoverUtil;
import com.tencent.widget.UpSideDownDrawable;

public class zdm
  implements DrawerFrame.IDrawerCallbacks
{
  public zdm(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void a(int paramInt)
  {
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerStartMoving:: side = " + paramInt + " getActivity = " + this.a.getActivity() + " mDrawerBg= " + this.a.jdField_a_of_type_AndroidViewViewGroup);
    }
    if (this.a.getActivity() == null) {
      return;
    }
    if (this.a.jdField_a_of_type_AndroidViewViewGroup != null) {
      FrameHelperActivity.a(this.a, false);
    }
    DrawerFrame.IDrawerCallbacks[] arrayOfIDrawerCallbacks = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    int j = arrayOfIDrawerCallbacks.length;
    while (i < j)
    {
      DrawerFrame.IDrawerCallbacks localIDrawerCallbacks = arrayOfIDrawerCallbacks[i];
      if (localIDrawerCallbacks != null) {
        localIDrawerCallbacks.a(paramInt);
      }
      i += 1;
    }
    this.a.c(true);
  }
  
  @TargetApi(11)
  public void a(int paramInt, float paramFloat)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerMoving:: side = " + paramInt + " getActivity = " + this.a.getActivity());
    }
    if (this.a.getActivity() == null) {
      return;
    }
    if ((!this.a.getActivity().isFinishing()) && (FrameHelperActivity.a(this.a) != null) && (DrawerCoverUtil.a()))
    {
      localObject1 = FrameHelperActivity.a(this.a).a(DrawerCoverUtil.a);
      if (localObject1 != null) {
        ((UpSideDownDrawable)localObject1).c();
      }
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    Object localObject1 = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.a(paramInt, paramFloat);
      }
      i += 1;
    }
    this.a.c(true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerOpened:: side = " + paramInt1 + " getActivity = " + this.a.getActivity());
    }
    if (this.a.getActivity() == null) {}
    Object localObject1;
    label251:
    do
    {
      return;
      FrameHelperActivity.a(this.a, true);
      this.a.a(paramInt2, true, FrameHelperActivity.c(this.a));
      localObject1 = this.a.getActivity().app;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from DrawerOpened");
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(14);
      if ((!this.a.getActivity().isFinishing()) && (FrameHelperActivity.a(this.a) != null))
      {
        FrameHelperActivity.a(this.a).a();
        if (DrawerCoverUtil.a())
        {
          localObject1 = FrameHelperActivity.a(this.a).a(DrawerCoverUtil.a);
          if (localObject1 != null)
          {
            if (paramInt2 != 1) {
              break label251;
            }
            ((UpSideDownDrawable)localObject1).d();
          }
        }
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT < 11) {}
        localObject1 = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2 != null) {
            localObject2.a(paramInt1, paramInt2);
          }
          i += 1;
        }
        ((UpSideDownDrawable)localObject1).a();
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar != null) && (this.a.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.a())) {
        this.a.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.a(true);
      }
      this.a.c(true);
      localObject1 = this.a.b();
    } while (!(localObject1 instanceof ReadinjoyTabFrame));
    ((ReadinjoyTabFrame)localObject1).n();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerStartToggle:: side = " + paramInt + " open:" + paramBoolean + " getActivity = " + this.a.getActivity());
    }
    DrawerFrame.IDrawerCallbacks[] arrayOfIDrawerCallbacks = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    int j = arrayOfIDrawerCallbacks.length;
    int i = 0;
    while (i < j)
    {
      DrawerFrame.IDrawerCallbacks localIDrawerCallbacks = arrayOfIDrawerCallbacks[i];
      if (localIDrawerCallbacks != null) {
        localIDrawerCallbacks.a(paramInt, paramBoolean);
      }
      i += 1;
    }
    if (paramBoolean) {
      ThreadManager.post(new zdn(this), 5, null, true);
    }
    this.a.c(paramBoolean);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onDrawerClosed:: side = " + paramInt1 + " getActivity = " + this.a.getActivity());
    }
    if (this.a.getActivity() == null) {
      return;
    }
    FrameHelperActivity.a(this.a, false);
    this.a.a(paramInt2, false, FrameHelperActivity.c(this.a));
    if ((!this.a.getActivity().isFinishing()) && (FrameHelperActivity.a(this.a) != null))
    {
      FrameHelperActivity.a(this.a).b();
      if (DrawerCoverUtil.a())
      {
        localObject1 = FrameHelperActivity.a(this.a).a(DrawerCoverUtil.a);
        if (localObject1 != null) {
          ((UpSideDownDrawable)localObject1).b();
        }
      }
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
      }
    }
    if (this.a.jdField_a_of_type_AndroidViewViewGroup != null) {
      ((ImageView)this.a.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369232)).setImageResource(0);
    }
    Object localObject1 = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.b(paramInt1, paramInt2);
      }
      i += 1;
    }
    this.a.c(false);
    localObject1 = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject1 != null) {
      ((KandianMergeManager)((QQAppInterface)localObject1).getManager(161)).o();
    }
    if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(17)) {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(17);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(17, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zdm
 * JD-Core Version:    0.7.0.1
 */