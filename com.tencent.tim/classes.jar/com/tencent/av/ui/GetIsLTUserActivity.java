package com.tencent.av.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;

@Deprecated
public class GetIsLTUserActivity
  extends BaseActivity
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    setResult(-1, new Intent());
    finish();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GetIsLTUserActivity
 * JD-Core Version:    0.7.0.1
 */