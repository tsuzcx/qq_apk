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

public class uxx
  extends zwh
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private stPublisherRsp jdField_a_of_type_UserGrowthStPublisherRsp;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private uxu jdField_a_of_type_Uxu;
  private TextView b;
  
  public uxx(Context paramContext)
  {
    this(paramContext, -1, -1);
  }
  
  public uxx(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, 2131755945, paramInt1, paramInt2);
  }
  
  protected uxx(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
    paramContext = getWindow();
    if (paramContext == null)
    {
      vmp.b("WSPublisherDialog", 2, "ScrollMoreDialog() window == null.");
      return;
    }
    paramContext = paramContext.getAttributes();
    if (paramContext == null)
    {
      vmp.b("WSPublisherDialog", 2, "ScrollMoreDialog() params == null.");
      return;
    }
    paramContext.width = paramInt2;
    paramContext.height = paramInt3;
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (String str = "focus";; str = "feeds")
    {
      WSPublicAccReport.getInstance().reportPublisher(paramString1, str, paramString2, paramInt);
      return;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560066, null, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381579));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381580));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381552));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381553));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381555));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381563);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    localRelativeLayout.setOnClickListener(this);
    a("gzh_exposure", "publish_popup", 0);
  }
  
  private void c()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_UserGrowthStPublisherRsp == null) {
      return;
    }
    vnd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_UserGrowthStPublisherRsp.weishiSchema, this.jdField_a_of_type_UserGrowthStPublisherRsp.h5Url, this.jdField_a_of_type_UserGrowthStPublisherRsp.miniAppSchema, 0, new uxy(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(stPublisherRsp paramstPublisherRsp)
  {
    this.jdField_a_of_type_UserGrowthStPublisherRsp = paramstPublisherRsp;
    paramstPublisherRsp = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841740);
    if ((this.jdField_a_of_type_UserGrowthStPublisherRsp != null) && (this.jdField_a_of_type_UserGrowthStPublisherRsp.guide != null))
    {
      String str = this.jdField_a_of_type_UserGrowthStPublisherRsp.guide.imageUrl;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPublisherRsp.guide.desc);
      this.b.setText(this.jdField_a_of_type_UserGrowthStPublisherRsp.guide.btnText);
      this.jdField_a_of_type_Uxu = new uxu();
      this.jdField_a_of_type_Uxu.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramstPublisherRsp, str, true, false);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramstPublisherRsp);
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.jdField_a_of_type_Uxu != null)
    {
      this.jdField_a_of_type_Uxu.a();
      this.jdField_a_of_type_Uxu = null;
    }
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
      d();
      c();
      continue;
      a("gzh_click", "publish_popup", 1000001);
      c();
      continue;
      a("gzh_click", "publish_popup", 1000005);
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxx
 * JD-Core Version:    0.7.0.1
 */