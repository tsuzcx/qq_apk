import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class vut
{
  protected int a;
  protected avzm a;
  protected String a;
  protected String b;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, vus paramvus)
  {
    if (paramvus != null)
    {
      vtr localvtr = new vtr();
      localvtr.jdField_a_of_type_Long = paramvus.b;
      localvtr.jdField_a_of_type_Int = paramInt;
      localvtr.jdField_b_of_type_JavaLangString = paramString2;
      localvtr.jdField_a_of_type_JavaLangString = paramString1;
      localvtr.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      localvtr.c = this.jdField_b_of_type_JavaLangString;
      localvtr.jdField_a_of_type_Boolean = false;
      localvtr.jdField_b_of_type_Int = 1;
      if (paramSlideItemInfo != null)
      {
        localvtr.jdField_a_of_type_Boolean = paramSlideItemInfo.jdField_a_of_type_Boolean;
        localvtr.jdField_b_of_type_Int = paramSlideItemInfo.c;
      }
      if (paramvus.a != null) {
        paramvus.a.a(localvtr);
      }
    }
  }
  
  protected boolean a(vus paramvus)
  {
    if ((!paramvus.d) && (QLog.isColorLevel())) {
      QLog.d("ToVideoConverter", 2, "run exit:" + paramvus.b + " currContext.isRun:" + paramvus.d);
    }
    return !paramvus.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vut
 * JD-Core Version:    0.7.0.1
 */