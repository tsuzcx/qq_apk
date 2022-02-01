import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBigImageVideo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcVideo;
import com.tencent.widget.AbsListView.LayoutParams;

public class map
  extends mak
{
  public map(Context paramContext, aqdf paramaqdf, ndi paramndi)
  {
    super(paramContext, paramaqdf, paramndi);
  }
  
  public lwm a()
  {
    this.alM = true;
    return a(this.d, this.c).r().l().g().n().q().j();
  }
  
  public lwm d()
    throws Exception
  {
    LinearLayout localLinearLayout1 = new LinearLayout(this.context);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial);
    }
    LinearLayout localLinearLayout2 = new LinearLayout(this.context);
    localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout2.setOrientation(1);
    localLinearLayout2.setPadding(0, 0, 0, wja.dp2px(1.0F, this.context.getResources()));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader);
    }
    if (this.jdField_a_of_type_Lwl != null)
    {
      LinearLayout localLinearLayout3 = new LinearLayout(this.context);
      localLinearLayout3.setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(wja.dp2px(12.0F, this.context.getResources()), wja.dp2px(11.0F, this.context.getResources()), wja.dp2px(12.0F, this.context.getResources()), wja.dp2px(12.0F, this.context.getResources()));
      localLinearLayout3.setLayoutParams(localLayoutParams);
      localLinearLayout3.addView((View)this.jdField_a_of_type_Lwl);
      if ((this.jdField_a_of_type_Lwl instanceof ComponentContentBigImageVideo))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
          localLinearLayout3.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
        }
        localLinearLayout3.setOnClickListener(new maq(this));
      }
      localLinearLayout2.addView(localLinearLayout3);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource);
    }
    kvl.setBackground(localLinearLayout2, this.context.getResources().getDrawable(2130843865));
    localLinearLayout1.addView(localLinearLayout2);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    localLinearLayout2.setOnClickListener(new mar(this));
    a(localLinearLayout1);
    return this;
  }
  
  public lwm g()
  {
    this.jdField_a_of_type_Lwl = new ComponentContentUgcVideo(this.context);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     map
 * JD-Core Version:    0.7.0.1
 */