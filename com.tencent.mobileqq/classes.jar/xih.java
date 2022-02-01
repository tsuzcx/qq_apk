import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;

public class xih
{
  private xiv jdField_a_of_type_Xiv;
  private xix jdField_a_of_type_Xix;
  private xiz jdField_a_of_type_Xiz = new xii(this);
  public xjt a;
  private xvy jdField_a_of_type_Xvy;
  private xiz b = new xij(this);
  
  public void a(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_Xjt = new xjt(new xjk(paramMsgTabPlayInfo));
    this.jdField_a_of_type_Xvy = new xvy(this.jdField_a_of_type_Xjt);
    this.jdField_a_of_type_Xvy.b();
  }
  
  public void a(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    this.jdField_a_of_type_Xjt = new xjt(new xiq(paramHomeFeedPlayInfo));
    this.jdField_a_of_type_Xvy = new xvy(this.jdField_a_of_type_Xjt);
  }
  
  public void onClickTestDown(View paramView)
  {
    if (this.jdField_a_of_type_Xjt != null)
    {
      this.jdField_a_of_type_Xjt.a(this.b);
      this.jdField_a_of_type_Xjt.b(this.jdField_a_of_type_Xiz);
      this.jdField_a_of_type_Xjt.a(this.jdField_a_of_type_Xix, 2, 1, null);
    }
  }
  
  public void onClickTestUp(View paramView)
  {
    if (this.jdField_a_of_type_Xjt != null)
    {
      this.jdField_a_of_type_Xjt.b(this.b);
      this.jdField_a_of_type_Xjt.a(this.jdField_a_of_type_Xiz);
      this.jdField_a_of_type_Xjt.a(this.jdField_a_of_type_Xix, 0, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xih
 * JD-Core Version:    0.7.0.1
 */