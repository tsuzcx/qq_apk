import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Iterator;

public class vpl
  extends vrn
{
  public AdExposureChecker.ExposureCallback a;
  public ArrayList<AdExposureChecker> a;
  
  public vpl(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, 2131560067, paramInt, paramWSVerticalPageFragment);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return -1;
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_Uyx instanceof vpv))
    {
      vqe localvqe = (vqe)this.jdField_a_of_type_Uyx;
      if ((localvqe.a() instanceof vrd)) {
        return ((vrd)localvqe.a()).a();
      }
    }
    return null;
  }
  
  public uyx<vpj> a(int paramInt)
  {
    return new vpv(a(), this);
  }
  
  public void a()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AdExposureChecker)((Iterator)localObject).next()).onActivityResume();
      }
    }
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      localObject = (stSimpleMetaFeed)((vpj)this.jdField_a_of_type_JavaLangObject).a();
      if ((localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null))
      {
        vpk.a(BaseApplicationImpl.getContext(), (stSimpleMetaFeed)((vpj)this.jdField_a_of_type_JavaLangObject).a());
        ((vpj)this.jdField_a_of_type_JavaLangObject).a().isGdtAdVidoReport = false;
        this.jdField_a_of_type_Uyx.a(this.jdField_a_of_type_JavaLangObject);
      }
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void b()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AdExposureChecker)((Iterator)localObject).next()).onActivityPause();
      }
    }
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      localObject = (stSimpleMetaFeed)((vpj)this.jdField_a_of_type_JavaLangObject).a();
      if ((((vpj)this.jdField_a_of_type_JavaLangObject).a() != null) && (localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null) && (this.jdField_a_of_type_Vgb != null) && (this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh != null))
      {
        if (!((vpj)this.jdField_a_of_type_JavaLangObject).a().isGdtAdclicked) {
          break label186;
        }
        vsh.a((vpj)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Vgb, 2);
        ((vpj)this.jdField_a_of_type_JavaLangObject).a().isGdtAdclicked = false;
      }
    }
    for (;;)
    {
      ((vpj)this.jdField_a_of_type_JavaLangObject).a().isGdtAdVidoReport = true;
      this.jdField_a_of_type_Vgb.jdField_a_of_type_Long = this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh.a();
      return;
      label186:
      vsh.a((vpj)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Vgb, 3);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        AdExposureChecker localAdExposureChecker = (AdExposureChecker)localIterator.next();
        localAdExposureChecker.onActivityDestroy();
        localAdExposureChecker.setCallback(null);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpl
 * JD-Core Version:    0.7.0.1
 */