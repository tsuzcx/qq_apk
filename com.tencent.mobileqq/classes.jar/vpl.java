import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;

public class vpl
  extends vpn
{
  public ErrorMessage a;
  
  public vpl(vpm paramvpm, @Nullable ErrorMessage paramErrorMessage)
  {
    super(paramvpm);
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
    return "fg{g=" + this.jdField_a_of_type_Vpm + ", em=" + this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpl
 * JD-Core Version:    0.7.0.1
 */