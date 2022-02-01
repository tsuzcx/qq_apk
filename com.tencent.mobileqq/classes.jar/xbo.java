import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import java.util.Map;

public class xbo
  implements xei
{
  private xbs jdField_a_of_type_Xbs = new xbq(this);
  private xbt jdField_a_of_type_Xbt;
  private final xbv jdField_a_of_type_Xbv = new xbp(this);
  private xcu jdField_a_of_type_Xcu;
  private xei jdField_a_of_type_Xei;
  private xej jdField_a_of_type_Xej;
  
  public xbo() {}
  
  private xbo(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_Xej = new xee(paramActivity);
  }
  
  public static xbo a(@NonNull Activity paramActivity)
  {
    return new xbo(paramActivity);
  }
  
  public static xbo a(@NonNull Activity paramActivity, xej paramxej)
  {
    return new xbo().a(paramxej);
  }
  
  public xbo a()
  {
    if (this.jdField_a_of_type_Xej.a() == null) {
      return this;
    }
    this.jdField_a_of_type_Xej.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public xbo a(int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_Xej.a();
    if (localActivity == null) {
      return this;
    }
    this.jdField_a_of_type_Xej.jdField_a_of_type_JavaLangString = localActivity.getString(paramInt);
    return this;
  }
  
  public xbo a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Xej.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public xbo a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Xcu == null) {
      throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
    }
    this.jdField_a_of_type_Xcu.b.put(paramString1, paramString2);
    return this;
  }
  
  public xbo a(@NonNull List<int[]> paramList)
  {
    this.jdField_a_of_type_Xej.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public xbo a(xbt paramxbt)
  {
    this.jdField_a_of_type_Xbt = paramxbt;
    return this;
  }
  
  public xbo a(@NonNull xcu paramxcu)
  {
    this.jdField_a_of_type_Xcu = paramxcu;
    this.jdField_a_of_type_Xcu.a(this.jdField_a_of_type_Xej.a());
    this.jdField_a_of_type_Xcu.jdField_a_of_type_Xbs = this.jdField_a_of_type_Xbs;
    this.jdField_a_of_type_Xei = new xbr(this);
    return this;
  }
  
  public xbo a(xej paramxej)
  {
    this.jdField_a_of_type_Xej = paramxej;
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 29782)
    {
      Activity localActivity = this.jdField_a_of_type_Xej.a();
      if ((paramInt2 == -1) && (localActivity != null)) {}
      for (;;)
      {
        try
        {
          bgbw.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
          if (this.jdField_a_of_type_Xbt != null) {
            this.jdField_a_of_type_Xbt.a(1);
          }
          if (this.jdField_a_of_type_Xbt != null) {
            this.jdField_a_of_type_Xbt.a();
          }
        }
        catch (Exception paramIntent)
        {
          if (this.jdField_a_of_type_Xbt == null) {
            continue;
          }
          this.jdField_a_of_type_Xbt.c(1);
          if (this.jdField_a_of_type_Xbt == null) {
            continue;
          }
          this.jdField_a_of_type_Xbt.a();
          continue;
        }
        return true;
        if (this.jdField_a_of_type_Xbt != null) {
          this.jdField_a_of_type_Xbt.d(1);
        }
        if (this.jdField_a_of_type_Xbt != null) {
          this.jdField_a_of_type_Xbt.a();
        }
      }
    }
    return false;
  }
  
  public xbo b()
  {
    yqp.a("StoryShare", "show(): %s", toString());
    if (this.jdField_a_of_type_Xcu == null) {
      if (this.jdField_a_of_type_Xbt != null) {
        this.jdField_a_of_type_Xbt.c(0);
      }
    }
    do
    {
      return this;
      this.jdField_a_of_type_Xej.a(this.jdField_a_of_type_Xei);
      if (this.jdField_a_of_type_Xbt != null) {
        this.jdField_a_of_type_Xbt.b();
      }
      this.jdField_a_of_type_Xej.d();
    } while (this.jdField_a_of_type_Xbt == null);
    this.jdField_a_of_type_Xbt.c();
    return this;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbo
 * JD-Core Version:    0.7.0.1
 */