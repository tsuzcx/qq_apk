package com.tencent.open.pcpush;

import java.util.List;

public abstract interface PCPushProxy$OnDownloadListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(PCPushProxy.PkgEntry paramPkgEntry, int paramInt1, String paramString, int paramInt2);
  
  public abstract void a(List paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.pcpush.PCPushProxy.OnDownloadListener
 * JD-Core Version:    0.7.0.1
 */