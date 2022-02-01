package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

final class QQLiveImage$5
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
            localQQLiveImage.recyleFor2Background();
            QLog.i(QQLiveImage.TAG, 1, "recyleFor2Background().... i " + i + ", ID: " + localQQLiveImage.ID);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QQLiveImage.TAG, 2, "recyleFor2Background()", localException);
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
 * Qualified Name:     com.tencent.image.QQLiveImage.5
 * JD-Core Version:    0.7.0.1
 */