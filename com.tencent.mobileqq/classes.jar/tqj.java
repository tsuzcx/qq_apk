import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class tqj
  extends tqk
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
  
  public tqj()
  {
    this.jdField_d_of_type_Int = 1;
  }
  
  public final void a(tro paramtro)
  {
    super.a(paramtro);
    paramtro.a = a(6);
  }
  
  public final void a(trq paramtrq)
  {
    super.a(paramtrq);
    paramtrq.b = 0;
    paramtrq.jdField_d_of_type_JavaLangString = this.k;
    paramtrq.a = this.a.mVideoThumbnailUrl;
    paramtrq.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramtrq.h = a(1);
    if (this.b != -1) {
      paramtrq.jdField_d_of_type_Int = this.b;
    }
    if (this.c != -1) {
      paramtrq.jdField_e_of_type_Int = this.c;
    }
  }
  
  public final void a(trr paramtrr)
  {
    super.a(paramtrr);
    paramtrr.a = this.a.mVideoThumbnailUrl;
    paramtrr.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramtrr.jdField_d_of_type_JavaLangString = this.i;
    paramtrr.jdField_e_of_type_JavaLangString = a(2);
  }
  
  public final void a(trs paramtrs)
  {
    super.a(paramtrs);
    paramtrs.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtrs.jdField_d_of_type_JavaLangString = this.a.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramtrs.jdField_d_of_type_JavaLangString)) {
      paramtrs.jdField_d_of_type_JavaLangString = tsa.a(paramtrs.jdField_e_of_type_JavaLangString);
    }
    paramtrs.jdField_c_of_type_JavaLangString = a(5);
    paramtrs.a = this.j;
  }
  
  public void a(trt paramtrt)
  {
    super.a(paramtrt);
    paramtrt.jdField_c_of_type_JavaLangString = this.i;
    paramtrt.a = this.jdField_e_of_type_JavaLangString;
    paramtrt.jdField_d_of_type_JavaLangString = a(3);
    paramtrt.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtrt.jdField_c_of_type_Boolean = true;
  }
  
  protected void a_(trp paramtrp)
  {
    veg.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
    super.a_(paramtrp);
    if (this.a.isPollVideo()) {
      paramtrp.a("vote", "1");
    }
    for (;;)
    {
      paramtrp.a = this.a;
      return;
      if (this.a.isInteractVideo()) {
        paramtrp.a("grade", "1");
      }
    }
  }
  
  public void b(trt paramtrt)
  {
    super.b(paramtrt);
    paramtrt.jdField_c_of_type_JavaLangString = this.i;
    paramtrt.a = this.jdField_d_of_type_JavaLangString;
    paramtrt.jdField_d_of_type_JavaLangString = a(4);
    paramtrt.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtrt.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqj
 * JD-Core Version:    0.7.0.1
 */