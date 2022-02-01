import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.c;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.d;

public abstract interface nwn
  extends VideoPlayManager.d
{
  public abstract void a(VideoPlayManager.c paramc);
  
  public abstract void a(VideoPlayManager paramVideoPlayManager);
  
  public abstract void ai(int paramInt, boolean paramBoolean);
  
  public abstract void bbF();
  
  public abstract void bbG();
  
  public abstract boolean isFullScreen();
  
  public abstract ViewGroup n();
  
  public abstract void onDestory();
  
  public abstract void setControlType(int paramInt);
  
  public abstract void setEndWithLastFrame(boolean paramBoolean);
  
  public abstract void setEventListener(nwn.a parama);
  
  public abstract void setFullScreenDisable(boolean paramBoolean);
  
  public abstract void ul(int paramInt);
  
  public static abstract interface a
  {
    public abstract void qi(boolean paramBoolean);
    
    public abstract void qj(boolean paramBoolean);
    
    public abstract void um(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwn
 * JD-Core Version:    0.7.0.1
 */