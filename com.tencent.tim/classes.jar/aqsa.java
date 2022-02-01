import android.os.Bundle;
import android.os.Handler;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import mqq.app.AppRuntime;

public class aqsa
  implements aqro, ku.a
{
  protected aqrp a;
  private ETTextView.e b;
  protected ku b;
  private boolean cVL;
  private int ecr = 1;
  private int ecs = 1;
  private Observer h = new aqsb(this);
  private ETTextView m;
  protected AppRuntime mApp;
  protected int mFontType;
  private float mTextSize;
  private long msgId = System.currentTimeMillis();
  
  public aqsa(aqrn paramaqrn, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_b_of_type_ComEtrumpMixlayoutETTextView$e = new aqsc(this);
    this.a = paramaqrn.a();
    this.mApp = paramAppRuntime;
    this.mFontType = paramInt;
    kx.a().addObserver(this.h);
  }
  
  public void O(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureFontAdapter", 2, "downloadDone type = " + paramInt);
    }
  }
  
  public void XS(int paramInt)
  {
    this.ecr = paramInt;
  }
  
  public void a(ETTextView paramETTextView, float paramFloat, boolean paramBoolean)
  {
    this.m = paramETTextView;
    this.mTextSize = paramFloat;
    this.cVL = paramBoolean;
    this.m.setTextAnimationListener(this.jdField_b_of_type_ComEtrumpMixlayoutETTextView$e);
  }
  
  protected void a(ETTextView paramETTextView, kt paramkt, float paramFloat)
  {
    if (paramkt.mFontId == 0)
    {
      paramETTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    if (paramkt.b != null)
    {
      paramkt = paramkt.b;
      paramkt.setSize(paramFloat);
    }
    for (;;)
    {
      if ((paramETTextView.mFont == null) || (!paramkt.equals(paramETTextView.mFont))) {
        this.msgId = System.currentTimeMillis();
      }
      paramETTextView.shouldStartAnimation = this.cVL;
      paramkt.mAnimationId = this.msgId;
      paramETTextView.setFont(paramkt, this.msgId);
      paramETTextView.requestLayout();
      return;
      ETFont localETFont = new ETFont(paramkt.mFontId, paramkt.mFontPath, paramFloat, paramkt.mFontType, paramkt.mTypeface);
      paramkt.b = localETFont;
      paramkt = localETFont;
    }
  }
  
  protected kt b(int paramInt1, int paramInt2)
  {
    if ((this.mApp != null) && ((this.mApp instanceof QQAppInterface)))
    {
      this.jdField_b_of_type_Ku = ((ku)this.mApp.getManager(42));
      this.jdField_b_of_type_Ku.a(this);
      return this.jdField_b_of_type_Ku.a(paramInt1, paramInt2, false, ((QQAppInterface)this.mApp).getCurrentUin(), 0);
    }
    return null;
  }
  
  public void destroy()
  {
    kx.a().deleteObserver(this.h);
    if (this.m != null)
    {
      this.m.setTextAnimationListener(null);
      this.m = null;
    }
    if (this.jdField_b_of_type_Ku != null) {
      this.jdField_b_of_type_Ku.b(this);
    }
  }
  
  public void eU()
  {
    this.a.A().sendEmptyMessage(10003);
  }
  
  public void load()
  {
    if (AppUtil.isMainProcess()) {}
    for (kt localkt = b(this.a.getId(), this.mFontType);; localkt = kx.a().b(this.a.getId(), this.mFontType))
    {
      QLog.i("SignatureFontAdapter", 1, "load " + localkt + " fontId:" + this.a.getId());
      if ((localkt != null) && (this.m != null)) {
        a(this.m, localkt, this.mTextSize);
      }
      return;
    }
  }
  
  public void update(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.m.setFont(0, System.currentTimeMillis());
      return;
    }
    this.a.update(paramInt1);
    this.mFontType = paramInt2;
    load();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsa
 * JD-Core Version:    0.7.0.1
 */