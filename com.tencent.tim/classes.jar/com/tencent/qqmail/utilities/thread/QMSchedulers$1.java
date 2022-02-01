package com.tencent.qqmail.utilities.thread;

import com.tencent.qqmail.utilities.qmnetwork.NetworkManager.Task;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import java.util.Comparator;

final class QMSchedulers$1
  implements Comparator<Runnable>
{
  public int compare(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if (((paramRunnable1 instanceof NetworkManager.Task)) && ((paramRunnable2 instanceof NetworkManager.Task))) {
      return ((NetworkManager.Task)paramRunnable1).request.priorityInteger - ((NetworkManager.Task)paramRunnable2).request.priorityInteger;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.thread.QMSchedulers.1
 * JD-Core Version:    0.7.0.1
 */