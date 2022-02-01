import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment.6.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class afvs
  extends RecyclerView.OnScrollListener
{
  public afvs(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void onScrollStateChanged(RecyclerView arg1, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("onScrollStateChanged state=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.this$0.jdField_a_of_type_Aqdf != null)
    {
      if (paramInt != 0) {
        break label87;
      }
      this.this$0.mScrolling = false;
      this.this$0.jdField_a_of_type_Aqdf.resume();
      this.this$0.dcd();
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        this.this$0.dch();
        this.this$0.Iv(false);
      }
      return;
      label87:
      this.this$0.mScrolling = true;
      this.this$0.jdField_a_of_type_Aqdf.pause();
      this.this$0.jdField_a_of_type_Aqdf.edu();
      synchronized (ExtendFriendBaseFragment.dD)
      {
        if (this.this$0.kq != null) {
          this.this$0.kq.clear();
        }
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((!ExtendFriendSearchFragment.a(this.this$0)) && (!ExtendFriendSearchFragment.b(this.this$0)) && (this.this$0.mLayoutManager != null) && (this.this$0.jdField_a_of_type_Afwe != null) && (this.this$0.mLayoutManager.findViewByPosition(this.this$0.jdField_a_of_type_Afwe.getItemCount() - 2) != null))
    {
      this.this$0.Iu(true);
      ExtendFriendSearchFragment.a(this.this$0).post(new ExtendFriendSearchFragment.6.1(this));
      anot.a(this.this$0.mApp, "dc00898", "", "", "0X80092D5", "0X80092D5", 0, 0, "", "", "", "");
    }
    this.this$0.K(false, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvs
 * JD-Core Version:    0.7.0.1
 */