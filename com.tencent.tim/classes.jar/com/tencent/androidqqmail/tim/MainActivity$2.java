package com.tencent.androidqqmail.tim;

class MainActivity$2
  implements Runnable
{
  MainActivity$2(MainActivity paramMainActivity) {}
  
  public void run()
  {
    TimMailLoginManager.requestA2AndSkey(QMAppInterface.sharedInstance().getAccount(), null, new MainActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MainActivity.2
 * JD-Core Version:    0.7.0.1
 */