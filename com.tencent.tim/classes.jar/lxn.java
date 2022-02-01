import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.widget.AbsListView.LayoutParams;

public class lxn
  extends lwm
{
  public lxn(Context paramContext, aqdf paramaqdf, ndi paramndi)
  {
    super(paramContext, paramaqdf, paramndi);
  }
  
  public lwm a()
  {
    this.alM = true;
    return a(this.d, this.c).h().f().g().q().l().n().j();
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
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
    localLinearLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary);
    }
    if ((this.jdField_a_of_type_Lwl != null) && ((this.jdField_a_of_type_Lwl instanceof ComponentContentGalleryBiu)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null))
    {
      localObject = new LinearLayout(this.context);
      ((LinearLayout)localObject).setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = wja.dp2px(12.0F, this.context.getResources());
      localLayoutParams.rightMargin = wja.dp2px(12.0F, this.context.getResources());
      localLayoutParams.bottomMargin = wja.dp2px(13.0F, this.context.getResources());
      localLayoutParams.gravity = 1;
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_Lwl).setId(1);
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_Lwl).setLayoutParams(localLayoutParams);
      ((LinearLayout)localObject).addView((ComponentContentGalleryBiu)this.jdField_a_of_type_Lwl);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setId(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setLayoutParams(localLayoutParams);
      ((LinearLayout)localObject).addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setOnClickListener(new lxo(this));
      ((LinearLayout)localObject).setOnClickListener(new lxp(this));
      ((LinearLayout)localObject).setDuplicateParentStateEnabled(true);
      ((LinearLayout)localObject).setOnTouchListener(new lxq(this, (LinearLayout)localObject));
      localLinearLayout2.setOnTouchListener(new lxr(this, (LinearLayout)localObject));
      kvl.setBackground((View)localObject, this.context.getResources().getDrawable(2130843709));
      localLinearLayout2.addView((View)localObject);
      localLinearLayout2.setDuplicateParentStateEnabled(true);
      localLinearLayout2.setOnTouchListener(new lxs(this, localLinearLayout2));
      localLinearLayout1.setOnTouchListener(new lxt(this, localLinearLayout2, (LinearLayout)localObject));
    }
    localLinearLayout2.setOnClickListener(new lxu(this));
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
    return null;
  }
  
  public lwm f()
  {
    super.f();
    return this;
  }
  
  public lwm g()
  {
    this.jdField_a_of_type_Lwl = new ComponentContentGalleryBiu(this.context);
    return this;
  }
  
  public lwm o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.P(this.aN);
      if ((this.aN instanceof lie))
      {
        lie locallie = (lie)this.aN;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setReadedStatus(this.d.m(locallie.nh(), locallie.a().mArticleID));
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.P(this.aN);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.P(this.aN);
    }
    if ((this.jdField_a_of_type_Lwl != null) && ((this.jdField_a_of_type_Lwl instanceof ComponentContentGalleryBiu)))
    {
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_Lwl).setAdapter(this.d);
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_Lwl).setPosition(this.aQl);
    }
    return this;
  }
  
  public lwm p()
  {
    super.p();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a(this.jdField_a_of_type_Lwm$a);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.a(this.jdField_a_of_type_Lwm$a);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lxn
 * JD-Core Version:    0.7.0.1
 */