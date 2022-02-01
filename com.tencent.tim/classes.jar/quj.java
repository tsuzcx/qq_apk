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

public class quj
  extends rsd
  implements View.OnClickListener, qtp.d
{
  public static final String KEY = "MemoriesProfileSegment";
  private boolean aFy;
  private boolean aFz;
  public int bof = 0;
  private qtp c;
  private View mContentView;
  public int mSource;
  
  public quj(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    this.mSource = paramInt;
    this.c = new qtp(paramString, this);
    this.c.create();
  }
  
  private void a(ViewGroup paramViewGroup, ProgressBar paramProgressBar, TextView paramTextView, ImageView paramImageView)
  {
    int i = this.c.mUserUIItem.medalLevel;
    int j = this.c.mUserUIItem.gradeSpeed;
    ram.b("Q.qqstory.memories.MemoriesProfileSegment", "medalLevel:%s, gradeSpeed:%s", Integer.valueOf(i), Integer.valueOf(j));
    if ((this.c.mUserUIItem.isMe()) && (j >= 0))
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
    while ((i < 0) || ((this.c.mUserUIItem.isVip()) && (!this.c.mUserUIItem.isFriend()) && (!this.c.mUserUIItem.isMe())))
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
      if (this.c.mUserUIItem.isMe())
      {
        paramImageView.setImageResource(2130847482);
        return;
      }
      paramImageView.setVisibility(8);
      return;
    case 1: 
      paramImageView.setImageResource(2130847479);
      return;
    case 2: 
      paramImageView.setImageResource(2130847481);
      return;
    }
    paramImageView.setImageResource(2130847480);
  }
  
  private void bqP()
  {
    this.aFy = true;
    if (this.c.mUserUIItem == null)
    {
      ram.w("Q.qqstory.memories.MemoriesProfileSegment", "current userUIItem is null, %s", new Object[] { this.c.mUid });
      return;
    }
    if (this.c.mUserUIItem.fansCountExtra != 0)
    {
      this.c.mUserUIItem.fansCountExtra = 0;
      ThreadManager.post(new MemoriesProfileSegment.1(this), 5, null, false);
      notifyDataSetChanged(true);
    }
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/fans_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", acfp.m(2131708101));
    localIntent.putExtra("isShowAd", false);
    this.context.startActivity(localIntent);
    rar.a("memory", "clk_fan_list", StoryMemoriesFragment.dX(this.mSource), 0, new String[] { "", "", "", "" });
  }
  
  private void bqQ()
  {
    this.aFy = true;
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/follow_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", acfp.m(2131708099));
    localIntent.putExtra("isShowAd", false);
    this.context.startActivity(localIntent);
    rar.a("memory", "clk_follow_list", StoryMemoriesFragment.dX(this.mSource), 0, new String[] { "", "", "", "" });
  }
  
  private void bqR()
  {
    AppInterface localAppInterface = QQStoryContext.c();
    String str = localAppInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + localAppInterface.getCurrentAccountUin(), 0).getString("profile_card_qim_online_url", null);
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("hide_operation_bar", true);
    this.context.startActivity(localIntent);
    if ((localAppInterface instanceof QQAppInterface)) {
      anot.a((QQAppInterface)localAppInterface, "dc00898", "", "", "0X8008641", "0X8008641", 3, 0, "", "", "", "");
    }
  }
  
  private void bqS()
  {
    int i = 1;
    SegmentList localSegmentList;
    int k;
    if (this.mContentView != null)
    {
      localSegmentList = a();
      if (localSegmentList != null)
      {
        k = this.mContentView.getBottom() - (int)this.context.getResources().getDimension(2131299627);
        if ((!ImmersiveTitleBar2.dlu) || (ImmersiveUtils.isSupporImmersive() != 1)) {
          break label93;
        }
      }
    }
    for (;;)
    {
      int j = k;
      if (i != 0) {
        j = k - (ImmersiveUtils.getStatusBarHeight(this.context) - rpq.dip2px(this.context, 15.0F));
      }
      localSegmentList.smoothScrollBy(j, 500);
      return;
      label93:
      i = 0;
    }
  }
  
  protected boolean Z(boolean paramBoolean)
  {
    this.c.refreshData(false);
    return true;
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    if (this.c.mUserUIItem == null) {
      return paramqyd.getItemView();
    }
    paramViewGroup = (ImageView)paramqyd.get(2131368868);
    Object localObject1 = (ImageView)paramqyd.get(2131368866);
    TextView localTextView3 = (TextView)paramqyd.get(2131379515);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramqyd.get(2131368936);
    TextView localTextView4 = (TextView)paramqyd.get(2131379541);
    View localView2 = paramqyd.get(2131370195);
    View localView3 = paramqyd.get(2131370172);
    View localView4 = paramqyd.get(2131370304);
    TextView localTextView5 = (TextView)paramqyd.get(2131379470);
    TextView localTextView6 = (TextView)paramqyd.get(2131379473);
    TextView localTextView7 = (TextView)paramqyd.get(2131379564);
    Object localObject3 = (TextView)paramqyd.get(2131378958);
    TextView localTextView8 = (TextView)paramqyd.get(2131379460);
    TextView localTextView9 = (TextView)paramqyd.get(2131379458);
    TextView localTextView10 = (TextView)paramqyd.get(2131379459);
    View localView1 = paramqyd.get(2131363401);
    ViewGroup localViewGroup = (ViewGroup)paramqyd.get(2131368100);
    ProgressBar localProgressBar = (ProgressBar)paramqyd.get(2131368101);
    TextView localTextView1 = (TextView)paramqyd.get(2131368102);
    ImageView localImageView = (ImageView)paramqyd.get(2131371201);
    Object localObject2 = (RedTouch)paramqyd.l("redTouch");
    FrameLayout localFrameLayout = (FrameLayout)paramqyd.get(2131370161);
    TextView localTextView2 = (TextView)paramqyd.get(2131380862);
    View localView5 = paramqyd.get(2131366708);
    View localView6 = paramqyd.get(2131367386);
    if (QQStoryContext.isNightMode())
    {
      localTextView3.setTextColor(this.context.getResources().getColor(2131166761));
      localTextView4.setTextColor(this.context.getResources().getColor(2131166761));
      localTextView7.setTextColor(this.context.getResources().getColor(2131166761));
      localTextView5.setTextColor(this.context.getResources().getColor(2131166761));
      localTextView6.setTextColor(this.context.getResources().getColor(2131166761));
      ((TextView)localObject3).setTextColor(this.context.getResources().getColor(2131166761));
      localTextView8.setTextColor(this.context.getResources().getColor(2131166761));
      localTextView9.setTextColor(this.context.getResources().getColor(2131166761));
      localTextView10.setTextColor(this.context.getResources().getColor(2131166761));
      localFrameLayout.setBackgroundResource(2130847274);
      paramViewGroup.setColorFilter(this.context.getResources().getColor(2131166762));
      localView5.setBackgroundColor(this.context.getResources().getColor(2131166761));
      localView6.setBackgroundColor(this.context.getResources().getColor(2131166761));
      ((TextView)localObject3).setBackgroundResource(2130847411);
    }
    if (!TextUtils.isEmpty(this.c.mUserUIItem.backgroundUrl)) {
      rpq.a(paramViewGroup, this.c.mUserUIItem.backgroundUrl, 0, 0, null);
    }
    rpq.b((ImageView)localObject1, rpn.gn(this.c.mUserUIItem.headUrl), 200, 200, aqhu.F(1), "QQStory200");
    ((ImageView)localObject1).setContentDescription(qem.d(this.c.mUserUIItem));
    localTextView3.setText(qem.d(this.c.mUserUIItem));
    localTextView3.setContentDescription(qem.d(this.c.mUserUIItem));
    localStoryUserBadgeView.setUnionID(this.c.mUserUIItem.getUnionId(), 3);
    if (localStoryUserBadgeView.getVisibility() == 0)
    {
      if (!((Boolean)paramqyd.l("hasExposure")).booleanValue())
      {
        paramqyd.q("hasExposure", new Boolean(true));
        localStoryUserBadgeView.aCG();
      }
      localTextView4.setText(this.c.mUserUIItem.signature);
      localTextView5.setText(rpq.aL(Math.max(this.c.mUserUIItem.fansCount, 0)));
      localTextView6.setText(rpq.aL(Math.max(this.c.mUserUIItem.followCount, 0)));
      if (!this.c.mUserUIItem.isVip()) {
        break label1248;
      }
      localView2.setVisibility(0);
      label782:
      localTextView7.setText(rpq.aL(Math.max(this.c.mUserUIItem.videoCount, 0)));
      if (this.c.mUserUIItem.videoCount >= 0) {
        break label1258;
      }
      localView4.setVisibility(8);
      label825:
      if (this.c.mUserUIItem.isMe())
      {
        localView2.setOnClickListener(this);
        localView3.setOnClickListener(this);
      }
      localView4.setOnClickListener(this);
      ((TextView)localObject3).setOnClickListener(this);
      if (this.bof == 0)
      {
        localObject1 = (FrameLayout.LayoutParams)localView1.getLayoutParams();
        paramViewGroup = (ViewGroup)localObject1;
        if (localObject1 == null) {
          paramViewGroup = new FrameLayout.LayoutParams(-1, -2);
        }
        if (!quc.a(this.c.mUserUIItem)) {
          break label1267;
        }
        this.bof = 1;
        paramViewGroup.height = rpq.dip2px(this.mContentView.getContext(), 254.0F);
        label933:
        localView1.setLayoutParams(paramViewGroup);
      }
      if (this.bof == 1) {
        break label1292;
      }
      ((TextView)localObject3).setVisibility(8);
      label954:
      if ((this.c.mUserUIItem.isMe()) && (this.c.mUserUIItem.fansCountExtra != 0)) {
        break label1339;
      }
      ((RedTouch)localObject2).setVisibility(8);
      label987:
      if (!this.aFz) {
        break label1403;
      }
      paramViewGroup = QQStoryContext.c();
      localObject2 = paramViewGroup.getApplication().getSharedPreferences("public_account_qq_mail_" + paramViewGroup.getCurrentAccountUin(), 0);
      localObject3 = ((SharedPreferences)localObject2).getString("profile_card_qim_online_url", null);
      localObject1 = ((SharedPreferences)localObject2).getString("key_story_qim_online_icon_url", null);
      localObject2 = ((SharedPreferences)localObject2).getString("profile_card_qim_online_wording", null);
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label1393;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText((CharSequence)localObject2);
      paramInt = this.context.getResources().getDimensionPixelSize(2131298493);
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
        anot.a((QQAppInterface)paramViewGroup, "dc00898", "", "", "0X8008640", "0X8008640", 3, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      a(localViewGroup, localProgressBar, localTextView1, localImageView);
      return paramqyd.getItemView();
      localStoryUserBadgeView.setVisibility(8);
      break;
      label1248:
      localView2.setVisibility(8);
      break label782;
      label1258:
      localView4.setVisibility(0);
      break label825;
      label1267:
      this.bof = 2;
      paramViewGroup.height = rpq.dip2px(this.mContentView.getContext(), 220.0F);
      break label933;
      label1292:
      ((TextView)localObject3).setVisibility(0);
      if (this.c.mUserUIItem.isSubscribe())
      {
        ((TextView)localObject3).setText(acfp.m(2131708103));
        break label954;
      }
      ((TextView)localObject3).setText(acfp.m(2131708110));
      break label954;
      label1339:
      paramViewGroup = rpj.a(4, "+" + rpq.aL(this.c.mUserUIItem.fansCountExtra), 0);
      ((RedTouch)localObject2).setVisibility(0);
      ((RedTouch)localObject2).e(paramViewGroup);
      break label987;
      label1393:
      localTextView2.setVisibility(8);
      continue;
      label1403:
      localTextView2.setVisibility(8);
    }
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    this.mContentView = LayoutInflater.from(this.context).inflate(2131561892, paramViewGroup, false);
    paramViewGroup = new qyd(this.mContentView);
    View localView = paramViewGroup.get(2131377021);
    paramViewGroup.q("redTouch", new RedTouch(this.mContentView.getContext(), localView).a(21).c(3).b(5).a());
    paramViewGroup.q("hasExposure", new Boolean(false));
    return paramViewGroup;
  }
  
  protected void bqO()
  {
    this.c.refreshData(true);
  }
  
  public void bqT()
  {
    ram.i("Q.qqstory.memories.MemoriesProfileSegment", "on subscribe button click. ");
    if (this.c.mUserUIItem == null)
    {
      ram.w("Q.qqstory.memories.MemoriesProfileSegment", "current userUIItem is null, %s", new Object[] { this.c.mUid });
      return;
    }
    int j = this.c.mUserUIItem.isSubscribe;
    Object localObject = (pma)qem.getQQAppInterface().getBusinessHandler(98);
    int i;
    if (this.c.mUserUIItem.isVip())
    {
      i = 1;
      ((pma)localObject).b(i, this.c.mUserUIItem.uid, j, 2);
      i = StoryMemoriesFragment.dX(this.mSource);
      if (j != 1) {
        break label169;
      }
      localObject = "2";
      label112:
      if (!this.c.mUserUIItem.isVip()) {
        break label176;
      }
    }
    label169:
    label176:
    for (String str = "1";; str = "2")
    {
      rar.a("memory", "follow_card", i, 0, new String[] { localObject, str, "", "" });
      return;
      i = 0;
      break;
      localObject = "1";
      break label112;
    }
  }
  
  public void bqU()
  {
    String str = QQStoryContext.a().mi();
    if (TextUtils.isEmpty(str))
    {
      ram.e("Q.qqstory.memories.MemoriesProfileSegment", "onGradeSpeedClick, uin is empty");
      return;
    }
    str = String.format("https://story.now.qq.com/m/gaccel/?uin=%s", new Object[] { str });
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.context.startActivity(localIntent);
    int i;
    if (this.c.mUserUIItem.gradeSpeed == 0) {
      i = 1;
    }
    for (;;)
    {
      rar.a("memory", "clk_level", 0, 0, new String[] { String.valueOf(i) });
      return;
      if ((this.c.mUserUIItem.gradeSpeed > 0) && (this.c.mUserUIItem.gradeSpeed < 10)) {
        i = 2;
      } else if (this.c.mUserUIItem.gradeSpeed == 10) {
        i = 3;
      } else {
        i = -1;
      }
    }
  }
  
  public void bqV()
  {
    if (this.c.mUserUIItem.isMe())
    {
      str = "https://ti.qq.com/qqmedal2/index.html?from=8&_nav_alpha=0&_nav_anim=true&_wwv=4&_wv=1&_nav_txtclr=ffffff&_bid=2450&_nav_titleclr=ffffff&openMedalId=22";
      Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.context.startActivity(localIntent);
      if (!this.c.mUserUIItem.isMe()) {
        break label113;
      }
    }
    label113:
    for (String str = "1";; str = "2")
    {
      rar.a("memory", "clk_medal", 0, 0, new String[] { str });
      return;
      str = String.format("https://ti.qq.com/qqmedal2/index.html?from=9&_nav_alpha=0&_nav_anim=true&_wwv=4&_wv=1&_nav_txtclr=ffffff&_bid=2450&_nav_titleclr=ffffff&openMedalId=22&tuin=%s", new Object[] { ajri.encode(this.c.mUserUIItem.qq) });
      break;
    }
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public String getKey()
  {
    return "MemoriesProfileSegment";
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
      bqP();
      continue;
      bqQ();
      continue;
      bqR();
      continue;
      bqS();
      continue;
      bqT();
      continue;
      bqV();
      continue;
      bqU();
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.c.destroy();
  }
  
  protected void onResume()
  {
    if (this.aFy)
    {
      this.aFy = false;
      this.c.refreshData(false);
    }
  }
  
  public void to(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      notifyDataSetChanged(true);
      return;
    }
    notifyDataSetChanged(false);
  }
  
  public void tp(boolean paramBoolean)
  {
    this.aFz = paramBoolean;
    notifyDataSetChanged(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     quj
 * JD-Core Version:    0.7.0.1
 */