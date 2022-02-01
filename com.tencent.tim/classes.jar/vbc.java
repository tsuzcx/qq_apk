import android.os.AsyncTask;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageActivity.6.1;
import com.tencent.widget.Gallery;

public class vbc
  extends AsyncTask<Void, Void, Void>
{
  public vbc(FriendProfileImageActivity paramFriendProfileImageActivity, vbi.b paramb) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    this.this$0.jdField_a_of_type_Vbi.e(this.a);
    return null;
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    this.this$0.jdField_a_of_type_Vbi.setCurrentIndex(this.this$0.initIndex);
    this.this$0.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.this$0.jdField_a_of_type_Vbi.getCurrentIndex());
    this.this$0.jdField_a_of_type_Aben.notifyDataSetChanged();
    if ((!this.this$0.Av) && (this.this$0.aWG)) {
      this.this$0.af.setVisibility(0);
    }
    this.this$0.mRoot.post(new FriendProfileImageActivity.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbc
 * JD-Core Version:    0.7.0.1
 */