import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1;

public class uzk
  extends uzr
  implements syq<uzl, uzm>
{
  private uyt jdField_a_of_type_Uyt;
  private boolean jdField_a_of_type_Boolean;
  
  public uzk(uyt paramuyt)
  {
    this.jdField_a_of_type_Uyt = paramuyt;
  }
  
  public static boolean a(uyc paramuyc)
  {
    if (paramuyc == null) {
      throw new IllegalArgumentException("argument can't be null");
    }
    tcs localtcs = (tcs)tcz.a(10);
    paramuyc.jdField_b_of_type_Int = ((Integer)localtcs.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
    if (((Integer)localtcs.b("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramuyc.jdField_c_of_type_Boolean = bool;
      paramuyc.jdField_c_of_type_Int = ((Integer)localtcs.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramuyc.a = ((Integer)localtcs.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramuyc.jdField_b_of_type_JavaLangString = ((String)localtcs.b("qqstory_my_newest_video_cover", ""));
      paramuyc.jdField_c_of_type_JavaLangString = ((String)localtcs.b("qqstory_my_newest_video_vid", ""));
      return true;
    }
  }
  
  public String a()
  {
    return "GetUserSelfInfoStep";
  }
  
  public void a()
  {
    ved.d("Q.qqstory.home.GetUserSelfInfoStep", "run");
    uzl localuzl = new uzl();
    syo.a().a(localuzl, this);
  }
  
  public void a(@NonNull uzl paramuzl, @Nullable uzm paramuzm, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    ved.d("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (b())
    {
      ved.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      ved.c("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    paramuzl = (tdl)tcz.a(2);
    if (paramuzl.b(paramuzm.a) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramuzm.a;
      if (paramuzm.jdField_b_of_type_Int != 1) {
        break label129;
      }
    }
    for (;;)
    {
      paramErrorMessage.isVip = bool;
      paramuzl.a(paramErrorMessage);
      if (this.jdField_a_of_type_Uyt == null) {
        break;
      }
      this.jdField_a_of_type_Uyt.a(new GetUserSelfInfoStep.1(this, paramuzm));
      return;
      label129:
      bool = false;
    }
    ved.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramuzm);
    paramuzl = (tcs)tcz.a(10);
    paramuzl.b("qqstory_my_fans_count", Integer.valueOf(paramuzm.jdField_c_of_type_Int));
    paramuzl.b("qqstory_i_am_vip", Integer.valueOf(paramuzm.jdField_b_of_type_Int));
    paramuzl.b("qqstory_my_vidoe_count", Integer.valueOf(paramuzm.jdField_d_of_type_Int));
    paramuzl.b("qqstory_my_visiter_count", Integer.valueOf(paramuzm.e));
    paramuzl.b("qqstory_my_newest_video_cover", paramuzm.jdField_c_of_type_JavaLangString);
    paramuzl.b("qqstory_my_newest_video_vid", paramuzm.jdField_d_of_type_JavaLangString);
    QQStoryContext.a().a(paramuzm.a);
    d();
  }
  
  public void b() {}
  
  public boolean b()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzk
 * JD-Core Version:    0.7.0.1
 */