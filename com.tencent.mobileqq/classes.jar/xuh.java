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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class xuh
  extends ysg<xpu>
  implements Handler.Callback, IEventReceiver
{
  public static final String KEY = "NewMyStorySegment";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  protected vlc a;
  protected vuq a;
  private xpu jdField_a_of_type_Xpu;
  protected xri a;
  private xsh jdField_a_of_type_Xsh;
  private xsi jdField_a_of_type_Xsi;
  protected xuw a;
  protected xux a;
  protected xuy a;
  public final yqo<xqr> a;
  private yrj jdField_a_of_type_Yrj;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public final yqo<xqq> b;
  private boolean jdField_b_of_type_Boolean;
  public final yqo<xrc> c;
  private boolean c;
  public final yqo<xqn> d = new xup(this);
  
  public xuh(Activity paramActivity, xsi paramxsi)
  {
    super(paramActivity);
    this.jdField_a_of_type_Yqo = new xui(this);
    this.jdField_b_of_type_Yqo = new xun(this);
    this.jdField_c_of_type_Yqo = new xuo(this);
    this.jdField_a_of_type_Vlc = new xur(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Xsi = paramxsi;
    this.jdField_a_of_type_Float = (UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) - UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 145.0F));
    this.jdField_a_of_type_Vuq = ((vuq)vux.a(10));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Xri = new xri(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Xpu = new xpu();
    this.jdField_a_of_type_Xux = new xux(this);
    this.jdField_a_of_type_Xuw = new xuw(this);
    this.jdField_a_of_type_Xuy = new xuy(this);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Vlc);
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(xqc.b(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramStoryVideoItem;
  }
  
  private String a(xpu paramxpu, int paramInt, TextPaint paramTextPaint)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(paramxpu.a(paramInt, paramTextPaint));
    paramxpu = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramxpu;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    wkp.a(paramStoryVideoItem, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (UIUtils.isFastDoubleClick()) {
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (String str1 = "1";; str1 = "2")
    {
      String str2 = "2";
      if ((TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str2 = "1";
      }
      xwa.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
      paramStoryVideoItem = new VidListPlayInfo(this.jdField_a_of_type_Xpu.jdField_a_of_type_Vwa.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
      wmu.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, 2, paramView);
      return;
    }
  }
  
  private void a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Xsh = paramxsh;
    paramViewGroup = (ImageView)paramxsh.a(2131374477);
    TextView localTextView = (TextView)paramxsh.a(2131374433);
    ImageView localImageView1 = (ImageView)paramxsh.a(2131374439);
    ImageView localImageView2 = (ImageView)paramxsh.a(2131374437);
    View localView = paramxsh.a(2131374438);
    this.jdField_a_of_type_Xpu.a();
    paramInt = -657931;
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (bool) {
      paramInt = -15980466;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((vvj)vux.a(2)).a();
    if (this.jdField_a_of_type_Xpu.b() == 0)
    {
      paramViewGroup.setImageResource(2130846745);
      localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
      if (!this.jdField_b_of_type_Boolean) {
        break label335;
      }
      if (!bool) {
        break label324;
      }
      localImageView2.setImageResource(2130846581);
      label170:
      localImageView2.setContentDescription(amtj.a(2131706638));
      if (this.jdField_a_of_type_Xpu.a().size() <= 0) {
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
      paramViewGroup.setOnClickListener(paramxsh);
      paramxsh.a().findViewById(2131374474).setOnClickListener(paramxsh);
      if (paramxsh.jdField_a_of_type_Xqa == null) {
        paramxsh.a(new xuv(this));
      }
      return;
      if ((localQQUserUIItem == null) || (TextUtils.isEmpty(localQQUserUIItem.headUrl)))
      {
        xvv.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
        paramViewGroup.setImageResource(2130846745);
        wcg.d();
        break;
      }
      UIUtils.setCircleViewByURL(paramViewGroup, yql.b(localQQUserUIItem.headUrl), 200, 200, bfvo.a(1), "QQStory200");
      break;
      label324:
      localImageView2.setImageResource(2130846580);
      break label170;
      label335:
      if (bool) {
        localImageView2.setImageResource(2130846579);
      }
      for (;;)
      {
        localImageView2.setContentDescription(amtj.a(2131706629));
        break;
        localImageView2.setImageResource(2130846578);
      }
      label373:
      if (this.jdField_a_of_type_Xpu.b() != 0)
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
  
  private void a(xpu paramxpu, View paramView)
  {
    if (UIUtils.isFastDoubleClick()) {
      return;
    }
    if (paramxpu.d) {}
    for (String str = "1"; paramxpu.b() == 0; str = "2")
    {
      xwa.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_Xsi.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131374477) {
      xwa.a("mystory", "clk_head_data", 0, 0, new String[0]);
    }
    for (;;)
    {
      paramxpu = QQStoryContext.a().b();
      vpl.a(this.jdField_a_of_type_AndroidContentContext, 3, paramxpu);
      return;
      xwa.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (UIUtils.isFastDoubleClick()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131374426);
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
      xwa.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str });
      paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_Xpu.jdField_a_of_type_Vwa.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid), 2);
      wmu.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem.a(), localStoryCoverView.a);
      return;
    }
  }
  
  private void b(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramxsh.a(2131374426);
    ImageView localImageView1 = (ImageView)paramxsh.a(2131374440);
    TextView localTextView1 = (TextView)paramxsh.a(2131374427);
    Object localObject1 = (TextView)paramxsh.a(2131374479);
    ImageView localImageView2 = (ImageView)paramxsh.a(2131374429);
    TextView localTextView2 = (TextView)paramxsh.a(2131374482);
    TextView localTextView3 = (TextView)paramxsh.a(2131374432);
    ImageView localImageView3 = (ImageView)paramxsh.a(2131374425);
    paramViewGroup = (Button)paramxsh.a(2131374478);
    ImageView localImageView4 = (ImageView)paramxsh.a(2131374430);
    if ((this.jdField_a_of_type_Xpu == null) || (this.jdField_a_of_type_Xpu.a() == null))
    {
      xvv.e("NewMyStorySegment", "myStorys is null!");
      return;
    }
    paramxsh.a().setTag(-3, Integer.valueOf(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
    paramViewGroup.setOnClickListener(paramxsh);
    paramViewGroup = (ImageView)paramxsh.a(2131374430);
    Object localObject2 = (ImageView)paramxsh.a(2131374431);
    paramInt = -657931;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      paramInt = -15980466;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ((ImageView)localObject2).setBackgroundColor(paramInt);
    localObject2 = (StoryVideoItem)this.jdField_a_of_type_Xpu.a().get(i);
    xvv.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
    label289:
    boolean bool2;
    if (xqc.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath))
    {
      paramViewGroup = xvs.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);
      bool2 = false;
      UIUtils.setRoundCornerViewByURL(localStoryCoverView.a, paramViewGroup, 106, 170, 5, UIUtils.roundDefaultIcon, "myStory");
      localStoryCoverView.setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      localStoryCoverView.setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      ((TextView)localObject1).setMaxWidth(UIUtils.dip2pxWithoutFontScale(this.jdField_a_of_type_AndroidContentContext, 160.0F));
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
        paramxsh.jdField_b_of_type_Int = i;
        paramxsh.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Xpu;
        localTextView1.setOnClickListener(paramxsh);
        paramxsh.a().setOnClickListener(paramxsh);
        paramxsh.a().setContentDescription(amtj.a(2131706631) + vkm.jdField_a_of_type_JavaLangString + amtj.a(2131706643) + (i + 1) + amtj.a(2131706630));
        localTextView2.setOnClickListener(paramxsh);
        localImageView2.setOnClickListener(paramxsh);
        if (paramxsh.jdField_a_of_type_Xqa != null) {
          break;
        }
        paramxsh.a(new xuk(this, bool1));
        return;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null) {
          xvv.e("NewMyStorySegment", "mVideoThumbnailUrl is null! vid=" + ((StoryVideoItem)localObject2).mVid);
        }
        paramViewGroup = yql.a(((StoryVideoItem)localObject2).mVideoThumbnailUrl);
        break label289;
        localTextView3.setVisibility(0);
        localTextView3.setText(amtj.a(2131706632));
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
          paramInt = voe.a().a(((StoryVideoItem)localObject2).mVid);
          if (paramInt >= 0) {
            localTextView3.setText(amtj.a(2131706633) + paramInt + "%");
          }
          paramViewGroup = new xuj(this, localTextView3);
          localTextView3.setTag(paramViewGroup);
          voe.a().a(((StoryVideoItem)localObject2).mVid, paramViewGroup);
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
          if ((localTextView3.getTag() != null) && ((localTextView3.getTag() instanceof vog))) {
            voe.a().a((vog)localTextView3.getTag());
          }
          localTextView3.setText(2131698863);
        }
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        if (((StoryVideoItem)localObject2).mUpLoadFailedError == 10404) {
          localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131698866));
        }
        ((TextView)localObject1).setVisibility(8);
        localImageView3.setVisibility(8);
        localImageView2.setVisibility(0);
        localTextView3.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView3.setVisibility(0);
        localTextView3.setText(amtj.a(2131706637));
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
      paramViewGroup = ((TroopManager)wkp.a().getManager(52)).b((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.get(0));
      if ((paramViewGroup == null) || (TextUtils.isEmpty(paramViewGroup.getTroopName()))) {
        break label1221;
      }
      paramViewGroup = amtj.a(2131706634) + paramViewGroup.getTroopName();
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
  
  private void b(xsh paramxsh, int paramInt)
  {
    TextView localTextView1 = (TextView)paramxsh.a(2131374427);
    TextView localTextView2 = (TextView)paramxsh.a(2131374479);
    ImageView localImageView = (ImageView)paramxsh.a(2131374429);
    TextView localTextView3 = (TextView)paramxsh.a(2131374482);
    paramxsh = (ImageView)paramxsh.a(2131374425);
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
      paramxsh.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramxsh.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 3: 
    case 6: 
      localTextView1.setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView2.setVisibility(8);
      paramxsh.setVisibility(8);
      localImageView.setVisibility(0);
      return;
    case 9: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramxsh.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    }
    localTextView3.setVisibility(8);
    paramxsh.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  private void c(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramxsh.a(2131369938);
    View localView1 = paramxsh.a(2131369972);
    View localView2 = paramxsh.a(2131369973);
    paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167103);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramxsh.a(2131378500);
    localView1 = paramxsh.a(2131378395);
    paramViewGroup.setOnClickListener(paramxsh);
    localView1.setOnClickListener(paramxsh);
    if (paramxsh.jdField_a_of_type_Xqa == null) {
      paramxsh.a(new xul(this));
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Xpu != null) && (this.jdField_a_of_type_Xpu.a().size() > 0)) {
        return this.jdField_a_of_type_Xpu.a().size() + 2;
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
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    int i = a(paramInt);
    xvv.a("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return paramxsh.a();
      a(paramInt, paramxsh, paramViewGroup);
      continue;
      b(paramInt, paramxsh, paramViewGroup);
      continue;
      c(paramInt, paramxsh, paramViewGroup);
    }
  }
  
  public String a()
  {
    return "NewMyStorySegment";
  }
  
  public xri a()
  {
    return new xri(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = null;
    }
    while (paramViewGroup != null)
    {
      return new xsh(paramViewGroup);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561732, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561733, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561622, paramViewGroup, false);
    }
    return new xsh(new TextView(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_Xpu.a(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131706639), 0).a();
    m();
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_Xpu.a(paramString);
    this.jdField_a_of_type_Xpu.c(paramString);
    if (this.jdField_a_of_type_Xpu.a().size() == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Xpu.jdField_b_of_type_Boolean = false;
    }
    ((xnv)vux.a(12)).a(this.jdField_a_of_type_Xpu.jdField_a_of_type_Vwa.jdField_a_of_type_JavaLangString, 0, paramString);
    m();
  }
  
  protected void a(voc paramvoc)
  {
    xvv.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramvoc);
    Object localObject1 = paramvoc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_Xpu.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      xvv.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_Xpu.a((StoryVideoItem)localObject1);
      if (paramvoc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
        break label268;
      }
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramvoc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    for (;;)
    {
      if (paramvoc.b != null)
      {
        this.jdField_a_of_type_Xpu.a(((StoryVideoItem)localObject1).mVid, paramvoc.b);
        this.jdField_a_of_type_Xpu.jdField_b_of_type_Boolean = paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.mIsContribute;
        if ((!TextUtils.isEmpty(paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)) && (!TextUtils.equals(this.jdField_a_of_type_Xpu.jdField_a_of_type_Vwa.jdField_a_of_type_JavaLangString, paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)))
        {
          xvv.a("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.jdField_a_of_type_Xpu.jdField_a_of_type_Vwa.jdField_a_of_type_JavaLangString, paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
          Object localObject2 = paramvoc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
          localObject1 = new xrl(xqt.a((String)localObject2));
          xrq localxrq = (xrq)this.jdField_b_of_type_Yqo.a();
          localObject2 = new xrk(new xum(this, (String)localObject2));
          xri localxri = a();
          a(new xrq[] { localObject1, localxrq, localObject2 }, localxri);
        }
      }
      if (!paramvoc.jdField_c_of_type_Boolean) {
        break label279;
      }
      a().h();
      return;
      this.jdField_a_of_type_Xpu.b((StoryVideoItem)localObject1);
      break;
      label268:
      xvv.e("NewMyStorySegment", "item error info is null!!");
    }
    label279:
    m();
  }
  
  public void a(xpu paramxpu)
  {
    this.jdField_a_of_type_Xpu = paramxpu;
    xrc.a(this.jdField_a_of_type_Xpu);
    c(true);
  }
  
  public void a(xsh paramxsh, int paramInt)
  {
    a().t();
    if ((this.jdField_a_of_type_Xpu.a().size() > paramInt) && (this.jdField_a_of_type_Xpu.a().get(paramInt) != null))
    {
      localObject = ((StoryVideoItem)this.jdField_a_of_type_Xpu.a().get(paramInt)).mVid;
      if (!StoryVideoItem.isFakeVid((String)localObject)) {
        break label117;
      }
      vns.a((String)localObject);
      m();
      if (!((StoryVideoItem)this.jdField_a_of_type_Xpu.a().get(paramInt)).isUploading()) {
        break label110;
      }
    }
    label110:
    for (paramxsh = "1";; paramxsh = "3")
    {
      xwa.a("mystory", "del_onevideo", 0, 0, new String[] { paramxsh });
      return;
    }
    label117:
    new wbi().a((String)localObject);
    ((StoryVideoItem)this.jdField_a_of_type_Xpu.a().get(paramInt)).mUploadStatus = 9;
    Object localObject = (TextView)paramxsh.a(2131374432);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(amtj.a(2131706641));
    b(paramxsh, 9);
    xwa.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    m();
  }
  
  protected void a(xrq[] paramArrayOfxrq)
  {
    if (this.jdField_a_of_type_Xri != null) {
      this.jdField_a_of_type_Xri.c();
    }
    this.jdField_a_of_type_Xri = new xri(this.jdField_a_of_type_AndroidOsHandler);
    a(paramArrayOfxrq, this.jdField_a_of_type_Xri);
  }
  
  protected void a(xrq[] paramArrayOfxrq, xri paramxri)
  {
    int j = paramArrayOfxrq.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        xrq localxrq = paramArrayOfxrq[i];
        try
        {
          paramxri.a(localxrq);
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
    paramxri.a(new xuu(this)).a(new xut(this));
    paramxri.a();
  }
  
  public void a_(xsh paramxsh)
  {
    super.a_(paramxsh);
    ImageView localImageView1 = (ImageView)paramxsh.a(2131374430);
    ImageView localImageView2 = (ImageView)paramxsh.a(2131374429);
    ImageView localImageView3 = (ImageView)paramxsh.a(2131374425);
    if ((localImageView3 != null) && (localImageView2 != null) && (localImageView1 != null))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localImageView3.setVisibility(8);
    }
    if (this.jdField_a_of_type_Xpu.a().size() > paramxsh.jdField_b_of_type_Int)
    {
      paramxsh = (StoryVideoItem)this.jdField_a_of_type_Xpu.a().get(paramxsh.jdField_b_of_type_Int);
      if (!paramxsh.isUploadSuc()) {
        break label135;
      }
      paramxsh = "2";
    }
    for (;;)
    {
      xwa.a("mystory", "slide_del", 0, 0, new String[] { paramxsh });
      return;
      label135:
      if (paramxsh.isUploadFail()) {
        paramxsh = "3";
      } else if (paramxsh.isUploading()) {
        paramxsh = "1";
      } else {
        paramxsh = "2";
      }
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    a(new xrq[] { (xrq)this.jdField_a_of_type_Yqo.a(), (xrq)this.jdField_b_of_type_Yqo.a(), (xrq)this.jdField_c_of_type_Yqo.a(), (xrq)this.d.a() });
    return true;
  }
  
  public void b_(xsh paramxsh)
  {
    super.b_(paramxsh);
    ((ImageView)paramxsh.a(2131374430)).setVisibility(0);
    if (this.jdField_a_of_type_Xpu.a().size() > paramxsh.jdField_b_of_type_Int) {
      b(paramxsh, ((StoryVideoItem)this.jdField_a_of_type_Xpu.a().get(paramxsh.jdField_b_of_type_Int)).mUploadStatus);
    }
  }
  
  protected void c()
  {
    vli.a().registerSubscriber(this.jdField_a_of_type_Xux);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xuw);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xuy);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((vvj)vux.a(2)).b(QQStoryContext.a().b());
    List localList = ((vuu)vux.a(5)).b(QQStoryContext.a().b());
    this.jdField_a_of_type_Xpu.b();
    xpu localxpu = this.jdField_a_of_type_Xpu;
    if (((Integer)this.jdField_a_of_type_Vuq.b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1)
    {
      bool = true;
      localxpu.jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Xpu.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Xpu.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Vuq.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      }
      this.jdField_a_of_type_Xpu.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Vuq.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Xpu.jdField_a_of_type_Long = ((Integer)this.jdField_a_of_type_Vuq.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Xpu.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_Vuq.b("qqstory_my_newest_video_cover", ""));
      this.jdField_a_of_type_Xpu.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_Vuq.b("qqstory_my_newest_video_vid", ""));
      localxpu = this.jdField_a_of_type_Xpu;
      if (((Integer)this.jdField_a_of_type_Vuq.b("qqstory_my_story_have_contributed", Integer.valueOf(-1))).intValue() != 1) {
        break label471;
      }
    }
    label471:
    for (boolean bool = true;; bool = false)
    {
      localxpu.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Xpu.jdField_a_of_type_Vwa.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Vuq.b("qqstory_key_story_latest_feed_feature_feed_id", ""));
      this.jdField_a_of_type_Xpu.jdField_a_of_type_Vwa.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_Vuq.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Xpu.jdField_a_of_type_Vwa.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Vuq.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Xpu.jdField_a_of_type_Vwa.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Vuq.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(0))).intValue();
      if (localList.size() == 0) {
        xvv.d("NewMyStorySegment", "Story DB have no mystory data!");
      }
      Collections.sort(localList);
      this.jdField_a_of_type_Xpu.a(localList);
      xvv.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_Xpu.a()) });
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
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xux);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xuw);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xuy);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Xri.c();
    if (this.jdField_a_of_type_Yrj != null) {
      this.jdField_a_of_type_Yrj.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Vlc);
  }
  
  protected void e() {}
  
  protected int g_()
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
      a((xpu)paramMessage.obj);
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuh
 * JD-Core Version:    0.7.0.1
 */