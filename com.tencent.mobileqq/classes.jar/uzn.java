import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1;

public class uzn
  extends uzu
  implements syt<uzo, uzp>
{
  private uyw jdField_a_of_type_Uyw;
  private boolean jdField_a_of_type_Boolean;
  
  public uzn(uyw paramuyw)
  {
    this.jdField_a_of_type_Uyw = paramuyw;
  }
  
  public static boolean a(uyf paramuyf)
  {
    if (paramuyf == null) {
      throw new IllegalArgumentException("argument can't be null");
    }
    tcv localtcv = (tcv)tdc.a(10);
    paramuyf.jdField_b_of_type_Int = ((Integer)localtcv.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
    if (((Integer)localtcv.b("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramuyf.jdField_c_of_type_Boolean = bool;
      paramuyf.jdField_c_of_type_Int = ((Integer)localtcv.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramuyf.a = ((Integer)localtcv.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramuyf.jdField_b_of_type_JavaLangString = ((String)localtcv.b("qqstory_my_newest_video_cover", ""));
      paramuyf.jdField_c_of_type_JavaLangString = ((String)localtcv.b("qqstory_my_newest_video_vid", ""));
      return true;
    }
  }
  
  public String a()
  {
    return "GetUserSelfInfoStep";
  }
  
  public void a()
  {
    veg.d("Q.qqstory.home.GetUserSelfInfoStep", "run");
    uzo localuzo = new uzo();
    syr.a().a(localuzo, this);
  }
  
  public void a(@NonNull uzo paramuzo, @Nullable uzp paramuzp, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    veg.d("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (b())
    {
      veg.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      d();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      veg.c("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    paramuzo = (tdo)tdc.a(2);
    if (paramuzo.b(paramuzp.a) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramuzp.a;
      if (paramuzp.jdField_b_of_type_Int != 1) {
        break label129;
      }
    }
    for (;;)
    {
      paramErrorMessage.isVip = bool;
      paramuzo.a(paramErrorMessage);
      if (this.jdField_a_of_type_Uyw == null) {
        break;
      }
      this.jdField_a_of_type_Uyw.a(new GetUserSelfInfoStep.1(this, paramuzp));
      return;
      label129:
      bool = false;
    }
    veg.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramuzp);
    paramuzo = (tcv)tdc.a(10);
    paramuzo.b("qqstory_my_fans_count", Integer.valueOf(paramuzp.jdField_c_of_type_Int));
    paramuzo.b("qqstory_i_am_vip", Integer.valueOf(paramuzp.jdField_b_of_type_Int));
    paramuzo.b("qqstory_my_vidoe_count", Integer.valueOf(paramuzp.jdField_d_of_type_Int));
    paramuzo.b("qqstory_my_visiter_count", Integer.valueOf(paramuzp.e));
    paramuzo.b("qqstory_my_newest_video_cover", paramuzp.jdField_c_of_type_JavaLangString);
    paramuzo.b("qqstory_my_newest_video_vid", paramuzp.jdField_d_of_type_JavaLangString);
    QQStoryContext.a().a(paramuzp.a);
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
 * Qualified Name:     uzn
 * JD-Core Version:    0.7.0.1
 */