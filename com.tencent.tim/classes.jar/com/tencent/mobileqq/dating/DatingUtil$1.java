package com.tencent.mobileqq.dating;

import afcl;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import aqha;
import aqju;

public final class DatingUtil$1
  implements Runnable
{
  public DatingUtil$1(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = new afcl(this);
    localObject = aqha.a(this.w, 230, null, this.val$content, 0, 2131721303, (DialogInterface.OnClickListener)localObject, null);
    if (localObject != null)
    {
      ((TextView)((aqju)localObject).findViewById(2131365841)).setVisibility(8);
      TextView localTextView = (TextView)((aqju)localObject).findViewById(2131365863);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setMinHeight(aqcx.dip2px(this.w, 35.0F));
      localTextView.setGravity(17);
      ((aqju)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingUtil.1
 * JD-Core Version:    0.7.0.1
 */