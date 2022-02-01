import android.media.MediaMetadataRetriever;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.qphone.base.util.QLog;

public class anzb
  extends anyz
{
  protected VPNGImageView b;
  
  public anzb(SpriteNativeView paramSpriteNativeView, String paramString)
  {
    this.a = paramSpriteNativeView;
    this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView = new VPNGImageView(paramSpriteNativeView.getContext());
    paramSpriteNativeView = new MediaMetadataRetriever();
    try
    {
      paramSpriteNativeView.setDataSource(paramString);
      paramString = paramSpriteNativeView.extractMetadata(18);
      String str = paramSpriteNativeView.extractMetadata(19);
      this.width = (Integer.parseInt(paramString) / 2);
      this.height = Integer.parseInt(str);
      paramString = new FrameLayout.LayoutParams((int)this.width, (int)this.height);
      this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.setLayoutParams(paramString);
      this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.setPivotX(this.width / 2.0F);
      this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.setPivotY(this.height / 2.0F);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("VideoSprite", 2, "MediaMetadataRetriever exception " + paramString);
      return;
    }
    finally
    {
      paramSpriteNativeView.release();
    }
  }
  
  public boolean azq()
  {
    boolean bool = super.azq();
    a(this.jdField_b_of_type_Anya);
    float f1 = this.jdField_b_of_type_Anya.x;
    float f2 = bv();
    float f3 = this.width / 2.0F;
    float f4 = this.mViewHeight;
    float f5 = this.jdField_b_of_type_Anya.y;
    float f6 = bv();
    float f7 = this.height / 2.0F;
    this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.setX(f1 * f2 - f3);
    this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.setY(f4 - f5 * f6 - f7);
    this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.setScaleX(this.scale * bv());
    this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.setScaleY(this.scale * bv());
    this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.setRotation(this.rotate);
    this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.setAlpha(this.opacity * (Ky() / 255.0F) / 255.0F);
    return bool;
  }
  
  public void cW(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.setVideo(paramString, paramBoolean);
  }
  
  public void onAdded()
  {
    this.a.addView(this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView);
  }
  
  public void pause()
  {
    super.pause();
    this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.onPause();
  }
  
  public void release()
  {
    super.release();
  }
  
  public void resume()
  {
    super.resume();
    this.jdField_b_of_type_ComTencentMobileqqVpngViewVPNGImageView.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzb
 * JD-Core Version:    0.7.0.1
 */