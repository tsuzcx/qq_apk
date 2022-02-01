import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class atxf
{
  private atxf.a jdField_a_of_type_Atxf$a;
  private atzy jdField_a_of_type_Atzy;
  private aubi jdField_a_of_type_Aubi;
  private aucp jdField_a_of_type_Aucp;
  private agsa b;
  protected atyr b;
  private int cYH = 0;
  private Activity mContext;
  
  public atxf(Activity paramActivity, agsa paramagsa, atxf.a parama)
  {
    this.mContext = paramActivity;
    this.jdField_b_of_type_Agsa = paramagsa;
    this.jdField_a_of_type_Atxf$a = parama;
  }
  
  private boolean amm()
  {
    if (this.jdField_a_of_type_Atzy != null)
    {
      int i = this.jdField_a_of_type_Atzy.bE();
      if (this.cYH != i)
      {
        if (this.jdField_a_of_type_Aubi != null) {
          this.jdField_a_of_type_Aubi.cqt();
        }
        switch (i)
        {
        default: 
          this.jdField_a_of_type_Aubi = new auby(this.jdField_a_of_type_Atzy, this.mContext);
          this.jdField_a_of_type_Aubi.a(this.jdField_b_of_type_Agsa);
          this.jdField_a_of_type_Aubi.b(this.jdField_b_of_type_Atyr);
          this.jdField_a_of_type_Aubi.init();
          this.jdField_a_of_type_Aucp = this.jdField_a_of_type_Aubi.a();
          this.cYH = i;
        }
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_Aubi = new aubg(this.jdField_a_of_type_Atzy, this.mContext);
        break;
        this.jdField_a_of_type_Aubi = new aubn(this.jdField_a_of_type_Atzy, this.mContext);
        break;
        this.jdField_a_of_type_Aubi = new aubs(this.jdField_a_of_type_Atzy, this.mContext);
        break;
        this.jdField_a_of_type_Aubi = new aucd(this.jdField_a_of_type_Atzy, this.mContext);
        break;
        this.jdField_a_of_type_Aubi = new aucj(this.jdField_a_of_type_Atzy, this.mContext);
        break;
        this.jdField_a_of_type_Aubi = new aubx(this.jdField_a_of_type_Atzy, this.mContext);
        break;
        this.jdField_a_of_type_Aubi = new aubv(this.jdField_a_of_type_Atzy, this.mContext);
        break;
        this.jdField_a_of_type_Aubi = new aubr(this.jdField_a_of_type_Atzy, this.mContext);
        break;
        this.jdField_a_of_type_Aubi.init();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager", 2, "initFileViewer error : model is null");
    }
    return false;
  }
  
  public void a(atyr paramatyr)
  {
    this.jdField_b_of_type_Atyr = paramatyr;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = amm();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.jdField_a_of_type_Aucp.ca(), paramLayoutParams);
    }
    return bool;
  }
  
  public boolean amj()
  {
    if (this.jdField_a_of_type_Aubi != null) {
      return this.jdField_a_of_type_Aubi.amj();
    }
    return false;
  }
  
  public boolean amk()
  {
    if (this.jdField_a_of_type_Aubi != null) {
      return this.jdField_a_of_type_Aubi.amk();
    }
    return false;
  }
  
  public boolean b(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_Atzy == null)
    {
      this.jdField_a_of_type_Atzy = this.jdField_a_of_type_Atxf$a.a();
      this.jdField_a_of_type_Atzy.a(this.jdField_b_of_type_Agsa);
    }
    boolean bool2 = amm();
    boolean bool1;
    if ((this.jdField_a_of_type_Aucp == null) || (this.jdField_a_of_type_Aubi == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager", 2, "create file view error");
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
    paramViewGroup.addView(this.jdField_a_of_type_Aucp.ca(), paramLayoutParams);
    return bool2;
  }
  
  public void c(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Aubi != null) {
      this.jdField_a_of_type_Aubi.c(paramConfiguration);
    }
  }
  
  public void cqt()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager Finish");
    }
    if (this.jdField_a_of_type_Aubi != null)
    {
      this.jdField_a_of_type_Aubi.cqt();
      this.jdField_a_of_type_Aubi = null;
    }
    if (this.jdField_a_of_type_Aucp != null) {
      this.jdField_a_of_type_Aucp = null;
    }
    if (this.jdField_a_of_type_Atzy != null)
    {
      this.jdField_a_of_type_Atzy.cqt();
      this.jdField_a_of_type_Atzy = null;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Atzy != null) {
      this.jdField_a_of_type_Atzy.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Atzy != null) {
      this.jdField_a_of_type_Atzy.doOnPause();
    }
    if (this.jdField_a_of_type_Aubi != null) {
      this.jdField_a_of_type_Aubi.doOnPause();
    }
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_Atzy != null) {
      this.jdField_a_of_type_Atzy.doOnResume();
    }
    if (this.jdField_a_of_type_Aubi != null) {
      this.jdField_a_of_type_Aubi.doOnResume();
    }
  }
  
  public ArrayList<aufa.b> eq()
  {
    if (this.jdField_a_of_type_Atzy != null) {
      return this.jdField_a_of_type_Atzy.er();
    }
    return new ArrayList();
  }
  
  public long getFileSize()
  {
    if (this.jdField_a_of_type_Atzy != null) {
      return this.jdField_a_of_type_Atzy.getFileSize();
    }
    return 0L;
  }
  
  public String getLocalFilePath()
  {
    if (this.jdField_a_of_type_Atzy != null) {
      return this.jdField_a_of_type_Atzy.getFilePath();
    }
    return "";
  }
  
  public String vE()
  {
    if (this.jdField_a_of_type_Aubi != null) {
      return this.jdField_a_of_type_Aubi.vE();
    }
    return "";
  }
  
  public static abstract interface a
  {
    public abstract atzy a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxf
 * JD-Core Version:    0.7.0.1
 */