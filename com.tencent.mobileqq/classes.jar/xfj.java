import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import java.util.Map;

public class xfj
  implements xid
{
  private xfn jdField_a_of_type_Xfn = new xfl(this);
  private xfo jdField_a_of_type_Xfo;
  private final xfq jdField_a_of_type_Xfq = new xfk(this);
  private xgp jdField_a_of_type_Xgp;
  private xid jdField_a_of_type_Xid;
  private xie jdField_a_of_type_Xie;
  
  public xfj() {}
  
  private xfj(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_Xie = new xhz(paramActivity);
  }
  
  public static xfj a(@NonNull Activity paramActivity)
  {
    return new xfj(paramActivity);
  }
  
  public static xfj a(@NonNull Activity paramActivity, xie paramxie)
  {
    return new xfj().a(paramxie);
  }
  
  public xfj a()
  {
    if (this.jdField_a_of_type_Xie.a() == null) {
      return this;
    }
    this.jdField_a_of_type_Xie.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public xfj a(int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_Xie.a();
    if (localActivity == null) {
      return this;
    }
    this.jdField_a_of_type_Xie.jdField_a_of_type_JavaLangString = localActivity.getString(paramInt);
    return this;
  }
  
  public xfj a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Xie.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public xfj a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Xgp == null) {
      throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
    }
    this.jdField_a_of_type_Xgp.b.put(paramString1, paramString2);
    return this;
  }
  
  public xfj a(@NonNull List<int[]> paramList)
  {
    this.jdField_a_of_type_Xie.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public xfj a(xfo paramxfo)
  {
    this.jdField_a_of_type_Xfo = paramxfo;
    return this;
  }
  
  public xfj a(@NonNull xgp paramxgp)
  {
    this.jdField_a_of_type_Xgp = paramxgp;
    this.jdField_a_of_type_Xgp.a(this.jdField_a_of_type_Xie.a());
    this.jdField_a_of_type_Xgp.jdField_a_of_type_Xfn = this.jdField_a_of_type_Xfn;
    this.jdField_a_of_type_Xid = new xfm(this);
    return this;
  }
  
  public xfj a(xie paramxie)
  {
    this.jdField_a_of_type_Xie = paramxie;
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 29782)
    {
      Activity localActivity = this.jdField_a_of_type_Xie.a();
      if ((paramInt2 == -1) && (localActivity != null)) {}
      for (;;)
      {
        try
        {
          bhbx.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
          if (this.jdField_a_of_type_Xfo != null) {
            this.jdField_a_of_type_Xfo.a(1);
          }
          if (this.jdField_a_of_type_Xfo != null) {
            this.jdField_a_of_type_Xfo.a();
          }
        }
        catch (Exception paramIntent)
        {
          if (this.jdField_a_of_type_Xfo == null) {
            continue;
          }
          this.jdField_a_of_type_Xfo.c(1);
          if (this.jdField_a_of_type_Xfo == null) {
            continue;
          }
          this.jdField_a_of_type_Xfo.a();
          continue;
        }
        return true;
        if (this.jdField_a_of_type_Xfo != null) {
          this.jdField_a_of_type_Xfo.d(1);
        }
        if (this.jdField_a_of_type_Xfo != null) {
          this.jdField_a_of_type_Xfo.a();
        }
      }
    }
    return false;
  }
  
  public xfj b()
  {
    yuk.a("StoryShare", "show(): %s", toString());
    if (this.jdField_a_of_type_Xgp == null) {
      if (this.jdField_a_of_type_Xfo != null) {
        this.jdField_a_of_type_Xfo.c(0);
      }
    }
    do
    {
      return this;
      this.jdField_a_of_type_Xie.a(this.jdField_a_of_type_Xid);
      if (this.jdField_a_of_type_Xfo != null) {
        this.jdField_a_of_type_Xfo.b();
      }
      this.jdField_a_of_type_Xie.d();
    } while (this.jdField_a_of_type_Xfo == null);
    this.jdField_a_of_type_Xfo.c();
    return this;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfj
 * JD-Core Version:    0.7.0.1
 */