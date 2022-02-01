import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

public class amcd
  implements IBrowserBuilder
{
  private amcn jdField_a_of_type_Amcn;
  private amcv jdField_a_of_type_Amcv;
  private amdq jdField_a_of_type_Amdq;
  private Activity mActivity;
  
  public amcd(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public amcv a()
  {
    return this.jdField_a_of_type_Amcv;
  }
  
  public void buildComplete()
  {
    this.jdField_a_of_type_Amcv.buildComplete();
    this.jdField_a_of_type_Amdq.buildComplete();
    this.jdField_a_of_type_Amcn.buildComplete();
  }
  
  public void buildModel()
  {
    this.jdField_a_of_type_Amcn.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.jdField_a_of_type_Amcv.buildParams(paramIntent);
    this.jdField_a_of_type_Amdq.buildParams(paramIntent);
    this.jdField_a_of_type_Amcn.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.jdField_a_of_type_Amcv = new amcv();
    this.jdField_a_of_type_Amdq = new amdq(this.mActivity, this.jdField_a_of_type_Amcv);
    this.jdField_a_of_type_Amcv.a(this.jdField_a_of_type_Amdq);
    this.jdField_a_of_type_Amcn = new amcn(this.jdField_a_of_type_Amcv);
    this.jdField_a_of_type_Amcv.a(this.jdField_a_of_type_Amcn);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Amdq.buildView(paramViewGroup);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Amcv != null) {
      this.jdField_a_of_type_Amcv.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Amcv != null) {
      return this.jdField_a_of_type_Amcv.onBackEvent();
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Amcv != null) {
      this.jdField_a_of_type_Amcv.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Amcv != null) {
      this.jdField_a_of_type_Amcv.onDestroy();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Amcv != null) {
      return this.jdField_a_of_type_Amcv.onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Amcv != null) {
      this.jdField_a_of_type_Amcv.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_Amcv != null) {
      this.jdField_a_of_type_Amcv.onResume();
    }
  }
  
  public void onStart()
  {
    if (this.jdField_a_of_type_Amcv != null) {
      this.jdField_a_of_type_Amcv.onStart();
    }
  }
  
  public void onWindowFocusChanged()
  {
    if (this.jdField_a_of_type_Amcv != null) {
      this.jdField_a_of_type_Amcv.onWindowFocusChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcd
 * JD-Core Version:    0.7.0.1
 */