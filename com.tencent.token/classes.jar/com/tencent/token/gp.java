package com.tencent.token;

import java.util.concurrent.ThreadFactory;

class gp
  implements ThreadFactory
{
  gp(String paramString, boolean paramBoolean) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, this.a);
    paramRunnable.setDaemon(this.b);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gp
 * JD-Core Version:    0.7.0.1
 */