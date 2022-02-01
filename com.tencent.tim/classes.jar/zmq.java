import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zmq
  extends zkw
{
  private long Lk;
  private TenDocMessageResultAdapter a;
  private ImageButton ar;
  private String ban = "";
  private int cdm;
  private LinearLayout hN;
  private View mFooterView;
  private EditText v;
  
  public zmq(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.cdm = paramInt;
    cpQ();
    gT();
    cpP();
  }
  
  private void cpP()
  {
    this.ar.setOnClickListener(new zmu(this));
    Button localButton = (Button)findViewById(2131363801);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new zmv(this));
  }
  
  private void cpQ()
  {
    this.F = ((XListView)findViewById(2131377856));
    View localView = getLayoutInflater().inflate(2131559538, this.F, false);
    this.mFooterView = getLayoutInflater().inflate(2131562071, this.F, false);
    this.hN = ((LinearLayout)localView.findViewById(2131372444));
    this.hN.setClickable(false);
    this.mFooterView.setVisibility(8);
    this.mFooterView.setClickable(false);
    this.mFooterView.findViewById(2131377037).setVisibility(0);
    this.mFooterView.findViewById(2131373660).setVisibility(8);
    ((TextView)this.mFooterView.findViewById(2131371975)).setText(this.mContext.getString(2131719294));
    this.F.setVisibility(0);
    this.F.addHeaderView(localView, null, false);
    this.F.addFooterView(this.mFooterView, null, false);
    this.a = new TenDocMessageResultAdapter(this.mContext, this.b, this.sessionInfo, this.app);
    this.F.setAdapter(this.a);
    this.ar = ((ImageButton)findViewById(2131368696));
    this.F.setOnTouchListener(new zmr(this));
    this.F.setOnItemClickListener(new zms(this));
  }
  
  private void fQ(View paramView)
  {
    if (paramView == null) {}
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      localInputMethodManager = (InputMethodManager)this.mContext.getSystemService("input_method");
    } while (localInputMethodManager == null);
    localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  private void gT()
  {
    this.v = ((EditText)findViewById(2131366542));
    this.v.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.v.addTextChangedListener(new zmt(this));
    this.v.setImeOptions(3);
    zkw.a locala = new zkw.a(this);
    this.v.setOnEditorActionListener(locala);
    this.v.setOnKeyListener(locala);
    this.v.setHint(this.mContext.getString(2131691434));
    this.v.setSelection(0);
    this.v.requestFocus();
  }
  
  protected void cpN()
  {
    String str = this.v.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i("TenDocMessageSearchDialog", 2, "searchMessage, keyword = " + str);
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    this.hN.setVisibility(8);
    this.mFooterView.setVisibility(8);
    this.ban = str;
    this.Lk = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("TenDocMessageSearchDialog", 2, "searchMessage, keyword: " + this.ban + ", netState: " + AppNetConnInfo.isNetSupport());
    }
    this.a.zx(this.ban);
    this.a.j(this.Lk, this.ban, 1);
    anot.a(this.app, "dc00898", "", "", "0X800A174", "0X800A174", this.cdm, 0, "", "", "s_qq_history_tab", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TenDocMessageSearchDialog", 2, "handleMessage, catch show message");
      }
      Object localObject1 = paramMessage.getData();
      long l = ((Bundle)localObject1).getLong("searchSequence", 0L);
      Object localObject2 = ((Bundle)localObject1).getString("searchKeyword");
      if ((!(paramMessage.obj instanceof List)) || (l != this.Lk) || (!TextUtils.equals(this.ban, (CharSequence)localObject2)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TenDocMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
        }
        return true;
      }
      localObject1 = (List)paramMessage.obj;
      int i;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("handleMessage : ACTION_SHOW_MESSAGE searchSequence: ").append(l).append(", keyword: ").append((String)localObject2).append(", mCurrentKeyword: ").append(this.ban).append(", searchSequence: ").append(l).append(", mCurrentSearchSequence: ").append(this.Lk).append(", loadType: ").append(paramMessage.arg1).append(", size: ");
        if (localObject1 == null)
        {
          i = 0;
          QLog.d("TenDocMessageSearchDialog", 2, i);
        }
      }
      else
      {
        this.a.N((List)localObject1, paramMessage.arg1);
        if (this.a.getCount() != 0) {
          break label275;
        }
        this.hN.setVisibility(0);
        this.mFooterView.setVisibility(8);
      }
      for (;;)
      {
        return true;
        i = ((List)localObject1).size();
        break;
        label275:
        this.hN.setVisibility(8);
        this.mFooterView.setVisibility(0);
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  public void setData(List<Object> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof TencentDocItem)) {
        localArrayList.add((TencentDocItem)localObject);
      }
    }
    this.a.setData(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmq
 * JD-Core Version:    0.7.0.1
 */