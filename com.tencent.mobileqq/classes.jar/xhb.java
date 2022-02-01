import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class xhb
  implements xjd
{
  public xhb(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(int paramInt)
  {
    ykq.a(this.a.jdField_a_of_type_JavaLangString, "onPageSelected : position = %d", Integer.valueOf(paramInt));
    int i = this.a.b;
    this.a.b = paramInt;
    Object localObject = this.a.a();
    if (localObject != null)
    {
      localObject = (xho)((xhm)localObject).a(xho.class);
      if ((localObject != null) && (((xho)localObject).b.getVisibility() != 0)) {
        this.a.a(true, true);
      }
    }
    localObject = (xgb)this.a.b(xgb.class);
    if (localObject != null) {
      ((xgb)localObject).a().a(paramInt);
    }
    c(paramInt);
    if (StoryPlayerGroupHolder.a(this.a) != null) {
      StoryPlayerGroupHolder.a(this.a).a(this.a.jdField_a_of_type_Int, i, paramInt);
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (StoryPlayerGroupHolder.a(this.a) != null) {
      StoryPlayerGroupHolder.a(this.a).a(this.a.jdField_a_of_type_Int, paramInt1, paramFloat, paramInt2);
    }
    xgb localxgb = (xgb)this.a.b(xgb.class);
    if (localxgb != null) {
      localxgb.a().a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == 1) && (this.a.d()) && (this.a.c()))
    {
      ((xgb)this.a.b(xgb.class)).d();
      ykq.a(this.a.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onPageScrolled, showLoadingMoreWidget position=%d", Integer.valueOf(this.a.b));
    }
    xgb localxgb = (xgb)this.a.b(xgb.class);
    if (localxgb != null) {
      localxgb.a().b(paramInt);
    }
    if (StoryPlayerGroupHolder.a(this.a) != null) {
      StoryPlayerGroupHolder.a(this.a).a(this.a.jdField_a_of_type_Int, paramInt);
    }
  }
  
  public void c(int paramInt)
  {
    ykq.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected : position = %d", Integer.valueOf(paramInt));
    xhm localxhm = this.a.a();
    if ((localxhm != null) && (TextUtils.equals(StoryPlayerGroupHolder.a(this.a).a().jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString)) && (!localxhm.c()))
    {
      ykq.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected, setSelected => %s", localxhm);
      this.a.a(localxhm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhb
 * JD-Core Version:    0.7.0.1
 */