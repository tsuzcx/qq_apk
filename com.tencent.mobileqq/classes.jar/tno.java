import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.widget.AbsListView;

public class tno
  extends tna
{
  public static long a;
  public static GdtHandler.Params a;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  private int jdField_a_of_type_Int;
  tnp jdField_a_of_type_Tnp = null;
  
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
    b = false;
    c = false;
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_a_of_type_Spi instanceof tnp)))
    {
      if (tnp.a((tnp)this.jdField_a_of_type_Spi) != null) {
        tnp.a((tnp)this.jdField_a_of_type_Spi).setVisibility(8);
      }
      if (tnp.a((tnp)this.jdField_a_of_type_Spi) != null) {
        tnp.a((tnp)this.jdField_a_of_type_Spi).setVisibility(8);
      }
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Int == 1) && ((this.jdField_a_of_type_Spi instanceof tnp)))
    {
      if (tnp.a((tnp)this.jdField_a_of_type_Spi) != null) {
        tnp.a((tnp)this.jdField_a_of_type_Spi).setVisibility(0);
      }
      if (tnp.a((tnp)this.jdField_a_of_type_Spi) != null) {
        tnp.a((tnp)this.jdField_a_of_type_Spi).setVisibility(0);
      }
    }
  }
  
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerVideoItemData)) {
      i = tpp.a((ProteusBannerVideoItemData)paramBaseData);
    }
    return i;
  }
  
  protected spi a(View paramView, BaseData paramBaseData)
  {
    this.jdField_a_of_type_Tnp = new tnp(this, paramView, paramBaseData, this.jdField_a_of_type_JavaLangRefWeakReference);
    return this.jdField_a_of_type_Tnp;
  }
  
  public void a()
  {
    a(true);
    if ((this.jdField_a_of_type_Tnp != null) && (tnp.a(this.jdField_a_of_type_Tnp) != null)) {
      tnp.a(this.jdField_a_of_type_Tnp).m();
    }
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
    ubd.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
    if ((this.jdField_a_of_type_Tnp != null) && (tnp.a(this.jdField_a_of_type_Tnp) != null)) {
      tnp.a(this.jdField_a_of_type_Tnp).p();
    }
    i();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Tnp != null) && (tnp.a(this.jdField_a_of_type_Tnp) != null)) {
      tnp.a(this.jdField_a_of_type_Tnp).q();
    }
  }
  
  public void d()
  {
    
    if ((this.jdField_a_of_type_Tnp != null) && (tnp.a(this.jdField_a_of_type_Tnp) != null))
    {
      tnp.a(this.jdField_a_of_type_Tnp).k();
      tnp.a(this.jdField_a_of_type_Tnp, null);
      this.jdField_a_of_type_Tnp = null;
    }
  }
  
  public void e()
  {
    
    if ((this.jdField_a_of_type_Tnp != null) && (tnp.a(this.jdField_a_of_type_Tnp) != null))
    {
      tnp.a(this.jdField_a_of_type_Tnp).k();
      tnp.a(this.jdField_a_of_type_Tnp, null);
      this.jdField_a_of_type_Tnp = null;
    }
  }
  
  public void g()
  {
    if (b)
    {
      c = true;
      if ((this.jdField_a_of_type_Tnp != null) && (tnp.a(this.jdField_a_of_type_Tnp) != null)) {
        tnp.a(this.jdField_a_of_type_Tnp).q();
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Tnp != null) && (tnp.a(this.jdField_a_of_type_Tnp) != null)) {
      tnp.a(this.jdField_a_of_type_Tnp).n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tno
 * JD-Core Version:    0.7.0.1
 */