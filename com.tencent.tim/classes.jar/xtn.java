import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

final class xtn
  extends AsyncTask<Void, Void, Integer>
{
  xtn(Context paramContext, int paramInt, URLDrawable paramURLDrawable, QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    if (this.x.getStatus() != 1) {
      this.x.downloadImediatly(false);
    }
    URLDrawable.removeMemoryCacheByUrl(this.x.getURL().toString());
    if (this.x.getTag() == null) {
      return Integer.valueOf(1);
    }
    paramVarArgs = ((MessageForPic)this.x.getTag()).path;
    paramVarArgs = xtm.a(this.val$context, paramVarArgs);
    if (paramVarArgs != null)
    {
      xtm.a(this.val$app, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, paramVarArgs);
      return Integer.valueOf(2);
    }
    paramVarArgs = this.x.getURL().toString();
    if (!aoiz.hasFile(paramVarArgs))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, has file");
      }
      return Integer.valueOf(1);
    }
    File localFile = aoiz.getFile(paramVarArgs);
    if (localFile != null) {}
    for (paramVarArgs = SecUtil.getFileMd5(localFile.getAbsolutePath());; paramVarArgs = null)
    {
      if ((paramVarArgs == null) || ("".equals(paramVarArgs)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, md5 is null");
        }
        return Integer.valueOf(1);
      }
      aqhq.UD(acbn.bmd + ".nomedia");
      String str2 = this.val$app.getCurrentAccountUin();
      int i;
      StringBuilder localStringBuilder;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.isDiyDouTu()))
      {
        i = 1;
        if (i == 0) {
          break label364;
        }
        localStringBuilder = new StringBuilder().append("_diydoutu@");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId)) {
          break label353;
        }
        str1 = "0";
      }
      label266:
      label353:
      label364:
      for (String str1 = str1;; str1 = "")
      {
        paramVarArgs = acbn.bmd + aczs.jH(str2) + paramVarArgs + str1 + ".jpg";
        try
        {
          aqhq.copyFile(localFile, new File(paramVarArgs));
          return Integer.valueOf(xtm.a(this.val$context, paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData));
        }
        catch (Exception paramVarArgs)
        {
          QLog.d("AIOGalleryUtils", 1, paramVarArgs, new Object[0]);
          return Integer.valueOf(1);
        }
        i = 0;
        break;
        str1 = this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId;
        break label266;
      }
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      QQToast.a(this.val$context.getApplicationContext(), 2131696978, 0).show(this.bWT);
      ajdg.ew("2004", 1);
    }
    while (paramInteger.intValue() != 2) {
      return;
    }
    QQToast.a(this.val$context.getApplicationContext(), 1, 2131689839, 0).show(this.bWT);
    ajdg.ew("2003", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtn
 * JD-Core Version:    0.7.0.1
 */