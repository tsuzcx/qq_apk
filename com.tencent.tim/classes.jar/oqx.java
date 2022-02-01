import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class oqx
  extends ogm<oqr>
  implements View.OnClickListener
{
  public static GdtAppReceiver mGdtAppReceiver;
  private stNewIconStyle a;
  private WSVerticalPageFragment c;
  private stSimpleMetaFeed h;
  private TextView mText;
  private View nB;
  
  public oqx(Context paramContext, osf paramosf)
  {
    super(paramContext);
    if (paramosf != null) {
      this.c = paramosf.c;
    }
  }
  
  private void qX(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a != null) && (!TextUtils.isEmpty(this.a.title)))
    {
      this.mText.setVisibility(0);
      this.nB.setVisibility(0);
      this.mText.setText(this.a.title);
      return;
    }
    this.mText.setVisibility(8);
    this.nB.setVisibility(8);
  }
  
  protected void Hp()
  {
    oqr localoqr = (oqr)getData();
    if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed)))
    {
      this.h = ((stSimpleMetaFeed)localoqr.B());
      this.a = this.h.new_icon;
    }
  }
  
  protected int gn()
  {
    return 2131559387;
  }
  
  protected void initView()
  {
    this.nB = findViewById(2131367893);
    this.nB.setOnClickListener(this);
    this.mText = ((TextView)findViewById(2131367894));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131367893) && (this.h != null))
    {
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
  
  protected void onUpdateUI()
  {
    if ((this.a != null) && (this.a.tag_type == 0))
    {
      qX(true);
      return;
    }
    qX(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqx
 * JD-Core Version:    0.7.0.1
 */