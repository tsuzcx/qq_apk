package com.tencent.qqmail.model.sendmail;

import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SendMailManager$14
  implements Observable.OnSubscribe<Void>
{
  SendMailManager$14(SendMailManager paramSendMailManager, List paramList, ArrayList paramArrayList) {}
  
  public void call(Subscriber<? super Void> paramSubscriber)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.val$ftnUploadInfos.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((FtnUploadInfo)((Iterator)localObject2).next()).getFid());
    }
    Log.d(SendMailManager.access$100(), "attachNeedFtnUploadSize:" + this.val$ftnUploadInfos.size() + ", fids:" + localObject1);
    localObject2 = FtnManager.sharedInstance().getFtnListByFids((List)localObject1);
    localObject1 = new HashMap();
    int i = 0;
    Object localObject3;
    while (i < ((FtnUI)localObject2).getCount())
    {
      localObject3 = ((FtnUI)localObject2).get(i);
      QMLog.log(2, SendMailManager.access$100(), "fileName: " + ((FileInfo)localObject3).filename + ", size: " + ((FileInfo)localObject3).filesize + ", createTime: " + ((FileInfo)localObject3).createtime + ", expireTime: " + ((FileInfo)localObject3).expiretime + ", fid: " + ((FileInfo)localObject3).fid + ", uploadsize: " + ((FileInfo)localObject3).uploadsize + ", code: " + ((FileInfo)localObject3).code + ", key: " + ((FileInfo)localObject3).key + ", filetype: " + ((FileInfo)localObject3).filetype + ", md5: " + ((FileInfo)localObject3).md5 + ", sha: " + ((FileInfo)localObject3).sha + ", viewtype: " + ((FileInfo)localObject3).viewtype);
      localObject3 = FtnCommonUtils.fileInfo2BigAttach((FileInfo)localObject3);
      ((Map)localObject1).put(((MailBigAttach)localObject3).getFid(), localObject3);
      i += 1;
    }
    localObject2 = this.val$attachNeedFtnUpload.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AttachInfo)((Iterator)localObject2).next();
      MailBigAttach localMailBigAttach = (MailBigAttach)((Map)localObject1).get(((AttachInfo)localObject3).getFid());
      if (localMailBigAttach != null)
      {
        ((AttachInfo)localObject3).setAttach(localMailBigAttach);
        ((AttachInfo)localObject3).setAttachSize(StringExtention.getHumanReadableSizeString(Long.parseLong(localMailBigAttach.getSize())));
      }
      else
      {
        QMLog.log(5, SendMailManager.access$100(), "can not find mailBigAttach, AttachName:" + ((AttachInfo)localObject3).getAttachName() + ", fid:" + ((AttachInfo)localObject3).getFid());
        FtnManager.sharedInstance().deleteUploadInfoByFid(((AttachInfo)localObject3).getFid());
      }
    }
    for (i = 0;; i = 1)
    {
      if (i != 0)
      {
        paramSubscriber.onNext(null);
        paramSubscriber.onCompleted();
        return;
      }
      paramSubscriber.onError(new QMNetworkError(9, 0, QMApplicationContext.sharedInstance().getString(2131719541)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.14
 * JD-Core Version:    0.7.0.1
 */