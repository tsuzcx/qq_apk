import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class zaq
{
  protected int a;
  protected bbna a;
  protected String a;
  protected String b;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, zap paramzap)
  {
    if (paramzap != null)
    {
      yzo localyzo = new yzo();
      localyzo.jdField_a_of_type_Long = paramzap.b;
      localyzo.jdField_a_of_type_Int = paramInt;
      localyzo.jdField_b_of_type_JavaLangString = paramString2;
      localyzo.jdField_a_of_type_JavaLangString = paramString1;
      localyzo.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      localyzo.c = this.jdField_b_of_type_JavaLangString;
      localyzo.jdField_a_of_type_Boolean = false;
      localyzo.jdField_b_of_type_Int = 1;
      if (paramSlideItemInfo != null)
      {
        localyzo.jdField_a_of_type_Boolean = paramSlideItemInfo.jdField_a_of_type_Boolean;
        localyzo.jdField_b_of_type_Int = paramSlideItemInfo.c;
      }
      if (paramzap.a != null) {
        paramzap.a.a(localyzo);
      }
    }
  }
  
  protected boolean a(zap paramzap)
  {
    if ((!paramzap.d) && (QLog.isColorLevel())) {
      QLog.d("ToVideoConverter", 2, "run exit:" + paramzap.b + " currContext.isRun:" + paramzap.d);
    }
    return !paramzap.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zaq
 * JD-Core Version:    0.7.0.1
 */