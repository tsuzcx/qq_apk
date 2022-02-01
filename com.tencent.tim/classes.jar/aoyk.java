import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class aoyk
  extends BaseAdapter
{
  public static final String cnw = acfp.m(2131703516);
  public static final String cnx = acfp.m(2131703517);
  protected NewTroopCateView a;
  protected QQAppInterface mApp;
  protected Context mContext;
  protected ArrayList<aozp.a> mDataList = new ArrayList();
  protected LayoutInflater mInflater;
  
  public aoyk(NewTroopCateView paramNewTroopCateView, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramNewTroopCateView.a;
    this.a = paramNewTroopCateView;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.mApp = paramQQAppInterface;
  }
  
  public int getCount()
  {
    return this.mDataList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mDataList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.mInflater.inflate(2131560781, null);
      paramView = new aoyk.b(this, localView);
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.a((aozp.a)this.mDataList.get(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      aoyk.b localb = (aoyk.b)paramView.getTag();
      localView = paramView;
      paramView = localb;
    }
  }
  
  public void setData(ArrayList<aozp.a> paramArrayList)
  {
    this.mDataList = paramArrayList;
    super.notifyDataSetChanged();
  }
  
  public static class a
  {
    View Ia;
    aozp.a a;
    View container;
    TextView description;
    View fO;
    ImageView icon;
    View.OnTouchListener onTouchListener = new aoyl(this);
    int position;
    TextView title;
    
    public a(View paramView, int paramInt)
    {
      this.container = paramView;
      this.position = paramInt;
      this.icon = ((ImageView)paramView.findViewById(2131381174));
      this.title = ((TextView)paramView.findViewById(2131381177));
      this.description = ((TextView)paramView.findViewById(2131381173));
      this.fO = paramView.findViewById(2131381175);
      this.Ia = paramView.findViewById(2131381178);
    }
    
    public void a(Context paramContext, aozp.a parama, View.OnClickListener paramOnClickListener)
    {
      this.description.setAlpha(1.0F);
      this.Ia.setTranslationY(0.0F);
      this.fO.setRotation(0.0F);
      this.container.setTag(this);
      this.title.setText(parama.name);
      this.title.setContentDescription(parama.name);
      this.a = parama;
      if (parama.iconResId != 0)
      {
        this.icon.setImageResource(parama.iconResId);
        this.description.setVisibility(8);
        if (!parama.cPt) {
          break label142;
        }
        this.fO.setVisibility(0);
      }
      for (;;)
      {
        this.container.setOnTouchListener(this.onTouchListener);
        this.container.setOnClickListener(paramOnClickListener);
        return;
        if (parama.iconResId == 0) {
          break;
        }
        this.icon.setImageResource(parama.iconResId);
        break;
        label142:
        this.fO.setVisibility(8);
      }
    }
  }
  
  public static class b
    implements View.OnClickListener
  {
    ArrayList<aozl> BG;
    ArrayList<aoyk.a> BH;
    View Ib;
    View Ic;
    aoyk jdField_a_of_type_Aoyk;
    aozl.a jdField_a_of_type_Aozl$a = new aoyn(this);
    TextView aak;
    aozp.a b;
    View.OnClickListener fX = new aoym(this);
    
    public b(aoyk paramaoyk, View paramView)
    {
      this.jdField_a_of_type_Aoyk = paramaoyk;
      this.Ib = paramView;
      this.aak = ((TextView)paramView.findViewById(2131370549));
      this.Ic = paramView.findViewById(2131365524);
      this.BH = new ArrayList();
      aoyk.a locala = new aoyk.a(paramView.findViewById(2131370551), 0);
      this.BH.add(locala);
      locala = new aoyk.a(paramView.findViewById(2131370552), 1);
      this.BH.add(locala);
      locala = new aoyk.a(paramView.findViewById(2131370553), 2);
      this.BH.add(locala);
      paramView = new aoyk.a(paramView.findViewById(2131370554), 3);
      this.BH.add(paramView);
      this.BG = new ArrayList(2);
      paramView = new aozl((ViewStub)this.Ib.findViewById(2131370555), paramaoyk.mContext, this.fX, this.jdField_a_of_type_Aozl$a);
      this.BG.add(paramView);
      paramaoyk = new aozl((ViewStub)this.Ib.findViewById(2131370556), paramaoyk.mContext, this.fX, this.jdField_a_of_type_Aozl$a);
      this.BG.add(paramaoyk);
    }
    
    public void a(aozp.a parama)
    {
      Object localObject = this.BG.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((aozl)((Iterator)localObject).next()).dYf();
      }
      this.b = parama;
      this.aak.setText(parama.name);
      this.aak.setContentDescription(parama.name);
      if (parama.name.equals(aoyk.cnw))
      {
        localObject = (TroopManager)this.jdField_a_of_type_Aoyk.mApp.getManager(52);
        boolean bool = ((TroopManager)localObject).abM();
        if (((TroopManager)localObject).a.aMd)
        {
          localObject = this.Ic;
          if (!bool) {
            break label181;
          }
        }
      }
      label181:
      for (int i = 8;; i = 0)
      {
        ((View)localObject).setVisibility(i);
        i = 0;
        while (i < parama.list.size())
        {
          ((aoyk.a)this.BH.get(i)).a(this.jdField_a_of_type_Aoyk.mContext, (aozp.a)parama.list.get(i), this);
          i += 1;
        }
      }
    }
    
    public void onClick(View paramView)
    {
      aoyk.a locala1 = (aoyk.a)paramView.getTag();
      if ((locala1 == null) || (locala1.a == null)) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        aozp.a locala = locala1.a;
        if (locala.id == null) {}
        for (Object localObject = "";; localObject = locala.id)
        {
          anot.a(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, (String)localObject, "", "", "");
          if (!locala.cPt) {
            break label118;
          }
          int i = locala1.position / 2;
          ((aozl)this.BG.get(i)).a(locala1, locala);
          break;
        }
        label118:
        if (locala.type == 1)
        {
          if ((locala.id.equals("20001")) || (locala.id.equals("20002")))
          {
            localObject = (TroopManager)this.jdField_a_of_type_Aoyk.mApp.getManager(52);
            if (((TroopManager)localObject).a.aMd)
            {
              ((TroopManager)localObject).cMX();
              this.Ic.setVisibility(8);
            }
            this.jdField_a_of_type_Aoyk.a.SC(locala.id);
            if (locala.id.equals("20001")) {}
            for (localObject = "Clk_type_2";; localObject = "Clk_type_3")
            {
              anot.a(this.jdField_a_of_type_Aoyk.mApp, "dc00899", "Grp_create_mobile", "", "chose_type", (String)localObject, 0, 0, "", "", "", "");
              break;
            }
          }
          if (locala.id.equals("20003"))
          {
            QLog.e("vip_pretty.createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
            aqlt.b(aeqz.c().kl("category"), this.jdField_a_of_type_Aoyk.mApp.getCurrentUin(), (Activity)this.jdField_a_of_type_Aoyk.mContext);
            anot.a(this.jdField_a_of_type_Aoyk.mApp, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
          }
          else
          {
            this.jdField_a_of_type_Aoyk.a.hS(locala.id, null);
          }
        }
        else
        {
          this.jdField_a_of_type_Aoyk.a.hS(locala.parentId, locala.id);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoyk
 * JD-Core Version:    0.7.0.1
 */