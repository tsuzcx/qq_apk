import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1;

public class ylw
  extends ymd
  implements wld<ylx, yly>
{
  private ylf jdField_a_of_type_Ylf;
  private boolean jdField_a_of_type_Boolean;
  
  public ylw(ylf paramylf)
  {
    this.jdField_a_of_type_Ylf = paramylf;
  }
  
  public static boolean a(yko paramyko)
  {
    if (paramyko == null) {
      throw new IllegalArgumentException("argument can't be null");
    }
    wpf localwpf = (wpf)wpm.a(10);
    paramyko.jdField_b_of_type_Int = ((Integer)localwpf.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
    if (((Integer)localwpf.b("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramyko.jdField_c_of_type_Boolean = bool;
      paramyko.jdField_c_of_type_Int = ((Integer)localwpf.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramyko.a = ((Integer)localwpf.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramyko.jdField_b_of_type_JavaLangString = ((String)localwpf.b("qqstory_my_newest_video_cover", ""));
      paramyko.jdField_c_of_type_JavaLangString = ((String)localwpf.b("qqstory_my_newest_video_vid", ""));
      return true;
    }
  }
  
  public String a()
  {
    return "GetUserSelfInfoStep";
  }
  
  public void a()
  {
    yqp.d("Q.qqstory.home.GetUserSelfInfoStep", "run");
    ylx localylx = new ylx();
    wlb.a().a(localylx, this);
  }
  
  public void a(@NonNull ylx paramylx, @Nullable yly paramyly, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    yqp.d("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (b())
    {
      yqp.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      yqp.c("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    paramylx = (wpy)wpm.a(2);
    if (paramylx.b(paramyly.a) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramyly.a;
      if (paramyly.jdField_b_of_type_Int != 1) {
        break label129;
      }
    }
    for (;;)
    {
      paramErrorMessage.isVip = bool;
      paramylx.a(paramErrorMessage);
      if (this.jdField_a_of_type_Ylf == null) {
        break;
      }
      this.jdField_a_of_type_Ylf.a(new GetUserSelfInfoStep.1(this, paramyly));
      return;
      label129:
      bool = false;
    }
    yqp.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramyly);
    paramylx = (wpf)wpm.a(10);
    paramylx.b("qqstory_my_fans_count", Integer.valueOf(paramyly.jdField_c_of_type_Int));
    paramylx.b("qqstory_i_am_vip", Integer.valueOf(paramyly.jdField_b_of_type_Int));
    paramylx.b("qqstory_my_vidoe_count", Integer.valueOf(paramyly.jdField_d_of_type_Int));
    paramylx.b("qqstory_my_visiter_count", Integer.valueOf(paramyly.e));
    paramylx.b("qqstory_my_newest_video_cover", paramyly.jdField_c_of_type_JavaLangString);
    paramylx.b("qqstory_my_newest_video_vid", paramyly.jdField_d_of_type_JavaLangString);
    QQStoryContext.a().a(paramyly.a);
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
 * Qualified Name:     ylw
 * JD-Core Version:    0.7.0.1
 */