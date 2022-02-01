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
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
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

public class uar
  extends BaseAdapter
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  private float jdField_a_of_type_Float;
  private aklg jdField_a_of_type_Aklg;
  private ServiceAccountFolderActivity jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = "ServiceAccountFolderFeedAdapter";
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<uaq> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private float b;
  private float c;
  
  public uar(QQAppInterface paramQQAppInterface, ServiceAccountFolderActivity paramServiceAccountFolderActivity, SwipListView paramSwipListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity = paramServiceAccountFolderActivity;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aklg = new aklg(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Float = paramServiceAccountFolderActivity.getResources().getDimension(2131297988);
    this.b = paramServiceAccountFolderActivity.getResources().getDimension(2131297986);
    this.c = (this.jdField_a_of_type_Float + this.b);
  }
  
  private void a(uaq paramuaq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow->uin:" + paramuaq.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.b(true);
    Object localObject = (amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((amxz)localObject).a(paramuaq.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if ((localObject != null) && (ugf.a(((AccountDetail)localObject).accountFlag) == -4))
      {
        localObject = new NewIntent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, odw.class);
        ((NewIntent)localObject).putExtra("cmd", "unfollow");
        mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
        localUnFollowRequest.uin.set((int)Long.parseLong(paramuaq.jdField_a_of_type_JavaLangString));
        ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
        ((NewIntent)localObject).putExtra("source", 25);
        ((NewIntent)localObject).setObserver(new uat(this, paramuaq));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      }
      for (;;)
      {
        ugf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramuaq.jdField_a_of_type_JavaLangString);
        return;
        localObject = new anxp(new uau(this, paramuaq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)localObject);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)localObject);
        anxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramuaq.jdField_a_of_type_JavaLangString, 0);
      }
    }
  }
  
  private void a(uaq paramuaq, int paramInt)
  {
    bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, null);
    localbjnw.a(String.format(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources().getString(2131695986), new Object[] { paramuaq.jdField_c_of_type_JavaLangString }));
    localbjnw.a(2131695924, 3);
    localbjnw.c(2131690620);
    localbjnw.a(new uas(this, paramuaq, paramInt, localbjnw));
    localbjnw.show();
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showActionSheet->uin:" + paramuaq.jdField_a_of_type_JavaLangString + ", name:" + paramuaq.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void a(uav paramuav, int paramInt, View paramView)
  {
    uaq localuaq = (uaq)getItem(paramInt);
    if (localuaq == null) {}
    for (;;)
    {
      return;
      boolean bool = a(localuaq.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateItemContent->uin:" + localuaq.jdField_a_of_type_JavaLangString + ", isFollow:" + bool);
      }
      int i;
      if (bool)
      {
        paramuav.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramView.setTag(-3, Integer.valueOf((int)this.c));
        paramuav.jdField_a_of_type_JavaLangString = localuaq.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Aklg != null) {
          a(paramuav, localuaq.jdField_a_of_type_JavaLangString);
        }
        paramuav.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, localuaq.jdField_c_of_type_Int);
        paramuav.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localuaq.jdField_c_of_type_JavaLangString);
        paramuav.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localuaq.jdField_b_of_type_JavaLangString, 0);
        i = 0;
        if (localuaq.e == 4) {
          i = 2130839576;
        }
        paramuav.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
        i = localuaq.jdField_d_of_type_Int;
        Object localObject2 = localuaq.jdField_d_of_type_JavaLangString;
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
          paramuav.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        paramuav.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject2, 1);
      }
      try
      {
        paramuav.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(new QQText(localuaq.jdField_a_of_type_JavaLangCharSequence, 3, 16));
        m = localuaq.jdField_b_of_type_Int;
        i = localuaq.jdField_a_of_type_Int;
        if (m > 0) {
          if (i == 0)
          {
            paramuav.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            paramuav.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 0;
            if ((b(localuaq.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))))
            {
              this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
              zxp.b(localuaq.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_exp", 0, 0, new String[0]);
            }
            bjpg.a(paramuav.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, k, i, j, 99, null);
            if (!AppSetting.c) {
              continue;
            }
            paramView = new StringBuilder();
            paramView.append(paramuav.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText()).append(",");
            if (i != 0) {
              break label724;
            }
            paramView.append(paramuav.jdField_b_of_type_ComTencentWidgetSingleLineTextView.getText()).append(",").append(localuaq.jdField_b_of_type_JavaLangString);
            paramuav.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramView);
            return;
            paramuav.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramView.setTag(-3, Integer.valueOf((int)this.b));
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
          paramuav.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(localuaq.jdField_a_of_type_JavaLangCharSequence + " ");
          continue;
          if (i == 2)
          {
            paramuav.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            paramuav.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 1;
          }
          else
          {
            int n = 3;
            int i1 = 2130850325;
            paramuav.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
            paramuav.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            i = m;
            j = i1;
            k = n;
            if (b(localuaq.jdField_a_of_type_JavaLangString))
            {
              zxp.a(localuaq.jdField_a_of_type_JavaLangString, "auth_page", "new_exp", 0, 0, new String[0]);
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
  
  private void a(uav paramuav, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "setHolderIcon->uin:" + paramString);
    }
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      paramuav.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Aklg.a(1008, paramString));
      return;
    }
    paramuav.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AccountDetail localAccountDetail;
    do
    {
      amxz localamxz;
      do
      {
        do
        {
          return false;
          localamxz = (amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
        } while (localamxz == null);
        localAccountDetail = localamxz.b(paramString);
      } while (((localAccountDetail != null) && (!localAccountDetail.isShowFollowButton)) || ((localAccountDetail == null) && ("1770946116".equals(paramString))));
      if (localamxz.c(paramString) != null) {
        return true;
      }
    } while (localAccountDetail == null);
    if (localAccountDetail.followType == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showNetworkErrorToast");
    }
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131694775, 0).show();
  }
  
  private void b(uaq paramuaq)
  {
    String str = paramuaq.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateUnfollowInfo->uin:" + str);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramuaq);
      notifyDataSetChanged();
      ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.7(this, paramuaq));
      if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new ServiceAccountFolderFeedAdapter.8(this, str, paramuaq), 10L);
      return;
    }
  }
  
  private boolean b(String paramString)
  {
    amxz localamxz = (amxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localamxz != null)
    {
      paramString = localamxz.b(paramString);
      if ((paramString != null) && (ugf.a(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aklg.a();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(List<uaq> paramList)
  {
    if (paramList != null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "setDataList->DataSetChanged size:" + paramList.size());
      }
      return;
    }
  }
  
  public int getCount()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
  }
  
  public Object getItem(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramInt >= getCount()) {
        return null;
      }
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      if ((paramView.getTag() instanceof uav)) {
        localObject1 = (uav)paramView.getTag();
      }
    }
    if (localObject1 == null)
    {
      paramView = new uav(this);
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity).inflate(2131559643, null);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131366383));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368236));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject1).findViewById(2131378707));
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject1).findViewById(2131365445));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131380166));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject1).findViewById(2131370732));
      paramView.jdField_b_of_type_AndroidWidgetButton = ((Button)((View)localObject1).findViewById(2131370712));
      Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources();
      float f = DeviceInfoUtil.getDesity();
      localObject2 = ((Resources)localObject3).getColorStateList(2131167096);
      localObject3 = ((Resources)localObject3).getColorStateList(2131167019);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject3);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 0);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 2);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
      ((ThemeImageView)paramView.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((View)localObject1).setTag(paramView);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
      paramView.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
      paramView.jdField_b_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
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
    uaq localuaq = (uaq)getItem(k);
    if (localuaq == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = localuaq.jdField_b_of_type_Int;
    int j = localuaq.jdField_a_of_type_Int;
    if (j != 1) {
      i = 0;
    }
    for (;;)
    {
      long l = uaw.a().a(localuaq);
      ??? = localuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      String str1;
      if (??? != null)
      {
        str1 = anxs.a(localuaq.jdField_b_of_type_Int + "", ((MessageRecord)???).msgseq + "", ((MessageRecord)???).msgBackupMsgRandom + "");
        label154:
        if ((localuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (localuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject == null)) {
          break label1189;
        }
      }
      label401:
      label788:
      label1189:
      for (String str2 = localuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");; str2 = "") {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131366383: 
          ??? = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, ChatActivity.class);
          ((Intent)???).putExtra("uintype", 1008);
          ((Intent)???).putExtra("uin", localuaq.jdField_a_of_type_JavaLangString);
          ((Intent)???).putExtra("uinname", localuaq.jdField_c_of_type_JavaLangString);
          ((Intent)???).putExtra("start_time", System.currentTimeMillis());
          ((Intent)???).putExtra("red_hot_count", localuaq.jdField_b_of_type_Int);
          ((Intent)???).putExtra("INTENT_KEY_FROM", 2);
          this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.startActivity((Intent)???);
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickFeedItem->uin:" + localuaq.jdField_a_of_type_JavaLangString + ", name:" + localuaq.jdField_c_of_type_JavaLangString);
          }
          ??? = "0X80067F1";
          QQAppInterface localQQAppInterface;
          String str3;
          if (j == 1)
          {
            ??? = "0X80067EF";
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localuaq.jdField_a_of_type_JavaLangString, (String)???, (String)???, 0, 0, "" + j, "" + l, "" + (k + 1), "" + i);
            akmc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localuaq.jdField_a_of_type_JavaLangString, localuaq.jdField_a_of_type_Int, localuaq.jdField_b_of_type_Int, 2, localuaq.jdField_c_of_type_JavaLangString);
            localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            str3 = localuaq.jdField_a_of_type_JavaLangString;
            i = localuaq.jdField_a_of_type_Int;
            j = localuaq.jdField_b_of_type_Int;
            if (localuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              break label788;
            }
          }
          for (??? = "";; ??? = localuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg)
          {
            anxs.b(localQQAppInterface, str3, i, j, (String)???, str2, str1, k + "");
            if (agjp.a(localuaq.jdField_a_of_type_JavaLangString)) {
              bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.4.8", "");
            }
            if (b(localuaq.jdField_a_of_type_JavaLangString))
            {
              zxp.a(localuaq.jdField_a_of_type_JavaLangString, "auth_page", "clk_content", 0, 0, new String[] { "", "1", localuaq.jdField_c_of_type_JavaLangString, localuaq.jdField_d_of_type_JavaLangString });
              zxp.b(localuaq.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_clk", 0, 0, new String[0]);
            }
            ugt.a(null, "SUBSCRIPT_AIO_COST");
            break;
            str1 = "";
            break label154;
            if (j != 2) {
              break label401;
            }
            ??? = "0X80067F0";
            break label401;
          }
        case 2131370732: 
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuUnfollow->uin:" + localuaq.jdField_a_of_type_JavaLangString + ", name:" + localuaq.jdField_c_of_type_JavaLangString);
          }
          a(localuaq, k);
          ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.1(this, localuaq));
          break;
        case 2131370712: 
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuDelete->uin:" + localuaq.jdField_a_of_type_JavaLangString + ", name:" + localuaq.jdField_c_of_type_JavaLangString);
          }
          for (;;)
          {
            synchronized (this.jdField_a_of_type_JavaLangObject)
            {
              this.jdField_a_of_type_JavaUtilList.remove(localuaq);
              notifyDataSetChanged();
              ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.2(this, localuaq));
              if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
                this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
              }
              if (j == 2)
              {
                j = 1;
                bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localuaq.jdField_a_of_type_JavaLangString, "0X80067F3", "0X80067F3", 0, 0, "" + j, "" + i, "" + (k + 1), "" + l);
                akmc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localuaq.jdField_a_of_type_JavaLangString, localuaq.jdField_a_of_type_Int, localuaq.jdField_b_of_type_Int, 2, localuaq.jdField_c_of_type_JavaLangString);
                ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.3(this, localuaq));
              }
            }
            j = 0;
          }
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
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof uav)))
        {
          paramBitmap = (uav)paramBitmap;
          if (paramString.equals(paramBitmap.jdField_a_of_type_JavaLangString)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ServiceAccountFolderFeedAdapter", 2, "onDecodeTaskCompleted->uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uar
 * JD-Core Version:    0.7.0.1
 */