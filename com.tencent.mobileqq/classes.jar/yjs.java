import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment;
import com.tencent.gdtad.views.videoceiling.GdtBaseVideoCeilingFragment;
import java.lang.ref.WeakReference;

public class yjs
{
  public int a;
  public long a;
  public Rect a;
  public Bundle a;
  public GdtAd a;
  public Class<? extends GdtBaseVideoCeilingFragment> a;
  public String a;
  public WeakReference<Activity> a;
  public boolean a;
  public int b;
  public Class<? extends GdtCanvasBaseFragment> b;
  public WeakReference<GdtAppReceiver> b;
  public boolean b;
  public int c = -2147483648;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  
  public yjs()
  {
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = -2147483648;
  }
  
  public boolean a()
  {
    return (b()) && (this.jdField_a_of_type_ComTencentGdtadAditemGdtAd != null) && (this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.isValid()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForImpression())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForClick())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForEffect())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForAction())) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForLandingPage()));
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_b_of_type_JavaLangClass != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yjs
 * JD-Core Version:    0.7.0.1
 */