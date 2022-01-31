package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

class Fragment$2
  extends FragmentContainer
{
  Fragment$2(Fragment paramFragment) {}
  
  public Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    return this.this$0.mHost.instantiate(paramContext, paramString, paramBundle);
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.Fragment.2
 * JD-Core Version:    0.7.0.1
 */