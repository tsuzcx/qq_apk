import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SelectTouchBarView;
import com.tencent.widget.ListView;
import java.util.List;

public class wwu
  implements wvs
{
  private SelectTouchBarView a;
  private int bRS;
  private BaseChatPie c;
  private ListAdapter mListAdapter;
  private ListView n;
  private List<ChatMessage> rY;
  
  public wwu(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.n = this.c.b;
    this.mListAdapter = this.c.a;
    if (this.mListAdapter != null) {
      this.rY = this.c.a.getList();
    }
  }
  
  private boolean Sd()
  {
    int i = wk();
    int j = wl();
    int k = wj();
    if ((k < 0) || (i < 0) || (j < 0)) {}
    while (k < i) {
      return false;
    }
    return true;
  }
  
  private void ccJ()
  {
    if (this.c != null)
    {
      this.n = this.c.b;
      this.mListAdapter = this.c.a;
      if (this.mListAdapter != null) {
        this.rY = this.c.a.getList();
      }
    }
  }
  
  private void fF(int paramInt1, int paramInt2)
  {
    p(paramInt1, paramInt2, true);
  }
  
  private void ff(View paramView)
  {
    int i = 1;
    ccJ();
    if ((this.c == null) || (this.rY == null) || (this.n == null)) {}
    do
    {
      do
      {
        return;
        ccJ();
        this.bRS = this.rY.size();
        if (ajlc.a().getCheckedItemCount() == 0) {
          QQToast.a(paramView.getContext(), acfp.m(2131714246), 0).show();
        }
        j = wk();
        m = wl();
        k = wj();
      } while ((k < 0) || (j < 0) || (m < 0) || (k < j));
      int m = k + 1;
      int i1 = this.n.getCount() - 1;
      if ((m < this.n.getCount()) && (m <= i1)) {
        p(m, i1, false);
      }
      fF(j, k);
    } while ((this.c == null) || (this.c.sessionInfo == null));
    int j = ajlc.a().getCheckedItemCount();
    int k = Integer.valueOf(ChatActivityUtils.cs(this.c.sessionInfo.cZ)).intValue();
    if (k == 0) {}
    for (;;)
    {
      anot.a(this.c.getApp(), "dc00898", "", "", "0X800A510", "0X800A510", i, j, "", "", "", "");
      return;
      if (k == 1) {
        i = 3;
      } else if (k == 3) {
        i = 2;
      } else if (k == 2) {
        i = 4;
      } else {
        i = 5;
      }
    }
  }
  
  private boolean gu(int paramInt)
  {
    ccJ();
    if ((this.n == null) || (paramInt < 0) || (paramInt > this.n.getCount()) || (this.a == null)) {
      return false;
    }
    Object localObject = this.n.getChildAt(paramInt);
    int i = ((View)localObject).getTop();
    paramInt = i;
    if ((localObject instanceof BaseChatItemLayout)) {
      paramInt = ((BaseChatItemLayout)localObject).a.getTop() + i;
    }
    localObject = (RelativeLayout)this.a.findViewById(2131362508);
    i = this.a.getTop();
    return paramInt < ((RelativeLayout)localObject).getHeight() / 2 + i;
  }
  
  private void p(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = ajlc.a();
    int i = paramInt1;
    if (i <= paramInt2)
    {
      ChatMessage localChatMessage;
      if ((i >= 0) && (i < this.rY.size()))
      {
        localChatMessage = (ChatMessage)this.rY.get(i);
        if (((ajlc)localObject).O(localChatMessage) != paramBoolean) {
          break label69;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label69:
        if ((ajlg.R(localChatMessage)) && (this.c != null))
        {
          int j = ajlc.a().Gq();
          if ((paramBoolean) && (ajlc.a().c(localChatMessage, j)))
          {
            if (ajlc.a().djF == 7) {}
            for (localObject = this.c.mContext.getString(2131700611, new Object[] { Integer.valueOf(j) });; localObject = this.c.mContext.getString(2131700610, new Object[] { Integer.valueOf(j) }))
            {
              QQToast.a(this.c.mContext, (CharSequence)localObject, 0).show();
              return;
            }
          }
          ((ajlc)localObject).a(localChatMessage, paramBoolean);
          this.c.a(localChatMessage, null, paramBoolean);
          ((wki)this.mListAdapter).notifyDataSetChanged();
        }
      }
    }
    QLog.d("SelectToBottomHelper", 3, "item index: " + paramInt1 + " to " + paramInt2 + " Perform select");
  }
  
  private int wj()
  {
    ccJ();
    int k = -1;
    int m = this.n.getFirstVisiblePosition();
    int i = this.n.getChildCount() - 1;
    for (;;)
    {
      int j = k;
      if (i >= 0)
      {
        if (gu(i)) {
          j = i + m - 1;
        }
      }
      else
      {
        QLog.d("SelectToBottomHelper", 3, "Real last visible index is: " + j);
        return j;
      }
      i -= 1;
    }
  }
  
  private int wk()
  {
    ccJ();
    ajlc localajlc = ajlc.a();
    int i = 0;
    if (i < this.rY.size())
    {
      ChatMessage localChatMessage = (ChatMessage)this.rY.get(i);
      if ((!localajlc.O(localChatMessage)) || (!ajlg.R(localChatMessage))) {}
    }
    for (;;)
    {
      QLog.d("SelectToBottomHelper", 3, "First selected index is: " + i);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private int wl()
  {
    ccJ();
    ajlc localajlc = ajlc.a();
    int i = this.rY.size() - 1;
    if (i >= 0)
    {
      ChatMessage localChatMessage = (ChatMessage)this.rY.get(i);
      if ((!localajlc.O(localChatMessage)) || (!ajlg.R(localChatMessage))) {}
    }
    for (;;)
    {
      QLog.d("SelectToBottomHelper", 3, "Last selected index is: " + i);
      return i;
      i -= 1;
      break;
      i = -1;
    }
  }
  
  public int[] C()
  {
    return new int[] { 5, 16, 18 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("SelectToBottomHelper", 1, "onResume");
              }
            } while (this.a == null);
            this.a.eiT();
          } while (!QLog.isColorLevel());
          QLog.d("SelectToBottomHelper", 1, "onResume->updateDotLine");
          return;
          onScrollStateChanged(paramInt);
        } while (!QLog.isColorLevel());
        QLog.d("SelectToBottomHelper", 1, "onScrollStateIdle");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SelectToBottomHelper", 1, "onConfigurationChanged");
        }
      } while (this.a == null);
      this.a.eiT();
    } while (!QLog.isColorLevel());
    QLog.d("SelectToBottomHelper", 1, "onConfigurationChanged->updateDotLine");
  }
  
  public void a(LinearLayout paramLinearLayout, int paramInt, RelativeLayout paramRelativeLayout)
  {
    if ((this.a == null) && (this.c != null))
    {
      this.a = new SelectTouchBarView(this.c.mContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, paramInt);
      localLayoutParams.addRule(2, paramLinearLayout.getId());
      this.a.setLayoutParams(localLayoutParams);
      this.a.a(acfp.m(2131714245)).a(paramInt).a();
      paramRelativeLayout.addView(this.a);
      this.a.setId(2131362507);
      this.a.setOnClickListener(new wwv(this));
    }
  }
  
  public void ccH()
  {
    if (this.a != null) {
      this.a.setVisibility(8);
    }
  }
  
  public void ccI()
  {
    if (this.a != null) {
      this.a.setVisibility(0);
    }
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    ccJ();
    int i;
    int j;
    if (paramInt == 16)
    {
      i = wj();
      j = wk();
      if ((this.a != null) && (j >= 0)) {}
    }
    else
    {
      return;
    }
    paramInt = i;
    if (this.bRS != this.rY.size())
    {
      paramInt = i + (this.rY.size() - this.bRS);
      this.bRS = this.rY.size();
    }
    if (paramInt < j)
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
  }
  
  public void setCheckedNum(int paramInt)
  {
    if (this.a != null)
    {
      if ((paramInt != 0) && ((this.a.getMeasuredHeight() == 0) || (Sd()))) {
        break label46;
      }
      this.a.setVisibility(8);
    }
    for (;;)
    {
      this.a.setCheckedNum(paramInt);
      return;
      label46:
      this.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwu
 * JD-Core Version:    0.7.0.1
 */