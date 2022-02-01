import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.8;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ypb
  extends zpa<yko>
  implements Handler.Callback, IEventReceiver
{
  public static final String KEY = "NewMyStorySegment";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  protected wfi a;
  protected wpf a;
  private yko jdField_a_of_type_Yko;
  protected ymc a;
  private ynb jdField_a_of_type_Ynb;
  private ync jdField_a_of_type_Ync;
  protected ypq a;
  protected ypr a;
  protected yps a;
  public final zmc<yll> a;
  private zod jdField_a_of_type_Zod;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public final zmc<ylk> b;
  private boolean jdField_b_of_type_Boolean;
  public final zmc<ylw> c;
  private boolean c;
  public final zmc<ylh> d = new ypj(this);
  
  public ypb(Activity paramActivity, ync paramync)
  {
    super(paramActivity);
    this.jdField_a_of_type_Zmc = new ypc(this);
    this.jdField_b_of_type_Zmc = new yph(this);
    this.jdField_c_of_type_Zmc = new ypi(this);
    this.jdField_a_of_type_Wfi = new ypl(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Ync = paramync;
    this.jdField_a_of_type_Float = (zlx.a(this.jdField_a_of_type_AndroidContentContext) - zlx.a(this.jdField_a_of_type_AndroidContentContext, 145.0F));
    this.jdField_a_of_type_Wpf = ((wpf)wpm.a(10));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Ymc = new ymc(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Yko = new yko();
    this.jdField_a_of_type_Ypr = new ypr(this);
    this.jdField_a_of_type_Ypq = new ypq(this);
    this.jdField_a_of_type_Yps = new yps(this);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Wfi);
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(ykw.b(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramStoryVideoItem;
  }
  
  private String a(yko paramyko, int paramInt, TextPaint paramTextPaint)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(paramyko.a(paramInt, paramTextPaint));
    paramyko = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramyko;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    xfe.a(paramStoryVideoItem, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (zlx.b()) {
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (String str1 = "1";; str1 = "2")
    {
      String str2 = "2";
      if ((TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str2 = "1";
      }
      yqu.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
      paramStoryVideoItem = new VidListPlayInfo(this.jdField_a_of_type_Yko.jdField_a_of_type_Wqp.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
      xho.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, 2, paramView);
      return;
    }
  }
  
  private void a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Ynb = paramynb;
    paramViewGroup = (ImageView)paramynb.a(2131374572);
    TextView localTextView = (TextView)paramynb.a(2131374528);
    ImageView localImageView1 = (ImageView)paramynb.a(2131374534);
    ImageView localImageView2 = (ImageView)paramynb.a(2131374532);
    View localView = paramynb.a(2131374533);
    this.jdField_a_of_type_Yko.a();
    paramInt = -657931;
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (bool) {
      paramInt = -15980466;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((wpy)wpm.a(2)).a();
    if (this.jdField_a_of_type_Yko.b() == 0)
    {
      paramViewGroup.setImageResource(2130846820);
      localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
      if (!this.jdField_b_of_type_Boolean) {
        break label335;
      }
      if (!bool) {
        break label324;
      }
      localImageView2.setImageResource(2130846656);
      label170:
      localImageView2.setContentDescription(anni.a(2131706301));
      if (this.jdField_a_of_type_Yko.a().size() <= 0) {
        break label373;
      }
      localImageView2.setVisibility(0);
      label200:
      if (!this.jdField_b_of_type_Boolean) {
        break label403;
      }
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(paramynb);
      paramynb.a().findViewById(2131374569).setOnClickListener(paramynb);
      if (paramynb.jdField_a_of_type_Yku == null) {
        paramynb.a(new ypp(this));
      }
      return;
      if ((localQQUserUIItem == null) || (TextUtils.isEmpty(localQQUserUIItem.headUrl)))
      {
        yqp.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
        paramViewGroup.setImageResource(2130846820);
        wwv.d();
        break;
      }
      zlx.b(paramViewGroup, zlu.b(localQQUserUIItem.headUrl), 200, 200, bgmo.a(1), "QQStory200");
      break;
      label324:
      localImageView2.setImageResource(2130846655);
      break label170;
      label335:
      if (bool) {
        localImageView2.setImageResource(2130846654);
      }
      for (;;)
      {
        localImageView2.setContentDescription(anni.a(2131706292));
        break;
        localImageView2.setImageResource(2130846653);
      }
      label373:
      if (this.jdField_a_of_type_Yko.b() != 0)
      {
        localImageView2.setVisibility(8);
        break label200;
      }
      localImageView2.setVisibility(8);
      break label200;
      label403:
      localImageView1.setVisibility(8);
    }
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, ImageView paramImageView)
  {
    paramImageView.setVisibility(4);
  }
  
  private void a(yko paramyko, View paramView)
  {
    if (zlx.b()) {
      return;
    }
    if (paramyko.d) {}
    for (String str = "1"; paramyko.b() == 0; str = "2")
    {
      yqu.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_Ync.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131374572) {
      yqu.a("mystory", "clk_head_data", 0, 0, new String[0]);
    }
    for (;;)
    {
      paramyko = QQStoryContext.a().b();
      wjz.a(this.jdField_a_of_type_AndroidContentContext, 3, paramyko);
      return;
      yqu.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (zlx.b()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131374521);
    if (paramStoryVideoItem.mUnreadLikeCount > 0)
    {
      a(paramInt, paramStoryVideoItem, localStoryCoverView.a);
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (paramView = "1";; paramView = "2")
    {
      String str = "2";
      if ((!TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (!TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str = "1";
      }
      yqu.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str });
      paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_Yko.jdField_a_of_type_Wqp.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid), 2);
      xho.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem.a(), localStoryCoverView.a);
      return;
    }
  }
  
  private void b(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramynb.a(2131374521);
    ImageView localImageView1 = (ImageView)paramynb.a(2131374535);
    TextView localTextView1 = (TextView)paramynb.a(2131374522);
    Object localObject1 = (TextView)paramynb.a(2131374574);
    ImageView localImageView2 = (ImageView)paramynb.a(2131374524);
    TextView localTextView2 = (TextView)paramynb.a(2131374577);
    TextView localTextView3 = (TextView)paramynb.a(2131374527);
    ImageView localImageView3 = (ImageView)paramynb.a(2131374520);
    paramViewGroup = (Button)paramynb.a(2131374573);
    ImageView localImageView4 = (ImageView)paramynb.a(2131374525);
    if ((this.jdField_a_of_type_Yko == null) || (this.jdField_a_of_type_Yko.a() == null))
    {
      yqp.e("NewMyStorySegment", "myStorys is null!");
      return;
    }
    paramynb.a().setTag(-3, Integer.valueOf(zlx.a(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
    paramViewGroup.setOnClickListener(paramynb);
    paramViewGroup = (ImageView)paramynb.a(2131374525);
    Object localObject2 = (ImageView)paramynb.a(2131374526);
    paramInt = -657931;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      paramInt = -15980466;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ((ImageView)localObject2).setBackgroundColor(paramInt);
    localObject2 = (StoryVideoItem)this.jdField_a_of_type_Yko.a().get(i);
    yqp.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
    label289:
    boolean bool2;
    if (ykw.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath))
    {
      paramViewGroup = yqm.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);
      bool2 = false;
      zlx.a(localStoryCoverView.a, paramViewGroup, 106, 170, 5, zlx.b, "myStory");
      localStoryCoverView.setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      localStoryCoverView.setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      ((TextView)localObject1).setMaxWidth(zlx.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
      localImageView4.setVisibility(0);
      bool1 = bool2;
    }
    switch (((StoryVideoItem)localObject2).mUploadStatus)
    {
    default: 
      bool1 = bool2;
    case 7: 
    case 8: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 3: 
    case 6: 
    case 9: 
      for (;;)
      {
        a((StoryVideoItem)localObject2, localImageView1);
        if ((((StoryVideoItem)localObject2).mViewTotalTime <= 0L) && (!bool1)) {
          break label1212;
        }
        localTextView1.setEnabled(true);
        label461:
        paramynb.jdField_b_of_type_Int = i;
        paramynb.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Yko;
        localTextView1.setOnClickListener(paramynb);
        paramynb.a().setOnClickListener(paramynb);
        paramynb.a().setContentDescription(anni.a(2131706294) + wes.jdField_a_of_type_JavaLangString + anni.a(2131706306) + (i + 1) + anni.a(2131706293));
        localTextView2.setOnClickListener(paramynb);
        localImageView2.setOnClickListener(paramynb);
        if (paramynb.jdField_a_of_type_Yku != null) {
          break;
        }
        paramynb.a(new ype(this, bool1));
        return;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null) {
          yqp.e("NewMyStorySegment", "mVideoThumbnailUrl is null! vid=" + ((StoryVideoItem)localObject2).mVid);
        }
        paramViewGroup = zlu.a(((StoryVideoItem)localObject2).mVideoThumbnailUrl);
        break label289;
        localTextView3.setVisibility(0);
        localTextView3.setText(anni.a(2131706295));
        localTextView1.setVisibility(8);
        ((TextView)localObject1).setVisibility(8);
        localTextView2.setVisibility(8);
        localImageView3.setVisibility(0);
        localImageView2.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView3.setVisibility(0);
        if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid))
        {
          paramInt = wik.a().a(((StoryVideoItem)localObject2).mVid);
          if (paramInt >= 0) {
            localTextView3.setText(anni.a(2131706296) + paramInt + "%");
          }
          paramViewGroup = new ypd(this, localTextView3);
          localTextView3.setTag(paramViewGroup);
          wik.a().a(((StoryVideoItem)localObject2).mVid, paramViewGroup);
        }
        for (;;)
        {
          localTextView1.setVisibility(8);
          ((TextView)localObject1).setVisibility(8);
          localTextView2.setVisibility(8);
          localImageView3.setVisibility(0);
          localImageView2.setVisibility(8);
          bool1 = bool2;
          break;
          if ((localTextView3.getTag() != null) && ((localTextView3.getTag() instanceof wim))) {
            wik.a().a((wim)localTextView3.getTag());
          }
          localTextView3.setText(2131698521);
        }
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        if (((StoryVideoItem)localObject2).mUpLoadFailedError == 10404) {
          localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131698524));
        }
        ((TextView)localObject1).setVisibility(8);
        localImageView3.setVisibility(8);
        localImageView2.setVisibility(0);
        localTextView3.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView3.setVisibility(0);
        localTextView3.setText(anni.a(2131706300));
        localTextView1.setVisibility(8);
        ((TextView)localObject1).setVisibility(8);
        localTextView2.setVisibility(8);
        localImageView3.setVisibility(0);
        localImageView2.setVisibility(8);
        bool1 = bool2;
      }
    }
    localTextView3.setVisibility(8);
    if (!TextUtils.isEmpty(((StoryVideoItem)localObject2).mDoodleText))
    {
      ((TextView)localObject1).setText(((StoryVideoItem)localObject2).mDoodleText);
      ((TextView)localObject1).setVisibility(0);
      label1036:
      localTextView2.setVisibility(8);
      localImageView3.setVisibility(0);
      localImageView2.setVisibility(8);
      if ((((StoryVideoItem)localObject2).mVideoSpreadGroupList == null) || (((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_Int != 4) || (((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.isEmpty())) {
        break label1221;
      }
      paramViewGroup = ((TroopManager)xfe.a().getManager(52)).b((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.get(0));
      if ((paramViewGroup == null) || (TextUtils.isEmpty(paramViewGroup.getTroopName()))) {
        break label1221;
      }
      paramViewGroup = anni.a(2131706297) + paramViewGroup.getTroopName();
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup)) {
        localObject1 = a((StoryVideoItem)localObject2);
      }
      localTextView1.setText((CharSequence)localObject1);
      localTextView1.setVisibility(0);
      break;
      ((TextView)localObject1).setVisibility(8);
      break label1036;
      label1212:
      localTextView1.setEnabled(false);
      break label461;
      label1221:
      paramViewGroup = "";
    }
  }
  
  private void b(ynb paramynb, int paramInt)
  {
    TextView localTextView1 = (TextView)paramynb.a(2131374522);
    TextView localTextView2 = (TextView)paramynb.a(2131374574);
    ImageView localImageView = (ImageView)paramynb.a(2131374524);
    TextView localTextView3 = (TextView)paramynb.a(2131374577);
    paramynb = (ImageView)paramynb.a(2131374520);
    switch (paramInt)
    {
    case 7: 
    case 8: 
    default: 
      return;
    case 0: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramynb.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramynb.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 3: 
    case 6: 
      localTextView1.setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView2.setVisibility(8);
      paramynb.setVisibility(8);
      localImageView.setVisibility(0);
      return;
    case 9: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramynb.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    }
    localTextView3.setVisibility(8);
    paramynb.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  private void c(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramynb.a(2131369846);
    View localView1 = paramynb.a(2131369881);
    View localView2 = paramynb.a(2131369882);
    paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167071);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramynb.a(2131378576);
    localView1 = paramynb.a(2131378473);
    paramViewGroup.setOnClickListener(paramynb);
    localView1.setOnClickListener(paramynb);
    if (paramynb.jdField_a_of_type_Yku == null) {
      paramynb.a(new ypf(this));
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Yko != null) && (this.jdField_a_of_type_Yko.a().size() > 0)) {
        return this.jdField_a_of_type_Yko.a().size() + 2;
      }
      return 1;
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == a() - 1) {
      return 2;
    }
    return 1;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    int i = a(paramInt);
    yqp.a("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return paramynb.a();
      a(paramInt, paramynb, paramViewGroup);
      continue;
      b(paramInt, paramynb, paramViewGroup);
      continue;
      c(paramInt, paramynb, paramViewGroup);
    }
  }
  
  public String a()
  {
    return "NewMyStorySegment";
  }
  
  public ymc a()
  {
    return new ymc(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = null;
    }
    while (paramViewGroup != null)
    {
      return new ynb(paramViewGroup);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561813, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561814, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561703, paramViewGroup, false);
    }
    return new ynb(new TextView(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_Yko.a(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    QQToast.a(BaseApplication.getContext(), 1, anni.a(2131706302), 0).a();
    m();
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_Yko.a(paramString);
    this.jdField_a_of_type_Yko.c(paramString);
    if (this.jdField_a_of_type_Yko.a().size() == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Yko.jdField_b_of_type_Boolean = false;
    }
    ((yip)wpm.a(12)).a(this.jdField_a_of_type_Yko.jdField_a_of_type_Wqp.jdField_a_of_type_JavaLangString, 0, paramString);
    m();
  }
  
  protected void a(wii paramwii)
  {
    yqp.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramwii);
    Object localObject1 = paramwii.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_Yko.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      yqp.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_Yko.a((StoryVideoItem)localObject1);
      if (paramwii.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
        break label268;
      }
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramwii.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    for (;;)
    {
      if (paramwii.b != null)
      {
        this.jdField_a_of_type_Yko.a(((StoryVideoItem)localObject1).mVid, paramwii.b);
        this.jdField_a_of_type_Yko.jdField_b_of_type_Boolean = paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.mIsContribute;
        if ((!TextUtils.isEmpty(paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)) && (!TextUtils.equals(this.jdField_a_of_type_Yko.jdField_a_of_type_Wqp.jdField_a_of_type_JavaLangString, paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)))
        {
          yqp.a("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.jdField_a_of_type_Yko.jdField_a_of_type_Wqp.jdField_a_of_type_JavaLangString, paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
          Object localObject2 = paramwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
          localObject1 = new ymf(yln.a((String)localObject2));
          ymk localymk = (ymk)this.jdField_b_of_type_Zmc.a();
          localObject2 = new yme(new ypg(this, (String)localObject2));
          ymc localymc = a();
          a(new ymk[] { localObject1, localymk, localObject2 }, localymc);
        }
      }
      if (!paramwii.jdField_c_of_type_Boolean) {
        break label279;
      }
      a().h();
      return;
      this.jdField_a_of_type_Yko.b((StoryVideoItem)localObject1);
      break;
      label268:
      yqp.e("NewMyStorySegment", "item error info is null!!");
    }
    label279:
    m();
  }
  
  public void a(yko paramyko)
  {
    this.jdField_a_of_type_Yko = paramyko;
    ylw.a(this.jdField_a_of_type_Yko);
    c(true);
  }
  
  public void a(ynb paramynb, int paramInt)
  {
    a().t();
    if ((this.jdField_a_of_type_Yko.a().size() > paramInt) && (this.jdField_a_of_type_Yko.a().get(paramInt) != null))
    {
      localObject = ((StoryVideoItem)this.jdField_a_of_type_Yko.a().get(paramInt)).mVid;
      if (!StoryVideoItem.isFakeVid((String)localObject)) {
        break label117;
      }
      why.a((String)localObject);
      m();
      if (!((StoryVideoItem)this.jdField_a_of_type_Yko.a().get(paramInt)).isUploading()) {
        break label110;
      }
    }
    label110:
    for (paramynb = "1";; paramynb = "3")
    {
      yqu.a("mystory", "del_onevideo", 0, 0, new String[] { paramynb });
      return;
    }
    label117:
    new wvx().a((String)localObject);
    ((StoryVideoItem)this.jdField_a_of_type_Yko.a().get(paramInt)).mUploadStatus = 9;
    Object localObject = (TextView)paramynb.a(2131374527);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(anni.a(2131706304));
    b(paramynb, 9);
    yqu.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    m();
  }
  
  protected void a(ymk[] paramArrayOfymk)
  {
    if (this.jdField_a_of_type_Ymc != null) {
      this.jdField_a_of_type_Ymc.c();
    }
    this.jdField_a_of_type_Ymc = new ymc(this.jdField_a_of_type_AndroidOsHandler);
    a(paramArrayOfymk, this.jdField_a_of_type_Ymc);
  }
  
  protected void a(ymk[] paramArrayOfymk, ymc paramymc)
  {
    int j = paramArrayOfymk.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        ymk localymk = paramArrayOfymk[i];
        try
        {
          paramymc.a(localymk);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    paramymc.a(new ypo(this)).a(new ypn(this));
    paramymc.a();
  }
  
  public void a_(ynb paramynb)
  {
    super.a_(paramynb);
    ImageView localImageView1 = (ImageView)paramynb.a(2131374525);
    ImageView localImageView2 = (ImageView)paramynb.a(2131374524);
    ImageView localImageView3 = (ImageView)paramynb.a(2131374520);
    if ((localImageView3 != null) && (localImageView2 != null) && (localImageView1 != null))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localImageView3.setVisibility(8);
    }
    if (this.jdField_a_of_type_Yko.a().size() > paramynb.jdField_b_of_type_Int)
    {
      paramynb = (StoryVideoItem)this.jdField_a_of_type_Yko.a().get(paramynb.jdField_b_of_type_Int);
      if (!paramynb.isUploadSuc()) {
        break label135;
      }
      paramynb = "2";
    }
    for (;;)
    {
      yqu.a("mystory", "slide_del", 0, 0, new String[] { paramynb });
      return;
      label135:
      if (paramynb.isUploadFail()) {
        paramynb = "3";
      } else if (paramynb.isUploading()) {
        paramynb = "1";
      } else {
        paramynb = "2";
      }
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    a(new ymk[] { (ymk)this.jdField_a_of_type_Zmc.a(), (ymk)this.jdField_b_of_type_Zmc.a(), (ymk)this.jdField_c_of_type_Zmc.a(), (ymk)this.d.a() });
    return true;
  }
  
  public void b_(ynb paramynb)
  {
    super.b_(paramynb);
    ((ImageView)paramynb.a(2131374525)).setVisibility(0);
    if (this.jdField_a_of_type_Yko.a().size() > paramynb.jdField_b_of_type_Int) {
      b(paramynb, ((StoryVideoItem)this.jdField_a_of_type_Yko.a().get(paramynb.jdField_b_of_type_Int)).mUploadStatus);
    }
  }
  
  protected void c()
  {
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ypr);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ypq);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yps);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wpy)wpm.a(2)).b(QQStoryContext.a().b());
    List localList = ((wpj)wpm.a(5)).b(QQStoryContext.a().b());
    this.jdField_a_of_type_Yko.b();
    yko localyko = this.jdField_a_of_type_Yko;
    if (((Integer)this.jdField_a_of_type_Wpf.b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1)
    {
      bool = true;
      localyko.jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Yko.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Yko.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Wpf.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      }
      this.jdField_a_of_type_Yko.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Wpf.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yko.jdField_a_of_type_Long = ((Integer)this.jdField_a_of_type_Wpf.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yko.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_Wpf.b("qqstory_my_newest_video_cover", ""));
      this.jdField_a_of_type_Yko.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_Wpf.b("qqstory_my_newest_video_vid", ""));
      localyko = this.jdField_a_of_type_Yko;
      if (((Integer)this.jdField_a_of_type_Wpf.b("qqstory_my_story_have_contributed", Integer.valueOf(-1))).intValue() != 1) {
        break label471;
      }
    }
    label471:
    for (boolean bool = true;; bool = false)
    {
      localyko.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Yko.jdField_a_of_type_Wqp.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Wpf.b("qqstory_key_story_latest_feed_feature_feed_id", ""));
      this.jdField_a_of_type_Yko.jdField_a_of_type_Wqp.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_Wpf.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yko.jdField_a_of_type_Wqp.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Wpf.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yko.jdField_a_of_type_Wqp.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Wpf.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(0))).intValue();
      if (localList.size() == 0) {
        yqp.d("NewMyStorySegment", "Story DB have no mystory data!");
      }
      Collections.sort(localList);
      this.jdField_a_of_type_Yko.a(localList);
      yqp.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_Yko.a()) });
      this.jdField_c_of_type_Boolean = true;
      return;
      bool = false;
      break;
    }
  }
  
  protected void d()
  {
    super.d();
    this.jdField_c_of_type_Boolean = false;
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ypr);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ypq);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yps);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Ymc.c();
    if (this.jdField_a_of_type_Zod != null) {
      this.jdField_a_of_type_Zod.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Wfi);
  }
  
  protected void e() {}
  
  protected int h_()
  {
    return 3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a((yko)paramMessage.obj);
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypb
 * JD-Core Version:    0.7.0.1
 */