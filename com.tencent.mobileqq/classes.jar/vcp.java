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
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class vcp
  extends wco<uyc>
  implements Handler.Callback, IEventReceiver
{
  public static final String KEY = "NewMyStorySegment";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  protected ssv a;
  protected tcs a;
  private uyc jdField_a_of_type_Uyc;
  protected uzq a;
  private vap jdField_a_of_type_Vap;
  private vaq jdField_a_of_type_Vaq;
  protected vde a;
  protected vdf a;
  protected vdg a;
  public final vzq<uyz> a;
  private wbr jdField_a_of_type_Wbr;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public final vzq<uyy> b;
  private boolean jdField_b_of_type_Boolean;
  public final vzq<uzk> c;
  private boolean c;
  public final vzq<uyv> d = new vcx(this);
  
  public vcp(Activity paramActivity, vaq paramvaq)
  {
    super(paramActivity);
    this.jdField_a_of_type_Vzq = new vcq(this);
    this.jdField_b_of_type_Vzq = new vcv(this);
    this.jdField_c_of_type_Vzq = new vcw(this);
    this.jdField_a_of_type_Ssv = new vcz(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Vaq = paramvaq;
    this.jdField_a_of_type_Float = (vzl.a(this.jdField_a_of_type_AndroidContentContext) - vzl.a(this.jdField_a_of_type_AndroidContentContext, 145.0F));
    this.jdField_a_of_type_Tcs = ((tcs)tcz.a(10));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Uzq = new uzq(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Uyc = new uyc();
    this.jdField_a_of_type_Vdf = new vdf(this);
    this.jdField_a_of_type_Vde = new vde(this);
    this.jdField_a_of_type_Vdg = new vdg(this);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Ssv);
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(uyk.b(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramStoryVideoItem;
  }
  
  private String a(uyc paramuyc, int paramInt, TextPaint paramTextPaint)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(paramuyc.a(paramInt, paramTextPaint));
    paramuyc = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramuyc;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    tsr.a(paramStoryVideoItem, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (vzl.b()) {
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (String str1 = "1";; str1 = "2")
    {
      String str2 = "2";
      if ((TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str2 = "1";
      }
      vei.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
      paramStoryVideoItem = new VidListPlayInfo(this.jdField_a_of_type_Uyc.jdField_a_of_type_Tec.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
      tvc.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, 2, paramView);
      return;
    }
  }
  
  private void a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vap = paramvap;
    paramViewGroup = (ImageView)paramvap.a(2131373370);
    TextView localTextView = (TextView)paramvap.a(2131373326);
    ImageView localImageView1 = (ImageView)paramvap.a(2131373332);
    ImageView localImageView2 = (ImageView)paramvap.a(2131373330);
    View localView = paramvap.a(2131373331);
    this.jdField_a_of_type_Uyc.a();
    paramInt = -657931;
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (bool) {
      paramInt = -15980466;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((tdl)tcz.a(2)).a();
    if (this.jdField_a_of_type_Uyc.b() == 0)
    {
      paramViewGroup.setImageResource(2130845930);
      localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
      if (!this.jdField_b_of_type_Boolean) {
        break label335;
      }
      if (!bool) {
        break label324;
      }
      localImageView2.setImageResource(2130845765);
      label170:
      localImageView2.setContentDescription(ajya.a(2131707526));
      if (this.jdField_a_of_type_Uyc.a().size() <= 0) {
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
      paramViewGroup.setOnClickListener(paramvap);
      paramvap.a().findViewById(2131373367).setOnClickListener(paramvap);
      if (paramvap.jdField_a_of_type_Uyi == null) {
        paramvap.a(new vdd(this));
      }
      return;
      if ((localQQUserUIItem == null) || (TextUtils.isEmpty(localQQUserUIItem.headUrl)))
      {
        ved.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
        paramViewGroup.setImageResource(2130845930);
        tki.d();
        break;
      }
      vzl.b(paramViewGroup, vzi.b(localQQUserUIItem.headUrl), 200, 200, bbef.a(1), "QQStory200");
      break;
      label324:
      localImageView2.setImageResource(2130845764);
      break label170;
      label335:
      if (bool) {
        localImageView2.setImageResource(2130845763);
      }
      for (;;)
      {
        localImageView2.setContentDescription(ajya.a(2131707517));
        break;
        localImageView2.setImageResource(2130845762);
      }
      label373:
      if (this.jdField_a_of_type_Uyc.b() != 0)
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
  
  private void a(uyc paramuyc, View paramView)
  {
    if (vzl.b()) {
      return;
    }
    if (paramuyc.d) {}
    for (String str = "1"; paramuyc.b() == 0; str = "2")
    {
      vei.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_Vaq.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131373370) {
      vei.a("mystory", "clk_head_data", 0, 0, new String[0]);
    }
    for (;;)
    {
      paramuyc = QQStoryContext.a().b();
      sxm.a(this.jdField_a_of_type_AndroidContentContext, 3, paramuyc);
      return;
      vei.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (vzl.b()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131373319);
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
      vei.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str });
      paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_Uyc.jdField_a_of_type_Tec.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid), 2);
      tvc.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem.a(), localStoryCoverView.a);
      return;
    }
  }
  
  private void b(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramvap.a(2131373319);
    ImageView localImageView1 = (ImageView)paramvap.a(2131373333);
    TextView localTextView1 = (TextView)paramvap.a(2131373320);
    Object localObject1 = (TextView)paramvap.a(2131373372);
    ImageView localImageView2 = (ImageView)paramvap.a(2131373322);
    TextView localTextView2 = (TextView)paramvap.a(2131373375);
    TextView localTextView3 = (TextView)paramvap.a(2131373325);
    ImageView localImageView3 = (ImageView)paramvap.a(2131373318);
    paramViewGroup = (Button)paramvap.a(2131373371);
    ImageView localImageView4 = (ImageView)paramvap.a(2131373323);
    if ((this.jdField_a_of_type_Uyc == null) || (this.jdField_a_of_type_Uyc.a() == null))
    {
      ved.e("NewMyStorySegment", "myStorys is null!");
      return;
    }
    paramvap.a().setTag(-3, Integer.valueOf(vzl.a(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
    paramViewGroup.setOnClickListener(paramvap);
    paramViewGroup = (ImageView)paramvap.a(2131373323);
    Object localObject2 = (ImageView)paramvap.a(2131373324);
    paramInt = -657931;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      paramInt = -15980466;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ((ImageView)localObject2).setBackgroundColor(paramInt);
    localObject2 = (StoryVideoItem)this.jdField_a_of_type_Uyc.a().get(i);
    ved.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
    label289:
    boolean bool2;
    if (uyk.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath))
    {
      paramViewGroup = vea.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);
      bool2 = false;
      vzl.a(localStoryCoverView.a, paramViewGroup, 106, 170, 5, vzl.b, "myStory");
      localStoryCoverView.setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      localStoryCoverView.setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      ((TextView)localObject1).setMaxWidth(vzl.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
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
        paramvap.jdField_b_of_type_Int = i;
        paramvap.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Uyc;
        localTextView1.setOnClickListener(paramvap);
        paramvap.a().setOnClickListener(paramvap);
        paramvap.a().setContentDescription(ajya.a(2131707519) + ssf.jdField_a_of_type_JavaLangString + ajya.a(2131707531) + (i + 1) + ajya.a(2131707518));
        localTextView2.setOnClickListener(paramvap);
        localImageView2.setOnClickListener(paramvap);
        if (paramvap.jdField_a_of_type_Uyi != null) {
          break;
        }
        paramvap.a(new vcs(this, bool1));
        return;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null) {
          ved.e("NewMyStorySegment", "mVideoThumbnailUrl is null! vid=" + ((StoryVideoItem)localObject2).mVid);
        }
        paramViewGroup = vzi.a(((StoryVideoItem)localObject2).mVideoThumbnailUrl);
        break label289;
        localTextView3.setVisibility(0);
        localTextView3.setText(ajya.a(2131707520));
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
          paramInt = svx.a().a(((StoryVideoItem)localObject2).mVid);
          if (paramInt >= 0) {
            localTextView3.setText(ajya.a(2131707521) + paramInt + "%");
          }
          paramViewGroup = new vcr(this, localTextView3);
          localTextView3.setTag(paramViewGroup);
          svx.a().a(((StoryVideoItem)localObject2).mVid, paramViewGroup);
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
          if ((localTextView3.getTag() != null) && ((localTextView3.getTag() instanceof svz))) {
            svx.a().a((svz)localTextView3.getTag());
          }
          localTextView3.setText(2131699714);
        }
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        if (((StoryVideoItem)localObject2).mUpLoadFailedError == 10404) {
          localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131699717));
        }
        ((TextView)localObject1).setVisibility(8);
        localImageView3.setVisibility(8);
        localImageView2.setVisibility(0);
        localTextView3.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView3.setVisibility(0);
        localTextView3.setText(ajya.a(2131707525));
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
      paramViewGroup = ((TroopManager)tsr.a().getManager(52)).b((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.get(0));
      if ((paramViewGroup == null) || (TextUtils.isEmpty(paramViewGroup.getTroopName()))) {
        break label1221;
      }
      paramViewGroup = ajya.a(2131707522) + paramViewGroup.getTroopName();
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
  
  private void b(vap paramvap, int paramInt)
  {
    TextView localTextView1 = (TextView)paramvap.a(2131373320);
    TextView localTextView2 = (TextView)paramvap.a(2131373372);
    ImageView localImageView = (ImageView)paramvap.a(2131373322);
    TextView localTextView3 = (TextView)paramvap.a(2131373375);
    paramvap = (ImageView)paramvap.a(2131373318);
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
      paramvap.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramvap.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 3: 
    case 6: 
      localTextView1.setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView2.setVisibility(8);
      paramvap.setVisibility(8);
      localImageView.setVisibility(0);
      return;
    case 9: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramvap.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    }
    localTextView3.setVisibility(8);
    paramvap.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  private void c(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramvap.a(2131369200);
    View localView1 = paramvap.a(2131369235);
    View localView2 = paramvap.a(2131369236);
    paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166938);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramvap.a(2131377161);
    localView1 = paramvap.a(2131377059);
    paramViewGroup.setOnClickListener(paramvap);
    localView1.setOnClickListener(paramvap);
    if (paramvap.jdField_a_of_type_Uyi == null) {
      paramvap.a(new vct(this));
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Uyc != null) && (this.jdField_a_of_type_Uyc.a().size() > 0)) {
        return this.jdField_a_of_type_Uyc.a().size() + 2;
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
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    int i = a(paramInt);
    ved.a("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return paramvap.a();
      a(paramInt, paramvap, paramViewGroup);
      continue;
      b(paramInt, paramvap, paramViewGroup);
      continue;
      c(paramInt, paramvap, paramViewGroup);
    }
  }
  
  public String a()
  {
    return "NewMyStorySegment";
  }
  
  public uzq a()
  {
    return new uzq(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = null;
    }
    while (paramViewGroup != null)
    {
      return new vap(paramViewGroup);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561370, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561371, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561260, paramViewGroup, false);
    }
    return new vap(new TextView(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_Uyc.a(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    bcql.a(BaseApplication.getContext(), 1, ajya.a(2131707527), 0).a();
    m();
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_Uyc.a(paramString);
    this.jdField_a_of_type_Uyc.c(paramString);
    if (this.jdField_a_of_type_Uyc.a().size() == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Uyc.jdField_b_of_type_Boolean = false;
    }
    ((uwd)tcz.a(12)).a(this.jdField_a_of_type_Uyc.jdField_a_of_type_Tec.jdField_a_of_type_JavaLangString, 0, paramString);
    m();
  }
  
  protected void a(svv paramsvv)
  {
    ved.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramsvv);
    Object localObject1 = paramsvv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_Uyc.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      ved.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_Uyc.a((StoryVideoItem)localObject1);
      if (paramsvv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
        break label268;
      }
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramsvv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    for (;;)
    {
      if (paramsvv.b != null)
      {
        this.jdField_a_of_type_Uyc.a(((StoryVideoItem)localObject1).mVid, paramsvv.b);
        this.jdField_a_of_type_Uyc.jdField_b_of_type_Boolean = paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.mIsContribute;
        if ((!TextUtils.isEmpty(paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)) && (!TextUtils.equals(this.jdField_a_of_type_Uyc.jdField_a_of_type_Tec.jdField_a_of_type_JavaLangString, paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)))
        {
          ved.a("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.jdField_a_of_type_Uyc.jdField_a_of_type_Tec.jdField_a_of_type_JavaLangString, paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
          Object localObject2 = paramsvv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
          localObject1 = new uzt(uzb.a((String)localObject2));
          uzy localuzy = (uzy)this.jdField_b_of_type_Vzq.a();
          localObject2 = new uzs(new vcu(this, (String)localObject2));
          uzq localuzq = a();
          a(new uzy[] { localObject1, localuzy, localObject2 }, localuzq);
        }
      }
      if (!paramsvv.jdField_c_of_type_Boolean) {
        break label279;
      }
      a().h();
      return;
      this.jdField_a_of_type_Uyc.b((StoryVideoItem)localObject1);
      break;
      label268:
      ved.e("NewMyStorySegment", "item error info is null!!");
    }
    label279:
    m();
  }
  
  public void a(uyc paramuyc)
  {
    this.jdField_a_of_type_Uyc = paramuyc;
    uzk.a(this.jdField_a_of_type_Uyc);
    c(true);
  }
  
  public void a(vap paramvap, int paramInt)
  {
    a().t();
    if ((this.jdField_a_of_type_Uyc.a().size() > paramInt) && (this.jdField_a_of_type_Uyc.a().get(paramInt) != null))
    {
      localObject = ((StoryVideoItem)this.jdField_a_of_type_Uyc.a().get(paramInt)).mVid;
      if (!StoryVideoItem.isFakeVid((String)localObject)) {
        break label117;
      }
      svl.a((String)localObject);
      m();
      if (!((StoryVideoItem)this.jdField_a_of_type_Uyc.a().get(paramInt)).isUploading()) {
        break label110;
      }
    }
    label110:
    for (paramvap = "1";; paramvap = "3")
    {
      vei.a("mystory", "del_onevideo", 0, 0, new String[] { paramvap });
      return;
    }
    label117:
    new tjk().a((String)localObject);
    ((StoryVideoItem)this.jdField_a_of_type_Uyc.a().get(paramInt)).mUploadStatus = 9;
    Object localObject = (TextView)paramvap.a(2131373325);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(ajya.a(2131707529));
    b(paramvap, 9);
    vei.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    m();
  }
  
  protected void a(uzy[] paramArrayOfuzy)
  {
    if (this.jdField_a_of_type_Uzq != null) {
      this.jdField_a_of_type_Uzq.c();
    }
    this.jdField_a_of_type_Uzq = new uzq(this.jdField_a_of_type_AndroidOsHandler);
    a(paramArrayOfuzy, this.jdField_a_of_type_Uzq);
  }
  
  protected void a(uzy[] paramArrayOfuzy, uzq paramuzq)
  {
    int j = paramArrayOfuzy.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        uzy localuzy = paramArrayOfuzy[i];
        try
        {
          paramuzq.a(localuzy);
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
    paramuzq.a(new vdc(this)).a(new vdb(this));
    paramuzq.a();
  }
  
  public void a_(vap paramvap)
  {
    super.a_(paramvap);
    ImageView localImageView1 = (ImageView)paramvap.a(2131373323);
    ImageView localImageView2 = (ImageView)paramvap.a(2131373322);
    ImageView localImageView3 = (ImageView)paramvap.a(2131373318);
    if ((localImageView3 != null) && (localImageView2 != null) && (localImageView1 != null))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localImageView3.setVisibility(8);
    }
    if (this.jdField_a_of_type_Uyc.a().size() > paramvap.jdField_b_of_type_Int)
    {
      paramvap = (StoryVideoItem)this.jdField_a_of_type_Uyc.a().get(paramvap.jdField_b_of_type_Int);
      if (!paramvap.isUploadSuc()) {
        break label135;
      }
      paramvap = "2";
    }
    for (;;)
    {
      vei.a("mystory", "slide_del", 0, 0, new String[] { paramvap });
      return;
      label135:
      if (paramvap.isUploadFail()) {
        paramvap = "3";
      } else if (paramvap.isUploading()) {
        paramvap = "1";
      } else {
        paramvap = "2";
      }
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    a(new uzy[] { (uzy)this.jdField_a_of_type_Vzq.a(), (uzy)this.jdField_b_of_type_Vzq.a(), (uzy)this.jdField_c_of_type_Vzq.a(), (uzy)this.d.a() });
    return true;
  }
  
  public void b_(vap paramvap)
  {
    super.b_(paramvap);
    ((ImageView)paramvap.a(2131373323)).setVisibility(0);
    if (this.jdField_a_of_type_Uyc.a().size() > paramvap.jdField_b_of_type_Int) {
      b(paramvap, ((StoryVideoItem)this.jdField_a_of_type_Uyc.a().get(paramvap.jdField_b_of_type_Int)).mUploadStatus);
    }
  }
  
  protected void c()
  {
    stb.a().registerSubscriber(this.jdField_a_of_type_Vdf);
    stb.a().registerSubscriber(this.jdField_a_of_type_Vde);
    stb.a().registerSubscriber(this.jdField_a_of_type_Vdg);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((tdl)tcz.a(2)).b(QQStoryContext.a().b());
    List localList = ((tcw)tcz.a(5)).b(QQStoryContext.a().b());
    this.jdField_a_of_type_Uyc.b();
    uyc localuyc = this.jdField_a_of_type_Uyc;
    if (((Integer)this.jdField_a_of_type_Tcs.b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1)
    {
      bool = true;
      localuyc.jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Uyc.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Uyc.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Tcs.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      }
      this.jdField_a_of_type_Uyc.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Tcs.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Uyc.jdField_a_of_type_Long = ((Integer)this.jdField_a_of_type_Tcs.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Uyc.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_Tcs.b("qqstory_my_newest_video_cover", ""));
      this.jdField_a_of_type_Uyc.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_Tcs.b("qqstory_my_newest_video_vid", ""));
      localuyc = this.jdField_a_of_type_Uyc;
      if (((Integer)this.jdField_a_of_type_Tcs.b("qqstory_my_story_have_contributed", Integer.valueOf(-1))).intValue() != 1) {
        break label471;
      }
    }
    label471:
    for (boolean bool = true;; bool = false)
    {
      localuyc.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Uyc.jdField_a_of_type_Tec.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Tcs.b("qqstory_key_story_latest_feed_feature_feed_id", ""));
      this.jdField_a_of_type_Uyc.jdField_a_of_type_Tec.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_Tcs.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Uyc.jdField_a_of_type_Tec.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Tcs.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Uyc.jdField_a_of_type_Tec.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Tcs.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(0))).intValue();
      if (localList.size() == 0) {
        ved.d("NewMyStorySegment", "Story DB have no mystory data!");
      }
      Collections.sort(localList);
      this.jdField_a_of_type_Uyc.a(localList);
      ved.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_Uyc.a()) });
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
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Vdf);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Vde);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Vdg);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Uzq.c();
    if (this.jdField_a_of_type_Wbr != null) {
      this.jdField_a_of_type_Wbr.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ssv);
  }
  
  protected void e() {}
  
  protected int f_()
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
      a((uyc)paramMessage.obj);
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcp
 * JD-Core Version:    0.7.0.1
 */