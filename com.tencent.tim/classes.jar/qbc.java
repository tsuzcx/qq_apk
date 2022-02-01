import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import java.util.Map;

public class qbc
  implements qdt
{
  private qbg jdField_a_of_type_Qbg = new qbe(this);
  private qbh jdField_a_of_type_Qbh;
  private final qbj jdField_a_of_type_Qbj = new qbd(this);
  private qci jdField_a_of_type_Qci;
  private qdt jdField_a_of_type_Qdt;
  private qdu jdField_a_of_type_Qdu;
  
  public qbc() {}
  
  private qbc(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_Qdu = new qdp(paramActivity);
  }
  
  public static qbc a(@NonNull Activity paramActivity)
  {
    return new qbc(paramActivity);
  }
  
  public static qbc a(@NonNull Activity paramActivity, qdu paramqdu)
  {
    return new qbc().a(paramqdu);
  }
  
  public qbc a()
  {
    if (this.jdField_a_of_type_Qdu.m() == null) {
      return this;
    }
    this.jdField_a_of_type_Qdu.mShowTitle = false;
    return this;
  }
  
  public qbc a(int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_Qdu.m();
    if (localActivity == null) {
      return this;
    }
    this.jdField_a_of_type_Qdu.mTitle = localActivity.getString(paramInt);
    return this;
  }
  
  public qbc a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Qdu.mTitle = paramString;
    return this;
  }
  
  public qbc a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Qci == null) {
      throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
    }
    this.jdField_a_of_type_Qci.fP.put(paramString1, paramString2);
    return this;
  }
  
  public qbc a(@NonNull List<int[]> paramList)
  {
    this.jdField_a_of_type_Qdu.nK = paramList;
    return this;
  }
  
  public qbc a(qbh paramqbh)
  {
    this.jdField_a_of_type_Qbh = paramqbh;
    return this;
  }
  
  public qbc a(@NonNull qci paramqci)
  {
    this.jdField_a_of_type_Qci = paramqci;
    this.jdField_a_of_type_Qci.bd(this.jdField_a_of_type_Qdu.m());
    this.jdField_a_of_type_Qci.jdField_a_of_type_Qbg = this.jdField_a_of_type_Qbg;
    this.jdField_a_of_type_Qdt = new qbf(this);
    return this;
  }
  
  public qbc a(qdu paramqdu)
  {
    this.jdField_a_of_type_Qdu = paramqdu;
    return this;
  }
  
  public qbc b()
  {
    ram.b("StoryShare", "show(): %s", toString());
    if (this.jdField_a_of_type_Qci == null) {
      if (this.jdField_a_of_type_Qbh != null) {
        this.jdField_a_of_type_Qbh.onFailure(0);
      }
    }
    do
    {
      return this;
      this.jdField_a_of_type_Qdu.a(this.jdField_a_of_type_Qdt);
      if (this.jdField_a_of_type_Qbh != null) {
        this.jdField_a_of_type_Qbh.onStart();
      }
      this.jdField_a_of_type_Qdu.show();
    } while (this.jdField_a_of_type_Qbh == null);
    this.jdField_a_of_type_Qbh.bnD();
    return this;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 29782)
    {
      Activity localActivity = this.jdField_a_of_type_Qdu.m();
      if ((paramInt2 == -1) && (localActivity != null)) {}
      for (;;)
      {
        try
        {
          apzg.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
          if (this.jdField_a_of_type_Qbh != null) {
            this.jdField_a_of_type_Qbh.onSuccess(1);
          }
          if (this.jdField_a_of_type_Qbh != null) {
            this.jdField_a_of_type_Qbh.onFinish();
          }
        }
        catch (Exception paramIntent)
        {
          if (this.jdField_a_of_type_Qbh == null) {
            continue;
          }
          this.jdField_a_of_type_Qbh.onFailure(1);
          if (this.jdField_a_of_type_Qbh == null) {
            continue;
          }
          this.jdField_a_of_type_Qbh.onFinish();
          continue;
        }
        return true;
        if (this.jdField_a_of_type_Qbh != null) {
          this.jdField_a_of_type_Qbh.we(1);
        }
        if (this.jdField_a_of_type_Qbh != null) {
          this.jdField_a_of_type_Qbh.onFinish();
        }
      }
    }
    return false;
  }
  
  public void onCancel() {}
  
  public void onClick(int paramInt) {}
  
  public void onDismiss() {}
  
  public void onShow() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbc
 * JD-Core Version:    0.7.0.1
 */