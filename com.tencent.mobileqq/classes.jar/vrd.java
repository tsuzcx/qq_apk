import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class vrd
{
  public static int a;
  public static int b;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130846618);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public Long a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844021);
  public Long b;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  public int c;
  public Long c;
  private String c;
  public int d = 2;
  public int e;
  private int f;
  private int g;
  private int h = jdField_a_of_type_Int;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public vrd a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public vrd a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return this;
  }
  
  public vrd a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramImageView.setTag(2131373996, this.jdField_a_of_type_JavaLangString);
      }
    }
    return this;
  }
  
  public vrd a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131373996, this.jdField_a_of_type_JavaLangString);
    }
    return this;
  }
  
  public vrd a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public Drawable b()
  {
    return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public vrd b(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public vrd b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public vrd b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public vrd c(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public vrd c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && ((this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131373996) instanceof String)))
    {
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131373996);
      if (QCircleFeedPicLoader.a(str).equals(QCircleFeedPicLoader.a(this.jdField_a_of_type_JavaLangString)))
      {
        QLog.i(QCircleFeedPicLoader.jdField_a_of_type_JavaLangString, 1, "seq = " + this.e + " is valid, url" + this.jdField_a_of_type_JavaLangString);
        return true;
      }
      QLog.i(QCircleFeedPicLoader.jdField_a_of_type_JavaLangString, 1, "seq = " + this.e + " is unValid, tagUrl:" + str + "-----original url:" + this.jdField_a_of_type_JavaLangString);
      return false;
    }
    QLog.i(QCircleFeedPicLoader.jdField_a_of_type_JavaLangString, 1, "seq = " + this.e + " unValid mTargetView is empty,isFromPreload:" + this.jdField_a_of_type_Boolean);
    return false;
  }
  
  public int d()
  {
    return this.h;
  }
  
  public vrd d(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrd
 * JD-Core Version:    0.7.0.1
 */