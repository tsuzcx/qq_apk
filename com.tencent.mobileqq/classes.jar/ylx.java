import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class ylx
{
  protected int a;
  protected bagl a;
  protected String a;
  protected String b;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, ylw paramylw)
  {
    if (paramylw != null)
    {
      ykv localykv = new ykv();
      localykv.jdField_a_of_type_Long = paramylw.b;
      localykv.jdField_a_of_type_Int = paramInt;
      localykv.jdField_b_of_type_JavaLangString = paramString2;
      localykv.jdField_a_of_type_JavaLangString = paramString1;
      localykv.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      localykv.c = this.jdField_b_of_type_JavaLangString;
      localykv.jdField_a_of_type_Boolean = false;
      localykv.jdField_b_of_type_Int = 1;
      if (paramSlideItemInfo != null)
      {
        localykv.jdField_a_of_type_Boolean = paramSlideItemInfo.jdField_a_of_type_Boolean;
        localykv.jdField_b_of_type_Int = paramSlideItemInfo.c;
      }
      if (paramylw.a != null) {
        paramylw.a.a(localykv);
      }
    }
  }
  
  protected boolean a(ylw paramylw)
  {
    if ((!paramylw.d) && (QLog.isColorLevel())) {
      QLog.d("ToVideoConverter", 2, "run exit:" + paramylw.b + " currContext.isRun:" + paramylw.d);
    }
    return !paramylw.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylx
 * JD-Core Version:    0.7.0.1
 */