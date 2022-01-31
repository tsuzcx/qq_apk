import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

class ean
  implements UpCallBack
{
  final int jdField_a_of_type_Int;
  final Rect jdField_a_of_type_AndroidGraphicsRect;
  final PicFowardInfo jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo;
  final PicResult jdField_a_of_type_ComTencentMobileqqPicPicResult;
  
  ean(eam parameam, int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqPicPicResult = ((PicResult)parameam.a.a.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo = ((PicFowardInfo)parameam.a.a.b.get(paramInt));
    this.jdField_a_of_type_AndroidGraphicsRect = a(paramString);
  }
  
  private Rect a(String paramString)
  {
    int j = 198;
    Rect localRect = new Rect(0, 0, 0, 0);
    int m;
    int n;
    int i;
    int k;
    float f;
    if (paramString != null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      m = localOptions.outWidth;
      n = localOptions.outHeight;
      i = Math.min(m, n);
      k = Math.max(m, n);
      f = k / i;
      if (i <= 198) {
        break label136;
      }
      if (f <= 3.0F) {
        break label122;
      }
      i = 66;
    }
    for (;;)
    {
      if (m < n)
      {
        localRect.right = i;
        localRect.bottom = j;
        return localRect;
        label122:
        i = (int)(i * 198.0F / k);
        continue;
        label136:
        if ((i > 66) && (i <= 198))
        {
          if (f > 3.0F)
          {
            i = 66;
            continue;
          }
          if (k >= 198) {
            i = (int)(i * 198.0F / k);
          }
        }
        else if ((i > 66) || (f <= 3.0F) || (k < 198)) {}
      }
      else
      {
        localRect.right = j;
        localRect.bottom = i;
        return localRect;
      }
      j = k;
    }
  }
  
  public MessageRecord a(im_msg_body.RichText arg1)
  {
    Object localObject1;
    if ((??? != null) && (???.elems.has()))
    {
      ??? = (im_msg_body.Elem)???.elems.get(0);
      if (??? != null) {
        if (???.not_online_image.has())
        {
          localObject1 = (im_msg_body.NotOnlineImage)???.not_online_image.get();
          ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_width.set(this.jdField_a_of_type_AndroidGraphicsRect.right);
          ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_height.set(this.jdField_a_of_type_AndroidGraphicsRect.bottom);
          if ((this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b == 1) || (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b == 3000))
          {
            Logger.a(this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "convert2CustomFace for [" + this.jdField_a_of_type_Int + "] ");
            localObject1 = eal.a(this.jdField_a_of_type_Eam.a, (im_msg_body.NotOnlineImage)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.d = 0;
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = localObject1;
        Logger.a(this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + eak.a(this.jdField_a_of_type_Eam.a.a, (im_msg_body.CustomFace)localObject1));
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] OK");
        }
        i = 1;
        if (i != 0) {}
      }
      synchronized (this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.d = -1;
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b = ("Get target pic filepath of [" + this.jdField_a_of_type_Int + "] failed");
        if ((this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b == 1) || (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b == 3000))
        {
          this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Eam.a.a.a(null, null, this.jdField_a_of_type_Int);
          Logger.b(this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, errDec ＝ " + this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
          if (QLog.isColorLevel()) {
            QLog.e("MultiMsg", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] failed, errDec ＝ " + this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
          }
          eal.a(this.jdField_a_of_type_Eam.a);
          if (eal.a(this.jdField_a_of_type_Eam.a) == 0) {
            eak.a(this.jdField_a_of_type_Eam.a.a);
          }
          return null;
          localNotOnlineImage1 = finally;
          throw localNotOnlineImage1;
          synchronized (this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_JavaUtilArrayList)
          {
            this.jdField_a_of_type_ComTencentMobileqqPicPicResult.d = 0;
            this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = localNotOnlineImage1;
            Logger.a(this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + eak.a(this.jdField_a_of_type_Eam.a.a, localNotOnlineImage1));
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] OK");
          }
          if (???.custom_face.has())
          {
            im_msg_body.CustomFace localCustomFace1 = (im_msg_body.CustomFace)???.custom_face.get();
            localCustomFace1.uint32_thumb_width.set(this.jdField_a_of_type_AndroidGraphicsRect.right);
            localCustomFace1.uint32_thumb_height.set(this.jdField_a_of_type_AndroidGraphicsRect.bottom);
            if ((this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b == 1) || (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b == 3000)) {}
            for (;;)
            {
              synchronized (this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_JavaUtilArrayList)
              {
                this.jdField_a_of_type_ComTencentMobileqqPicPicResult.d = 0;
                this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = localCustomFace1;
                Logger.a(this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + eak.a(this.jdField_a_of_type_Eam.a.a, localCustomFace1));
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] OK");
                }
                i = 1;
              }
              Logger.a(this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "convert2NotOnlineImage for [" + this.jdField_a_of_type_Int + "] ");
              im_msg_body.NotOnlineImage localNotOnlineImage2 = eal.a(this.jdField_a_of_type_Eam.a, localCustomFace2);
              synchronized (this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_JavaUtilArrayList)
              {
                this.jdField_a_of_type_ComTencentMobileqqPicPicResult.d = 0;
                this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = localNotOnlineImage2;
                Logger.a(this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] OK, " + eak.a(this.jdField_a_of_type_Eam.a.a, localNotOnlineImage2));
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] OK");
                }
              }
            }
          }
          Logger.b(this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, elem.not_online_image and elem.custom_face are null");
          i = 0;
          continue;
          Logger.b(this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, richText.elems is null");
          for (;;)
          {
            i = 0;
            break;
            Logger.b(this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.jdField_a_of_type_Int + "] failed, richText is null or richText.elems is null");
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Eam.a.a.a(null, null, this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    synchronized (this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_JavaUtilArrayList)
    {
      if (paramSendResult.jdField_a_of_type_Int != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.d = -1;
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b = paramSendResult.jdField_a_of_type_JavaLangString;
        if ((this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b != 1) && (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b != 3000)) {
          break label285;
        }
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Eam.a.a.a(null, null, this.jdField_a_of_type_Int);
        Logger.a(this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Eam.a.a.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onSend", "[" + this.jdField_a_of_type_Int + "] failed, errDec = " + this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
        if (QLog.isColorLevel()) {
          QLog.e("MultiMsg", 2, "[uploadForwardMultiMsgPics] upload [" + this.jdField_a_of_type_Int + "] failed, errDec ＝ " + this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
        }
        eal.a(this.jdField_a_of_type_Eam.a);
        if (eal.a(this.jdField_a_of_type_Eam.a) == 0) {
          eak.a(this.jdField_a_of_type_Eam.a.a);
        }
      }
      return;
      label285:
      this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_Eam.a.a.a(null, null, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ean
 * JD-Core Version:    0.7.0.1
 */