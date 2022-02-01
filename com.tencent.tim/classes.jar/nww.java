import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class nww
{
  private nww.a a;
  private int aXc;
  private VVideoView b;
  private ViewGroup bB;
  private int bcR;
  private ReadInJoyCommentListFragment c;
  private ViewGroup cf;
  private FrameLayout container;
  private ViewGroup.LayoutParams d;
  private int[] dA;
  private int[] dB;
  private int[] dC;
  private ViewGroup.LayoutParams h;
  private FragmentActivity mActivity;
  private FragmentManager mFragmentManager;
  private boolean mIsVisible;
  private View ne;
  private View nf;
  
  public nww(FragmentActivity paramFragmentActivity, FragmentManager paramFragmentManager, int paramInt)
  {
    this.bcR = paramInt;
    this.mActivity = paramFragmentActivity;
    this.mFragmentManager = paramFragmentManager;
    this.container = new FrameLayout(paramFragmentActivity);
    this.ne = new View(paramFragmentActivity);
    this.container.addView(this.ne, -1, -1);
    this.bB = new FrameLayout(paramFragmentActivity);
    this.bB.setId(2131365045);
    this.container.addView(this.bB, -2, -2);
    ((FrameLayout.LayoutParams)this.bB.getLayoutParams()).gravity = 80;
    this.bB.setVisibility(0);
    this.mActivity.getWindow().addContentView(this.container, new WindowManager.LayoutParams(-1, -1));
    initUI();
  }
  
  private void a(VVideoView paramVVideoView, View paramView)
  {
    this.bB.setVisibility(8);
    this.ne.setVisibility(8);
    b(paramVVideoView, paramView);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (this.cf != null) {
      this.cf.addView(paramView, this.aXc, this.h);
    }
    this.b = null;
    this.nf = null;
    this.cf = null;
    this.h = null;
    this.dA = null;
    this.dB = null;
  }
  
  private void a(VVideoView paramVVideoView, View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    this.b = paramVVideoView;
    this.nf = paramView;
    this.cf = ((ViewGroup)paramView.getParent());
    this.h = paramView.getLayoutParams();
    this.aXc = this.cf.indexOfChild(paramView);
    this.dA = new int[2];
    paramView.getLocationInWindow(this.dA);
    this.dA[1] -= this.bcR;
    this.dB = new int[] { paramView.getWidth(), paramView.getHeight() };
    b(paramVVideoView, paramView);
    int i = muj.c(this.mActivity)[0];
    int j = (int)(paramView.getHeight() / paramView.getWidth() * i);
    this.container.addView(paramView, 1, new FrameLayout.LayoutParams(-1, j));
    this.ne.setBackgroundDrawable(new ColorDrawable(paramInt));
    this.bB.setVisibility(8);
    this.ne.setVisibility(8);
    muj.m(this.ne, 0, 300);
    muj.a(this.bB, 0, 300);
    muj.a(paramView, this.dA, this.dB, new int[] { 0, ImmersiveUtils.getStatusBarHeight(this.mActivity) }, new int[] { i, j }, 300L, true);
    paramVVideoView = this.bB;
    paramInt = this.dA[1];
    i = this.dB[1];
    int[] arrayOfInt1 = this.dC;
    j = muj.c(this.mActivity)[1];
    int k = this.dC[1];
    int[] arrayOfInt2 = this.dC;
    muj.a(paramVVideoView, new int[] { 0, paramInt + i }, arrayOfInt1, new int[] { 0, j - k }, arrayOfInt2, 300L, true);
    paramView.addOnLayoutChangeListener(new nwx(this));
  }
  
  private void a(VVideoView paramVVideoView, View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    this.bB.setVisibility(0);
    this.ne.setVisibility(0);
    muj.m(this.ne, 8, 300);
    muj.a(this.bB, 8, 300);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.bB.getWidth();
    arrayOfInt[1] = this.bB.getHeight();
    Object localObject;
    if (paramBoolean)
    {
      localObject = new int[2];
      localObject[0] = 0;
      localObject[1] = muj.c(this.mActivity)[1];
    }
    for (;;)
    {
      muj.a(this.bB, new int[] { 0, muj.c(this.mActivity)[1] - this.bB.getHeight() }, arrayOfInt, (int[])localObject, arrayOfInt, 300L, true);
      int i = ImmersiveUtils.getStatusBarHeight(this.mActivity);
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      localObject = this.dA;
      arrayOfInt = this.dB;
      localObject = muj.a(paramView, new int[] { 0, i }, new int[] { j, k }, (int[])localObject, arrayOfInt, 300L, false);
      ((Animator)localObject).addListener(new nwy(this, paramVVideoView, paramView));
      ((Animator)localObject).start();
      return;
      localObject = new int[2];
      localObject[0] = 0;
      localObject[1] = (this.dA[1] + this.dB[1]);
    }
  }
  
  private void b(VVideoView paramVVideoView, View paramView)
  {
    if (paramVVideoView != null) {
      paramVVideoView.aTP();
    }
    if ((paramView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    if (paramVVideoView != null) {
      paramVVideoView.aTQ();
    }
  }
  
  private void bbP()
  {
    try
    {
      int i;
      if (ankt.bA(this.mActivity.getApplicationContext()))
      {
        i = ankt.getNavigationBarHeight(this.mActivity.getApplicationContext());
        this.bB.setPadding(0, 0, 0, i);
      }
      if (this.mActivity == null) {
        return;
      }
      if (CommonSuspensionGestureLayout.isNavigationBarExist(this.mActivity))
      {
        if (this.bcR == 0) {
          return;
        }
        i = ankt.getNavigationBarHeight(this.mActivity.getApplicationContext());
        this.bB.setPadding(0, 0, 0, i + this.bcR);
        return;
      }
      if (this.bcR == 0)
      {
        this.bB.post(new ViolaCommentManager.1(this));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ViolaCommentManager", 1, "setCommentPadding");
      localException.printStackTrace();
      return;
    }
    if ((!CommonSuspensionGestureLayout.isNavigationBarExist(this.mActivity)) && (this.bcR != 0)) {
      this.bB.setPadding(0, 0, 0, this.bcR);
    }
  }
  
  public boolean El()
  {
    return this.mIsVisible;
  }
  
  public void a(VVideoView paramVVideoView, View paramView, ArticleInfo paramArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    bbP();
    if ((this.bB.getWidth() <= 0) || (this.bB.getHeight() != this.dC[1]))
    {
      this.bB.setVisibility(0);
      this.bB.setAlpha(0.0F);
    }
    do
    {
      this.bB.post(new ViolaCommentManager.5(this, paramVVideoView, paramView, paramArticleInfo, paramAnchorData, paramInt));
      do
      {
        return;
      } while ((this.mIsVisible) || (paramArticleInfo == null));
      if (this.c == null)
      {
        Fragment localFragment = this.mFragmentManager.findFragmentById(2131365045);
        if ((localFragment instanceof ReadInJoyCommentListFragment)) {
          this.c = ((ReadInJoyCommentListFragment)localFragment);
        }
      }
      if (this.c != null) {
        this.c.a(paramArticleInfo, paramAnchorData, true, 2);
      }
      this.mIsVisible = true;
      a(paramVVideoView, paramView, paramInt);
    } while (this.a == null);
    this.a.ox(true);
  }
  
  public void a(nww.a parama)
  {
    this.a = parama;
  }
  
  public void aKA()
  {
    if (this.c == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_is_fragment_container", true);
      ((Bundle)localObject).putBoolean("arg_comment_list_comment_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_share_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_from_video", true);
      this.c = new ReadInJoyCommentListFragment();
      this.c.pB(2);
      this.c.a((Bundle)localObject, new nwz(this), this.bB);
      localObject = this.mFragmentManager.beginTransaction();
      ((FragmentTransaction)localObject).add(2131365045, this.c);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  public void d(View paramView, float paramFloat)
  {
    if (this.d != null)
    {
      int i = (int)(paramView.getHeight() / paramView.getWidth() * muj.c(this.mActivity)[0]);
      this.d.height = ((int)(muj.c(this.mActivity)[1] - i - paramFloat - ImmersiveUtils.getStatusBarHeight(this.mActivity)));
      this.dC[1] = this.d.height;
      this.bB.setLayoutParams(this.d);
    }
  }
  
  public void initUI()
  {
    this.d = this.bB.getLayoutParams();
    this.d.height = muj.m(this.mActivity);
    this.bB.setLayoutParams(this.d);
    this.bB.setOnClickListener(null);
    aKA();
    this.dC = new int[] { muj.c(this.mActivity)[0], this.d.height };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.c != null) {
      this.c.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPress()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.c != null)
    {
      bool1 = bool2;
      if (!this.c.onBackPress())
      {
        ql(false);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void ql(boolean paramBoolean)
  {
    if (this.mIsVisible)
    {
      this.mIsVisible = false;
      if (this.b == null)
      {
        View localView = this.nf.findViewWithTag("VVideoView");
        if ((localView instanceof VVideoView)) {
          this.b = ((VVideoView)localView);
        }
      }
      a(this.b, this.nf, paramBoolean);
      if (this.a != null) {
        this.a.ox(false);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aGM();
    
    public abstract void ox(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nww
 * JD-Core Version:    0.7.0.1
 */