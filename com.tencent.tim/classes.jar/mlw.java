import android.view.ViewGroup;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;

public abstract interface mlw
{
  public abstract void a(int paramInt, ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void a(String paramString, ViewGroup paramViewGroup);
  
  public abstract void a(mlt parammlt);
  
  public abstract void a(mlu parammlu, mlu.a parama);
  
  public abstract long getVideoDuration();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mlw
 * JD-Core Version:    0.7.0.1
 */