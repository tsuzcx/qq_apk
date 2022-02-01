package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

final class QQLiveImage$7
  implements Runnable
{
  public void run()
  {
    try
    {
      QQLiveImage.mLockForImageList.lock();
      if (QQLiveImage.access$200() != null)
      {
        int i = 0;
        while (i < QQLiveImage.access$200().size())
        {
          QQLiveImage localQQLiveImage = (QQLiveImage)QQLiveImage.access$200().get(i);
          if (localQQLiveImage != null)
          {
            localQQLiveImage.pause();
            QLog.i(QQLiveImage.TAG, 1, "pauseAll().... i " + i + ", ID: " + localQQLiveImage.ID);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QQLiveImage.TAG, 2, "pauseAll()", localException);
      }
      return;
    }
    finally
    {
      QQLiveImage.mLockForImageList.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.7
 * JD-Core Version:    0.7.0.1
 */