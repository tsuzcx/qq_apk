import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class tyh
{
  int jdField_a_of_type_Int = 0;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  String jdField_a_of_type_JavaLangString = "";
  String b = "";
  String c = "";
  
  public tyh(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramContext.getString(paramInt2);
    this.b = "";
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(paramInt3);
      label66:
      this.c = a(paramInt1);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      break label66;
    }
  }
  
  public tyh(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = a(paramInt);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = tyg.a(paramContext, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder mId: " + this.jdField_a_of_type_Int + " | mName: " + this.jdField_a_of_type_JavaLangString + " | mIconUrl: " + this.b + " | mUin : " + this.c);
    }
    if ((!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c)))
    {
      paramString1 = aend.b(paramContext, paramString2);
      if (paramString1 != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString1;
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      aend.a(paramQQAppInterface, paramContext, paramString2, new aene(paramContext, new tyi(this, paramQQAppInterface, this.c), new Object[0]));
      return;
    }
    QLog.d("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder mIconUrl is empty");
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return String.valueOf(7210);
    case 2: 
      return String.valueOf(anhk.az);
    }
    return String.valueOf(anhk.aA);
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyh
 * JD-Core Version:    0.7.0.1
 */