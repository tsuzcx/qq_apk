import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1;

public class wsl
  extends wss
  implements urr<wsm, wsn>
{
  private wru jdField_a_of_type_Wru;
  private boolean jdField_a_of_type_Boolean;
  
  public wsl(wru paramwru)
  {
    this.jdField_a_of_type_Wru = paramwru;
  }
  
  public static boolean a(wrd paramwrd)
  {
    if (paramwrd == null) {
      throw new IllegalArgumentException("argument can't be null");
    }
    uvt localuvt = (uvt)uwa.a(10);
    paramwrd.jdField_b_of_type_Int = ((Integer)localuvt.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
    if (((Integer)localuvt.b("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramwrd.jdField_c_of_type_Boolean = bool;
      paramwrd.jdField_c_of_type_Int = ((Integer)localuvt.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramwrd.a = ((Integer)localuvt.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramwrd.jdField_b_of_type_JavaLangString = ((String)localuvt.b("qqstory_my_newest_video_cover", ""));
      paramwrd.jdField_c_of_type_JavaLangString = ((String)localuvt.b("qqstory_my_newest_video_vid", ""));
      return true;
    }
  }
  
  public String a()
  {
    return "GetUserSelfInfoStep";
  }
  
  public void a()
  {
    wxe.d("Q.qqstory.home.GetUserSelfInfoStep", "run");
    wsm localwsm = new wsm();
    urp.a().a(localwsm, this);
  }
  
  public void a(@NonNull wsm paramwsm, @Nullable wsn paramwsn, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    wxe.d("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (b())
    {
      wxe.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      wxe.c("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    paramwsm = (uwm)uwa.a(2);
    if (paramwsm.b(paramwsn.a) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramwsn.a;
      if (paramwsn.jdField_b_of_type_Int != 1) {
        break label129;
      }
    }
    for (;;)
    {
      paramErrorMessage.isVip = bool;
      paramwsm.a(paramErrorMessage);
      if (this.jdField_a_of_type_Wru == null) {
        break;
      }
      this.jdField_a_of_type_Wru.a(new GetUserSelfInfoStep.1(this, paramwsn));
      return;
      label129:
      bool = false;
    }
    wxe.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramwsn);
    paramwsm = (uvt)uwa.a(10);
    paramwsm.b("qqstory_my_fans_count", Integer.valueOf(paramwsn.jdField_c_of_type_Int));
    paramwsm.b("qqstory_i_am_vip", Integer.valueOf(paramwsn.jdField_b_of_type_Int));
    paramwsm.b("qqstory_my_vidoe_count", Integer.valueOf(paramwsn.jdField_d_of_type_Int));
    paramwsm.b("qqstory_my_visiter_count", Integer.valueOf(paramwsn.e));
    paramwsm.b("qqstory_my_newest_video_cover", paramwsn.jdField_c_of_type_JavaLangString);
    paramwsm.b("qqstory_my_newest_video_vid", paramwsn.jdField_d_of_type_JavaLangString);
    QQStoryContext.a().a(paramwsn.a);
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
 * Qualified Name:     wsl
 * JD-Core Version:    0.7.0.1
 */