import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class tre
  extends tqh
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
  
  public tre()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 1;
  }
  
  protected String a()
  {
    if (this.a.isPollVideo()) {
      return this.jdField_c_of_type_JavaLangString + ajya.a(2131716384);
    }
    if (this.a.isInteractVideo()) {
      return this.jdField_c_of_type_JavaLangString + ajya.a(2131716402);
    }
    if (this.a.isGameVideo())
    {
      tem localtem = this.a.getVideoGameInfo();
      if (localtem.a == 2) {
        return ajya.a(2131716386) + localtem.b + ajya.a(2131716366);
      }
      if (this.b == 0) {
        return ajya.a(2131716367) + localtem.b + localtem.jdField_c_of_type_JavaLangString + ajya.a(2131716401);
      }
      return this.a.mOwnerName + ajya.a(2131716376) + localtem.b + localtem.jdField_c_of_type_JavaLangString + ajya.a(2131716372);
    }
    return this.jdField_c_of_type_JavaLangString + ajya.a(2131716382) + ssf.a;
  }
  
  public final void a(trl paramtrl)
  {
    super.a(paramtrl);
    paramtrl.a = a(6);
    a(paramtrl);
  }
  
  protected void a(trm paramtrm) {}
  
  public final void a(trn paramtrn)
  {
    super.a(paramtrn);
    paramtrn.b = 0;
    paramtrn.jdField_d_of_type_JavaLangString = this.k;
    paramtrn.a = this.a.mVideoThumbnailUrl;
    paramtrn.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramtrn.j = this.l;
    paramtrn.h = a(1);
    if (this.jdField_c_of_type_Int != -1) {
      paramtrn.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_d_of_type_Int != -1) {
      paramtrn.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    }
    a(paramtrn);
  }
  
  public final void a(tro paramtro)
  {
    super.a(paramtro);
    paramtro.a = this.a.mVideoThumbnailUrl;
    paramtro.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramtro.jdField_d_of_type_JavaLangString = this.i;
    paramtro.jdField_e_of_type_JavaLangString = a(2);
    a(paramtro);
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
    a(paramtrp);
  }
  
  public void a(trq paramtrq)
  {
    super.a(paramtrq);
    paramtrq.jdField_c_of_type_JavaLangString = this.i;
    paramtrq.a = this.jdField_d_of_type_JavaLangString;
    paramtrq.jdField_d_of_type_JavaLangString = a(3);
    paramtrq.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtrq.jdField_c_of_type_Boolean = true;
    a(paramtrq);
  }
  
  protected void a_(trm paramtrm)
  {
    ved.b("VideoShareModeBase", "prepareCommonShareData");
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
  
  protected String b()
  {
    Object localObject1 = this.a.getPollLayout();
    Object localObject2 = this.a.getInteractLayout();
    if ((localObject1 != null) && (((tej)localObject1).a != null) && (((tej)localObject1).a.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject2 + " · " + localObject1.a[0];
    }
    if ((localObject2 != null) && (((tei)localObject2).a != null) && (((tei)localObject2).a.length > 0))
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
  
  public void b(trq paramtrq)
  {
    super.b(paramtrq);
    paramtrq.jdField_c_of_type_JavaLangString = this.i;
    paramtrq.a = this.jdField_d_of_type_JavaLangString;
    paramtrq.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtrq.jdField_d_of_type_JavaLangString = a(4);
    paramtrq.jdField_c_of_type_Boolean = true;
    a(paramtrq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tre
 * JD-Core Version:    0.7.0.1
 */