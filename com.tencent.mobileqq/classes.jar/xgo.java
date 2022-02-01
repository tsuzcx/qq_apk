import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class xgo
  extends xgp
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
  
  public xgo()
  {
    this.jdField_d_of_type_Int = 1;
  }
  
  public final void a(xht paramxht)
  {
    super.a(paramxht);
    paramxht.a = a(6);
  }
  
  public final void a(xhv paramxhv)
  {
    super.a(paramxhv);
    paramxhv.b = 0;
    paramxhv.jdField_d_of_type_JavaLangString = this.k;
    paramxhv.a = this.a.mVideoThumbnailUrl;
    paramxhv.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramxhv.h = a(1);
    if (this.b != -1) {
      paramxhv.jdField_d_of_type_Int = this.b;
    }
    if (this.c != -1) {
      paramxhv.jdField_e_of_type_Int = this.c;
    }
  }
  
  public final void a(xhw paramxhw)
  {
    super.a(paramxhw);
    paramxhw.a = this.a.mVideoThumbnailUrl;
    paramxhw.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramxhw.jdField_d_of_type_JavaLangString = this.i;
    paramxhw.jdField_e_of_type_JavaLangString = a(2);
  }
  
  public final void a(xhx paramxhx)
  {
    super.a(paramxhx);
    paramxhx.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramxhx.jdField_d_of_type_JavaLangString = this.a.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramxhx.jdField_d_of_type_JavaLangString)) {
      paramxhx.jdField_d_of_type_JavaLangString = xif.a(paramxhx.jdField_e_of_type_JavaLangString);
    }
    paramxhx.jdField_c_of_type_JavaLangString = a(5);
    paramxhx.a = this.j;
  }
  
  public void a(xhy paramxhy)
  {
    super.a(paramxhy);
    paramxhy.jdField_c_of_type_JavaLangString = this.i;
    paramxhy.a = this.jdField_e_of_type_JavaLangString;
    paramxhy.jdField_d_of_type_JavaLangString = a(3);
    paramxhy.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramxhy.jdField_c_of_type_Boolean = true;
  }
  
  protected void a_(xhu paramxhu)
  {
    yuk.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
    super.a_(paramxhu);
    if (this.a.isPollVideo()) {
      paramxhu.a("vote", "1");
    }
    for (;;)
    {
      paramxhu.a = this.a;
      return;
      if (this.a.isInteractVideo()) {
        paramxhu.a("grade", "1");
      }
    }
  }
  
  public void b(xhy paramxhy)
  {
    super.b(paramxhy);
    paramxhy.jdField_c_of_type_JavaLangString = this.i;
    paramxhy.a = this.jdField_d_of_type_JavaLangString;
    paramxhy.jdField_d_of_type_JavaLangString = a(4);
    paramxhy.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramxhy.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgo
 * JD-Core Version:    0.7.0.1
 */