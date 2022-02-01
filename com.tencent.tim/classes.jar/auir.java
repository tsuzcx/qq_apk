import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.tencent.cloudfile.CloudBase;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.CloudFileDirBrowserActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class auir
  implements auhk.d
{
  private augx jdField_a_of_type_Augx;
  private auhk.e jdField_a_of_type_Auhk$e;
  private QQAppInterface app;
  private aqky b;
  private aqju be;
  private aqju m;
  
  public auir(QQAppInterface paramQQAppInterface, augx paramaugx)
  {
    this.jdField_a_of_type_Augx = paramaugx;
    this.app = paramQQAppInterface;
  }
  
  private void a(Context paramContext, PadInfo paramPadInfo)
  {
    dUd();
    if (paramPadInfo == null) {
      return;
    }
    Object localObject2 = "";
    Object localObject1 = paramContext.getString(2131721079);
    if ((paramPadInfo.type_list == 1) || ((paramPadInfo.creatorUin > 0L) && (this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin))))) {
      if (paramPadInfo.type == 1)
      {
        localObject2 = paramContext.getString(2131720894);
        localObject1 = paramContext.getString(2131720889);
      }
    }
    for (;;)
    {
      this.m = aqha.a(paramContext, 230).setMessage((CharSequence)localObject2);
      this.m.setPositiveButton((String)localObject1, new auiu(this, paramPadInfo));
      this.m.setNegativeButton(paramContext.getString(2131721058), new auiv(this));
      this.m.show();
      return;
      if (paramPadInfo.type == 2)
      {
        localObject2 = paramContext.getString(2131720900);
        localObject1 = paramContext.getString(2131720892);
      }
      else if (paramPadInfo.type == 3)
      {
        localObject2 = paramContext.getString(2131720896);
        localObject1 = paramContext.getString(2131720890);
      }
      else if (paramPadInfo.type == 4)
      {
        localObject2 = paramContext.getString(2131720898);
        localObject1 = paramContext.getString(2131720891);
        continue;
        if (paramPadInfo.type == 1) {
          localObject1 = paramContext.getString(2131720893);
        }
        for (;;)
        {
          String str = paramContext.getString(2131691404);
          localObject2 = localObject1;
          localObject1 = str;
          break;
          if (paramPadInfo.type == 2)
          {
            localObject1 = paramContext.getString(2131720899);
          }
          else if (paramPadInfo.type == 3)
          {
            localObject1 = paramContext.getString(2131720895);
          }
          else
          {
            localObject1 = localObject2;
            if (paramPadInfo.type == 4) {
              localObject1 = paramContext.getString(2131720897);
            }
          }
        }
      }
      else
      {
        localObject2 = "";
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
        QLog.e("TeamWorkOperationController", 1, " dismiss exception: " + localException.toString());
      }
    }
  }
  
  public String Fc()
  {
    if (this.b != null) {
      return this.b.getInputValue();
    }
    return "";
  }
  
  public boolean Pp()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Augx != null) {
      bool = this.jdField_a_of_type_Augx.Pp();
    }
    return bool;
  }
  
  public void a(Context paramContext, Object... paramVarArgs)
  {
    if ((paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof PadInfo)))
    {
      a(paramContext, (PadInfo)paramVarArgs[0]);
      return;
    }
    paramVarArgs = new auis(this, paramVarArgs);
    auit localauit = new auit(this);
    this.be = aqha.a(paramContext, 230, null, paramContext.getString(2131691611), paramVarArgs, localauit);
    this.be.show();
  }
  
  public void a(auhk.e parame)
  {
    this.jdField_a_of_type_Auhk$e = parame;
  }
  
  public void d(Context paramContext, Object paramObject)
  {
    auiw localauiw = new auiw(this);
    auix localauix = new auix(this, paramObject);
    auiy localauiy = new auiy(this);
    if ((paramObject instanceof FileManagerEntity)) {
      paramObject = ((FileManagerEntity)paramObject).cloudFile;
    }
    for (String str = paramContext.getString(2131691629);; str = paramContext.getString(2131691614))
    {
      this.b = aqha.a(paramContext, 2131691654, paramObject.showName, str, localauiw, 2131721079, localauix, 2131721058, localauiy);
      this.b.setOnDismissListener(new auiz(this));
      return;
      paramObject = ((atin)paramObject).a;
    }
  }
  
  public void e(Context paramContext, Object paramObject)
  {
    paramObject = new Intent(paramContext, CloudFileDirBrowserActivity.class);
    Object localObject = new FileInfo();
    ((FileInfo)localObject).bf(((atgc)((QQAppInterface)((BaseActivity)paramContext).getAppInterface()).getManager(373)).aE());
    ((FileInfo)localObject).setName(paramContext.getString(2131691603));
    paramObject.putExtra("key_file_info", (Parcelable)localObject);
    paramObject.putExtra("key_file_browser_mode", 1);
    paramObject.putExtra("key_bottom_bar_left_action", 1);
    paramObject.putExtra("key_bottom_bar_right_action", 3);
    paramObject.putExtra("key_is_root_dir_selectable", false);
    localObject = ((FragmentActivity)paramContext).getSupportFragmentManager().getFragments();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramContext = ((List)localObject).iterator();
      while (paramContext.hasNext())
      {
        localObject = (Fragment)paramContext.next();
        if ((localObject != null) && (((Fragment)localObject).isVisible())) {
          ((Fragment)localObject).startActivityForResult(paramObject, 4);
        }
      }
      return;
    }
    ((Activity)paramContext).startActivityForResult(paramObject, 4);
  }
  
  public void euU()
  {
    if ((this.be != null) && (this.be.isShowing())) {
      this.be.dismiss();
    }
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    dUd();
  }
  
  public void h(Context paramContext, List<Object> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Intent localIntent;
    do
    {
      return;
      while (!paramContext.hasNext())
      {
        localIntent = new Intent(paramContext, CloudFileDirBrowserActivity.class);
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = paramList.next();
          if ((localObject instanceof atin)) {
            localArrayList.add(aueh.a((atin)localObject));
          } else if ((localObject instanceof FileManagerEntity)) {
            localArrayList.add(aueh.a((FileManagerEntity)localObject));
          }
        }
        paramList = new FileInfo();
        paramList.bf(((atgc)((QQAppInterface)((BaseActivity)paramContext).getAppInterface()).getManager(373)).aE());
        paramList.setName(paramContext.getString(2131691641));
        localIntent.putExtra("key_file_info", paramList);
        localIntent.putExtra("key_file_browser_mode", 1);
        localIntent.putExtra("key_bottom_bar_left_action", 1);
        localIntent.putExtra("key_bottom_bar_right_action", 1);
        localIntent.putExtra("key_file_to_be_dealt_with", localArrayList);
        paramList = ((FragmentActivity)paramContext).getSupportFragmentManager().getFragments();
        if ((paramList == null) || (paramList.size() <= 0)) {
          break;
        }
        paramContext = paramList.iterator();
      }
      paramList = (Fragment)paramContext.next();
    } while ((paramList == null) || (!paramList.isVisible()));
    paramList.startActivityForResult(localIntent, 3);
    return;
    ((Activity)paramContext).startActivityForResult(localIntent, 3);
  }
  
  public void i(Context paramContext, List<Object> paramList) {}
  
  public void qw(String paramString)
  {
    ahao.D(1, paramString, 0);
  }
  
  public void showSuccessToast(String paramString)
  {
    ahao.D(2, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auir
 * JD-Core Version:    0.7.0.1
 */