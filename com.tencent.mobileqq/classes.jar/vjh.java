import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class vjh
  extends vji
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
  
  public vjh()
  {
    this.jdField_d_of_type_Int = 1;
  }
  
  public final void a(vkm paramvkm)
  {
    super.a(paramvkm);
    paramvkm.a = a(6);
  }
  
  public final void a(vko paramvko)
  {
    super.a(paramvko);
    paramvko.b = 0;
    paramvko.jdField_d_of_type_JavaLangString = this.k;
    paramvko.a = this.a.mVideoThumbnailUrl;
    paramvko.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramvko.h = a(1);
    if (this.b != -1) {
      paramvko.jdField_d_of_type_Int = this.b;
    }
    if (this.c != -1) {
      paramvko.jdField_e_of_type_Int = this.c;
    }
  }
  
  public final void a(vkp paramvkp)
  {
    super.a(paramvkp);
    paramvkp.a = this.a.mVideoThumbnailUrl;
    paramvkp.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramvkp.jdField_d_of_type_JavaLangString = this.i;
    paramvkp.jdField_e_of_type_JavaLangString = a(2);
  }
  
  public final void a(vkq paramvkq)
  {
    super.a(paramvkq);
    paramvkq.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramvkq.jdField_d_of_type_JavaLangString = this.a.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramvkq.jdField_d_of_type_JavaLangString)) {
      paramvkq.jdField_d_of_type_JavaLangString = vky.a(paramvkq.jdField_e_of_type_JavaLangString);
    }
    paramvkq.jdField_c_of_type_JavaLangString = a(5);
    paramvkq.a = this.j;
  }
  
  public void a(vkr paramvkr)
  {
    super.a(paramvkr);
    paramvkr.jdField_c_of_type_JavaLangString = this.i;
    paramvkr.a = this.jdField_e_of_type_JavaLangString;
    paramvkr.jdField_d_of_type_JavaLangString = a(3);
    paramvkr.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramvkr.jdField_c_of_type_Boolean = true;
  }
  
  protected void a_(vkn paramvkn)
  {
    wxe.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
    super.a_(paramvkn);
    if (this.a.isPollVideo()) {
      paramvkn.a("vote", "1");
    }
    for (;;)
    {
      paramvkn.a = this.a;
      return;
      if (this.a.isInteractVideo()) {
        paramvkn.a("grade", "1");
      }
    }
  }
  
  public void b(vkr paramvkr)
  {
    super.b(paramvkr);
    paramvkr.jdField_c_of_type_JavaLangString = this.i;
    paramvkr.a = this.jdField_d_of_type_JavaLangString;
    paramvkr.jdField_d_of_type_JavaLangString = a(4);
    paramvkr.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramvkr.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vjh
 * JD-Core Version:    0.7.0.1
 */