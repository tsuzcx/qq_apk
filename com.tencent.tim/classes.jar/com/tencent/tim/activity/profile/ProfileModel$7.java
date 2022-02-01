package com.tencent.tim.activity.profile;

import acfp;
import android.text.TextUtils;
import atbj;
import com.tencent.mobileqq.data.MessageRecord;
import slz;

public class ProfileModel$7
  implements Runnable
{
  public ProfileModel$7(atbj paramatbj, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.this$0.g();
    if (localObject != null) {}
    for (localObject = acfp.m(2131709917) + slz.a(((MessageRecord)localObject).time, true, false, true).toString();; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.this$0.c.bVm = ((String)localObject);
      }
      if (this.sT) {
        atbj.a(this.this$0, 7, true, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.ProfileModel.7
 * JD-Core Version:    0.7.0.1
 */