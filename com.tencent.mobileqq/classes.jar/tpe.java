import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import java.util.Map;

public class tpe
  implements try
{
  private tpi jdField_a_of_type_Tpi = new tpg(this);
  private tpj jdField_a_of_type_Tpj;
  private final tpl jdField_a_of_type_Tpl = new tpf(this);
  private tqk jdField_a_of_type_Tqk;
  private try jdField_a_of_type_Try;
  private trz jdField_a_of_type_Trz;
  
  public tpe() {}
  
  private tpe(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_Trz = new tru(paramActivity);
  }
  
  public static tpe a(@NonNull Activity paramActivity)
  {
    return new tpe(paramActivity);
  }
  
  public static tpe a(@NonNull Activity paramActivity, trz paramtrz)
  {
    return new tpe().a(paramtrz);
  }
  
  public tpe a()
  {
    if (this.jdField_a_of_type_Trz.a() == null) {
      return this;
    }
    this.jdField_a_of_type_Trz.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public tpe a(int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_Trz.a();
    if (localActivity == null) {
      return this;
    }
    this.jdField_a_of_type_Trz.jdField_a_of_type_JavaLangString = localActivity.getString(paramInt);
    return this;
  }
  
  public tpe a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Trz.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public tpe a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Tqk == null) {
      throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
    }
    this.jdField_a_of_type_Tqk.b.put(paramString1, paramString2);
    return this;
  }
  
  public tpe a(@NonNull List<int[]> paramList)
  {
    this.jdField_a_of_type_Trz.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public tpe a(tpj paramtpj)
  {
    this.jdField_a_of_type_Tpj = paramtpj;
    return this;
  }
  
  public tpe a(@NonNull tqk paramtqk)
  {
    this.jdField_a_of_type_Tqk = paramtqk;
    this.jdField_a_of_type_Tqk.a(this.jdField_a_of_type_Trz.a());
    this.jdField_a_of_type_Tqk.jdField_a_of_type_Tpi = this.jdField_a_of_type_Tpi;
    this.jdField_a_of_type_Try = new tph(this);
    return this;
  }
  
  public tpe a(trz paramtrz)
  {
    this.jdField_a_of_type_Trz = paramtrz;
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 29782)
    {
      Activity localActivity = this.jdField_a_of_type_Trz.a();
      if ((paramInt2 == -1) && (localActivity != null)) {}
      for (;;)
      {
        try
        {
          batu.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
          if (this.jdField_a_of_type_Tpj != null) {
            this.jdField_a_of_type_Tpj.a(1);
          }
          if (this.jdField_a_of_type_Tpj != null) {
            this.jdField_a_of_type_Tpj.a();
          }
        }
        catch (Exception paramIntent)
        {
          if (this.jdField_a_of_type_Tpj == null) {
            continue;
          }
          this.jdField_a_of_type_Tpj.c(1);
          if (this.jdField_a_of_type_Tpj == null) {
            continue;
          }
          this.jdField_a_of_type_Tpj.a();
          continue;
        }
        return true;
        if (this.jdField_a_of_type_Tpj != null) {
          this.jdField_a_of_type_Tpj.d(1);
        }
        if (this.jdField_a_of_type_Tpj != null) {
          this.jdField_a_of_type_Tpj.a();
        }
      }
    }
    return false;
  }
  
  public tpe b()
  {
    veg.a("StoryShare", "show(): %s", toString());
    if (this.jdField_a_of_type_Tqk == null) {
      if (this.jdField_a_of_type_Tpj != null) {
        this.jdField_a_of_type_Tpj.c(0);
      }
    }
    do
    {
      return this;
      this.jdField_a_of_type_Trz.a(this.jdField_a_of_type_Try);
      if (this.jdField_a_of_type_Tpj != null) {
        this.jdField_a_of_type_Tpj.b();
      }
      this.jdField_a_of_type_Trz.d();
    } while (this.jdField_a_of_type_Tpj == null);
    this.jdField_a_of_type_Tpj.c();
    return this;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpe
 * JD-Core Version:    0.7.0.1
 */