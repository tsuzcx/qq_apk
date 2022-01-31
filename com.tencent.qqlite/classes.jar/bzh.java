import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public final class bzh
  extends AsyncTask
{
  public bzh(Context paramContext, int paramInt, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly(false);
    }
    URLDrawable.removeMemoryCacheByUrl(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    paramVarArgs = ((MessageForPic)this.jdField_a_of_type_ComTencentImageURLDrawable.getTag()).path;
    if (AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs)) {
      return Integer.valueOf(2);
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
    if (!AbsDownloader.a(paramVarArgs)) {
      return Integer.valueOf(1);
    }
    paramVarArgs = SecUtil.a(AbsDownloader.a(paramVarArgs).getAbsolutePath());
    if (("".equals(paramVarArgs)) || (paramVarArgs == null)) {
      return Integer.valueOf(1);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramVarArgs = AppConstants.av + (String)localObject1 + paramVarArgs + ".jpg";
    localObject1 = paramVarArgs + ".tmp";
    Object localObject2 = new File((String)localObject1);
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    if (!((File)localObject2).exists()) {}
    try
    {
      ImageUtil.a((String)localObject1);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo((String)localObject1) == null) {
        break label324;
      }
      localObject2 = new ImageInfo();
      ((ImageInfo)localObject2).c = this.jdField_a_of_type_JavaLangString;
      if (ImageUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, paramVarArgs, (ImageInfo)localObject2, 1))
      {
        localObject2 = new File(paramVarArgs);
        localObject1 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          ((File)localObject1).delete();
          return Integer.valueOf(AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs));
        }
        throw new Exception("compressPic file fail");
      }
    }
    catch (Exception paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOGalleryUtils", 2, "", paramVarArgs);
      }
      return Integer.valueOf(1);
    }
    return Integer.valueOf(1);
    label324:
    throw new Exception("save file fail");
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131363417), 0).b(this.jdField_a_of_type_Int);
      paramInteger = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
      if (paramInteger != null) {
        paramInteger.obtainMessage(10).sendToTarget();
      }
    }
    do
    {
      return;
      if (paramInteger.intValue() == 1)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131363453), 0).b(this.jdField_a_of_type_Int);
        return;
      }
    } while (paramInteger.intValue() != 2);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131363420), 0).b(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bzh
 * JD-Core Version:    0.7.0.1
 */