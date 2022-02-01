import android.os.Handler;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController.b;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.1;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.2;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.3;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.5;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.7;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class afnh
  extends aflk
  implements afkm
{
  private boolean bZE;
  private boolean bZF;
  afkn c = new afnk(this);
  public AdapterView.OnItemClickListener i = new afnl(this);
  private int mFromType;
  
  public afnh(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  public int[] C()
  {
    return new int[] { 6, 7, 8, 1, 3 };
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, List<afoo> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {}
    label154:
    label158:
    for (;;)
    {
      return 0;
      if (paramList != null)
      {
        paramQQAppInterface = ((ajdg)paramQQAppInterface.getManager(14)).b(paramString);
        int k;
        int j;
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.jobType == 3) || (paramQQAppInterface.jobType == 5)))
        {
          k = 1;
          int m = paramList.size();
          j = 0;
          label65:
          if (j >= m) {
            break label154;
          }
          paramQQAppInterface = (afoo)paramList.get(j);
          if ((paramQQAppInterface == null) || (paramQQAppInterface.d == null) || (!paramString.equals(paramQQAppInterface.d.epId))) {
            break label124;
          }
        }
        for (;;)
        {
          if (j == -1) {
            break label158;
          }
          return j;
          k = 0;
          break;
          label124:
          if ((k == 0) || (paramQQAppInterface == null) || (paramQQAppInterface.type != 9))
          {
            j += 1;
            break label65;
            j = -1;
          }
        }
      }
    }
  }
  
  public int a(String paramString, List<afoo> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    int k = paramList.size();
    int j = 0;
    while (j < k)
    {
      Object localObject = (afoo)paramList.get(j);
      if (((afoo)localObject).type == 6)
      {
        localObject = ((afoo)localObject).d;
        if ((localObject != null) && (paramString.equals(((EmoticonPackage)localObject).epId)))
        {
          if (paramBoolean) {
            return j - 3;
          }
          return j - 2;
        }
      }
      j += 1;
    }
    return -1;
  }
  
  public void a(afoo paramafoo, boolean paramBoolean)
  {
    String str;
    boolean bool;
    if (paramafoo != null)
    {
      str = "";
      if (paramafoo.type != 7) {
        break label99;
      }
      paramafoo = "0X800AE07";
      bool = true;
    }
    for (;;)
    {
      int j = this.a.z(bool);
      QQAppInterface localQQAppInterface;
      if ((!TextUtils.isEmpty(paramafoo)) && (j != 0))
      {
        localQQAppInterface = this.a.app;
        if (!paramBoolean) {
          break label223;
        }
      }
      label223:
      for (str = "3";; str = "2")
      {
        anot.a(localQQAppInterface, "dc00898", "", "", paramafoo, paramafoo, j, 0, str, "", "", "");
        if (paramBoolean)
        {
          this.bZF = true;
          this.mFromType = 0;
        }
        return;
        label99:
        if ((paramafoo.type == 5) || (paramafoo.type == 4))
        {
          paramafoo = "0X800AE08";
          bool = true;
          break;
        }
        if (paramafoo.type == 11)
        {
          paramafoo = "0X800AE0A";
          bool = true;
          break;
        }
        if (paramafoo.type == 8)
        {
          paramafoo = "0X800AE0B";
          bool = false;
          break;
        }
        if (paramafoo.type == 9)
        {
          paramafoo = "0X800AE0D";
          bool = false;
          break;
        }
        if (paramafoo.type == 12)
        {
          paramafoo = "0X800AE09";
          bool = true;
          break;
        }
        if ((paramafoo.type != 6) && (paramafoo.type != 10)) {
          break label230;
        }
        paramafoo = "0X800AE0C";
        bool = false;
        break;
      }
      label230:
      bool = true;
      paramafoo = str;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPackageDeleted");
    }
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    List localList;
    int k;
    do
    {
      return;
      localList = this.a.zZ;
      int j = 0;
      int m;
      for (k = -1; j < localList.size(); k = m)
      {
        Object localObject = (afoo)localList.get(j);
        m = k;
        if (localObject != null)
        {
          m = k;
          if (((afoo)localObject).type == 6)
          {
            localObject = ((afoo)localObject).d;
            m = k;
            if (localObject != null)
            {
              m = k;
              if (paramEmoticonPackage.epId.equals(((EmoticonPackage)localObject).epId)) {
                m = j;
              }
            }
          }
        }
        j += 1;
      }
    } while (k == -1);
    if (k < EmoticonPanelController.cSe) {
      paramEmoticonPackage = this.a;
    }
    for (paramEmoticonPackage.cSd += 1;; this.a.cSd = (localList.size() - 1)) {
      do
      {
        this.a.bwe = true;
        return;
      } while ((k != EmoticonPanelController.cSe) || (k != localList.size() - 1));
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPackageMoved");
    }
    this.a.bwe = true;
  }
  
  public void a(boolean paramBoolean, EmoticonPanelController.b paramb)
  {
    QLog.d("EmoticonPanelMallHelper", 1, "asyncInitPanelDataList begin");
    ThreadManager.post(new EmoticonPanelMallHelper.1(this, paramBoolean, paramb), 5, null, true);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      QLog.e("EmoticonPanelMallHelper", 1, "onPackageAdded: ep = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPackageAdded: ep = " + paramEmoticonPackage);
    }
    this.a.bwe = true;
    ThreadManager.getUIHandler().post(new EmoticonPanelMallHelper.7(this, paramEmoticonPackage));
  }
  
  public void dae()
  {
    afkd.a().a(this);
    afkd.a().a(this.c);
  }
  
  public void dao()
  {
    if (!this.a.b().isShown()) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelMallHelper.5(this), 200L);
  }
  
  public void dap()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelMallHelper.2(this), 200L);
  }
  
  public void onDestory()
  {
    afkd.a().b(this);
    afkd.a().b(this.c);
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((this.a.zZ == null) || (paramInt >= this.a.zZ.size())) {
      return;
    }
    if (this.a.a != null)
    {
      afll localafll = this.a.a.a((afoo)this.a.zZ.get(paramInt));
      if ((localafll instanceof afoa)) {
        ((afoa)localafll).daL();
      }
    }
    if ((this.bZE) || (this.bZF))
    {
      this.bZE = false;
      this.bZF = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPageSelected position: " + paramInt);
    }
    this.mFromType = 2;
    this.bZE = false;
    a((afoo)this.a.zZ.get(paramInt), false);
  }
  
  public void onPause()
  {
    afkd.a().b(this.c);
  }
  
  public void onResume()
  {
    afkd.a().a(this.c);
  }
  
  public void preloadWebProcess()
  {
    ThreadManager.getSubThreadHandler().post(new EmoticonPanelMallHelper.3(this));
  }
  
  public int sZ()
  {
    return this.mFromType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnh
 * JD-Core Version:    0.7.0.1
 */