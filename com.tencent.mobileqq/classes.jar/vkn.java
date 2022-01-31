import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;

public class vkn
{
  private vlb jdField_a_of_type_Vlb;
  private vld jdField_a_of_type_Vld;
  private vlf jdField_a_of_type_Vlf = new vko(this);
  public vlz a;
  private vye jdField_a_of_type_Vye;
  private vlf b = new vkp(this);
  
  public void a(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_Vlz = new vlz(new vlq(paramMsgTabPlayInfo));
    this.jdField_a_of_type_Vye = new vye(this.jdField_a_of_type_Vlz);
    this.jdField_a_of_type_Vye.b();
  }
  
  public void a(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    this.jdField_a_of_type_Vlz = new vlz(new vkw(paramHomeFeedPlayInfo));
    this.jdField_a_of_type_Vye = new vye(this.jdField_a_of_type_Vlz);
  }
  
  public void onClickTestDown(View paramView)
  {
    this.jdField_a_of_type_Vlz.a(this.b);
    this.jdField_a_of_type_Vlz.b(this.jdField_a_of_type_Vlf);
    this.jdField_a_of_type_Vlz.a(this.jdField_a_of_type_Vld, 2, 1, null);
  }
  
  public void onClickTestUp(View paramView)
  {
    this.jdField_a_of_type_Vlz.b(this.b);
    this.jdField_a_of_type_Vlz.a(this.jdField_a_of_type_Vlf);
    this.jdField_a_of_type_Vlz.a(this.jdField_a_of_type_Vld, 0, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkn
 * JD-Core Version:    0.7.0.1
 */