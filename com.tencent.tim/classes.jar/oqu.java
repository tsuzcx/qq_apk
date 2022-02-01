import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class oqu
  extends ogm<oqr>
  implements View.OnClickListener
{
  public static GdtAppReceiver mGdtAppReceiver;
  private WSVerticalPageFragment c;
  private stSimpleMetaFeed h;
  private ImageView mAdIcon;
  private TextView vg;
  
  public oqu(Context paramContext, osf paramosf)
  {
    super(paramContext);
    if (paramosf != null) {
      this.c = paramosf.c;
    }
  }
  
  private void pR(String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramString + "ao");
    paramString = getResources().getDrawable(2130840572);
    paramString.setBounds(aqnm.dpToPx(4.0F), -15, 100, 25);
    paramString = new ImageSpan(paramString);
    localSpannableStringBuilder.setSpan(paramString, localSpannableStringBuilder.length() - 2, localSpannableStringBuilder.length(), 33);
    if ((TextUtils.isEmpty(localSpannableStringBuilder)) || (paramString == null))
    {
      this.vg.setVisibility(8);
      this.mAdIcon.setVisibility(8);
      return;
    }
    this.vg.setVisibility(0);
    this.mAdIcon.setVisibility(0);
    this.vg.setText(localSpannableStringBuilder);
  }
  
  protected void Hp()
  {
    oqr localoqr = (oqr)getData();
    if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed))) {
      this.h = ((stSimpleMetaFeed)localoqr.B());
    }
  }
  
  protected int gn()
  {
    return 2131559385;
  }
  
  protected void initView()
  {
    this.vg = ((TextView)findViewById(2131367900));
    this.mAdIcon = ((ImageView)findViewById(2131367890));
    this.vg.setOnClickListener(this);
    this.mAdIcon.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.h != null) && (getContext() != null))
    {
      ooz.d("GdtWSVerticalItemBottomController", "跳转到广告落地页");
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
    oqr localoqr = (oqr)getData();
    if (localoqr == null) {}
    while (!(localoqr.B() instanceof stSimpleMetaFeed)) {
      return;
    }
    pR(((stSimpleMetaFeed)localoqr.B()).feed_desc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqu
 * JD-Core Version:    0.7.0.1
 */