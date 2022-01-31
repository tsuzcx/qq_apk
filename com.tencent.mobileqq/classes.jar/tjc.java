import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;

public class tjc
{
  private tjq jdField_a_of_type_Tjq;
  private tjs jdField_a_of_type_Tjs;
  private tju jdField_a_of_type_Tju = new tjd(this);
  public tko a;
  private twt jdField_a_of_type_Twt;
  private tju b = new tje(this);
  
  public void a(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_Tko = new tko(new tkf(paramMsgTabPlayInfo));
    this.jdField_a_of_type_Twt = new twt(this.jdField_a_of_type_Tko);
    this.jdField_a_of_type_Twt.b();
  }
  
  public void a(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    this.jdField_a_of_type_Tko = new tko(new tjl(paramHomeFeedPlayInfo));
    this.jdField_a_of_type_Twt = new twt(this.jdField_a_of_type_Tko);
  }
  
  public void onClickTestDown(View paramView)
  {
    this.jdField_a_of_type_Tko.a(this.b);
    this.jdField_a_of_type_Tko.b(this.jdField_a_of_type_Tju);
    this.jdField_a_of_type_Tko.a(this.jdField_a_of_type_Tjs, 2, 1, null);
  }
  
  public void onClickTestUp(View paramView)
  {
    this.jdField_a_of_type_Tko.b(this.b);
    this.jdField_a_of_type_Tko.a(this.jdField_a_of_type_Tju);
    this.jdField_a_of_type_Tko.a(this.jdField_a_of_type_Tjs, 0, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjc
 * JD-Core Version:    0.7.0.1
 */