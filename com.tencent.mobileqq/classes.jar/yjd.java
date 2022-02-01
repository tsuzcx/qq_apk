import android.support.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

class yjd
  implements wri
{
  yjd(yjc paramyjc, wrf paramwrf) {}
  
  public void a(boolean paramBoolean, @Nullable wre paramwre)
  {
    yqp.e("Q.qqstory.home.data.HomeFeedPresenter", "lbs update %b %s", new Object[] { Boolean.valueOf(paramBoolean), paramwre });
    this.jdField_a_of_type_Wrf.b(this);
    if (this.jdField_a_of_type_Yjc.a.get())
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "is destroy");
      return;
    }
    yjc.a(this.jdField_a_of_type_Yjc).a = paramwre;
    yjc.a(this.jdField_a_of_type_Yjc).a(null, 0);
    ((yij)wpm.a(11)).a = paramwre;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjd
 * JD-Core Version:    0.7.0.1
 */