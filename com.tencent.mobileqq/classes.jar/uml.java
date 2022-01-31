import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

public final class uml
  extends AsyncTask
{
  public uml(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  protected ImageInfo a(Void... paramVarArgs)
  {
    ImageUtil.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "sessionInfo.handleScreenPhoto");
    String str = ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramVarArgs = new ImageInfo();
    ImageUtil.a(paramVarArgs, "compress_start", "sessionInfo.handleScreenPhoto");
    ImageUtil.a(3, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, str, true, paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (!FileUtils.b(paramVarArgs.b)) {
      return null;
    }
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      StatisticConstants.a(new String[] { str }, i, false, false, -1, localQQAppInterface);
      return paramVarArgs;
    }
    catch (Exception localException) {}
    return paramVarArgs;
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    if (paramImageInfo != null)
    {
      Object localObject = new PicUploadInfo.Builder();
      ((PicUploadInfo.Builder)localObject).a(paramImageInfo.b);
      ((PicUploadInfo.Builder)localObject).d(1027);
      ((PicUploadInfo.Builder)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramImageInfo.h == 2) {}
      for (int i = TranDbRecord.PicDbRecord.e;; i = TranDbRecord.PicDbRecord.d)
      {
        ((PicUploadInfo.Builder)localObject).c(i);
        ((PicUploadInfo.Builder)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        ((PicUploadInfo.Builder)localObject).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((PicUploadInfo.Builder)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        PicReq localPicReq = PicBusiManager.a(2, 1027);
        localPicReq.a(((PicUploadInfo.Builder)localObject).a());
        PicBusiManager.a(localPicReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramImageInfo);
        ImageUtil.a(this.jdField_a_of_type_AndroidContentContext, (List)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return;
      }
    }
    ImageUtil.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "sessionInfo.handleScreenPhoto");
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131434505), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uml
 * JD-Core Version:    0.7.0.1
 */