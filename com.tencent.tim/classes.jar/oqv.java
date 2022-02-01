import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class oqv
  extends ogm<oqr>
  implements View.OnClickListener
{
  public static GdtAppReceiver mGdtAppReceiver;
  private WSVerticalPageFragment c;
  private RoundImageView g;
  private stSimpleMetaFeed h;
  private View rootView;
  private TextView vj;
  
  public oqv(Context paramContext)
  {
    super(paramContext);
  }
  
  public oqv(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this(paramContext);
    this.c = paramWSVerticalPageFragment;
  }
  
  protected void Hp()
  {
    oqr localoqr = (oqr)getData();
    if (localoqr == null) {}
    while (!(localoqr.B() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.h = ((stSimpleMetaFeed)localoqr.B());
  }
  
  protected int gn()
  {
    return 2131559386;
  }
  
  protected void initView()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mParentView.getLayoutParams();
    localLayoutParams.height = opm.rJ();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = opm.p((Activity)this.mContext);
    localLayoutParams.leftMargin = opm.rI();
    this.mParentView.setLayoutParams(localLayoutParams);
    this.rootView = findViewById(2131377566);
    this.g = ((RoundImageView)findViewById(2131367896));
    this.vj = ((TextView)findViewById(2131367898));
    this.g.setOnClickListener(this);
    this.vj.setOnClickListener(this);
    this.rootView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.h != null) && (getContext() != null))
    {
      ooz.d("GdtAdWSVerticalItemTopController", "跳转到广告落地页");
      if (mGdtAppReceiver == null)
      {
        mGdtAppReceiver = new GdtAppReceiver();
        mGdtAppReceiver.register(BaseApplicationImpl.getContext());
      }
      oqs.a(getContext(), this.h, mGdtAppReceiver);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onRecycle() {}
  
  @UiThread
  protected void onUpdateUI()
  {
    ooz.i("GdtAdWSVerticalItemTopController", "onUpdateUI hashcode******************************" + hashCode() + ",position:" + getPosition());
    oqr localoqr = (oqr)getData();
    if (localoqr == null) {}
    while (!(localoqr.B() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.vj.setText(this.h.poster.nick);
    opn.a(this.mContext, this.g, this.h.poster.avatar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqv
 * JD-Core Version:    0.7.0.1
 */