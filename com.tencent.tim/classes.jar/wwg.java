import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper.2;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class wwg
  implements wvs, wwf
{
  private BaseChatPie a;
  Map<Integer, Intent> hH = new HashMap();
  
  wwg(wvm paramwvm, BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    paramwvm.a(this);
  }
  
  private PhotoListPanel b()
  {
    PhotoListPanel localPhotoListPanel = null;
    if (this.a != null) {
      localPhotoListPanel = this.a.a();
    }
    return localPhotoListPanel;
  }
  
  private void handlePause()
  {
    PhotoListPanel localPhotoListPanel = b();
    if (localPhotoListPanel != null) {
      localPhotoListPanel.onPause();
    }
  }
  
  private void handleResume()
  {
    PhotoListPanel localPhotoListPanel = b();
    if (localPhotoListPanel == null) {}
    XPanelContainer localXPanelContainer;
    do
    {
      do
      {
        return;
      } while (this.a == null);
      localXPanelContainer = this.a.a();
    } while ((localXPanelContainer == null) || (localXPanelContainer.vm() != 4));
    localPhotoListPanel.ceT();
    localPhotoListPanel.postDelayed(new PhotoListHelper.2(this, localPhotoListPanel), 2000L);
    localPhotoListPanel.h(this.a);
  }
  
  public int[] C()
  {
    return new int[] { 3, 13, 9, 5 };
  }
  
  public void CT(int paramInt)
  {
    this.hH.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListHelper", 2, "removeSelectedPhotoData code=" + paramInt);
    }
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      CT(this.a.app.hashCode());
      return;
    case 9: 
      handlePause();
      return;
    case 5: 
      handleResume();
      return;
    }
    CT(this.a.app.hashCode());
  }
  
  public void F(int paramInt, Intent paramIntent)
  {
    int j = 0;
    this.hH.put(Integer.valueOf(paramInt), paramIntent);
    if (QLog.isColorLevel())
    {
      if (paramIntent != null) {
        break label54;
      }
      QLog.d("PhotoListHelper", 2, "setSelectedPhotoData null, code=" + paramInt);
    }
    label54:
    while (!paramIntent.hasExtra("PhotoConst.SELECTED_PATHS")) {
      return;
    }
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
    paramIntent = paramIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
    StringBuilder localStringBuilder = new StringBuilder().append("setSelectedPhotoData checked size=");
    if (localObject == null)
    {
      i = 0;
      localObject = localStringBuilder.append(i).append(",checkedIndex size=");
      if (paramIntent != null) {
        break label153;
      }
    }
    label153:
    for (int i = j;; i = paramIntent.size())
    {
      QLog.d("PhotoListHelper", 2, i + ", code=" + paramInt);
      return;
      i = ((ArrayList)localObject).size();
      break;
    }
  }
  
  public Intent a(int paramInt)
  {
    return (Intent)this.hH.get(Integer.valueOf(paramInt));
  }
  
  public void bk()
  {
    int i = 0;
    wvd localwvd = (wvd)this.a.a(24);
    int j = localwvd.getPicCount();
    if (localwvd.isFullScreenMode())
    {
      if (j >= 20)
      {
        QQToast.a(this.a.app.getApp(), 2131696916, 0).show(this.a.app.getApp().getResources().getDimensionPixelSize(2131299627));
        return;
      }
      if ((this.a.sessionInfo.cZ == 1033) || (this.a.sessionInfo.cZ == 1034)) {
        i = 1;
      }
      if ((i != 0) || (this.a.OS()))
      {
        localwvd.K(true);
        return;
      }
      wmj.l(this.a.a(), j);
      this.a.bJe();
      return;
    }
    if (j > 0)
    {
      QQToast.a(this.a.app.getApp(), 2131696886, 0).show(this.a.app.getApp().getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if (this.a.Pj())
    {
      anot.a(this.a.app, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 2, 0, "", "", "", "");
      return;
    }
    anot.a(this.a.app, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 1, 0, "", "", "", "");
    wmj.a(this.a.app, this.a.mActivity, this.a.sessionInfo, null, new Intent(), null);
  }
  
  public void ccA()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if ((this.a.mActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (this.a.mActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.a.mActivity.requestPermissions(new wwh(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
      }
      else
      {
        bk();
        return;
        i = 1;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    PhotoListPanel localPhotoListPanel = b();
    if (localPhotoListPanel != null) {
      if (paramInt2 == -1) {
        switch (paramInt1)
        {
        }
      }
    }
    for (;;)
    {
      localPhotoListPanel.setLastRequestCode(paramInt1);
      return;
      localPhotoListPanel.o(paramInt1, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwg
 * JD-Core Version:    0.7.0.1
 */