package moai.fragment.app;

import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

public abstract class FragmentContainer
{
  @Nullable
  public abstract View onFindViewById(@IdRes int paramInt);
  
  public abstract boolean onHasView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentContainer
 * JD-Core Version:    0.7.0.1
 */