package com.tencent.gdtad.views.form.framework;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.gdtad.aditem.GdtAd;
import java.lang.ref.WeakReference;
import tly;

public final class GdtFormCommitUtil$1
  implements Runnable
{
  public GdtFormCommitUtil$1(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdFormError localAdFormError = tly.b(this.val$context, this.jdField_b_of_type_ComTencentGdtadAditemGdtAd, this.jdField_b_of_type_ComTencentAdTangramCanvasViewsFormAdFormData);
    if ((this.val$listener == null) || (this.val$listener.get() == null)) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new GdtFormCommitUtil.1.1(this, localAdFormError));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormCommitUtil.1
 * JD-Core Version:    0.7.0.1
 */