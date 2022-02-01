import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class aktk
{
  public static final AppRuntime.Status[] a = { AppRuntime.Status.online, AppRuntime.Status.away, AppRuntime.Status.busy, AppRuntime.Status.dnd, AppRuntime.Status.invisiable };
  
  public static int a(AppRuntime.Status paramStatus)
  {
    switch (aktl.mk[paramStatus.ordinal()])
    {
    default: 
      QLog.d("Q..online.status", 1, "getButtonId changed to online , status: " + paramStatus);
    case 1: 
      return 2131361925;
    case 2: 
      return 2131361926;
    case 3: 
      return 2131361921;
    case 4: 
      return 2131361922;
    case 5: 
      return 2131361923;
    }
    return 2131361924;
  }
  
  public static Drawable a(AppRuntime.Status paramStatus)
  {
    return a(paramStatus, 0);
  }
  
  public static Drawable a(AppRuntime.Status paramStatus, int paramInt)
  {
    Object localObject = null;
    if (paramStatus != null) {}
    try
    {
      switch (aktl.mk[paramStatus.ordinal()])
      {
      case 1: 
        QLog.d("Q..online.status", 1, "getStatusIcon, not find status: " + paramStatus);
        paramStatus = localObject;
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
        for (;;)
        {
          if ((paramStatus != null) && (paramInt > 0)) {
            paramStatus.setBounds(0, 0, paramInt, paramInt);
          }
          return paramStatus;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837629);
          continue;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837631);
          continue;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837620);
          continue;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837622);
          continue;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837625);
          continue;
          paramStatus = BaseApplicationImpl.getContext().getResources().getDrawable(2130837627);
          continue;
          QLog.d("Q..online.status", 1, "getStatusIcon, status == null");
          paramStatus = localObject;
        }
      }
    }
    catch (Exception paramStatus)
    {
      for (;;)
      {
        QLog.d("Q..online.status", 1, "getStatusDrawable", paramStatus);
        paramStatus = localObject;
      }
    }
  }
  
  public static String a(AppRuntime.Status paramStatus)
  {
    if (paramStatus != null)
    {
      switch (aktl.mk[paramStatus.ordinal()])
      {
      default: 
        QLog.d("Q..online.status", 1, "getStatusName, not find status: " + paramStatus);
        return "";
      case 1: 
        return BaseApplicationImpl.getContext().getString(2131720456);
      case 2: 
        return BaseApplicationImpl.getContext().getString(2131720457);
      case 3: 
        return BaseApplicationImpl.getContext().getString(2131720439);
      case 4: 
        return BaseApplicationImpl.getContext().getString(2131720443);
      case 5: 
        return BaseApplicationImpl.getContext().getString(2131720449);
      }
      return BaseApplicationImpl.getContext().getString(2131720452);
    }
    QLog.d("Q..online.status", 1, "getStatusName, status is null");
    return "";
  }
  
  public static AppRuntime.Status a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return AppRuntime.Status.online;
    case 2: 
      return AppRuntime.Status.offline;
    case 3: 
      return AppRuntime.Status.away;
    case 4: 
      return AppRuntime.Status.invisiable;
    case 5: 
      return AppRuntime.Status.busy;
    case 6: 
      return AppRuntime.Status.qme;
    }
    return AppRuntime.Status.dnd;
  }
  
  public static boolean a(AppRuntime.Status paramStatus)
  {
    return (paramStatus == AppRuntime.Status.away) || (paramStatus == AppRuntime.Status.busy) || (paramStatus == AppRuntime.Status.dnd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktk
 * JD-Core Version:    0.7.0.1
 */