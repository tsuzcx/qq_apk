import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.widget.AbsListView;

public class uhs
  extends uhi
{
  public static long a;
  public static GdtHandler.Params a;
  public static boolean a;
  private int jdField_a_of_type_Int;
  uht jdField_a_of_type_Uht = null;
  
  static
  {
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void f()
  {
    a(false);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_a_of_type_Tgr instanceof uht)))
    {
      if (uht.a((uht)this.jdField_a_of_type_Tgr) != null) {
        uht.a((uht)this.jdField_a_of_type_Tgr).setVisibility(8);
      }
      if (uht.a((uht)this.jdField_a_of_type_Tgr) != null) {
        uht.a((uht)this.jdField_a_of_type_Tgr).setVisibility(8);
      }
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_a_of_type_Tgr instanceof uht)))
    {
      if (uht.a((uht)this.jdField_a_of_type_Tgr) != null) {
        uht.a((uht)this.jdField_a_of_type_Tgr).setVisibility(0);
      }
      if (uht.a((uht)this.jdField_a_of_type_Tgr) != null) {
        uht.a((uht)this.jdField_a_of_type_Tgr).setVisibility(0);
      }
    }
  }
  
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerVideoItemData)) {
      i = uki.a((ProteusBannerVideoItemData)paramBaseData);
    }
    return i;
  }
  
  protected tgr a(View paramView, BaseData paramBaseData)
  {
    if (this.jdField_a_of_type_Uht == null) {
      this.jdField_a_of_type_Uht = new uht(this, paramView, paramBaseData, this.jdField_a_of_type_JavaLangRefWeakReference);
    }
    return this.jdField_a_of_type_Uht;
  }
  
  public void a()
  {
    a(true);
    this.jdField_a_of_type_Int = Aladdin.getConfig(341).getIntegerFromString("bottom_ad_style", 0);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.s;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramInt = paramAbsListView.getFirstVisiblePosition();
    int j = paramAbsListView.getLastVisiblePosition();
    if ((i >= paramInt) && (i <= j))
    {
      h();
      i();
      return;
    }
    g();
    j();
  }
  
  public boolean a(BaseData paramBaseData)
  {
    if ((paramBaseData != null) && (paramBaseData.r == 17)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData;
      }
      return bool;
    }
  }
  
  public void b()
  {
    super.b();
    uvp.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
    ulm.a.b();
    i();
  }
  
  public void c()
  {
    super.c();
    ulm.a.c();
  }
  
  public void d()
  {
    
    if ((this.jdField_a_of_type_Uht != null) && (uht.a(this.jdField_a_of_type_Uht) != null))
    {
      ulm.a.d();
      uht.a(this.jdField_a_of_type_Uht).a();
      uht.a(this.jdField_a_of_type_Uht, null);
      ukq.a("VideoPlayerWrapper_AD", "bottomView create - item:  onDestroy");
      this.jdField_a_of_type_Uht = null;
    }
  }
  
  public void e()
  {
    
    if ((this.jdField_a_of_type_Uht != null) && (uht.a(this.jdField_a_of_type_Uht) != null))
    {
      ulm.a.d();
      uht.a(this.jdField_a_of_type_Uht).a();
      uht.a(this.jdField_a_of_type_Uht, null);
      ukq.a("VideoPlayerWrapper_AD", "bottomView create - item:  onFinishPage");
      this.jdField_a_of_type_Uht = null;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Uht != null) && (uht.a(this.jdField_a_of_type_Uht) != null)) {
      uht.a(this.jdField_a_of_type_Uht).a(false);
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Uht != null) && (uht.a(this.jdField_a_of_type_Uht) != null)) {
      uht.a(this.jdField_a_of_type_Uht).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhs
 * JD-Core Version:    0.7.0.1
 */