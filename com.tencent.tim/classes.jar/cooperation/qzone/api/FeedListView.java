package cooperation.qzone.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.List;

public class FeedListView
  extends XListView
{
  private boolean doE;
  
  public FeedListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FeedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FeedListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void RR() {}
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong) {}
  
  public void a(c paramc) {}
  
  public boolean a(String paramString, c paramc)
  {
    return false;
  }
  
  public boolean aLv()
  {
    return this.doE;
  }
  
  public void h(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public int hp()
  {
    return 0;
  }
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void scrollToTop() {}
  
  public void setExpandHead(a parama) {}
  
  public void setFeedUinChangedListener(b paramb) {}
  
  public void setLongClickValid(boolean paramBoolean)
  {
    this.doE = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void hide();
    
    public abstract void show();
  }
  
  public static abstract interface b
  {
    public abstract void J(String paramString, List<Long> paramList);
  }
  
  public static abstract interface c
  {
    public abstract void yA(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.api.FeedListView
 * JD-Core Version:    0.7.0.1
 */