import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.MultiVideoMembersHolderUI;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bkm
  implements AdapterView.OnItemClickListener
{
  public bkm(MultiVideoMembersHolderUI paramMultiVideoMembersHolderUI) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiVideoMembersHolderUI", 2, "onItemClick INGridView POSITION=" + paramInt + "ID=" + paramLong);
    }
    paramInt = (int)paramLong;
    bkp localbkp = (bkp)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    boolean bool = this.a.a(localbkp, paramInt);
    if ((!bool) && (!localbkp.c) && (!localbkp.b)) {}
    for (paramInt = 0;; paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener != null) {
        this.a.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener.a(localbkp.a, paramInt, bool);
      }
      if ((localbkp.c) || (localbkp.b)) {
        break;
      }
      paramView.startAnimation(AnimationUtils.loadAnimation((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968635));
      ReportController.b(null, "CliOper", "", "", "0X800442D", "0X800442D", 0, 0, "", "", "", "");
      return;
    }
    ((bko)paramAdapterView.getAdapter()).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkm
 * JD-Core Version:    0.7.0.1
 */