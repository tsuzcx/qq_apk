import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;

public class vow
{
  private vpk jdField_a_of_type_Vpk;
  private vpm jdField_a_of_type_Vpm;
  private vpo jdField_a_of_type_Vpo = new vox(this);
  public vqi a;
  private wcn jdField_a_of_type_Wcn;
  private vpo b = new voy(this);
  
  public void a(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_Vqi = new vqi(new vpz(paramMsgTabPlayInfo));
    this.jdField_a_of_type_Wcn = new wcn(this.jdField_a_of_type_Vqi);
    this.jdField_a_of_type_Wcn.b();
  }
  
  public void a(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    this.jdField_a_of_type_Vqi = new vqi(new vpf(paramHomeFeedPlayInfo));
    this.jdField_a_of_type_Wcn = new wcn(this.jdField_a_of_type_Vqi);
  }
  
  public void onClickTestDown(View paramView)
  {
    this.jdField_a_of_type_Vqi.a(this.b);
    this.jdField_a_of_type_Vqi.b(this.jdField_a_of_type_Vpo);
    this.jdField_a_of_type_Vqi.a(this.jdField_a_of_type_Vpm, 2, 1, null);
  }
  
  public void onClickTestUp(View paramView)
  {
    this.jdField_a_of_type_Vqi.b(this.b);
    this.jdField_a_of_type_Vqi.a(this.jdField_a_of_type_Vpo);
    this.jdField_a_of_type_Vqi.a(this.jdField_a_of_type_Vpm, 0, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vow
 * JD-Core Version:    0.7.0.1
 */