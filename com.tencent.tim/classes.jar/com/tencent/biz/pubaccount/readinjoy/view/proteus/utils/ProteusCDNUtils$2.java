package com.tencent.biz.pubaccount.readinjoy.view.proteus.utils;

import acbn;
import aqhq;
import aqul;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jpe;
import jqj;
import jqo;
import jqp;
import npx;

public final class ProteusCDNUtils$2
  implements Runnable
{
  public ProteusCDNUtils$2(String paramString) {}
  
  public void run()
  {
    String str1 = aqul.getSDKPrivatePath(acbn.bny + this.val$bid + ".7z");
    if (!new File(str1).exists()) {
      QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], bid = " + this.val$bid + ", file does not exist.");
    }
    boolean bool;
    do
    {
      Object localObject;
      int i;
      do
      {
        return;
        localObject = BidDownloader.dK(str1);
        QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], fileFormat = " + (String)localObject);
        String str3 = aqul.getSDKPrivatePath(acbn.bny);
        str2 = aqul.getSDKPrivatePath(acbn.bny + this.val$bid + ".zip");
        localObject = new File(str2);
        if (((File)localObject).exists())
        {
          aqhq.deleteFile(str2);
          QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], delete file = " + str2);
        }
        int j = LzmaUtils.m(BaseApplicationImpl.getApplication().getApplicationContext(), str1, str3);
        QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], firstUnCompressCode = " + j + ", outputFilePath = " + str3);
        i = -1;
        str1 = aqul.getSDKPrivatePath(acbn.bny + this.val$bid);
        if (j == 0)
        {
          jqo.dn(str1);
          if (!new File(str1).mkdirs())
          {
            QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], mkdirs error.");
            return;
          }
          i = jqp.unZipFolder(str2, str1);
          QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], secondUnCompressCode = " + i + ", folderPathNew = " + str1);
        }
      } while (i != 0);
      String str2 = jpe.dO(this.val$bid);
      str2 = str2 + this.val$bid;
      ((File)localObject).renameTo(new File(str1 + "/b.zip"));
      if (!jqj.D(str1, this.val$bid)) {
        break;
      }
      jqo.dn(str2);
      bool = new File(str1).renameTo(new File(str2));
      QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], isRenameSuccess = " + bool + ", folderPathNew = " + str1 + ", targetFolderPath = " + str2);
    } while (!bool);
    npx.access$100("0X800ABFF", this.val$bid);
    return;
    QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], bid = " + this.val$bid + ", folderPathNew = " + str1 + ", folder may have changed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.ProteusCDNUtils.2
 * JD-Core Version:    0.7.0.1
 */