import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class xct
  extends xcu
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
  
  public xct()
  {
    this.jdField_d_of_type_Int = 1;
  }
  
  public final void a(xdy paramxdy)
  {
    super.a(paramxdy);
    paramxdy.a = a(6);
  }
  
  public final void a(xea paramxea)
  {
    super.a(paramxea);
    paramxea.b = 0;
    paramxea.jdField_d_of_type_JavaLangString = this.k;
    paramxea.a = this.a.mVideoThumbnailUrl;
    paramxea.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramxea.h = a(1);
    if (this.b != -1) {
      paramxea.jdField_d_of_type_Int = this.b;
    }
    if (this.c != -1) {
      paramxea.jdField_e_of_type_Int = this.c;
    }
  }
  
  public final void a(xeb paramxeb)
  {
    super.a(paramxeb);
    paramxeb.a = this.a.mVideoThumbnailUrl;
    paramxeb.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramxeb.jdField_d_of_type_JavaLangString = this.i;
    paramxeb.jdField_e_of_type_JavaLangString = a(2);
  }
  
  public final void a(xec paramxec)
  {
    super.a(paramxec);
    paramxec.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramxec.jdField_d_of_type_JavaLangString = this.a.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramxec.jdField_d_of_type_JavaLangString)) {
      paramxec.jdField_d_of_type_JavaLangString = xek.a(paramxec.jdField_e_of_type_JavaLangString);
    }
    paramxec.jdField_c_of_type_JavaLangString = a(5);
    paramxec.a = this.j;
  }
  
  public void a(xed paramxed)
  {
    super.a(paramxed);
    paramxed.jdField_c_of_type_JavaLangString = this.i;
    paramxed.a = this.jdField_e_of_type_JavaLangString;
    paramxed.jdField_d_of_type_JavaLangString = a(3);
    paramxed.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramxed.jdField_c_of_type_Boolean = true;
  }
  
  protected void a_(xdz paramxdz)
  {
    yqp.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
    super.a_(paramxdz);
    if (this.a.isPollVideo()) {
      paramxdz.a("vote", "1");
    }
    for (;;)
    {
      paramxdz.a = this.a;
      return;
      if (this.a.isInteractVideo()) {
        paramxdz.a("grade", "1");
      }
    }
  }
  
  public void b(xed paramxed)
  {
    super.b(paramxed);
    paramxed.jdField_c_of_type_JavaLangString = this.i;
    paramxed.a = this.jdField_d_of_type_JavaLangString;
    paramxed.jdField_d_of_type_JavaLangString = a(4);
    paramxed.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramxed.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xct
 * JD-Core Version:    0.7.0.1
 */