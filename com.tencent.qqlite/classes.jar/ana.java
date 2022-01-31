import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class ana
  implements Runnable
{
  public ana(ForwardOperations paramForwardOperations, String paramString, QQCustomDialog paramQQCustomDialog) {}
  
  public void run()
  {
    Object localObject7 = null;
    Object localObject3;
    Object localObject1;
    Object localObject5;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v == 1)
      {
        localObject3 = BitmapManager.a(this.jdField_a_of_type_JavaLangString, 100, 100);
        localObject1 = localObject3;
        if (localObject3 != null) {
          localObject1 = ImageUtil.a((Bitmap)localObject3, new File(this.jdField_a_of_type_JavaLangString));
        }
        localObject5 = localObject1;
        if (localObject1 != null) {
          break label332;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v != -2) {
          break label124;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130837993);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new anb(this, (Drawable)localObject1));
      }
    }
    for (;;)
    {
      return;
      localObject1 = BitmapManager.a(this.jdField_a_of_type_JavaLangString);
      break;
      label124:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v != 9) {
        continue;
      }
      localObject1 = MarketFaceItemBuilder.a;
      if (localObject1 == null) {
        continue;
      }
      Object localObject6 = ((PicEmoticonInfo)localObject1).a;
      int i;
      if (((PicEmoticonInfo)localObject1).c())
      {
        localObject1 = EmosmUtils.getEmoticonAIOPreviewPath(((Emoticon)localObject6).epId, ((Emoticon)localObject6).eId);
        localObject3 = "aio_preview";
        i = 1;
      }
      Object localObject2;
      for (;;)
      {
        localObject5 = Integer.toString(i);
        try
        {
          localObject1 = new URL("emotion_pic", (String)localObject3, (String)localObject1);
          localObject1 = URLDrawable.getDrawable((URL)localObject1, false);
          if (((URLDrawable)localObject1).getStatus() != 1)
          {
            ((URLDrawable)localObject1).setTag(localObject6);
            ((URLDrawable)localObject1).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            ((URLDrawable)localObject1).addHeader("emo_tasks", (String)localObject5);
          }
          ((URLDrawable)localObject1).setBounds(ImageUtil.a((Drawable)localObject1, 36, 100, ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations)));
          this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new anc(this, (URLDrawable)localObject1));
          return;
          i = 4;
          localObject1 = "big_img";
          if (((Emoticon)localObject6).isSound)
          {
            localObject1 = "big_sound";
            i = 12;
          }
          localObject5 = EmosmUtils.getEmoticonEncryptPath(((Emoticon)localObject6).epId, ((Emoticon)localObject6).eId);
          localObject3 = localObject1;
          localObject1 = localObject5;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            localMalformedURLException.printStackTrace();
            localObject2 = null;
          }
        }
      }
      localObject5 = null;
      label332:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.z != null) && (AbsDownloader.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.z)))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.z;
        label363:
        localObject6 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_Boolean)
        {
          if (localObject2 == null) {
            break label641;
          }
          localObject6 = localObject2;
          if (Build.VERSION.SDK_INT >= 10)
          {
            if (!((String)localObject2).toLowerCase(Locale.US).startsWith("file:")) {
              break label630;
            }
            localObject3 = localObject7;
          }
        }
      }
      try
      {
        if (((String)localObject2).substring(0, "file:".length()).equalsIgnoreCase("file:")) {
          localObject3 = new File(((String)localObject2).substring("file:".length()));
        }
        label444:
        localObject6 = localObject2;
        if (localObject3 != null)
        {
          localObject6 = localObject2;
          if (((File)localObject3).exists()) {
            localObject6 = RegionalThumbDownloader.a(((File)localObject3).getAbsolutePath(), this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.x, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.x).toString();
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_Boolean)
        {
          localObject2 = URLDrawable.getDrawable((String)localObject6);
          label503:
          if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_Boolean)
          {
            localObject3 = (URLDrawable)localObject2;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v != 12) || (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.A == null)) {
              break label671;
            }
            URLDrawableHelper.a((URLDrawable)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
          }
          label555:
          if (localObject2 == null) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v != -2) {
            break label689;
          }
          ((Drawable)localObject2).setBounds(0, 0, (int)(264.0F * ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations)), (int)(138.0F * ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations)));
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ane(this, (Drawable)localObject2));
          return;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.y;
          break label363;
          label630:
          localObject3 = AbsDownloader.a(AbsDownloader.b((String)localObject2));
          break label444;
          label641:
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("ForwardOperations", 2, "isURLDrawablFoward is true, but mBigURLDrawableUrl and URLDrawableUrl are null");
          return;
          localObject2 = ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations, (Bitmap)localObject5);
          break label503;
          label671:
          URLDrawableHelper.a((URLDrawable)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
          break label555;
          label689:
          if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.v == 12) {
            ((Drawable)localObject2).setBounds(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.x, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.x);
          } else {
            ((Drawable)localObject2).setBounds(ImageUtil.a((Drawable)localObject2, 36, 100, ForwardOperations.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations)));
          }
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        for (;;)
        {
          Object localObject4 = localObject7;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ana
 * JD-Core Version:    0.7.0.1
 */