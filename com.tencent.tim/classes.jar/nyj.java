import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.1;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.2;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.3;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.7;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class nyj
  extends BaseAdapter
  implements View.OnClickListener, aqdf.a
{
  private final String TAG = "ServiceAccountFolderFeedAdapter";
  private ServiceAccountFolderActivity jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private Set<Integer> au = new HashSet();
  private SwipListView e;
  private HashMap<String, Bitmap> eA = new HashMap();
  private List<nyi> kH;
  private float lu;
  private float lv;
  private float lw;
  private QQAppInterface mApp;
  private final Object mDataLock = new Object();
  private aajx mFaceDecoder;
  
  public nyj(QQAppInterface paramQQAppInterface, ServiceAccountFolderActivity paramServiceAccountFolderActivity, SwipListView paramSwipListView)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity = paramServiceAccountFolderActivity;
    this.e = paramSwipListView;
    this.kH = new ArrayList();
    this.mFaceDecoder = new aajx(paramQQAppInterface, this, false);
    this.lu = paramServiceAccountFolderActivity.getResources().getDimension(2131298408);
    this.lv = paramServiceAccountFolderActivity.getResources().getDimension(2131298406);
    this.lw = (this.lu + this.lv);
  }
  
  private void a(nyi paramnyi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow->uin:" + paramnyi.mUin);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.showProgressBar(true);
    Object localObject = (acja)this.mApp.getManager(56);
    if (localObject != null) {}
    for (localObject = ((acja)localObject).a(paramnyi.mUin);; localObject = null)
    {
      if ((localObject != null) && (ocp.getAccountType(((AccountDetail)localObject).accountFlag) == -4))
      {
        localObject = new NewIntent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, kbs.class);
        ((NewIntent)localObject).putExtra("cmd", "unfollow");
        mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
        localUnFollowRequest.uin.set((int)Long.parseLong(paramnyi.mUin));
        ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
        ((NewIntent)localObject).putExtra("source", 25);
        ((NewIntent)localObject).setObserver(new nyl(this, paramnyi));
        this.mApp.startServlet((NewIntent)localObject);
      }
      for (;;)
      {
        ocp.n(this.mApp, paramnyi.mUin);
        return;
        localObject = new adai(new nym(this, paramnyi), this.mApp);
        this.mApp.removeObserver((acci)localObject);
        this.mApp.addObserver((acci)localObject);
        adam.a(this.mApp, false, paramnyi.mUin, 0);
      }
    }
  }
  
  private void a(nyi paramnyi, int paramInt)
  {
    ausj localausj = (ausj)auss.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, null);
    localausj.setMainTitle(String.format(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources().getString(2131698742), new Object[] { paramnyi.mTitleName }));
    localausj.addButton(2131698678, 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new nyk(this, paramnyi, paramInt, localausj));
    localausj.show();
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showActionSheet->uin:" + paramnyi.mUin + ", name:" + paramnyi.mTitleName);
    }
  }
  
  private void a(nyj.a parama, int paramInt, View paramView)
  {
    nyi localnyi = (nyi)getItem(paramInt);
    if (localnyi == null) {}
    for (;;)
    {
      return;
      boolean bool = em(localnyi.mUin);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateItemContent->uin:" + localnyi.mUin + ", isFollow:" + bool);
      }
      int i;
      if (bool)
      {
        parama.bY.setVisibility(0);
        paramView.setTag(-3, Integer.valueOf((int)this.lw));
        parama.uin = localnyi.mUin;
        if (this.mFaceDecoder != null) {
          a(parama, localnyi.mUin);
        }
        parama.g.setCompoundDrawablesWithIntrinsicBounds(0, localnyi.mAuthenIconId);
        parama.g.setText(localnyi.mTitleName);
        parama.g.setExtendText(localnyi.mShowTime, 0);
        i = 0;
        if (localnyi.mStatus == 4) {
          i = 2130839799;
        }
        parama.h.setCompoundDrawablesWithIntrinsicBounds(i, 0);
        i = localnyi.mExtraInfoColor;
        Object localObject2 = localnyi.aoL;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0)
        {
          localObject2 = localObject1;
          if (!((String)localObject1).endsWith(" ")) {
            localObject2 = (String)localObject1 + " ";
          }
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (i != 0)) {
          parama.h.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        parama.h.setExtendText((String)localObject2, 1);
      }
      try
      {
        parama.h.setText(new aofk(localnyi.v, 3, 16));
        m = localnyi.mUnreadNum;
        i = localnyi.mUnreadFlag;
        if (m > 0) {
          if (i == 0)
          {
            parama.d.setDragViewType(-1, paramView);
            parama.d.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 0;
            if ((en(localnyi.mUin)) && (this.au != null) && (!this.au.contains(Integer.valueOf(paramInt))))
            {
              this.au.add(Integer.valueOf(paramInt));
              sqn.c(localnyi.mUin, "auth_page", "new_msg_exp", 0, 0, new String[0]);
            }
            aute.updateCustomNoteTxt(parama.d, k, i, j, 99, null);
            if (!AppSetting.enableTalkBack) {
              continue;
            }
            paramView = new StringBuilder();
            paramView.append(parama.g.getText()).append(",");
            if (i != 0) {
              break label724;
            }
            paramView.append(parama.h.getText()).append(",").append(localnyi.mShowTime);
            parama.fC.setContentDescription(paramView);
            return;
            parama.bY.setVisibility(8);
            paramView.setTag(-3, Integer.valueOf((int)this.lv));
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int m;
          int j;
          int k;
          localException.printStackTrace();
          parama.h.setText(localnyi.v + " ");
          continue;
          if (i == 2)
          {
            parama.d.setDragViewType(-1, paramView);
            parama.d.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 1;
          }
          else
          {
            int n = 3;
            int i1 = 2130851404;
            parama.d.setDragViewType(0, paramView);
            parama.d.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            i = m;
            j = i1;
            k = n;
            if (en(localnyi.mUin))
            {
              sqn.b(localnyi.mUin, "auth_page", "new_exp", 0, 0, new String[0]);
              i = m;
              j = i1;
              k = n;
              continue;
              label724:
              if (i == 1)
              {
                paramView.append("有一条未读,");
              }
              else if (i == 2)
              {
                paramView.append("有两条未读,");
              }
              else if (i > 0)
              {
                paramView.append("有").append(i).append("条未读,");
                continue;
                i = 0;
                j = 0;
                k = 0;
              }
            }
          }
        }
      }
    }
  }
  
  private void a(nyj.a parama, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "setHolderIcon->uin:" + paramString);
    }
    Bitmap localBitmap = (Bitmap)this.eA.get(paramString);
    if (localBitmap == null)
    {
      parama.icon.setImageDrawable(this.mFaceDecoder.a(1008, paramString));
      return;
    }
    parama.icon.setImageBitmap(localBitmap);
  }
  
  private void b(nyi paramnyi)
  {
    String str = paramnyi.mUin;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateUnfollowInfo->uin:" + str);
    }
    synchronized (this.mDataLock)
    {
      this.kH.remove(paramnyi);
      notifyDataSetChanged();
      ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.7(this, paramnyi));
      if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.qt(true);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new ServiceAccountFolderFeedAdapter.8(this, str, paramnyi), 10L);
      return;
    }
  }
  
  private void bcA()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showNetworkErrorToast");
    }
    Toast.makeText(this.mApp.getApplication(), 2131697432, 0).show();
  }
  
  private boolean em(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AccountDetail localAccountDetail;
    do
    {
      acja localacja;
      do
      {
        do
        {
          return false;
          localacja = (acja)this.mApp.getManager(56);
        } while (localacja == null);
        localAccountDetail = localacja.b(paramString);
      } while (((localAccountDetail != null) && (!localAccountDetail.isShowFollowButton)) || ((localAccountDetail == null) && ("1770946116".equals(paramString))));
      if (localacja.c(paramString) != null) {
        return true;
      }
    } while (localAccountDetail == null);
    if (localAccountDetail.followType == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean en(String paramString)
  {
    acja localacja = (acja)this.mApp.getManager(56);
    if (localacja != null)
    {
      paramString = localacja.b(paramString);
      if ((paramString != null) && (ocp.F(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  public void cS(List<nyi> paramList)
  {
    if (paramList != null) {}
    synchronized (this.mDataLock)
    {
      this.kH.clear();
      this.kH.addAll(paramList);
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "setDataList->DataSetChanged size:" + paramList.size());
      }
      return;
    }
  }
  
  public int getCount()
  {
    synchronized (this.mDataLock)
    {
      int i = this.kH.size();
      return i;
    }
  }
  
  public Object getItem(int paramInt)
  {
    synchronized (this.mDataLock)
    {
      if (paramInt >= getCount()) {
        return null;
      }
      Object localObject2 = this.kH.get(paramInt);
      return localObject2;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView != null)
    {
      localObject1 = localObject2;
      if ((paramView.getTag() instanceof nyj.a)) {
        localObject1 = (nyj.a)paramView.getTag();
      }
    }
    if (localObject1 == null)
    {
      paramView = new nyj.a();
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity).inflate(2131559841, null);
      paramView.fC = ((RelativeLayout)((View)localObject1).findViewById(2131366769));
      paramView.icon = ((ImageView)((View)localObject1).findViewById(2131368698));
      paramView.g = ((SingleLineTextView)((View)localObject1).findViewById(2131379769));
      paramView.h = ((SingleLineTextView)((View)localObject1).findViewById(2131365748));
      paramView.d = ((DragTextView)((View)localObject1).findViewById(2131381288));
      paramView.bY = ((Button)((View)localObject1).findViewById(2131371305));
      paramView.bL = ((Button)((View)localObject1).findViewById(2131371285));
      Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources();
      float f = aqgz.getDesity();
      localObject2 = ((Resources)localObject3).getColorStateList(2131167383);
      localObject3 = ((Resources)localObject3).getColorStateList(2131167311);
      paramView.g.setTextColor((ColorStateList)localObject3);
      paramView.g.setTextSize(17.0F);
      paramView.g.setExtendTextColor((ColorStateList)localObject2, 0);
      paramView.g.setExtendTextSize(12.0F, 0);
      paramView.g.setCompoundDrawablePadding((int)(3.0F * f));
      paramView.g.setExtendTextPadding((int)(5.0F * f), 2);
      paramView.g.setExtendTextColor((ColorStateList)localObject2, 2);
      paramView.g.setExtendTextSize(17.0F, 2);
      paramView.h.setTextSize(14.0F);
      paramView.h.setExtendTextPadding((int)(f * 2.0F), 1);
      paramView.h.setExtendTextSize(14.0F, 1);
      ((ThemeImageView)paramView.icon).setSupportMaskView(true);
      paramView.fC.setOnClickListener(this);
      paramView.bY.setOnClickListener(this);
      paramView.bL.setOnClickListener(this);
      ((View)localObject1).setTag(paramView);
    }
    for (;;)
    {
      paramView.fC.setTag(Integer.valueOf(paramInt));
      paramView.bY.setTag(Integer.valueOf(paramInt));
      paramView.bL.setTag(Integer.valueOf(paramInt));
      paramView.d.setTag(Integer.valueOf(paramInt));
      a(paramView, paramInt, (View)localObject1);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = paramView;
      paramView = (View)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public void onClick(View paramView)
  {
    int k = ((Integer)paramView.getTag()).intValue();
    nyi localnyi = (nyi)getItem(k);
    if (localnyi == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = localnyi.mUnreadNum;
    int j = localnyi.mUnreadFlag;
    if (j != 1) {
      i = 0;
    }
    for (;;)
    {
      long l = nyn.a().a(localnyi);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131366769: 
        ??? = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, ChatActivity.class);
        ((Intent)???).putExtra("uintype", 1008);
        ((Intent)???).putExtra("uin", localnyi.mUin);
        ((Intent)???).putExtra("uinname", localnyi.mTitleName);
        ((Intent)???).putExtra("start_time", System.currentTimeMillis());
        ((Intent)???).putExtra("red_hot_count", localnyi.mUnreadNum);
        ((Intent)???).putExtra("INTENT_KEY_FROM", 2);
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.startActivity((Intent)???);
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickFeedItem->uin:" + localnyi.mUin + ", name:" + localnyi.mTitleName);
        }
        ??? = "0X80067F1";
        QQAppInterface localQQAppInterface;
        String str2;
        if (j == 1)
        {
          ??? = "0X80067EF";
          anot.a(this.mApp, "dc01160", "Pb_account_lifeservice", "" + localnyi.mUin, (String)???, (String)???, 0, 0, "" + j, "" + l, "" + (k + 1), "" + i);
          aakp.a(this.mApp, localnyi.mUin, localnyi.mUnreadFlag, localnyi.mUnreadNum, 2, localnyi.mTitleName);
          str1 = "";
          ??? = str1;
          if (localnyi.d != null)
          {
            ??? = str1;
            if (localnyi.d.mExJsonObject != null) {
              ??? = localnyi.d.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
            }
          }
          localQQAppInterface = this.mApp;
          str2 = localnyi.mUin;
          i = localnyi.mUnreadFlag;
          j = localnyi.mUnreadNum;
          if (localnyi.d != null) {
            break label680;
          }
        }
        for (String str1 = "";; str1 = localnyi.d.msg)
        {
          adak.b(localQQAppInterface, str2, i, j, str1, (String)???);
          if (xki.hN(localnyi.mUin)) {
            anot.a(this.mApp, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "3.4.4", "");
          }
          if (en(localnyi.mUin))
          {
            sqn.b(localnyi.mUin, "auth_page", "clk_content", 0, 0, new String[] { "", "1", localnyi.mTitleName, localnyi.aoL });
            sqn.c(localnyi.mUin, "auth_page", "new_msg_clk", 0, 0, new String[0]);
          }
          odd.bU(null, "SUBSCRIPT_AIO_COST");
          break;
          if (j != 2) {
            break label273;
          }
          ??? = "0X80067F0";
          break label273;
        }
      case 2131371305: 
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuUnfollow->uin:" + localnyi.mUin + ", name:" + localnyi.mTitleName);
        }
        a(localnyi, k);
        ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.1(this, localnyi));
        break;
      case 2131371285: 
        label273:
        label680:
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuDelete->uin:" + localnyi.mUin + ", name:" + localnyi.mTitleName);
        }
        for (;;)
        {
          synchronized (this.mDataLock)
          {
            this.kH.remove(localnyi);
            notifyDataSetChanged();
            ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.2(this, localnyi));
            if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
              this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.qt(true);
            }
            if (j == 2)
            {
              j = 1;
              anot.a(this.mApp, "dc01160", "Pb_account_lifeservice", "" + localnyi.mUin, "0X80067F3", "0X80067F3", 0, 0, "" + j, "" + i, "" + (k + 1), "" + l);
              aakp.b(this.mApp, localnyi.mUin, localnyi.mUnreadFlag, localnyi.mUnreadNum, 2, localnyi.mTitleName);
              ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.3(this, localnyi));
            }
          }
          j = 0;
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
      this.eA.put(paramString, paramBitmap);
      paramInt2 = this.e.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.e.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof nyj.a)))
        {
          paramBitmap = (nyj.a)paramBitmap;
          if (paramString.equals(paramBitmap.uin)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ServiceAccountFolderFeedAdapter", 2, "onDecodeTaskCompleted->uin:" + paramString);
  }
  
  public void onDestory()
  {
    this.mFaceDecoder.onDestory();
    this.eA.clear();
    this.au.clear();
    synchronized (this.mDataLock)
    {
      this.kH.clear();
      return;
    }
  }
  
  public void setDragHost(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  class a
    extends auvd.a
  {
    Button bL;
    Button bY;
    DragTextView d;
    RelativeLayout fC;
    SingleLineTextView g;
    SingleLineTextView h;
    ImageView icon;
    String uin;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyj
 * JD-Core Version:    0.7.0.1
 */