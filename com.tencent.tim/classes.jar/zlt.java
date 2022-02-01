import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zlt
  extends zkw
{
  boolean Hf = false;
  long Lj;
  TextView MR;
  TextView MS;
  TextView MT;
  zjj a;
  String ban = "";
  String bao = "";
  boolean brB = false;
  private Set<Long> bz = new HashSet();
  int cdG = 0;
  private View.OnClickListener clickListener = new zlx(this);
  View footerView;
  boolean gV = false;
  LinearLayout hI;
  private LinearLayout hN;
  LinearLayout hO;
  LinearLayout hP;
  View mHeadView;
  private List<zmc> uz = new ArrayList();
  
  public zlt(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.brB = paramBoolean;
    paramContext = paramQQAppInterface.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(paramContext)) && ("1".equals(paramContext.substring(paramContext.length() - 1, paramContext.length())))) {}
    cpQ();
    gT();
    cpP();
  }
  
  private void bA(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "showHeaderViewByType, needShowType = " + paramInt + ",tips: " + paramString);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mHeadView.setVisibility(8);
      this.hP.setVisibility(8);
      this.hO.setVisibility(8);
      this.MR.setVisibility(8);
      this.MT.setVisibility(8);
      this.hN.setVisibility(8);
      return;
    case 1: 
      this.mHeadView.setVisibility(0);
      this.hP.setVisibility(8);
      this.hO.setVisibility(0);
      this.MR.setVisibility(0);
      this.MT.setVisibility(8);
      return;
    case 2: 
      this.mHeadView.setVisibility(0);
      this.hP.setVisibility(8);
      this.hO.setVisibility(0);
      this.MR.setVisibility(8);
      this.MT.setVisibility(0);
      this.MT.setClickable(true);
      this.MT.setTextColor(this.mContext.getResources().getColor(2131166782));
      this.MT.setText(paramString);
      return;
    case 3: 
      this.mHeadView.setVisibility(0);
      this.hP.setVisibility(8);
      this.hO.setVisibility(0);
      this.MR.setVisibility(8);
      this.MT.setVisibility(0);
      this.MT.setClickable(false);
      this.MT.setTextColor(this.mContext.getResources().getColor(2131167379));
      this.MT.setText(paramString);
      return;
    case 4: 
      this.mHeadView.setVisibility(0);
      this.hN.setVisibility(0);
      return;
    }
    this.hO.setVisibility(8);
    this.MR.setVisibility(8);
    this.MT.setVisibility(8);
  }
  
  private void cpO()
  {
    this.gV = false;
    this.cdG = 0;
    this.uz.clear();
    this.bz.clear();
    this.Hf = false;
  }
  
  private void cpP()
  {
    ((ImageButton)findViewById(2131368696)).setOnClickListener(new zlv(this));
    Button localButton = (Button)findViewById(2131363801);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new zlw(this));
  }
  
  private void cpQ()
  {
    this.F = ((XListView)findViewById(2131377856));
    this.F.setVisibility(0);
    this.mHeadView = getLayoutInflater().inflate(2131559538, null);
    this.F.addHeaderView(this.mHeadView, null, false);
    this.hP = ((LinearLayout)this.mHeadView.findViewById(2131377037));
    this.hP.setClickable(false);
    this.MT = ((TextView)this.mHeadView.findViewById(2131377810));
    this.MT.setOnClickListener(this.clickListener);
    this.hO = ((LinearLayout)this.mHeadView.findViewById(2131377835));
    this.MR = ((TextView)this.mHeadView.findViewById(2131377838));
    this.MR.setOnClickListener(this.clickListener);
    this.hN = ((LinearLayout)this.mHeadView.findViewById(2131372444));
    this.hN.setClickable(false);
    this.footerView = getLayoutInflater().inflate(2131562071, null);
    this.F.addFooterView(this.footerView, null, false);
    this.footerView.setClickable(false);
    this.hI = ((LinearLayout)this.footerView.findViewById(2131377037));
    this.MS = ((TextView)this.footerView.findViewById(2131371975));
    this.MS.setText(this.mContext.getString(2131719290));
    this.footerView.setVisibility(8);
    this.a = new zjj(this.mContext, this.b, this.sessionInfo, this.app);
    this.F.setAdapter(this.a);
    this.F.setOnScrollListener(new zly(this));
    this.F.setOnTouchListener(new zlz(this));
    this.F.setOnItemClickListener(new zma(this));
    this.F.setOnItemLongClickListener(new zmb(this));
  }
  
  private void gT()
  {
    this.v = ((EditText)findViewById(2131366542));
    this.v.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.v.addTextChangedListener(new zlu(this));
    this.v.setImeOptions(3);
    zkw.a locala = new zkw.a(this);
    this.v.setOnEditorActionListener(locala);
    this.v.setOnKeyListener(locala);
    this.v.setHint(this.mContext.getString(2131691420));
    this.v.setSelection(0);
    this.v.requestFocus();
  }
  
  protected void cpN()
  {
    String str = this.v.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "searchMessage, keyword = " + str);
    }
    if (str.length() == 0) {
      return;
    }
    cpO();
    this.ban = str;
    this.a.zx(this.ban);
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "searchMessage, keyword: " + this.ban + ", needSearchInCloud: " + this.brB + ", netState: " + AppNetConnInfo.isNetSupport());
    }
    this.Lj = System.currentTimeMillis();
    this.cdG = 0;
    this.a.j(this.Lj, this.ban, 1);
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.v.getWindowToken(), 0);
    this.b.removeMessages(0);
    this.b.removeMessages(1);
    this.app.removeHandler(getClass());
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
      QLog.i("LinkMessageSearchDialog", 2, "handleMessage, msg.what = " + paramMessage.what + ",mSearchMode = " + this.cdG);
    }
    switch (i)
    {
    }
    Object localObject;
    long l;
    label314:
    label325:
    do
    {
      do
      {
        return true;
        showSoftInputIfNecessary();
        return true;
        showSoftInput();
        return true;
        localObject = paramMessage.getData();
        l = ((Bundle)localObject).getLong("searchSequence", 0L);
        localObject = ((Bundle)localObject).getString("searchKeyword");
        List localList = (List)paramMessage.obj;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("handleMessage : ACTION_SHOW_MESSAGE searchSequence: ").append(l).append(", keyword: ").append((String)localObject).append(", mCurrentKeyword: ").append(this.ban).append(", searchSequence: ").append(l).append(", mSearchSequence: ").append(this.Lj).append(", loadType: ").append(paramMessage.arg1).append(", size: ");
          if (localList != null) {
            break label314;
          }
        }
        for (i = 0;; i = localList.size())
        {
          QLog.d("LinkMessageSearchDialog", 2, i);
          if ((localList != null) && (l == this.Lj) && ((localObject == null) || (((String)localObject).equals(this.ban)))) {
            break label325;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("LinkMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
          return true;
        }
        if (((1 == paramMessage.arg1) && (localList.size() > 0) && (localList.size() != 20)) || ((2 == paramMessage.arg1) && (localList.size() == 0)))
        {
          this.MS.setText(acfp.m(2131707749));
          this.hI.findViewById(2131373660).setVisibility(8);
          this.hI.setVisibility(0);
          this.footerView.setVisibility(0);
          if (2 == paramMessage.arg1)
          {
            this.gV = false;
            return true;
          }
        }
        if ((paramMessage.obj instanceof List))
        {
          this.a.a((List)paramMessage.obj, paramMessage.arg1, this.Hf, 0);
          this.a.notifyDataSetChanged();
        }
        if (this.a.getCount() == 0) {
          bA(4, null);
        }
        for (;;)
        {
          this.gV = false;
          return true;
          this.hN.setVisibility(8);
          this.F.setVisibility(0);
        }
        paramMessage = (HashMap)paramMessage.obj;
        localObject = (String)paramMessage.get("keyword");
        l = ((Long)paramMessage.get("sequence")).longValue();
        if (QLog.isColorLevel()) {
          QLog.i("LinkMessageSearchDialog", 2, "handleMessage : MSG_TYPE_QUERY_LOCAL_DONE lastRequestKeyWord = " + (String)localObject + ",currentKeyword = " + this.ban + ",searchSequence = " + l + ",mCurrentSequence = " + this.Lj + ",mIsComplete: " + this.Hf);
        }
      } while ((!this.brB) || (this.Lj != l) || (TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(this.ban)) || (l != this.Lj) || (!this.ban.equals(localObject)));
      this.gV = false;
      this.footerView.setVisibility(8);
      this.hI.setVisibility(8);
      this.a.ac(this.uz, this.Hf);
      if ((this.Hf) && (this.a.getCount() < 20))
      {
        this.MS.setText(acfp.m(2131707750));
        this.hI.findViewById(2131373660).setVisibility(8);
        this.hI.setVisibility(0);
        this.footerView.setVisibility(0);
      }
      this.a.notifyDataSetChanged();
      this.F.setAdapter(this.a);
      this.F.setSelection(0);
      this.uz.clear();
      return true;
      localObject = (HashMap)paramMessage.obj;
      paramMessage = (String)((HashMap)localObject).get("keyword");
      l = ((Long)((HashMap)localObject).get("sequence")).longValue();
      localObject = (List)((HashMap)localObject).get("data");
      if (QLog.isColorLevel()) {
        QLog.i("LinkMessageSearchDialog", 2, "handleMessage: MERGE_LOCAL_MESSAGES_AND_CLOUD_MESSAGES reqKeyWord = " + paramMessage + ",currentKeyword = " + this.ban + ",searchSequence = " + l + ",mCurrentSequence = " + this.Lj + ",mIsComplete: " + this.Hf);
      }
    } while ((TextUtils.isEmpty(paramMessage)) || (!this.brB) || (this.Lj != l) || (!this.ban.equals(paramMessage)) || (l != this.Lj) || (!this.ban.equals(paramMessage)));
    this.gV = false;
    this.footerView.setVisibility(8);
    this.hI.setVisibility(8);
    this.a.ac((List)localObject, this.Hf);
    this.a.notifyDataSetChanged();
    this.F.setAdapter(this.a);
    this.F.setSelection(0);
    this.uz.clear();
    return true;
  }
  
  public void hj(List<TroopLinkElement> paramList)
  {
    this.a.hj(paramList);
  }
  
  public void show()
  {
    super.show();
    this.app.setHandler(getClass(), this.b);
    this.b.removeMessages(0);
    this.b.removeMessages(1);
    this.b.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlt
 * JD-Core Version:    0.7.0.1
 */