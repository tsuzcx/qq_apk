import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public final class vnw
  extends AsyncTask
{
  public vnw(Context paramContext, int paramInt, URLDrawable paramURLDrawable, QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly(false);
    }
    URLDrawable.removeMemoryCacheByUrl(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    paramVarArgs = ((MessageForPic)this.jdField_a_of_type_ComTencentImageURLDrawable.getTag()).path;
    paramVarArgs = AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs);
    if (paramVarArgs != null)
    {
      AIOGalleryUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, paramVarArgs);
      return Integer.valueOf(2);
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
    if (!AbsDownloader.a(paramVarArgs)) {
      return Integer.valueOf(1);
    }
    paramVarArgs = AbsDownloader.a(paramVarArgs);
    if (paramVarArgs != null) {}
    label299:
    label310:
    for (paramVarArgs = SecUtil.getFileMd5(paramVarArgs.getAbsolutePath());; paramVarArgs = null)
    {
      if ((paramVarArgs == null) || ("".equals(paramVarArgs))) {
        return Integer.valueOf(1);
      }
      FileUtils.c(AppConstants.aU + ".nomedia");
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      int i;
      StringBuilder localStringBuilder;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.isDiyDouTu()))
      {
        i = 1;
        if (i == 0) {
          break label310;
        }
        localStringBuilder = new StringBuilder().append("_diydoutu@");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId)) {
          break label299;
        }
        str1 = "0";
      }
      label220:
      for (String str1 = str1;; str1 = "")
      {
        paramVarArgs = AppConstants.aU + str2 + paramVarArgs + str1 + ".jpg";
        try
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(paramVarArgs);
          return Integer.valueOf(AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData));
        }
        catch (IOException paramVarArgs)
        {
          paramVarArgs.printStackTrace();
          QLog.d("AIOGalleryUtils", 1, paramVarArgs, new Object[0]);
          return Integer.valueOf(1);
        }
        i = 0;
        break;
        str1 = this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId;
        break label220;
      }
    }
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 0) {}
    do
    {
      return;
      if (paramInteger.intValue() == 1)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131434584, 0).b(this.jdField_a_of_type_Int);
        return;
      }
      if (paramInteger.intValue() == 2)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, 2131434501, 0).b(this.jdField_a_of_type_Int);
        return;
      }
    } while (paramInteger.intValue() != 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vnw
 * JD-Core Version:    0.7.0.1
 */