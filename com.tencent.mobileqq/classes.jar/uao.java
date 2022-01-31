import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class uao
  implements ucq
{
  public uao(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(int paramInt)
  {
    ved.a(this.a.jdField_a_of_type_JavaLangString, "onPageSelected : position = %d", Integer.valueOf(paramInt));
    int i = this.a.b;
    this.a.b = paramInt;
    Object localObject = this.a.a();
    if (localObject != null)
    {
      localObject = (ubb)((uaz)localObject).a(ubb.class);
      if ((localObject != null) && (((ubb)localObject).b.getVisibility() != 0)) {
        this.a.a(true, true);
      }
    }
    localObject = (tzo)this.a.b(tzo.class);
    if (localObject != null) {
      ((tzo)localObject).a().a(paramInt);
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
    tzo localtzo = (tzo)this.a.b(tzo.class);
    if (localtzo != null) {
      localtzo.a().a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == 1) && (this.a.d()) && (this.a.c()))
    {
      ((tzo)this.a.b(tzo.class)).d();
      ved.a(this.a.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onPageScrolled, showLoadingMoreWidget position=%d", Integer.valueOf(this.a.b));
    }
    tzo localtzo = (tzo)this.a.b(tzo.class);
    if (localtzo != null) {
      localtzo.a().b(paramInt);
    }
    if (StoryPlayerGroupHolder.a(this.a) != null) {
      StoryPlayerGroupHolder.a(this.a).a(this.a.jdField_a_of_type_Int, paramInt);
    }
  }
  
  public void c(int paramInt)
  {
    ved.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected : position = %d", Integer.valueOf(paramInt));
    uaz localuaz = this.a.a();
    if ((localuaz != null) && (TextUtils.equals(StoryPlayerGroupHolder.a(this.a).a().jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString)) && (!localuaz.c()))
    {
      ved.a(this.a.jdField_a_of_type_JavaLangString, "onIdlePageSelected, setSelected => %s", localuaz);
      this.a.a(localuaz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uao
 * JD-Core Version:    0.7.0.1
 */