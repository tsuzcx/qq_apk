import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;

public class xmc
{
  private xmq jdField_a_of_type_Xmq;
  private xms jdField_a_of_type_Xms;
  private xmu jdField_a_of_type_Xmu = new xmd(this);
  public xno a;
  private xzt jdField_a_of_type_Xzt;
  private xmu b = new xme(this);
  
  public void a(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_Xno = new xno(new xnf(paramMsgTabPlayInfo));
    this.jdField_a_of_type_Xzt = new xzt(this.jdField_a_of_type_Xno);
    this.jdField_a_of_type_Xzt.b();
  }
  
  public void a(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    this.jdField_a_of_type_Xno = new xno(new xml(paramHomeFeedPlayInfo));
    this.jdField_a_of_type_Xzt = new xzt(this.jdField_a_of_type_Xno);
  }
  
  public void onClickTestDown(View paramView)
  {
    if (this.jdField_a_of_type_Xno != null)
    {
      this.jdField_a_of_type_Xno.a(this.b);
      this.jdField_a_of_type_Xno.b(this.jdField_a_of_type_Xmu);
      this.jdField_a_of_type_Xno.a(this.jdField_a_of_type_Xms, 2, 1, null);
    }
  }
  
  public void onClickTestUp(View paramView)
  {
    if (this.jdField_a_of_type_Xno != null)
    {
      this.jdField_a_of_type_Xno.b(this.b);
      this.jdField_a_of_type_Xno.a(this.jdField_a_of_type_Xmu);
      this.jdField_a_of_type_Xno.a(this.jdField_a_of_type_Xms, 0, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmc
 * JD-Core Version:    0.7.0.1
 */