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
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class txz
  extends tvv
  implements yiy, ylc
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private QCircleTransitionInnerLayout jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout;
  private QCircleTransitionLayout jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout;
  private QCirclePolymorphicAniView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private RecyclerViewCompat jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  private tuz jdField_a_of_type_Tuz;
  private txq jdField_a_of_type_Txq;
  private tyj jdField_a_of_type_Tyj;
  private tyn jdField_a_of_type_Tyn;
  private uaj jdField_a_of_type_Uaj;
  private boolean jdField_a_of_type_Boolean;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  private trw a()
  {
    return new tyi(this);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAlpha(paramInt);
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setAlpha(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setFloatValues(new float[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new tyc(this));
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.start();
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = ((StatusView)paramView.findViewById(2131377299));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a().setTextColor(-1);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.b().setImageResource(2130840191);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.b().setLayoutParams(new LinearLayout.LayoutParams(ImmersiveUtils.a(60.0F), ImmersiveUtils.a(60.0F)));
  }
  
  private void c(View paramView)
  {
    int j = 0;
    String str = bdea.a(paramView.getContext(), "key_sp_content_detail_is_show_guide_count");
    if (str.equals("")) {}
    for (int i = 0;; i = Integer.parseInt(str))
    {
      if (i < 3) {
        j = 1;
      }
      if ((j == 0) || (tqb.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean == null) || (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.isSingleFeed)) {
        break;
      }
      k();
      this.jdField_a_of_type_Tyn = new tyn(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Tyn.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
      this.jdField_a_of_type_Tyn.a();
      this.jdField_a_of_type_Tyn.a(new tyd(this));
      tqb.jdField_a_of_type_Boolean = true;
      bdea.a(paramView.getContext(), "key_sp_content_detail_is_show_guide_count", String.valueOf(i + 1));
      return;
    }
    l();
  }
  
  private void e()
  {
    if ((a() != null) && (a().getIntent().hasExtra("bundle_key_parms_extra")))
    {
      Object localObject = a().getIntent().getBundleExtra("bundle_key_parms_extra");
      if (ykt.a((Bundle)localObject))
      {
        this.jdField_a_of_type_Uaj = new uaj((Bundle)localObject);
        if (this.jdField_a_of_type_Uaj.a() != null)
        {
          localObject = new FrameLayout.LayoutParams(-1, -1);
          this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_Uaj.a(), (ViewGroup.LayoutParams)localObject);
        }
        this.jdField_a_of_type_Uaj.a(this);
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Txq.a().observe(a(), new tye(this));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnScrollListener(new tyf(this));
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new tyg(this));
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new tyh(this));
    }
  }
  
  private void h()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000L)
    {
      Toast.makeText(a(), 2131698333, 0).show();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Txq != null) && (!this.jdField_a_of_type_Txq.a().a()) && (!this.jdField_a_of_type_Txq.a().b()))
    {
      this.jdField_a_of_type_Txq.a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean, true);
      k();
    }
  }
  
  private void j()
  {
    if ((a() != null) && (a().getIntent() != null)) {
      try
      {
        this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
        if (this.jdField_a_of_type_Tyj != null)
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getFeed();
          if ((localObject1 != null) && (((FeedCloudMeta.StFeed)localObject1).type.get() != 0))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(localObject1);
            this.jdField_a_of_type_Tyj.setDatas((ArrayList)localObject2);
            this.jdField_a_of_type_Tyj.a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getDataPosInList());
            this.jdField_a_of_type_Tyj.a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.mVideoCurrentPosition);
          }
          Object localObject2 = this.jdField_a_of_type_Tyj;
          if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getExtraTypeInfo() == null) {}
          for (localObject1 = new ExtraTypeInfo();; localObject1 = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getExtraTypeInfo())
          {
            ((tyj)localObject2).a((ExtraTypeInfo)localObject1);
            this.jdField_a_of_type_Txq.a().a(null);
            this.jdField_a_of_type_Txq.a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean, false);
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
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.b(false);
    }
  }
  
  private void l()
  {
    ThreadManager.getUIHandler().postDelayed(new QCircleContentPart.10(this), 500L);
  }
  
  public QCircleTransitionLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout;
  }
  
  public String a()
  {
    return "QCircleContentPart";
  }
  
  public void a()
  {
    a(0);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if ((paramView instanceof QCircleTransitionLayout))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout = ((QCircleTransitionLayout)paramView);
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout = ((QCircleTransitionInnerLayout)paramView.findViewById(2131366428));
      if ((this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout != null) && (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.getBackground() != null)) {
        this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.getBackground().setAlpha(255);
      }
      if (!(a() instanceof PublicTransFragmentActivity)) {
        break label369;
      }
      if ((a() instanceof QCircleBaseFragment)) {
        ((QCircleBaseFragment)a()).a(false);
      }
      k();
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout, new tya(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380108));
      this.jdField_a_of_type_Tuz = new tuz(a());
      this.jdField_a_of_type_Tuz.a(a(), this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = ((QCirclePolymorphicAniView)paramView.findViewById(2131373208));
      this.jdField_a_of_type_Txq = ((txq)a(txq.class));
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((RecyclerViewCompat)paramView.findViewById(2131376098));
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setLayoutManager(new LinearLayoutManager(paramView.getContext(), 1, false));
      bies localbies = new bies();
      this.jdField_a_of_type_Tyj = new tyj(this, localbies);
      this.jdField_a_of_type_Tyj.a(a());
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAdapter(this.jdField_a_of_type_Tyj);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnScrollListener(new tyb(this));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369667));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368710));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368912));
      b(paramView);
      localbies.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
      g();
      j();
      f();
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      yiw.a().a(this);
      e();
      return;
      label369:
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout.a();
      if ((a() instanceof QCircleBaseFragment)) {
        ((QCircleBaseFragment)a()).a(true);
      }
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_Tyj != null) && (this.jdField_a_of_type_Tyj.a())) || (super.a());
  }
  
  public void b()
  {
    a(0);
  }
  
  public void c()
  {
    a(1);
  }
  
  public void d()
  {
    a(1);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAdapter(null);
    }
    yiw.a().b(this);
    if (this.jdField_a_of_type_Txq != null) {
      this.jdField_a_of_type_Txq.a();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if ((this.jdField_a_of_type_Txq != null) && ((this.jdField_a_of_type_Txq.a() instanceof txn)))
    {
      paramActivity = ((txn)this.jdField_a_of_type_Txq.a()).a;
      if (!paramActivity.a())
      {
        paramActivity.b();
        paramActivity.setInterrupt(true);
      }
      String str = paramActivity.a();
      if (!TextUtils.isEmpty(str))
      {
        long l = paramActivity.a();
        yiw.a().a(new QCircleFeedVideoPositionLinkEvent(str, l));
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Txq != null) && ((this.jdField_a_of_type_Txq.a() instanceof txn)))
    {
      paramActivity = ((txn)this.jdField_a_of_type_Txq.a()).a;
      if (paramActivity.c()) {
        paramActivity.c();
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedEvent)) && (this.jdField_a_of_type_Tyj != null) && (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 3))
    {
      this.jdField_a_of_type_Tyj.a(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
      if ((this.jdField_a_of_type_Tyj.getDataList().size() == 0) && (a() != null)) {
        a().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txz
 * JD-Core Version:    0.7.0.1
 */