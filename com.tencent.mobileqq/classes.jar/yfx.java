import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1;

public class yfx
  extends yge
  implements wfk<yfy, yfz>
{
  private yfg jdField_a_of_type_Yfg;
  private boolean jdField_a_of_type_Boolean;
  
  public yfx(yfg paramyfg)
  {
    this.jdField_a_of_type_Yfg = paramyfg;
  }
  
  public static boolean a(yep paramyep)
  {
    if (paramyep == null) {
      throw new IllegalArgumentException("argument can't be null");
    }
    wjl localwjl = (wjl)wjs.a(10);
    paramyep.jdField_b_of_type_Int = ((Integer)localwjl.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
    if (((Integer)localwjl.b("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramyep.jdField_c_of_type_Boolean = bool;
      paramyep.jdField_c_of_type_Int = ((Integer)localwjl.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramyep.a = ((Integer)localwjl.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramyep.jdField_b_of_type_JavaLangString = ((String)localwjl.b("qqstory_my_newest_video_cover", ""));
      paramyep.jdField_c_of_type_JavaLangString = ((String)localwjl.b("qqstory_my_newest_video_vid", ""));
      return true;
    }
  }
  
  public String a()
  {
    return "GetUserSelfInfoStep";
  }
  
  public void a()
  {
    ykq.d("Q.qqstory.home.GetUserSelfInfoStep", "run");
    yfy localyfy = new yfy();
    wfi.a().a(localyfy, this);
  }
  
  public void a(@NonNull yfy paramyfy, @Nullable yfz paramyfz, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    ykq.d("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (b())
    {
      ykq.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      ykq.c("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    paramyfy = (wke)wjs.a(2);
    if (paramyfy.b(paramyfz.a) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramyfz.a;
      if (paramyfz.jdField_b_of_type_Int != 1) {
        break label129;
      }
    }
    for (;;)
    {
      paramErrorMessage.isVip = bool;
      paramyfy.a(paramErrorMessage);
      if (this.jdField_a_of_type_Yfg == null) {
        break;
      }
      this.jdField_a_of_type_Yfg.a(new GetUserSelfInfoStep.1(this, paramyfz));
      return;
      label129:
      bool = false;
    }
    ykq.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramyfz);
    paramyfy = (wjl)wjs.a(10);
    paramyfy.b("qqstory_my_fans_count", Integer.valueOf(paramyfz.jdField_c_of_type_Int));
    paramyfy.b("qqstory_i_am_vip", Integer.valueOf(paramyfz.jdField_b_of_type_Int));
    paramyfy.b("qqstory_my_vidoe_count", Integer.valueOf(paramyfz.jdField_d_of_type_Int));
    paramyfy.b("qqstory_my_visiter_count", Integer.valueOf(paramyfz.e));
    paramyfy.b("qqstory_my_newest_video_cover", paramyfz.jdField_c_of_type_JavaLangString);
    paramyfy.b("qqstory_my_newest_video_vid", paramyfz.jdField_d_of_type_JavaLangString);
    QQStoryContext.a().a(paramyfz.a);
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
 * Qualified Name:     yfx
 * JD-Core Version:    0.7.0.1
 */