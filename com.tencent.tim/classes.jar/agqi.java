import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agqi
{
  private agqi.a jdField_a_of_type_Agqi$a;
  private aguk jdField_a_of_type_Aguk;
  private agwc jdField_a_of_type_Agwc;
  private agxu jdField_a_of_type_Agxu;
  private agsa b;
  protected agsb b;
  private Bundle ba;
  private int cYH = 0;
  private ShareActionSheet d;
  private Activity mContext;
  
  public agqi(Activity paramActivity, agsa paramagsa, agqi.a parama)
  {
    this.mContext = paramActivity;
    this.jdField_b_of_type_Agsa = paramagsa;
    this.jdField_a_of_type_Agqi$a = parama;
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfArrayList)
  {
    if ((paramArrayOfArrayList != null) && (paramArrayOfArrayList.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfArrayList.length)
      {
        Object localObject = paramArrayOfArrayList[i];
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next()).action == 26) {
              anot.a(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private boolean amm()
  {
    if (this.jdField_a_of_type_Aguk != null)
    {
      int i = this.jdField_a_of_type_Aguk.bE();
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 1, "refreshFileView. currentType[" + this.cYH + "] fileType[" + i + "]");
      }
      if (this.cYH != i)
      {
        if (this.jdField_a_of_type_Agwc != null) {
          this.jdField_a_of_type_Agwc.cqt();
        }
        switch (i)
        {
        default: 
          this.jdField_a_of_type_Agwc = new agwv(this.jdField_a_of_type_Aguk, this.mContext);
        }
        for (;;)
        {
          this.jdField_a_of_type_Agwc.a(this.jdField_b_of_type_Agsa);
          this.jdField_a_of_type_Agwc.cB(this.ba);
          this.jdField_a_of_type_Agwc.b(this.jdField_b_of_type_Agsb);
          this.jdField_a_of_type_Agwc.init();
          this.jdField_a_of_type_Agxu = this.jdField_a_of_type_Agwc.a();
          this.cYH = i;
          return true;
          this.jdField_a_of_type_Agwc = new agvx(this.jdField_a_of_type_Aguk, this.mContext);
          continue;
          this.jdField_a_of_type_Agwc = new agwh(this.jdField_a_of_type_Aguk, this.mContext);
          continue;
          this.jdField_a_of_type_Agwc = new agwn(this.jdField_a_of_type_Aguk, this.mContext);
          continue;
          this.jdField_a_of_type_Agwc = new agxa(this.jdField_a_of_type_Aguk, this.mContext);
          continue;
          this.jdField_a_of_type_Agwc = new agxi(this.jdField_a_of_type_Aguk, this.mContext);
          continue;
          this.jdField_a_of_type_Agwc = new agwu(this.jdField_a_of_type_Aguk, this.mContext);
          continue;
          this.jdField_a_of_type_Agwc = new agws(this.jdField_a_of_type_Aguk, this.mContext);
          continue;
          this.jdField_a_of_type_Agwc = new agwm(this.jdField_a_of_type_Aguk, this.mContext);
          continue;
          this.jdField_a_of_type_Agwc = new agvz(this.jdField_a_of_type_Aguk, this.mContext);
          continue;
          this.jdField_a_of_type_Agwc = new agvt(this.jdField_a_of_type_Aguk, this.mContext);
        }
      }
      this.jdField_a_of_type_Agwc.init();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 2, "initFileViewer error : model is null");
    }
    return false;
  }
  
  public void a(agsb paramagsb)
  {
    this.jdField_b_of_type_Agsb = paramagsb;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = amm();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.jdField_a_of_type_Agxu.ca(), paramLayoutParams);
    }
    return bool;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
    }
    this.ba = paramBundle;
    if (this.jdField_a_of_type_Aguk == null)
    {
      this.jdField_a_of_type_Aguk = this.jdField_a_of_type_Agqi$a.a();
      this.jdField_a_of_type_Aguk.a(this.jdField_b_of_type_Agsa);
      this.jdField_a_of_type_Aguk.Ov(paramInt);
      this.jdField_a_of_type_Aguk.cB(paramBundle);
    }
    boolean bool2 = amm();
    boolean bool1;
    if ((this.jdField_a_of_type_Agxu == null) || (this.jdField_a_of_type_Agwc == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 2, "create file view error");
      }
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramViewGroup == null);
      bool1 = bool2;
    } while (paramLayoutParams == null);
    paramViewGroup.removeAllViews();
    paramViewGroup.addView(this.jdField_a_of_type_Agxu.ca(), paramLayoutParams);
    return bool2;
  }
  
  public boolean ami()
  {
    int i = this.jdField_a_of_type_Aguk.getFileType();
    return (i == 3) || (i == 9) || (i == 7) || (i == 10) || (i == 6);
  }
  
  public boolean amj()
  {
    if (this.jdField_a_of_type_Agwc != null) {
      return this.jdField_a_of_type_Agwc.amj();
    }
    return false;
  }
  
  public boolean amk()
  {
    if (this.jdField_a_of_type_Agwc != null) {
      return this.jdField_a_of_type_Agwc.amk();
    }
    return false;
  }
  
  public boolean aml()
  {
    return (this.jdField_a_of_type_Aguk != null) && (this.jdField_a_of_type_Aguk.bM() != 0);
  }
  
  public boolean amn()
  {
    Object localObject = null;
    ArrayList[] arrayOfArrayList = c();
    ArrayList localArrayList;
    if (arrayOfArrayList != null) {
      if (arrayOfArrayList.length == 1) {
        localArrayList = arrayOfArrayList[0];
      }
    }
    for (;;)
    {
      if (((localArrayList != null) && (!localArrayList.isEmpty())) || ((localObject != null) && (!localObject.isEmpty())))
      {
        return true;
        if (arrayOfArrayList.length == 2)
        {
          localArrayList = arrayOfArrayList[0];
          localObject = arrayOfArrayList[1];
        }
      }
      else
      {
        return false;
      }
      localArrayList = null;
    }
  }
  
  public aebf b()
  {
    if (this.jdField_a_of_type_Aguk != null) {
      return this.jdField_a_of_type_Aguk.b();
    }
    return null;
  }
  
  public void c(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Agwc != null) {
      this.jdField_a_of_type_Agwc.c(paramConfiguration);
    }
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] c()
  {
    if ((this.jdField_a_of_type_Aguk != null) && (this.jdField_a_of_type_Aguk.amv())) {
      return this.jdField_a_of_type_Aguk.a();
    }
    return null;
  }
  
  public void cqt()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserManager<FileAssistant><FileAssistant>", 1, "FileBrowserManager Finish");
    }
    if (this.jdField_a_of_type_Aguk != null)
    {
      this.jdField_a_of_type_Aguk.cqt();
      this.jdField_a_of_type_Aguk = null;
    }
    if (this.jdField_a_of_type_Agwc != null)
    {
      this.jdField_a_of_type_Agwc.cqt();
      this.jdField_a_of_type_Agwc = null;
    }
    if (this.jdField_a_of_type_Agxu != null) {
      this.jdField_a_of_type_Agxu = null;
    }
  }
  
  public void dji()
  {
    List localList = null;
    ShareActionSheetV2.Param localParam;
    if (this.d == null)
    {
      localParam = new ShareActionSheetV2.Param();
      localParam.context = this.mContext;
      this.d = ShareActionSheetFactory.create(localParam);
    }
    this.d.setRowVisibility(0, 0, 0);
    this.d.setOnDismissListener(new agqj(this));
    Object localObject = c();
    if (localObject != null) {
      if (localObject.length == 1) {
        localParam = localObject[0];
      }
    }
    for (;;)
    {
      if (((localParam != null) && (!localParam.isEmpty())) || ((localList != null) && (!localList.isEmpty())))
      {
        a((ArrayList[])localObject);
        localObject = vE() + "(" + ahbj.g(getFileSize()) + ")";
        this.d.setActionSheetTitle((CharSequence)localObject);
        localObject = this.jdField_a_of_type_Aguk.f();
        String str = this.jdField_a_of_type_Aguk.ax();
        this.mContext.getIntent().putExtra("big_brother_source_key", str);
        if ((localObject != null) && (!TextUtils.isEmpty(str))) {
          break label271;
        }
        this.d.setRowVisibility(8, 0, 0);
      }
      for (;;)
      {
        this.d.setActionSheetItems(localParam, localList);
        this.d.setItemClickListenerV2(new agqk(this));
        this.d.show();
        return;
        if (localObject.length != 2) {
          break label284;
        }
        localParam = localObject[0];
        localList = localObject[1];
        break;
        label271:
        this.d.setIntentForStartForwardRecentActivity((Intent)localObject);
      }
      label284:
      localParam = null;
    }
  }
  
  public void djj()
  {
    List localList = null;
    if ((this.jdField_a_of_type_Agwc != null) && ((this.jdField_a_of_type_Agwc instanceof agxa))) {
      this.jdField_a_of_type_Agwc.dka();
    }
    while (this.d == null) {
      return;
    }
    ArrayList[] arrayOfArrayList = c();
    ArrayList localArrayList;
    if (arrayOfArrayList != null) {
      if (arrayOfArrayList.length == 1) {
        localArrayList = arrayOfArrayList[0];
      }
    }
    for (;;)
    {
      if (((localArrayList != null) && (!localArrayList.isEmpty())) || ((localList != null) && (!localList.isEmpty()))) {
        this.d.setActionSheetItems(localArrayList, localList);
      }
      if (!this.d.isShowing()) {
        break;
      }
      this.d.refresh();
      return;
      if (arrayOfArrayList.length == 2)
      {
        localArrayList = arrayOfArrayList[0];
        localList = arrayOfArrayList[1];
      }
      else
      {
        localArrayList = null;
      }
    }
  }
  
  public void djk()
  {
    if ((this.jdField_a_of_type_Aguk != null) && ((this.jdField_a_of_type_Agxu instanceof SimpleFileViewer))) {
      ((SimpleFileViewer)this.jdField_a_of_type_Agxu).Jw(this.jdField_a_of_type_Aguk.getFileName());
    }
  }
  
  public void doBeforeFinish()
  {
    if (this.jdField_a_of_type_Aguk != null) {
      this.jdField_a_of_type_Aguk.doBeforeFinish();
    }
    if (this.jdField_a_of_type_Agwc != null) {
      this.jdField_a_of_type_Agwc.doBeforeFinish();
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Aguk != null) {
      this.jdField_a_of_type_Aguk.doOnPause();
    }
    if (this.jdField_a_of_type_Agwc != null) {
      this.jdField_a_of_type_Agwc.doOnPause();
    }
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_Aguk != null) {
      this.jdField_a_of_type_Aguk.doOnResume();
    }
    if (this.jdField_a_of_type_Agwc != null) {
      this.jdField_a_of_type_Agwc.doOnResume();
    }
  }
  
  public long getFileSize()
  {
    if (this.jdField_a_of_type_Aguk != null) {
      return this.jdField_a_of_type_Aguk.getFileSize();
    }
    return 0L;
  }
  
  public int getFileType()
  {
    if (this.jdField_a_of_type_Aguk != null) {
      return this.jdField_a_of_type_Aguk.getFileType();
    }
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Agwc != null) {
      this.jdField_a_of_type_Agwc.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public String vE()
  {
    if (this.jdField_a_of_type_Agwc != null) {
      return this.jdField_a_of_type_Agwc.vE();
    }
    return "";
  }
  
  public static abstract interface a
  {
    public abstract aguk a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqi
 * JD-Core Version:    0.7.0.1
 */