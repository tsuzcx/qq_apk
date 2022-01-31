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

public class vcs
  extends wcr<uyf>
  implements Handler.Callback, IEventReceiver
{
  public static final String KEY = "NewMyStorySegment";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  protected ssy a;
  protected tcv a;
  private uyf jdField_a_of_type_Uyf;
  protected uzt a;
  private vas jdField_a_of_type_Vas;
  private vat jdField_a_of_type_Vat;
  protected vdh a;
  protected vdi a;
  protected vdj a;
  public final vzt<uzc> a;
  private wbu jdField_a_of_type_Wbu;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public final vzt<uzb> b;
  private boolean jdField_b_of_type_Boolean;
  public final vzt<uzn> c;
  private boolean c;
  public final vzt<uyy> d = new vda(this);
  
  public vcs(Activity paramActivity, vat paramvat)
  {
    super(paramActivity);
    this.jdField_a_of_type_Vzt = new vct(this);
    this.jdField_b_of_type_Vzt = new vcy(this);
    this.jdField_c_of_type_Vzt = new vcz(this);
    this.jdField_a_of_type_Ssy = new vdc(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Vat = paramvat;
    this.jdField_a_of_type_Float = (vzo.a(this.jdField_a_of_type_AndroidContentContext) - vzo.a(this.jdField_a_of_type_AndroidContentContext, 145.0F));
    this.jdField_a_of_type_Tcv = ((tcv)tdc.a(10));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Uzt = new uzt(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Uyf = new uyf();
    this.jdField_a_of_type_Vdi = new vdi(this);
    this.jdField_a_of_type_Vdh = new vdh(this);
    this.jdField_a_of_type_Vdj = new vdj(this);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Ssy);
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(uyn.b(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramStoryVideoItem;
  }
  
  private String a(uyf paramuyf, int paramInt, TextPaint paramTextPaint)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(paramuyf.a(paramInt, paramTextPaint));
    paramuyf = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramuyf;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    tsu.a(paramStoryVideoItem, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (vzo.b()) {
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (String str1 = "1";; str1 = "2")
    {
      String str2 = "2";
      if ((TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str2 = "1";
      }
      vel.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
      paramStoryVideoItem = new VidListPlayInfo(this.jdField_a_of_type_Uyf.jdField_a_of_type_Tef.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
      tvf.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, 2, paramView);
      return;
    }
  }
  
  private void a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vas = paramvas;
    paramViewGroup = (ImageView)paramvas.a(2131373368);
    TextView localTextView = (TextView)paramvas.a(2131373324);
    ImageView localImageView1 = (ImageView)paramvas.a(2131373330);
    ImageView localImageView2 = (ImageView)paramvas.a(2131373328);
    View localView = paramvas.a(2131373329);
    this.jdField_a_of_type_Uyf.a();
    paramInt = -657931;
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (bool) {
      paramInt = -15980466;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((tdo)tdc.a(2)).a();
    if (this.jdField_a_of_type_Uyf.b() == 0)
    {
      paramViewGroup.setImageResource(2130845924);
      localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
      if (!this.jdField_b_of_type_Boolean) {
        break label335;
      }
      if (!bool) {
        break label324;
      }
      localImageView2.setImageResource(2130845759);
      label170:
      localImageView2.setContentDescription(ajyc.a(2131707515));
      if (this.jdField_a_of_type_Uyf.a().size() <= 0) {
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
      paramViewGroup.setOnClickListener(paramvas);
      paramvas.a().findViewById(2131373365).setOnClickListener(paramvas);
      if (paramvas.jdField_a_of_type_Uyl == null) {
        paramvas.a(new vdg(this));
      }
      return;
      if ((localQQUserUIItem == null) || (TextUtils.isEmpty(localQQUserUIItem.headUrl)))
      {
        veg.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
        paramViewGroup.setImageResource(2130845924);
        tkl.d();
        break;
      }
      vzo.b(paramViewGroup, vzl.b(localQQUserUIItem.headUrl), 200, 200, bbdr.a(1), "QQStory200");
      break;
      label324:
      localImageView2.setImageResource(2130845758);
      break label170;
      label335:
      if (bool) {
        localImageView2.setImageResource(2130845757);
      }
      for (;;)
      {
        localImageView2.setContentDescription(ajyc.a(2131707506));
        break;
        localImageView2.setImageResource(2130845756);
      }
      label373:
      if (this.jdField_a_of_type_Uyf.b() != 0)
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
  
  private void a(uyf paramuyf, View paramView)
  {
    if (vzo.b()) {
      return;
    }
    if (paramuyf.d) {}
    for (String str = "1"; paramuyf.b() == 0; str = "2")
    {
      vel.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_Vat.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131373368) {
      vel.a("mystory", "clk_head_data", 0, 0, new String[0]);
    }
    for (;;)
    {
      paramuyf = QQStoryContext.a().b();
      sxp.a(this.jdField_a_of_type_AndroidContentContext, 3, paramuyf);
      return;
      vel.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (vzo.b()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131373317);
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
      vel.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str });
      paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_Uyf.jdField_a_of_type_Tef.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid), 2);
      tvf.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem.a(), localStoryCoverView.a);
      return;
    }
  }
  
  private void b(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramvas.a(2131373317);
    ImageView localImageView1 = (ImageView)paramvas.a(2131373331);
    TextView localTextView1 = (TextView)paramvas.a(2131373318);
    Object localObject1 = (TextView)paramvas.a(2131373370);
    ImageView localImageView2 = (ImageView)paramvas.a(2131373320);
    TextView localTextView2 = (TextView)paramvas.a(2131373373);
    TextView localTextView3 = (TextView)paramvas.a(2131373323);
    ImageView localImageView3 = (ImageView)paramvas.a(2131373316);
    paramViewGroup = (Button)paramvas.a(2131373369);
    ImageView localImageView4 = (ImageView)paramvas.a(2131373321);
    if ((this.jdField_a_of_type_Uyf == null) || (this.jdField_a_of_type_Uyf.a() == null))
    {
      veg.e("NewMyStorySegment", "myStorys is null!");
      return;
    }
    paramvas.a().setTag(-3, Integer.valueOf(vzo.a(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
    paramViewGroup.setOnClickListener(paramvas);
    paramViewGroup = (ImageView)paramvas.a(2131373321);
    Object localObject2 = (ImageView)paramvas.a(2131373322);
    paramInt = -657931;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      paramInt = -15980466;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ((ImageView)localObject2).setBackgroundColor(paramInt);
    localObject2 = (StoryVideoItem)this.jdField_a_of_type_Uyf.a().get(i);
    veg.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
    label289:
    boolean bool2;
    if (uyn.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath))
    {
      paramViewGroup = ved.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);
      bool2 = false;
      vzo.a(localStoryCoverView.a, paramViewGroup, 106, 170, 5, vzo.b, "myStory");
      localStoryCoverView.setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      localStoryCoverView.setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      ((TextView)localObject1).setMaxWidth(vzo.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
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
        paramvas.jdField_b_of_type_Int = i;
        paramvas.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Uyf;
        localTextView1.setOnClickListener(paramvas);
        paramvas.a().setOnClickListener(paramvas);
        paramvas.a().setContentDescription(ajyc.a(2131707508) + ssi.jdField_a_of_type_JavaLangString + ajyc.a(2131707520) + (i + 1) + ajyc.a(2131707507));
        localTextView2.setOnClickListener(paramvas);
        localImageView2.setOnClickListener(paramvas);
        if (paramvas.jdField_a_of_type_Uyl != null) {
          break;
        }
        paramvas.a(new vcv(this, bool1));
        return;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null) {
          veg.e("NewMyStorySegment", "mVideoThumbnailUrl is null! vid=" + ((StoryVideoItem)localObject2).mVid);
        }
        paramViewGroup = vzl.a(((StoryVideoItem)localObject2).mVideoThumbnailUrl);
        break label289;
        localTextView3.setVisibility(0);
        localTextView3.setText(ajyc.a(2131707509));
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
          paramInt = swa.a().a(((StoryVideoItem)localObject2).mVid);
          if (paramInt >= 0) {
            localTextView3.setText(ajyc.a(2131707510) + paramInt + "%");
          }
          paramViewGroup = new vcu(this, localTextView3);
          localTextView3.setTag(paramViewGroup);
          swa.a().a(((StoryVideoItem)localObject2).mVid, paramViewGroup);
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
          if ((localTextView3.getTag() != null) && ((localTextView3.getTag() instanceof swc))) {
            swa.a().a((swc)localTextView3.getTag());
          }
          localTextView3.setText(2131699703);
        }
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        if (((StoryVideoItem)localObject2).mUpLoadFailedError == 10404) {
          localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131699706));
        }
        ((TextView)localObject1).setVisibility(8);
        localImageView3.setVisibility(8);
        localImageView2.setVisibility(0);
        localTextView3.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView3.setVisibility(0);
        localTextView3.setText(ajyc.a(2131707514));
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
      paramViewGroup = ((TroopManager)tsu.a().getManager(52)).b((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.get(0));
      if ((paramViewGroup == null) || (TextUtils.isEmpty(paramViewGroup.getTroopName()))) {
        break label1221;
      }
      paramViewGroup = ajyc.a(2131707511) + paramViewGroup.getTroopName();
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
  
  private void b(vas paramvas, int paramInt)
  {
    TextView localTextView1 = (TextView)paramvas.a(2131373318);
    TextView localTextView2 = (TextView)paramvas.a(2131373370);
    ImageView localImageView = (ImageView)paramvas.a(2131373320);
    TextView localTextView3 = (TextView)paramvas.a(2131373373);
    paramvas = (ImageView)paramvas.a(2131373316);
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
      paramvas.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramvas.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 3: 
    case 6: 
      localTextView1.setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView2.setVisibility(8);
      paramvas.setVisibility(8);
      localImageView.setVisibility(0);
      return;
    case 9: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramvas.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    }
    localTextView3.setVisibility(8);
    paramvas.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  private void c(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramvas.a(2131369200);
    View localView1 = paramvas.a(2131369235);
    View localView2 = paramvas.a(2131369236);
    paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166938);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramvas.a(2131377159);
    localView1 = paramvas.a(2131377057);
    paramViewGroup.setOnClickListener(paramvas);
    localView1.setOnClickListener(paramvas);
    if (paramvas.jdField_a_of_type_Uyl == null) {
      paramvas.a(new vcw(this));
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Uyf != null) && (this.jdField_a_of_type_Uyf.a().size() > 0)) {
        return this.jdField_a_of_type_Uyf.a().size() + 2;
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
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    int i = a(paramInt);
    veg.a("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return paramvas.a();
      a(paramInt, paramvas, paramViewGroup);
      continue;
      b(paramInt, paramvas, paramViewGroup);
      continue;
      c(paramInt, paramvas, paramViewGroup);
    }
  }
  
  public String a()
  {
    return "NewMyStorySegment";
  }
  
  public uzt a()
  {
    return new uzt(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = null;
    }
    while (paramViewGroup != null)
    {
      return new vas(paramViewGroup);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561371, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561372, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561261, paramViewGroup, false);
    }
    return new vas(new TextView(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_Uyf.a(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131707516), 0).a();
    m();
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_Uyf.a(paramString);
    this.jdField_a_of_type_Uyf.c(paramString);
    if (this.jdField_a_of_type_Uyf.a().size() == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Uyf.jdField_b_of_type_Boolean = false;
    }
    ((uwg)tdc.a(12)).a(this.jdField_a_of_type_Uyf.jdField_a_of_type_Tef.jdField_a_of_type_JavaLangString, 0, paramString);
    m();
  }
  
  protected void a(svy paramsvy)
  {
    veg.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramsvy);
    Object localObject1 = paramsvy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_Uyf.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      veg.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_Uyf.a((StoryVideoItem)localObject1);
      if (paramsvy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
        break label268;
      }
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramsvy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    for (;;)
    {
      if (paramsvy.b != null)
      {
        this.jdField_a_of_type_Uyf.a(((StoryVideoItem)localObject1).mVid, paramsvy.b);
        this.jdField_a_of_type_Uyf.jdField_b_of_type_Boolean = paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.mIsContribute;
        if ((!TextUtils.isEmpty(paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)) && (!TextUtils.equals(this.jdField_a_of_type_Uyf.jdField_a_of_type_Tef.jdField_a_of_type_JavaLangString, paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)))
        {
          veg.a("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.jdField_a_of_type_Uyf.jdField_a_of_type_Tef.jdField_a_of_type_JavaLangString, paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
          Object localObject2 = paramsvy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
          localObject1 = new uzw(uze.a((String)localObject2));
          vab localvab = (vab)this.jdField_b_of_type_Vzt.a();
          localObject2 = new uzv(new vcx(this, (String)localObject2));
          uzt localuzt = a();
          a(new vab[] { localObject1, localvab, localObject2 }, localuzt);
        }
      }
      if (!paramsvy.jdField_c_of_type_Boolean) {
        break label279;
      }
      a().h();
      return;
      this.jdField_a_of_type_Uyf.b((StoryVideoItem)localObject1);
      break;
      label268:
      veg.e("NewMyStorySegment", "item error info is null!!");
    }
    label279:
    m();
  }
  
  public void a(uyf paramuyf)
  {
    this.jdField_a_of_type_Uyf = paramuyf;
    uzn.a(this.jdField_a_of_type_Uyf);
    c(true);
  }
  
  public void a(vas paramvas, int paramInt)
  {
    a().t();
    if ((this.jdField_a_of_type_Uyf.a().size() > paramInt) && (this.jdField_a_of_type_Uyf.a().get(paramInt) != null))
    {
      localObject = ((StoryVideoItem)this.jdField_a_of_type_Uyf.a().get(paramInt)).mVid;
      if (!StoryVideoItem.isFakeVid((String)localObject)) {
        break label117;
      }
      svo.a((String)localObject);
      m();
      if (!((StoryVideoItem)this.jdField_a_of_type_Uyf.a().get(paramInt)).isUploading()) {
        break label110;
      }
    }
    label110:
    for (paramvas = "1";; paramvas = "3")
    {
      vel.a("mystory", "del_onevideo", 0, 0, new String[] { paramvas });
      return;
    }
    label117:
    new tjn().a((String)localObject);
    ((StoryVideoItem)this.jdField_a_of_type_Uyf.a().get(paramInt)).mUploadStatus = 9;
    Object localObject = (TextView)paramvas.a(2131373323);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(ajyc.a(2131707518));
    b(paramvas, 9);
    vel.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    m();
  }
  
  protected void a(vab[] paramArrayOfvab)
  {
    if (this.jdField_a_of_type_Uzt != null) {
      this.jdField_a_of_type_Uzt.c();
    }
    this.jdField_a_of_type_Uzt = new uzt(this.jdField_a_of_type_AndroidOsHandler);
    a(paramArrayOfvab, this.jdField_a_of_type_Uzt);
  }
  
  protected void a(vab[] paramArrayOfvab, uzt paramuzt)
  {
    int j = paramArrayOfvab.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        vab localvab = paramArrayOfvab[i];
        try
        {
          paramuzt.a(localvab);
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
    paramuzt.a(new vdf(this)).a(new vde(this));
    paramuzt.a();
  }
  
  public void a_(vas paramvas)
  {
    super.a_(paramvas);
    ImageView localImageView1 = (ImageView)paramvas.a(2131373321);
    ImageView localImageView2 = (ImageView)paramvas.a(2131373320);
    ImageView localImageView3 = (ImageView)paramvas.a(2131373316);
    if ((localImageView3 != null) && (localImageView2 != null) && (localImageView1 != null))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localImageView3.setVisibility(8);
    }
    if (this.jdField_a_of_type_Uyf.a().size() > paramvas.jdField_b_of_type_Int)
    {
      paramvas = (StoryVideoItem)this.jdField_a_of_type_Uyf.a().get(paramvas.jdField_b_of_type_Int);
      if (!paramvas.isUploadSuc()) {
        break label135;
      }
      paramvas = "2";
    }
    for (;;)
    {
      vel.a("mystory", "slide_del", 0, 0, new String[] { paramvas });
      return;
      label135:
      if (paramvas.isUploadFail()) {
        paramvas = "3";
      } else if (paramvas.isUploading()) {
        paramvas = "1";
      } else {
        paramvas = "2";
      }
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    a(new vab[] { (vab)this.jdField_a_of_type_Vzt.a(), (vab)this.jdField_b_of_type_Vzt.a(), (vab)this.jdField_c_of_type_Vzt.a(), (vab)this.d.a() });
    return true;
  }
  
  public void b_(vas paramvas)
  {
    super.b_(paramvas);
    ((ImageView)paramvas.a(2131373321)).setVisibility(0);
    if (this.jdField_a_of_type_Uyf.a().size() > paramvas.jdField_b_of_type_Int) {
      b(paramvas, ((StoryVideoItem)this.jdField_a_of_type_Uyf.a().get(paramvas.jdField_b_of_type_Int)).mUploadStatus);
    }
  }
  
  protected void c()
  {
    ste.a().registerSubscriber(this.jdField_a_of_type_Vdi);
    ste.a().registerSubscriber(this.jdField_a_of_type_Vdh);
    ste.a().registerSubscriber(this.jdField_a_of_type_Vdj);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((tdo)tdc.a(2)).b(QQStoryContext.a().b());
    List localList = ((tcz)tdc.a(5)).b(QQStoryContext.a().b());
    this.jdField_a_of_type_Uyf.b();
    uyf localuyf = this.jdField_a_of_type_Uyf;
    if (((Integer)this.jdField_a_of_type_Tcv.b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1)
    {
      bool = true;
      localuyf.jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Uyf.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Uyf.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Tcv.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      }
      this.jdField_a_of_type_Uyf.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Tcv.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Uyf.jdField_a_of_type_Long = ((Integer)this.jdField_a_of_type_Tcv.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Uyf.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_Tcv.b("qqstory_my_newest_video_cover", ""));
      this.jdField_a_of_type_Uyf.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_Tcv.b("qqstory_my_newest_video_vid", ""));
      localuyf = this.jdField_a_of_type_Uyf;
      if (((Integer)this.jdField_a_of_type_Tcv.b("qqstory_my_story_have_contributed", Integer.valueOf(-1))).intValue() != 1) {
        break label471;
      }
    }
    label471:
    for (boolean bool = true;; bool = false)
    {
      localuyf.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Uyf.jdField_a_of_type_Tef.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Tcv.b("qqstory_key_story_latest_feed_feature_feed_id", ""));
      this.jdField_a_of_type_Uyf.jdField_a_of_type_Tef.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_Tcv.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Uyf.jdField_a_of_type_Tef.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Tcv.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Uyf.jdField_a_of_type_Tef.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Tcv.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(0))).intValue();
      if (localList.size() == 0) {
        veg.d("NewMyStorySegment", "Story DB have no mystory data!");
      }
      Collections.sort(localList);
      this.jdField_a_of_type_Uyf.a(localList);
      veg.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_Uyf.a()) });
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
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Vdi);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Vdh);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Vdj);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Uzt.c();
    if (this.jdField_a_of_type_Wbu != null) {
      this.jdField_a_of_type_Wbu.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ssy);
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
      a((uyf)paramMessage.obj);
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcs
 * JD-Core Version:    0.7.0.1
 */