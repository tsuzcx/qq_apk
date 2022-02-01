import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesProfileSegment.1;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

public class yks
  extends zsv
  implements View.OnClickListener, yjf
{
  public static final String KEY = "MemoriesProfileSegment";
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private yja jdField_a_of_type_Yja;
  public int b;
  private boolean b;
  private boolean c;
  
  public yks(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Yja = new yja(paramString, this);
    this.jdField_a_of_type_Yja.a();
  }
  
  private void a(ViewGroup paramViewGroup, ProgressBar paramProgressBar, TextView paramTextView, ImageView paramImageView)
  {
    int i = this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.medalLevel;
    int j = this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed;
    yuk.a("Q.qqstory.memories.MemoriesProfileSegment", "medalLevel:%s, gradeSpeed:%s", Integer.valueOf(i), Integer.valueOf(j));
    if ((this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) && (j >= 0))
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setOnClickListener(this);
      paramProgressBar.setMax(10);
      if (j < 10)
      {
        paramTextView.setText("QQ等级加速");
        paramProgressBar.setProgress(j);
        if (j == 0)
        {
          paramProgressBar.setMax(12);
          paramProgressBar.setProgress(1);
        }
      }
    }
    while ((i < 0) || ((this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip()) && (!this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend()) && (!this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())))
    {
      paramImageView.setVisibility(8);
      paramImageView.setOnClickListener(null);
      return;
      paramTextView.setText("加速0.5天");
      paramProgressBar.setProgress(10);
      continue;
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    paramImageView.setVisibility(0);
    paramImageView.setOnClickListener(this);
    switch (i)
    {
    default: 
      paramImageView.setVisibility(8);
      paramImageView.setOnClickListener(null);
      return;
    case 0: 
      if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
      {
        paramImageView.setImageResource(2130846617);
        return;
      }
      paramImageView.setVisibility(8);
      return;
    case 1: 
      paramImageView.setImageResource(2130846614);
      return;
    case 2: 
      paramImageView.setImageResource(2130846616);
      return;
    }
    paramImageView.setImageResource(2130846615);
  }
  
  private void i()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      yuk.d("Q.qqstory.memories.MemoriesProfileSegment", "current userUIItem is null, %s", new Object[] { this.jdField_a_of_type_Yja.jdField_a_of_type_JavaLangString });
      return;
    }
    if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra != 0)
    {
      this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra = 0;
      ThreadManager.post(new MemoriesProfileSegment.1(this), 5, null, false);
      c(true);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/fans_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", anzj.a(2131705416));
    localIntent.putExtra("isShowAd", false);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    yup.a("memory", "clk_fan_list", StoryMemoriesFragment.a(this.jdField_b_of_type_Int), 0, new String[] { "", "", "", "" });
  }
  
  private void j()
  {
    this.jdField_b_of_type_Boolean = true;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/follow_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", anzj.a(2131705414));
    localIntent.putExtra("isShowAd", false);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    yup.a("memory", "clk_follow_list", StoryMemoriesFragment.a(this.jdField_b_of_type_Int), 0, new String[] { "", "", "", "" });
  }
  
  private void l()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    String str = localAppInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + localAppInterface.getCurrentAccountUin(), 0).getString("profile_card_qim_online_url", null);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("hide_operation_bar", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if ((localAppInterface instanceof QQAppInterface)) {
      bdll.b((QQAppInterface)localAppInterface, "dc00898", "", "", "0X8008641", "0X8008641", 3, 0, "", "", "", "");
    }
  }
  
  private void n()
  {
    int i = 1;
    SegmentList localSegmentList;
    int k;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localSegmentList = a();
      if (localSegmentList != null)
      {
        k = this.jdField_a_of_type_AndroidViewView.getBottom() - (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131299011);
        if ((!ImmersiveTitleBar2.a) || (ImmersiveUtils.isSupporImmersive() != 1)) {
          break label93;
        }
      }
    }
    for (;;)
    {
      int j = k;
      if (i != 0) {
        j = k - (ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext) - zps.a(this.jdField_a_of_type_AndroidContentContext, 15.0F));
      }
      localSegmentList.smoothScrollBy(j, 500);
      return;
      label93:
      i = 0;
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null) {
      return paramyqw.a();
    }
    paramViewGroup = (ImageView)paramyqw.a(2131368363);
    Object localObject1 = (ImageView)paramyqw.a(2131368361);
    TextView localTextView3 = (TextView)paramyqw.a(2131378712);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramyqw.a(2131368429);
    TextView localTextView4 = (TextView)paramyqw.a(2131378738);
    View localView2 = paramyqw.a(2131369682);
    View localView3 = paramyqw.a(2131369658);
    View localView4 = paramyqw.a(2131369788);
    TextView localTextView5 = (TextView)paramyqw.a(2131378667);
    TextView localTextView6 = (TextView)paramyqw.a(2131378670);
    TextView localTextView7 = (TextView)paramyqw.a(2131378761);
    Object localObject3 = (TextView)paramyqw.a(2131378191);
    TextView localTextView8 = (TextView)paramyqw.a(2131378657);
    TextView localTextView9 = (TextView)paramyqw.a(2131378655);
    TextView localTextView10 = (TextView)paramyqw.a(2131378656);
    View localView1 = paramyqw.a(2131363396);
    ViewGroup localViewGroup = (ViewGroup)paramyqw.a(2131367636);
    ProgressBar localProgressBar = (ProgressBar)paramyqw.a(2131367637);
    TextView localTextView1 = (TextView)paramyqw.a(2131367638);
    ImageView localImageView = (ImageView)paramyqw.a(2131370671);
    Object localObject2 = (RedTouch)paramyqw.a("redTouch");
    FrameLayout localFrameLayout = (FrameLayout)paramyqw.a(2131369646);
    TextView localTextView2 = (TextView)paramyqw.a(2131380011);
    View localView5 = paramyqw.a(2131366296);
    View localView6 = paramyqw.a(2131366951);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      localTextView4.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      localTextView7.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      localTextView5.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      localTextView6.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      localTextView8.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      localTextView9.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      localTextView10.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      localFrameLayout.setBackgroundResource(2130846409);
      paramViewGroup.setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166479));
      localView5.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      localView6.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      ((TextView)localObject3).setBackgroundResource(2130846546);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.backgroundUrl)) {
      zps.a(paramViewGroup, this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.backgroundUrl, 0, 0, null);
    }
    zps.b((ImageView)localObject1, zpp.b(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.headUrl), 200, 200, bhmq.a(1), "QQStory200");
    ((ImageView)localObject1).setContentDescription(xiz.a(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem));
    localTextView3.setText(xiz.a(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem));
    localTextView3.setContentDescription(xiz.a(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem));
    localStoryUserBadgeView.setUnionID(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), 3);
    if (localStoryUserBadgeView.getVisibility() == 0)
    {
      if (!((Boolean)paramyqw.a("hasExposure")).booleanValue())
      {
        paramyqw.a("hasExposure", new Boolean(true));
        localStoryUserBadgeView.a();
      }
      localTextView4.setText(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.signature);
      localTextView5.setText(zps.a(Math.max(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCount, 0)));
      localTextView6.setText(zps.a(Math.max(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.followCount, 0)));
      if (!this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip()) {
        break label1247;
      }
      localView2.setVisibility(0);
      label782:
      localTextView7.setText(zps.a(Math.max(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount, 0)));
      if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount >= 0) {
        break label1257;
      }
      localView4.setVisibility(8);
      label825:
      if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
      {
        localView2.setOnClickListener(this);
        localView3.setOnClickListener(this);
      }
      localView4.setOnClickListener(this);
      ((TextView)localObject3).setOnClickListener(this);
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject1 = (FrameLayout.LayoutParams)localView1.getLayoutParams();
        paramViewGroup = (ViewGroup)localObject1;
        if (localObject1 == null) {
          paramViewGroup = new FrameLayout.LayoutParams(-1, -2);
        }
        if (!ykf.a(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem)) {
          break label1266;
        }
        this.jdField_a_of_type_Int = 1;
        paramViewGroup.height = zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 254.0F);
        label933:
        localView1.setLayoutParams(paramViewGroup);
      }
      if (this.jdField_a_of_type_Int == 1) {
        break label1291;
      }
      ((TextView)localObject3).setVisibility(8);
      label954:
      if ((this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) && (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra != 0)) {
        break label1338;
      }
      ((RedTouch)localObject2).setVisibility(8);
      label987:
      if (!this.c) {
        break label1402;
      }
      paramViewGroup = QQStoryContext.a();
      localObject2 = paramViewGroup.getApplication().getSharedPreferences("public_account_qq_mail_" + paramViewGroup.getCurrentAccountUin(), 0);
      localObject3 = ((SharedPreferences)localObject2).getString("profile_card_qim_online_url", null);
      localObject1 = ((SharedPreferences)localObject2).getString("key_story_qim_online_icon_url", null);
      localObject2 = ((SharedPreferences)localObject2).getString("profile_card_qim_online_wording", null);
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label1392;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText((CharSequence)localObject2);
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298018);
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mRetryCount = 2;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramInt;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramInt;
      localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
      ((Drawable)localObject1).setBounds(0, 0, paramInt, paramInt);
      localTextView2.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localTextView2.setContentDescription((CharSequence)localObject2);
      localTextView2.setOnClickListener(this);
      if ((paramViewGroup instanceof QQAppInterface)) {
        bdll.b((QQAppInterface)paramViewGroup, "dc00898", "", "", "0X8008640", "0X8008640", 3, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      a(localViewGroup, localProgressBar, localTextView1, localImageView);
      return paramyqw.a();
      localStoryUserBadgeView.setVisibility(8);
      break;
      label1247:
      localView2.setVisibility(8);
      break label782;
      label1257:
      localView4.setVisibility(0);
      break label825;
      label1266:
      this.jdField_a_of_type_Int = 2;
      paramViewGroup.height = zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 220.0F);
      break label933;
      label1291:
      ((TextView)localObject3).setVisibility(0);
      if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe())
      {
        ((TextView)localObject3).setText(anzj.a(2131705418));
        break label954;
      }
      ((TextView)localObject3).setText(anzj.a(2131705425));
      break label954;
      label1338:
      paramViewGroup = zpk.a(4, "+" + zps.a(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra), 0);
      ((RedTouch)localObject2).setVisibility(0);
      ((RedTouch)localObject2).a(paramViewGroup);
      break label987;
      label1392:
      localTextView2.setVisibility(8);
      continue;
      label1402:
      localTextView2.setVisibility(8);
    }
  }
  
  public String a()
  {
    return "MemoriesProfileSegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561775, paramViewGroup, false);
    paramViewGroup = new yqw(this.jdField_a_of_type_AndroidViewView);
    View localView = paramViewGroup.a(2131376429);
    paramViewGroup.a("redTouch", new RedTouch(this.jdField_a_of_type_AndroidViewView.getContext(), localView).a(21).c(3).b(5).a());
    paramViewGroup.a("hasExposure", new Boolean(false));
    return paramViewGroup;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(true);
      return;
    }
    c(false);
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    this.jdField_a_of_type_Yja.a(false);
    return true;
  }
  
  protected void b()
  {
    super.b();
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    c(true);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Yja.a(true);
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_Yja.b();
  }
  
  protected void e()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Yja.a(false);
    }
  }
  
  public void f()
  {
    yuk.c("Q.qqstory.memories.MemoriesProfileSegment", "on subscribe button click. ");
    if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      yuk.d("Q.qqstory.memories.MemoriesProfileSegment", "current userUIItem is null, %s", new Object[] { this.jdField_a_of_type_Yja.jdField_a_of_type_JavaLangString });
      return;
    }
    int j = this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe;
    Object localObject = (wja)xiz.a().a(98);
    int i;
    if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip())
    {
      i = 1;
      ((wja)localObject).a(i, this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid, j, 2);
      i = StoryMemoriesFragment.a(this.jdField_b_of_type_Int);
      if (j != 1) {
        break label169;
      }
      localObject = "2";
      label112:
      if (!this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip()) {
        break label176;
      }
    }
    label169:
    label176:
    for (String str = "1";; str = "2")
    {
      yup.a("memory", "follow_card", i, 0, new String[] { localObject, str, "", "" });
      return;
      i = 0;
      break;
      localObject = "1";
      break label112;
    }
  }
  
  public void g()
  {
    String str = QQStoryContext.a().a();
    if (TextUtils.isEmpty(str))
    {
      yuk.e("Q.qqstory.memories.MemoriesProfileSegment", "onGradeSpeedClick, uin is empty");
      return;
    }
    str = String.format("https://story.now.qq.com/m/gaccel/?uin=%s", new Object[] { str });
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    int i;
    if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed == 0) {
      i = 1;
    }
    for (;;)
    {
      yup.a("memory", "clk_level", 0, 0, new String[] { String.valueOf(i) });
      return;
      if ((this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed > 0) && (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed < 10)) {
        i = 2;
      } else if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed == 10) {
        i = 3;
      } else {
        i = -1;
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
    {
      str = "https://ti.qq.com/qqmedal2/index.html?from=8&_nav_alpha=0&_nav_anim=true&_wwv=4&_wv=1&_nav_txtclr=ffffff&_bid=2450&_nav_titleclr=ffffff&openMedalId=22";
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (!this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {
        break label113;
      }
    }
    label113:
    for (String str = "1";; str = "2")
    {
      yup.a("memory", "clk_medal", 0, 0, new String[] { str });
      return;
      str = String.format("https://ti.qq.com/qqmedal2/index.html?from=9&_nav_alpha=0&_nav_anim=true&_wwv=4&_wv=1&_nav_txtclr=ffffff&_bid=2450&_nav_titleclr=ffffff&openMedalId=22&tuin=%s", new Object[] { axwz.a(this.jdField_a_of_type_Yja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq) });
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i();
      continue;
      j();
      continue;
      l();
      continue;
      n();
      continue;
      f();
      continue;
      h();
      continue;
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yks
 * JD-Core Version:    0.7.0.1
 */