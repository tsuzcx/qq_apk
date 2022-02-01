import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class aoze
  extends ausj
  implements View.OnClickListener
{
  View Ie;
  apbc.c a;
  QQAppInterface app = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  long aqE = 0L;
  apbc b = (apbc)this.app.getManager(32);
  int dSi = 0;
  Activity mActivity;
  ImageView mCloseBtn;
  XListView mListView;
  
  public aoze(Activity paramActivity, apbc.c paramc)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
    this.a = paramc;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() != null)
    {
      aoze.b localb = (aoze.b)paramView.getTag();
      this.b.SH(localb.troopUin);
      anot.a(this.app, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong", 0, 0, "" + this.b.a().createFrom, "" + this.dSi, "", "");
      this.b.dYx();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (2131365520 == paramView.getId())
      {
        if (System.currentTimeMillis() - this.aqE > 1500L)
        {
          this.aqE = System.currentTimeMillis();
          this.b.a((BaseActivity)this.mActivity, this.a);
        }
        anot.a(this.app, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong_new", 0, 0, "" + this.b.a().createFrom, "" + this.dSi, "", "");
      }
      else if (2131364687 == paramView.getId())
      {
        this.b.dYx();
        dismiss();
      }
    }
  }
  
  public void show()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131560785, null);
    if ("1103".equals(ThemeUtil.curThemeId)) {
      localLinearLayout.setBackgroundColor(-15921907);
    }
    addView(localLinearLayout);
    Object localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    this.mListView = ((XListView)localLinearLayout.findViewById(2131377856));
    localObject = (apbc)this.app.getManager(32);
    if ((((apbc)localObject).BN == null) || (((apbc)localObject).BN.size() == 0))
    {
      dismiss();
      ((apbc)localObject).dYx();
      this.mActivity.finish();
      return;
    }
    localObject = new aoze.a(((apbc)localObject).BN);
    this.mListView.setAdapter((ListAdapter)localObject);
    this.mListView.setMaxHeight(wja.dp2px(200.0F, getContext().getResources()));
    this.Ie = localLinearLayout.findViewById(2131365520);
    this.Ie.setOnClickListener(this);
    int i = this.b.BN.size();
    localObject = String.format(acfp.m(2131709112), new Object[] { Integer.valueOf(i) });
    ((TextView)localLinearLayout.findViewById(2131377235)).setText((CharSequence)localObject);
    localObject = this.b.a();
    this.dSi = (((apbc.d)localObject).HD.size() - 1);
    String str = String.format(acfp.m(2131709118), new Object[] { Integer.valueOf(this.dSi) });
    ((TextView)this.Ie.findViewById(2131377949)).setText(str);
    ((SingleLineTextView)this.Ie.findViewById(2131380363)).setText(((apbc.d)localObject).cnN);
    this.mCloseBtn = ((ImageView)localLinearLayout.findViewById(2131364687));
    this.mCloseBtn.setOnClickListener(this);
    super.show();
    anot.a(this.app, "dc00899", "Grp_create_new", "", "create_page", "exp_fuyong", 0, 0, "" + ((apbc.d)localObject).createFrom, "" + this.dSi, "", "");
  }
  
  class a
    extends BaseAdapter
  {
    List<TroopSearchLogic.a> mItems;
    
    a()
    {
      Object localObject;
      this.mItems = localObject;
    }
    
    public int getCount()
    {
      return this.mItems.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.mItems.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      aoze.b localb;
      TroopSearchLogic.a locala;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(aoze.this.getContext()).inflate(2131560786, null);
        localb = new aoze.b(aoze.this);
        localb.G = ((SingleLineTextView)paramView.findViewById(2131372190));
        localb.El = ((ImageView)paramView.findViewById(2131368427));
        localb.aal = ((TextView)paramView.findViewById(2131370129));
        localb.bd = paramView.findViewById(2131370458);
        paramView.setOnClickListener(aoze.this);
        paramView.setTag(localb);
        locala = (TroopSearchLogic.a)getItem(paramInt);
        localb.G.setText(locala.troopInfo.getTroopName());
        if (locala.troopInfo.lastMsgTime == 0L) {
          break label298;
        }
        localb.aal.setVisibility(0);
        localb.aal.setText(acfp.m(2131709114) + aale.a().t(locala.troopInfo.troopuin, locala.troopInfo.lastMsgTime));
        label200:
        if (!locala.troopInfo.hasSetTroopHead()) {
          break label387;
        }
      }
      label387:
      for (int i = 4;; i = 113)
      {
        aqdj localaqdj = aqdj.a(aoze.this.app, i, locala.troopInfo.troopuin, 1, aqdj.g(4, 1), aqdj.g(4, 1));
        localb.El.setImageDrawable(localaqdj);
        localb.troopUin = locala.troopInfo.troopuin;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localb = (aoze.b)paramView.getTag();
        break;
        label298:
        if (locala.troopInfo.troopCreateTime != 0L)
        {
          localb.aal.setVisibility(0);
          localb.aal.setText(acfp.m(2131709119) + aale.a().t(locala.troopInfo.troopuin, locala.troopInfo.troopCreateTime));
          break label200;
        }
        localb.aal.setVisibility(8);
        break label200;
      }
    }
  }
  
  class b
  {
    ImageView El;
    SingleLineTextView G;
    TextView aal;
    View bd;
    String troopUin;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoze
 * JD-Core Version:    0.7.0.1
 */