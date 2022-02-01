import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.av.screenshare.ScreenShareQQCustomDialog.1;

public class itr
  extends aqju
{
  private String Qv;
  private boolean Vd;
  private int atF;
  private int mCount;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  
  public itr(Context paramContext, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.mCount = paramInt2;
    this.atF = paramInt2;
    this.Vd = paramBoolean;
    this.Qv = paramString;
  }
  
  private void B(Runnable paramRunnable)
  {
    if (this.mCount > 0)
    {
      this.lBtn.setText(String.format("%s(%d)", new Object[] { this.Qv, Integer.valueOf(this.mCount) }));
      this.mHandler.postDelayed(paramRunnable, 1000L);
      return;
    }
    this.lBtn.setText(this.Qv);
    this.mCount = this.atF;
    this.lBtn.setEnabled(true);
  }
  
  private Runnable b()
  {
    return new ScreenShareQQCustomDialog.1(this);
  }
  
  public void a(Typeface paramTypeface, ColorStateList paramColorStateList)
  {
    this.title.setTypeface(paramTypeface);
    this.rBtn.setTypeface(paramTypeface);
    this.lBtn.setTypeface(paramTypeface);
    this.lBtn.setTextColor(paramColorStateList);
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void onBackPressed() {}
  
  public void show()
  {
    super.show();
    if ((this.Vd) && (this.mCount > 0))
    {
      this.lBtn.setText(String.format("%s(%d)", new Object[] { this.Qv, Integer.valueOf(this.mCount) }));
      this.lBtn.setEnabled(false);
      this.mHandler.postDelayed(b(), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itr
 * JD-Core Version:    0.7.0.1
 */