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

public class tna
  extends tck<tmv>
  implements View.OnClickListener
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private tep jdField_a_of_type_Tep;
  private TextView b;
  
  public tna(Context paramContext)
  {
    super(paramContext);
  }
  
  public tna(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (TextUtils.equals(tlv.f(), paramstSimpleMetaPerson.id))
    {
      this.b.setVisibility(8);
      return;
    }
    int i = paramstSimpleMetaPerson.followStatus;
    tlo.d("WSVerticalItemTopController", "followStatus:" + i + ",personInfo hashCode:" + paramstSimpleMetaPerson.hashCode());
    if (tlf.a(paramstSimpleMetaPerson.followStatus))
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
      tlo.b("WSVerticalItemTopController", "Jump to personal page.");
      return;
      Object localObject = paramstSimpleMetaPerson.miniAppSchema;
      tlo.d("weishi", "miniShema is :" + (String)localObject);
      tgn.a().a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson.miniAppSchema);
      tnt.c(1000001, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
      continue;
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.schema;
      int i = tee.a().a();
      if (xoo.a(this.jdField_a_of_type_AndroidContentContext))
      {
        tlq.a(this.jdField_a_of_type_AndroidContentContext, "biz_src_jc_gzh_weishi", paramstSimpleMetaPerson, 1, i, 1);
        tnt.c(1000003, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
      }
      for (;;)
      {
        tlo.d("weishi", "schema is :" + paramstSimpleMetaPerson);
        break;
        localObject = new WSDownloadParams();
        ((WSDownloadParams)localObject).mScene = 1;
        ((WSDownloadParams)localObject).mLinkStrategyType = i;
        ((WSDownloadParams)localObject).mEventId = 1;
        ((WSDownloadParams)localObject).mTestId = tlv.a(2);
        stReportItem localstReportItem = tjr.a();
        localstReportItem.pagetype = 2;
        localstReportItem.optype = 115;
        ((WSDownloadParams)localObject).mStReportItem = localstReportItem;
        ((WSDownloadParams)localObject).mScheme = paramstSimpleMetaPerson;
        tfa.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), (WSDownloadParams)localObject, false);
        tnt.c(1000002, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
      }
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.H5Url;
      tch.a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson);
      tlo.d("weishi", "h5Url is :" + paramstSimpleMetaPerson);
      tnt.c(1000004, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
  
  private void f()
  {
    if (!ndk.a(a())) {
      bfhq.a().a(2131721476);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Tep == null) {
            this.jdField_a_of_type_Tep = tep.a();
          }
          localObject = (tmv)a();
        } while (localObject == null);
        tlo.b("WSVerticalItemTopController", "Follow user.");
      } while (!(((tmv)localObject).a() instanceof stSimpleMetaFeed));
      localObject = ((stSimpleMetaFeed)((tmv)localObject).a()).poster;
    } while (localObject == null);
    if (tlf.a(((stSimpleMetaPerson)localObject).followStatus))
    {
      tlf.a(a(), new tnb(this, (stSimpleMetaPerson)localObject), null);
      return;
    }
    this.jdField_a_of_type_Tep.b(((stSimpleMetaPerson)localObject).id, 1);
    ((stSimpleMetaPerson)localObject).followStatus = 1;
    if ((tfw.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (tfw.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster != null)) {
      tfw.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.followStatus = 1;
    }
    this.b.setText("已关注");
    tlo.a("WSVerticalItemTopController", "---> followStatus:" + ((stSimpleMetaPerson)localObject).followStatus + ",personInfo hashCode:" + localObject.hashCode());
    this.b.setVisibility(8);
  }
  
  protected void a()
  {
    tmv localtmv = (tmv)a();
    if (localtmv == null) {}
    while (!(localtmv.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localtmv.a());
  }
  
  protected int b()
  {
    return 2131559874;
  }
  
  @UiThread
  protected void b()
  {
    tlo.a("WSVerticalItemTopController", "onUpdateUI hashcode******************************" + hashCode() + ",position:" + a());
    Object localObject = (tmv)a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!(((tmv)localObject).a() instanceof stSimpleMetaFeed));
      localObject = ((stSimpleMetaFeed)((tmv)localObject).a()).poster;
    } while (localObject == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((stSimpleMetaPerson)localObject).nick);
    tlv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, ((stSimpleMetaPerson)localObject).avatar);
    a((stSimpleMetaPerson)localObject);
  }
  
  protected void c() {}
  
  protected void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = tlu.b();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = tlu.b((Activity)this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams.leftMargin = tlu.a();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131379499));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379501));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b = ((TextView)a(2131379500));
    this.b.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = ((stSimpleMetaFeed)((tmv)a()).a()).poster;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131379499: 
    case 2131379501: 
      b(localstSimpleMetaPerson);
      return;
    }
    f();
    tnt.d(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tna
 * JD-Core Version:    0.7.0.1
 */