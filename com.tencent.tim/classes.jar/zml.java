import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;

class zml
  implements AdapterView.c
{
  zml(zme paramzme) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(zme.TAG, 2, "onItemClick, position = " + paramInt);
    }
    paramAdapterView = this.b.F.getAdapter();
    if (paramAdapterView == this.b.b)
    {
      paramAdapterView = (zmc)this.b.b.getItem(paramInt);
      this.b.o = paramAdapterView.messageRecord;
      this.b.cdF = this.b.app.b().a(this.b.sessionInfo.aTl, this.b.sessionInfo.cZ, paramAdapterView.messageRecord);
      if (QLog.isColorLevel()) {
        QLog.i(zme.TAG, 2, "onItemClick, mRecordCount = " + this.b.cdF);
      }
      this.b.BM(true);
      this.b.dismiss();
    }
    do
    {
      return;
      if (paramAdapterView == this.b.a)
      {
        paramAdapterView = (zls)this.b.a.getItem(paramInt);
        this.b.brD = false;
        this.b.v.setText(paramAdapterView.keyword);
        this.b.v.setSelection(paramAdapterView.keyword.length());
        this.b.v.requestFocus();
        ((InputMethodManager)this.b.v.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i(zme.TAG, 2, "onItemClick, unknown data type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zml
 * JD-Core Version:    0.7.0.1
 */