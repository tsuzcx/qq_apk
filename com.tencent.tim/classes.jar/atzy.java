import android.app.Activity;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class atzy
{
  protected atyz a;
  protected atza a;
  protected atzb a;
  public atzy.c a;
  public atzy.d a;
  protected atzy.e a;
  protected FilePreviewActivity.a b;
  protected attt c;
  protected agsa e;
  public Activity mContext;
  protected int mCurrentIndex;
  protected int mEntranceType = -1;
  
  public atzy(Activity paramActivity)
  {
    this.mContext = paramActivity;
  }
  
  public abstract String Fa();
  
  public void Oy(int paramInt)
  {
    this.mEntranceType = paramInt;
  }
  
  public abstract long V();
  
  public agsw a()
  {
    return null;
  }
  
  public abstract atyz a();
  
  public abstract atza a();
  
  public abstract atzb a();
  
  public abstract TeamWorkFileImportInfo a();
  
  public abstract void a(int paramInt, atzy.a parama);
  
  public void a(agsa paramagsa)
  {
    this.e = paramagsa;
  }
  
  public abstract void a(atzy.b paramb);
  
  public void a(atzy.c paramc)
  {
    this.jdField_a_of_type_Atzy$c = paramc;
  }
  
  public void a(atzy.d paramd)
  {
    this.jdField_a_of_type_Atzy$d = paramd;
  }
  
  public void a(atzy.e parame)
  {
    this.jdField_a_of_type_Atzy$e = parame;
  }
  
  public boolean a(atzy.b paramb)
  {
    if (paramb != null) {
      paramb.djC();
    }
    return false;
  }
  
  public abstract String aA();
  
  public abstract void aA(int paramInt);
  
  public abstract String aB();
  
  public abstract String aC();
  
  public abstract void aH(int paramInt);
  
  public abstract void at(boolean paramBoolean);
  
  public abstract void ax(int paramInt);
  
  public int bE()
  {
    int i = 3;
    int j = getFileType();
    if (((bG() == 3) || (bG() == 9)) && (audx.isLocalFile(getFilePath())) && (bF() != 16))
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
      QLog.i("FileBrowserModelBase<QFileBrowser>", 2, "getCreateFileType error : this is a local file, but is invalid, may be can not find file path");
    }
    return 0;
  }
  
  public abstract int bF();
  
  public abstract int bG();
  
  public abstract int bI();
  
  public abstract int bK();
  
  public abstract int bL();
  
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
    if (this.jdField_a_of_type_Atzy$d != null) {
      this.jdField_a_of_type_Atzy$d = null;
    }
    if (this.jdField_a_of_type_Atzy$c != null) {
      this.jdField_a_of_type_Atzy$c = null;
    }
    if (this.jdField_a_of_type_Atzy$e != null) {
      this.jdField_a_of_type_Atzy$e = null;
    }
  }
  
  public abstract void djr();
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Atzy$d != null) {
      this.jdField_a_of_type_Atzy$d = null;
    }
    if (this.jdField_a_of_type_Atzy$c != null) {
      this.jdField_a_of_type_Atzy$c = null;
    }
    if (this.jdField_a_of_type_Atzy$e != null) {
      this.jdField_a_of_type_Atzy$e = null;
    }
  }
  
  public void doOnResume()
  {
    ix();
  }
  
  public abstract ArrayList<aufa.b> er();
  
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
  
  public abstract void l(int paramInt, String paramString);
  
  protected abstract void removeObserver();
  
  public abstract List<atzy.a> u();
  
  public String ve()
  {
    return null;
  }
  
  public static abstract interface a
  {
    public abstract boolean S(String paramString);
    
    public abstract void aA(String paramString);
    
    public abstract void aB(String paramString);
    
    public abstract URL c();
    
    public abstract boolean ca();
    
    public abstract int getImageType();
    
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
    public abstract void b(List<agxi.a> paramList, String paramString1, String paramString2, String paramString3, String paramString4);
    
    public abstract void fQ(String paramString1, String paramString2);
    
    public abstract void jM(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzy
 * JD-Core Version:    0.7.0.1
 */