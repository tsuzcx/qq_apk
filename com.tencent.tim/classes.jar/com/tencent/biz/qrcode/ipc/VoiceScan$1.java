package com.tencent.biz.qrcode.ipc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import aqha;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import rwi;
import rwj;

public class VoiceScan$1
  implements Runnable
{
  public VoiceScan$1(rwi paramrwi) {}
  
  public void run()
  {
    SpannableString localSpannableString = new SpannableString(rwi.a(this.this$0).getString(2131700600));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(rwi.a(this.this$0).getResources().getColor(2131165750), rwi.a(this.this$0).getResources().getColor(2131165758)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    rwi.a(this.this$0, aqha.a(rwi.a(this.this$0), rwi.a(this.this$0).getString(2131700599), localSpannableString, 0, 2131691042, null, null, new rwj(this)));
    rwi.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.VoiceScan.1
 * JD-Core Version:    0.7.0.1
 */