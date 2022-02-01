import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.SignatureManager.SigCommentInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mqq.os.MqqHandler;

public class abgb
  extends BaseAdapter
  implements View.OnClickListener
{
  private View AE;
  private SigCommentListActivity jdField_b_of_type_ComTencentMobileqqActivitySigCommentListActivity;
  private SignatureManager jdField_b_of_type_ComTencentMobileqqAppSignatureManager;
  public int cog = -1;
  private boolean isOver;
  private QQAppInterface mApp;
  private ArrayList<SignatureManager.SigCommentInfo> mData = new ArrayList();
  private View mEmptyView;
  private LayoutInflater mLayoutInflater;
  private XListView mListView;
  
  public abgb(SigCommentListActivity paramSigCommentListActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, View paramView)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivitySigCommentListActivity = paramSigCommentListActivity;
    this.mLayoutInflater = LayoutInflater.from(paramSigCommentListActivity);
    this.mListView = paramXListView;
    this.mApp = paramQQAppInterface;
    this.jdField_b_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)this.mApp.getManager(58));
    this.mEmptyView = paramView;
  }
  
  private void c(String paramString, TextView paramTextView)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
        localObject = (SignatureManager)this.mApp.getManager(58);
      } while (localObject == null);
      paramString = ((SignatureManager)localObject).b(paramString);
    } while (paramString == null);
    Object localObject = new StringBuilder();
    if (!TextUtils.isEmpty(paramString.actionText))
    {
      ((StringBuilder)localObject).append(paramString.actionText);
      if (!TextUtils.isEmpty(paramString.dataText)) {
        ((StringBuilder)localObject).append(paramString.dataText);
      }
      ((StringBuilder)localObject).append(' ');
    }
    if (!TextUtils.isEmpty(paramString.getPlainText())) {
      ((StringBuilder)localObject).append(paramString.getPlainText());
    }
    paramTextView.setText(((StringBuilder)localObject).toString());
  }
  
  public void Ha(int paramInt)
  {
    if (this.AE != null) {
      ((abgb.a)this.AE.getTag()).ny.setText(paramInt);
    }
  }
  
  public SignatureManager.SigCommentInfo a(int paramInt)
  {
    if ((this.mData == null) || (paramInt < 0) || (paramInt >= this.mData.size())) {
      return null;
    }
    return (SignatureManager.SigCommentInfo)this.mData.get(paramInt);
  }
  
  public List<SignatureManager.SigCommentInfo> dy()
  {
    if (this.mData.size() == 0) {
      return null;
    }
    return (ArrayList)this.mData.clone();
  }
  
  public int getCount()
  {
    int j = 0;
    if (this.mData != null) {}
    for (int i = this.mData.size(); i == 0; i = 0) {
      return 1;
    }
    if (this.isOver) {}
    for (;;)
    {
      return i + j;
      j = 1;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mData == null) || (this.mData.size() == 0)) {
      return 0;
    }
    if (paramInt == this.mData.size()) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(this.mListView.getWidth(), this.mListView.getHeight()));
      paramView = this.mEmptyView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      Object localObject1;
      if (1 == i)
      {
        label171:
        SignatureManager.SigCommentInfo localSigCommentInfo;
        if (paramView == null)
        {
          paramView = this.mLayoutInflater.inflate(2131563113, this.mListView, false);
          localObject1 = new abgb.b();
          ((abgb.b)localObject1).wR = ((ImageView)paramView.findViewById(2131378392));
          ((abgb.b)localObject1).nickName = ((TextView)paramView.findViewById(2131378393));
          ((abgb.b)localObject1).xo = ((ImageView)paramView.findViewById(2131378390));
          ((abgb.b)localObject1).Py = ((TextView)paramView.findViewById(2131378391));
          ((abgb.b)localObject1).Pz = ((TextView)paramView.findViewById(2131378394));
          paramView.setTag(localObject1);
          localSigCommentInfo = a(paramInt);
          localObject2 = String.valueOf(localSigCommentInfo.uin);
          aqdj localaqdj = aqdj.a(this.mApp, 1, (String)localObject2);
          if (localaqdj != null) {
            ((abgb.b)localObject1).wR.setImageDrawable(localaqdj);
          }
          localObject2 = aqgv.D(this.mApp, (String)localObject2);
          ((abgb.b)localObject1).nickName.setText((CharSequence)localObject2);
          ((abgb.b)localObject1).xo.setBackgroundResource(2130851034);
          localObject2 = Calendar.getInstance();
          ((Calendar)localObject2).setTimeInMillis(localSigCommentInfo.time * 1000L);
          i = ((Calendar)localObject2).get(9);
          localObject2 = new SimpleDateFormat("hh:mm").format(new Date(localSigCommentInfo.time * 1000L));
          if (i != 0) {
            break label375;
          }
        }
        label375:
        for (Object localObject2 = acfp.m(2131714540) + (String)localObject2;; localObject2 = acfp.m(2131714537) + (String)localObject2)
        {
          ((abgb.b)localObject1).Py.setText((CharSequence)localObject2);
          c(localSigCommentInfo.feedsid, ((abgb.b)localObject1).Pz);
          break;
          localObject1 = (abgb.b)paramView.getTag();
          break label171;
        }
      }
      if (2 == i)
      {
        if (paramView == null)
        {
          paramView = this.mLayoutInflater.inflate(2131562250, this.mListView, false);
          paramView.setOnClickListener(this);
          localObject1 = new abgb.a();
          paramView.setTag(localObject1);
          paramView.findViewById(2131370781).setVisibility(8);
          ((abgb.a)localObject1).ny = ((TextView)paramView.findViewById(2131371975));
          this.AE = paramView;
        }
        for (;;)
        {
          paramView = this.AE;
          break;
          paramView = (abgb.a)paramView.getTag();
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onClick(View paramView)
  {
    if (this.AE == paramView)
    {
      MqqHandler localMqqHandler = this.mApp.getHandler(SigCommentListActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(0, 1, 0), 200L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setData(List<SignatureManager.SigCommentInfo> paramList, boolean paramBoolean)
  {
    if (paramList != this.mData) {
      this.mData = ((ArrayList)paramList);
    }
    this.isOver = paramBoolean;
  }
  
  public static class a
  {
    public TextView ny;
  }
  
  public static class b
  {
    public TextView Py;
    public TextView Pz;
    public TextView nickName;
    public ImageView wR;
    public ImageView xo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgb
 * JD-Core Version:    0.7.0.1
 */