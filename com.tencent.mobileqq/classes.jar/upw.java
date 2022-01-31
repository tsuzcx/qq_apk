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

public class upw
  extends vpv<ulj>
  implements Handler.Callback, IEventReceiver
{
  public static final String KEY = "NewMyStorySegment";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  protected sgc a;
  protected spz a;
  private ulj jdField_a_of_type_Ulj;
  protected umx a;
  private unw jdField_a_of_type_Unw;
  private unx jdField_a_of_type_Unx;
  protected uql a;
  protected uqm a;
  protected uqn a;
  public final vmx<umg> a;
  private voy jdField_a_of_type_Voy;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public final vmx<umf> b;
  private boolean jdField_b_of_type_Boolean;
  public final vmx<umr> c;
  private boolean c;
  public final vmx<umc> d = new uqe(this);
  
  public upw(Activity paramActivity, unx paramunx)
  {
    super(paramActivity);
    this.jdField_a_of_type_Vmx = new upx(this);
    this.jdField_b_of_type_Vmx = new uqc(this);
    this.jdField_c_of_type_Vmx = new uqd(this);
    this.jdField_a_of_type_Sgc = new uqg(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Unx = paramunx;
    this.jdField_a_of_type_Float = (vms.a(this.jdField_a_of_type_AndroidContentContext) - vms.a(this.jdField_a_of_type_AndroidContentContext, 145.0F));
    this.jdField_a_of_type_Spz = ((spz)sqg.a(10));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Umx = new umx(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Ulj = new ulj();
    this.jdField_a_of_type_Uqm = new uqm(this);
    this.jdField_a_of_type_Uql = new uql(this);
    this.jdField_a_of_type_Uqn = new uqn(this);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Sgc);
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(ulr.b(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramStoryVideoItem;
  }
  
  private String a(ulj paramulj, int paramInt, TextPaint paramTextPaint)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(paramulj.a(paramInt, paramTextPaint));
    paramulj = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramulj;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    tfy.a(paramStoryVideoItem, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (vms.b()) {
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (String str1 = "1";; str1 = "2")
    {
      String str2 = "2";
      if ((TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str2 = "1";
      }
      urp.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
      paramStoryVideoItem = new VidListPlayInfo(this.jdField_a_of_type_Ulj.jdField_a_of_type_Srj.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
      tij.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, 2, paramView);
      return;
    }
  }
  
  private void a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Unw = paramunw;
    paramViewGroup = (ImageView)paramunw.a(2131307655);
    TextView localTextView = (TextView)paramunw.a(2131307611);
    ImageView localImageView1 = (ImageView)paramunw.a(2131307617);
    ImageView localImageView2 = (ImageView)paramunw.a(2131307615);
    View localView = paramunw.a(2131307616);
    this.jdField_a_of_type_Ulj.a();
    paramInt = -657931;
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (bool) {
      paramInt = -15980466;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((sqs)sqg.a(2)).a();
    if (this.jdField_a_of_type_Ulj.b() == 0)
    {
      paramViewGroup.setImageResource(2130845742);
      localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
      if (!this.jdField_b_of_type_Boolean) {
        break label335;
      }
      if (!bool) {
        break label324;
      }
      localImageView2.setImageResource(2130845576);
      label170:
      localImageView2.setContentDescription(ajjy.a(2131641730));
      if (this.jdField_a_of_type_Ulj.a().size() <= 0) {
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
      paramViewGroup.setOnClickListener(paramunw);
      paramunw.a().findViewById(2131307652).setOnClickListener(paramunw);
      if (paramunw.jdField_a_of_type_Ulp == null) {
        paramunw.a(new uqk(this));
      }
      return;
      if ((localQQUserUIItem == null) || (TextUtils.isEmpty(localQQUserUIItem.headUrl)))
      {
        urk.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
        paramViewGroup.setImageResource(2130845742);
        sxp.d();
        break;
      }
      vms.b(paramViewGroup, vmp.b(localQQUserUIItem.headUrl), 200, 200, bacm.a(1), "QQStory200");
      break;
      label324:
      localImageView2.setImageResource(2130845575);
      break label170;
      label335:
      if (bool) {
        localImageView2.setImageResource(2130845574);
      }
      for (;;)
      {
        localImageView2.setContentDescription(ajjy.a(2131641721));
        break;
        localImageView2.setImageResource(2130845573);
      }
      label373:
      if (this.jdField_a_of_type_Ulj.b() != 0)
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
  
  private void a(ulj paramulj, View paramView)
  {
    if (vms.b()) {
      return;
    }
    if (paramulj.d) {}
    for (String str = "1"; paramulj.b() == 0; str = "2")
    {
      urp.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_Unx.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131307655) {
      urp.a("mystory", "clk_head_data", 0, 0, new String[0]);
    }
    for (;;)
    {
      paramulj = QQStoryContext.a().b();
      skt.a(this.jdField_a_of_type_AndroidContentContext, 3, paramulj);
      return;
      urp.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (vms.b()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131307604);
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
      urp.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str });
      paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_Ulj.jdField_a_of_type_Srj.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid), 2);
      tij.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem.a(), localStoryCoverView.a);
      return;
    }
  }
  
  private void b(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramunw.a(2131307604);
    ImageView localImageView1 = (ImageView)paramunw.a(2131307618);
    TextView localTextView1 = (TextView)paramunw.a(2131307605);
    Object localObject1 = (TextView)paramunw.a(2131307657);
    ImageView localImageView2 = (ImageView)paramunw.a(2131307607);
    TextView localTextView2 = (TextView)paramunw.a(2131307660);
    TextView localTextView3 = (TextView)paramunw.a(2131307610);
    ImageView localImageView3 = (ImageView)paramunw.a(2131307603);
    paramViewGroup = (Button)paramunw.a(2131307656);
    ImageView localImageView4 = (ImageView)paramunw.a(2131307608);
    if ((this.jdField_a_of_type_Ulj == null) || (this.jdField_a_of_type_Ulj.a() == null))
    {
      urk.e("NewMyStorySegment", "myStorys is null!");
      return;
    }
    paramunw.a().setTag(-3, Integer.valueOf(vms.a(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
    paramViewGroup.setOnClickListener(paramunw);
    paramViewGroup = (ImageView)paramunw.a(2131307608);
    Object localObject2 = (ImageView)paramunw.a(2131307609);
    paramInt = -657931;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      paramInt = -15980466;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ((ImageView)localObject2).setBackgroundColor(paramInt);
    localObject2 = (StoryVideoItem)this.jdField_a_of_type_Ulj.a().get(i);
    urk.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
    label289:
    boolean bool2;
    if (ulr.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath))
    {
      paramViewGroup = urh.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);
      bool2 = false;
      vms.a(localStoryCoverView.a, paramViewGroup, 106, 170, 5, vms.b, "myStory");
      localStoryCoverView.setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      localStoryCoverView.setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      ((TextView)localObject1).setMaxWidth(vms.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
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
        paramunw.jdField_b_of_type_Int = i;
        paramunw.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Ulj;
        localTextView1.setOnClickListener(paramunw);
        paramunw.a().setOnClickListener(paramunw);
        paramunw.a().setContentDescription(ajjy.a(2131641723) + sfm.jdField_a_of_type_JavaLangString + ajjy.a(2131641735) + (i + 1) + ajjy.a(2131641722));
        localTextView2.setOnClickListener(paramunw);
        localImageView2.setOnClickListener(paramunw);
        if (paramunw.jdField_a_of_type_Ulp != null) {
          break;
        }
        paramunw.a(new upz(this, bool1));
        return;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null) {
          urk.e("NewMyStorySegment", "mVideoThumbnailUrl is null! vid=" + ((StoryVideoItem)localObject2).mVid);
        }
        paramViewGroup = vmp.a(((StoryVideoItem)localObject2).mVideoThumbnailUrl);
        break label289;
        localTextView3.setVisibility(0);
        localTextView3.setText(ajjy.a(2131641724));
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
          paramInt = sje.a().a(((StoryVideoItem)localObject2).mVid);
          if (paramInt >= 0) {
            localTextView3.setText(ajjy.a(2131641725) + paramInt + "%");
          }
          paramViewGroup = new upy(this, localTextView3);
          localTextView3.setTag(paramViewGroup);
          sje.a().a(((StoryVideoItem)localObject2).mVid, paramViewGroup);
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
          if ((localTextView3.getTag() != null) && ((localTextView3.getTag() instanceof sjg))) {
            sje.a().a((sjg)localTextView3.getTag());
          }
          localTextView3.setText(2131633915);
        }
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        if (((StoryVideoItem)localObject2).mUpLoadFailedError == 10404) {
          localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131633918));
        }
        ((TextView)localObject1).setVisibility(8);
        localImageView3.setVisibility(8);
        localImageView2.setVisibility(0);
        localTextView3.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView3.setVisibility(0);
        localTextView3.setText(ajjy.a(2131641729));
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
      paramViewGroup = ((TroopManager)tfy.a().getManager(52)).b((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.get(0));
      if ((paramViewGroup == null) || (TextUtils.isEmpty(paramViewGroup.getTroopName()))) {
        break label1221;
      }
      paramViewGroup = ajjy.a(2131641726) + paramViewGroup.getTroopName();
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
  
  private void b(unw paramunw, int paramInt)
  {
    TextView localTextView1 = (TextView)paramunw.a(2131307605);
    TextView localTextView2 = (TextView)paramunw.a(2131307657);
    ImageView localImageView = (ImageView)paramunw.a(2131307607);
    TextView localTextView3 = (TextView)paramunw.a(2131307660);
    paramunw = (ImageView)paramunw.a(2131307603);
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
      paramunw.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramunw.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 3: 
    case 6: 
      localTextView1.setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView2.setVisibility(8);
      paramunw.setVisibility(8);
      localImageView.setVisibility(0);
      return;
    case 9: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramunw.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    }
    localTextView3.setVisibility(8);
    paramunw.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  private void c(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramunw.a(2131303531);
    View localView1 = paramunw.a(2131303566);
    View localView2 = paramunw.a(2131303567);
    paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101343);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramunw.a(2131311348);
    localView1 = paramunw.a(2131311247);
    paramViewGroup.setOnClickListener(paramunw);
    localView1.setOnClickListener(paramunw);
    if (paramunw.jdField_a_of_type_Ulp == null) {
      paramunw.a(new uqa(this));
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Ulj != null) && (this.jdField_a_of_type_Ulj.a().size() > 0)) {
        return this.jdField_a_of_type_Ulj.a().size() + 2;
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
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    int i = a(paramInt);
    urk.a("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return paramunw.a();
      a(paramInt, paramunw, paramViewGroup);
      continue;
      b(paramInt, paramunw, paramViewGroup);
      continue;
      c(paramInt, paramunw, paramViewGroup);
    }
  }
  
  public String a()
  {
    return "NewMyStorySegment";
  }
  
  public umx a()
  {
    return new umx(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = null;
    }
    while (paramViewGroup != null)
    {
      return new unw(paramViewGroup);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495780, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495781, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495670, paramViewGroup, false);
    }
    return new unw(new TextView(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_Ulj.a(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131641731), 0).a();
    m();
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_Ulj.a(paramString);
    this.jdField_a_of_type_Ulj.c(paramString);
    if (this.jdField_a_of_type_Ulj.a().size() == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Ulj.jdField_b_of_type_Boolean = false;
    }
    ((ujk)sqg.a(12)).a(this.jdField_a_of_type_Ulj.jdField_a_of_type_Srj.jdField_a_of_type_JavaLangString, 0, paramString);
    m();
  }
  
  protected void a(sjc paramsjc)
  {
    urk.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramsjc);
    Object localObject1 = paramsjc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_Ulj.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      urk.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_Ulj.a((StoryVideoItem)localObject1);
      if (paramsjc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
        break label268;
      }
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramsjc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    for (;;)
    {
      if (paramsjc.b != null)
      {
        this.jdField_a_of_type_Ulj.a(((StoryVideoItem)localObject1).mVid, paramsjc.b);
        this.jdField_a_of_type_Ulj.jdField_b_of_type_Boolean = paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.mIsContribute;
        if ((!TextUtils.isEmpty(paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)) && (!TextUtils.equals(this.jdField_a_of_type_Ulj.jdField_a_of_type_Srj.jdField_a_of_type_JavaLangString, paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)))
        {
          urk.a("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.jdField_a_of_type_Ulj.jdField_a_of_type_Srj.jdField_a_of_type_JavaLangString, paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
          Object localObject2 = paramsjc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
          localObject1 = new una(umi.a((String)localObject2));
          unf localunf = (unf)this.jdField_b_of_type_Vmx.a();
          localObject2 = new umz(new uqb(this, (String)localObject2));
          umx localumx = a();
          a(new unf[] { localObject1, localunf, localObject2 }, localumx);
        }
      }
      if (!paramsjc.jdField_c_of_type_Boolean) {
        break label279;
      }
      a().h();
      return;
      this.jdField_a_of_type_Ulj.b((StoryVideoItem)localObject1);
      break;
      label268:
      urk.e("NewMyStorySegment", "item error info is null!!");
    }
    label279:
    m();
  }
  
  public void a(ulj paramulj)
  {
    this.jdField_a_of_type_Ulj = paramulj;
    umr.a(this.jdField_a_of_type_Ulj);
    c(true);
  }
  
  public void a(unw paramunw, int paramInt)
  {
    a().t();
    if ((this.jdField_a_of_type_Ulj.a().size() > paramInt) && (this.jdField_a_of_type_Ulj.a().get(paramInt) != null))
    {
      localObject = ((StoryVideoItem)this.jdField_a_of_type_Ulj.a().get(paramInt)).mVid;
      if (!StoryVideoItem.isFakeVid((String)localObject)) {
        break label117;
      }
      sis.a((String)localObject);
      m();
      if (!((StoryVideoItem)this.jdField_a_of_type_Ulj.a().get(paramInt)).isUploading()) {
        break label110;
      }
    }
    label110:
    for (paramunw = "1";; paramunw = "3")
    {
      urp.a("mystory", "del_onevideo", 0, 0, new String[] { paramunw });
      return;
    }
    label117:
    new swr().a((String)localObject);
    ((StoryVideoItem)this.jdField_a_of_type_Ulj.a().get(paramInt)).mUploadStatus = 9;
    Object localObject = (TextView)paramunw.a(2131307610);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(ajjy.a(2131641733));
    b(paramunw, 9);
    urp.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    m();
  }
  
  protected void a(unf[] paramArrayOfunf)
  {
    if (this.jdField_a_of_type_Umx != null) {
      this.jdField_a_of_type_Umx.c();
    }
    this.jdField_a_of_type_Umx = new umx(this.jdField_a_of_type_AndroidOsHandler);
    a(paramArrayOfunf, this.jdField_a_of_type_Umx);
  }
  
  protected void a(unf[] paramArrayOfunf, umx paramumx)
  {
    int j = paramArrayOfunf.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        unf localunf = paramArrayOfunf[i];
        try
        {
          paramumx.a(localunf);
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
    paramumx.a(new uqj(this)).a(new uqi(this));
    paramumx.a();
  }
  
  public void a_(unw paramunw)
  {
    super.a_(paramunw);
    ImageView localImageView1 = (ImageView)paramunw.a(2131307608);
    ImageView localImageView2 = (ImageView)paramunw.a(2131307607);
    ImageView localImageView3 = (ImageView)paramunw.a(2131307603);
    if ((localImageView3 != null) && (localImageView2 != null) && (localImageView1 != null))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localImageView3.setVisibility(8);
    }
    if (this.jdField_a_of_type_Ulj.a().size() > paramunw.jdField_b_of_type_Int)
    {
      paramunw = (StoryVideoItem)this.jdField_a_of_type_Ulj.a().get(paramunw.jdField_b_of_type_Int);
      if (!paramunw.isUploadSuc()) {
        break label135;
      }
      paramunw = "2";
    }
    for (;;)
    {
      urp.a("mystory", "slide_del", 0, 0, new String[] { paramunw });
      return;
      label135:
      if (paramunw.isUploadFail()) {
        paramunw = "3";
      } else if (paramunw.isUploading()) {
        paramunw = "1";
      } else {
        paramunw = "2";
      }
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    a(new unf[] { (unf)this.jdField_a_of_type_Vmx.a(), (unf)this.jdField_b_of_type_Vmx.a(), (unf)this.jdField_c_of_type_Vmx.a(), (unf)this.d.a() });
    return true;
  }
  
  public void b_(unw paramunw)
  {
    super.b_(paramunw);
    ((ImageView)paramunw.a(2131307608)).setVisibility(0);
    if (this.jdField_a_of_type_Ulj.a().size() > paramunw.jdField_b_of_type_Int) {
      b(paramunw, ((StoryVideoItem)this.jdField_a_of_type_Ulj.a().get(paramunw.jdField_b_of_type_Int)).mUploadStatus);
    }
  }
  
  protected void c()
  {
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uqm);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uql);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uqn);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((sqs)sqg.a(2)).b(QQStoryContext.a().b());
    List localList = ((sqd)sqg.a(5)).b(QQStoryContext.a().b());
    this.jdField_a_of_type_Ulj.b();
    ulj localulj = this.jdField_a_of_type_Ulj;
    if (((Integer)this.jdField_a_of_type_Spz.b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1)
    {
      bool = true;
      localulj.jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Ulj.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Ulj.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Spz.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      }
      this.jdField_a_of_type_Ulj.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Spz.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Ulj.jdField_a_of_type_Long = ((Integer)this.jdField_a_of_type_Spz.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Ulj.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_Spz.b("qqstory_my_newest_video_cover", ""));
      this.jdField_a_of_type_Ulj.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_Spz.b("qqstory_my_newest_video_vid", ""));
      localulj = this.jdField_a_of_type_Ulj;
      if (((Integer)this.jdField_a_of_type_Spz.b("qqstory_my_story_have_contributed", Integer.valueOf(-1))).intValue() != 1) {
        break label471;
      }
    }
    label471:
    for (boolean bool = true;; bool = false)
    {
      localulj.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Ulj.jdField_a_of_type_Srj.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Spz.b("qqstory_key_story_latest_feed_feature_feed_id", ""));
      this.jdField_a_of_type_Ulj.jdField_a_of_type_Srj.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_Spz.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Ulj.jdField_a_of_type_Srj.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Spz.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Ulj.jdField_a_of_type_Srj.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Spz.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(0))).intValue();
      if (localList.size() == 0) {
        urk.d("NewMyStorySegment", "Story DB have no mystory data!");
      }
      Collections.sort(localList);
      this.jdField_a_of_type_Ulj.a(localList);
      urk.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_Ulj.a()) });
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
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uqm);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uql);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uqn);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Umx.c();
    if (this.jdField_a_of_type_Voy != null) {
      this.jdField_a_of_type_Voy.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Sgc);
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
      a((ulj)paramMessage.obj);
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upw
 * JD-Core Version:    0.7.0.1
 */