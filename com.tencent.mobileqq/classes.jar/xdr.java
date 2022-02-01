import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class xdr
  extends xcu
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
  
  public xdr()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 1;
  }
  
  protected String a()
  {
    if (this.a.isPollVideo()) {
      return this.jdField_c_of_type_JavaLangString + anni.a(2131715045);
    }
    if (this.a.isInteractVideo()) {
      return this.jdField_c_of_type_JavaLangString + anni.a(2131715063);
    }
    if (this.a.isGameVideo())
    {
      wqz localwqz = this.a.getVideoGameInfo();
      if (localwqz.a == 2) {
        return anni.a(2131715047) + localwqz.b + anni.a(2131715027);
      }
      if (this.b == 0) {
        return anni.a(2131715028) + localwqz.b + localwqz.jdField_c_of_type_JavaLangString + anni.a(2131715062);
      }
      return this.a.mOwnerName + anni.a(2131715037) + localwqz.b + localwqz.jdField_c_of_type_JavaLangString + anni.a(2131715033);
    }
    return this.jdField_c_of_type_JavaLangString + anni.a(2131715043) + wes.a;
  }
  
  public final void a(xdy paramxdy)
  {
    super.a(paramxdy);
    paramxdy.a = a(6);
    a(paramxdy);
  }
  
  protected void a(xdz paramxdz) {}
  
  public final void a(xea paramxea)
  {
    super.a(paramxea);
    paramxea.b = 0;
    paramxea.jdField_d_of_type_JavaLangString = this.k;
    paramxea.a = this.a.mVideoThumbnailUrl;
    paramxea.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramxea.j = this.l;
    paramxea.h = a(1);
    if (this.jdField_c_of_type_Int != -1) {
      paramxea.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_d_of_type_Int != -1) {
      paramxea.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    }
    a(paramxea);
  }
  
  public final void a(xeb paramxeb)
  {
    super.a(paramxeb);
    paramxeb.a = this.a.mVideoThumbnailUrl;
    paramxeb.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramxeb.jdField_d_of_type_JavaLangString = this.i;
    paramxeb.jdField_e_of_type_JavaLangString = a(2);
    a(paramxeb);
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
    a(paramxec);
  }
  
  public void a(xed paramxed)
  {
    super.a(paramxed);
    paramxed.jdField_c_of_type_JavaLangString = this.i;
    paramxed.a = this.jdField_d_of_type_JavaLangString;
    paramxed.jdField_d_of_type_JavaLangString = a(3);
    paramxed.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramxed.jdField_c_of_type_Boolean = true;
    a(paramxed);
  }
  
  protected void a_(xdz paramxdz)
  {
    yqp.b("VideoShareModeBase", "prepareCommonShareData");
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
  
  protected String b()
  {
    Object localObject1 = this.a.getPollLayout();
    Object localObject2 = this.a.getInteractLayout();
    if ((localObject1 != null) && (((wqw)localObject1).a != null) && (((wqw)localObject1).a.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject2 + " · " + localObject1.a[0];
    }
    if ((localObject2 != null) && (((wqv)localObject2).a != null) && (((wqv)localObject2).a.length > 0))
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
  
  public void b(xed paramxed)
  {
    super.b(paramxed);
    paramxed.jdField_c_of_type_JavaLangString = this.i;
    paramxed.a = this.jdField_d_of_type_JavaLangString;
    paramxed.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramxed.jdField_d_of_type_JavaLangString = a(4);
    paramxed.jdField_c_of_type_Boolean = true;
    a(paramxed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdr
 * JD-Core Version:    0.7.0.1
 */