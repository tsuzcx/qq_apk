import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class ajzr
  implements ajzq
{
  private ajvz jdField_a_of_type_Ajvz;
  private ajxz jdField_a_of_type_Ajxz;
  private VideoData b;
  private int mCurrentPageIndex;
  
  public ajzr(ajxz paramajxz, VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Ajxz = paramajxz;
    this.jdField_a_of_type_Ajvz = new ajwa(paramVideoData, paramQQAppInterface);
    this.b = paramVideoData;
  }
  
  public int GI()
  {
    return this.mCurrentPageIndex;
  }
  
  public void dAm()
  {
    if (this.jdField_a_of_type_Ajxz != null) {
      this.jdField_a_of_type_Ajxz.showLoading();
    }
    this.jdField_a_of_type_Ajvz.a(this.mCurrentPageIndex, new ajzs(this));
  }
  
  public void l(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Ajvz.a(paramComment, new ajzt(this));
  }
  
  public void m(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Ajvz.a(paramComment, new ajzu(this));
  }
  
  public void release()
  {
    this.jdField_a_of_type_Ajxz = null;
  }
  
  public void start()
  {
    this.mCurrentPageIndex = 0;
    dAm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzr
 * JD-Core Version:    0.7.0.1
 */