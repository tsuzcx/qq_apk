import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1;

public class xrc
  extends xrj
  implements vqp<xrd, xre>
{
  private xql jdField_a_of_type_Xql;
  private boolean jdField_a_of_type_Boolean;
  
  public xrc(xql paramxql)
  {
    this.jdField_a_of_type_Xql = paramxql;
  }
  
  public static boolean a(xpu paramxpu)
  {
    if (paramxpu == null) {
      throw new IllegalArgumentException("argument can't be null");
    }
    vuq localvuq = (vuq)vux.a(10);
    paramxpu.jdField_b_of_type_Int = ((Integer)localvuq.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
    if (((Integer)localvuq.b("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramxpu.jdField_c_of_type_Boolean = bool;
      paramxpu.jdField_c_of_type_Int = ((Integer)localvuq.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramxpu.a = ((Integer)localvuq.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramxpu.jdField_b_of_type_JavaLangString = ((String)localvuq.b("qqstory_my_newest_video_cover", ""));
      paramxpu.jdField_c_of_type_JavaLangString = ((String)localvuq.b("qqstory_my_newest_video_vid", ""));
      return true;
    }
  }
  
  public String a()
  {
    return "GetUserSelfInfoStep";
  }
  
  public void a()
  {
    xvv.d("Q.qqstory.home.GetUserSelfInfoStep", "run");
    xrd localxrd = new xrd();
    vqn.a().a(localxrd, this);
  }
  
  public void a(@NonNull xrd paramxrd, @Nullable xre paramxre, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    xvv.d("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (b())
    {
      xvv.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      xvv.c("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    paramxrd = (vvj)vux.a(2);
    if (paramxrd.b(paramxre.a) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramxre.a;
      if (paramxre.jdField_b_of_type_Int != 1) {
        break label129;
      }
    }
    for (;;)
    {
      paramErrorMessage.isVip = bool;
      paramxrd.a(paramErrorMessage);
      if (this.jdField_a_of_type_Xql == null) {
        break;
      }
      this.jdField_a_of_type_Xql.a(new GetUserSelfInfoStep.1(this, paramxre));
      return;
      label129:
      bool = false;
    }
    xvv.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramxre);
    paramxrd = (vuq)vux.a(10);
    paramxrd.b("qqstory_my_fans_count", Integer.valueOf(paramxre.jdField_c_of_type_Int));
    paramxrd.b("qqstory_i_am_vip", Integer.valueOf(paramxre.jdField_b_of_type_Int));
    paramxrd.b("qqstory_my_vidoe_count", Integer.valueOf(paramxre.jdField_d_of_type_Int));
    paramxrd.b("qqstory_my_visiter_count", Integer.valueOf(paramxre.e));
    paramxrd.b("qqstory_my_newest_video_cover", paramxre.jdField_c_of_type_JavaLangString);
    paramxrd.b("qqstory_my_newest_video_vid", paramxre.jdField_d_of_type_JavaLangString);
    QQStoryContext.a().a(paramxre.a);
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
 * Qualified Name:     xrc
 * JD-Core Version:    0.7.0.1
 */