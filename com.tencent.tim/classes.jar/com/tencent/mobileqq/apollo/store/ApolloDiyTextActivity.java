package com.tencent.mobileqq.apollo.store;

import android.annotation.TargetApi;
import android.os.Bundle;

@TargetApi(14)
public class ApolloDiyTextActivity
  extends ApolloGameActivity
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.TAG = "cmgame_process.ApolloDiyTextActivity";
    super.doOnCreate(paramBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloDiyTextActivity
 * JD-Core Version:    0.7.0.1
 */