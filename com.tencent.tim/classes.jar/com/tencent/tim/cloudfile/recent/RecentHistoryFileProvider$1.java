package com.tencent.tim.cloudfile.recent;

import android.text.TextUtils;
import apsv;
import atgi;
import atmn;
import attf;
import audx;
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

public class RecentHistoryFileProvider$1
  implements Runnable
{
  RecentHistoryFileProvider$1(RecentHistoryFileProvider paramRecentHistoryFileProvider, List paramList) {}
  
  public void run()
  {
    if ((this.KG == null) || (this.KG.size() <= 0)) {
      return;
    }
    Iterator localIterator = this.KG.iterator();
    label31:
    CloudHistoryInfo localCloudHistoryInfo;
    history_file_extension.FileExtension localFileExtension;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label551;
      }
      localCloudHistoryInfo = (CloudHistoryInfo)localIterator.next();
      localFileExtension = new history_file_extension.FileExtension();
      try
      {
        localFileExtension.mergeFrom(localCloudHistoryInfo.fileExtInfo);
        switch (localCloudHistoryInfo.sourceType)
        {
        default: 
          RecentHistoryFileProvider.a(this.this$0, localCloudHistoryInfo, null);
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if (!localFileExtension.uint64_session_id.has()) {
          break label577;
        }
      }
    }
    long l = localFileExtension.uint64_session_id.get();
    label551:
    label577:
    for (Object localObject = RecentHistoryFileProvider.a(this.this$0).a().c(l);; localObject = null)
    {
      RecentHistoryFileProvider.a(this.this$0, localCloudHistoryInfo, localObject);
      break label31;
      if (localFileExtension.uint64_session_id.has()) {
        l = localFileExtension.uint64_session_id.get();
      }
      for (localObject = RecentHistoryFileProvider.a(this.this$0).a().c(l);; localObject = null)
      {
        RecentHistoryFileProvider.a(this.this$0, localCloudHistoryInfo, localObject);
        break label31;
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
                localObject = audx.a(apsv.a(RecentHistoryFileProvider.a(this.this$0), l, (String)localObject, str, localCloudHistoryInfo.fileName, localCloudHistoryInfo.fileSize, i));
                RecentHistoryFileProvider.a(this.this$0, localCloudHistoryInfo, localObject);
                break label31;
              }
              RecentHistoryFileProvider.a(this.this$0, localCloudHistoryInfo, null);
              break label31;
              localObject = new String(localCloudHistoryInfo.fileIdBytes, Charset.forName("UTF-8"));
              localObject = RecentHistoryFileProvider.a(this.this$0).a().c((String)localObject);
              RecentHistoryFileProvider.a(this.this$0, localCloudHistoryInfo, localObject);
              break label31;
              localObject = RecentHistoryFileProvider.a(this.this$0).a().c(new String(localCloudHistoryInfo.fileSha, Charset.forName("UTF-8")), localCloudHistoryInfo.fileName);
              RecentHistoryFileProvider.a(this.this$0, localCloudHistoryInfo, localObject);
              break label31;
              localObject = localCloudHistoryInfo.fileIdBytes;
              atgi.a().getCloudItemById((byte[])localObject, new atmn(this, localCloudHistoryInfo));
              break label31;
              break;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.recent.RecentHistoryFileProvider.1
 * JD-Core Version:    0.7.0.1
 */