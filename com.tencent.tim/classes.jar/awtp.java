import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class awtp
  extends awrx
{
  private awuv jdField_a_of_type_Awuv;
  private ayca jdField_a_of_type_Ayca;
  private aycb jdField_a_of_type_Aycb;
  
  public awtp(aycb paramaycb, ayca paramayca)
  {
    this.jdField_a_of_type_Aycb = paramaycb;
    this.jdField_a_of_type_Ayca = paramayca;
  }
  
  public void eFX()
  {
    Intent localIntent = this.jdField_a_of_type_Aycb.getActivity().getIntent();
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 7);
    this.jdField_a_of_type_Awuv = new awuv();
    this.jdField_a_of_type_Aycb.getActivity().getFragmentManager().beginTransaction().add(2131367154, this.jdField_a_of_type_Awuv).commit();
  }
  
  public void onActivityStart()
  {
    super.onActivityStart();
  }
  
  public boolean onBackPressed()
  {
    if (this.jdField_a_of_type_Aycb == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Awuv != null) && (this.jdField_a_of_type_Awuv.a != null)) {
      this.jdField_a_of_type_Awuv.a.onTitleBtnCancelClick(null);
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView()
  {
    return this.jdField_a_of_type_Aycb.getActivity().getLayoutInflater().inflate(2131558631, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Aycb.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtp
 * JD-Core Version:    0.7.0.1
 */