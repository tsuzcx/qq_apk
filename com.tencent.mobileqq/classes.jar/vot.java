import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class vot
  extends voq
{
  public List<vou> a;
  public boolean a;
  
  public vot(@NonNull String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String a()
  {
    return "LocationFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((vou)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString;
    }
    throw new IndexOutOfBoundsException("getThumbUri with illegal index : " + paramInt + ", the item size is : " + this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((vou)this.jdField_a_of_type_JavaUtilList.get(paramInt)).b;
    }
    throw new IndexOutOfBoundsException("getCategory with illegal index : " + paramInt + ", the item size is : " + this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LocationFacePackage{");
    localStringBuffer.append("id='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append("logoUrl='").append(this.c).append('\'');
    localStringBuffer.append("logoDrawable='").append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).append('\'');
    localStringBuffer.append("items=").append(this.jdField_a_of_type_JavaUtilList);
    localStringBuffer.append(", isLocating=").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vot
 * JD-Core Version:    0.7.0.1
 */