import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.List;

public class yxj
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  String jdField_a_of_type_JavaLangString;
  private List<yxj> jdField_a_of_type_JavaUtilList;
  String b;
  String c;
  String d;
  private String e;
  private String f;
  
  public yxj(String paramString1, String paramString2, Drawable paramDrawable, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.e = paramString2;
    this.f = paramString1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public String a()
  {
    return this.e;
  }
  
  public yxj a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (yxj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo.logo_url.has()) {
      this.jdField_a_of_type_JavaLangString = paramButtonInfo.logo_url.get();
    }
    if (paramButtonInfo.texture_url.has()) {
      this.d = paramButtonInfo.texture_url.get();
    }
    if (paramButtonInfo.bg_colors.has())
    {
      paramButtonInfo = paramButtonInfo.bg_colors.get().split("\\|");
      if (paramButtonInfo.length > 0) {
        this.b = paramButtonInfo[0];
      }
      if (paramButtonInfo.length > 1) {
        this.c = paramButtonInfo[1];
      }
    }
  }
  
  public void a(yxj paramyxj)
  {
    if (paramyxj == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramyxj);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList != null;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String b()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxj
 * JD-Core Version:    0.7.0.1
 */