import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.AdDislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.NegativeChildrenLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class auua
  extends autw
  implements View.OnClickListener
{
  ArrayList<DislikeInfo> EA = new ArrayList();
  ArrayList<DislikeInfo> EB = new ArrayList();
  ArrayList<DislikeInfo> EC = new ArrayList();
  ArrayList<DislikeInfo> ED = new ArrayList();
  View Lo;
  View Lp;
  View Lq;
  View Lr;
  private auua.a a;
  autw.b b = new auub(this);
  HashMap<Integer, DislikeInfo> qm = new HashMap();
  
  public auua(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(2131560435, null);
    setContentView(this.mContentView);
    setHeight(-2);
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    try
    {
      initUI(this.mContentView);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  protected int OO()
  {
    int j = this.EA.size();
    int i = j;
    if (this.EB.size() > j) {
      i = this.EB.size();
    }
    j = i;
    if (this.EC.size() > i) {
      j = this.EC.size();
    }
    i = j;
    if (this.ED.size() > j) {
      i = this.ED.size();
    }
    j = i;
    if (i > 6) {
      j = 6;
    }
    return j;
  }
  
  protected int OP()
  {
    if (this.etI <= 0)
    {
      iU(this.Hm);
      this.etI = this.Hm.getMeasuredHeight();
    }
    int i = (OO() + 1) * this.etK + this.etI;
    iU(this.Lo);
    int j = this.Lo.getMeasuredHeight() * this.etL + this.etI;
    if (i > j) {
      return i;
    }
    return j;
  }
  
  public void a(auua.a parama)
  {
    this.jdField_a_of_type_Auua$a = parama;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, ArrayList<AdDislikeInfo> paramArrayList)
  {
    clearData();
    this.etM = paramInt1;
    this.mChannelID = paramInt2;
    this.aLh = paramInt3;
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramArrayList.next();
        if (localAdDislikeInfo != null)
        {
          if (localAdDislikeInfo.id != 0) {
            this.qm.put(Integer.valueOf(localAdDislikeInfo.id), localAdDislikeInfo);
          }
          for (;;)
          {
            localStringBuilder.append(localAdDislikeInfo.toString());
            localStringBuilder.append("\n");
            break;
            switch (localAdDislikeInfo.aRs)
            {
            default: 
              break;
            case 1: 
              this.EA.add(localAdDislikeInfo);
              break;
            case 2: 
              this.EB.add(localAdDislikeInfo);
              break;
            case 3: 
              this.EC.add(localAdDislikeInfo);
            }
          }
        }
      }
    }
    if (this.qm.containsKey(Integer.valueOf(1)))
    {
      paramArrayList = (DislikeInfo)this.qm.get(Integer.valueOf(1));
      boolean bool = true;
      if (this.EA.isEmpty())
      {
        this.EA.add(paramArrayList);
        bool = false;
      }
      a(this.EA, this.Lo, 2130842509, paramArrayList.agQ, bool);
      if (!this.qm.containsKey(Integer.valueOf(2))) {
        break label565;
      }
      paramArrayList = (DislikeInfo)this.qm.get(Integer.valueOf(2));
      bool = true;
      if (this.EB.isEmpty())
      {
        this.EB.add(paramArrayList);
        bool = false;
      }
      a(this.EB, this.Lp, 2130842511, paramArrayList.agQ, bool);
      label352:
      if (!this.qm.containsKey(Integer.valueOf(3))) {
        break label592;
      }
      paramArrayList = (DislikeInfo)this.qm.get(Integer.valueOf(3));
      bool = true;
      if (this.EC.isEmpty())
      {
        this.EC.add(paramArrayList);
        bool = false;
      }
      a(this.EC, this.Lq, 2130842502, paramArrayList.agQ, bool);
    }
    for (;;)
    {
      paramArrayList = new DislikeInfo();
      paramArrayList.agQ = acfp.m(2131707576);
      paramArrayList.type = 0;
      this.ED.add(paramArrayList);
      a(this.ED, this.Lr, 2130842493, paramArrayList.agQ, false);
      this.Lr.findViewById(2131369517).setVisibility(0);
      ewZ();
      if (QLog.isColorLevel()) {
        QLog.d("KandianNegativeWindowForAd", 1, "setData:" + localStringBuilder.toString());
      }
      return;
      a(new ArrayList(), this.Lo, 2130842509, acfp.m(2131707560), false);
      break;
      label565:
      a(new ArrayList(), this.Lp, 2130842511, acfp.m(2131707563), false);
      break label352;
      label592:
      a(new ArrayList(), this.Lq, 2130842502, acfp.m(2131707564), false);
    }
  }
  
  public void b(lis paramlis, ArrayList<AdDislikeInfo> paramArrayList)
  {
    int k = 0;
    Object localObject = null;
    int j;
    int i;
    if (paramlis != null)
    {
      j = paramlis.mPosition;
      i = paramlis.mChannelID;
    }
    for (paramlis = paramlis.a();; paramlis = localObject)
    {
      if (paramlis != null) {
        k = kxm.a(paramlis);
      }
      b(j, i, k, paramArrayList);
      return;
      i = 0;
      j = 0;
    }
  }
  
  protected void clearData()
  {
    super.clearData();
    this.qm.clear();
    this.EA.clear();
    this.EB.clear();
    this.EC.clear();
    this.ED.clear();
  }
  
  protected void exb()
  {
    this.Ez.clear();
    y(this.EA.size(), this.Lo);
    y(this.EB.size(), this.Lp);
    y(this.EC.size(), this.Lq);
    y(this.ED.size(), this.Lr);
  }
  
  public void initUI(View paramView)
  {
    this.mh = ((LinearLayout)paramView.findViewById(2131365360));
    this.mg = ((LinearLayout)paramView.findViewById(2131371094));
    this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout = ((NegativeChildrenLayout)paramView.findViewById(2131364599));
    this.Hl = ((ImageView)paramView.findViewById(2131372264));
    this.Hm = ((ImageView)paramView.findViewById(2131372265));
    this.Lo = paramView.findViewById(2131372258);
    this.Lp = paramView.findViewById(2131372266);
    this.Lq = paramView.findViewById(2131372262);
    this.Lr = paramView.findViewById(2131372256);
    this.Lo.setOnClickListener(this);
    this.Lp.setOnClickListener(this);
    this.Lq.setOnClickListener(this);
    this.Lr.setOnClickListener(this);
    this.Lr.findViewById(2131378043).setVisibility(4);
    setBackgroundDrawable(new ColorDrawable());
    ((ImageView)paramView.findViewById(2131367119).findViewById(2131370351)).setOnClickListener(this);
    this.mScreenWidth = ((int)aqgz.hK());
    this.mScreenHeight = ((int)aqgz.hL());
    this.etJ = ((int)this.mContext.getResources().getDimension(2131299225));
    this.mWindowWidth = (this.mScreenWidth - this.etJ * 2);
    setWidth(this.mWindowWidth);
    this.etK = ((int)this.mContext.getResources().getDimension(2131299201));
    setOnDismissListener(new auuc(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getTag() != null)
      {
        iV(paramView);
        showToast();
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.EA, ((DislikeInfo)this.qm.get(Integer.valueOf(1))).agQ, this.b);
        Wh(true);
        continue;
        if (paramView.getTag() != null)
        {
          iV(paramView);
          showToast();
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.EA, ((DislikeInfo)this.qm.get(Integer.valueOf(2))).agQ, this.b);
          Wh(true);
          continue;
          if (paramView.getTag() != null)
          {
            iV(paramView);
            showToast();
          }
          else
          {
            this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.EA, ((DislikeInfo)this.qm.get(Integer.valueOf(3))).agQ, this.b);
            Wh(true);
            continue;
            if (this.jdField_a_of_type_Auua$a != null) {
              this.jdField_a_of_type_Auua$a.aNT();
            }
            dismiss();
            continue;
            Wh(false);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aNT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auua
 * JD-Core Version:    0.7.0.1
 */