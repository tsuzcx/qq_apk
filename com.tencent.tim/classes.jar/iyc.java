import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class iyc
{
  private volatile boolean Wd = true;
  private boolean We;
  private iyc.a jdField_a_of_type_Iyc$a = new iyc.a(Looper.getMainLooper());
  private volatile iyc.b jdField_a_of_type_Iyc$b;
  private ViewGroup aD;
  private final int avF = 1000;
  private final int avG = 256;
  private volatile iyc.b b;
  private VideoAppInterface d;
  private TextView mB;
  
  public iyc(VideoAppInterface paramVideoAppInterface)
  {
    this.d = paramVideoAppInterface;
  }
  
  private void a(ViewGroup paramViewGroup, TextView paramTextView)
  {
    this.aD = paramViewGroup;
    this.mB = paramTextView;
    this.Wd = true;
  }
  
  private void asl()
  {
    if ((this.Wd) && (this.jdField_a_of_type_Iyc$b != null) && (this.jdField_a_of_type_Iyc$b.isLive())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_Iyc$b = null;
      }
      String str = hk();
      jX(str);
      if ((this.jdField_a_of_type_Iyc$a != null) && (this.Wd) && (!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_Iyc$a.hasMessages(256))) {
        this.jdField_a_of_type_Iyc$a.sendEmptyMessageDelayed(256, 1000L);
      }
      return;
    }
  }
  
  private String hk()
  {
    if ((this.jdField_a_of_type_Iyc$b != null) && (this.jdField_a_of_type_Iyc$b.isLive())) {
      return this.jdField_a_of_type_Iyc$b.Rl;
    }
    if (this.b != null) {
      return this.b.Rl;
    }
    return "";
  }
  
  private void jX(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.mB.setText(paramString);
      this.aD.setVisibility(0);
      return;
    }
    this.aD.setVisibility(8);
  }
  
  public void a(iyc.b paramb)
  {
    this.jdField_a_of_type_Iyc$b = paramb;
    if (paramb.Wf) {
      this.b = paramb;
    }
    if (this.jdField_a_of_type_Iyc$a != null)
    {
      this.jdField_a_of_type_Iyc$a.removeMessages(256);
      this.jdField_a_of_type_Iyc$a.sendEmptyMessage(256);
    }
  }
  
  public String aS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return this.d.getApp().getString(2131690631);
    case 1: 
      return this.d.getApp().getString(2131690619);
    case 2: 
      return this.d.getApp().getString(2131690632);
    case 3: 
      return this.d.getApp().getString(2131690620);
    case 4: 
      return this.d.getApp().getString(2131697645);
    case 5: 
      return this.d.getApp().getString(2131690621);
    case 6: 
      return this.d.getApp().getString(2131690625);
    case 7: 
      return this.d.getApp().getString(2131690622);
    case 8: 
      return this.d.getApp().getString(2131690624);
    }
    return this.d.getApp().getString(2131690623);
  }
  
  public void attach()
  {
    if (AudioHelper.aCz()) {
      QLog.w("DeviceTipsController", 1, "attach, isAttach[" + this.We + "]");
    }
    if (this.We) {
      detach();
    }
    if (!this.We) {
      ((ikz)this.d.a(11)).a(this);
    }
    this.We = true;
  }
  
  public void bM(View paramView)
  {
    a((ViewGroup)paramView.findViewById(2131374240), (TextView)paramView.findViewById(2131373970));
  }
  
  public void destroy()
  {
    if (this.We) {
      detach();
    }
    this.jdField_a_of_type_Iyc$b = null;
    this.Wd = false;
    this.b = null;
    if (this.jdField_a_of_type_Iyc$a != null) {
      this.jdField_a_of_type_Iyc$a.removeMessages(256);
    }
  }
  
  public void detach()
  {
    if (AudioHelper.aCz()) {
      QLog.w("DeviceTipsController", 1, "detach, isAttach[" + this.We + "]");
    }
    if (this.We) {
      ((ikz)this.d.a(11)).a(null);
    }
    this.We = false;
  }
  
  public void f(int paramInt, long paramLong, boolean paramBoolean)
  {
    iyc.b localb = new iyc.b();
    localb.or = System.currentTimeMillis();
    localb.Wf = paramBoolean;
    localb.os = paramLong;
    localb.Rl = aS(paramInt);
    a(localb);
  }
  
  public void jx(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Iyc$b == this.b) {
        this.jdField_a_of_type_Iyc$b = null;
      }
      this.b = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Iyc$a != null)
      {
        this.jdField_a_of_type_Iyc$a.removeMessages(256);
        this.jdField_a_of_type_Iyc$a.sendEmptyMessage(256);
      }
      return;
      this.jdField_a_of_type_Iyc$b = null;
    }
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    attach();
  }
  
  public void setRotation(float paramFloat)
  {
    if (this.aD == null) {}
  }
  
  public void z(int paramInt, long paramLong)
  {
    f(paramInt, paramLong, false);
  }
  
  class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      iyc.b(iyc.this);
    }
  }
  
  public static class b
  {
    public String Rl = "";
    public boolean Wf;
    public long or;
    public long os;
    
    public boolean isLive()
    {
      long l = System.currentTimeMillis();
      return (this.Wf) || (this.or + this.os > l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyc
 * JD-Core Version:    0.7.0.1
 */