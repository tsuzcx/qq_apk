import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentHelperCallback.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentListViewStateChangeListener.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogTopGestureLayout;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView.a;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import javax.annotation.Nullable;
import mqq.os.MqqHandler;

public class qhr
  extends ReportDialog
{
  private CommentFloatDialogTopGestureLayout jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout;
  private StoryPlayerCommentListView jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView;
  private qhy jdField_a_of_type_Qhy;
  private qru jdField_a_of_type_Qru;
  @Nullable
  private qsb jdField_a_of_type_Qsb;
  private boolean aDu;
  private boolean aDv;
  private Animation aj;
  private Animation ak;
  private RelativeLayout fN;
  private boolean mDestroy;
  private String mFeedId;
  private RelativeLayout mRootView;
  private int mSource;
  
  public qhr(@NonNull Context paramContext, @NonNull String paramString1, qhy paramqhy, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, 2131755310);
    this.mFeedId = paramString1;
    this.jdField_a_of_type_Qhy = paramqhy;
    this.mSource = paramInt;
    this.aDu = paramBoolean1;
    this.aDv = paramBoolean2;
    paramContext = LayoutInflater.from(paramContext).inflate(2131561996, null);
    i(paramContext, paramString2);
    this.jdField_a_of_type_Qhy.setFeedId(this.mFeedId);
    this.jdField_a_of_type_Qhy.bot();
    super.setContentView(paramContext);
    paramContext = getWindow();
    if (paramContext != null)
    {
      paramContext.setSoftInputMode(16);
      paramString1 = paramContext.getAttributes();
      paramString1.width = -1;
      paramString1.height = rpq.getScreenHeight(getContext());
      paramString1.flags |= 0x20;
      paramString1.gravity = 80;
      paramContext.setAttributes(paramString1);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        getWindow().addFlags(67108864);
        paramContext = new SystemBarCompact(this, true, getContext().getResources().getColor(17170445));
        paramContext.setStatusBarDrawable(null);
        paramContext.init();
      }
    }
  }
  
  private void i(View paramView, String paramString)
  {
    this.mRootView = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout = ((CommentFloatDialogTopGestureLayout)paramView.findViewById(2131365360));
    this.fN = ((RelativeLayout)paramView.findViewById(2131365322));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView = ((StoryPlayerCommentListView)paramView.findViewById(2131365034));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView.b(this.jdField_a_of_type_Qhy, new qhr.b(null), this.mSource);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.a(this, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout);
    if (QQStoryContext.isNightMode())
    {
      ((InputLinearLayout)paramView.findViewById(2131377137)).setBackgroundColor(getContext().getResources().getColor(2131166760));
      ((LinearLayout)paramView.findViewById(2131363673)).setBackgroundColor(getContext().getResources().getColor(2131166759));
      ((XEditTextEx)paramView.findViewById(2131366528)).setHintTextColor(getContext().getResources().getColor(2131166761));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView.setBackgroundColor(getContext().getResources().getColor(2131166759));
      paramView.findViewById(2131379823).setBackgroundColor(getContext().getResources().getColor(2131166759));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.setBackgroundColor(getContext().getResources().getColor(2131166759));
      paramView.findViewById(2131365990).setBackgroundColor(getContext().getResources().getColor(2131166760));
    }
    paramView.setOnClickListener(new qhs(this));
    ImageView localImageView = (ImageView)paramView.findViewById(2131364687);
    localImageView.setOnClickListener(new qht(this));
    if (QQStoryContext.isNightMode()) {
      localImageView.setBackgroundResource(2130847322);
    }
    ((TextView)paramView.findViewById(2131379769)).setText(paramString);
    this.aj = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    this.ak = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.aj.setDuration(400L);
    this.ak.setDuration(300L);
    this.ak.setAnimationListener(new qhu(this));
  }
  
  public boolean JD()
  {
    return (this.jdField_a_of_type_Qru != null) && (this.jdField_a_of_type_Qru.d != null) && (this.jdField_a_of_type_Qru.d.getOwner().isMe());
  }
  
  public boolean JE()
  {
    return (this.jdField_a_of_type_Qru != null) && (this.jdField_a_of_type_Qru.d != null) && (this.jdField_a_of_type_Qru.d.getOwner().isVip());
  }
  
  public void close()
  {
    if (!this.mDestroy)
    {
      this.mDestroy = true;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.startAnimation(this.ak);
    }
  }
  
  public void close(int paramInt)
  {
    if (!this.mDestroy)
    {
      this.mDestroy = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, paramInt, 1, 1.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new qhv(this));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.startAnimation(localTranslateAnimation);
    }
  }
  
  public CharSequence h()
  {
    if (this.jdField_a_of_type_Qsb != null) {
      return this.jdField_a_of_type_Qsb.b.getText();
    }
    return "";
  }
  
  protected void onStart()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.startAnimation(this.aj);
    super.onStart();
  }
  
  public class a
    implements qsb.a
  {
    private a() {}
    
    public void azy()
    {
      qhr.a(qhr.this).azy();
    }
    
    public void boq()
    {
      int i = qhr.a(qhr.this).sD();
      qhr.a(qhr.this).setSelectionFromBottom(i, 0);
    }
    
    public void bor()
    {
      Object localObject = qhr.a(qhr.this).a("CommentFloatDialog");
      if (localObject != null) {
        ((rsn)localObject).uh(false);
      }
      localObject = qhr.a(qhr.this).getLayoutParams();
      if (localObject == null) {
        localObject = new ViewGroup.LayoutParams(-1, qhr.this.getContext().getResources().getDimensionPixelOffset(2131299502));
      }
      for (;;)
      {
        qhr.a(qhr.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        ((ViewGroup.LayoutParams)localObject).height = qhr.this.getContext().getResources().getDimensionPixelOffset(2131299504);
      }
    }
    
    public void bos()
    {
      boolean bool = false;
      Object localObject = qhr.a(qhr.this).a("CommentFloatDialog");
      if (localObject != null)
      {
        if (qhr.a(qhr.this) != null)
        {
          if (!qhr.a(qhr.this).Y(qhr.a(qhr.this).isOpen())) {
            bool = true;
          }
          ((rsn)localObject).uh(bool);
        }
      }
      else
      {
        localObject = qhr.a(qhr.this).getLayoutParams();
        if (localObject != null) {
          break label118;
        }
        localObject = new ViewGroup.LayoutParams(-1, qhr.this.getContext().getResources().getDimensionPixelOffset(2131299502));
      }
      for (;;)
      {
        qhr.a(qhr.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        ((rsn)localObject).uh(false);
        break;
        label118:
        ((ViewGroup.LayoutParams)localObject).height = qhr.this.getContext().getResources().getDimensionPixelOffset(2131299502);
      }
    }
    
    public void f(CommentEntry paramCommentEntry)
    {
      qvf localqvf = (qvf)psx.a(11);
      psa localpsa = (psa)psx.a(17);
      boolean bool = qhr.a(qhr.this).isOpen();
      if ((!qhr.a(qhr.this).Y(bool)) && (qhr.a(qhr.this).a(bool) == null))
      {
        CommentEntry localCommentEntry = qsb.b(qhr.a(qhr.this).r(bool) - qhr.a(qhr.this).h(bool).size());
        qhr.a(qhr.this).e(localCommentEntry, bool);
        qhr.a(qhr.this).c(localCommentEntry, bool);
      }
      qhr.a(qhr.this).c(paramCommentEntry, bool);
      ram.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(qhr.a(qhr.this).d.mCommentCount), Integer.valueOf(qhr.a(qhr.this).d.mFanCommentCount), Integer.valueOf(qhr.a(qhr.this).d.mFriendCommentCount));
      int i;
      if (qhr.a(qhr.this).d.mDenyComment == 1)
      {
        i = 1;
        if (i != 0)
        {
          QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131704190), 0).show();
          paramCommentEntry.status = 2;
        }
        qhr.a(qhr.this).azy();
        ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
        qhr.a(qhr.this).d = ((CommentLikeFeedItem)localqvf.a(qhr.a(qhr.this).d));
        if (!qhr.a(qhr.this).Kl()) {
          break label347;
        }
        if (!bool) {
          break label334;
        }
        paramCommentEntry.type = 4;
        paramCommentEntry.pbType = 1;
        label313:
        localpsa.b(paramCommentEntry);
      }
      for (;;)
      {
        if (i == 0) {
          g(paramCommentEntry);
        }
        return;
        i = 0;
        break;
        label334:
        paramCommentEntry.type = 3;
        paramCommentEntry.pbType = 0;
        break label313;
        label347:
        paramCommentEntry.pbType = qhr.a(qhr.this).d.getCommentLikeType();
        localpsa.c(paramCommentEntry);
      }
    }
    
    public void g(CommentEntry paramCommentEntry)
    {
      pqj.a(qhr.a(qhr.this).d, paramCommentEntry, qhr.c(qhr.this), qhr.a(qhr.this), new qhx(this));
    }
    
    public void wk(int paramInt)
    {
      qhr.a(qhr.this).setSelectionFromBottom(qhr.a(qhr.this).sC() + paramInt, 0);
    }
    
    public void wl(int paramInt)
    {
      boolean bool = qhr.a(qhr.this).isOpen();
      Object localObject = qhr.a(qhr.this).h(bool);
      if ((paramInt < 0) || (paramInt >= ((List)localObject).size()))
      {
        ram.w("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
        return;
      }
      localObject = (CommentEntry)qhr.a(qhr.this).h(bool).get(paramInt);
      if (((CommentEntry)localObject).status != 0)
      {
        qhr.a(qhr.this).b((CommentEntry)localObject, bool);
        return;
      }
      if (!aqiw.isNetSupport(qhr.this.getContext()))
      {
        QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131704191), 0).show();
        ram.w("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
        return;
      }
      ((CommentEntry)localObject).status = 1;
      pqf.a((CommentEntry)localObject, new qhw(this, (CommentEntry)localObject, bool));
    }
  }
  
  public class b
    implements StoryPlayerCommentListView.a
  {
    private b() {}
    
    public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
    {
      if (qhr.a(qhr.this) != null) {
        qhr.a(qhr.this).c(paramCommentEntry, paramInt1, paramInt2);
      }
    }
    
    public void a(@NonNull qru paramqru, ErrorMessage paramErrorMessage)
    {
      if (paramErrorMessage.isSuccess())
      {
        qhr.a(qhr.this, paramqru);
        qhr.a(qhr.this).setVisibility(0);
        qhr.a(qhr.this, new qsb(qhr.this.getContext(), qhr.b(qhr.this), paramqru, false, 4444, new qhr.a(qhr.this, null)));
        if (qhr.a(qhr.this).x != null) {
          qhr.a(qhr.this).b.setText(qhr.a(qhr.this).x);
        }
        if (qhr.a(qhr.this))
        {
          qhr.a(qhr.this, false);
          qhr.a(qhr.this).postDelayed(new CommentFloatDialog.OnCommentListViewStateChangeListener.1(this), 100);
        }
        return;
      }
      qhr.a(qhr.this).setVisibility(8);
    }
    
    public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
    {
      if (qhr.a(qhr.this) != null) {
        qhr.a(qhr.this).b(paramCommentEntry, paramInt1, paramInt2);
      }
    }
    
    public void close()
    {
      if (!qhr.b(qhr.this)) {
        qhr.this.close();
      }
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((paramMotionEvent.getAction() == 1) && (qhr.a(qhr.this) != null) && (qhr.a(qhr.this).Ks()))
      {
        qhr.a(qhr.this).bqb();
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhr
 * JD-Core Version:    0.7.0.1
 */