import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import java.util.Map;

public class vdt
  implements vgn
{
  private vdx jdField_a_of_type_Vdx = new vdv(this);
  private vdy jdField_a_of_type_Vdy;
  private final vea jdField_a_of_type_Vea = new vdu(this);
  private vez jdField_a_of_type_Vez;
  private vgn jdField_a_of_type_Vgn;
  private vgo jdField_a_of_type_Vgo;
  
  public vdt() {}
  
  private vdt(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_Vgo = new vgj(paramActivity);
  }
  
  public static vdt a(@NonNull Activity paramActivity)
  {
    return new vdt(paramActivity);
  }
  
  public static vdt a(@NonNull Activity paramActivity, vgo paramvgo)
  {
    return new vdt().a(paramvgo);
  }
  
  public vdt a()
  {
    if (this.jdField_a_of_type_Vgo.a() == null) {
      return this;
    }
    this.jdField_a_of_type_Vgo.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public vdt a(int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_Vgo.a();
    if (localActivity == null) {
      return this;
    }
    this.jdField_a_of_type_Vgo.jdField_a_of_type_JavaLangString = localActivity.getString(paramInt);
    return this;
  }
  
  public vdt a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Vgo.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public vdt a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Vez == null) {
      throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
    }
    this.jdField_a_of_type_Vez.b.put(paramString1, paramString2);
    return this;
  }
  
  public vdt a(@NonNull List<int[]> paramList)
  {
    this.jdField_a_of_type_Vgo.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public vdt a(vdy paramvdy)
  {
    this.jdField_a_of_type_Vdy = paramvdy;
    return this;
  }
  
  public vdt a(@NonNull vez paramvez)
  {
    this.jdField_a_of_type_Vez = paramvez;
    this.jdField_a_of_type_Vez.a(this.jdField_a_of_type_Vgo.a());
    this.jdField_a_of_type_Vez.jdField_a_of_type_Vdx = this.jdField_a_of_type_Vdx;
    this.jdField_a_of_type_Vgn = new vdw(this);
    return this;
  }
  
  public vdt a(vgo paramvgo)
  {
    this.jdField_a_of_type_Vgo = paramvgo;
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 29782)
    {
      Activity localActivity = this.jdField_a_of_type_Vgo.a();
      if ((paramInt2 == -1) && (localActivity != null)) {}
      for (;;)
      {
        try
        {
          bctc.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
          if (this.jdField_a_of_type_Vdy != null) {
            this.jdField_a_of_type_Vdy.a(1);
          }
          if (this.jdField_a_of_type_Vdy != null) {
            this.jdField_a_of_type_Vdy.a();
          }
        }
        catch (Exception paramIntent)
        {
          if (this.jdField_a_of_type_Vdy == null) {
            continue;
          }
          this.jdField_a_of_type_Vdy.c(1);
          if (this.jdField_a_of_type_Vdy == null) {
            continue;
          }
          this.jdField_a_of_type_Vdy.a();
          continue;
        }
        return true;
        if (this.jdField_a_of_type_Vdy != null) {
          this.jdField_a_of_type_Vdy.d(1);
        }
        if (this.jdField_a_of_type_Vdy != null) {
          this.jdField_a_of_type_Vdy.a();
        }
      }
    }
    return false;
  }
  
  public vdt b()
  {
    wsv.a("StoryShare", "show(): %s", toString());
    if (this.jdField_a_of_type_Vez == null) {
      if (this.jdField_a_of_type_Vdy != null) {
        this.jdField_a_of_type_Vdy.c(0);
      }
    }
    do
    {
      return this;
      this.jdField_a_of_type_Vgo.a(this.jdField_a_of_type_Vgn);
      if (this.jdField_a_of_type_Vdy != null) {
        this.jdField_a_of_type_Vdy.b();
      }
      this.jdField_a_of_type_Vgo.d();
    } while (this.jdField_a_of_type_Vdy == null);
    this.jdField_a_of_type_Vdy.c();
    return this;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vdt
 * JD-Core Version:    0.7.0.1
 */