import NearbyGroup.GroupInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zcd
  extends abeg
  implements View.OnClickListener
{
  private zcd.a a;
  private QQAppInterface mApp;
  private Context mContext;
  private List<RecentRecommendTroopItem> tH = new ArrayList();
  
  public zcd(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean, zcd.a parama)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.a = parama;
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
  }
  
  private void a(zcd.b paramb, RecentRecommendTroopItem paramRecentRecommendTroopItem)
  {
    paramb.v.setText(paramRecentRecommendTroopItem.name);
    paramb.w.setText(paramRecentRecommendTroopItem.labelStr);
    paramb.es.setText(acfp.m(2131713765));
    paramb.pQ.setImageBitmap(a(4, paramRecentRecommendTroopItem.uin));
    paramb.a = paramRecentRecommendTroopItem;
    paramb.uin = paramRecentRecommendTroopItem.uin;
    paramb.type = 4;
    anot.a(null, "dc00899", "Grp_recom", "", "link_top", "exp_grp", 0, 0, paramRecentRecommendTroopItem.uin, paramRecentRecommendTroopItem.recomAlgol, "", "");
    if (AppSetting.enableTalkBack)
    {
      paramb.itemView.setContentDescription(paramRecentRecommendTroopItem.name + " " + paramRecentRecommendTroopItem.labelStr);
      paramb.v.setContentDescription(paramRecentRecommendTroopItem.name);
      paramb.w.setContentDescription(paramRecentRecommendTroopItem.labelStr);
    }
  }
  
  public void Bw(boolean paramBoolean)
  {
    notifyDataSetChanged();
  }
  
  public RecentRecommendTroopItem a(int paramInt)
  {
    return (RecentRecommendTroopItem)this.tH.get(paramInt);
  }
  
  public void bq(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public int getCount()
  {
    return this.tH.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new zcd.b();
      localView = LayoutInflater.from(this.mContext).inflate(2131559106, null);
      paramView.pQ = ((ImageView)localView.findViewById(2131361802));
      paramView.v = ((SingleLineTextView)localView.findViewById(2131372384));
      paramView.w = ((SingleLineTextView)localView.findViewById(2131377214));
      paramView.es = ((Button)localView.findViewById(2131377201));
      paramView.Ms = ((TextView)localView.findViewById(2131377211));
      paramView.uS = ((ImageView)localView.findViewById(2131365697));
      paramView.itemView = localView;
      ((ThemeImageView)paramView.pQ).setSupportMaskView(true);
      paramView.uS.setOnClickListener(this);
      paramView.es.setOnClickListener(this);
      localView.setOnClickListener(this);
      localView.setTag(paramView);
      paramView.uS.setTag(paramView);
      paramView.es.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      if (zce.bqF)
      {
        anot.a(null, "dc00899", "Grp_recom", "", "link_top", "exp", 0, 0, "", "", "", "");
        zce.bqF = false;
      }
      a((zcd.b)localObject, a(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (zcd.b)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void ha(List<RecentRecommendTroopItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.tH.clear();
    this.tH.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public boolean in(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.tH.iterator();
    while (localIterator.hasNext()) {
      if (((RecentRecommendTroopItem)localIterator.next()).uin.equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
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
      Object localObject1 = ((zcd.b)paramView.getTag()).a;
      Object localObject2 = "mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=" + ((RecentRecommendTroopItem)localObject1).uin + "&subsource_id=10019";
      Object localObject3 = new Intent(this.mContext, JoinGroupTransitActivity.class);
      ((Intent)localObject3).putExtra("source_scheme", (String)localObject2);
      this.mContext.startActivity((Intent)localObject3);
      anot.a(null, "dc00899", "Grp_recom", "", "link_top", "clk_add", 0, 0, ((RecentRecommendTroopItem)localObject1).uin, ((RecentRecommendTroopItem)localObject1).recomAlgol, "", "");
      continue;
      localObject1 = ((zcd.b)paramView.getTag()).a;
      localObject2 = new GroupInfo();
      try
      {
        ((GroupInfo)localObject2).lCode = Long.valueOf(((RecentRecommendTroopItem)localObject1).uin).longValue();
        ((GroupInfo)localObject2).strName = ((RecentRecommendTroopItem)localObject1).name;
        if (TextUtils.isEmpty(((RecentRecommendTroopItem)localObject1).recommendReason)) {}
        for (((GroupInfo)localObject2).strIntro = ((RecentRecommendTroopItem)localObject1).intro;; ((GroupInfo)localObject2).strIntro = ((RecentRecommendTroopItem)localObject1).recommendReason)
        {
          ((GroupInfo)localObject2).iMemberCnt = ((RecentRecommendTroopItem)localObject1).memberNum;
          localObject3 = joa.a((RecommendTroopItem)localObject1);
          if (localObject3 != null) {
            ((GroupInfo)localObject2).labels = ((ArrayList)localObject3);
          }
          ((GroupInfo)localObject2).strJoinSig = ((RecentRecommendTroopItem)localObject1).authSig;
          localObject2 = apuh.a(108, (GroupInfo)localObject2, 10020, false);
          apuh.a(this.mContext, (Bundle)localObject2, 2);
          anot.a(null, "dc00899", "Grp_recom", "", "link_top", "clk_grp", 0, 0, ((RecentRecommendTroopItem)localObject1).uin, ((RecentRecommendTroopItem)localObject1).recomAlgol, "", "");
          break;
        }
        localObject1 = (zcd.b)paramView.getTag();
        this.tH.remove(((zcd.b)localObject1).a);
        notifyDataSetChanged();
        if (this.a != null) {
          this.a.cI(((zcd.b)localObject1).a.uin, this.tH.size());
        }
        anot.a(null, "dc00899", "Grp_recom", "", "link_top", "clk_delete", 0, 0, ((zcd.b)localObject1).a.uin, ((zcd.b)localObject1).a.recomAlgol, "", "");
      }
      catch (Exception localException) {}
    }
  }
  
  public void onDestroy()
  {
    super.destroy();
    this.mContext = null;
    this.mApp = null;
  }
  
  public static abstract interface a
  {
    public abstract void cI(String paramString, int paramInt);
  }
  
  static class b
    extends abeg.a
  {
    public TextView Ms;
    public RecentRecommendTroopItem a;
    public Button es;
    public View itemView;
    public ImageView uS;
    public SingleLineTextView v;
    public SingleLineTextView w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcd
 * JD-Core Version:    0.7.0.1
 */