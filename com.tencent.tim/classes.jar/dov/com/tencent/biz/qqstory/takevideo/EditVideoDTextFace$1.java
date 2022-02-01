package dov.com.tencent.biz.qqstory.takevideo;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ayft;
import ayfu;
import ayxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import rar;
import wja;

public class EditVideoDTextFace$1
  implements Runnable
{
  public EditVideoDTextFace$1(ayft paramayft, DynamicTextConfigManager paramDynamicTextConfigManager) {}
  
  public void run()
  {
    if (this.this$0.Qk()) {
      return;
    }
    ayft.a(this.this$0, LayoutInflater.from(this.this$0.getContext()).inflate(2131561826, null));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.y(2131364110);
    EditText localEditText = (EditText)ayft.a(this.this$0).findViewById(2131366209);
    View localView = ayft.a(this.this$0).findViewById(2131370496);
    localEditText.setText(" " + ayft.a(this.this$0));
    localEditText.setSelection(0);
    localEditText.setOnTouchListener(new ayfu(this));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12);
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    int j = wja.dp2px(200.0F, localResources);
    int i;
    if (ayxa.isLiuHaiUseValid())
    {
      int k = this.d.aDH - wja.dp2px(48.0F, localResources);
      i = k;
      if (k <= 0)
      {
        i = k;
        if (k > 300) {
          i = wja.dp2px(66.0F, localResources);
        }
      }
      i += j;
    }
    for (;;)
    {
      localLayoutParams.bottomMargin = i;
      localLayoutParams.leftMargin = wja.dp2px(12.0F, localResources);
      i = localResources.getDisplayMetrics().widthPixels;
      localView.getLayoutParams().width = (i - localLayoutParams.leftMargin * 2);
      localRelativeLayout.addView(ayft.a(this.this$0), localLayoutParams);
      localEditText.setFocusable(true);
      localEditText.setFocusableInTouchMode(true);
      localEditText.requestFocus();
      localEditText.setSelection(0);
      ayft.a(this.this$0, localEditText);
      rar.a("video_edit_text", "exp_textWording", 0, 0, new String[] { this.this$0.cWT, "", "", "" });
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDTextFace.1
 * JD-Core Version:    0.7.0.1
 */