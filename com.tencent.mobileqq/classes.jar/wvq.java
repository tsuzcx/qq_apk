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

public class wvq
  extends xvp<wrd>
  implements Handler.Callback, IEventReceiver
{
  public static final String KEY = "NewMyStorySegment";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  protected ulw a;
  protected uvt a;
  private wrd jdField_a_of_type_Wrd;
  protected wsr a;
  private wtq jdField_a_of_type_Wtq;
  private wtr jdField_a_of_type_Wtr;
  protected wwf a;
  protected wwg a;
  protected wwh a;
  public final xsr<wsa> a;
  private xus jdField_a_of_type_Xus;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public final xsr<wrz> b;
  private boolean jdField_b_of_type_Boolean;
  public final xsr<wsl> c;
  private boolean c;
  public final xsr<wrw> d = new wvy(this);
  
  public wvq(Activity paramActivity, wtr paramwtr)
  {
    super(paramActivity);
    this.jdField_a_of_type_Xsr = new wvr(this);
    this.jdField_b_of_type_Xsr = new wvw(this);
    this.jdField_c_of_type_Xsr = new wvx(this);
    this.jdField_a_of_type_Ulw = new wwa(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Wtr = paramwtr;
    this.jdField_a_of_type_Float = (xsm.a(this.jdField_a_of_type_AndroidContentContext) - xsm.a(this.jdField_a_of_type_AndroidContentContext, 145.0F));
    this.jdField_a_of_type_Uvt = ((uvt)uwa.a(10));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Wsr = new wsr(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Wrd = new wrd();
    this.jdField_a_of_type_Wwg = new wwg(this);
    this.jdField_a_of_type_Wwf = new wwf(this);
    this.jdField_a_of_type_Wwh = new wwh(this);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Ulw);
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(wrl.b(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramStoryVideoItem;
  }
  
  private String a(wrd paramwrd, int paramInt, TextPaint paramTextPaint)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(paramwrd.a(paramInt, paramTextPaint));
    paramwrd = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramwrd;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    vls.a(paramStoryVideoItem, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (xsm.b()) {
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (String str1 = "1";; str1 = "2")
    {
      String str2 = "2";
      if ((TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str2 = "1";
      }
      wxj.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
      paramStoryVideoItem = new VidListPlayInfo(this.jdField_a_of_type_Wrd.jdField_a_of_type_Uxd.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
      vod.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, 2, paramView);
      return;
    }
  }
  
  private void a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wtq = paramwtq;
    paramViewGroup = (ImageView)paramwtq.a(2131373870);
    TextView localTextView = (TextView)paramwtq.a(2131373826);
    ImageView localImageView1 = (ImageView)paramwtq.a(2131373832);
    ImageView localImageView2 = (ImageView)paramwtq.a(2131373830);
    View localView = paramwtq.a(2131373831);
    this.jdField_a_of_type_Wrd.a();
    paramInt = -657931;
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (bool) {
      paramInt = -15980466;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((uwm)uwa.a(2)).a();
    if (this.jdField_a_of_type_Wrd.b() == 0)
    {
      paramViewGroup.setImageResource(2130846382);
      localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
      if (!this.jdField_b_of_type_Boolean) {
        break label335;
      }
      if (!bool) {
        break label324;
      }
      localImageView2.setImageResource(2130846217);
      label170:
      localImageView2.setContentDescription(alud.a(2131707910));
      if (this.jdField_a_of_type_Wrd.a().size() <= 0) {
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
      paramViewGroup.setOnClickListener(paramwtq);
      paramwtq.a().findViewById(2131373867).setOnClickListener(paramwtq);
      if (paramwtq.jdField_a_of_type_Wrj == null) {
        paramwtq.a(new wwe(this));
      }
      return;
      if ((localQQUserUIItem == null) || (TextUtils.isEmpty(localQQUserUIItem.headUrl)))
      {
        wxe.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
        paramViewGroup.setImageResource(2130846382);
        vdj.d();
        break;
      }
      xsm.b(paramViewGroup, xsj.b(localQQUserUIItem.headUrl), 200, 200, bdhj.a(1), "QQStory200");
      break;
      label324:
      localImageView2.setImageResource(2130846216);
      break label170;
      label335:
      if (bool) {
        localImageView2.setImageResource(2130846215);
      }
      for (;;)
      {
        localImageView2.setContentDescription(alud.a(2131707901));
        break;
        localImageView2.setImageResource(2130846214);
      }
      label373:
      if (this.jdField_a_of_type_Wrd.b() != 0)
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
  
  private void a(wrd paramwrd, View paramView)
  {
    if (xsm.b()) {
      return;
    }
    if (paramwrd.d) {}
    for (String str = "1"; paramwrd.b() == 0; str = "2")
    {
      wxj.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_Wtr.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131373870) {
      wxj.a("mystory", "clk_head_data", 0, 0, new String[0]);
    }
    for (;;)
    {
      paramwrd = QQStoryContext.a().b();
      uqn.a(this.jdField_a_of_type_AndroidContentContext, 3, paramwrd);
      return;
      wxj.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (xsm.b()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131373819);
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
      wxj.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str });
      paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_Wrd.jdField_a_of_type_Uxd.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid), 2);
      vod.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem.a(), localStoryCoverView.a);
      return;
    }
  }
  
  private void b(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramwtq.a(2131373819);
    ImageView localImageView1 = (ImageView)paramwtq.a(2131373833);
    TextView localTextView1 = (TextView)paramwtq.a(2131373820);
    Object localObject1 = (TextView)paramwtq.a(2131373872);
    ImageView localImageView2 = (ImageView)paramwtq.a(2131373822);
    TextView localTextView2 = (TextView)paramwtq.a(2131373875);
    TextView localTextView3 = (TextView)paramwtq.a(2131373825);
    ImageView localImageView3 = (ImageView)paramwtq.a(2131373818);
    paramViewGroup = (Button)paramwtq.a(2131373871);
    ImageView localImageView4 = (ImageView)paramwtq.a(2131373823);
    if ((this.jdField_a_of_type_Wrd == null) || (this.jdField_a_of_type_Wrd.a() == null))
    {
      wxe.e("NewMyStorySegment", "myStorys is null!");
      return;
    }
    paramwtq.a().setTag(-3, Integer.valueOf(xsm.a(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
    paramViewGroup.setOnClickListener(paramwtq);
    paramViewGroup = (ImageView)paramwtq.a(2131373823);
    Object localObject2 = (ImageView)paramwtq.a(2131373824);
    paramInt = -657931;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      paramInt = -15980466;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ((ImageView)localObject2).setBackgroundColor(paramInt);
    localObject2 = (StoryVideoItem)this.jdField_a_of_type_Wrd.a().get(i);
    wxe.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
    label289:
    boolean bool2;
    if (wrl.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath))
    {
      paramViewGroup = wxb.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);
      bool2 = false;
      xsm.a(localStoryCoverView.a, paramViewGroup, 106, 170, 5, xsm.b, "myStory");
      localStoryCoverView.setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      localStoryCoverView.setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      ((TextView)localObject1).setMaxWidth(xsm.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
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
        paramwtq.jdField_b_of_type_Int = i;
        paramwtq.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Wrd;
        localTextView1.setOnClickListener(paramwtq);
        paramwtq.a().setOnClickListener(paramwtq);
        paramwtq.a().setContentDescription(alud.a(2131707903) + ulg.jdField_a_of_type_JavaLangString + alud.a(2131707915) + (i + 1) + alud.a(2131707902));
        localTextView2.setOnClickListener(paramwtq);
        localImageView2.setOnClickListener(paramwtq);
        if (paramwtq.jdField_a_of_type_Wrj != null) {
          break;
        }
        paramwtq.a(new wvt(this, bool1));
        return;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null) {
          wxe.e("NewMyStorySegment", "mVideoThumbnailUrl is null! vid=" + ((StoryVideoItem)localObject2).mVid);
        }
        paramViewGroup = xsj.a(((StoryVideoItem)localObject2).mVideoThumbnailUrl);
        break label289;
        localTextView3.setVisibility(0);
        localTextView3.setText(alud.a(2131707904));
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
          paramInt = uoy.a().a(((StoryVideoItem)localObject2).mVid);
          if (paramInt >= 0) {
            localTextView3.setText(alud.a(2131707905) + paramInt + "%");
          }
          paramViewGroup = new wvs(this, localTextView3);
          localTextView3.setTag(paramViewGroup);
          uoy.a().a(((StoryVideoItem)localObject2).mVid, paramViewGroup);
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
          if ((localTextView3.getTag() != null) && ((localTextView3.getTag() instanceof upa))) {
            uoy.a().a((upa)localTextView3.getTag());
          }
          localTextView3.setText(2131700095);
        }
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        if (((StoryVideoItem)localObject2).mUpLoadFailedError == 10404) {
          localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131700098));
        }
        ((TextView)localObject1).setVisibility(8);
        localImageView3.setVisibility(8);
        localImageView2.setVisibility(0);
        localTextView3.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView3.setVisibility(0);
        localTextView3.setText(alud.a(2131707909));
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
      paramViewGroup = ((TroopManager)vls.a().getManager(52)).b((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.get(0));
      if ((paramViewGroup == null) || (TextUtils.isEmpty(paramViewGroup.getTroopName()))) {
        break label1221;
      }
      paramViewGroup = alud.a(2131707906) + paramViewGroup.getTroopName();
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
  
  private void b(wtq paramwtq, int paramInt)
  {
    TextView localTextView1 = (TextView)paramwtq.a(2131373820);
    TextView localTextView2 = (TextView)paramwtq.a(2131373872);
    ImageView localImageView = (ImageView)paramwtq.a(2131373822);
    TextView localTextView3 = (TextView)paramwtq.a(2131373875);
    paramwtq = (ImageView)paramwtq.a(2131373818);
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
      paramwtq.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramwtq.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 3: 
    case 6: 
      localTextView1.setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView2.setVisibility(8);
      paramwtq.setVisibility(8);
      localImageView.setVisibility(0);
      return;
    case 9: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramwtq.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    }
    localTextView3.setVisibility(8);
    paramwtq.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  private void c(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramwtq.a(2131369451);
    View localView1 = paramwtq.a(2131369486);
    View localView2 = paramwtq.a(2131369487);
    paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166988);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramwtq.a(2131377736);
    localView1 = paramwtq.a(2131377634);
    paramViewGroup.setOnClickListener(paramwtq);
    localView1.setOnClickListener(paramwtq);
    if (paramwtq.jdField_a_of_type_Wrj == null) {
      paramwtq.a(new wvu(this));
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Wrd != null) && (this.jdField_a_of_type_Wrd.a().size() > 0)) {
        return this.jdField_a_of_type_Wrd.a().size() + 2;
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
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    int i = a(paramInt);
    wxe.a("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return paramwtq.a();
      a(paramInt, paramwtq, paramViewGroup);
      continue;
      b(paramInt, paramwtq, paramViewGroup);
      continue;
      c(paramInt, paramwtq, paramViewGroup);
    }
  }
  
  public String a()
  {
    return "NewMyStorySegment";
  }
  
  public wsr a()
  {
    return new wsr(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = null;
    }
    while (paramViewGroup != null)
    {
      return new wtq(paramViewGroup);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561578, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561579, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561468, paramViewGroup, false);
    }
    return new wtq(new TextView(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_Wrd.a(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    QQToast.a(BaseApplication.getContext(), 1, alud.a(2131707911), 0).a();
    m();
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_Wrd.a(paramString);
    this.jdField_a_of_type_Wrd.c(paramString);
    if (this.jdField_a_of_type_Wrd.a().size() == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Wrd.jdField_b_of_type_Boolean = false;
    }
    ((wpe)uwa.a(12)).a(this.jdField_a_of_type_Wrd.jdField_a_of_type_Uxd.jdField_a_of_type_JavaLangString, 0, paramString);
    m();
  }
  
  protected void a(uow paramuow)
  {
    wxe.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramuow);
    Object localObject1 = paramuow.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_Wrd.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      wxe.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_Wrd.a((StoryVideoItem)localObject1);
      if (paramuow.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
        break label268;
      }
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramuow.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    for (;;)
    {
      if (paramuow.b != null)
      {
        this.jdField_a_of_type_Wrd.a(((StoryVideoItem)localObject1).mVid, paramuow.b);
        this.jdField_a_of_type_Wrd.jdField_b_of_type_Boolean = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.mIsContribute;
        if ((!TextUtils.isEmpty(paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)) && (!TextUtils.equals(this.jdField_a_of_type_Wrd.jdField_a_of_type_Uxd.jdField_a_of_type_JavaLangString, paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)))
        {
          wxe.a("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.jdField_a_of_type_Wrd.jdField_a_of_type_Uxd.jdField_a_of_type_JavaLangString, paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
          Object localObject2 = paramuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
          localObject1 = new wsu(wsc.a((String)localObject2));
          wsz localwsz = (wsz)this.jdField_b_of_type_Xsr.a();
          localObject2 = new wst(new wvv(this, (String)localObject2));
          wsr localwsr = a();
          a(new wsz[] { localObject1, localwsz, localObject2 }, localwsr);
        }
      }
      if (!paramuow.jdField_c_of_type_Boolean) {
        break label279;
      }
      a().h();
      return;
      this.jdField_a_of_type_Wrd.b((StoryVideoItem)localObject1);
      break;
      label268:
      wxe.e("NewMyStorySegment", "item error info is null!!");
    }
    label279:
    m();
  }
  
  public void a(wrd paramwrd)
  {
    this.jdField_a_of_type_Wrd = paramwrd;
    wsl.a(this.jdField_a_of_type_Wrd);
    c(true);
  }
  
  public void a(wtq paramwtq, int paramInt)
  {
    a().t();
    if ((this.jdField_a_of_type_Wrd.a().size() > paramInt) && (this.jdField_a_of_type_Wrd.a().get(paramInt) != null))
    {
      localObject = ((StoryVideoItem)this.jdField_a_of_type_Wrd.a().get(paramInt)).mVid;
      if (!StoryVideoItem.isFakeVid((String)localObject)) {
        break label117;
      }
      uom.a((String)localObject);
      m();
      if (!((StoryVideoItem)this.jdField_a_of_type_Wrd.a().get(paramInt)).isUploading()) {
        break label110;
      }
    }
    label110:
    for (paramwtq = "1";; paramwtq = "3")
    {
      wxj.a("mystory", "del_onevideo", 0, 0, new String[] { paramwtq });
      return;
    }
    label117:
    new vcl().a((String)localObject);
    ((StoryVideoItem)this.jdField_a_of_type_Wrd.a().get(paramInt)).mUploadStatus = 9;
    Object localObject = (TextView)paramwtq.a(2131373825);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(alud.a(2131707913));
    b(paramwtq, 9);
    wxj.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    m();
  }
  
  protected void a(wsz[] paramArrayOfwsz)
  {
    if (this.jdField_a_of_type_Wsr != null) {
      this.jdField_a_of_type_Wsr.c();
    }
    this.jdField_a_of_type_Wsr = new wsr(this.jdField_a_of_type_AndroidOsHandler);
    a(paramArrayOfwsz, this.jdField_a_of_type_Wsr);
  }
  
  protected void a(wsz[] paramArrayOfwsz, wsr paramwsr)
  {
    int j = paramArrayOfwsz.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        wsz localwsz = paramArrayOfwsz[i];
        try
        {
          paramwsr.a(localwsz);
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
    paramwsr.a(new wwd(this)).a(new wwc(this));
    paramwsr.a();
  }
  
  public void a_(wtq paramwtq)
  {
    super.a_(paramwtq);
    ImageView localImageView1 = (ImageView)paramwtq.a(2131373823);
    ImageView localImageView2 = (ImageView)paramwtq.a(2131373822);
    ImageView localImageView3 = (ImageView)paramwtq.a(2131373818);
    if ((localImageView3 != null) && (localImageView2 != null) && (localImageView1 != null))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localImageView3.setVisibility(8);
    }
    if (this.jdField_a_of_type_Wrd.a().size() > paramwtq.jdField_b_of_type_Int)
    {
      paramwtq = (StoryVideoItem)this.jdField_a_of_type_Wrd.a().get(paramwtq.jdField_b_of_type_Int);
      if (!paramwtq.isUploadSuc()) {
        break label135;
      }
      paramwtq = "2";
    }
    for (;;)
    {
      wxj.a("mystory", "slide_del", 0, 0, new String[] { paramwtq });
      return;
      label135:
      if (paramwtq.isUploadFail()) {
        paramwtq = "3";
      } else if (paramwtq.isUploading()) {
        paramwtq = "1";
      } else {
        paramwtq = "2";
      }
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    a(new wsz[] { (wsz)this.jdField_a_of_type_Xsr.a(), (wsz)this.jdField_b_of_type_Xsr.a(), (wsz)this.jdField_c_of_type_Xsr.a(), (wsz)this.d.a() });
    return true;
  }
  
  public void b_(wtq paramwtq)
  {
    super.b_(paramwtq);
    ((ImageView)paramwtq.a(2131373823)).setVisibility(0);
    if (this.jdField_a_of_type_Wrd.a().size() > paramwtq.jdField_b_of_type_Int) {
      b(paramwtq, ((StoryVideoItem)this.jdField_a_of_type_Wrd.a().get(paramwtq.jdField_b_of_type_Int)).mUploadStatus);
    }
  }
  
  protected void c()
  {
    umc.a().registerSubscriber(this.jdField_a_of_type_Wwg);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wwf);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wwh);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((uwm)uwa.a(2)).b(QQStoryContext.a().b());
    List localList = ((uvx)uwa.a(5)).b(QQStoryContext.a().b());
    this.jdField_a_of_type_Wrd.b();
    wrd localwrd = this.jdField_a_of_type_Wrd;
    if (((Integer)this.jdField_a_of_type_Uvt.b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1)
    {
      bool = true;
      localwrd.jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Wrd.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_Wrd.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Uvt.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      }
      this.jdField_a_of_type_Wrd.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Uvt.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Wrd.jdField_a_of_type_Long = ((Integer)this.jdField_a_of_type_Uvt.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Wrd.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_Uvt.b("qqstory_my_newest_video_cover", ""));
      this.jdField_a_of_type_Wrd.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_Uvt.b("qqstory_my_newest_video_vid", ""));
      localwrd = this.jdField_a_of_type_Wrd;
      if (((Integer)this.jdField_a_of_type_Uvt.b("qqstory_my_story_have_contributed", Integer.valueOf(-1))).intValue() != 1) {
        break label471;
      }
    }
    label471:
    for (boolean bool = true;; bool = false)
    {
      localwrd.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Wrd.jdField_a_of_type_Uxd.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Uvt.b("qqstory_key_story_latest_feed_feature_feed_id", ""));
      this.jdField_a_of_type_Wrd.jdField_a_of_type_Uxd.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_Uvt.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Wrd.jdField_a_of_type_Uxd.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_Uvt.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Wrd.jdField_a_of_type_Uxd.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_Uvt.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(0))).intValue();
      if (localList.size() == 0) {
        wxe.d("NewMyStorySegment", "Story DB have no mystory data!");
      }
      Collections.sort(localList);
      this.jdField_a_of_type_Wrd.a(localList);
      wxe.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_Wrd.a()) });
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
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wwg);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wwf);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wwh);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Wsr.c();
    if (this.jdField_a_of_type_Xus != null) {
      this.jdField_a_of_type_Xus.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ulw);
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
      a((wrd)paramMessage.obj);
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvq
 * JD-Core Version:    0.7.0.1
 */