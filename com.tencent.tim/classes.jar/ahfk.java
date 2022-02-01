import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;

public class ahfk
  implements SplashScreen
{
  private OnFirstFrameRenderedListener a;
  
  public ahfk(OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener)
  {
    this.a = paramOnFirstFrameRenderedListener;
  }
  
  @Nullable
  public View createSplashView(@NonNull Context paramContext, @Nullable Bundle paramBundle)
  {
    return LayoutInflater.from(paramContext).inflate(2131561078, null);
  }
  
  public boolean doesSplashViewRememberItsTransition()
  {
    return false;
  }
  
  @Nullable
  public Bundle saveSplashScreenState()
  {
    return null;
  }
  
  public void transitionToFlutter(@NonNull Runnable paramRunnable)
  {
    paramRunnable.run();
    if (this.a != null) {
      this.a.onFirstFrameRendered();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfk
 * JD-Core Version:    0.7.0.1
 */