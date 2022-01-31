import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import java.util.Map;

public class tpb
  implements trv
{
  private tpf jdField_a_of_type_Tpf = new tpd(this);
  private tpg jdField_a_of_type_Tpg;
  private final tpi jdField_a_of_type_Tpi = new tpc(this);
  private tqh jdField_a_of_type_Tqh;
  private trv jdField_a_of_type_Trv;
  private trw jdField_a_of_type_Trw;
  
  public tpb() {}
  
  private tpb(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_Trw = new trr(paramActivity);
  }
  
  public static tpb a(@NonNull Activity paramActivity)
  {
    return new tpb(paramActivity);
  }
  
  public static tpb a(@NonNull Activity paramActivity, trw paramtrw)
  {
    return new tpb().a(paramtrw);
  }
  
  public tpb a()
  {
    if (this.jdField_a_of_type_Trw.a() == null) {
      return this;
    }
    this.jdField_a_of_type_Trw.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public tpb a(int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_Trw.a();
    if (localActivity == null) {
      return this;
    }
    this.jdField_a_of_type_Trw.jdField_a_of_type_JavaLangString = localActivity.getString(paramInt);
    return this;
  }
  
  public tpb a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Trw.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public tpb a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Tqh == null) {
      throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
    }
    this.jdField_a_of_type_Tqh.b.put(paramString1, paramString2);
    return this;
  }
  
  public tpb a(@NonNull List<int[]> paramList)
  {
    this.jdField_a_of_type_Trw.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public tpb a(tpg paramtpg)
  {
    this.jdField_a_of_type_Tpg = paramtpg;
    return this;
  }
  
  public tpb a(@NonNull tqh paramtqh)
  {
    this.jdField_a_of_type_Tqh = paramtqh;
    this.jdField_a_of_type_Tqh.a(this.jdField_a_of_type_Trw.a());
    this.jdField_a_of_type_Tqh.jdField_a_of_type_Tpf = this.jdField_a_of_type_Tpf;
    this.jdField_a_of_type_Trv = new tpe(this);
    return this;
  }
  
  public tpb a(trw paramtrw)
  {
    this.jdField_a_of_type_Trw = paramtrw;
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 29782)
    {
      Activity localActivity = this.jdField_a_of_type_Trw.a();
      if ((paramInt2 == -1) && (localActivity != null)) {}
      for (;;)
      {
        try
        {
          baui.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
          if (this.jdField_a_of_type_Tpg != null) {
            this.jdField_a_of_type_Tpg.a(1);
          }
          if (this.jdField_a_of_type_Tpg != null) {
            this.jdField_a_of_type_Tpg.a();
          }
        }
        catch (Exception paramIntent)
        {
          if (this.jdField_a_of_type_Tpg == null) {
            continue;
          }
          this.jdField_a_of_type_Tpg.c(1);
          if (this.jdField_a_of_type_Tpg == null) {
            continue;
          }
          this.jdField_a_of_type_Tpg.a();
          continue;
        }
        return true;
        if (this.jdField_a_of_type_Tpg != null) {
          this.jdField_a_of_type_Tpg.d(1);
        }
        if (this.jdField_a_of_type_Tpg != null) {
          this.jdField_a_of_type_Tpg.a();
        }
      }
    }
    return false;
  }
  
  public tpb b()
  {
    ved.a("StoryShare", "show(): %s", toString());
    if (this.jdField_a_of_type_Tqh == null) {
      if (this.jdField_a_of_type_Tpg != null) {
        this.jdField_a_of_type_Tpg.c(0);
      }
    }
    do
    {
      return this;
      this.jdField_a_of_type_Trw.a(this.jdField_a_of_type_Trv);
      if (this.jdField_a_of_type_Tpg != null) {
        this.jdField_a_of_type_Tpg.b();
      }
      this.jdField_a_of_type_Trw.d();
    } while (this.jdField_a_of_type_Tpg == null);
    this.jdField_a_of_type_Tpg.c();
    return this;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpb
 * JD-Core Version:    0.7.0.1
 */