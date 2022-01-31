import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class vpg
  implements vri
{
  public vpg(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(int paramInt)
  {
    wsv.a(this.a.jdField_a_of_type_JavaLangString, "onPageSelected : position = %d", Integer.valueOf(paramInt));
    int i = this.a.b;
    this.a.b = paramInt;
    Object localObject = this.a.a();
    if (localObject != null)
    {
      localObject = (vpt)((vpr)localObject).a(vpt.class);
      if ((localObject != null) && (((vpt)localObject).b.getVisibility() != 0)) {
        this.a.a(true, true);
      }
    }
    localObject = (vog)this.a.b(vog.class);
    if (localObject != null) {
      ((vog)localObject).a().a(paramInt);
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
    vog localvog = (vog)this.a.b(vog.class);
    if (localvog != null) {
      localvog.a().a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == 1) && (this.a.d()) && (this.a.c()))
    {
      ((vog)this.a.b(vog.class)).d();
      wsv.a(this.a.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onPageScrolled, showLoadingMoreWidget position=%d", Integer.valueOf(this.a.b));
    }
    vog localvog = (vog)this.a.b(vog.class);
    if (localvog != null) {
      localvog.a().b(paramInt);
    }
    if (StoryPlayerGroupHolder.a(this.a) != null) {
      StoryPlayerGroupHolder.a(this.a).a(this.a.jdField_a_of_type_Int, paramInt);
    }
  }
  
  public void c(int paramInt)
  {
    wsv.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected : position = %d", Integer.valueOf(paramInt));
    vpr localvpr = this.a.a();
    if ((localvpr != null) && (TextUtils.equals(StoryPlayerGroupHolder.a(this.a).a().jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString)) && (!localvpr.c()))
    {
      wsv.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected, setSelected => %s", localvpr);
      this.a.a(localvpr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpg
 * JD-Core Version:    0.7.0.1
 */