import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.ViolaCommentManager.1;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.ViolaCommentManager.5;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ubq
{
  private int jdField_a_of_type_Int;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  @Nullable
  private VVideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
  private TKDCommentDispatcher.HippyCommentEvent jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent = new ubw(this);
  private ubx jdField_a_of_type_Ubx;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  @Nullable
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup.LayoutParams jdField_b_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int[] c;
  
  public ubq(FragmentActivity paramFragmentActivity, FragmentManager paramFragmentManager, int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = paramFragmentManager;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramFragmentActivity);
    this.jdField_a_of_type_AndroidViewView = new View(paramFragmentActivity);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, -1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(paramFragmentActivity);
    this.jdField_a_of_type_AndroidViewViewGroup.setId(2131364968);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, -2, -2);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).gravity = 80;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    if (paramViewGroup != null) {
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -1, -1);
    }
    for (;;)
    {
      a();
      return;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new WindowManager.LayoutParams(-1, -1));
    }
  }
  
  private void a(VVideoView paramVVideoView, View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    b(paramVVideoView, paramView);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.addView(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_AndroidViewViewGroup$LayoutParams);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_b_of_type_AndroidViewViewGroup$LayoutParams = null;
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_b_of_type_ArrayOfInt = null;
  }
  
  private void a(VVideoView paramVVideoView, View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = paramVVideoView;
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(paramInt));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    six.a(this.jdField_a_of_type_AndroidViewView, 0, 300);
    six.a(this.jdField_a_of_type_AndroidViewViewGroup, 0, 300);
    if (paramView != null)
    {
      this.jdField_b_of_type_AndroidViewView = paramView;
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.getParent());
      this.jdField_a_of_type_Int = this.jdField_b_of_type_AndroidViewViewGroup.indexOfChild(paramView);
      this.jdField_b_of_type_AndroidViewViewGroup$LayoutParams = paramView.getLayoutParams();
      this.jdField_a_of_type_ArrayOfInt = new int[2];
      paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_ArrayOfInt[1] -= this.jdField_b_of_type_Int;
      this.jdField_b_of_type_ArrayOfInt = new int[] { paramView.getWidth(), paramView.getHeight() };
      b(paramVVideoView, paramView);
      paramInt = six.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[0];
      i = (int)(paramView.getHeight() / paramView.getWidth() * paramInt);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, 1, new FrameLayout.LayoutParams(-1, i));
      six.a(paramView, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, new int[] { 0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity) }, new int[] { paramInt, i }, 300L, true);
      paramVVideoView = this.jdField_a_of_type_AndroidViewViewGroup;
      paramInt = this.jdField_a_of_type_ArrayOfInt[1];
      i = this.jdField_b_of_type_ArrayOfInt[1];
      arrayOfInt1 = this.c;
      j = six.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[1];
      int k = this.c[1];
      int[] arrayOfInt2 = this.c;
      six.a(paramVVideoView, new int[] { 0, paramInt + i }, arrayOfInt1, new int[] { 0, j - k }, arrayOfInt2, 300L, true);
      paramView.addOnLayoutChangeListener(new ubr(this));
      return;
    }
    paramVVideoView = this.jdField_a_of_type_AndroidViewViewGroup;
    paramInt = six.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[1];
    paramView = this.c;
    int i = six.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[1];
    int j = this.c[1];
    int[] arrayOfInt1 = this.c;
    six.a(paramVVideoView, new int[] { 0, paramInt }, paramView, new int[] { 0, i - j }, arrayOfInt1, 300L, true);
  }
  
  private void a(VVideoView paramVVideoView, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    six.a(this.jdField_a_of_type_AndroidViewView, 8, 300);
    six.a(this.jdField_a_of_type_AndroidViewViewGroup, 8, 300);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.jdField_a_of_type_AndroidViewViewGroup.getWidth();
    arrayOfInt[1] = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
    Object localObject;
    if ((paramBoolean) || (paramView == null))
    {
      localObject = new int[2];
      localObject[0] = 0;
      localObject[1] = six.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[1];
    }
    for (;;)
    {
      six.a(this.jdField_a_of_type_AndroidViewViewGroup, new int[] { 0, six.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[1] - this.jdField_a_of_type_AndroidViewViewGroup.getHeight() }, arrayOfInt, (int[])localObject, arrayOfInt, 300L, true);
      if (paramView == null) {
        break;
      }
      int i = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      localObject = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      localObject = six.a(paramView, new int[] { 0, i }, new int[] { j, k }, (int[])localObject, arrayOfInt, 300L, false);
      ((Animator)localObject).addListener(new ubs(this, paramVVideoView, paramView));
      ((Animator)localObject).start();
      return;
      localObject = new int[2];
      localObject[0] = 0;
      localObject[1] = (this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_b_of_type_ArrayOfInt[1]);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = null;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaCommentManager", 2, "hideFirstCommentList: isSlideDown=" + paramBoolean);
      }
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView == null) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        View localView = this.jdField_b_of_type_AndroidViewView.findViewWithTag("VVideoView");
        if ((localView instanceof VVideoView)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = ((VVideoView)localView);
        }
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView, this.jdField_b_of_type_AndroidViewView, paramBoolean);
      if (this.jdField_a_of_type_Ubx != null) {
        this.jdField_a_of_type_Ubx.a(false);
      }
    }
  }
  
  private void b(VVideoView paramVVideoView, View paramView)
  {
    if (paramVVideoView != null) {
      paramVVideoView.b();
    }
    if ((paramView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    if (paramVVideoView != null) {
      paramVVideoView.c();
    }
  }
  
  private void e()
  {
    try
    {
      int i;
      if (ScreenUtil.checkDeviceHasNavigationBar(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext()))
      {
        i = ScreenUtil.getNavigationBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext());
        this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, i);
      }
      if (CommonSuspensionGestureLayout.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        if (this.jdField_b_of_type_Int == 0) {
          return;
        }
        i = ScreenUtil.getNavigationBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext());
        this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, i + this.jdField_b_of_type_Int);
        return;
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.post(new ViolaCommentManager.1(this));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ViolaCommentManager", 1, "setCommentPadding");
      localException.printStackTrace();
      return;
    }
    if ((!CommonSuspensionGestureLayout.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) && (this.jdField_b_of_type_Int != 0)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, this.jdField_b_of_type_Int);
    }
  }
  
  private void f()
  {
    six.a(new ViolaCommentManager.5(this));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
    {
      Fragment localFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentById(2131364968);
      if ((localFragment instanceof ReadInJoyCommentListFragment)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = ((ReadInJoyCommentListFragment)localFragment);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = six.c(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    b();
    this.c = new int[] { six.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[0], this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height };
    TKDCommentDispatcher.INSTANCE.addEventListener(this.jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams != null)
    {
      if (paramView != null)
      {
        float f = paramView.getHeight() / paramView.getWidth();
        i = (int)(six.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[0] * f);
      }
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ((int)(six.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[1] - i - paramFloat - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)));
      this.c[1] = this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    }
  }
  
  public void a(VVideoView paramVVideoView, View paramView, ArticleInfo paramArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    g();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(paramArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(paramAnchorData);
    }
    e();
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getWidth() <= 0) || (this.jdField_a_of_type_AndroidViewViewGroup.getHeight() != this.c[1]))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(new ubu(this, paramVVideoView, paramView, paramArticleInfo, paramAnchorData, paramInt));
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Boolean) || (paramArticleInfo == null));
      if (QLog.isColorLevel()) {
        QLog.d("ViolaCommentManager", 2, "showCommentList: ");
      }
      g();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(paramArticleInfo, paramAnchorData, true, 2);
      }
      this.jdField_a_of_type_Boolean = true;
      a(paramVVideoView, paramView, paramInt);
    } while (this.jdField_a_of_type_Ubx == null);
    this.jdField_a_of_type_Ubx.a(true);
  }
  
  public void a(ubx paramubx)
  {
    this.jdField_a_of_type_Ubx = paramubx;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null)
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.d())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ViolaCommentManager", 2, "onBackPress: ");
        }
        a(false);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_is_fragment_container", true);
      ((Bundle)localObject).putBoolean("arg_comment_list_comment_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_share_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_from_video", true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a((Bundle)localObject, new ubt(this), this.jdField_a_of_type_AndroidViewViewGroup);
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
      ((FragmentTransaction)localObject).add(2131364968, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  public void b(VVideoView paramVVideoView, View paramView, ArticleInfo paramArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    if (paramArticleInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaCommentManager", 2, "openWriteCommentComponent: ");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
      {
        a(paramVVideoView, paramView, paramArticleInfo, paramAnchorData, paramInt);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(new ubv(this));
      }
    }
    else
    {
      return;
    }
    a(paramVVideoView, paramView, paramArticleInfo, paramAnchorData, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.d();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaCommentManager", 2, "hideCommentList: ");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.d();
      a(false);
    }
  }
  
  public void d()
  {
    TKDCommentDispatcher.INSTANCE.removeEventListener(this.jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ubq
 * JD-Core Version:    0.7.0.1
 */