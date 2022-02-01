import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import java.util.Map;

public class wvu
  implements wyo
{
  private wvy jdField_a_of_type_Wvy = new wvw(this);
  private wvz jdField_a_of_type_Wvz;
  private final wwb jdField_a_of_type_Wwb = new wvv(this);
  private wxa jdField_a_of_type_Wxa;
  private wyo jdField_a_of_type_Wyo;
  private wyp jdField_a_of_type_Wyp;
  
  public wvu() {}
  
  private wvu(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_Wyp = new wyk(paramActivity);
  }
  
  public static wvu a(@NonNull Activity paramActivity)
  {
    return new wvu(paramActivity);
  }
  
  public static wvu a(@NonNull Activity paramActivity, wyp paramwyp)
  {
    return new wvu().a(paramwyp);
  }
  
  public wvu a()
  {
    if (this.jdField_a_of_type_Wyp.a() == null) {
      return this;
    }
    this.jdField_a_of_type_Wyp.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public wvu a(int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_Wyp.a();
    if (localActivity == null) {
      return this;
    }
    this.jdField_a_of_type_Wyp.jdField_a_of_type_JavaLangString = localActivity.getString(paramInt);
    return this;
  }
  
  public wvu a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Wyp.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public wvu a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Wxa == null) {
      throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
    }
    this.jdField_a_of_type_Wxa.b.put(paramString1, paramString2);
    return this;
  }
  
  public wvu a(@NonNull List<int[]> paramList)
  {
    this.jdField_a_of_type_Wyp.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public wvu a(wvz paramwvz)
  {
    this.jdField_a_of_type_Wvz = paramwvz;
    return this;
  }
  
  public wvu a(@NonNull wxa paramwxa)
  {
    this.jdField_a_of_type_Wxa = paramwxa;
    this.jdField_a_of_type_Wxa.a(this.jdField_a_of_type_Wyp.a());
    this.jdField_a_of_type_Wxa.jdField_a_of_type_Wvy = this.jdField_a_of_type_Wvy;
    this.jdField_a_of_type_Wyo = new wvx(this);
    return this;
  }
  
  public wvu a(wyp paramwyp)
  {
    this.jdField_a_of_type_Wyp = paramwyp;
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 29782)
    {
      Activity localActivity = this.jdField_a_of_type_Wyp.a();
      if ((paramInt2 == -1) && (localActivity != null)) {}
      for (;;)
      {
        try
        {
          bgua.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
          if (this.jdField_a_of_type_Wvz != null) {
            this.jdField_a_of_type_Wvz.a(1);
          }
          if (this.jdField_a_of_type_Wvz != null) {
            this.jdField_a_of_type_Wvz.a();
          }
        }
        catch (Exception paramIntent)
        {
          if (this.jdField_a_of_type_Wvz == null) {
            continue;
          }
          this.jdField_a_of_type_Wvz.c(1);
          if (this.jdField_a_of_type_Wvz == null) {
            continue;
          }
          this.jdField_a_of_type_Wvz.a();
          continue;
        }
        return true;
        if (this.jdField_a_of_type_Wvz != null) {
          this.jdField_a_of_type_Wvz.d(1);
        }
        if (this.jdField_a_of_type_Wvz != null) {
          this.jdField_a_of_type_Wvz.a();
        }
      }
    }
    return false;
  }
  
  public wvu b()
  {
    ykq.a("StoryShare", "show(): %s", toString());
    if (this.jdField_a_of_type_Wxa == null) {
      if (this.jdField_a_of_type_Wvz != null) {
        this.jdField_a_of_type_Wvz.c(0);
      }
    }
    do
    {
      return this;
      this.jdField_a_of_type_Wyp.a(this.jdField_a_of_type_Wyo);
      if (this.jdField_a_of_type_Wvz != null) {
        this.jdField_a_of_type_Wvz.b();
      }
      this.jdField_a_of_type_Wyp.d();
    } while (this.jdField_a_of_type_Wvz == null);
    this.jdField_a_of_type_Wvz.c();
    return this;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvu
 * JD-Core Version:    0.7.0.1
 */