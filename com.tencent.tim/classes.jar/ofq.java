import UserGrowth.stPublisherGuide;
import UserGrowth.stPublisherRsp;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ofq
  extends sdz
  implements View.OnClickListener
{
  private URLImageView M;
  private final String TAG = "WSPublisherDialog";
  private ofe a;
  private stPublisherRsp b;
  private int beI;
  private LinearLayout ev;
  private ImageView ij;
  private Context mContext;
  private View mRootView;
  private TextView tf;
  private TextView ui;
  
  public ofq(Context paramContext)
  {
    this(paramContext, -1, -1);
  }
  
  public ofq(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, 2131756599, paramInt1, paramInt2);
  }
  
  protected ofq(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    this.mContext = paramContext;
    initView();
    paramContext = getWindow();
    if (paramContext == null)
    {
      ooz.d("WSPublisherDialog", 2, "ScrollMoreDialog() window == null.");
      return;
    }
    paramContext = paramContext.getAttributes();
    if (paramContext == null)
    {
      ooz.d("WSPublisherDialog", 2, "ScrollMoreDialog() params == null.");
      return;
    }
    paramContext.width = paramInt2;
    paramContext.height = paramInt3;
  }
  
  private void bel()
  {
    if (this.b == null) {
      return;
    }
    opn.a(this.mContext, this.b.weishiSchema, this.b.h5Url, this.b.miniAppSchema, 0, new ofr(this));
  }
  
  private void gV()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  private void initView()
  {
    this.mRootView = LayoutInflater.from(getContext()).inflate(2131560210, null, false);
    setContentView(this.mRootView);
    this.tf = ((TextView)this.mRootView.findViewById(2131382351));
    this.ui = ((TextView)this.mRootView.findViewById(2131382352));
    this.M = ((URLImageView)this.mRootView.findViewById(2131382333));
    this.ij = ((ImageView)this.mRootView.findViewById(2131382334));
    this.ev = ((LinearLayout)this.mRootView.findViewById(2131382336));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.mRootView.findViewById(2131382342);
    this.ij.setOnClickListener(this);
    this.ev.setOnClickListener(this);
    localRelativeLayout.setOnClickListener(this);
    o("gzh_exposure", "publish_popup", 0);
  }
  
  private void o(String paramString1, String paramString2, int paramInt)
  {
    if (this.beI == 0) {}
    for (String str = "focus";; str = "feeds")
    {
      WSPublicAccReport.getInstance().reportPublisher(paramString1, str, paramString2, paramInt);
      return;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
  }
  
  public void e(stPublisherRsp paramstPublisherRsp)
  {
    this.b = paramstPublisherRsp;
    paramstPublisherRsp = this.mContext.getResources().getDrawable(2130842541);
    if ((this.b != null) && (this.b.guide != null))
    {
      String str = this.b.guide.imageUrl;
      this.tf.setText(this.b.guide.desc);
      this.ui.setText(this.b.guide.btnText);
      this.a = new ofe();
      this.a.a(this.M, paramstPublisherRsp, str);
      return;
    }
    this.M.setImageDrawable(paramstPublisherRsp);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bel();
      gV();
      continue;
      o("gzh_click", "publish_popup", 1000001);
      gV();
      continue;
      o("gzh_click", "publish_popup", 1000005);
      gV();
    }
  }
  
  public void uD(int paramInt)
  {
    this.beI = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofq
 * JD-Core Version:    0.7.0.1
 */