import android.animation.ValueAnimator;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.10;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.transition.QCircleTransitionInnerLayout;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class pbc
  extends rxk
  implements rwx, sgl
{
  private ProgressBar E;
  private QCircleTransitionInnerLayout jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout;
  private QCircleTransitionLayout jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout;
  private QCirclePolymorphicAniView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView;
  private RecyclerViewCompat jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  private oyu jdField_a_of_type_Oyu;
  private pbm jdField_a_of_type_Pbm;
  private pbp jdField_a_of_type_Pbp;
  private pdk jdField_a_of_type_Pdk;
  private boolean azi;
  private QCircleInitBean jdField_b_of_type_ComTencentBizQqcircleQCircleInitBean;
  private StatusView jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView;
  private ViewGroup bD;
  private pat c;
  private ViewGroup cn;
  private ImageView lY;
  private ImageView lZ;
  private int mLastPosition;
  private long mLastShowTime;
  private ViewStub w;
  
  private void Z(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setFloatValues(new float[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new pbf(this));
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.start();
  }
  
  private ovv a()
  {
    return new pbl(this);
  }
  
  private void biW()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null)) {
      try
      {
        this.jdField_b_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
        if (this.jdField_a_of_type_Pbm != null)
        {
          Object localObject1 = this.jdField_b_of_type_ComTencentBizQqcircleQCircleInitBean.getFeed();
          if ((localObject1 != null) && (((FeedCloudMeta.StFeed)localObject1).type.get() != 0))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(localObject1);
            this.jdField_a_of_type_Pbm.setDatas((ArrayList)localObject2);
            this.jdField_a_of_type_Pbm.vp(this.jdField_b_of_type_ComTencentBizQqcircleQCircleInitBean.getDataPosInList());
            this.jdField_a_of_type_Pbm.eY(this.jdField_b_of_type_ComTencentBizQqcircleQCircleInitBean.mVideoCurrentPosition);
            bjf();
          }
          Object localObject2 = this.jdField_a_of_type_Pbm;
          if (this.jdField_b_of_type_ComTencentBizQqcircleQCircleInitBean.getExtraTypeInfo() == null) {}
          for (localObject1 = new ExtraTypeInfo();; localObject1 = this.jdField_b_of_type_ComTencentBizQqcircleQCircleInitBean.getExtraTypeInfo())
          {
            ((pbm)localObject2).setExtraTypeInfo((ExtraTypeInfo)localObject1);
            this.c.getLoadInfo().sP(null);
            this.c.a(this.jdField_b_of_type_ComTencentBizQqcircleQCircleInitBean, false);
            return;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void bjb()
  {
    if ((getActivity() != null) && (getActivity().getIntent().hasExtra("bundle_key_parms_extra")))
    {
      Object localObject = getActivity().getIntent().getBundleExtra("bundle_key_parms_extra");
      if (sge.s((Bundle)localObject))
      {
        this.jdField_a_of_type_Pdk = new pdk((Bundle)localObject);
        if (this.jdField_a_of_type_Pdk.e() != null)
        {
          localObject = new FrameLayout.LayoutParams(-1, -1);
          this.bD.addView(this.jdField_a_of_type_Pdk.e(), (ViewGroup.LayoutParams)localObject);
        }
        this.jdField_a_of_type_Pdk.a(this);
      }
    }
  }
  
  private void bjc()
  {
    this.c.j().observe(b(), new pbh(this));
  }
  
  private void bjd()
  {
    if (System.currentTimeMillis() - this.mLastShowTime > 2000L)
    {
      Toast.makeText(getContext(), 2131700123, 0).show();
      this.mLastShowTime = System.currentTimeMillis();
    }
  }
  
  private void bje()
  {
    if ((this.c != null) && (!this.c.getLoadInfo().isFinish()) && (!this.c.getLoadInfo().isLoading()))
    {
      this.c.a(this.jdField_b_of_type_ComTencentBizQqcircleQCircleInitBean, true);
      bjk();
    }
  }
  
  private void bjf()
  {
    if (this.E != null)
    {
      this.E.setVisibility(8);
      this.E.setIndeterminate(false);
    }
  }
  
  private void bjk()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.rs(false);
    }
  }
  
  private void bjl()
  {
    ThreadManager.getUIHandler().postDelayed(new QCircleContentPart.10(this), 500L);
  }
  
  private void dG(View paramView)
  {
    this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView = ((StatusView)paramView.findViewById(2131379035));
    this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView.E().setTextColor(-1);
    this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView.setBackgroundColor(-16777216);
    this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView.o().setImageResource(2130844778);
    this.jdField_b_of_type_ComTencentBizSubscribeWidgetStatusView.o().setLayoutParams(new LinearLayout.LayoutParams(ImmersiveUtils.dpToPx(60.0F), ImmersiveUtils.dpToPx(60.0F)));
  }
  
  private void dH(View paramView)
  {
    int j = 0;
    String str = aqfe.get(paramView.getContext(), "key_sp_content_detail_is_show_guide_count");
    if (str.equals("")) {}
    for (int i = 0;; i = Integer.parseInt(str))
    {
      if (i < 3) {
        j = 1;
      }
      if ((j == 0) || (oug.ayA) || (this.jdField_b_of_type_ComTencentBizQqcircleQCircleInitBean == null) || (this.jdField_b_of_type_ComTencentBizQqcircleQCircleInitBean.isSingleFeed)) {
        break;
      }
      bjk();
      this.jdField_a_of_type_Pbp = new pbp(this.bD);
      this.jdField_a_of_type_Pbp.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
      this.jdField_a_of_type_Pbp.bjr();
      this.jdField_a_of_type_Pbp.a(new pbg(this));
      oug.ayA = true;
      aqfe.J(paramView.getContext(), "key_sp_content_detail_is_show_guide_count", String.valueOf(i + 1));
      return;
    }
    bjl();
  }
  
  private void kJ()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnScrollListener(new pbi(this));
    }
    if (this.lY != null) {
      this.lY.setOnClickListener(new pbj(this));
    }
    if (this.lZ != null) {
      this.lZ.setOnClickListener(new pbk(this));
    }
  }
  
  private void setAlpha(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAlpha(paramInt);
    }
    if (this.cn != null) {
      this.cn.setAlpha(paramInt);
    }
  }
  
  public QCircleTransitionLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout;
  }
  
  public void bjg()
  {
    setAlpha(0);
  }
  
  public void bjh()
  {
    setAlpha(0);
  }
  
  public void bji()
  {
    setAlpha(1);
  }
  
  public void bjj()
  {
    setAlpha(1);
  }
  
  protected void dC(View paramView)
  {
    super.dC(paramView);
    if ((paramView instanceof QCircleTransitionLayout))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout = ((QCircleTransitionLayout)paramView);
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout = ((QCircleTransitionInnerLayout)paramView.findViewById(2131367167));
      if ((this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout != null) && (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.getBackground() != null)) {
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.getBackground().setAlpha(255);
      }
      if (!(getActivity() instanceof PublicTransFragmentActivity)) {
        break label382;
      }
      if ((b() instanceof QCircleBaseFragment)) {
        ((QCircleBaseFragment)b()).L(false);
      }
      bjk();
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout, new pbd(this));
    }
    for (;;)
    {
      this.w = ((ViewStub)paramView.findViewById(2131382098));
      this.jdField_a_of_type_Oyu = new oyu(getActivity());
      this.jdField_a_of_type_Oyu.a(getActivity(), this.w);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = ((QCirclePolymorphicAniView)paramView.findViewById(2131374561));
      this.c = ((pat)getViewModel(pat.class));
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((RecyclerViewCompat)paramView.findViewById(2131377613));
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setLayoutManager(new LinearLayoutManager(paramView.getContext(), 1, false));
      auwv localauwv = new auwv();
      this.jdField_a_of_type_Pbm = new pbm(this, localauwv);
      this.jdField_a_of_type_Pbm.setInteractor(a());
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAdapter(this.jdField_a_of_type_Pbm);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnScrollListener(new pbe(this));
      this.cn = ((ViewGroup)paramView.findViewById(2131370682));
      this.lY = ((ImageView)paramView.findViewById(2131369672));
      this.lZ = ((ImageView)paramView.findViewById(2131369896));
      this.E = ((ProgressBar)paramView.findViewById(2131373864));
      dG(paramView);
      localauwv.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
      kJ();
      biW();
      bjc();
      this.bD = ((ViewGroup)paramView);
      rwv.a().a(this);
      bjb();
      return;
      label382:
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.bkd();
      if ((b() instanceof QCircleBaseFragment)) {
        ((QCircleBaseFragment)b()).L(true);
      }
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public String getLogTag()
  {
    return "QCircleContentPart";
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAdapter(null);
    }
    rwv.a().b(this);
    if (this.c != null) {
      this.c.onDestroy();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if ((this.c != null) && ((this.c.a() instanceof pao.b)))
    {
      paramActivity = ((pao.b)this.c.a()).a;
      if (!paramActivity.Ml())
      {
        paramActivity.pause();
        paramActivity.setInterrupt(true);
      }
      String str = paramActivity.getPlayUrl();
      if (!TextUtils.isEmpty(str))
      {
        long l = paramActivity.getCurrentPosition();
        rwv.a().a(new QCircleFeedVideoPositionLinkEvent(str, l));
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.azi = false;
    if ((this.c != null) && ((this.c.a() instanceof pao.b)))
    {
      paramActivity = ((pao.b)this.c.a()).a;
      if (paramActivity.Mn()) {
        paramActivity.start();
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
  }
  
  public boolean onBackEvent()
  {
    return ((this.jdField_a_of_type_Pbm != null) && (this.jdField_a_of_type_Pbm.onBackEvent())) || (super.onBackEvent());
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedEvent)) && (this.jdField_a_of_type_Pbm != null) && (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 3))
    {
      this.jdField_a_of_type_Pbm.eO(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
      if ((this.jdField_a_of_type_Pbm.getDataList().size() == 0) && (getActivity() != null)) {
        getActivity().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbc
 * JD-Core Version:    0.7.0.1
 */