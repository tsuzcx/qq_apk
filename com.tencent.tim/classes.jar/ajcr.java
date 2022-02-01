import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ajcr
  implements IEventReceiver
{
  private static volatile ajcr jdField_a_of_type_Ajcr;
  private ajco jdField_a_of_type_Ajco = new ajco();
  private ajcq jdField_a_of_type_Ajcq = new ajcq();
  private ajcr.c jdField_a_of_type_Ajcr$c = new ajcr.c(this);
  private SparseArray<ajcl> cR;
  private Map<String, ajck> lJ = new LinkedHashMap();
  private Map<String, MiniAppOptions> mOptionsMap = new HashMap();
  
  private ajcr()
  {
    pmi.a().registerSubscriber("MiniAppManager", this.jdField_a_of_type_Ajcr$c);
  }
  
  private void Mj(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    ajck localajck = (ajck)this.lJ.remove(paramString);
    if (localajck != null) {
      localajck.onDestroy();
    }
    this.mOptionsMap.remove(paramString);
  }
  
  private ajcn a(String paramString, int paramInt1, ajcn paramajcn, int paramInt2, boolean paramBoolean, ajco.a parama, int paramInt3)
  {
    if ((paramajcn != null) && (this.jdField_a_of_type_Ajco.a(paramajcn, paramInt2, paramInt3))) {
      if ((parama != null) && (parama.bs != null)) {
        parama.a(parama.bs.get(), true, paramajcn);
      }
    }
    do
    {
      do
      {
        return paramajcn;
        if ((paramajcn == null) || (paramInt2 != 1) || (!this.jdField_a_of_type_Ajco.a(paramajcn))) {
          break;
        }
        paramString = (ajck)this.lJ.get(paramajcn.cacheKey);
        if (paramString != null) {
          paramString.b(paramajcn);
        }
      } while ((parama == null) || (parama.bs == null));
      parama.a(parama.bs.get(), true, paramajcn);
      return paramajcn;
      if ((paramajcn == null) || (paramInt2 != 2) || (!this.jdField_a_of_type_Ajco.b(paramajcn))) {
        break;
      }
      paramString = (ajck)this.lJ.get(paramajcn.cacheKey);
      if (paramString != null) {
        paramString.b(paramajcn);
      }
    } while ((parama == null) || (parama.bs == null));
    parama.a(parama.bs.get(), true, paramajcn);
    return paramajcn;
    if (paramBoolean)
    {
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        Object localObject = paramajcn;
        if (paramajcn == null)
        {
          paramString = new ajcn(paramString, paramInt1);
          paramajcn = (ajck)this.lJ.get(paramString.cacheKey);
          localObject = paramString;
          if (paramajcn != null)
          {
            paramajcn.b(paramString);
            localObject = paramString;
          }
        }
        this.jdField_a_of_type_Ajco.a((ajcn)localObject, paramInt2, parama);
      }
      for (;;)
      {
        return null;
        if ((parama != null) && (parama.bs != null)) {
          parama.a(parama.bs.get(), false, null);
        }
      }
    }
    if ((parama != null) && (parama.bs != null)) {
      parama.a(parama.bs.get(), false, null);
    }
    return null;
  }
  
  public static ajcr a()
  {
    if (jdField_a_of_type_Ajcr == null) {}
    try
    {
      if (jdField_a_of_type_Ajcr == null) {
        jdField_a_of_type_Ajcr = new ajcr();
      }
      return jdField_a_of_type_Ajcr;
    }
    finally {}
  }
  
  private void a(ajck paramajck)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramajck.d.cacheKey });
    }
    ajcr.b localb = new ajcr.b(this);
    a(paramajck.d.appId, paramajck.d.appType, 2, true, localb);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "runApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    Intent localIntent = new Intent(paramActivity, MiniAppActivity.class);
    localIntent.putExtra("key_appid", paramString);
    localIntent.putExtra("key_appType", paramInt);
    localIntent.putExtra("key_options", paramMiniAppOptions);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.setFlags(268435456);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130772367, 2130772002);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.jdField_a_of_type_Ajcq.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      aw(paramString, paramInt, 1000);
      return;
    }
    String str = ajcn.ao(paramString, paramInt);
    this.lJ.put(str, paramMiniAppActivity);
    this.mOptionsMap.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new ajcr.a(this));
  }
  
  private void aw(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131708390), 0).show();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    eZ(paramString, paramInt1);
    Mj(ajcn.ao(paramString, paramInt1));
  }
  
  private void b(ajck paramajck)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramajck.d.cacheKey });
    }
    this.jdField_a_of_type_Ajcq.a(paramajck, (MiniAppOptions)this.mOptionsMap.get(paramajck.d.cacheKey));
  }
  
  public ajcl a(String paramString)
  {
    if (this.cR == null) {
      this.cR = new SparseArray();
    }
    int i = ajcl.dw(paramString);
    if (i > 0)
    {
      ajcl localajcl = (ajcl)this.cR.get(i);
      paramString = localajcl;
      if (localajcl == null)
      {
        paramString = new ajci();
        this.cR.put(i, paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public ajcn a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, ajco.a parama)
  {
    return a(paramString, paramInt1, paramInt2, paramBoolean, parama, 0);
  }
  
  public ajcn a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, ajco.a parama, int paramInt3)
  {
    if (parama == null) {
      return this.jdField_a_of_type_Ajco.a(ajcn.ao(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.jdField_a_of_type_Ajco.a(ajcn.ao(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, parama, paramInt3);
  }
  
  public void c(ajcn paramajcn)
  {
    this.jdField_a_of_type_Ajco.lI.put(paramajcn.cacheKey, paramajcn);
  }
  
  void eZ(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (ajck)this.lJ.get(ajcn.ao(paramString, paramInt));
    if ((paramString != null) && (paramString.isRunning())) {
      paramString.stop();
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  static class a
    extends ajco.a<ajcr>
  {
    public a(ajcr paramajcr)
    {
      super();
    }
    
    public void a(ajcr paramajcr, boolean paramBoolean, ajcn paramajcn)
    {
      if (paramajcr == null) {
        return;
      }
      if (paramBoolean)
      {
        ajcr.a(paramajcr, (ajck)ajcr.a(paramajcr).get(paramajcn.cacheKey));
        return;
      }
      ajcr.a(paramajcr, paramajcn.appId, paramajcn.appType, 1001);
    }
  }
  
  static class b
    extends ajco.a<ajcr>
  {
    public b(ajcr paramajcr)
    {
      super();
    }
    
    public void a(ajcr paramajcr, boolean paramBoolean, ajcn paramajcn)
    {
      if (paramajcr == null) {
        return;
      }
      if (paramBoolean)
      {
        ajcl localajcl = paramajcr.a(paramajcn.bQG);
        if (localajcl != null)
        {
          ajcr.a(paramajcr).a(paramajcn, localajcl);
          return;
        }
      }
      ajcr.a(paramajcr, paramajcn.appId, paramajcn.appType, 1002);
    }
  }
  
  static class c
    extends QQUIEventReceiver<ajcr, ajcm>
  {
    public c(@NonNull ajcr paramajcr)
    {
      super();
    }
    
    public void a(@NonNull ajcr paramajcr, @NonNull ajcm paramajcm)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppManager", 2, "receive event:" + paramajcm.toString());
      }
      switch (paramajcm.type)
      {
      }
      do
      {
        do
        {
          return;
        } while ((!"MiniAppLauncher".equals(paramajcm.src)) || (ajcl.dw((String)paramajcm.s[0]) != 1) || (((Integer)paramajcm.s[2]).intValue() == 2));
        String str = (String)paramajcm.s[1];
        if (paramajcm.isSuccess)
        {
          QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131708401), 0).show();
          ajcn localajcn = ajcr.a(paramajcr).a(str, 2, 0, false);
          if (localajcn != null)
          {
            localajcn.extras.putString("unzipped_path", (String)paramajcm.s[3]);
            ajcr.b(paramajcr, (ajck)ajcr.a(paramajcr).get(localajcn.cacheKey));
            return;
          }
        }
        paramajcm = ajcn.q(str);
        ajcr.a(paramajcr, paramajcm[1], Integer.parseInt(paramajcm[0]), 1003);
        return;
        ajcr.a(paramajcr, (MiniAppActivity)paramajcm.s[0], (String)paramajcm.s[1], ((Integer)paramajcm.s[2]).intValue(), (MiniAppOptions)paramajcm.s[3]);
        return;
        ajcr.a(paramajcr, ajcn.ao((String)paramajcm.s[0], ((Integer)paramajcm.s[1]).intValue()));
        return;
      } while (paramajcm.isSuccess);
      ajcr.a(paramajcr, paramajcm.d.appId, paramajcm.d.appType, 1004);
    }
    
    public Class acceptEventClass()
    {
      return ajcm.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcr
 * JD-Core Version:    0.7.0.1
 */