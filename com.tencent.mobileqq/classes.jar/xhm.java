import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class xhm
  extends xgp
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
  
  public xhm()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 1;
  }
  
  protected String a()
  {
    if (this.a.isPollVideo()) {
      return this.jdField_c_of_type_JavaLangString + anzj.a(2131715154);
    }
    if (this.a.isInteractVideo()) {
      return this.jdField_c_of_type_JavaLangString + anzj.a(2131715172);
    }
    if (this.a.isGameVideo())
    {
      wuu localwuu = this.a.getVideoGameInfo();
      if (localwuu.a == 2) {
        return anzj.a(2131715156) + localwuu.b + anzj.a(2131715136);
      }
      if (this.b == 0) {
        return anzj.a(2131715137) + localwuu.b + localwuu.jdField_c_of_type_JavaLangString + anzj.a(2131715171);
      }
      return this.a.mOwnerName + anzj.a(2131715146) + localwuu.b + localwuu.jdField_c_of_type_JavaLangString + anzj.a(2131715142);
    }
    return this.jdField_c_of_type_JavaLangString + anzj.a(2131715152) + win.a;
  }
  
  public final void a(xht paramxht)
  {
    super.a(paramxht);
    paramxht.a = a(6);
    a(paramxht);
  }
  
  protected void a(xhu paramxhu) {}
  
  public final void a(xhv paramxhv)
  {
    super.a(paramxhv);
    paramxhv.b = 0;
    paramxhv.jdField_d_of_type_JavaLangString = this.k;
    paramxhv.a = this.a.mVideoThumbnailUrl;
    paramxhv.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramxhv.j = this.l;
    paramxhv.h = a(1);
    if (this.jdField_c_of_type_Int != -1) {
      paramxhv.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_d_of_type_Int != -1) {
      paramxhv.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    }
    a(paramxhv);
  }
  
  public final void a(xhw paramxhw)
  {
    super.a(paramxhw);
    paramxhw.a = this.a.mVideoThumbnailUrl;
    paramxhw.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramxhw.jdField_d_of_type_JavaLangString = this.i;
    paramxhw.jdField_e_of_type_JavaLangString = a(2);
    a(paramxhw);
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
    a(paramxhx);
  }
  
  public void a(xhy paramxhy)
  {
    super.a(paramxhy);
    paramxhy.jdField_c_of_type_JavaLangString = this.i;
    paramxhy.a = this.jdField_d_of_type_JavaLangString;
    paramxhy.jdField_d_of_type_JavaLangString = a(3);
    paramxhy.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramxhy.jdField_c_of_type_Boolean = true;
    a(paramxhy);
  }
  
  protected void a_(xhu paramxhu)
  {
    yuk.b("VideoShareModeBase", "prepareCommonShareData");
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
  
  protected String b()
  {
    Object localObject1 = this.a.getPollLayout();
    Object localObject2 = this.a.getInteractLayout();
    if ((localObject1 != null) && (((wur)localObject1).a != null) && (((wur)localObject1).a.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject2 + " · " + localObject1.a[0];
    }
    if ((localObject2 != null) && (((wuq)localObject2).a != null) && (((wuq)localObject2).a.length > 0))
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
  
  public void b(xhy paramxhy)
  {
    super.b(paramxhy);
    paramxhy.jdField_c_of_type_JavaLangString = this.i;
    paramxhy.a = this.jdField_d_of_type_JavaLangString;
    paramxhy.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramxhy.jdField_d_of_type_JavaLangString = a(4);
    paramxhy.jdField_c_of_type_Boolean = true;
    a(paramxhy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhm
 * JD-Core Version:    0.7.0.1
 */