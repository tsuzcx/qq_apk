import android.text.TextUtils;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;

public class vla
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private vlb jdField_a_of_type_Vlb;
  private String b;
  private String c;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public vla a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    Object localObject2 = bjtz.b(QCircleFeedPicLoader.a(paramString));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = bjtz.a(paramString);
    }
    if (localObject1 == null)
    {
      localObject2 = new StringBuilder().append(vkx.a()).append(paramString);
      if (paramInt != 0) {
        break label122;
      }
      localObject1 = ".mp4";
      label65:
      this.c = ((String)localObject1);
      localObject1 = new StringBuilder().append(vkx.c()).append(paramString);
      if (paramInt != 0) {
        break label128;
      }
    }
    label128:
    for (paramString = ".mp4";; paramString = ".jpeg")
    {
      this.b = paramString;
      return this;
      paramString = (String)localObject1;
      break;
      label122:
      localObject1 = ".jpeg";
      break label65;
    }
  }
  
  public vla a(vlb paramvlb)
  {
    this.jdField_a_of_type_Vlb = paramvlb;
    return this;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vla
 * JD-Core Version:    0.7.0.1
 */