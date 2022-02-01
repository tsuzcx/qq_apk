import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class wwz
  extends wxa
{
  protected int a;
  protected StoryVideoItem a;
  protected int b = -1;
  protected int c = -1;
  protected String c;
  protected int d;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  
  public wwz()
  {
    this.jdField_d_of_type_Int = 1;
  }
  
  public final void a(wye paramwye)
  {
    super.a(paramwye);
    paramwye.a = a(6);
  }
  
  public final void a(wyg paramwyg)
  {
    super.a(paramwyg);
    paramwyg.b = 0;
    paramwyg.jdField_d_of_type_JavaLangString = this.k;
    paramwyg.a = this.a.mVideoThumbnailUrl;
    paramwyg.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramwyg.h = a(1);
    if (this.b != -1) {
      paramwyg.jdField_d_of_type_Int = this.b;
    }
    if (this.c != -1) {
      paramwyg.jdField_e_of_type_Int = this.c;
    }
  }
  
  public final void a(wyh paramwyh)
  {
    super.a(paramwyh);
    paramwyh.a = this.a.mVideoThumbnailUrl;
    paramwyh.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramwyh.jdField_d_of_type_JavaLangString = this.i;
    paramwyh.jdField_e_of_type_JavaLangString = a(2);
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
  }
  
  public void a(wyj paramwyj)
  {
    super.a(paramwyj);
    paramwyj.jdField_c_of_type_JavaLangString = this.i;
    paramwyj.a = this.jdField_e_of_type_JavaLangString;
    paramwyj.jdField_d_of_type_JavaLangString = a(3);
    paramwyj.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramwyj.jdField_c_of_type_Boolean = true;
  }
  
  protected void a_(wyf paramwyf)
  {
    ykq.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
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
  
  public void b(wyj paramwyj)
  {
    super.b(paramwyj);
    paramwyj.jdField_c_of_type_JavaLangString = this.i;
    paramwyj.a = this.jdField_d_of_type_JavaLangString;
    paramwyj.jdField_d_of_type_JavaLangString = a(4);
    paramwyj.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramwyj.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwz
 * JD-Core Version:    0.7.0.1
 */