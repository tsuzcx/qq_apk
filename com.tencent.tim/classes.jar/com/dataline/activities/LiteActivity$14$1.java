package com.dataline.activities;

import ab;
import afeh;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import aqqx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class LiteActivity$14$1
  implements Runnable
{
  public LiteActivity$14$1(ab paramab, boolean paramBoolean, Bitmap paramBitmap) {}
  
  public void run()
  {
    Bundle localBundle;
    if (this.aV)
    {
      localObject = this.this$0.a.getResources().getDrawable(2130839260);
      localBundle = new Bundle();
      localBundle.putBoolean("key_use_rect", true);
      localBundle.putBoolean("key_double_bitmap", true);
    }
    for (Object localObject = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), this.this$0.val$path, "-chatBg-", (Drawable)localObject, new int[] { 0 }, "-chatBg-", localBundle);; localObject = new afeh(this.this$0.a.getResources(), this.n))
    {
      this.this$0.d.setBackgroundDrawable((Drawable)localObject);
      this.this$0.d.setTag(2131361821, this.this$0.val$path);
      this.this$0.d.setTag(2131361820, localObject);
      LiteActivity.a(this.this$0.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.14.1
 * JD-Core Version:    0.7.0.1
 */