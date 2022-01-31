import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;

public class txe
  extends tvg
  implements yel
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private RecyclerViewCompat jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  private twv jdField_a_of_type_Twv;
  private txk jdField_a_of_type_Txk;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  
  private void a()
  {
    this.jdField_a_of_type_Twv.a().observe(a(), new txg(this));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnScrollListener(new txh(this));
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new txi(this));
    }
    if (this.b != null) {
      this.b.setOnClickListener(new txj(this));
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = ((StatusView)paramView.findViewById(2131377245));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.a().setTextColor(-1);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.b().setImageResource(2130840190);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.b().setLayoutParams(new LinearLayout.LayoutParams(ImmersiveUtils.a(60.0F), ImmersiveUtils.a(60.0F)));
  }
  
  private void c()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000L)
    {
      Toast.makeText(a(), 2131698324, 0).show();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private void c(View paramView)
  {
    int j = 0;
    Object localObject = bczr.a(paramView.getContext(), "key_sp_content_detail_is_show_guide_count");
    if (((String)localObject).equals("")) {}
    for (int i = 0;; i = Integer.parseInt((String)localObject))
    {
      if (i < 3) {
        j = 1;
      }
      if ((j != 0) && (!tqb.jdField_a_of_type_Boolean))
      {
        localObject = new txp(this.jdField_a_of_type_AndroidViewViewGroup);
        ((txp)localObject).a(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
        ((txp)localObject).a();
        tqb.jdField_a_of_type_Boolean = true;
        bczr.a(paramView.getContext(), "key_sp_content_detail_is_show_guide_count", String.valueOf(i + 1));
      }
      return;
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Twv != null) && (!this.jdField_a_of_type_Twv.a().a()) && (!this.jdField_a_of_type_Twv.a().b())) {
      this.jdField_a_of_type_Twv.a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean, true);
    }
  }
  
  private void e()
  {
    if ((a() != null) && (a().getIntent() != null)) {
      try
      {
        this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
        if (this.jdField_a_of_type_Txk != null)
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getFeed();
          if ((localObject1 != null) && (((FeedCloudMeta.StFeed)localObject1).type.get() != 0))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(localObject1);
            this.jdField_a_of_type_Txk.a((ArrayList)localObject2);
            this.jdField_a_of_type_Txk.a(((FeedCloudMeta.StFeed)localObject1).id.get(), this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getDataPosInList());
            this.jdField_a_of_type_Txk.a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.mVideoCurrentPosition);
          }
          Object localObject2 = this.jdField_a_of_type_Txk;
          if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getExtraTypeInfo() == null) {}
          for (localObject1 = new ExtraTypeInfo();; localObject1 = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getExtraTypeInfo())
          {
            ((txk)localObject2).a((ExtraTypeInfo)localObject1);
            this.jdField_a_of_type_Twv.a().a(null);
            this.jdField_a_of_type_Twv.a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean, false);
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
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_Twv = ((twv)a(twv.class));
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((RecyclerViewCompat)paramView.findViewById(2131376045));
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setLayoutManager(new LinearLayoutManager(paramView.getContext(), 1, false));
    bial localbial = new bial();
    this.jdField_a_of_type_Txk = new txk(this, localbial);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAdapter(this.jdField_a_of_type_Txk);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnScrollListener(new txf(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368698));
    this.b = ((ImageView)paramView.findViewById(2131368894));
    b(paramView);
    localbial.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
    b();
    e();
    a();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
    yej.a().a(this);
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedEvent)) && (this.jdField_a_of_type_Txk != null) && (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 3))
    {
      this.jdField_a_of_type_Txk.a(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
      if ((this.jdField_a_of_type_Txk.b().size() == 0) && (a() != null)) {
        a().finish();
      }
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_Txk != null) && (this.jdField_a_of_type_Txk.a())) || (super.a());
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAdapter(null);
    }
    yej.a().b(this);
    if (this.jdField_a_of_type_Twv != null) {
      this.jdField_a_of_type_Twv.a();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if ((this.jdField_a_of_type_Twv != null) && ((this.jdField_a_of_type_Twv.a() instanceof twu)))
    {
      paramActivity = ((twu)this.jdField_a_of_type_Twv.a()).a;
      if (!paramActivity.a())
      {
        paramActivity.b();
        paramActivity.setInterrupt(true);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Twv != null) && ((this.jdField_a_of_type_Twv.a() instanceof twu)))
    {
      paramActivity = ((twu)this.jdField_a_of_type_Twv.a()).a;
      if (paramActivity.c()) {
        paramActivity.c();
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txe
 * JD-Core Version:    0.7.0.1
 */