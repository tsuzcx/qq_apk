import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class xnr
{
  protected int a;
  protected axvw a;
  protected String a;
  protected String b;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, xnq paramxnq)
  {
    if (paramxnq != null)
    {
      xmp localxmp = new xmp();
      localxmp.jdField_a_of_type_Long = paramxnq.b;
      localxmp.jdField_a_of_type_Int = paramInt;
      localxmp.jdField_b_of_type_JavaLangString = paramString2;
      localxmp.jdField_a_of_type_JavaLangString = paramString1;
      localxmp.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      localxmp.c = this.jdField_b_of_type_JavaLangString;
      localxmp.jdField_a_of_type_Boolean = false;
      localxmp.jdField_b_of_type_Int = 1;
      if (paramSlideItemInfo != null)
      {
        localxmp.jdField_a_of_type_Boolean = paramSlideItemInfo.jdField_a_of_type_Boolean;
        localxmp.jdField_b_of_type_Int = paramSlideItemInfo.c;
      }
      if (paramxnq.a != null) {
        paramxnq.a.a(localxmp);
      }
    }
  }
  
  protected boolean a(xnq paramxnq)
  {
    if ((!paramxnq.d) && (QLog.isColorLevel())) {
      QLog.d("ToVideoConverter", 2, "run exit:" + paramxnq.b + " currContext.isRun:" + paramxnq.d);
    }
    return !paramxnq.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnr
 * JD-Core Version:    0.7.0.1
 */