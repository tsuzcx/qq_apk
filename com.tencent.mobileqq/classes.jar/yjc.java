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
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class yjc
  extends zgz<yep>
  implements Handler.Callback, IEventReceiver
{
  public static final String KEY = "NewMyStorySegment";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  protected vzx a;
  protected wjl a;
  private yep jdField_a_of_type_Yep;
  protected ygd a;
  private yhc jdField_a_of_type_Yhc;
  private yhd jdField_a_of_type_Yhd;
  protected yjr a;
  protected yjs a;
  protected yjt a;
  public final zfh<yfm> a;
  private zgc jdField_a_of_type_Zgc;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public final zfh<yfl> b;
  private boolean jdField_b_of_type_Boolean;
  public final zfh<yfx> c;
  private boolean c;
  public final zfh<yfi> d = new yjk(this);
  
  public yjc(Activity paramActivity, yhd paramyhd)
  {
    super(paramActivity);
    this.jdField_a_of_type_Zfh = new yjd(this);
    this.jdField_b_of_type_Zfh = new yji(this);
    this.jdField_c_of_type_Zfh = new yjj(this);
    this.jdField_a_of_type_Vzx = new yjm(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Yhd = paramyhd;
    this.jdField_a_of_type_Float = (UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) - UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 145.0F));
    this.jdField_a_of_type_Wjl = ((wjl)wjs.a(10));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Ygd = new ygd(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Yep = new yep();
    this.jdField_a_of_type_Yjs = new yjs(this);
    this.jdField_a_of_type_Yjr = new yjr(this);
    this.jdField_a_of_type_Yjt = new yjt(this);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Vzx);
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(yex.b(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramStoryVideoItem;
  }
  
  private String a(yep paramyep, int paramInt, TextPaint paramTextPaint)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(paramyep.a(paramInt, paramTextPaint));
    paramyep = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramyep;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    wzk.a(paramStoryVideoItem, this.jdField_a_of_type_AndroidContentContext);
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
      ykv.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
      paramStoryVideoItem = new VidListPlayInfo(this.jdField_a_of_type_Yep.jdField_a_of_type_Wkv.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
      xbp.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, 2, paramView);
      return;
    }
  }
  
  private void a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yhc = paramyhc;
    paramViewGroup = (ImageView)paramyhc.a(2131374715);
    TextView localTextView = (TextView)paramyhc.a(2131374671);
    ImageView localImageView1 = (ImageView)paramyhc.a(2131374677);
    ImageView localImageView2 = (ImageView)paramyhc.a(2131374675);
    View localView = paramyhc.a(2131374676);
    this.jdField_a_of_type_Yep.a();
    paramInt = -657931;
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (bool) {
      paramInt = -15980466;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((wke)wjs.a(2)).a();
    if (this.jdField_a_of_type_Yep.b() == 0)
    {
      paramViewGroup.setImageResource(2130846841);
      localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
      if (!this.jdField_b_of_type_Boolean) {
        break label335;
      }
      if (!bool) {
        break label324;
      }
      localImageView2.setImageResource(2130846677);
      label170:
      localImageView2.setContentDescription(anvx.a(2131706990));
      if (this.jdField_a_of_type_Yep.a().size() <= 0) {
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
      paramViewGroup.setOnClickListener(paramyhc);
      paramyhc.a().findViewById(2131374712).setOnClickListener(paramyhc);
      if (paramyhc.jdField_a_of_type_Yev == null) {
        paramyhc.a(new yjq(this));
      }
      return;
      if ((localQQUserUIItem == null) || (TextUtils.isEmpty(localQQUserUIItem.headUrl)))
      {
        ykq.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
        paramViewGroup.setImageResource(2130846841);
        wrb.d();
        break;
      }
      UIUtils.setCircleViewByURL(paramViewGroup, zfe.b(localQQUserUIItem.headUrl), 200, 200, bheg.a(1), "QQStory200");
      break;
      label324:
      localImageView2.setImageResource(2130846676);
      break label170;
      label335:
      if (bool) {
        localImageView2.setImageResource(2130846675);
      }
      for (;;)
      {
        localImageView2.setContentDescription(anvx.a(2131706981));
        break;
        localImageView2.setImageResource(2130846674);
      }
      label373:
      if (this.jdField_a_of_type_Yep.b() != 0)
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
  
  private void a(yep paramyep, View paramView)
  {
    if (UIUtils.isFastDoubleClick()) {
      return;
    }
    if (paramyep.d) {}
    for (String str = "1"; paramyep.b() == 0; str = "2")
    {
      ykv.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_Yhd.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131374715) {
      ykv.a("mystory", "clk_head_data", 0, 0, new String[0]);
    }
    for (;;)
    {
      paramyep = QQStoryContext.a().b();
      weg.a(this.jdField_a_of_type_AndroidContentContext, 3, paramyep);
      return;
      ykv.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (UIUtils.isFastDoubleClick()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131374664);
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
      ykv.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str });
      paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_Yep.jdField_a_of_type_Wkv.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid), 2);
      xbp.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem.a(), localStoryCoverView.a);
      return;
    }
  }
  
  private void b(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramyhc.a(2131374664);
    ImageView localImageView1 = (ImageView)paramyhc.a(2131374678);
    TextView localTextView1 = (TextView)paramyhc.a(2131374665);
    Object localObject1 = (TextView)paramyhc.a(2131374717);
    ImageView localImageView2 = (ImageView)paramyhc.a(2131374667);
    TextView localTextView2 = (TextView)paramyhc.a(2131374720);
    TextView localTextView3 = (TextView)paramyhc.a(2131374670);
    ImageView localImageView3 = (ImageView)paramyhc.a(2131374663);
    paramViewGroup = (Button)paramyhc.a(2131374716);
    ImageView localImageView4 = (ImageView)paramyhc.a(2131374668);
    if ((this.jdField_a_of_type_Yep == null) || (this.jdField_a_of_type_Yep.a() == null))
    {
      ykq.e("NewMyStorySegment", "myStorys is null!");
      return;
    }
    paramyhc.a().setTag(-3, Integer.valueOf(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
    paramViewGroup.setOnClickListener(paramyhc);
    paramViewGroup = (ImageView)paramyhc.a(2131374668);
    Object localObject2 = (ImageView)paramyhc.a(2131374669);
    paramInt = -657931;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      paramInt = -15980466;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ((ImageView)localObject2).setBackgroundColor(paramInt);
    localObject2 = (StoryVideoItem)this.jdField_a_of_type_Yep.a().get(i);
    ykq.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
    label289:
    boolean bool2;
    if (yex.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath))
    {
      paramViewGroup = ykn.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);
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
          break label1213;
        }
        localTextView1.setEnabled(true);
        label461:
        paramyhc.jdField_b_of_type_Int = i;
        paramyhc.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Yep;
        localTextView1.setOnClickListener(paramyhc);
        paramyhc.a().setOnClickListener(paramyhc);
        paramyhc.a().setContentDescription(anvx.a(2131706983) + vzh.jdField_a_of_type_JavaLangString + anvx.a(2131706995) + (i + 1) + anvx.a(2131706982));
        localTextView2.setOnClickListener(paramyhc);
        localImageView2.setOnClickListener(paramyhc);
        if (paramyhc.jdField_a_of_type_Yev != null) {
          break;
        }
        paramyhc.a(new yjf(this, bool1));
        return;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null) {
          ykq.e("NewMyStorySegment", "mVideoThumbnailUrl is null! vid=" + ((StoryVideoItem)localObject2).mVid);
        }
        paramViewGroup = zfe.a(((StoryVideoItem)localObject2).mVideoThumbnailUrl);
        break label289;
        localTextView3.setVisibility(0);
        localTextView3.setText(anvx.a(2131706984));
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
          paramInt = wcz.a().a(((StoryVideoItem)localObject2).mVid);
          if (paramInt >= 0) {
            localTextView3.setText(anvx.a(2131706985) + paramInt + "%");
          }
          paramViewGroup = new yje(this, localTextView3);
          localTextView3.setTag(paramViewGroup);
          wcz.a().a(((StoryVideoItem)localObject2).mVid, paramViewGroup);
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
          if ((localTextView3.getTag() != null) && ((localTextView3.getTag() instanceof wdb))) {
            wcz.a().a((wdb)localTextView3.getTag());
          }
          localTextView3.setText(2131699214);
        }
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        if (((StoryVideoItem)localObject2).mUpLoadFailedError == 10404) {
          localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131699217));
        }
        ((TextView)localObject1).setVisibility(8);
        localImageView3.setVisibility(8);
        localImageView2.setVisibility(0);
        localTextView3.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView3.setVisibility(0);
        localTextView3.setText(anvx.a(2131706989));
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
        break label1222;
      }
      paramViewGroup = ((TroopManager)wzk.a().getManager(QQManagerFactory.TROOP_MANAGER)).b((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.get(0));
      if ((paramViewGroup == null) || (TextUtils.isEmpty(paramViewGroup.getTroopName()))) {
        break label1222;
      }
      paramViewGroup = anvx.a(2131706986) + paramViewGroup.getTroopName();
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
      label1213:
      localTextView1.setEnabled(false);
      break label461;
      label1222:
      paramViewGroup = "";
    }
  }
  
  private void b(yhc paramyhc, int paramInt)
  {
    TextView localTextView1 = (TextView)paramyhc.a(2131374665);
    TextView localTextView2 = (TextView)paramyhc.a(2131374717);
    ImageView localImageView = (ImageView)paramyhc.a(2131374667);
    TextView localTextView3 = (TextView)paramyhc.a(2131374720);
    paramyhc = (ImageView)paramyhc.a(2131374663);
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
      paramyhc.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramyhc.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 3: 
    case 6: 
      localTextView1.setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView2.setVisibility(8);
      paramyhc.setVisibility(8);
      localImageView.setVisibility(0);
      return;
    case 9: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramyhc.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    }
    localTextView3.setVisibility(8);
    paramyhc.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  private void c(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramyhc.a(2131370108);
    View localView1 = paramyhc.a(2131370142);
    View localView2 = paramyhc.a(2131370143);
    paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167117);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramyhc.a(2131378791);
    localView1 = paramyhc.a(2131378686);
    paramViewGroup.setOnClickListener(paramyhc);
    localView1.setOnClickListener(paramyhc);
    if (paramyhc.jdField_a_of_type_Yev == null) {
      paramyhc.a(new yjg(this));
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Yep != null) && (this.jdField_a_of_type_Yep.a().size() > 0)) {
        return this.jdField_a_of_type_Yep.a().size() + 2;
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
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    int i = a(paramInt);
    ykq.a("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return paramyhc.a();
      a(paramInt, paramyhc, paramViewGroup);
      continue;
      b(paramInt, paramyhc, paramViewGroup);
      continue;
      c(paramInt, paramyhc, paramViewGroup);
    }
  }
  
  public String a()
  {
    return "NewMyStorySegment";
  }
  
  public ygd a()
  {
    return new ygd(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = null;
    }
    while (paramViewGroup != null)
    {
      return new yhc(paramViewGroup);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561800, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561801, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561690, paramViewGroup, false);
    }
    return new yhc(new TextView(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_Yep.a(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131706991), 0).a();
    m();
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_Yep.a(paramString);
    this.jdField_a_of_type_Yep.c(paramString);
    if (this.jdField_a_of_type_Yep.a().size() == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Yep.jdField_b_of_type_Boolean = false;
    }
    ((ycq)wjs.a(12)).a(this.jdField_a_of_type_Yep.jdField_a_of_type_Wkv.jdField_a_of_type_JavaLangString, 0, paramString);
    m();
  }
  
  protected void a(wcx paramwcx)
  {
    ykq.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramwcx);
    Object localObject1 = paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_Yep.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      ykq.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_Yep.a((StoryVideoItem)localObject1);
      if (paramwcx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
        break label268;
      }
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramwcx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    for (;;)
    {
      if (paramwcx.b != null)
      {
        this.jdField_a_of_type_Yep.a(((StoryVideoItem)localObject1).mVid, paramwcx.b);
        this.jdField_a_of_type_Yep.jdField_b_of_type_Boolean = paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.mIsContribute;
        if ((!TextUtils.isEmpty(paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)) && (!TextUtils.equals(this.jdField_a_of_type_Yep.jdField_a_of_type_Wkv.jdField_a_of_type_JavaLangString, paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)))
        {
          ykq.a("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.jdField_a_of_type_Yep.jdField_a_of_type_Wkv.jdField_a_of_type_JavaLangString, paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
          Object localObject2 = paramwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
          localObject1 = new ygg(yfo.a((String)localObject2));
          ygl localygl = (ygl)this.jdField_b_of_type_Zfh.a();
          localObject2 = new ygf(new yjh(this, (String)localObject2));
          ygd localygd = a();
          a(new ygl[] { localObject1, localygl, localObject2 }, localygd);
        }
      }
      if (!paramwcx.jdField_c_of_type_Boolean) {
        break label279;
      }
      a().h();
      return;
      this.jdField_a_of_type_Yep.b((StoryVideoItem)localObject1);
      break;
      label268:
      ykq.e("NewMyStorySegment", "item error info is null!!");
    }
    label279:
    m();
  }
  
  public void a(yep paramyep)
  {
    this.jdField_a_of_type_Yep = paramyep;
    yfx.a(this.jdField_a_of_type_Yep);
    c(true);
  }
  
  public void a(yhc paramyhc, int paramInt)
  {
    a().t();
    if ((this.jdField_a_of_type_Yep.a().size() > paramInt) && (this.jdField_a_of_type_Yep.a().get(paramInt) != null))
    {
      localObject = ((StoryVideoItem)this.jdField_a_of_type_Yep.a().get(paramInt)).mVid;
      if (!StoryVideoItem.isFakeVid((String)localObject)) {
        break label117;
      }
      wcn.a((String)localObject);
      m();
      if (!((StoryVideoItem)this.jdField_a_of_type_Yep.a().get(paramInt)).isUploading()) {
        break label110;
      }
    }
    label110:
    for (paramyhc = "1";; paramyhc = "3")
    {
      ykv.a("mystory", "del_onevideo", 0, 0, new String[] { paramyhc });
      return;
    }
    label117:
    new wqd().a((String)localObject);
    ((StoryVideoItem)this.jdField_a_of_type_Yep.a().get(paramInt)).mUploadStatus = 9;
    Object localObject = (TextView)paramyhc.a(2131374670);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(anvx.a(2131706993));
    b(paramyhc, 9);
    ykv.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    m();
  }
  
  protected void a(ygl[] paramArrayOfygl)
  {
    if (this.jdField_a_of_type_Ygd != null) {
      this.jdField_a_of_type_Ygd.c();
    }
    this.jdField_a_of_type_Ygd = new ygd(this.jdField_a_of_type_AndroidOsHandler);
    a(paramArrayOfygl, this.jdField_a_of_type_Ygd);
  }
  
  protected void a(ygl[] paramArrayOfygl, ygd paramygd)
  {
    int j = paramArrayOfygl.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        ygl localygl = paramArrayOfygl[i];
        try
        {
          paramygd.a(localygl);
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
    paramygd.a(new yjp(this)).a(new yjo(this));
    paramygd.a();
  }
  
  public void a_(yhc paramyhc)
  {
    super.a_(paramyhc);
    ImageView localImageView1 = (ImageView)paramyhc.a(2131374668);
    ImageView localImageView2 = (ImageView)paramyhc.a(2131374667);
    ImageView localImageView3 = (ImageView)paramyhc.a(2131374663);
    if ((localImageView3 != null) && (localImageView2 != null) && (localImageView1 != null))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localImageView3.setVisibility(8);
    }
    if (this.jdField_a_of_type_Yep.a().size() > paramyhc.jdField_b_of_type_Int)
    {
      paramyhc = (StoryVideoItem)this.jdField_a_of_type_Yep.a().get(paramyhc.jdField_b_of_type_Int);
      if (!paramyhc.isUploadSuc()) {
        break label135;
      }
      paramyhc = "2";
    }
    for (;;)
    {
      ykv.a("mystory", "slide_del", 0, 0, new String[] { paramyhc });
      return;
      label135:
      if (paramyhc.isUploadFail()) {
        paramyhc = "3";
      } else if (paramyhc.isUploading()) {
        paramyhc = "1";
      } else {
        paramyhc = "2";
      }
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    a(new ygl[] { (ygl)this.jdField_a_of_type_Zfh.a(), (ygl)this.jdField_b_of_type_Zfh.a(), (ygl)this.jdField_c_of_type_Zfh.a(), (ygl)this.d.a() });
    return true;
  }
  
  public void b_(yhc paramyhc)
  {
    super.b_(paramyhc);
    ((ImageView)paramyhc.a(2131374668)).setVisibility(0);
    if (this.jdField_a_of_type_Yep.a().size() > paramyhc.jdField_b_of_type_Int) {
      b(paramyhc, ((StoryVideoItem)this.jdField_a_of_type_Yep.a().get(paramyhc.jdField_b_of_type_Int)).mUploadStatus);
    }
  }
  
  protected void c()
  {
    wad.a().registerSubscriber(this.jdField_a_of_type_Yjs);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yjr);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yjt);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wke)wjs.a(2)).b(QQStoryContext.a().b());
    List localList = ((wjp)wjs.a(5)).b(QQStoryContext.a().b());
    this.jdField_a_of_type_Yep.b();
    yep localyep = this.jdField_a_of_type_Yep;
    if (((Integer)this.jdField_a_of_type_Wjl.b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1)
    {
      bool = true;
      localyep.jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Yep.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Yep.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Wjl.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      }
      this.jdField_a_of_type_Yep.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Wjl.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yep.jdField_a_of_type_Long = ((Integer)this.jdField_a_of_type_Wjl.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yep.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_Wjl.b("qqstory_my_newest_video_cover", ""));
      this.jdField_a_of_type_Yep.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_Wjl.b("qqstory_my_newest_video_vid", ""));
      localyep = this.jdField_a_of_type_Yep;
      if (((Integer)this.jdField_a_of_type_Wjl.b("qqstory_my_story_have_contributed", Integer.valueOf(-1))).intValue() != 1) {
        break label471;
      }
    }
    label471:
    for (boolean bool = true;; bool = false)
    {
      localyep.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Yep.jdField_a_of_type_Wkv.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Wjl.b("qqstory_key_story_latest_feed_feature_feed_id", ""));
      this.jdField_a_of_type_Yep.jdField_a_of_type_Wkv.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_Wjl.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yep.jdField_a_of_type_Wkv.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Wjl.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yep.jdField_a_of_type_Wkv.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Wjl.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(0))).intValue();
      if (localList.size() == 0) {
        ykq.d("NewMyStorySegment", "Story DB have no mystory data!");
      }
      Collections.sort(localList);
      this.jdField_a_of_type_Yep.a(localList);
      ykq.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_Yep.a()) });
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
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yjs);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yjr);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yjt);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Ygd.c();
    if (this.jdField_a_of_type_Zgc != null) {
      this.jdField_a_of_type_Zgc.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Vzx);
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
      a((yep)paramMessage.obj);
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjc
 * JD-Core Version:    0.7.0.1
 */