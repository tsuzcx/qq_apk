import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.qphone.base.util.QLog;

public class tlt
  implements tlu
{
  static int jdField_a_of_type_Int;
  static int b;
  public Drawable a;
  ZImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView;
  private String jdField_a_of_type_JavaLangString = "zimage.DrawableController";
  public tls a;
  tlw jdField_a_of_type_Tlw;
  vuw jdField_a_of_type_Vuw;
  private boolean jdField_a_of_type_Boolean = true;
  
  public tlt(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = paramZImageView;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + ".v" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.hashCode());
  }
  
  private void a(tls paramtls, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tls != null) {
      this.jdField_a_of_type_Tls.a();
    }
    this.jdField_a_of_type_Tls = paramtls;
    paramtls = new tme(this.jdField_a_of_type_Tls.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramtls, paramBoolean);
  }
  
  private boolean a(tls paramtls)
  {
    if ((this.jdField_a_of_type_Tls != null) && (paramtls != null) && (this.jdField_a_of_type_Tls.a() == paramtls.a())) {
      return (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof BitmapDrawable)) || (((BitmapDrawable)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable()).getBitmap() != this.jdField_a_of_type_Tls.a());
    }
    return true;
  }
  
  public tlw a()
  {
    return this.jdField_a_of_type_Tlw;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Tlw != null) {
      a("setPlaceHolder");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Tlw != null) {
      this.jdField_a_of_type_Tlw.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      tmd.a(this.jdField_a_of_type_JavaLangString, "detachFromWindow " + paramString + " " + this.jdField_a_of_type_Tlw + " " + this.jdField_a_of_type_Tls);
    }
    if (!a())
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof tme))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      if (this.jdField_a_of_type_Tls != null)
      {
        this.jdField_a_of_type_Tls.a();
        this.jdField_a_of_type_Tls = null;
      }
    }
    if (this.jdField_a_of_type_Tlw != null)
    {
      tlv.a().a(this.jdField_a_of_type_Tlw, "reset");
      this.jdField_a_of_type_Tlw = null;
    }
  }
  
  public void a(tlw paramtlw)
  {
    blfz.a("DrawableController.setImageRequest");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.isRound()) {
      paramtlw.c = 1;
    }
    jdField_a_of_type_Int += 1;
    a("resetUrl");
    tls localtls = tlv.a().a(paramtlw);
    if (localtls == null)
    {
      this.jdField_a_of_type_Tlw = paramtlw;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      qdl.a(this.jdField_a_of_type_Tlw);
      tlv.a().a(this.jdField_a_of_type_Tlw, this);
    }
    for (;;)
    {
      blfz.a();
      return;
      b += 1;
      qdm.b(1, paramtlw);
      a(paramtlw, localtls, false, "setImageRequest");
    }
  }
  
  public void a(tlw paramtlw, int paramInt)
  {
    if (this.jdField_a_of_type_Vuw != null) {
      this.jdField_a_of_type_Vuw.a(paramtlw.jdField_a_of_type_JavaNetURL, paramInt);
    }
  }
  
  public void a(tlw paramtlw, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Vuw != null) {
      this.jdField_a_of_type_Vuw.a(paramtlw.jdField_a_of_type_JavaNetURL, paramThrowable);
    }
  }
  
  public void a(tlw paramtlw, tls paramtls)
  {
    if ((paramtlw.equals(this.jdField_a_of_type_Tlw)) && (paramtls.a() != null))
    {
      a(paramtlw, paramtls, true, "onSuccess");
      return;
    }
    paramtls.a();
  }
  
  void a(tlw paramtlw, tls paramtls, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Tlw = paramtlw;
    if (QLog.isColorLevel()) {
      tmd.a(this.jdField_a_of_type_JavaLangString, "attachImage " + paramString + " " + this.jdField_a_of_type_Tlw + " " + paramtls + " total:" + jdField_a_of_type_Int + " cache:" + b);
    }
    if ((!a()) || (a(paramtls))) {
      a(paramtls, paramBoolean);
    }
    if (this.jdField_a_of_type_Tlw != null)
    {
      this.jdField_a_of_type_Tlw.e = 0;
      qdm.a(this.jdField_a_of_type_Tlw, true, "attached");
    }
    if (this.jdField_a_of_type_Vuw != null) {
      this.jdField_a_of_type_Vuw.a(paramtlw.jdField_a_of_type_JavaNetURL, paramtls);
    }
  }
  
  public void a(vuw paramvuw)
  {
    this.jdField_a_of_type_Vuw = paramvuw;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    return (qdk.a.e()) && (tmd.a());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      tmd.a(this.jdField_a_of_type_JavaLangString, "attachToWindow " + paramString + " " + this.jdField_a_of_type_Tlw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tlt
 * JD-Core Version:    0.7.0.1
 */