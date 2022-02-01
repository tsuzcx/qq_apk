package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import auvk;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentList.a;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import jnv;
import mqq.os.MqqHandler;
import plr;
import pmi;
import pnx.a;
import ppf;
import ppg;
import pqj;
import psr;
import psx;
import ptf;
import ptq;
import qvf;
import qwp;
import qye;
import qyf;
import qyk;
import qyk.e;
import qzc;
import qzg;
import qzh;
import qzx;
import ram;
import rar;
import rom;
import rpq;
import rsd;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class MystoryListView
  extends SegmentList
  implements IEventReceiver, qyk.e
{
  private long Bw;
  private long Bx;
  private int HA;
  private int HB;
  private int HC;
  private int Hy;
  private int Hz;
  private a jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$a;
  private c jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$c;
  private ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  private psr jdField_a_of_type_Psr;
  public qye a;
  private boolean aFY;
  protected boolean aFZ;
  private boolean aGa;
  private boolean aGb;
  private int bow;
  private int boy;
  private AbsListView.e e = new qyf(this);
  private AbsListView.e m;
  Runnable mScrollRunnable = null;
  private View oy;
  private boolean rR;
  private int redPointType;
  public Activity y;
  
  public MystoryListView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public MystoryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MystoryListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt);
  }
  
  private void brB()
  {
    String str1;
    String str2;
    if (qyk.eK(qyk.ab(getContext())))
    {
      str1 = "1";
      if (QQStoryMainActivity.Bj <= 0L) {
        break label104;
      }
      str2 = String.valueOf(System.currentTimeMillis() - QQStoryMainActivity.Bj);
      label35:
      if (!this.aFY) {
        break label110;
      }
    }
    label104:
    label110:
    for (String str3 = "2";; str3 = "1")
    {
      rar.b("story_home_dev", "exp", 0, 0, new String[] { str3, str1, str2 });
      qwp.d("Q.qqstory.home.MyStoryListView", new Object[] { "listViewExposure auto_play_switch=", str1, ",cost=", str2 });
      return;
      str1 = "0";
      break;
      str2 = "-1";
      break label35;
    }
  }
  
  private void brC()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    if (localQQAppInterface != null) {
      ((jnv)localQQAppInterface.getManager(70)).ayC();
    }
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super.setOnScrollListener(this.e);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this);
  }
  
  private int sW()
  {
    QQStoryContext.a();
    Object localObject = QQStoryContext.a();
    if (localObject != null)
    {
      localObject = ((jnv)((QQAppInterface)localObject).getManager(70)).a();
      if ((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).uint32_appid != null) && (((oidb_0x791.RedDotInfo)localObject).uint32_appid.has())) {
        switch (((oidb_0x791.RedDotInfo)localObject).uint32_appid.get())
        {
        }
      }
    }
    for (;;)
    {
      return 0;
      return 1;
      return 2;
      return 3;
      return 4;
      ram.e("Q.qqstory.home.MyStoryListView", "Get the QQAppInterface is null,we dont know the red point state");
    }
  }
  
  public boolean KN()
  {
    return this.aGb;
  }
  
  public void a(Activity paramActivity, qye paramqye, View paramView)
  {
    this.jdField_a_of_type_Qye = paramqye;
    this.y = paramActivity;
    this.oy = paramView;
    this.jdField_a_of_type_Psr = ((psr)psx.a(10));
    this.bow = ((Integer)this.jdField_a_of_type_Psr.c("qqstory_key_story_have_show_click_to_top", Integer.valueOf(0))).intValue();
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.Bx = System.currentTimeMillis();
    super.a(paramInt, paramView, paramListView);
    if (paramInt == 0)
    {
      this.aGa = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$c != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$c.onPullRefresh();
      }
    }
    while (paramInt != 1) {
      return true;
    }
    return true;
  }
  
  public void ae(boolean paramBoolean, int paramInt)
  {
    super.ae(paramBoolean, paramInt);
    if (paramBoolean) {
      brC();
    }
    this.jdField_a_of_type_Qye.tf(false);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$c != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$c.ao(paramBoolean, false);
    }
    String str;
    if (this.Bx > 0L)
    {
      str = String.valueOf(System.currentTimeMillis() - this.Bx);
      if (!paramBoolean) {
        break label149;
      }
    }
    label149:
    for (int i = 1;; i = 2)
    {
      rar.b("story_home_dev", "ref_cost", 2, i, new String[] { String.valueOf(paramInt), str });
      this.Bx = 0L;
      qwp.d("Q.qqstory.home.MyStoryListView", new Object[] { "autoRefreshCompleted=", Boolean.valueOf(paramBoolean), ",errorCode=", Integer.valueOf(paramInt), ",cost time=", str });
      return;
    }
  }
  
  public void af(boolean paramBoolean, int paramInt)
  {
    super.af(paramBoolean, paramInt);
    if (paramBoolean) {
      brC();
    }
    this.jdField_a_of_type_Qye.tf(false);
    ram.b("Q.qqstory.home.MyStoryListView", "pullRefreshCompleted success=%s,isManualPullRefresh=%s", Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aGa));
    String str;
    if (this.aGa)
    {
      this.aGa = false;
      if (paramBoolean)
      {
        str = "1";
        rar.a("home_page", "refresh", 0, 0, new String[] { str });
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$c != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$c.ao(paramBoolean, this.aGa);
      }
      if (this.Bx > 0L)
      {
        str = String.valueOf(System.currentTimeMillis() - this.Bx);
        if (!paramBoolean) {
          break label218;
        }
      }
    }
    label218:
    for (int i = 1;; i = 2)
    {
      rar.b("story_home_dev", "ref_cost", 1, i, new String[] { String.valueOf(paramInt), str });
      this.Bx = 0L;
      qwp.d("Q.qqstory.home.MyStoryListView", new Object[] { "pullToRefreshCompleted=", Boolean.valueOf(paramBoolean), ",errorCode=", Integer.valueOf(paramInt), ",cost time=", str });
      return;
      str = "2";
      break;
    }
  }
  
  public void b(String paramString, CommentEntry paramCommentEntry)
  {
    if (this.aFY)
    {
      int i = rpq.dip2px(getContext(), 36.0F);
      super.smoothScrollBy(i, i);
    }
  }
  
  public void box()
  {
    super.setActTAG("list_qqstory_home");
    ((b)ppf.a(b.class, new Object[0])).a(this);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
    super.setContentBackground(2130839637);
  }
  
  public void bqJ()
  {
    ThreadManager.getUIHandler().postDelayed(new MystoryListView.6(this), 300L);
    this.jdField_a_of_type_Qye.bpJ();
  }
  
  public void bqK()
  {
    this.oy.setVisibility(8);
    this.jdField_a_of_type_Qye.bpI();
  }
  
  public void bqL()
  {
    if (this.aFY)
    {
      int i = rpq.dip2px(getContext(), 232.0F);
      super.smoothScrollBy(-i, -i);
    }
  }
  
  public void bqM()
  {
    if (this.aFY)
    {
      int i = rpq.dip2px(getContext(), 232.0F);
      super.smoothScrollBy(i, i);
    }
  }
  
  public void brA()
  {
    super.brA();
    QQStoryContext.a();
    Object localObject = QQStoryContext.a();
    oidb_0x791.RedDotInfo localRedDotInfo;
    label48:
    label74:
    int j;
    if (localObject != null)
    {
      localRedDotInfo = ((jnv)((QQAppInterface)localObject).getManager(70)).a();
      if (((qyk)a("FeedSegment")).getCount() <= 0) {
        break label278;
      }
      i = 1;
      String str = rar.gc("home_page-exp-d4");
      localObject = str;
      if (str == null)
      {
        if (!this.aFY) {
          break label283;
        }
        localObject = "2";
      }
      rar.cy("home_page-exp-d4", null);
      if (this.redPointType != 0) {
        break label289;
      }
      j = sW();
      label93:
      rar.a("home_page", "exp", j, i, new String[] { "", "", "", localObject });
      rar.a("home_page", "network", 0, 0, new String[] { "", "", rar.getNetworkType(getContext()) });
      this.redPointType = 0;
      if ((localRedDotInfo != null) && (localRedDotInfo.uint32_appid.get() == 52))
      {
        localObject = ((ptf)psx.a(2)).b(QQStoryContext.a().getCurrentUid());
        if ((localObject == null) || (!((QQUserUIItem)localObject).isVip)) {
          break label297;
        }
        i = 1;
        label219:
        if (i == 0) {
          break label302;
        }
      }
    }
    label278:
    label283:
    label289:
    label297:
    label302:
    for (int i = 1;; i = 2)
    {
      rar.a("play_video", "exp_grey", i, 0, new String[] { "", "", "", "" });
      return;
      ram.e("Q.qqstory.home.MyStoryListView", "Get the QQAppInterface is null,we dont know the red point state");
      localRedDotInfo = null;
      break;
      i = 2;
      break label48;
      localObject = "1";
      break label74;
      j = this.redPointType;
      break label93;
      i = 0;
      break label219;
    }
  }
  
  public void brD()
  {
    this.Bx = System.currentTimeMillis();
    this.jdField_a_of_type_Qye.tf(true);
    super.setSelection(0);
    super.brD();
  }
  
  public void brE()
  {
    ram.w("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), mOverScrollHeight %d firstVisiblePostion %d childCount %d", new Object[] { Integer.valueOf(this.mOverScrollHeight), Integer.valueOf(getFirstVisiblePosition()), Integer.valueOf(getChildCount()) });
    int[] arrayOfInt1 = new int[7];
    int[] tmp48_47 = arrayOfInt1;
    tmp48_47[0] = 0;
    int[] tmp52_48 = tmp48_47;
    tmp52_48[1] = 2;
    int[] tmp56_52 = tmp52_48;
    tmp56_52[2] = 2;
    int[] tmp60_56 = tmp56_52;
    tmp60_56[3] = 2;
    int[] tmp64_60 = tmp60_56;
    tmp64_60[4] = 2;
    int[] tmp68_64 = tmp64_60;
    tmp68_64[5] = 2;
    int[] tmp72_68 = tmp68_64;
    tmp72_68[6] = 1;
    tmp72_68;
    float[] arrayOfFloat = new float[7];
    arrayOfFloat[0] = (getHeight() / 2.0F);
    arrayOfFloat[1] = (getHeight() / 2.0F + 0.5F * this.mOverScrollHeight);
    arrayOfFloat[2] = (getHeight() / 2.0F + 1.0F * this.mOverScrollHeight);
    arrayOfFloat[3] = (getHeight() / 2.0F + 1.5F * this.mOverScrollHeight);
    arrayOfFloat[4] = (getHeight() / 2.0F + this.mOverScrollHeight * 2.0F);
    arrayOfFloat[5] = (getHeight() / 2.0F + this.mOverScrollHeight * 2.5F);
    arrayOfFloat[6] = (getHeight() / 2.0F + this.mOverScrollHeight * 2.5F);
    int[] arrayOfInt2 = new int[7];
    int[] tmp226_224 = arrayOfInt2;
    tmp226_224[0] = 0;
    int[] tmp230_226 = tmp226_224;
    tmp230_226[1] = 50;
    int[] tmp235_230 = tmp230_226;
    tmp235_230[2] = 50;
    int[] tmp240_235 = tmp235_230;
    tmp240_235[3] = 50;
    int[] tmp245_240 = tmp240_235;
    tmp245_240[4] = 50;
    int[] tmp250_245 = tmp245_240;
    tmp250_245[5] = 50;
    int[] tmp255_250 = tmp250_245;
    tmp255_250[6] = 800;
    tmp255_250;
    if ((arrayOfInt1.length == arrayOfFloat.length) && (arrayOfFloat.length == arrayOfInt2.length)) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      this.mScrollRunnable = new MystoryListView.3(this, arrayOfInt1, arrayOfInt2, arrayOfFloat);
      if ((getFirstVisiblePosition() == 0) && (getChildCount() > 0))
      {
        int i = getChildAt(0).getTop();
        ram.w("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), child(0).top = %d", new Object[] { Integer.valueOf(i) });
        if (i >= 0)
        {
          post(this.mScrollRunnable);
          this.mScrollRunnable = null;
        }
      }
      if (this.mScrollRunnable != null)
      {
        ram.w("Q.qqstory.home.MyStoryListView", "doUIPulldownRefresh(), smoothScrollToPostion(0)!");
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, 0, new MystoryListView.4(this), 4);
      }
      return;
    }
  }
  
  public void brF()
  {
    if (this.bow != 1)
    {
      this.bow = 1;
      this.jdField_a_of_type_Psr.n("qqstory_key_story_have_show_click_to_top", Integer.valueOf(1));
    }
    this.jdField_a_of_type_Qye.te(false);
    super.setSelection(0);
  }
  
  public void brz()
  {
    if (this.Bw > 0L)
    {
      localObject = String.valueOf(System.currentTimeMillis() - this.Bw);
      int i = getCount();
      rar.b("story_home_dev", "local_cost", 0, i, new String[] { localObject });
      this.Bw = 0L;
      qwp.d("Q.qqstory.home.MyStoryListView", new Object[] { "onLoadCacheCompile getCount=", Integer.valueOf(i), ",cost time=", localObject });
    }
    brB();
    if (!this.aGb)
    {
      ThreadManager.getUIHandler().postDelayed(new MystoryListView.2(this), 500L);
      return;
    }
    Object localObject = (qvf)psx.a(11);
    ram.b("Q.qqstory.home.position", "start auto jump position:%d, offset:%d", Integer.valueOf(((qvf)localObject).mFirstPosition), Integer.valueOf(((qvf)localObject).bon));
    if ((((qvf)localObject).mFirstPosition != 0) && (((qvf)localObject).bon != 0)) {
      setSelectionFromTop(((qvf)localObject).mFirstPosition, ((qvf)localObject).bon);
    }
    ram.b("Q.qqstory.home.position", "mDisableAutoRefresh：%b", Boolean.valueOf(this.aGb));
    brA();
    this.aJy = true;
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void layoutChildren()
  {
    auvk.traceBegin("MystoryList.layoutChildren");
    super.layoutChildren();
    if (this.aFZ)
    {
      this.aFZ = false;
      qyk localqyk = (qyk)a("FeedSegment");
      if (localqyk != null) {
        localqyk.wH(0);
      }
    }
    auvk.traceEnd();
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.Bw = System.currentTimeMillis();
    this.redPointType = sW();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$a = new a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$a);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    URLDrawable.resume();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$a != null)
    {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$a);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$a = null;
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
      this.y = null;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    StoryInputBarView localStoryInputBarView = this.jdField_a_of_type_Qye.a();
    if (localStoryInputBarView.getVisibility() == 0)
    {
      ((InputMethodManager)this.y.getSystemService("input_method")).hideSoftInputFromWindow(localStoryInputBarView.getWindowToken(), 0);
      localStoryInputBarView.clearFocus();
      localStoryInputBarView.setVisibility(8);
      bqJ();
      int i;
      if (localStoryInputBarView.c != null)
      {
        paramMotionEvent = localStoryInputBarView.c.a;
        i = rar.a(paramMotionEvent.getOwner());
        if (!paramMotionEvent.getOwner().isMe()) {
          break label129;
        }
      }
      label129:
      for (paramMotionEvent = "1";; paramMotionEvent = "2")
      {
        rar.a("home_page", "cancel_reply", i, 0, new String[] { paramMotionEvent, "1", "", "" });
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    URLDrawable.resume();
    StoryInputBarView localStoryInputBarView = this.jdField_a_of_type_Qye.a();
    if (ppg.isQQ())
    {
      this.oy.setVisibility(0);
      localStoryInputBarView.hide();
    }
    this.jdField_a_of_type_Qye.te(false);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (paramInt == 2)
    {
      URLDrawable.pause();
      return;
    }
    URLDrawable.resume();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    this.aFZ = true;
  }
  
  public void setDisableAutoRefresh(boolean paramBoolean)
  {
    this.aGb = paramBoolean;
  }
  
  public void setIsNowTab(boolean paramBoolean)
  {
    this.aFY = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.m = parame;
  }
  
  public void setPullRefreshListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$c = paramc;
  }
  
  public void sk(@NonNull String paramString)
  {
    this.jdField_a_of_type_Qye.tf(true);
    super.sk(paramString);
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    qyk localqyk = (qyk)a("FeedSegment");
    if (localqyk == null) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    localqyk.wF(1);
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    localqyk.wF(0);
    return bool;
  }
  
  public static class a
    extends QQUIEventReceiver<MystoryListView, pnx.a>
  {
    public a(@NonNull MystoryListView paramMystoryListView)
    {
      super();
    }
    
    public void a(@NonNull MystoryListView paramMystoryListView, @NonNull pnx.a parama)
    {
      paramMystoryListView.resetAdapter();
      parama = (qyk)paramMystoryListView.a("FeedSegment");
      if (parama != null) {
        parama.brM();
      }
      paramMystoryListView = (qzh)paramMystoryListView.a("NewMyStorySegment");
      if (paramMystoryListView != null) {
        paramMystoryListView.setOpen(false);
      }
    }
    
    public Class acceptEventClass()
    {
      return pnx.a.class;
    }
  }
  
  public static class b
    implements SegmentList.a
  {
    public void a(SegmentList paramSegmentList)
    {
      if (!(paramSegmentList instanceof MystoryListView)) {
        throw new IllegalArgumentException("arg should match type!");
      }
      paramSegmentList = (MystoryListView)paramSegmentList;
      Activity localActivity = paramSegmentList.y;
      Object localObject = paramSegmentList.a;
      boolean bool = paramSegmentList.KN();
      paramSegmentList.a(ppf.a(localActivity, 5));
      paramSegmentList.a(new qzh(localActivity, (qye)localObject));
      paramSegmentList.a(new qzg(localActivity));
      paramSegmentList.a(new qzc(localActivity));
      localObject = new qyk(localActivity, localActivity, 10, (qye)localObject, bool);
      paramSegmentList.a((rsd)localObject);
      paramSegmentList.a(new qzx(localActivity, "FeedSegment", acfp.m(2131708625) + plr.asY + "\n拍摄一段视频，分享眼前的世界", 2130847477, 2130847478));
      ((qyk)localObject).setDisplay(true);
    }
  }
  
  public static abstract interface c
  {
    public abstract void ao(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void onPullRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView
 * JD-Core Version:    0.7.0.1
 */