import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.BaseEmosmStrategy.1;
import com.tencent.mobileqq.emosm.BaseEmosmStrategy.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class affr
  implements afgs
{
  afgt a = null;
  public boolean aWh;
  public QQAppInterface app;
  afgf b;
  public boolean bXR;
  AtomicBoolean cQ = new AtomicBoolean();
  public List<afpg> zx = new ArrayList();
  
  public affr(QQAppInterface paramQQAppInterface, afgf paramafgf)
  {
    this.app = paramQQAppInterface;
    this.b = paramafgf;
    this.a = new afgt(paramQQAppInterface);
  }
  
  public int CQ()
  {
    return 2131693071;
  }
  
  public void O(Context paramContext, Intent paramIntent)
  {
    if (this.b == null) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if ("com.tencent.mobileqq.action.refresh.emotiom".equals(paramContext))
        {
          this.b.bYN();
          return;
        }
      } while (!"com.tencent.mobileqq.action.upload.emotiom".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d("BaseEmosmStrategy", 2, "onReceive ACTION_UPLOAD_EMOTION");
      }
      paramContext = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramContext != null)
      {
        ThreadManager.excute(new BaseEmosmStrategy.1(this, paramContext), 64, null, false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BaseEmosmStrategy", 2, "onReceive selected is empty");
  }
  
  public afgt a()
  {
    return this.a;
  }
  
  public View a(int paramInt, View paramView, afgf.a parama, afmi paramafmi)
  {
    return paramView;
  }
  
  public String a(afmi paramafmi)
  {
    return null;
  }
  
  public void a(affx.a parama)
  {
    a().a(parama);
  }
  
  public void a(GridView paramGridView, int paramInt, afpn paramafpn) {}
  
  public List<afmi> aY(List<afmi> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      afmi localafmi = (afmi)paramList.next();
      Object localObject;
      if ((localafmi instanceof aflv))
      {
        localObject = (aflv)localafmi;
        if ((!TextUtils.isEmpty(((aflv)localObject).bDZ)) && (!((aflv)localObject).bDZ.equals("needUpload"))) {
          localArrayList.add(localafmi);
        }
      }
      else if ((localafmi instanceof afpg))
      {
        localObject = (afpg)localafmi;
        if ((!TextUtils.isEmpty(((afpg)localObject).bDZ)) && (!((afpg)localObject).bDZ.equals("needUpload"))) {
          localArrayList.add(localafmi);
        }
      }
      else
      {
        localArrayList.add(localafmi);
      }
    }
    return localArrayList;
  }
  
  public boolean ajf()
  {
    return false;
  }
  
  public boolean ajg()
  {
    return true;
  }
  
  public boolean b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void cYP()
  {
    this.cQ.set(false);
  }
  
  public void cYQ()
  {
    if (this.b == null) {
      return;
    }
    Object localObject = aY(this.b.zA);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      if ((((List)localObject).size() > 0) && (((afmi)((List)localObject).get(0)).operateType == 1)) {
        ((List)localObject).remove(0);
      }
      this.b.jX((List)localObject);
      return;
    }
  }
  
  public void cYR()
  {
    if (this.b == null) {
      return;
    }
    Object localObject = this.b.zA;
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      afmi localafmi;
      if (ajf())
      {
        if (((List)localObject).size() <= 0) {
          break label91;
        }
        if (((afmi)((List)localObject).get(0)).operateType != 1)
        {
          localafmi = new afmi();
          localafmi.operateType = 1;
          ((List)localObject).add(0, localafmi);
        }
      }
      for (;;)
      {
        this.b.jX((List)localObject);
        return;
        label91:
        localafmi = new afmi();
        localafmi.operateType = 1;
        ((List)localObject).add(0, localafmi);
      }
    }
  }
  
  public void cYS()
  {
    this.a.onDestroy();
    this.b = null;
  }
  
  public void cYT() {}
  
  public void cYU() {}
  
  public void cYV() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BaseEmosmStrategy", 2, "onActivityResult, PeakConstants.REQUEST_CODE_FOR_PHOTO_PREVIEW");
      }
      if (paramIntent == null) {
        break;
      }
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramIntent != null)
      {
        ThreadManager.excute(new BaseEmosmStrategy.2(this, paramIntent), 64, null, false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BaseEmosmStrategy", 2, "onActivityResult, selected is empty");
    return;
    QLog.e("BaseEmosmStrategy", 1, "onActivityResult, PeakConstants.REQUEST_CODE_FOR_PHOTO_PREVIEW, data is null");
  }
  
  public boolean s(Activity paramActivity)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affr
 * JD-Core Version:    0.7.0.1
 */