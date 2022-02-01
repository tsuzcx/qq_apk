import android.content.res.Resources;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class zav
{
  private TextView Mp;
  private TextView Mq;
  private zax a;
  private int ccA;
  private int ccB;
  private QQAppInterface d;
  private RelativeLayout is;
  private RelativeLayout it;
  private RelativeLayout iu;
  private ViewGroup.LayoutParams j;
  private SingleLineTextView r;
  private SingleLineTextView s;
  private SingleLineTextView t;
  private ImageView uP;
  private RecyclerView w;
  
  public zav(RelativeLayout paramRelativeLayout, QQAppInterface paramQQAppInterface)
  {
    this.is = paramRelativeLayout;
    this.j = paramRelativeLayout.getLayoutParams();
    this.d = paramQQAppInterface;
    this.Mp = ((TextView)paramRelativeLayout.findViewById(2131380410));
    this.Mq = ((TextView)paramRelativeLayout.findViewById(2131372468));
    this.r = ((SingleLineTextView)paramRelativeLayout.findViewById(2131372344));
    this.uP = ((ImageView)paramRelativeLayout.findViewById(2131372345));
    this.it = ((RelativeLayout)paramRelativeLayout.findViewById(2131372338));
    this.iu = ((RelativeLayout)paramRelativeLayout.findViewById(2131372630));
    this.s = ((SingleLineTextView)paramRelativeLayout.findViewById(2131372384));
    this.t = ((SingleLineTextView)paramRelativeLayout.findViewById(2131377167));
    t(paramRelativeLayout);
    cnE();
    if (QLog.isColorLevel()) {
      QLog.d("CTNewFriendEntryController", 2, "CTNewFriendEntryController maxDisplayHeadCount = " + this.ccA);
    }
  }
  
  private void D(boolean paramBoolean, List<Object> paramList)
  {
    if ((paramList == null) || (paramList.size() < 0)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CTNewFriendEntryController", 2, "showMultiNewFriendUI doAnimate = " + paramBoolean + ",count = " + paramList.size());
      }
      this.it.setVisibility(0);
      this.w.setVisibility(0);
      this.iu.setVisibility(4);
      this.r.setVisibility(4);
      this.uP.setVisibility(4);
      this.j.height = aqnm.dpToPx(93.0F);
      this.is.requestLayout();
      ysf localysf = (ysf)this.d.getManager(34);
      if (!paramBoolean) {
        break;
      }
    } while (paramList.size() <= 0);
    this.a.aJ(paramList.get(0));
    return;
    this.a.eu(paramList);
  }
  
  private void aV(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ysf)this.d.getManager(34);
    StringBuilder localStringBuilder = new StringBuilder(32);
    if (paramInt == 0)
    {
      localObject = ((ysf)localObject).a();
      if ((localObject != null) && (((ytv)localObject).G(this.d)))
      {
        if (paramBoolean) {
          anot.a(this.d, "CliOper", "", "", "0X800707A", "0X800707A", 0, 0, "", "", "", "");
        }
        localStringBuilder.append(this.d.getApp().getResources().getString(2131696301)).append(" 有更新");
        i = 1;
        aute.updateCustomNoteTxt(this.Mq, i, paramInt, 0);
        this.Mp.setVisibility(4);
        this.Mq.setVisibility(0);
      }
    }
    while (paramInt <= 0) {
      for (;;)
      {
        int i;
        this.is.setContentDescription(localStringBuilder.toString());
        return;
        if (yqv.a(this.d).Uh())
        {
          int k = 1;
          i = k;
          if (QLog.isColorLevel())
          {
            QLog.d("NewFriendVerification.manager", 2, "contacts updateUnreadCount");
            i = k;
          }
        }
        else
        {
          localStringBuilder.append(this.d.getApp().getResources().getString(2131720778));
          i = 0;
        }
      }
    }
    if (paramBoolean) {
      anot.a(this.d, "CliOper", "", "", "0X800707B", "0X800707B", 0, 0, "", "", "", "");
    }
    localStringBuilder.append(this.d.getApp().getResources().getString(2131696301)).append(" ");
    if (paramInt > 99) {
      localStringBuilder.append("多于99条未读");
    }
    for (;;)
    {
      aute.updateCustomNoteTxt(this.Mp, 3, paramInt, 0);
      this.Mp.setVisibility(0);
      this.Mq.setVisibility(4);
      break;
      localStringBuilder.append(paramInt).append("条未读");
    }
  }
  
  private void cnE()
  {
    this.r.setVisibility(0);
    this.uP.setVisibility(0);
    this.it.setVisibility(4);
    this.iu.setVisibility(4);
    this.w.setVisibility(4);
    this.j.height = aqnm.dpToPx(56.0F);
    this.is.requestLayout();
  }
  
  private void gX(List<Object> paramList)
  {
    if ((paramList == null) || (paramList.size() < 0)) {
      return;
    }
    this.it.setVisibility(0);
    this.iu.setVisibility(0);
    this.r.setVisibility(4);
    this.uP.setVisibility(4);
    this.w.setVisibility(0);
    this.j.height = aqnm.dpToPx(93.0F);
    this.is.requestLayout();
    Object localObject1 = paramList.get(0);
    Object localObject2;
    if ((localObject1 instanceof ytq))
    {
      localObject2 = (ytq)localObject1;
      this.s.setText(((ytq)localObject2).getNickName());
      localObject1 = ((ytq)localObject2).pR();
      if (QLog.isColorLevel()) {
        QLog.d("CTNewFriendEntryController", 2, "showOneNewFriendUI nickname = " + ((ytq)localObject2).getNickName() + "reqContent = " + (String)localObject1);
      }
      this.t.setText((CharSequence)localObject1);
      localObject2 = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
      }
    }
    for (;;)
    {
      this.a.eu(paramList.subList(0, 1));
      return;
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, 0);
      continue;
      if ((localObject1 instanceof PhoneContact))
      {
        localObject1 = (PhoneContact)localObject1;
        this.s.setText(((PhoneContact)localObject1).name);
        localObject1 = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
      }
      else if ((localObject1 instanceof ytp))
      {
        localObject1 = (ytp)localObject1;
        this.s.setText(((ytp)localObject1).a.name);
        localObject1 = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10, 0);
      }
    }
  }
  
  private void t(RelativeLayout paramRelativeLayout)
  {
    this.w = ((RecyclerView)paramRelativeLayout.findViewById(2131372335));
    int k = aqnm.getScreenWidth();
    int i1 = aqnm.dpToPx(68.0F);
    int m = aqnm.dpToPx(48.0F);
    int n = aqnm.dpToPx(8.0F);
    int i = (k - i1 + n) / m;
    i1 = (k - i1 + n) % m;
    PaintDrawable localPaintDrawable;
    if (i1 > n)
    {
      k = i + 1;
      float f = (i1 - n) * 1.0F / (m - n);
      paramRelativeLayout = new zaw(this, f);
      localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory(paramRelativeLayout);
      paramRelativeLayout = localPaintDrawable;
      i = k;
      if (QLog.isColorLevel())
      {
        QLog.d("CTNewFriendEntryController", 2, "initHeadsRecyclerView count = " + k + ", ratio = " + f);
        i = k;
      }
    }
    for (paramRelativeLayout = localPaintDrawable;; paramRelativeLayout = null)
    {
      this.ccA = i;
      this.a = new zax(this.d, null, paramRelativeLayout, this.ccA);
      this.w.setAdapter(this.a);
      this.w.setLayoutFrozen(true);
      this.w.addItemDecoration(new zax.a(aqnm.dpToPx(8.0F)));
      paramRelativeLayout = new DefaultItemAnimator();
      paramRelativeLayout.setAddDuration(1000L);
      this.w.setItemAnimator(paramRelativeLayout);
      paramRelativeLayout = new LinearLayoutManager(this.d.getApp());
      paramRelativeLayout.setOrientation(0);
      this.w.setLayoutManager(paramRelativeLayout);
      return;
    }
  }
  
  public void j(List<Object> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if ((paramList == null) || (paramList.size() < 0)) {
      return;
    }
    int i = paramList.size();
    if (QLog.isColorLevel()) {
      QLog.d("CTNewFriendEntryController", 2, "updateRedDotCount count = " + i + ",doAnimate = " + paramBoolean1);
    }
    if (i == 0) {
      cnE();
    }
    for (;;)
    {
      this.ccB = i;
      aV(i, paramBoolean2);
      return;
      if (i != 1) {
        break;
      }
      gX(paramList);
    }
    if ((paramBoolean1) && (i - this.ccB == 1)) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      D(paramBoolean1, paramList);
      break;
    }
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTNewFriendEntryController", 2, "clearData");
    }
    this.d = paramQQAppInterface;
    this.w.getRecycledViewPool().clear();
    this.a.bp(paramQQAppInterface);
    this.a.eu(new ArrayList());
  }
  
  public void reportClick()
  {
    int i;
    if (this.ccB == 1) {
      i = 1;
    }
    for (;;)
    {
      anot.a(this.d, "dc00898", "", "", "0X8007F18", "0X8007F18", 1, 0, String.valueOf(i), "", "", "");
      return;
      if (this.ccB > 1) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zav
 * JD-Core Version:    0.7.0.1
 */