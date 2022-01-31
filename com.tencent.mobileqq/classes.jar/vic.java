import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import java.util.Map;

public class vic
  implements vkw
{
  private vig jdField_a_of_type_Vig = new vie(this);
  private vih jdField_a_of_type_Vih;
  private final vij jdField_a_of_type_Vij = new vid(this);
  private vji jdField_a_of_type_Vji;
  private vkw jdField_a_of_type_Vkw;
  private vkx jdField_a_of_type_Vkx;
  
  public vic() {}
  
  private vic(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_Vkx = new vks(paramActivity);
  }
  
  public static vic a(@NonNull Activity paramActivity)
  {
    return new vic(paramActivity);
  }
  
  public static vic a(@NonNull Activity paramActivity, vkx paramvkx)
  {
    return new vic().a(paramvkx);
  }
  
  public vic a()
  {
    if (this.jdField_a_of_type_Vkx.a() == null) {
      return this;
    }
    this.jdField_a_of_type_Vkx.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public vic a(int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_Vkx.a();
    if (localActivity == null) {
      return this;
    }
    this.jdField_a_of_type_Vkx.jdField_a_of_type_JavaLangString = localActivity.getString(paramInt);
    return this;
  }
  
  public vic a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Vkx.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public vic a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Vji == null) {
      throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
    }
    this.jdField_a_of_type_Vji.b.put(paramString1, paramString2);
    return this;
  }
  
  public vic a(@NonNull List<int[]> paramList)
  {
    this.jdField_a_of_type_Vkx.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public vic a(vih paramvih)
  {
    this.jdField_a_of_type_Vih = paramvih;
    return this;
  }
  
  public vic a(@NonNull vji paramvji)
  {
    this.jdField_a_of_type_Vji = paramvji;
    this.jdField_a_of_type_Vji.a(this.jdField_a_of_type_Vkx.a());
    this.jdField_a_of_type_Vji.jdField_a_of_type_Vig = this.jdField_a_of_type_Vig;
    this.jdField_a_of_type_Vkw = new vif(this);
    return this;
  }
  
  public vic a(vkx paramvkx)
  {
    this.jdField_a_of_type_Vkx = paramvkx;
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 29782)
    {
      Activity localActivity = this.jdField_a_of_type_Vkx.a();
      if ((paramInt2 == -1) && (localActivity != null)) {}
      for (;;)
      {
        try
        {
          bcxl.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
          if (this.jdField_a_of_type_Vih != null) {
            this.jdField_a_of_type_Vih.a(1);
          }
          if (this.jdField_a_of_type_Vih != null) {
            this.jdField_a_of_type_Vih.a();
          }
        }
        catch (Exception paramIntent)
        {
          if (this.jdField_a_of_type_Vih == null) {
            continue;
          }
          this.jdField_a_of_type_Vih.c(1);
          if (this.jdField_a_of_type_Vih == null) {
            continue;
          }
          this.jdField_a_of_type_Vih.a();
          continue;
        }
        return true;
        if (this.jdField_a_of_type_Vih != null) {
          this.jdField_a_of_type_Vih.d(1);
        }
        if (this.jdField_a_of_type_Vih != null) {
          this.jdField_a_of_type_Vih.a();
        }
      }
    }
    return false;
  }
  
  public vic b()
  {
    wxe.a("StoryShare", "show(): %s", toString());
    if (this.jdField_a_of_type_Vji == null) {
      if (this.jdField_a_of_type_Vih != null) {
        this.jdField_a_of_type_Vih.c(0);
      }
    }
    do
    {
      return this;
      this.jdField_a_of_type_Vkx.a(this.jdField_a_of_type_Vkw);
      if (this.jdField_a_of_type_Vih != null) {
        this.jdField_a_of_type_Vih.b();
      }
      this.jdField_a_of_type_Vkx.d();
    } while (this.jdField_a_of_type_Vih == null);
    this.jdField_a_of_type_Vih.c();
    return this;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vic
 * JD-Core Version:    0.7.0.1
 */