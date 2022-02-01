import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;

public class woc
  extends woe
{
  public ErrorMessage a;
  
  public woc(wod paramwod, @Nullable ErrorMessage paramErrorMessage)
  {
    super(paramwod);
    if (paramErrorMessage == null) {}
    for (this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(97000001, "loading");; this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode == 97000000;
  }
  
  public boolean b()
  {
    return (!a()) && (!c());
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode == 97000001;
  }
  
  public String toString()
  {
    return "fg{g=" + this.jdField_a_of_type_Wod + ", em=" + this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     woc
 * JD-Core Version:    0.7.0.1
 */