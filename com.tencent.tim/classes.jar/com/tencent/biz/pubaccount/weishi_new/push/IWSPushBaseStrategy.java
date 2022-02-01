package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcelable;

public abstract interface IWSPushBaseStrategy
  extends Parcelable
{
  public abstract String getAbTest();
  
  public abstract int getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy
 * JD-Core Version:    0.7.0.1
 */