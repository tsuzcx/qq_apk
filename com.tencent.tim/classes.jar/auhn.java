import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.PadInfo;
import java.util.List;

public class auhn
  implements auhk.d
{
  private augx jdField_a_of_type_Augx;
  private auhk.e jdField_a_of_type_Auhk$e;
  private QQAppInterface app;
  private aqju m;
  
  public auhn(QQAppInterface paramQQAppInterface, augx paramaugx)
  {
    this.jdField_a_of_type_Augx = paramaugx;
    this.app = paramQQAppInterface;
  }
  
  private void a(Context paramContext, atkw paramatkw)
  {
    dUd();
    if (paramatkw == null) {
      return;
    }
    Object localObject2 = "";
    Object localObject1 = paramContext.getString(2131721079);
    Object localObject3;
    if (paramatkw.relatedType == 7)
    {
      localObject3 = (PadInfo)paramatkw.fQ;
      if ((((PadInfo)localObject3).type_list == 1) || ((((PadInfo)localObject3).creatorUin > 0L) && (this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(((PadInfo)localObject3).creatorUin))))) {
        if (((PadInfo)localObject3).type == 1)
        {
          localObject2 = paramContext.getString(2131720894);
          localObject1 = paramContext.getString(2131720889);
        }
      }
    }
    for (;;)
    {
      this.m = aqha.a(paramContext, 230).setMessage((CharSequence)localObject2);
      this.m.setPositiveButton((String)localObject1, new auho(this, paramatkw, paramContext));
      this.m.setNegativeButton(paramContext.getString(2131721058), new auhp(this));
      this.m.show();
      return;
      if (((PadInfo)localObject3).type == 2)
      {
        localObject2 = paramContext.getString(2131720900);
        localObject1 = paramContext.getString(2131720892);
      }
      else if (((PadInfo)localObject3).type == 3)
      {
        localObject2 = paramContext.getString(2131720896);
        localObject1 = paramContext.getString(2131720890);
      }
      else if (((PadInfo)localObject3).type == 4)
      {
        localObject2 = paramContext.getString(2131720898);
        localObject1 = paramContext.getString(2131720891);
        continue;
        if (((PadInfo)localObject3).type == 1) {
          localObject1 = paramContext.getString(2131720893);
        }
        for (;;)
        {
          localObject3 = paramContext.getString(2131691404);
          localObject2 = localObject1;
          localObject1 = localObject3;
          break;
          if (((PadInfo)localObject3).type == 2)
          {
            localObject1 = paramContext.getString(2131720899);
          }
          else if (((PadInfo)localObject3).type == 3)
          {
            localObject1 = paramContext.getString(2131720895);
          }
          else
          {
            if (((PadInfo)localObject3).type == 4)
            {
              localObject1 = paramContext.getString(2131720897);
              continue;
              localObject2 = paramContext.getString(2131691647);
              localObject1 = paramContext.getString(2131691648);
              break;
            }
            localObject1 = "";
          }
        }
      }
    }
  }
  
  private void dUd()
  {
    if ((this.m == null) || (this.m.isShowing())) {}
    try
    {
      this.m.dismiss();
      this.m = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("CloudRecentHistoryOperationContrller", 1, " dismiss exception: " + localException.toString());
      }
    }
  }
  
  public boolean Pp()
  {
    return false;
  }
  
  public void a(Context paramContext, Object... paramVarArgs)
  {
    if ((paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof atkw))) {
      a(paramContext, (atkw)paramVarArgs[0]);
    }
  }
  
  public void a(auhk.e parame)
  {
    this.jdField_a_of_type_Auhk$e = parame;
  }
  
  public void d(Context paramContext, Object paramObject) {}
  
  public void e(Context paramContext, Object paramObject) {}
  
  public void euU() {}
  
  public void h(Context paramContext, List<Object> paramList) {}
  
  public void i(Context paramContext, List<Object> paramList) {}
  
  public void qw(String paramString) {}
  
  public void showSuccessToast(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhn
 * JD-Core Version:    0.7.0.1
 */