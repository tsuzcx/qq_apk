import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;

public final class trk
{
  private int jdField_a_of_type_Int = -1;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  public TabLayoutCompat a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private Object jdField_a_of_type_JavaLangObject;
  public trl a;
  private CharSequence b;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  @Nullable
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @Nullable
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  @Nullable
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  @NonNull
  public trk a(int paramInt)
  {
    return a(LayoutInflater.from(this.jdField_a_of_type_Trl.getContext()).inflate(paramInt, this.jdField_a_of_type_Trl, false));
  }
  
  @NonNull
  public trk a(@Nullable View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    c();
    return this;
  }
  
  @NonNull
  public trk a(@Nullable CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    c();
    return this;
  }
  
  @NonNull
  public trk a(@Nullable Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    return this;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.e(this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.b() == this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public CharSequence b()
  {
    return this.b;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.c(this, true);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Trl != null) {
      this.jdField_a_of_type_Trl.b();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = null;
    this.jdField_a_of_type_Trl = null;
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.b = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trk
 * JD-Core Version:    0.7.0.1
 */