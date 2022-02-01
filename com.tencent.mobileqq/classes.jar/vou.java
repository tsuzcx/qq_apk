import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;

public class vou
{
  public static int a;
  public static int b;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130846601);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public Long a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844002);
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
  
  public vou a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public vou a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return this;
  }
  
  public vou a(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      paramImageView.setTag(2131373863, this.jdField_a_of_type_JavaLangString);
    }
    return this;
  }
  
  public vou a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131373863, this.jdField_a_of_type_JavaLangString);
    }
    return this;
  }
  
  public vou a(boolean paramBoolean)
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
  
  public vou b(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public vou b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public vou b(boolean paramBoolean)
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
  
  public vou c(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public vou c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && ((this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131373863) instanceof String))) {
      return this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131373863).equals(this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public int d()
  {
    return this.h;
  }
  
  public vou d(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vou
 * JD-Core Version:    0.7.0.1
 */