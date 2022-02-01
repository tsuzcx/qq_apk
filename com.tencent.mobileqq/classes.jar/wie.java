import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class wie
  extends wif
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
  
  public wie()
  {
    this.jdField_d_of_type_Int = 1;
  }
  
  public final void a(wjj paramwjj)
  {
    super.a(paramwjj);
    paramwjj.a = a(6);
  }
  
  public final void a(wjl paramwjl)
  {
    super.a(paramwjl);
    paramwjl.b = 0;
    paramwjl.jdField_d_of_type_JavaLangString = this.k;
    paramwjl.a = this.a.mVideoThumbnailUrl;
    paramwjl.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramwjl.h = a(1);
    if (this.b != -1) {
      paramwjl.jdField_d_of_type_Int = this.b;
    }
    if (this.c != -1) {
      paramwjl.jdField_e_of_type_Int = this.c;
    }
  }
  
  public final void a(wjm paramwjm)
  {
    super.a(paramwjm);
    paramwjm.a = this.a.mVideoThumbnailUrl;
    paramwjm.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramwjm.jdField_d_of_type_JavaLangString = this.i;
    paramwjm.jdField_e_of_type_JavaLangString = a(2);
  }
  
  public final void a(wjn paramwjn)
  {
    super.a(paramwjn);
    paramwjn.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramwjn.jdField_d_of_type_JavaLangString = this.a.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramwjn.jdField_d_of_type_JavaLangString)) {
      paramwjn.jdField_d_of_type_JavaLangString = wjv.a(paramwjn.jdField_e_of_type_JavaLangString);
    }
    paramwjn.jdField_c_of_type_JavaLangString = a(5);
    paramwjn.a = this.j;
  }
  
  public void a(wjo paramwjo)
  {
    super.a(paramwjo);
    paramwjo.jdField_c_of_type_JavaLangString = this.i;
    paramwjo.a = this.jdField_e_of_type_JavaLangString;
    paramwjo.jdField_d_of_type_JavaLangString = a(3);
    paramwjo.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramwjo.jdField_c_of_type_Boolean = true;
  }
  
  protected void a_(wjk paramwjk)
  {
    xvv.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
    super.a_(paramwjk);
    if (this.a.isPollVideo()) {
      paramwjk.a("vote", "1");
    }
    for (;;)
    {
      paramwjk.a = this.a;
      return;
      if (this.a.isInteractVideo()) {
        paramwjk.a("grade", "1");
      }
    }
  }
  
  public void b(wjo paramwjo)
  {
    super.b(paramwjo);
    paramwjo.jdField_c_of_type_JavaLangString = this.i;
    paramwjo.a = this.jdField_d_of_type_JavaLangString;
    paramwjo.jdField_d_of_type_JavaLangString = a(4);
    paramwjo.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramwjo.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wie
 * JD-Core Version:    0.7.0.1
 */