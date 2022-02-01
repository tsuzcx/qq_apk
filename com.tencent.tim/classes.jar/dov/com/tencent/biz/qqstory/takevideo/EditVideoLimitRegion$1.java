package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import anjx;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import mqq.os.MqqHandler;

public final class EditVideoLimitRegion$1
  implements Runnable
{
  public EditVideoLimitRegion$1(StoryGuideLineView paramStoryGuideLineView) {}
  
  public void run()
  {
    Object localObject1 = anjx.a().b("CMD_GET_CURRENT_NICK_NAME", null);
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject2 = anjx.a().b("CMD_GET_CURRENT_USER_HEAD", null);
      if (localObject2 == null) {
        localObject2 = "";
      }
      try
      {
        for (;;)
        {
          localObject2 = SafeBitmapFactory.decodeFile((String)localObject2);
          Bitmap localBitmap = aqhu.r((Bitmap)localObject2, 50, 50);
          BaseApplicationImpl.sImageCache.put("story_user_avatar", localBitmap);
          ((Bitmap)localObject2).recycle();
          ThreadManager.getUIHandler().post(new EditVideoLimitRegion.1.1(this, (String)localObject1, localBitmap));
          return;
          localObject1 = ((Bundle)localObject1).getString("VALUE_GET_CURRENT_NICK_NAME");
          break;
          localObject2 = ((Bundle)localObject2).getString("VALUE_GET_CURRENT_USER_HEAD");
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "user Head Path can't read");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoLimitRegion.1
 * JD-Core Version:    0.7.0.1
 */