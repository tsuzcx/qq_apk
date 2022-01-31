import com.tencent.biz.qqstory.msgTabNode.view.viewholder.MsgNodeViewHolder.1.1;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class vbp
  implements URLDrawable.URLDrawableListener
{
  vbp(vbo paramvbo) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ThreadManager.getUIHandler().postDelayed(new MsgNodeViewHolder.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vbp
 * JD-Core Version:    0.7.0.1
 */