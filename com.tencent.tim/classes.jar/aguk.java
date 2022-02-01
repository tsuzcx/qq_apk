import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.a;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.3;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.4;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public abstract class aguk
{
  private adjn a;
  protected agss a;
  protected agsu a;
  protected agsv a;
  public aguk.c a;
  public aguk.d a;
  protected aguk.e a;
  protected FilePreviewActivity.a b;
  protected String bJl;
  protected Bundle ba;
  protected agku c;
  protected int cYK;
  public agsa e;
  protected HashMap<String, ArrayList<ShareActionSheetBuilder.ActionSheetItem>> kO;
  public Activity mContext;
  protected int mCurrentIndex;
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> wJ;
  
  public aguk(Activity paramActivity)
  {
    this.mContext = paramActivity;
    this.cYK = 0;
  }
  
  public int EJ()
  {
    return this.cYK;
  }
  
  public void F(String paramString, Bundle paramBundle) {}
  
  public void Ov(int paramInt)
  {
    this.cYK = paramInt;
  }
  
  protected void Ow(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 118: 
      anot.a(null, "dc00898", "", "", "0X800ADBC", "0X800ADBC", 0, 0, "", "", "", "");
      return;
    case 52: 
      anot.a(null, "dc00898", "", "", "0X800ADBD", "0X800ADBD", 0, 0, "", "", "", "");
      return;
    case 55: 
      anot.a(null, "dc00898", "", "", "0X800ADBE", "0X800ADBE", 0, 0, "", "", "", "");
      return;
    }
    anot.a(null, "dc00898", "", "", "0X800ADBF", "0X800ADBF", 0, 0, "", "", "", "");
  }
  
  public abstract long V();
  
  public abstract agss a();
  
  public abstract agsu a();
  
  public abstract agsv a();
  
  public agsw a()
  {
    return null;
  }
  
  public abstract TeamWorkFileImportInfo a();
  
  public abstract void a(int paramInt, aguk.a parama);
  
  public void a(agsa paramagsa)
  {
    this.e = paramagsa;
  }
  
  public abstract void a(aguk.b paramb);
  
  public void a(aguk.c paramc)
  {
    this.jdField_a_of_type_Aguk$c = paramc;
  }
  
  public void a(aguk.d paramd)
  {
    this.jdField_a_of_type_Aguk$d = paramd;
  }
  
  public void a(aguk.e parame)
  {
    this.jdField_a_of_type_Aguk$e = parame;
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem) {}
  
  public boolean a(aguk.b paramb)
  {
    if (paramb != null) {
      paramb.djC();
    }
    return false;
  }
  
  public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a();
  
  public abstract String aA();
  
  public abstract void aA(int paramInt);
  
  public abstract String aB();
  
  public abstract String aC();
  
  public abstract void aH(int paramInt);
  
  public abstract void aI(int paramInt);
  
  public boolean amt()
  {
    return false;
  }
  
  public boolean amv()
  {
    return this.cYK != 12;
  }
  
  public abstract void at(boolean paramBoolean);
  
  public String ax()
  {
    return "";
  }
  
  public abstract void ax(int paramInt);
  
  public abstract String ay();
  
  public String az()
  {
    return "";
  }
  
  public aebf b()
  {
    return new agsm();
  }
  
  public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b();
  
  public int bE()
  {
    int i = 3;
    int j = getFileType();
    if ((bG() == 3) && (ahav.isLocalFile(getFilePath())) && (bF() != 16))
    {
      switch (j)
      {
      case 3: 
      default: 
        i = 1;
      case 5: 
        return i;
      case 1: 
        return 4;
      case 2: 
        return 2;
      case 0: 
        return 6;
      }
      if (cm()) {
        return 5;
      }
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "getCreateFileType error : this is a local file, but is invalid, may be can not find file path");
    }
    return 0;
  }
  
  public abstract int bF();
  
  public abstract int bG();
  
  public abstract int bH();
  
  public abstract int bI();
  
  public abstract int bK();
  
  public abstract int bL();
  
  public int bM()
  {
    return 0;
  }
  
  public void cB(Bundle paramBundle)
  {
    this.ba = paramBundle;
  }
  
  public abstract boolean cg();
  
  public abstract boolean ch();
  
  public abstract boolean ci();
  
  public abstract boolean cj();
  
  public abstract boolean cl();
  
  public abstract boolean cm();
  
  public abstract boolean cn();
  
  public abstract boolean co();
  
  public void cqt()
  {
    removeObserver();
    if (this.jdField_a_of_type_Aguk$d != null) {
      this.jdField_a_of_type_Aguk$d = null;
    }
    if (this.jdField_a_of_type_Aguk$c != null) {
      this.jdField_a_of_type_Aguk$c = null;
    }
    if (this.jdField_a_of_type_Aguk$e != null) {
      this.jdField_a_of_type_Aguk$e = null;
    }
    djA();
  }
  
  protected void djA()
  {
    if (this.jdField_a_of_type_Adjn == null) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.4(this));
  }
  
  protected void djz()
  {
    if (this.jdField_a_of_type_Adjn != null) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.3(this));
  }
  
  public void doBeforeFinish() {}
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Aguk$d != null) {
      this.jdField_a_of_type_Aguk$d = null;
    }
    if (this.jdField_a_of_type_Aguk$c != null) {
      this.jdField_a_of_type_Aguk$c = null;
    }
    if (this.jdField_a_of_type_Aguk$e != null) {
      this.jdField_a_of_type_Aguk$e = null;
    }
  }
  
  public void doOnResume()
  {
    ix();
    djz();
  }
  
  public Intent f()
  {
    return null;
  }
  
  public String getCurrentAccountUin()
  {
    return "";
  }
  
  public int getCurrentIndex()
  {
    if (this.mCurrentIndex < 0) {
      return 0;
    }
    return this.mCurrentIndex;
  }
  
  public abstract String getFileName();
  
  public abstract String getFilePath();
  
  public abstract long getFileSize();
  
  public abstract int getFileType();
  
  public int getTitleBarHeight()
  {
    if (this.e != null) {
      return this.e.bD();
    }
    return 0;
  }
  
  public abstract long getUin();
  
  protected abstract void iA();
  
  public abstract void iB();
  
  public abstract void iC();
  
  public abstract void iD();
  
  public abstract boolean isFromProcessingForward2c2cOrDiscItem();
  
  protected abstract void ix();
  
  public abstract float k();
  
  public void kL(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    if (paramList == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (this.kO == null) {
          this.kO = new HashMap();
        }
        localObject = az();
      } while (!aqhq.fileExistsAndNotEmpty((String)localObject));
      if (!this.kO.containsKey(localObject)) {
        break;
      }
      localObject = (ArrayList)this.kO.get(localObject);
    } while ((localObject == null) || (((ArrayList)localObject).isEmpty()));
    paramList.addAll((Collection)localObject);
    return;
    ahbr.a(this.mContext, (String)localObject, new agul(this, (String)localObject));
  }
  
  public void kM(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    if ((this.wJ != null) && (!this.wJ.isEmpty())) {
      paramList.addAll(this.wJ);
    }
    this.wJ = null;
  }
  
  public abstract void l(int paramInt, String paramString);
  
  protected abstract void removeObserver();
  
  public abstract List<aguk.a> u();
  
  public String vM()
  {
    return null;
  }
  
  public String vN()
  {
    return "";
  }
  
  public String vO()
  {
    return "";
  }
  
  public String vP()
  {
    return "";
  }
  
  public String ve()
  {
    return null;
  }
  
  public static abstract interface a
  {
    public abstract boolean S(String paramString);
    
    public abstract void aA(String paramString);
    
    public abstract void aB(String paramString);
    
    public abstract String av();
    
    public abstract String aw();
    
    public abstract URL c();
    
    public abstract boolean ca();
    
    public abstract int getImageType();
    
    public abstract int getOrientation();
    
    public abstract boolean isLoading();
    
    public abstract void setState(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void djB();
    
    public abstract void djC();
    
    public abstract void djD();
    
    public abstract void fO(String paramString1, String paramString2);
  }
  
  public static abstract interface c
  {
    public abstract void fP(String paramString1, String paramString2);
  }
  
  public static abstract interface d
  {
    public abstract void aO(float paramFloat);
    
    public abstract void djE();
    
    public abstract void djF();
    
    public abstract void djG();
    
    public abstract void djH();
  }
  
  public static abstract interface e
  {
    public abstract void a(List<agxi.a> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort);
    
    public abstract void fQ(String paramString1, String paramString2);
    
    public abstract void jM(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aguk
 * JD-Core Version:    0.7.0.1
 */