package dov.com.qq.im.aeeditor.arch;

import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import axji;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import dov.com.qq.im.aeeditor.view.ProgressView;

public abstract class AEEditorBaseFragment
  extends PublicBaseFragment
{
  private static final String TAG = AEEditorBaseFragment.class.getSimpleName();
  protected ProgressView a;
  private axji b;
  public String cVh;
  protected Dialog g;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  
  @NonNull
  public axji a()
  {
    if (this.b == null) {
      throw new RuntimeException("moduleManager not set");
    }
    return this.b;
  }
  
  public void a(axji paramaxji)
  {
    this.b = paramaxji;
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (getActivity() == null) {
      return;
    }
    FragmentActivity localFragmentActivity = getActivity();
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.postDelayed(new AEEditorBaseFragment.1(this, localFragmentActivity, paramOnDismissListener, paramBoolean, paramCharSequence), paramLong);
  }
  
  public boolean aOM()
  {
    return false;
  }
  
  public void bpm()
  {
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.post(new AEEditorBaseFragment.2(this));
  }
  
  public void doOnBackPressed() {}
  
  public abstract String getModuleId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment
 * JD-Core Version:    0.7.0.1
 */