import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class acxy
  extends Observable
{
  protected long Rx;
  public acyc a;
  protected acyf a;
  public FTSDatabase a;
  protected FTSDatatbase a;
  protected boolean bKl;
  protected int cAr = -1;
  protected int cAs = -1;
  protected int cAt;
  protected boolean isDestroyed;
  private boolean isSaveDBAtOnceFlag;
  public QQAppInterface mApp;
  
  public acxy(QQAppInterface paramQQAppInterface, acyc paramacyc)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Acyc = paramacyc;
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return null;
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase = paramFTSDatatbase;
    this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase = paramFTSDatabase;
    return true;
  }
  
  public boolean acV()
  {
    if (aqoe.ak(this.mApp) != 1) {}
    while (this.jdField_a_of_type_Acyf == null) {
      return false;
    }
    return this.jdField_a_of_type_Acyf.acV();
  }
  
  public boolean acW()
  {
    if (this.jdField_a_of_type_Acyf != null) {
      return this.jdField_a_of_type_Acyf.acW();
    }
    return true;
  }
  
  public boolean acX()
  {
    return true;
  }
  
  protected boolean acY()
  {
    return false;
  }
  
  public boolean acZ()
  {
    return false;
  }
  
  public void b(Observer paramObserver)
  {
    if (paramObserver != null) {
      addObserver(paramObserver);
    }
  }
  
  public void c(Observer paramObserver)
  {
    if (paramObserver != null) {
      deleteObserver(paramObserver);
    }
  }
  
  public void cOP()
  {
    if (acV()) {
      acW();
    }
  }
  
  public void cOQ()
  {
    setChanged();
    notifyObservers();
  }
  
  public void cOR()
  {
    this.jdField_a_of_type_Acyc.obtainMessage(2, this).sendToTarget();
  }
  
  public abstract void cOS();
  
  public void destroy()
  {
    this.isDestroyed = true;
    if (this.jdField_a_of_type_Acyf != null) {
      this.jdField_a_of_type_Acyf.destroy();
    }
  }
  
  protected boolean isSaveDBAtOnce()
  {
    boolean bool3 = false;
    int i;
    boolean bool1;
    if (!this.isSaveDBAtOnceFlag) {
      if (this.mApp != null)
      {
        i = this.mApp.a.Bd();
        if (i == 0)
        {
          this.isSaveDBAtOnceFlag = true;
          bool1 = false;
          label39:
          bool2 = bool1;
          if (i == 1) {
            this.isSaveDBAtOnceFlag = true;
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if ((bool2) && (acY()) && (!this.mApp.isBackground_Stop)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.sync_worker", 2, "isSaveDBAtOnce unActionLoginB atOnce:" + bool1);
        }
        return bool1;
      }
      bool1 = true;
      break label39;
      i = 0;
      break;
    }
  }
  
  public String rX()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(50);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" ").append(getClass().getSimpleName()).append(" transCount:").append(this.cAt).append(" transCost:").append(this.Rx).append(" transAvg:");
    if (this.cAt != 0) {}
    for (float f = (float)this.Rx * 1.0F / this.cAt;; f = 0.0F)
    {
      localStringBuilder2.append(f);
      this.Rx = 0L;
      this.cAt = 0;
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxy
 * JD-Core Version:    0.7.0.1
 */