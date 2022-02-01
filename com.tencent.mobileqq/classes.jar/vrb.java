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

public class vrb
  extends uyw<vpj>
  implements View.OnClickListener
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private vbg jdField_a_of_type_Vbg;
  private TextView b;
  
  public vrb(Context paramContext)
  {
    super(paramContext);
  }
  
  public vrb(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (TextUtils.equals(vnd.f(), paramstSimpleMetaPerson.id))
    {
      this.b.setVisibility(8);
      return;
    }
    int i = paramstSimpleMetaPerson.followStatus;
    vmp.d("WSVerticalItemTopController", "followStatus:" + i + ",personInfo hashCode:" + paramstSimpleMetaPerson.hashCode());
    if (vmg.a(paramstSimpleMetaPerson.followStatus))
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
      vmp.b("WSVerticalItemTopController", "Jump to personal page.");
      return;
      Object localObject = paramstSimpleMetaPerson.miniAppSchema;
      vmp.d("weishi", "miniShema is :" + (String)localObject);
      vfa.a().a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson.miniAppSchema);
      c(1000001);
      continue;
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.schema;
      int i = vau.a().a();
      if (zfn.a(this.jdField_a_of_type_AndroidContentContext))
      {
        vmr.a(this.jdField_a_of_type_AndroidContentContext, "biz_src_jc_gzh_weishi", paramstSimpleMetaPerson, 1, i, 1);
        c(1000003);
      }
      for (;;)
      {
        vmp.d("weishi", "schema is :" + paramstSimpleMetaPerson);
        break;
        localObject = new WSDownloadParams();
        ((WSDownloadParams)localObject).mScene = voq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
        ((WSDownloadParams)localObject).mLinkStrategyType = i;
        ((WSDownloadParams)localObject).mEventId = 1;
        ((WSDownloadParams)localObject).mTestId = vnd.a(2);
        stReportItem localstReportItem = vjx.a();
        localstReportItem.pagetype = 2;
        localstReportItem.optype = 115;
        ((WSDownloadParams)localObject).mStReportItem = localstReportItem;
        ((WSDownloadParams)localObject).mScheme = paramstSimpleMetaPerson;
        vbq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), (WSDownloadParams)localObject, false);
        c(1000002);
      }
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.H5Url;
      uyt.a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson);
      vmp.d("weishi", "h5Url is :" + paramstSimpleMetaPerson);
      c(1000004);
    }
  }
  
  private void c(int paramInt)
  {
    vsj.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramInt, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void f()
  {
    if (!NetworkUtil.isNetworkAvailable(a())) {
      bjkv.a().a(2131720145);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Vbg == null) {
            this.jdField_a_of_type_Vbg = vbg.a();
          }
          localObject = (vpj)a();
        } while (localObject == null);
        vmp.b("WSVerticalItemTopController", "Follow user.");
      } while (!(((vpj)localObject).a() instanceof stSimpleMetaFeed));
      localObject = ((stSimpleMetaFeed)((vpj)localObject).a()).poster;
    } while (localObject == null);
    if (vmg.a(((stSimpleMetaPerson)localObject).followStatus))
    {
      vmg.a(a(), new vrc(this, (stSimpleMetaPerson)localObject), null);
      return;
    }
    this.jdField_a_of_type_Vbg.b(((stSimpleMetaPerson)localObject).id, 1);
    ((stSimpleMetaPerson)localObject).followStatus = 1;
    this.b.setText("已关注");
    vmp.a("WSVerticalItemTopController", "---> followStatus:" + ((stSimpleMetaPerson)localObject).followStatus + ",personInfo hashCode:" + localObject.hashCode());
    this.b.setVisibility(8);
  }
  
  protected void a()
  {
    vpj localvpj = (vpj)a();
    if (localvpj == null) {}
    while (!(localvpj.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localvpj.a());
  }
  
  protected int b()
  {
    return 2131560082;
  }
  
  @UiThread
  protected void b()
  {
    vmp.a("WSVerticalItemTopController", "onUpdateUI hashcode******************************" + hashCode() + ",position:" + a());
    Object localObject = (vpj)a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!(((vpj)localObject).a() instanceof stSimpleMetaFeed));
      localObject = ((stSimpleMetaFeed)((vpj)localObject).a()).poster;
    } while (localObject == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((stSimpleMetaPerson)localObject).nick);
    vnd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, ((stSimpleMetaPerson)localObject).avatar);
    a((stSimpleMetaPerson)localObject);
  }
  
  protected void c() {}
  
  protected void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = vnc.b();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = vnc.b((Activity)this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams.leftMargin = vnc.a();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131380744));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380749));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b = ((TextView)a(2131380748));
    this.b.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = ((stSimpleMetaFeed)((vpj)a()).a()).poster;
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
      vsj.f(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrb
 * JD-Core Version:    0.7.0.1
 */