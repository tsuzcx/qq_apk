import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;

public class aakf
  extends aakb
{
  protected String bdm;
  private WeakReference<abex> eT;
  View.OnTouchListener j = new aakg(this);
  
  aakf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentMayKnowFriendItemBuilder", 0, "RecentMayKnowFriendItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    paramOnLongClickListener = null;
    paramViewGroup = paramOnLongClickListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnLongClickListener;
      if ((paramView.getTag() instanceof aakf.a)) {
        paramViewGroup = (aakf.a)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = (RecentItemMayKnowFriendData)paramObject;
      paramView = new aakf.a();
      paramView.curUin = paramViewGroup.curUin;
      paramViewGroup = a(paramContext, 2131559114, paramView);
      paramView.Ob = ((TextView)paramViewGroup.findViewById(2131376924));
      paramView.Ob.setOnClickListener(paramOnClickListener);
      paramView.Ob.setOnTouchListener(this.j);
      paramView.o = ((HorizontalListView)paramViewGroup.findViewById(2131371197));
      paramView.o.setDividerWidth(wja.dp2px(9.0F, paramContext.getResources()));
      paramOnLongClickListener = new abex((Activity)paramContext, paramaajx.getAppInterface(), paramView.o, null, 25, 0);
      if (this.eT != null)
      {
        paramc = (abex)this.eT.get();
        if (paramc != null) {
          paramc.destroy();
        }
      }
      this.eT = new WeakReference(paramOnLongClickListener);
      paramView.o.setAdapter(paramOnLongClickListener);
      paramViewGroup.setTag(paramView);
      paramOnLongClickListener = paramView;
      paramView = paramViewGroup;
      this.bdm = ThemeUtil.curThemeId;
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(null);
      }
      if ((paramOnLongClickListener == null) || (!(paramObject instanceof RecentBaseData))) {
        break label379;
      }
      a(paramView, (RecentBaseData)paramObject, paramContext, paramaajx.getAppInterface());
    }
    for (;;)
    {
      a(paramContext, paramView, paramInt, paramObject, paramOnLongClickListener, paramOnClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      paramOnLongClickListener.Ob.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      if ((!TextUtils.equals(this.bdm, ThemeUtil.curThemeId)) && (this.eT != null))
      {
        paramOnLongClickListener = (abex)this.eT.get();
        if (paramOnLongClickListener != null) {
          paramOnLongClickListener.notifyDataSetChanged();
        }
      }
      paramOnLongClickListener = paramViewGroup;
      break;
      label379:
      if (paramOnLongClickListener == null) {}
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("RecentMayKnowFriendItemBuilder", 0, "updateView|param invalidate");
      }
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof aakf.a)) {}
    for (paramView = (aakf.a)localObject;; paramView = null)
    {
      if (paramView == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("RecentMayKnowFriendItemBuilder", 0, "updateView|holder is null, tag = " + localObject);
        return;
      }
      if (!(paramRecentBaseData instanceof RecentItemMayKnowFriendData)) {
        break;
      }
      paramRecentBaseData = (RecentItemMayKnowFriendData)paramRecentBaseData;
      if (QLog.isColorLevel()) {
        QLog.i("RecentMayKnowFriendItemBuilder", 0, "updateView");
      }
      if ((TextUtils.isEmpty(paramRecentBaseData.curUin)) || (paramRecentBaseData.curUin.equals(paramView.curUin))) {
        break;
      }
      paramContext = new abex((Activity)paramContext, paramQQAppInterface, paramView.o, null, 25, 0);
      if (this.eT != null)
      {
        paramQQAppInterface = (abex)this.eT.get();
        if (paramQQAppInterface != null) {
          paramQQAppInterface.destroy();
        }
      }
      this.eT = new WeakReference(paramContext);
      paramView.o.setAdapter(paramContext);
      paramView.curUin = paramRecentBaseData.curUin;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("RecentMayKnowFriendItemBuilder", 0, "updateView1");
      return;
    }
  }
  
  public void destroy()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("destroy : ");
      if ((this.eT == null) || (this.eT.get() == null)) {
        break label84;
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("RecentMayKnowFriendItemBuilder", 0, bool);
      if (this.eT != null)
      {
        localObject = (abex)this.eT.get();
        if (localObject != null) {
          ((abex)localObject).destroy();
        }
        this.eT = null;
      }
      return;
    }
  }
  
  public static class a
    extends aakb.a
  {
    public TextView Ob;
    public String curUin;
    public HorizontalListView o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aakf
 * JD-Core Version:    0.7.0.1
 */