import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.Pair;
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
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.searcher.oidb_c2c_searcher.Iterator;

public class zli
  extends zkw
{
  boolean Hf = false;
  long Lj;
  TextView MR;
  TextView MS;
  TextView MT;
  public zlg a;
  String ban = "";
  String bao = "";
  boolean brB = false;
  boolean brC = false;
  private Set<Long> bz = new HashSet();
  int cdG = 0;
  private int cdJ;
  private View.OnClickListener clickListener = new zlm(this);
  View footerView;
  boolean gV = false;
  LinearLayout hI;
  private LinearLayout hN;
  LinearLayout hO;
  LinearLayout hP;
  private HashMap<String, oidb_c2c_searcher.Iterator> hr = new HashMap();
  View mHeadView;
  private List<zmc> uA = new ArrayList();
  private List<zmc> uz = new ArrayList();
  
  public zli(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.brB = paramBoolean;
    paramContext = paramQQAppInterface.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(paramContext)) && ("1".equals(paramContext.substring(paramContext.length() - 1, paramContext.length())))) {
      this.brC = true;
    }
    cpQ();
    gT();
    cpP();
  }
  
  private void bA(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "showHeaderViewByType, needShowType = " + paramInt + ",tips: " + paramString);
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
    this.cdJ = 0;
    this.Hf = false;
  }
  
  private void cpP()
  {
    ((ImageButton)findViewById(2131368696)).setOnClickListener(new zlk(this));
    Button localButton = (Button)findViewById(2131363801);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new zll(this));
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
    this.a = new zlg(this.mContext, this.b, this.sessionInfo, this.app);
    this.F.setAdapter(this.a);
    this.F.setOnScrollListener(new zln(this));
    this.F.setOnTouchListener(new zlo(this));
    this.F.setOnItemClickListener(new zlp(this));
    this.F.setOnItemLongClickListener(new zlq(this));
  }
  
  private void gT()
  {
    this.v = ((EditText)findViewById(2131366542));
    this.v.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.v.addTextChangedListener(new zlj(this));
    this.v.setImeOptions(3);
    zkw.a locala = new zkw.a(this);
    this.v.setOnEditorActionListener(locala);
    this.v.setOnKeyListener(locala);
    this.v.setSelection(0);
    this.v.requestFocus();
  }
  
  public void Fp(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.sessionInfo.aTl);
    oidb_c2c_searcher.Iterator localIterator = (oidb_c2c_searcher.Iterator)this.hr.get(this.ban);
    long l1 = NetConnInfoCenter.getServerTime();
    Object localObject2 = (achs)this.app.getManager(92);
    Object localObject1 = ((achs)localObject2).d();
    long l2;
    int j;
    int k;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      l2 = ((Long)((achs)localObject2).a((Calendar)localObject1).second).longValue();
      localObject2 = new StringBuilder();
      int i = ((Calendar)localObject1).get(1);
      j = ((Calendar)localObject1).get(2) + 1;
      k = ((Calendar)localObject1).get(5);
      localStringBuilder = ((StringBuilder)localObject2).append(i).append("-");
      if (j <= 9) {
        break label280;
      }
      localObject1 = Integer.valueOf(j);
      localStringBuilder = localStringBuilder.append(localObject1).append("-");
      if (k <= 9) {
        break label305;
      }
    }
    label280:
    label305:
    for (localObject1 = Integer.valueOf(k);; localObject1 = "0" + k)
    {
      localStringBuilder.append(localObject1);
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.i("C2CMessageSearchDialog", 2, "showSearchDialog--> lastDay:" + ((StringBuilder)localObject2).toString());
        l1 = l2;
      }
      if (localIterator == null) {
        break label331;
      }
      localObject1 = new ArrayList();
      ((List)localObject1).add(localIterator);
      this.app.a().a(paramInt, localArrayList, this.ban, this.Lj, (List)localObject1, 0, l1);
      return;
      localObject1 = "0" + j;
      break;
    }
    label331:
    this.app.a().a(paramInt, localArrayList, this.ban, this.Lj, null, 0, l1);
  }
  
  protected void cpN()
  {
    String str = this.v.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "searchMessage, keyword = " + str);
    }
    if (str.length() == 0) {
      return;
    }
    this.hr.clear();
    cpO();
    this.ban = str;
    this.a.zx(this.ban);
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "searchMessage, keyword: " + this.ban + ", needSearchInCloud: " + this.brB + ", netState: " + AppNetConnInfo.isNetSupport());
    }
    this.Lj = System.currentTimeMillis();
    if ((this.brB) && (AppNetConnInfo.isNetSupport()))
    {
      this.cdG = 1;
      bA(5, null);
      Fp(1);
      anot.a(this.app, "CliOper", "", "", "0X8005FCB", "0X8005FCB", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X8005FCA", "0X8005FCA", 0, 0, "", "", "", "");
      return;
      this.cdG = 0;
      this.a.j(this.Lj, this.ban, 1);
      if (this.brB) {
        bA(3, this.mContext.getString(2131719301));
      } else {
        bA(0, null);
      }
    }
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
      QLog.i("C2CMessageSearchDialog", 2, "handleMessage, msg.what = " + paramMessage.what + ",mSearchMode = " + this.cdG);
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
      Object localObject1 = paramMessage.getData();
      long l = ((Bundle)localObject1).getLong("searchSequence", 0L);
      localObject1 = ((Bundle)localObject1).getString("searchKeyword");
      Object localObject2 = (List)paramMessage.obj;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("handleMessage : ACTION_SHOW_MESSAGE searchSequence: ").append(l).append(", keyword: ").append((String)localObject1).append(", mCurrentKeyword: ").append(this.ban).append(", searchSequence: ").append(l).append(", mSearchSequence: ").append(this.Lj).append(", loadType: ").append(paramMessage.arg1).append(", size: ");
        if (localObject2 != null) {
          break label320;
        }
      }
      label320:
      for (i = 0;; i = ((List)localObject2).size())
      {
        QLog.d("C2CMessageSearchDialog", 2, i);
        if ((localObject2 != null) && (l == this.Lj) && ((localObject1 == null) || (((String)localObject1).equals(this.ban)))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("C2CMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
        }
        return true;
      }
      if (((1 == paramMessage.arg1) && (((List)localObject2).size() > 0) && (((List)localObject2).size() != 20)) || ((2 == paramMessage.arg1) && (((List)localObject2).size() == 0)))
      {
        this.MS.setText(acfp.m(2131703335));
        this.hI.findViewById(2131373660).setVisibility(8);
        this.hI.setVisibility(0);
        this.footerView.setVisibility(0);
        if (2 == paramMessage.arg1)
        {
          this.gV = false;
          continue;
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
        break;
        this.hN.setVisibility(8);
        this.F.setVisibility(0);
      }
      paramMessage = (HashMap)paramMessage.obj;
      localObject1 = (String)paramMessage.get("KEYWORD");
      l = ((Long)paramMessage.get("SEARCHSEQUENCE")).longValue();
      i = ((Integer)paramMessage.get("LOADTYPE")).intValue();
      if (QLog.isColorLevel()) {
        QLog.i("C2CMessageSearchDialog", 2, "handleMessage : RSP_SEARCH_TIMEOUT_OR_ERROR_IN_CLOUD ReqkeyWord = " + (String)localObject1 + ",currentKeyword: " + this.ban + ", searchSequence: " + l + ",mCurrentSequence: " + this.Lj + ", needSearchInCloud: " + this.brB);
      }
      if ((!this.brB) || (l != this.Lj) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(this.ban))) {
        return true;
      }
      if ((l == this.Lj) && (this.ban.equals(localObject1)))
      {
        this.footerView.setVisibility(8);
        this.hI.setVisibility(8);
        this.Hf = true;
        this.cdJ = 0;
        if (i == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CMessageSearchDialog", 2, "LOAD_REFRESH query cloud failed --->>> switch local mode");
          }
          bA(0, null);
          this.cdG = 0;
          this.Lj = System.currentTimeMillis();
          this.a.j(this.Lj, this.ban, 1);
        }
        for (;;)
        {
          this.gV = false;
          this.uz.clear();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("C2CMessageSearchDialog", 2, "LOAD_MSG_IN_CLOUD query cloud failed --->>> merge local data");
          }
          this.a.a(this.uz, 4, this.Hf, 0);
          this.a.notifyDataSetChanged();
        }
        localObject2 = (HashMap)paramMessage.obj;
        localObject1 = (String)((HashMap)localObject2).get("KEYWORD");
        l = ((Long)((HashMap)localObject2).get("SEARCHSEQUENCE")).longValue();
        int j = ((Integer)((HashMap)localObject2).get("LOADTYPE")).intValue();
        paramMessage = (List)((HashMap)localObject2).get("SEARCHRESULT");
        boolean bool = ((Boolean)((HashMap)localObject2).get("SEARCHCOMPLETE")).booleanValue();
        if (((HashMap)localObject2).get("SEARCHINFO") != null)
        {
          localObject2 = (List)((HashMap)localObject2).get("SEARCHINFO");
          this.hr.put(localObject1, ((List)localObject2).get(0));
        }
        if (QLog.isColorLevel()) {
          QLog.i("C2CMessageSearchDialog", 2, "handleMessage : RSP_SEARCH_MORE_MESSAGE_IN_CLOUD reqKeyWord: " + (String)localObject1 + ", mCurrentKeyword: " + this.ban + ", searchSequence: " + l + ", mCurrentSequence:" + this.Lj + ", searchresult size: " + paramMessage.size() + ", total cache size: " + this.uz.size() + ", IsComplete: " + bool + ", loadType: " + j + ", needSearchInCloud: " + this.brB + ", retryGetMore: " + this.cdJ);
        }
        if ((!this.brB) || (this.Lj != l) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(this.ban))) {
          return true;
        }
        if ((this.Lj == l) && (this.ban.equals(localObject1)))
        {
          this.gV = false;
          this.footerView.setVisibility(8);
          this.hI.setVisibility(8);
          this.Hf = bool;
          if (this.cdJ == 0) {
            this.uz.clear();
          }
          i = 0;
          while (i < paramMessage.size())
          {
            localObject1 = new zmc(this.app, (MessageRecord)paramMessage.get(i));
            this.uz.add(localObject1);
            this.bz.add(Long.valueOf(((zmc)localObject1).messageRecord.shmsgseq));
            i += 1;
          }
          if ((this.uz.size() < 15) && (!this.Hf) && (this.cdJ < 4))
          {
            this.cdJ += 1;
            this.Lj = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.i("C2CMessageSearchDialog", 2, "handleMessage, retry to accumulate more messages for one-screen-display,retryGetMore = " + this.cdJ + ",loadType: " + j);
            }
            Fp(j);
            return true;
          }
          if (!this.Hf) {
            if (this.cdJ >= 4) {
              break label1530;
            }
          }
          label1530:
          for (bool = this.Hf;; bool = true)
          {
            this.Hf = bool;
            this.cdJ = 0;
            if (j != 1) {
              break label1637;
            }
            bA(0, null);
            if (this.uz.size() != 0) {
              break label1536;
            }
            if (QLog.isColorLevel()) {
              QLog.d("C2CMessageSearchDialog", 2, "LOAD_REFRESH, no result at cloud, load local msg, mIsComplete: " + this.Hf);
            }
            this.cdG = 0;
            this.Lj = System.currentTimeMillis();
            this.a.j(this.Lj, this.ban, 1);
            break;
          }
          label1536:
          if (QLog.isColorLevel()) {
            QLog.d("C2CMessageSearchDialog", 2, "LOAD_REFRESH, has result at cloud size: " + this.uz.size() + ", start merge local msg, mIsComplete: " + this.Hf);
          }
          this.a.U(this.ban, this.Lj);
          anot.a(this.app, "CliOper", "", "", "0X8005FC2", "0X8005FC2", 0, 0, "", "", "", "");
          continue;
          label1637:
          if (QLog.isColorLevel()) {
            QLog.d("C2CMessageSearchDialog", 2, " LOAD_MORE&LOAD_MSG_IN_CLOUD, has rsult at cloud size: " + this.uz.size() + ", mIsComplete: " + this.Hf);
          }
          if (this.brC) {
            anot.a(this.app, "CliOper", "", "", "0X8005FCC", "0X8005FCC", 0, (int)(System.currentTimeMillis() - this.Lj), "", "", "", "");
          }
          this.a.a(this.uz, 4, this.Hf, 1);
          this.a.notifyDataSetChanged();
          this.uz.clear();
          continue;
          paramMessage = (HashMap)paramMessage.obj;
          localObject1 = (String)paramMessage.get("keyword");
          l = ((Long)paramMessage.get("sequence")).longValue();
          if (QLog.isColorLevel()) {
            QLog.i("C2CMessageSearchDialog", 2, "handleMessage : MSG_TYPE_QUERY_LOCAL_DONE lastRequestKeyWord = " + (String)localObject1 + ",currentKeyword = " + this.ban + ",searchSequence = " + l + ",mCurrentSequence = " + this.Lj + ",mIsComplete: " + this.Hf);
          }
          if ((!this.brB) || (this.Lj != l) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(this.ban))) {
            return true;
          }
          if ((l == this.Lj) && (this.ban.equals(localObject1)))
          {
            anot.a(this.app, "CliOper", "", "", "0X8005FC6", "0X8005FC6", 0, (int)(System.currentTimeMillis() - this.Lj), "", "", "", "");
            this.gV = false;
            this.footerView.setVisibility(8);
            this.hI.setVisibility(8);
            this.a.ac(this.uz, this.Hf);
            if ((this.Hf) && (this.a.getCount() < 20))
            {
              this.MS.setText(acfp.m(2131703337));
              this.hI.findViewById(2131373660).setVisibility(8);
              this.hI.setVisibility(0);
              this.footerView.setVisibility(0);
            }
            this.a.notifyDataSetChanged();
            this.F.setAdapter(this.a);
            this.F.setSelection(0);
            this.uz.clear();
            continue;
            localObject1 = (HashMap)paramMessage.obj;
            paramMessage = (String)((HashMap)localObject1).get("keyword");
            l = ((Long)((HashMap)localObject1).get("sequence")).longValue();
            localObject1 = (List)((HashMap)localObject1).get("data");
            if (QLog.isColorLevel()) {
              QLog.i("C2CMessageSearchDialog", 2, "handleMessage: MERGE_LOCAL_MESSAGES_AND_CLOUD_MESSAGES reqKeyWord = " + paramMessage + ",currentKeyword = " + this.ban + ",searchSequence = " + l + ",mCurrentSequence = " + this.Lj + ",mIsComplete: " + this.Hf);
            }
            if ((TextUtils.isEmpty(paramMessage)) || (!this.brB) || (this.Lj != l) || (!this.ban.equals(paramMessage))) {
              return true;
            }
            if ((l == this.Lj) && (this.ban.equals(paramMessage)))
            {
              this.gV = false;
              this.footerView.setVisibility(8);
              this.hI.setVisibility(8);
              this.a.ac((List)localObject1, this.Hf);
              this.a.notifyDataSetChanged();
              this.F.setAdapter(this.a);
              this.F.setSelection(0);
              this.uz.clear();
            }
          }
        }
      }
    }
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
 * Qualified Name:     zli
 * JD-Core Version:    0.7.0.1
 */