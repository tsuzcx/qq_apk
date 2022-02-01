package com.tencent.biz.subscribe.utils;

import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sgm;
import sgm.a;
import sgp;

public class AnimationDrawableFactory$4
  implements Runnable
{
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.aLl)
    {
      localObject1 = localObject2;
      if (sgm.b(this.this$0) != null)
      {
        localObject1 = localObject2;
        if (sgm.b(this.this$0).get(this.val$dirPath) != null)
        {
          QLog.i("AnimationDrawableFactory", 2, "animationDrawable use cache" + this.val$dirPath);
          localObject1 = (QQAnimationDrawable)sgm.b(this.this$0).get(this.val$dirPath);
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      Object localObject3 = new File(this.val$dirPath);
      localObject2 = localObject1;
      if (((File)localObject3).exists())
      {
        localObject2 = localObject1;
        if (((File)localObject3).isDirectory())
        {
          QLog.i("AnimationDrawableFactory", 2, "exist Animation Pic!");
          localObject3 = ((File)localObject3).listFiles();
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            if (localObject3.length > 0)
            {
              Arrays.sort((Object[])localObject3, new sgp(this));
              int i = this.bwJ / localObject3.length;
              QLog.i("AnimationDrawableFactory", 2, "createFromDirectory perDuration=" + i);
              localObject1 = new ArrayList();
              int j = localObject3.length;
              i = 0;
              while (i < j)
              {
                ((List)localObject1).add(localObject3[i].getPath());
                i += 1;
              }
              localObject2 = new QQAnimationDrawable();
              ((QQAnimationDrawable)localObject2).Q((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]));
              sgm.b(this.this$0).put(this.val$dirPath, localObject2);
            }
          }
        }
      }
    }
    if (this.a != null)
    {
      if (localObject2 != null) {
        this.a.a((QQAnimationDrawable)localObject2);
      }
    }
    else {
      return;
    }
    this.a.bxN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.AnimationDrawableFactory.4
 * JD-Core Version:    0.7.0.1
 */