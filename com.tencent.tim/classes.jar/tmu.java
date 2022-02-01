import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import com.tencent.gdtad.views.videoimax.GdtMotiveVideoMockQzoneImaxFeedsFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;

public class tmu
  implements View.OnClickListener
{
  public tmu(GdtMotiveVideoMockQzoneImaxFeedsFragment paramGdtMotiveVideoMockQzoneImaxFeedsFragment) {}
  
  public void onClick(View paramView)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.processId = 2;
    localParams.activity = new WeakReference(this.a.getActivity());
    Object localObject = GdtMotiveVideoMockQzoneImaxFeedsFragment.a(this.a).getAd();
    ((GdtAd)localObject).info.product_type.set(1000);
    ((GdtAd)localObject).info.dest_info.dest_type.set(4);
    ((GdtAd)localObject).info.display_info.video_info2.video_url.set(GdtMotiveVideoMockQzoneImaxFeedsFragment.a(this.a).getVideoData().getUrl());
    localParams.ad = ((GdtAd)localObject);
    localParams.videoSpliceSupported = true;
    localParams.reportForClick = true;
    localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    tkw.d("GdtMotiveVideoMockQzoneImaxFeedsFragment", "onClick() getLocationInWindow = [" + Arrays.toString((int[])localObject) + "]");
    paramView.getLocationOnScreen((int[])localObject);
    tkw.d("GdtMotiveVideoMockQzoneImaxFeedsFragment", "onClick() getLocationOnScreen = [" + Arrays.toString((int[])localObject) + "]");
    localParams.mediaViewLocationRect = new Rect(localObject[0], localObject[1], localObject[0] + paramView.getWidth(), localObject[1] + paramView.getHeight());
    localObject = this.a.getActivity().getIntent();
    if (TextUtils.isEmpty(((Intent)localObject).getStringExtra("big_brother_ref_source_key"))) {}
    for (localObject = ((Intent)localObject).getStringExtra("big_brother_source_key");; localObject = ((Intent)localObject).getStringExtra("big_brother_ref_source_key"))
    {
      localParams.extra = new Bundle();
      localParams.extra.putString("big_brother_ref_source_key", (String)localObject);
      localParams.directPlay = true;
      GdtHandler.a(localParams);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmu
 * JD-Core Version:    0.7.0.1
 */