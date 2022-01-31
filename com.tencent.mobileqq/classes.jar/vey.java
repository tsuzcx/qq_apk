import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class vey
  extends vez
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
  
  public vey()
  {
    this.jdField_d_of_type_Int = 1;
  }
  
  public final void a(vgd paramvgd)
  {
    super.a(paramvgd);
    paramvgd.a = a(6);
  }
  
  public final void a(vgf paramvgf)
  {
    super.a(paramvgf);
    paramvgf.b = 0;
    paramvgf.jdField_d_of_type_JavaLangString = this.k;
    paramvgf.a = this.a.mVideoThumbnailUrl;
    paramvgf.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramvgf.h = a(1);
    if (this.b != -1) {
      paramvgf.jdField_d_of_type_Int = this.b;
    }
    if (this.c != -1) {
      paramvgf.jdField_e_of_type_Int = this.c;
    }
  }
  
  public final void a(vgg paramvgg)
  {
    super.a(paramvgg);
    paramvgg.a = this.a.mVideoThumbnailUrl;
    paramvgg.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramvgg.jdField_d_of_type_JavaLangString = this.i;
    paramvgg.jdField_e_of_type_JavaLangString = a(2);
  }
  
  public final void a(vgh paramvgh)
  {
    super.a(paramvgh);
    paramvgh.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramvgh.jdField_d_of_type_JavaLangString = this.a.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramvgh.jdField_d_of_type_JavaLangString)) {
      paramvgh.jdField_d_of_type_JavaLangString = vgp.a(paramvgh.jdField_e_of_type_JavaLangString);
    }
    paramvgh.jdField_c_of_type_JavaLangString = a(5);
    paramvgh.a = this.j;
  }
  
  public void a(vgi paramvgi)
  {
    super.a(paramvgi);
    paramvgi.jdField_c_of_type_JavaLangString = this.i;
    paramvgi.a = this.jdField_e_of_type_JavaLangString;
    paramvgi.jdField_d_of_type_JavaLangString = a(3);
    paramvgi.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramvgi.jdField_c_of_type_Boolean = true;
  }
  
  protected void a_(vge paramvge)
  {
    wsv.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
    super.a_(paramvge);
    if (this.a.isPollVideo()) {
      paramvge.a("vote", "1");
    }
    for (;;)
    {
      paramvge.a = this.a;
      return;
      if (this.a.isInteractVideo()) {
        paramvge.a("grade", "1");
      }
    }
  }
  
  public void b(vgi paramvgi)
  {
    super.b(paramvgi);
    paramvgi.jdField_c_of_type_JavaLangString = this.i;
    paramvgi.a = this.jdField_d_of_type_JavaLangString;
    paramvgi.jdField_d_of_type_JavaLangString = a(4);
    paramvgi.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramvgi.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vey
 * JD-Core Version:    0.7.0.1
 */