package moai.fragment.app;

import android.view.View;
import androidx.annotation.Nullable;

class Fragment$2
  extends FragmentContainer
{
  Fragment$2(Fragment paramFragment) {}
  
  @Nullable
  public View onFindViewById(int paramInt)
  {
    if (this.this$0.mView == null) {
      throw new IllegalStateException("Fragment does not have a view");
    }
    return this.this$0.mView.findViewById(paramInt);
  }
  
  public boolean onHasView()
  {
    return this.this$0.mView != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.Fragment.2
 * JD-Core Version:    0.7.0.1
 */