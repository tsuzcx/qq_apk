package com.tencent.qqmail.utilities;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.protocol.MailUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import smartisanos.api.OneStepHelper;

public class OneStepUtils
{
  private static final String TAG = "OneStepUtils";
  private static OneStepHelper sOneStepHelper;
  
  public static boolean dragFileByOneStep(View paramView, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return false;
      initOneStepHelper();
    } while (!sOneStepHelper.isOneStepShowing());
    File localFile = new File(paramString1);
    if (!localFile.exists())
    {
      Log.d("OneStepUtils", "not exist: " + paramString1);
      return false;
    }
    paramString1 = IntentUtil.getMIMEType(localFile);
    Log.d("OneStepUtils", "mineType:" + paramString1);
    sOneStepHelper.dragFile(paramView, localFile, paramString1, paramString2);
    return true;
  }
  
  public static boolean dragImageByOneStep(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      initOneStepHelper();
    } while (!sOneStepHelper.isOneStepShowing());
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      Log.d("OneStepUtils", "not exist: " + paramString);
      return false;
    }
    sOneStepHelper.dragImage(paramView, localFile, "image/jpeg");
    return true;
  }
  
  public static boolean dragLinkByOneStep(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      initOneStepHelper();
    } while (!sOneStepHelper.isOneStepShowing());
    sOneStepHelper.dragLink(paramView, paramString);
    return true;
  }
  
  public static boolean dragMailByOneStep(View paramView, Mail paramMail)
  {
    if (paramMail == null) {
      return false;
    }
    try
    {
      if (isOneStepShowing())
      {
        String str2 = FileUtil.getEmlCacheDir();
        if (str2 != null)
        {
          String str1 = null;
          Object localObject = paramMail.getInformation();
          if (localObject != null) {
            str1 = FileUtil.getLegalFileName(((MailInformation)localObject).getSubject());
          }
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = System.currentTimeMillis() + "";
          }
          str1 = str2 + (String)localObject + ".eml";
          if (FileUtil.createFile(str1))
          {
            MailParser.createMessage(MailUtil.QMMail2SdkMail(paramMail, false)).write(new FileOutputStream(str1), new OneStepUtils.1());
            dragFileByOneStep(paramView, str1, paramMail.getInformation().getSubject());
          }
        }
      }
      return true;
    }
    catch (MessageException paramView)
    {
      QMLog.log(5, "OneStepUtils", "dragMailByOneStep", paramView);
      return false;
    }
    catch (FileNotFoundException paramView)
    {
      QMLog.log(5, "OneStepUtils", "dragMailByOneStep", paramView);
    }
    return false;
  }
  
  public static boolean dragTextByOneStep(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      initOneStepHelper();
    } while (!sOneStepHelper.isOneStepShowing());
    sOneStepHelper.dragText(paramView, paramString);
    return true;
  }
  
  public static void drapAttachByOneStep(View paramView, Attach paramAttach)
  {
    if ((!isOneStepShowing()) || (paramAttach == null)) {}
    while (!paramAttach.isExist()) {
      return;
    }
    if (AttachToolbox.isAttachTypeImage(paramAttach))
    {
      dragImageByOneStep(paramView, paramAttach.getPreview().getMyDisk());
      return;
    }
    dragFileByOneStep(paramView, paramAttach.getPreview().getMyDisk(), paramAttach.getName());
  }
  
  private static void initOneStepHelper()
  {
    if (sOneStepHelper == null) {
      sOneStepHelper = OneStepHelper.getInstance(QMApplicationContext.sharedInstance());
    }
  }
  
  public static boolean isOneStepShowing()
  {
    initOneStepHelper();
    return sOneStepHelper.isOneStepShowing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.OneStepUtils
 * JD-Core Version:    0.7.0.1
 */