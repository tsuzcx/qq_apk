import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class vuq
{
  protected int a;
  protected avzo a;
  protected String a;
  protected String b;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, vup paramvup)
  {
    if (paramvup != null)
    {
      vto localvto = new vto();
      localvto.jdField_a_of_type_Long = paramvup.b;
      localvto.jdField_a_of_type_Int = paramInt;
      localvto.jdField_b_of_type_JavaLangString = paramString2;
      localvto.jdField_a_of_type_JavaLangString = paramString1;
      localvto.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      localvto.c = this.jdField_b_of_type_JavaLangString;
      localvto.jdField_a_of_type_Boolean = false;
      localvto.jdField_b_of_type_Int = 1;
      if (paramSlideItemInfo != null)
      {
        localvto.jdField_a_of_type_Boolean = paramSlideItemInfo.jdField_a_of_type_Boolean;
        localvto.jdField_b_of_type_Int = paramSlideItemInfo.c;
      }
      if (paramvup.a != null) {
        paramvup.a.a(localvto);
      }
    }
  }
  
  protected boolean a(vup paramvup)
  {
    if ((!paramvup.d) && (QLog.isColorLevel())) {
      QLog.d("ToVideoConverter", 2, "run exit:" + paramvup.b + " currContext.isRun:" + paramvup.d);
    }
    return !paramvup.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vuq
 * JD-Core Version:    0.7.0.1
 */