import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;

public class tvy
{
  private twm jdField_a_of_type_Twm;
  private two jdField_a_of_type_Two;
  private twq jdField_a_of_type_Twq = new tvz(this);
  public txk a;
  private ujp jdField_a_of_type_Ujp;
  private twq b = new twa(this);
  
  public void a(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_Txk = new txk(new txb(paramMsgTabPlayInfo));
    this.jdField_a_of_type_Ujp = new ujp(this.jdField_a_of_type_Txk);
    this.jdField_a_of_type_Ujp.b();
  }
  
  public void a(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    this.jdField_a_of_type_Txk = new txk(new twh(paramHomeFeedPlayInfo));
    this.jdField_a_of_type_Ujp = new ujp(this.jdField_a_of_type_Txk);
  }
  
  public void onClickTestDown(View paramView)
  {
    this.jdField_a_of_type_Txk.a(this.b);
    this.jdField_a_of_type_Txk.b(this.jdField_a_of_type_Twq);
    this.jdField_a_of_type_Txk.a(this.jdField_a_of_type_Two, 2, 1, null);
  }
  
  public void onClickTestUp(View paramView)
  {
    this.jdField_a_of_type_Txk.b(this.b);
    this.jdField_a_of_type_Txk.a(this.jdField_a_of_type_Twq);
    this.jdField_a_of_type_Txk.a(this.jdField_a_of_type_Two, 0, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvy
 * JD-Core Version:    0.7.0.1
 */