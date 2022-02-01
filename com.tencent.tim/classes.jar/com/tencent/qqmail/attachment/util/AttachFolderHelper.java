package com.tencent.qqmail.attachment.util;

import android.content.Intent;
import android.widget.ImageView;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.List;

public class AttachFolderHelper
{
  public static final long SEND_LIMIT_SIZE = 47185920L;
  
  public static boolean isAttachPreviewLegal(Attach paramAttach)
  {
    return !AttachToolbox.attachSizeExceedTen(paramAttach, 10485760L);
  }
  
  public static void loadImageThumb(int paramInt1, String paramString, int paramInt2, ImageView paramImageView, boolean paramBoolean, ImageDownloadListener paramImageDownloadListener)
  {
    setDefaultThumbByType(paramImageView, "image");
    if ((StringExtention.isNullOrEmpty(paramString)) || (AttachToolbox.isGroupMail(paramString))) {}
    label102:
    do
    {
      return;
      if (QMNetworkConfig.isContainCgiButDropHost(paramString, "magick")) {}
      for (paramString = QMNetworkConfig.getCgiRequestHost(paramInt1) + paramString;; paramString = AttachToolbox.formatThumbnailUrl(paramString, 160, 160))
      {
        paramInt2 = ImageDownloadManager.shareInstance().isThumbBitmapExistLocal(paramString);
        if ((paramInt2 != 2) && (paramInt2 != 1)) {
          break label102;
        }
        paramString = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(paramString);
        if (paramString == null) {
          break;
        }
        paramImageView.setImageBitmap(paramString);
        return;
      }
    } while (paramBoolean);
    paramImageView = new DownloadInfo();
    paramImageView.setAccountId(paramInt1);
    paramImageView.setUrl(paramString);
    paramImageView.setImageDownloadListener(paramImageDownloadListener);
    ImageDownloadManager.shareInstance().fetchImage(paramImageView);
  }
  
  public static Intent setBackToMail(Intent paramIntent1, Intent paramIntent2)
  {
    paramIntent1.putExtra("id", paramIntent2.getLongExtra("id", 0L));
    paramIntent1.putExtra("accountId", paramIntent2.getIntExtra("accountId", 0));
    paramIntent1.putExtra("folderId", paramIntent2.getIntExtra("folderId", 0));
    paramIntent1.putExtra("subject", paramIntent2.getStringExtra("subject"));
    paramIntent1.putExtra("fromnickname", paramIntent2.getStringExtra("fromnickname"));
    paramIntent1.putExtra("fromaddress", paramIntent2.getStringExtra("fromaddress"));
    paramIntent1.putExtra("remoteid", paramIntent2.getStringExtra("remoteid"));
    return paramIntent1;
  }
  
  public static Intent setBackToMail(Attach paramAttach, Intent paramIntent)
  {
    long l = paramAttach.getBelongMailId();
    int i = paramAttach.getAccountId();
    int j = paramAttach.getFolderId();
    String str1 = paramAttach.getMailSubject();
    String str2 = paramAttach.getMailSender();
    String str3 = paramAttach.getMailSenderAddr();
    paramIntent.putExtra("id", l);
    paramIntent.putExtra("accountId", i);
    paramIntent.putExtra("folderId", j);
    paramIntent.putExtra("subject", str1);
    paramIntent.putExtra("fromnickname", str2);
    paramIntent.putExtra("fromaddress", str3);
    paramIntent.putExtra("remoteid", paramAttach.getRemoteId());
    return paramIntent;
  }
  
  public static void setDefaultThumbByType(ImageView paramImageView, String paramString)
  {
    paramImageView.setImageResource(ImageResourceUtil.getImageResource(paramString, ImageResourceUtil.IMAGE_SIZE_58));
  }
  
  public static boolean validateAttachSize(List<Attach> paramList, long paramLong)
  {
    boolean bool = false;
    long l1 = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      Attach localAttach = (Attach)paramList.get(i);
      long l2 = l1;
      if (localAttach != null) {
        l2 = l1 + StringExtention.sizeStrToLong(localAttach.getSize());
      }
      i += 1;
      l1 = l2;
    }
    if (l1 < paramLong) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.AttachFolderHelper
 * JD-Core Version:    0.7.0.1
 */