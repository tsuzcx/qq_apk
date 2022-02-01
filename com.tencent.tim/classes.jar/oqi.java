import android.content.Intent;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import java.util.ArrayList;
import java.util.List;

public class oqi
{
  public static abstract interface a
    extends oeu<oqi.b>
  {
    public abstract void a(WSSimpleBaseEvent paramWSSimpleBaseEvent);
    
    public abstract void b(RecyclerView.ViewHolder paramViewHolder, int paramInt);
    
    public abstract void bgg();
    
    public abstract void c(boolean paramBoolean1, boolean paramBoolean2, String paramString);
    
    public abstract List<oqr> d(ArrayList paramArrayList);
    
    public abstract int dJ(int paramInt);
    
    public abstract void doOnPause();
    
    public abstract void doOnResume();
    
    public abstract void initData();
    
    public abstract int rN();
  }
  
  public static abstract interface b
    extends omi<List<oqr>>
  {
    public abstract VideoFeedsRecyclerView a();
    
    public abstract WSPlayerManager a();
    
    public abstract oqb a();
    
    public abstract void ac(Object paramObject);
    
    public abstract void bgh();
    
    public abstract List<oqr> bq();
    
    public abstract String getFrom();
    
    public abstract String getPlayScene();
    
    public abstract void u(int paramInt, Intent paramIntent);
    
    public abstract void uU(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqi
 * JD-Core Version:    0.7.0.1
 */