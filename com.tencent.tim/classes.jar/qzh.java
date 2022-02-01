import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
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
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class qzh
  extends rsd<qwm>
  implements Handler.Callback, IEventReceiver
{
  public static final String KEY = "NewMyStorySegment";
  private static final StringBuilder mStringBuilder = new StringBuilder();
  protected psr a;
  private qwm jdField_a_of_type_Qwm;
  protected qxl a;
  private qye jdField_a_of_type_Qye;
  protected qzh.a a;
  protected qzh.b a;
  protected qzh.c a;
  public final rps<qxd> a;
  private rrl jdField_a_of_type_Rrl;
  private boolean aDA;
  public final rps<qxc> b = new qzn(this);
  private Handler bm;
  public final rps<qxh> c = new qzo(this);
  public final rps<qxa> d = new qzp(this);
  private QQUserUIItem jdField_f_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  protected pmd f;
  private qyd jdField_f_of_type_Qyd;
  private boolean isOpen;
  private float mG;
  private Handler mUIHandler;
  private Activity y;
  
  public qzh(Activity paramActivity, qye paramqye)
  {
    super(paramActivity);
    this.jdField_a_of_type_Rps = new qzi(this);
    this.jdField_f_of_type_Pmd = new qzr(this);
    this.y = paramActivity;
    this.jdField_a_of_type_Qye = paramqye;
    this.mG = (rpq.getWindowScreenWidth(this.context) - rpq.dip2px(this.context, 145.0F));
    this.jdField_a_of_type_Psr = ((psr)psx.a(10));
    this.bm = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Qxl = new qxl(this.bm);
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Qwm = new qwm();
    this.jdField_a_of_type_Qzh$b = new qzh.b(this);
    this.jdField_a_of_type_Qzh$a = new qzh.a(this);
    this.jdField_a_of_type_Qzh$c = new qzh.c(this);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_f_of_type_Pmd);
  }
  
  private String a(qwm paramqwm, int paramInt, TextPaint paramTextPaint)
  {
    mStringBuilder.append(paramqwm.a(paramInt, paramTextPaint));
    paramqwm = mStringBuilder.toString();
    mStringBuilder.setLength(0);
    return paramqwm;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (rpq.isFastDoubleClick()) {
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (String str1 = "1";; str1 = "2")
    {
      String str2 = "2";
      if ((TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str2 = "1";
      }
      rar.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
      paramStoryVideoItem = new VidListPlayInfo(this.jdField_a_of_type_Qwm.a.feedId, paramStoryVideoItem.mVid);
      qgg.a(this.y, paramStoryVideoItem, 2, paramView);
      return;
    }
  }
  
  private void a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    this.jdField_f_of_type_Qyd = paramqyd;
    paramViewGroup = (ImageView)paramqyd.get(2131375252);
    TextView localTextView = (TextView)paramqyd.get(2131375208);
    ImageView localImageView1 = (ImageView)paramqyd.get(2131375214);
    ImageView localImageView2 = (ImageView)paramqyd.get(2131375212);
    View localView = paramqyd.get(2131375213);
    this.jdField_a_of_type_Qwm.brj();
    paramInt = -657931;
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null);
    if (bool) {
      paramInt = -15980466;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((ptf)psx.a(2)).a();
    if (this.jdField_a_of_type_Qwm.getState() == 0)
    {
      paramViewGroup.setImageResource(2130847703);
      localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
      if (!this.isOpen) {
        break label335;
      }
      if (!bool) {
        break label324;
      }
      localImageView2.setImageResource(2130847538);
      label170:
      localImageView2.setContentDescription(acfp.m(2131709065));
      if (this.jdField_a_of_type_Qwm.bu().size() <= 0) {
        break label373;
      }
      localImageView2.setVisibility(0);
      label200:
      if (!this.isOpen) {
        break label403;
      }
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(paramqyd);
      paramqyd.getItemView().findViewById(2131375249).setOnClickListener(paramqyd);
      if (paramqyd.b == null) {
        paramqyd.b(new qzv(this));
      }
      return;
      if ((localQQUserUIItem == null) || (TextUtils.isEmpty(localQQUserUIItem.headUrl)))
      {
        ram.e("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
        paramViewGroup.setImageResource(2130847703);
        pxs.bnA();
        break;
      }
      rpq.b(paramViewGroup, rpn.gn(localQQUserUIItem.headUrl), 200, 200, aqhu.F(1), "QQStory200");
      break;
      label324:
      localImageView2.setImageResource(2130847537);
      break label170;
      label335:
      if (bool) {
        localImageView2.setImageResource(2130847536);
      }
      for (;;)
      {
        localImageView2.setContentDescription(acfp.m(2131709056));
        break;
        localImageView2.setImageResource(2130847535);
      }
      label373:
      if (this.jdField_a_of_type_Qwm.getState() != 0)
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
  
  private void a(qwm paramqwm, View paramView)
  {
    if (rpq.isFastDoubleClick()) {
      return;
    }
    if (paramqwm.aFT) {}
    for (String str = "1"; paramqwm.getState() == 0; str = "2")
    {
      rar.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_Qye.b(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131375252) {
      rar.a("mystory", "clk_head_data", 0, 0, new String[0]);
    }
    for (;;)
    {
      paramqwm = QQStoryContext.a().getCurrentUid();
      ppf.f(this.context, 3, paramqwm);
      return;
      rar.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
  }
  
  private String b(StoryVideoItem paramStoryVideoItem)
  {
    mStringBuilder.append(qwq.aG(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = mStringBuilder.toString();
    mStringBuilder.setLength(0);
    return paramStoryVideoItem;
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    qem.b(paramStoryVideoItem, this.context);
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (rpq.isFastDoubleClick()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131375201);
    if (paramStoryVideoItem.mUnreadLikeCount > 0)
    {
      a(paramInt, paramStoryVideoItem, localStoryCoverView.mImageView);
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (paramView = "1";; paramView = "2")
    {
      String str = "2";
      if ((!TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (!TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str = "1";
      }
      rar.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str });
      paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_Qwm.a.feedId, paramStoryVideoItem.mVid), 2);
      qgg.a(this.y, paramStoryVideoItem.b(), localStoryCoverView.mImageView);
      return;
    }
  }
  
  private void b(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramqyd.get(2131375201);
    ImageView localImageView1 = (ImageView)paramqyd.get(2131375215);
    TextView localTextView1 = (TextView)paramqyd.get(2131375202);
    Object localObject1 = (TextView)paramqyd.get(2131375254);
    ImageView localImageView2 = (ImageView)paramqyd.get(2131375204);
    TextView localTextView2 = (TextView)paramqyd.get(2131375257);
    TextView localTextView3 = (TextView)paramqyd.get(2131375207);
    ImageView localImageView3 = (ImageView)paramqyd.get(2131375200);
    paramViewGroup = (Button)paramqyd.get(2131375253);
    ImageView localImageView4 = (ImageView)paramqyd.get(2131375205);
    if ((this.jdField_a_of_type_Qwm == null) || (this.jdField_a_of_type_Qwm.bu() == null))
    {
      ram.e("NewMyStorySegment", "myStorys is null!");
      return;
    }
    paramqyd.getItemView().setTag(-3, Integer.valueOf(rpq.dip2px(this.context, 84.0F)));
    paramViewGroup.setOnClickListener(paramqyd);
    paramViewGroup = (ImageView)paramqyd.get(2131375205);
    Object localObject2 = (ImageView)paramqyd.get(2131375206);
    paramInt = -657931;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null)) {
      paramInt = -15980466;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ((ImageView)localObject2).setBackgroundColor(paramInt);
    localObject2 = (StoryVideoItem)this.jdField_a_of_type_Qwm.bu().get(i);
    ram.b("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
    label289:
    boolean bool2;
    if (qwq.isFileExist(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath))
    {
      paramViewGroup = raj.a.gb(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);
      bool2 = false;
      rpq.a(localStoryCoverView.mImageView, paramViewGroup, 106, 170, 5, rpq.dl, "myStory");
      localStoryCoverView.setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      localStoryCoverView.setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      ((TextView)localObject1).setMaxWidth(rpq.c(this.context, 160.0F));
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
        paramqyd.position = i;
        paramqyd.param = this.jdField_a_of_type_Qwm;
        localTextView1.setOnClickListener(paramqyd);
        paramqyd.getItemView().setOnClickListener(paramqyd);
        paramqyd.getItemView().setContentDescription(acfp.m(2131709058) + plr.asY + acfp.m(2131709070) + (i + 1) + acfp.m(2131709057));
        localTextView2.setOnClickListener(paramqyd);
        localImageView2.setOnClickListener(paramqyd);
        if (paramqyd.b != null) {
          break;
        }
        paramqyd.b(new qzk(this, bool1));
        return;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null) {
          ram.e("NewMyStorySegment", "mVideoThumbnailUrl is null! vid=" + ((StoryVideoItem)localObject2).mVid);
        }
        paramViewGroup = rpn.gm(((StoryVideoItem)localObject2).mVideoThumbnailUrl);
        break label289;
        localTextView3.setVisibility(0);
        localTextView3.setText(acfp.m(2131709059));
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
          paramInt = poe.a().bb(((StoryVideoItem)localObject2).mVid);
          if (paramInt >= 0) {
            localTextView3.setText(acfp.m(2131709060) + paramInt + "%");
          }
          paramViewGroup = new qzj(this, localTextView3);
          localTextView3.setTag(paramViewGroup);
          poe.a().a(((StoryVideoItem)localObject2).mVid, paramViewGroup);
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
          if ((localTextView3.getTag() != null) && ((localTextView3.getTag() instanceof poe.b))) {
            poe.a().a((poe.b)localTextView3.getTag());
          }
          localTextView3.setText(2131701955);
        }
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        if (((StoryVideoItem)localObject2).mUpLoadFailedError == 10404) {
          localTextView2.setText(this.context.getResources().getText(2131701958));
        }
        ((TextView)localObject1).setVisibility(8);
        localImageView3.setVisibility(8);
        localImageView2.setVisibility(0);
        localTextView3.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView3.setVisibility(0);
        localTextView3.setText(acfp.m(2131709064));
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
      if ((((StoryVideoItem)localObject2).mVideoSpreadGroupList == null) || (((StoryVideoItem)localObject2).mVideoSpreadGroupList.bkr != 4) || (((StoryVideoItem)localObject2).mVideoSpreadGroupList.mA.isEmpty())) {
        break label1221;
      }
      paramViewGroup = ((TroopManager)qem.getQQAppInterface().getManager(52)).b((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.mA.get(0));
      if ((paramViewGroup == null) || (TextUtils.isEmpty(paramViewGroup.getTroopName()))) {
        break label1221;
      }
      paramViewGroup = acfp.m(2131709061) + paramViewGroup.getTroopName();
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup)) {
        localObject1 = b((StoryVideoItem)localObject2);
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
  
  private void c(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramqyd.get(2131370458);
    View localView1 = paramqyd.get(2131370494);
    View localView2 = paramqyd.get(2131370495);
    paramInt = this.context.getResources().getColor(2131167390);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramqyd.get(2131379538);
    localView1 = paramqyd.get(2131379436);
    paramViewGroup.setOnClickListener(paramqyd);
    localView1.setOnClickListener(paramqyd);
    if (paramqyd.b == null) {
      paramqyd.b(new qzl(this));
    }
  }
  
  private void c(qyd paramqyd, int paramInt)
  {
    TextView localTextView1 = (TextView)paramqyd.get(2131375202);
    TextView localTextView2 = (TextView)paramqyd.get(2131375254);
    ImageView localImageView = (ImageView)paramqyd.get(2131375204);
    TextView localTextView3 = (TextView)paramqyd.get(2131375257);
    paramqyd = (ImageView)paramqyd.get(2131375200);
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
      paramqyd.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramqyd.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 3: 
    case 6: 
      localTextView1.setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView2.setVisibility(8);
      paramqyd.setVisibility(8);
      localImageView.setVisibility(0);
      return;
    case 9: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramqyd.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    }
    localTextView3.setVisibility(8);
    paramqyd.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  protected int J(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == getCount() - 1) {
      return 2;
    }
    return 1;
  }
  
  protected boolean Z(boolean paramBoolean)
  {
    a(new qxo[] { (qxo)this.jdField_a_of_type_Rps.call(), (qxo)this.b.call(), (qxo)this.c.call(), (qxo)this.d.call() });
    return true;
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    int i = J(paramInt);
    ram.b("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return paramqyd.getItemView();
      a(paramInt, paramqyd, paramViewGroup);
      continue;
      b(paramInt, paramqyd, paramViewGroup);
      continue;
      c(paramInt, paramqyd, paramViewGroup);
    }
  }
  
  public qxl a()
  {
    return new qxl(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (J(paramInt))
    {
    default: 
      paramViewGroup = null;
    }
    while (paramViewGroup != null)
    {
      return new qyd(paramViewGroup);
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131561971, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131561972, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131561861, paramViewGroup, false);
    }
    return new qyd(new TextView(this.context));
  }
  
  protected void a(qxo[] paramArrayOfqxo)
  {
    if (this.jdField_a_of_type_Qxl != null) {
      this.jdField_a_of_type_Qxl.reset();
    }
    this.jdField_a_of_type_Qxl = new qxl(this.bm);
    a(paramArrayOfqxo, this.jdField_a_of_type_Qxl);
  }
  
  protected void a(qxo[] paramArrayOfqxo, qxl paramqxl)
  {
    int j = paramArrayOfqxo.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        qxo localqxo = paramArrayOfqxo[i];
        try
        {
          paramqxl.a(localqxo);
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
    paramqxl.a(new qzu(this)).a(new qzt(this));
    paramqxl.run();
  }
  
  public void aN(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_Qwm.d(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131709066), 0).show();
    bwd();
  }
  
  public void b(qwm paramqwm)
  {
    this.jdField_a_of_type_Qwm = paramqwm;
    qxh.a(this.jdField_a_of_type_Qwm);
    notifyDataSetChanged(true);
  }
  
  public void b(qyd paramqyd, int paramInt)
  {
    a().AP();
    if ((this.jdField_a_of_type_Qwm.bu().size() > paramInt) && (this.jdField_a_of_type_Qwm.bu().get(paramInt) != null))
    {
      localObject = ((StoryVideoItem)this.jdField_a_of_type_Qwm.bu().get(paramInt)).mVid;
      if (!StoryVideoItem.isFakeVid((String)localObject)) {
        break label117;
      }
      pnx.qT((String)localObject);
      bwd();
      if (!((StoryVideoItem)this.jdField_a_of_type_Qwm.bu().get(paramInt)).isUploading()) {
        break label110;
      }
    }
    label110:
    for (paramqyd = "1";; paramqyd = "3")
    {
      rar.a("mystory", "del_onevideo", 0, 0, new String[] { paramqyd });
      return;
    }
    label117:
    new pxj().qV((String)localObject);
    ((StoryVideoItem)this.jdField_a_of_type_Qwm.bu().get(paramInt)).mUploadStatus = 9;
    Object localObject = (TextView)paramqyd.get(2131375207);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(acfp.m(2131709068));
    c(paramqyd, 9);
    rar.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
  }
  
  protected void bqO()
  {
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qzh$b);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qzh$a);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qzh$c);
    this.jdField_f_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((ptf)psx.a(2)).b(QQStoryContext.a().getCurrentUid());
    List localList = ((psu)psx.a(5)).Q(QQStoryContext.a().getCurrentUid());
    this.jdField_a_of_type_Qwm.clear();
    qwm localqwm = this.jdField_a_of_type_Qwm;
    if (((Integer)this.jdField_a_of_type_Psr.c("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1)
    {
      bool = true;
      localqwm.isVip = bool;
      if (this.jdField_a_of_type_Qwm.isVip) {
        this.jdField_a_of_type_Qwm.fansCount = ((Integer)this.jdField_a_of_type_Psr.c("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      }
      this.jdField_a_of_type_Qwm.blJ = ((Integer)this.jdField_a_of_type_Psr.c("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Qwm.Bs = ((Integer)this.jdField_a_of_type_Psr.c("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Qwm.ayX = ((String)this.jdField_a_of_type_Psr.c("qqstory_my_newest_video_cover", ""));
      this.jdField_a_of_type_Qwm.ayY = ((String)this.jdField_a_of_type_Psr.c("qqstory_my_newest_video_vid", ""));
      localqwm = this.jdField_a_of_type_Qwm;
      if (((Integer)this.jdField_a_of_type_Psr.c("qqstory_my_story_have_contributed", Integer.valueOf(-1))).intValue() != 1) {
        break label471;
      }
    }
    label471:
    for (boolean bool = true;; bool = false)
    {
      localqwm.aFS = bool;
      this.jdField_a_of_type_Qwm.a.feedId = ((String)this.jdField_a_of_type_Psr.c("qqstory_key_story_latest_feed_feature_feed_id", ""));
      this.jdField_a_of_type_Qwm.a.totalLikeCount = ((Integer)this.jdField_a_of_type_Psr.c("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Qwm.a.bkl = ((Integer)this.jdField_a_of_type_Psr.c("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_Qwm.a.bkm = ((Integer)this.jdField_a_of_type_Psr.c("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(0))).intValue();
      if (localList.size() == 0) {
        ram.w("NewMyStorySegment", "Story DB have no mystory data!");
      }
      Collections.sort(localList);
      this.jdField_a_of_type_Qwm.eH(localList);
      ram.w("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_Qwm.sQ()) });
      this.aDA = true;
      return;
      bool = false;
      break;
    }
  }
  
  protected void d(pnx.d paramd)
  {
    ram.b("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramd);
    Object localObject1 = paramd.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_Qwm.d(((StoryVideoItem)localObject1).mVid) == null)
    {
      ram.d("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_Qwm.p((StoryVideoItem)localObject1);
      if (paramd.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
        break label268;
      }
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramd.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    for (;;)
    {
      if (paramd.c != null)
      {
        this.jdField_a_of_type_Qwm.a(((StoryVideoItem)localObject1).mVid, paramd.c);
        this.jdField_a_of_type_Qwm.aFS = paramd.a.mIsContribute;
        if ((!TextUtils.isEmpty(paramd.a.feedId)) && (!TextUtils.equals(this.jdField_a_of_type_Qwm.a.feedId, paramd.a.feedId)))
        {
          ram.b("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.jdField_a_of_type_Qwm.a.feedId, paramd.a.feedId);
          Object localObject2 = paramd.a.feedId;
          localObject1 = new qxm.b(qxd.a.a((String)localObject2));
          qxo localqxo = (qxo)this.b.call();
          localObject2 = new qxm.a(new qzm(this, (String)localObject2));
          qxl localqxl = a();
          a(new qxo[] { localObject1, localqxo, localObject2 }, localqxl);
        }
      }
      if (!paramd.aAV) {
        break label279;
      }
      a().brD();
      return;
      this.jdField_a_of_type_Qwm.q((StoryVideoItem)localObject1);
      break;
      label268:
      ram.e("NewMyStorySegment", "item error info is null!!");
    }
    label279:
    bwd();
  }
  
  public void g(qyd paramqyd)
  {
    super.g(paramqyd);
    ((ImageView)paramqyd.get(2131375205)).setVisibility(0);
    if (this.jdField_a_of_type_Qwm.bu().size() > paramqyd.position) {
      c(paramqyd, ((StoryVideoItem)this.jdField_a_of_type_Qwm.bu().get(paramqyd.position)).mUploadStatus);
    }
  }
  
  public int getCount()
  {
    if (this.aDA)
    {
      if ((this.isOpen) && (this.jdField_a_of_type_Qwm != null) && (this.jdField_a_of_type_Qwm.bu().size() > 0)) {
        return this.jdField_a_of_type_Qwm.bu().size() + 2;
      }
      return 1;
    }
    return 0;
  }
  
  public String getKey()
  {
    return "NewMyStorySegment";
  }
  
  protected int getViewTypeCount()
  {
    return 3;
  }
  
  public void h(qyd paramqyd)
  {
    super.h(paramqyd);
    ImageView localImageView1 = (ImageView)paramqyd.get(2131375205);
    ImageView localImageView2 = (ImageView)paramqyd.get(2131375204);
    ImageView localImageView3 = (ImageView)paramqyd.get(2131375200);
    if ((localImageView3 != null) && (localImageView2 != null) && (localImageView1 != null))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localImageView3.setVisibility(8);
    }
    if (this.jdField_a_of_type_Qwm.bu().size() > paramqyd.position)
    {
      paramqyd = (StoryVideoItem)this.jdField_a_of_type_Qwm.bu().get(paramqyd.position);
      if (!paramqyd.isUploadSuc()) {
        break label135;
      }
      paramqyd = "2";
    }
    for (;;)
    {
      rar.a("mystory", "slide_del", 0, 0, new String[] { paramqyd });
      return;
      label135:
      if (paramqyd.isUploadFail()) {
        paramqyd = "3";
      } else if (paramqyd.isUploading()) {
        paramqyd = "1";
      } else {
        paramqyd = "2";
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      b((qwm)paramMessage.obj);
    }
  }
  
  public boolean isValidate()
  {
    return this.aDA;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.aDA = false;
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qzh$b);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qzh$a);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qzh$c);
    this.bm.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Qxl.reset();
    if (this.jdField_a_of_type_Rrl != null) {
      this.jdField_a_of_type_Rrl.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_f_of_type_Pmd);
  }
  
  protected void onResume() {}
  
  public void setOpen(boolean paramBoolean)
  {
    this.isOpen = paramBoolean;
    bwd();
  }
  
  public void sn(String paramString)
  {
    paramString = this.jdField_a_of_type_Qwm.d(paramString);
    this.jdField_a_of_type_Qwm.r(paramString);
    if (this.jdField_a_of_type_Qwm.bu().size() == 0)
    {
      this.isOpen = false;
      this.jdField_a_of_type_Qwm.aFS = false;
    }
    ((qvi)psx.a(12)).a(this.jdField_a_of_type_Qwm.a.feedId, 0, paramString);
    bwd();
  }
  
  public static class a
    extends QQUIEventReceiver<qzh, psg>
  {
    public a(@NonNull qzh paramqzh)
    {
      super();
    }
    
    public void a(@NonNull qzh paramqzh, @NonNull psg parampsg)
    {
      if (parampsg.b.isFail())
      {
        ram.w(this.TAG, "deleted story failed");
        paramqzh.aN(5, parampsg.vid);
        return;
      }
      paramqzh.sn(parampsg.vid);
      paramqzh.a(new qxo[] { new qxm.b(qxd.a.a(qzh.a(paramqzh).a.feedId)), (qxo)paramqzh.c.call() });
    }
    
    public Class acceptEventClass()
    {
      return psg.class;
    }
  }
  
  public static class b
    extends QQUIEventReceiver<qzh, pnx.d>
  {
    public b(@NonNull qzh paramqzh)
    {
      super();
    }
    
    public void a(@NonNull qzh paramqzh, @NonNull pnx.d paramd)
    {
      if (paramd.Iz())
      {
        ram.d(this.TAG, "group video upload");
        return;
      }
      if (!paramd.IA())
      {
        ram.d(this.TAG, "ignore personal video");
        return;
      }
      paramqzh.d(paramd);
    }
    
    public Class acceptEventClass()
    {
      return pnx.d.class;
    }
  }
  
  public static class c
    extends QQUIEventReceiver<qzh, pxs.b>
  {
    public c(@NonNull qzh paramqzh)
    {
      super();
    }
    
    public void a(@NonNull qzh paramqzh, @NonNull pxs.b paramb)
    {
      if ((paramb == null) || (paramb.c == null) || (TextUtils.isEmpty(paramb.c.headUrl))) {
        ram.e(this.TAG, "GetUserInfoHandler return headUrl is null!", new IllegalStateException());
      }
      while (!paramb.c.isMe()) {
        return;
      }
      qzh.b(paramqzh);
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzh
 * JD-Core Version:    0.7.0.1
 */