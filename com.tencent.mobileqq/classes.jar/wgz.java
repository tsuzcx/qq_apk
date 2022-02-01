import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import java.util.Map;

public class wgz
  implements wjt
{
  private whd jdField_a_of_type_Whd = new whb(this);
  private whe jdField_a_of_type_Whe;
  private final whg jdField_a_of_type_Whg = new wha(this);
  private wif jdField_a_of_type_Wif;
  private wjt jdField_a_of_type_Wjt;
  private wju jdField_a_of_type_Wju;
  
  public wgz() {}
  
  private wgz(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_Wju = new wjp(paramActivity);
  }
  
  public static wgz a(@NonNull Activity paramActivity)
  {
    return new wgz(paramActivity);
  }
  
  public static wgz a(@NonNull Activity paramActivity, wju paramwju)
  {
    return new wgz().a(paramwju);
  }
  
  public wgz a()
  {
    if (this.jdField_a_of_type_Wju.a() == null) {
      return this;
    }
    this.jdField_a_of_type_Wju.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public wgz a(int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_Wju.a();
    if (localActivity == null) {
      return this;
    }
    this.jdField_a_of_type_Wju.jdField_a_of_type_JavaLangString = localActivity.getString(paramInt);
    return this;
  }
  
  public wgz a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Wju.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public wgz a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Wif == null) {
      throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
    }
    this.jdField_a_of_type_Wif.b.put(paramString1, paramString2);
    return this;
  }
  
  public wgz a(@NonNull List<int[]> paramList)
  {
    this.jdField_a_of_type_Wju.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public wgz a(whe paramwhe)
  {
    this.jdField_a_of_type_Whe = paramwhe;
    return this;
  }
  
  public wgz a(@NonNull wif paramwif)
  {
    this.jdField_a_of_type_Wif = paramwif;
    this.jdField_a_of_type_Wif.a(this.jdField_a_of_type_Wju.a());
    this.jdField_a_of_type_Wif.jdField_a_of_type_Whd = this.jdField_a_of_type_Whd;
    this.jdField_a_of_type_Wjt = new whc(this);
    return this;
  }
  
  public wgz a(wju paramwju)
  {
    this.jdField_a_of_type_Wju = paramwju;
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 29782)
    {
      Activity localActivity = this.jdField_a_of_type_Wju.a();
      if ((paramInt2 == -1) && (localActivity != null)) {}
      for (;;)
      {
        try
        {
          bflj.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
          if (this.jdField_a_of_type_Whe != null) {
            this.jdField_a_of_type_Whe.a(1);
          }
          if (this.jdField_a_of_type_Whe != null) {
            this.jdField_a_of_type_Whe.a();
          }
        }
        catch (Exception paramIntent)
        {
          if (this.jdField_a_of_type_Whe == null) {
            continue;
          }
          this.jdField_a_of_type_Whe.c(1);
          if (this.jdField_a_of_type_Whe == null) {
            continue;
          }
          this.jdField_a_of_type_Whe.a();
          continue;
        }
        return true;
        if (this.jdField_a_of_type_Whe != null) {
          this.jdField_a_of_type_Whe.d(1);
        }
        if (this.jdField_a_of_type_Whe != null) {
          this.jdField_a_of_type_Whe.a();
        }
      }
    }
    return false;
  }
  
  public wgz b()
  {
    xvv.a("StoryShare", "show(): %s", toString());
    if (this.jdField_a_of_type_Wif == null) {
      if (this.jdField_a_of_type_Whe != null) {
        this.jdField_a_of_type_Whe.c(0);
      }
    }
    do
    {
      return this;
      this.jdField_a_of_type_Wju.a(this.jdField_a_of_type_Wjt);
      if (this.jdField_a_of_type_Whe != null) {
        this.jdField_a_of_type_Whe.b();
      }
      this.jdField_a_of_type_Wju.d();
    } while (this.jdField_a_of_type_Whe == null);
    this.jdField_a_of_type_Whe.c();
    return this;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgz
 * JD-Core Version:    0.7.0.1
 */