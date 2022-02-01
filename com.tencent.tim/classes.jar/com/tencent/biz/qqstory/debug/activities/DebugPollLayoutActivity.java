package com.tencent.biz.qqstory.debug.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import rpg;
import rpg.a;

public class DebugPollLayoutActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558482);
    paramBundle = rpg.a(this, 1, 1, null);
    ((FrameLayout)findViewById(2131365322)).addView(paramBundle.getView());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.debug.activities.DebugPollLayoutActivity
 * JD-Core Version:    0.7.0.1
 */