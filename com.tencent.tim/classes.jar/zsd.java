import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class zsd
  implements AdapterView.c
{
  public zsd(QzonePhotoPreviewActivity paramQzonePhotoPreviewActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QzonePhotoPreviewActivity.a(this.a))
    {
      this.a.getActivity().finish();
      aqfy.anim(this.a.getActivity(), true, false);
      return;
    }
    this.a.back();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsd
 * JD-Core Version:    0.7.0.1
 */