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
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vch
  extends ukz<vaq>
  implements View.OnClickListener
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private ung jdField_a_of_type_Ung;
  private TextView b;
  
  public vch(Context paramContext)
  {
    super(paramContext);
  }
  
  public vch(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (TextUtils.equals(uyo.f(), paramstSimpleMetaPerson.id))
    {
      this.b.setVisibility(8);
      return;
    }
    int i = paramstSimpleMetaPerson.followStatus;
    uya.d("WSVerticalItemTopController", "followStatus:" + i + ",personInfo hashCode:" + paramstSimpleMetaPerson.hashCode());
    if (uxr.a(paramstSimpleMetaPerson.followStatus))
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
      uya.b("WSVerticalItemTopController", "Jump to personal page.");
      return;
      Object localObject = paramstSimpleMetaPerson.miniAppSchema;
      uya.d("weishi", "miniShema is :" + (String)localObject);
      uqs.a().a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson.miniAppSchema);
      c(1000001);
      continue;
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.schema;
      int i = umu.a().a();
      if (yqu.a(this.jdField_a_of_type_AndroidContentContext))
      {
        uyc.a(this.jdField_a_of_type_AndroidContentContext, "biz_src_jc_gzh_weishi", paramstSimpleMetaPerson, 1, i, 1);
        c(1000003);
      }
      for (;;)
      {
        uya.d("weishi", "schema is :" + paramstSimpleMetaPerson);
        break;
        localObject = new WSDownloadParams();
        ((WSDownloadParams)localObject).mScene = 1;
        ((WSDownloadParams)localObject).mLinkStrategyType = i;
        ((WSDownloadParams)localObject).mEventId = 1;
        ((WSDownloadParams)localObject).mTestId = uyo.a(2);
        stReportItem localstReportItem = uvi.a();
        localstReportItem.pagetype = 2;
        localstReportItem.optype = 115;
        ((WSDownloadParams)localObject).mStReportItem = localstReportItem;
        ((WSDownloadParams)localObject).mScheme = paramstSimpleMetaPerson;
        unq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), (WSDownloadParams)localObject, false);
        c(1000002);
      }
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.H5Url;
      ukw.a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson);
      uya.d("weishi", "h5Url is :" + paramstSimpleMetaPerson);
      c(1000004);
    }
  }
  
  private void c(int paramInt)
  {
    vdq.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramInt, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void f()
  {
    if (!NetworkUtil.isNetworkAvailable(a())) {
      bhzt.a().a(2131719692);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Ung == null) {
            this.jdField_a_of_type_Ung = ung.a();
          }
          localObject = (vaq)a();
        } while (localObject == null);
        uya.b("WSVerticalItemTopController", "Follow user.");
      } while (!(((vaq)localObject).a() instanceof stSimpleMetaFeed));
      localObject = ((stSimpleMetaFeed)((vaq)localObject).a()).poster;
    } while (localObject == null);
    if (uxr.a(((stSimpleMetaPerson)localObject).followStatus))
    {
      uxr.a(a(), new vci(this, (stSimpleMetaPerson)localObject), null);
      return;
    }
    this.jdField_a_of_type_Ung.b(((stSimpleMetaPerson)localObject).id, 1);
    ((stSimpleMetaPerson)localObject).followStatus = 1;
    this.b.setText("已关注");
    uya.a("WSVerticalItemTopController", "---> followStatus:" + ((stSimpleMetaPerson)localObject).followStatus + ",personInfo hashCode:" + localObject.hashCode());
    this.b.setVisibility(8);
  }
  
  protected void a()
  {
    vaq localvaq = (vaq)a();
    if (localvaq == null) {}
    while (!(localvaq.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localvaq.a());
  }
  
  protected int b()
  {
    return 2131560038;
  }
  
  @UiThread
  protected void b()
  {
    uya.a("WSVerticalItemTopController", "onUpdateUI hashcode******************************" + hashCode() + ",position:" + a());
    Object localObject = (vaq)a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!(((vaq)localObject).a() instanceof stSimpleMetaFeed));
      localObject = ((stSimpleMetaFeed)((vaq)localObject).a()).poster;
    } while (localObject == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((stSimpleMetaPerson)localObject).nick);
    uyo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, ((stSimpleMetaPerson)localObject).avatar);
    a((stSimpleMetaPerson)localObject);
  }
  
  protected void c() {}
  
  protected void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = uyn.b();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = uyn.b((Activity)this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams.leftMargin = uyn.a();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131380406));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380410));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b = ((TextView)a(2131380409));
    this.b.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = ((stSimpleMetaFeed)((vaq)a()).a()).poster;
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
      vdq.f(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vch
 * JD-Core Version:    0.7.0.1
 */