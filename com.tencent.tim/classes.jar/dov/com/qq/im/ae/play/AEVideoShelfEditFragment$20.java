package dov.com.qq.im.ae.play;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import axih.b;

class AEVideoShelfEditFragment$20
  implements Runnable
{
  public void run()
  {
    if (AEVideoShelfEditFragment.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = AEVideoShelfEditFragment.a(this.this$0).getLayoutManager();
        } while (!(localObject instanceof LinearLayoutManager));
        int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
        localObject = AEVideoShelfEditFragment.a(this.this$0).getChildAt(this.val$position - i);
      } while (localObject == null);
      localObject = (axih.b)AEVideoShelfEditFragment.a(this.this$0).getChildViewHolder((View)localObject);
    } while (localObject == null);
    ((axih.b)localObject).eKy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfEditFragment.20
 * JD-Core Version:    0.7.0.1
 */