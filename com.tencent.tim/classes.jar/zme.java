import android.content.Context;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class zme
  extends zkw
{
  protected static final String TAG = zme.class.getSimpleName();
  protected TextView MU;
  zmo a;
  zmd b;
  boolean brD = true;
  private View.OnClickListener cp = new zmi(this);
  
  public zme(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    cpQ();
    gT();
    gU();
    initCancelButton();
  }
  
  private void cpQ()
  {
    this.F = ((XListView)findViewById(2131377856));
    this.jdField_b_of_type_Zmd = new zmd(this.mContext, this.jdField_b_of_type_Aurf, this.sessionInfo, this.app);
    this.a = new zmo(this.mContext, this.jdField_b_of_type_Aurf, this.app);
    this.F.setAdapter(this.a);
    this.F.setOnScrollListener(new zmj(this));
    this.F.setOnTouchListener(new zmk(this));
    this.F.setOnItemClickListener(new zml(this));
    this.F.setOnItemLongClickListener(new zmm(this));
    this.MU = ((TextView)findViewById(2131372437));
    this.MU.setCompoundDrawables(null, null, null, null);
    this.MU.setText(2131719279);
  }
  
  private void cpR()
  {
    String str = this.v.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "loadMessageMore, currentKeyword = " + str);
    }
    this.jdField_b_of_type_Zmd.j(System.currentTimeMillis(), str, 2);
  }
  
  private void gT()
  {
    this.v = ((EditText)findViewById(2131366542));
    this.v.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.v.addTextChangedListener(new zmf(this));
    this.v.setImeOptions(3);
    zkw.a locala = new zkw.a(this);
    this.v.setOnEditorActionListener(locala);
    this.v.setOnKeyListener(locala);
    this.v.setSelection(0);
    this.v.requestFocus();
    this.a.zy("");
  }
  
  private void gU()
  {
    ((ImageButton)findViewById(2131368696)).setOnClickListener(new zmg(this));
  }
  
  private void initCancelButton()
  {
    Button localButton = (Button)findViewById(2131363801);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new zmh(this));
  }
  
  protected void cpN()
  {
    String str1 = this.v.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "searchMessage, currentKeyword = " + str1);
    }
    if (str1.length() == 0) {}
    String str2;
    do
    {
      return;
      str2 = this.jdField_b_of_type_Zmd.getKeyword();
      if ((this.F.getAdapter() != this.jdField_b_of_type_Zmd) || (!str1.equalsIgnoreCase(str2))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "searchMessage, skip, currentKeyword = " + str1 + ", mLastKeyword = " + str2);
    return;
    this.jdField_b_of_type_Zmd.j(System.currentTimeMillis(), str1, 1);
    am(2131691423);
  }
  
  void cpS()
  {
    this.MU.setVisibility(0);
    this.F.setVisibility(8);
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.v.getWindowToken(), 0);
    this.jdField_b_of_type_Aurf.removeMessages(0);
    this.jdField_b_of_type_Aurf.removeMessages(1);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "handleMessage, msg.what = " + paramMessage.what);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      showSoftInputIfNecessary();
      continue;
      showSoftInput();
      continue;
      dismissProgressDialog();
      if (this.F.getAdapter() != this.jdField_b_of_type_Zmd) {
        this.F.setAdapter(this.jdField_b_of_type_Zmd);
      }
      if ((paramMessage.obj instanceof List))
      {
        this.jdField_b_of_type_Zmd.N((List)paramMessage.obj, paramMessage.arg1);
        this.jdField_b_of_type_Zmd.notifyDataSetChanged();
      }
      if (this.jdField_b_of_type_Zmd.getCount() == 0)
      {
        cpS();
      }
      else
      {
        showListView();
        continue;
        if (this.F.getAdapter() != this.a) {
          this.F.setAdapter(this.a);
        }
        this.a.notifyDataSetChanged();
        showListView();
      }
    }
  }
  
  public void show()
  {
    super.show();
    this.jdField_b_of_type_Aurf.removeMessages(0);
    this.jdField_b_of_type_Aurf.removeMessages(1);
    this.jdField_b_of_type_Aurf.sendEmptyMessage(0);
  }
  
  void showListView()
  {
    this.MU.setVisibility(8);
    this.F.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zme
 * JD-Core Version:    0.7.0.1
 */