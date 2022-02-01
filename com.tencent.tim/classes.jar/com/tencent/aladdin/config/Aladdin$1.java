package com.tencent.aladdin.config;

import com.tencent.aladdin.config.network.AsyncTaskExecutor;

final class Aladdin$1
  implements AsyncTaskExecutor
{
  public void execute(Runnable paramRunnable)
  {
    new Aladdin.SimpleAsyncTask(paramRunnable, null).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.Aladdin.1
 * JD-Core Version:    0.7.0.1
 */