import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import mqq.os.MqqHandler;

public class yua
  implements Runnable
{
  public yua(ApolloStoreActivity paramApolloStoreActivity, Bitmap paramBitmap, long paramLong, String paramString) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "[saveImage] failed bitmap null");
      }
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreActivity", 2, "[saveImage] consume time " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + " ms");
        }
        Message localMessage = Message.obtain();
        localMessage.what = 256;
        try
        {
          str = Environment.getExternalStorageDirectory().toString();
          Object localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Long.valueOf(System.currentTimeMillis()));
          if (ApolloStoreActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity) != null) {
            i = ApolloStoreActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity).c();
          }
          str = str + "/cmshow/" + i + "_" + (String)localObject + ".png";
          localObject = new File(str);
          if (!TextUtils.isEmpty(str))
          {
            try
            {
              ImageUtil.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject);
              if ((!TextUtils.isEmpty(str)) && (FileUtils.c(str))) {
                break label275;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ApolloStoreActivity", 2, "[saveImage] failed invalid path");
              return;
            }
            catch (Throwable localThrowable1) {}
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloStoreActivity", 2, "[saveImage] failed save to disk");
              return;
            }
          }
        }
        catch (Throwable localThrowable2) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "[saveImage] failed create path" + localThrowable2.getMessage());
    return;
    try
    {
      label275:
      MediaScannerConnection.scanFile(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity.getApplicationContext(), new String[] { str }, new String[] { "image/png" }, null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "[saveImage] to media db " + str);
      }
      localThrowable2.obj = this.jdField_a_of_type_JavaLangString;
      localThrowable2.arg1 = 0;
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloStoreActivity.a.sendMessage(localThrowable2);
      return;
    }
    catch (Throwable localThrowable3)
    {
      QLog.e("ApolloStoreActivity", 2, "[saveImage] failed exception " + localThrowable3.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yua
 * JD-Core Version:    0.7.0.1
 */