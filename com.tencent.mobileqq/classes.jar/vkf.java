import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class vkf
  extends vji
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
  
  public vkf()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 1;
  }
  
  protected String a()
  {
    if (this.a.isPollVideo()) {
      return this.jdField_c_of_type_JavaLangString + alud.a(2131716768);
    }
    if (this.a.isInteractVideo()) {
      return this.jdField_c_of_type_JavaLangString + alud.a(2131716786);
    }
    if (this.a.isGameVideo())
    {
      uxn localuxn = this.a.getVideoGameInfo();
      if (localuxn.a == 2) {
        return alud.a(2131716770) + localuxn.b + alud.a(2131716750);
      }
      if (this.b == 0) {
        return alud.a(2131716751) + localuxn.b + localuxn.jdField_c_of_type_JavaLangString + alud.a(2131716785);
      }
      return this.a.mOwnerName + alud.a(2131716760) + localuxn.b + localuxn.jdField_c_of_type_JavaLangString + alud.a(2131716756);
    }
    return this.jdField_c_of_type_JavaLangString + alud.a(2131716766) + ulg.a;
  }
  
  public final void a(vkm paramvkm)
  {
    super.a(paramvkm);
    paramvkm.a = a(6);
    a(paramvkm);
  }
  
  protected void a(vkn paramvkn) {}
  
  public final void a(vko paramvko)
  {
    super.a(paramvko);
    paramvko.b = 0;
    paramvko.jdField_d_of_type_JavaLangString = this.k;
    paramvko.a = this.a.mVideoThumbnailUrl;
    paramvko.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramvko.j = this.l;
    paramvko.h = a(1);
    if (this.jdField_c_of_type_Int != -1) {
      paramvko.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_d_of_type_Int != -1) {
      paramvko.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    }
    a(paramvko);
  }
  
  public final void a(vkp paramvkp)
  {
    super.a(paramvkp);
    paramvkp.a = this.a.mVideoThumbnailUrl;
    paramvkp.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramvkp.jdField_d_of_type_JavaLangString = this.i;
    paramvkp.jdField_e_of_type_JavaLangString = a(2);
    a(paramvkp);
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
    a(paramvkq);
  }
  
  public void a(vkr paramvkr)
  {
    super.a(paramvkr);
    paramvkr.jdField_c_of_type_JavaLangString = this.i;
    paramvkr.a = this.jdField_d_of_type_JavaLangString;
    paramvkr.jdField_d_of_type_JavaLangString = a(3);
    paramvkr.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramvkr.jdField_c_of_type_Boolean = true;
    a(paramvkr);
  }
  
  protected void a_(vkn paramvkn)
  {
    wxe.b("VideoShareModeBase", "prepareCommonShareData");
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
  
  protected String b()
  {
    Object localObject1 = this.a.getPollLayout();
    Object localObject2 = this.a.getInteractLayout();
    if ((localObject1 != null) && (((uxk)localObject1).a != null) && (((uxk)localObject1).a.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject2 + " · " + localObject1.a[0];
    }
    if ((localObject2 != null) && (((uxj)localObject2).a != null) && (((uxj)localObject2).a.length > 0))
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
  
  public void b(vkr paramvkr)
  {
    super.b(paramvkr);
    paramvkr.jdField_c_of_type_JavaLangString = this.i;
    paramvkr.a = this.jdField_d_of_type_JavaLangString;
    paramvkr.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramvkr.jdField_d_of_type_JavaLangString = a(4);
    paramvkr.jdField_c_of_type_Boolean = true;
    a(paramvkr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkf
 * JD-Core Version:    0.7.0.1
 */