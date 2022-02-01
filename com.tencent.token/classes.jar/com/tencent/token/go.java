package com.tencent.token;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class go
  extends gh
{
  private int j;
  private int k;
  private LayoutInflater l;
  
  @Deprecated
  public go(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.k = paramInt;
    this.j = paramInt;
    this.l = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.l.inflate(this.j, paramViewGroup, false);
  }
  
  public final View b(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.l.inflate(this.k, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.go
 * JD-Core Version:    0.7.0.1
 */