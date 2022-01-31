import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public abstract class vpu
{
  public final int a;
  public final String a;
  public final int b;
  public String b;
  
  public vpu(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
  }
  
  @NonNull
  public abstract Class<? extends vpv> a();
  
  @NonNull
  public abstract vpv a(@NonNull Context paramContext, ViewGroup paramViewGroup);
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpu
 * JD-Core Version:    0.7.0.1
 */