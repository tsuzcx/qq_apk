import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class zwv
  extends zug
{
  zwv(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = (NewPhotoPreviewActivity)this.mActivity;
    if ((paramAdapterView != null) && (!paramAdapterView.isFinishing())) {
      paramAdapterView.titleView.setText(acfp.m(2131709625));
    }
  }
  
  protected void submit()
  {
    Object localObject = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
    Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    if (localObject != null)
    {
      zsz.gi(((ArrayList)localObject).size(), this.a.totalPicCount);
      zsz.d(localIntent, ((ArrayList)localObject).size(), this.mPhotoCommonData.currentQualityType);
    }
    localObject = (NewPhotoPreviewActivity)this.mActivity;
    if ((localObject == null) || (((NewPhotoPreviewActivity)localObject).isFinishing())) {
      return;
    }
    ((NewPhotoPreviewActivity)localObject).setResult(-1, new Intent());
    ((NewPhotoPreviewActivity)localObject).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwv
 * JD-Core Version:    0.7.0.1
 */