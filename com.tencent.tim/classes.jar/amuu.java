import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.search.rich.RichNodeRootLayout;

public abstract class amuu
  implements amum
{
  private View He;
  public amuk a;
  private RichNodeRootLayout a;
  private View mContentView;
  
  public amuu(amuk paramamuk, Context paramContext)
  {
    this.jdField_a_of_type_Amuk = paramamuk;
    eQ(paramContext);
  }
  
  public TextView N()
  {
    return null;
  }
  
  public TextView O()
  {
    return null;
  }
  
  public void Pz(boolean paramBoolean) {}
  
  public amuk a()
  {
    return this.jdField_a_of_type_Amuk;
  }
  
  public void destroy()
  {
    onDestroy();
  }
  
  public void eQ(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131561656, null, false);
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout = ((RichNodeRootLayout)localView.findViewById(2131377556));
    this.He = localView.findViewById(2131365990);
    this.mContentView = n(paramContext);
    if (this.mContentView != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout.addView(this.mContentView);
    }
  }
  
  public View g(String paramString)
  {
    return null;
  }
  
  public String getData()
  {
    amuk localamuk = a();
    if (localamuk != null) {
      return localamuk.getData();
    }
    return null;
  }
  
  public TextView getTitleView()
  {
    return null;
  }
  
  public final View getView()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout;
  }
  
  public abstract View n(Context paramContext);
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Amuk = null;
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout = null;
    this.mContentView = null;
    this.He = null;
  }
  
  public void showDivider(boolean paramBoolean)
  {
    if (this.He != null)
    {
      if (paramBoolean) {
        this.He.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.He.setVisibility(8);
  }
  
  public ImageView v()
  {
    return null;
  }
  
  public ImageView w()
  {
    return null;
  }
  
  public TextView z()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amuu
 * JD-Core Version:    0.7.0.1
 */