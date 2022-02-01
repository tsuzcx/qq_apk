import android.view.View;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;

public class xci
{
  private xcw jdField_a_of_type_Xcw;
  private xcy jdField_a_of_type_Xcy;
  private xda jdField_a_of_type_Xda = new xcj(this);
  public xdu a;
  private xpz jdField_a_of_type_Xpz;
  private xda b = new xck(this);
  
  public void a(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_Xdu = new xdu(new xdl(paramMsgTabPlayInfo));
    this.jdField_a_of_type_Xpz = new xpz(this.jdField_a_of_type_Xdu);
    this.jdField_a_of_type_Xpz.b();
  }
  
  public void a(HomeFeedPlayInfo paramHomeFeedPlayInfo)
  {
    this.jdField_a_of_type_Xdu = new xdu(new xcr(paramHomeFeedPlayInfo));
    this.jdField_a_of_type_Xpz = new xpz(this.jdField_a_of_type_Xdu);
  }
  
  public void onClickTestDown(View paramView)
  {
    if (this.jdField_a_of_type_Xdu != null)
    {
      this.jdField_a_of_type_Xdu.a(this.b);
      this.jdField_a_of_type_Xdu.b(this.jdField_a_of_type_Xda);
      this.jdField_a_of_type_Xdu.a(this.jdField_a_of_type_Xcy, 2, 1, null);
    }
  }
  
  public void onClickTestUp(View paramView)
  {
    if (this.jdField_a_of_type_Xdu != null)
    {
      this.jdField_a_of_type_Xdu.b(this.b);
      this.jdField_a_of_type_Xdu.a(this.jdField_a_of_type_Xda);
      this.jdField_a_of_type_Xdu.a(this.jdField_a_of_type_Xcy, 0, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xci
 * JD-Core Version:    0.7.0.1
 */