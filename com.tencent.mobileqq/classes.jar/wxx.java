import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class wxx
  extends wxa
{
  protected StoryVideoItem a;
  protected int b;
  protected int c;
  protected String c;
  protected int d;
  protected String d;
  protected int e;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  protected String l;
  
  public wxx()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 1;
  }
  
  protected String a()
  {
    if (this.a.isPollVideo()) {
      return this.jdField_c_of_type_JavaLangString + anvx.a(2131715736);
    }
    if (this.a.isInteractVideo()) {
      return this.jdField_c_of_type_JavaLangString + anvx.a(2131715754);
    }
    if (this.a.isGameVideo())
    {
      wlf localwlf = this.a.getVideoGameInfo();
      if (localwlf.a == 2) {
        return anvx.a(2131715738) + localwlf.b + anvx.a(2131715718);
      }
      if (this.b == 0) {
        return anvx.a(2131715719) + localwlf.b + localwlf.jdField_c_of_type_JavaLangString + anvx.a(2131715753);
      }
      return this.a.mOwnerName + anvx.a(2131715728) + localwlf.b + localwlf.jdField_c_of_type_JavaLangString + anvx.a(2131715724);
    }
    return this.jdField_c_of_type_JavaLangString + anvx.a(2131715734) + vzh.a;
  }
  
  public final void a(wye paramwye)
  {
    super.a(paramwye);
    paramwye.a = a(6);
    a(paramwye);
  }
  
  protected void a(wyf paramwyf) {}
  
  public final void a(wyg paramwyg)
  {
    super.a(paramwyg);
    paramwyg.b = 0;
    paramwyg.jdField_d_of_type_JavaLangString = this.k;
    paramwyg.a = this.a.mVideoThumbnailUrl;
    paramwyg.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramwyg.j = this.l;
    paramwyg.h = a(1);
    if (this.jdField_c_of_type_Int != -1) {
      paramwyg.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_d_of_type_Int != -1) {
      paramwyg.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    }
    a(paramwyg);
  }
  
  public final void a(wyh paramwyh)
  {
    super.a(paramwyh);
    paramwyh.a = this.a.mVideoThumbnailUrl;
    paramwyh.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramwyh.jdField_d_of_type_JavaLangString = this.i;
    paramwyh.jdField_e_of_type_JavaLangString = a(2);
    a(paramwyh);
  }
  
  public final void a(wyi paramwyi)
  {
    super.a(paramwyi);
    paramwyi.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramwyi.jdField_d_of_type_JavaLangString = this.a.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramwyi.jdField_d_of_type_JavaLangString)) {
      paramwyi.jdField_d_of_type_JavaLangString = wyq.a(paramwyi.jdField_e_of_type_JavaLangString);
    }
    paramwyi.jdField_c_of_type_JavaLangString = a(5);
    paramwyi.a = this.j;
    a(paramwyi);
  }
  
  public void a(wyj paramwyj)
  {
    super.a(paramwyj);
    paramwyj.jdField_c_of_type_JavaLangString = this.i;
    paramwyj.a = this.jdField_d_of_type_JavaLangString;
    paramwyj.jdField_d_of_type_JavaLangString = a(3);
    paramwyj.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramwyj.jdField_c_of_type_Boolean = true;
    a(paramwyj);
  }
  
  protected void a_(wyf paramwyf)
  {
    ykq.b("VideoShareModeBase", "prepareCommonShareData");
    super.a_(paramwyf);
    if (this.a.isPollVideo()) {
      paramwyf.a("vote", "1");
    }
    for (;;)
    {
      paramwyf.a = this.a;
      return;
      if (this.a.isInteractVideo()) {
        paramwyf.a("grade", "1");
      }
    }
  }
  
  protected String b()
  {
    Object localObject1 = this.a.getPollLayout();
    Object localObject2 = this.a.getInteractLayout();
    if ((localObject1 != null) && (((wlc)localObject1).a != null) && (((wlc)localObject1).a.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject2 + " · " + localObject1.a[0];
    }
    if ((localObject2 != null) && (((wlb)localObject2).a != null) && (((wlb)localObject2).a.length > 0))
    {
      localObject1 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject1 + " · " + localObject2.a[0];
    }
    localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
    if (TextUtils.isEmpty(this.g)) {}
    for (localObject1 = "1个小视频";; localObject1 = this.g) {
      return (String)localObject2 + " · " + (String)localObject1;
    }
  }
  
  public void b(wyj paramwyj)
  {
    super.b(paramwyj);
    paramwyj.jdField_c_of_type_JavaLangString = this.i;
    paramwyj.a = this.jdField_d_of_type_JavaLangString;
    paramwyj.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramwyj.jdField_d_of_type_JavaLangString = a(4);
    paramwyj.jdField_c_of_type_Boolean = true;
    a(paramwyj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxx
 * JD-Core Version:    0.7.0.1
 */