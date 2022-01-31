import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class vhx
{
  protected int a;
  protected auzt a;
  protected String a;
  protected String b;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, vhw paramvhw)
  {
    if (paramvhw != null)
    {
      vgv localvgv = new vgv();
      localvgv.jdField_a_of_type_Long = paramvhw.b;
      localvgv.jdField_a_of_type_Int = paramInt;
      localvgv.jdField_b_of_type_JavaLangString = paramString2;
      localvgv.jdField_a_of_type_JavaLangString = paramString1;
      localvgv.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      localvgv.c = this.jdField_b_of_type_JavaLangString;
      localvgv.jdField_a_of_type_Boolean = false;
      localvgv.jdField_b_of_type_Int = 1;
      if (paramSlideItemInfo != null)
      {
        localvgv.jdField_a_of_type_Boolean = paramSlideItemInfo.jdField_a_of_type_Boolean;
        localvgv.jdField_b_of_type_Int = paramSlideItemInfo.c;
      }
      if (paramvhw.a != null) {
        paramvhw.a.a(localvgv);
      }
    }
  }
  
  protected boolean a(vhw paramvhw)
  {
    if ((!paramvhw.d) && (QLog.isColorLevel())) {
      QLog.d("ToVideoConverter", 2, "run exit:" + paramvhw.b + " currContext.isRun:" + paramvhw.d);
    }
    return !paramvhw.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhx
 * JD-Core Version:    0.7.0.1
 */