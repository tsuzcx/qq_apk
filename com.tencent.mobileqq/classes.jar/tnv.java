import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class tnv
  implements tpx
{
  public tnv(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(int paramInt)
  {
    urk.a(this.a.jdField_a_of_type_JavaLangString, "onPageSelected : position = %d", Integer.valueOf(paramInt));
    int i = this.a.b;
    this.a.b = paramInt;
    Object localObject = this.a.a();
    if (localObject != null)
    {
      localObject = (toi)((tog)localObject).a(toi.class);
      if ((localObject != null) && (((toi)localObject).b.getVisibility() != 0)) {
        this.a.a(true, true);
      }
    }
    localObject = (tmv)this.a.b(tmv.class);
    if (localObject != null) {
      ((tmv)localObject).a().a(paramInt);
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
    tmv localtmv = (tmv)this.a.b(tmv.class);
    if (localtmv != null) {
      localtmv.a().a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == 1) && (this.a.d()) && (this.a.c()))
    {
      ((tmv)this.a.b(tmv.class)).d();
      urk.a(this.a.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onPageScrolled, showLoadingMoreWidget position=%d", Integer.valueOf(this.a.b));
    }
    tmv localtmv = (tmv)this.a.b(tmv.class);
    if (localtmv != null) {
      localtmv.a().b(paramInt);
    }
    if (StoryPlayerGroupHolder.a(this.a) != null) {
      StoryPlayerGroupHolder.a(this.a).a(this.a.jdField_a_of_type_Int, paramInt);
    }
  }
  
  public void c(int paramInt)
  {
    urk.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected : position = %d", Integer.valueOf(paramInt));
    tog localtog = this.a.a();
    if ((localtog != null) && (TextUtils.equals(StoryPlayerGroupHolder.a(this.a).a().jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString)) && (!localtog.c()))
    {
      urk.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected, setSelected => %s", localtog);
      this.a.a(localtog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tnv
 * JD-Core Version:    0.7.0.1
 */