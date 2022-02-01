import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.RecommendsAdapter.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class zas
  extends abeg
  implements View.OnClickListener
{
  achg a;
  protected Runnable eK = new RecommendsAdapter.2(this);
  QQAppInterface mApp;
  Context mContext;
  XListView mListView;
  private AbsListView.e mOnScrollListener = new zat(this);
  Resources mRes;
  List<MayKnowRecommend> ta = new ArrayList();
  
  public zas(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mRes = this.mContext.getResources();
    this.mListView = paramXListView;
    this.a = ((achg)paramQQAppInterface.getManager(159));
    setOnScrollListener(this.mOnScrollListener);
  }
  
  private void a(zas.a parama)
  {
    Object localObject = parama.a.getRichStatus();
    StringBuilder localStringBuilder = new StringBuilder();
    if (((RichStatus)localObject).actionText != null) {
      localStringBuilder.append("actionText:").append(((RichStatus)localObject).actionText);
    }
    if (((RichStatus)localObject).dataText != null) {
      localStringBuilder.append("dataText:").append(((RichStatus)localObject).dataText);
    }
    localStringBuilder.append("plainText:");
    localObject = ((RichStatus)localObject).getPlainText();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localStringBuilder.append((String)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.i("contacts.RecommendsAdapter", 2, "updateRichStatus, content=" + localStringBuilder + "  uin:" + parama.a.uin);
    }
  }
  
  public void bo(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.mApp)
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.RecommendsAdapter", 2, "checkResetApp, need change app!");
      }
      this.mApp = paramQQAppInterface;
      bT(this.mApp);
      this.a = ((achg)paramQQAppInterface.getManager(159));
    }
  }
  
  public void ckZ()
  {
    if ((this.mListView != null) && (this.mListView.isShown()) && (!this.ta.isEmpty()))
    {
      this.mListView.removeCallbacks(this.eK);
      int j = this.mListView.getFirstVisiblePosition();
      int k = this.mListView.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i = j;
      while (i <= k)
      {
        if ((i >= 0) && (i < this.ta.size()) && (this.ta.get(i) != null))
        {
          localArrayList1.add(((MayKnowRecommend)this.ta.get(i)).uin);
          localArrayList2.add(((MayKnowRecommend)this.ta.get(i)).recommendReason);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(((MayKnowRecommend)this.ta.get(i)).algBuffer);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("contacts.RecommendsAdapter", 2, "reportRecommendFrdExpose firstVisibleItem: " + j + " lastVisibleItem: " + k + " exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      if (!localArrayList1.isEmpty()) {
        ContactReportUtils.a(this.mApp, 20, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 0, null);
      }
    }
  }
  
  public void cli()
  {
    if (this.mListView == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("contacts.RecommendsAdapter", 2, "stopVisibleExpose firstVisible: " + this.mListView.getFirstVisiblePosition() + " lastvisible: " + this.mListView.getLastVisiblePosition());
      }
      if ((getCount() > 0) && (this.mListView.isShown()))
      {
        achg localachg = (achg)this.mApp.getManager(159);
        int i = this.mListView.getFirstVisiblePosition();
        while (i <= this.mListView.getLastVisiblePosition())
        {
          if ((i >= 0) && (i < getCount())) {
            localachg.b((MayKnowRecommend)getItem(i), 20, 0, 1);
          }
          i += 1;
        }
      }
    } while (this.mListView == null);
    this.mListView.removeCallbacks(this.eK);
  }
  
  public void gJ(List<MayKnowRecommend> paramList)
  {
    this.ta.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.ta.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.ta.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.ta.size())) {
      return new MayKnowRecommend();
    }
    return this.ta.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      paramView = new zas.a();
      localView = LayoutInflater.from(this.mContext).inflate(2131559105, paramViewGroup, false);
      paramView.pQ = ((ImageView)localView.findViewById(2131361802));
      paramView.p = ((SingleLineTextView)localView.findViewById(2131372384));
      paramView.q = ((SingleLineTextView)localView.findViewById(2131377214));
      paramView.er = ((Button)localView.findViewById(2131377201));
      paramView.LF = ((TextView)localView.findViewById(2131377211));
      if ((paramView.pQ instanceof ThemeImageView)) {
        ((ThemeImageView)paramView.pQ).setSupportMaskView(false);
      }
      localView.setTag(paramView);
      localObject1 = (MayKnowRecommend)getItem(paramInt);
      paramView.uin = ((MayKnowRecommend)localObject1).uin;
      paramView.a = ((MayKnowRecommend)localObject1);
      if (this.a == null) {
        break label688;
      }
    }
    label543:
    label555:
    label688:
    for (boolean bool = this.a.aaC();; bool = false)
    {
      Object localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
      StringBuilder localStringBuilder = new StringBuilder(512);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramView.p.setVisibility(0);
        paramView.p.setText((CharSequence)localObject2);
        if (AppSetting.enableTalkBack) {
          localStringBuilder.append((String)localObject2);
        }
        label232:
        localObject2 = new StringBuilder();
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).category)) {
          ((StringBuilder)localObject2).append(((MayKnowRecommend)localObject1).category).append(" ");
        }
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).recommendReason)) {
          ((StringBuilder)localObject2).append(((MayKnowRecommend)localObject1).recommendReason);
        }
        localObject2 = ((StringBuilder)localObject2).toString();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label543;
        }
        paramView.q.setVisibility(0);
        paramView.q.setText((CharSequence)localObject2);
        if (AppSetting.enableTalkBack) {
          localStringBuilder.append(",").append((String)localObject2);
        }
        label343:
        if (((MayKnowRecommend)localObject1).friendStatus != 0) {
          break label555;
        }
        paramView.er.setOnClickListener(this);
        paramView.er.setVisibility(0);
        paramView.er.setTag(localObject1);
        paramView.er.setText(acfp.m(2131721053));
        paramView.LF.setVisibility(8);
        if (AppSetting.enableTalkBack)
        {
          localStringBuilder.append(",点击添加");
          paramView.er.setContentDescription(acfp.m(2131721053));
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          a(paramView);
        }
        if (this.a != null) {
          this.a.a((MayKnowRecommend)localObject1, 20, 0, 1);
        }
        if (AppSetting.enableTalkBack) {
          localView.setContentDescription(localStringBuilder.toString());
        }
        localView.setOnClickListener(this);
        paramView.pQ.setImageBitmap(a(1, paramView.uin));
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject1 = (zas.a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject1;
        break;
        paramView.p.setVisibility(8);
        break label232;
        paramView.q.setVisibility(8);
        break label343;
        if (((MayKnowRecommend)localObject1).friendStatus == 1)
        {
          paramView.er.setVisibility(8);
          paramView.LF.setVisibility(0);
          paramView.LF.setText(2131718834);
          if (AppSetting.enableTalkBack)
          {
            localStringBuilder.append(",等待验证");
            paramView.LF.setContentDescription(this.mRes.getString(2131718834));
          }
        }
        else
        {
          paramView.er.setVisibility(8);
          paramView.LF.setVisibility(0);
          paramView.LF.setText(2131690291);
          if (AppSetting.enableTalkBack)
          {
            localStringBuilder.append(",已添加");
            paramView.LF.setContentDescription(this.mRes.getString(2131690291));
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject1;
    boolean bool1;
    do
    {
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject1 = (MayKnowRecommend)paramView.getTag();
        } while (localObject1 == null);
        localObject2 = (acff)this.mApp.getManager(51);
        if ((!((acff)localObject2).isFriend(((MayKnowRecommend)localObject1).uin)) && (!((acff)localObject2).kd(((MayKnowRecommend)localObject1).uin)))
        {
          boolean bool2 = ((Activity)this.mContext).getIntent().getBooleanExtra("from_babyq", false);
          bool1 = false;
          if (this.a != null) {
            bool1 = this.a.aaC();
          }
          localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool1);
          i = 3045;
          int j = 20;
          if (bool2)
          {
            i = 3083;
            j = 1;
          }
          localObject2 = AddFriendLogicActivity.a(this.mContext, 1, ((MayKnowRecommend)localObject1).uin, null, i, j, (String)localObject2, null, null, this.mContext.getString(2131721053), null);
          ((Intent)localObject2).putExtra("key_param_age_area", aqep.a(this.mContext, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
          ((Intent)localObject2).putExtra("from_babyq", bool2);
          ((Activity)this.mContext).startActivity((Intent)localObject2);
        }
        for (;;)
        {
          if (this.a != null) {
            this.a.a((MayKnowRecommend)localObject1, 20, 0, 3);
          }
          ContactReportUtils.a(this.mApp, ((MayKnowRecommend)localObject1).uin, "frd_list_add", 20, 1, ((MayKnowRecommend)localObject1).recommendReason, this.ta.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0);
          break;
          if (((acff)localObject2).isFriend(((MayKnowRecommend)localObject1).uin))
          {
            ((MayKnowRecommend)localObject1).friendStatus = 2;
            notifyDataSetChanged();
          }
          else
          {
            ((MayKnowRecommend)localObject1).friendStatus = 1;
            notifyDataSetChanged();
          }
        }
        localObject1 = (zas.a)paramView.getTag();
      } while (localObject1 == null);
      localObject1 = ((zas.a)localObject1).a;
    } while (localObject1 == null);
    Object localObject2 = (acff)this.mApp.getManager(51);
    if ((localObject2 != null) && (((acff)localObject2).isFriend(((MayKnowRecommend)localObject1).uin))) {}
    for (int i = 1;; i = 103)
    {
      localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, i);
      bool1 = false;
      if (this.a != null) {
        bool1 = this.a.aaC();
      }
      Object localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(bool1);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((ProfileActivity.AllInOne)localObject2).aOH = ((String)localObject3);
      }
      if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
        ((ProfileActivity.AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
      }
      ((ProfileActivity.AllInOne)localObject2).bJa = 88;
      bool1 = ((Activity)this.mContext).getIntent().getBooleanExtra("from_babyq", false);
      localObject3 = new Bundle();
      if (bool1) {
        ((Bundle)localObject3).putBoolean("from_babyq", true);
      }
      ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
      ((Bundle)localObject3).putInt("recommend_pos", this.ta.indexOf(localObject1));
      ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
      ProfileActivity.a(this.mContext, (ProfileActivity.AllInOne)localObject2, (Bundle)localObject3);
      if (this.a != null) {
        this.a.a((MayKnowRecommend)localObject1, 20, 0, 2);
      }
      ContactReportUtils.a(this.mApp, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", 20, 0, ((MayKnowRecommend)localObject1).recommendReason, this.ta.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0);
      break;
    }
  }
  
  public void onDestroy()
  {
    super.destroy();
    setOnScrollListener(null);
    this.mListView = null;
    this.a = null;
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.RecommendsAdapter", 2, "onResume firstVisible: " + this.mListView.getFirstVisiblePosition() + " lastvisible: " + this.mListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.mListView.isShown()))
    {
      achg localachg = (achg)this.mApp.getManager(159);
      int i = this.mListView.getFirstVisiblePosition();
      while (i <= this.mListView.getLastVisiblePosition())
      {
        if ((i >= 0) && (i < getCount())) {
          localachg.a((MayKnowRecommend)getItem(i), 20, 0, 1);
        }
        i += 1;
      }
    }
    if (this.mListView != null)
    {
      this.mListView.removeCallbacks(this.eK);
      this.mListView.postDelayed(this.eK, 1000L);
    }
  }
  
  static class a
    extends abeg.a
  {
    public TextView LF;
    public MayKnowRecommend a;
    public Button er;
    public SingleLineTextView p;
    public SingleLineTextView q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zas
 * JD-Core Version:    0.7.0.1
 */