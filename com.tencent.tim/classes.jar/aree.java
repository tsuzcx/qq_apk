import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class aree
  implements aqdf.a
{
  public aqdf a;
  ssf a;
  ared b;
  public xzp c;
  public String cAg;
  ViewGroup cj;
  Handler mUIHandler = new aref(this, Looper.getMainLooper());
  
  public aree(String paramString)
  {
    this.jdField_a_of_type_Ssf = ((ssf)ssf.fV.get("Werewolves.apk"));
    if (this.jdField_a_of_type_Ssf == null) {
      this.jdField_a_of_type_Ssf = new ssf("2584", "Werewolves.apk");
    }
    this.cAg = paramString;
  }
  
  public void F(String paramString, byte[] paramArrayOfByte)
  {
    if (this.b == null) {
      return;
    }
    this.b.E(paramString, paramArrayOfByte);
  }
  
  public void U(ViewGroup paramViewGroup)
  {
    this.cj = paramViewGroup;
    this.cj.removeAllViews();
    this.b.a(paramViewGroup, this.jdField_a_of_type_Ssf.a);
  }
  
  public ared a()
  {
    return this.b;
  }
  
  public void a(BaseActivity paramBaseActivity, xzp paramxzp)
  {
    this.c = paramxzp;
    this.jdField_a_of_type_Ssf.c(paramBaseActivity);
    if (this.b != null)
    {
      this.b.onDestroy();
      this.b.init(this.jdField_a_of_type_Ssf.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqdf = new aqdf((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Aqdf.a(this);
      return;
      this.b = new ared(this, this.jdField_a_of_type_Ssf.mClassLoader);
    }
  }
  
  public void a(xzp paramxzp)
  {
    if (this.c != paramxzp) {}
    do
    {
      return;
      if (this.b != null) {
        this.b.ehA();
      }
      if (this.cj != null)
      {
        this.cj.removeAllViews();
        this.cj = null;
      }
      if (this.jdField_a_of_type_Aqdf != null) {
        this.jdField_a_of_type_Aqdf.destory();
      }
    } while (this.jdField_a_of_type_Ssf == null);
    this.jdField_a_of_type_Ssf.a = null;
  }
  
  public void cgp()
  {
    if (!this.jdField_a_of_type_Ssf.aMP)
    {
      this.jdField_a_of_type_Ssf.vc(false);
      return;
    }
    if (this.b == null) {
      this.b = new ared(this, this.jdField_a_of_type_Ssf.mClassLoader);
    }
    Message localMessage = this.mUIHandler.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public boolean isLoaded()
  {
    return this.jdField_a_of_type_Ssf.aMP;
  }
  
  public boolean isReady()
  {
    if (this.b == null) {}
    while ((this.b != null) && (this.b.isReady())) {
      return true;
    }
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.b != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.b.C(paramString, paramBitmap);
    }
  }
  
  public void onDestroy()
  {
    if (this.b != null) {
      this.b.onDestroy();
    }
    if (this.cj != null)
    {
      this.cj.removeAllViews();
      this.cj = null;
    }
    this.c = null;
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    if (this.jdField_a_of_type_Ssf != null) {
      this.jdField_a_of_type_Ssf.clear();
    }
  }
  
  public String qn(String paramString)
  {
    if (this.b != null) {
      return this.b.qn(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aree
 * JD-Core Version:    0.7.0.1
 */