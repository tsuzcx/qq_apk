import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.HorizonEmoticonTabs;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class foi
  extends EmoticonPackageDownloadListener
{
  public foi(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void onCoverComplete(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onCoverComplete");
    }
    if ((paramEmoticonPackage == null) || (EmoticonMainPanel.b(this.a) == null)) {
      break label28;
    }
    label28:
    label284:
    for (;;)
    {
      return;
      if ((paramInt2 == 0) && (EmoticonMainPanel.b() == 1))
      {
        label60:
        Object localObject;
        if (paramInt1 == 4)
        {
          paramInt2 = EmoticonMainPanel.b(this.a).size();
          paramInt1 = 0;
          if (paramInt1 >= paramInt2) {
            break label279;
          }
          localObject = (EmoticonViewBinder)EmoticonMainPanel.b(this.a).get(paramInt1);
          if ((localObject != null) && ((localObject instanceof BigEmoticonViewBinder)))
          {
            localObject = (BigEmoticonViewBinder)localObject;
            if ((((BigEmoticonViewBinder)localObject).a != null) && (((BigEmoticonViewBinder)localObject).a.epId.equals(paramEmoticonPackage.epId))) {
              paramEmoticonPackage = ((BigEmoticonViewBinder)localObject).a(this.a.getContext());
            }
          }
        }
        for (;;)
        {
          if ((EmoticonMainPanel.a(this.a) == null) || (paramInt1 == -1)) {
            break label284;
          }
          EmoticonMainPanel.a(this.a).a(paramEmoticonPackage, paramInt1);
          return;
          paramInt1 += 1;
          break label60;
          if (paramInt1 != 2) {
            break;
          }
          paramInt2 = EmoticonMainPanel.b(this.a).size();
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            localObject = (EmoticonViewBinder)EmoticonMainPanel.b(this.a).get(paramInt1);
            if ((localObject != null) && ((localObject instanceof BigEmoticonViewBinder)))
            {
              localObject = (BigEmoticonViewBinder)localObject;
              if ((((BigEmoticonViewBinder)localObject).a != null) && (((BigEmoticonViewBinder)localObject).a.epId.equals(paramEmoticonPackage.epId)))
              {
                ((BigEmoticonViewBinder)localObject).c();
                return;
              }
            }
            paramInt1 += 1;
          }
          break label28;
          paramEmoticonPackage = null;
          paramInt1 = -1;
        }
      }
    }
  }
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    this.a.post(new foj(this, paramEmoticonPackage, paramInt));
  }
  
  public void onPackageProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "onPackageProgress: epId=" + paramEmoticonPackage.epId);
          }
        } while ((EmoticonMainPanel.b() != 1) || (EmoticonMainPanel.b(this.a) == null) || (EmoticonMainPanel.d() >= EmoticonMainPanel.b(this.a).size()));
        localObject = (EmoticonViewBinder)EmoticonMainPanel.b(this.a).get(EmoticonMainPanel.d());
      } while ((localObject == null) || (!(localObject instanceof BigEmoticonViewBinder)));
      localObject = (BigEmoticonViewBinder)localObject;
    } while ((((BigEmoticonViewBinder)localObject).a == null) || (!((BigEmoticonViewBinder)localObject).a.epId.equals(paramEmoticonPackage.epId)));
    ((BigEmoticonViewBinder)localObject).a((int)(100.0F * paramInt2 / paramInt1));
  }
  
  public void onPackageStart(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "onPackageStart: epId=" + paramEmoticonPackage.epId);
          }
        } while ((EmoticonMainPanel.b() != 1) || (EmoticonMainPanel.a(this.a) == null) || (EmoticonMainPanel.c() >= EmoticonMainPanel.a(this.a).size()));
        localObject = (EmoticonViewBinder)EmoticonMainPanel.a(this.a).get(EmoticonMainPanel.c());
      } while ((localObject == null) || (!(localObject instanceof BigEmoticonViewBinder)));
      localObject = (BigEmoticonViewBinder)localObject;
    } while ((((BigEmoticonViewBinder)localObject).a == null) || (!((BigEmoticonViewBinder)localObject).a.epId.equals(paramEmoticonPackage.epId)));
    ((BigEmoticonViewBinder)localObject).a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     foi
 * JD-Core Version:    0.7.0.1
 */