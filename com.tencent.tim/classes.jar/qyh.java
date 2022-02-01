import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryUploadProgressView.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.MessageProgressView.a;
import mqq.os.MqqHandler;

public class qyh
  implements poe.b
{
  public MessageProgressView a;
  private String mVid;
  
  public qyh(MessageProgressView paramMessageProgressView)
  {
    this.a = paramMessageProgressView;
  }
  
  private void bu(String paramString, int paramInt)
  {
    this.a.setAnimProgress(paramInt, this.mVid + "_" + hashCode());
  }
  
  public boolean KO()
  {
    return this.a.sd(this.mVid + "_" + hashCode());
  }
  
  public void a(MessageProgressView.a parama)
  {
    this.a.setAnimRunnableListener(parama);
  }
  
  public void bl(String paramString, int paramInt)
  {
    bu(paramString, paramInt);
    if (paramInt >= 100) {
      ThreadManager.getUIHandler().postDelayed(new StoryUploadProgressView.1(this), 500L);
    }
  }
  
  public void init()
  {
    this.a.setRadius(rpq.dip2px(this.a.getContext(), 8.0F), false);
    this.a.setShowCorner(false);
    this.a.setDrawStatus(1);
  }
  
  public void setVid(String paramString)
  {
    this.mVid = paramString;
  }
  
  public void setVisibility(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qyh
 * JD-Core Version:    0.7.0.1
 */