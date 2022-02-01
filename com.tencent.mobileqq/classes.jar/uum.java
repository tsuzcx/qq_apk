import UserGrowth.stReportItem;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uum
  extends uej<usv>
  implements View.OnClickListener
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private ugp jdField_a_of_type_Ugp;
  private TextView b;
  
  public uum(Context paramContext)
  {
    super(paramContext);
  }
  
  public uum(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (TextUtils.equals(uqt.f(), paramstSimpleMetaPerson.id))
    {
      this.b.setVisibility(8);
      return;
    }
    int i = paramstSimpleMetaPerson.followStatus;
    uqf.d("WSVerticalItemTopController", "followStatus:" + i + ",personInfo hashCode:" + paramstSimpleMetaPerson.hashCode());
    if (upw.a(paramstSimpleMetaPerson.followStatus))
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.setText("关注");
    this.b.setVisibility(0);
  }
  
  private void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson != null)
    {
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.avatarSchema;
      if (paramstSimpleMetaPerson != null) {
        switch (paramstSimpleMetaPerson.type)
        {
        }
      }
    }
    for (;;)
    {
      uqf.b("WSVerticalItemTopController", "Jump to personal page.");
      return;
      Object localObject = paramstSimpleMetaPerson.miniAppSchema;
      uqf.d("weishi", "miniShema is :" + (String)localObject);
      ujx.a().a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson.miniAppSchema);
      c(1000001);
      continue;
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.schema;
      int i = ugd.a().a();
      if (zqd.a(this.jdField_a_of_type_AndroidContentContext))
      {
        uqh.a(this.jdField_a_of_type_AndroidContentContext, "biz_src_jc_gzh_weishi", paramstSimpleMetaPerson, 1, i, 1);
        c(1000003);
      }
      for (;;)
      {
        uqf.d("weishi", "schema is :" + paramstSimpleMetaPerson);
        break;
        localObject = new WSDownloadParams();
        ((WSDownloadParams)localObject).mScene = 1;
        ((WSDownloadParams)localObject).mLinkStrategyType = i;
        ((WSDownloadParams)localObject).mEventId = 1;
        ((WSDownloadParams)localObject).mTestId = uqt.a(2);
        stReportItem localstReportItem = uno.a();
        localstReportItem.pagetype = 2;
        localstReportItem.optype = 115;
        ((WSDownloadParams)localObject).mStReportItem = localstReportItem;
        ((WSDownloadParams)localObject).mScheme = paramstSimpleMetaPerson;
        ugz.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), (WSDownloadParams)localObject, false);
        c(1000002);
      }
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.H5Url;
      ueg.a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson);
      uqf.d("weishi", "h5Url is :" + paramstSimpleMetaPerson);
      c(1000004);
    }
  }
  
  private void c(int paramInt)
  {
    uvv.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramInt, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void f()
  {
    if (!nny.a(a())) {
      bjuh.a().a(2131719373);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Ugp == null) {
            this.jdField_a_of_type_Ugp = ugp.a();
          }
          localObject = (usv)a();
        } while (localObject == null);
        uqf.b("WSVerticalItemTopController", "Follow user.");
      } while (!(((usv)localObject).a() instanceof stSimpleMetaFeed));
      localObject = ((stSimpleMetaFeed)((usv)localObject).a()).poster;
    } while (localObject == null);
    if (upw.a(((stSimpleMetaPerson)localObject).followStatus))
    {
      upw.a(a(), new uun(this, (stSimpleMetaPerson)localObject), null);
      return;
    }
    this.jdField_a_of_type_Ugp.b(((stSimpleMetaPerson)localObject).id, 1);
    ((stSimpleMetaPerson)localObject).followStatus = 1;
    this.b.setText("已关注");
    uqf.a("WSVerticalItemTopController", "---> followStatus:" + ((stSimpleMetaPerson)localObject).followStatus + ",personInfo hashCode:" + localObject.hashCode());
    this.b.setVisibility(8);
  }
  
  protected void a()
  {
    usv localusv = (usv)a();
    if (localusv == null) {}
    while (!(localusv.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localusv.a());
  }
  
  protected int b()
  {
    return 2131560032;
  }
  
  @UiThread
  protected void b()
  {
    uqf.a("WSVerticalItemTopController", "onUpdateUI hashcode******************************" + hashCode() + ",position:" + a());
    Object localObject = (usv)a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!(((usv)localObject).a() instanceof stSimpleMetaFeed));
      localObject = ((stSimpleMetaFeed)((usv)localObject).a()).poster;
    } while (localObject == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((stSimpleMetaPerson)localObject).nick);
    uqt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, ((stSimpleMetaPerson)localObject).avatar);
    a((stSimpleMetaPerson)localObject);
  }
  
  protected void c() {}
  
  protected void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = uqs.b();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = uqs.b((Activity)this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams.leftMargin = uqs.a();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131380680));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380684));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b = ((TextView)a(2131380683));
    this.b.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = ((stSimpleMetaFeed)((usv)a()).a()).poster;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(localstSimpleMetaPerson);
      continue;
      f();
      uvv.f(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uum
 * JD-Core Version:    0.7.0.1
 */