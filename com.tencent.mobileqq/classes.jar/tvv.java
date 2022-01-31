import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;

public class tvv
{
  private twj jdField_a_of_type_Twj;
  private twl jdField_a_of_type_Twl;
  private twn jdField_a_of_type_Twn = new tvw(this);
  public txh a;
  private ujm jdField_a_of_type_Ujm;
  private twn b = new tvx(this);
  
  public void a(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_Txh = new txh(new twy(paramMsgTabPlayInfo));
    this.jdField_a_of_type_Ujm = new ujm(this.jdField_a_of_type_Txh);
    this.jdField_a_of_type_Ujm.b();
  }
  
  public void a(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    this.jdField_a_of_type_Txh = new txh(new twe(paramHomeFeedPlayInfo));
    this.jdField_a_of_type_Ujm = new ujm(this.jdField_a_of_type_Txh);
  }
  
  public void onClickTestDown(View paramView)
  {
    this.jdField_a_of_type_Txh.a(this.b);
    this.jdField_a_of_type_Txh.b(this.jdField_a_of_type_Twn);
    this.jdField_a_of_type_Txh.a(this.jdField_a_of_type_Twl, 2, 1, null);
  }
  
  public void onClickTestUp(View paramView)
  {
    this.jdField_a_of_type_Txh.b(this.b);
    this.jdField_a_of_type_Txh.a(this.jdField_a_of_type_Twn);
    this.jdField_a_of_type_Txh.a(this.jdField_a_of_type_Twl, 0, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvv
 * JD-Core Version:    0.7.0.1
 */