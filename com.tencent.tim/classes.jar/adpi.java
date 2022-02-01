import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiAppPanel.2;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class adpi
{
  private static int cIZ = 3;
  private adpi.a jdField_a_of_type_Adpi$a;
  private adpi.b jdField_a_of_type_Adpi$b;
  private ArkAppRootLayout jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout;
  private wyw.b jdField_b_of_type_Wyw$b = new adpj(this);
  private boolean bQh = true;
  private BaseChatPie jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ArkAppView jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private Button cd;
  private int curIndex;
  AdapterView.OnItemClickListener i = new adpm(this);
  private RelativeLayout jI;
  private ArrayList<wyv> mf;
  private HorizontalListView s;
  private ArrayList<Boolean> uG;
  private List<adqa> yp;
  
  public adpi(BaseChatPie paramBaseChatPie)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private void GF(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAiAppPanel", 2, "initArkApp.chatPie == null!");
      }
    }
    while ((this.yp == null) || (this.yp.size() <= 0) || (this.yp.size() <= this.curIndex)) {
      return;
    }
    Object localObject1 = (adqa)this.yp.get(this.curIndex);
    Object localObject2 = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext;
    int j = BaseChatItemLayout.bOh;
    int m = XPanelContainer.aLe;
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.getParent() != null)) {
      j = ((View)this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.getParent()).getMeasuredWidth();
    }
    for (;;)
    {
      localObject2 = (wyv)this.mf.get(this.curIndex);
      ((wyv)localObject2).a(((adqa)localObject1).appName, ((adqa)localObject1).appView, ((adqa)localObject1).appVer, ((adqa)localObject1).meta, adqr.getDensity(), null, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      Object localObject3;
      int k;
      if (Boolean.FALSE.equals(this.uG.get(this.curIndex)))
      {
        adqu.b(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, "ShowView", ((adqa)localObject1).appName, null, adqu.cJo, 0, 0);
        if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app != null)
        {
          localObject3 = (adqx)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getBusinessHandler(95);
          if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a != null)
          {
            localObject3 = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a.getText();
            if (localObject3 != null) {
              break label451;
            }
          }
        }
        this.uG.set(this.curIndex, Boolean.TRUE);
      }
      else
      {
        if (!paramBoolean) {
          break label460;
        }
        k = MessageForArkApp.dp2px(36.0F);
        this.jI.setVisibility(0);
      }
      for (;;)
      {
        m -= k;
        ((wyv)localObject2).setViewRect(((wyv)localObject2).descaleRect(new Rect(0, 0, j, m)));
        ((wyv)localObject2).setFixSize(j, m);
        ((wyv)localObject2).setMaxSize(j, m);
        ((wyv)localObject2).a(this.jdField_b_of_type_Wyw$b);
        QLog.d("ArkAiAppPanel", 2, String.format("ArkAiAppPanel.initArkApp app:%s view%s width:%d height:%d.", new Object[] { ((adqa)localObject1).appName, ((adqa)localObject1).appView, Integer.valueOf(j), Integer.valueOf(m) }));
        this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView.a((wyw)localObject2, null);
        localObject1 = new RelativeLayout.LayoutParams(this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView.getLayoutParams());
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, k);
        this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        return;
        label451:
        localObject3.toString();
        break;
        label460:
        this.jI.setVisibility(8);
        k = 0;
      }
    }
  }
  
  private void cTC()
  {
    if ((this.yp == null) || (this.yp.size() <= 0)) {
      return;
    }
    if (this.mf == null)
    {
      this.mf = new ArrayList();
      this.uG = new ArrayList();
      localObject = new ArrayList();
      if (this.yp != null) {
        break label214;
      }
    }
    label214:
    for (int j = 0;; j = this.yp.size())
    {
      int k = 0;
      while ((k < cIZ) && (k < j))
      {
        ((ArrayList)localObject).add(this.yp.get(k));
        wyv localwyv = new wyv();
        localwyv.a = new ArkAppMessage.Config();
        localwyv.a.round = Integer.valueOf(1);
        this.mf.add(localwyv);
        this.uG.add(Boolean.FALSE);
        k += 1;
      }
      j = 0;
      while (j < this.mf.size())
      {
        localObject = (wyv)this.mf.get(j);
        if (localObject != null) {
          ((wyv)localObject).doOnEvent(2);
        }
        j += 1;
      }
      this.mf.clear();
      this.uG.clear();
      break;
    }
    this.jdField_a_of_type_Adpi$a.bJ((List)localObject);
    Object localObject = this.s.getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    if ((this.curIndex < 0) || (this.curIndex >= this.yp.size())) {
      this.curIndex = 0;
    }
    this.s.setSelection(this.curIndex);
    this.s.postDelayed(new ArkAiAppPanel.2(this), 500L);
  }
  
  private void initUI()
  {
    Context localContext = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)LayoutInflater.from(localContext).inflate(2131559435, null));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setDisableParentReturn(true);
    this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362952));
    this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView);
    this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new adpk(this));
    this.s = ((HorizontalListView)this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362954));
    this.s.setOnItemClickListener(this.i);
    this.jdField_a_of_type_Adpi$a = new adpi.a(localContext);
    this.s.setAdapter(this.jdField_a_of_type_Adpi$a);
    this.cd = ((Button)this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362966));
    this.cd.setOnClickListener(new adpl(this));
    this.jI = ((RelativeLayout)this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362968));
  }
  
  public void a(List<adqa> paramList, int paramInt, adpi.b paramb)
  {
    this.jdField_a_of_type_Adpi$b = paramb;
    this.yp = paramList;
    this.curIndex = paramInt;
    if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.vm() != 22)
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.k(Integer.valueOf(22));
      return;
    }
    cTC();
    this.bQh = true;
    GF(this.bQh);
  }
  
  public View bT()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout == null) {
      initUI();
    }
    if ((this.yp == null) || (this.yp.size() <= 0)) {
      return null;
    }
    this.bQh = true;
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout;
  }
  
  public void cTD()
  {
    if (this.mf != null)
    {
      int j = 0;
      while (j < this.mf.size())
      {
        wyv localwyv = (wyv)this.mf.get(j);
        if (localwyv != null) {
          localwyv.doOnEvent(2);
        }
        j += 1;
      }
      this.mf.clear();
      this.uG.clear();
    }
  }
  
  public void cTE()
  {
    cTC();
    GF(this.bQh);
  }
  
  public void onDestroy()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView != null) {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(null);
    }
    if (this.yp != null)
    {
      int j = 0;
      while (j < this.yp.size())
      {
        adqa localadqa = (adqa)this.yp.get(j);
        if (localadqa != null) {
          adqq.GC(localadqa.appName);
        }
        j += 1;
      }
      if (this.jdField_a_of_type_Adpi$b != null) {
        this.jdField_a_of_type_Adpi$b.jC(this.yp);
      }
      this.yp = null;
    }
    cTD();
  }
  
  class a
    extends BaseAdapter
  {
    private Context mContext;
    private List<adqa> mData;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
      this.mData = new ArrayList();
    }
    
    public adqa a(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= this.mData.size())) {
        return null;
      }
      return (adqa)this.mData.get(paramInt);
    }
    
    public void bJ(List<adqa> paramList)
    {
      this.mData.clear();
      this.mData.addAll(paramList);
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      return this.mData.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      if (paramView == null)
      {
        paramView = new adpi.a.a();
        paramView.root = new RelativeLayout(this.mContext);
        paramView.root.setBackgroundResource(2130845794);
        localObject1 = new ViewGroup.LayoutParams(MessageForArkApp.dp2px(50.0F), -1);
        paramView.root.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramView.yl = new ImageView(this.mContext);
        localObject1 = new RelativeLayout.LayoutParams(MessageForArkApp.dp2px(28.0F), MessageForArkApp.dp2px(25.0F));
        ((RelativeLayout.LayoutParams)localObject1).addRule(13);
        paramView.root.addView(paramView.yl, (ViewGroup.LayoutParams)localObject1);
        localObject1 = paramView.root;
        ((View)localObject1).setTag(paramView);
      }
      for (;;)
      {
        Object localObject2 = a(paramInt);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((adqa)localObject2).appPath))) {
          ArkAppCacheMgr.getAppIcon(((adqa)localObject2).appName, new adpn(this, paramView));
        }
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject2 = (adpi.a.a)paramView.getTag();
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
    }
    
    public class a
    {
      RelativeLayout root;
      ImageView yl;
      
      public a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void jC(List<adqa> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpi
 * JD-Core Version:    0.7.0.1
 */