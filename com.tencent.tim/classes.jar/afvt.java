import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;

public class afvt
  extends RecyclerView.AdapterDataObserver
{
  public afvt(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void onChanged()
  {
    if (this.this$0.jdField_a_of_type_Afwe.af() == 0)
    {
      this.this$0.mRecyclerView.removeItemDecoration(this.this$0.jdField_a_of_type_Afwf);
      return;
    }
    this.this$0.mRecyclerView.removeItemDecoration(this.this$0.jdField_a_of_type_Afwf);
    this.this$0.mRecyclerView.addItemDecoration(this.this$0.jdField_a_of_type_Afwf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvt
 * JD-Core Version:    0.7.0.1
 */