import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import java.util.Locale;

public class vkb
  implements MessageQueue.IdleHandler
{
  public vkb(AIOGalleryScene paramAIOGalleryScene) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if ((localObject != null) && (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a)))
    {
      AIOImageData localAIOImageData = (AIOImageData)((AIORichMediaInfo)localObject).a;
      if ((localAIOImageData != null) && (localAIOImageData.a(4)) && (localAIOImageData.a(4) == null)) {
        this.a.c(true);
      }
    }
    if ((localObject != null) && (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).a)))
    {
      localObject = (AIOFilePicData)((AIORichMediaInfo)localObject).a;
      if ((localObject != null) && (((AIOFilePicData)localObject).a(20)) && (((AIOFilePicData)localObject).a(20) == null))
      {
        if ((!((AIOFilePicData)localObject).d) || (!MsgUtils.a(((AIOFilePicData)localObject).b))) {
          break label204;
        }
        this.a.c(true);
        this.a.a(false);
        this.a.jdField_a_of_type_Vko = null;
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, AIOGalleryScene.c(this.a).getString(2131436095), new Object[] { FileUtil.a(((AIOFilePicData)localObject).a) }));
      }
      return false;
      label204:
      if (((AIOFilePicData)localObject).e) {
        this.a.c(false);
      } else {
        this.a.c(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vkb
 * JD-Core Version:    0.7.0.1
 */