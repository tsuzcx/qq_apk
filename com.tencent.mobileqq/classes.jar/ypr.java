import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1;

public class ypr
  extends ypy
  implements woy<yps, ypt>
{
  private ypa jdField_a_of_type_Ypa;
  private boolean jdField_a_of_type_Boolean;
  
  public ypr(ypa paramypa)
  {
    this.jdField_a_of_type_Ypa = paramypa;
  }
  
  public static boolean a(yoj paramyoj)
  {
    if (paramyoj == null) {
      throw new IllegalArgumentException("argument can't be null");
    }
    wta localwta = (wta)wth.a(10);
    paramyoj.jdField_b_of_type_Int = ((Integer)localwta.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
    if (((Integer)localwta.b("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramyoj.jdField_c_of_type_Boolean = bool;
      paramyoj.jdField_c_of_type_Int = ((Integer)localwta.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramyoj.a = ((Integer)localwta.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramyoj.jdField_b_of_type_JavaLangString = ((String)localwta.b("qqstory_my_newest_video_cover", ""));
      paramyoj.jdField_c_of_type_JavaLangString = ((String)localwta.b("qqstory_my_newest_video_vid", ""));
      return true;
    }
  }
  
  public String a()
  {
    return "GetUserSelfInfoStep";
  }
  
  public void a()
  {
    yuk.d("Q.qqstory.home.GetUserSelfInfoStep", "run");
    yps localyps = new yps();
    wow.a().a(localyps, this);
  }
  
  public void a(@NonNull yps paramyps, @Nullable ypt paramypt, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    yuk.d("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (b())
    {
      yuk.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      yuk.c("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    paramyps = (wtt)wth.a(2);
    if (paramyps.b(paramypt.a) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramypt.a;
      if (paramypt.jdField_b_of_type_Int != 1) {
        break label129;
      }
    }
    for (;;)
    {
      paramErrorMessage.isVip = bool;
      paramyps.a(paramErrorMessage);
      if (this.jdField_a_of_type_Ypa == null) {
        break;
      }
      this.jdField_a_of_type_Ypa.a(new GetUserSelfInfoStep.1(this, paramypt));
      return;
      label129:
      bool = false;
    }
    yuk.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramypt);
    paramyps = (wta)wth.a(10);
    paramyps.b("qqstory_my_fans_count", Integer.valueOf(paramypt.jdField_c_of_type_Int));
    paramyps.b("qqstory_i_am_vip", Integer.valueOf(paramypt.jdField_b_of_type_Int));
    paramyps.b("qqstory_my_vidoe_count", Integer.valueOf(paramypt.jdField_d_of_type_Int));
    paramyps.b("qqstory_my_visiter_count", Integer.valueOf(paramypt.e));
    paramyps.b("qqstory_my_newest_video_cover", paramypt.jdField_c_of_type_JavaLangString);
    paramyps.b("qqstory_my_newest_video_vid", paramypt.jdField_d_of_type_JavaLangString);
    QQStoryContext.a().a(paramypt.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypr
 * JD-Core Version:    0.7.0.1
 */