import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class lyt
  extends lwm
{
  private static final String TAG = lyt.class.getSimpleName();
  
  public lyt(Context paramContext, aqdf paramaqdf, ndi paramndi)
  {
    super(paramContext, paramaqdf, paramndi);
  }
  
  private void a(LinearLayout paramLinearLayout, lie paramlie)
  {
    if (paramlie.nh() == 56)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setDividerWidth(wja.dp2px(3.0F, this.context.getResources()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setPadding(aqcx.dip2px(this.context, 6.0F), 0, aqcx.dip2px(this.context, 6.0F), aqcx.dip2px(this.context, 15.0F));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setClipChildren(false);
      paramLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setDividerWidth(wja.dp2px(1.5F, this.context.getResources()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setPadding(aqcx.dip2px(this.context, 6.0F), aqcx.dip2px(this.context, 8.0F), aqcx.dip2px(this.context, 12.0F), aqcx.dip2px(this.context, 8.0F));
    }
  }
  
  private void cF(View paramView)
  {
    if ((this.context instanceof ReadInJoyNewFeedsActivity)) {}
    for (;;)
    {
      return;
      if (awit.aMG()) {
        try
        {
          ReadinjoyTabFrame localReadinjoyTabFrame = (ReadinjoyTabFrame)FrameHelperActivity.a((BaseActivity)this.context).a(ReadinjoyTabFrame.class);
          if (localReadinjoyTabFrame != null)
          {
            localReadinjoyTabFrame.db(paramView);
            return;
          }
        }
        catch (Exception paramView)
        {
          QLog.d(TAG, 2, "readinjoy tab add dispatch touch event view fail ! e : " + paramView);
          paramView.printStackTrace();
        }
      }
    }
  }
  
  public static boolean dN(int paramInt)
  {
    return (paramInt == 9) || (paramInt == 10) || (paramInt == 11);
  }
  
  public lwm a()
  {
    this.alM = true;
    if ((this.aN != null) && ((this.aN instanceof lie)) && (((lie)this.aN).nh() == 56))
    {
      if (((lie)this.aN).oE() == 53) {
        return b(this.d, this.c).u().n();
      }
      return b(this.d, this.c).u().n().l().m();
    }
    return b(this.d, this.c).u().n().l();
  }
  
  public lwm d()
    throws Exception
  {
    if (!this.alM) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.context);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric);
    }
    Object localObject;
    if ((this.aN != null) && ((this.aN instanceof lie)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView != null))
    {
      localObject = ((lie)this.aN).a();
      if ((((ArticleInfo)localObject).mPolymericInfo == null) || (!dN(((ArticleInfo)localObject).mPolymericInfo.aRX))) {
        break label193;
      }
      a(localLinearLayout, (lie)this.aN);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace);
      }
      a(localLinearLayout);
      cF(S());
      return this;
      label193:
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = aqcx.dip2px(this.context, 12.0F);
      ((LinearLayout.LayoutParams)localObject).bottomMargin = aqcx.dip2px(this.context, 20.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setDividerWidth(wja.dp2px(3.0F, this.context.getResources()));
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public lwm e()
    throws Exception
  {
    return this;
  }
  
  public lwm o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.P(this.aN);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.P(this.aN);
    }
    return this;
  }
  
  public lwm p()
  {
    super.p();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.a(this.jdField_a_of_type_Lwm$a);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lyt
 * JD-Core Version:    0.7.0.1
 */