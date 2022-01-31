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

public class wrh
  extends xrg<wmu>
  implements Handler.Callback, IEventReceiver
{
  public static final String KEY = "NewMyStorySegment";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  protected uhn a;
  protected urk a;
  private wmu jdField_a_of_type_Wmu;
  protected woi a;
  private wph jdField_a_of_type_Wph;
  private wpi jdField_a_of_type_Wpi;
  protected wrw a;
  protected wrx a;
  protected wry a;
  public final xoi<wnr> a;
  private xqj jdField_a_of_type_Xqj;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public final xoi<wnq> b;
  private boolean jdField_b_of_type_Boolean;
  public final xoi<woc> c;
  private boolean c;
  public final xoi<wnn> d = new wrp(this);
  
  public wrh(Activity paramActivity, wpi paramwpi)
  {
    super(paramActivity);
    this.jdField_a_of_type_Xoi = new wri(this);
    this.jdField_b_of_type_Xoi = new wrn(this);
    this.jdField_c_of_type_Xoi = new wro(this);
    this.jdField_a_of_type_Uhn = new wrr(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Wpi = paramwpi;
    this.jdField_a_of_type_Float = (xod.a(this.jdField_a_of_type_AndroidContentContext) - xod.a(this.jdField_a_of_type_AndroidContentContext, 145.0F));
    this.jdField_a_of_type_Urk = ((urk)urr.a(10));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Woi = new woi(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Wmu = new wmu();
    this.jdField_a_of_type_Wrx = new wrx(this);
    this.jdField_a_of_type_Wrw = new wrw(this);
    this.jdField_a_of_type_Wry = new wry(this);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Uhn);
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(wnc.b(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramStoryVideoItem;
  }
  
  private String a(wmu paramwmu, int paramInt, TextPaint paramTextPaint)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(paramwmu.a(paramInt, paramTextPaint));
    paramwmu = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramwmu;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    vhj.a(paramStoryVideoItem, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (xod.b()) {
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (String str1 = "1";; str1 = "2")
    {
      String str2 = "2";
      if ((TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str2 = "1";
      }
      wta.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
      paramStoryVideoItem = new VidListPlayInfo(this.jdField_a_of_type_Wmu.jdField_a_of_type_Usu.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
      vju.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, 2, paramView);
      return;
    }
  }
  
  private void a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wph = paramwph;
    paramViewGroup = (ImageView)paramwph.a(2131373819);
    TextView localTextView = (TextView)paramwph.a(2131373775);
    ImageView localImageView1 = (ImageView)paramwph.a(2131373781);
    ImageView localImageView2 = (ImageView)paramwph.a(2131373779);
    View localView = paramwph.a(2131373780);
    this.jdField_a_of_type_Wmu.a();
    paramInt = -657931;
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (bool) {
      paramInt = -15980466;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((usd)urr.a(2)).a();
    if (this.jdField_a_of_type_Wmu.b() == 0)
    {
      paramViewGroup.setImageResource(2130846309);
      localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
      if (!this.jdField_b_of_type_Boolean) {
        break label335;
      }
      if (!bool) {
        break label324;
      }
      localImageView2.setImageResource(2130846144);
      label170:
      localImageView2.setContentDescription(alpo.a(2131707898));
      if (this.jdField_a_of_type_Wmu.a().size() <= 0) {
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
      paramViewGroup.setOnClickListener(paramwph);
      paramwph.a().findViewById(2131373816).setOnClickListener(paramwph);
      if (paramwph.jdField_a_of_type_Wna == null) {
        paramwph.a(new wrv(this));
      }
      return;
      if ((localQQUserUIItem == null) || (TextUtils.isEmpty(localQQUserUIItem.headUrl)))
      {
        wsv.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
        paramViewGroup.setImageResource(2130846309);
        uza.d();
        break;
      }
      xod.b(paramViewGroup, xoa.b(localQQUserUIItem.headUrl), 200, 200, bdda.a(1), "QQStory200");
      break;
      label324:
      localImageView2.setImageResource(2130846143);
      break label170;
      label335:
      if (bool) {
        localImageView2.setImageResource(2130846142);
      }
      for (;;)
      {
        localImageView2.setContentDescription(alpo.a(2131707889));
        break;
        localImageView2.setImageResource(2130846141);
      }
      label373:
      if (this.jdField_a_of_type_Wmu.b() != 0)
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
  
  private void a(wmu paramwmu, View paramView)
  {
    if (xod.b()) {
      return;
    }
    if (paramwmu.d) {}
    for (String str = "1"; paramwmu.b() == 0; str = "2")
    {
      wta.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_Wpi.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131373819) {
      wta.a("mystory", "clk_head_data", 0, 0, new String[0]);
    }
    for (;;)
    {
      paramwmu = QQStoryContext.a().b();
      ume.a(this.jdField_a_of_type_AndroidContentContext, 3, paramwmu);
      return;
      wta.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (xod.b()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131373768);
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
      wta.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str });
      paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_Wmu.jdField_a_of_type_Usu.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid), 2);
      vju.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem.a(), localStoryCoverView.a);
      return;
    }
  }
  
  private void b(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramwph.a(2131373768);
    ImageView localImageView1 = (ImageView)paramwph.a(2131373782);
    TextView localTextView1 = (TextView)paramwph.a(2131373769);
    Object localObject1 = (TextView)paramwph.a(2131373821);
    ImageView localImageView2 = (ImageView)paramwph.a(2131373771);
    TextView localTextView2 = (TextView)paramwph.a(2131373824);
    TextView localTextView3 = (TextView)paramwph.a(2131373774);
    ImageView localImageView3 = (ImageView)paramwph.a(2131373767);
    paramViewGroup = (Button)paramwph.a(2131373820);
    ImageView localImageView4 = (ImageView)paramwph.a(2131373772);
    if ((this.jdField_a_of_type_Wmu == null) || (this.jdField_a_of_type_Wmu.a() == null))
    {
      wsv.e("NewMyStorySegment", "myStorys is null!");
      return;
    }
    paramwph.a().setTag(-3, Integer.valueOf(xod.a(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
    paramViewGroup.setOnClickListener(paramwph);
    paramViewGroup = (ImageView)paramwph.a(2131373772);
    Object localObject2 = (ImageView)paramwph.a(2131373773);
    paramInt = -657931;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      paramInt = -15980466;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ((ImageView)localObject2).setBackgroundColor(paramInt);
    localObject2 = (StoryVideoItem)this.jdField_a_of_type_Wmu.a().get(i);
    wsv.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
    label289:
    boolean bool2;
    if (wnc.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath))
    {
      paramViewGroup = wss.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);
      bool2 = false;
      xod.a(localStoryCoverView.a, paramViewGroup, 106, 170, 5, xod.b, "myStory");
      localStoryCoverView.setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      localStoryCoverView.setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      ((TextView)localObject1).setMaxWidth(xod.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
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
        paramwph.jdField_b_of_type_Int = i;
        paramwph.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Wmu;
        localTextView1.setOnClickListener(paramwph);
        paramwph.a().setOnClickListener(paramwph);
        paramwph.a().setContentDescription(alpo.a(2131707891) + ugx.jdField_a_of_type_JavaLangString + alpo.a(2131707903) + (i + 1) + alpo.a(2131707890));
        localTextView2.setOnClickListener(paramwph);
        localImageView2.setOnClickListener(paramwph);
        if (paramwph.jdField_a_of_type_Wna != null) {
          break;
        }
        paramwph.a(new wrk(this, bool1));
        return;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null) {
          wsv.e("NewMyStorySegment", "mVideoThumbnailUrl is null! vid=" + ((StoryVideoItem)localObject2).mVid);
        }
        paramViewGroup = xoa.a(((StoryVideoItem)localObject2).mVideoThumbnailUrl);
        break label289;
        localTextView3.setVisibility(0);
        localTextView3.setText(alpo.a(2131707892));
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
          paramInt = ukp.a().a(((StoryVideoItem)localObject2).mVid);
          if (paramInt >= 0) {
            localTextView3.setText(alpo.a(2131707893) + paramInt + "%");
          }
          paramViewGroup = new wrj(this, localTextView3);
          localTextView3.setTag(paramViewGroup);
          ukp.a().a(((StoryVideoItem)localObject2).mVid, paramViewGroup);
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
          if ((localTextView3.getTag() != null) && ((localTextView3.getTag() instanceof ukr))) {
            ukp.a().a((ukr)localTextView3.getTag());
          }
          localTextView3.setText(2131700083);
        }
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        if (((StoryVideoItem)localObject2).mUpLoadFailedError == 10404) {
          localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131700086));
        }
        ((TextView)localObject1).setVisibility(8);
        localImageView3.setVisibility(8);
        localImageView2.setVisibility(0);
        localTextView3.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView3.setVisibility(0);
        localTextView3.setText(alpo.a(2131707897));
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
      paramViewGroup = ((TroopManager)vhj.a().getManager(52)).b((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.get(0));
      if ((paramViewGroup == null) || (TextUtils.isEmpty(paramViewGroup.getTroopName()))) {
        break label1221;
      }
      paramViewGroup = alpo.a(2131707894) + paramViewGroup.getTroopName();
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
  
  private void b(wph paramwph, int paramInt)
  {
    TextView localTextView1 = (TextView)paramwph.a(2131373769);
    TextView localTextView2 = (TextView)paramwph.a(2131373821);
    ImageView localImageView = (ImageView)paramwph.a(2131373771);
    TextView localTextView3 = (TextView)paramwph.a(2131373824);
    paramwph = (ImageView)paramwph.a(2131373767);
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
      paramwph.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramwph.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 3: 
    case 6: 
      localTextView1.setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView2.setVisibility(8);
      paramwph.setVisibility(8);
      localImageView.setVisibility(0);
      return;
    case 9: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramwph.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    }
    localTextView3.setVisibility(8);
    paramwph.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  private void c(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramwph.a(2131369433);
    View localView1 = paramwph.a(2131369468);
    View localView2 = paramwph.a(2131369469);
    paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166986);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramwph.a(2131377682);
    localView1 = paramwph.a(2131377580);
    paramViewGroup.setOnClickListener(paramwph);
    localView1.setOnClickListener(paramwph);
    if (paramwph.jdField_a_of_type_Wna == null) {
      paramwph.a(new wrl(this));
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Wmu != null) && (this.jdField_a_of_type_Wmu.a().size() > 0)) {
        return this.jdField_a_of_type_Wmu.a().size() + 2;
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
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    int i = a(paramInt);
    wsv.a("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return paramwph.a();
      a(paramInt, paramwph, paramViewGroup);
      continue;
      b(paramInt, paramwph, paramViewGroup);
      continue;
      c(paramInt, paramwph, paramViewGroup);
    }
  }
  
  public String a()
  {
    return "NewMyStorySegment";
  }
  
  public woi a()
  {
    return new woi(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = null;
    }
    while (paramViewGroup != null)
    {
      return new wph(paramViewGroup);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561560, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561561, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561450, paramViewGroup, false);
    }
    return new wph(new TextView(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_Wmu.a(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131707899), 0).a();
    m();
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_Wmu.a(paramString);
    this.jdField_a_of_type_Wmu.c(paramString);
    if (this.jdField_a_of_type_Wmu.a().size() == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Wmu.jdField_b_of_type_Boolean = false;
    }
    ((wkv)urr.a(12)).a(this.jdField_a_of_type_Wmu.jdField_a_of_type_Usu.jdField_a_of_type_JavaLangString, 0, paramString);
    m();
  }
  
  protected void a(ukn paramukn)
  {
    wsv.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramukn);
    Object localObject1 = paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_Wmu.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      wsv.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_Wmu.a((StoryVideoItem)localObject1);
      if (paramukn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
        break label268;
      }
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramukn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    for (;;)
    {
      if (paramukn.b != null)
      {
        this.jdField_a_of_type_Wmu.a(((StoryVideoItem)localObject1).mVid, paramukn.b);
        this.jdField_a_of_type_Wmu.jdField_b_of_type_Boolean = paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.mIsContribute;
        if ((!TextUtils.isEmpty(paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)) && (!TextUtils.equals(this.jdField_a_of_type_Wmu.jdField_a_of_type_Usu.jdField_a_of_type_JavaLangString, paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)))
        {
          wsv.a("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.jdField_a_of_type_Wmu.jdField_a_of_type_Usu.jdField_a_of_type_JavaLangString, paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
          Object localObject2 = paramukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
          localObject1 = new wol(wnt.a((String)localObject2));
          woq localwoq = (woq)this.jdField_b_of_type_Xoi.a();
          localObject2 = new wok(new wrm(this, (String)localObject2));
          woi localwoi = a();
          a(new woq[] { localObject1, localwoq, localObject2 }, localwoi);
        }
      }
      if (!paramukn.jdField_c_of_type_Boolean) {
        break label279;
      }
      a().h();
      return;
      this.jdField_a_of_type_Wmu.b((StoryVideoItem)localObject1);
      break;
      label268:
      wsv.e("NewMyStorySegment", "item error info is null!!");
    }
    label279:
    m();
  }
  
  public void a(wmu paramwmu)
  {
    this.jdField_a_of_type_Wmu = paramwmu;
    woc.a(this.jdField_a_of_type_Wmu);
    c(true);
  }
  
  public void a(wph paramwph, int paramInt)
  {
    a().t();
    if ((this.jdField_a_of_type_Wmu.a().size() > paramInt) && (this.jdField_a_of_type_Wmu.a().get(paramInt) != null))
    {
      localObject = ((StoryVideoItem)this.jdField_a_of_type_Wmu.a().get(paramInt)).mVid;
      if (!StoryVideoItem.isFakeVid((String)localObject)) {
        break label117;
      }
      ukd.a((String)localObject);
      m();
      if (!((StoryVideoItem)this.jdField_a_of_type_Wmu.a().get(paramInt)).isUploading()) {
        break label110;
      }
    }
    label110:
    for (paramwph = "1";; paramwph = "3")
    {
      wta.a("mystory", "del_onevideo", 0, 0, new String[] { paramwph });
      return;
    }
    label117:
    new uyc().a((String)localObject);
    ((StoryVideoItem)this.jdField_a_of_type_Wmu.a().get(paramInt)).mUploadStatus = 9;
    Object localObject = (TextView)paramwph.a(2131373774);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(alpo.a(2131707901));
    b(paramwph, 9);
    wta.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    m();
  }
  
  protected void a(woq[] paramArrayOfwoq)
  {
    if (this.jdField_a_of_type_Woi != null) {
      this.jdField_a_of_type_Woi.c();
    }
    this.jdField_a_of_type_Woi = new woi(this.jdField_a_of_type_AndroidOsHandler);
    a(paramArrayOfwoq, this.jdField_a_of_type_Woi);
  }
  
  protected void a(woq[] paramArrayOfwoq, woi paramwoi)
  {
    int j = paramArrayOfwoq.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        woq localwoq = paramArrayOfwoq[i];
        try
        {
          paramwoi.a(localwoq);
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
    paramwoi.a(new wru(this)).a(new wrt(this));
    paramwoi.a();
  }
  
  public void a_(wph paramwph)
  {
    super.a_(paramwph);
    ImageView localImageView1 = (ImageView)paramwph.a(2131373772);
    ImageView localImageView2 = (ImageView)paramwph.a(2131373771);
    ImageView localImageView3 = (ImageView)paramwph.a(2131373767);
    if ((localImageView3 != null) && (localImageView2 != null) && (localImageView1 != null))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localImageView3.setVisibility(8);
    }
    if (this.jdField_a_of_type_Wmu.a().size() > paramwph.jdField_b_of_type_Int)
    {
      paramwph = (StoryVideoItem)this.jdField_a_of_type_Wmu.a().get(paramwph.jdField_b_of_type_Int);
      if (!paramwph.isUploadSuc()) {
        break label135;
      }
      paramwph = "2";
    }
    for (;;)
    {
      wta.a("mystory", "slide_del", 0, 0, new String[] { paramwph });
      return;
      label135:
      if (paramwph.isUploadFail()) {
        paramwph = "3";
      } else if (paramwph.isUploading()) {
        paramwph = "1";
      } else {
        paramwph = "2";
      }
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    a(new woq[] { (woq)this.jdField_a_of_type_Xoi.a(), (woq)this.jdField_b_of_type_Xoi.a(), (woq)this.jdField_c_of_type_Xoi.a(), (woq)this.d.a() });
    return true;
  }
  
  public void b_(wph paramwph)
  {
    super.b_(paramwph);
    ((ImageView)paramwph.a(2131373772)).setVisibility(0);
    if (this.jdField_a_of_type_Wmu.a().size() > paramwph.jdField_b_of_type_Int) {
      b(paramwph, ((StoryVideoItem)this.jdField_a_of_type_Wmu.a().get(paramwph.jdField_b_of_type_Int)).mUploadStatus);
    }
  }
  
  protected void c()
  {
    uht.a().registerSubscriber(this.jdField_a_of_type_Wrx);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wrw);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wry);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((usd)urr.a(2)).b(QQStoryContext.a().b());
    List localList = ((uro)urr.a(5)).b(QQStoryContext.a().b());
    this.jdField_a_of_type_Wmu.b();
    wmu localwmu = this.jdField_a_of_type_Wmu;
    if (((Integer)this.jdField_a_of_type_Urk.b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1)
    {
      bool = true;
      localwmu.jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Wmu.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Wmu.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Urk.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      }
      this.jdField_a_of_type_Wmu.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Urk.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Wmu.jdField_a_of_type_Long = ((Integer)this.jdField_a_of_type_Urk.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Wmu.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_Urk.b("qqstory_my_newest_video_cover", ""));
      this.jdField_a_of_type_Wmu.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_Urk.b("qqstory_my_newest_video_vid", ""));
      localwmu = this.jdField_a_of_type_Wmu;
      if (((Integer)this.jdField_a_of_type_Urk.b("qqstory_my_story_have_contributed", Integer.valueOf(-1))).intValue() != 1) {
        break label471;
      }
    }
    label471:
    for (boolean bool = true;; bool = false)
    {
      localwmu.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Wmu.jdField_a_of_type_Usu.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Urk.b("qqstory_key_story_latest_feed_feature_feed_id", ""));
      this.jdField_a_of_type_Wmu.jdField_a_of_type_Usu.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_Urk.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Wmu.jdField_a_of_type_Usu.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Urk.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Wmu.jdField_a_of_type_Usu.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Urk.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(0))).intValue();
      if (localList.size() == 0) {
        wsv.d("NewMyStorySegment", "Story DB have no mystory data!");
      }
      Collections.sort(localList);
      this.jdField_a_of_type_Wmu.a(localList);
      wsv.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_Wmu.a()) });
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
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wrx);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wrw);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wry);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Woi.c();
    if (this.jdField_a_of_type_Xqj != null) {
      this.jdField_a_of_type_Xqj.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Uhn);
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
      a((wmu)paramMessage.obj);
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrh
 * JD-Core Version:    0.7.0.1
 */