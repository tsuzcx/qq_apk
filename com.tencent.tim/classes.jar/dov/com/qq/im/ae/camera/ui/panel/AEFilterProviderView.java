package dov.com.qq.im.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import awte;
import awwf;
import awwg;
import awzh;
import awzh.a;
import axip;
import axis;
import axov;
import axpr;
import axpr.a;
import axpr.b;
import axqc;
import axqf;
import axqm;
import axro;
import axtq;
import ayva;
import ayva.a;
import ayva.b;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEFilterProviderView
  extends ProviderView
  implements awzh.a, axpr.a
{
  public ArrayList<FilterCategory> FB;
  private RecyclerView J;
  public ayva.b a;
  private awzh jdField_b_of_type_Awzh;
  private axpr jdField_b_of_type_Axpr;
  private AEProviderContainerView d;
  public int dzN;
  
  public AEFilterProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static void ack(String paramString)
  {
    axis.a().ai("ae_filter_id", paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "saveFilterPref(ae_filter_id, " + paramString + ")");
    }
  }
  
  public static String getFilterId()
  {
    String str = axis.a().t("ae_filter_id", "", 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "getFilterId(ae_filter_id, " + str + ")");
    }
    return str;
  }
  
  private void initData(Bundle paramBundle)
  {
    Bundle localBundle = null;
    if (paramBundle != null) {
      localBundle = paramBundle.getBundle(AEFilterProviderView.class.getSimpleName());
    }
    if (localBundle != null)
    {
      if (ayva.a().a[this.eCJ] != null) {
        ayva.a().a[this.eCJ].eGG = 1;
      }
      paramBundle = (QIMFilterCategoryItem)localBundle.getParcelable("selected_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AEFilterProviderView", 2, "restore " + paramBundle.id);
        }
        paramBundle.eGG = 1;
      }
    }
  }
  
  public Bundle D()
  {
    Bundle localBundle = new Bundle();
    QIMFilterCategoryItem localQIMFilterCategoryItem1 = ayva.a().c(this.eCJ);
    if (localQIMFilterCategoryItem1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterProviderView", 2, "save " + localQIMFilterCategoryItem1.id);
      }
      localBundle.putParcelable("selected_filter_item", localQIMFilterCategoryItem1);
      if ((this.FB != null) && (!this.FB.isEmpty()))
      {
        FilterCategory localFilterCategory = (FilterCategory)this.FB.get(this.dzN);
        if (localFilterCategory != null)
        {
          Object localObject = localFilterCategory.Fv;
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              QIMFilterCategoryItem localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)((Iterator)localObject).next();
              if ((localQIMFilterCategoryItem1.getFilterId() == localQIMFilterCategoryItem2.getFilterId()) && (localQIMFilterCategoryItem1.name != null) && (localQIMFilterCategoryItem1.name.equals(localQIMFilterCategoryItem2.name))) {
                localBundle.putParcelable("ProviderView.select_item_category", localFilterCategory);
              }
            }
          }
        }
      }
    }
    return localBundle;
  }
  
  public int QW()
  {
    return 2131561124;
  }
  
  public void a(axqc paramaxqc) {}
  
  public void a(axqc paramaxqc, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "fp onComboApply combo " + paramaxqc.target + " filter ");
    }
    this.jdField_b_of_type_Awzh.notifyDataSetChanged();
  }
  
  public void a(axqf paramaxqf, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    this.jdField_b_of_type_Awzh.notifyDataSetChanged();
    if (paramBoolean)
    {
      paramaxqf = (axro)axov.a().c(8);
      if (this.eCJ != 0) {
        break label44;
      }
    }
    label44:
    for (paramInt = awte.eCR;; paramInt = awte.eCS)
    {
      paramaxqf.aeJ(paramInt);
      paramaxqf.eOr();
      return;
    }
  }
  
  public void a(axqm paramaxqm, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(ayva.a parama)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onComboFilterDataUpdated data:");
      if (parama != null) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AEFilterProviderView", 2, bool);
      if (parama != null) {
        a(parama.a(this.eCJ));
      }
      return;
    }
  }
  
  public void a(ayva.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "filters setup()");
    }
    this.a = paramb;
    this.FB = paramb.GF;
    if ((this.FB != null) && (this.FB.size() > this.dzN)) {
      this.jdField_b_of_type_Awzh.setData(((FilterCategory)this.FB.get(this.dzN)).Fv);
    }
    this.jdField_b_of_type_Awzh.notifyDataSetChanged();
  }
  
  public void apk()
  {
    super.apk();
    Object localObject;
    if ((this.a == null) && (this.jdField_b_of_type_Axpr != null))
    {
      localObject = this.jdField_b_of_type_Axpr.jdField_a_of_type_Ayva$a;
      if (localObject != null) {
        this.a = ((ayva.a)localObject).a(this.eCJ);
      }
    }
    if ((this.a != null) && (this.a.h != null))
    {
      localObject = (Activity)getContext();
      this.jdField_b_of_type_Axpr.a(this.a.h).b((Activity)localObject, this.eCJ);
      ayva.a().b(this.a.h, (Activity)getContext(), this.eCJ);
      ayva.a().a(this.a.h, this.eCJ);
      this.jdField_b_of_type_Awzh.notifyDataSetChanged();
      onItemClick(null, 0);
    }
  }
  
  public void aq(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    FilterCategory localFilterCategory = (FilterCategory)this.FB.get(this.dzN);
    paramInt = 0;
    if (paramInt < localFilterCategory.Fv.size())
    {
      paramString1 = (QIMFilterCategoryItem)localFilterCategory.Fv.get(paramInt);
      if (!paramString1.id.equals(paramString2)) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterProviderView", 2, "itemInfo= " + paramString1 + ",index=" + this.dzN + ",pos=" + paramInt);
      }
      if (paramString1 != null)
      {
        postDelayed(new AEFilterProviderView.1(this, paramInt), 200L);
        if (this.jdField_b_of_type_Axpr != null)
        {
          paramString2 = new Bundle();
          paramString2.putInt("apply_source", 1);
          paramString2.putInt("capture_scene", this.eCJ);
          this.jdField_b_of_type_Axpr.a(paramString1, (Activity)getContext(), paramString2);
        }
        if (!this.d.aOn()) {
          ack(paramString1.id);
        }
        this.jdField_b_of_type_Awzh.notifyDataSetChanged();
      }
      return;
      paramInt += 1;
      break;
      paramInt = 0;
      paramString1 = null;
    }
  }
  
  public void dKI()
  {
    super.dKI();
    if (this.c != null) {
      this.c.eNs();
    }
    this.jdField_b_of_type_Awzh.notifyDataSetChanged();
  }
  
  public void dLs()
  {
    super.dLs();
    if (this.c != null) {
      this.c.YI(false);
    }
  }
  
  public void ex(Bundle paramBundle)
  {
    super.ex(paramBundle);
    initData(paramBundle);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = ((AEProviderContainerView)((Activity)getContext()).findViewById(2131363367));
    if (this.mContentView == null) {
      this.mContentView = LayoutInflater.from(getContext()).inflate(2131558554, this, true);
    }
    this.J = ((RecyclerView)this.mContentView.findViewById(2131367088));
    paramBundle = new LinearLayoutManager(this.mContext, 0, false);
    this.J.setLayoutManager(paramBundle);
    this.jdField_b_of_type_Awzh = new awzh(this.mContext, this.eCJ);
    this.J.setAdapter(this.jdField_b_of_type_Awzh);
    this.jdField_b_of_type_Awzh.a(this);
    if (axov.a().oq(5))
    {
      this.jdField_b_of_type_Axpr = ((axpr)axov.a(5));
      if (this.jdField_b_of_type_Axpr != null) {
        this.jdField_b_of_type_Axpr.a(this);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "FilterProviderView onCreate");
    }
    paramBundle = this.jdField_b_of_type_Axpr.jdField_a_of_type_Ayva$a;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterProviderView", 2, "filterProviderView get data is null");
      }
      return;
    }
    a(paramBundle.a(this.eCJ));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_b_of_type_Axpr != null)
    {
      this.jdField_b_of_type_Axpr.jdField_a_of_type_ArrayOfAxpr$b[this.eCJ].eNN();
      this.jdField_b_of_type_Axpr.b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "onDestroy");
    }
  }
  
  public void onItemClick(View paramView, int paramInt)
  {
    StringBuilder localStringBuilder = null;
    if (paramView != null) {}
    for (Object localObject = paramView.getTag();; localObject = null)
    {
      paramView = localStringBuilder;
      if (localObject != null) {
        paramView = (QIMFilterCategoryItem)localObject;
      }
      if (paramView == null) {
        return;
      }
      if (paramView != null)
      {
        if (paramInt != 0) {
          break label255;
        }
        axip.a().acW("none");
        label46:
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("report filter click(").append(paramInt).append(", ");
          if (paramInt != 0) {
            break label268;
          }
        }
      }
      label268:
      for (localObject = "none";; localObject = "" + paramView.id)
      {
        QLog.d("AEFilterProviderView", 2, (String)localObject + ")");
        if (this.c != null) {
          this.c.b(-1, paramView);
        }
        if (this.jdField_b_of_type_Axpr != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("apply_source", 1);
          ((Bundle)localObject).putInt("capture_scene", this.eCJ);
          if ((awwf.a() != null) && (!awwf.a().dtj)) {
            ((Bundle)localObject).putBoolean("capture_force_enable", true);
          }
          this.jdField_b_of_type_Axpr.a(paramView, (Activity)getContext(), (Bundle)localObject);
        }
        if (!this.d.aOn()) {
          ack(paramView.id);
        }
        ((axtq)axov.a(14)).hk(paramView.name, 1);
        if (this.jdField_b_of_type_Axpr == null) {
          break;
        }
        this.jdField_b_of_type_Axpr.a(this.eCJ, (Activity)this.mContext);
        return;
        label255:
        axip.a().acW(paramView.id);
        break label46;
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_b_of_type_Axpr != null) {
      this.jdField_b_of_type_Axpr.a(this);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_b_of_type_Axpr != null) {
      this.jdField_b_of_type_Axpr.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView
 * JD-Core Version:    0.7.0.1
 */