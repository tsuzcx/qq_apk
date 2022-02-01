import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.qphone.base.util.QLog;

public class now
  implements nox
{
  static int baK;
  static int baL;
  nov jdField_a_of_type_Nov;
  noz jdField_a_of_type_Noz;
  private boolean atJ = true;
  ZImageView b;
  oud c;
  public Drawable mPlaceHolder;
  private String tag = "zimage.DrawableController";
  
  public now(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.mPlaceHolder = paramDrawable;
    this.b = paramZImageView;
    this.tag = (this.tag + ".v" + this.b.hashCode());
  }
  
  private void a(nov paramnov, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Nov != null) {
      this.jdField_a_of_type_Nov.close();
    }
    this.jdField_a_of_type_Nov = paramnov;
    paramnov = new npf(this.jdField_a_of_type_Nov.Q());
    this.b.setImageDrawable(paramnov, paramBoolean);
  }
  
  private boolean a(nov paramnov)
  {
    if ((this.jdField_a_of_type_Nov != null) && (paramnov != null) && (this.jdField_a_of_type_Nov.Q() == paramnov.Q())) {
      return (!(this.b.getDrawable() instanceof BitmapDrawable)) || (((BitmapDrawable)this.b.getDrawable()).getBitmap() != this.jdField_a_of_type_Nov.Q());
    }
    return true;
  }
  
  boolean FS()
  {
    return (lgj.Cg()) && (npe.FU());
  }
  
  public void G(Drawable paramDrawable)
  {
    this.mPlaceHolder = paramDrawable;
    if (this.jdField_a_of_type_Noz != null) {
      op("setPlaceHolder");
    }
    this.b.setImageDrawable(paramDrawable);
  }
  
  public noz a()
  {
    return this.jdField_a_of_type_Noz;
  }
  
  public void a(noz paramnoz, int paramInt)
  {
    if (this.c != null) {
      this.c.a(paramnoz.url, paramInt);
    }
  }
  
  public void a(noz paramnoz, Throwable paramThrowable)
  {
    if (this.c != null) {
      this.c.a(paramnoz.url, paramThrowable);
    }
  }
  
  public void a(noz paramnoz, nov paramnov)
  {
    if ((paramnoz.equals(this.jdField_a_of_type_Noz)) && (paramnov.Q() != null))
    {
      a(paramnoz, paramnov, true, "onSuccess");
      return;
    }
    paramnov.close();
  }
  
  void a(noz paramnoz, nov paramnov, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Noz = paramnoz;
    if (QLog.isColorLevel()) {
      npe.log(this.tag, "attachImage " + paramString + " " + this.jdField_a_of_type_Noz + " " + paramnov + " total:" + baK + " cache:" + baL);
    }
    if ((!FS()) || (a(paramnov))) {
      a(paramnov, paramBoolean);
    }
    lgl.a(this.jdField_a_of_type_Noz, true, "attached");
    if (this.c != null) {
      this.c.a(paramnoz.url, paramnov);
    }
  }
  
  public void f(noz paramnoz)
  {
    auvk.traceBegin("DrawableController.setImageRequest");
    if (this.b.isRound()) {
      paramnoz.shape = 1;
    }
    baK += 1;
    op("resetUrl");
    nov localnov = noy.a().a(paramnoz);
    if (localnov == null)
    {
      this.jdField_a_of_type_Noz = paramnoz;
      this.b.setImageDrawable(this.mPlaceHolder);
      lgk.a(this.jdField_a_of_type_Noz);
      noy.a().a(this.jdField_a_of_type_Noz, this);
    }
    for (;;)
    {
      auvk.traceEnd();
      return;
      baL += 1;
      lgl.b(1, paramnoz);
      a(paramnoz, localnov, false, "setImageRequest");
    }
  }
  
  public void op(String paramString)
  {
    if (this.jdField_a_of_type_Noz != null) {
      this.jdField_a_of_type_Noz.mIsCancel = true;
    }
    if (QLog.isColorLevel()) {
      npe.log(this.tag, "detachFromWindow " + paramString + " " + this.jdField_a_of_type_Noz + " " + this.jdField_a_of_type_Nov);
    }
    if (!FS())
    {
      if ((this.atJ) && (this.b.getDrawable() != null) && ((this.b.getDrawable() instanceof npf))) {
        this.b.setImageDrawable(this.mPlaceHolder);
      }
      if (this.jdField_a_of_type_Nov != null)
      {
        this.jdField_a_of_type_Nov.close();
        this.jdField_a_of_type_Nov = null;
      }
    }
    if (this.jdField_a_of_type_Noz != null)
    {
      noy.a().a(this.jdField_a_of_type_Noz, "reset");
      this.jdField_a_of_type_Noz = null;
    }
  }
  
  public void oq(String paramString)
  {
    if (QLog.isColorLevel()) {
      npe.log(this.tag, "attachToWindow " + paramString + " " + this.jdField_a_of_type_Noz);
    }
  }
  
  public void pV(boolean paramBoolean)
  {
    this.atJ = paramBoolean;
  }
  
  public void setPublicAccountImageDownListener(oud paramoud)
  {
    this.c = paramoud;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     now
 * JD-Core Version:    0.7.0.1
 */