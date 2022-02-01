import android.support.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

class qvu
  implements pub.a
{
  qvu(qvt paramqvt, pub parampub) {}
  
  public void a(boolean paramBoolean, @Nullable pua parampua)
  {
    ram.e("Q.qqstory.home.data.HomeFeedPresenter", "lbs update %b %s", new Object[] { Boolean.valueOf(paramBoolean), parampua });
    this.a.b(this);
    if (this.this$0.mIsDestroy.get())
    {
      ram.w("Q.qqstory.home.data.HomeFeedPresenter", "is destroy");
      return;
    }
    qvt.a(this.this$0).c = parampua;
    qvt.a(this.this$0).a(null, 0);
    ((qvf)psx.a(11)).c = parampua;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvu
 * JD-Core Version:    0.7.0.1
 */