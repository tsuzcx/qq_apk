import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdDislikeInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class toa
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private blnb jdField_a_of_type_Blnb;
  private rzd jdField_a_of_type_Rzd;
  
  public toa(Activity paramActivity, rzd paramrzd)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rzd = paramrzd;
    this.jdField_a_of_type_Blnb = new blnb(paramActivity);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Blnb != null) && (this.jdField_a_of_type_Blnb.isShowing())) {
      this.jdField_a_of_type_Blnb.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    toc localtoc = new toc(this, paramInt, paramVideoInfo);
    if (!this.jdField_a_of_type_Blnb.a()) {
      this.jdField_a_of_type_Blnb.a();
    }
    this.jdField_a_of_type_Blnb.b = false;
    ArrayList localArrayList = new ArrayList();
    if ((paramVideoInfo.a != null) && (paramVideoInfo.a.e != null))
    {
      int i = 0;
      while (i < paramVideoInfo.a.e.size())
      {
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_Long = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_Long;
        localDislikeInfo.jdField_a_of_type_JavaLangString = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_JavaLangString;
        localArrayList.add(localDislikeInfo);
        i += 1;
      }
    }
    if (localArrayList.size() > 0)
    {
      nzq.a(paramVideoInfo.a);
      if (this.jdField_a_of_type_Blnb.a(paramInt, localArrayList)) {
        this.jdField_a_of_type_Blnb.a(paramView, localtoc);
      }
    }
  }
  
  public void a(View paramView, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramView == null) || (paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdDislikeInfos == null) || (paramAdvertisementInfo.mAdDislikeInfos.size() == 0)) {}
    tob localtob;
    ArrayList localArrayList;
    do
    {
      return;
      localtob = new tob(this, paramAdvertisementInfo);
      if (!this.jdField_a_of_type_Blnb.a()) {
        this.jdField_a_of_type_Blnb.a();
      }
      this.jdField_a_of_type_Blnb.b = false;
      localArrayList = new ArrayList();
      paramAdvertisementInfo = paramAdvertisementInfo.mAdDislikeInfos.iterator();
      while (paramAdvertisementInfo.hasNext())
      {
        AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramAdvertisementInfo.next();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_ArrayOfByte = localAdDislikeInfo.jdField_a_of_type_ArrayOfByte;
        localDislikeInfo.jdField_a_of_type_Int = localAdDislikeInfo.jdField_a_of_type_Int;
        localDislikeInfo.jdField_a_of_type_Long = localAdDislikeInfo.jdField_a_of_type_Long;
        localDislikeInfo.b = localAdDislikeInfo.b;
        localDislikeInfo.jdField_a_of_type_JavaLangString = localAdDislikeInfo.jdField_a_of_type_JavaLangString;
        localArrayList.add(localDislikeInfo);
      }
    } while ((localArrayList.size() <= 0) || (!this.jdField_a_of_type_Blnb.a(0, localArrayList)));
    this.jdField_a_of_type_Blnb.a(paramView, localtob);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Blnb != null) && (this.jdField_a_of_type_Blnb.isShowing())) {
      this.jdField_a_of_type_Blnb.dismiss();
    }
    this.jdField_a_of_type_Blnb = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     toa
 * JD-Core Version:    0.7.0.1
 */