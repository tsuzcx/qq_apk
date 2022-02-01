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

public class urw
  extends utw
{
  public AdExposureChecker.ExposureCallback a;
  public ArrayList<AdExposureChecker> a;
  
  public urw(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, 2131560009, paramInt, paramWSVerticalPageFragment);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_Uei instanceof usg))
    {
      usp localusp = (usp)this.jdField_a_of_type_Uei;
      if ((localusp.a() instanceof utm)) {
        return ((utm)localusp.a()).a();
      }
    }
    return null;
  }
  
  public uei<uru> a(int paramInt)
  {
    return new usg(a(), this);
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
      localObject = (stSimpleMetaFeed)((uru)this.jdField_a_of_type_JavaLangObject).a();
      if ((localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null))
      {
        urv.a(BaseApplicationImpl.getContext(), (stSimpleMetaFeed)((uru)this.jdField_a_of_type_JavaLangObject).a());
        ((uru)this.jdField_a_of_type_JavaLangObject).a().isGdtAdVidoReport = false;
        this.jdField_a_of_type_Uei.a(this.jdField_a_of_type_JavaLangObject);
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
      localObject = (stSimpleMetaFeed)((uru)this.jdField_a_of_type_JavaLangObject).a();
      stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = ((uru)this.jdField_a_of_type_JavaLangObject).a();
      if ((localstSimpleMetaGdtAdInfo != null) && (localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null) && (this.jdField_a_of_type_Ukb != null) && (this.jdField_a_of_type_Ukb.jdField_a_of_type_Uke != null))
      {
        uur.a((stSimpleMetaFeed)localObject, this.jdField_a_of_type_Ukb);
        localstSimpleMetaGdtAdInfo.isGdtAdVidoReport = true;
        this.jdField_a_of_type_Ukb.jdField_a_of_type_Long = this.jdField_a_of_type_Ukb.jdField_a_of_type_Uke.a();
      }
    }
  }
  
  public void d()
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
 * Qualified Name:     urw
 * JD-Core Version:    0.7.0.1
 */