package com.tencent.mobileqq.activity.aio.audiopanel;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.widget.CheckBox;
import android.widget.EditText;
import aqmr;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import wqs;

class VoiceTextEditPanel$11
  implements Runnable
{
  VoiceTextEditPanel$11(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void run()
  {
    if (VoiceTextEditPanel.a(this.this$0).get() == 1)
    {
      localSpannableString = VoiceTextEditPanel.a(this.this$0).g();
      VoiceTextEditPanel.a(this.this$0).setText(localSpannableString);
    }
    do
    {
      return;
      if (VoiceTextEditPanel.a(this.this$0).get() == 3)
      {
        localSpannableString = VoiceTextEditPanel.a(this.this$0).b(VoiceTextEditPanel.a(this.this$0));
        VoiceTextEditPanel.a(this.this$0).setText(localSpannableString);
        VoiceTextEditPanel.a(this.this$0).setSelection(VoiceTextEditPanel.a(this.this$0).vU(), VoiceTextEditPanel.a(this.this$0).vU());
        return;
      }
    } while (VoiceTextEditPanel.a(this.this$0).get() != 4);
    if (aqmr.isEmpty(VoiceTextEditPanel.a(this.this$0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEditPanel", 2, "no word state= " + VoiceTextEditPanel.a(this.this$0).get());
      }
      VoiceTextEditPanel.a(this.this$0).setText("");
      VoiceTextEditPanel.a(this.this$0).set(5);
      VoiceTextEditPanel.a(this.this$0).setFocusableInTouchMode(true);
      VoiceTextEditPanel.a(this.this$0).stop();
      if (!VoiceTextEditPanel.a(this.this$0).isChecked()) {
        this.this$0.setSendEnable(false);
      }
      for (;;)
      {
        QQToast.a(this.this$0.getContext(), acfp.m(2131716870), 0).show(this.this$0.getContext().getResources().getDimensionPixelSize(2131299627));
        return;
        this.this$0.setSendEnable(true);
      }
    }
    if (VoiceTextEditPanel.a(this.this$0).hE(VoiceTextEditPanel.a(this.this$0)))
    {
      if (ThemeUtil.isNowThemeIsNight(VoiceTextEditPanel.a(this.this$0), false, null)) {
        VoiceTextEditPanel.a(this.this$0).setTextColor(Color.parseColor("#777777"));
      }
      for (;;)
      {
        VoiceTextEditPanel.a(this.this$0).setText(VoiceTextEditPanel.a(this.this$0));
        VoiceTextEditPanel.a(this.this$0).stop();
        VoiceTextEditPanel.a(this.this$0).setFocusableInTouchMode(true);
        VoiceTextEditPanel.a(this.this$0).set(5);
        VoiceTextEditPanel.a(this.this$0).setSelection(VoiceTextEditPanel.a(this.this$0).length(), VoiceTextEditPanel.a(this.this$0).length());
        return;
        VoiceTextEditPanel.a(this.this$0).setTextColor(Color.parseColor("#03081a"));
      }
    }
    SpannableString localSpannableString = VoiceTextEditPanel.a(this.this$0).b(VoiceTextEditPanel.a(this.this$0));
    VoiceTextEditPanel.a(this.this$0).setText(localSpannableString);
    VoiceTextEditPanel.a(this.this$0).setSelection(VoiceTextEditPanel.a(this.this$0).vU(), VoiceTextEditPanel.a(this.this$0).vU());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel.11
 * JD-Core Version:    0.7.0.1
 */