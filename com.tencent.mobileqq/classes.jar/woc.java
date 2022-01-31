import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1;

public class woc
  extends woj
  implements uni<wod, woe>
{
  private wnl jdField_a_of_type_Wnl;
  private boolean jdField_a_of_type_Boolean;
  
  public woc(wnl paramwnl)
  {
    this.jdField_a_of_type_Wnl = paramwnl;
  }
  
  public static boolean a(wmu paramwmu)
  {
    if (paramwmu == null) {
      throw new IllegalArgumentException("argument can't be null");
    }
    urk localurk = (urk)urr.a(10);
    paramwmu.jdField_b_of_type_Int = ((Integer)localurk.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
    if (((Integer)localurk.b("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramwmu.jdField_c_of_type_Boolean = bool;
      paramwmu.jdField_c_of_type_Int = ((Integer)localurk.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramwmu.a = ((Integer)localurk.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramwmu.jdField_b_of_type_JavaLangString = ((String)localurk.b("qqstory_my_newest_video_cover", ""));
      paramwmu.jdField_c_of_type_JavaLangString = ((String)localurk.b("qqstory_my_newest_video_vid", ""));
      return true;
    }
  }
  
  public String a()
  {
    return "GetUserSelfInfoStep";
  }
  
  public void a()
  {
    wsv.d("Q.qqstory.home.GetUserSelfInfoStep", "run");
    wod localwod = new wod();
    ung.a().a(localwod, this);
  }
  
  public void a(@NonNull wod paramwod, @Nullable woe paramwoe, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    wsv.d("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (b())
    {
      wsv.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      wsv.c("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    paramwod = (usd)urr.a(2);
    if (paramwod.b(paramwoe.a) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramwoe.a;
      if (paramwoe.jdField_b_of_type_Int != 1) {
        break label129;
      }
    }
    for (;;)
    {
      paramErrorMessage.isVip = bool;
      paramwod.a(paramErrorMessage);
      if (this.jdField_a_of_type_Wnl == null) {
        break;
      }
      this.jdField_a_of_type_Wnl.a(new GetUserSelfInfoStep.1(this, paramwoe));
      return;
      label129:
      bool = false;
    }
    wsv.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramwoe);
    paramwod = (urk)urr.a(10);
    paramwod.b("qqstory_my_fans_count", Integer.valueOf(paramwoe.jdField_c_of_type_Int));
    paramwod.b("qqstory_i_am_vip", Integer.valueOf(paramwoe.jdField_b_of_type_Int));
    paramwod.b("qqstory_my_vidoe_count", Integer.valueOf(paramwoe.jdField_d_of_type_Int));
    paramwod.b("qqstory_my_visiter_count", Integer.valueOf(paramwoe.e));
    paramwod.b("qqstory_my_newest_video_cover", paramwoe.jdField_c_of_type_JavaLangString);
    paramwod.b("qqstory_my_newest_video_vid", paramwoe.jdField_d_of_type_JavaLangString);
    QQStoryContext.a().a(paramwoe.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     woc
 * JD-Core Version:    0.7.0.1
 */