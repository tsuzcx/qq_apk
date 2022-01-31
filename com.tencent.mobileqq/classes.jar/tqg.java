import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class tqg
  extends tqh
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
  
  public tqg()
  {
    this.jdField_d_of_type_Int = 1;
  }
  
  public final void a(trl paramtrl)
  {
    super.a(paramtrl);
    paramtrl.a = a(6);
  }
  
  public final void a(trn paramtrn)
  {
    super.a(paramtrn);
    paramtrn.b = 0;
    paramtrn.jdField_d_of_type_JavaLangString = this.k;
    paramtrn.a = this.a.mVideoThumbnailUrl;
    paramtrn.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramtrn.h = a(1);
    if (this.b != -1) {
      paramtrn.jdField_d_of_type_Int = this.b;
    }
    if (this.c != -1) {
      paramtrn.jdField_e_of_type_Int = this.c;
    }
  }
  
  public final void a(tro paramtro)
  {
    super.a(paramtro);
    paramtro.a = this.a.mVideoThumbnailUrl;
    paramtro.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramtro.jdField_d_of_type_JavaLangString = this.i;
    paramtro.jdField_e_of_type_JavaLangString = a(2);
  }
  
  public final void a(trp paramtrp)
  {
    super.a(paramtrp);
    paramtrp.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtrp.jdField_d_of_type_JavaLangString = this.a.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramtrp.jdField_d_of_type_JavaLangString)) {
      paramtrp.jdField_d_of_type_JavaLangString = trx.a(paramtrp.jdField_e_of_type_JavaLangString);
    }
    paramtrp.jdField_c_of_type_JavaLangString = a(5);
    paramtrp.a = this.j;
  }
  
  public void a(trq paramtrq)
  {
    super.a(paramtrq);
    paramtrq.jdField_c_of_type_JavaLangString = this.i;
    paramtrq.a = this.jdField_e_of_type_JavaLangString;
    paramtrq.jdField_d_of_type_JavaLangString = a(3);
    paramtrq.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtrq.jdField_c_of_type_Boolean = true;
  }
  
  protected void a_(trm paramtrm)
  {
    ved.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
    super.a_(paramtrm);
    if (this.a.isPollVideo()) {
      paramtrm.a("vote", "1");
    }
    for (;;)
    {
      paramtrm.a = this.a;
      return;
      if (this.a.isInteractVideo()) {
        paramtrm.a("grade", "1");
      }
    }
  }
  
  public void b(trq paramtrq)
  {
    super.b(paramtrq);
    paramtrq.jdField_c_of_type_JavaLangString = this.i;
    paramtrq.a = this.jdField_d_of_type_JavaLangString;
    paramtrq.jdField_d_of_type_JavaLangString = a(4);
    paramtrq.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtrq.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqg
 * JD-Core Version:    0.7.0.1
 */