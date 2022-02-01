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
import com.tencent.mobileqq.activity.contacts.topentry.MayknowRecommendsAdapter.2;
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

public class zcb
  extends abeg
  implements View.OnClickListener
{
  long KU = 0L;
  achg a;
  protected Runnable eK = new MayknowRecommendsAdapter.2(this);
  QQAppInterface mApp;
  Context mContext;
  XListView mListView;
  private AbsListView.e mOnScrollListener = new zcc(this);
  Resources mRes;
  List<MayKnowRecommend> ta = new ArrayList();
  
  public zcb(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mRes = this.mContext.getResources();
    this.mListView = paramXListView;
    this.a = ((achg)paramQQAppInterface.getManager(159));
    setOnScrollListener(this.mOnScrollListener);
  }
  
  private void a(MayKnowRecommend paramMayKnowRecommend)
  {
    Object localObject;
    boolean bool2;
    if ((paramMayKnowRecommend != null) && (this.mApp != null) && (this.mContext != null))
    {
      localObject = (acff)this.mApp.getManager(51);
      if ((((acff)localObject).isFriend(paramMayKnowRecommend.uin)) || (((acff)localObject).kd(paramMayKnowRecommend.uin))) {
        break label258;
      }
      bool2 = ((Activity)this.mContext).getIntent().getBooleanExtra("from_babyq", false);
      if (this.a == null) {
        break label300;
      }
    }
    label258:
    label300:
    for (boolean bool1 = this.a.aaC();; bool1 = false)
    {
      localObject = paramMayKnowRecommend.getDisplayName(bool1);
      int i = 3045;
      if (bool2) {
        i = 3083;
      }
      for (int j = 1;; j = 24)
      {
        localObject = AddFriendLogicActivity.a(this.mContext, 1, paramMayKnowRecommend.uin, null, i, j, (String)localObject, null, null, this.mContext.getString(2131721053), null);
        ((Intent)localObject).putExtra("key_param_age_area", aqep.a(this.mContext, paramMayKnowRecommend.gender, paramMayKnowRecommend.age, paramMayKnowRecommend.country, paramMayKnowRecommend.province, paramMayKnowRecommend.city));
        ((Intent)localObject).putExtra("from_babyq", bool2);
        ((Activity)this.mContext).startActivity((Intent)localObject);
        for (;;)
        {
          if (this.a != null) {
            this.a.a(paramMayKnowRecommend, 24, 0, 3);
          }
          ContactReportUtils.a(this.mApp, paramMayKnowRecommend.uin, "frd_list_add", 24, 1, paramMayKnowRecommend.recommendReason, this.ta.indexOf(paramMayKnowRecommend), paramMayKnowRecommend.algBuffer, 0, "1");
          return;
          if (((acff)localObject).isFriend(paramMayKnowRecommend.uin))
          {
            paramMayKnowRecommend.friendStatus = 2;
            notifyDataSetChanged();
          }
          else
          {
            paramMayKnowRecommend.friendStatus = 1;
            notifyDataSetChanged();
          }
        }
      }
    }
  }
  
  private void a(zcb.a parama)
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
  
  public void Bw(boolean paramBoolean)
  {
    notifyDataSetChanged();
  }
  
  public void bq(QQAppInterface paramQQAppInterface)
  {
    if (this.mApp != paramQQAppInterface) {
      this.mApp = paramQQAppInterface;
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
      if ((!localArrayList1.isEmpty()) && (this.mApp != null)) {
        ContactReportUtils.b(this.mApp, 24, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 0, "1");
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
      if ((getCount() > 0) && (this.mListView.isShown()) && (this.mApp != null))
      {
        achg localachg = (achg)this.mApp.getManager(159);
        int i = this.mListView.getFirstVisiblePosition();
        while (i <= this.mListView.getLastVisiblePosition())
        {
          if ((i >= 0) && (i < getCount())) {
            localachg.b((MayKnowRecommend)getItem(i), 24, 0, 1);
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
    Object localObject1;
    if ((this.mRes == null) || (this.mContext == null) || (this.mApp == null))
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject2 = new zcb.a();
      localObject3 = LayoutInflater.from(this.mContext).inflate(2131559106, paramViewGroup, false);
      ((zcb.a)localObject2).pQ = ((ImageView)((View)localObject3).findViewById(2131361802));
      ((zcb.a)localObject2).p = ((SingleLineTextView)((View)localObject3).findViewById(2131372384));
      ((zcb.a)localObject2).q = ((SingleLineTextView)((View)localObject3).findViewById(2131377214));
      ((zcb.a)localObject2).er = ((Button)((View)localObject3).findViewById(2131377201));
      ((zcb.a)localObject2).LF = ((TextView)((View)localObject3).findViewById(2131377211));
      ((zcb.a)localObject2).ku = ((ImageView)((View)localObject3).findViewById(2131365697));
      ((View)localObject3).setTag(localObject2);
      localObject1 = localObject2;
      paramView = (View)localObject3;
      if ((((zcb.a)localObject2).pQ instanceof ThemeImageView))
      {
        ((ThemeImageView)((zcb.a)localObject2).pQ).setSupportMaskView(false);
        paramView = (View)localObject3;
        localObject1 = localObject2;
      }
      label211:
      localObject2 = (MayKnowRecommend)getItem(paramInt);
      ((zcb.a)localObject1).uin = ((MayKnowRecommend)localObject2).uin;
      ((zcb.a)localObject1).a = ((MayKnowRecommend)localObject2);
      if (this.a == null) {
        break label810;
      }
    }
    label656:
    label669:
    label810:
    for (boolean bool = this.a.aaC();; bool = false)
    {
      Object localObject4 = ((MayKnowRecommend)localObject2).getDisplayName(bool);
      localObject3 = new StringBuilder(512);
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        ((zcb.a)localObject1).p.setVisibility(0);
        ((zcb.a)localObject1).p.setText((CharSequence)localObject4);
        if (AppSetting.enableTalkBack) {
          ((StringBuilder)localObject3).append((String)localObject4);
        }
        label316:
        localObject4 = new StringBuilder();
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject2).category)) {
          ((StringBuilder)localObject4).append(((MayKnowRecommend)localObject2).category).append(" ");
        }
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject2).recommendReason)) {
          ((StringBuilder)localObject4).append(((MayKnowRecommend)localObject2).recommendReason);
        }
        localObject4 = ((StringBuilder)localObject4).toString();
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label656;
        }
        ((zcb.a)localObject1).q.setVisibility(0);
        ((zcb.a)localObject1).q.setText((CharSequence)localObject4);
        if (AppSetting.enableTalkBack) {
          ((StringBuilder)localObject3).append(",").append((String)localObject4);
        }
        label429:
        if (((MayKnowRecommend)localObject2).friendStatus != 0) {
          break label669;
        }
        ((zcb.a)localObject1).er.setOnClickListener(this);
        ((zcb.a)localObject1).er.setVisibility(0);
        ((zcb.a)localObject1).er.setTag(localObject2);
        ((zcb.a)localObject1).er.setText(acfp.m(2131721053));
        ((zcb.a)localObject1).LF.setVisibility(8);
        if (AppSetting.enableTalkBack)
        {
          ((StringBuilder)localObject3).append(",点击添加");
          ((zcb.a)localObject1).er.setContentDescription(acfp.m(2131721053));
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          a((zcb.a)localObject1);
        }
        if (this.a != null) {
          this.a.a((MayKnowRecommend)localObject2, 24, 0, 1);
        }
        if (AppSetting.enableTalkBack) {
          paramView.setContentDescription(((StringBuilder)localObject3).toString());
        }
        ((zcb.a)localObject1).ku.setOnClickListener(this);
        ((zcb.a)localObject1).ku.setTag(localObject2);
        paramView.setOnClickListener(this);
        if (AppSetting.enableTalkBack) {
          ((zcb.a)localObject1).ku.setContentDescription(acfp.m(2131708055));
        }
        ((zcb.a)localObject1).pQ.setImageBitmap(a(1, ((zcb.a)localObject1).uin));
        localObject1 = paramView;
        break;
        localObject1 = (zcb.a)paramView.getTag();
        break label211;
        ((zcb.a)localObject1).p.setVisibility(8);
        break label316;
        ((zcb.a)localObject1).q.setVisibility(8);
        break label429;
        if (((MayKnowRecommend)localObject2).friendStatus == 1)
        {
          ((zcb.a)localObject1).er.setVisibility(8);
          ((zcb.a)localObject1).LF.setVisibility(0);
          ((zcb.a)localObject1).LF.setText(2131718834);
          if (AppSetting.enableTalkBack)
          {
            ((StringBuilder)localObject3).append(",等待验证");
            ((zcb.a)localObject1).LF.setContentDescription(this.mRes.getString(2131718834));
          }
        }
        else
        {
          ((zcb.a)localObject1).er.setVisibility(8);
          ((zcb.a)localObject1).LF.setVisibility(0);
          ((zcb.a)localObject1).LF.setText(2131690291);
          if (AppSetting.enableTalkBack)
          {
            ((StringBuilder)localObject3).append(",已添加");
            ((zcb.a)localObject1).LF.setContentDescription(this.mRes.getString(2131690291));
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
    case 2131377201: 
    case 2131377370: 
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            a((MayKnowRecommend)paramView.getTag());
          }
          localObject1 = (zcb.a)paramView.getTag();
        } while (localObject1 == null);
        localObject1 = ((zcb.a)localObject1).a;
      } while ((localObject1 == null) || (this.mApp == null) || (this.mContext == null));
      localObject2 = (acff)this.mApp.getManager(51);
      if ((localObject2 == null) || (!((acff)localObject2).isFriend(((MayKnowRecommend)localObject1).uin))) {
        break;
      }
    }
    for (int i = 1;; i = 101)
    {
      localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, i);
      if (this.a != null) {}
      for (boolean bool = this.a.aaC();; bool = false)
      {
        Object localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(bool);
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((ProfileActivity.AllInOne)localObject2).aOH = ((String)localObject3);
        }
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
          ((ProfileActivity.AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
        }
        ((ProfileActivity.AllInOne)localObject2).bJa = 88;
        bool = ((Activity)this.mContext).getIntent().getBooleanExtra("from_babyq", false);
        localObject3 = new Bundle();
        if (bool) {
          ((Bundle)localObject3).putBoolean("from_babyq", true);
        }
        ((Bundle)localObject3).putString("recommend_entry_type", "1");
        ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
        ((Bundle)localObject3).putInt("recommend_pos", this.ta.indexOf(localObject1));
        ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
        ProfileActivity.a(this.mContext, (ProfileActivity.AllInOne)localObject2, (Bundle)localObject3);
        if (this.a != null) {
          this.a.a((MayKnowRecommend)localObject1, 24, 0, 2);
        }
        ContactReportUtils.a(this.mApp, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", 24, 0, ((MayKnowRecommend)localObject1).recommendReason, this.ta.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0, "1");
        break;
        localObject2 = (MayKnowRecommend)paramView.getTag();
        if ((localObject2 == null) || (this.mApp == null) || (System.currentTimeMillis() - this.KU <= 500L)) {
          break;
        }
        this.KU = System.currentTimeMillis();
        localObject1 = (zbq)this.mApp.getManager(295);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((zbq)localObject1).a())
        {
          if (localObject1 != null) {
            ((zbx)localObject1).zt(((MayKnowRecommend)localObject2).uin);
          }
          if (this.ta == null) {
            break;
          }
          ContactReportUtils.a(this.mApp, ((MayKnowRecommend)localObject2).uin, "frd_list_dlt", 24, 0, ((MayKnowRecommend)localObject2).recommendReason, this.ta.indexOf(localObject2), ((MayKnowRecommend)localObject2).algBuffer, 0, "1");
          break;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.destroy();
    setOnScrollListener(null);
    if (this.ta != null) {
      this.ta.clear();
    }
    this.mListView = null;
    this.a = null;
    this.mContext = null;
    this.mRes = null;
    this.mApp = null;
  }
  
  public void onPause()
  {
    cli();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.RecommendsAdapter", 2, "onResume firstVisible: " + this.mListView.getFirstVisiblePosition() + " lastvisible: " + this.mListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.mListView.isShown()) && (this.mApp != null))
    {
      achg localachg = (achg)this.mApp.getManager(159);
      int i = this.mListView.getFirstVisiblePosition();
      while (i <= this.mListView.getLastVisiblePosition())
      {
        if ((i >= 0) && (i < getCount())) {
          localachg.a((MayKnowRecommend)getItem(i), 24, 0, 1);
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
    public ImageView ku;
    public SingleLineTextView p;
    public SingleLineTextView q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcb
 * JD-Core Version:    0.7.0.1
 */