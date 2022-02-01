import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.38.1;
import com.tencent.mobileqq.apollo.view.ApolloPanel.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class acau
  implements ApolloPanel.d
{
  public acau(ApolloPanel paramApolloPanel) {}
  
  public void Iv(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.this$0.mBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.this$0.mBaseChatPie.app.getCurrentUin(), 0).edit();
    if (paramInt < 0) {
      localEditor.remove("sp_key_apollo_current_page_index_3d");
    }
    for (;;)
    {
      localEditor.apply();
      return;
      localEditor.putString("sp_key_apollo_current_page_index_3d", String.valueOf(paramInt));
    }
  }
  
  public acbg a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new abzd(this.this$0.mBaseChatPie.mContext, this.this$0.mBaseChatPie.app, this.this$0.g);
    }
    if (abhh.ce("gamePanelSwitch") != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "loadPanel gameSwitch is 0 return null");
      }
      return null;
    }
    return new abzq(this.this$0.mBaseChatPie.mContext, this.this$0.mBaseChatPie.app, this.this$0.g, this.this$0.mBaseChatPie);
  }
  
  public void d(List<acbg> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    int i = 0;
    int m = 0;
    while (i < paramList.size())
    {
      m += ((acbg)paramList.get(i)).Ad();
      i += 1;
    }
    i = -1;
    Object localObject = this.this$0.mBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.this$0.mBaseChatPie.app.getCurrentUin(), 0);
    if (((SharedPreferences)localObject).contains("sp_key_apollo_current_page_index_3d"))
    {
      localObject = ((SharedPreferences)localObject).getString("sp_key_apollo_current_page_index_3d", null);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt((String)localObject);
        if (j >= m) {
          continue;
        }
      }
      catch (Exception localException1)
      {
        int k;
        int n;
        j = -1;
        i = 0;
        QLog.e("ApolloPanel", 1, "parse previousSavedPagerIndexStr error", localException1);
        continue;
        k += 1;
        continue;
        j = 0;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] from previous saved for 3d, pagerIndex=", Integer.valueOf(j) });
        }
        i = j;
        j = 1;
        k = j;
        j = i;
        i = k;
        if (i != 0) {
          continue;
        }
        n = paramList1.size();
        k = 0;
        if (k >= n) {
          continue;
        }
        localObject = (ApolloActionPackage)paramList1.get(k);
        if ((localObject == null) || (((ApolloActionPackage)localObject).packageId != 300)) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        i = 1;
        continue;
        k = i;
        i = j;
        j = k;
        continue;
        k = 0;
        continue;
      }
      if (k < paramList.size())
      {
        i = ApolloPanel.a(this.this$0, paramList, k);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] default single action, pagerIndex=", Integer.valueOf(i) });
        }
        j = 1;
        if (j == 0) {
          i = 1;
        }
        if (i < m)
        {
          ApolloPanel.cuh = i;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] sCurrentIndex= ", Integer.valueOf(ApolloPanel.cuh) });
          }
        }
        return;
      }
      i = 0;
      int j = -1;
    }
  }
  
  public boolean in(int paramInt)
  {
    return (paramInt >= 100) && (paramInt != 400);
  }
  
  public void updateView()
  {
    ApolloPanel.a(this.this$0).post(new ApolloPanel.38.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acau
 * JD-Core Version:    0.7.0.1
 */