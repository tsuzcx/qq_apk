import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class wjc
  extends wif
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
  
  public wjc()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 1;
  }
  
  protected String a()
  {
    if (this.a.isPollVideo()) {
      return this.jdField_c_of_type_JavaLangString + amtj.a(2131715388);
    }
    if (this.a.isInteractVideo()) {
      return this.jdField_c_of_type_JavaLangString + amtj.a(2131715406);
    }
    if (this.a.isGameVideo())
    {
      vwk localvwk = this.a.getVideoGameInfo();
      if (localvwk.a == 2) {
        return amtj.a(2131715390) + localvwk.b + amtj.a(2131715370);
      }
      if (this.b == 0) {
        return amtj.a(2131715371) + localvwk.b + localvwk.jdField_c_of_type_JavaLangString + amtj.a(2131715405);
      }
      return this.a.mOwnerName + amtj.a(2131715380) + localvwk.b + localvwk.jdField_c_of_type_JavaLangString + amtj.a(2131715376);
    }
    return this.jdField_c_of_type_JavaLangString + amtj.a(2131715386) + vkm.a;
  }
  
  public final void a(wjj paramwjj)
  {
    super.a(paramwjj);
    paramwjj.a = a(6);
    a(paramwjj);
  }
  
  protected void a(wjk paramwjk) {}
  
  public final void a(wjl paramwjl)
  {
    super.a(paramwjl);
    paramwjl.b = 0;
    paramwjl.jdField_d_of_type_JavaLangString = this.k;
    paramwjl.a = this.a.mVideoThumbnailUrl;
    paramwjl.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramwjl.j = this.l;
    paramwjl.h = a(1);
    if (this.jdField_c_of_type_Int != -1) {
      paramwjl.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_d_of_type_Int != -1) {
      paramwjl.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    }
    a(paramwjl);
  }
  
  public final void a(wjm paramwjm)
  {
    super.a(paramwjm);
    paramwjm.a = this.a.mVideoThumbnailUrl;
    paramwjm.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramwjm.jdField_d_of_type_JavaLangString = this.i;
    paramwjm.jdField_e_of_type_JavaLangString = a(2);
    a(paramwjm);
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
    a(paramwjn);
  }
  
  public void a(wjo paramwjo)
  {
    super.a(paramwjo);
    paramwjo.jdField_c_of_type_JavaLangString = this.i;
    paramwjo.a = this.jdField_d_of_type_JavaLangString;
    paramwjo.jdField_d_of_type_JavaLangString = a(3);
    paramwjo.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramwjo.jdField_c_of_type_Boolean = true;
    a(paramwjo);
  }
  
  protected void a_(wjk paramwjk)
  {
    xvv.b("VideoShareModeBase", "prepareCommonShareData");
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
  
  protected String b()
  {
    Object localObject1 = this.a.getPollLayout();
    Object localObject2 = this.a.getInteractLayout();
    if ((localObject1 != null) && (((vwh)localObject1).a != null) && (((vwh)localObject1).a.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject2 + " · " + localObject1.a[0];
    }
    if ((localObject2 != null) && (((vwg)localObject2).a != null) && (((vwg)localObject2).a.length > 0))
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
  
  public void b(wjo paramwjo)
  {
    super.b(paramwjo);
    paramwjo.jdField_c_of_type_JavaLangString = this.i;
    paramwjo.a = this.jdField_d_of_type_JavaLangString;
    paramwjo.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramwjo.jdField_d_of_type_JavaLangString = a(4);
    paramwjo.jdField_c_of_type_Boolean = true;
    a(paramwjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjc
 * JD-Core Version:    0.7.0.1
 */