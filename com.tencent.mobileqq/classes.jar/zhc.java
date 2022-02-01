import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class zhc
{
  protected int a;
  protected batx a;
  protected String a;
  protected String b;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, zhb paramzhb)
  {
    if (paramzhb != null)
    {
      zga localzga = new zga();
      localzga.jdField_a_of_type_Long = paramzhb.b;
      localzga.jdField_a_of_type_Int = paramInt;
      localzga.jdField_b_of_type_JavaLangString = paramString2;
      localzga.jdField_a_of_type_JavaLangString = paramString1;
      localzga.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      localzga.c = this.jdField_b_of_type_JavaLangString;
      localzga.jdField_a_of_type_Boolean = false;
      localzga.jdField_b_of_type_Int = 1;
      if (paramSlideItemInfo != null)
      {
        localzga.jdField_a_of_type_Boolean = paramSlideItemInfo.jdField_a_of_type_Boolean;
        localzga.jdField_b_of_type_Int = paramSlideItemInfo.c;
      }
      if (paramzhb.a != null) {
        paramzhb.a.a(localzga);
      }
    }
  }
  
  protected boolean a(zhb paramzhb)
  {
    if ((!paramzhb.d) && (QLog.isColorLevel())) {
      QLog.d("ToVideoConverter", 2, "run exit:" + paramzhb.b + " currContext.isRun:" + paramzhb.d);
    }
    return !paramzhb.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhc
 * JD-Core Version:    0.7.0.1
 */