import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.model.Comments;

class ajzs
  implements ajvz.b
{
  ajzs(ajzr paramajzr) {}
  
  public void a(Comments paramComments)
  {
    if (ajzr.a(this.a) != null)
    {
      ajzr.a(this.a);
      ajzr.a(this.a).b(paramComments);
      ajzr.a(this.a).hideLoading();
    }
  }
  
  public void dzN()
  {
    if (ajzr.a(this.a) != null)
    {
      ajzr.a(this.a).showToast(BaseApplicationImpl.getApplication().getString(2131698611));
      ajzr.a(this.a).hideLoading();
      ajzr.a(this.a).dzU();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzs
 * JD-Core Version:    0.7.0.1
 */