package com.tencent.mobileqq.troop.activity;

import android.content.res.Resources;
import android.os.Bundle;
import aoua;
import aoub;
import aouc;
import apvn;
import com.tencent.mobileqq.data.Setting;
import com.tencent.widget.Gallery;

public class TroopAvatarWallPreviewActivity$2$1
  implements Runnable
{
  TroopAvatarWallPreviewActivity$2$1(TroopAvatarWallPreviewActivity.2 param2, Setting paramSetting) {}
  
  public void run()
  {
    if (this.a.this$0.isFinishing()) {
      return;
    }
    this.a.this$0.a.Ua(this.a.this$0.cmY);
    this.a.this$0.a.mW(this.a.this$0.Hj);
    if (this.a.this$0.BD != null) {
      this.a.this$0.a.mX(this.a.this$0.BD);
    }
    this.a.this$0.a.a(this.a.this$0.mTroopUin, this.b);
    apvn localapvn = this.a.this$0.a;
    if (!this.a.val$bundle.getBoolean("from_photo_wall", false)) {}
    for (boolean bool = true;; bool = false)
    {
      localapvn.So(bool);
      this.a.this$0.a.Sp(this.a.val$bundle.getBoolean("is_use_path", false));
      this.a.this$0.mIndex = this.a.val$bundle.getInt("index", -1);
      this.a.this$0.b.setAdapter(this.a.this$0.a);
      this.a.this$0.b.setSpacing(this.a.this$0.getResources().getDimensionPixelSize(2131297406));
      this.a.this$0.b.setSelection(this.a.this$0.mIndex);
      this.a.this$0.b.setOnItemClickListener(new aoua(this));
      this.a.this$0.b.setOnItemSelectedListener(new aoub(this));
      this.a.this$0.b.setOnItemLongClickListener(new aouc(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2.1
 * JD-Core Version:    0.7.0.1
 */