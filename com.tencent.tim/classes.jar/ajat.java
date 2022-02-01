import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.mediafocus.MediaFocusController;
import com.tencent.mobileqq.mediafocus.MediaFocusController.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ajat
  implements MediaFocusController.a
{
  private final ajat.a jdField_a_of_type_Ajat$a = new ajat.a();
  private MediaFocusController jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController;
  private final Object ef = new Object();
  private final HashMap<String, ajat.c> lr = new HashMap();
  private final HashMap<String, Integer> ls = new HashMap();
  
  private ajat.c a(String paramString)
  {
    return (ajat.c)this.lr.get(paramString);
  }
  
  public static final ajat a()
  {
    return ajat.b.b();
  }
  
  private String a(ajat.c paramc)
  {
    if (paramc == null) {
      return new String(toString());
    }
    return new String(toString() + paramc.toString());
  }
  
  private void a(ajat.c paramc)
  {
    String str;
    synchronized (this.ef)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null) {
        this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = new MediaFocusController(this);
      }
      str = a(paramc);
      if (this.ls.containsKey(str))
      {
        int i = ((Integer)this.ls.get(str)).intValue();
        this.ls.put(str, Integer.valueOf(i + 1));
        if (!this.lr.containsKey(str)) {}
      }
      else
      {
        this.ls.put(str, Integer.valueOf(1));
      }
    }
    this.lr.put(str, paramc);
  }
  
  private boolean a(ajat.c paramc, boolean paramBoolean)
  {
    boolean bool = true;
    label130:
    label145:
    for (;;)
    {
      synchronized (this.ef)
      {
        paramc = a(paramc);
        if (!paramBoolean)
        {
          this.ls.remove(paramc);
          this.lr.remove(paramc);
          return true;
        }
        if (!this.ls.containsKey(paramc)) {
          break label130;
        }
        int i = ((Integer)this.ls.get(paramc)).intValue();
        if (i > 1)
        {
          this.ls.put(paramc, Integer.valueOf(i - 1));
          paramBoolean = false;
          break label145;
          return paramBoolean;
        }
      }
      this.ls.remove(paramc);
      this.lr.remove(paramc);
      paramBoolean = true;
      break label145;
      this.lr.remove(paramc);
      paramBoolean = bool;
    }
  }
  
  public int a(ajat.c paramc)
  {
    if (QLog.isColorLevel()) {
      if (paramc != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramc.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocusForce! listener:", str });
      if ((!a(paramc, false)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.dv(a(paramc));
    }
    return 1;
  }
  
  public int abandonMediaFocus(ajat.c paramc)
  {
    if (QLog.isColorLevel()) {
      if (paramc != null) {
        break label61;
      }
    }
    label61:
    for (String str = "null";; str = paramc.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "abandonMediaFocus! listener:", str });
      if ((!a(paramc, true)) || (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController == null)) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.dv(a(paramc));
    }
    return 1;
  }
  
  public void apk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusManager", 2, new Object[] { "onClear map:", Integer.valueOf(this.lr.size()) });
    }
    if ((this.lr.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.destroy();
      this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController = null;
    }
  }
  
  protected boolean bf(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.be(paramString1, paramString2);
    }
    return false;
  }
  
  public void dr(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusManager", 2, new Object[] { "onDispatch focus:", Integer.valueOf(paramInt), " ,id:", paramString });
    }
    paramString = this.jdField_a_of_type_Ajat$a.getHandler().obtainMessage(paramInt, paramString);
    this.jdField_a_of_type_Ajat$a.getHandler().sendMessage(paramString);
  }
  
  public int requestMediaFocus(int paramInt, ajat.c paramc)
  {
    if ((paramInt < 1) || (paramInt > 3))
    {
      QLog.e("MediaFocusManager", 1, new Object[] { "requestMediaFocus denied, Invalid type:", Integer.valueOf(paramInt) });
      return 1;
    }
    if (QLog.isColorLevel()) {
      if (paramc != null) {
        break label97;
      }
    }
    label97:
    for (String str = "null";; str = paramc.toString())
    {
      QLog.d("MediaFocusManager", 2, new Object[] { "requestMediaFocus focusType:", Integer.valueOf(paramInt), " ,listener:", str });
      a(paramc);
      return this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusController.r(paramInt, a(paramc));
    }
  }
  
  class a
  {
    private final Handler mHandler;
    
    a()
    {
      Looper localLooper2 = Looper.myLooper();
      Looper localLooper1 = localLooper2;
      if (localLooper2 == null) {
        localLooper1 = Looper.getMainLooper();
      }
      if (localLooper1 != null)
      {
        this.mHandler = new ajau(this, localLooper1, ajat.this);
        return;
      }
      this.mHandler = null;
    }
    
    Handler getHandler()
    {
      return this.mHandler;
    }
  }
  
  static class b
  {
    private static final ajat c = new ajat();
  }
  
  public static abstract interface c
  {
    public abstract void OC(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajat
 * JD-Core Version:    0.7.0.1
 */