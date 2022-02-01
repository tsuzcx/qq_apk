import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyForCanvasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import java.lang.ref.WeakReference;

public class tqe
{
  public static GdtHandler.Params a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, tqh paramtqh)
  {
    if ((paramAdvertisementInfo == null) || (paramActivity == null)) {
      return null;
    }
    GdtHandler.Params localParams = new GdtHandler.Params();
    tqh localtqh = paramtqh;
    if (paramtqh == null) {
      localtqh = new tqh();
    }
    paramtqh = uhs.a(paramAdvertisementInfo);
    localParams.c = 1;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramtqh);
    localParams.jdField_a_of_type_Boolean = localtqh.jdField_a_of_type_Boolean;
    localParams.jdField_b_of_type_Boolean = localtqh.jdField_b_of_type_Boolean;
    if (paramAdvertisementInfo.clickPos > 0)
    {
      localParams.jdField_b_of_type_Int = paramAdvertisementInfo.clickPos;
      paramAdvertisementInfo.resetClickPos();
    }
    localParams.jdField_a_of_type_Long = localtqh.jdField_a_of_type_Long;
    if (uhs.a == null)
    {
      uhs.a = new GdtAppReceiver();
      uhs.a.register(BaseApplicationImpl.getContext());
    }
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(uhs.a);
    long l = paramAdvertisementInfo.mChannelID;
    if ((l != 3L) && (l != 4L) && (paramAdvertisementInfo.mAdJumpMode != 6) && (!localtqh.d) && (l != 2000001L))
    {
      localParams.jdField_a_of_type_JavaLangClass = ReadInJoyVideoCeilingFragment.class;
      uhs.a(localParams, localtqh.c, paramAdvertisementInfo, paramActivity);
    }
    localParams.jdField_b_of_type_JavaLangClass = ReadInJoyForCanvasFragment.class;
    localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
    localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    return localParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqe
 * JD-Core Version:    0.7.0.1
 */