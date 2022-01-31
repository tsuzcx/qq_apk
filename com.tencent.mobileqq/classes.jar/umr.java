import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1;

public class umr
  extends umy
  implements slx<ums, umt>
{
  private uma jdField_a_of_type_Uma;
  private boolean jdField_a_of_type_Boolean;
  
  public umr(uma paramuma)
  {
    this.jdField_a_of_type_Uma = paramuma;
  }
  
  public static boolean a(ulj paramulj)
  {
    if (paramulj == null) {
      throw new IllegalArgumentException("argument can't be null");
    }
    spz localspz = (spz)sqg.a(10);
    paramulj.jdField_b_of_type_Int = ((Integer)localspz.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
    if (((Integer)localspz.b("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramulj.jdField_c_of_type_Boolean = bool;
      paramulj.jdField_c_of_type_Int = ((Integer)localspz.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramulj.a = ((Integer)localspz.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramulj.jdField_b_of_type_JavaLangString = ((String)localspz.b("qqstory_my_newest_video_cover", ""));
      paramulj.jdField_c_of_type_JavaLangString = ((String)localspz.b("qqstory_my_newest_video_vid", ""));
      return true;
    }
  }
  
  public String a()
  {
    return "GetUserSelfInfoStep";
  }
  
  public void a()
  {
    urk.d("Q.qqstory.home.GetUserSelfInfoStep", "run");
    ums localums = new ums();
    slv.a().a(localums, this);
  }
  
  public void a(@NonNull ums paramums, @Nullable umt paramumt, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    urk.d("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (b())
    {
      urk.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      urk.c("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    paramums = (sqs)sqg.a(2);
    if (paramums.b(paramumt.a) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramumt.a;
      if (paramumt.jdField_b_of_type_Int != 1) {
        break label129;
      }
    }
    for (;;)
    {
      paramErrorMessage.isVip = bool;
      paramums.a(paramErrorMessage);
      if (this.jdField_a_of_type_Uma == null) {
        break;
      }
      this.jdField_a_of_type_Uma.a(new GetUserSelfInfoStep.1(this, paramumt));
      return;
      label129:
      bool = false;
    }
    urk.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramumt);
    paramums = (spz)sqg.a(10);
    paramums.b("qqstory_my_fans_count", Integer.valueOf(paramumt.jdField_c_of_type_Int));
    paramums.b("qqstory_i_am_vip", Integer.valueOf(paramumt.jdField_b_of_type_Int));
    paramums.b("qqstory_my_vidoe_count", Integer.valueOf(paramumt.jdField_d_of_type_Int));
    paramums.b("qqstory_my_visiter_count", Integer.valueOf(paramumt.e));
    paramums.b("qqstory_my_newest_video_cover", paramumt.jdField_c_of_type_JavaLangString);
    paramums.b("qqstory_my_newest_video_vid", paramumt.jdField_d_of_type_JavaLangString);
    QQStoryContext.a().a(paramumt.a);
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
 * Qualified Name:     umr
 * JD-Core Version:    0.7.0.1
 */