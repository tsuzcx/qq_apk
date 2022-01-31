import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class vfw
  extends vez
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
  
  public vfw()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 1;
  }
  
  protected String a()
  {
    if (this.a.isPollVideo()) {
      return this.jdField_c_of_type_JavaLangString + alpo.a(2131716756);
    }
    if (this.a.isInteractVideo()) {
      return this.jdField_c_of_type_JavaLangString + alpo.a(2131716774);
    }
    if (this.a.isGameVideo())
    {
      ute localute = this.a.getVideoGameInfo();
      if (localute.a == 2) {
        return alpo.a(2131716758) + localute.b + alpo.a(2131716738);
      }
      if (this.b == 0) {
        return alpo.a(2131716739) + localute.b + localute.jdField_c_of_type_JavaLangString + alpo.a(2131716773);
      }
      return this.a.mOwnerName + alpo.a(2131716748) + localute.b + localute.jdField_c_of_type_JavaLangString + alpo.a(2131716744);
    }
    return this.jdField_c_of_type_JavaLangString + alpo.a(2131716754) + ugx.a;
  }
  
  public final void a(vgd paramvgd)
  {
    super.a(paramvgd);
    paramvgd.a = a(6);
    a(paramvgd);
  }
  
  protected void a(vge paramvge) {}
  
  public final void a(vgf paramvgf)
  {
    super.a(paramvgf);
    paramvgf.b = 0;
    paramvgf.jdField_d_of_type_JavaLangString = this.k;
    paramvgf.a = this.a.mVideoThumbnailUrl;
    paramvgf.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramvgf.j = this.l;
    paramvgf.h = a(1);
    if (this.jdField_c_of_type_Int != -1) {
      paramvgf.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_d_of_type_Int != -1) {
      paramvgf.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    }
    a(paramvgf);
  }
  
  public final void a(vgg paramvgg)
  {
    super.a(paramvgg);
    paramvgg.a = this.a.mVideoThumbnailUrl;
    paramvgg.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramvgg.jdField_d_of_type_JavaLangString = this.i;
    paramvgg.jdField_e_of_type_JavaLangString = a(2);
    a(paramvgg);
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
    a(paramvgh);
  }
  
  public void a(vgi paramvgi)
  {
    super.a(paramvgi);
    paramvgi.jdField_c_of_type_JavaLangString = this.i;
    paramvgi.a = this.jdField_d_of_type_JavaLangString;
    paramvgi.jdField_d_of_type_JavaLangString = a(3);
    paramvgi.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramvgi.jdField_c_of_type_Boolean = true;
    a(paramvgi);
  }
  
  protected void a_(vge paramvge)
  {
    wsv.b("VideoShareModeBase", "prepareCommonShareData");
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
  
  protected String b()
  {
    Object localObject1 = this.a.getPollLayout();
    Object localObject2 = this.a.getInteractLayout();
    if ((localObject1 != null) && (((utb)localObject1).a != null) && (((utb)localObject1).a.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject2 + " · " + localObject1.a[0];
    }
    if ((localObject2 != null) && (((uta)localObject2).a != null) && (((uta)localObject2).a.length > 0))
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
  
  public void b(vgi paramvgi)
  {
    super.b(paramvgi);
    paramvgi.jdField_c_of_type_JavaLangString = this.i;
    paramvgi.a = this.jdField_d_of_type_JavaLangString;
    paramvgi.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramvgi.jdField_d_of_type_JavaLangString = a(4);
    paramvgi.jdField_c_of_type_Boolean = true;
    a(paramvgi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfw
 * JD-Core Version:    0.7.0.1
 */