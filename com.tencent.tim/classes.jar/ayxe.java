import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout.a;

public class ayxe
  implements View.OnClickListener
{
  public ayxe(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onClick(View paramView)
  {
    axim.a().eKZ();
    if ("h5".equals(AEPituCameraCaptureButtonLayout.a(this.d))) {
      if (!aqiw.isNetworkAvailable(null)) {
        QQToast.a(this.d.getContext(), 1, this.d.getContext().getString(2131699823), 1).show();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.d.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", AEPituCameraCaptureButtonLayout.b(this.d));
      localIntent.putExtra("loc_play_show_material_id", AEPituCameraCaptureButtonLayout.b(this.d));
      if (AEPituCameraCaptureButtonLayout.a(this.d).hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AEPituCameraCaptureButtonLayout.a(this.d).getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", axcg.a.getId()));
      }
      for (;;)
      {
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", axcg.C.getId());
        if (!(this.d.getContext() instanceof Activity)) {
          break label223;
        }
        ((Activity)this.d.getContext()).startActivityForResult(localIntent, 1025);
        break;
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AEPituCameraCaptureButtonLayout.a(this.d).getIntExtra("VIDEO_STORY_FROM_TYPE", axcg.a.getId()));
      }
      label223:
      this.d.getContext().startActivity(localIntent);
      continue;
      this.d.a.acc(AEPituCameraCaptureButtonLayout.b(this.d));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayxe
 * JD-Core Version:    0.7.0.1
 */