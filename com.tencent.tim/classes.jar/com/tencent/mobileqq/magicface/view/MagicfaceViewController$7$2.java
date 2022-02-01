package com.tencent.mobileqq.magicface.view;

import aixt;
import aiyr;
import aiyu;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.BaseApplication;

public class MagicfaceViewController$7$2
  implements Runnable
{
  public MagicfaceViewController$7$2(aiyu paramaiyu, aixt paramaixt) {}
  
  public void run()
  {
    
    if (this.a.val$type == 1)
    {
      ((View)this.a.this$0.b).setBackgroundColor(0);
      this.a.this$0.dvw();
    }
    if ((this.b != null) && ("gravity".equalsIgnoreCase(this.b.bPV)) && (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(BaseApplicationImpl.getContext().getString(2131697091), false))) {
      this.a.this$0.c.turnOnShake();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.2
 * JD-Core Version:    0.7.0.1
 */