import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.HistorySearchEntryModel.4;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amjp
  extends amjh<LinearLayout>
  implements Handler.Callback
{
  public List<amjz> FD;
  protected XListView R;
  private TextView Ys;
  private TextView Yt;
  private TextView Yu;
  private TextView Yv;
  protected abeb a;
  protected amjp.a a;
  public aurf b;
  protected boolean cCX;
  protected int fromType;
  private QQAppInterface mApp;
  private Context mContext;
  private TextView mGuideText;
  private AdapterView.c mOnItemClickListener = new amjt(this);
  
  public amjp(int paramInt)
  {
    super(paramInt);
  }
  
  public amjp(int paramInt, amjp.a parama)
  {
    super(paramInt);
    this.jdField_a_of_type_Amjp$a = parama;
  }
  
  private int c(List<amjz> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return -1;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (((SearchHistory)((amjz)this.FD.get(i)).R()).getId() == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private boolean e(SearchHistory paramSearchHistory)
  {
    aclj localaclj = (aclj)this.mApp.getManager(55);
    if ((localaclj == null) || (paramSearchHistory == null)) {
      return false;
    }
    return localaclj.d(paramSearchHistory);
  }
  
  private List<amjz> gd()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = (aclj)this.mApp.getManager(55);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((aclj)localObject).cC().iterator();
    while (((Iterator)localObject).hasNext())
    {
      SearchHistory localSearchHistory = (SearchHistory)((Iterator)localObject).next();
      localArrayList.add(new amjl(this.mApp, localSearchHistory));
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      QLog.d("searchUtils", 2, "initSearchHistoryData() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private void refreshData()
  {
    ThreadManager.postImmediately(new HistorySearchEntryModel.4(this), null, true);
  }
  
  public LinearLayout a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.b = new aurf(this);
    paramContext = (LinearLayout)LayoutInflater.from(this.mContext).inflate(2131563294, null);
    this.R = ((XListView)paramContext.findViewById(2131377840));
    this.R.setVisibility(8);
    paramViewGroup = new AbsListView.LayoutParams(-1, aqcx.dip2px(this.mContext, 7.0F));
    this.Ys = new TextView(this.mContext);
    this.Ys.setLayoutParams(paramViewGroup);
    paramViewGroup = (LinearLayout)LayoutInflater.from(this.mContext).inflate(2131563016, null);
    this.Yt = ((TextView)paramViewGroup.findViewById(2131363701));
    this.Yu = ((TextView)paramViewGroup.findViewById(2131363702));
    this.Yv = ((TextView)paramViewGroup.findViewById(2131363703));
    this.R.addFooterView(paramViewGroup);
    this.Ys.setBackgroundResource(2130851241);
    this.jdField_a_of_type_Abeb = new abeb(paramQQAppInterface, this.mContext, this.R, null, new amjq(this), new amjr(this), false);
    this.R.setOnTouchListener(new amjs(this));
    this.mGuideText = ((TextView)paramContext.findViewById(2131377824));
    return paramContext;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what) {
      if ((this.FD != null) && (this.FD.size() > 0))
      {
        this.jdField_a_of_type_Abeb.cBh();
        this.jdField_a_of_type_Abeb.hS(this.FD);
        if (this.FD.size() > 0)
        {
          if (!this.cCX)
          {
            this.cCX = true;
            amxk.b("home_page", "exp_history", new String[] { "" + this.FD.size() });
            amub.a(this.mApp, 0, SearchEntryFragment.jf(this.bms), "0X8009D18", 0, 0, null, null);
          }
          this.Ys.setVisibility(0);
        }
        this.mGuideText.setVisibility(8);
        if (this.jdField_a_of_type_Amjp$a != null)
        {
          paramMessage = this.jdField_a_of_type_Amjp$a;
          if (this.FD != null) {
            break label246;
          }
          i = 0;
          paramMessage.Uv(i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("searchUtils", 2, "load history data finish");
        }
        setListViewHeightBasedOnChildren();
        this.R.setVisibility(0);
      }
    }
    label246:
    while (paramMessage.what != 3) {
      for (;;)
      {
        return true;
        if ((SearchEntryFragment.dX("kSearchMessageTab") == this.bms) || (SearchEntryFragment.dX("kSearchContactTab") == this.bms))
        {
          this.mGuideText.setVisibility(0);
          continue;
          i = this.FD.size();
        }
      }
    }
    long l = ((Long)paramMessage.obj).longValue();
    int i = c(this.FD, l);
    if (i != -1)
    {
      paramMessage = (SearchHistory)((amjz)this.FD.remove(i)).R();
      if (this.FD.size() <= 0)
      {
        this.Ys.setVisibility(8);
        this.Yt.setVisibility(8);
        this.Yu.setVisibility(8);
        this.Yv.setVisibility(8);
      }
      if (paramMessage == null) {
        break label554;
      }
      if (paramMessage.type == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      label377:
      anot.a(null, "CliOper", "", "", "0X8007620", "0X8007620", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Abeb.cBh();
      this.jdField_a_of_type_Abeb.hS(this.FD);
      amub.a(this.mApp, 0, SearchEntryFragment.jf(this.bms), "0X8009D1A", i, 0, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "delete history data finish : troopUin = " + paramMessage.troopUin + "displayname = " + paramMessage.displayName);
      }
      for (;;)
      {
        setListViewHeightBasedOnChildren();
        this.R.setVisibility(0);
        break;
        if ((paramMessage.type != 1) && (paramMessage.type != 3000)) {
          break label554;
        }
        i = 2;
        break label377;
        if (QLog.isColorLevel()) {
          QLog.d("searchUtils", 2, "delete history data error");
        }
      }
      label554:
      i = 0;
    }
  }
  
  public void initData()
  {
    super.initData();
    this.R.setAdapter(this.jdField_a_of_type_Abeb);
    refreshData();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Abeb != null) {
      this.jdField_a_of_type_Abeb.clear();
    }
  }
  
  public void refresh()
  {
    refreshData();
  }
  
  public void setListViewHeightBasedOnChildren()
  {
    if ((this.R == null) || (this.jdField_a_of_type_Abeb == null)) {
      return;
    }
    int k = View.MeasureSpec.makeMeasureSpec(this.R.getWidth(), 0);
    Object localObject = null;
    int i = 0;
    int j = 0;
    while (j < this.jdField_a_of_type_Abeb.getCount())
    {
      localObject = this.jdField_a_of_type_Abeb.getView(j, (View)localObject, this.R);
      if (j == 0) {
        ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(k, -2));
      }
      ((View)localObject).measure(k, 0);
      i += ((View)localObject).getMeasuredHeight();
      j += 1;
    }
    j = i;
    if (this.jdField_a_of_type_Abeb.getCount() > 0) {
      j = i + rpq.dip2px(this.mContext, 20.0F);
    }
    localObject = this.R.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (this.R.getDividerHeight() * (this.jdField_a_of_type_Abeb.getCount() - 1) + j);
    this.R.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public static abstract interface a
  {
    public abstract void Uv(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjp
 * JD-Core Version:    0.7.0.1
 */