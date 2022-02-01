import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class yvb
  extends BaseAdapter
{
  private View.OnClickListener em = new yvc(this);
  private View.OnClickListener en = new yvd(this);
  private QQAppInterface mApp;
  private Context mContext;
  private List<RecommendTroopItem> tt = new ArrayList();
  
  public yvb(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
  }
  
  public static View a(Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131561746, null);
    yvb.a locala = new yvb.a();
    locala.itemView = localView;
    locala.uE = ((ImageView)localView.findViewById(2131369937));
    if ((locala.uE instanceof ThemeImageView)) {
      ((ThemeImageView)locala.uE).setSupportMaskView(false);
    }
    locala.k = ((SingleLineTextView)localView.findViewById(2131381005));
    locala.eo = ((Button)localView.findViewById(2131363896));
    locala.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)localView.findViewById(2131363297));
    locala.b = ((TroopLabelLayout)localView.findViewById(2131363304));
    locala.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)localView.findViewById(2131380646));
    locala.LU = ((TextView)localView.findViewById(2131380644));
    locala.eo.setOnClickListener(paramOnClickListener2);
    localView.setOnClickListener(paramOnClickListener1);
    localView.setTag(locala);
    if (paramOnClickListener3 != null)
    {
      locala.LU.setOnClickListener(paramOnClickListener3);
      locala.LU.setVisibility(0);
      localView.setTag(-3, Integer.valueOf(wja.dp2px(100.0F, paramContext.getResources())));
      return localView;
    }
    locala.LU.setOnClickListener(null);
    locala.LU.setVisibility(8);
    localView.setTag(-3, null);
    return localView;
  }
  
  public static void a(yvb.a parama, RecommendTroopItem paramRecommendTroopItem, Drawable paramDrawable)
  {
    if ((parama == null) || (paramRecommendTroopItem == null))
    {
      QLog.d("RecommendTroop", 1, "viewHolder == null || troopItem == null");
      return;
    }
    parama.uE.setImageDrawable(paramDrawable);
    parama.k.setText(paramRecommendTroopItem.name);
    parama.k.setContentDescription(paramRecommendTroopItem.name);
    if (paramRecommendTroopItem.activity > 0)
    {
      parama.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(0);
      parama.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setHotLevel(paramRecommendTroopItem.activity);
      paramDrawable = joa.a(paramRecommendTroopItem);
      if ((paramDrawable == null) || (paramDrawable.size() <= 0)) {
        break label275;
      }
      parama.b.setVisibility(0);
      parama.b.setLabelType(1);
      parama.b.setAutoCreateDistanceTextView(true);
      parama.b.O(paramDrawable);
      label122:
      if ((!paramRecommendTroopItem.isJoined()) && (!paramRecommendTroopItem.hasRequestJoin)) {
        break label300;
      }
      parama.eo.setEnabled(false);
      if (!paramRecommendTroopItem.hasRequestJoin) {
        break label287;
      }
      parama.eo.setText(2131701841);
      label160:
      parama.eo.setMinWidth(aqnm.dip2px(60.0F));
      parama.eo.setMinWidth(aqnm.dip2px(29.0F));
      parama.eo.setPadding(0, parama.eo.getPaddingTop(), 0, parama.eo.getPaddingBottom());
      parama.eo.setBackgroundDrawable(null);
      label215:
      if (!TextUtils.isEmpty(paramRecommendTroopItem.intro)) {
        break label377;
      }
      parama.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText("");
    }
    for (;;)
    {
      parama.eo.setTag(-1, paramRecommendTroopItem);
      parama.LU.setTag(-1, paramRecommendTroopItem);
      parama.itemView.setTag(-1, paramRecommendTroopItem);
      return;
      parama.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(8);
      break;
      label275:
      parama.b.setVisibility(8);
      break label122;
      label287:
      parama.eo.setText(2131701842);
      break label160;
      label300:
      parama.eo.setEnabled(true);
      parama.eo.setText(2131701840);
      parama.eo.setMinWidth(0);
      parama.eo.setMinHeight(0);
      int i = aqnm.dip2px(16.0F);
      parama.eo.setPadding(i, parama.eo.getPaddingTop(), i, parama.eo.getPaddingBottom());
      parama.eo.setBackgroundResource(2130839559);
      break label215;
      label377:
      parama.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new aofk(paramRecommendTroopItem.intro, 11, 16));
    }
  }
  
  public RecommendTroopItem a(int paramInt)
  {
    return (RecommendTroopItem)this.tt.get(paramInt);
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem) {}
  
  protected void b(RecommendTroopItem paramRecommendTroopItem) {}
  
  public void bF(List<RecommendTroopItem> paramList)
  {
    if (paramList != null)
    {
      this.tt.clear();
      this.tt.addAll(paramList);
    }
  }
  
  protected void c(RecommendTroopItem paramRecommendTroopItem) {}
  
  public int getCount()
  {
    return this.tt.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof yvb.a))) {
      paramView = a(this.mContext, this.en, this.em, null);
    }
    for (;;)
    {
      yvb.a locala = (yvb.a)paramView.getTag();
      RecommendTroopItem localRecommendTroopItem = a(paramInt);
      a(locala, localRecommendTroopItem, aqdj.a(this.mApp, 4, localRecommendTroopItem.uin));
      c(localRecommendTroopItem);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  protected abstract int xD();
  
  protected abstract int xE();
  
  protected abstract int xF();
  
  public void zm(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    RecommendTroopItem localRecommendTroopItem;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.tt == null) || (this.tt.size() <= 0)) {}
        localIterator = this.tt.iterator();
      } while (!localIterator.hasNext());
      localRecommendTroopItem = (RecommendTroopItem)localIterator.next();
    } while (!paramString.equals(localRecommendTroopItem.uin));
    localRecommendTroopItem.hasRequestJoin = true;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroop", 2, "updateJoinStatus, troopUin: " + paramString);
    }
    notifyDataSetChanged();
  }
  
  public static class a
  {
    TextView LU;
    TroopActiveLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout;
    FolderTextView jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView;
    TroopLabelLayout b;
    Button eo;
    View itemView;
    SingleLineTextView k;
    ImageView uE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvb
 * JD-Core Version:    0.7.0.1
 */