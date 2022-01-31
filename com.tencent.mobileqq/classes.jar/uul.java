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
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

public class uul
  extends wco
  implements View.OnClickListener, usy
{
  public static final String KEY = "MemoriesProfileSegment";
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private ust jdField_a_of_type_Ust;
  public int b;
  private boolean b;
  private boolean c;
  
  public uul(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Ust = new ust(paramString, this);
    this.jdField_a_of_type_Ust.a();
  }
  
  private void a(ViewGroup paramViewGroup, ProgressBar paramProgressBar, TextView paramTextView, ImageView paramImageView)
  {
    int i = this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.medalLevel;
    int j = this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed;
    ved.a("Q.qqstory.memories.MemoriesProfileSegment", "medalLevel:%s, gradeSpeed:%s", Integer.valueOf(i), Integer.valueOf(j));
    if ((this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) && (j >= 0))
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
    while ((i < 0) || ((this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip()) && (!this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend()) && (!this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())))
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
      if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
      {
        paramImageView.setImageResource(2130845709);
        return;
      }
      paramImageView.setVisibility(8);
      return;
    case 1: 
      paramImageView.setImageResource(2130845706);
      return;
    case 2: 
      paramImageView.setImageResource(2130845708);
      return;
    }
    paramImageView.setImageResource(2130845707);
  }
  
  private void i()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      ved.d("Q.qqstory.memories.MemoriesProfileSegment", "current userUIItem is null, %s", new Object[] { this.jdField_a_of_type_Ust.jdField_a_of_type_JavaLangString });
      return;
    }
    if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra != 0)
    {
      this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra = 0;
      ThreadManager.post(new MemoriesProfileSegment.1(this), 5, null, false);
      c(true);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/fans_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", ajya.a(2131706534));
    localIntent.putExtra("isShowAd", false);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    vei.a("memory", "clk_fan_list", StoryMemoriesFragment.a(this.jdField_b_of_type_Int), 0, new String[] { "", "", "", "" });
  }
  
  private void j()
  {
    this.jdField_b_of_type_Boolean = true;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/follow_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", ajya.a(2131706532));
    localIntent.putExtra("isShowAd", false);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    vei.a("memory", "clk_follow_list", StoryMemoriesFragment.a(this.jdField_b_of_type_Int), 0, new String[] { "", "", "", "" });
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
      axqy.b((QQAppInterface)localAppInterface, "dc00898", "", "", "0X8008641", "0X8008641", 3, 0, "", "", "", "");
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
        k = this.jdField_a_of_type_AndroidViewView.getBottom() - (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298865);
        if ((!ImmersiveTitleBar2.a) || (ImmersiveUtils.isSupporImmersive() != 1)) {
          break label93;
        }
      }
    }
    for (;;)
    {
      int j = k;
      if (i != 0) {
        j = k - (ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext) - vzl.a(this.jdField_a_of_type_AndroidContentContext, 15.0F));
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
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null) {
      return paramvap.a();
    }
    paramViewGroup = (ImageView)paramvap.a(2131367818);
    Object localObject1 = (ImageView)paramvap.a(2131367816);
    TextView localTextView3 = (TextView)paramvap.a(2131377138);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramvap.a(2131367885);
    TextView localTextView4 = (TextView)paramvap.a(2131377164);
    View localView2 = paramvap.a(2131368950);
    View localView3 = paramvap.a(2131368927);
    View localView4 = paramvap.a(2131369054);
    TextView localTextView5 = (TextView)paramvap.a(2131377093);
    TextView localTextView6 = (TextView)paramvap.a(2131377096);
    TextView localTextView7 = (TextView)paramvap.a(2131377187);
    Object localObject3 = (TextView)paramvap.a(2131376661);
    TextView localTextView8 = (TextView)paramvap.a(2131377083);
    TextView localTextView9 = (TextView)paramvap.a(2131377081);
    TextView localTextView10 = (TextView)paramvap.a(2131377082);
    View localView1 = paramvap.a(2131363148);
    ViewGroup localViewGroup = (ViewGroup)paramvap.a(2131367130);
    ProgressBar localProgressBar = (ProgressBar)paramvap.a(2131367131);
    TextView localTextView1 = (TextView)paramvap.a(2131367132);
    ImageView localImageView = (ImageView)paramvap.a(2131369843);
    Object localObject2 = (RedTouch)paramvap.a("redTouch");
    FrameLayout localFrameLayout = (FrameLayout)paramvap.a(2131368916);
    TextView localTextView2 = (TextView)paramvap.a(2131378297);
    View localView5 = paramvap.a(2131365905);
    View localView6 = paramvap.a(2131366517);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      localTextView4.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      localTextView7.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      localTextView5.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      localTextView6.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      localTextView8.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      localTextView9.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      localTextView10.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      localFrameLayout.setBackgroundResource(2130845501);
      paramViewGroup.setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166352));
      localView5.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      localView6.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      ((TextView)localObject3).setBackgroundResource(2130845638);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.backgroundUrl)) {
      vzl.a(paramViewGroup, this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.backgroundUrl, 0, 0, null);
    }
    vzl.b((ImageView)localObject1, vzi.b(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.headUrl), 200, 200, bbef.a(1), "QQStory200");
    ((ImageView)localObject1).setContentDescription(tsr.a(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem));
    localTextView3.setText(tsr.a(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem));
    localTextView3.setContentDescription(tsr.a(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem));
    localStoryUserBadgeView.setUnionID(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), 3);
    if (localStoryUserBadgeView.getVisibility() == 0)
    {
      if (!((Boolean)paramvap.a("hasExposure")).booleanValue())
      {
        paramvap.a("hasExposure", new Boolean(true));
        localStoryUserBadgeView.a();
      }
      localTextView4.setText(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.signature);
      localTextView5.setText(vzl.a(Math.max(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCount, 0)));
      localTextView6.setText(vzl.a(Math.max(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.followCount, 0)));
      if (!this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip()) {
        break label1247;
      }
      localView2.setVisibility(0);
      label782:
      localTextView7.setText(vzl.a(Math.max(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount, 0)));
      if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount >= 0) {
        break label1257;
      }
      localView4.setVisibility(8);
      label825:
      if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
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
        if (!uty.a(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem)) {
          break label1266;
        }
        this.jdField_a_of_type_Int = 1;
        paramViewGroup.height = vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 254.0F);
        label933:
        localView1.setLayoutParams(paramViewGroup);
      }
      if (this.jdField_a_of_type_Int == 1) {
        break label1291;
      }
      ((TextView)localObject3).setVisibility(8);
      label954:
      if ((this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) && (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra != 0)) {
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
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297904);
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
        axqy.b((QQAppInterface)paramViewGroup, "dc00898", "", "", "0X8008640", "0X8008640", 3, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      a(localViewGroup, localProgressBar, localTextView1, localImageView);
      return paramvap.a();
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
      paramViewGroup.height = vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 220.0F);
      break label933;
      label1291:
      ((TextView)localObject3).setVisibility(0);
      if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe())
      {
        ((TextView)localObject3).setText(ajya.a(2131706536));
        break label954;
      }
      ((TextView)localObject3).setText(ajya.a(2131706543));
      break label954;
      label1338:
      paramViewGroup = vzd.a(4, "+" + vzl.a(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra), 0);
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
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561291, paramViewGroup, false);
    paramViewGroup = new vap(this.jdField_a_of_type_AndroidViewView);
    View localView = paramViewGroup.a(2131375041);
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
    this.jdField_a_of_type_Ust.a(false);
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
    this.jdField_a_of_type_Ust.a(true);
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_Ust.b();
  }
  
  protected void e()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Ust.a(false);
    }
  }
  
  public void f()
  {
    ved.c("Q.qqstory.memories.MemoriesProfileSegment", "on subscribe button click. ");
    if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      ved.d("Q.qqstory.memories.MemoriesProfileSegment", "current userUIItem is null, %s", new Object[] { this.jdField_a_of_type_Ust.jdField_a_of_type_JavaLangString });
      return;
    }
    int j = this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe;
    Object localObject = (sss)tsr.a().a(98);
    int i;
    if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip())
    {
      i = 1;
      ((sss)localObject).a(i, this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid, j, 2);
      i = StoryMemoriesFragment.a(this.jdField_b_of_type_Int);
      if (j != 1) {
        break label169;
      }
      localObject = "2";
      label112:
      if (!this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip()) {
        break label176;
      }
    }
    label169:
    label176:
    for (String str = "1";; str = "2")
    {
      vei.a("memory", "follow_card", i, 0, new String[] { localObject, str, "", "" });
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
      ved.e("Q.qqstory.memories.MemoriesProfileSegment", "onGradeSpeedClick, uin is empty");
      return;
    }
    str = String.format("https://story.now.qq.com/m/gaccel/?uin=%s", new Object[] { str });
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    int i;
    if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed == 0) {
      i = 1;
    }
    for (;;)
    {
      vei.a("memory", "clk_level", 0, 0, new String[] { String.valueOf(i) });
      return;
      if ((this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed > 0) && (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed < 10)) {
        i = 2;
      } else if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed == 10) {
        i = 3;
      } else {
        i = -1;
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
    {
      str = "https://ti.qq.com/qqmedal2/index.html?from=8&_nav_alpha=0&_nav_anim=true&_wwv=4&_wv=1&_nav_txtclr=ffffff&_bid=2450&_nav_titleclr=ffffff&openMedalId=22";
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (!this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {
        break label113;
      }
    }
    label113:
    for (String str = "1";; str = "2")
    {
      vei.a("memory", "clk_medal", 0, 0, new String[] { str });
      return;
      str = String.format("https://ti.qq.com/qqmedal2/index.html?from=9&_nav_alpha=0&_nav_anim=true&_wwv=4&_wv=1&_nav_txtclr=ffffff&_bid=2450&_nav_titleclr=ffffff&openMedalId=22&tuin=%s", new Object[] { atbp.a(this.jdField_a_of_type_Ust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq) });
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368950: 
      i();
      return;
    case 2131368927: 
      j();
      return;
    case 2131378297: 
      l();
      return;
    case 2131369054: 
      n();
      return;
    case 2131376661: 
      f();
      return;
    case 2131369843: 
      h();
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uul
 * JD-Core Version:    0.7.0.1
 */