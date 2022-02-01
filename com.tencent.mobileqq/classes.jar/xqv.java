import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class xqv
  implements xsx
{
  public xqv(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(int paramInt)
  {
    yuk.a(this.a.jdField_a_of_type_JavaLangString, "onPageSelected : position = %d", Integer.valueOf(paramInt));
    int i = this.a.b;
    this.a.b = paramInt;
    Object localObject = this.a.a();
    if (localObject != null)
    {
      localObject = (xri)((xrg)localObject).a(xri.class);
      if ((localObject != null) && (((xri)localObject).b.getVisibility() != 0)) {
        this.a.a(true, true);
      }
    }
    localObject = (xpv)this.a.b(xpv.class);
    if (localObject != null) {
      ((xpv)localObject).a().a(paramInt);
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
    xpv localxpv = (xpv)this.a.b(xpv.class);
    if (localxpv != null) {
      localxpv.a().a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == 1) && (this.a.d()) && (this.a.c()))
    {
      ((xpv)this.a.b(xpv.class)).d();
      yuk.a(this.a.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onPageScrolled, showLoadingMoreWidget position=%d", Integer.valueOf(this.a.b));
    }
    xpv localxpv = (xpv)this.a.b(xpv.class);
    if (localxpv != null) {
      localxpv.a().b(paramInt);
    }
    if (StoryPlayerGroupHolder.a(this.a) != null) {
      StoryPlayerGroupHolder.a(this.a).a(this.a.jdField_a_of_type_Int, paramInt);
    }
  }
  
  public void c(int paramInt)
  {
    yuk.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected : position = %d", Integer.valueOf(paramInt));
    xrg localxrg = this.a.a();
    if ((localxrg != null) && (TextUtils.equals(StoryPlayerGroupHolder.a(this.a).a().jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString)) && (!localxrg.c()))
    {
      yuk.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected, setSelected => %s", localxrg);
      this.a.a(localxrg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqv
 * JD-Core Version:    0.7.0.1
 */