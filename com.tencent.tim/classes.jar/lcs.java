import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public abstract class lcs
{
  @NotNull
  private lct a;
  private boolean ajo;
  private boolean ajp;
  @NotNull
  private String name = getClass().getSimpleName();
  
  public lcs(@NotNull lct paramlct, @NotNull String paramString)
  {
    this.a = paramlct;
    this.name = paramString;
  }
  
  public boolean BN()
  {
    return this.ajp;
  }
  
  public void aKl()
  {
    this.ajp = true;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.name + ") onShowSelf");
    }
  }
  
  public void aKm()
  {
    this.ajp = false;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.name + ") onHideSelf");
    }
  }
  
  protected abstract void aKn();
  
  protected abstract void aKo();
  
  public boolean isResumed()
  {
    return this.ajo;
  }
  
  @UiThread
  public void nn(boolean paramBoolean)
  {
    this.a.a(this, paramBoolean);
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.name + ") onCreate");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.name + ") onDestroy");
    }
  }
  
  public void onPause()
  {
    this.ajo = false;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.name + ") onPause");
    }
  }
  
  public void onResume()
  {
    this.ajo = true;
    if (QLog.isColorLevel()) {
      QLog.d("BasePopupStep", 2, "(" + this.name + ") onResume");
    }
  }
  
  @NonNull
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcs
 * JD-Core Version:    0.7.0.1
 */