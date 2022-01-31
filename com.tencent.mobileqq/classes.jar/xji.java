import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class xji
{
  protected int a;
  protected axrn a;
  protected String a;
  protected String b;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, xjh paramxjh)
  {
    if (paramxjh != null)
    {
      xig localxig = new xig();
      localxig.jdField_a_of_type_Long = paramxjh.b;
      localxig.jdField_a_of_type_Int = paramInt;
      localxig.jdField_b_of_type_JavaLangString = paramString2;
      localxig.jdField_a_of_type_JavaLangString = paramString1;
      localxig.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      localxig.c = this.jdField_b_of_type_JavaLangString;
      localxig.jdField_a_of_type_Boolean = false;
      localxig.jdField_b_of_type_Int = 1;
      if (paramSlideItemInfo != null)
      {
        localxig.jdField_a_of_type_Boolean = paramSlideItemInfo.jdField_a_of_type_Boolean;
        localxig.jdField_b_of_type_Int = paramSlideItemInfo.c;
      }
      if (paramxjh.a != null) {
        paramxjh.a.a(localxig);
      }
    }
  }
  
  protected boolean a(xjh paramxjh)
  {
    if ((!paramxjh.d) && (QLog.isColorLevel())) {
      QLog.d("ToVideoConverter", 2, "run exit:" + paramxjh.b + " currContext.isRun:" + paramxjh.d);
    }
    return !paramxjh.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xji
 * JD-Core Version:    0.7.0.1
 */