import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import com.tencent.gdtad.views.videoimax.GdtMotiveVideoMockQzoneImaxFeedsFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;

public class ysd
  implements View.OnClickListener
{
  public ysd(GdtMotiveVideoMockQzoneImaxFeedsFragment paramGdtMotiveVideoMockQzoneImaxFeedsFragment) {}
  
  public void onClick(View paramView)
  {
    yjs localyjs = new yjs();
    localyjs.jdField_a_of_type_Int = 2;
    localyjs.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.a.getActivity());
    Object localObject = GdtMotiveVideoMockQzoneImaxFeedsFragment.a(this.a).getAd();
    ((GdtAd)localObject).info.product_type.set(1000);
    ((GdtAd)localObject).info.dest_info.dest_type.set(4);
    ((GdtAd)localObject).info.display_info.video_info2.video_url.set(GdtMotiveVideoMockQzoneImaxFeedsFragment.a(this.a).getVideoData().getUrl());
    localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)localObject);
    localyjs.e = true;
    localyjs.jdField_a_of_type_Boolean = true;
    localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    yny.a("GdtMotiveVideoMockQzoneImaxFeedsFragment", "onClick() getLocationInWindow = [" + Arrays.toString((int[])localObject) + "]");
    paramView.getLocationOnScreen((int[])localObject);
    yny.a("GdtMotiveVideoMockQzoneImaxFeedsFragment", "onClick() getLocationOnScreen = [" + Arrays.toString((int[])localObject) + "]");
    localyjs.jdField_a_of_type_AndroidGraphicsRect = new Rect(localObject[0], localObject[1], localObject[0] + paramView.getWidth(), localObject[1] + paramView.getHeight());
    paramView = this.a.getActivity().getIntent();
    if (TextUtils.isEmpty(paramView.getStringExtra("big_brother_ref_source_key"))) {}
    for (paramView = paramView.getStringExtra("big_brother_source_key");; paramView = paramView.getStringExtra("big_brother_ref_source_key"))
    {
      localyjs.jdField_a_of_type_AndroidOsBundle = new Bundle();
      localyjs.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramView);
      localyjs.f = true;
      yjr.a(localyjs);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ysd
 * JD-Core Version:    0.7.0.1
 */