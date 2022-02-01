package dov.com.tencent.biz.qqstory.takevideo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import axol;
import aygn;
import aygz;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class EditVideoInteractFace$1
  implements Runnable
{
  public EditVideoInteractFace$1(aygn paramaygn) {}
  
  public void run()
  {
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams;
      try
      {
        Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("EditVideoInteractFace", 0);
        String str = axol.getAppInterface().getCurrentAccountUin();
        int i = ((SharedPreferences)localObject).getInt(str, 0);
        if (i >= 3) {
          return;
        }
        this.this$0.b.changeState(44);
        aygn.a(this.this$0, LayoutInflater.from(this.this$0.getContext()).inflate(2131561833, null));
        aygn.a(this.this$0).findViewById(2131382084).setOnClickListener(this.this$0);
        aygn.a(this.this$0).findViewById(2131376627).setOnClickListener(this.this$0);
        RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.y(2131364110);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.this$0.b.ok == null) {
          break label268;
        }
        if (this.this$0.b.dzj)
        {
          localLayoutParams.bottomMargin = this.this$0.b.ok.getHeight();
          localLayoutParams.addRule(12, -1);
          localRelativeLayout.addView(aygn.a(this.this$0), localLayoutParams);
          aygn.a(this.this$0, true);
          aygn.a(this.this$0).getViewTreeObserver().addOnGlobalLayoutListener(this.this$0);
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putInt(str, i + 1);
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      localLayoutParams.addRule(12, -1);
      continue;
      label268:
      localLayoutParams.addRule(2, 2131364112);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoInteractFace.1
 * JD-Core Version:    0.7.0.1
 */