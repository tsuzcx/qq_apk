package com.tencent.tim.cloudfile.recent;

import ahav;
import android.text.TextUtils;
import apsv;
import atgi;
import atmp;
import atmq;
import attf;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import tencent.cloud.history_file_extension.history_file_extension.AIOFileExtension;
import tencent.cloud.history_file_extension.history_file_extension.FileExtension;

public class RecentWebNativeStorageManager$5
  implements Runnable
{
  public void run()
  {
    if ((this.KG == null) || (this.KG.size() <= 0))
    {
      atmp.a(this.this$0, null, null);
      return;
    }
    Iterator localIterator = this.KG.iterator();
    label40:
    CloudHistoryInfo localCloudHistoryInfo;
    history_file_extension.FileExtension localFileExtension;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label559;
      }
      localCloudHistoryInfo = (CloudHistoryInfo)localIterator.next();
      localFileExtension = new history_file_extension.FileExtension();
      try
      {
        localFileExtension.mergeFrom(localCloudHistoryInfo.fileExtInfo);
        switch (localCloudHistoryInfo.sourceType)
        {
        default: 
          atmp.a(this.this$0, localCloudHistoryInfo, null);
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if (!localFileExtension.uint64_session_id.has()) {
          break label585;
        }
      }
    }
    long l = localFileExtension.uint64_session_id.get();
    label559:
    label585:
    for (Object localObject = atmp.a(this.this$0).a().c(l);; localObject = null)
    {
      atmp.a(this.this$0, localCloudHistoryInfo, localObject);
      break label40;
      if (localFileExtension.uint64_session_id.has()) {
        l = localFileExtension.uint64_session_id.get();
      }
      for (localObject = atmp.a(this.this$0).a().c(l);; localObject = null)
      {
        atmp.a(this.this$0, localCloudHistoryInfo, localObject);
        break label40;
        String str = new String(localCloudHistoryInfo.fileIdBytes, Charset.forName("UTF-8"));
        if (localFileExtension.aio_file_extension.uint64_groupe_code.has()) {}
        for (l = localFileExtension.aio_file_extension.uint64_groupe_code.get();; l = -1L)
        {
          if (localFileExtension.aio_file_extension.str_group_file_path.has()) {}
          for (localObject = localFileExtension.aio_file_extension.str_group_file_path.get();; localObject = null)
          {
            if (localFileExtension.aio_file_extension.int32_group_busid.has()) {}
            for (int i = localFileExtension.aio_file_extension.int32_group_busid.get();; i = -1)
            {
              if ((l != -1L) && (i != -1) && ((!TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.isEmpty(str))))
              {
                localObject = ahav.a(apsv.a(atmp.a(this.this$0), l, (String)localObject, str, localCloudHistoryInfo.fileName, localCloudHistoryInfo.fileSize, i));
                atmp.a(this.this$0, localCloudHistoryInfo, localObject);
                break label40;
              }
              atmp.a(this.this$0, localCloudHistoryInfo, null);
              break label40;
              localObject = new String(localCloudHistoryInfo.fileIdBytes, Charset.forName("UTF-8"));
              localObject = atmp.a(this.this$0).a().c((String)localObject);
              atmp.a(this.this$0, localCloudHistoryInfo, localObject);
              break label40;
              localObject = atmp.a(this.this$0).a().c(new String(localCloudHistoryInfo.fileSha, Charset.forName("UTF-8")), localCloudHistoryInfo.fileName);
              atmp.a(this.this$0, localCloudHistoryInfo, localObject);
              break label40;
              localObject = localCloudHistoryInfo.fileIdBytes;
              atgi.a().getCloudItemById((byte[])localObject, new atmq(this, localCloudHistoryInfo));
              break label40;
              break;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.recent.RecentWebNativeStorageManager.5
 * JD-Core Version:    0.7.0.1
 */