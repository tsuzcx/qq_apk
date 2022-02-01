import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout.a;
import com.tencent.qphone.base.util.QLog;

public abstract class wol
  implements wop
{
  private FriendShipLayout.a jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout$a = new wom(this);
  private FriendShipLayout jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout;
  private Context mContext;
  private WindowManager mWindowManager;
  
  public wol(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseDirector", 2, "BaseDirector init");
    }
    this.mContext = paramContext;
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  @Nullable
  public static wop a(@IntRange(from=0L, to=3L) int paramInt, Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseDirector", 2, "makeDirector type = " + paramInt);
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return new woa(paramActivity);
    case 2: 
      return new woc(paramActivity);
    }
    return new wog(paramActivity);
  }
  
  public FriendShipLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout;
  }
  
  public void a(wop.a parama) {}
  
  public void cancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseDirector", 2, "BaseDirector cancel");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout.removeAllViews();
    }
    try
    {
      this.mWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        QLog.e("BaseDirector", 1, "cancel anim error");
      }
    }
  }
  
  public Context m()
  {
    return this.mContext;
  }
  
  public void play()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseDirector", 2, "BaseDirector play");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout = new FriendShipLayout(this.mContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout.setBackListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout$a);
      if (Build.VERSION.SDK_INT < 19) {
        break label101;
      }
    }
    label101:
    for (int i = 67109888;; i = 1024)
    {
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1, 2, i, -2);
      new FrameLayout.LayoutParams(-1, -1).gravity = 51;
      this.mWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout, localLayoutParams);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipLayout.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wol
 * JD-Core Version:    0.7.0.1
 */