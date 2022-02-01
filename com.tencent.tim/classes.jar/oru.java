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

public class oru
  extends ogm<oqr>
  implements View.OnClickListener
{
  private oig b;
  private WSVerticalPageFragment c;
  private stSimpleMetaFeed jdField_h_of_type_UserGrowthStSimpleMetaFeed;
  private RoundImageView jdField_h_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private TextView vm;
  private TextView vr;
  
  public oru(Context paramContext)
  {
    super(paramContext);
  }
  
  public oru(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this(paramContext);
    this.c = paramWSVerticalPageFragment;
  }
  
  private void bff()
  {
    if (!jqi.isNetworkAvailable(getContext())) {
      arxa.a().showToast(2131721932);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (this.b == null) {
            this.b = oig.a();
          }
          localObject = (oqr)getData();
        } while (localObject == null);
        ooz.d("WSVerticalItemTopController", "Follow user.");
      } while (!(((oqr)localObject).B() instanceof stSimpleMetaFeed));
      localObject = ((stSimpleMetaFeed)((oqr)localObject).B()).poster;
    } while (localObject == null);
    if (oor.eu(((stSimpleMetaPerson)localObject).followStatus))
    {
      oor.a(getContext(), new orv(this, (stSimpleMetaPerson)localObject), null);
      return;
    }
    this.b.aY(((stSimpleMetaPerson)localObject).id, 1);
    ((stSimpleMetaPerson)localObject).followStatus = 1;
    if ((ojk.e != null) && (ojk.e.poster != null)) {
      ojk.e.poster.followStatus = 1;
    }
    this.vr.setText("已关注");
    ooz.i("WSVerticalItemTopController", "---> followStatus:" + ((stSimpleMetaPerson)localObject).followStatus + ",personInfo hashCode:" + localObject.hashCode());
    this.vr.setVisibility(8);
  }
  
  private void f(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (TextUtils.equals(opn.getPersonId(), paramstSimpleMetaPerson.id))
    {
      this.vr.setVisibility(8);
      return;
    }
    int i = paramstSimpleMetaPerson.followStatus;
    ooz.e("WSVerticalItemTopController", "followStatus:" + i + ",personInfo hashCode:" + paramstSimpleMetaPerson.hashCode());
    if (oor.eu(paramstSimpleMetaPerson.followStatus))
    {
      this.vr.setVisibility(8);
      return;
    }
    this.vr.setText("关注");
    this.vr.setVisibility(0);
  }
  
  private void g(stSimpleMetaPerson paramstSimpleMetaPerson)
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
      ooz.d("WSVerticalItemTopController", "Jump to personal page.");
      return;
      Object localObject = paramstSimpleMetaPerson.miniAppSchema;
      ooz.e("weishi", "miniShema is :" + (String)localObject);
      okj.a().aW(this.mContext, paramstSimpleMetaPerson.miniAppSchema);
      uV(1000001);
      continue;
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.schema;
      int i = ohy.a().rp();
      if (rpw.isWeishiInstalled(this.mContext))
      {
        opb.a(this.mContext, "biz_src_jc_gzh_weishi", paramstSimpleMetaPerson, 1, i, 1);
        uV(1000003);
      }
      for (;;)
      {
        ooz.e("weishi", "schema is :" + paramstSimpleMetaPerson);
        break;
        localObject = new WSDownloadParams();
        ((WSDownloadParams)localObject).mScene = 1;
        ((WSDownloadParams)localObject).mLinkStrategyType = i;
        ((WSDownloadParams)localObject).mEventId = 1;
        ((WSDownloadParams)localObject).mTestId = opn.getSceneTypeTestId(2);
        stReportItem localstReportItem = ond.getInitialReportItem();
        localstReportItem.pagetype = 2;
        localstReportItem.optype = 115;
        ((WSDownloadParams)localObject).mStReportItem = localstReportItem;
        ((WSDownloadParams)localObject).mScheme = paramstSimpleMetaPerson;
        oir.a(this.c.getActivity(), (WSDownloadParams)localObject, false);
        uV(1000002);
      }
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.H5Url;
      ogj.aM(this.mContext, paramstSimpleMetaPerson);
      ooz.e("weishi", "h5Url is :" + paramstSimpleMetaPerson);
      uV(1000004);
    }
  }
  
  private void uV(int paramInt)
  {
    osv.c(this.c.getFrom(), this.c.getPlayScene(), paramInt, this.jdField_h_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  protected void Hp()
  {
    oqr localoqr = (oqr)getData();
    if (localoqr == null) {}
    while (!(localoqr.B() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_h_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localoqr.B());
  }
  
  protected int gn()
  {
    return 2131560224;
  }
  
  protected void initView()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mParentView.getLayoutParams();
    localLayoutParams.height = opm.rJ();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = opm.p((Activity)this.mContext);
    localLayoutParams.leftMargin = opm.rI();
    this.mParentView.setLayoutParams(localLayoutParams);
    this.jdField_h_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)findViewById(2131381536));
    this.jdField_h_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.vm = ((TextView)findViewById(2131381540));
    this.vm.setOnClickListener(this);
    this.vr = ((TextView)findViewById(2131381539));
    this.vr.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = ((stSimpleMetaFeed)((oqr)getData()).B()).poster;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      g(localstSimpleMetaPerson);
      continue;
      bff();
      osv.e(this.c.getFrom(), this.c.getPlayScene(), this.jdField_h_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
  
  protected void onRecycle() {}
  
  @UiThread
  protected void onUpdateUI()
  {
    ooz.i("WSVerticalItemTopController", "onUpdateUI hashcode******************************" + hashCode() + ",position:" + getPosition());
    Object localObject = (oqr)getData();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!(((oqr)localObject).B() instanceof stSimpleMetaFeed));
      localObject = ((stSimpleMetaFeed)((oqr)localObject).B()).poster;
    } while (localObject == null);
    this.vm.setText(((stSimpleMetaPerson)localObject).nick);
    opn.a(this.mContext, this.jdField_h_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, ((stSimpleMetaPerson)localObject).avatar);
    f((stSimpleMetaPerson)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oru
 * JD-Core Version:    0.7.0.1
 */