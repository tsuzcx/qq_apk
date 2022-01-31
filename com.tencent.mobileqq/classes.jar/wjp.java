import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.ZhituViewHolder;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class wjp
  implements Runnable
{
  public wjp(ZhituPanelView.ZhituViewHolder paramZhituViewHolder, ZhituPicData paramZhituPicData) {}
  
  public void run()
  {
    Object localObject1 = null;
    Object localObject3;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_b_of_type_Boolean)
    {
      localObject3 = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituViewHolder.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.c);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)) {
        localObject1 = ((BitmapDrawable)this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
      }
      if (localObject1 == null) {
        return;
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (!((File)localObject3).exists())
          {
            ((File)localObject3).getParentFile().mkdirs();
            ((File)localObject3).createNewFile();
          }
          boolean bool = FileUtils.a((Bitmap)localObject1, ((File)localObject3).getAbsolutePath());
          if (!bool) {
            break;
          }
          localObject1 = localObject3;
          if (ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituViewHolder.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a() != 7220) {
            break label363;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_b_of_type_JavaLangString = ((File)localObject1).getAbsolutePath();
          ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituViewHolder.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituViewHolder.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008C72", "0X8008C72", ZhituManager.a(ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituViewHolder.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()), 0, "", "", "", "");
          return;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          ZhituManager.a(localOutOfMemoryError1);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_b_of_type_JavaLangString == null) {
          try
          {
            Object localObject2 = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituViewHolder.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData);
            if (localObject2 == null) {
              break;
            }
            localObject2 = new File((String)localObject2);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            for (;;)
            {
              QLog.e(ZhituPanelView.a(), 1, "oom when save bitmap");
              ZhituManager.a(localOutOfMemoryError2);
              localFile = null;
            }
          }
        }
      }
      File localFile = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituViewHolder.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.c);
      FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_b_of_type_JavaLangString, localFile.getAbsolutePath());
      continue;
      label363:
      localObject3 = new Intent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localFile.getAbsolutePath());
      ((Intent)localObject3).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject3).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1044);
      ((Intent)localObject3).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituViewHolder.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject3).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituViewHolder.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((Intent)localObject3).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituViewHolder.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      ((Intent)localObject3).putExtra("send_in_background", true);
      ((Intent)localObject3).putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      new SendPhotoActivity.sendPhotoTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituViewHolder.a.a.a(), (Intent)localObject3).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjp
 * JD-Core Version:    0.7.0.1
 */