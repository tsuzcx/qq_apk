import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atdr
  implements auhk.b
{
  protected augx a;
  private auhk.c a;
  protected Context context;
  protected arhz d;
  private ausj e;
  protected int epo;
  
  public atdr(Context paramContext, int paramInt, augx paramaugx)
  {
    this.context = paramContext;
    this.epo = paramInt;
    this.jdField_a_of_type_Augx = paramaugx;
  }
  
  public boolean Pp()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Augx != null) {
      bool = this.jdField_a_of_type_Augx.Pp();
    }
    return bool;
  }
  
  public void a(auhk.a parama)
  {
    this.jdField_a_of_type_Auhk$c = ((auhk.c)parama);
  }
  
  public void al(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      QQToast.a(this.context, 2, paramString, 0).show(this.context.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    QQToast.a(this.context, 1, paramString, 0).show(this.context.getResources().getDimensionPixelSize(2131299627));
  }
  
  public void dismiss()
  {
    if (this.e != null) {
      this.e.dismiss();
    }
  }
  
  public void ehM()
  {
    try
    {
      if ((this.d != null) && (this.d.isShowing())) {
        this.d.dismiss();
      }
      this.d = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getInputValue()
  {
    return null;
  }
  
  protected List<ResolveInfo> hf()
  {
    Object localObject = new Intent("android.intent.action.GET_CONTENT");
    ((Intent)localObject).addCategory("android.intent.category.OPENABLE");
    ((Intent)localObject).setType("*/*");
    ((Intent)localObject).putExtra("android.intent.extra.MIME_TYPES", (String[])aopl.q(this.context).toArray(new String[0]));
    PackageManager localPackageManager = this.context.getPackageManager();
    localObject = localPackageManager.queryIntentActivities((Intent)localObject, 65536);
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      Log.e("all_type", localResolveInfo.loadLabel(localPackageManager) + "\n" + localResolveInfo.activityInfo.packageName + "\n" + localResolveInfo.activityInfo.name);
      if ((localResolveInfo == null) || (localResolveInfo.activityInfo == null) || ((!"cn.wps.moffice_eng".equals(localResolveInfo.activityInfo.packageName)) && (!"com.dropbox.android".equals(localResolveInfo.activityInfo.packageName)) && (!"com.microsoft.skydrive".equals(localResolveInfo.activityInfo.packageName)))) {
        localIterator.remove();
      }
    }
    return localObject;
  }
  
  public void show()
  {
    if (((Activity)this.context).isFinishing()) {
      return;
    }
    this.e = ((ausj)auss.a(this.context, null));
    String[] arrayOfString = this.context.getResources().getStringArray(2130969881);
    ArrayList localArrayList = new ArrayList();
    this.e.addButton(arrayOfString[0]);
    localArrayList.add(new Pair(Integer.valueOf(0), null));
    Object localObject = hf();
    PackageManager localPackageManager = this.context.getPackageManager();
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
        this.e.addButton(localResolveInfo.loadLabel(localPackageManager));
        localArrayList.add(new Pair(Integer.valueOf(1), localResolveInfo));
      }
    }
    this.e.addButton(arrayOfString[2]);
    localArrayList.add(new Pair(Integer.valueOf(2), null));
    this.e.a(new atds(this, localArrayList));
    this.e.show();
  }
  
  public void showLoading()
  {
    try
    {
      this.d = new arhz(this.context);
      this.d.setMessage("加载中…");
      this.d.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdr
 * JD-Core Version:    0.7.0.1
 */