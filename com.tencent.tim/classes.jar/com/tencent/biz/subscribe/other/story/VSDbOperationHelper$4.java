package com.tencent.biz.subscribe.other.story;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import ram;
import sfk;

public class VSDbOperationHelper$4
  implements Runnable
{
  public VSDbOperationHelper$4(sfk paramsfk) {}
  
  public void run()
  {
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).add(5, -1);
    long l = ((Calendar)localObject1).getTime().getTime();
    localObject1 = QQStoryContext.a().mi();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      ram.i("Q.videostory.publish.upload.VSDbOperationHelper", "clearLocalCacheData() user id == null");
    }
    for (;;)
    {
      return;
      Object localObject2 = l + "";
      localObject1 = sfk.a(this.this$0).query(VSUploadVideoEntry.class, VSUploadVideoEntry.class.getSimpleName(), false, "uid=? and uploadStatus=? and createTime<?", new String[] { localObject1, "9", localObject2 }, null, null, null, null, null);
      if (localObject1 != null)
      {
        sfk.a(this.this$0, (List)localObject1);
        ram.i("Q.videostory.publish.upload.VSDbOperationHelper", "clearLocalCacheData() clearList.size=" + ((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VSUploadVideoEntry)((Iterator)localObject1).next();
          if (((VSUploadVideoEntry)localObject2).originalEntry != null)
          {
            sfk.a(this.this$0, (VSUploadVideoEntry)localObject2);
            sfk.a(this.this$0).delete(PublishVideoEntry.class.getSimpleName(), "fakeVid=?", new String[] { ((VSUploadVideoEntry)localObject2).fakeId });
            sfk.a(this.this$0).delete(VSUploadVideoEntry.class.getSimpleName(), "fakeId=?", new String[] { ((VSUploadVideoEntry)localObject2).fakeId });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSDbOperationHelper.4
 * JD-Core Version:    0.7.0.1
 */