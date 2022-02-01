import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkTextureView;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ahsm
  extends PagerAdapter
{
  public ahsm(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return QQGamePubAccountFragment.a(this.this$0).size() + 1;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    ahuh localahuh = null;
    if (paramInt < QQGamePubAccountFragment.a(this.this$0).size()) {}
    for (MessageRecord localMessageRecord = (MessageRecord)QQGamePubAccountFragment.a(this.this$0).get(paramInt);; localMessageRecord = null)
    {
      if (paramInt < this.this$0.mHeaderRecords.size()) {
        localahuh = (ahuh)this.this$0.mHeaderRecords.get(paramInt);
      }
      if (localahuh == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGamePubAccountFragment", 2, "headerView = null");
        }
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePubAccountFragment", 2, "headerView = " + localahuh.getClass().getSimpleName());
      }
      RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
      if (((View)localahuh).getParent() != null) {
        ((ViewGroup)((View)localahuh).getParent()).removeView((View)localahuh);
      }
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams3.addRule(13, ((View)localahuh).getId());
      TextView localTextView;
      RelativeLayout.LayoutParams localLayoutParams1;
      if (localMessageRecord != null)
      {
        localTextView = new TextView(this.this$0.getActivity());
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 10.0F);
        localTextView.setBackgroundColor(Color.parseColor("#4D000000"));
        localTextView.setText(aqmu.a(this.this$0.getActivity(), 3, localMessageRecord.time * 1000L));
        localTextView.setPadding(12, 0, 12, 0);
        localTextView.setId(2131379675);
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, wja.dp2px(15.0F, this.this$0.getResources()));
        }
        localTextView.setGravity(17);
        localLayoutParams1.addRule(14);
        localLayoutParams1.addRule(10);
        localTextView.bringToFront();
      }
      for (;;)
      {
        localRelativeLayout.addView((View)localahuh, localLayoutParams3);
        if ((localTextView != null) && (localLayoutParams1 != null)) {
          localRelativeLayout.addView(localTextView, localLayoutParams1);
        }
        paramViewGroup.addView(localRelativeLayout, localLayoutParams3);
        if (localMessageRecord != null)
        {
          localahuh.a(localMessageRecord, this.this$0.getActivity());
          if ((localMessageRecord instanceof MessageForArkApp))
          {
            paramViewGroup = (ArkTextureView)localahuh;
            ((View)localahuh).setOnTouchListener(new ahsn(this, paramViewGroup));
          }
          return localRelativeLayout;
        }
        return localRelativeLayout;
        localTextView = null;
        localLayoutParams1 = null;
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsm
 * JD-Core Version:    0.7.0.1
 */