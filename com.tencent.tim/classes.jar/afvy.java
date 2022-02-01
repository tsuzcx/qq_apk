import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment.3.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class afvy
  extends RecyclerView.OnScrollListener
{
  public afvy(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onScrollStateChanged(RecyclerView arg1, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onScrollStateChanged state=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.this$0.jdField_a_of_type_Aqdf != null)
    {
      if (paramInt != 0) {
        break label94;
      }
      this.this$0.mScrolling = false;
      this.this$0.jdField_a_of_type_Aqdf.resume();
      this.this$0.dcd();
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        ExtendFriendSquareFragment.c(this.this$0);
        this.this$0.dch();
        this.this$0.Iv(false);
      }
      return;
      label94:
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
    this.this$0.cUP = this.this$0.DI();
    float f2 = 0.0F;
    float f1 = f2;
    if (this.this$0.XR != -1L)
    {
      long l = System.currentTimeMillis() - this.this$0.XR;
      f1 = f2;
      if (l > 0L)
      {
        f1 = f2;
        if (l < 2000L) {
          f1 = paramInt2 * 1.0F / (float)l;
        }
      }
    }
    this.this$0.XR = System.currentTimeMillis();
    ExtendFriendSquareFragment.a(this.this$0, this.this$0.cUP, f1);
    if ((!ExtendFriendSquareFragment.a(this.this$0)) && (!ExtendFriendSquareFragment.b(this.this$0)) && (this.this$0.mLayoutManager != null) && (this.this$0.jdField_a_of_type_Afwe != null) && (this.this$0.mLayoutManager.findViewByPosition(this.this$0.jdField_a_of_type_Afwe.getItemCount() - 2) != null))
    {
      this.this$0.Iu(true);
      ExtendFriendSquareFragment.a(this.this$0).post(new ExtendFriendSquareFragment.3.1(this));
      anot.a(this.this$0.mApp, "dc00898", "", "", "0X80092D5", "0X80092D5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvy
 * JD-Core Version:    0.7.0.1
 */