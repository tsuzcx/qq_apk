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

public class vas
  extends vct
{
  public AdExposureChecker.ExposureCallback a;
  public ArrayList<AdExposureChecker> a;
  
  public vas(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, 2131560023, paramInt, paramWSVerticalPageFragment);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_Ula instanceof vbc))
    {
      vbl localvbl = (vbl)this.jdField_a_of_type_Ula;
      if ((localvbl.a() instanceof vcj)) {
        return ((vcj)localvbl.a()).a();
      }
    }
    return null;
  }
  
  public ula<vaq> a(int paramInt)
  {
    return new vbc(a(), this);
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
      localObject = (stSimpleMetaFeed)((vaq)this.jdField_a_of_type_JavaLangObject).a();
      if ((localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null))
      {
        var.a(BaseApplicationImpl.getContext(), (stSimpleMetaFeed)((vaq)this.jdField_a_of_type_JavaLangObject).a());
        ((vaq)this.jdField_a_of_type_JavaLangObject).a().isGdtAdVidoReport = false;
        this.jdField_a_of_type_Ula.a(this.jdField_a_of_type_JavaLangObject);
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
      localObject = (stSimpleMetaFeed)((vaq)this.jdField_a_of_type_JavaLangObject).a();
      if ((((vaq)this.jdField_a_of_type_JavaLangObject).a() != null) && (localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null) && (this.jdField_a_of_type_Urt != null) && (this.jdField_a_of_type_Urt.jdField_a_of_type_Urw != null))
      {
        if (!((vaq)this.jdField_a_of_type_JavaLangObject).a().isGdtAdclicked) {
          break label186;
        }
        vdo.a((vaq)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Urt, 2);
        ((vaq)this.jdField_a_of_type_JavaLangObject).a().isGdtAdclicked = false;
      }
    }
    for (;;)
    {
      ((vaq)this.jdField_a_of_type_JavaLangObject).a().isGdtAdVidoReport = true;
      this.jdField_a_of_type_Urt.jdField_a_of_type_Long = this.jdField_a_of_type_Urt.jdField_a_of_type_Urw.a();
      return;
      label186:
      vdo.a((vaq)this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Urt, 3);
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
 * Qualified Name:     vas
 * JD-Core Version:    0.7.0.1
 */