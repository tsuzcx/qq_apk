import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.2;

public class ayej
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ayej(EditProviderPart.2 param2) {}
  
  @TargetApi(16)
  public void onGlobalLayout()
  {
    if ((this.a.this$0.a == null) || (ayeh.a(this.a.this$0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditProviderPart", 2, "initTransitionRecommendView onGlobalLayout null");
      }
      return;
    }
    Object localObject = ayeh.a(this.a.this$0).getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
    }
    localObject = this.a.this$0.b.cN();
    if (localObject != null)
    {
      int i = ((View)localObject).getLeft();
      int j = ((View)localObject).getWidth() / 2;
      int k = ayeh.a(this.a.this$0).getWidth() / 2;
      ayeh.a(this.a.this$0).setX(j + i - k);
    }
    localObject = (GridView)this.a.this$0.y(2131380145);
    ((GridView)localObject).setNumColumns(3);
    ((GridView)localObject).setSelector(new ColorDrawable(0));
    ((GridView)localObject).setClipToPadding(false);
    ((GridView)localObject).setVerticalScrollBarEnabled(false);
    ((GridView)localObject).setHorizontalScrollBarEnabled(false);
    ((GridView)localObject).setOverScrollMode(2);
    axpg localaxpg = new axpg(this.a.this$0.getContext(), this.a.this$0.RP());
    localaxpg.dvN = true;
    localaxpg.setData(this.a.Nu);
    ((GridView)localObject).setAdapter(localaxpg);
    ((GridView)localObject).setOnItemClickListener(new ayek(this, localaxpg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayej
 * JD-Core Version:    0.7.0.1
 */