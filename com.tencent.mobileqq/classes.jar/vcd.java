import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class vcd
  extends vbx
{
  public int a;
  public final List<String> a;
  public boolean a;
  public int b;
  public String e;
  public String f;
  
  public vcd(@NonNull String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_Int = 100;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String a()
  {
    return "NormalFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.f)) {}
    do
    {
      Object localObject1;
      do
      {
        return false;
        localObject1 = new File(this.f);
      } while (!((File)localObject1).exists());
      this.jdField_a_of_type_JavaUtilList.clear();
      if (((File)localObject1).isDirectory())
      {
        localObject1 = ((File)localObject1).listFiles(new vce(this));
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            this.jdField_a_of_type_JavaUtilList.add(localObject2.toURI().toString());
            i += 1;
          }
          Collections.sort(this.jdField_a_of_type_JavaUtilList);
        }
      }
    } while (this.jdField_a_of_type_JavaUtilList.isEmpty());
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("NormalFacePackage{");
    localStringBuffer.append("id='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append("logoUrl='").append(this.c).append('\'');
    localStringBuffer.append("logoDrawable='").append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).append('\'');
    localStringBuffer.append(", zipDownloadUrl='").append(this.e).append('\'');
    localStringBuffer.append(", facePkgPath='").append(this.f).append('\'');
    localStringBuffer.append(", faceUriList=").append(this.jdField_a_of_type_JavaUtilList);
    localStringBuffer.append(", isDownloading=").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", maxProgress=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", currentProgress=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcd
 * JD-Core Version:    0.7.0.1
 */