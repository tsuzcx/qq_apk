import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class zkx
{
  protected int a;
  protected bbmq a;
  protected String a;
  protected String b;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, zkw paramzkw)
  {
    if (paramzkw != null)
    {
      zjv localzjv = new zjv();
      localzjv.jdField_a_of_type_Long = paramzkw.b;
      localzjv.jdField_a_of_type_Int = paramInt;
      localzjv.jdField_b_of_type_JavaLangString = paramString2;
      localzjv.jdField_a_of_type_JavaLangString = paramString1;
      localzjv.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      localzjv.c = this.jdField_b_of_type_JavaLangString;
      localzjv.jdField_a_of_type_Boolean = false;
      localzjv.jdField_b_of_type_Int = 1;
      if (paramSlideItemInfo != null)
      {
        localzjv.jdField_a_of_type_Boolean = paramSlideItemInfo.jdField_a_of_type_Boolean;
        localzjv.jdField_b_of_type_Int = paramSlideItemInfo.c;
      }
      if (paramzkw.a != null) {
        paramzkw.a.a(localzjv);
      }
    }
  }
  
  protected boolean a(zkw paramzkw)
  {
    if ((!paramzkw.d) && (QLog.isColorLevel())) {
      QLog.d("ToVideoConverter", 2, "run exit:" + paramzkw.b + " currContext.isRun:" + paramzkw.d);
    }
    return !paramzkw.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zkx
 * JD-Core Version:    0.7.0.1
 */