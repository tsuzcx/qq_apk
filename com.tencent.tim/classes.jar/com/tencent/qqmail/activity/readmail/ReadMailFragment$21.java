package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.namelist.watcher.AddNameListWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$21
  implements AddNameListWatcher
{
  ReadMailFragment$21(ReadMailFragment paramReadMailFragment) {}
  
  public void onBefore(int paramInt1, int paramInt2, String[] paramArrayOfString) {}
  
  public void onError(int paramInt1, int paramInt2, String[] paramArrayOfString, QMNetworkError paramQMNetworkError)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("addNameList onError :");
    if (paramQMNetworkError == null) {}
    for (paramArrayOfString = "";; paramArrayOfString = paramQMNetworkError.toString())
    {
      QMLog.log(6, "ReadMailFragment", paramArrayOfString);
      ReadMailFragment.access$8100(this.this$0, new ReadMailFragment.21.2(this));
      return;
    }
  }
  
  public void onSuccess(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    ReadMailFragment.access$8000(this.this$0, new ReadMailFragment.21.1(this, paramInt2, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.21
 * JD-Core Version:    0.7.0.1
 */