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

public class ysw
  extends zsv<yoj>
  implements Handler.Callback, IEventReceiver
{
  public static final String KEY = "NewMyStorySegment";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  protected wjd a;
  protected wta a;
  private yoj jdField_a_of_type_Yoj;
  protected ypx a;
  private yqw jdField_a_of_type_Yqw;
  private yqx jdField_a_of_type_Yqx;
  protected ytl a;
  protected ytm a;
  protected ytn a;
  public final zpx<ypg> a;
  private zry jdField_a_of_type_Zry;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public final zpx<ypf> b;
  private boolean jdField_b_of_type_Boolean;
  public final zpx<ypr> c;
  private boolean c;
  public final zpx<ypc> d = new yte(this);
  
  public ysw(Activity paramActivity, yqx paramyqx)
  {
    super(paramActivity);
    this.jdField_a_of_type_Zpx = new ysx(this);
    this.jdField_b_of_type_Zpx = new ytc(this);
    this.jdField_c_of_type_Zpx = new ytd(this);
    this.jdField_a_of_type_Wjd = new ytg(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Yqx = paramyqx;
    this.jdField_a_of_type_Float = (zps.a(this.jdField_a_of_type_AndroidContentContext) - zps.a(this.jdField_a_of_type_AndroidContentContext, 145.0F));
    this.jdField_a_of_type_Wta = ((wta)wth.a(10));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Ypx = new ypx(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Yoj = new yoj();
    this.jdField_a_of_type_Ytm = new ytm(this);
    this.jdField_a_of_type_Ytl = new ytl(this);
    this.jdField_a_of_type_Ytn = new ytn(this);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Wjd);
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(yor.b(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramStoryVideoItem;
  }
  
  private String a(yoj paramyoj, int paramInt, TextPaint paramTextPaint)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(paramyoj.a(paramInt, paramTextPaint));
    paramyoj = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramyoj;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    xiz.a(paramStoryVideoItem, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (zps.b()) {
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (String str1 = "1";; str1 = "2")
    {
      String str2 = "2";
      if ((TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str2 = "1";
      }
      yup.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
      paramStoryVideoItem = new VidListPlayInfo(this.jdField_a_of_type_Yoj.jdField_a_of_type_Wuk.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
      xlj.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, 2, paramView);
      return;
    }
  }
  
  private void a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yqw = paramyqw;
    paramViewGroup = (ImageView)paramyqw.a(2131374709);
    TextView localTextView = (TextView)paramyqw.a(2131374665);
    ImageView localImageView1 = (ImageView)paramyqw.a(2131374671);
    ImageView localImageView2 = (ImageView)paramyqw.a(2131374669);
    View localView = paramyqw.a(2131374670);
    this.jdField_a_of_type_Yoj.a();
    paramInt = -657931;
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (bool) {
      paramInt = -15980466;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((wtt)wth.a(2)).a();
    if (this.jdField_a_of_type_Yoj.b() == 0)
    {
      paramViewGroup.setImageResource(2130846837);
      localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
      if (!this.jdField_b_of_type_Boolean) {
        break label335;
      }
      if (!bool) {
        break label324;
      }
      localImageView2.setImageResource(2130846673);
      label170:
      localImageView2.setContentDescription(anzj.a(2131706408));
      if (this.jdField_a_of_type_Yoj.a().size() <= 0) {
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
      paramViewGroup.setOnClickListener(paramyqw);
      paramyqw.a().findViewById(2131374706).setOnClickListener(paramyqw);
      if (paramyqw.jdField_a_of_type_Yop == null) {
        paramyqw.a(new ytk(this));
      }
      return;
      if ((localQQUserUIItem == null) || (TextUtils.isEmpty(localQQUserUIItem.headUrl)))
      {
        yuk.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
        paramViewGroup.setImageResource(2130846837);
        xaq.d();
        break;
      }
      zps.b(paramViewGroup, zpp.b(localQQUserUIItem.headUrl), 200, 200, bhmq.a(1), "QQStory200");
      break;
      label324:
      localImageView2.setImageResource(2130846672);
      break label170;
      label335:
      if (bool) {
        localImageView2.setImageResource(2130846671);
      }
      for (;;)
      {
        localImageView2.setContentDescription(anzj.a(2131706399));
        break;
        localImageView2.setImageResource(2130846670);
      }
      label373:
      if (this.jdField_a_of_type_Yoj.b() != 0)
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
  
  private void a(yoj paramyoj, View paramView)
  {
    if (zps.b()) {
      return;
    }
    if (paramyoj.d) {}
    for (String str = "1"; paramyoj.b() == 0; str = "2")
    {
      yup.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_Yqx.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131374709) {
      yup.a("mystory", "clk_head_data", 0, 0, new String[0]);
    }
    for (;;)
    {
      paramyoj = QQStoryContext.a().b();
      wnu.a(this.jdField_a_of_type_AndroidContentContext, 3, paramyoj);
      return;
      yup.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (zps.b()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131374658);
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
      yup.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str });
      paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_Yoj.jdField_a_of_type_Wuk.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid), 2);
      xlj.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem.a(), localStoryCoverView.a);
      return;
    }
  }
  
  private void b(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramyqw.a(2131374658);
    ImageView localImageView1 = (ImageView)paramyqw.a(2131374672);
    TextView localTextView1 = (TextView)paramyqw.a(2131374659);
    Object localObject1 = (TextView)paramyqw.a(2131374711);
    ImageView localImageView2 = (ImageView)paramyqw.a(2131374661);
    TextView localTextView2 = (TextView)paramyqw.a(2131374714);
    TextView localTextView3 = (TextView)paramyqw.a(2131374664);
    ImageView localImageView3 = (ImageView)paramyqw.a(2131374657);
    paramViewGroup = (Button)paramyqw.a(2131374710);
    ImageView localImageView4 = (ImageView)paramyqw.a(2131374662);
    if ((this.jdField_a_of_type_Yoj == null) || (this.jdField_a_of_type_Yoj.a() == null))
    {
      yuk.e("NewMyStorySegment", "myStorys is null!");
      return;
    }
    paramyqw.a().setTag(-3, Integer.valueOf(zps.a(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
    paramViewGroup.setOnClickListener(paramyqw);
    paramViewGroup = (ImageView)paramyqw.a(2131374662);
    Object localObject2 = (ImageView)paramyqw.a(2131374663);
    paramInt = -657931;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      paramInt = -15980466;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ((ImageView)localObject2).setBackgroundColor(paramInt);
    localObject2 = (StoryVideoItem)this.jdField_a_of_type_Yoj.a().get(i);
    yuk.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
    label289:
    boolean bool2;
    if (yor.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath))
    {
      paramViewGroup = yuh.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);
      bool2 = false;
      zps.a(localStoryCoverView.a, paramViewGroup, 106, 170, 5, zps.b, "myStory");
      localStoryCoverView.setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      localStoryCoverView.setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      ((TextView)localObject1).setMaxWidth(zps.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
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
        paramyqw.jdField_b_of_type_Int = i;
        paramyqw.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Yoj;
        localTextView1.setOnClickListener(paramyqw);
        paramyqw.a().setOnClickListener(paramyqw);
        paramyqw.a().setContentDescription(anzj.a(2131706401) + win.jdField_a_of_type_JavaLangString + anzj.a(2131706413) + (i + 1) + anzj.a(2131706400));
        localTextView2.setOnClickListener(paramyqw);
        localImageView2.setOnClickListener(paramyqw);
        if (paramyqw.jdField_a_of_type_Yop != null) {
          break;
        }
        paramyqw.a(new ysz(this, bool1));
        return;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null) {
          yuk.e("NewMyStorySegment", "mVideoThumbnailUrl is null! vid=" + ((StoryVideoItem)localObject2).mVid);
        }
        paramViewGroup = zpp.a(((StoryVideoItem)localObject2).mVideoThumbnailUrl);
        break label289;
        localTextView3.setVisibility(0);
        localTextView3.setText(anzj.a(2131706402));
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
          paramInt = wmf.a().a(((StoryVideoItem)localObject2).mVid);
          if (paramInt >= 0) {
            localTextView3.setText(anzj.a(2131706403) + paramInt + "%");
          }
          paramViewGroup = new ysy(this, localTextView3);
          localTextView3.setTag(paramViewGroup);
          wmf.a().a(((StoryVideoItem)localObject2).mVid, paramViewGroup);
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
          if ((localTextView3.getTag() != null) && ((localTextView3.getTag() instanceof wmh))) {
            wmf.a().a((wmh)localTextView3.getTag());
          }
          localTextView3.setText(2131698628);
        }
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        if (((StoryVideoItem)localObject2).mUpLoadFailedError == 10404) {
          localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131698631));
        }
        ((TextView)localObject1).setVisibility(8);
        localImageView3.setVisibility(8);
        localImageView2.setVisibility(0);
        localTextView3.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView3.setVisibility(0);
        localTextView3.setText(anzj.a(2131706407));
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
      paramViewGroup = ((TroopManager)xiz.a().getManager(52)).b((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.get(0));
      if ((paramViewGroup == null) || (TextUtils.isEmpty(paramViewGroup.getTroopName()))) {
        break label1221;
      }
      paramViewGroup = anzj.a(2131706404) + paramViewGroup.getTroopName();
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
  
  private void b(yqw paramyqw, int paramInt)
  {
    TextView localTextView1 = (TextView)paramyqw.a(2131374659);
    TextView localTextView2 = (TextView)paramyqw.a(2131374711);
    ImageView localImageView = (ImageView)paramyqw.a(2131374661);
    TextView localTextView3 = (TextView)paramyqw.a(2131374714);
    paramyqw = (ImageView)paramyqw.a(2131374657);
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
      paramyqw.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramyqw.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 3: 
    case 6: 
      localTextView1.setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView2.setVisibility(8);
      paramyqw.setVisibility(8);
      localImageView.setVisibility(0);
      return;
    case 9: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramyqw.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    }
    localTextView3.setVisibility(8);
    paramyqw.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  private void c(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramyqw.a(2131369944);
    View localView1 = paramyqw.a(2131369978);
    View localView2 = paramyqw.a(2131369979);
    paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167081);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramyqw.a(2131378735);
    localView1 = paramyqw.a(2131378631);
    paramViewGroup.setOnClickListener(paramyqw);
    localView1.setOnClickListener(paramyqw);
    if (paramyqw.jdField_a_of_type_Yop == null) {
      paramyqw.a(new yta(this));
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Yoj != null) && (this.jdField_a_of_type_Yoj.a().size() > 0)) {
        return this.jdField_a_of_type_Yoj.a().size() + 2;
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
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    int i = a(paramInt);
    yuk.a("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return paramyqw.a();
      a(paramInt, paramyqw, paramViewGroup);
      continue;
      b(paramInt, paramyqw, paramViewGroup);
      continue;
      c(paramInt, paramyqw, paramViewGroup);
    }
  }
  
  public String a()
  {
    return "NewMyStorySegment";
  }
  
  public ypx a()
  {
    return new ypx(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = null;
    }
    while (paramViewGroup != null)
    {
      return new yqw(paramViewGroup);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561854, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561855, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561744, paramViewGroup, false);
    }
    return new yqw(new TextView(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_Yoj.a(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131706409), 0).a();
    m();
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_Yoj.a(paramString);
    this.jdField_a_of_type_Yoj.c(paramString);
    if (this.jdField_a_of_type_Yoj.a().size() == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Yoj.jdField_b_of_type_Boolean = false;
    }
    ((ymk)wth.a(12)).a(this.jdField_a_of_type_Yoj.jdField_a_of_type_Wuk.jdField_a_of_type_JavaLangString, 0, paramString);
    m();
  }
  
  protected void a(wmd paramwmd)
  {
    yuk.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramwmd);
    Object localObject1 = paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_Yoj.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      yuk.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_Yoj.a((StoryVideoItem)localObject1);
      if (paramwmd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
        break label268;
      }
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramwmd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    for (;;)
    {
      if (paramwmd.b != null)
      {
        this.jdField_a_of_type_Yoj.a(((StoryVideoItem)localObject1).mVid, paramwmd.b);
        this.jdField_a_of_type_Yoj.jdField_b_of_type_Boolean = paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.mIsContribute;
        if ((!TextUtils.isEmpty(paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)) && (!TextUtils.equals(this.jdField_a_of_type_Yoj.jdField_a_of_type_Wuk.jdField_a_of_type_JavaLangString, paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)))
        {
          yuk.a("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.jdField_a_of_type_Yoj.jdField_a_of_type_Wuk.jdField_a_of_type_JavaLangString, paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
          Object localObject2 = paramwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
          localObject1 = new yqa(ypi.a((String)localObject2));
          yqf localyqf = (yqf)this.jdField_b_of_type_Zpx.a();
          localObject2 = new ypz(new ytb(this, (String)localObject2));
          ypx localypx = a();
          a(new yqf[] { localObject1, localyqf, localObject2 }, localypx);
        }
      }
      if (!paramwmd.jdField_c_of_type_Boolean) {
        break label279;
      }
      a().h();
      return;
      this.jdField_a_of_type_Yoj.b((StoryVideoItem)localObject1);
      break;
      label268:
      yuk.e("NewMyStorySegment", "item error info is null!!");
    }
    label279:
    m();
  }
  
  public void a(yoj paramyoj)
  {
    this.jdField_a_of_type_Yoj = paramyoj;
    ypr.a(this.jdField_a_of_type_Yoj);
    c(true);
  }
  
  public void a(yqw paramyqw, int paramInt)
  {
    a().t();
    if ((this.jdField_a_of_type_Yoj.a().size() > paramInt) && (this.jdField_a_of_type_Yoj.a().get(paramInt) != null))
    {
      localObject = ((StoryVideoItem)this.jdField_a_of_type_Yoj.a().get(paramInt)).mVid;
      if (!StoryVideoItem.isFakeVid((String)localObject)) {
        break label117;
      }
      wlt.a((String)localObject);
      m();
      if (!((StoryVideoItem)this.jdField_a_of_type_Yoj.a().get(paramInt)).isUploading()) {
        break label110;
      }
    }
    label110:
    for (paramyqw = "1";; paramyqw = "3")
    {
      yup.a("mystory", "del_onevideo", 0, 0, new String[] { paramyqw });
      return;
    }
    label117:
    new wzs().a((String)localObject);
    ((StoryVideoItem)this.jdField_a_of_type_Yoj.a().get(paramInt)).mUploadStatus = 9;
    Object localObject = (TextView)paramyqw.a(2131374664);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(anzj.a(2131706411));
    b(paramyqw, 9);
    yup.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    m();
  }
  
  protected void a(yqf[] paramArrayOfyqf)
  {
    if (this.jdField_a_of_type_Ypx != null) {
      this.jdField_a_of_type_Ypx.c();
    }
    this.jdField_a_of_type_Ypx = new ypx(this.jdField_a_of_type_AndroidOsHandler);
    a(paramArrayOfyqf, this.jdField_a_of_type_Ypx);
  }
  
  protected void a(yqf[] paramArrayOfyqf, ypx paramypx)
  {
    int j = paramArrayOfyqf.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        yqf localyqf = paramArrayOfyqf[i];
        try
        {
          paramypx.a(localyqf);
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
    paramypx.a(new ytj(this)).a(new yti(this));
    paramypx.a();
  }
  
  public void a_(yqw paramyqw)
  {
    super.a_(paramyqw);
    ImageView localImageView1 = (ImageView)paramyqw.a(2131374662);
    ImageView localImageView2 = (ImageView)paramyqw.a(2131374661);
    ImageView localImageView3 = (ImageView)paramyqw.a(2131374657);
    if ((localImageView3 != null) && (localImageView2 != null) && (localImageView1 != null))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localImageView3.setVisibility(8);
    }
    if (this.jdField_a_of_type_Yoj.a().size() > paramyqw.jdField_b_of_type_Int)
    {
      paramyqw = (StoryVideoItem)this.jdField_a_of_type_Yoj.a().get(paramyqw.jdField_b_of_type_Int);
      if (!paramyqw.isUploadSuc()) {
        break label135;
      }
      paramyqw = "2";
    }
    for (;;)
    {
      yup.a("mystory", "slide_del", 0, 0, new String[] { paramyqw });
      return;
      label135:
      if (paramyqw.isUploadFail()) {
        paramyqw = "3";
      } else if (paramyqw.isUploading()) {
        paramyqw = "1";
      } else {
        paramyqw = "2";
      }
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    a(new yqf[] { (yqf)this.jdField_a_of_type_Zpx.a(), (yqf)this.jdField_b_of_type_Zpx.a(), (yqf)this.jdField_c_of_type_Zpx.a(), (yqf)this.d.a() });
    return true;
  }
  
  public void b_(yqw paramyqw)
  {
    super.b_(paramyqw);
    ((ImageView)paramyqw.a(2131374662)).setVisibility(0);
    if (this.jdField_a_of_type_Yoj.a().size() > paramyqw.jdField_b_of_type_Int) {
      b(paramyqw, ((StoryVideoItem)this.jdField_a_of_type_Yoj.a().get(paramyqw.jdField_b_of_type_Int)).mUploadStatus);
    }
  }
  
  protected void c()
  {
    wjj.a().registerSubscriber(this.jdField_a_of_type_Ytm);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Ytl);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Ytn);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wtt)wth.a(2)).b(QQStoryContext.a().b());
    List localList = ((wte)wth.a(5)).b(QQStoryContext.a().b());
    this.jdField_a_of_type_Yoj.b();
    yoj localyoj = this.jdField_a_of_type_Yoj;
    if (((Integer)this.jdField_a_of_type_Wta.b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1)
    {
      bool = true;
      localyoj.jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Yoj.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Yoj.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Wta.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      }
      this.jdField_a_of_type_Yoj.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Wta.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yoj.jdField_a_of_type_Long = ((Integer)this.jdField_a_of_type_Wta.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yoj.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_Wta.b("qqstory_my_newest_video_cover", ""));
      this.jdField_a_of_type_Yoj.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_Wta.b("qqstory_my_newest_video_vid", ""));
      localyoj = this.jdField_a_of_type_Yoj;
      if (((Integer)this.jdField_a_of_type_Wta.b("qqstory_my_story_have_contributed", Integer.valueOf(-1))).intValue() != 1) {
        break label471;
      }
    }
    label471:
    for (boolean bool = true;; bool = false)
    {
      localyoj.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Yoj.jdField_a_of_type_Wuk.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Wta.b("qqstory_key_story_latest_feed_feature_feed_id", ""));
      this.jdField_a_of_type_Yoj.jdField_a_of_type_Wuk.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_Wta.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yoj.jdField_a_of_type_Wuk.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Wta.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Yoj.jdField_a_of_type_Wuk.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Wta.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(0))).intValue();
      if (localList.size() == 0) {
        yuk.d("NewMyStorySegment", "Story DB have no mystory data!");
      }
      Collections.sort(localList);
      this.jdField_a_of_type_Yoj.a(localList);
      yuk.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_Yoj.a()) });
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
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ytm);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ytl);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ytn);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Ypx.c();
    if (this.jdField_a_of_type_Zry != null) {
      this.jdField_a_of_type_Zry.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Wjd);
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
      a((yoj)paramMessage.obj);
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysw
 * JD-Core Version:    0.7.0.1
 */