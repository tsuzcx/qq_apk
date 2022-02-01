import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import java.util.ArrayList;
import java.util.List;

public class acbb
  extends acbg
{
  public int ctN;
  public int ctO;
  
  public int Ad()
  {
    return 1;
  }
  
  public void ac(View paramView, int paramInt)
  {
    for (;;)
    {
      int j;
      int i;
      int k;
      try
      {
        Object localObject;
        ApolloLinearLayout.a locala;
        int i1;
        if (this.awS == 0)
        {
          int m = this.ctN;
          int n = this.ctO;
          j = 0;
          i = 0;
          if (j < this.ctO)
          {
            LinearLayout localLinearLayout = (LinearLayout)((ApolloLinearLayout)paramView).getChildAt(j);
            k = 0;
            if (k >= this.ctN) {
              break label266;
            }
            localObject = localLinearLayout.getChildAt(k);
            locala = (ApolloLinearLayout.a)((View)localObject).getTag();
            i1 = m * n * paramInt + i;
            List localList = this.xf;
            if (localList != null) {
              continue;
            }
          }
        }
        return;
        if (i1 < this.xf.size())
        {
          localObject = ((abzy)this.xf.get(i1)).c;
          locala.sk.setVisibility(0);
          locala.sk.setBackgroundDrawable(((abzy)this.xf.get(i1)).a(this.mContext, this.mContext.getResources().getDisplayMetrics().density));
          if ((localObject != null) && (((ApolloActionData)localObject).actionName != null)) {
            locala.name.setText(((ApolloActionData)localObject).actionName);
          }
          locala.d = ((abzy)this.xf.get(i1));
          locala.d.mBinderType = 1;
        }
        else
        {
          ((View)localObject).setContentDescription(null);
          ((View)localObject).setOnClickListener(null);
        }
      }
      finally {}
      label266:
      j += 1;
      continue;
      k += 1;
      i += 1;
    }
  }
  
  public View bQ()
  {
    switch (this.awS)
    {
    case 1: 
    default: 
      return new ApolloLinearLayout(this.mContext, null, this.mBinderType, this.ctN, this.ctO);
    case 0: 
      return new ApolloLinearLayout(this.mContext, null, this.mBinderType, this.ctN, this.ctO);
    }
    return LayoutInflater.from(this.mContext).inflate(2131558723, null);
  }
  
  public boolean h(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool;
    if (paramQQAppInterface == null) {
      bool = false;
    }
    Object localObject1;
    label50:
    int i;
    for (;;)
    {
      return bool;
      try
      {
        localObject1 = (abyu)paramQQAppInterface.getManager(154);
        if (localObject1 == null)
        {
          bool = false;
        }
        else
        {
          if (paramSessionInfo.cZ == 0) {}
          for (paramSessionInfo = ((abyu)localObject1).vC;; paramSessionInfo = ((abyu)localObject1).wT)
          {
            if (paramSessionInfo == null) {
              break label250;
            }
            if (paramSessionInfo.size() != 0) {
              break;
            }
            break label250;
            if ((paramSessionInfo.cZ != 1) && (paramSessionInfo.cZ != 3000)) {
              break label245;
            }
          }
          if (this.xf != null) {
            this.xf.clear();
          }
          for (;;)
          {
            i = paramSessionInfo.size() - 1;
            break;
            this.xf = new ArrayList();
          }
          localObject1 = new ApolloActionData();
        }
      }
      finally {}
    }
    label140:
    Object localObject2 = (abxk)paramQQAppInterface.getManager(155);
    if (localObject2 != null)
    {
      localObject2 = ((abxk)localObject2).a(((ApolloActionRecentData)paramSessionInfo.get(i)).actionId);
      localObject1 = localObject2;
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject2 = new acad(paramQQAppInterface.getCurrentUin());
      ((acad)localObject2).c = ((ApolloActionData)localObject1);
      ((acad)localObject2).mBinderType = 1;
      this.xf.add(localObject2);
      label275:
      for (;;)
      {
        bool = true;
        break;
        label245:
        paramSessionInfo = null;
        break label50;
        label250:
        bool = false;
        break;
        for (;;)
        {
          if (i < 0) {
            break label275;
          }
          if (paramQQAppInterface != null) {
            break label140;
          }
          bool = false;
          break;
          i -= 1;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.mContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbb
 * JD-Core Version:    0.7.0.1
 */