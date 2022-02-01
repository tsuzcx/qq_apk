package com.tencent.biz.subscribe.bizdapters;

import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import riw;
import ryy;
import sat;
import say;
import saz;
import sgm;
import shp;

public class DetailBaseBlock$4$1
  implements Runnable
{
  public DetailBaseBlock$4$1(say paramsay, AnimationDrawable paramAnimationDrawable) {}
  
  public void run()
  {
    int i;
    try
    {
      Object localObject = LayoutInflater.from(sat.h(this.a.this$0)).inflate(2131558858, null, false);
      ((View)localObject).measure(0, 0);
      ((View)localObject).getMeasuredWidth();
      i = ((View)localObject).getMeasuredHeight();
      ImageView localImageView = (ImageView)((View)localObject).findViewById(2131369842);
      sat.a(this.a.this$0, new PopViewAnimationDrawableHelper(this.val$animationDrawable));
      sat.a(this.a.this$0).a(new saz(this));
      this.val$animationDrawable.setOneShot(true);
      localImageView.setImageDrawable(this.val$animationDrawable);
      this.a.this$0.mPopupWindow = new PopupWindow((View)localObject, -2, -2);
      this.a.this$0.mPopupWindow.setOutsideTouchable(true);
      this.a.this$0.mPopupWindow.setTouchable(true);
      localObject = new int[2];
      if (this.a.this$0.a == null) {
        return;
      }
      if (this.a.this$0.a.Mx())
      {
        QLog.i(sat.TAG, 1, "mCommentBottomBar.isPraised");
        return;
      }
      if ((this.a.this$0.a.My()) || (this.a.this$0.a.Mz()))
      {
        sat.b(this.a.this$0, true);
        QLog.i(sat.TAG, 1, "isShowCommentList or isAddCommentMode");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    int j = riw.getWindowScreenHeight(sat.i(this.a.this$0));
    this.a.this$0.mPopupWindow.showAtLocation(this.a.this$0.a, 53, -riw.dip2px(sat.j(this.a.this$0), 32.0F), j - i - this.a.this$0.a.getMeasuredHeight() + riw.dip2px(sat.k(this.a.this$0), 10.0F));
    sat.a(this.a.this$0).start();
    sat.b(this.a.this$0, false);
    shp.a().j(sat.l(this.a.this$0), "subscribe_sp_key_show_praise_guide", 1);
    sgm.a().tf((String)ryy.eQ.get("praise_guide_pics"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.4.1
 * JD-Core Version:    0.7.0.1
 */