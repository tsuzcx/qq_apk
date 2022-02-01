import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.b;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentDivider;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class lym
  extends lwm
{
  private ComponentContentGridImage.b a;
  
  public lym(Context paramContext, aqdf paramaqdf, ndi paramndi)
  {
    super(paramContext, paramaqdf, paramndi);
  }
  
  public lwm a()
  {
    this.alM = true;
    return a(this.d, this.c).f().g().q().l().n().j();
  }
  
  public lwm d()
    throws Exception
  {
    if (!this.alM) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout1 = new LinearLayout(this.context);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial);
    }
    LinearLayout localLinearLayout2 = new LinearLayout(this.context);
    localLinearLayout2.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
    localLinearLayout2.setLayoutParams(localLayoutParams);
    kvl.setBackground(localLinearLayout2, this.context.getResources().getDrawable(2130842545));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary);
    }
    if ((this.jdField_a_of_type_Lwl != null) && ((this.jdField_a_of_type_Lwl instanceof ComponentContentGridImage)))
    {
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(wja.dp2px(12.0F, this.context.getResources()), 0, wja.dp2px(12.0F, this.context.getResources()), wja.dp2px(12.0F, this.context.getResources()));
      ((ComponentContentGridImage)this.jdField_a_of_type_Lwl).setLayoutParams(localLayoutParams);
      ((ComponentContentGridImage)this.jdField_a_of_type_Lwl).setDuplicateParentStateEnabled(true);
      kvl.setBackground((ComponentContentGridImage)this.jdField_a_of_type_Lwl, this.context.getResources().getDrawable(2130842545));
      ((ComponentContentGridImage)this.jdField_a_of_type_Lwl).setOnNoItemClickListener(new lyn(this));
      localLinearLayout2.addView((ComponentContentGridImage)this.jdField_a_of_type_Lwl);
    }
    localLinearLayout2.setOnClickListener(new lyo(this));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource);
    }
    if (localLinearLayout2.getChildCount() > 0) {
      localLinearLayout1.addView(localLinearLayout2);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localLinearLayout1);
    return this;
  }
  
  public lwm e()
    throws Exception
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$b != null) && (this.jdField_a_of_type_Lwl != null) && ((this.jdField_a_of_type_Lwl instanceof ComponentContentGridImage)))
    {
      if (!(((ComponentContentGridImage)this.jdField_a_of_type_Lwl).getLayoutParams() instanceof LinearLayout.LayoutParams)) {
        break label122;
      }
      localLayoutParams = (LinearLayout.LayoutParams)((ComponentContentGridImage)this.jdField_a_of_type_Lwl).getLayoutParams();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$b.aT() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$b.aT().size() != 0)) {
        break label136;
      }
      localLayoutParams.setMargins(wja.dp2px(12.0F, this.context.getResources()), 0, wja.dp2px(12.0F, this.context.getResources()), 0);
    }
    for (;;)
    {
      ((ComponentContentGridImage)this.jdField_a_of_type_Lwl).setLayoutParams(localLayoutParams);
      return this;
      label122:
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      break;
      label136:
      localLayoutParams.setMargins(wja.dp2px(12.0F, this.context.getResources()), 0, wja.dp2px(12.0F, this.context.getResources()), wja.dp2px(12.0F, this.context.getResources()));
    }
  }
  
  public lwm f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.alO = true;
    return this;
  }
  
  public lwm g()
  {
    this.jdField_a_of_type_Lwl = new ComponentContentGridImage(this.context);
    return this;
  }
  
  public lwm o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.P(this.aN);
      if ((this.aN instanceof lie))
      {
        lie locallie = (lie)this.aN;
        if (locallie.a() != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setReadedStatus(this.d.m(locallie.nh(), locallie.a().mArticleID));
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.P(this.aN);
    }
    if (this.jdField_a_of_type_Lwl != null)
    {
      if ((this.jdField_a_of_type_Lwl instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.jdField_a_of_type_Lwl).setMIReadInJoyModel(this.aN);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$b = ComponentContentGridImage.a(this.aN, 0);
      this.jdField_a_of_type_Lwl.P(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$b);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.P(this.aN);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider.P(this.aN);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.P(this.aN);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.P(this.aN);
    }
    try
    {
      e();
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lym
 * JD-Core Version:    0.7.0.1
 */