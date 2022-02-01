package com.tencent.qqmail.InlineImage.fetcher;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CidImageFetcher
  extends BaseFetcher
{
  private static final long LOCK_TIMEOUT = 18L;
  public static final String TAG = "CidImageFetch";
  private CountDownLatch countDownLatch;
  private String downloadPath = "";
  private Mail mail;
  
  public CidImageFetcher(Mail paramMail)
  {
    this.mail = paramMail;
  }
  
  protected void fetchFromNetwork(String paramString)
  {
    QMLog.log(4, "CidImageFetch", "Start loading cid image " + paramString);
    String str = SendMailHelper.removeInlineImgCid(paramString);
    if ((this.mail == null) || (this.mail.getInformation() == null))
    {
      QMLog.log(6, "CidImageFetch", "mail is null " + this.mail);
      return;
    }
    ArrayList localArrayList = this.mail.getInformation().getAttachList();
    if (localArrayList == null)
    {
      QMLog.log(6, "CidImageFetch", "Attach list is null");
      return;
    }
    Object localObject1 = localArrayList.iterator();
    Object localObject3;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject3 = ((Iterator)localObject1).next();
    } while ((!(localObject3 instanceof Attach)) || (!TextUtils.equals(((Attach)localObject3).getProtocol().getCid(), str)));
    label454:
    Object localObject2;
    for (localObject1 = (Attach)localObject3;; localObject2 = null)
    {
      if (localObject1 == null)
      {
        QMLog.log(6, "CidImageFetch", "Can't find corresponding attach for current img cid = " + str + " attachlist size = " + localArrayList.size());
        return;
      }
      if (((Attach)localObject1).isExist())
      {
        this.downloadPath = ((Attach)localObject1).getPreview().getMyDisk();
        QMLog.log(4, "CidImageFetch", "attach preview image exists " + this.downloadPath + ", cid:" + str);
      }
      while (!TextUtils.isEmpty(this.downloadPath))
      {
        InlineImagePathHelper.put(paramString, this.downloadPath);
        paramString = BitmapResizer.readResizedBitmap(this.downloadPath);
        if ((paramString != null) && (paramString.length != 0)) {
          break label454;
        }
        this.inputStream = null;
        return;
        QMLog.log(4, "CidImageFetch", "new cid download:" + str);
        this.countDownLatch = new CountDownLatch(1);
        QMMailManager.sharedInstance().downloadProtocolInlineImg(this.mail.getInformation(), (Attach)localObject1, new CidImageFetcher.1(this, paramString));
        try
        {
          boolean bool = this.countDownLatch.await(18L, TimeUnit.SECONDS);
          Log.i("CidImageFetch", "Finish loading cid image path downloadPath " + this.downloadPath + " reachLatch = " + bool);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          QMLog.log(4, "CidImageFetch", "InterruptedException " + localInterruptedException.toString());
        }
      }
      break;
      this.inputStream = new ByteArrayInputStream(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.fetcher.CidImageFetcher
 * JD-Core Version:    0.7.0.1
 */