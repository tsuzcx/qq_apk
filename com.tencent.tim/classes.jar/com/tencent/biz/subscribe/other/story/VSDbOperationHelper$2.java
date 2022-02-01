package com.tencent.biz.subscribe.other.story;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;
import mqq.os.MqqHandler;
import ram;
import sfk;
import sfk.a;

public class VSDbOperationHelper$2
  implements Runnable
{
  public VSDbOperationHelper$2(sfk paramsfk, String paramString, sfk.a parama) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.wb)) {
      ram.i("Q.videostory.publish.upload.VSDbOperationHelper", "getFailTaskFromDb() user id == null");
    }
    for (;;)
    {
      return;
      Object localObject = this.wb;
      localObject = sfk.a(this.this$0).query(VSUploadVideoEntry.class, VSUploadVideoEntry.class.getSimpleName(), false, "uid=? and uploadStatus<>?", new String[] { localObject, "9" }, null, null, null, null, null);
      sfk.a(this.this$0, (List)localObject);
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        ram.i("Q.videostory.publish.upload.VSDbOperationHelper", "getFailTaskFromDb() db fail list is null");
      }
      while (this.a != null)
      {
        ThreadManager.getUIHandler().post(new VSDbOperationHelper.2.1(this, (List)localObject));
        return;
        ram.i("Q.videostory.publish.upload.VSDbOperationHelper", "getFailTaskFromDb() db fail list size=" + ((List)localObject).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSDbOperationHelper.2
 * JD-Core Version:    0.7.0.1
 */