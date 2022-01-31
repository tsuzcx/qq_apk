import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.shortvideo.ProgressiveUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.CompressConfig;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class vkv
  extends AsyncTask
{
  long jdField_a_of_type_Long;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  String jdField_b_of_type_JavaLangString;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  String c;
  
  public vkv(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    paramMessageForShortVideo.videoFileStatus = 998;
    paramMessageForShortVideo.serial();
    paramQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
      return Integer.valueOf(7);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: Md5 not null, Compressed has been done, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      return Integer.valueOf(5);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName)) || (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "CompressTask, step: before compress, msg.videoFileName file not exists!! videoFileName=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName);
      }
      return Integer.valueOf(3);
    }
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    String str = ShortVideoUtils.c(paramVarArgs, "mp4");
    if (str == null) {
      return Integer.valueOf(5);
    }
    long l1;
    long l2;
    int i;
    boolean bool1;
    label583:
    File localFile;
    label719:
    int j;
    if (FileUtils.b(str))
    {
      this.jdField_b_of_type_JavaLangString = str;
      QLog.d("ShortVideoItemBuilder", 1, "CompressTask, step: Compressed file has exists, videoPath:" + str + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      l1 = new File(paramVarArgs).length();
      l2 = new File(this.jdField_b_of_type_JavaLangString).length();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "CompressTask，step: ShortVideoTrimmer Over fileSourceSize=" + l1 + ", fileTargetSize=" + l2 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", videoInput=" + paramVarArgs + ", mVideoPath=" + this.jdField_b_of_type_JavaLangString);
      }
      if (l2 > l1) {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: after compress, mVideoPath = " + this.jdField_b_of_type_JavaLangString + ", videoInput = " + paramVarArgs + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!FileUtils.b(this.jdField_b_of_type_JavaLangString)))
      {
        QLog.e("ShortVideoItemBuilder", 2, "CompressTask, step: after compress, mVideoPath not exists!!, path = " + this.jdField_b_of_type_JavaLangString + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        return Integer.valueOf(3);
      }
    }
    else
    {
      l1 = System.currentTimeMillis();
      if (ShortVideoTrimmer.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0, 0))
      {
        Object localObject = ShortVideoTrimmer.a(paramVarArgs, (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get());
        if ((localObject == null) || (!((ShortVideoTrimmer.CompressConfig)localObject).jdField_a_of_type_Boolean)) {
          break label1349;
        }
        if (Build.VERSION.SDK_INT >= 18)
        {
          i = ShortVideoCodec.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          if (((i & 0x1) > 0) && ((i & 0x2) > 0))
          {
            bool1 = true;
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: isHWCodecSupported = " + bool1);
            }
            if (!bool1) {
              break label936;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: Try to compress using MediaCodec");
            }
            localFile = new File(paramVarArgs);
            localObject = new vkz(this, str, (int)(((ShortVideoTrimmer.CompressConfig)localObject).b * 1024L), (int)((ShortVideoTrimmer.CompressConfig)localObject).jdField_a_of_type_Long, ((ShortVideoTrimmer.CompressConfig)localObject).c);
            if ((!new VideoConverter().a(localFile, (VideoConverter.Processor)localObject, true)) || (((vkz)localObject).a != null)) {
              break label928;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: compress completed using MediaCodec");
            }
            i = 0;
            j = i;
            if (i != 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
              }
              j = ShortVideoTrimmer.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramVarArgs, str, (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get());
              if (j != 0) {
                break label941;
              }
              QLog.d("ShortVideoItemBuilder", 1, "CompressTask, step:compress completed using ShortVideoTrimmer.compressVideo");
            }
          }
        }
      }
    }
    for (;;)
    {
      l1 = System.currentTimeMillis() - l1;
      label796:
      long l3;
      if (j == 0)
      {
        this.jdField_b_of_type_JavaLangString = str;
        l2 = new File(paramVarArgs).length();
        l3 = new File(this.jdField_b_of_type_JavaLangString).length();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "CompressTask，step: ShortVideoTrimmer compress ret = " + j + ", cost:" + l1 + "ms, fileSourceSize=" + l2 + ", fileTargetSize=" + l3 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        }
        if (j != 0) {
          break label1019;
        }
      }
      label928:
      label936:
      label941:
      label1019:
      for (bool1 = true;; bool1 = false)
      {
        for (;;)
        {
          StatisticConstants.a(bool1, l1, l2, l3);
          break;
          bool1 = false;
          break label583;
          QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: compress failed using MediaCodecr");
          i = -1;
          break label719;
          try
          {
            localFile = new File(str);
            if (localFile.exists()) {
              localFile.delete();
            }
            QLog.d("ShortVideoItemBuilder", 1, "CompressTask, step:compress failed using ShortVideoTrimmer.compressVideo, ret = " + j);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
        break label796;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
      QLog.e("ShortVideoItemBuilder", 2, "CompressTask，step: ShortVideoTrimmer init failure, ignore compress, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      break;
      paramVarArgs = new File(this.jdField_b_of_type_JavaLangString);
      if (ShortVideoUtils.a(paramVarArgs))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: supportProgressive, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.supportProgressive = true;
      }
      for (;;)
      {
        this.jdField_a_of_type_Long = paramVarArgs.length();
        try
        {
          this.jdField_a_of_type_JavaLangString = HexUtil.a(MD5.toMD5Byte(new FileInputStream(paramVarArgs), this.jdField_a_of_type_Long));
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            QLog.e("ShortVideoItemBuilder", 1, "CompressTask, step: after compress, mVideoMd5 is empty!!, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
            return Integer.valueOf(5);
            bool1 = ProgressiveUtils.a.get();
            boolean bool2 = ShortVideoUtils.a(this.jdField_b_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: not supportProgressive => moveMoovAtom, result = " + bool2 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", enableProgressive = " + bool1);
            }
            if (bool2)
            {
              this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.supportProgressive = true;
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.supportProgressive = false;
          }
        }
        catch (FileNotFoundException paramVarArgs)
        {
          for (;;)
          {
            paramVarArgs.printStackTrace();
          }
        }
        catch (Exception paramVarArgs)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ShortVideoItemBuilder", 2, "", paramVarArgs);
            }
          }
        }
      }
      return Integer.valueOf(1);
      label1349:
      j = -1;
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    QLog.d("ShortVideoItemBuilder", 1, "CompressTask onPostExecute(): result = " + paramInteger);
    Object localObject1;
    Object localObject2;
    switch (paramInteger.intValue())
    {
    default: 
      if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
      {
        localObject1 = (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if (localObject1 != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
          ((MessageForShortVideo)localObject2).videoFileStatus = 1005;
          ((MessageForShortVideo)localObject2).serial();
          ((QQAppInterface)localObject1).a().a(((MessageForShortVideo)localObject2).frienduin, ((MessageForShortVideo)localObject2).istroop, ((MessageForShortVideo)localObject2).uniseq, ((MessageForShortVideo)localObject2).msgData);
        }
      }
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
        break;
      }
    }
    label168:
    label500:
    do
    {
      do
      {
        do
        {
          do
          {
            QQToast.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "For test, Compress failure,result=" + paramInteger, 0).a();
            break label168;
            break label168;
            do
            {
              return;
            } while (this.jdField_b_of_type_JavaLangRefWeakReference == null);
            paramInteger = (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
            if (paramInteger == null) {
              break label500;
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
            if (this.jdField_a_of_type_Long < 27488000L) {
              break;
            }
            ((MessageForShortVideo)localObject1).videoFileStatus = 1005;
            ((MessageForShortVideo)localObject1).serial();
            paramInteger.a().a(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).istroop, ((MessageForShortVideo)localObject1).uniseq, ((MessageForShortVideo)localObject1).msgData);
          } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
          localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (!(localObject1 instanceof BaseActivity));
        localObject2 = (BaseActivity)localObject1;
        paramInteger = DialogUtil.a((Context)localObject1, 232, null, ((Context)localObject1).getString(2131437406), new vkw(this, paramInteger, (BaseActivity)localObject2), new vkx(this, paramInteger));
        try
        {
          paramInteger.show();
          return;
        }
        catch (Exception paramInteger)
        {
          return;
        }
        if ((ShortVideoItemBuilder.a == null) || (ShortVideoItemBuilder.a.get() != ((MessageForShortVideo)localObject1).uniseq)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute sRecvMsgSeq==mr.uniseq==" + ((MessageForShortVideo)localObject1).uniseq + ", just return");
      return;
      ((MessageForShortVideo)localObject1).md5 = this.jdField_a_of_type_JavaLangString;
      ((MessageForShortVideo)localObject1).videoFileSize = ((int)this.jdField_a_of_type_Long);
      ((MessageForShortVideo)localObject1).videoFileName = this.jdField_b_of_type_JavaLangString;
      ((MessageForShortVideo)localObject1).serial();
      paramInteger.a().a(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).istroop, ((MessageForShortVideo)localObject1).uniseq, ((MessageForShortVideo)localObject1).msgData);
      localObject2 = ShortVideoBusiManager.a(0, 0);
      ShortVideoUploadInfo localShortVideoUploadInfo = ShortVideoBusiManager.a(localObject1, (ShortVideoReq)localObject2);
      localShortVideoUploadInfo.i = this.c;
      localShortVideoUploadInfo.jdField_a_of_type_Boolean = false;
      ((ShortVideoReq)localObject2).a(localShortVideoUploadInfo);
      ShortVideoBusiManager.a((ShortVideoReq)localObject2, paramInteger);
      ShortVideoItemBuilder.a.set(-1L);
      ThreadManager.postImmediately(new vky(this, (MessageForShortVideo)localObject1), null, false);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute QQAppInterface is null...");
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vkv
 * JD-Core Version:    0.7.0.1
 */