import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class iwq
  implements iwt
{
  final String TAG = "AvTipsView_" + AudioHelper.hG();
  iwq.b jdField_a_of_type_Iwq$b;
  iwq.c jdField_a_of_type_Iwq$c;
  int auW = 0;
  int auX = 0;
  LinearLayout cY;
  View hO;
  VideoAppInterface mApp;
  ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new iwr(this);
  boolean zw = false;
  
  static void a(TextView paramTextView, iwq.d paramd)
  {
    paramTextView.setTextSize(paramd.avc);
    paramTextView.setTextColor(paramd.textColor);
    paramTextView.setText(paramd.b);
    paramTextView.setVisibility(0);
    iwq.d.b(paramTextView, paramd.avd, paramd.ave);
  }
  
  void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.height = -2;
    paramLayoutParams.topMargin = (this.auX + (int)jll.dp2px(this.cY.getContext(), 6.0F));
    paramLayoutParams.addRule(14, -1);
    paramLayoutParams.addRule(13, 0);
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, ViewGroup paramViewGroup)
  {
    this.hO = paramViewGroup.findViewById(2131374241);
    this.cY = ((LinearLayout)paramViewGroup.findViewById(2131374238));
    this.mApp = paramVideoAppInterface;
    this.jdField_a_of_type_Iwq$b = new iwq.b(this.cY);
    this.jdField_a_of_type_Iwq$c = new iwq.c(this.cY);
    attach();
  }
  
  public void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_Iwq$c != null) && (this.jdField_a_of_type_Iwq$c.bf != null))
    {
      this.jdField_a_of_type_Iwq$c.bf.setOnClickListener(paramOnClickListener);
      if (paramBoolean) {
        jlg.j(this.jdField_a_of_type_Iwq$c.bf, 2130842903, 2131166227);
      }
      paramOnClickListener = this.jdField_a_of_type_Iwq$c.bf;
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (int i = 0;; i = 8)
    {
      paramOnClickListener.setVisibility(i);
      return;
    }
  }
  
  public void arB()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "RemoveMainTipsView");
    }
    if (this.jdField_a_of_type_Iwq$b != null) {
      this.jdField_a_of_type_Iwq$b.hide();
    }
  }
  
  public void arC()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "RemoveSubTipView");
    }
    if (this.jdField_a_of_type_Iwq$c != null) {
      this.jdField_a_of_type_Iwq$c.hide();
    }
  }
  
  public void arD()
  {
    if (this.jdField_a_of_type_Iwq$b != null) {
      this.jdField_a_of_type_Iwq$b.lX(4);
    }
    if (this.jdField_a_of_type_Iwq$c != null) {
      this.jdField_a_of_type_Iwq$c.lX(4);
    }
  }
  
  public void arE()
  {
    if (this.jdField_a_of_type_Iwq$b != null) {
      this.jdField_a_of_type_Iwq$b.lX(0);
    }
    if (this.jdField_a_of_type_Iwq$c != null) {
      this.jdField_a_of_type_Iwq$c.lX(0);
    }
  }
  
  void attach()
  {
    String str;
    StringBuilder localStringBuilder;
    if (AudioHelper.aCz())
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder().append("attach, isAttach[").append(this.zw).append("], titleBar[");
      if (this.hO == null) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.zw) {
        detach();
      }
      if (!this.zw) {
        ((ikz)this.mApp.a(11)).a(this);
      }
      this.zw = true;
      if (this.hO != null) {
        this.hO.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
      }
      jk(true);
      return;
    }
  }
  
  public void b(long paramLong, float paramFloat)
  {
    if (this.cY == null) {}
    float f;
    do
    {
      return;
      f = this.cY.getRotation();
    } while (f == paramFloat);
    QLog.w(this.TAG, 1, "setRotation, rotation[" + f + "->" + paramFloat + "], seq[" + paramLong + "]");
    this.cY.setRotation(paramFloat);
    jk(true);
  }
  
  void b(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (float f = this.cY.getRotation();; f = 0.0F)
    {
      if (f % 180.0F == 0.0F)
      {
        paramLayoutParams.height = -2;
        paramLayoutParams.topMargin = ((int)jll.dp2px(this.cY.getContext(), 188.0F));
        paramLayoutParams.addRule(14, -1);
        paramLayoutParams.addRule(13, 0);
        return;
      }
      paramLayoutParams.height = (jll.getScreenWidth(this.cY.getContext()) * 23 / 25);
      paramLayoutParams.topMargin = 0;
      paramLayoutParams.addRule(14, 0);
      paramLayoutParams.addRule(13, -1);
      return;
    }
  }
  
  void c(RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.height = -2;
    paramLayoutParams.topMargin = (this.auX + (int)jll.dp2px(this.cY.getContext(), 6.0F));
    paramLayoutParams.addRule(14, -1);
    paramLayoutParams.addRule(13, 0);
  }
  
  void d(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (float f = this.cY.getRotation();; f = 0.0F)
    {
      if (f % 180.0F == 0.0F)
      {
        paramLayoutParams.height = -2;
        paramLayoutParams.topMargin = ((int)jll.dp2px(this.cY.getContext(), 188.0F));
        paramLayoutParams.addRule(14, -1);
        paramLayoutParams.addRule(13, 0);
        return;
      }
      paramLayoutParams.height = (jll.getScreenWidth(this.cY.getContext()) * 23 / 25);
      paramLayoutParams.topMargin = 0;
      paramLayoutParams.addRule(14, 0);
      paramLayoutParams.addRule(13, -1);
      return;
    }
  }
  
  void detach()
  {
    String str;
    StringBuilder localStringBuilder;
    if (AudioHelper.aCz())
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder().append("detach, isAttach[").append(this.zw).append("], qav_activity_root[");
      if (this.hO == null) {
        break label123;
      }
    }
    label123:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.zw) {
        ((ikz)this.mApp.a(11)).a(null);
      }
      this.zw = false;
      if (this.hO != null)
      {
        if (Build.VERSION.SDK_INT < 16) {
          break;
        }
        this.hO.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
      }
      return;
    }
    this.hO.getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
  }
  
  public boolean f(iww paramiww)
  {
    if (this.jdField_a_of_type_Iwq$b == null) {
      return false;
    }
    paramiww = iwq.d.a(this.jdField_a_of_type_Iwq$b.a(), paramiww, this.jdField_a_of_type_Iwq$b);
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "ShowMainTipsView, tipsInfo[" + paramiww.b + "]");
    }
    return this.jdField_a_of_type_Iwq$b.a(paramiww);
  }
  
  public boolean g(iww paramiww)
  {
    if (this.jdField_a_of_type_Iwq$c == null) {
      return false;
    }
    paramiww = iwq.d.a(this.jdField_a_of_type_Iwq$c.a(), paramiww, this.jdField_a_of_type_Iwq$c);
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "ShowSubTipsView, tipsInfo[" + paramiww.b + "]");
    }
    return this.jdField_a_of_type_Iwq$c.a(paramiww);
  }
  
  public void i(VideoAppInterface paramVideoAppInterface)
  {
    if (this.zw) {
      detach();
    }
    ((ikz)this.mApp.a(11)).anE();
    this.hO = null;
    this.cY = null;
  }
  
  public void j(VideoAppInterface paramVideoAppInterface) {}
  
  void jk(boolean paramBoolean)
  {
    int i = 0;
    if (this.hO == null) {}
    int k;
    do
    {
      do
      {
        return;
        j = this.hO.getWidth();
        k = this.hO.getHeight();
      } while ((this.auW == j) && (this.auX == k) && (!paramBoolean));
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("adjustPos, w[").append(this.auW).append("->").append(j).append("], h[").append(this.auX).append("->").append(k).append("], force[").append(paramBoolean).append("], tips_layout[");
      if (this.cY == null) {
        break;
      }
      paramBoolean = true;
      QLog.w((String)localObject, 1, paramBoolean + "]");
    } while (this.cY == null);
    this.auW = j;
    this.auX = k;
    Object localObject = this.mApp.b().b();
    int j = ((iiv)localObject).amI;
    if (j == 2)
    {
      if ((((iiv)localObject).PZ) || (((iiv)localObject).PY)) {
        break label462;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "adjustPos, sessionType[" + ((iiv)localObject).amI + "->" + i + "]");
      }
      localObject = (RelativeLayout.LayoutParams)this.cY.getLayoutParams();
      switch (i)
      {
      default: 
        this.cY.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        paramBoolean = false;
        break;
        if ((j == 4) || (j == 3)) {
          if (((iiv)localObject).jdField_if.size() > 0) {
            if ((((iiv)localObject).sX()) || (((ioa)((iiv)localObject).jdField_if.get(0)).isRender))
            {
              i = 1;
              k = ((ioa)((iiv)localObject).jdField_if.get(0)).videoSrcType;
              j = i;
              i = k;
            }
          }
        }
      case 1: 
      case 2: 
      case 3: 
      case 4: 
        for (;;)
        {
          label312:
          label376:
          if ((j == 0) || (i == 0))
          {
            i = 3;
            break;
            i = 0;
            break label376;
          }
          i = 4;
          break;
          a((RelativeLayout.LayoutParams)localObject);
          break label312;
          b((RelativeLayout.LayoutParams)localObject);
          break label312;
          c((RelativeLayout.LayoutParams)localObject);
          break label312;
          d((RelativeLayout.LayoutParams)localObject);
          break label312;
          j = 1;
        }
        label462:
        i = j;
      }
    }
  }
  
  public void k(VideoAppInterface paramVideoAppInterface)
  {
    attach();
  }
  
  public void lV(int paramInt)
  {
    if (this.jdField_a_of_type_Iwq$b != null) {
      this.jdField_a_of_type_Iwq$b.auY = paramInt;
    }
  }
  
  public void lW(int paramInt)
  {
    if ((this.jdField_a_of_type_Iwq$b != null) && (this.jdField_a_of_type_Iwq$b.y != null)) {
      this.jdField_a_of_type_Iwq$b.y.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    }
  }
  
  public boolean vQ()
  {
    if (this.jdField_a_of_type_Iwq$b == null) {
      return false;
    }
    return this.jdField_a_of_type_Iwq$b.isValid();
  }
  
  public boolean vR()
  {
    if (this.jdField_a_of_type_Iwq$c == null) {
      return false;
    }
    return this.jdField_a_of_type_Iwq$c.isValid();
  }
  
  static abstract class a
  {
    int auY = -1;
    int auZ = -552421387;
    int ava = -15550475;
    int avb = 14;
    LinearLayout cY = null;
    
    void lX(int paramInt)
    {
      if (this.cY != null) {
        this.cY.setVisibility(paramInt);
      }
    }
  }
  
  static class b
    extends iwq.a
  {
    ImageView gq;
    View hP;
    TextView mz;
    ProgressBar y;
    
    b(LinearLayout paramLinearLayout)
    {
      this.cY = paramLinearLayout;
      this.gq = ((ImageView)paramLinearLayout.findViewById(2131374236));
      this.mz = ((TextView)paramLinearLayout.findViewById(2131374233));
      this.hP = paramLinearLayout.findViewById(2131374237);
      this.y = ((ProgressBar)paramLinearLayout.findViewById(2131374239));
    }
    
    Resources a()
    {
      return this.mz.getResources();
    }
    
    boolean a(iwq.d paramd)
    {
      hide();
      if ((paramd.VI) && (paramd.br != null) && (this.gq != null))
      {
        this.gq.setImageBitmap(paramd.br);
        this.gq.setVisibility(0);
      }
      if ((paramd.VJ) && (this.y != null)) {
        this.y.setVisibility(0);
      }
      if ((paramd.VH) && (this.hP != null)) {
        this.hP.setVisibility(0);
      }
      if ((paramd.b != null) && (this.mz != null)) {
        iwq.a(this.mz, paramd);
      }
      return true;
    }
    
    void hide()
    {
      if (!isValid()) {}
      do
      {
        return;
        if (this.gq != null)
        {
          this.gq.setVisibility(8);
          this.gq.setImageBitmap(null);
        }
        if (this.mz != null) {
          this.mz.setVisibility(4);
        }
        if (this.hP != null) {
          this.hP.setVisibility(8);
        }
      } while (this.y == null);
      this.y.setVisibility(8);
    }
    
    boolean isValid()
    {
      return (this.mz != null) && (this.y != null);
    }
  }
  
  static class c
    extends iwq.a
  {
    Button bf;
    TextView mA;
    
    c(LinearLayout paramLinearLayout)
    {
      this.cY = paramLinearLayout;
      this.mA = ((TextView)paramLinearLayout.findViewById(2131374234));
      this.bf = ((Button)paramLinearLayout.findViewById(2131373952));
    }
    
    Resources a()
    {
      return this.mA.getResources();
    }
    
    boolean a(iwq.d paramd)
    {
      hide();
      if ((paramd.b != null) && (this.mA != null))
      {
        iwq.a(this.mA, paramd);
        return true;
      }
      return false;
    }
    
    void hide()
    {
      if (!isValid()) {
        return;
      }
      this.mA.setVisibility(8);
    }
    
    boolean isValid()
    {
      return this.mA != null;
    }
  }
  
  static class d
  {
    boolean VH = false;
    boolean VI = false;
    boolean VJ = false;
    int avc = -1;
    int avd = -1;
    int ave = -1;
    SpannableString b = null;
    Bitmap br = null;
    int textColor = -1;
    
    static d a(Resources paramResources, iww paramiww, iwq.a parama)
    {
      d locald = new d();
      if (!TextUtils.isEmpty(paramiww.hj())) {
        locald.b = new SpannableString(paramiww.hj());
      }
      locald.avc = parama.avb;
      locald.textColor = parama.auY;
      locald.avd = parama.auZ;
      locald.ave = parama.ava;
      switch (paramiww.lM())
      {
      }
      do
      {
        return locald;
        paramiww = (iwy)paramiww;
        if ((paramiww.getDrawable() instanceof BitmapDrawable)) {
          locald.br = ((BitmapDrawable)paramiww.getDrawable()).getBitmap();
        }
        for (;;)
        {
          switch (paramiww.lT())
          {
          default: 
            return locald;
          case 1: 
            locald.VH = true;
            return locald;
            parama = paramiww.getIconUrl();
            if (!TextUtils.isEmpty(parama)) {
              locald.br = jik.a(paramResources, parama);
            }
            break;
          }
        }
        locald.VI = true;
        return locald;
        locald.VJ = ((iwz)paramiww).vT();
        return locald;
        paramResources = (iwx)paramiww;
        if (paramResources.lQ() != -1) {
          locald.avc = paramResources.lQ();
        }
        if (paramResources.lS() != -1) {
          locald.avd = paramResources.lS();
        }
        if (paramResources.lR() != -1) {
          locald.ave = paramResources.lR();
        }
      } while (locald.b == null);
      int j = paramResources.lO();
      if (paramResources.lP() == -1) {}
      for (int i = paramiww.hj().length() + j;; i = paramResources.lP() + j)
      {
        locald.b.setSpan(new iws(paramResources), j, i, 33);
        paramResources = new ForegroundColorSpan(locald.avd);
        locald.b.setSpan(paramResources, j, i, 17);
        return locald;
      }
    }
    
    static void b(TextView paramTextView, int paramInt1, int paramInt2)
    {
      paramTextView.setTag(2131379217, Integer.valueOf(paramInt2));
      paramTextView.setTag(2131379218, Integer.valueOf(paramInt1));
      paramTextView.setMovementMethod((irw)irw.getInstance());
      paramTextView.setHighlightColor(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwq
 * JD-Core Version:    0.7.0.1
 */