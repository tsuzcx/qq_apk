package com.tencent.qqmail.utilities;

import android.os.Message;

public abstract interface IState
{
  public static final boolean HANDLED = true;
  public static final boolean NOT_HANDLED = false;
  
  public abstract void enter();
  
  public abstract void exit();
  
  public abstract String getName();
  
  public abstract boolean processMessage(Message paramMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.IState
 * JD-Core Version:    0.7.0.1
 */