import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class afzm
{
  private afzm a;
  public afub b;
  private afzm b;
  private int cVI = 0;
  private int cVJ = 0;
  private int cVK;
  private int cVL;
  private int width;
  
  public afzm(afub paramafub)
  {
    this.jdField_b_of_type_Afub = paramafub;
    this.cVL = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297576);
  }
  
  public int DT()
  {
    return this.cVI;
  }
  
  public int DU()
  {
    return this.cVJ;
  }
  
  public void NI(int paramInt)
  {
    this.cVI = paramInt;
  }
  
  public void NJ(int paramInt)
  {
    this.cVJ = paramInt;
  }
  
  public afzm a()
  {
    return this.a;
  }
  
  public afzm b()
  {
    return this.jdField_b_of_type_Afzm;
  }
  
  public void b(afzm paramafzm)
  {
    this.a = paramafzm;
  }
  
  public void c(afzm paramafzm)
  {
    this.jdField_b_of_type_Afzm = paramafzm;
  }
  
  public int getMeasuredWidth()
  {
    if (this.cVK != 0) {
      return this.cVK;
    }
    if ((this.jdField_b_of_type_Afub != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_Afub.tagName)))
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = afzn.b(this.jdField_b_of_type_Afub.tagName, ((QQAppInterface)localObject1).getApp().getBaseContext());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_b_of_type_Afub.tagName;
      }
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297581);
      localObject2 = new TextPaint();
      ((TextPaint)localObject2).setAntiAlias(true);
      ((TextPaint)localObject2).setDither(true);
      ((TextPaint)localObject2).setTextSize(i);
      this.cVK = ((int)((TextPaint)localObject2).measureText((String)localObject1) + (BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297580) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297579) * 2 + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297576) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297577)));
    }
    for (;;)
    {
      return this.cVK;
      QLog.e("TAG horserace", 2, " GET WIDTH WITH NULL INFO");
    }
  }
  
  public int getWidth()
  {
    if (this.width != 0)
    {
      if (this.cVL != 0) {
        return this.width + this.cVL;
      }
      this.cVL = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297576);
      return this.width + this.cVL;
    }
    return 0;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzm
 * JD-Core Version:    0.7.0.1
 */