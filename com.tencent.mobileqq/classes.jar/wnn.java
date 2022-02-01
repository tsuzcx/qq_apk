import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;

public class wnn
{
  private wob jdField_a_of_type_Wob;
  private wod jdField_a_of_type_Wod;
  private wof jdField_a_of_type_Wof = new wno(this);
  public woz a;
  private xbe jdField_a_of_type_Xbe;
  private wof b = new wnp(this);
  
  public void a(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_Woz = new woz(new woq(paramMsgTabPlayInfo));
    this.jdField_a_of_type_Xbe = new xbe(this.jdField_a_of_type_Woz);
    this.jdField_a_of_type_Xbe.b();
  }
  
  public void a(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    this.jdField_a_of_type_Woz = new woz(new wnw(paramHomeFeedPlayInfo));
    this.jdField_a_of_type_Xbe = new xbe(this.jdField_a_of_type_Woz);
  }
  
  public void onClickTestDown(View paramView)
  {
    if (this.jdField_a_of_type_Woz != null)
    {
      this.jdField_a_of_type_Woz.a(this.b);
      this.jdField_a_of_type_Woz.b(this.jdField_a_of_type_Wof);
      this.jdField_a_of_type_Woz.a(this.jdField_a_of_type_Wod, 2, 1, null);
    }
  }
  
  public void onClickTestUp(View paramView)
  {
    if (this.jdField_a_of_type_Woz != null)
    {
      this.jdField_a_of_type_Woz.b(this.b);
      this.jdField_a_of_type_Woz.a(this.jdField_a_of_type_Wof);
      this.jdField_a_of_type_Woz.a(this.jdField_a_of_type_Wod, 0, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnn
 * JD-Core Version:    0.7.0.1
 */