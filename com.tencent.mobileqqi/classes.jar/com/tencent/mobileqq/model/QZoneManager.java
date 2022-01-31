package com.tencent.mobileqq.model;

import mqq.manager.Manager;

public abstract interface QZoneManager
  extends Manager
{
  public static final int a = 1;
  public static final int b = 2;
  
  public abstract int a(QZoneManager.FeedType paramFeedType);
  
  public abstract String a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(QZoneManager.FeedType paramFeedType);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.model.QZoneManager
 * JD-Core Version:    0.7.0.1
 */