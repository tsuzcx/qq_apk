package com.tencent.mobileqq.model;

import com.tencent.mobileqq.data.ChatBackgroundInfo;
import java.util.ArrayList;
import mqq.manager.Manager;

public abstract interface ChatBackgroundManager
  extends Manager
{
  public abstract ArrayList a();
  
  public abstract void a(ChatBackgroundInfo paramChatBackgroundInfo);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract ArrayList b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager
 * JD-Core Version:    0.7.0.1
 */