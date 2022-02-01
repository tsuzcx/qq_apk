import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public abstract interface oet<V extends oer, P extends oeu<V>>
{
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onDestroyView();
  
  public abstract void onViewCreated(View paramView, @Nullable Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oet
 * JD-Core Version:    0.7.0.1
 */