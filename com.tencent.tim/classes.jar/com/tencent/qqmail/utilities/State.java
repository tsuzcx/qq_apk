package com.tencent.qqmail.utilities;

import android.os.Message;

public class State
  implements IState
{
  public void enter() {}
  
  public void exit() {}
  
  public String getName()
  {
    String str = getClass().getName();
    return str.substring(str.lastIndexOf('$') + 1);
  }
  
  public boolean processMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.State
 * JD-Core Version:    0.7.0.1
 */