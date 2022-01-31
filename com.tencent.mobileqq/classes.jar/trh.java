import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class trh
  extends tqk
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
  
  public trh()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 1;
  }
  
  protected String a()
  {
    if (this.a.isPollVideo()) {
      return this.jdField_c_of_type_JavaLangString + ajyc.a(2131716373);
    }
    if (this.a.isInteractVideo()) {
      return this.jdField_c_of_type_JavaLangString + ajyc.a(2131716391);
    }
    if (this.a.isGameVideo())
    {
      tep localtep = this.a.getVideoGameInfo();
      if (localtep.a == 2) {
        return ajyc.a(2131716375) + localtep.b + ajyc.a(2131716355);
      }
      if (this.b == 0) {
        return ajyc.a(2131716356) + localtep.b + localtep.jdField_c_of_type_JavaLangString + ajyc.a(2131716390);
      }
      return this.a.mOwnerName + ajyc.a(2131716365) + localtep.b + localtep.jdField_c_of_type_JavaLangString + ajyc.a(2131716361);
    }
    return this.jdField_c_of_type_JavaLangString + ajyc.a(2131716371) + ssi.a;
  }
  
  public final void a(tro paramtro)
  {
    super.a(paramtro);
    paramtro.a = a(6);
    a(paramtro);
  }
  
  protected void a(trp paramtrp) {}
  
  public final void a(trq paramtrq)
  {
    super.a(paramtrq);
    paramtrq.b = 0;
    paramtrq.jdField_d_of_type_JavaLangString = this.k;
    paramtrq.a = this.a.mVideoThumbnailUrl;
    paramtrq.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramtrq.j = this.l;
    paramtrq.h = a(1);
    if (this.jdField_c_of_type_Int != -1) {
      paramtrq.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_d_of_type_Int != -1) {
      paramtrq.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    }
    a(paramtrq);
  }
  
  public final void a(trr paramtrr)
  {
    super.a(paramtrr);
    paramtrr.a = this.a.mVideoThumbnailUrl;
    paramtrr.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramtrr.jdField_d_of_type_JavaLangString = this.i;
    paramtrr.jdField_e_of_type_JavaLangString = a(2);
    a(paramtrr);
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
    a(paramtrs);
  }
  
  public void a(trt paramtrt)
  {
    super.a(paramtrt);
    paramtrt.jdField_c_of_type_JavaLangString = this.i;
    paramtrt.a = this.jdField_d_of_type_JavaLangString;
    paramtrt.jdField_d_of_type_JavaLangString = a(3);
    paramtrt.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtrt.jdField_c_of_type_Boolean = true;
    a(paramtrt);
  }
  
  protected void a_(trp paramtrp)
  {
    veg.b("VideoShareModeBase", "prepareCommonShareData");
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
  
  protected String b()
  {
    Object localObject1 = this.a.getPollLayout();
    Object localObject2 = this.a.getInteractLayout();
    if ((localObject1 != null) && (((tem)localObject1).a != null) && (((tem)localObject1).a.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject2 + " · " + localObject1.a[0];
    }
    if ((localObject2 != null) && (((tel)localObject2).a != null) && (((tel)localObject2).a.length > 0))
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
  
  public void b(trt paramtrt)
  {
    super.b(paramtrt);
    paramtrt.jdField_c_of_type_JavaLangString = this.i;
    paramtrt.a = this.jdField_d_of_type_JavaLangString;
    paramtrt.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtrt.jdField_d_of_type_JavaLangString = a(4);
    paramtrt.jdField_c_of_type_Boolean = true;
    a(paramtrt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     trh
 * JD-Core Version:    0.7.0.1
 */