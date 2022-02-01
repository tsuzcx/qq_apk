package com.tencent.mobileqq.activity.richmedia;

import aapm;
import aapn.a;
import android.os.Handler;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import rkc;

public class EditLocalVideoMusicMixRunnable
  implements Runnable
{
  private long Me;
  private long Mf;
  private long Mg;
  private aapn.a a;
  private String bdC;
  private rkc h;
  
  public EditLocalVideoMusicMixRunnable(long paramLong1, long paramLong2, long paramLong3, String paramString, rkc paramrkc, aapn.a parama)
  {
    this.Me = paramLong1;
    this.Mf = paramLong2;
    this.Mg = paramLong3;
    this.bdC = paramString;
    this.h = paramrkc;
    this.a = parama;
  }
  
  private void AC(String paramString)
  {
    if (this.a != null) {
      QzoneHandlerThreadFactory.getMainHandler().post(new EditLocalVideoMusicMixRunnable.2(this, paramString));
    }
  }
  
  private void cvY()
  {
    if (this.a != null) {
      QzoneHandlerThreadFactory.getMainHandler().post(new EditLocalVideoMusicMixRunnable.3(this));
    }
  }
  
  private boolean iS(String paramString)
  {
    if (paramString == null)
    {
      if (this.a != null) {
        QzoneHandlerThreadFactory.getMainHandler().post(new EditLocalVideoMusicMixRunnable.1(this));
      }
      return true;
    }
    return false;
  }
  
  public void run()
  {
    cvY();
    if (this.h.musicType == 0) {
      AC(aapm.ik(this.bdC));
    }
    ArrayList localArrayList;
    String str;
    do
    {
      do
      {
        return;
        localArrayList = new ArrayList();
        localObject1 = aapm.im(this.h.aAR);
        QZLog.d("EditLocalVideoMusicMixR", 2, "step 1, run() returned: " + (String)localObject1);
        localArrayList.add(localObject1);
      } while (iS((String)localObject1));
      str = aapm.il((String)localObject1);
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 2, run() returned: " + str);
      localArrayList.add(str);
    } while (iS(str));
    Object localObject1 = this.h;
    ((rkc)localObject1).start -= 1000;
    if (this.h.start > 0) {}
    for (Object localObject2 = aapm.a(this.h.start, this.h.end - this.h.start, str);; localObject2 = str)
    {
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 3, run() returned: " + (String)localObject2);
      localArrayList.add(localObject2);
      if (iS((String)localObject2)) {
        break;
      }
      localObject1 = localObject2;
      if (this.Mf - this.Me > this.h.duration) {
        localObject1 = aapm.Z((String)localObject2, (int)((this.Mf - this.Me) / this.h.duration + 1L));
      }
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 4, run() returned: " + (String)localObject1);
      localArrayList.add(localObject1);
      if (iS((String)localObject1)) {
        break;
      }
      localObject2 = localObject1;
      if (this.Me > 0L)
      {
        str = aapm.a(this.Me, str, this.h.duration);
        localObject2 = aapm.y(Arrays.asList(new String[] { str, localObject1 }));
        localArrayList.add(str);
      }
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 5, run() returned: " + (String)localObject2);
      localArrayList.add(localObject2);
      if (iS((String)localObject2)) {
        break;
      }
      localObject1 = aapm.f(this.bdC, (String)localObject2, this.Mg);
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 6, run() returned: " + (String)localObject1);
      if (iS((String)localObject1)) {
        break;
      }
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if ((str != null) && (new File(str).delete())) {
          QZLog.d("EditLocalVideoMusicMixR", 2, "step 7, run() clear: " + str);
        }
      }
      AC((String)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixRunnable
 * JD-Core Version:    0.7.0.1
 */