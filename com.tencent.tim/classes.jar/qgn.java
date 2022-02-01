import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;

public class qgn
{
  private qgy.a a;
  public qhi a;
  private qgy.e jdField_b_of_type_Qgy$e = new qgo(this);
  private qoh jdField_b_of_type_Qoh;
  private qgy.c jdField_c_of_type_Qgy$c;
  private qgy.e jdField_c_of_type_Qgy$e = new qgp(this);
  
  public void a(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_Qhi = new qhi(new qhc(paramMsgTabPlayInfo));
    this.jdField_b_of_type_Qoh = new qoh(this.jdField_a_of_type_Qhi);
    this.jdField_b_of_type_Qoh.create();
  }
  
  public void a(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    this.jdField_a_of_type_Qhi = new qhi(new qgu(paramHomeFeedPlayInfo));
    this.jdField_b_of_type_Qoh = new qoh(this.jdField_a_of_type_Qhi);
  }
  
  public void onClickTestDown(View paramView)
  {
    if (this.jdField_a_of_type_Qhi != null)
    {
      this.jdField_a_of_type_Qhi.a(this.jdField_c_of_type_Qgy$e);
      this.jdField_a_of_type_Qhi.b(this.jdField_b_of_type_Qgy$e);
      this.jdField_a_of_type_Qhi.a(this.jdField_c_of_type_Qgy$c, 2, 1, null);
    }
  }
  
  public void onClickTestUp(View paramView)
  {
    if (this.jdField_a_of_type_Qhi != null)
    {
      this.jdField_a_of_type_Qhi.b(this.jdField_c_of_type_Qgy$e);
      this.jdField_a_of_type_Qhi.a(this.jdField_b_of_type_Qgy$e);
      this.jdField_a_of_type_Qhi.a(this.jdField_c_of_type_Qgy$c, 0, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgn
 * JD-Core Version:    0.7.0.1
 */