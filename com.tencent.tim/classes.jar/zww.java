import com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent;
import com.tencent.mobileqq.activity.photo.album.preview.PreviewBean;
import java.io.File;

public class zww
  extends BasePreviewAdapter
{
  public zww(PhotoPreviewLogicBase paramPhotoPreviewLogicBase)
  {
    super(paramPhotoPreviewLogicBase);
  }
  
  public BasePreviewPresent generatePreviewPresent(PreviewBean paramPreviewBean)
  {
    if ((this.mPhotoPreviewData.canUseURL) && (aqfy.isNetUrl(paramPreviewBean.getPath()))) {
      return new zwy(paramPreviewBean);
    }
    String str = paramPreviewBean.getPath();
    if ((str != null) && (new File(str).exists()) && (paramPreviewBean.mMediaType == 1)) {
      return new zwx(paramPreviewBean);
    }
    return super.generatePreviewPresent(paramPreviewBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zww
 * JD-Core Version:    0.7.0.1
 */