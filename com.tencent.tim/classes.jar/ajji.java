import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ajji
  implements ajjz.a, ajjz.b, ajjz.c, View.OnClickListener
{
  private Long N;
  ajjz jdField_a_of_type_Ajjz;
  MultiCardFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment;
  public boolean coV;
  public Context mContext;
  private TextView mNickName;
  private View mRootView;
  private long mTroopUin;
  
  private void qt(boolean paramBoolean)
  {
    View localView;
    if (this.mRootView != null)
    {
      localView = this.mRootView.findViewById(2131380676);
      if (localView != null) {
        if (!paramBoolean) {
          break label33;
        }
      }
    }
    label33:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void E(HashMap<Long, IntimateInfo> paramHashMap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.a(null, paramHashMap, null);
    }
  }
  
  public void b(long paramLong, HashMap<Long, String> paramHashMap)
  {
    if ((this.mTroopUin != paramLong) || (paramHashMap == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.a(null, null, paramHashMap);
  }
  
  public void b(ArrayList<Long> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayList == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onPreLoadData : ");
          localStringBuilder.append(paramArrayList.size());
          localStringBuilder.append("  ");
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            localStringBuilder.append((Long)localIterator.next());
            localStringBuilder.append(" ");
          }
          QLog.d("MultiCardContainer", 2, "onPreLoadData : " + localStringBuilder.toString());
        }
      } while (this.jdField_a_of_type_Ajjz == null);
      if (paramBoolean1) {
        this.jdField_a_of_type_Ajjz.a(this.mContext, this.mTroopUin, paramArrayList, this);
      }
    } while (!paramBoolean2);
    this.jdField_a_of_type_Ajjz.a(this.mContext, this.mTroopUin, paramArrayList, this);
  }
  
  public void dxR()
  {
    yZ(false);
  }
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public void l(long paramLong, ArrayList<Long> paramArrayList)
  {
    if (this.mTroopUin != paramLong) {}
    do
    {
      return;
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        qt(true);
        setNickName(null);
        return;
      }
      qt(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment == null);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment.a(paramArrayList, null, null);
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.N != null) && (l - this.N.longValue() < 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.N = Long.valueOf(l);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363226: 
        yZ(true);
      }
    }
  }
  
  public void setNickName(String paramString)
  {
    if ((!this.coV) && (this.mNickName != null)) {
      this.mNickName.setText(null);
    }
  }
  
  public void yZ(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajji
 * JD-Core Version:    0.7.0.1
 */